package com.google.android.gms.common.api.internal;

import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class j<L> {

    /* renamed from: a, reason: collision with root package name */
    public final L f23468a;

    /* renamed from: b, reason: collision with root package name */
    public final String f23469b;

    @RecentlyNonNull
    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return this.f23468a == jVar.f23468a && this.f23469b.equals(jVar.f23469b);
    }

    @RecentlyNonNull
    public final int hashCode() {
        return (System.identityHashCode(this.f23468a) * 31) + this.f23469b.hashCode();
    }
}
