package ma.rentcom.test;


import java.io.IOException;
import java.net.InetAddress;

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

@RunWith(SpringRunner.class)
public class IntegrationTest2 {
	
	
	public TransportClient connec() throws IOException {
		String EsHost = "localhost";
		TransportClient client = new PreBuiltTransportClient(Settings.EMPTY)
		        .addTransportAddress(new TransportAddress(InetAddress.getByName(EsHost), 9300));
		
		return client;
	}
	
	
	
	public void QueryCarb(String carbur) throws IOException {
		
		String EsHost = "localhost";
				
				TransportClient client = new PreBuiltTransportClient(Settings.EMPTY)
				        .addTransportAddress(new TransportAddress(InetAddress.getByName(EsHost), 9300));
				
				QueryBuilder qb = QueryBuilders.queryStringQuery("carburant: '"+carbur+"' ");

				SearchResponse response = client.prepareSearch("carrs").setTypes("cars")
				    .setQuery(qb)
				    .execute().actionGet();
				client.close();
					System.out.println("###########Query#########"+response);
					
				}
	@Test
	public void getAllCar() throws IOException {
	/* 
	 * 
	 * config ES
	 */
		
		String carse = "Essence";
		QueryCarb(carse);
					
	}
	
	public TransportClient closeClient() throws IOException {
		TransportClient client = connec();
		client.close();
		System.out.println("Client closed");
		return client;
		
	}


	


}

