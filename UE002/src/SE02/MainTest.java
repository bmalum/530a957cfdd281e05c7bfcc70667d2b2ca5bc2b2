package SE02;




public class MainTest extends Thread {

	public static void main(String[] args) throws InterruptedException{		
		Consumer b = new Consumer();
		Producer p = new Producer();
		SharedData data = new SharedData();


		p.start();
		b.start();

		Thread.sleep(6000);
		synchronized (b) {
			b.notify();
		}
		
		while (true) {
			if(data.startWatchDog()){
				synchronized (b) {
					//b.notify();
				}
			}
		}
	}

	
}
