import java.text.SimpleDateFormat;
import java.util.*;
class Solution{

    public int solution(int Y,String A,String B,String W) throws Exception{
	//getting the starting day for the A month
        int day=getStartMonthDay(Y,A,W);
	//calculating total days between months
        int totalDays=calculateDays(Y,A,B);
	//returning number of weeks john can stay
        return (totalDays+day-8)/7;
    }

    public int calculateDays(int Y,String A,String B){
    int totalDays=0;
    int a=getMonth(A);
    int b=getMonth(B);
    for(int i=a;i<=b;i++)
    totalDays+=getMonthDays(i);
    return totalDays;
    }

    public static void main(String args[]) throws Exception{
     int Y=Integer.parseInt(args[0]);
     String A=args[1];
     String B=args[2];
     String W=args[3];
     Solution sol= new Solution(); 
     System.out.println(sol.solution(Y, A, B, W));  
    }



    public int getStartMonthDay(int Y,String A,String W)throws Exception{
        int oddDays[]={0,3,0,3,2,3,2,3,3,2,3,2,3};
        int totalOdds=0;
        if (Y%4==0 && Y%100!=0|| Y%400==0) oddDays[2]=1;
        int monthNo=getMonth(A);
        for(int i=1;i<monthNo;i++)
            totalOdds+=oddDays[i];
        totalOdds=totalOdds%7;
        int firstDay=getDay(W);
       int  startday=(firstDay+totalOdds)%7;
       return startday;
    }

    public int getMonth(String month)
    {
        HashMap<String,Integer> hm=new HashMap<>();
        hm.put("Januvary",1);
        hm.put("Febuvary",2);
        hm.put("March",3);
        hm.put("April",4);
        hm.put("May",5);
        hm.put("June",6);
        hm.put("July",7);
        hm.put("August",8);
        hm.put("September",9);
        hm.put("October",10);
        hm.put("November",11);
        hm.put("December",12);
        return (int)hm.get(month);
    }

    public int getDay(String day)
    {
        HashMap<String,Integer> hm=new HashMap<>();
        hm.put("Monday",1);
        hm.put("Tuesday",2);
        hm.put("Wednesday",3);
        hm.put("Thursday",4);
        hm.put("Friday",5);
        hm.put("Saturday",6);
        hm.put("Sunday",7);
        return (int)hm.get(day);
    }
    public int getMonthDays(int month)
    {
        HashMap<Integer,Integer> hm=new HashMap<>();
        hm.put(1,31);
        hm.put(2,28);
        hm.put(3,31);
        hm.put(4,30);
        hm.put(5,31);
        hm.put(6,30);
        hm.put(7,31);
        hm.put(8,31);
        hm.put(9,30);
        hm.put(10,31);
        hm.put(11,30);
        hm.put(12,31);
        return (int)hm.get(month);
    }

 
}
