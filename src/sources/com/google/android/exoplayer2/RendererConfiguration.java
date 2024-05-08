package com.google.android.exoplayer2;

import androidx.annotation.Nullable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class RendererConfiguration {

    /* renamed from: b, reason: collision with root package name */
    public static final RendererConfiguration f19651b = new RendererConfiguration(false);

    /* renamed from: a, reason: collision with root package name */
    public final boolean f19652a;

    public RendererConfiguration(boolean z10) {
        this.f19652a = z10;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && RendererConfiguration.class == obj.getClass() && this.f19652a == ((RendererConfiguration) obj).f19652a;
    }

    public int hashCode() {
        return !this.f19652a ? 1 : 0;
    }
}
