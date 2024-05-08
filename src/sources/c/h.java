package c;

import ar.com.hjg.pngj.chunks.PngChunk;

/* compiled from: PngChunkSingle.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class h extends PngChunk {
    public h(String str, ar.com.hjg.pngj.k kVar) {
        super(str, kVar);
    }

    @Override // ar.com.hjg.pngj.chunks.PngChunk
    public final boolean a() {
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        h hVar = (h) obj;
        String str = this.f1076a;
        if (str == null) {
            if (hVar.f1076a != null) {
                return false;
            }
        } else if (!str.equals(hVar.f1076a)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.f1076a;
        return 31 + (str == null ? 0 : str.hashCode());
    }
}
