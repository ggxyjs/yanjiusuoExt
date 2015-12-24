package com.yanjiusuo.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.yanjiusuo.util.FileUtil;
import com.yanjiusuo.util.JsonUtil;


@Controller
public class UploadController extends MultiActionController {
	
    private final static Log logger = LogFactory.getLog(UploadController.class);
	public static final int PAGE_NUM = 10;
	

    /**
     * 将文件上传到某个路径
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ModelAndView UploadFile(HttpServletRequest request,
            HttpServletResponse response) throws Exception
    {
        response.setContentType("application/json;charset=utf-8");
        PrintWriter pw = response.getWriter();
        String path = request.getContextPath();
    	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    	String data="";
    	String dir=request.getParameter("dir");
    	
    	String savePath = request.getSession().getServletContext().getRealPath("/files/"+dir+"/save");
		File saveDir = new File(savePath);
    	    
	    if(!saveDir.isDirectory()){
	        saveDir.mkdir();
	    }
    	    	
		try{
	        if(ServletFileUpload.isMultipartContent(request))
	        {
	          DiskFileItemFactory dff = new DiskFileItemFactory();
	          dff.setSizeThreshold(104857600);
	          ServletFileUpload sfu = new ServletFileUpload(dff);
	          sfu.setFileSizeMax(104857600);
	          sfu.setSizeMax(314572800);
	          
	          FileItemIterator fii = sfu.getItemIterator(request);
	          
	          while(fii.hasNext())
	          {
	            FileItemStream fis = fii.next();
	            if(!fis.isFormField() && fis.getName().length()>0)
	            {

	                String fileName = "//"+fis.getName();
	                BufferedInputStream in = new BufferedInputStream(fis.openStream());
	                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(new File(saveDir+fileName)));
	                Streams.copy(in, out, true);
	            }
	          }
	          data = "Success Upload";
	          pw.println("{\"data\":\"" + data + "\"}");
	          
	          response.sendRedirect(basePath+"/upload/"+dir+".jsp");
            }     
		}catch(Exception e){
			e.printStackTrace();
			data = "Fail Upload";
	        pw.println("{\"data\":\"" + data + "\"}"); 
	        logger.error(e.getMessage());
		}
		return null;
    }
    

    /**
     * 文件搜索功能
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ModelAndView SearchFile(HttpServletRequest request,
            HttpServletResponse response) throws Exception
    {
        response.setContentType("application/json;charset=utf-8");
        
        String filename=request.getParameter("filename");
        PrintWriter pw = response.getWriter();
		String jsonData = null;
		
		String dir=request.getParameter("dir");
	    String savePath = request.getSession().getServletContext().getRealPath("/files/"+dir+"/save");
    	File file=new File(savePath);
		int pageNum = Integer.parseInt(request.getParameter("page"));
    	File[] tempList = file.listFiles();
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
    	for (int i = 0; i < tempList.length; i++) {
    		HashMap<String, Object> map = new HashMap<String, Object>();
    		if ((tempList[i].getName()).contains(filename)) {
    			map.put("filename", tempList[i].getName());
    			map.put("size", tempList[i].length()/1024+"KB");
    			map.put("modify",FileUtil.getTime(tempList[i].lastModified()));
    			map.put("path", savePath+"\\"+ tempList[i].getName());
    			list.add(map);
    	    }
    	} 
    	int count=list.size();
		jsonData = JsonUtil.getJSONString(list);
	    pw.println("{\"jsonData\":" + jsonData  + ",\"total\":\"" + count + "\","
				+ "\"pageSize\":\"" + PAGE_NUM + "\"," + "\"pageNo\":\"" + pageNum + "\"}");
	    return null;
    }

    /**
     * 展示目标路径的文件
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ModelAndView ShowFile(HttpServletRequest request,
            HttpServletResponse response) throws Exception
    {
        response.setContentType("application/json;charset=utf-8");
        
        PrintWriter pw = response.getWriter();
		String jsonData = null;
		
		String dir=request.getParameter("dir");
		String category=request.getParameter("category");
	    String savePath = request.getSession().getServletContext().getRealPath("/files/"+dir+"/"+category);
	    
    	File file=new File(savePath);
		int pageNum = Integer.parseInt(request.getParameter("page"));
    	File[] tempList = file.listFiles();
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
    	int count=tempList.length;
    	
    	for (int i = 0; i < tempList.length; i++) {
    		HashMap<String, Object> map = new HashMap<String, Object>();
    		if (tempList[i].isFile()) {
    			map.put("filename", tempList[i].getName());
    			map.put("size", tempList[i].length()/1024+"KB");
    			long time = tempList[i].lastModified();
    			Date d = new Date(time);
    			Format simpleFormat = new SimpleDateFormat("E dd MMM yyyy hh:mm:ss a");
    			String dateString = simpleFormat.format(d);
    			map.put("modify",dateString);
    			map.put("path", savePath+"\\"+ tempList[i].getName());
    			list.add(map);
    	    }
    	    if (tempList[i].isDirectory()) {
    		   pw.println("{\"data\":\"" + jsonData + "\"}");    	   
    	    }
    	} 
		jsonData = JsonUtil.getJSONString(list);
	    pw.println("{\"jsonData\":" + jsonData  + ",\"total\":\"" + count + "\","
				+ "\"pageSize\":\"" + PAGE_NUM + "\"," + "\"pageNo\":\"" + pageNum + "\"}");
	    return null;
    }
    

    /**
     * 图形化展示
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ModelAndView ShowImgFile(HttpServletRequest request,
            HttpServletResponse response) throws Exception
    {
        response.setContentType("application/json;charset=utf-8");
        String dir=request.getParameter("dir");
        PrintWriter pw = response.getWriter();
		String jsonData = null;
	    String savePath = request.getSession().getServletContext().getRealPath("/files/"+dir+"/class");
    	File file=new File(savePath);
    	File[] tempList = file.listFiles();
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
    	
    	for (int i = 0; i < tempList.length; i++) {
    		HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("filefix", FileUtil.getPostfix((tempList[i].getName())));
			map.put("filename", tempList[i].getName());
			list.add(map);
    	} 
		jsonData = JsonUtil.getJSONString(list);
	    pw.println("{\"jsonData\":" + jsonData   + "}");
	    return null;
    }
}