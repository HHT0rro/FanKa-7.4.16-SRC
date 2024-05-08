package com.cupidapp.live.maskparty.adapter;

import android.view.ViewGroup;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.maskparty.model.ItemCardFeaturesItemModel;
import com.cupidapp.live.maskparty.model.ItemCardFeaturesModel;
import com.cupidapp.live.maskparty.model.ItemCardPurchaseModel;
import com.cupidapp.live.superlike.model.SuperLikePurchaseSkuModel;
import com.cupidapp.live.vip.model.PayType;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MaskPartyItemCardAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MaskPartyItemCardAdapter extends FKBaseRecyclerViewAdapter {

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public Function1<? super ItemCardFeaturesItemModel, p> f16254f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public Function2<? super SuperLikePurchaseSkuModel, ? super PayType, p> f16255g;

    public MaskPartyItemCardAdapter() {
        k().add(ItemCardFeaturesModel.class);
        k().add(ItemCardPurchaseModel.class);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        s.i(parent, "parent");
        if (i10 == 0) {
            return MaskPartyItemCardFeaturesViewHolder.f16257e.a(parent, this.f16254f);
        }
        return MaskPartyItemCardPurchaseViewHolder.f16262f.a(parent, this.f16255g);
    }

    public final void v(@Nullable Function2<? super SuperLikePurchaseSkuModel, ? super PayType, p> function2) {
        this.f16255g = function2;
    }

    public final void w(@Nullable Function1<? super ItemCardFeaturesItemModel, p> function1) {
        this.f16254f = function1;
    }
}
