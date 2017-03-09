import java.util.*;

public class Lab08
{
  
  public static void main(String[] bubbles)
  {
    Vector dateV = new Vector();
    double prob = 1;
    String[] dateThing;
    String jnk, unit, label, inout;
    int freq, limit;
    int daytmp [3];
    int i = 0;
    Scanner fin = null;
    MyDate startDate = null;
    
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
	dateV.add(new eventMonthly(freq,prob,inout,label,startDate));
      }
      else
	datV.add(new eventDaily(freq,prob,inout,label,startDate));

      i++;
    }	