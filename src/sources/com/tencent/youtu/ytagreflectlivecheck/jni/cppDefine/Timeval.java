package com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class Timeval {
    public final long tvSec;
    public final int tvUsec;

    public Timeval(long j10, int i10) {
        this.tvSec = j10;
        this.tvUsec = i10;
    }

    public String toString() {
        return "Timeval{tvSec=" + this.tvSec + ", tvUsec=" + this.tvUsec + '}';
    }
}
