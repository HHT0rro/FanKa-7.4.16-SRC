package com.inno.innosdk.bean;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.inno.innosdk.a.c;
import com.inno.innosdk.b.b;
import com.inno.innosdk.utils.AppInfomation;
import com.inno.innosdk.utils.NativeUtils;
import com.inno.innosdk.utils.d;
import com.inno.innosdk.utils.g;
import com.inno.innosdk.utils.o;
import com.inno.innosdk.utils.q;
import com.inno.innosdk.utils.u.a;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class FyDeviceInfo extends BaseDevice {
    public String abs;
    public String acidSour;
    public String appsInfo;
    public String appsort;
    public String batter;
    public String bdn;
    public String bid;
    public String bp;
    public String bpidnv;
    public String buv;
    public String bv;
    public String cbts;
    public String cpSour;
    public String cpuInfo;
    public String cuidSour;
    public String division;
    public String experiment;
    public String fncuid;
    public String fua;
    public String gi;
    public String gpsInfo;
    public String gyro;
    public String iccid;
    public String inits;
    public String ip6;
    public String ish;
    public String isou;
    public String isr;
    public String isrr;
    public String iss;
    public String issd;
    public String issn;
    public String issnr;
    public String issr;
    public String isvir;
    public String isvir1;
    public String isvir2;
    public String lpt;
    public String lrt;
    public String mpc;
    public String ms;
    public String mua;
    public String netStat;
    public String nw;
    public String ot2;
    public String pid;
    public String pro;
    public String rss;
    public String sav;
    public String sdn;
    public String sdsn;
    public String simuf;
    public String wi;
    public String xjl;

    public FyDeviceInfo() {
        this(c.k(), "", c.f35475c);
    }

    @Override // com.inno.innosdk.bean.BaseDevice
    public Object clone() {
        try {
            return (FyDeviceInfo) super.clone();
        } catch (Exception e2) {
            a.a((Throwable) e2);
            return null;
        }
    }

    @Override // com.inno.innosdk.bean.BaseDevice
    public String getValue(BaseDevice baseDevice) {
        return super.getValue(baseDevice);
    }

    public void loadFyData(Context context) {
        try {
            this.mua = com.inno.innosdk.utils.c.a(context).h();
            this.fua = com.inno.innosdk.utils.c.a(context).e();
            this.appsInfo = com.inno.innosdk.utils.c.a(context).b();
            this.appsort = com.inno.innosdk.utils.c.a(context).c();
            this.rss = AppInfomation.n(context);
            this.ms = AppInfomation.C() + "," + AppInfomation.f(context);
            this.wi = AppInfomation.u(context);
            this.bid = AppInfomation.c(context);
            this.pid = String.valueOf(Process.myPid());
            this.iccid = o.a(context).e();
            this.bv = com.inno.innosdk.b.a.s();
            this.buv = com.inno.innosdk.b.a.r();
            this.bpidnv = com.inno.innosdk.b.a.u();
            this.sav = com.inno.innosdk.b.a.x();
            if (AppInfomation.checkSimulator(context).booleanValue()) {
                this.iss = "1";
                this.issd = g.a(context).g();
                this.issnr = com.inno.innosdk.utils.w.a.o().n();
            } else {
                this.issn = String.valueOf(com.inno.innosdk.utils.w.a.o().p());
                this.issnr = com.inno.innosdk.utils.w.a.o().q();
            }
            this.issr = AppInfomation.q(context);
            this.division = com.inno.innosdk.utils.v.a.a(context).f();
            this.simuf = com.inno.innosdk.utils.w.a.o().m();
            this.abs = com.inno.innosdk.utils.v.a.a(context).b();
            this.bdn = AppInfomation.b(context);
            this.mpc = o.a(context).j();
            this.nw = "";
            this.sdn = AppInfomation.z();
            this.sdsn = AppInfomation.A();
            if (AppInfomation.D() || (!TextUtils.isEmpty(this.appsInfo) && this.appsInfo.toLowerCase().contains("supersu"))) {
                this.isr = "1";
            }
            if (AppInfomation.w(context)) {
                this.ish = "1";
            }
            this.isrr = AppInfomation.r();
            this.gi = o.a(context).d();
            this.cpuInfo = AppInfomation.m();
            String m10 = AppInfomation.m(context);
            this.pro = m10;
            this.bp = AppInfomation.a(m10, com.inno.innosdk.b.a.o());
            if (d.b()) {
                this.isvir = "1";
            } else {
                this.isvir = "";
            }
            String str = this.cid;
            if (str != null && AppInfomation.d(str)) {
                this.isvir1 = "1";
            }
            if (this.pro.toLowerCase().contains("xposed")) {
                this.ish = "1";
            }
            if (AppInfomation.B().toLowerCase().contains("xposed")) {
                this.ish = "1";
            }
            if (AppInfomation.s().toLowerCase().contains("xposed")) {
                this.ish = "1";
            }
            if (TextUtils.isEmpty(this.bp)) {
                this.pro = null;
            }
            if (AppInfomation.x(context)) {
                this.isou = "1";
            }
            this.cuidSour = q.b(c.k(), "inno_cuidSour", "0");
            this.acidSour = q.b(c.k(), "inno_acidSour", "0");
            this.cpSour = q.b(c.k(), "inno_cpSour", "0");
            this.ip6 = q.a(c.k(), "inno_ipv6", "");
            String i10 = com.inno.innosdk.b.a.i();
            if (i10.endsWith("|")) {
                i10 = i10.substring(0, i10.length() - 1);
            }
            this.batter = i10;
            this.xjl = com.inno.innosdk.b.a.n();
            if (TextUtils.isEmpty(NativeUtils.f35552a)) {
                NativeUtils.a();
            }
            this.fncuid = NativeUtils.f35552a;
            if (com.inno.innosdk.a.a.a()) {
                this.experiment = "1";
            } else {
                this.experiment = "0";
            }
        } catch (Exception e2) {
            a.a((Throwable) e2);
        }
    }

    public void reloadSomeData() {
        if (TextUtils.isEmpty(this.acid)) {
            this.acid = b.d();
        }
        if (TextUtils.isEmpty(this.ncuid)) {
            this.ncuid = AppInfomation.v(c.k());
            this.ncuidsrc = AppInfomation.v();
        }
        if (TextUtils.isEmpty(this.openid)) {
            this.openid = b.a(c.k());
        }
    }

    public FyDeviceInfo(String str) {
        this(c.k(), str, c.f35475c);
    }

    public FyDeviceInfo(Context context, String str, Map<String, Object> map) {
        super(context);
        this.wi = "";
        this.pro = "";
        this.nw = "";
        this.cuidSour = "";
        this.acidSour = "";
        this.cpSour = "";
        this.ip6 = "";
        this.pid = "";
        this.bpidnv = "";
        this.division = "";
        this.act = str;
        setCp(map);
    }
}
