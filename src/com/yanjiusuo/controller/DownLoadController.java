package com.yanjiusuo.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.yanjiusuo.util.FileUtil;

@Controller
public class DownLoadController extends MultiActionController {
    private final static Log logger = LogFactory.getLog(LoginController.class);


    /**
     * 实现文件下载功能
     * @param request
     * @param response
     * @return
     * @throws Exception
     * @throws IOException
     */
    public ModelAndView DownloadFile(HttpServletRequest request,
            HttpServletResponse response) throws Exception,IOException
    {
		String filename=new String(request.getParameter("filename").getBytes("ISO-8859-1"),"UTF-8");
        response.setContentType(getServletContext().getMimeType(filename));  
        response.setHeader("contentType", "text/html; charset=utf-8");
        response.setHeader("Content-Disposition","attachment;filename="+new String(filename.getBytes("gb2312"),"ISO8859-1"));  
		String dir=request.getParameter("dir");
    	String fullFileName = request.getSession().getServletContext().getRealPath("/files/"+dir+"/save/"+filename);

        InputStream in = new FileInputStream(fullFileName);  
        OutputStream out = response.getOutputStream();
        
        //写文件  
        int b;
        try {
        	while((b=in.read())!= -1)  
            {  
                out.write(b);
            }  
            in.close();  
            out.close(); 
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
         
		return null;
    }
    

    /**
     * 实现设置为在线课件功能
     * @param request
     * @param response
     * @return
     * @throws Exception
     * @throws IOException
     */
    public ModelAndView TransferFile(HttpServletRequest request,
            HttpServletResponse response) throws Exception,IOException
    {
    	String path = request.getContextPath();
    	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		String filename=new String(request.getParameter("filename").getBytes("ISO-8859-1"),"UTF-8");
		String dir=request.getParameter("dir");
		String category=request.getParameter("category");
        response.setContentType(getServletContext().getMimeType(filename));
        
        String inputFilePath = request.getSession().getServletContext().getRealPath("/files/"+dir+"/save/"+filename);
        String OutputFilePath = request.getSession().getServletContext().getRealPath("/files/"+dir+"/"+category+"/"+filename);
        
        FileUtil.copy(inputFilePath, OutputFilePath);
        
        response.sendRedirect(basePath+"/upload/"+dir+".jsp");
		return null;
    }
    
    /**
     * 实现文件删除功能
     * @param request
     * @param response
     * @return
     * @throws Exception
     * @throws IOException
     */
    public ModelAndView DelFile(HttpServletRequest request,
            HttpServletResponse response) throws Exception,IOException
    {
    	String path = request.getContextPath();
    	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		String filename=request.getParameter("filename");
		String dir=request.getParameter("dir");
		String category=request.getParameter("category");
		
        response.setContentType(getServletContext().getMimeType(filename));
        String sPath = request.getSession().getServletContext().getRealPath("/files/"+dir+"/"+category+"/"+filename);
        
        FileUtil.deleteFile(sPath);       
        response.sendRedirect(basePath+"/upload/"+dir+".jsp");
		return null;
    }
}