package fr.epsi.router;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epsi.entite.Client;
import fr.epsi.service.ClientService;

public class ClientServlet extends HttpServlet {
	

	@EJB
	private ClientService clientService;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
		// Affichage Liste clients
		if(req.getParameter("action").equals("list")) 
		{
			req.setAttribute( "listClients", clientService.getListClients() );
			this.getServletContext().getRequestDispatcher("/WEB-INF/pages/clientsList.jsp").forward(req, resp);
		}
		// Affichage Formulaire création client
		else if(req.getParameter("action").equals("create"))
		{
			this.getServletContext().getRequestDispatcher("/WEB-INF/pages/clientCreate.jsp").forward(req, resp);
		}
    }
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
		// Creation Client
		if(req.getParameter("actionPost").equals("formCreate")) 
		{		
			/* Création du client avec les parametres reçue */
			Client client = new Client();
			client.setNom(req.getParameter("nameClient"));
			client.setAdresse(req.getParameter("adresseClient"));
			   
			/* Ajout du client dans la BDD */
			clientService.addClient(client);
			
			/* Affichage de la liste des clients */
			req.setAttribute( "listClients", clientService.getListClients() );
			this.getServletContext().getRequestDispatcher("/WEB-INF/pages/clientsList.jsp").forward(req, resp);
	    }
	}
}
