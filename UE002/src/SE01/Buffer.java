package SE01;

import java.util.LinkedList;
import java.util.Queue;

public class Buffer {
	private static Buffer instance = null;
	private static Queue<Integer> queue = new LinkedList<Integer>();
	
	protected Buffer() {
		// Exists only to defeat instantiation.
	}
	
	public static Buffer getInstance() {
		if(instance == null) {
			instance = new Buffer();
		}
		return instance;
	}
	
	public static synchronized void addToQueue(int a){
		queue.add(a);
	}
	
	public static synchronized int pollFromQueue(){
		if (queue.isEmpty()){
			return -1;
		} else {
			return queue.poll();
		}
	}
}
