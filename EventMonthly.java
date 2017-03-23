import java.util.*;
public class EventMonthly extends Event {
  int PrevMonth = 0;
  //Random Rand = new Random();
  EventMonthly(int frequency, double probability, String InsOuts, String lab, MyDate start){
    this.freq = frequency;
    this.prob = probability;
    this.isExpense = InsOuts.equals("expense");
    this.label = lab;
    this.startDate = start;
}

  void step(MyDate curDate){
    if(curDate.getMonth() != PrevMonth){
       count++;
       PrevMonth = curDate.getMonth();
    }
  }
  boolean isHap(MyDate curDate){
    //check the probability and see if the event is run
      if(curDate.getMonth() != PrevMonth){
	  count++;
	  PrevMonth = curDate.getMonth();
      }
      
      if(startDate.daysUntil(curDate) >=  0){
	  // System.out.println(curDate.getDay() + " " + startDate.getDay() + " "
	  //		     + count + " " + freq);
	  if(curDate.getDay() == startDate.getDay() && count >= freq){
	      count = 0;
	      if(Rand.nextDouble() <= prob){
		  return true;
	      }
	  }
      }
    return false;
  }

  String printString(){
    return label;
  }
}
