package com.cupidapp.live.liveshow.adapter;

import android.view.ViewGroup;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.liveshow.model.HeatItemModel;
import com.cupidapp.live.liveshow.viewholder.HeatIntroViewHolder;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: HeatIntroAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class HeatIntroAdapter extends FKBaseRecyclerViewAdapter {
    public HeatIntroAdapter() {
        k().add(HeatItemModel.class);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        s.i(parent, "parent");
        HeatIntroViewHolder a10 = HeatIntroViewHolder.f16054c.a(parent);
        a10.k(l());
        return a10;
    }
}
