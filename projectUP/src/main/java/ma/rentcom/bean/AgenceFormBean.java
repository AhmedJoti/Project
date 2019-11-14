/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.rentcom.bean;

import static com.github.adminfaces.template.util.Assert.has;
import static ma.rentcom.util.Utils.addDetailMessage;

import java.io.ByteArrayInputStream;
import java.io.File;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Properties;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.io.FilenameUtils;
import org.junit.jupiter.api.Test;
import org.omnifaces.util.Faces;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

import com.github.adminfaces.template.exception.AccessDeniedException;

import ma.rentcom.model.entity.Agence;
import ma.rentcom.model.entity.Ville;

import ma.rentcom.service.AgenceService;
import ma.rentcom.service.VilleService;
import ma.rentcom.util.Utils;

@Named
@ViewScoped
public class AgenceFormBean implements Serializable {

	private static final long serialVersionUID = 4571281212429719001L;

	@Inject
	private AgenceService agenceService;

	@Inject
	private VilleService villeService;

	private List<Ville> villes;
	private Long selectedVille;
	private Long idAgence;
	private Agence agence;
	private List<Agence> agences;
	private Ville ville;
	private String villess;
	private Collection<Agence> agencess;
	private String selectedAgence;
	private String image;

	/*
	 * protected final Logger log = Logger.getLogger(getClass().getName());
	 */

	UploadedFile file;
	
	FileUploadEvent event;
	
	
	public void init() throws IOException {

		villes = villeService.getAll();
		agences = agenceService.getAll();
//         photo= extractBytes("c:\\images\\10.png");
		if (Faces.isAjaxRequest()) {
			return;
		}
		if (has(idAgence)) {
			agence = agenceService.findById(idAgence);
			selectedVille = agence.getVille().getId();
           agence.getLink_logo();
		} else {
			agence = new Agence();

		}
	}


	public FileUploadEvent getEvent() {
		return event;
	}

	public void setEvent(FileUploadEvent event) {
		this.event = event;
	}

	public UploadedFile getFile() {
		return file;
	}
    
	 
	public void setFile(UploadedFile file) {
		this.file = file;
	}
	
	
	public void save() throws IOException {
		agenceService.validate(agence);


		try {

		Ville v = new Ville();
		v.setId(selectedVille);
		agence.setVille(v);

		List<Agence> ag = new ArrayList<Agence>();
		agence.setLink_logo(image);
		ag.addAll(agencess);
		agence.setAgenceFils(ag);

		agence.setLink_logo(agence.getLink_logo());
		String msg;
		agenceService.add(agence);
		
		
		
		String suffix = FilenameUtils.getExtension(file.getFileName());
		agence.setLink_logo(agence.getId()+"."+ suffix);
		agenceService.add(agence);
		
		msg = "Agence " + agence.getId() + " created successfully";
		
		 try{
			 	InputStream input = file.getInputstream();
			 	InputStream appProperties = AgenceFormBean.class.getClassLoader().getResourceAsStream("application.properties");
	            Properties prop = new Properties();
	            prop.load(appProperties);
	            
			 	
			 	String path = prop.getProperty("image.path");
			 	Path newPath = new File(path+"agence/", agence.getId()+".png" ).toPath();
			 	Files.copy(input, newPath , StandardCopyOption.REPLACE_EXISTING);
			 	
				 System.out.println("~######################################"+newPath);


		 }
		 catch(Exception e)
		 {
			 System.out.println(e.getMessage());
		 }

		addDetailMessage(msg);
		 } catch (Exception e) {

				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "veuillez saisir une ville!"));

	       }

		
	    }
	
	public StreamedContent getUploadedFileAsStream()
    {
        if (file != null)
        {
            return new DefaultStreamedContent(new ByteArrayInputStream(file.getContents()));
        }
        return null;
    }
      
	public void uploadFile(FileUploadEvent event)
    {
        file = event.getFile();
    }
	
