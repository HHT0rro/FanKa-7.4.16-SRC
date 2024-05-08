package com.cupidapp.live.maskparty.adapter;

import android.view.ViewGroup;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: MaskPartyItemCardFeaturesAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MaskPartyItemCardFeaturesAdapter extends FKBaseRecyclerViewAdapter {
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        s.i(parent, "parent");
        MaskPartyItemCardFeaturesItemViewHolder a10 = MaskPartyItemCardFeaturesItemViewHolder.f16256c.a(parent);
        a10.k(l());
        return a10;
    }
}
