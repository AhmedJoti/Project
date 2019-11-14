package ma.rentcom.model;

import java.util.Collection;
import ma.rentcom.model.entity.Agence;
import ma.rentcom.model.entity.Ville;

public class agenceData {


	
    private Long id;
	private byte[] photo;
	

	private String nom;

	private String adresse;
	
	private Ville ville;

	private double longitude;

	private double lat;
	
	private String tel;
	
	private String fax;
	
	private String siteWeb;
	
	private String email;
	
	private String link_logo;

	private Collection<Agence> agenceFils;

    
	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	
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


	public Long getId() {
		return id;
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
            if (other.getId() != null)
                return false;
        } else if (!id.equals(other.getId()))
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
        return ville != null && !"".equals(ville+"".trim());
    }
	

	
	
	
	public int compareTo(Agence o) {
        return this.id.compareTo(o.getId());
    }

	@Override
	public String toString() {
		return   nom ;
	}


	
	

	


	/**/

	
}
