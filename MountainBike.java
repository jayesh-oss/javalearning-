public class MountainBike extends Bicycle{
int height;

static final String cName="Hero";
MountainBike(int seatHeight, int startSpeed, int startGear)
{
 super(startSpeed, startGear);
 height=seatHeight;
}

public static void main(String args[]){

MountainBike mb=new MountainBike(10,20,2);

System.out.printf("Company Name:"+cName);

System.out.printf("\nSeatHeight of the Bicycle:"+mb.height);
System.out.printf("\nSpeed of the Bicycle:"+mb.speed);
System.out.printf("\nsGear of the Bicycle:"+mb.gear);
}
}