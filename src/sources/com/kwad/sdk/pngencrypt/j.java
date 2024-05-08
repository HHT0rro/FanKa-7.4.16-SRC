package com.kwad.sdk.pngencrypt;

import java.util.Arrays;
import java.util.zip.Inflater;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class j extends DeflatedChunksSet {
    public final e aKn;
    public byte[] aLh;
    public byte[] aLi;
    public final k aLj;
    public final p aLk;
    public int[] aLl;

    /* renamed from: com.kwad.sdk.pngencrypt.j$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] aLm;

        static {
            int[] iArr = new int[FilterType.values().length];
            aLm = iArr;
            try {
                iArr[FilterType.FILTER_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                aLm[FilterType.FILTER_SUB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                aLm[FilterType.FILTER_UP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                aLm[FilterType.FILTER_AVERAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                aLm[FilterType.FILTER_PAETH.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public j(String str, boolean z10, k kVar, e eVar) {
        this(str, z10, kVar, eVar, null, null);
    }

    private void JZ() {
        dI(this.aLk.aLR);
    }

    private int Ka() {
        int JY;
        e eVar = this.aKn;
        int i10 = 0;
        if (eVar == null) {
            int JQ = JQ();
            k kVar = this.aLj;
            if (JQ < kVar.aKU - 1) {
                JY = kVar.aLv;
                i10 = JY + 1;
            }
        } else if (eVar.JR()) {
            JY = this.aKn.JY();
            i10 = JY + 1;
        }
        if (!this.aKq) {
            dE(i10);
        }
        return i10;
    }

    private void dI(int i10) {
        byte[] bArr = this.aLh;
        if (bArr == null || bArr.length < this.aKG.length) {
            byte[] bArr2 = this.aKG;
            this.aLh = new byte[bArr2.length];
            this.aLi = new byte[bArr2.length];
        }
        if (this.aLk.aLO == 0) {
            Arrays.fill(this.aLh, (byte) 0);
        }
        byte[] bArr3 = this.aLh;
        this.aLh = this.aLi;
        this.aLi = bArr3;
        byte b4 = this.aKG[0];
        if (FilterType.isValidStandard(b4)) {
            FilterType byVal = FilterType.getByVal(b4);
            int[] iArr = this.aLl;
            iArr[b4] = iArr[b4] + 1;
            this.aLh[0] = this.aKG[0];
            int i11 = AnonymousClass1.aLm[byVal.ordinal()];
            if (i11 == 1) {
                dK(i10);
                return;
            }
            if (i11 == 2) {
                dM(i10);
                return;
            }
            if (i11 == 3) {
                dN(i10);
                return;
            }
            if (i11 == 4) {
                dJ(i10);
                return;
            } else {
                if (i11 == 5) {
                    dL(i10);
                    return;
                }
                throw new PngjException("Filter type " + ((int) b4) + " not implemented");
            }
        }
        throw new PngjException("Filter type " + ((int) b4) + " invalid");
    }

    private void dJ(int i10) {
        int i11 = 1;
        int i12 = 1 - this.aLj.aLu;
        while (i11 <= i10) {
            this.aLh[i11] = (byte) (this.aKG[i11] + (((i12 > 0 ? this.aLh[i12] & 255 : 0) + (this.aLi[i11] & 255)) / 2));
            i11++;
            i12++;
        }
    }

    private void dK(int i10) {
        for (int i11 = 1; i11 <= i10; i11++) {
            this.aLh[i11] = this.aKG[i11];
        }
    }

    private void dL(int i10) {
        int i11 = 1;
        int i12 = 1 - this.aLj.aLu;
        while (i11 <= i10) {
            int i13 = 0;
            int i14 = i12 > 0 ? this.aLh[i12] & 255 : 0;
            if (i12 > 0) {
                i13 = this.aLi[i12] & 255;
            }
            this.aLh[i11] = (byte) (this.aKG[i11] + n.b(i14, this.aLi[i11] & 255, i13));
            i11++;
            i12++;
        }
    }

    private void dM(int i10) {
        int i11;
        int i12 = 1;
        while (true) {
            i11 = this.aLj.aLu;
            if (i12 > i11) {
                break;
            }
            this.aLh[i12] = this.aKG[i12];
            i12++;
        }
        int i13 = i11 + 1;
        int i14 = 1;
        while (i13 <= i10) {
            byte[] bArr = this.aLh;
            bArr[i13] = (byte) (this.aKG[i13] + bArr[i14]);
            i13++;
            i14++;
        }
    }

    private void dN(int i10) {
        for (int i11 = 1; i11 <= i10; i11++) {
            this.aLh[i11] = (byte) (this.aKG[i11] + this.aLi[i11]);
        }
    }

    @Override // com.kwad.sdk.pngencrypt.DeflatedChunksSet
    public final void JN() {
        super.JN();
        this.aLk.update(JQ());
        JZ();
        p pVar = this.aLk;
        pVar.h(this.aLh, pVar.aLR + 1);
    }

    @Override // com.kwad.sdk.pngencrypt.DeflatedChunksSet
    public final int JO() {
        return Ka();
    }

    @Override // com.kwad.sdk.pngencrypt.DeflatedChunksSet
    public final void close() {
        super.close();
        this.aLh = null;
        this.aLi = null;
    }

    private j(String str, boolean z10, k kVar, e eVar, Inflater inflater, byte[] bArr) {
        super(str, z10, (eVar != null ? eVar.JY() : kVar.aLv) + 1, kVar.aLv + 1, null, null);
        this.aLl = new int[5];
        this.aLj = kVar;
        this.aKn = eVar;
        this.aLk = new p(kVar, eVar);
        com.kwad.sdk.core.e.c.d("PNG_ENCRYPT", "Creating IDAT set ");
    }
}
