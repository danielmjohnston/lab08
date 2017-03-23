//Dan Brandon and Alejandra
import java.util.*;
import java.io.*;

public class Lab08
{
  
  public static void main(String[] bubbles)
  {
    int days = Integer.parseInt(bubbles[1]);
    Event[] dateV = new Event[9999];
    //Vector dateV = new Vector();
    double prob = 1;
    String[] dateThing;
    String jnk, unit, label, inout;
    int freq, limit;
    int[] daytmp = new int [3];
    int i = 0;
    Scanner fin = null;
    MyDate startDate = null, curDate;
    
    try{//create reader to the file
      fin = new Scanner (new FileReader(bubbles[0]));
    }catch(IOException e){
      e.printStackTrace(); System.exit(1);
    }

    while(fin.hasNext()){//read everything in
      jnk = fin.next();
      freq = fin.nextInt();
      unit = fin.next();
      jnk = fin.next();
      if(jnk.equals("for")){
	limit = fin.nextInt();
	jnk = fin.next();
      }
      jnk = fin.next();
      dateThing = jnk.split("/");
      for(int j = 0; j < 3; j++)
	daytmp[j] = Integer.parseInt(dateThing[j]); 
      inout = fin.next();
      if(inout.equals("prob")){
	prob = fin.nextDouble();
	inout = fin.next();
      }
      label = fin.nextLine();
      startDate = MyDate.makeDate(daytmp[2],daytmp[0],daytmp[1]);
      if(unit.equals("months")){
	  dateV[i] = new EventMonthly(freq,prob,inout,label,startDate);
	//dateV.add(new EventMonthly(freq,prob,inout,label,startDate));
      }
      else
	  dateV[i] = new EventDaily(freq,prob,inout,label,startDate);
      //dateV.add(new EventDaily(freq,prob,inout,label,startDate));

      i++;//how many things we have
    }

    //Start date is hard coded
    curDate = MyDate.makeDate(2017,1,1);
    
    
    //Go through everything and do it (or not)
    for(int j = 0; j < days; j++){
      int flag = 0;
      for(int k = 0; k < i; k++){
        //System.out.println(curDate.toString());
	if((dateV[k]).isHap(curDate)){
	  if(flag == 0){
	      System.out.print(curDate.toString() + ":" + dateV[k].printString());
	      flag++;
	  }
	  else{
	      System.out.print(( ",") + dateV[k].printString());
	  }
	}
	if(k+1 == i && flag > 0){System.out.println();}
      }
      
      curDate.incDay(1);
    }
  }
}

































