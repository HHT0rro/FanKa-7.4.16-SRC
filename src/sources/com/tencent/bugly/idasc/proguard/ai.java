package com.tencent.bugly.idasc.proguard;

import android.content.Context;
import android.os.Process;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class ai {

    /* renamed from: b, reason: collision with root package name */
    private static ai f39528b;

    /* renamed from: a, reason: collision with root package name */
    public ah f39529a;

    /* renamed from: d, reason: collision with root package name */
    private final Context f39531d;

    /* renamed from: f, reason: collision with root package name */
    private long f39533f;

    /* renamed from: g, reason: collision with root package name */
    private long f39534g;

    /* renamed from: e, reason: collision with root package name */
    private Map<Integer, Long> f39532e = new HashMap();

    /* renamed from: h, reason: collision with root package name */
    private LinkedBlockingQueue<Runnable> f39535h = new LinkedBlockingQueue<>();

    /* renamed from: i, reason: collision with root package name */
    private LinkedBlockingQueue<Runnable> f39536i = new LinkedBlockingQueue<>();

    /* renamed from: j, reason: collision with root package name */
    private final Object f39537j = new Object();

    /* renamed from: k, reason: collision with root package name */
    private long f39538k = 0;

    /* renamed from: l, reason: collision with root package name */
    private int f39539l = 0;

    /* renamed from: c, reason: collision with root package name */
    private final w f39530c = w.a();

    private ai(Context context) {
        this.f39531d = context;
    }

    public static synchronized ai a() {
        ai aiVar;
        synchronized (ai.class) {
            aiVar = f39528b;
        }
        return aiVar;
    }

    public static synchronized ai a(Context context) {
        ai aiVar;
        synchronized (ai.class) {
            if (f39528b == null) {
                f39528b = new ai(context);
            }
            aiVar = f39528b;
        }
        return aiVar;
    }

    private void a(int i10, int i11, byte[] bArr, String str, String str2, ah ahVar, boolean z10) {
        try {
        } catch (Throwable th) {
            th = th;
        }
        try {
            a(new aj(this.f39531d, i10, i11, bArr, str, str2, ahVar, 0, 0, false), z10, false, 0L);
        } catch (Throwable th2) {
            th = th2;
            if (al.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    private void a(int i10, LinkedBlockingQueue<Runnable> linkedBlockingQueue) {
        ak a10 = ak.a();
        if (i10 > 0) {
            al.c("[UploadManager] Execute urgent upload tasks of queue which has %d tasks (pid=%d | tid=%d)", Integer.valueOf(i10), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        }
        for (int i11 = 0; i11 < i10; i11++) {
            final Runnable poll = linkedBlockingQueue.poll();
            if (poll == null) {
                return;
            }
            synchronized (this.f39537j) {
                if (this.f39539l < 2 || a10 == null) {
                    al.a("[UploadManager] Create and start a new thread to execute a upload task: %s", "BUGLY_ASYNC_UPLOAD");
                    if (ap.a(new Runnable() { // from class: com.tencent.bugly.idasc.proguard.ai.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            poll.run();
                            synchronized (ai.this.f39537j) {
                                ai.b(ai.this);
                            }
                        }
                    }, "BUGLY_ASYNC_UPLOAD") != null) {
                        synchronized (this.f39537j) {
                            this.f39539l++;
                        }
                    } else {
                        al.d("[UploadManager] Failed to start a thread to execute asynchronous upload task,will try again next time.", new Object[0]);
                        a(poll, true);
                    }
                } else {
                    a10.a(poll);
                }
            }
        }
    }

    private void a(Runnable runnable, long j10) {
        if (runnable == null) {
            al.d("[UploadManager] Upload task should not be null", new Object[0]);
            return;
        }
        al.c("[UploadManager] Execute synchronized upload task (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        Thread a10 = ap.a(runnable, "BUGLY_SYNC_UPLOAD");
        if (a10 == null) {
            al.e("[UploadManager] Failed to start a thread to execute synchronized upload task, add it to queue.", new Object[0]);
            a(runnable, true);
            return;
        }
        try {
            a10.join(j10);
        } catch (Throwable th) {
            al.e("[UploadManager] Failed to join upload synchronized task with message: %s. Add it to queue.", th.getMessage());
            a(runnable, true);
            b();
        }
    }

    private void a(Runnable runnable, boolean z10, boolean z11, long j10) {
        al.c("[UploadManager] Add upload task (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        if (z11) {
            a(runnable, j10);
        } else {
            a(runnable, z10);
            b();
        }
    }

    private static void a(LinkedBlockingQueue<Runnable> linkedBlockingQueue, LinkedBlockingQueue<Runnable> linkedBlockingQueue2, int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            Runnable peek = linkedBlockingQueue.peek();
            if (peek == null) {
                return;
            }
            try {
                linkedBlockingQueue2.put(peek);
                linkedBlockingQueue.poll();
            } catch (Throwable th) {
                al.e("[UploadManager] Failed to add upload task to temp urgent queue: %s", th.getMessage());
            }
        }
    }

    private boolean a(Runnable runnable, boolean z10) {
        if (runnable == null) {
            al.a("[UploadManager] Upload task should not be null", new Object[0]);
            return false;
        }
        try {
            al.c("[UploadManager] Add upload task to queue (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            synchronized (this.f39537j) {
                (z10 ? this.f39535h : this.f39536i).put(runnable);
            }
            return true;
        } catch (Throwable th) {
            al.e("[UploadManager] Failed to add upload task to queue: %s", th.getMessage());
            return false;
        }
    }

    public static /* synthetic */ int b(ai aiVar) {
        int i10 = aiVar.f39539l - 1;
        aiVar.f39539l = i10;
        return i10;
    }

    private void b() {
        ak a10 = ak.a();
        LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<>();
        final LinkedBlockingQueue linkedBlockingQueue2 = new LinkedBlockingQueue();
        synchronized (this.f39537j) {
            al.c("[UploadManager] Try to poll all upload task need and put them into temp queue (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            int size = this.f39535h.size();
            final int size2 = this.f39536i.size();
            if (size == 0 && size2 == 0) {
                al.c("[UploadManager] There is no upload task in queue.", new Object[0]);
                return;
            }
            if (a10 == null || !a10.c()) {
                size2 = 0;
            }
            a(this.f39535h, linkedBlockingQueue, size);
            a(this.f39536i, linkedBlockingQueue2, size2);
            a(size, linkedBlockingQueue);
            if (size2 > 0) {
                al.c("[UploadManager] Execute upload tasks of queue which has %d tasks (pid=%d | tid=%d)", Integer.valueOf(size2), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            }
            ak a11 = ak.a();
            if (a11 != null) {
                a11.a(new Runnable() { // from class: com.tencent.bugly.idasc.proguard.ai.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        Runnable runnable;
                        for (int i10 = 0; i10 < size2 && (runnable = (Runnable) linkedBlockingQueue2.poll()) != null; i10++) {
                            runnable.run();
                        }
                    }
                });
            }
        }
    }

    public final synchronized long a(int i10) {
        if (i10 >= 0) {
            Long l10 = this.f39532e.get(Integer.valueOf(i10));
            if (l10 != null) {
                return l10.longValue();
            }
        } else {
            al.e("[UploadManager] Unknown upload ID: %d", Integer.valueOf(i10));
        }
        return 0L;
    }

    public final long a(boolean z10) {
        long j10;
        long b4 = ap.b();
        int i10 = z10 ? 5 : 3;
        List<y> a10 = this.f39530c.a(i10);
        if (a10 == null || a10.size() <= 0) {
            j10 = z10 ? this.f39534g : this.f39533f;
        } else {
            j10 = 0;
            try {
                y yVar = a10.get(0);
                if (yVar.f39988e >= b4) {
                    j10 = ap.d(yVar.f39990g);
                    if (i10 == 3) {
                        this.f39533f = j10;
                    } else {
                        this.f39534g = j10;
                    }
                    a10.remove(yVar);
                }
            } catch (Throwable th) {
                al.a(th);
            }
            if (a10.size() > 0) {
                this.f39530c.a(a10);
            }
        }
        al.c("[UploadManager] Local network consume: %d KB", Long.valueOf(j10 / 1024));
        return j10;
    }

    public final synchronized void a(int i10, long j10) {
        if (i10 < 0) {
            al.e("[UploadManager] Unknown uploading ID: %d", Integer.valueOf(i10));
            return;
        }
        this.f39532e.put(Integer.valueOf(i10), Long.valueOf(j10));
        y yVar = new y();
        yVar.f39985b = i10;
        yVar.f39988e = j10;
        yVar.f39986c = "";
        yVar.f39987d = "";
        yVar.f39990g = new byte[0];
        this.f39530c.b(i10);
        this.f39530c.a(yVar);
        al.c("[UploadManager] Uploading(ID:%d) time: %s", Integer.valueOf(i10), ap.a(j10));
    }

    public final void a(int i10, bq bqVar, String str, String str2, ah ahVar, long j10, boolean z10) {
        try {
        } catch (Throwable th) {
            th = th;
        }
        try {
            a(new aj(this.f39531d, i10, bqVar.f39807g, ae.a((Object) bqVar), str, str2, ahVar, z10), true, true, j10);
        } catch (Throwable th2) {
            th = th2;
            if (al.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public final void a(int i10, bq bqVar, String str, String str2, ah ahVar, boolean z10) {
        a(i10, bqVar.f39807g, ae.a((Object) bqVar), str, str2, ahVar, z10);
    }

    public final synchronized void a(long j10, boolean z10) {
        int i10 = z10 ? 5 : 3;
        y yVar = new y();
        yVar.f39985b = i10;
        yVar.f39988e = ap.b();
        yVar.f39986c = "";
        yVar.f39987d = "";
        yVar.f39990g = ap.c(j10);
        this.f39530c.b(i10);
        this.f39530c.a(yVar);
        if (z10) {
            this.f39534g = j10;
        } else {
            this.f39533f = j10;
        }
        al.c("[UploadManager] Network total consume: %d KB", Long.valueOf(j10 / 1024));
    }

    public final boolean b(int i10) {
        if (p.f39908c) {
            al.c("Uploading frequency will not be checked if SDK is in debug mode.", new Object[0]);
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis() - a(i10);
        al.c("[UploadManager] Time interval is %d seconds since last uploading(ID: %d).", Long.valueOf(currentTimeMillis / 1000), Integer.valueOf(i10));
        if (currentTimeMillis >= 30000) {
            return true;
        }
        al.a("[UploadManager] Data only be uploaded once in %d seconds.", 30L);
        return false;
    }
}
