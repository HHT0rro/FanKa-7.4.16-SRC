package com.cupidapp.live.visitors.adapter;

import android.view.ViewGroup;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.visitors.model.VisitorsPurchasePriceModel;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: VisitorsPurchaseRecyclerAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VisitorsPurchaseRecyclerAdapter extends FKBaseRecyclerViewAdapter {
    public VisitorsPurchaseRecyclerAdapter() {
        k().add(VisitorsPurchasePriceModel.class);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        s.i(parent, "parent");
        VisitorsPurchasePriceViewHolder a10 = VisitorsPurchasePriceViewHolder.f18940c.a(parent);
        a10.k(l());
        return a10;
    }
}