package com.cupidapp.live.superboost.purchase;

import android.view.ViewGroup;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.superlike.model.SuperLikePurchaseSkuModel;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: SuperBoostPurchaserAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class SuperBoostPurchaserAdapter extends FKBaseRecyclerViewAdapter {
    public SuperBoostPurchaserAdapter() {
        k().add(SuperLikePurchaseSkuModel.class);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        s.i(parent, "parent");
        SuperBoostPurchaseViewHolder a10 = SuperBoostPurchaseViewHolder.f18606c.a(parent);
        a10.k(l());
        return a10;
    }
}
