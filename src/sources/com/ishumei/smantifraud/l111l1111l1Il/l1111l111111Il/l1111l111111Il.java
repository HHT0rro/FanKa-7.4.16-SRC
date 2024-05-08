package com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class l1111l111111Il implements l11l1111I1l {
    private static int l1111l111111Il = 2000;
    private static float l111l11111I1l = 0.0f;
    private static int l111l11111lIl = 1;
    private final int l111l11111Il;
    private final float l111l1111l1Il;
    private int l111l1111lI1l;
    private int l111l1111llIl;

    public l1111l111111Il() {
        this(2000, 1, 0.0f);
    }

    public l1111l111111Il(int i10, int i11, float f10) {
        this.l111l1111llIl = i10;
        this.l111l11111Il = i11;
        this.l111l1111l1Il = f10;
    }

    private float l111l11111I1l() {
        return this.l111l1111l1Il;
    }

    private boolean l111l11111Il() {
        return this.l111l1111lI1l <= this.l111l11111Il;
    }

    @Override // com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l11l1111I1l
    public final int l1111l111111Il() {
        return this.l111l1111llIl;
    }

    @Override // com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l11l1111I1l
    public final void l1111l111111Il(l11l1111I1ll l11l1111i1ll) {
        int i10 = this.l111l1111lI1l + 1;
        this.l111l1111lI1l = i10;
        int i11 = this.l111l1111llIl;
        this.l111l1111llIl = i11 + ((int) (i11 * this.l111l1111l1Il));
        if (!(i10 <= this.l111l11111Il)) {
            throw l11l1111i1ll;
        }
    }

    @Override // com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il.l11l1111I1l
    public final int l111l11111lIl() {
        return this.l111l1111lI1l;
    }
}
