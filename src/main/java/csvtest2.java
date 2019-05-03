
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;


public class csvtest2 {

	 static List<Date> endDatecon = new ArrayList<Date>();
	 static List<String> clin=new ArrayList<String>();
	 static  List<Date> stDatecon = new ArrayList<Date>();
	 static List<String> d=new ArrayList<String>();
	 static List<String> d1=new ArrayList<String>();
     static List<String> c=new ArrayList<String>();
     static List<String> price=new ArrayList<String>();
     static List<String> fprice=new ArrayList<String>();
     static String CLIN_number=null;
     static String PriceSelected=null;
     

       
     //  public static void main(String[] args) throws IOException, ParseException {
           public static String pricecheckforclin(String CSV_FILE_PATH) throws IOException, ParseException   {
              try (
                          Reader reader = Files.newBufferedReader(Paths.get(CSV_FILE_PATH));
                          CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                                  .withHeader("clin", "case_number", "task_order_number", "country_jurs_id","price","price_start_date","price_stop_date","mod_id")
                                  .withIgnoreHeaderCase()
                                  .withTrim());
                      ) {
                          for (CSVRecord csvRecord : csvParser) {
                              // Accessing values by the names assigned to each column
                              String name = csvRecord.get("clin");
                         	   c.add(name);         
                              String price1 = csvRecord.get("price");
                              price.add(price1);
                              String price_start_date = csvRecord.get("price_start_date");
                              d.add(price_start_date);
                              String price_stop_date = csvRecord.get("price_stop_date");
                              d1.add(price_stop_date);                            
                          }
                      //}
              
              //to ignore the Headers
              for(int i=1;i<price.size();i++) {
              	 fprice.add(price.get(i));
               }
              
              for(int i=1;i<c.size();i++) {
             	 clin.add(c.get(i));
              }
                 for(int i=1;i<d.size();i++) {
          		 String s=d.get(i);
          		 Date date1=new SimpleDateFormat("MM/dd/yyyy").parse(s);
          		 stDatecon.add(date1);
          	  }
          	  
         	  for(int i=1;i<d1.size();i++) {
         		 String s=d1.get(i);
         		 Date date1=new SimpleDateFormat("MM/dd/yyyy").parse(s);
         		 endDatecon.add(date1);
         	  }
         	  
         	  System.out.println("size of clin:"+clin.size());
         	  System.out.println("Size of start date"+ stDatecon.size());
         	  System.out.println("Size of end date "+endDatecon.size());
               	  
                  
              
       DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		System.out.println("current date :"+dateFormat.format(date));
		//String currentdate=dateFormat.format(date);
	    Date date11=new SimpleDateFormat("MM/dd/yyyy").parse(dateFormat.format(date));
	    System.out.println("FInal current date:"+date11);
   	    System.out.println("Size of start date"+ stDatecon.size());
   	    System.out.println("********"+stDatecon.get(0));
		for(int i=0;i<stDatecon.size();i++) {
			 Date test1=stDatecon.get(i);
				if(test1.compareTo(date11) <=0){		
					Date test2=endDatecon.get(i);
				if(test2.compareTo(date11)>=0) {
					System.out.println(stDatecon.get(i));
					System.out.println(endDatecon.get(i));
					CLIN_number =clin.get(i);
					System.out.println(clin.get(i));
					PriceSelected=fprice.get(i);
					System.out.println(fprice.get(i));
					System.out.println("#######################");
					break;
				}
				}
				        			
        		}
		}
              
       double finalPrice=Double.parseDouble(PriceSelected)+((4.75*Double.parseDouble(PriceSelected))/100);
      // System.out.println("Final price :"+finalPrice);
       //System.out.println(String.valueOf(finalPrice));
       return String.valueOf(finalPrice);
              
       }
           
           public static void main(String[] args) throws IOException, ParseException {
               final String CSV_FILE_PATH = "C:\\Users\\AB54030\\Music\\CABLE_WIRING_FEATURES_charge_mods.csv";

        	 String pricefromCSV= pricecheckforclin(CSV_FILE_PATH);
        	 System.out.println("pricefromCSV: "+pricefromCSV);
           }
}
