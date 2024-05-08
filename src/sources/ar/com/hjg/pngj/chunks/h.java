package ar.com.hjg.pngj.chunks;

import ar.com.hjg.pngj.PngjException;

/* compiled from: PngChunkICCP.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class h extends c.h {

    /* renamed from: i, reason: collision with root package name */
    public String f1113i;

    /* renamed from: j, reason: collision with root package name */
    public byte[] f1114j;

    public h(ar.com.hjg.pngj.k kVar) {
        super("iCCP", kVar);
    }

    @Override // ar.com.hjg.pngj.chunks.PngChunk
    public void e(c.d dVar) {
        int f10 = c.b.f(dVar.f1495d);
        this.f1113i = c.b.j(dVar.f1495d, 0, f10);
        byte[] bArr = dVar.f1495d;
        if ((bArr[f10 + 1] & 255) == 0) {
            int i10 = f10 + 2;
            int length = bArr.length - i10;
            byte[] bArr2 = new byte[length];
            this.f1114j = bArr2;
            System.arraycopy((Object) bArr, i10, (Object) bArr2, 0, length);
            return;
        }
        throw new PngjException("bad compression for ChunkTypeICCP");
    }
}
