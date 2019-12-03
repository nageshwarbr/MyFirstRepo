package com.manthan.resume.test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manthan.resume.bean.ResumeBean;
@WebServlet("/searchResume")
public class SearchImpl extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<ResumeBean> ls = new ArrayList<ResumeBean>();
		String keyword = req.getParameter("keyword").toLowerCase();
		File folder = new File("D:\\files");
		File[] listOfFiles = folder.listFiles();
		PdfReader pdf=new PdfReader();
       ResumeBean bean=null;
		for (File file : listOfFiles) {
			System.out.println(file);
			 bean=pdf.pdfReader(file, keyword);
			
			if (bean.getFileName() != null && bean.getName() != null && bean.getEmail() != null ) {
				
				ls.add(bean);
			}
		}
			if (ls.isEmpty()) {
				req.setAttribute("msg", "No records found");
			} else {
				req.setAttribute("ls", ls);
			}
			req.getRequestDispatcher("/Search").forward(req, resp);

		

	}
}
