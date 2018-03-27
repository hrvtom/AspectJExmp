public aspect ThreadPooling{
	ThreadPool pool = new ThreadPool();
	
	pointcut threadCreation(Runnable runnable)
	:call (Thread.new(Runnable)) && args(runnable);
	
	Thread around(Runnable runnable): threadCreation(runnable){
		ThreadPool.DelegatinThread availableThread = pool.get();
		if (availableThread == null){
			System.out.println("ThreadPooling: Creating new DelegatinThread by Aspect");
			availableThread = new ThreadPool.DelegatinThread();
		}else{
			System.out.println("ThreadPooling: Reusing DelegatinThread by Aspect "+availableThread);
		}
		
		availableThread.setDelegatee(runnable);
		return availableThread;
	}
	
	pointcut session(ThreadPool.DelegatinThread thread)
	: execution(void ThreadPool.DelegatinThread.run()) && this(thread);
	
	void around(ThreadPool.DelegatinThread thread) : session(thread){
		while(true){
			proceed(thread);
			pool.put(thread);
			synchronized(thread){
				try{
					System.out.println("ThreadPooling: Putting Thread to waiting by Aspect");
					thread.wait();
				}catch (InterruptedException ex){
				}
			}
		}
	}
	
	pointcut threadStart(ThreadPool.DelegatinThread thread)
	: call(void Thread.start()) && target(thread);
	
	void around (Thread thread) : threadStart(thread){
		if(thread.isAlive()){
			synchronized (thread){
				System.out.println("ThreadPooling: Waking up thread by Aspect");
				thread.notifyAll();
			}
		}else{
			proceed(thread);
		}
	}
	
}