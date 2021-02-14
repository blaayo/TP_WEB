package fr.epsi.router;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epsi.service.FactureService;

public class FactureServlet extends HttpServlet {

	@EJB
	private FactureService factureService;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
		// Affichage Liste articles
		if(req.getParameter("action").equals("list")) 
		{
			req.setAttribute( "listfactures", factureService.getListFactures() );
			this.getServletContext().getRequestDispatcher("/WEB-INF/pages/facturesList.jsp").forward(req, resp);
		}
    }

}
