package devloper.MVC;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import controller.MVC.iController;
import model.MVC.UserBean;
import model.MVC.UserBean;
import service.MVC.RegisterService;

import java.util.*;
import java.net.*;

public class RegistrationProcess implements iController {

	public void doProcess(HttpServletRequest request, HttpServletResponse response, String view)
			throws IOException, ServletException {

		String firstName = request.getParameter("first_name");
		String lastName = request.getParameter("last_name");
		String email = request.getParameter("email");
		String password = request.getParameter("passwrd");

		UserBean user = new UserBean(firstName, lastName, email, password);

		try {
			RegisterService registerService = new RegisterService();
			boolean result = registerService.register(user);
			if (result) {
				RequestDispatcher rs = request.getRequestDispatcher("loginView");
				rs.forward(request, response);
				System.out.println("Data Insert Successfully");
			} else {
				System.out.println("Data Insertion Failed");
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}