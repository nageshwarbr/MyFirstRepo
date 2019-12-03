package com.manthan.resume.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manthan.resume.bean.ResumeBean;
@WebServlet("/download")
public class DownloadServlet extends HttpServlet{
	List<ResumeBean> ls=(ArrayList)reques.getAttribute("ls");
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String file = "";
		String path = "D:\\files";
		response.setContentType("APPLICATION/OCTET-STREAM");
		response.setHeader("Content-Disposition", "attachment; filename=\"");
 
		FileInputStream fileInputStream = new FileInputStream(path
				+ file);
 
		int i;
		while ((i = fileInputStream.read()) != -1) {
			out.write(i);
		}
		fileInputStream.close();
		out.close();
	}
//	req.getRequestDispatcher("/Search").forward(req, resp);
}
