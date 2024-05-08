package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import android.system.ErrnoException;
import android.system.OsConstants;
import android.text.TextUtils;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.upstream.a;
import com.google.android.exoplayer2.util.j0;
import com.kuaishou.weapon.p0.t;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import o6.v;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FileDataSource extends o6.f {

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public RandomAccessFile f22723e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public Uri f22724f;

    /* renamed from: g, reason: collision with root package name */
    public long f22725g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f22726h;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class FileDataSourceException extends DataSourceException {
        @Deprecated
        public FileDataSourceException(Exception exc) {
            super(exc, 2000);
        }

        @Deprecated
        public FileDataSourceException(String str, IOException iOException) {
            super(str, iOException, 2000);
        }

        public FileDataSourceException(Throwable th, int i10) {
            super(th, i10);
        }

        public FileDataSourceException(@Nullable String str, @Nullable Throwable th, int i10) {
            super(str, th, i10);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a implements a.InterfaceC0208a {

        /* renamed from: a, reason: collision with root package name */
        @Nullable
        public v f22727a;

        @Override // com.google.android.exoplayer2.upstream.a.InterfaceC0208a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public FileDataSource a() {
            FileDataSource fileDataSource = new FileDataSource();
            v vVar = this.f22727a;
            if (vVar != null) {
                fileDataSource.d(vVar);
            }
            return fileDataSource;
        }
    }

    @RequiresApi(21)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b {
        /* JADX INFO: Access modifiers changed from: private */
        @DoNotInline
        public static boolean b(@Nullable Throwable th) {
            return (th instanceof ErrnoException) && ((ErrnoException) th).errno == OsConstants.EACCES;
        }
    }

    public FileDataSource() {
        super(false);
    }

    public static RandomAccessFile x(Uri uri) throws FileDataSourceException {
        try {
            return new RandomAccessFile((String) com.google.android.exoplayer2.util.a.e(uri.getPath()), t.f36226k);
        } catch (FileNotFoundException e2) {
            if (TextUtils.isEmpty(uri.getQuery()) && TextUtils.isEmpty(uri.getFragment())) {
                throw new FileDataSourceException(e2, (j0.f22990a < 21 || !b.b(e2.getCause())) ? 2005 : 2006);
            }
            throw new FileDataSourceException(String.format("uri has query and/or fragment, which are not supported. Did you call Uri.parse() on a string containing '?' or '#'? Use Uri.fromFile(new File(path)) to avoid this. path=%s,query=%s,fragment=%s", uri.getPath(), uri.getQuery(), uri.getFragment()), e2, 1004);
        } catch (SecurityException e10) {
            throw new FileDataSourceException(e10, 2006);
        } catch (RuntimeException e11) {
            throw new FileDataSourceException(e11, 2000);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public long a(com.google.android.exoplayer2.upstream.b bVar) throws FileDataSourceException {
        Uri uri = bVar.f22767a;
        this.f22724f = uri;
        v(bVar);
        RandomAccessFile x10 = x(uri);
        this.f22723e = x10;
        try {
            x10.seek(bVar.f22773g);
            long j10 = bVar.f22774h;
            if (j10 == -1) {
                j10 = this.f22723e.length() - bVar.f22773g;
            }
            this.f22725g = j10;
            if (j10 >= 0) {
                this.f22726h = true;
                w(bVar);
                return this.f22725g;
            }
            throw new FileDataSourceException(null, null, 2008);
        } catch (IOException e2) {
            throw new FileDataSourceException(e2, 2000);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public void close() throws FileDataSourceException {
        this.f22724f = null;
        try {
            try {
                RandomAccessFile randomAccessFile = this.f22723e;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
            } catch (IOException e2) {
                throw new FileDataSourceException(e2, 2000);
            }
        } finally {
            this.f22723e = null;
            if (this.f22726h) {
                this.f22726h = false;
                u();
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.a
    @Nullable
    public Uri i() {
        return this.f22724f;
    }

    @Override // o6.g
    public int read(byte[] bArr, int i10, int i11) throws FileDataSourceException {
        if (i11 == 0) {
            return 0;
        }
        if (this.f22725g == 0) {
            return -1;
        }
        try {
            int read = ((RandomAccessFile) j0.j(this.f22723e)).read(bArr, i10, (int) Math.min(this.f22725g, i11));
            if (read > 0) {
                this.f22725g -= read;
                t(read);
            }
            return read;
        } catch (IOException e2) {
            throw new FileDataSourceException(e2, 2000);
        }
    }
}
