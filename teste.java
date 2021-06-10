/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programa;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author igor_
 */
public class teste {
    SimpleDateFormat f1 = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy, HH:mm:ss");
	SimpleDateFormat f2 = new SimpleDateFormat("dd/MM/yy - HH:mm:ss Z");           
	SimpleDateFormat f3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");             
	SimpleDateFormat f4 = new SimpleDateFormat("EEEE, dd 'de' MMMM 'de' yyyy");    
	SimpleDateFormat f5 = new SimpleDateFormat("HH:mm:ss.SSS z");                  
	SimpleDateFormat f6 = new SimpleDateFormat("EEE dd MMM, HH:mm");   
        
        Calendar now = Calendar.getInstance();
        
	System.out.println(f1.format(now.getTime()));                                  
	System.out.println(f2.format(now.getTime()));                                  
	System.out.println(f3.format(now.getTime()));                                  
	System.out.println(f4.format(now.getTime()));                                  
	System.out.println(f5.format(now.getTime()));                                  
	System.out.println(f6.format(now.getTime()));  
    
}
