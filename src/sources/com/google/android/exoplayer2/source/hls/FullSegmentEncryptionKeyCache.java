package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FullSegmentEncryptionKeyCache {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashMap<Uri, byte[]> f21450a;

    public FullSegmentEncryptionKeyCache(final int i10) {
        this.f21450a = new LinkedHashMap<Uri, byte[]>(this, i10 + 1, 1.0f, false) { // from class: com.google.android.exoplayer2.source.hls.FullSegmentEncryptionKeyCache.1
            @Override // java.util.LinkedHashMap
            public boolean removeEldestEntry(Map.Entry<Uri, byte[]> entry) {
                return size() > i10;
            }
        };
    }

    @Nullable
    public byte[] a(@Nullable Uri uri) {
        if (uri == null) {
            return null;
        }
        return this.f21450a.get(uri);
    }

    @Nullable
    public byte[] b(Uri uri, byte[] bArr) {
        return this.f21450a.put((Uri) com.google.android.exoplayer2.util.a.e(uri), (byte[]) com.google.android.exoplayer2.util.a.e(bArr));
    }

    @Nullable
    public byte[] c(Uri uri) {
        return this.f21450a.remove(com.google.android.exoplayer2.util.a.e(uri));
    }
}
