package com.yanjiusuo.util;

import java.util.regex.Pattern;

/**
 * 
 * @author hwl_sz
 *
 * @desc 需要swftools第三插件的支持 ,支持window\linux\mac等系统
 */
public class Office2Swf 
{
	/**
	 * 根据操作系统的名称，获取执行pdf->swf文件的命令 
	 * @param pdfFile 转换的pdf源文件路径
	 * @param swfOutFilePath 输出的swf文件路径
	 * @return
	 */
	private static String getCommand(String pdfFile, String swfOutFilePath)
	{
		String command = null;
		String osName = System.getProperty("os.name");
		if (null == swfOutFilePath || "".equals(swfOutFilePath.trim()))
		{
			swfOutFilePath = pdfFile.toLowerCase().replaceAll(".pdf", ".swf");
		}
		
		if (Pattern.matches("Linux.*", osName)) 
		{
			command = "pdf2swf -f " + pdfFile + " " + swfOutFilePath;
		} 
		else if (Pattern.matches("Windows.*", osName)) 
		{
			command = "D:/Workplaces/Swftool/pdf2swf.exe -t " + pdfFile + " -o "  + swfOutFilePath + " -T 9";
		} 
		else if (Pattern.matches("Mac.*", osName)) 
		{
		}
		return command;
	}
	
	/**
	 * 将pdf转换swf文件，在线预览
	 * @param pdfInputFilePath 待转换的pdf源文件路径
	 * @param swfOutFilePath  输出的swf目标文件路径，如果未指定(null)，则按在源文件当前目录生成同名的swf文件
	 * @return swf目标文件路径
	 */
	public static String pdf2Swf(String pdfInputFilePath, String swfOutFilePath)
	{
		String command = getCommand(pdfInputFilePath, swfOutFilePath);
		try
		{
			Process pro = Runtime.getRuntime().exec(command); 
			pro.waitFor();
			return pdfInputFilePath.replaceAll("." + getPostfix(pdfInputFilePath), ".swf");
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 将office文件直接转换为swf文件
	 * @param inputFilePath 待转换的源office文件路径
	 * @param outputSwfPath 输出的swf目标文件路径，如果未指定(null)，则按在源文件当前目录生成同名的swf文件
	 * @return swf目标文件路径
	 */
	public static String office2Swf(String inputFilePath, String outputSwfPath)
	{
		String outputPdfPath = null;
		if (null == outputSwfPath || "".equals(outputSwfPath.trim()))
		{
			outputPdfPath = inputFilePath.replace("." + getPostfix(inputFilePath), ".pdf");
		}
		else
		{
			outputPdfPath = outputSwfPath.replace("." + getPostfix(outputSwfPath), ".pdf");
		}
		
		boolean isSucc = Office2PDF.openOffice2Pdf(inputFilePath, outputPdfPath);
		if (isSucc)
		{
			outputSwfPath = pdf2Swf(outputPdfPath, outputSwfPath);
		}
		return outputSwfPath;
	}
	
	/**
	 * 获取文件的后缀名
	 */
	private static String getPostfix(String inputFilePath) 
	{
		String postfix = null;
		if (null != inputFilePath && !"".equals(inputFilePath.trim()))
		{
			int idx = inputFilePath.lastIndexOf(".");
			if (idx > 0)
			{
				postfix = inputFilePath.substring(idx + 1, inputFilePath.trim().length());
			}
		}
		return postfix;
	}
}
