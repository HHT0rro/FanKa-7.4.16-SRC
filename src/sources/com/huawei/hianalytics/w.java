package com.huawei.hianalytics;

import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class w {

    /* renamed from: a, reason: collision with root package name */
    public Map<String, String> f28847a;
    public x abc;

    /* renamed from: b, reason: collision with root package name */
    public String f28848b;
    public boolean bcd;

    /* renamed from: c, reason: collision with root package name */
    public long f28849c;
    public int cde;

    /* renamed from: d, reason: collision with root package name */
    public String f28850d;
    public int def;

    /* renamed from: e, reason: collision with root package name */
    public boolean f28851e;
    public String efg;
    public String fgh;
    public String ghi;
    public String hij;
    public String ijk;
    public boolean ikl;
    public boolean klm;
    public String lmn;

    public w() {
        this.def = 30;
        this.cde = 7;
        this.bcd = false;
        this.abc = new x();
        this.f28849c = 0L;
        this.f28850d = "";
        this.f28851e = true;
    }

    public void fgh(String str) {
        this.fgh = str;
    }

    public void ghi(String str) {
        this.efg = str;
    }

    public void hij(String str) {
        this.ghi = str;
    }

    public void ijk(String str) {
        this.f28850d = str;
    }

    public void ikl(boolean z10) {
        this.ikl = z10;
    }

    public void klm(boolean z10) {
        this.f28851e = z10;
    }

    public void lmn(Map<String, String> map) {
        this.f28847a = map;
    }

    public void ijk(boolean z10) {
        this.bcd = z10;
    }

    public void ikl(String str) {
        this.hij = str;
    }

    public void klm(String str) {
        this.ijk = str;
    }

    public void lmn(boolean z10) {
        this.klm = z10;
    }

    public void klm(int i10) {
        this.def = i10;
    }

    public void lmn(int i10) {
        this.cde = i10;
    }

    public x lmn() {
        x xVar = this.abc;
        return xVar == null ? new x() : xVar;
    }

    public void lmn(long j10) {
        this.f28849c = j10;
    }

    public void lmn(String str) {
        this.f28848b = str;
    }

    public w(w wVar) {
        this.def = 30;
        this.cde = 7;
        this.bcd = false;
        this.abc = new x();
        this.f28849c = 0L;
        this.f28850d = "";
        this.f28851e = true;
        this.abc = wVar.abc;
        lmn(wVar.klm);
        klm(wVar.ijk);
        ikl(wVar.hij);
        hij(wVar.ghi);
        fgh(wVar.fgh);
        ijk(wVar.f28850d);
        ghi(wVar.efg);
        ikl(wVar.ikl);
        klm(wVar.def);
        lmn(wVar.cde);
        ijk(wVar.bcd);
        lmn(wVar.f28847a);
        lmn(wVar.f28849c);
        lmn(wVar.f28848b);
        klm(wVar.f28851e);
    }
}
