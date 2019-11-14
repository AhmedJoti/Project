package ma.rentcom.model.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.elasticsearch.annotations.Document;

//import org.springframework.data.elasticsearch.annotations.Document;






@Entity
@Table(name = "Agence")
//@Document(indexName = "mkyong", type = "books")
public class Agence implements Serializable {
	
	
	

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column
    private Long id;
	
	@Column(name = "nom")
	private String nom;

	@Column(name = "Adresse")
	private String adresse;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_ville")
	private Ville ville;

	@Column(name = "Longitude")
	private double longitude;

	@Column(name = "latitude")
	private double lat;
	
	@Column(name = "tel")
	private String tel;
	
	@Column(name = "fax")
	private String fax;
	
	@Column(name = "site_web")
	private String siteWeb;
	
	@Column(name = "adresse_email")
	private String email;
	
	@Column(name = "Logo")
	private String link_logo;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "agentFils")
	private Collection<Agence> agenceFils;
	 


	public Collection<Agence> getAgenceFils() {
		return agenceFils;
	}

	public void setAgenceFils(Collection<Agence> agenceFils) {
		this.agenceFils = agenceFils;
	}


	public String getLink_logo() {
		return link_logo;
	}

	public void setLink_logo(String link_logo) {
		this.link_logo = link_logo;
	}
	
	public Ville getVille() {
		return ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}

	
	public Agence() {
		super();
	}
	


	public Long getId() {
		return id;
	}

	public Agence(Long id,String nom, String adresse, String email) {
		super();
		this.id = id;

		this.nom = nom;
		this.adresse = adresse;
		this.email = email;
	}

	public void setId(Long id) {
		this.id = id;
	}




	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getSiteWeb() {
		return siteWeb;
	}

	public void setSiteWeb(String siteWeb) {
		this.siteWeb = siteWeb;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	@Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Agence other = (Agence) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
	
	public boolean hasName() {
        return nom != null && !"".equals(nom.trim());
    }
     
	
	public boolean hasTel() {
        return tel != null && !"".equals(tel.trim());
    }
	
	public boolean hasAdresse() {
        return adresse != null && !"".equals(adresse.trim());
    }
	public boolean hasEmail() {
        return email != null && !"".equals(email.trim());
    }
	public boolean hasVille() {
        return ville != null && !"".equals(ville.trim());
    }
	

	
	
	
	public int compareTo(Agence o) {
        return this.id.compareTo(o.getId());
    }

	 @Override
	    public String toString() {
	        return  nom ;
	    }

	
	

	


	/**/

	
}
