package com.cupidapp.live.liveshow.view.liveinfo;

import android.view.ViewGroup;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.liveshow.model.LiveActivityModel;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: FKLiveShowActivityLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveActivityAdapter extends FKBaseRecyclerViewAdapter {
    public FKLiveActivityAdapter() {
        k().add(LiveActivityModel.class);
        k().add(LiveActivityWebModel.class);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        FKBaseRecyclerViewHolder a10;
        s.i(parent, "parent");
        if (i10 == 0) {
            a10 = FKLiveActivityViewHolder.f15704c.a(parent);
        } else {
            a10 = FKLiveActivityWebViewHolder.f15705c.a(parent);
        }
        a10.k(l());
        return a10;
    }
}
