package controller.MVC;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * This class GlobalController acts as a fontcontroller, it accept
 * all kind request from web.xml file and dispatch
 * the request to the specefic view by pearsing mvc.xml file.
 * This class also check the client request valid or not.
 * 
 * @author Zahid
 * @version 1.0
 * @since 2018-05-02
 * 
 */

public class GlobalController extends HttpServlet {

	/**
	 * This method doProcess() has tow parameter which come from HttpServletRequest
	 * This method parse a xml file and take it's elements content
	 * and then take decision to despatch the request
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String requestURL = request.getPathInfo();

		try {

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(getClass().getResourceAsStream("mvc.xml"));
			doc.getDocumentElement().normalize();

			String dispatchURL = null;
			Node sibling = null;
			Node siblingModel = null;
			Node siblingController = null;

			/**
			 * Take the 'ctrl-url' element content from mvc.xml
			 * and check the user given url 
			 *  
			 */
			NodeList ctrlUrlNodeList = doc.getElementsByTagName("ctrl-url");
			for (int i = 0; i < ctrlUrlNodeList.getLength(); i++) {
				String ctrlUrlContent = ctrlUrlNodeList.item(i).getTextContent();
				// check the url here
				if (ctrlUrlContent.equals(requestURL)) {
					//------ get view content
					sibling = ctrlUrlNodeList.item(i).getNextSibling();

					//------- get model content
					siblingModel = ctrlUrlNodeList.item(i).getPreviousSibling();

					while (!(sibling instanceof Element) && sibling != null) {
						sibling = sibling.getNextSibling();
					}

					while (!(siblingModel instanceof Element) && siblingModel != null) {
						siblingModel = siblingModel.getPreviousSibling();
					}

					siblingController = siblingModel.getPreviousSibling();

					while (!(siblingController instanceof Element) && siblingController != null) {
						siblingController = siblingController.getPreviousSibling();
					}
					siblingController.getTextContent();
					dispatchURL = sibling.getTextContent();   //--- view---

					break;
				}
				
			}
			/**
			 * call the method of iController interface
			 * 
			 */
			String ctrl = siblingController.getTextContent();
			// String obj = "controller.MVC.RegistrationController";
			iController con = (iController) Class.forName(ctrl).getConstructor().newInstance();
			/**
			 * dispatchURL is a view which is come from mvc.xml file
			 * 
			 * @param request
			 * @param response
			 * @param dispatchURL
			 */
			con.doProcess(request, response, dispatchURL);

		} catch (Exception e) {
			System.out.println(e);

		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

}
