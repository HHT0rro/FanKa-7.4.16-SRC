package com.cupidapp.live.feed.layout;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FeedTopRcmdLiveLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f14595a;

    public i(boolean z10) {
        this.f14595a = z10;
    }

    public final boolean a() {
        return this.f14595a;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof i) && this.f14595a == ((i) obj).f14595a;
    }

    public int hashCode() {
        boolean z10 = this.f14595a;
        if (z10) {
            return 1;
        }
        return z10 ? 1 : 0;
    }

    @NotNull
    public String toString() {
        return "FeedViewShowChanged(show=" + this.f14595a + ")";
    }
}
