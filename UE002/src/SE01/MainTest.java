package SE01;

public class MainTest {
	public static void main(String[] args){
		Runnable producer = new Producer();
		Runnable consumer = new Consumer();

		Thread producerthread = new Thread(producer);
		Thread consumerthread = new Thread(consumer);

		producerthread.start();
		consumerthread.start();
	}

}
