package com.example.threading;

//Example that shows multiple threads
//can execute the same method but in
//synchronized way.
class Line
{

	// if multiple threads(trains) trying to access
	// this synchronized method on the same Object
	// but only one thread will be able
	// to execute it at a time.
	synchronized public void getLine()
	{
	    //Thread t new Thread();
		int destination =3;
		for (int start = 0; start < destination; start++)
		{
			System.out.println(Thread.currentThread().getName()+" "+start+ " km" +" on single line");
			try
			{
				Thread.sleep(400);
			}
			catch (Exception e)
			{
				System.out.println(e);
			}
		}
	}
	
	public void getLineWithoutSynchronization()
    {
        for (int i = 0; i < 3; i++)
        {
        	System.out.println(Thread.currentThread().getName()+" "+i+ " km" +" on single line");
            try
            {
                Thread.sleep(400);
            }
            catch (Exception e)
            {
                System.out.println(e);
            }
        }
    }
}

class Train extends Thread
{
	// Reference variable of type Line.
	Line line;

	Train(Line line)
	{
		this.line = line;
	}

	@Override
	public void run()
	{
		line.getLine();
		//line.getLineWithoutSynchronization();
	}
}

class SyncronizationEx2
{
	public static void main(String[] args)
	{
		Line obj = new Line();

		// we are creating two threads which share
		// same Object.
		Train train1 = new Train(obj);
		Train train2 = new Train(obj);

		// both threads start executing 
		train1.setName("Rajdhani Express completes");
		train2.setName("garib rath completes");
		train1.start();
		train2.start();
	}
}
