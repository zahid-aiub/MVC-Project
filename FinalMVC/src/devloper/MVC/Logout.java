package devloper.MVC;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.MVC.iController;

public class Logout implements iController{

	@Override
	public void doProcess(HttpServletRequest request, HttpServletResponse response, String view)
			throws IOException, ServletException {
		
		
		RequestDispatcher rs = request.getRequestDispatcher(view);
		rs.forward(request,response);
		
	}

}
