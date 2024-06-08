package gadget;
import tool.*;
public class SmartPhone extends Mobile
{
public void userFor()
{
System.out.println("Smart Phone used for calling and other functionalities");
}
public static void main(String args[])
{
Mobile m=new Mobile();
m.usage();
SmartPhone sm= new SmartPhone();
sm.userFor();
}
}
