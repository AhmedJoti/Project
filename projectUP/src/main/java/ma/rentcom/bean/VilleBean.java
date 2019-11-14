package ma.rentcom.bean;

import static ma.rentcom.util.Utils.addDetailMessage;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.github.adminfaces.template.exception.BusinessException;

import ma.rentcom.model.entity.Agence;
import ma.rentcom.model.entity.Ville;
import ma.rentcom.service.VilleService;

@Named
@ViewScoped
public class VilleBean implements Serializable {

	private static final long serialVersionUID = -2498852449984363552L;

	protected final Logger log = Logger.getLogger(getClass().getName());

	@Inject
	private VilleService villeService;

	private Long idVille;

	private Ville ville;

	private List<Ville> villes;

	private List<Ville> selectedVilles; // villes selected in checkbox column

	@PostConstruct
	public void initMB() {
		villes = villeService.getAll();
	}

	public void findVilleById(Long id) {
		if (id == null) {
			throw new BusinessException("Provide Ville ID to load");
		}
		selectedVilles.add(villeService.findById(id));
	}

	public void delete() {
		int numAgences = 0;
		for (Ville selectedVille : selectedVilles) {
			numAgences++;
			villeService.remove(selectedVille);
			villes.remove(selectedVille);
		}
		selectedVilles.clear();
		addDetailMessage(numAgences + " agences deleted successfully!");
	}

	public void clear() {
		ville = new Ville();
		idVille = null;
	}

	public List<Ville> getSelectedVilles() {
		return selectedVilles;
	}

	public void setSelectedVilles(List<Ville> selectedVilles) {
		this.selectedVilles = selectedVilles;
	}



	public List<Ville> getVilles() {
		return villes;
	}

	public void setVilles(List<Ville> villes) {
		this.villes = villes;
	}

	public Ville getVille() {
		return ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}

	public Long getIdVille() {
		return idVille;
	}

	public void setIdVille(Long idVille) {
		this.idVille = idVille;
	}
}
