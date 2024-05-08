package com.huawei.flexiblelayout;

import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.util.SparseArray;
import com.huawei.flexiblelayout.common.Debuggable;
import com.huawei.flexiblelayout.f1;
import com.huawei.flexiblelayout.log.Log;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: JsTimer.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class f1 {

    /* renamed from: c, reason: collision with root package name */
    private static final String f28121c = "JsTimer";

    /* renamed from: a, reason: collision with root package name */
    private Timer f28122a;

    /* renamed from: b, reason: collision with root package name */
    private final SparseArray<c> f28123b = new SparseArray<>();

    /* compiled from: JsTimer.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface b {
        void a(Object... objArr) throws RemoteException;
    }

    /* compiled from: JsTimer.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class c extends TimerTask {

        /* renamed from: e, reason: collision with root package name */
        private static final Handler f28124e = new Handler(Looper.getMainLooper());

        /* renamed from: a, reason: collision with root package name */
        private final b f28125a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f28126b;

        /* renamed from: c, reason: collision with root package name */
        private final Object[] f28127c;

        /* renamed from: d, reason: collision with root package name */
        private final int f28128d;

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            f28124e.post(new Runnable() { // from class: com.huawei.flexiblelayout.q1
                @Override // java.lang.Runnable
                public final void run() {
                    f1.c.this.a();
                }
            });
        }

        private c(b bVar, boolean z10, Object... objArr) {
            this.f28128d = System.identityHashCode(this);
            this.f28125a = bVar;
            this.f28126b = z10;
            this.f28127c = objArr;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a() {
            if (!this.f28126b) {
                f1.a().a(this.f28128d);
            }
            try {
                this.f28125a.a(this.f28127c);
            } catch (RemoteException unused) {
                f1.a().a(this.f28128d);
            } catch (Exception e2) {
                if (Debuggable.isDebuggable()) {
                    Log.e(f1.f28121c, "Exception when invoking timer callback.", e2);
                    return;
                }
                Log.e(f1.f28121c, "Exception when invoking timer callback." + e2.getMessage());
            }
        }
    }

    /* compiled from: JsTimer.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        private static final f1 f28129a = new f1();

        private d() {
        }
    }

    public static f1 a() {
        return d.f28129a;
    }

    public Integer a(boolean z10, b bVar, long j10, Object[] objArr) {
        if (this.f28122a == null) {
            this.f28122a = new Timer(f28121c);
        }
        c cVar = new c(bVar, z10, objArr);
        if (z10) {
            this.f28122a.schedule(cVar, j10, j10);
        } else {
            this.f28122a.schedule(cVar, j10);
        }
        int i10 = cVar.f28128d;
        this.f28123b.put(i10, cVar);
        return Integer.valueOf(i10);
    }

    public void a(int i10) {
        c cVar;
        if (this.f28122a == null || (cVar = this.f28123b.get(i10)) == null) {
            return;
        }
        this.f28123b.delete(i10);
        cVar.cancel();
        this.f28122a.purge();
        if (this.f28123b.size() == 0) {
            this.f28122a.cancel();
            this.f28122a = null;
        }
    }
}
