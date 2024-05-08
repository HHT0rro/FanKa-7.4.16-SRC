package com.wangmai.okserver.task;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class PriorityRunnable extends PriorityObject<Runnable> implements Runnable {
    public PriorityRunnable(int i10, Runnable runnable) {
        super(i10, runnable);
    }

    @Override // java.lang.Runnable
    public void run() {
        ((Runnable) this.obj).run();
    }
}
