package com.jd.ad.sdk.jad_ep;

import com.jd.ad.sdk.jad_ep.jad_kx;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class jad_kx<CHILD extends jad_kx<CHILD, TranscodeType>, TranscodeType> implements Cloneable {
    public Object clone() {
        try {
            return (jad_kx) super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    public final CHILD jad_an() {
        try {
            return (CHILD) super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }
}
