package com.huawei.hms.scankit;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Display;
import android.view.WindowManager;
import com.huawei.hms.hmsscankit.api.IRemoteFrameDecoderDelegate;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.scankit.p.g0;
import com.huawei.hms.scankit.p.j0;
import com.huawei.hms.scankit.p.k0;
import com.huawei.hms.scankit.p.l1;
import com.huawei.hms.scankit.p.m0;
import com.huawei.hms.scankit.p.o4;
import com.huawei.hms.scankit.p.s6;
import com.huawei.hms.scankit.p.w3;
import com.huawei.hms.scankit.p.y6;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DecodeHandler.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class c extends Handler {

    /* renamed from: j, reason: collision with root package name */
    private static a f30575j;

    /* renamed from: k, reason: collision with root package name */
    private static long f30576k;

    /* renamed from: a, reason: collision with root package name */
    private final Context f30577a;

    /* renamed from: b, reason: collision with root package name */
    private final j0 f30578b;

    /* renamed from: c, reason: collision with root package name */
    private final com.huawei.hms.scankit.a f30579c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f30580d = true;

    /* renamed from: e, reason: collision with root package name */
    private int f30581e = 50;

    /* renamed from: f, reason: collision with root package name */
    private Rect f30582f;

    /* renamed from: g, reason: collision with root package name */
    private int f30583g;

    /* renamed from: h, reason: collision with root package name */
    private IRemoteFrameDecoderDelegate f30584h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f30585i;

    /* compiled from: DecodeHandler.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a extends AsyncTask<Object, Object, Object> {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<c> f30586a;

        /* renamed from: e, reason: collision with root package name */
        private List<k0.a> f30590e;

        /* renamed from: f, reason: collision with root package name */
        private List<k0.a> f30591f;

        /* renamed from: b, reason: collision with root package name */
        private boolean f30587b = true;

        /* renamed from: c, reason: collision with root package name */
        private boolean f30588c = false;

        /* renamed from: d, reason: collision with root package name */
        private int f30589d = 0;

        /* renamed from: g, reason: collision with root package name */
        private int f30592g = 0;

        /* renamed from: h, reason: collision with root package name */
        private int f30593h = 0;

        public a(c cVar) {
            this.f30586a = new WeakReference<>(cVar);
        }

        public void b(int i10) {
            this.f30593h = i10;
            c cVar = this.f30586a.get();
            if (cVar != null) {
                try {
                    cVar.a(this.f30593h, this.f30591f);
                    o4.d("DecodeHandler", "ScanCode handle global value" + this.f30593h);
                } catch (RuntimeException e2) {
                    o4.b("DecodeHandler", "RuntimeException: " + e2.getMessage());
                } catch (Exception unused) {
                    o4.b("DecodeHandler", "Exception");
                }
            }
        }

        @Override // android.os.AsyncTask
        public Object doInBackground(Object... objArr) {
            if (c.f30575j.isCancelled()) {
                return null;
            }
            while (!this.f30588c) {
                if (this.f30587b) {
                    try {
                        Thread.sleep(400L);
                    } catch (InterruptedException unused) {
                        o4.d("ScankitDecode", "doInBackground  get InterruptedException  error!!!");
                    }
                    this.f30587b = false;
                } else {
                    c cVar = this.f30586a.get();
                    int i10 = this.f30592g;
                    if (i10 == 0) {
                        this.f30587b = true;
                    } else if (cVar != null) {
                        try {
                            cVar.a(this.f30589d / i10, this.f30590e);
                            o4.d("DecodeHandler", "ScanCode handle auto value" + (this.f30589d / this.f30592g));
                            a();
                            this.f30587b = true;
                        } catch (RuntimeException e2) {
                            o4.b("DecodeHandler", "RuntimeException: " + e2.getMessage());
                        } catch (Exception unused2) {
                            o4.b("DecodeHandler", "Exception");
                        }
                    }
                }
            }
            return null;
        }

        public void a(int i10) {
            this.f30589d += i10;
            this.f30592g++;
        }

        public void a(List<Rect> list, int i10, int i11, boolean z10) {
            if (list == null) {
                o4.a("ScankitDecode", "areas is null");
                return;
            }
            if (list.size() == 0) {
                this.f30591f = Collections.singletonList(new k0.a(new Rect(-100, -100, 100, 100), 1000));
                return;
            }
            this.f30591f = new ArrayList();
            for (Rect rect : list) {
                int centerX = ((rect.centerX() * 2000) / i10) - 1000;
                int centerY = ((rect.centerY() * 2000) / i11) - 1000;
                int width = ((rect.width() * 2000) / i10) / 2;
                int height = ((rect.height() * 2000) / i11) / 2;
                this.f30591f.add(new k0.a(new Rect(centerX - (width / 2), centerY - (height / 2), centerX + width, centerY + height), 1000 / list.size()));
            }
            list.clear();
        }

        public void b(List<Rect> list, int i10, int i11, boolean z10) {
            if (list == null) {
                o4.a("ScankitDecode", "areas is null");
                return;
            }
            if (list.size() == 0) {
                this.f30590e = Collections.singletonList(new k0.a(new Rect(-100, -100, 100, 100), 1000));
                return;
            }
            this.f30590e = new ArrayList();
            if (z10) {
                int i12 = (i11 > i10 ? i11 - i10 : i10 - i11) >> 1;
                for (Rect rect : list) {
                    int centerY = (((rect.centerY() + i12) * 2000) / i10) - 1000;
                    int centerX = ((rect.centerX() * 2000) / i11) - 1000;
                    int height = ((rect.height() * 2000) / i10) / 2;
                    int width = ((rect.width() * 2000) / i11) / 2;
                    this.f30590e.add(new k0.a(new Rect(centerY - (height / 2), centerX - (width / 2), centerY + height, centerX + width), 1000 / list.size()));
                }
                return;
            }
            for (Rect rect2 : list) {
                int centerX2 = ((rect2.centerX() * 2000) / i10) - 1000;
                int centerY2 = ((rect2.centerY() * 2000) / i11) - 1000;
                int width2 = ((rect2.width() * 2000) / i10) / 2;
                int height2 = ((rect2.height() * 2000) / i11) / 2;
                this.f30590e.add(new k0.a(new Rect(centerX2 - (width2 / 2), centerY2 - (height2 / 2), centerX2 + width2, centerY2 + height2), 1000 / list.size()));
            }
            list.clear();
        }

        private void a() {
            this.f30589d = 0;
            this.f30592g = 0;
        }
    }

    public c(Context context, j0 j0Var, com.huawei.hms.scankit.a aVar, Map<l1, Object> map, Rect rect, boolean z10) {
        this.f30585i = false;
        this.f30577a = context;
        this.f30578b = j0Var;
        this.f30579c = aVar;
        this.f30582f = rect;
        if (f30575j == null) {
            a aVar2 = new a(this);
            f30575j = aVar2;
            aVar2.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
        }
        this.f30583g = 0;
        this.f30585i = z10;
        a(context);
    }

    private boolean d() {
        Context context = this.f30577a;
        if (context == null) {
            return true;
        }
        Object systemService = context.getSystemService("window");
        if (systemService instanceof WindowManager) {
            Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getSize(point);
            return point.x < point.y;
        }
        o4.d("ScankitDecode", "isScreenPortrait  getSystemService  WINDOW_SERVICE  error!!!");
        return true;
    }

    public boolean b(float f10) {
        boolean z10;
        com.huawei.hms.scankit.a aVar = this.f30579c;
        if (aVar != null && aVar.a()) {
            return false;
        }
        try {
            m0 g3 = this.f30578b.g();
            if (g3 == null) {
                o4.d("ScankitDecode", "Zoom not supported,data is null");
                return false;
            }
            int c4 = g3.c();
            int b4 = g3.b();
            float intValue = ((r1.get(b4).intValue() * 1.0f) / 100.0f) * f10;
            if (((int) (intValue * 100.0f)) > g3.a().get(c4).intValue()) {
                intValue = (c4 * 1.0f) / 100.0f;
            }
            if (this.f30578b.j()) {
                int a10 = a(intValue);
                if (a10 > b4) {
                    this.f30578b.d(a10);
                    z10 = true;
                } else {
                    this.f30578b.d(b4);
                    z10 = false;
                }
                this.f30578b.a(Collections.singletonList(new k0.a(new Rect(-150, -150, 150, 150), 1000)));
                return z10;
            }
            o4.d("ScankitDecode", "Zoom not supported");
            return false;
        } catch (RuntimeException unused) {
            o4.b("ScankitDecode", "Zoom not supported,RuntimeException happen");
            return false;
        } catch (Exception unused2) {
            o4.b("ScankitDecode", "Zoom not supported,Exception happen");
            return false;
        }
    }

    public float c() {
        if (b() == null) {
            return 1.0f;
        }
        return Math.round(r0.get(r0.size() - 1).intValue() / 100.0f);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message == null || !this.f30580d) {
            return;
        }
        int i10 = message.what;
        if (i10 == R.id.scankit_decode) {
            int i11 = this.f30583g;
            if (i11 <= 1) {
                this.f30583g = i11 + 1;
                this.f30579c.sendEmptyMessage(R.id.scankit_decode_failed);
                return;
            } else {
                Object obj = message.obj;
                if (obj instanceof byte[]) {
                    a((byte[]) obj, d());
                    return;
                }
                return;
            }
        }
        if (i10 == R.id.scankit_quit) {
            this.f30580d = false;
            a aVar = f30575j;
            if (aVar != null) {
                aVar.f30588c = true;
                f30575j.cancel(true);
            }
            Looper.myLooper().quit();
            return;
        }
        o4.d("ScankitDecode", "handleMessage  message.what:" + message.what);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004c A[Catch: RemoteException -> 0x0057, TryCatch #4 {RemoteException -> 0x0057, blocks: (B:7:0x003b, B:9:0x003f, B:12:0x004c, B:14:0x0050), top: B:6:0x003b }] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x003f A[Catch: RemoteException -> 0x0057, TryCatch #4 {RemoteException -> 0x0057, blocks: (B:7:0x003b, B:9:0x003f, B:12:0x004c, B:14:0x0050), top: B:6:0x003b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(android.content.Context r4) {
        /*
            r3 = this;
            java.lang.String r0 = "ScankitDecode"
            boolean r1 = r3.f30585i     // Catch: java.lang.InstantiationException -> L29 java.lang.ClassNotFoundException -> L2f java.lang.IllegalAccessException -> L35
            if (r1 == 0) goto Ld
            java.lang.Class<com.huawei.hms.scankit.DecoderCreator> r4 = com.huawei.hms.scankit.DecoderCreator.class
            java.lang.Object r4 = r4.newInstance()     // Catch: java.lang.InstantiationException -> L29 java.lang.ClassNotFoundException -> L2f java.lang.IllegalAccessException -> L35
            goto L3b
        Ld:
            android.content.Context r4 = com.huawei.hms.hmsscankit.g.e(r4)     // Catch: java.lang.Throwable -> L11 java.lang.InstantiationException -> L29 java.lang.ClassNotFoundException -> L2f java.lang.IllegalAccessException -> L35
        L11:
            java.lang.ClassLoader r1 = r4.getClassLoader()     // Catch: java.lang.InstantiationException -> L29 java.lang.ClassNotFoundException -> L2f java.lang.IllegalAccessException -> L35
            java.lang.String r2 = "com.huawei.hms.scankit.DecoderCreator"
            java.lang.Class r1 = r1.loadClass(r2)     // Catch: java.lang.InstantiationException -> L29 java.lang.ClassNotFoundException -> L2f java.lang.IllegalAccessException -> L35
            java.lang.ClassLoader r4 = r4.getClassLoader()     // Catch: java.lang.InstantiationException -> L29 java.lang.ClassNotFoundException -> L2f java.lang.IllegalAccessException -> L35
            java.lang.String r2 = "com.huawei.hms.scankit.aiscan.common.BarcodeFormat"
            r4.loadClass(r2)     // Catch: java.lang.InstantiationException -> L29 java.lang.ClassNotFoundException -> L2f java.lang.IllegalAccessException -> L35
            java.lang.Object r4 = r1.newInstance()     // Catch: java.lang.InstantiationException -> L29 java.lang.ClassNotFoundException -> L2f java.lang.IllegalAccessException -> L35
            goto L3b
        L29:
            java.lang.String r4 = "InstantiationException"
            com.huawei.hms.scankit.p.o4.a(r0, r4)
            goto L3a
        L2f:
            java.lang.String r4 = "ClassNotFoundException"
            com.huawei.hms.scankit.p.o4.a(r0, r4)
            goto L3a
        L35:
            java.lang.String r4 = "IllegalAccessException"
            com.huawei.hms.scankit.p.o4.a(r0, r4)
        L3a:
            r4 = 0
        L3b:
            boolean r1 = r4 instanceof android.os.IBinder     // Catch: android.os.RemoteException -> L57
            if (r1 == 0) goto L4c
            android.os.IBinder r4 = (android.os.IBinder) r4     // Catch: android.os.RemoteException -> L57
            com.huawei.hms.hmsscankit.api.IRemoteDecoderCreator r4 = com.huawei.hms.hmsscankit.api.IRemoteDecoderCreator.Stub.asInterface(r4)     // Catch: android.os.RemoteException -> L57
            com.huawei.hms.hmsscankit.api.IRemoteFrameDecoderDelegate r4 = r4.newRemoteFrameDecoderDelegate()     // Catch: android.os.RemoteException -> L57
            r3.f30584h = r4     // Catch: android.os.RemoteException -> L57
            return
        L4c:
            com.huawei.hms.hmsscankit.api.IRemoteFrameDecoderDelegate r4 = r3.f30584h     // Catch: android.os.RemoteException -> L57
            if (r4 != 0) goto L5c
            com.huawei.hms.scankit.p.h4 r4 = com.huawei.hms.scankit.p.h4.a()     // Catch: android.os.RemoteException -> L57
            r3.f30584h = r4     // Catch: android.os.RemoteException -> L57
            goto L5c
        L57:
            java.lang.String r4 = "RemoteException"
            com.huawei.hms.scankit.p.o4.a(r0, r4)
        L5c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.c.a(android.content.Context):void");
    }

    public List<Integer> b() {
        return this.f30578b.g().a();
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(byte[] r18, boolean r19) {
        /*
            Method dump skipped, instructions count: 433
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.c.a(byte[], boolean):void");
    }

    private boolean a(float f10, s6[] s6VarArr, w3.c cVar) {
        if (!b(f10)) {
            return false;
        }
        Message obtain = Message.obtain();
        obtain.what = R.id.scankit_decode_succeeded;
        HmsScan[] a10 = y6.a(s6VarArr);
        obtain.obj = a10;
        if (b.J != null) {
            b.J.a(a10, cVar);
        }
        this.f30579c.sendMessage(obtain);
        return true;
    }

    private void a(s6[] s6VarArr, byte[] bArr, int i10, int i11, w3.c cVar) {
        if (this.f30579c != null) {
            Message obtain = Message.obtain(this.f30579c, R.id.scankit_decode_succeeded, y6.a(s6VarArr));
            try {
                if (b.I != null) {
                    b.I.a(s6VarArr[0].e(), s6VarArr[0].b(), s6VarArr[0].m());
                }
            } catch (Exception unused) {
            }
            if (this.f30579c.c()) {
                Bundle bundle = new Bundle();
                a(bArr, i10, i11, bundle);
                obtain.setData(bundle);
            }
            obtain.sendToTarget();
        }
    }

    private static void a(byte[] bArr, int i10, int i11, Bundle bundle) {
        if (bArr == null || bArr.length == 0) {
            return;
        }
        YuvImage yuvImage = new YuvImage(bArr, 17, i10, i11, null);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        yuvImage.compressToJpeg(new Rect(0, 0, i10, i11), 100, byteArrayOutputStream);
        bundle.putByteArray("barcode_bitmap", byteArrayOutputStream.toByteArray());
        bundle.putFloat("barcode_scaled_factor", 1.0f);
        try {
            byteArrayOutputStream.close();
        } catch (IOException unused) {
        }
    }

    public void a(Rect rect, boolean z10) {
        com.huawei.hms.scankit.a aVar = this.f30579c;
        if (aVar == null || !aVar.a()) {
            this.f30578b.a(rect, z10);
        }
    }

    public void a(int i10, List<k0.a> list) {
        g0 b4 = this.f30578b.b();
        int b10 = b4.b();
        int c4 = b4.c();
        int a10 = b4.a();
        if (i10 == 0) {
            return;
        }
        int i11 = a10 + i10;
        if (i11 <= b10) {
            b10 = i11 < c4 ? c4 : i11;
        }
        this.f30578b.c(b10);
        k0 c10 = this.f30578b.c();
        Rect b11 = c10.b();
        if (c10.a() > 0) {
            if (c10.a() == 1) {
                int centerX = b11.centerX();
                int centerY = b11.centerY();
                if (Math.sqrt(((centerX - list.get(0).f31196a.centerX()) * (centerX - list.get(0).f31196a.centerX())) + (centerY - list.get(0).f31196a.centerY()) + (centerY - list.get(0).f31196a.centerY())) > this.f30581e) {
                    list.set(0, new k0.a(list.get(0).f31196a, 1000));
                    this.f30578b.a(list.subList(0, 1));
                    return;
                }
                return;
            }
            this.f30578b.a(list);
        }
    }

    public int a(float f10) {
        List<Integer> b4 = b();
        if (b4 == null) {
            return -3;
        }
        if (b4.size() <= 0) {
            return -4;
        }
        if (Math.abs(f10 - 1.0f) < 1.0E-6f) {
            return 0;
        }
        if (f10 == c()) {
            return b4.size() - 1;
        }
        for (int i10 = 1; i10 < b4.size(); i10++) {
            float f11 = 100.0f * f10;
            if (b4.get(i10).intValue() >= f11 && b4.get(i10 - 1).intValue() <= f11) {
                return i10;
            }
        }
        return -1;
    }
}
