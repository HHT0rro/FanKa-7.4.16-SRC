package com.kwad.components.ad.reward.n;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.kwad.sdk.utils.ai;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class d {
    public void a(r rVar) {
    }

    public void ab(boolean z10) {
    }

    public final void b(@NonNull r rVar) {
        a(rVar);
        gF().getContext();
        ab(ai.LZ());
    }

    public abstract ViewGroup gF();

    public void onUnbind() {
    }
}
