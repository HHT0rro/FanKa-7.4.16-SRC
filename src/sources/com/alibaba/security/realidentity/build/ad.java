package com.alibaba.security.realidentity.build;

import android.content.Context;
import android.os.AsyncTask;
import com.alibaba.security.biometrics.service.common.GetCacheDataManager;
import com.alibaba.security.common.log.RPLogging;
import com.alibaba.security.realidentity.build.hb;
import com.alibaba.security.realidentity.business.start.UploadToken;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

/* compiled from: BaseUploadTask.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class ad extends AsyncTask<UploadToken, Void, String> {

    /* renamed from: l, reason: collision with root package name */
    private static final String f3020l = ah.class.getSimpleName();

    /* renamed from: a, reason: collision with root package name */
    public String f3021a;

    /* renamed from: b, reason: collision with root package name */
    public String f3022b;

    /* renamed from: c, reason: collision with root package name */
    public AtomicInteger f3023c;

    /* renamed from: d, reason: collision with root package name */
    public AtomicIntegerArray f3024d;

    /* renamed from: e, reason: collision with root package name */
    public int f3025e;

    /* renamed from: f, reason: collision with root package name */
    public int f3026f;

    /* renamed from: g, reason: collision with root package name */
    public a f3027g;

    /* renamed from: h, reason: collision with root package name */
    public String f3028h;

    /* renamed from: i, reason: collision with root package name */
    public hc f3029i;

    /* renamed from: j, reason: collision with root package name */
    public String f3030j;

    /* renamed from: k, reason: collision with root package name */
    public String f3031k;

    /* renamed from: m, reason: collision with root package name */
    private ThreadPoolExecutor f3032m;

    /* renamed from: n, reason: collision with root package name */
    private byte[] f3033n;

    /* compiled from: BaseUploadTask.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface a {
        void a();

        void b();
    }

    public ad(Context context, String str, String str2, String str3, String str4, byte[] bArr) {
        this.f3033n = bArr;
        a(context, str, str2, str3, str4);
    }

    private void a(Context context, String str, String str2, String str3, String str4) {
        this.f3021a = str2;
        this.f3031k = str;
        if (str4 != null && !str4.endsWith("/")) {
            str4 = str4 + "/";
        }
        this.f3028h = str4;
        this.f3022b = str3;
        hb unused = hb.a.f3807a;
        this.f3029i = hb.a(context);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 5, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.alibaba.security.realidentity.build.ad.1
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return new Thread(runnable, "rpsdk-uploadService");
            }
        });
        this.f3032m = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    private void b(int i10) {
        this.f3026f = i10;
    }

    public static long e() {
        long uploadTimeOut = GetCacheDataManager.getInstance().getUploadTimeOut();
        RPLogging.d(f3020l, "uploadTimeOut:".concat(String.valueOf(uploadTimeOut)));
        return uploadTimeOut;
    }

    private String f() {
        return this.f3021a;
    }

    private boolean g() {
        for (int i10 = 0; i10 < this.f3026f; i10++) {
            if (this.f3024d.get(i10) == 0) {
                return false;
            }
        }
        return true;
    }

    private void h() {
        this.f3024d.addAndGet(this.f3025e, 1);
    }

    private void i() {
        this.f3024d.addAndGet(this.f3025e, 0);
    }

    public boolean c() {
        return false;
    }

    public abstract String d();

    public byte[] b() {
        return this.f3033n;
    }

    public ad(Context context, String str, String str2, String str3, String str4) {
        a(context, str, str2, str3, str4);
    }

    private void a(a aVar) {
        this.f3027g = aVar;
    }

    private void a(AtomicIntegerArray atomicIntegerArray) {
        this.f3024d = atomicIntegerArray;
    }

    private void a(AtomicInteger atomicInteger) {
        this.f3023c = atomicInteger;
    }

    private void a(int i10) {
        this.f3025e = i10;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x005f  */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String doInBackground(com.alibaba.security.realidentity.business.start.UploadToken... r10) {
        /*
            r9 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            com.alibaba.security.realidentity.build.j r1 = com.alibaba.security.realidentity.build.j.a.a()
            android.content.Context r1 = r1.f3894d
            java.lang.String r1 = com.alibaba.security.common.utils.FileUtils.getSaveDir(r1)
            r0.append(r1)
            java.lang.String r1 = "/images/"
            r0.append(r1)
            java.lang.String r1 = r9.f3031k
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = r9.f3022b
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            java.lang.String r3 = java.io.File.separator
            r2.append(r3)
            r2.append(r1)
            java.lang.String r2 = r2.toString()
            r3 = 1
            r4 = 0
            java.util.concurrent.FutureTask r5 = new java.util.concurrent.FutureTask     // Catch: java.lang.Exception -> L54
            com.alibaba.security.realidentity.build.ad$2 r6 = new com.alibaba.security.realidentity.build.ad$2     // Catch: java.lang.Exception -> L54
            r6.<init>()     // Catch: java.lang.Exception -> L54
            r5.<init>(r6)     // Catch: java.lang.Exception -> L54
            java.util.concurrent.ThreadPoolExecutor r6 = r9.f3032m     // Catch: java.lang.Exception -> L52
            r6.execute(r5)     // Catch: java.lang.Exception -> L52
            r6 = 1
            java.util.concurrent.TimeUnit r8 = java.util.concurrent.TimeUnit.SECONDS     // Catch: java.lang.Exception -> L52
            java.lang.Object r6 = r5.get(r6, r8)     // Catch: java.lang.Exception -> L52
            byte[] r6 = (byte[]) r6     // Catch: java.lang.Exception -> L52
            goto L5b
        L52:
            goto L55
        L54:
            r5 = r4
        L55:
            if (r5 == 0) goto L5a
            r5.cancel(r3)
        L5a:
            r6 = r4
        L5b:
            java.lang.String r5 = ""
            if (r6 != 0) goto L6d
            boolean r10 = r9.c()
            if (r10 != 0) goto L68
            r9.f3030j = r4
            goto L6a
        L68:
            r9.f3030j = r5
        L6a:
            java.lang.String r10 = r9.f3030j
            return r10
        L6d:
            boolean r0 = com.alibaba.security.common.utils.FileUtils.saveBytes2File(r0, r6, r1)
            if (r0 != 0) goto L76
            r9.f3030j = r5
            return r5
        L76:
            com.alibaba.security.realidentity.upload.UploadFileModel r0 = new com.alibaba.security.realidentity.upload.UploadFileModel
            r0.<init>()
            java.lang.String r1 = "jpeg"
            r0.setFileType(r1)
            r0.setLocalFilePath(r2)
            java.lang.String r1 = r9.d()
            r0.setRemoteFileName(r1)
            r1 = 0
            r10 = r10[r1]
            com.alibaba.security.realidentity.upload.UploadFileConfigParams r1 = new com.alibaba.security.realidentity.upload.UploadFileConfigParams
            r1.<init>()
            java.lang.String r4 = "image/jpeg"
            r1.setContentType(r4)
            java.lang.String r4 = r10.bucket
            r1.setBucket(r4)
            java.lang.String r4 = r10.endPoint
            r1.setEndPoint(r4)
            long r4 = r10.expired
            r1.setExpired(r4)
            java.lang.String r4 = r10.key
            r1.setKey(r4)
            java.lang.String r4 = r10.path
            r1.setPath(r4)
            java.lang.String r4 = r10.secret
            r1.setSecret(r4)
            java.lang.String r10 = r10.token
            r1.setToken(r10)
            java.util.concurrent.CountDownLatch r10 = new java.util.concurrent.CountDownLatch
            r10.<init>(r3)
            com.alibaba.security.realidentity.build.hc r3 = r9.f3029i
            com.alibaba.security.realidentity.build.ad$3 r4 = new com.alibaba.security.realidentity.build.ad$3
            r4.<init>()
            java.lang.Object r0 = r3.a(r1, r0, r4)
            long r1 = e()     // Catch: java.lang.InterruptedException -> Ld4
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.SECONDS     // Catch: java.lang.InterruptedException -> Ld4
            r10.await(r1, r3)     // Catch: java.lang.InterruptedException -> Ld4
            goto Ld9
        Ld4:
            com.alibaba.security.realidentity.build.hc r10 = r9.f3029i
            r10.a(r0)
        Ld9:
            java.lang.String r10 = r9.f3030j
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.security.realidentity.build.ad.doInBackground(com.alibaba.security.realidentity.business.start.UploadToken[]):java.lang.String");
    }

    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(String str) {
        super.onPostExecute(str);
        boolean z10 = false;
        if (this.f3030j == null) {
            this.f3024d.addAndGet(this.f3025e, 0);
        } else {
            this.f3024d.addAndGet(this.f3025e, 1);
        }
        if (this.f3023c.decrementAndGet() != 0 || this.f3027g == null) {
            return;
        }
        int i10 = 0;
        while (true) {
            if (i10 >= this.f3026f) {
                z10 = true;
                break;
            } else if (this.f3024d.get(i10) == 0) {
                break;
            } else {
                i10++;
            }
        }
        if (z10) {
            this.f3027g.a();
        } else {
            this.f3027g.b();
        }
    }

    public final String a() {
        return this.f3030j;
    }
}