//	public byte[] extractBytes (String ImageName) throws IOException {
//		 // open image
//		 File imgPath = new File("c:\\images\\10.png");
//		 BufferedImage bufferedImage = ImageIO.read(imgPath);
//
//		 // get DataBufferBytes from Raster
//		 WritableRaster raster = bufferedImage .getRaster();
//		 DataBufferByte data   = (DataBufferByte) raster.getDataBuffer();
//
//		 return ( data.getData() );
//		}
//	
//	
//	
//	public String handleFileUpload() throws IOException {  
//	    FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
//	    FacesContext.getCurrentInstance().addMessage(null, msg);  
//	    UploadedFile file = event.getFile();
//
//	    String prefix = FilenameUtils.getBaseName(file.getFileName());
//	    String suffix = FilenameUtils.getExtension(file.getFileName());
//
//
//	    String path = "C:/images";
//
//	     ExternalContext extContext = FacesContext.getCurrentInstance().getExternalContext();
//
//
//	    File fileToDirectory = File.createTempFile(prefix + "-", "." + suffix, new File(path));
//
//	    InputStream inputStream = event.getFile().getInputstream();
//	    String fileName = event.getFile().getFileName();
//
//	    OutputStream outputStream = new FileOutputStream(fileToDirectory);
//
//	    byte[] buffer = new byte[1024];
//
//	    int length;
//	    //copy the file content in bytes 
//	    while ((length = inputStream.read(buffer)) > 0){
//
//	        outputStream.write(buffer, 0, length);
//
//	    }
//
//	    inputStream.close();
//	    outputStream.close();
//	    return path+fileName;
//
//
//	}
//	
	
//	public void fileUploadListener(FileUploadEvent e) throws IOException{
//	
//       
//		
//		// Get uploaded file from the FileUploadEvent
//		this.file = e.getFile();
//		// Print out the information of the file
//		System.out.println("Uploaded File Name Is :: "+file.getFileName()+" :: Uploaded File Size :: "+file.getSize());
//		FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("File Uploaded Successfully"));
//		InputStream input = file.getInputstream();
//        
//		Path folder = Paths.get("");
//		String filename = FilenameUtils.getBaseName(file.getFileName()); 
//		String extension = FilenameUtils.getExtension(file.getFileName());
//		Path file = Files.createTempFile(folder,filename, "." + extension);
//		Files.copy(input, file, StandardCopyOption.REPLACE_EXISTING);
//		
//		System.out.println("Uploaded file successfully saved in " + file);
//	}
	
	/*

	/*
	 * public void upload(){
	 * 
	 * if(file !=null){ try{ FacesContext context =
	 * FacesContext.getCurrentInstance(); ServletContext servletcontext =
	 * (ServletContext)context.getExternalContext().getContext(); String dbpath =
	 * servletcontext.getRealPath("/"); String webcut = dbpath.substring(0,
	 * dbpath.lastIndexOf("\\")); String buildcut = webcut.substring(0,
	 * webcut.lastIndexOf("\\")); String mainURLPath = buildcut.substring(0,
	 * buildcut.lastIndexOf("\\"));
	 * 
	 * InputStream inputStrim = file.getInputstream(); String path =
	 * mainURLPath+"\\WEB-INF\\images\\"+file.getFileName(); File destFile = new
	 * File(path); if(!destFile.exists()){
	 * FileUtils.copyInputStreamToFile(inputStrim, destFile); }
	 * agence.setLink_logo(file.getFileName().toString()); } catch (Exception e) {
	 * e.printStackTrace(); } }}
	 */

	/*
	 * public void FileUpload(FileUploadEvent event) throws IOException {
	 * 
	 * ExternalContext extContext =
	 * FacesContext.getCurrentInstance().getExternalContext();
	 * 
	 * File result = new
	 * File(extContext.getRealPath(event.getFile().getFileName()));
	 * System.out.println(extContext.getRealPath( event.getFile().getFileName()));
	 * image = extContext.getRealPath( event.getFile().getFileName());
	 * 
	 * FileOutputStream fileOutputStream = new FileOutputStream(result);
	 */
		
