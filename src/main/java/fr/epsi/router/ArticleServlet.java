package fr.epsi.router;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epsi.entite.Article;
import fr.epsi.service.ArticleService;

public class ArticleServlet extends HttpServlet  {
	

	@EJB
	private ArticleService articleService;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
		// Affichage Liste articles
		if(req.getParameter("action").equals("list")) 
		{
			req.setAttribute("listArticles", articleService.getListArticles());
			this.getServletContext().getRequestDispatcher("/WEB-INF/pages/articlesList.jsp").forward(req, resp);
		}
		// Affichage Formulaire création article
		else if(req.getParameter("action").equals("create"))
		{
			this.getServletContext().getRequestDispatcher("/WEB-INF/pages/articleCreate.jsp").forward(req, resp);
		}
    }
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
		// Creation articles
		if(req.getParameter("actionPost").equals("formCreate")) 
		{
			/* Création de l'articles avec les parametres reçue */
			Article article = new Article();
			article.setNom(req.getParameter("nameArticle"));
			article.setCodeBarre(req.getParameter("nameCodeBarre"));
			article.setPrix(Double.parseDouble(req.getParameter("priceArticle")));
			   
			/* Ajout de l'articles dans la BDD */
			articleService.addArticle(article);
			
			/* Affichage de la liste des articles */
			req.setAttribute("listArticles", articleService.getListArticles());
			this.getServletContext().getRequestDispatcher("/WEB-INF/pages/articlesList.jsp").forward(req, resp);
	    }
	}

}
