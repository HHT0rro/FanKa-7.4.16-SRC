package com.google.android.exoplayer2.drm;

import android.media.MediaDrmException;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import b5.v;
import b5.z;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.g;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: DummyExoMediaDrm.java */
@RequiresApi(18)
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class e implements g {
    @Override // com.google.android.exoplayer2.drm.g
    public Class<z> a() {
        return z.class;
    }

    @Override // com.google.android.exoplayer2.drm.g
    public Map<String, String> b(byte[] bArr) {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.drm.g
    public g.d c() {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.drm.g
    public byte[] d() throws MediaDrmException {
        throw new MediaDrmException("Attempting to open a session using a dummy ExoMediaDrm.");
    }

    @Override // com.google.android.exoplayer2.drm.g
    public void e(byte[] bArr, byte[] bArr2) {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.drm.g
    public void f(@Nullable g.b bVar) {
    }

    @Override // com.google.android.exoplayer2.drm.g
    @Nullable
    public byte[] g(byte[] bArr, byte[] bArr2) {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.drm.g
    public v h(byte[] bArr) {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.drm.g
    public void i(byte[] bArr) {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.drm.g
    public void j(byte[] bArr) {
    }

    @Override // com.google.android.exoplayer2.drm.g
    public g.a k(byte[] bArr, @Nullable List<DrmInitData.SchemeData> list, int i10, @Nullable HashMap<String, String> hashMap) {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.drm.g
    public void release() {
    }
}
