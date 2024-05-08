package com.xiaomi.mipush.sdk;

import com.xiaomi.mipush.sdk.n;
import java.util.concurrent.ScheduledFuture;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class w implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ n.a.C0713a f47086b;

    public w(n.a.C0713a c0713a) {
        this.f47086b = c0713a;
    }

    @Override // java.lang.Runnable
    public void run() {
        ScheduledFuture scheduledFuture;
        ScheduledFuture scheduledFuture2;
        if (this.f47086b.f47039b.size() != 0) {
            this.f47086b.f();
            return;
        }
        scheduledFuture = this.f47086b.f47040c;
        if (scheduledFuture != null) {
            scheduledFuture2 = this.f47086b.f47040c;
            scheduledFuture2.cancel(false);
            this.f47086b.f47040c = null;
        }
    }
}
