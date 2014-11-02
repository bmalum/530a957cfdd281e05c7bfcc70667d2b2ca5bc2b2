package SE02;

import java.util.ArrayList;
import java.util.List;

public class Consumer extends Thread{
	SharedData data = new SharedData();
	List<Integer> result = new ArrayList<Integer>();
	private boolean stop = false;
	
	@Override
	public void run() {
		synchronized (this) {
		
		System.out.println("Customer started wit ID:" + getId());
		while(!stop){
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				List<Buffer> bufferlist = data.getBufferList();
				bufferContent(bufferlist);
				System.out.println("Got Numbers" + result.toString());
			}
			
		}
	}
	
	public List<Integer> bufferContent(List<Buffer> tmp) {		
		for (int i = 0; i < tmp.size(); i++) {
			if(tmp.size() == 0){
				stop = false;
			}
			else if (tmp.get(i).peek() > 0) {
				result.add(tmp.get(i).pollFromQueue());
			}
			else {
				System.out.println("da is was schief gegangen");
			}
		}
		System.out.println(result);
		return result;
	}

}
