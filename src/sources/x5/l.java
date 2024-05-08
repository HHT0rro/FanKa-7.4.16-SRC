package x5;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.j0;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: DataChunk.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class l extends f {

    /* renamed from: j, reason: collision with root package name */
    public byte[] f54551j;

    /* renamed from: k, reason: collision with root package name */
    public volatile boolean f54552k;

    public l(com.google.android.exoplayer2.upstream.a aVar, com.google.android.exoplayer2.upstream.b bVar, int i10, Format format, int i11, @Nullable Object obj, @Nullable byte[] bArr) {
        super(aVar, bVar, i10, format, i11, obj, -9223372036854775807L, -9223372036854775807L);
        l lVar;
        byte[] bArr2;
        if (bArr == null) {
            bArr2 = j0.f22995f;
            lVar = this;
        } else {
            lVar = this;
            bArr2 = bArr;
        }
        lVar.f54551j = bArr2;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.e
    public final void b() {
        this.f54552k = true;
    }

    public abstract void f(byte[] bArr, int i10) throws IOException;

    public byte[] g() {
        return this.f54551j;
    }

    public final void h(int i10) {
        byte[] bArr = this.f54551j;
        if (bArr.length < i10 + 16384) {
            this.f54551j = Arrays.copyOf(bArr, bArr.length + 16384);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.e
    public final void load() throws IOException {
        try {
            this.f54514i.a(this.f54507b);
            int i10 = 0;
            int i11 = 0;
            while (i10 != -1 && !this.f54552k) {
                h(i11);
                i10 = this.f54514i.read(this.f54551j, i11, 16384);
                if (i10 != -1) {
                    i11 += i10;
                }
            }
            if (!this.f54552k) {
                f(this.f54551j, i11);
            }
        } finally {
            j0.n(this.f54514i);
        }
    }
}
