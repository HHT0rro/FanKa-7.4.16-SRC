package com.google.android.exoplayer2.upstream;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.h;
import com.huawei.openalliance.ad.constant.u;
import java.io.FileNotFoundException;
import java.io.IOException;
import o6.q;

/* compiled from: DefaultLoadErrorHandlingPolicy.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class f implements h {

    /* renamed from: a, reason: collision with root package name */
    public final int f22883a;

    public f() {
        this(-1);
    }

    @Override // com.google.android.exoplayer2.upstream.h
    public long a(h.c cVar) {
        IOException iOException = cVar.f22894c;
        if ((iOException instanceof ParserException) || (iOException instanceof FileNotFoundException) || (iOException instanceof HttpDataSource.CleartextNotPermittedException) || (iOException instanceof Loader.UnexpectedLoaderException)) {
            return -9223372036854775807L;
        }
        return Math.min((cVar.f22895d - 1) * 1000, 5000);
    }

    @Override // com.google.android.exoplayer2.upstream.h
    @Nullable
    public h.b b(h.a aVar, h.c cVar) {
        if (!e(cVar.f22894c)) {
            return null;
        }
        if (aVar.a(1)) {
            return new h.b(1, u.as);
        }
        if (aVar.a(2)) {
            return new h.b(2, 60000L);
        }
        return null;
    }

    @Override // com.google.android.exoplayer2.upstream.h
    public /* synthetic */ void c(long j10) {
        q.a(this, j10);
    }

    @Override // com.google.android.exoplayer2.upstream.h
    public int d(int i10) {
        int i11 = this.f22883a;
        return i11 == -1 ? i10 == 7 ? 6 : 3 : i11;
    }

    public boolean e(IOException iOException) {
        if (!(iOException instanceof HttpDataSource.InvalidResponseCodeException)) {
            return false;
        }
        int i10 = ((HttpDataSource.InvalidResponseCodeException) iOException).responseCode;
        return i10 == 403 || i10 == 404 || i10 == 410 || i10 == 416 || i10 == 500 || i10 == 503;
    }

    public f(int i10) {
        this.f22883a = i10;
    }
}
