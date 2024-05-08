package com.kwad.components.ad.reward.n;

import android.content.Context;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class a implements b {
    private Context mContext;
    private com.kwad.components.ad.reward.g qo;

    public a(Context context, com.kwad.components.ad.reward.g gVar) {
        this.qo = gVar;
        this.mContext = context;
    }

    @Override // com.kwad.components.ad.reward.n.b
    public final void gJ() {
        this.qo.a(1, this.mContext, 1, 1);
    }

    @Override // com.kwad.components.ad.reward.n.b
    public void ih() {
        this.qo.a(1, this.mContext, 13, 2);
    }

    @Override // com.kwad.components.ad.reward.n.b
    public void ii() {
        this.qo.a(1, this.mContext, 117, 2);
    }
}
