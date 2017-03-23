import java.util.*;
public class EventDaily extends Event {
  EventDaily(int frequency, double probability, String InsOuts, String lab, MyDate start){
    this.freq = frequency;
    this.prob = probability;
    this.label = lab;
    this.startDate = start;
}
    void step(MyDate swag){}

  boolean isHap(MyDate curDate){
      count++;
      if(startDate.daysUntil(curDate) >= 0){
	if(count >= freq){
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
