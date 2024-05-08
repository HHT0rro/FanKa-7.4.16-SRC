package com.inno.innosdk.bean;

import android.content.Context;
import android.text.TextUtils;
import com.inno.innosdk.utils.AppInfomation;
import com.inno.innosdk.utils.c;
import com.inno.innosdk.utils.o;
import com.inno.innosdk.utils.q;
import com.inno.innosdk.utils.t.b;
import com.inno.innosdk.utils.u.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class DeviceId extends BaseDevice {
    public String aid;
    public String appsc;

    /* renamed from: ba, reason: collision with root package name */
    public String f35536ba;
    public String bm;
    public String cpui;
    public String dbt;
    public String did;
    public String ds;
    public String imei;
    public String imei2;
    public String imsi;
    public String issr;
    public String jclip;
    public String lua;
    public String mac;
    public String meid;
    public String mia;

    /* renamed from: sc, reason: collision with root package name */
    public String f35537sc;
    public String scb;
    public String sdcid;
    public String sdcsd;
    public String sdr;
    public String sens;
    public String sims;
    public String ss;
    public String usbs;
    public String vo;
    public String wm;
    public String wn;

    public DeviceId(Context context) {
        super(context);
        this.aid = "";
        this.did = "";
        this.imei = "";
        this.imei2 = "";
        this.meid = "";
        this.vo = "";
        loadIdData(context);
    }

    @Override // com.inno.innosdk.bean.BaseDevice
    public Object clone() {
        try {
            return (DeviceId) super.clone();
        } catch (Exception e2) {
            a.a((Throwable) e2);
            return null;
        }
    }

    @Override // com.inno.innosdk.bean.BaseDevice
    public String getValue(BaseDevice baseDevice) {
        return super.getValue(baseDevice);
    }

    public void loadIdData(Context context) {
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
        this.lua = c.a(context).f();
        this.mia = c.a(context).g();
        this.ds = AppInfomation.q() + "," + AppInfomation.p();
        this.appsc = c.a(context).a();
        this.vo = AppInfomation.t(context);
        this.cpui = AppInfomation.o();
        this.scb = String.valueOf(AppInfomation.h(context));
        this.sens = AppInfomation.z(context);
        this.f35537sc = AppInfomation.p(context);
        this.ss = AppInfomation.o(context);
        this.wn = AppInfomation.j(context);
        this.wm = AppInfomation.i(context);
        this.usbs = AppInfomation.r(context);
        this.sims = String.valueOf(o.a(context).k());
        this.f35536ba = c.a(context).d();
        if (b.f35668a) {
            this.sdr = "1";
        }
        this.issr = AppInfomation.q(context);
        this.bm = AppInfomation.g(context);
        if (TextUtils.isEmpty(this.jclip)) {
            this.jclip = q.b(com.inno.innosdk.a.c.k(), "temp_jclip", "");
        }
    }
}
