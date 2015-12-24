package com.yanjiusuo.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileUtil {

	/**
	 * 获取文件后缀名
	 * @param inputFilePath
	 * @return
	 */
	public static String getPostfix(String inputFilePath) 
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
	
	/**
	 * 文件时间格式处理
	 * @param time
	 * @return
	 */
	public static String getTime(Long time){
		Date d = new Date(time);
		Format simpleFormat = new SimpleDateFormat("E dd MMM yyyy hh:mm:ss a");
		String date = simpleFormat.format(d);
		return date;
	}
	
	/**
	 * 文件路径复制
	 * @param inputFilePath
	 * @param OutputFilePath
	 */
	public static void copy(String inputFilePath, String OutputFilePath) {   
        try {   
             InputStream in = new FileInputStream(inputFilePath);   
             OutputStream out = new FileOutputStream(OutputFilePath);   
   
            byte[] buff = new byte[1024];   
            int len = 0;   
            while ((len = in.read(buff)) != -1) {   
                 out.write(buff, 0, len);   
             }   
             in.close();   
             out.close();   
         } catch (FileNotFoundException e) {   
             e.printStackTrace();   
         } catch (IOException e) {   
             e.printStackTrace();   
         }   
     }
	
    /**
     * 删除单个文件
     * @param   sPath    被删除文件的文件名
     * @return 单个文件删除成功返回true，否则返回false
     */
    public static boolean deleteFile(String sPath) {
        boolean flag = false;
        File file = new File(sPath);
        // 路径为文件且不为空则进行删除
        if (file.isFile() && file.exists()) {
            file.delete();
            flag = true;
        }
        return flag;
    }
}
