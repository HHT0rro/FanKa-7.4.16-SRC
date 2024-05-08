package com.cupidapp.live.superlike.holder;

import android.view.ViewGroup;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.superlike.model.SuperLikePurchaseSkuModel;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: SuperLikePurchaseAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class SuperLikePurchaseAdapter extends FKBaseRecyclerViewAdapter {
    public SuperLikePurchaseAdapter() {
        k().add(SuperLikePurchaseSkuModel.class);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        s.i(parent, "parent");
        SuperLikePurchaseOptionViewHolder a10 = SuperLikePurchaseOptionViewHolder.f18626c.a(parent);
        a10.k(l());
        return a10;
    }
}
