package SE02;

import java.util.LinkedList;
import java.util.Queue;

public class Buffer {
	private  Queue<Integer> queue = new LinkedList<Integer>();
	SharedData data = new SharedData();

	public  synchronized void addToQueue(int a){
		queue.add(a);
	}
	
	public  synchronized int pollFromQueue(){
		if (queue.isEmpty()){
			return -1;
		}
		else if (queue.peek() == 0) {
			int tmp = queue.poll();
			data.removeBuffer(this);
			return tmp;
		}
		else {
			return queue.poll();
		}
	}
	
	public synchronized int  peek() {
		return queue.peek();
	}
	
	public boolean check(){
		return queue.isEmpty();
	}
}
