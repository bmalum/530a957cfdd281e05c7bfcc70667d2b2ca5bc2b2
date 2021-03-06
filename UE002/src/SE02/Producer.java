package SE02;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Producer extends Thread{
	Buffer buffer = new Buffer();
	SharedData data = new SharedData();
	
	@Override
	public void run() {
		data.addBuffer(buffer);
		System.out.println("Producer started");
		int R = 0;
		int W = 0;
		int High_Gen = 101;
		int Low_Gen = 0;
		int High_Wait = 4;
		int Low_Wait = 0;	
		
		Random r = new Random();
		
		do{
			//System.out.println(data.getBufferList().size());
			R = r.nextInt(High_Gen-Low_Gen) + Low_Gen;
			W = r.nextInt(High_Wait-Low_Wait) + Low_Wait;
			try {
				TimeUnit.SECONDS.sleep(W);
			} catch (InterruptedException e) {
			    Thread.currentThread().interrupt();
				e.printStackTrace();
			} 
			if (R == 0) {
				System.out.println("Produced a 0 - so i will terminate now!");
			}
			else {
				System.out.println("Produced "+R+" - now i was sleeping for "+W+" Seconds");	
			}
			buffer.addToQueue(R);
		}while(R!=0);
		data.removeBuffer(buffer);
	}	
	
}
