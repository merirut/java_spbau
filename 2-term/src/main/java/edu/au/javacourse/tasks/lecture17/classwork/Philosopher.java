package edu.au.javacourse.tasks.lecture17.classwork;

import java.util.Random;

public class Philosopher extends Thread {

	private static final int ACTION_DURATION_LIMIT = 2000;

	private final String name;
	private final Fork firstFork;
	private final Fork secondFork;
	private final Random random = new java.util.Random();


	public Philosopher(String name, Fork leftFork, Fork rightFork, boolean reversed) {
		this.name = name;
        if (reversed) {
            this.firstFork = rightFork;
            this.secondFork = leftFork;
        } else {
            this.firstFork = leftFork;
            this.secondFork = rightFork;
        }
	}

	@Override
	public void run() {
		while (true) {
			try {
				doAction(name + ": размышляю.");

				synchronized (firstFork) {
                    doAction(name + ": беру первую вилку " + firstFork.getName() + ".");
                    synchronized (secondFork) {
						doAction(name + ": беру вторую вилку " + secondFork.getName() + ".");
						doAction(name + ": ем.");
						doAction(name + ": кладу вторую вилку " + secondFork.getName() + ".");
					}
                    doAction(name + ": кладу первую вилку " + firstFork.getName() + ".");
                }
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void doAction(String action) throws InterruptedException {
		System.out.println(action);
		sleep(random.nextInt(ACTION_DURATION_LIMIT));
	}
}
