package fr.epsi.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import fr.epsi.entite.Article;
import fr.epsi.entite.Client;
import fr.epsi.entite.Facture;
import fr.epsi.entite.LigneFacture;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class FactureServiceImplementation implements FactureService {

	public List<Facture> getListFactures() {
		// TODO Auto-generated method stub
		
		return null;
	}

	public List<Facture> getMockListFactures() {
		SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
		
		List<Facture> listFactures = new ArrayList<Facture>();
		List<LigneFacture> listLignesFacture = new ArrayList<LigneFacture>();
		
		Facture facture1 = new Facture();
		
		Double prixTotal = 0.0;

		LigneFacture ligneFacture1 = new LigneFacture();
		LigneFacture ligneFacture2 = new LigneFacture();
		
		Article article = new Article();
		Article article2 = new Article();
		
		Client client1 = new Client();
		
		article.setNom("Clavier sans fils");
		article.setCodeBarre("cb-33150");
		article.setPrix(50.99);
		
		article2.setNom("Souris sans fils");
		article2.setCodeBarre("cb-11897");
		article2.setPrix(20.99);
		
		ligneFacture1.setArticle(article);
		ligneFacture1.setQte((long) 5);
		ligneFacture1.setPrix(article.getPrix());
		
		ligneFacture2.setArticle(article2);
		ligneFacture2.setQte((long) 8);
		ligneFacture2.setPrix(article2.getPrix());
		
		
		ligneFacture1.setFacture(facture1);
		ligneFacture2.setFacture(facture1);
		
		listLignesFacture.add(ligneFacture1);
		listLignesFacture.add(ligneFacture2);
		
		client1.setNom("DUPONT");
		client1.setAdresse("Marseille");
		
		facture1.setClient(client1);
		try {
			facture1.setDate(DateFor.parse("01/01/2021"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(LigneFacture lignefacture : listLignesFacture) {
			prixTotal += lignefacture.getPrix();
		}
		
		facture1.setPrix(prixTotal);
		
		listFactures.add(facture1);
		
		return listFactures;
	}

}
