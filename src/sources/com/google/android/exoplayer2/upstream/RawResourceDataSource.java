package com.google.android.exoplayer2.upstream;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.j0;
import com.huawei.openalliance.ad.constant.u;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class RawResourceDataSource extends o6.f {

    /* renamed from: e, reason: collision with root package name */
    public final Resources f22750e;

    /* renamed from: f, reason: collision with root package name */
    public final String f22751f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public Uri f22752g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public AssetFileDescriptor f22753h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    public InputStream f22754i;

    /* renamed from: j, reason: collision with root package name */
    public long f22755j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f22756k;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class RawResourceDataSourceException extends DataSourceException {
        @Deprecated
        public RawResourceDataSourceException(String str) {
            super(str, null, 2000);
        }

        @Deprecated
        public RawResourceDataSourceException(Throwable th) {
            super(th, 2000);
        }

        public RawResourceDataSourceException(@Nullable String str, @Nullable Throwable th, int i10) {
            super(str, th, i10);
        }
    }

    public RawResourceDataSource(Context context) {
        super(false);
        this.f22750e = context.getResources();
        this.f22751f = context.getPackageName();
    }

    public static Uri buildRawResourceUri(int i10) {
        StringBuilder sb2 = new StringBuilder(26);
        sb2.append("rawresource:///");
        sb2.append(i10);
        return Uri.parse(sb2.toString());
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public long a(b bVar) throws RawResourceDataSourceException {
        int parseInt;
        Uri uri = bVar.f22767a;
        this.f22752g = uri;
        if (!TextUtils.equals("rawresource", uri.getScheme()) && (!TextUtils.equals("android.resource", uri.getScheme()) || uri.getPathSegments().size() != 1 || !((String) com.google.android.exoplayer2.util.a.e(uri.getLastPathSegment())).matches("\\d+"))) {
            if (TextUtils.equals("android.resource", uri.getScheme())) {
                String str = (String) com.google.android.exoplayer2.util.a.e(uri.getPath());
                if (str.startsWith("/")) {
                    str = str.substring(1);
                }
                String host = uri.getHost();
                String valueOf = String.valueOf(TextUtils.isEmpty(host) ? "" : String.valueOf(host).concat(u.bD));
                String valueOf2 = String.valueOf(str);
                parseInt = this.f22750e.getIdentifier(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf), "raw", this.f22751f);
                if (parseInt == 0) {
                    throw new RawResourceDataSourceException("Resource not found.", null, 2005);
                }
            } else {
                throw new RawResourceDataSourceException("URI must either use scheme rawresource or android.resource", null, 1004);
            }
        } else {
            try {
                parseInt = Integer.parseInt((String) com.google.android.exoplayer2.util.a.e(uri.getLastPathSegment()));
            } catch (NumberFormatException unused) {
                throw new RawResourceDataSourceException("Resource identifier must be an integer.", null, 1004);
            }
        }
        v(bVar);
        try {
            AssetFileDescriptor openRawResourceFd = this.f22750e.openRawResourceFd(parseInt);
            this.f22753h = openRawResourceFd;
            if (openRawResourceFd != null) {
                long length = openRawResourceFd.getLength();
                FileInputStream fileInputStream = new FileInputStream(openRawResourceFd.getFileDescriptor());
                this.f22754i = fileInputStream;
                if (length != -1) {
                    try {
                        if (bVar.f22773g > length) {
                            throw new RawResourceDataSourceException(null, null, 2008);
                        }
                    } catch (RawResourceDataSourceException e2) {
                        throw e2;
                    } catch (IOException e10) {
                        throw new RawResourceDataSourceException(null, e10, 2000);
                    }
                }
                long startOffset = openRawResourceFd.getStartOffset();
                long skip = fileInputStream.skip(bVar.f22773g + startOffset) - startOffset;
                if (skip == bVar.f22773g) {
                    if (length == -1) {
                        FileChannel channel = fileInputStream.getChannel();
                        if (channel.size() == 0) {
                            this.f22755j = -1L;
                        } else {
                            long size = channel.size() - channel.position();
                            this.f22755j = size;
                            if (size < 0) {
                                throw new RawResourceDataSourceException(null, null, 2008);
                            }
                        }
                    } else {
                        long j10 = length - skip;
                        this.f22755j = j10;
                        if (j10 < 0) {
                            throw new DataSourceException(2008);
                        }
                    }
                    long j11 = bVar.f22774h;
                    if (j11 != -1) {
                        long j12 = this.f22755j;
                        if (j12 != -1) {
                            j11 = Math.min(j12, j11);
                        }
                        this.f22755j = j11;
                    }
                    this.f22756k = true;
                    w(bVar);
                    long j13 = bVar.f22774h;
                    return j13 != -1 ? j13 : this.f22755j;
                }
                throw new RawResourceDataSourceException(null, null, 2008);
            }
            String valueOf3 = String.valueOf(uri);
            StringBuilder sb2 = new StringBuilder(valueOf3.length() + 24);
            sb2.append("Resource is compressed: ");
            sb2.append(valueOf3);
            throw new RawResourceDataSourceException(sb2.toString(), null, 2000);
        } catch (Resources.NotFoundException e11) {
            throw new RawResourceDataSourceException(null, e11, 2005);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public void close() throws RawResourceDataSourceException {
        this.f22752g = null;
        try {
            try {
                InputStream inputStream = this.f22754i;
                if (inputStream != null) {
                    inputStream.close();
                }
                this.f22754i = null;
                try {
                    try {
                        AssetFileDescriptor assetFileDescriptor = this.f22753h;
                        if (assetFileDescriptor != null) {
                            assetFileDescriptor.close();
                        }
                    } catch (IOException e2) {
                        throw new RawResourceDataSourceException(null, e2, 2000);
                    }
                } finally {
                    this.f22753h = null;
                    if (this.f22756k) {
                        this.f22756k = false;
                        u();
                    }
                }
            } catch (Throwable th) {
                this.f22754i = null;
                try {
                    try {
                        AssetFileDescriptor assetFileDescriptor2 = this.f22753h;
                        if (assetFileDescriptor2 != null) {
                            assetFileDescriptor2.close();
                        }
                        this.f22753h = null;
                        if (this.f22756k) {
                            this.f22756k = false;
                            u();
                        }
                        throw th;
                    } finally {
                        this.f22753h = null;
                        if (this.f22756k) {
                            this.f22756k = false;
                            u();
                        }
                    }
                } catch (IOException e10) {
                    throw new RawResourceDataSourceException(null, e10, 2000);
                }
            }
        } catch (IOException e11) {
            throw new RawResourceDataSourceException(null, e11, 2000);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.a
    @Nullable
    public Uri i() {
        return this.f22752g;
    }

    @Override // o6.g
    public int read(byte[] bArr, int i10, int i11) throws RawResourceDataSourceException {
        if (i11 == 0) {
            return 0;
        }
        long j10 = this.f22755j;
        if (j10 == 0) {
            return -1;
        }
        if (j10 != -1) {
            try {
                i11 = (int) Math.min(j10, i11);
            } catch (IOException e2) {
                throw new RawResourceDataSourceException(null, e2, 2000);
            }
        }
        int read = ((InputStream) j0.j(this.f22754i)).read(bArr, i10, i11);
        if (read == -1) {
            if (this.f22755j == -1) {
                return -1;
            }
            throw new RawResourceDataSourceException("End of stream reached having not read sufficient data.", new EOFException(), 2000);
        }
        long j11 = this.f22755j;
        if (j11 != -1) {
            this.f22755j = j11 - read;
        }
        t(read);
        return read;
    }
}
