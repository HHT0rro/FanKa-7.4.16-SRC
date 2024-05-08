package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.upstream.a;
import java.io.IOException;
import java.util.Map;
import o6.j;
import o6.v;

/* compiled from: DummyDataSource.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class g implements a {

    /* renamed from: a, reason: collision with root package name */
    public static final g f22884a = new g();

    /* renamed from: b, reason: collision with root package name */
    public static final a.InterfaceC0208a f22885b = new a.InterfaceC0208a() { // from class: o6.o
        @Override // com.google.android.exoplayer2.upstream.a.InterfaceC0208a
        public final com.google.android.exoplayer2.upstream.a a() {
            return com.google.android.exoplayer2.upstream.g.n();
        }
    };

    public static /* synthetic */ g n() {
        return new g();
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public long a(b bVar) throws IOException {
        throw new IOException("DummyDataSource cannot be opened");
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public void close() {
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public void d(v vVar) {
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public /* synthetic */ Map e() {
        return j.a(this);
    }

    @Override // com.google.android.exoplayer2.upstream.a
    @Nullable
    public Uri i() {
        return null;
    }

    @Override // o6.g
    public int read(byte[] bArr, int i10, int i11) {
        throw new UnsupportedOperationException();
    }
}
