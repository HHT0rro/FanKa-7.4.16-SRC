package com.google.android.exoplayer2.upstream;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.j0;
import com.kuaishou.weapon.p0.t;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ContentDataSource extends o6.f {

    /* renamed from: e, reason: collision with root package name */
    public final ContentResolver f22717e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public Uri f22718f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public AssetFileDescriptor f22719g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public FileInputStream f22720h;

    /* renamed from: i, reason: collision with root package name */
    public long f22721i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f22722j;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class ContentDataSourceException extends DataSourceException {
        @Deprecated
        public ContentDataSourceException(IOException iOException) {
            this(iOException, 2000);
        }

        public ContentDataSourceException(@Nullable IOException iOException, int i10) {
            super(iOException, i10);
        }
    }

    public ContentDataSource(Context context) {
        super(false);
        this.f22717e = context.getContentResolver();
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public long a(b bVar) throws ContentDataSourceException {
        try {
            Uri uri = bVar.f22767a;
            this.f22718f = uri;
            v(bVar);
            AssetFileDescriptor openAssetFileDescriptor = this.f22717e.openAssetFileDescriptor(uri, t.f36226k);
            this.f22719g = openAssetFileDescriptor;
            if (openAssetFileDescriptor != null) {
                long length = openAssetFileDescriptor.getLength();
                FileInputStream fileInputStream = new FileInputStream(openAssetFileDescriptor.getFileDescriptor());
                this.f22720h = fileInputStream;
                if (length != -1 && bVar.f22773g > length) {
                    throw new ContentDataSourceException(null, 2008);
                }
                long startOffset = openAssetFileDescriptor.getStartOffset();
                long skip = fileInputStream.skip(bVar.f22773g + startOffset) - startOffset;
                if (skip == bVar.f22773g) {
                    if (length == -1) {
                        FileChannel channel = fileInputStream.getChannel();
                        long size = channel.size();
                        if (size == 0) {
                            this.f22721i = -1L;
                        } else {
                            long position = size - channel.position();
                            this.f22721i = position;
                            if (position < 0) {
                                throw new ContentDataSourceException(null, 2008);
                            }
                        }
                    } else {
                        long j10 = length - skip;
                        this.f22721i = j10;
                        if (j10 < 0) {
                            throw new ContentDataSourceException(null, 2008);
                        }
                    }
                    long j11 = bVar.f22774h;
                    if (j11 != -1) {
                        long j12 = this.f22721i;
                        if (j12 != -1) {
                            j11 = Math.min(j12, j11);
                        }
                        this.f22721i = j11;
                    }
                    this.f22722j = true;
                    w(bVar);
                    long j13 = bVar.f22774h;
                    return j13 != -1 ? j13 : this.f22721i;
                }
                throw new ContentDataSourceException(null, 2008);
            }
            String valueOf = String.valueOf(uri);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 36);
            sb2.append("Could not open file descriptor for: ");
            sb2.append(valueOf);
            throw new ContentDataSourceException(new IOException(sb2.toString()), 2000);
        } catch (ContentDataSourceException e2) {
            throw e2;
        } catch (IOException e10) {
            throw new ContentDataSourceException(e10, e10 instanceof FileNotFoundException ? 2005 : 2000);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public void close() throws ContentDataSourceException {
        this.f22718f = null;
        try {
            try {
                FileInputStream fileInputStream = this.f22720h;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                this.f22720h = null;
                try {
                    try {
                        AssetFileDescriptor assetFileDescriptor = this.f22719g;
                        if (assetFileDescriptor != null) {
                            assetFileDescriptor.close();
                        }
                    } catch (IOException e2) {
                        throw new ContentDataSourceException(e2, 2000);
                    }
                } finally {
                    this.f22719g = null;
                    if (this.f22722j) {
                        this.f22722j = false;
                        u();
                    }
                }
            } catch (Throwable th) {
                this.f22720h = null;
                try {
                    try {
                        AssetFileDescriptor assetFileDescriptor2 = this.f22719g;
                        if (assetFileDescriptor2 != null) {
                            assetFileDescriptor2.close();
                        }
                        this.f22719g = null;
                        if (this.f22722j) {
                            this.f22722j = false;
                            u();
                        }
                        throw th;
                    } finally {
                        this.f22719g = null;
                        if (this.f22722j) {
                            this.f22722j = false;
                            u();
                        }
                    }
                } catch (IOException e10) {
                    throw new ContentDataSourceException(e10, 2000);
                }
            }
        } catch (IOException e11) {
            throw new ContentDataSourceException(e11, 2000);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.a
    @Nullable
    public Uri i() {
        return this.f22718f;
    }

    @Override // o6.g
    public int read(byte[] bArr, int i10, int i11) throws ContentDataSourceException {
        if (i11 == 0) {
            return 0;
        }
        long j10 = this.f22721i;
        if (j10 == 0) {
            return -1;
        }
        if (j10 != -1) {
            try {
                i11 = (int) Math.min(j10, i11);
            } catch (IOException e2) {
                throw new ContentDataSourceException(e2, 2000);
            }
        }
        int read = ((FileInputStream) j0.j(this.f22720h)).read(bArr, i10, i11);
        if (read == -1) {
            return -1;
        }
        long j11 = this.f22721i;
        if (j11 != -1) {
            this.f22721i = j11 - read;
        }
        t(read);
        return read;
    }
}
