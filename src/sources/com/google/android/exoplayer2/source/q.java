package com.google.android.exoplayer2.source;

import androidx.annotation.Nullable;
import com.android.internal.logging.nano.MetricsProto;

/* compiled from: MediaPeriodId.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class q {

    /* renamed from: a, reason: collision with root package name */
    public final Object f21883a;

    /* renamed from: b, reason: collision with root package name */
    public final int f21884b;

    /* renamed from: c, reason: collision with root package name */
    public final int f21885c;

    /* renamed from: d, reason: collision with root package name */
    public final long f21886d;

    /* renamed from: e, reason: collision with root package name */
    public final int f21887e;

    public q(Object obj) {
        this(obj, -1L);
    }

    public q a(Object obj) {
        return this.f21883a.equals(obj) ? this : new q(obj, this.f21884b, this.f21885c, this.f21886d, this.f21887e);
    }

    public boolean b() {
        return this.f21884b != -1;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        return this.f21883a.equals(qVar.f21883a) && this.f21884b == qVar.f21884b && this.f21885c == qVar.f21885c && this.f21886d == qVar.f21886d && this.f21887e == qVar.f21887e;
    }

    public int hashCode() {
        return ((((((((MetricsProto.MetricsEvent.DIALOG_SUPPORT_PHONE + this.f21883a.hashCode()) * 31) + this.f21884b) * 31) + this.f21885c) * 31) + ((int) this.f21886d)) * 31) + this.f21887e;
    }

    public q(Object obj, long j10) {
        this(obj, -1, -1, j10, -1);
    }

    public q(Object obj, long j10, int i10) {
        this(obj, -1, -1, j10, i10);
    }

    public q(Object obj, int i10, int i11, long j10) {
        this(obj, i10, i11, j10, -1);
    }

    public q(q qVar) {
        this.f21883a = qVar.f21883a;
        this.f21884b = qVar.f21884b;
        this.f21885c = qVar.f21885c;
        this.f21886d = qVar.f21886d;
        this.f21887e = qVar.f21887e;
    }

    public q(Object obj, int i10, int i11, long j10, int i12) {
        this.f21883a = obj;
        this.f21884b = i10;
        this.f21885c = i11;
        this.f21886d = j10;
        this.f21887e = i12;
    }
}
