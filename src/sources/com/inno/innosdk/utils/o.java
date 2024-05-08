package com.inno.innosdk.utils;

import android.content.Context;
import android.os.Build;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.util.List;

/* compiled from: TelephonyInfos.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class o {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f35641a = {"000000000000000", "e21833235b6eef10", "012345678912345"};

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f35642b = {"310260000000000"};

    /* renamed from: c, reason: collision with root package name */
    public static volatile o f35643c;

    /* renamed from: d, reason: collision with root package name */
    public String f35644d;

    /* renamed from: e, reason: collision with root package name */
    public String f35645e = "";

    /* renamed from: f, reason: collision with root package name */
    public String f35646f = "";

    /* renamed from: g, reason: collision with root package name */
    public int f35647g;

    /* renamed from: h, reason: collision with root package name */
    public String f35648h;

    /* renamed from: i, reason: collision with root package name */
    public String f35649i;

    /* renamed from: j, reason: collision with root package name */
    public String f35650j;

    /* renamed from: k, reason: collision with root package name */
    public String f35651k;

    /* renamed from: l, reason: collision with root package name */
    public String f35652l;

    /* renamed from: m, reason: collision with root package name */
    public String f35653m;

    /* renamed from: n, reason: collision with root package name */
    public String f35654n;

    /* renamed from: o, reason: collision with root package name */
    public String f35655o;

    public o(Context context) {
        this.f35644d = null;
        this.f35647g = 0;
        this.f35648h = null;
        this.f35649i = "";
        this.f35650j = "";
        this.f35651k = "";
        this.f35652l = "";
        this.f35653m = "";
        this.f35654n = "";
        this.f35655o = "";
        if (com.inno.innosdk.a.c.l() != null) {
            this.f35644d = com.inno.innosdk.a.c.l().getImei();
        }
        if (this.f35648h == null && com.inno.innosdk.a.c.l() != null) {
            this.f35648h = com.inno.innosdk.a.c.l().getImsi();
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager != null) {
            try {
                if (q.a(context, com.kuaishou.weapon.p0.g.f36117c)) {
                    this.f35650j = telephonyManager.getSimSerialNumber();
                }
                this.f35647g = telephonyManager.getSimState();
                this.f35649i = telephonyManager.getSimOperator();
                this.f35651k = telephonyManager.getNetworkOperatorName();
                String networkOperator = telephonyManager.getNetworkOperator();
                this.f35653m = networkOperator;
                if (networkOperator.length() >= 5) {
                    this.f35654n = this.f35653m.substring(0, 3);
                    this.f35655o = this.f35653m.substring(3, 5);
                }
                this.f35652l = a(context, telephonyManager);
            } catch (Exception e2) {
                com.inno.innosdk.utils.u.a.a((Throwable) e2);
            }
        }
    }

    public static o a(Context context) {
        if (f35643c == null) {
            synchronized (o.class) {
                if (f35643c == null) {
                    f35643c = new o(context);
                }
            }
        }
        return f35643c;
    }

    public boolean b() {
        for (String str : f35642b) {
            if (str.equalsIgnoreCase(this.f35648h)) {
                return true;
            }
        }
        return false;
    }

    public boolean c() {
        return "android".equalsIgnoreCase(this.f35651k);
    }

    public String d() {
        return this.f35652l;
    }

    public String e() {
        return a(this.f35650j);
    }

    public String f() {
        return a(this.f35644d);
    }

    public String g() {
        return a(this.f35645e);
    }

    public String h() {
        return this.f35648h;
    }

    public String i() {
        return a(this.f35646f);
    }

    public String j() {
        String str = this.f35649i;
        return str == null ? "0" : str;
    }

    public int k() {
        return this.f35647g;
    }

    public String toString() {
        return "TelephonyInfos{imei='" + this.f35644d + "', imei2='" + this.f35645e + "', meid='" + this.f35646f + "', sims=" + this.f35647g + ", imsi='" + this.f35648h + "', mpc='" + this.f35649i + "', iccid='" + this.f35650j + "', operatorName='" + this.f35651k + "', cellLocation='" + this.f35652l + "', operator='" + this.f35653m + "', mcc='" + this.f35654n + "', mnc='" + this.f35655o + "'}";
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str) || str.contains("unknown") || str.contains("null") || str.contains("nil")) {
            return "";
        }
        int i10 = 0;
        for (int i11 = 0; i11 <= str.length() - 1; i11++) {
            if ('0' == str.charAt(i11) && (i10 = i10 + 1) > str.length() / 2) {
                return "";
            }
        }
        return str;
    }

    private String a(Context context, TelephonyManager telephonyManager) {
        if (Build.BRAND.contains("samsung") && Build.VERSION.SDK_INT == 23) {
            return "";
        }
        try {
            StringBuilder sb2 = new StringBuilder();
            if (!q.a(context, com.kuaishou.weapon.p0.g.f36122h) && !q.a(context, com.kuaishou.weapon.p0.g.f36121g)) {
                return "";
            }
            try {
                List<CellInfo> allCellInfo = telephonyManager.getAllCellInfo();
                if (allCellInfo != null) {
                    int i10 = 0;
                    int i11 = 0;
                    int i12 = 0;
                    for (CellInfo cellInfo : allCellInfo) {
                        if (cellInfo.toString().contains("CellInfoLte")) {
                            CellInfoLte cellInfoLte = (CellInfoLte) cellInfo;
                            CellIdentityLte cellIdentity = cellInfoLte.getCellIdentity();
                            i11 = cellIdentity.getCi();
                            i10 = cellIdentity.getTac();
                            i12 = cellInfoLte.getCellSignalStrength().getDbm();
                        } else if (cellInfo.toString().contains("CellInfoGsm")) {
                            CellInfoGsm cellInfoGsm = (CellInfoGsm) cellInfo;
                            CellIdentityGsm cellIdentity2 = cellInfoGsm.getCellIdentity();
                            i11 = cellIdentity2.getCid();
                            i10 = cellIdentity2.getLac();
                            i12 = cellInfoGsm.getCellSignalStrength().getDbm();
                        } else if (cellInfo.toString().contains("CellInfoCdma")) {
                            CellInfoCdma cellInfoCdma = (CellInfoCdma) cellInfo;
                            int basestationId = cellInfoCdma.getCellIdentity().getBasestationId();
                            i12 = cellInfoCdma.getCellSignalStrength().getDbm();
                            i11 = basestationId;
                            i10 = 0;
                        }
                        sb2.append(",");
                        sb2.append("{");
                        sb2.append(i10);
                        sb2.append(",");
                        sb2.append(i11);
                        sb2.append(",");
                        sb2.append(i12);
                        sb2.append(com.alipay.sdk.util.i.f4738d);
                    }
                }
            } catch (Exception e2) {
                com.inno.innosdk.utils.u.a.a((Throwable) e2);
            }
            return sb2.toString();
        } catch (Exception e10) {
            com.inno.innosdk.utils.u.a.a((Throwable) e10);
            return "";
        }
    }

    public boolean a() {
        for (String str : f35641a) {
            if (str.equalsIgnoreCase(this.f35644d)) {
                return true;
            }
        }
        return false;
    }
}
