
public class TryCatchDemo 
{ 
  public static void main(String args [])
  {
    try
   {
    int arr[] = new int[5];
    arr [6] = 10/2;
    System.out.println("Result: "+arr[4]);
    }
  catch(Exception e )
{
  System.out.println("Exception is : "+e.getMessage());
 }
finally
{
 System.out.println("This program Exception Handling");
}

}
}