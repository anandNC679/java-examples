package com.example.threading;


class Sender{
	public void send(String msg) throws InterruptedException {
		System.out.println("msg is sending:" + msg);
		Thread.sleep(1000);
		System.out.println(msg+" sent:");
	}
}

class ThreadedSend extends Thread{
	private String msg;
	Sender sender;
	ThreadedSend(String msg,Sender sender) {
		this.msg=msg;
		this.sender=sender;
	}
	public void run() {
		synchronized (sender) {
			try {
				sender.send(msg);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
public class SynchronizationExample {

	public static void main(String[] args) {
		Sender sender = new Sender();
		ThreadedSend t1= new ThreadedSend("Hi", sender);
		ThreadedSend t2= new ThreadedSend("World", sender);
		
		t1.start();
		t2.start();
		
		try {
			t1.join();t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
