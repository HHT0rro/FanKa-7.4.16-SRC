package java.util;

import dalvik.annotation.optimization.ReachabilitySensitive;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class Timer {
    private static final AtomicInteger nextSerialNumber = new AtomicInteger(0);

    @ReachabilitySensitive
    private final TaskQueue queue;

    @ReachabilitySensitive
    private final TimerThread thread;
    private final Object threadReaper;

    private static int serialNumber() {
        return nextSerialNumber.getAndIncrement();
    }

    public Timer() {
        this("Timer-" + serialNumber());
    }

    public Timer(boolean isDaemon) {
        this("Timer-" + serialNumber(), isDaemon);
    }

    public Timer(String name) {
        TaskQueue taskQueue = new TaskQueue();
        this.queue = taskQueue;
        TimerThread timerThread = new TimerThread(taskQueue);
        this.thread = timerThread;
        this.threadReaper = new Object() { // from class: java.util.Timer.1
            protected void finalize() throws Throwable {
                synchronized (Timer.this.queue) {
                    Timer.this.thread.newTasksMayBeScheduled = false;
                    Timer.this.queue.notify();
                }
            }
        };
        timerThread.setName(name);
        timerThread.start();
    }

    public Timer(String name, boolean isDaemon) {
        TaskQueue taskQueue = new TaskQueue();
        this.queue = taskQueue;
        TimerThread timerThread = new TimerThread(taskQueue);
        this.thread = timerThread;
        this.threadReaper = new Object() { // from class: java.util.Timer.1
            protected void finalize() throws Throwable {
                synchronized (Timer.this.queue) {
                    Timer.this.thread.newTasksMayBeScheduled = false;
                    Timer.this.queue.notify();
                }
            }
        };
        timerThread.setName(name);
        timerThread.setDaemon(isDaemon);
        timerThread.start();
    }

    public void schedule(TimerTask task, long delay) {
        if (delay < 0) {
            throw new IllegalArgumentException("Negative delay.");
        }
        sched(task, System.currentTimeMillis() + delay, 0L);
    }

    public void schedule(TimerTask task, Date time) {
        sched(task, time.getTime(), 0L);
    }

    public void schedule(TimerTask task, long delay, long period) {
        if (delay < 0) {
            throw new IllegalArgumentException("Negative delay.");
        }
        if (period <= 0) {
            throw new IllegalArgumentException("Non-positive period.");
        }
        sched(task, System.currentTimeMillis() + delay, -period);
    }

    public void schedule(TimerTask task, Date firstTime, long period) {
        if (period <= 0) {
            throw new IllegalArgumentException("Non-positive period.");
        }
        sched(task, firstTime.getTime(), -period);
    }

    public void scheduleAtFixedRate(TimerTask task, long delay, long period) {
        if (delay < 0) {
            throw new IllegalArgumentException("Negative delay.");
        }
        if (period <= 0) {
            throw new IllegalArgumentException("Non-positive period.");
        }
        sched(task, System.currentTimeMillis() + delay, period);
    }

    public void scheduleAtFixedRate(TimerTask task, Date firstTime, long period) {
        if (period <= 0) {
            throw new IllegalArgumentException("Non-positive period.");
        }
        sched(task, firstTime.getTime(), period);
    }

    private void sched(TimerTask task, long time, long period) {
        long period2;
        if (time < 0) {
            throw new IllegalArgumentException("Illegal execution time.");
        }
        if (Math.abs(period) <= 4611686018427387903L) {
            period2 = period;
        } else {
            period2 = period >> 1;
        }
        synchronized (this.queue) {
            if (!this.thread.newTasksMayBeScheduled) {
                throw new IllegalStateException("Timer already cancelled.");
            }
            synchronized (task.lock) {
                if (task.state != 0) {
                    throw new IllegalStateException("Task already scheduled or cancelled");
                }
                task.nextExecutionTime = time;
                task.period = period2;
                task.state = 1;
            }
            this.queue.add(task);
            if (this.queue.getMin() == task) {
                this.queue.notify();
            }
        }
    }

    public void cancel() {
        synchronized (this.queue) {
            this.thread.newTasksMayBeScheduled = false;
            this.queue.clear();
            this.queue.notify();
        }
    }

    public int purge() {
        int result = 0;
        synchronized (this.queue) {
            for (int i10 = this.queue.size(); i10 > 0; i10--) {
                if (this.queue.get(i10).state == 3) {
                    this.queue.quickRemove(i10);
                    result++;
                }
            }
            if (result != 0) {
                this.queue.heapify();
            }
        }
        return result;
    }
}
