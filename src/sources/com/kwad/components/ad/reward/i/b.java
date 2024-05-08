package com.kwad.components.ad.reward.i;

import android.content.Context;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.jshandler.bf;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class b extends bf implements bf.a {

    /* renamed from: sa, reason: collision with root package name */
    private PlayableSource f36554sa;

    public b(Context context, AdTemplate adTemplate, PlayableSource playableSource) {
        super(context, adTemplate);
        this.f36554sa = playableSource;
        a(this);
    }

    @Override // com.kwad.components.core.webview.jshandler.bf.a
    public final boolean dK() {
        com.kwad.components.ad.reward.a.eX().c(this.f36554sa, new a(this.mContext));
        return false;
    }
}
