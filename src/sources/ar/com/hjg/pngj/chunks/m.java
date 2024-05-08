package ar.com.hjg.pngj.chunks;

import ar.com.hjg.pngj.PngjException;
import com.android.internal.os.PowerProfile;

/* compiled from: PngChunkPHYS.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class m extends c.h {

    /* renamed from: i, reason: collision with root package name */
    public long f1125i;

    /* renamed from: j, reason: collision with root package name */
    public long f1126j;

    /* renamed from: k, reason: collision with root package name */
    public int f1127k;

    public m(ar.com.hjg.pngj.k kVar) {
        super("pHYs", kVar);
    }

    @Override // ar.com.hjg.pngj.chunks.PngChunk
    public void e(c.d dVar) {
        if (dVar.f1492a == 9) {
            long i10 = ar.com.hjg.pngj.o.i(dVar.f1495d, 0);
            this.f1125i = i10;
            if (i10 < 0) {
                this.f1125i = i10 + PowerProfile.SUBSYSTEM_MODEM;
            }
            long i11 = ar.com.hjg.pngj.o.i(dVar.f1495d, 4);
            this.f1126j = i11;
            if (i11 < 0) {
                this.f1126j = i11 + PowerProfile.SUBSYSTEM_MODEM;
            }
            this.f1127k = ar.com.hjg.pngj.o.f(dVar.f1495d, 8);
            return;
        }
        throw new PngjException("bad chunk length " + ((Object) dVar));
    }
}
