package devloper.MVC;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.MVC.iController;

public class LogoutProcess implements iController{

	@Override
	public void doProcess(HttpServletRequest request, HttpServletResponse response, String view)
			throws IOException, ServletException {
		
		HttpSession session = request.getSession();
		session.removeAttribute(null);
		session.removeAttribute(null);
		
		
		RequestDispatcher rs = request.getRequestDispatcher("loginView");
		rs.forward(request,response);
		
	}

}
