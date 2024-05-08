package com.cupidapp.live.superboost.dialog;

import android.view.ViewGroup;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.superboost.model.FilterItemUiModel;
import com.cupidapp.live.superboost.model.FilterOptionModel;
import kotlin.d;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;

/* compiled from: DirectSuperBoostFilterAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class DirectSuperBoostFilterAdapter extends FKBaseRecyclerViewAdapter {

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public final Function2<FilterOptionModel, FilterItemUiModel, p> f18569f;

    /* JADX WARN: Multi-variable type inference failed */
    public DirectSuperBoostFilterAdapter(@NotNull Function2<? super FilterOptionModel, ? super FilterItemUiModel, p> itemClick) {
        s.i(itemClick, "itemClick");
        this.f18569f = itemClick;
        k().add(FilterItemUiModel.class);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        s.i(parent, "parent");
        DirectSuperBoostFilterViewHolder a10 = DirectSuperBoostFilterViewHolder.f18575d.a(parent, this.f18569f);
        a10.k(l());
        return a10;
    }
}
