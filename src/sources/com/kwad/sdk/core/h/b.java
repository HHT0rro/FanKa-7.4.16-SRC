package com.kwad.sdk.core.h;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class b implements c {
    private boolean aDI = false;
    private boolean Mi = false;
    private boolean Mj = false;

    @Override // com.kwad.sdk.core.h.c
    public final void aM() {
        this.aDI = true;
        if (this.Mj) {
            return;
        }
        ah();
        this.Mj = true;
    }

    @Override // com.kwad.sdk.core.h.c
    public final void aN() {
        if (this.aDI && !this.Mi) {
            ai();
            this.Mi = true;
        }
    }

    public abstract void ah();

    public abstract void ai();
}
