package ma.rentcom.model.entity;



import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "ville")
public class Ville implements Serializable{
	 

	private static final long serialVersionUID = -916210296829717141L;


	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@Column
	private String ville;
	
	

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public Ville(String ville) {
		super();
		this.ville = ville;
	}

	public Ville() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	
	public boolean hasVille() {
        return ville != null && !"".equals(ville.trim());
    }

	@Override
	public String toString() {
		return ville ;
	}

	public Object trim() {
		// TODO Auto-generated method stub
		return null;
	}

	



	


	 
		
	
}
