package com.tencent.turingcam;

import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Build;
import android.os.Message;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import android.view.View;
import com.tencent.turingcam.s7Dnc;
import com.tencent.turingcam.view.ShGzN;
import com.tencent.turingcam.view.TuringPreviewDisplay;
import com.tencent.turingcam.y8N3A;
import com.tencent.turingface.sdk.mfa.c9YSQ;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class z5VDt {

    /* renamed from: a, reason: collision with root package name */
    private static final String f45488a = WOMZP.b("3spd2H8hHma4H18EjYTzWg==");

    /* renamed from: b, reason: collision with root package name */
    private static final String f45489b = WOMZP.b("DSv7X69YcoK1PCJvm8ce5osrHNM=");

    /* renamed from: c, reason: collision with root package name */
    private static final String f45490c = WOMZP.b("PRCBC9ulqKi8tK1vJSfQ3CVEfaa9uZL8xNsqSA==");

    /* renamed from: d, reason: collision with root package name */
    private static final String f45491d = WOMZP.b("ZhC44TH2gipmEmDqkN11sw==");

    /* renamed from: e, reason: collision with root package name */
    private static final String f45492e = WOMZP.b("GPJOXui0b6GBvil8JLG3bY/zgr9DbLPt");

    /* renamed from: f, reason: collision with root package name */
    private static final String f45493f = WOMZP.b("53GWiqTfPF5HGxYjWLrd0U4Oll+oAajp");

    /* renamed from: g, reason: collision with root package name */
    private static final String f45494g = WOMZP.b("tnBzhxxR/b+gYqxoICYmA1lN0tEjYYXvb1msZQ==");

    /* renamed from: h, reason: collision with root package name */
    private static final String f45495h = WOMZP.b("W31u13O9REtolI1/zQ62pl5cse0Shhs4WEu3fuJwapA=");

    /* renamed from: i, reason: collision with root package name */
    private static final String f45496i = WOMZP.b("WsIxLAQ7292izcD9D2+F/C1r56ivVsc57/Qy2Wr+k/4=");

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f45497j = 0;

    /* renamed from: k, reason: collision with root package name */
    private String f45498k;

    /* renamed from: l, reason: collision with root package name */
    private XnM3A f45499l;

    /* renamed from: m, reason: collision with root package name */
    private WeakReference<Camera> f45500m;

    /* renamed from: n, reason: collision with root package name */
    private B9LVG f45501n;

    /* renamed from: o, reason: collision with root package name */
    private kwCJn f45502o;

    /* renamed from: p, reason: collision with root package name */
    private WeakReference<View> f45503p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f45504q;

    /* renamed from: r, reason: collision with root package name */
    private TuringFaceBuilder f45505r;

    /* renamed from: s, reason: collision with root package name */
    public long f45506s;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface B9LVG {
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class Bi3eT {

        /* renamed from: a, reason: collision with root package name */
        private static final z5VDt f45507a = new z5VDt(null);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class ShGzN implements ShGzN.spXPg {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Camera f45508a;

        public ShGzN(Camera camera) {
            this.f45508a = camera;
        }

        @Override // com.tencent.turingcam.view.ShGzN.spXPg
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i10, int i11) {
            z5VDt.a(z5VDt.this, this.f45508a, surfaceTexture, null);
            if (z5VDt.this.f45501n != null) {
                ((F2BEC) z5VDt.this.f45501n).f45397a.onPreviewAvailable();
            }
        }

        @Override // com.tencent.turingcam.view.ShGzN.spXPg
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            if (z5VDt.this.f45501n == null) {
                return false;
            }
            ((F2BEC) z5VDt.this.f45501n).f45397a.onPreviewDestroyed();
            return false;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class SkEpO implements SurfaceHolder.Callback {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Camera f45510a;

        public SkEpO(Camera camera) {
            this.f45510a = camera;
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i10, int i11, int i12) {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            z5VDt.a(z5VDt.this, this.f45510a, null, surfaceHolder);
            if (z5VDt.this.f45501n != null) {
                ((F2BEC) z5VDt.this.f45501n).f45397a.onPreviewAvailable();
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            if (z5VDt.this.f45501n != null) {
                ((F2BEC) z5VDt.this.f45501n).f45397a.onPreviewDestroyed();
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class kwCJn {

        /* renamed from: a, reason: collision with root package name */
        public String f45512a;

        /* renamed from: b, reason: collision with root package name */
        public int f45513b = 0;

        /* renamed from: c, reason: collision with root package name */
        public com.tencent.turingcam.wmqhz f45514c;

        /* renamed from: d, reason: collision with root package name */
        public List<String> f45515d;

        /* renamed from: e, reason: collision with root package name */
        public Map<String, String> f45516e;

        /* renamed from: f, reason: collision with root package name */
        public byte[] f45517f;

        public kwCJn() {
            com.tencent.turingcam.wmqhz wmqhzVar = new com.tencent.turingcam.wmqhz();
            this.f45514c = wmqhzVar;
            wmqhzVar.f45473c = new ArrayList<>();
            this.f45514c.f45474d = new HashMap();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class wmqhz implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TuringPreviewDisplay f45519a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f45520b;

        public wmqhz(z5VDt z5vdt, TuringPreviewDisplay turingPreviewDisplay, View view) {
            this.f45519a = turingPreviewDisplay;
            this.f45520b = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f45519a.addView(this.f45520b, -1, -1);
        }
    }

    public /* synthetic */ z5VDt(spXPg spxpg) {
        this();
    }

    public static void a(z5VDt z5vdt, String str) {
        z5vdt.getClass();
        hxUS9.b().a();
        long currentTimeMillis = System.currentTimeMillis();
        WeakReference<Camera> weakReference = z5vdt.f45500m;
        Camera camera = weakReference != null ? weakReference.get() : null;
        y8N3A.SkEpO b4 = y8N3A.a().b();
        int i10 = b4.f45478a;
        if (i10 == 0) {
            String str2 = b4.f45479b;
            com.tencent.turingcam.kwCJn kwcjn = new com.tencent.turingcam.kwCJn();
            kwcjn.f45442d = "";
            kwcjn.f45443e = new ArrayList<>();
            kwcjn.f45444f = y8N3A.a().c();
            kwcjn.f45446h = z5vdt.a();
            kwcjn.f45447i = str2;
            HashMap hashMap = new HashMap();
            kwcjn.f45445g = hashMap;
            HashMap hashMap2 = new HashMap();
            if (camera != null) {
                Camera.Parameters parameters = camera.getParameters();
                hashMap2.put(f45488a, parameters.get(f45489b) + ";" + parameters.get(f45490c) + ";" + parameters.get(f45491d) + ";" + parameters.get(f45492e) + ";" + parameters.get(f45493f) + ";" + parameters.get(f45494g) + ";" + parameters.get(f45495h) + ";" + parameters.get(f45496i));
            }
            hashMap2.toString();
            hashMap.putAll(hashMap2);
            if (!TextUtils.isEmpty(str)) {
                kwcjn.f45445g.put("token", str);
            }
            com.tencent.turingcam.ShGzN shGzN = new com.tencent.turingcam.ShGzN(128);
            kwcjn.a(shGzN);
            c9YSQ c9ysq = (c9YSQ) com.tencent.turingface.sdk.mfa.EQsUZ.a(103, shGzN.a());
            c9ysq.f45753a.getClass();
            byte[] bArr = c9ysq.f45753a.f45584a;
            B9LVG b9lvg = z5vdt.f45501n;
            if (b9lvg != null) {
                ((F2BEC) b9lvg).f45397a.onFinish(0L, bArr);
            }
            hxUS9.b().a("upload_code", 0L);
            hxUS9.b().a("upload_cost", System.currentTimeMillis() - currentTimeMillis);
            return;
        }
        long j10 = i10 - 400000;
        B9LVG b9lvg2 = z5vdt.f45501n;
        if (b9lvg2 != null) {
            ((F2BEC) b9lvg2).f45397a.onFinish(j10, null);
        }
        hxUS9.b().a("upload_code", j10);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void b(com.tencent.turingcam.z5VDt r8, java.lang.String r9) {
        /*
            Method dump skipped, instructions count: 310
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.turingcam.z5VDt.b(com.tencent.turingcam.z5VDt, java.lang.String):void");
    }

    private z5VDt() {
        this.f45504q = false;
        this.f45506s = 0L;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class spXPg implements CvowV {
        public spXPg() {
        }

        @Override // com.tencent.turingcam.CvowV
        public void a(Message message) {
            int i10 = message.what;
            if (i10 == 3) {
                z5VDt.a(z5VDt.this, (s7Dnc.spXPg) message.obj);
                return;
            }
            if (i10 == 4) {
                z5VDt.a(z5VDt.this);
                return;
            }
            if (i10 == 5) {
                Object obj = message.obj;
                z5VDt.a(z5VDt.this, obj != null ? (String) obj : "");
            } else {
                if (i10 != 6) {
                    return;
                }
                z5VDt.b(z5VDt.this, (String) message.obj);
            }
        }

        @Override // com.tencent.turingcam.CvowV
        public void a(Throwable th) {
            if (z5VDt.this.f45501n != null) {
                ((F2BEC) z5VDt.this.f45501n).f45397a.onException(th);
            }
        }
    }

    public static boolean a(z5VDt z5vdt, Camera camera, SurfaceTexture surfaceTexture, SurfaceHolder surfaceHolder) {
        z5vdt.getClass();
        if (camera != null) {
            try {
                if (surfaceTexture != null) {
                    camera.setPreviewTexture(surfaceTexture);
                } else if (surfaceHolder != null) {
                    camera.setPreviewDisplay(surfaceHolder);
                }
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public void a(TuringFaceBuilder turingFaceBuilder) {
        if (this.f45504q) {
            return;
        }
        this.f45505r = turingFaceBuilder;
        long currentTimeMillis = System.currentTimeMillis();
        y8N3A.a().a(this.f45505r);
        hxUS9.b().a(this.f45505r.getContext());
        XnM3A xnM3A = new XnM3A();
        this.f45499l = xnM3A;
        this.f45498k = xnM3A.a(new spXPg());
        this.f45504q = true;
        hxUS9.b().a("init_cost", System.currentTimeMillis() - currentTimeMillis);
        hxUS9.b().a("init_code", 0L);
    }

    public void a(B9LVG b9lvg) {
        this.f45501n = b9lvg;
    }

    public void a(Camera camera, String str) {
        if (camera != null) {
            this.f45500m = new WeakReference<>(camera);
        }
        Message obtain = Message.obtain();
        obtain.what = 5;
        obtain.obj = str;
        this.f45499l.a(this.f45498k, obtain);
    }

    public void a(String str) {
        Message obtain = Message.obtain();
        obtain.what = 6;
        obtain.obj = str;
        this.f45499l.a(this.f45498k, obtain);
    }

    public void a(byte[] bArr) {
        if (bArr == null) {
            return;
        }
        s7Dnc.spXPg spxpg = new s7Dnc.spXPg();
        spxpg.f45457a = System.currentTimeMillis();
        spxpg.f45458b = bArr;
        Message obtain = Message.obtain();
        obtain.obj = spxpg;
        obtain.what = 3;
        this.f45499l.a(this.f45498k, obtain);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(Camera camera, TuringPreviewDisplay turingPreviewDisplay) {
        com.tencent.turingcam.view.spXPg spxpg;
        this.f45505r.isHardwareAcceleration();
        TuringFaceBuilder turingFaceBuilder = this.f45505r;
        if (turingFaceBuilder != null && turingFaceBuilder.isHardwareAcceleration() && oqKCa.f()) {
            com.tencent.turingcam.view.ShGzN shGzN = new com.tencent.turingcam.view.ShGzN(turingPreviewDisplay.getContext(), null);
            shGzN.a(new ShGzN(camera));
            spxpg = shGzN;
        } else {
            com.tencent.turingcam.view.spXPg spxpg2 = new com.tencent.turingcam.view.spXPg(turingPreviewDisplay.getContext(), null);
            spxpg2.getHolder().addCallback(new SkEpO(camera));
            spxpg = spxpg2;
        }
        this.f45503p = new WeakReference<>(spxpg);
        turingPreviewDisplay.post(new wmqhz(this, turingPreviewDisplay, spxpg));
    }

    public static void a(z5VDt z5vdt, s7Dnc.spXPg spxpg) {
        kwCJn kwcjn = z5vdt.f45502o;
        if (kwcjn != null) {
            int i10 = kwcjn.f45513b;
            if (i10 == 6 || i10 == 2 || i10 == 3) {
                z5vdt.f45506s = System.currentTimeMillis();
                z5vdt.f45502o.f45513b = 3;
                z5vdt.f45499l.a(z5vdt.f45498k, 4);
                z5vdt.f45499l.a(z5vdt.f45498k, 4, 10000L);
                Camera camera = z5vdt.f45500m.get();
                if (camera == null) {
                    B9LVG b9lvg = z5vdt.f45501n;
                    if (b9lvg != null) {
                        ((F2BEC) b9lvg).f45397a.onFinishFrameCheck(-301001L, null);
                    }
                    hxUS9.b().a("process_code", -301001L);
                    return;
                }
                kwCJn kwcjn2 = z5vdt.f45502o;
                com.tencent.turingcam.wmqhz wmqhzVar = kwcjn2.f45514c;
                Iterator<String> iterator2 = kwcjn2.f45515d.iterator2();
                while (iterator2.hasNext()) {
                    s7Dnc a10 = FLlEM.a(iterator2.next());
                    if (a10 != null && a10.a(spxpg, camera, wmqhzVar)) {
                        a10.a();
                        iterator2.remove();
                    }
                }
                if (z5vdt.f45502o.f45515d.isEmpty()) {
                    z5vdt.f45499l.a(z5vdt.f45498k, 4);
                    z5vdt.f45502o.f45513b = 4;
                    hxUS9.b().a("process_code", 0L);
                    hxUS9.b().a("process_cost", System.currentTimeMillis() - z5vdt.f45506s);
                    long currentTimeMillis = System.currentTimeMillis();
                    com.tencent.turingcam.B9LVG b9lvg2 = new com.tencent.turingcam.B9LVG();
                    b9lvg2.f45384c = z5vdt.f45502o.f45512a;
                    ArrayList<com.tencent.turingcam.Bi3eT> arrayList = new ArrayList<>();
                    b9lvg2.f45385d = arrayList;
                    arrayList.addAll(z5vdt.f45502o.f45514c.f45473c);
                    b9lvg2.f45386e = z5vdt.f45502o.f45517f;
                    b9lvg2.f45387f = z5vdt.a();
                    com.tencent.turingcam.ShGzN shGzN = new com.tencent.turingcam.ShGzN(128);
                    b9lvg2.a(shGzN);
                    c9YSQ c9ysq = (c9YSQ) com.tencent.turingface.sdk.mfa.EQsUZ.a(104, shGzN.a());
                    c9ysq.f45753a.getClass();
                    byte[] bArr = c9ysq.f45753a.f45584a;
                    B9LVG b9lvg3 = z5vdt.f45501n;
                    if (b9lvg3 != null) {
                        ((F2BEC) b9lvg3).f45397a.onFinishFrameCheck(0L, bArr);
                    }
                    hxUS9.b().a("upload_code", 0L);
                    hxUS9.b().a("upload_cost", System.currentTimeMillis() - currentTimeMillis);
                }
            }
        }
    }

    public static void a(z5VDt z5vdt) {
        z5vdt.f45502o.f45513b = 4;
        B9LVG b9lvg = z5vdt.f45501n;
        if (b9lvg != null) {
            ((F2BEC) b9lvg).f45397a.onFinish(-301005L, null);
        }
    }

    private SWw7W a() {
        SWw7W sWw7W = new SWw7W();
        sWw7W.f45399a = 2;
        sWw7W.f45401c = y8N3A.f45476b;
        sWw7W.f45400b = Build.BRAND;
        sWw7W.f45402d = Build.VERSION.RELEASE;
        sWw7W.f45403e = "2.0.3";
        sWw7W.f45405g = "7WCF54SWX5H87QEV";
        sWw7W.f45404f = String.valueOf(108158);
        sWw7W.f45406h = this.f45505r.getContext().getPackageName();
        sWw7W.f45407i = String.valueOf(this.f45505r.getChannel() != 0 ? this.f45505r.getChannel() : 108098);
        return sWw7W;
    }
}
