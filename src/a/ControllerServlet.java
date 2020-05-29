package a;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ControllerServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
doGet(request, response);
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String search=request.getParameter("search");
        
        if(search.isEmpty()){
        	RequestDispatcher rd=request.getRequestDispatcher("error.jsp");  
            rd.forward(request, response);
        }
        else{
        	beanyBean bean=new beanyBean(); 
            SQLcon.search = search;
            request.setAttribute("bean",bean);
              
            if(SQLcon.connectSQL()){  
            	SQLcon.stateSQL();
                RequestDispatcher rd=request.getRequestDispatcher("success.jsp");  
                rd.forward(request, response);
            }  
            else{  
                RequestDispatcher rd=request.getRequestDispatcher("error.jsp");  
                rd.forward(request, response);  
            }
        }
	}

}
