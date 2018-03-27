import java.util.*;

public class ThreadPool{
	private List waitingThreads = new Vector();
	
	public void put(DelegatinThread thread){
		System.out.println("ThreadPool: Adding to pool of waiting threads "+thread);
		waitingThreads.add(thread);
	}
	
	public DelegatinThread get(){
		DelegatinThread availableThread = null;
		if (waitingThreads.size() != 0){
			availableThread = (DelegatinThread) waitingThreads.remove(0);
			System.out.println("ThreadPool: Removing from pool of waiting threads "+availableThread);
		}
		return availableThread;
	}
	
	static class DelegatinThread extends Thread{
		private Runnable _delegatee;
		public void setDelegatee(Runnable delegatee){
			System.out.println("ThreadPool: Setting  new Delegatin to thread");
			_delegatee = delegatee;
		}
		
		public void run(){
			_delegatee.run();
		}
	}
}
