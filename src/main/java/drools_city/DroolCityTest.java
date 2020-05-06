//package drools_city;
//import java.math.BigDecimal;
//
////import org.drools.KnowledgeBase;
//import org.drools.KnowledgeBaseFactory;
//import org.drools.builder.KnowledgeBuilder;
//import org.drools.builder.KnowledgeBuilderError;
//import org.drools.builder.KnowledgeBuilderErrors;
//import org.drools.builder.KnowledgeBuilderFactory;
//import org.drools.builder.ResourceType;
//import org.drools.io.ResourceFactory;
//import org.drools.runtime.StatefulKnowledgeSession;
//
//import drools_city.CityModel.City;
//import drools_city.CityModel.Type;
//
//public class DroolCityTest {
//
//
//	/* 
//	   *This is a sample class to launch a rule. 
//	*/
//
//
//	   public static final void main(String[] args) {
//	      try {
//	         // load up the knowledge base
//	         KnowledgeBase kbase = readKnowledgeBase();
//	         StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
//	         
//	         CityModel item1 = new CityModel();
//	         item1.setPurchaseCity(City.PUNE);
//	         item1.setTypeofItem(Type.MEDICINES);
//	         item1.setSellPrice(new BigDecimal(10));
//	         ksession.insert(item1);
//	         
//	         CityModel item2 = new CityModel();
//	         item2.setPurchaseCity(City.PUNE);
//	         item2.setTypeofItem(Type.GROCERIES);
//	         item2.setSellPrice(new BigDecimal(10));
//	         ksession.insert(item2);
//	         
//	         CityModel item3 = new CityModel();
//	         item3.setPurchaseCity(City.NAGPUR);
//	         item3.setTypeofItem(Type.MEDICINES);
//	         item3.setSellPrice(new BigDecimal(10));
//	         ksession.insert(item3);
//	         
//	         CityModel item4 = new CityModel();
//	         item4.setPurchaseCity(City.NAGPUR);
//	         item4.setTypeofItem(Type.GROCERIES);
//	         item4.setSellPrice(new BigDecimal(10));         
//	         ksession.insert(item4);
//	         
//	         ksession.fireAllRules();
//	         
//	         System.out.println(item1.getPurchaseCity().toString() + " " 
//	            + item1.getLocalTax().intValue());
//	         
//	         System.out.println(item2.getPurchaseCity().toString() + " "
//	            + item2.getLocalTax().intValue());
//	         
//	         System.out.println(item3.getPurchaseCity().toString() + " "
//	            + item3.getLocalTax().intValue());
//	         
//	         System.out.println(item4.getPurchaseCity().toString() + " "
//	            + item4.getLocalTax().intValue());
//	                            
//	      } catch (Throwable t) {
//	         t.printStackTrace();
//	      }
//	   }
//	   private static KnowledgeBase readKnowledgeBase() throws Exception {
//	      KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
//	      kbuilder.add(ResourceFactory.newClassPathResource("Pune.drl"), ResourceType.DRL);
//	      kbuilder.add(ResourceFactory.newClassPathResource("Nagpur.drl"), ResourceType.DRL);
//	      KnowledgeBuilderErrors errors = kbuilder.getErrors();
//	      
//	      if (errors.size() > 0) {
//	         for (KnowledgeBuilderError error: errors) {
//	            System.err.println(error);
//	         }
//	         throw new IllegalArgumentException("Could not parse knowledge.");
//	      }
//	      KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
//	      kbase.addPackages(kbuilder.getKnowledgePackages());
//	      return kbase;
//	   }
//	}