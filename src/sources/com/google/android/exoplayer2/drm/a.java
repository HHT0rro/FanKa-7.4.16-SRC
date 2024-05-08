package com.google.android.exoplayer2.drm;

import android.net.Uri;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import b5.u;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.e;
import com.google.android.exoplayer2.util.j0;
import com.google.android.exoplayer2.w0;
import com.google.common.primitives.Ints;
import java.util.Map;

/* compiled from: DefaultDrmSessionManagerProvider.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class a implements u {

    /* renamed from: a, reason: collision with root package name */
    public final Object f19964a = new Object();

    /* renamed from: b, reason: collision with root package name */
    @GuardedBy("lock")
    public w0.e f19965b;

    /* renamed from: c, reason: collision with root package name */
    @GuardedBy("lock")
    public c f19966c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public HttpDataSource.a f19967d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public String f19968e;

    @Override // b5.u
    public c a(w0 w0Var) {
        c cVar;
        com.google.android.exoplayer2.util.a.e(w0Var.f23163b);
        w0.e eVar = w0Var.f23163b.f23218c;
        if (eVar != null && j0.f22990a >= 18) {
            synchronized (this.f19964a) {
                if (!j0.c(eVar, this.f19965b)) {
                    this.f19965b = eVar;
                    this.f19966c = b(eVar);
                }
                cVar = (c) com.google.android.exoplayer2.util.a.e(this.f19966c);
            }
            return cVar;
        }
        return c.f19974a;
    }

    @RequiresApi(18)
    public final c b(w0.e eVar) {
        HttpDataSource.a aVar = this.f19967d;
        if (aVar == null) {
            aVar = new e.b().e(this.f19968e);
        }
        Uri uri = eVar.f23202b;
        i iVar = new i(uri == null ? null : uri.toString(), eVar.f23206f, aVar);
        for (Map.Entry<String, String> entry : eVar.f23203c.entrySet()) {
            iVar.e(entry.getKey(), entry.getValue());
        }
        DefaultDrmSessionManager a10 = new DefaultDrmSessionManager.b().e(eVar.f23201a, h.f19983d).b(eVar.f23204d).c(eVar.f23205e).d(Ints.m(eVar.f23207g)).a(iVar);
        a10.D(0, eVar.a());
        return a10;
    }
}
