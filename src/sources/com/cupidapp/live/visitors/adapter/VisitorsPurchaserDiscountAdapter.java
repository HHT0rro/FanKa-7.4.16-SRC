package com.cupidapp.live.visitors.adapter;

import android.view.ViewGroup;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.vip.model.VipPurchasePriceModel;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: VisitorsPurchaserNewAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VisitorsPurchaserDiscountAdapter extends FKBaseRecyclerViewAdapter {
    public VisitorsPurchaserDiscountAdapter() {
        k().add(VipPurchasePriceModel.class);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        s.i(parent, "parent");
        VisitorsPurchaseNewViewHolder a10 = VisitorsPurchaseNewViewHolder.f18938d.a(parent, j().size());
        a10.k(l());
        return a10;
    }
}
