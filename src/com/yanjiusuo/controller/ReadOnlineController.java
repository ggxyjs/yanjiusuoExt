package com.yanjiusuo.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.yanjiusuo.util.FileUtil;
import com.yanjiusuo.util.Office2Swf;

/**
 * @author HXF
 *
 */
@Controller
public class ReadOnlineController extends MultiActionController {
    private final static Log logger = LogFactory.getLog(LoginController.class);
    
	
    /**
     * @param request
     * @param response
     * @return
     * @throws Exception
     * @throws IOException
     */
    public ModelAndView ReadOnline(HttpServletRequest request,
            HttpServletResponse response) throws Exception,IOException
    {
    	String path = request.getContextPath();
    	String dir=request.getParameter("dir");
    	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    	String filename=new String(request.getParameter("filename").getBytes("ISO-8859-1"),"UTF-8");
    	String inputFilePath = request.getSession().getServletContext().getRealPath("/files/"+dir+"/save/"+filename);
		long filetime = new File(inputFilePath).lastModified();
    	String outFilePath = inputFilePath.replace("save\\"+filename, "convert\\"+filetime+ ".swf");
		logger.warn(inputFilePath);
		File outfile =new File(outFilePath);
		String outname = outfile.getName();
		String prefix= FileUtil.getPostfix(inputFilePath);
		
		request.getSession().setAttribute("fileName", outname);
		request.getSession().setAttribute("dir", dir);
		
		if (prefix.equals("pdf")) {
			if (!outfile.exists()) {
				Office2Swf.pdf2Swf(inputFilePath, outFilePath);
				response.sendRedirect(basePath+"home/readonline.jsp");
			}else {
				response.sendRedirect(basePath+"home/readonline.jsp");
			}
		}else {
			if (!outfile.exists()) {
				outFilePath = Office2Swf.office2Swf(inputFilePath, outFilePath);
				response.sendRedirect(basePath+"home/readonline.jsp");
			}else {
				response.sendRedirect(basePath+"home/readonline.jsp");
			}
		}
		return null;
    }
}	
