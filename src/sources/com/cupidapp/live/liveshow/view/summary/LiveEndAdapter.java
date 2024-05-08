package com.cupidapp.live.liveshow.view.summary;

import android.view.ViewGroup;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.recyclerview.FKFooterViewHolder;
import com.cupidapp.live.base.recyclerview.MutableColumnRecyclerAdapter;
import com.cupidapp.live.base.recyclerview.model.FKFooterViewModel;
import com.cupidapp.live.liveshow.model.AnchorModel;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: LiveEndAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveEndAdapter extends MutableColumnRecyclerAdapter {
    public LiveEndAdapter() {
        k().add(AnchorModel.class);
        k().add(LiveEndTitleModel.class);
        k().add(LiveShowModel.class);
        k().add(FKFooterViewModel.class);
    }

    @Override // com.cupidapp.live.base.recyclerview.MutableColumnRecyclerAdapter
    public int u(int i10) {
        if (i10 >= 0 && !(j().get(i10) instanceof LiveShowModel)) {
            return v();
        }
        return 1;
    }

    @Override // com.cupidapp.live.base.recyclerview.MutableColumnRecyclerAdapter
    public int v() {
        return 2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        FKBaseRecyclerViewHolder a10;
        s.i(parent, "parent");
        if (i10 == 0) {
            a10 = LiveEndAnchorViewHolder.f15947f.a(parent);
        } else if (i10 == 1) {
            a10 = LiveEndTitleViewHolder.f15954c.a(parent);
        } else if (i10 != 2) {
            a10 = FKFooterViewHolder.f12036c.a(parent);
        } else {
            a10 = LiveEndRecommendLiveViewHolder.f15953c.a(parent);
        }
        a10.k(l());
        return a10;
    }
}
