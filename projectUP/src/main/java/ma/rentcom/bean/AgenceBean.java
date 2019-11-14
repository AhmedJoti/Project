package ma.rentcom.bean;

import static ma.rentcom.util.Utils.addDetailMessage;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import javax.faces.view.ViewScoped;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.github.adminfaces.template.exception.BusinessException;

import ma.rentcom.model.entity.Agence;
import ma.rentcom.model.entity.Ville;
import ma.rentcom.service.AgenceService;
import ma.rentcom.service.VilleService;

@Named
@ViewScoped
public class AgenceBean implements Serializable {

	private static final long serialVersionUID = -3923629366408082983L;

	protected final Logger log = Logger.getLogger(getClass().getName());

	@Inject
	private AgenceService agenceService;

	@Inject
	private VilleService villeService;

	private Long idAgence;
	private Agence agence;
	private List<Agence> agences;
	private List<Agence> selectedAgences; 
	private List<Ville> villes;
	private String selectedVille;
	private String editAgenceId;
	private Ville ville;
	private String villess;
	private Collection<Agence> agencess;
	private String selectedAgence;
	private List<Agence> filtredAgences;

	


	@PostConstruct
	public void initMB() throws IOException {
		agences = agenceService.getAll();
		villes = villeService.getAll();
		
	}
	
	
	public List<Agence> getFiltredAgences() {
		return filtredAgences;
	}

	public void setFiltredAgences(List<Agence> filtredAgences) {
		this.filtredAgences = filtredAgences;
	}
	
	
	

	
	
	

	public void findAgenceById(Long id) {
		if (id == null) {
			throw new BusinessException("Provide Agence ID to load");
		}
		selectedAgences.add(agenceService.findById(id));
	}

	public void delete() {
		int numAgences = 0;
		for (Agence selectedAgence : selectedAgences) {
			numAgences++;
			agenceService.remove(selectedAgence);
			agences.remove(selectedAgence);
		}
		selectedAgences.clear();
		addDetailMessage(numAgences + " agences deleted successfully!");
	}

	/*
	 * public void update(Long id) throws IOException { agence =
	 * agenceService.findById(id); //1ere methode
	 * 
	 * 
	 * Faces.redirect("admin/agence-edit.xhtml"); log.log(Level.WARNING,
	 * agence.getNom());
	 * 
	 * 
	 * editAgenceId=FacesContext.getCurrentInstance().getExternalContext().
	 * getRequestParameterMap().get("selectedAgenceId"); log.log(Level.WARNING,
	 * editAgenceId);//2eme methode
	 * 
	 * 
	 * }
	 */

	public void clear() {
		agence = new Agence();
		idAgence = null;
	}

	public List<Agence> getSelectedAgences() {
		return selectedAgences;
	}

	public void setSelectedAgences(List<Agence> selectedAgences) {
		this.selectedAgences = selectedAgences;
	}

	public Long getIdAgence() {
		return idAgence;
	}

	public void setId(Long idAgence) {
		this.idAgence = idAgence;
	}

	public String getEditAgenceId() {
		return editAgenceId;
	}

	public void setEditAgenceId(String editAgenceId) {
		this.editAgenceId = editAgenceId;
	}

	public List<Agence> getAgences() {
		return agences;
	}

	public void setAgences(List<Agence> agences) {
		this.agences = agences;
	}

	public Agence getAgence() {
		return agence;
	}

	public void setAgence(Agence agence) {
		this.agence = agence;
	}

	public VilleService getVilleService() {
		return villeService;
	}

	public void setVilleService(VilleService villeService) {
		this.villeService = villeService;
	}

	public List<Ville> getVilles() {
		return villes;
	}

	public void setVilles(List<Ville> villes) {
		this.villes = villes;
	}

	public String getSelectedVille() {
		return selectedVille;
	}

	public void setSelectedVille(String selectedVille) {
		this.selectedVille = selectedVille;
	}

	public Ville getVille() {
		return ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}

	public String getVilless() {
		return villess;
	}

	public void setVilless(String villess) {
		this.villess = villess;
	}

	public Collection<Agence> getAgencess() {
		return agencess;
	}

	public void setAgencess(Collection<Agence> agencess) {
		this.agencess = agencess;
	}
	
	public String getSelectedAgence() {
		return selectedAgence;
	}

	public void setSelectedAgence(String selectedAgence) {
		this.selectedAgence = selectedAgence;
	}


}
