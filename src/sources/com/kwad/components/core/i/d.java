package com.kwad.components.core.i;

import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsInnerAd;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class d {

    @Nullable
    private Object Me;

    public d(Object obj) {
        this.Me = obj;
    }

    public final void c(c cVar) {
        if (this.Me == null || cVar == null || cVar.getHost() == null) {
            return;
        }
        try {
            ((KsInnerAd.KsInnerAdInteractionListener) this.Me).onAdClicked((KsInnerAd) cVar.getHost());
        } catch (Exception unused) {
        }
    }

    public final void d(c cVar) {
        if (this.Me == null || cVar == null || cVar.getHost() == null) {
            return;
        }
        try {
            ((KsInnerAd.KsInnerAdInteractionListener) this.Me).onAdShow((KsInnerAd) cVar.getHost());
        } catch (Exception unused) {
        }
    }

    public final void destroy() {
        this.Me = null;
    }
}
