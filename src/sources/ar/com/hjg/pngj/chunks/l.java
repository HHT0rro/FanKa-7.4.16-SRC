package ar.com.hjg.pngj.chunks;

import ar.com.hjg.pngj.PngjException;
import com.android.internal.os.PowerProfile;

/* compiled from: PngChunkOFFS.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class l extends c.h {

    /* renamed from: i, reason: collision with root package name */
    public long f1122i;

    /* renamed from: j, reason: collision with root package name */
    public long f1123j;

    /* renamed from: k, reason: collision with root package name */
    public int f1124k;

    public l(ar.com.hjg.pngj.k kVar) {
        super("oFFs", kVar);
    }

    @Override // ar.com.hjg.pngj.chunks.PngChunk
    public void e(c.d dVar) {
        if (dVar.f1492a == 9) {
            long i10 = ar.com.hjg.pngj.o.i(dVar.f1495d, 0);
            this.f1122i = i10;
            if (i10 < 0) {
                this.f1122i = i10 + PowerProfile.SUBSYSTEM_MODEM;
            }
            long i11 = ar.com.hjg.pngj.o.i(dVar.f1495d, 4);
            this.f1123j = i11;
            if (i11 < 0) {
                this.f1123j = i11 + PowerProfile.SUBSYSTEM_MODEM;
            }
            this.f1124k = ar.com.hjg.pngj.o.f(dVar.f1495d, 8);
            return;
        }
        throw new PngjException("bad chunk length " + ((Object) dVar));
    }
}
