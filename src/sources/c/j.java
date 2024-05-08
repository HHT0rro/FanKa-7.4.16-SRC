package c;

import ar.com.hjg.pngj.PngjException;
import ar.com.hjg.pngj.chunks.u;

/* compiled from: PngChunkZTXT.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class j extends u {
    public j(ar.com.hjg.pngj.k kVar) {
        super("zTXt", kVar);
    }

    @Override // ar.com.hjg.pngj.chunks.PngChunk
    public void e(d dVar) {
        byte[] bArr;
        int i10 = 0;
        while (true) {
            bArr = dVar.f1495d;
            if (i10 >= bArr.length) {
                i10 = -1;
                break;
            } else if (bArr[i10] == 0) {
                break;
            } else {
                i10++;
            }
        }
        if (i10 >= 0 && i10 <= bArr.length - 2) {
            this.f1151i = b.j(bArr, 0, i10);
            byte[] bArr2 = dVar.f1495d;
            if (bArr2[i10 + 1] == 0) {
                this.f1152j = b.i(b.a(bArr2, i10 + 2, (bArr2.length - i10) - 2, false));
                return;
            }
            throw new PngjException("bad zTXt chunk: unknown compression method");
        }
        throw new PngjException("bad zTXt chunk: no separator found");
    }
}
