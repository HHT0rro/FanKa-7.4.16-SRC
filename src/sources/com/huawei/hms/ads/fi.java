package com.huawei.hms.ads;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.Gravity;
import com.huawei.openalliance.ad.constant.bq;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class fi extends Drawable implements Animatable, Drawable.Callback {
    private static final int B = 2;
    private static final int C = 119;
    private static final String Code = "GifDrawable";
    private static final int D = 2;
    private static final int F = 5;
    private static final int I = 640;
    private static final int L = 4;
    private static final String S = "render_frame";
    private static final int V = 0;
    private static final int Z = 960;

    /* renamed from: f, reason: collision with root package name */
    private Paint f29203f;

    /* renamed from: i, reason: collision with root package name */
    private String f29206i;

    /* renamed from: l, reason: collision with root package name */
    private int f29209l;

    /* renamed from: m, reason: collision with root package name */
    private int f29210m;

    /* renamed from: o, reason: collision with root package name */
    private fh f29212o;

    /* renamed from: p, reason: collision with root package name */
    private Context f29213p;

    /* renamed from: r, reason: collision with root package name */
    private fj f29215r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f29216s;

    /* renamed from: t, reason: collision with root package name */
    private com.huawei.openalliance.ad.utils.s f29217t;

    /* renamed from: v, reason: collision with root package name */
    private fk f29219v;

    /* renamed from: w, reason: collision with root package name */
    private a f29220w;

    /* renamed from: a, reason: collision with root package name */
    private final String f29198a = S + hashCode();

    /* renamed from: b, reason: collision with root package name */
    private Canvas f29199b = new Canvas();

    /* renamed from: c, reason: collision with root package name */
    private Rect f29200c = new Rect();

    /* renamed from: d, reason: collision with root package name */
    private Rect f29201d = new Rect();

    /* renamed from: e, reason: collision with root package name */
    private Rect f29202e = new Rect();

    /* renamed from: g, reason: collision with root package name */
    private boolean f29204g = false;

    /* renamed from: h, reason: collision with root package name */
    private int f29205h = 0;

    /* renamed from: j, reason: collision with root package name */
    private Queue<fj> f29207j = new ConcurrentLinkedQueue();

    /* renamed from: k, reason: collision with root package name */
    private Queue<Bitmap> f29208k = new ConcurrentLinkedQueue();

    /* renamed from: n, reason: collision with root package name */
    private boolean f29211n = false;

    /* renamed from: q, reason: collision with root package name */
    private long f29214q = 0;

    /* renamed from: u, reason: collision with root package name */
    private final WeakHashMap<Drawable.Callback, Void> f29218u = new WeakHashMap<>();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface a {
        void Code(Bitmap bitmap);
    }

    public fi(Context context, String str) {
        this.f29213p = context.getApplicationContext();
        this.f29206i = str;
        com.huawei.openalliance.ad.utils.s sVar = new com.huawei.openalliance.ad.utils.s("gif-thread");
        this.f29217t = sVar;
        sVar.Code();
        setCallback(this);
    }

    private InputStream B(String str) {
        String e2;
        StringBuilder sb2;
        try {
            return this.f29213p.getResources().openRawResource(Integer.parseInt(str.substring(bq.RES.toString().length())));
        } catch (Resources.NotFoundException e10) {
            e = e10;
            e2 = e();
            sb2 = new StringBuilder();
            sb2.append("loadFile ");
            sb2.append(e.getClass().getSimpleName());
            gl.I(e2, sb2.toString());
            return null;
        } catch (NumberFormatException e11) {
            e = e11;
            e2 = e();
            sb2 = new StringBuilder();
            sb2.append("loadFile ");
            sb2.append(e.getClass().getSimpleName());
            gl.I(e2, sb2.toString());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        gl.V(e(), "replay " + com.huawei.openalliance.ad.utils.bc.Code(this.f29206i));
        Code(this.f29206i);
    }

    private InputStream C(String str) {
        try {
            return this.f29213p.getAssets().open(str.substring(bq.ASSET.toString().length()));
        } catch (IOException e2) {
            gl.I(e(), "loadFile " + e2.getClass().getSimpleName());
            return null;
        }
    }

    private void C() {
        Code(false);
        this.f29209l = 0;
        this.f29207j.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0047, code lost:
    
        if (r10 > 640) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.graphics.Bitmap Code(android.graphics.Bitmap r9, boolean r10) {
        /*
            r8 = this;
            boolean r0 = com.huawei.hms.ads.gl.Code()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L1f
            java.lang.String r0 = r8.e()
            java.lang.Object[] r3 = new java.lang.Object[r2]
            java.util.Queue<android.graphics.Bitmap> r4 = r8.f29208k
            int r4 = r4.size()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r3[r1] = r4
            java.lang.String r4 = "image pool size: %d"
            com.huawei.hms.ads.gl.Code(r0, r4, r3)
        L1f:
            java.util.Queue<android.graphics.Bitmap> r0 = r8.f29208k
            java.lang.Object r0 = r0.poll()
            android.graphics.Bitmap r0 = (android.graphics.Bitmap) r0
            if (r0 != 0) goto L90
            java.lang.String r0 = r8.e()
            java.lang.String r3 = "cache bitmap null"
            com.huawei.hms.ads.gl.V(r0, r3)
            if (r10 == 0) goto L87
            int r10 = r9.getWidth()
            int r0 = r9.getHeight()
            if (r10 >= r0) goto L40
            r3 = 1
            goto L41
        L40:
            r3 = 0
        L41:
            r4 = 640(0x280, float:8.97E-43)
            r5 = 960(0x3c0, float:1.345E-42)
            if (r3 == 0) goto L4a
            if (r10 <= r4) goto L4f
            goto L50
        L4a:
            if (r10 <= r5) goto L4f
            r4 = 960(0x3c0, float:1.345E-42)
            goto L50
        L4f:
            r4 = r10
        L50:
            int r3 = r4 * r0
            float r3 = (float) r3
            r5 = 1065353216(0x3f800000, float:1.0)
            float r3 = r3 * r5
            float r5 = (float) r10
            float r3 = r3 / r5
            int r3 = (int) r3
            java.lang.String r5 = r8.e()
            r6 = 4
            java.lang.Object[] r6 = new java.lang.Object[r6]
            java.lang.Integer r7 = java.lang.Integer.valueOf(r4)
            r6[r1] = r7
            java.lang.Integer r1 = java.lang.Integer.valueOf(r3)
            r6[r2] = r1
            r1 = 2
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            r6[r1] = r10
            r10 = 3
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r6[r10] = r0
            java.lang.String r10 = "reduce image size to w: %d, h: %d src w: %d, h: %d"
            com.huawei.hms.ads.gl.V(r5, r10, r6)
            android.graphics.Bitmap$Config r10 = android.graphics.Bitmap.Config.RGB_565
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r4, r3, r10)
            goto L90
        L87:
            android.graphics.Bitmap$Config r10 = r9.getConfig()
            android.graphics.Bitmap r9 = r9.copy(r10, r2)
            return r9
        L90:
            r8.Code(r9, r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.ads.fi.Code(android.graphics.Bitmap, boolean):android.graphics.Bitmap");
    }

    private void Code(Bitmap bitmap, Bitmap bitmap2) {
        if (bitmap2 != null) {
            this.f29199b.setBitmap(bitmap2);
            this.f29199b.drawColor(0, PorterDuff.Mode.CLEAR);
            this.f29201d.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            this.f29202e.set(0, 0, bitmap2.getWidth(), bitmap2.getHeight());
            this.f29199b.drawBitmap(bitmap, this.f29201d, this.f29202e, (Paint) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(fj fjVar) {
        if (fjVar == null) {
            gl.V(e(), "invalid frame.");
            return;
        }
        gl.V(e(), "onFrameDecoded index: %d isstop: %s", Integer.valueOf(fjVar.Code), Boolean.valueOf(F()));
        if (F()) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.f29214q;
        if (gl.Code()) {
            gl.Code(e(), "onFrameDecoded decodeInterval: %d currentFrameDuration: %d", Long.valueOf(currentTimeMillis), Integer.valueOf(this.f29210m));
        }
        if (fjVar.Code == 1) {
            b();
        } else {
            int i10 = this.f29210m;
            if (currentTimeMillis < i10) {
                try {
                    Thread.sleep(i10 - currentTimeMillis);
                } catch (InterruptedException unused) {
                    gl.Code(e(), "sleep InterruptedException");
                }
            }
        }
        V(fjVar);
    }

    private void Code(final String str) {
        this.f29217t.Code(new Runnable() { // from class: com.huawei.hms.ads.fi.2
            @Override // java.lang.Runnable
            public void run() {
                fi.this.V(str);
            }
        });
    }

    private synchronized void Code(boolean z10) {
        this.f29211n = z10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Code(fj fjVar, long j10) {
        int i10;
        long width = fjVar.V.getWidth() * fjVar.V.getHeight() * (fjVar.V.getConfig() == Bitmap.Config.RGB_565 ? 2 : 4);
        int i11 = fjVar.I;
        if (j10 > i11) {
            i10 = (int) Math.ceil((j10 * 1.0d) / i11);
            if (i10 > 5) {
                i10 = 5;
            }
        } else {
            i10 = 1;
        }
        long max = width * Math.max(i10, this.f29207j.size());
        long V2 = com.huawei.openalliance.ad.utils.v.V();
        if (gl.Code()) {
            gl.Code(e(), "max frame mem: %d unused memory: %d", Long.valueOf(max), Long.valueOf(V2));
        }
        return max >= V2;
    }

    public static /* synthetic */ int D(fi fiVar) {
        int i10 = fiVar.f29209l;
        fiVar.f29209l = i10 + 1;
        return i10;
    }

    private void D() {
        com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.fi.3
            @Override // java.lang.Runnable
            public void run() {
                if (fi.this.f29219v != null) {
                    fi.this.f29219v.V();
                }
                fi.this.V();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean F() {
        return this.f29211n;
    }

    private InputStream I(String str) {
        try {
            return this.f29213p.getContentResolver().openInputStream(Uri.parse(str));
        } catch (FileNotFoundException e2) {
            gl.I(e(), "oPIs " + e2.getClass().getSimpleName());
            return null;
        }
    }

    private void I(fj fjVar) {
        if (fjVar == null || this.f29208k.size() >= 2) {
            gl.V(e(), "drop frame");
        } else {
            if (this.f29208k.contains(fjVar.V) || this.f29208k.offer(fjVar.V)) {
                return;
            }
            gl.I(e(), "fail to release frame to pool");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        final fh fhVar;
        if (F() || (fhVar = this.f29212o) == null || fhVar.I()) {
            return;
        }
        this.f29217t.Code(new Runnable() { // from class: com.huawei.hms.ads.fi.4
            @Override // java.lang.Runnable
            public void run() {
                gl.V(fi.this.e(), "fetch next");
                long currentTimeMillis = System.currentTimeMillis();
                fj Code2 = fhVar.Code();
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                gl.Code(fi.this.e(), "frame fetch - decoding duration: %d gif: %s", Long.valueOf(currentTimeMillis2), Code2);
                fi fiVar = fi.this;
                if (Code2 == null) {
                    fj fjVar = (fj) fiVar.f29207j.poll();
                    if (fjVar != null) {
                        fi.this.Code(fjVar);
                        return;
                    }
                    long currentTimeMillis3 = System.currentTimeMillis() - fi.this.f29214q;
                    if (currentTimeMillis3 < fi.this.f29210m) {
                        try {
                            Thread.sleep(fi.this.f29210m - currentTimeMillis3);
                        } catch (InterruptedException unused) {
                            gl.Code(fi.this.e(), "InterruptedException");
                        }
                    }
                    fi.this.a();
                    return;
                }
                boolean Code3 = fiVar.Code(Code2, currentTimeMillis2);
                gl.Code(fi.this.e(), "need reduce size: %s", Boolean.valueOf(Code3));
                fj Code4 = Code2.Code();
                Code4.V = fi.this.Code(Code2.V, Code3);
                if (!fi.this.f29207j.offer(Code4)) {
                    gl.I(fi.this.e(), "fail to add frame to cache");
                }
                int i10 = Code4.I;
                if (currentTimeMillis2 <= i10) {
                    gl.V(fi.this.e(), "send to render directly");
                } else {
                    int i11 = (int) ((currentTimeMillis2 * 1.0d) / i10);
                    if (i11 > 5) {
                        i11 = 5;
                    }
                    gl.Code(fi.this.e(), "preferred cached frame num: %d", Integer.valueOf(i11));
                    if (fi.this.f29207j.size() < i11) {
                        fi.this.L();
                        return;
                    }
                }
                fi fiVar2 = fi.this;
                fiVar2.Code((fj) fiVar2.f29207j.poll());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() {
        fh fhVar = this.f29212o;
        if (fhVar != null) {
            fhVar.V();
            this.f29212o = null;
        }
    }

    private void V(fj fjVar) {
        a aVar;
        I(this.f29215r);
        this.f29215r = fjVar;
        if (fjVar != null && (aVar = this.f29220w) != null) {
            aVar.Code(fjVar.V);
        }
        this.f29210m = fjVar.I;
        com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.fi.7
            @Override // java.lang.Runnable
            public void run() {
                if (fi.this.F()) {
                    fi.this.f29215r = null;
                } else {
                    fi.this.invalidateSelf();
                    fi.this.L();
                }
            }
        }, this.f29198a, 0L);
        this.f29214q = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(String str) {
        S();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        InputStream C2 = str.startsWith(bq.ASSET.toString()) ? C(str) : str.startsWith(bq.RES.toString()) ? B(str) : str.startsWith(bq.CONTENT.toString()) ? I(str) : Z(str);
        if (C2 != null) {
            try {
                this.f29212o = new fh(C2, 100);
                L();
            } catch (Exception unused) {
                gl.I(e(), "exception in creating gif decoder");
                D();
            }
        }
    }

    private Paint Z() {
        if (this.f29203f == null) {
            this.f29203f = new Paint(2);
        }
        return this.f29203f;
    }

    private InputStream Z(String str) {
        try {
            return new FileInputStream(new File(str));
        } catch (FileNotFoundException e2) {
            gl.I(e(), "loadFile " + e2.getClass().getSimpleName());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.fi.5
            @Override // java.lang.Runnable
            public void run() {
                fi.D(fi.this);
                if (fi.this.f29205h == 0 || fi.this.f29209l < fi.this.f29205h) {
                    fi.this.B();
                } else {
                    fi.this.V();
                    fi.this.d();
                }
            }
        });
    }

    private void b() {
        com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.fi.6
            @Override // java.lang.Runnable
            public void run() {
                if (fi.this.f29219v != null) {
                    fi.this.f29219v.Code();
                }
            }
        });
    }

    private void c() {
        this.f29208k.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        gl.V(e(), "on play end");
        c();
        com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.fi.8
            @Override // java.lang.Runnable
            public void run() {
                if (fi.this.f29219v != null) {
                    fi.this.f29219v.I();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String e() {
        return "GifDrawable_" + hashCode();
    }

    public void Code() {
        if (TextUtils.isEmpty(this.f29206i)) {
            return;
        }
        gl.V(e(), "play " + com.huawei.openalliance.ad.utils.bc.Code(this.f29206i));
        V();
        C();
        Code(this.f29206i);
    }

    public void Code(int i10) {
        this.f29205h = i10;
    }

    public void Code(Drawable.Callback callback) {
        this.f29218u.put(callback, null);
        setCallback(this);
    }

    public void Code(a aVar) {
        this.f29220w = aVar;
    }

    public void Code(fk fkVar) {
        this.f29219v = fkVar;
    }

    public int I() {
        int size = (this.f29208k.size() + this.f29207j.size()) * getIntrinsicWidth() * getIntrinsicHeight() * 4;
        if (size > 0) {
            return size;
        }
        return 1;
    }

    public void V() {
        gl.V(e(), "stop play " + com.huawei.openalliance.ad.utils.bc.Code(this.f29206i));
        com.huawei.openalliance.ad.utils.ba.Code(this.f29198a);
        Code(true);
        this.f29207j.clear();
        this.f29217t.Code(new Runnable() { // from class: com.huawei.hms.ads.fi.1
            @Override // java.lang.Runnable
            public void run() {
                fi.this.S();
            }
        });
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        fj fjVar = this.f29215r;
        if (fjVar == null || fjVar.V == null) {
            return;
        }
        if (gl.Code() && this.f29215r != null) {
            gl.Code(e(), "draw frame: %d", Integer.valueOf(this.f29215r.Code));
        }
        if (this.f29216s) {
            Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), this.f29200c);
            this.f29216s = false;
        }
        canvas.drawBitmap(this.f29215r.V, (Rect) null, this.f29200c, Z());
    }

    public void finalize() {
        super.finalize();
        this.f29217t.V();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        fj fjVar = this.f29215r;
        return fjVar != null ? fjVar.V.getHeight() : super.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        fj fjVar = this.f29215r;
        return fjVar != null ? fjVar.V.getWidth() : super.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        for (Drawable.Callback callback : this.f29218u.h()) {
            if (callback != null) {
                callback.invalidateDrawable(drawable);
            }
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f29204g;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f29216s = true;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j10) {
        for (Drawable.Callback callback : this.f29218u.h()) {
            if (callback != null) {
                callback.scheduleDrawable(drawable, runnable, j10);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        Z().setAlpha(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Z().setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z10, boolean z11) {
        gl.V(e(), "setVisible " + z10);
        if (!z10) {
            stop();
        } else if (!this.f29204g) {
            start();
        }
        return super.setVisible(z10, z11);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        gl.V(e(), "start");
        this.f29204g = true;
        Code();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        gl.V(e(), "stop");
        this.f29204g = false;
        V();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        for (Drawable.Callback callback : this.f29218u.h()) {
            if (callback != null) {
                callback.unscheduleDrawable(drawable, runnable);
            }
        }
    }
}
