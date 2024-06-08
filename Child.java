public class Child extends Parent
{
 public void career()
 {
  System.out.println("In Child ");
  System.out.println("youtuber");
 }
 public static void main(String args[])
 {
   Child ch=new Child();
   ch.career();
   Parent p=new Parent();
   p.career();
 }
}