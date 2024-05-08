package java.util;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* compiled from: Timer.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class TaskQueue {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private TimerTask[] queue = new TimerTask[128];
    private int size = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public int size() {
        return this.size;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void add(TimerTask task) {
        int i10 = this.size + 1;
        TimerTask[] timerTaskArr = this.queue;
        if (i10 == timerTaskArr.length) {
            this.queue = (TimerTask[]) Arrays.copyOf(timerTaskArr, timerTaskArr.length * 2);
        }
        TimerTask[] timerTaskArr2 = this.queue;
        int i11 = this.size + 1;
        this.size = i11;
        timerTaskArr2[i11] = task;
        fixUp(i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TimerTask getMin() {
        return this.queue[1];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TimerTask get(int i10) {
        return this.queue[i10];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeMin() {
        TimerTask[] timerTaskArr = this.queue;
        int i10 = this.size;
        timerTaskArr[1] = timerTaskArr[i10];
        this.size = i10 - 1;
        timerTaskArr[i10] = null;
        fixDown(1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void quickRemove(int i10) {
        TimerTask[] timerTaskArr = this.queue;
        int i11 = this.size;
        timerTaskArr[i10] = timerTaskArr[i11];
        this.size = i11 - 1;
        timerTaskArr[i11] = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void rescheduleMin(long newTime) {
        this.queue[1].nextExecutionTime = newTime;
        fixDown(1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clear() {
        for (int i10 = 1; i10 <= this.size; i10++) {
            this.queue[i10] = null;
        }
        this.size = 0;
    }

    private void fixUp(int k10) {
        while (k10 > 1) {
            int j10 = k10 >> 1;
            if (this.queue[j10].nextExecutionTime > this.queue[k10].nextExecutionTime) {
                TimerTask[] timerTaskArr = this.queue;
                TimerTask tmp = timerTaskArr[j10];
                timerTaskArr[j10] = timerTaskArr[k10];
                timerTaskArr[k10] = tmp;
                k10 = j10;
            } else {
                return;
            }
        }
    }

    private void fixDown(int k10) {
        while (true) {
            int i10 = k10 << 1;
            int j10 = i10;
            int i11 = this.size;
            if (i10 <= i11 && j10 > 0) {
                if (j10 < i11 && this.queue[j10].nextExecutionTime > this.queue[j10 + 1].nextExecutionTime) {
                    j10++;
                }
                if (this.queue[k10].nextExecutionTime > this.queue[j10].nextExecutionTime) {
                    TimerTask[] timerTaskArr = this.queue;
                    TimerTask tmp = timerTaskArr[j10];
                    timerTaskArr[j10] = timerTaskArr[k10];
                    timerTaskArr[k10] = tmp;
                    k10 = j10;
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void heapify() {
        for (int i10 = this.size / 2; i10 >= 1; i10--) {
            fixDown(i10);
        }
    }
}
