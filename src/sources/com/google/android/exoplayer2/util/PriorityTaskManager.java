package com.google.android.exoplayer2.util;

import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class PriorityTaskManager {

    /* renamed from: a, reason: collision with root package name */
    public final Object f22932a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public final PriorityQueue<Integer> f22933b = new PriorityQueue<>(10, Collections.reverseOrder());

    /* renamed from: c, reason: collision with root package name */
    public int f22934c = Integer.MIN_VALUE;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class PriorityTooLowException extends IOException {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public PriorityTooLowException(int r3, int r4) {
            /*
                r2 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r1 = 60
                r0.<init>(r1)
                java.lang.String r1 = "Priority too low [priority="
                r0.append(r1)
                r0.append(r3)
                java.lang.String r3 = ", highest="
                r0.append(r3)
                r0.append(r4)
                java.lang.String r3 = "]"
                r0.append(r3)
                java.lang.String r3 = r0.toString()
                r2.<init>(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.util.PriorityTaskManager.PriorityTooLowException.<init>(int, int):void");
        }
    }

    public void a(int i10) {
        synchronized (this.f22932a) {
            this.f22933b.add(Integer.valueOf(i10));
            this.f22934c = Math.max(this.f22934c, i10);
        }
    }

    public void b(int i10) throws PriorityTooLowException {
        synchronized (this.f22932a) {
            if (this.f22934c != i10) {
                throw new PriorityTooLowException(i10, this.f22934c);
            }
        }
    }

    public void c(int i10) {
        synchronized (this.f22932a) {
            this.f22933b.remove(Integer.valueOf(i10));
            this.f22934c = this.f22933b.isEmpty() ? Integer.MIN_VALUE : ((Integer) j0.j(this.f22933b.peek())).intValue();
            this.f22932a.notifyAll();
        }
    }
}
