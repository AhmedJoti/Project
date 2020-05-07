package org.sid;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.sid.dao.ContactRepository;
import org.sid.entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
    @Autowired
	private ContactRepository contactRepository ;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);  
	}

	@Override
	public void run(String... args) throws Exception {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
contactRepository.save(new Contact("joti3", "mly hmed3	", df.parse("22/01/1990"), "mlyhmedjoti3@gmail.com\n" + 
		"",  0454545, "photo"));	
contactRepository.save(new Contact("joti", "mly hmed", df.parse("22/01/1990"), "mlyhmedjoti56@gmail.com\n" + 
		"",  0454545, "photo"));	
contactRepository.save(new Contact("joti5", "prenom", df.parse("22/01/1990"), "mlyhmedjoti56gdf",  0454545, "photo"));	
contactRepository.findAll().forEach(c->{
       System.out.println(c.getNom());
	});

}
}