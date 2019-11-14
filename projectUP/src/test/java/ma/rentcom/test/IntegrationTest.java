//package ma.rentcom.test;
//
//import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.net.InetAddress;
//import java.util.Date;
//
//import org.elasticsearch.action.index.IndexResponse;
//import org.elasticsearch.client.transport.TransportClient;
//import org.elasticsearch.common.settings.Settings;
//import org.elasticsearch.common.transport.InetSocketTransportAddress;
//import org.elasticsearch.transport.client.PreBuiltTransportClient;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import ma.rentcom.repository.AgenceRepository;
//
//@RunWith(SpringRunner.class)
//public class IntegrationTest {
//
//	
//	@Autowired
//	private AgenceRepository agenceRepository;
//	  
//	    
//	@Test
//	public void getAllAgence() throws IOException {
//
//		
//		
//		
//		
//		
//		Agence agence = new Agence();
//		ArrayList<Agence> rows = new ArrayList<>();
//		FileWriter csvWriter = new FileWriter("Agences.csv");
//		csvWriter.append("Id");
//		csvWriter.append(",");
//		csvWriter.append("imm");
//		csvWriter.append(",");
//		csvWriter.append("Agencebu");
//		csvWriter.append(",");
//		csvWriter.append("Marque");
//		csvWriter.append(",");
//		csvWriter.append("Model");
//		csvWriter.append(",");
//		csvWriter.append("Agence");
//		csvWriter.append("\n");
//		for(int i  = 0 ; i <= 150 ; i++) {
//			
//			if(i <75) {
//				
//				Long id = (long) i ;
//				Model model = new Model();
//				Marque marque = new Marque();
//				Agence agence = new Agence();
//				model.setNom("A4");
//				marque.setNom("Audi");
//				agence.setNom("Logista");
//				agence.setId(id);
//				model.setId(id);
//				agence.setModel(model);
//				agence.setMarque(marque);
//				agence.setAgence(agence);
//				agence.setImmVoi("B-"+"2"+i+"-3");
//				agence.setAgenceburant("Diesel");
//				rows.add(agence);
//				
//			}else {
//				
//				Long id = (long) i ;
//				Model model = new Model();
//				Marque marque = new Marque();
//				Agence agence = new Agence();
//				model.setId(id);
//				model.setNom("Golf 8");
//				marque.setNom("volkswagen");
//				agence.setNom("Medousa");
//				agence.setId(id);
//				agence.setModel(model);
//				agence.setMarque(marque);
//				agence.setAgence(agence);
//				agence.setImmVoi("A-"+"1"+i+"-2");
//				agence.setAgenceburant("Essence");
//				rows.add(agence);
//
//       
//		
////		try (PrintWriter writer = new PrintWriter(new File("c:/csv/test3.csv"))) {
////         
////		      StringBuilder sb = new StringBuilder();
////		      sb.append("ffggf");
////		      sb.append(',');
////		      sb.append("Name");
////		      sb.append('\n');
////
////		      sb.append("1");
////		      sb.append(',');
////		      sb.append("Prashant Ghimire");
////		      sb.append('\n');
////
////		      writer.write(sb.toString());
////
////		      System.out.println("done!");
////
////		    } catch (FileNotFoundException e) {
////		      System.out.println(e.getMessage());
////		    }
////
////	
////		
////		TransportClient client = new PreBuiltTransportClient(Settings.EMPTY)
////		        .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300));
////
////		
////		
////									/* --> Indexing <--		*/
////		IndexResponse response = client.prepareIndex("hello1", "_doc", "1")
////		        .setSource(jsonBuilder()
////		                    .startObject()
////		                        .field("user", "done")
////		                        .field("postDate", new Date())
////		                        .field("message", "trying out Elasticsearch")
////		                    .endObject()
////		                  )
////		        
////		        .get();
////		
////		
////		IndexResponse response2 = client.prepareIndex("logista", "_doc", "2")
////		        .setSource(jsonBuilder()
////		                    .startObject()
////		                        .field("user", "done")
////		                        .field("postDate", new Date())
////		                        .field("message", "trying out Elasticsearch")
////		                    .endObject()
////		                  )
////		        
////		        .get();
////		
////		IndexResponse response3 = client.prepareIndex("salam", "_doc", "3")
////		        .setSource(jsonBuilder()
////		                    .startObject()
////		                        .field("user", "done")
////		                        .field("postDate", new Date())
////		                        .field("message", "trying out Elasticsearch")
////		                    .endObject()
////		                  )
////		        
////		        .get();
////		
////		
////		
////	
////		  }
//		 
//
//		
//
//
//			}}	
//	}
//}
