package com.kwad.components.core.q;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class a {
    private static volatile a Ss;
    private int Pb;
    private int St;
    private boolean Su;
    private boolean Sv;
    private int Sw;
    private boolean Sx;

    private a() {
    }

    public static a qH() {
        if (Ss == null) {
            synchronized (a.class) {
                if (Ss == null) {
                    Ss = new a();
                }
            }
        }
        return Ss;
    }

    public final void aH(int i10) {
        this.St = i10;
    }

    public final void aI(int i10) {
        this.Sw = i10;
    }

    public final void aJ(int i10) {
        this.Pb = i10;
    }

    public final void aK(boolean z10) {
        this.Su = true;
    }

    public final void aL(boolean z10) {
        this.Sv = z10;
    }

    public final void aM(boolean z10) {
        this.Sx = z10;
    }

    public final void clear() {
        this.Sv = false;
        this.Su = false;
        this.Sw = 0;
        this.Sx = false;
        this.St = -1;
        this.Pb = 0;
    }

    public final int qI() {
        return this.St;
    }

    public final boolean qJ() {
        return this.Su;
    }

    public final boolean qK() {
        return this.Sv;
    }

    public final boolean qL() {
        int i10 = this.Sw;
        return i10 == 1 || i10 == 3;
    }

    public final int qM() {
        return this.Sw;
    }

    public final boolean qN() {
        return this.Sx;
    }

    public final int qO() {
        return this.Pb;
    }
}
