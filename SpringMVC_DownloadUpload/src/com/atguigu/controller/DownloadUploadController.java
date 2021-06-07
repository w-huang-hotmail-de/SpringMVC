package com.atguigu.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/DownloadUploadController")
public class DownloadUploadController {	
	
	/**
	 * Download a file from server and save it locally.
	 * @param fileName - file name sent from client
	 * @param session - object of type HttpSession to get the path of ServletContext
	 * @return an object of type ResponseEntity<byte[]> sent to client, with which the client can download and save the file locally.
	 */
	@RequestMapping(value="/downloadAndSave/{fileName}")	//no setting of RequestMethod means that all RequestMethods are suitable
	public ResponseEntity<byte[]> download(@PathVariable(name="fileName")String fileName, HttpSession session) {
		ResponseEntity<byte[]> respEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		//get the path of the downloaded file in the server
		String imgDirectory = session.getServletContext().getRealPath("img");
		String filePath = imgDirectory + File.separator + fileName + ".jpg";
		
		//read the file 
		try(InputStream is = new FileInputStream(filePath))
		{
			byte[] body = new byte[is.available()];
			is.read(body);
			MultiValueMap<String, String> headers = new HttpHeaders();
			headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=1.jpg");	//set response header for downloading file as an attachment and saving locally. The filename must be set, otherwise the downloaded file has default extension .htm.
			respEntity = new ResponseEntity<byte[]>(body, headers, HttpStatus.OK);	//create repEntity for client
		}catch(IOException ex) {
			ex.printStackTrace();
		}
		
		return respEntity;
	}
	
	
	/**
	 * Download a file from server and display it in browser.
	 * @param fileName - file name sent from client
	 * @param session - object of type HttpSession to get the path of ServletContext
	 * @return an object of type ResponseEntity<byte[]> sent to the client, with which the client can download and display the file in browser.
	 */
	@RequestMapping(value="/downloadAndShow/{filename}")
	public ResponseEntity<byte[]> downloadAndShow(@PathVariable(name="filename")String filename, HttpSession session){
//	public ResponseEntity<byte[]> downloadAndShow(@PathVariable(name="filename")String filename, HttpSession session, HttpServletResponse resp){
		ResponseEntity<byte[]> respEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		//get the path of downloaded file in the server
		String imgDirectory = session.getServletContext().getRealPath("img");
		String filePath = imgDirectory + File.separator + filename + ".jpg";
		
		//read the file
		try(InputStream is = new FileInputStream(filePath))
//		try(InputStream is = new FileInputStream(filePath); OutputStream os= resp.getOutputStream())	//If HttpServletResponse is used at the same time, the ResponseEntity dose not work because httpServletResoponse occupies the outputStream von Response when the getPutputStream() emthod is called, and ResponseEntity cannot write the data in response. In this case, you can only write data into response through HttpServletResponse or delete HttpServletResponse. 
		{
			byte[] body = new byte[is.available()];
			is.read(body);
//			os.write(body);	//in the case of using HttpServletResponse
//			os.flush();
			MultiValueMap<String, String> headers = new HttpHeaders();	//The content-disposition is not set as attachment, and then has the default value inline, and the browser dislay the content within the page.
			headers.add(HttpHeaders.CONTENT_TYPE, "image/jpg");	//content-type must be set, then the browser know that it is an image and can display it correctly
			respEntity = new ResponseEntity<byte[]>(body, headers, HttpStatus.OK);
		}catch(IOException e) {
			e.printStackTrace();
		}
		return respEntity;
	}
}



