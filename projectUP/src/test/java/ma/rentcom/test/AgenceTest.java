package ma.rentcom.test;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.util.ArrayList;

import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import ma.rentcom.model.entity.Agence;
@RunWith(SpringRunner.class)
public class AgenceTest {

	
	


		
		@Test
		public void getAllCar() throws IOException {
			Agence agence = new Agence();

			ArrayList<Agence> rows = new ArrayList<>();
			FileWriter csvWriter = new FileWriter("c:/csv/tes987989.csv")   ;

			csvWriter.append("Id");
			csvWriter.append(',');
			csvWriter.append("Name");
			csvWriter.append(',');
			csvWriter.append('\n');
	      
			
		
				 for(int i  = 0 ; i <= 80 ; i++) {
						
						if(i <40) {
							
							Long id = (long) i ;
							agence.setId(id);
							agence.setNom("Logista");
							rows.add(agence);

							
						}else {
							
							Long id = (long) i ;
							agence.setId(id);

							agence.setNom("Rentcom");
							rows.add(agence);
						}
				     
						
						
						csvWriter.append(agence.getId()+","+agence.getNom()+",");
					    csvWriter.append("\n");

					    TransportClient client = new PreBuiltTransportClient(Settings.EMPTY)
						        .addTransportAddress(new TransportAddress(InetAddress.getByName("localhost"), 9300));
				
						
						IndexResponse agencee = client.prepareIndex("agences", "a", agence.getId()+"")
						        .setSource(jsonBuilder()
						                    .startObject()
						                    .field("nom", agence.getNom())
					                        .field("Id",agence.getId())
						                    .endObject()
						                  )
						        
						        .get();
				     }
					System.out.println("#############################ok");

					
		    
				
		
			
		    csvWriter.flush();
			csvWriter.close();
			
//			QueryBuilder qb = QueryBuilders.queryStringQuery("nom: rentcom AND Id :60");
//
//			SearchResponse response = client.prepareSearch("agences").setTypes("agences")
//			    .setQuery(qb)
//			    
//			    .execute().actionGet();
//				System.out.println(response);
//
////					
//			client.close();
//		}
//
	}}
