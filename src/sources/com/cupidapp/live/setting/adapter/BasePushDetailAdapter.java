package com.cupidapp.live.setting.adapter;

import android.view.ViewGroup;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.setting.model.NewPushLiveShowItemModel;
import com.cupidapp.live.setting.model.NewPushLiveShowModel;
import com.cupidapp.live.setting.viewholder.NewPushHeaderHolder;
import com.cupidapp.live.setting.viewholder.NewPushItemHolder;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: BasePushDetailAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class BasePushDetailAdapter extends FKBaseRecyclerViewAdapter {
    public BasePushDetailAdapter() {
        List<Class<? extends Object>> k10 = k();
        k10.add(NewPushLiveShowModel.class);
        k10.add(NewPushLiveShowItemModel.class);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        FKBaseRecyclerViewHolder a10;
        s.i(parent, "parent");
        if (i10 == 0) {
            a10 = NewPushHeaderHolder.f18245c.a(parent);
        } else {
            a10 = NewPushItemHolder.f18246c.a(parent);
        }
        a10.k(l());
        return a10;
    }
}
