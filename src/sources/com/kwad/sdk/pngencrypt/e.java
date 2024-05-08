package com.kwad.sdk.pngencrypt;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class e {
    public final k aKS;
    private int aKU;
    private int aKV;
    public int aKW;
    public int aKX;
    public int aKY;
    public int aKZ;
    public int aLa;
    public int aLb;
    private int aKT = 0;
    private int aLc = -1;
    private int aLd = -1;
    private int aLe = 0;
    private boolean aLg = false;
    public int aLf = 0;

    public e(k kVar) {
        this.aKS = kVar;
        dG(1);
        dF(0);
    }

    private int JX() {
        return JW();
    }

    private void dF(int i10) {
        this.aLc = i10;
        int i11 = (i10 * this.aKW) + this.aKY;
        this.aLd = i11;
        if (i11 < 0 || i11 >= this.aKS.aKU) {
            throw new PngjException("bad row - this should not happen");
        }
    }

    private void dG(int i10) {
        if (this.aKT == i10) {
            return;
        }
        this.aKT = i10;
        byte[] dH = dH(i10);
        byte b4 = dH[0];
        this.aKX = b4;
        byte b10 = dH[1];
        this.aKW = b10;
        byte b11 = dH[2];
        this.aKZ = b11;
        byte b12 = dH[3];
        this.aKY = b12;
        k kVar = this.aKS;
        int i11 = kVar.aKU;
        this.aKU = i11 > b12 ? (((i11 + b10) - 1) - b12) / b10 : 0;
        int i12 = kVar.aKV;
        int i13 = i12 > b11 ? (((i12 + b4) - 1) - b11) / b4 : 0;
        this.aKV = i13;
        if (i13 == 0) {
            this.aKU = 0;
        }
        int i14 = kVar.aLo;
        this.aLb = b4 * i14;
        this.aLa = b11 * i14;
    }

    private static byte[] dH(int i10) {
        switch (i10) {
            case 1:
                return new byte[]{8, 8, 0, 0};
            case 2:
                return new byte[]{8, 8, 4, 0};
            case 3:
                return new byte[]{4, 8, 0, 4};
            case 4:
                return new byte[]{4, 4, 2, 0};
            case 5:
                return new byte[]{2, 4, 0, 2};
            case 6:
                return new byte[]{2, 2, 1, 0};
            case 7:
                return new byte[]{1, 2, 0, 1};
            default:
                throw new PngjException("bad interlace pass" + i10);
        }
    }

    public final boolean JR() {
        int i10;
        while (true) {
            this.aLe++;
            int i11 = this.aKU;
            if (i11 != 0 && (i10 = this.aLc) < i11 - 1) {
                dF(i10 + 1);
                break;
            }
            int i12 = this.aKT;
            if (i12 == 7) {
                this.aLg = true;
                return false;
            }
            dG(i12 + 1);
            if (this.aKU == 0) {
                this.aLe--;
            } else {
                dF(0);
                break;
            }
        }
        return true;
    }

    public final int JS() {
        return this.aLc;
    }

    public final int JT() {
        return this.aLd;
    }

    public final int JU() {
        return this.aKT;
    }

    public final int JV() {
        return this.aKU;
    }

    public final int JW() {
        return this.aKV;
    }

    public final int JY() {
        return ((this.aKS.aLt * JX()) + 7) / 8;
    }
}
