package com.kwad.sdk.pngencrypt.chunk;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class p extends PngChunk {
    public p(String str, com.kwad.sdk.pngencrypt.k kVar) {
        super(str, kVar);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        p pVar = (p) obj;
        String str = this.ahi;
        if (str == null) {
            if (pVar.ahi != null) {
                return false;
            }
        } else if (!str.equals(pVar.ahi)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.ahi;
        return (str == null ? 0 : str.hashCode()) + 31;
    }
}
