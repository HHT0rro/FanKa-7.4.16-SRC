package com.google.android.exoplayer2.upstream;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.j0;
import com.google.android.exoplayer2.util.m;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import o6.v;

/* compiled from: DefaultDataSource.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class c implements a {

    /* renamed from: a, reason: collision with root package name */
    public final Context f22788a;

    /* renamed from: b, reason: collision with root package name */
    public final List<v> f22789b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final a f22790c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public a f22791d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public a f22792e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public a f22793f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public a f22794g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public a f22795h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    public a f22796i;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    public a f22797j;

    /* renamed from: k, reason: collision with root package name */
    @Nullable
    public a f22798k;

    public c(Context context, a aVar) {
        this.f22788a = context.getApplicationContext();
        this.f22790c = (a) com.google.android.exoplayer2.util.a.e(aVar);
    }

    public final void A(@Nullable a aVar, v vVar) {
        if (aVar != null) {
            aVar.d(vVar);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public long a(b bVar) throws IOException {
        com.google.android.exoplayer2.util.a.g(this.f22798k == null);
        String scheme = bVar.f22767a.getScheme();
        if (j0.q0(bVar.f22767a)) {
            String path = bVar.f22767a.getPath();
            if (path != null && path.startsWith("/android_asset/")) {
                this.f22798k = t();
            } else {
                this.f22798k = w();
            }
        } else if ("asset".equals(scheme)) {
            this.f22798k = t();
        } else if ("content".equals(scheme)) {
            this.f22798k = u();
        } else if ("rtmp".equals(scheme)) {
            this.f22798k = y();
        } else if ("udp".equals(scheme)) {
            this.f22798k = z();
        } else if ("data".equals(scheme)) {
            this.f22798k = v();
        } else if (!"rawresource".equals(scheme) && !"android.resource".equals(scheme)) {
            this.f22798k = this.f22790c;
        } else {
            this.f22798k = x();
        }
        return this.f22798k.a(bVar);
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public void close() throws IOException {
        a aVar = this.f22798k;
        if (aVar != null) {
            try {
                aVar.close();
            } finally {
                this.f22798k = null;
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public void d(v vVar) {
        com.google.android.exoplayer2.util.a.e(vVar);
        this.f22790c.d(vVar);
        this.f22789b.add(vVar);
        A(this.f22791d, vVar);
        A(this.f22792e, vVar);
        A(this.f22793f, vVar);
        A(this.f22794g, vVar);
        A(this.f22795h, vVar);
        A(this.f22796i, vVar);
        A(this.f22797j, vVar);
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public Map<String, List<String>> e() {
        a aVar = this.f22798k;
        return aVar == null ? Collections.emptyMap() : aVar.e();
    }

    @Override // com.google.android.exoplayer2.upstream.a
    @Nullable
    public Uri i() {
        a aVar = this.f22798k;
        if (aVar == null) {
            return null;
        }
        return aVar.i();
    }

    public final void n(a aVar) {
        for (int i10 = 0; i10 < this.f22789b.size(); i10++) {
            aVar.d(this.f22789b.get(i10));
        }
    }

    @Override // o6.g
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        return ((a) com.google.android.exoplayer2.util.a.e(this.f22798k)).read(bArr, i10, i11);
    }

    public final a t() {
        if (this.f22792e == null) {
            AssetDataSource assetDataSource = new AssetDataSource(this.f22788a);
            this.f22792e = assetDataSource;
            n(assetDataSource);
        }
        return this.f22792e;
    }

    public final a u() {
        if (this.f22793f == null) {
            ContentDataSource contentDataSource = new ContentDataSource(this.f22788a);
            this.f22793f = contentDataSource;
            n(contentDataSource);
        }
        return this.f22793f;
    }

    public final a v() {
        if (this.f22796i == null) {
            o6.h hVar = new o6.h();
            this.f22796i = hVar;
            n(hVar);
        }
        return this.f22796i;
    }

    public final a w() {
        if (this.f22791d == null) {
            FileDataSource fileDataSource = new FileDataSource();
            this.f22791d = fileDataSource;
            n(fileDataSource);
        }
        return this.f22791d;
    }

    public final a x() {
        if (this.f22797j == null) {
            RawResourceDataSource rawResourceDataSource = new RawResourceDataSource(this.f22788a);
            this.f22797j = rawResourceDataSource;
            n(rawResourceDataSource);
        }
        return this.f22797j;
    }

    public final a y() {
        if (this.f22794g == null) {
            try {
                a aVar = (a) Class.forName("com.google.android.exoplayer2.ext.rtmp.RtmpDataSource").getConstructor(new Class[0]).newInstance(new Object[0]);
                this.f22794g = aVar;
                n(aVar);
            } catch (ClassNotFoundException unused) {
                m.h("DefaultDataSource", "Attempting to play RTMP stream without depending on the RTMP extension");
            } catch (Exception e2) {
                throw new RuntimeException("Error instantiating RTMP extension", e2);
            }
            if (this.f22794g == null) {
                this.f22794g = this.f22790c;
            }
        }
        return this.f22794g;
    }

    public final a z() {
        if (this.f22795h == null) {
            UdpDataSource udpDataSource = new UdpDataSource();
            this.f22795h = udpDataSource;
            n(udpDataSource);
        }
        return this.f22795h;
    }
}
