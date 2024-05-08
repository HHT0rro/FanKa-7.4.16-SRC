package com.kwad.components.ad.interstitial.e;

import com.kwad.sdk.mvp.Presenter;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class b extends Presenter {
    public c jK;

    @Override // com.kwad.sdk.mvp.Presenter
    public void aj() {
        super.aj();
        this.jK = (c) Jx();
    }

    public void cP() {
        List<Presenter> Jw = Jw();
        if (Jw == null) {
            return;
        }
        for (Presenter presenter : Jw) {
            if (presenter instanceof b) {
                ((b) presenter).cP();
            }
        }
    }

    public void cQ() {
        List<Presenter> Jw = Jw();
        if (Jw == null) {
            return;
        }
        for (Presenter presenter : Jw) {
            if (presenter instanceof b) {
                ((b) presenter).cQ();
            }
        }
    }
}
