package com.huawei.openalliance.ad.constant;

import com.huawei.hms.ads.gl;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class bj {
    private static final String Code = "PlacementPlayState";
    private final byte[] I;
    private a V;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public enum a {
        SINGLE_INST,
        MAIN_VIEW,
        BACKUP_VIEW
    }

    public bj() {
        this.V = a.SINGLE_INST;
        this.I = new byte[0];
    }

    public bj(a aVar) {
        a aVar2 = a.SINGLE_INST;
        this.I = new byte[0];
        this.V = aVar;
    }

    public a Code() {
        a aVar;
        synchronized (this.I) {
            aVar = this.V;
        }
        return aVar;
    }

    public void Code(a aVar) {
        if (aVar == null) {
            return;
        }
        synchronized (this.I) {
            gl.V(Code, "switch to state: %s", aVar);
            this.V = aVar;
        }
    }

    public boolean I(a aVar) {
        boolean z10;
        synchronized (this.I) {
            z10 = !V(aVar);
        }
        return z10;
    }

    public boolean V(a aVar) {
        boolean z10;
        synchronized (this.I) {
            z10 = aVar == this.V;
        }
        return z10;
    }
}
