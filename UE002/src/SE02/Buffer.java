package SE02;

import java.util.LinkedList;
import java.util.Queue;

public class Buffer {
	private  Queue<Integer> queue = new LinkedList<Integer>();
	
	public  synchronized void addToQueue(int a){
		queue.add(a);
	}
	
	public  synchronized int pollFromQueue(){
		if (queue.isEmpty()){
			return -1;
		} else {
			return queue.poll();
		}
	}
	
	public boolean check(){
		return queue.isEmpty();
	}
}
