import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class test {

	public static void main(String[] args) throws ParseException {

		String s="10/1/2018" ;
		Date date1=new SimpleDateFormat("MM/dd/yyyy").parse(s);
		System.out.println(date1);
		
		String s1="9/30/2019" ;
		Date date2=new SimpleDateFormat("MM/dd/yyyy").parse(s1);
		System.out.println(date2);
		
		/*DateFormat date2=new SimpleDateFormat("MM/dd/yyyy");
		System.out.println(date2.format(date1));*/
		
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		System.out.println("current date :"+dateFormat.format(date));
		Date date11=new SimpleDateFormat("MM/dd/yyyy").parse(dateFormat.format(date));
		System.out.println(date11);
		
		int test=date1.compareTo(date11) * date2.compareTo(date11);
		System.out.println(test);
		if(date11.compareTo(date1) >=0)  {
			if(date11.compareTo(date2)<=0) {
			System.out.println("DATE In Range");
			}
		}

		
	}

}
