import java.util.*;

public class Lab08
{
  
  public static void main(String[] bubbles)
  {
    int days = Integer.parseInt(bubbles[2]);
    Vector dateV = new Vector();
    double prob = 1;
    String[] dateThing;
    String jnk, unit, label, inout;
    int freq, limit;
    int daytmp [3];
    int i = 0;
    Scanner fin = null;
    MyDate startDate = null, curDate;
    
    try{
      fin = new Scanner (new FileReader(bubbles[0]));
    }catch(IOException e){
      e.printStackTrace(); System.exit(1);
    }

    while(fin.hasNext()){
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
      startDate = makeDate(daytmp[2],daytmp[0],daytmp[1]);
      if(unit.equals("monthly")){
	dateV.add(new EventMonthly(freq,prob,inout,label,startDate));
      }
      else
	dateV.add(new EventDaily(freq,prob,inout,label,startDate));

      i++;
    }

    curDate = makeDate(2017,1,1);
    
    
    for(int j = 0; j < days; j++){
      for(int k = 0; k < i; k++){
	flag = 0;
	if(dateV[k].isHap(curDate)){
	  if(flag == 0){
	    System.out.print(currdate.toString() + ": ");
	  }
	  System.out.print(dateV[k].toString()+ ( ", ");
	}
      }
    }
    
