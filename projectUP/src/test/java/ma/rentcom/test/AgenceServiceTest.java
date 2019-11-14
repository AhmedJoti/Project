//package ma.rentcom.test;
//
//
//
//import static org.hamcrest.CoreMatchers.is;
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//
//import java.util.List;
//
//import javax.faces.application.Application;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import ma.rentcom.model.entity.Book;
//import ma.rentcom.service.BookService;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = Application.class)
//public class AgenceServiceTest {
//    
//	 @Autowired
//	    private BookService bookService;
////    @Autowired
////    private AgenceService agenceService;
//
//    @Autowired
//    private ElasticsearchTemplate esTemplate;
//
//    @Before
//    public void before() {
//        esTemplate.deleteIndex(Book.class);
//        esTemplate.createIndex(Book.class);
//        esTemplate.putMapping(Book.class);
//        esTemplate.refresh(Book.class);
//    }
//
////    @Test
////    public void testSave() {
////         
////    	Agence agence = new Agence(9999L,"100fdf1", "Elasticsearch Basics", "Rambabu Posa");
////    	Agence testAgence = agenceService.save(agence);
////
////        assertNotNull(testAgence.getId());
////        assertEquals(testAgence.getNom(), agence.getNom());
////        assertEquals(testAgence.getAdresse(), agence.getAdresse());
////        assertEquals(testAgence.getEmail(), agence.getEmail());
////
////    }
//    @Test
//    public void testSave() {
//
//        Book book = new Book("1001", "Elasticsearch Basics", "Rambabu Posa", "23-FEB-2017");
//        Book testBook = bookService.save(book);
//
//        assertNotNull(testBook.getId());
//        assertEquals(testBook.getTitle(), book.getTitle());
//        assertEquals(testBook.getAuthor(), book.getAuthor());
//        assertEquals(testBook.getReleaseDate(), book.getReleaseDate());
//
//    }
//    
//    
//    
//    @Test
//    public void testFindById() {
//
//        Book book = new Book("1001", "Elasticsearch Basics", "Rambabu Posa", "23-FEB-2017");
//        bookService.save(book);
//
//        Book testBook = bookService.findById(book.getId());
//
//        assertNotNull(testBook.getId());
//        assertEquals(testBook.getTitle(), book.getTitle());
//        assertEquals(testBook.getAuthor(), book.getAuthor());
//        assertEquals(testBook.getReleaseDate(), book.getReleaseDate());
//
//    }
//    
////    @Test
////    public void testFindOne() {
////
////    	Agence agence = new Agence(9999L,"100fdf1", "Elasticsearch Basics", "Rambabu Posa");
////    	agenceService.save(agence);
////
////        Agence testAgence = agenceService.findById(agence.getId());
////
////        assertNotNull(testAgence.getId());
////        assertEquals(testAgence.getNom(), agence.getNom());
////        assertEquals(testAgence.getAdresse(), agence.getAdresse());
////        assertEquals(testAgence.getEmail(), agence.getEmail());
////
////    }
//
////    @Test
////    public void testFindByTitle() {
////
////    	Agence agence = new Agence(9999L,"100fdf1", "Elasticsearch Basics", "Rambabu Posa");
////    	agenceService.save(agence);
////        
////        List<Agence> byTitle = agenceService.findByEmail(agence.getEmail());
////        assertThat(byTitle.size(), is(1));
////    }
//
//    
//    @Test
//    public void testFindByTitle() {
//
//        Book book = new Book("1001", "Elasticsearch Basics", "Rambabu Posa", "23-FEB-2017");
//        bookService.save(book);
//
//        List<Book> byTitle = bookService.findByTitle(book.getTitle());
//        assertThat(byTitle.size(), is(1));
//    }
//    
//    
////    @Test
////    public void testFindByAuthor() {
////
////        List<Agence> agenceList = new ArrayList<>();
////
////        agenceList.add(new Agence(1001L, "Elasticsearch Basics", "Rambabu Posa", "23-FEB-2017"));
////        agenceList.add(new Agence(1002L, "Apache Lucene Basics", "Rambabu Posa", "13-MAR-2017"));
////        agenceList.add(new Agence(1003L, "Apache Solr Basics", "Rambabu Posa", "21-MAR-2017"));
////        agenceList.add(new Agence(1007L, "Spring Data + ElasticSearch", "Rambabu Posa", "01-APR-2017"));
////        agenceList.add(new Agence(1008L, "Spring Boot + MongoDB", "Mkyong", "25-FEB-2017"));
////
////        for (Agence agence : agenceList) {
////        	agenceService.save(agence);
////        }
////
////        Page<Agence> byNom = agenceService.findByNom("Rambabu Posa", PageRequest.of(0, 10));
////        assertThat(byNom.getTotalElements(), is(4L));
////
////        Page<Agence> byNom2 = agenceService.findByNom("Mkyong", PageRequest.of(0, 10));
////        assertThat(byNom2.getTotalElements(), is(1L));
////
////    }
//
////    @Test
////    public void testDelete() {
////
////    	Agence agence = new Agence(1001L, "Elasticsearch Basics", "Rambabu Posa", "23-FEB-2017");
////        agenceService.save(agence);
////        agenceService.remove(agence);
////        Agence testAgence = agenceService.findById(agence.getId());
////        assertNull(testAgence);
////    }
//
//}