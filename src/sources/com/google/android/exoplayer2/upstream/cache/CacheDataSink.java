package com.google.android.exoplayer2.upstream.cache;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.util.j0;
import com.google.android.exoplayer2.util.m;
import com.google.android.exoplayer2.util.x;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import o6.i;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class CacheDataSink implements i {

    /* renamed from: a, reason: collision with root package name */
    public final Cache f22799a;

    /* renamed from: b, reason: collision with root package name */
    public final long f22800b;

    /* renamed from: c, reason: collision with root package name */
    public final int f22801c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public com.google.android.exoplayer2.upstream.b f22802d;

    /* renamed from: e, reason: collision with root package name */
    public long f22803e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public File f22804f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public OutputStream f22805g;

    /* renamed from: h, reason: collision with root package name */
    public long f22806h;

    /* renamed from: i, reason: collision with root package name */
    public long f22807i;

    /* renamed from: j, reason: collision with root package name */
    public x f22808j;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class CacheDataSinkException extends Cache.CacheException {
        public CacheDataSinkException(IOException iOException) {
            super(iOException);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a implements i.a {

        /* renamed from: a, reason: collision with root package name */
        public Cache f22809a;

        /* renamed from: b, reason: collision with root package name */
        public long f22810b = 5242880;

        /* renamed from: c, reason: collision with root package name */
        public int f22811c = 20480;

        @Override // o6.i.a
        public i a() {
            return new CacheDataSink((Cache) com.google.android.exoplayer2.util.a.e(this.f22809a), this.f22810b, this.f22811c);
        }

        public a b(Cache cache) {
            this.f22809a = cache;
            return this;
        }
    }

    public CacheDataSink(Cache cache, long j10, int i10) {
        com.google.android.exoplayer2.util.a.h(j10 > 0 || j10 == -1, "fragmentSize must be positive or C.LENGTH_UNSET.");
        if (j10 != -1 && j10 < PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE) {
            m.h("CacheDataSink", "fragmentSize is below the minimum recommended value of 2097152. This may cause poor cache performance.");
        }
        this.f22799a = (Cache) com.google.android.exoplayer2.util.a.e(cache);
        this.f22800b = j10 == -1 ? Long.MAX_VALUE : j10;
        this.f22801c = i10;
    }

    @Override // o6.i
    public void a(com.google.android.exoplayer2.upstream.b bVar) throws CacheDataSinkException {
        com.google.android.exoplayer2.util.a.e(bVar.f22775i);
        if (bVar.f22774h == -1 && bVar.d(2)) {
            this.f22802d = null;
            return;
        }
        this.f22802d = bVar;
        this.f22803e = bVar.d(4) ? this.f22800b : Long.MAX_VALUE;
        this.f22807i = 0L;
        try {
            c(bVar);
        } catch (IOException e2) {
            throw new CacheDataSinkException(e2);
        }
    }

    public final void b() throws IOException {
        OutputStream outputStream = this.f22805g;
        if (outputStream == null) {
            return;
        }
        try {
            outputStream.flush();
            j0.o(this.f22805g);
            this.f22805g = null;
            File file = (File) j0.j(this.f22804f);
            this.f22804f = null;
            this.f22799a.h(file, this.f22806h);
        } catch (Throwable th) {
            j0.o(this.f22805g);
            this.f22805g = null;
            File file2 = (File) j0.j(this.f22804f);
            this.f22804f = null;
            file2.delete();
            throw th;
        }
    }

    public final void c(com.google.android.exoplayer2.upstream.b bVar) throws IOException {
        long j10 = bVar.f22774h;
        this.f22804f = this.f22799a.d((String) j0.j(bVar.f22775i), bVar.f22773g + this.f22807i, j10 != -1 ? Math.min(j10 - this.f22807i, this.f22803e) : -1L);
        FileOutputStream fileOutputStream = new FileOutputStream(this.f22804f);
        if (this.f22801c > 0) {
            x xVar = this.f22808j;
            if (xVar == null) {
                this.f22808j = new x(fileOutputStream, this.f22801c);
            } else {
                xVar.a(fileOutputStream);
            }
            this.f22805g = this.f22808j;
        } else {
            this.f22805g = fileOutputStream;
        }
        this.f22806h = 0L;
    }

    @Override // o6.i
    public void close() throws CacheDataSinkException {
        if (this.f22802d == null) {
            return;
        }
        try {
            b();
        } catch (IOException e2) {
            throw new CacheDataSinkException(e2);
        }
    }

    @Override // o6.i
    public void write(byte[] bArr, int i10, int i11) throws CacheDataSinkException {
        com.google.android.exoplayer2.upstream.b bVar = this.f22802d;
        if (bVar == null) {
            return;
        }
        int i12 = 0;
        while (i12 < i11) {
            try {
                if (this.f22806h == this.f22803e) {
                    b();
                    c(bVar);
                }
                int min = (int) Math.min(i11 - i12, this.f22803e - this.f22806h);
                ((OutputStream) j0.j(this.f22805g)).write(bArr, i10 + i12, min);
                i12 += min;
                long j10 = min;
                this.f22806h += j10;
                this.f22807i += j10;
            } catch (IOException e2) {
                throw new CacheDataSinkException(e2);
            }
        }
    }
}
