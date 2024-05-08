package com.autonavi.aps.amapapi;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.wifi.WifiInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import com.amap.api.col.p0003l.fj;
import com.amap.api.col.p0003l.fm;
import com.amap.api.col.p0003l.fn;
import com.amap.api.col.p0003l.fv;
import com.amap.api.col.p0003l.gw;
import com.amap.api.col.p0003l.gy;
import com.amap.api.col.p0003l.hm;
import com.amap.api.col.p0003l.ht;
import com.amap.api.col.p0003l.hw;
import com.amap.api.col.p0003l.ie;
import com.amap.api.col.p0003l.ig;
import com.amap.api.col.p0003l.ih;
import com.amap.api.col.p0003l.in;
import com.amap.api.col.p0003l.ix;
import com.amap.api.col.p0003l.iz;
import com.amap.api.col.p0003l.jd;
import com.amap.api.col.p0003l.je;
import com.amap.api.col.p0003l.jm;
import com.amap.api.col.p0003l.jo;
import com.amap.api.col.p0003l.ki;
import com.amap.api.col.p0003l.kl;
import com.amap.api.col.p0003l.kr;
import com.amap.api.col.p0003l.ks;
import com.amap.api.col.p0003l.kw;
import com.amap.api.col.p0003l.kx;
import com.amap.api.col.p0003l.ky;
import com.autonavi.aps.amapapi.restruct.e;
import com.autonavi.aps.amapapi.restruct.h;
import com.autonavi.aps.amapapi.restruct.k;
import com.autonavi.aps.amapapi.utils.j;
import com.kuaishou.weapon.p0.t;
import com.tencent.cloud.huiyansdkface.normal.tools.secure.AESEncrypt;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.crypto.KeyGenerator;

