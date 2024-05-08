package com.alibaba.security.biometrics.service.model.detector;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class MineInfo implements Serializable {
    private static final long serialVersionUID = 1;
    public int mt;

    /* renamed from: t, reason: collision with root package name */
    public long f2884t;

    public MineInfo(int i10, long j10) {
        this.mt = i10;
        this.f2884t = j10;
    }

    public int getMt() {
        return this.mt;
    }

    public long getT() {
        return this.f2884t;
    }

    public void setMt(int i10) {
        this.mt = i10;
    }

    public void setT(long j10) {
        this.f2884t = j10;
    }

    public String toString() {
        return "Mine [minetype=" + this.mt + "(0:ACTIONBLEND,1:NOTVIDEO,2:TIMEOUT,3:NOTLIVE,4:BADCOLOR,5:BAD3D,-1:UNKNOWN), time=" + new SimpleDateFormat("yyyyMMdd_HHmmss.SSS", Locale.getDefault()).format(new Date(this.f2884t)) + "]";
    }
}
