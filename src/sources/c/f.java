package c;

import ar.com.hjg.pngj.PngjException;
import ar.com.hjg.pngj.chunks.u;

/* compiled from: PngChunkITXT.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class f extends u {

    /* renamed from: k, reason: collision with root package name */
    public boolean f1505k;

    /* renamed from: l, reason: collision with root package name */
    public String f1506l;

    /* renamed from: m, reason: collision with root package name */
    public String f1507m;

    public f(ar.com.hjg.pngj.k kVar) {
        super("iTXt", kVar);
        this.f1505k = false;
        this.f1506l = "";
        this.f1507m = "";
    }

    @Override // ar.com.hjg.pngj.chunks.PngChunk
    public void e(d dVar) {
        byte[] bArr;
        int[] iArr = new int[3];
        int i10 = 0;
        int i11 = 0;
        while (true) {
            bArr = dVar.f1495d;
            if (i10 >= bArr.length) {
                break;
            }
            if (bArr[i10] == 0) {
                iArr[i11] = i10;
                i11++;
                if (i11 == 1) {
                    i10 += 2;
                }
                if (i11 == 3) {
                    break;
                }
            }
            i10++;
        }
        if (i11 == 3) {
            this.f1151i = b.j(bArr, 0, iArr[0]);
            int i12 = iArr[0] + 1;
            byte[] bArr2 = dVar.f1495d;
            boolean z10 = bArr2[i12] != 0;
            this.f1505k = z10;
            int i13 = i12 + 1;
            if (z10 && bArr2[i13] != 0) {
                throw new PngjException("Bad formed PngChunkITXT chunk - bad compression method ");
            }
            this.f1506l = b.j(bArr2, i13, iArr[1] - i13);
            this.f1507m = b.l(dVar.f1495d, iArr[1] + 1, (iArr[2] - iArr[1]) - 1);
            int i14 = iArr[2] + 1;
            if (this.f1505k) {
                byte[] bArr3 = dVar.f1495d;
                this.f1152j = b.k(b.a(bArr3, i14, bArr3.length - i14, false));
                return;
            } else {
                byte[] bArr4 = dVar.f1495d;
                this.f1152j = b.l(bArr4, i14, bArr4.length - i14);
                return;
            }
        }
        throw new PngjException("Bad formed PngChunkITXT chunk");
    }
}
