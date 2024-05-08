package com.kwad.components.ad.reward.n;

import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.annotation.IdRes;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class s extends d {
    public ViewGroup sz;

    public final void a(ViewGroup viewGroup, @IdRes int i10, @IdRes int i11) {
        if (this.sz != null) {
            return;
        }
        ViewStub viewStub = (ViewStub) viewGroup.findViewById(i10);
        if (viewStub != null) {
            this.sz = (ViewGroup) viewStub.inflate();
        } else {
            this.sz = (ViewGroup) viewGroup.findViewById(i11);
        }
    }

    @Override // com.kwad.components.ad.reward.n.d
    public ViewGroup gF() {
        return this.sz;
    }
}
