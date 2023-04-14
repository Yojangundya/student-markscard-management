package controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDao;
import dto.Student;

@WebServlet("/studentSignup")
public class StudentSignup extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Student student = new Student();
		student.setEmail(req.getParameter("email"));
		student.setMobile(Long.parseLong(req.getParameter("phone")));
		student.setName(req.getParameter("name"));
		student.setPassword(req.getParameter("password"));
		student.setStandard(req.getParameter("cls"));
	
		Date dob=Date.valueOf(req.getParameter("dob"));
		student.setDob(dob);
		
		LocalDate date1=dob.toLocalDate();
		LocalDate date2=LocalDate.now();
		
		student.setAge(Period.between(date1, date2).getYears());
		StudentDao dao=new StudentDao();
		
		try {
			dao.saveStudent(student);
			resp.getWriter().print("<h1>Account Created Successully</h1>");
			req.getRequestDispatcher("login.html").include(req, resp);
			
			}
			catch(Exception e)
			{
				resp.getWriter().print("<h1>Email / Phone Number Exists</h1>");
				req.getRequestDispatcher("studentSignup.html").include(req, resp);
			}
		}
	}

