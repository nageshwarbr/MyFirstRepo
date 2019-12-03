package com.manthan.resume.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import com.manthan.resume.bean.ResumeBean;

public class PdfReader {
	public ResumeBean pdfReader(File file, String keyword) throws IOException {
		ResumeBean resumeBean = new ResumeBean();
		// Loading an existing document
		// File file = new File("C:\\Users\\User\\Downloads\\TestYantra - ELF -
		// Servlets.pdf");
		PDDocument document = PDDocument.load(file);

		// Instantiate PDFTextStripper class
		PDFTextStripper pdfStripper = new PDFTextStripper();
      
		// Retrieving text from PDF document
		String text = pdfStripper.getText(document);
		
		String newText=text.replaceAll("\n", " ").replaceAll("\r", " ").toLowerCase();
		
//		while (matcher.find()) {
//			email = matcher.group();
//		}
//		
		 
		
//		if (newText.indexOf(keyword) > 0) {
//			String[] arr=newText.split(" ");
//			
//	         for(String s:arr) {
//			if(s.contains("@")) {
//			email=s;
//	         }
//	         resumeBean.setName(file.getName());
//				resumeBean.setFileName(file.getName());
//				resumeBean.setEmail(s);
//		}}
		 
		if(newText.contains(keyword)) {
			String email=null;
		String[] arr=newText.split(" ");
		for(String s:arr) {
//			Pattern pattern = Pattern.matches("^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$", s);
//			
//			if(pattern.) {
//				email=m.group();
//			}
		

       

        String patternString1 ="^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$";

        Pattern pattern = Pattern.compile(patternString1);
        Matcher matcher = pattern.matcher(s);

        while(matcher.find()) {
            email= matcher.group();
        }
		
		resumeBean.setName(file.getName());
		resumeBean.setFileName(file.getName());
		resumeBean.setEmail(email);
		}
		}
		// Closing the document
		document.close();
		return resumeBean;
	
}
}
