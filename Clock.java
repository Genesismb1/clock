/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classjavafiles;
import java.util.Scanner;

/**
 *
 * @author monikabhatt
 */
class Clock {
    int hours, minutes, seconds;
    
    protected Clock(){
    }
    
    protected Clock(int hours, int minutes, int seconds){
        this.hours=hours;
        this.minutes=minutes;
        this.seconds=seconds;
    }
    
    protected Clock(int valSeconds){
        hours=(int)(valSeconds/3600);
        minutes=(int)((valSeconds%3600)/60);
        seconds=((valSeconds%3600)%60);
    }
    
    protected void tick(){
        seconds++;
        int extraHour=0, extraMinute=0, extraSecond=0;
        if(seconds>=60){
            extraMinute=seconds/60;
            seconds=seconds%60;
        }
        minutes=minutes+extraMinute;
        if(minutes>=60){
            extraHour=minutes/60;
            minutes=minutes%60;
        }
        hours=hours+extraHour;
    }
    
    protected void addClock(Clock A, Clock B){
        int extraHour=0, extraMinute=0;
        seconds=A.seconds+B.seconds;
        if(seconds>=60){
            extraMinute=seconds/60;
            seconds=seconds%60;
        }
        minutes=A.minutes+B.minutes+extraMinute;
        if(minutes>=60){
            extraHour=minutes/60;
            minutes=minutes%60;
        }
        hours=A.hours+B.hours+extraHour;
        if(hours>23){
            hours=hours-24;
        }
    }
    
    public String toString(){
    String str1=Integer.toString(hours);
    String str2=Integer.toString(minutes);
    String str3=Integer.toString(seconds);
    return str1+ ":" +str2 + ":" + str3;
    }
    
    protected void tickDown(){
        seconds--;
        if(seconds<0){
            seconds=59;
            minutes--;
        }
        if(minutes<0){
            minutes=59;
            hours--;
        }
        if(hours<0){
            hours=23;
        }
    }
    
    protected void subtractClock(Clock A, Clock B){
        seconds=A.seconds-B.seconds;
        minutes=A.minutes-B.minutes;
        hours=A.hours-B.hours;
        if(seconds<0){
            seconds=60+seconds;
        }
        if(minutes<0){
            minutes=60+minutes;
        }
        if(hours<0){
            hours=24+hours;
        }
    }
}
        
class ClockDemo extends Clock{
        public static void main(String args[]){
            int hour=0, minute=0, second=0;
            Scanner scan=new Scanner(System.in);
            
            System.out.println("Enter a value in seconds to convert to minutes and hours: ");
            Clock firstClock=new Clock(exceptionCheck(scan));
            System.out.println("You entered: " + firstClock.toString());
            
            System.out.println("Enter the number of seconds that you want the clock to add: ");
            int enteredSecs=exceptionCheck(scan);
            for(int i=0;i<enteredSecs;i++){
                firstClock.tick();
            }
            System.out.println("The clock value after addition is: " + firstClock.toString());
            
            System.out.println("Enter the number of seconds that you want the clock to subtract: ");
            enteredSecs=exceptionCheck(scan);
            for(int i=0;i<enteredSecs;i++){
                firstClock.tickDown();
            }
            System.out.println("The clock value after subtraction is: " + firstClock.toString());
            
            System.out.println("Enter the hours, minutes, and seconds that you want to add and subtract from this time: ");
            char repeat='y';
            do{
               hour=exceptionCheck(scan);
               if (hour>23){
                   System.out.println("Enter hour between 0 to 23");
               }
               else{
                   repeat='n';
               }   
            }
            while(repeat=='y');
            repeat='y';
            do{
               minute=exceptionCheck(scan);
               if (minute>60){
                   System.out.println("Enter hour between 0 to 23");
               }
               else{
                   repeat='n';
               }   
            }
            while(repeat=='y');
            repeat='y';
            do{
               second=exceptionCheck(scan);
               if (second>60){
                   System.out.println("Enter hour between 0 to 23");
               }
               else{
                   repeat='n';
               }   
            }
            while(repeat=='y');
            
            Clock secondClock=new Clock(hour,minute,second);
            
            System.out.println("You entered: " + secondClock.toString());
            
            Clock thirdClock=new Clock();
            thirdClock.subtractClock(firstClock,secondClock);
            System.out.println("The subtraction between the times: " + thirdClock.toString());
            thirdClock.addClock(firstClock, secondClock);
            System.out.println("The addition between the times: " + thirdClock.toString());
        }
        
        static int exceptionCheck(Scanner scan){
            int val=0;
            char repeat='y';
            do{
                try{
                   val=scan.nextInt();
                   if(val<0){
                       System.out.println("Enter positive number");
                   }
                   else repeat='n';
                }
                catch(Exception e){
                    System.out.println("Enter valid integer");
                    scan.next();
                }
            }while(repeat=='y');
                return val;
            
        }
 }

