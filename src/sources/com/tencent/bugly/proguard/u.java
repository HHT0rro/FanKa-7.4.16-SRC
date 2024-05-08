package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: BUGLY */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    private static u f40199a;

    /* renamed from: c, reason: collision with root package name */
    private final Context f40201c;

    /* renamed from: e, reason: collision with root package name */
    private long f40203e;

    /* renamed from: f, reason: collision with root package name */
    private long f40204f;

    /* renamed from: d, reason: collision with root package name */
    private Map<Integer, Long> f40202d = new HashMap();

    /* renamed from: g, reason: collision with root package name */
    private LinkedBlockingQueue<Runnable> f40205g = new LinkedBlockingQueue<>();

    /* renamed from: h, reason: collision with root package name */
    private LinkedBlockingQueue<Runnable> f40206h = new LinkedBlockingQueue<>();

    /* renamed from: i, reason: collision with root package name */
    private final Object f40207i = new Object();

    /* renamed from: j, reason: collision with root package name */
    private int f40208j = 0;

    /* renamed from: b, reason: collision with root package name */
    private final p f40200b = p.a();

    private u(Context context) {
        this.f40201c = context;
    }

    public static /* synthetic */ int b(u uVar) {
        int i10 = uVar.f40208j - 1;
        uVar.f40208j = i10;
        return i10;
    }

    private void c(int i10) {
        w a10 = w.a();
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        final LinkedBlockingQueue linkedBlockingQueue2 = new LinkedBlockingQueue();
        synchronized (this.f40207i) {
            x.c("[UploadManager] Try to poll all upload task need and put them into temp queue (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            int size = this.f40205g.size();
            final int size2 = this.f40206h.size();
            if (size == 0 && size2 == 0) {
                x.c("[UploadManager] There is no upload task in queue.", new Object[0]);
                return;
            }
            if (a10 == null || !a10.c()) {
                size2 = 0;
            }
            for (int i11 = 0; i11 < size; i11++) {
                Runnable peek = this.f40205g.peek();
                if (peek == null) {
                    break;
                }
                try {
                    linkedBlockingQueue.put(peek);
                    this.f40205g.poll();
                } catch (Throwable th) {
                    x.e("[UploadManager] Failed to add upload task to temp urgent queue: %s", th.getMessage());
                }
            }
            for (int i12 = 0; i12 < size2; i12++) {
                Runnable peek2 = this.f40206h.peek();
                if (peek2 == null) {
                    break;
                }
                try {
                    linkedBlockingQueue2.put(peek2);
                    this.f40206h.poll();
                } catch (Throwable th2) {
                    x.e("[UploadManager] Failed to add upload task to temp urgent queue: %s", th2.getMessage());
                }
            }
            if (size > 0) {
                x.c("[UploadManager] Execute urgent upload tasks of queue which has %d tasks (pid=%d | tid=%d)", Integer.valueOf(size), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            }
            for (int i13 = 0; i13 < size; i13++) {
                final Runnable runnable = (Runnable) linkedBlockingQueue.poll();
                if (runnable == null) {
                    break;
                }
                synchronized (this.f40207i) {
                    if (this.f40208j >= 2 && a10 != null) {
                        a10.a(runnable);
                    } else {
                        x.a("[UploadManager] Create and start a new thread to execute a upload task: %s", "BUGLY_ASYNC_UPLOAD");
                        if (z.a(new Runnable() { // from class: com.tencent.bugly.proguard.u.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                runnable.run();
                                synchronized (u.this.f40207i) {
                                    u.b(u.this);
                                }
                            }
                        }, "BUGLY_ASYNC_UPLOAD") != null) {
                            synchronized (this.f40207i) {
                                this.f40208j++;
                            }
                        } else {
                            x.d("[UploadManager] Failed to start a thread to execute asynchronous upload task, will try again next time.", new Object[0]);
                            a(runnable, true);
                        }
                    }
                }
            }
            if (size2 > 0) {
                x.c("[UploadManager] Execute upload tasks of queue which has %d tasks (pid=%d | tid=%d)", Integer.valueOf(size2), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            }
            if (a10 != null) {
                a10.a(new Runnable(this) { // from class: com.tencent.bugly.proguard.u.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        Runnable runnable2;
                        for (int i14 = 0; i14 < size2 && (runnable2 = (Runnable) linkedBlockingQueue2.poll()) != null; i14++) {
                            runnable2.run();
                        }
                    }
                });
            }
        }
    }

    public static synchronized u a(Context context) {
        u uVar;
        synchronized (u.class) {
            if (f40199a == null) {
                f40199a = new u(context);
            }
            uVar = f40199a;
        }
        return uVar;
    }

    public final boolean b(int i10) {
        if (com.tencent.bugly.b.f39031c) {
            x.c("Uploading frequency will not be checked if SDK is in debug mode.", new Object[0]);
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis() - a(i10);
        x.c("[UploadManager] Time interval is %d seconds since last uploading(ID: %d).", Long.valueOf(currentTimeMillis / 1000), Integer.valueOf(i10));
        if (currentTimeMillis >= 30000) {
            return true;
        }
        x.a("[UploadManager] Data only be uploaded once in %d seconds.", 30L);
        return false;
    }

    public static synchronized u a() {
        u uVar;
        synchronized (u.class) {
            uVar = f40199a;
        }
        return uVar;
    }

    public final void a(int i10, am amVar, String str, String str2, t tVar, long j10, boolean z10) {
        try {
        } catch (Throwable th) {
            th = th;
        }
        try {
            a(new v(this.f40201c, i10, amVar.f40057g, a.a((Object) amVar), str, str2, tVar, true, z10), true, true, j10);
        } catch (Throwable th2) {
            th = th2;
            if (x.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public final void a(int i10, am amVar, String str, String str2, t tVar, boolean z10) {
        try {
        } catch (Throwable th) {
            th = th;
        }
        try {
            a(new v(this.f40201c, i10, amVar.f40057g, a.a((Object) amVar), str, str2, tVar, 0, 0, false, null), z10, false, 0L);
        } catch (Throwable th2) {
            th = th2;
            if (x.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public final long a(boolean z10) {
        long j10;
        long b4 = z.b();
        int i10 = z10 ? 5 : 3;
        List<r> a10 = this.f40200b.a(i10);
        if (a10 != null && a10.size() > 0) {
            j10 = 0;
            try {
                r rVar = a10.get(0);
                if (rVar.f40193e >= b4) {
                    j10 = z.b(rVar.f40195g);
                    if (i10 == 3) {
                        this.f40203e = j10;
                    } else {
                        this.f40204f = j10;
                    }
                    a10.remove(rVar);
                }
            } catch (Throwable th) {
                x.a(th);
            }
            if (a10.size() > 0) {
                this.f40200b.a(a10);
            }
        } else {
            j10 = z10 ? this.f40204f : this.f40203e;
        }
        x.c("[UploadManager] Local network consume: %d KB", Long.valueOf(j10 / 1024));
        return j10;
    }

    public final synchronized void a(long j10, boolean z10) {
        int i10 = z10 ? 5 : 3;
        r rVar = new r();
        rVar.f40190b = i10;
        rVar.f40193e = z.b();
        rVar.f40191c = "";
        rVar.f40192d = "";
        rVar.f40195g = z.c(j10);
        this.f40200b.b(i10);
        this.f40200b.a(rVar);
        if (z10) {
            this.f40204f = j10;
        } else {
            this.f40203e = j10;
        }
        x.c("[UploadManager] Network total consume: %d KB", Long.valueOf(j10 / 1024));
    }

    public final synchronized void a(int i10, long j10) {
        if (i10 < 0) {
            x.e("[UploadManager] Unknown uploading ID: %d", Integer.valueOf(i10));
            return;
        }
        this.f40202d.put(Integer.valueOf(i10), Long.valueOf(j10));
        r rVar = new r();
        rVar.f40190b = i10;
        rVar.f40193e = j10;
        rVar.f40191c = "";
        rVar.f40192d = "";
        rVar.f40195g = new byte[0];
        this.f40200b.b(i10);
        this.f40200b.a(rVar);
        x.c("[UploadManager] Uploading(ID:%d) time: %s", Integer.valueOf(i10), z.a(j10));
    }

    public final synchronized long a(int i10) {
        if (i10 >= 0) {
            Long l10 = this.f40202d.get(Integer.valueOf(i10));
            if (l10 != null) {
                return l10.longValue();
            }
        } else {
            x.e("[UploadManager] Unknown upload ID: %d", Integer.valueOf(i10));
        }
        return 0L;
    }

    private boolean a(Runnable runnable, boolean z10) {
        if (runnable == null) {
            x.a("[UploadManager] Upload task should not be null", new Object[0]);
            return false;
        }
        try {
            x.c("[UploadManager] Add upload task to queue (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            synchronized (this.f40207i) {
                if (z10) {
                    this.f40205g.put(runnable);
                } else {
                    this.f40206h.put(runnable);
                }
            }
            return true;
        } catch (Throwable th) {
            x.e("[UploadManager] Failed to add upload task to queue: %s", th.getMessage());
            return false;
        }
    }

    private void a(Runnable runnable, boolean z10, boolean z11, long j10) {
        if (runnable == null) {
            x.d("[UploadManager] Upload task should not be null", new Object[0]);
        }
        x.c("[UploadManager] Add upload task (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        if (!z11) {
            a(runnable, z10);
            c(0);
            return;
        }
        if (runnable == null) {
            x.d("[UploadManager] Upload task should not be null", new Object[0]);
            return;
        }
        x.c("[UploadManager] Execute synchronized upload task (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        Thread a10 = z.a(runnable, "BUGLY_SYNC_UPLOAD");
        if (a10 == null) {
            x.e("[UploadManager] Failed to start a thread to execute synchronized upload task, add it to queue.", new Object[0]);
            a(runnable, true);
            return;
        }
        try {
            a10.join(j10);
        } catch (Throwable th) {
            x.e("[UploadManager] Failed to join upload synchronized task with message: %s. Add it to queue.", th.getMessage());
            a(runnable, true);
            c(0);
        }
    }
}
