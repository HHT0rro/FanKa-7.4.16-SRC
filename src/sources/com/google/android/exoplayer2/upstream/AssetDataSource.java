package com.google.android.exoplayer2.upstream;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.j0;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class AssetDataSource extends o6.f {

    /* renamed from: e, reason: collision with root package name */
    public final AssetManager f22712e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public Uri f22713f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public InputStream f22714g;

    /* renamed from: h, reason: collision with root package name */
    public long f22715h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f22716i;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class AssetDataSourceException extends DataSourceException {
        @Deprecated
        public AssetDataSourceException(IOException iOException) {
            super(iOException, 2000);
        }

        public AssetDataSourceException(@Nullable Throwable th, int i10) {
            super(th, i10);
        }
    }

    public AssetDataSource(Context context) {
        super(false);
        this.f22712e = context.getAssets();
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public long a(b bVar) throws AssetDataSourceException {
        try {
            Uri uri = bVar.f22767a;
            this.f22713f = uri;
            String str = (String) com.google.android.exoplayer2.util.a.e(uri.getPath());
            if (str.startsWith("/android_asset/")) {
                str = str.substring(15);
            } else if (str.startsWith("/")) {
                str = str.substring(1);
            }
            v(bVar);
            InputStream open = this.f22712e.open(str, 1);
            this.f22714g = open;
            if (open.skip(bVar.f22773g) >= bVar.f22773g) {
                long j10 = bVar.f22774h;
                if (j10 != -1) {
                    this.f22715h = j10;
                } else {
                    long available = this.f22714g.available();
                    this.f22715h = available;
                    if (available == ZipUtils.UPPER_UNIXTIME_BOUND) {
                        this.f22715h = -1L;
                    }
                }
                this.f22716i = true;
                w(bVar);
                return this.f22715h;
            }
            throw new AssetDataSourceException(null, 2008);
        } catch (AssetDataSourceException e2) {
            throw e2;
        } catch (IOException e10) {
            throw new AssetDataSourceException(e10, e10 instanceof FileNotFoundException ? 2005 : 2000);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public void close() throws AssetDataSourceException {
        this.f22713f = null;
        try {
            try {
                InputStream inputStream = this.f22714g;
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e2) {
                throw new AssetDataSourceException(e2, 2000);
            }
        } finally {
            this.f22714g = null;
            if (this.f22716i) {
                this.f22716i = false;
                u();
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.a
    @Nullable
    public Uri i() {
        return this.f22713f;
    }

    @Override // o6.g
    public int read(byte[] bArr, int i10, int i11) throws AssetDataSourceException {
        if (i11 == 0) {
            return 0;
        }
        long j10 = this.f22715h;
        if (j10 == 0) {
            return -1;
        }
        if (j10 != -1) {
            try {
                i11 = (int) Math.min(j10, i11);
            } catch (IOException e2) {
                throw new AssetDataSourceException(e2, 2000);
            }
        }
        int read = ((InputStream) j0.j(this.f22714g)).read(bArr, i10, i11);
        if (read == -1) {
            return -1;
        }
        long j11 = this.f22715h;
        if (j11 != -1) {
            this.f22715h = j11 - read;
        }
        t(read);
        return read;
    }
}
