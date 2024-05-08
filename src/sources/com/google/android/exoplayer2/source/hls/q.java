package com.google.android.exoplayer2.source.hls;

import android.util.SparseArray;
import com.google.android.exoplayer2.util.f0;

/* compiled from: TimestampAdjusterProvider.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public final SparseArray<f0> f21732a = new SparseArray<>();

    public f0 a(int i10) {
        f0 f0Var = this.f21732a.get(i10);
        if (f0Var != null) {
            return f0Var;
        }
        f0 f0Var2 = new f0(9223372036854775806L);
        this.f21732a.put(i10, f0Var2);
        return f0Var2;
    }

    public void b() {
        this.f21732a.clear();
    }
}
