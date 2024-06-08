public class MethodOverload{
public String formatNumber(int value){
return String.format("%d",value);
}
public String formatNumber(double value){
return String.format("%.3f",value);
}
public String formatNumber(String value){
return String.format("%2f",Double.parseDouble(value));
}
public static void main(String args[]){
MethodOverload Method=new MethodOverload();
String function1=Method.formatNumber(1000);
String function2=Method.formatNumber(25.8765);
String function3=Method.formatNumber("4500");

System.out.println("Result of first method "+function1);
System.out.println("Result of second method "+function2);
System.out.println("Result of third method "+function3);
}
}