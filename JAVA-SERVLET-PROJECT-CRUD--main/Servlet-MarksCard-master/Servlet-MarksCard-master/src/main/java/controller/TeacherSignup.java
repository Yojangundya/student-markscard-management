package controller;

import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.exception.ConstraintViolationException;

import dao.TeacherDao;
import dto.Teacher;

@WebServlet("/teacherSignup")
public class TeacherSignup extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Teacher teacher = new Teacher();
		teacher.setEmail(req.getParameter("email"));
		teacher.setEmpid(req.getParameter("eid"));
		teacher.setMobile(Long.parseLong(req.getParameter("phone")));
		teacher.setName(req.getParameter("name"));
		teacher.setPassword(req.getParameter("password"));
		teacher.setSubject(req.getParameter("sub"));

		TeacherDao dao=new TeacherDao();
		try {
		dao.saveTeacher(teacher);
		resp.getWriter().print("<h1>Account Created Successully</h1>");
		req.getRequestDispatcher("login.html").include(req, resp);
		
		}
		catch(Exception e)
		{
			resp.getWriter().print("<h1>Email / Phone Number Exists</h1>");
			req.getRequestDispatcher("teacherSignup.html").include(req, resp);
		}
	}
}
