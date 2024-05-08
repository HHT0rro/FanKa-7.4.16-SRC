package com.kwad.sdk.core.videocache.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class g extends e {
    private final long maxSize;

    public g(long j10) {
        if (j10 > 0) {
            this.maxSize = j10;
            return;
        }
        throw new IllegalArgumentException("Max size must be positive number!");
    }

    @Override // com.kwad.sdk.core.videocache.a.e
    public final boolean au(long j10) {
        return j10 <= this.maxSize;
    }
}
