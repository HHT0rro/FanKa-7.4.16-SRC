package z4;

import android.media.MediaCodec;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.util.j0;

/* compiled from: CryptoInfo.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public byte[] f54840a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public byte[] f54841b;

    /* renamed from: c, reason: collision with root package name */
    public int f54842c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public int[] f54843d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public int[] f54844e;

    /* renamed from: f, reason: collision with root package name */
    public int f54845f;

    /* renamed from: g, reason: collision with root package name */
    public int f54846g;

    /* renamed from: h, reason: collision with root package name */
    public int f54847h;

    /* renamed from: i, reason: collision with root package name */
    public final MediaCodec.CryptoInfo f54848i;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    public final C0845b f54849j;

    /* compiled from: CryptoInfo.java */
    @RequiresApi(24)
    /* renamed from: z4.b$b, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class C0845b {

        /* renamed from: a, reason: collision with root package name */
        public final MediaCodec.CryptoInfo f54850a;

        /* renamed from: b, reason: collision with root package name */
        public final MediaCodec.CryptoInfo.Pattern f54851b;

        public final void b(int i10, int i11) {
            this.f54851b.set(i10, i11);
            this.f54850a.setPattern(this.f54851b);
        }

        public C0845b(MediaCodec.CryptoInfo cryptoInfo) {
            this.f54850a = cryptoInfo;
            this.f54851b = new MediaCodec.CryptoInfo.Pattern(0, 0);
        }
    }

    public b() {
        MediaCodec.CryptoInfo cryptoInfo = new MediaCodec.CryptoInfo();
        this.f54848i = cryptoInfo;
        this.f54849j = j0.f22990a >= 24 ? new C0845b(cryptoInfo) : null;
    }

    public MediaCodec.CryptoInfo a() {
        return this.f54848i;
    }

    public void b(int i10) {
        if (i10 == 0) {
            return;
        }
        if (this.f54843d == null) {
            int[] iArr = new int[1];
            this.f54843d = iArr;
            this.f54848i.numBytesOfClearData = iArr;
        }
        int[] iArr2 = this.f54843d;
        iArr2[0] = iArr2[0] + i10;
    }

    public void c(int i10, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i11, int i12, int i13) {
        this.f54845f = i10;
        this.f54843d = iArr;
        this.f54844e = iArr2;
        this.f54841b = bArr;
        this.f54840a = bArr2;
        this.f54842c = i11;
        this.f54846g = i12;
        this.f54847h = i13;
        MediaCodec.CryptoInfo cryptoInfo = this.f54848i;
        cryptoInfo.numSubSamples = i10;
        cryptoInfo.numBytesOfClearData = iArr;
        cryptoInfo.numBytesOfEncryptedData = iArr2;
        cryptoInfo.key = bArr;
        cryptoInfo.iv = bArr2;
        cryptoInfo.mode = i11;
        if (j0.f22990a >= 24) {
            ((C0845b) com.google.android.exoplayer2.util.a.e(this.f54849j)).b(i12, i13);
        }
    }
}
