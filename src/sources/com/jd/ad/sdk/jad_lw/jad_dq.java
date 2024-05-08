package com.jd.ad.sdk.jad_lw;

import com.jd.ad.sdk.jad_lw.jad_mz;
import java.util.Queue;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class jad_dq<T extends jad_mz> {
    public final Queue<T> jad_an = com.jd.ad.sdk.jad_gp.jad_ly.jad_an(20);

    public abstract T jad_an();

    public T jad_bo() {
        T poll = this.jad_an.poll();
        return poll == null ? jad_an() : poll;
    }
}
