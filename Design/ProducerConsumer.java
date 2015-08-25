package Design;

import java.util.LinkedList;
import java.util.Queue;

class ProducerConsumer{
	
	public static void main(String args[]){
		SyncResourcePool pool = new SyncResourcePool();
		Producer producer = new Producer(pool);
		Consumer consumer = new Consumer(pool);
		Thread tp = new Thread(producer);
		Thread tc = new Thread(consumer);
		tp.start();
		tc.start();
	}

}

class Producer implements Runnable{
	private SyncResourcePool pool = new SyncResourcePool();
	public Producer(SyncResourcePool pool){
		this.pool = pool;
	}
	
	int count = 0;
	public void produce(){
		Token item = new Token(count, System.currentTimeMillis());
		count++;
		System.out.println("Producer produced a token. <" + item.id + ", " + item.value + ">");
		pool.push(item);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			produce();
			try {
				Thread.sleep((long) (Math.random() * 1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}

class Consumer implements Runnable{
	SyncResourcePool pool = new SyncResourcePool();
	
	public Consumer(SyncResourcePool pool){
		this.pool = pool;
	}
	
	public void consume(){
		Token item = pool.poll();
		System.out.println("Consumer consume a token. <" + item.id + ", " + item.value + ">");
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			consume();
			try {
				Thread.sleep((long) (Math.random() * 1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}


class SyncResourcePool{
	Queue<Token> pool = new LinkedList<Token>();
	private final static int MAX_SIZE = 20;
	
	public synchronized void push(Token t){
		while(pool.size() == MAX_SIZE){
			System.out.println("Resourse Pool is Full! Please Wait!");
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		notify();
		pool.add(t);
	}  
	
	public synchronized Token poll(){
		while(pool.size() == 0){
			System.out.println("Resourse Pool is Empty! Please Wait!");
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		notify();
		return pool.poll();
	}
}

class Token{
	int id;
	long value;
	
	public Token(int id, long v){
		this.id = id;
		this.value = v;
	}
}
