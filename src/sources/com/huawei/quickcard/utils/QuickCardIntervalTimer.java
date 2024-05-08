package com.huawei.quickcard.utils;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.NonNull;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class QuickCardIntervalTimer {

    /* renamed from: f, reason: collision with root package name */
    private static final int f34294f = 1;

    /* renamed from: b, reason: collision with root package name */
    private final long f34296b;

    /* renamed from: c, reason: collision with root package name */
    private long f34297c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f34298d;

    /* renamed from: a, reason: collision with root package name */
    private boolean f34295a = true;

    /* renamed from: e, reason: collision with root package name */
    private final Handler f34299e = new Handler() { // from class: com.huawei.quickcard.utils.QuickCardIntervalTimer.1
        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            synchronized (QuickCardIntervalTimer.this) {
                if (QuickCardIntervalTimer.this.f34295a) {
                    return;
                }
                QuickCardIntervalTimer.this.onTick();
                if (!QuickCardIntervalTimer.this.f34298d) {
                    QuickCardIntervalTimer.this.f34295a = true;
                } else {
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    Message obtainMessage = obtainMessage(1);
                    long j10 = (QuickCardIntervalTimer.this.f34296b - elapsedRealtime) + QuickCardIntervalTimer.this.f34297c;
                    long j11 = QuickCardIntervalTimer.this.f34296b;
                    long j12 = (elapsedRealtime - QuickCardIntervalTimer.this.f34297c) / QuickCardIntervalTimer.this.f34296b;
                    Long.signum(j11);
                    sendMessageDelayed(obtainMessage, j10 + (j11 * j12));
                }
            }
        }
    };

    public QuickCardIntervalTimer(long j10) {
        this.f34296b = j10;
    }

    public final synchronized void cancel() {
        if (this.f34295a) {
            return;
        }
        this.f34295a = true;
        this.f34299e.removeMessages(1);
    }

    public abstract void onTick();

    public final synchronized void start(boolean z10) {
        if (this.f34296b <= 0) {
            return;
        }
        this.f34298d = z10;
        this.f34297c = SystemClock.elapsedRealtime();
        Handler handler = this.f34299e;
        handler.sendMessageDelayed(handler.obtainMessage(1), this.f34296b);
        this.f34295a = false;
    }
}
