package com.example.threading;

public class SleepExample implements Runnable{

	public static void main(String[] args) {
		Thread thread = new Thread(new SleepExample());
		thread.start();
		Thread thread1 = new Thread(new SleepExample());
		thread1.start();
	}

	@Override
	public void run() {
		for(int i=0;i<4;i++) {
			try {
				Thread.sleep(1000);
				System.out.println("child thread started:"+Thread.currentThread().getName());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
