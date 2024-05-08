package o6;

import android.net.Uri;
import android.util.Base64;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.upstream.DataSourceException;
import com.google.android.exoplayer2.util.j0;
import java.io.IOException;
import java.net.URLDecoder;

/* compiled from: DataSchemeDataSource.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class h extends f {

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public com.google.android.exoplayer2.upstream.b f52301e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public byte[] f52302f;

    /* renamed from: g, reason: collision with root package name */
    public int f52303g;

    /* renamed from: h, reason: collision with root package name */
    public int f52304h;

    public h() {
        super(false);
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public long a(com.google.android.exoplayer2.upstream.b bVar) throws IOException {
        v(bVar);
        this.f52301e = bVar;
        Uri uri = bVar.f22767a;
        String scheme = uri.getScheme();
        boolean equals = "data".equals(scheme);
        String valueOf = String.valueOf(scheme);
        com.google.android.exoplayer2.util.a.b(equals, valueOf.length() != 0 ? "Unsupported scheme: ".concat(valueOf) : new String("Unsupported scheme: "));
        String[] M0 = j0.M0(uri.getSchemeSpecificPart(), ",");
        if (M0.length == 2) {
            String str = M0[1];
            if (M0[0].contains(";base64")) {
                try {
                    this.f52302f = Base64.decode(str, 0);
                } catch (IllegalArgumentException e2) {
                    String valueOf2 = String.valueOf(str);
                    throw ParserException.createForMalformedDataOfUnknownType(valueOf2.length() != 0 ? "Error while parsing Base64 encoded string: ".concat(valueOf2) : new String("Error while parsing Base64 encoded string: "), e2);
                }
            } else {
                this.f52302f = j0.i0(URLDecoder.decode(str, com.google.common.base.c.f25959a.name()));
            }
            long j10 = bVar.f22773g;
            byte[] bArr = this.f52302f;
            if (j10 <= bArr.length) {
                int i10 = (int) j10;
                this.f52303g = i10;
                int length = bArr.length - i10;
                this.f52304h = length;
                long j11 = bVar.f22774h;
                if (j11 != -1) {
                    this.f52304h = (int) Math.min(length, j11);
                }
                w(bVar);
                long j12 = bVar.f22774h;
                return j12 != -1 ? j12 : this.f52304h;
            }
            this.f52302f = null;
            throw new DataSourceException(2008);
        }
        String valueOf3 = String.valueOf(uri);
        StringBuilder sb2 = new StringBuilder(valueOf3.length() + 23);
        sb2.append("Unexpected URI format: ");
        sb2.append(valueOf3);
        throw ParserException.createForMalformedDataOfUnknownType(sb2.toString(), null);
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public void close() {
        if (this.f52302f != null) {
            this.f52302f = null;
            u();
        }
        this.f52301e = null;
    }

    @Override // com.google.android.exoplayer2.upstream.a
    @Nullable
    public Uri i() {
        com.google.android.exoplayer2.upstream.b bVar = this.f52301e;
        if (bVar != null) {
            return bVar.f22767a;
        }
        return null;
    }

    @Override // o6.g
    public int read(byte[] bArr, int i10, int i11) {
        if (i11 == 0) {
            return 0;
        }
        int i12 = this.f52304h;
        if (i12 == 0) {
            return -1;
        }
        int min = Math.min(i11, i12);
        System.arraycopy(j0.j(this.f52302f), this.f52303g, bArr, i10, min);
        this.f52303g += min;
        this.f52304h -= min;
        t(min);
        return min;
    }
}
