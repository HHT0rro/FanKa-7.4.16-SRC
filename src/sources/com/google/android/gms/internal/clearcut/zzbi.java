package com.google.android.gms.internal.clearcut;

import java.io.IOException;
import java.nio.charset.Charset;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class zzbi extends zzbh {
    public final byte[] zzfp;

    public zzbi(byte[] bArr) {
        this.zzfp = bArr;
    }

    @Override // com.google.android.gms.internal.clearcut.zzbb
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzbb) || size() != ((zzbb) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (!(obj instanceof zzbi)) {
            return obj.equals(this);
        }
        zzbi zzbiVar = (zzbi) obj;
        int zzab = zzab();
        int zzab2 = zzbiVar.zzab();
        if (zzab == 0 || zzab2 == 0 || zzab == zzab2) {
            return zza(zzbiVar, 0, size());
        }
        return false;
    }

    @Override // com.google.android.gms.internal.clearcut.zzbb
    public int size() {
        return this.zzfp.length;
    }

    @Override // com.google.android.gms.internal.clearcut.zzbb
    public final int zza(int i10, int i11, int i12) {
        return z0.c(i10, this.zzfp, zzac(), i12);
    }

    @Override // com.google.android.gms.internal.clearcut.zzbb
    public final zzbb zza(int i10, int i11) {
        int zzb = zzbb.zzb(0, i11, size());
        return zzb == 0 ? zzbb.zzfi : new zzbe(this.zzfp, zzac(), zzb);
    }

    @Override // com.google.android.gms.internal.clearcut.zzbb
    public final String zza(Charset charset) {
        return new String(this.zzfp, zzac(), size(), charset);
    }

    @Override // com.google.android.gms.internal.clearcut.zzbb
    public final void zza(y yVar) throws IOException {
        yVar.a(this.zzfp, zzac(), size());
    }

    @Override // com.google.android.gms.internal.clearcut.zzbh
    public final boolean zza(zzbb zzbbVar, int i10, int i11) {
        if (i11 > zzbbVar.size()) {
            int size = size();
            StringBuilder sb2 = new StringBuilder(40);
            sb2.append("Length too large: ");
            sb2.append(i11);
            sb2.append(size);
            throw new IllegalArgumentException(sb2.toString());
        }
        if (i11 > zzbbVar.size()) {
            int size2 = zzbbVar.size();
            StringBuilder sb3 = new StringBuilder(59);
            sb3.append("Ran off end of other: 0, ");
            sb3.append(i11);
            sb3.append(", ");
            sb3.append(size2);
            throw new IllegalArgumentException(sb3.toString());
        }
        if (!(zzbbVar instanceof zzbi)) {
            return zzbbVar.zza(0, i11).equals(zza(0, i11));
        }
        zzbi zzbiVar = (zzbi) zzbbVar;
        byte[] bArr = this.zzfp;
        byte[] bArr2 = zzbiVar.zzfp;
        int zzac = zzac() + i11;
        int zzac2 = zzac();
        int zzac3 = zzbiVar.zzac();
        while (zzac2 < zzac) {
            if (bArr[zzac2] != bArr2[zzac3]) {
                return false;
            }
            zzac2++;
            zzac3++;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.clearcut.zzbb
    public final boolean zzaa() {
        int zzac = zzac();
        return r3.i(this.zzfp, zzac, size() + zzac);
    }

    public int zzac() {
        return 0;
    }

    @Override // com.google.android.gms.internal.clearcut.zzbb
    public byte zzj(int i10) {
        return this.zzfp[i10];
    }
}
