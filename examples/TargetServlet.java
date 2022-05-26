/*
 * SourceServlet.java
 * 
 * Copyright 2022 Rodney <>
 * 
 * 
 */

@WebServlet("/targetServlet")
public class TargetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// this is called when the hyperlink from SourceServlet is clicked
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// instantiate the session object and use the .getSession() method on the request
		HttpSession session = request.getSession();
		
		// retrieve the attribute from the session
		String username = (String)(session.getAttribute("user"));
		
		String sessionId = session.getId();

		long creationTime = session.getCreationTime();
		long lastAccessedTime = session.getLastAccessedTime();

		Date createDate= new Date(creationTime);
		Date lastAccessedDate= new Date(lastAccessedTime);

		
		// print the retrieved attribute using the PrintWriter
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>Username is: " + username + " </h1>");
		
		out.println(" Your Session Infomation: <br/>");
		out.println("ID: " + sessionId  + "<br/>");
		out.println("Session Created Date: " + createDate + "<br/>");
		out.println("Session Created Time: " + creationTime + "<br/>");
		out.println("Last Accessed Date : " + lastAccessedDate + "<br/>");
		out.println("Last Accessed Time: " + lastAccessedTime + "<br/>");
	}
}
