package com.inno.innosdk.bean;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.alibaba.security.realidentity.common.BuildConfig;
import com.inno.innosdk.a.c;
import com.inno.innosdk.b.b;
import com.inno.innosdk.utils.AppInfomation;
import com.inno.innosdk.utils.o;
import com.inno.innosdk.utils.q;
import com.inno.innosdk.utils.u.a;
import java.lang.reflect.Field;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class BaseDevice implements Cloneable {
    public static String mycv = "1.0.0";
    public String account;
    public String acid;
    public String act;
    public String appKey;
    public String appsc;
    public String av;
    public String avn;

    /* renamed from: ba, reason: collision with root package name */
    public String f35532ba;
    public String bm;
    public String cerr;
    public String cid;
    public String cp;
    public String cpui;
    public String cuid;
    public String dbt;
    public String ds;
    public String imsi;
    public String issr;
    public String jclip;
    public String lerr;
    public String lua;
    public String mac;
    public String mia;
    public String ncuid;
    public String ncuidsrc;
    public String nt;
    public String openid;
    public String pidn;
    public String product;

    /* renamed from: sc, reason: collision with root package name */
    public String f35535sc;
    public String scb;
    public String scshot;
    public String sdcid;
    public String sdcsd;
    public String sdr;
    public String sens;
    public String sims;
    public String ss;
    public String usbs;
    public String wm;
    public String wn;
    public String cv = BuildConfig.VERSION_NAME;
    public long ot = System.currentTimeMillis();

    /* renamed from: o, reason: collision with root package name */
    public String f35533o = Build.VERSION.RELEASE;

    /* renamed from: o2, reason: collision with root package name */
    public String f35534o2 = String.valueOf(Build.VERSION.SDK_INT);
    public String brand = Build.BRAND;
    public String mf = Build.MANUFACTURER;
    public String dme = Build.MODEL;
    public String hardware = Build.HARDWARE;
    public String aid = "";
    public String did = "";
    public String imei = "";
    public String imei2 = "";
    public String meid = "";
    public String vo = "";

    public BaseDevice(Context context) {
        loadBaseData(context);
    }

    public Object clone() {
        try {
            return (BaseDevice) super.clone();
        } catch (Exception e2) {
            a.a((Throwable) e2);
            return null;
        }
    }

    public String getValue(BaseDevice baseDevice) {
        Map<String, Boolean> p10 = com.inno.innosdk.b.a.p();
        StringBuilder sb2 = new StringBuilder();
        try {
            String name = BaseDevice.class.getSuperclass().getName();
            for (Class<?> cls = baseDevice.getClass(); cls != null; cls = cls.getSuperclass()) {
                if (name.equals(cls.getName())) {
                    break;
                }
                for (Field field : cls.getDeclaredFields()) {
                    field.setAccessible(true);
                    try {
                        if (p10.get(field.getName()) == null && field.get(baseDevice) != null && !"".equals(field.get(baseDevice).toString())) {
                            if (sb2.length() > 0) {
                                sb2.append((char) 30);
                            }
                            String replace = field.get(baseDevice).toString().replace((char) 30, ' ').replace((char) 31, ' ');
                            sb2.append(field.getName());
                            sb2.append((char) 31);
                            sb2.append(replace);
                        }
                    } catch (IllegalAccessException e2) {
                        a.a((Throwable) e2);
                    }
                }
            }
        } catch (Throwable th) {
            a.a(th);
        }
        return sb2.toString();
    }

    public boolean isEmpty() {
        return TextUtils.isEmpty(this.ncuid) || TextUtils.isEmpty(this.cuid) || TextUtils.isEmpty(this.cid);
    }

    public void loadBaseData(Context context) {
        this.account = c.h();
        this.product = c.q();
        this.cid = c.j();
        this.appKey = c.i();
        this.av = AppInfomation.e(context);
        this.avn = AppInfomation.d(context);
        this.acid = b.d();
        this.ncuid = AppInfomation.v(context);
        this.ncuidsrc = AppInfomation.v();
        this.cuid = AppInfomation.s(context);
        this.openid = b.a(context);
        this.nt = String.valueOf(System.currentTimeMillis());
        this.pidn = AppInfomation.l(context);
        this.scshot = q.b(c.k(), "inno_scshot", "0");
        this.dbt = String.valueOf(AppInfomation.k());
        this.mac = AppInfomation.u();
        this.aid = AppInfomation.a(context);
        this.did = AppInfomation.k(context);
        this.imei = o.a(context).f();
        this.imei2 = o.a(context).g();
        this.meid = o.a(context).i();
        this.imsi = o.a(context).h();
        this.sdcid = AppInfomation.x();
        this.sdcsd = AppInfomation.y();
        this.lua = com.inno.innosdk.utils.c.a(context).f();
        this.mia = com.inno.innosdk.utils.c.a(context).g();
        this.ds = AppInfomation.q() + "," + AppInfomation.p();
        this.appsc = com.inno.innosdk.utils.c.a(context).a();
        this.vo = AppInfomation.t(context);
        this.cpui = AppInfomation.o();
        this.scb = String.valueOf(AppInfomation.h(context));
        this.sens = AppInfomation.z(context);
        this.f35535sc = AppInfomation.p(context);
        this.ss = AppInfomation.o(context);
        this.wn = AppInfomation.j(context);
        this.wm = AppInfomation.i(context);
        this.usbs = AppInfomation.r(context);
        this.sims = String.valueOf(o.a(context).k());
        this.f35532ba = com.inno.innosdk.utils.c.a(context).d();
        if (com.inno.innosdk.utils.t.b.f35668a) {
            this.sdr = "1";
        }
        this.issr = AppInfomation.q(context);
        this.bm = AppInfomation.g(context);
        if (TextUtils.isEmpty(this.jclip)) {
            this.jclip = q.b(c.k(), "temp_jclip", "");
        }
    }

    public void setCp(Map<String, Object> map) {
        if (map != null) {
            try {
                if (map.size() != 0) {
                    StringBuilder sb2 = new StringBuilder();
                    for (String str : map.h()) {
                        sb2.append(str);
                        sb2.append("=");
                        sb2.append(map.get(str));
                        sb2.append("&");
                    }
                    String sb3 = sb2.toString();
                    this.cp = sb3;
                    if (sb3.endsWith("&")) {
                        this.cp = this.cp.substring(0, r6.length() - 1);
                        return;
                    }
                    return;
                }
            } catch (Throwable th) {
                a.a(th);
                return;
            }
        }
        this.cp = "";
    }
}