/* compiled from: CollectionManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class c implements ky {

    /* renamed from: k, reason: collision with root package name */
    private static long f9345k;

    /* renamed from: a, reason: collision with root package name */
    public Context f9346a;

    /* renamed from: d, reason: collision with root package name */
    public ki f9349d;

    /* renamed from: e, reason: collision with root package name */
    public ig f9350e;

    /* renamed from: g, reason: collision with root package name */
    private Handler f9352g;

    /* renamed from: h, reason: collision with root package name */
    private LocationManager f9353h;

    /* renamed from: i, reason: collision with root package name */
    private a f9354i;

    /* renamed from: f, reason: collision with root package name */
    private ArrayList<jo> f9351f = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    public k f9347b = null;

    /* renamed from: c, reason: collision with root package name */
    public e f9348c = null;

    /* renamed from: j, reason: collision with root package name */
    private volatile boolean f9355j = false;

    /* compiled from: CollectionManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class a implements LocationListener {

        /* renamed from: a, reason: collision with root package name */
        private c f9357a;

        public a(c cVar) {
            this.f9357a = cVar;
        }

        public final void a(c cVar) {
            this.f9357a = cVar;
        }

        @Override // android.location.LocationListener
        public final void onLocationChanged(Location location) {
            try {
                c cVar = this.f9357a;
                if (cVar != null) {
                    cVar.a(location);
                }
            } catch (Throwable unused) {
            }
        }

        @Override // android.location.LocationListener
        public final void onProviderDisabled(String str) {
        }

        @Override // android.location.LocationListener
        public final void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public final void onStatusChanged(String str, int i10, Bundle bundle) {
        }

        public final void a() {
            this.f9357a = null;
        }
    }

    public c(Context context) {
        this.f9346a = null;
        this.f9346a = context;
        ig igVar = new ig();
        this.f9350e = igVar;
        in.a(this.f9346a, igVar, gw.f6172k, 100, 1024000, "0");
        ig igVar2 = this.f9350e;
        int i10 = com.autonavi.aps.amapapi.utils.a.f9611g;
        boolean z10 = com.autonavi.aps.amapapi.utils.a.f9609e;
        int i11 = com.autonavi.aps.amapapi.utils.a.f9610f;
        igVar2.f6455f = new iz(context, i10, "kKey", new ix(context, z10, i11, i11 * 10, "carrierLocKey"));
        this.f9350e.f6454e = new hm();
    }

    private static byte[] b(int i10) {
        return new byte[]{(byte) ((i10 >> 24) & 255), (byte) ((i10 >> 16) & 255), (byte) ((i10 >> 8) & 255), (byte) (i10 & 255)};
    }

    private static byte[] c(int i10) {
        return new byte[]{(byte) ((i10 & 65280) >> 8), (byte) (i10 & 255)};
    }

    public static /* synthetic */ byte[] f() {
        return a(128);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        try {
            com.autonavi.aps.amapapi.utils.d.a();
            if (j.m(this.f9346a)) {
                com.autonavi.aps.amapapi.utils.d.a();
                return;
            }
            ArrayList<jo> arrayList = this.f9351f;
            if (arrayList != null && arrayList.size() != 0) {
                ArrayList arrayList2 = new ArrayList();
                synchronized (this.f9351f) {
                    arrayList2.addAll(this.f9351f);
                    this.f9351f.clear();
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] a10 = a(256);
                if (a10 == null) {
                    return;
                }
                byteArrayOutputStream.write(c(a10.length));
                byteArrayOutputStream.write(a10);
                Iterator iterator2 = arrayList2.iterator2();
                while (iterator2.hasNext()) {
                    jo joVar = (jo) iterator2.next();
                    byte[] b4 = joVar.b();
                    if (b4.length >= 10 && b4.length <= 65535) {
                        byte[] b10 = fn.b(a10, b4, fv.c());
                        byteArrayOutputStream.write(c(b10.length));
                        byteArrayOutputStream.write(b10);
                        byteArrayOutputStream.write(b(joVar.a()));
                    }
                }
                ih.a(Long.toString(System.currentTimeMillis()), byteArrayOutputStream.toByteArray(), this.f9350e);
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "clm", "wtD");
        }
    }

    public final void d() {
        try {
            if (j.m(this.f9346a)) {
                com.autonavi.aps.amapapi.utils.d.a();
            } else {
                if (System.currentTimeMillis() - f9345k < 60000) {
                    return;
                }
                jd.a().a(new b(2));
            }
        } catch (Throwable unused) {
        }
    }

    public final void e() {
        try {
            jd.a().a(new b(3));
        } catch (Throwable unused) {
        }
    }

    /* compiled from: CollectionManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public class b extends je {

        /* renamed from: b, reason: collision with root package name */
        private int f9359b;

        /* renamed from: c, reason: collision with root package name */
        private Location f9360c;

        public b(int i10) {
            this.f9359b = i10;
        }

        private void a() {
            try {
                com.autonavi.aps.amapapi.utils.d.a();
                if (this.f9360c != null && c.this.f9355j) {
                    if (j.m(c.this.f9346a)) {
                        com.autonavi.aps.amapapi.utils.d.a();
                        return;
                    }
                    Bundle extras = this.f9360c.getExtras();
                    int i10 = extras != null ? extras.getInt("satellites") : 0;
                    if (j.a(this.f9360c, i10)) {
                        return;
                    }
                    k kVar = c.this.f9347b;
                    if (kVar != null && !kVar.f9514s) {
                        kVar.f();
                    }
                    ArrayList<ks> a10 = c.this.f9347b.a();
                    List<kl> a11 = c.this.f9348c.a();
                    jm.a aVar = new jm.a();
                    kr krVar = new kr();
                    krVar.f6681i = this.f9360c.getAccuracy();
                    krVar.f6678f = this.f9360c.getAltitude();
                    krVar.f6676d = this.f9360c.getLatitude();
                    krVar.f6680h = this.f9360c.getBearing();
                    krVar.f6677e = this.f9360c.getLongitude();
                    krVar.f6682j = this.f9360c.isFromMockProvider();
                    krVar.f6673a = this.f9360c.getProvider();
                    krVar.f6679g = this.f9360c.getSpeed();
                    krVar.f6684l = (byte) i10;
                    krVar.f6674b = System.currentTimeMillis();
                    krVar.f6675c = this.f9360c.getTime();
                    krVar.f6683k = this.f9360c.getTime();
                    aVar.f6584a = krVar;
                    aVar.f6585b = a10;
                    WifiInfo c4 = c.this.f9347b.c();
                    if (c4 != null) {
                        aVar.f6586c = ks.a(h.a(c4));
                    }
                    aVar.f6587d = k.f9500z;
                    aVar.f6589f = this.f9360c.getTime();
                    aVar.f6590g = (byte) fm.i(c.this.f9346a);
                    aVar.f6591h = fm.n(c.this.f9346a);
                    aVar.f6588e = c.this.f9347b.k();
                    aVar.f6593j = j.a(c.this.f9346a);
                    aVar.f6592i = a11;
                    jo a12 = ki.a(aVar);
                    if (a12 == null) {
                        return;
                    }
                    synchronized (c.this.f9351f) {
                        c.this.f9351f.add(a12);
                        if (c.this.f9351f.size() >= 5) {
                            c.this.e();
                        }
                    }
                    c.this.d();
                }
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "cl", "coll");
            }
        }

        private void b() {
            com.autonavi.aps.amapapi.utils.d.a();
            if (!j.m(c.this.f9346a)) {
                ht htVar = null;
                try {
                    long unused = c.f9345k = System.currentTimeMillis();
                    if (c.this.f9350e.f6455f.d()) {
                        htVar = ht.a(new File(c.this.f9350e.f6450a), c.this.f9350e.f6451b);
                        ArrayList arrayList = new ArrayList();
                        byte[] f10 = c.f();
                        if (f10 != null) {
                            List b4 = c.b(htVar, c.this.f9350e, arrayList, f10);
                            if (b4 != null && b4.size() != 0) {
                                c.this.f9350e.f6455f.a_(true);
                                if (ki.a(fv.b(ki.a(com.autonavi.aps.amapapi.security.a.a(f10), fn.b(f10, ki.a(), fv.c()), b4)))) {
                                    c.b(htVar, arrayList);
                                }
                            }
                            try {
                                htVar.close();
                                return;
                            } catch (Throwable unused2) {
                                return;
                            }
                        }
                        try {
                            htVar.close();
                            return;
                        } catch (Throwable unused3) {
                            return;
                        }
                    }
                    if (htVar != null) {
                        try {
                            htVar.close();
                            return;
                        } catch (Throwable unused4) {
                            return;
                        }
                    }
                    return;
                } catch (Throwable th) {
                    try {
                        gy.b(th, "leg", "uts");
                        if (htVar != null) {
                            try {
                                htVar.close();
                                return;
                            } catch (Throwable unused5) {
                                return;
                            }
                        }
                        return;
                    } catch (Throwable th2) {
                        if (htVar != null) {
                            try {
                                htVar.close();
                            } catch (Throwable unused6) {
                            }
                        }
                        throw th2;
                    }
                }
            }
            com.autonavi.aps.amapapi.utils.d.a();
        }

        @Override // com.amap.api.col.p0003l.je
        public final void runTask() {
            int i10 = this.f9359b;
            if (i10 == 1) {
                a();
            } else if (i10 == 2) {
                b();
            } else if (i10 == 3) {
                c.this.g();
            }
        }

        public b(c cVar, Location location) {
            this(1);
            this.f9360c = location;
        }
    }

    public final void b() {
        try {
            com.autonavi.aps.amapapi.utils.d.a();
            Handler handler = this.f9352g;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.autonavi.aps.amapapi.c.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        k kVar;
                        try {
                            c cVar = c.this;
                            if (cVar.f9349d == null || (kVar = cVar.f9347b) == null) {
                                return;
                            }
                            ki.b(kVar.a());
                        } catch (Throwable th) {
                            com.autonavi.aps.amapapi.utils.b.a(th, "cl", "upwr");
                        }
                    }
                });
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "cl", "upw");
        }
    }

    public final void c() {
        e eVar;
        try {
            com.autonavi.aps.amapapi.utils.d.a();
            if (this.f9349d == null || (eVar = this.f9348c) == null) {
                return;
            }
            ki.a(eVar.a());
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "cl", "upc");
        }
    }

    public final void a() {
        LocationManager locationManager;
        if (j.m(this.f9346a)) {
            com.autonavi.aps.amapapi.utils.d.a();
            return;
        }
        try {
            a aVar = this.f9354i;
            if (aVar != null && (locationManager = this.f9353h) != null) {
                locationManager.removeUpdates(aVar);
            }
            a aVar2 = this.f9354i;
            if (aVar2 != null) {
                aVar2.a();
            }
            if (this.f9355j) {
                g();
                this.f9347b.a((c) null);
                this.f9348c.a((c) null);
                this.f9348c = null;
                this.f9347b = null;
                this.f9352g = null;
                this.f9355j = false;
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "clm", "stc");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(ht htVar, List<String> list) {
        if (htVar != null) {
            try {
                Iterator<String> iterator2 = list.iterator2();
                while (iterator2.hasNext()) {
                    htVar.c(iterator2.next());
                }
                htVar.close();
            } catch (Throwable th) {
                gy.b(th, t.f36231p, "dlo");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0039, code lost:
    
        if (r9 != null) goto L99;
     */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00fb A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00e9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.List<com.amap.api.col.p0003l.jo> b(com.amap.api.col.p0003l.ht r17, com.amap.api.col.p0003l.ig r18, java.util.List<java.lang.String> r19, byte[] r20) {
        /*
            Method dump skipped, instructions count: 268
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.c.b(com.amap.api.col.3l.ht, com.amap.api.col.3l.ig, java.util.List, byte[]):java.util.List");
    }

    public final void a(e eVar, k kVar, Handler handler) {
        LocationManager locationManager;
        com.autonavi.aps.amapapi.utils.d.a();
        if (this.f9355j || eVar == null || kVar == null || handler == null) {
            return;
        }
        if (j.m(this.f9346a)) {
            com.autonavi.aps.amapapi.utils.d.a();
            return;
        }
        this.f9355j = true;
        this.f9348c = eVar;
        this.f9347b = kVar;
        kVar.a(this);
        this.f9348c.a(this);
        this.f9352g = handler;
        try {
            if (this.f9353h == null) {
                this.f9353h = (LocationManager) this.f9346a.getSystemService("location");
            }
            if (this.f9354i == null) {
                this.f9354i = new a(this);
            }
            this.f9354i.a(this);
            a aVar = this.f9354i;
            if (aVar != null && (locationManager = this.f9353h) != null) {
                locationManager.requestLocationUpdates("passive", 1000L, -1.0f, aVar);
            }
            if (this.f9349d == null) {
                ki kiVar = new ki("6.4.1", fj.f(this.f9346a), "S128DF1572465B890OE3F7A13167KLEI", fj.c(this.f9346a), this);
                this.f9349d = kiVar;
                kiVar.a(fm.k()).b(fm.f(this.f9346a)).c(fm.a(this.f9346a)).d(fm.e(this.f9346a)).e(fm.n()).f(fm.f()).g(Build.MODEL).h(Build.MANUFACTURER).i(Build.BRAND).a(Build.VERSION.SDK_INT).j(Build.VERSION.RELEASE).a(ks.a(fm.h())).k(fm.h());
                ki.b();
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "col", "init");
        }
    }

    public final void a(Location location) {
        try {
            Handler handler = this.f9352g;
            if (handler != null) {
                handler.post(new b(this, location));
            }
        } catch (Throwable th) {
            gy.b(th, "cl", "olcc");
        }
    }

    @Override // com.amap.api.col.p0003l.ky
    public final kx a(kw kwVar) {
        try {
            com.autonavi.aps.amapapi.trans.b bVar = new com.autonavi.aps.amapapi.trans.b();
            bVar.a(kwVar.f6715b);
            bVar.a(kwVar.f6714a);
            bVar.a(kwVar.f6717d);
            hw.a();
            ie a10 = hw.a(bVar);
            kx kxVar = new kx();
            kxVar.f6721c = a10.f6444a;
            kxVar.f6720b = a10.f6445b;
            kxVar.f6719a = 200;
            return kxVar;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static byte[] a(int i10) {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance(AESEncrypt.ALGORITHM);
            if (keyGenerator == null) {
                return null;
            }
            keyGenerator.init(i10);
            return keyGenerator.generateKey().getEncoded();
        } catch (Throwable unused) {
            return null;
        }
    }

    private static int a(byte[] bArr) {
        return ((bArr[0] & 255) << 24) | (bArr[3] & 255) | ((bArr[2] & 255) << 8) | ((bArr[1] & 255) << 16);
    }
}
