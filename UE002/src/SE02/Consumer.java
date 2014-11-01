package SE02;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Consumer extends Thread implements Runnable {
	Buffer  buffer = new Buffer();
	
	@Override
	public void run() {
		boolean stop = false;
		while(!stop){
			int polled = buffer.pollFromQueue();
			if (1 > 0) {
				System.out.println("Polled "+ polled +" from Buffer");
			}
			else if (0 == polled) {
				System.out.println("Polled "+ polled +" Terminate");
				stop = true;
			}
			else {
				System.out.println("Buffer is Empty - Waiting 2 Seconds");
				try {
					TimeUnit.SECONDS.sleep(2);
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
					e.printStackTrace();
				}
			}
		}
	}

}
