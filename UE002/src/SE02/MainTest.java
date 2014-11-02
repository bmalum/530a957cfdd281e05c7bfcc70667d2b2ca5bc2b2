package SE02;




public class MainTest extends Thread {

	public static void main(String[] args) throws InterruptedException{		
		Producer p = new Producer();
		Producer p2 = new Producer();

		SharedData data = new SharedData();

		p2.start();
		p.start();
		Consumer b = new Consumer();
		b.start();

		Thread.sleep(6000);
		synchronized (b) {
			b.notify();
		}
		
		while (true) {
			if(data.startWatchDog()){
				synchronized (b) {
					b.notify();
				}
			}
		}
	}

	
}
