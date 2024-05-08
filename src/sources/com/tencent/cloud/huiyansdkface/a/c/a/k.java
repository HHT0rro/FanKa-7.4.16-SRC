package com.tencent.cloud.huiyansdkface.a.c.a;

import android.graphics.ImageFormat;
import android.hardware.Camera;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class k implements com.tencent.cloud.huiyansdkface.a.e.c {

    /* renamed from: a, reason: collision with root package name */
    private static ExecutorService f40378a = Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.tencent.cloud.huiyansdkface.a.c.a.k.1
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("WeCamera-PreviewProcessorThread");
            return thread;
        }
    });

    /* renamed from: b, reason: collision with root package name */
    private Camera f40379b;

    /* renamed from: c, reason: collision with root package name */
    private com.tencent.cloud.huiyansdkface.a.c.a f40380c;

    /* renamed from: d, reason: collision with root package name */
    private List<com.tencent.cloud.huiyansdkface.a.e.d> f40381d;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.cloud.huiyansdkface.a.a.a.d f40382e;

    /* renamed from: f, reason: collision with root package name */
    private int f40383f;

    /* renamed from: g, reason: collision with root package name */
    private com.tencent.cloud.huiyansdkface.a.e.b f40384g;

    /* renamed from: h, reason: collision with root package name */
    private a f40385h = new a();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        public boolean f40390a = false;

        /* renamed from: b, reason: collision with root package name */
        public boolean f40391b = false;

        public a() {
        }
    }

    public k(com.tencent.cloud.huiyansdkface.a.c.a aVar, Camera camera) {
        this.f40379b = camera;
        this.f40380c = aVar;
        com.tencent.cloud.huiyansdkface.a.e.b d10 = aVar.d();
        this.f40384g = d10;
        this.f40382e = d10.b();
        this.f40383f = this.f40384g.f();
        this.f40381d = new ArrayList();
    }

    private void a(com.tencent.cloud.huiyansdkface.a.e.a aVar, byte[] bArr) {
        synchronized (this.f40381d) {
            for (int i10 = 0; i10 < this.f40381d.size(); i10++) {
                this.f40381d.get(i10).a(aVar);
            }
        }
        try {
            this.f40379b.addCallbackBuffer(bArr);
        } catch (Exception e2) {
            com.tencent.cloud.huiyansdkface.a.d.a.d("V1PreviewProcessor", e2, "addCallbackBuffer err:" + Log.getStackTraceString(e2), new Object[0]);
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(byte[] bArr, byte[] bArr2) {
        a(new com.tencent.cloud.huiyansdkface.a.e.a(this.f40382e, bArr, this.f40384g.c(), this.f40383f, this.f40384g.a()), bArr2);
    }

    private byte[] a(com.tencent.cloud.huiyansdkface.a.a.a.d dVar) {
        int i10 = this.f40383f;
        int a10 = i10 == 842094169 ? a(dVar.f40295a, dVar.f40296b) : ((dVar.f40295a * dVar.f40296b) * ImageFormat.getBitsPerPixel(i10)) / 8;
        com.tencent.cloud.huiyansdkface.a.d.a.a("V1PreviewProcessor", "camera preview format:" + i10 + ",calc buffer size:" + a10, new Object[0]);
        return new byte[a10];
    }

    public int a(int i10, int i11) {
        return (((int) Math.ceil(i10 / 16.0d)) * 16 * i11) + ((((((int) Math.ceil((r5 / 2) / 16.0d)) * 16) * i11) / 2) * 2);
    }

    public void a() {
        com.tencent.cloud.huiyansdkface.a.d.a.b("V1PreviewProcessor", "add callback buffer", new Object[0]);
        try {
            this.f40379b.addCallbackBuffer(a(this.f40382e));
        } catch (Exception e2) {
            com.tencent.cloud.huiyansdkface.a.d.a.d("V1PreviewProcessor", e2, "addCallbackBuffer err:" + Log.getStackTraceString(e2), new Object[0]);
            e2.printStackTrace();
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.a.e.c
    public void a(com.tencent.cloud.huiyansdkface.a.e.d dVar) {
        synchronized (this.f40381d) {
            com.tencent.cloud.huiyansdkface.a.d.a.a("V1PreviewProcessor", "register preview callback:" + ((Object) dVar), new Object[0]);
            if (dVar != null && !this.f40381d.contains(dVar)) {
                this.f40381d.add(dVar);
            }
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.a.e.c
    public void b() {
        a();
        com.tencent.cloud.huiyansdkface.a.d.a.b("V1PreviewProcessor", "start preview callback.", new Object[0]);
        this.f40379b.setPreviewCallbackWithBuffer(new Camera.PreviewCallback() { // from class: com.tencent.cloud.huiyansdkface.a.c.a.k.2
            @Override // android.hardware.Camera.PreviewCallback
            public void onPreviewFrame(final byte[] bArr, Camera camera) {
                final byte[] bArr2;
                if (k.this.f40385h.f40390a) {
                    bArr2 = new byte[bArr.length];
                    System.arraycopy((Object) bArr, 0, (Object) bArr2, 0, bArr.length);
                } else {
                    bArr2 = bArr;
                }
                if (k.this.f40385h.f40391b) {
                    k.this.a(bArr2, bArr);
                } else {
                    k.f40378a.submit(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.a.c.a.k.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            k.this.a(bArr2, bArr);
                        }
                    });
                }
            }
        });
    }

    @Override // com.tencent.cloud.huiyansdkface.a.e.c
    public void c() {
        com.tencent.cloud.huiyansdkface.a.d.a.b("V1PreviewProcessor", "stop preview callback.", new Object[0]);
        this.f40379b.setPreviewCallbackWithBuffer(null);
    }
}
