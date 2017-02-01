package composants;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import outils.ListeUtilisateurDTO;
import outils.UtilisateurDTO;


	
@ManagedBean(name="utilisateurs")
@RequestScoped
public class gui {

	private List<UtilisateurDTO> dtoliste = new ArrayList<UtilisateurDTO>();
	

	
	
	public gui() {
		super();
	}
	

	public List<UtilisateurDTO> getDtoliste() {
		return dtoliste;
	}


	public void setDtoliste(List<UtilisateurDTO> dtoliste) {
		this.dtoliste = dtoliste;
	}


	@PostConstruct
	public void init(){
	
	
		Client client = ClientBuilder.newClient();
		WebTarget cible = client.target(UriBuilder.fromPath("http://172.17.0.5:8080/listeur"));
		WebTarget ciblefinale = cible.path("listedto");
		ListeUtilisateurDTO dtoliste2 = ciblefinale.request(MediaType.APPLICATION_XML).get(ListeUtilisateurDTO.class);
		dtoliste = dtoliste2.getListedto();
	}
	}

	
	
	
