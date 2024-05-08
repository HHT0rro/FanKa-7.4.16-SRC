package com.kwad.components.ad.reward.m;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.g;
import com.kwad.components.core.video.l;
import com.kwad.sdk.utils.h;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class e {
    private g qo;

    @Nullable
    private com.kwad.components.ad.reward.f.a xT;

    @Nullable
    private d xU;

    @Nullable
    private b xV;

    @NonNull
    private com.kwad.components.ad.j.a xW;
    private int xS = 0;
    private int xX = 0;
    private List<l> xY = new CopyOnWriteArrayList();

    public e(g gVar) {
        this.qo = gVar;
        this.xW = new a(gVar.mAdTemplate);
    }

    private com.kwad.components.ad.j.a jL() {
        return this.xW;
    }

    public final void a(int i10, com.kwad.components.ad.j.a aVar) {
        this.xS = i10;
        if (i10 == 1) {
            this.xU = (d) aVar;
        } else if (i10 == 2) {
            this.xT = (com.kwad.components.ad.reward.f.a) aVar;
        } else if (i10 == 3) {
            this.xV = (b) aVar;
        }
        this.xW = aVar;
        Iterator<l> iterator2 = this.xY.iterator2();
        while (iterator2.hasNext()) {
            this.xW.b(iterator2.next());
        }
        this.xY.clear();
    }

    public final void b(@Nullable l lVar) {
        jL().a(lVar);
        if (lVar != null) {
            this.xY.remove(lVar);
        }
    }

    public final long getPlayDuration() {
        return jL().getPlayDuration();
    }

    public final void jI() {
        d dVar = this.xU;
        if (dVar != null) {
            dVar.jI();
        } else {
            b bVar = this.xV;
            if (bVar != null) {
                bVar.jI();
            }
        }
        this.qo.fy();
    }

    public final void jJ() {
        d dVar = this.xU;
        if (dVar != null) {
            dVar.jJ();
        }
    }

    public final boolean jM() {
        return this.xT != null;
    }

    @Nullable
    public final com.kwad.components.ad.reward.f.a jN() {
        return this.xT;
    }

    @Nullable
    public final b jO() {
        return this.xV;
    }

    public final void pause() {
        jL().pause();
    }

    public final void release() {
        jL().release();
    }

    public final void resume() {
        int i10;
        jL().resume();
        com.kwad.components.ad.reward.f.a aVar = this.xT;
        if (aVar == null || (i10 = this.xX) <= 0) {
            return;
        }
        aVar.setAudioEnabled(i10 == 2, false);
    }

    public final void setAudioEnabled(boolean z10, boolean z11) {
        this.xX = z10 ? 2 : 1;
        jL().setAudioEnabled(z10, z11);
    }

    public final void skipToEnd() {
        jL().skipToEnd();
    }

    public final void b(h.a aVar) {
        d dVar = this.xU;
        if (dVar != null) {
            dVar.b(aVar);
        }
    }

    public final void a(@Nullable l lVar) {
        if (jL().jH()) {
            this.xY.add(lVar);
        } else {
            jL().b(lVar);
        }
    }

    public final void a(h.a aVar) {
        d dVar = this.xU;
        if (dVar != null) {
            dVar.a(aVar);
        }
    }
}
