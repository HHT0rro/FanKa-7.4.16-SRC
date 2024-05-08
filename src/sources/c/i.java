package c;

import ar.com.hjg.pngj.chunks.u;

/* compiled from: PngChunkTEXT.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class i extends u {
    public i(ar.com.hjg.pngj.k kVar) {
        super("tEXt", kVar);
    }

    @Override // ar.com.hjg.pngj.chunks.PngChunk
    public void e(d dVar) {
        byte[] bArr;
        int i10 = 0;
        while (true) {
            bArr = dVar.f1495d;
            if (i10 >= bArr.length || bArr[i10] == 0) {
                break;
            } else {
                i10++;
            }
        }
        this.f1151i = b.j(bArr, 0, i10);
        int i11 = i10 + 1;
        byte[] bArr2 = dVar.f1495d;
        this.f1152j = i11 < bArr2.length ? b.j(bArr2, i11, bArr2.length - i11) : "";
    }
}
