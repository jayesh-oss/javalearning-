public class CarModel extends CarCompany{

public void Details(){

 System.out.println("Model:Mk4");
 System.out.println("\nprice: 13 lakh");
 System.out.println("\nTwin-Turbo 3.0 liter Engine");
 System.out.println("\n320Hp");
 System.out.println("\nAccelerate 0 to 100km in 4.9sec");
 System.out.println("\nMax Speed 277Kmh");
 }

public static void main(String args[])
{
 CarModel model=new CarModel();
 model.Name();
 model.Company();
 model.Details();
}
}