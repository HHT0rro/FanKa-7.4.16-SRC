package java.util;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* compiled from: Timer.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class TimerThread extends Thread {
    boolean newTasksMayBeScheduled = true;
    private TaskQueue queue;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TimerThread(TaskQueue queue) {
        this.queue = queue;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            mainLoop();
            synchronized (this.queue) {
                this.newTasksMayBeScheduled = false;
                this.queue.clear();
            }
        } catch (Throwable th) {
            synchronized (this.queue) {
                this.newTasksMayBeScheduled = false;
                this.queue.clear();
                throw th;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0075, code lost:
    
        if (r8 == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0077, code lost:
    
        r1.run();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void mainLoop() {
        /*
            r13 = this;
        L1:
            java.util.TaskQueue r0 = r13.queue     // Catch: java.lang.InterruptedException -> L81
            monitor-enter(r0)     // Catch: java.lang.InterruptedException -> L81
        L4:
            java.util.TaskQueue r1 = r13.queue     // Catch: java.lang.Throwable -> L7e
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L7e
            if (r1 == 0) goto L16
            boolean r1 = r13.newTasksMayBeScheduled     // Catch: java.lang.Throwable -> L7e
            if (r1 == 0) goto L16
            java.util.TaskQueue r1 = r13.queue     // Catch: java.lang.Throwable -> L7e
            r1.wait()     // Catch: java.lang.Throwable -> L7e
            goto L4
        L16:
            java.util.TaskQueue r1 = r13.queue     // Catch: java.lang.Throwable -> L7e
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L7e
            if (r1 == 0) goto L20
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L7e
            return
        L20:
            java.util.TaskQueue r1 = r13.queue     // Catch: java.lang.Throwable -> L7e
            java.util.TimerTask r1 = r1.getMin()     // Catch: java.lang.Throwable -> L7e
            java.lang.Object r2 = r1.lock     // Catch: java.lang.Throwable -> L7e
            monitor-enter(r2)     // Catch: java.lang.Throwable -> L7e
            int r3 = r1.state     // Catch: java.lang.Throwable -> L7b
            r4 = 3
            if (r3 != r4) goto L36
            java.util.TaskQueue r3 = r13.queue     // Catch: java.lang.Throwable -> L7b
            r3.removeMin()     // Catch: java.lang.Throwable -> L7b
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L7b
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L7e
            goto L1
        L36:
            long r3 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L7b
            long r5 = r1.nextExecutionTime     // Catch: java.lang.Throwable -> L7b
            int r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r7 > 0) goto L42
            r7 = 1
            goto L43
        L42:
            r7 = 0
        L43:
            r8 = r7
            if (r7 == 0) goto L6a
            long r9 = r1.period     // Catch: java.lang.Throwable -> L7b
            r11 = 0
            int r7 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r7 != 0) goto L57
            java.util.TaskQueue r7 = r13.queue     // Catch: java.lang.Throwable -> L7b
            r7.removeMin()     // Catch: java.lang.Throwable -> L7b
            r7 = 2
            r1.state = r7     // Catch: java.lang.Throwable -> L7b
            goto L6a
        L57:
            java.util.TaskQueue r7 = r13.queue     // Catch: java.lang.Throwable -> L7b
            long r9 = r1.period     // Catch: java.lang.Throwable -> L7b
            int r9 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r9 >= 0) goto L64
            long r9 = r1.period     // Catch: java.lang.Throwable -> L7b
            long r9 = r3 - r9
            goto L67
        L64:
            long r9 = r1.period     // Catch: java.lang.Throwable -> L7b
            long r9 = r9 + r5
        L67:
            r7.rescheduleMin(r9)     // Catch: java.lang.Throwable -> L7b
        L6a:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L7b
            if (r8 != 0) goto L74
            java.util.TaskQueue r2 = r13.queue     // Catch: java.lang.Throwable -> L7e
            long r9 = r5 - r3
            r2.wait(r9)     // Catch: java.lang.Throwable -> L7e
        L74:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L7e
            if (r8 == 0) goto L82
            r1.run()     // Catch: java.lang.InterruptedException -> L81
            goto L82
        L7b:
            r3 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L7b
            throw r3     // Catch: java.lang.Throwable -> L7e
        L7e:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L7e
            throw r1     // Catch: java.lang.InterruptedException -> L81
        L81:
            r0 = move-exception
        L82:
            goto L1
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.TimerThread.mainLoop():void");
    }
}
