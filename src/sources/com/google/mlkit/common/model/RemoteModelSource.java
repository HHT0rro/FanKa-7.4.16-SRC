package com.google.mlkit.common.model;

import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.internal.g;
import com.google.android.gms.internal.mlkit_common.r0;
import com.google.android.gms.internal.mlkit_common.s0;

/* compiled from: com.google.mlkit:common@@17.1.1 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class RemoteModelSource {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public final String f27035a;

    @RecentlyNullable
    public final String a() {
        return this.f27035a;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        return g.a(this.f27035a, ((RemoteModelSource) obj).f27035a);
    }

    public int hashCode() {
        return g.b(this.f27035a);
    }

    @RecentlyNonNull
    public String toString() {
        r0 b4 = s0.b("RemoteModelSource");
        b4.a("firebaseModelName", this.f27035a);
        return b4.toString();
    }
}
