package com.kwad.sdk.core.video.a;

import android.media.TimedText;
import com.kwad.sdk.core.video.a.c;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class a implements c {
    private c.e Uc;
    private c.i Ud;
    private c.b Ue;
    private c.InterfaceC0530c Uf;
    private c.d Ug;
    private c.a Uh;
    private c.f aAY;
    private c.g aAZ;
    private c.h aBa;

    public static void f(float f10) {
        if (f10 == 0.0f) {
            com.kwad.sdk.core.video.a.a.a.ev("autoMute");
        } else {
            com.kwad.sdk.core.video.a.a.a.ev("autoVoice");
        }
    }

    public final void FX() {
        c.f fVar = this.aAY;
        if (fVar != null) {
            fVar.ry();
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void a(c.f fVar) {
        this.aAY = fVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void b(c.e eVar) {
        this.Uc = eVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void c(c.d dVar) {
        this.Ug = dVar;
    }

    public final void notifyOnBufferingUpdate(int i10) {
        c.a aVar = this.Uh;
        if (aVar != null) {
            aVar.av(i10);
        }
    }

    public final void notifyOnCompletion() {
        c.b bVar = this.Ue;
        if (bVar != null) {
            bVar.oZ();
        }
    }

    public final boolean notifyOnError(int i10, int i11) {
        com.kwad.sdk.core.video.a.a.a.ev("videoPlayError");
        c.InterfaceC0530c interfaceC0530c = this.Uf;
        return interfaceC0530c != null && interfaceC0530c.l(i10, i11);
    }

    public final boolean notifyOnInfo(int i10, int i11) {
        c.d dVar = this.Ug;
        return dVar != null && dVar.m(i10, i11);
    }

    public final void notifyOnPrepared() {
        c.e eVar = this.Uc;
        if (eVar != null) {
            eVar.a(this);
        }
    }

    public final void notifyOnSeekComplete() {
        c.g gVar = this.aAZ;
        if (gVar != null) {
            gVar.pa();
        }
    }

    public final void resetListeners() {
        this.aAY = null;
        this.Uc = null;
        this.Uh = null;
        this.Ue = null;
        this.aAZ = null;
        this.Ud = null;
        this.Uf = null;
        this.Ug = null;
        this.aBa = null;
    }

    public final void w(int i10, int i11) {
        c.i iVar = this.Ud;
        if (iVar != null) {
            iVar.k(i10, i11);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void a(c.b bVar) {
        this.Ue = bVar;
    }

    public final void b(TimedText timedText) {
        c.h hVar = this.aBa;
        if (hVar != null) {
            hVar.a(timedText);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void a(c.a aVar) {
        this.Uh = aVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void a(c.g gVar) {
        this.aAZ = gVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void a(c.i iVar) {
        this.Ud = iVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void a(c.InterfaceC0530c interfaceC0530c) {
        this.Uf = interfaceC0530c;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void a(c.h hVar) {
        this.aBa = hVar;
    }
}
