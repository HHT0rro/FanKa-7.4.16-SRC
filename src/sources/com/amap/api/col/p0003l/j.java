package com.amap.api.col.p0003l;

import android.content.Context;
import android.text.TextUtils;
import com.alimm.tanx.core.utils.LandingPageUtHelper;
import com.amap.api.location.AMapLocation;
import com.autonavi.aps.amapapi.security.a;
import com.autonavi.aps.amapapi.storage.b;
import com.autonavi.aps.amapapi.storage.c;
import java.util.List;
import org.json.JSONObject;

/* compiled from: LastLocationManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class j {

    /* renamed from: b, reason: collision with root package name */
    public static b f6517b;

    /* renamed from: e, reason: collision with root package name */
    public static hh f6518e;

    /* renamed from: g, reason: collision with root package name */
    public static long f6519g;

    /* renamed from: a, reason: collision with root package name */
    public String f6520a = null;

    /* renamed from: c, reason: collision with root package name */
    public b f6521c = null;

    /* renamed from: d, reason: collision with root package name */
    public b f6522d = null;

    /* renamed from: f, reason: collision with root package name */
    public long f6523f = 0;

    /* renamed from: h, reason: collision with root package name */
    public boolean f6524h = false;

    /* renamed from: i, reason: collision with root package name */
    private Context f6525i;

    public j(Context context) {
        this.f6525i = context.getApplicationContext();
    }

    private void e() {
        if (f6517b == null || com.autonavi.aps.amapapi.utils.j.b() - f6519g > 180000) {
            b f10 = f();
            f6519g = com.autonavi.aps.amapapi.utils.j.b();
            if (f10 == null || !com.autonavi.aps.amapapi.utils.j.a(f10.a())) {
                return;
            }
            f6517b = f10;
        }
    }

    private b f() {
        Throwable th;
        b bVar;
        hh hhVar;
        byte[] b4;
        byte[] b10;
        String str = null;
        if (this.f6525i == null) {
            return null;
        }
        a();
        try {
            hhVar = f6518e;
        } catch (Throwable th2) {
            th = th2;
            bVar = null;
        }
        if (hhVar == null) {
            return null;
        }
        List b11 = hhVar.b("_id=1", b.class);
        if (b11 == null || b11.size() <= 0) {
            bVar = null;
        } else {
            bVar = (b) b11.get(0);
            try {
                byte[] b12 = fn.b(bVar.c());
                String str2 = (b12 == null || b12.length <= 0 || (b10 = a.b(b12, this.f6520a)) == null || b10.length <= 0) ? null : new String(b10, "UTF-8");
                byte[] b13 = fn.b(bVar.b());
                if (b13 != null && b13.length > 0 && (b4 = a.b(b13, this.f6520a)) != null && b4.length > 0) {
                    str = new String(b4, "UTF-8");
                }
                bVar.a(str);
                str = str2;
            } catch (Throwable th3) {
                th = th3;
                com.autonavi.aps.amapapi.utils.b.a(th, "LastLocationManager", "readLastFix");
                return bVar;
            }
        }
        if (!TextUtils.isEmpty(str)) {
            AMapLocation aMapLocation = new AMapLocation("");
            com.autonavi.aps.amapapi.utils.b.a(aMapLocation, new JSONObject(str));
            if (com.autonavi.aps.amapapi.utils.j.b(aMapLocation)) {
                bVar.a(aMapLocation);
            }
        }
        return bVar;
    }

    public final void a() {
        if (this.f6524h) {
            return;
        }
        try {
            if (this.f6520a == null) {
                this.f6520a = a.a("MD5", fm.k());
            }
            if (f6518e == null) {
                f6518e = new hh(this.f6525i, hh.a((Class<? extends hg>) c.class));
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "LastLocationManager", "<init>:DBOperation");
        }
        this.f6524h = true;
    }

    public final AMapLocation b() {
        e();
        b bVar = f6517b;
        if (bVar != null && com.autonavi.aps.amapapi.utils.j.a(bVar.a())) {
            return f6517b.a();
        }
        return null;
    }

    public final void c() {
        try {
            d();
            this.f6523f = 0L;
            this.f6524h = false;
            this.f6521c = null;
            this.f6522d = null;
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "LastLocationManager", LandingPageUtHelper.XAD_UT_LP_DESTROY);
        }
    }

    public final void d() {
        b bVar;
        String str;
        try {
            a();
            b bVar2 = this.f6521c;
            if (bVar2 != null && com.autonavi.aps.amapapi.utils.j.a(bVar2.a()) && f6518e != null && (bVar = this.f6521c) != this.f6522d && bVar.d() == 0) {
                String str2 = this.f6521c.a().toStr();
                String b4 = this.f6521c.b();
                this.f6522d = this.f6521c;
                if (TextUtils.isEmpty(str2)) {
                    str = null;
                } else {
                    String b10 = fn.b(a.a(str2.getBytes("UTF-8"), this.f6520a));
                    str = TextUtils.isEmpty(b4) ? null : fn.b(a.a(b4.getBytes("UTF-8"), this.f6520a));
                    r4 = b10;
                }
                if (TextUtils.isEmpty(r4)) {
                    return;
                }
                b bVar3 = new b();
                bVar3.b(r4);
                bVar3.a(com.autonavi.aps.amapapi.utils.j.b());
                bVar3.a(str);
                f6518e.a(bVar3, "_id=1");
                this.f6523f = com.autonavi.aps.amapapi.utils.j.b();
                b bVar4 = f6517b;
                if (bVar4 != null) {
                    bVar4.a(com.autonavi.aps.amapapi.utils.j.b());
                }
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "LastLocationManager", "saveLastFix");
        }
    }

    public final boolean a(AMapLocation aMapLocation, String str) {
        if (this.f6525i != null && aMapLocation != null && com.autonavi.aps.amapapi.utils.j.a(aMapLocation) && aMapLocation.getLocationType() != 2 && !aMapLocation.isMock() && !aMapLocation.isFixLastLocation()) {
            b bVar = new b();
            bVar.a(aMapLocation);
            if (aMapLocation.getLocationType() == 1) {
                bVar.a((String) null);
            } else {
                bVar.a(str);
            }
            try {
                f6517b = bVar;
                f6519g = com.autonavi.aps.amapapi.utils.j.b();
                this.f6521c = bVar;
                b bVar2 = this.f6522d;
                if (bVar2 != null && com.autonavi.aps.amapapi.utils.j.a(bVar2.a(), bVar.a()) <= 500.0f) {
                    return false;
                }
                if (com.autonavi.aps.amapapi.utils.j.b() - this.f6523f > 30000) {
                    return true;
                }
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "LastLocationManager", "setLastFix");
            }
        }
        return false;
    }

    public final AMapLocation a(AMapLocation aMapLocation, String str, long j10) {
        if (aMapLocation == null || aMapLocation.getErrorCode() == 0 || aMapLocation.getLocationType() == 1 || aMapLocation.getErrorCode() == 7) {
            return aMapLocation;
        }
        try {
            e();
            b bVar = f6517b;
            if (bVar != null && bVar.a() != null) {
                boolean z10 = false;
                if (TextUtils.isEmpty(str)) {
                    long b4 = com.autonavi.aps.amapapi.utils.j.b() - f6517b.d();
                    if (b4 >= 0 && b4 <= j10) {
                        z10 = true;
                    }
                    aMapLocation.setTrustedLevel(3);
                } else {
                    z10 = com.autonavi.aps.amapapi.utils.j.a(f6517b.b(), str);
                    aMapLocation.setTrustedLevel(2);
                }
                if (!z10) {
                    return aMapLocation;
                }
                AMapLocation a10 = f6517b.a();
                try {
                    a10.setLocationType(9);
                    a10.setFixLastLocation(true);
                    a10.setLocationDetail(aMapLocation.getLocationDetail());
                    return a10;
                } catch (Throwable th) {
                    th = th;
                    aMapLocation = a10;
                    com.autonavi.aps.amapapi.utils.b.a(th, "LastLocationManager", "fixLastLocation");
                    return aMapLocation;
                }
            }
            return aMapLocation;
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
