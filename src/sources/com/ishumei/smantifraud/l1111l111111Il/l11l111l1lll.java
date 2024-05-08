package com.ishumei.smantifraud.l1111l111111Il;

import com.ishumei.smantifraud.VDataListener;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class l11l111l1lll {
    public VDataListener mListener;

    public void register(VDataListener vDataListener) {
        this.mListener = vDataListener;
    }

    public void unregister() {
        this.mListener = null;
    }
}
