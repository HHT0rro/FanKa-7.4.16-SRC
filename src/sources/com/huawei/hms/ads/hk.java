package com.huawei.hms.ads;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class hk {
    private static final String Code = "VideoMonitor";
    private String C;
    private boolean V = false;
    private boolean I = false;
    private long Z = 0;
    private long B = 0;

    public hk(String str) {
        this.C = "VideoMonitor_" + str;
    }

    public long B() {
        return this.B;
    }

    public void Code() {
        if (gl.Code()) {
            gl.Code(this.C, "onPlayStart");
        }
        if (this.I) {
            return;
        }
        this.I = true;
        this.B = System.currentTimeMillis();
    }

    public void I() {
        if (gl.Code()) {
            gl.Code(this.C, "onVideoEnd");
        }
        this.I = false;
        this.V = false;
        this.Z = 0L;
        this.B = 0L;
    }

    public void V() {
        if (gl.Code()) {
            gl.Code(this.C, "onBufferStart");
        }
        if (this.V) {
            return;
        }
        this.V = true;
        this.Z = System.currentTimeMillis();
    }

    public long Z() {
        return this.Z;
    }
}
