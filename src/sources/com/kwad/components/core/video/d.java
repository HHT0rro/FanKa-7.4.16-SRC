package com.kwad.components.core.video;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class d {
    private boolean UC = false;
    private boolean UD = false;
    private boolean UE = false;
    private boolean UF = false;
    private boolean UG = false;
    private int UH = -1;

    public final void aN(int i10) {
        this.UH = i10;
    }

    public final void aR(boolean z10) {
        this.UE = z10;
    }

    public final boolean rB() {
        return this.UH > 0;
    }

    public final int rC() {
        return this.UH;
    }

    public final boolean rD() {
        return this.UC;
    }

    public final boolean rE() {
        return this.UD;
    }

    public final boolean rF() {
        return this.UE;
    }

    public final boolean rG() {
        return this.UF;
    }

    public final boolean rH() {
        return this.UG;
    }

    public final void setAd(boolean z10) {
        this.UD = z10;
    }

    public final void setFillXY(boolean z10) {
        this.UG = z10;
    }

    public final void setForce(boolean z10) {
        this.UC = z10;
    }

    public final void setHorizontalVideo(boolean z10) {
        this.UF = z10;
    }
}