//            byte[] buffer = new byte[BUFFER_SIZE];
//            int bulk;
//            InputStream inputStream = event.getFile().getInputstream();
//           
//                bulk = inputStream.read(buffer);}

	
	/*
	 * public byte[] testphoto(Long idAgence) throws IOException {
	 * 
	 * // get link image by idAgence = linkimage InputStream in =
	 * servletContext.getResourceAsStream("linkimage"); return
	 * IOUtils.toByteArray(in); }
	 */

	public String getSelectedAgence() {
		return selectedAgence;
	}

	public void setSelectedAgence(String selectedAgence) {
		this.selectedAgence = selectedAgence;
	}

	
	public Long getSelectedVille() {
		return selectedVille;
	}

	public void setSelectedVille(Long selectedVille) {
		this.selectedVille = selectedVille;
	}

	public Agence getAgence() {
		return agence;
	}

	public void setAgence(Agence agence) {
		this.agence = agence;
	}

	public void remove() throws IOException {
		if (!Utils.isUserInRole("ROLE_ADMIN")) {
			throw new AccessDeniedException("User not authorized! Only role <b>admin</b> can remove agences.");
		}
		if (has(agence) && has(agence.getId())) {
			agenceService.remove(agence);
			addDetailMessage("Agence " + agence.getId() + " removed successfully");
			Faces.getFlash().setKeepMessages(true);
			Faces.redirect("admin/agence-list.xhtml");
		}
	}

	
	// Faces.getFlash().setKeepMessages(true);
//        Faces.redirect("user/agence-list.xhtml");

	public void clear() {
		agence = new Agence();
		idAgence = null;
	}

	public String getVilless() {
		return villess;
	}

	public void setVilless(String villess) {
		this.villess = villess;
	}
	
	public boolean isNew() {
		return agence == null ;
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

	public Collection<Agence> getAgencess() {
		return agencess;
	}

	public void setAgencess(Collection<Agence> agencess) {
		this.agencess = agencess;
	}

	public List<Agence> getAgences() {
		return agences;
	}

	public void setAgences(List<Agence> agences) {
		this.agences = agences;
	}

	public Long getIdAgence() {
		return idAgence;
	}

	public void setIdAgence(Long idAgence) {
		this.idAgence = idAgence;
	}

	/*
	 * public void storeImage() throws ClassNotFoundException, SQLException,
	 * IOException{
	 * 
	 * Class.forName("com.mysql.jdbc.Driver"); // Connect to the database Connection
	 * connection = DriverManager.getConnection(
	 * "jdbc:mysql://192.168.100.13:3306/rentcom?user=root&password=test"); // Set
	 * autocommit to false to manage it by hand connection.setAutoCommit(false);
	 * 
	 * // Create the statement object PreparedStatement statement =
	 * connection.prepareStatement("INSERT INTO agence (logo) VALUES (?)"); // Set
	 * file data statement.setBinaryStream(1, file.getInputstream());
	 * 
	 * // Insert data to the database statement.executeUpdate();
	 * 
	 * // Commit & close connection.commit(); // when autocommit=false
	 * connection.close();
	 * 
	 * FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
	 * "Upload success", file.getFileName() + " is uploaded.");
	 * FacesContext.getCurrentInstance().addMessage(null, msg); // Get uploaded file
	 * from the FileUploadEvent
	 * 
	 * }
	 * 		agenceService.validate(agence);

	 * public void upload(FileUploadEvent event) { UploadedFile uploadedFile =
	 * event.getFile(); String fileName = uploadedFile.getFileName(); String
	 * contentType = uploadedFile.getContentType(); byte[] contents =
	 * uploadedFile.getContents(); // Or getInputStream() // ... Save it, now! }
	 */
	
	

}
