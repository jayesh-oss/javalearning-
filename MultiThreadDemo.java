class A extends Thread{
	public void run() {
		for(int i=1;i<=5;i++)
		{
			System.out.println("Thread"+i);
			try {
				sleep(1000);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class MultiThreadDemo {
	public static void main(String args[]) {
		A obj1=new A();
		obj1.start();
		System.out.println(obj1.isAlive());
		System.out.println("MultiThreading helps to achiveve Multitasking");
	}
}
