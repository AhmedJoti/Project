/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.rentcom.bean;

import static com.github.adminfaces.template.util.Assert.has;
import static ma.rentcom.util.Utils.addDetailMessage;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Faces;

import com.github.adminfaces.template.exception.AccessDeniedException;

import ma.rentcom.model.entity.Ville;
import ma.rentcom.service.VilleService;
import ma.rentcom.util.Utils;

/**
 * @author rmpestano
 */
@Named
@ViewScoped
public class VilleFormBean implements Serializable {



	/**
	 * 
	 */
	private static final long serialVersionUID = 7404403837906690133L;

	@Inject
    private VilleService villeService;

    private Long idVille;
    private Ville ville  = new Ville();


    public void init() {
        if (Faces.isAjaxRequest()) {
            return;
        }
        if (has(idVille)) {
            ville = villeService.findById(idVille);
        } else {
            ville = new Ville();
        }
    }


    public Ville getVille() {
        return ville;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
    }


    public void remove() throws IOException {
        if (!Utils.isUserInRole("ROLE_ADMIN")) {
            throw new AccessDeniedException("User not authorized! Only role <b>admin</b> can remove villes.");
        }
        if (has(ville) && has(ville.getId())) {
            villeService.remove(ville);
            addDetailMessage("Ville " + ville.getId() + " removed successfully");
            Faces.getFlash().setKeepMessages(true);
            Faces.redirect("admin/ville-list.xhtml");
        }
    }

	public void save() throws IOException {
		String msg;
		
		villeService.add(ville);
		msg = "Ville " + ville.getId() + " created successfully";
		addDetailMessage(msg);
//		Faces.getFlash().setKeepMessages(true);
//        Faces.redirect("user/ville-list.xhtml");
	}

    public void clear() {
        ville = new Ville();
        idVille = null;
    }

    public boolean isNew() {
        return ville == null || ville.getId() == null;
    }

	public Long getIdVille() {
		return idVille;
	}

	public void setIdVille(Long idVille) {
		this.idVille = idVille;
	}


}
