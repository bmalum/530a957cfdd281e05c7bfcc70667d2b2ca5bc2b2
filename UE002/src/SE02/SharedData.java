package SE02;

import java.util.ArrayList;
import java.util.List;

public class SharedData {
	private static SharedData instance = null;
	private static List<Buffer> bufferList = new ArrayList<Buffer>();
		

	protected SharedData() {
		// Exists only to defeat instantiation.
	}
	
	public static SharedData getInstance() {
		if(instance == null) {
			instance = new SharedData();
		}
		return instance;
	}
	
	public void addBuffer(Buffer buffer){
		bufferList.add(buffer);
	}
	
	public void removeBuffer(Buffer buffer) {
		bufferList.remove(buffer);
	}

	public List<Buffer> getBufferList() {
		return bufferList;
	}
	
	public boolean startWatchDog() {
		boolean notify = true;
		for (int i = 0; i < bufferList.size(); i++) {
			notify = notify && !bufferList.get(i).check();
		}
		if (bufferList.size() == 0) {
			return false;
		}
		return notify;
	}
}
