package com.google.android.exoplayer2.drm;

import androidx.annotation.Nullable;
import b5.v;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.b;
import java.util.Map;
import java.util.UUID;

/* compiled from: ErrorStateDrmSession.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class f implements DrmSession {

    /* renamed from: a, reason: collision with root package name */
    public final DrmSession.DrmSessionException f19977a;

    public f(DrmSession.DrmSessionException drmSessionException) {
        this.f19977a = (DrmSession.DrmSessionException) com.google.android.exoplayer2.util.a.e(drmSessionException);
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public void a(@Nullable b.a aVar) {
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public boolean b() {
        return false;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    @Nullable
    public Map<String, String> c() {
        return null;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public void d(@Nullable b.a aVar) {
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public final UUID e() {
        return com.google.android.exoplayer2.h.f20704a;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    @Nullable
    public v f() {
        return null;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    @Nullable
    public DrmSession.DrmSessionException getError() {
        return this.f19977a;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public int getState() {
        return 1;
    }
}
