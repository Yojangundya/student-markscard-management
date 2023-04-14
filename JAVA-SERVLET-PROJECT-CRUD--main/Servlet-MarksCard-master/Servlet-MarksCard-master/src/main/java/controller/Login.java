package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDao;
import dao.TeacherDao;
import dto.Student;
import dto.Teacher;

@WebServlet("/login")
public class Login extends HttpServlet
{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String emph=req.getParameter("emph");
	String password=req.getParameter("password");
	
	StudentDao dao1=new StudentDao();
	TeacherDao dao2=new TeacherDao();
	
	try {
	long mobile=Long.parseLong(emph);
	Teacher teacher=dao2.findTeacher(mobile);
	Student student=dao1.findStudent(mobile);
	if(teacher==null)
	{
		if(student==null)
		{
			resp.getWriter().print("<h1>Enter proper Email Id</h1>");
			req.getRequestDispatcher("login.html").include(req, resp);
		}
		else {
			if(student.getPassword().equals(password))
			{
				resp.getWriter().print("<h1>Login Success</h1>");
				req.getRequestDispatcher("studenthome.html").include(req, resp);
			}
			else {
				resp.getWriter().print("<h1>Enter proper Password</h1>");
				req.getRequestDispatcher("login.html").include(req, resp);
			}
		}
	}
	else {
		if(teacher.getPassword().equals(password))
		{
			resp.getWriter().print("<h1>Login Success</h1>");
			req.getRequestDispatcher("teacherhome.html").include(req, resp);
		}
		else {
			resp.getWriter().print("<h1>Enter proper Password</h1>");
			req.getRequestDispatcher("login.html").include(req, resp);
		}
	}
	}
	catch (NumberFormatException e) {

		Teacher teacher = dao2.findTeacher(emph);
		Student student=dao1.findStudent(emph);
		if(teacher==null)
		{
			if(student==null)
			{
				resp.getWriter().print("<h1>Enter proper Email Id</h1>");
				req.getRequestDispatcher("login.html").include(req, resp);
			}
			else {
				if(student.getPassword().equals(password))
				{
					resp.getWriter().print("<h1>Login Success</h1>");
					req.getRequestDispatcher("studenthome.html").include(req, resp);
				}
				else {
					resp.getWriter().print("<h1>Enter proper Password</h1>");
					req.getRequestDispatcher("login.html").include(req, resp);
				}
			}
		}
		else {
			if(teacher.getPassword().equals(password))
			{
				resp.getWriter().print("<h1>Login Success</h1>");
				req.getRequestDispatcher("teacherhome.html").include(req, resp);
			}
			else {
				resp.getWriter().print("<h1>Enter proper Password</h1>");
				req.getRequestDispatcher("login.html").include(req, resp);
			}
		}
		
	}
	
}
}
