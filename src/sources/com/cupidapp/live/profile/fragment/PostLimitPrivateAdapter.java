package com.cupidapp.live.profile.fragment;

import android.view.ViewGroup;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.recyclerview.FKEmptyListViewHolder;
import com.cupidapp.live.base.recyclerview.FKErrorListViewHolder;
import com.cupidapp.live.base.recyclerview.FKFooterViewHolder;
import com.cupidapp.live.base.recyclerview.MutableColumnRecyclerAdapter;
import com.cupidapp.live.base.recyclerview.model.FKEmptyViewModel;
import com.cupidapp.live.base.recyclerview.model.FKErrorViewModel;
import com.cupidapp.live.base.recyclerview.model.FKFooterViewModel;
import com.cupidapp.live.base.recyclerview.model.FKTitleUiModel;
import com.cupidapp.live.feed.model.PostLimitDetailModel;
import com.cupidapp.live.profile.holder.PostLimitPrivateViewHolder;
import com.cupidapp.live.profile.holder.PrivateFeedTitleViewHolder;
import java.util.List;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: PostLimitPrivateFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class PostLimitPrivateAdapter extends MutableColumnRecyclerAdapter {
    public PostLimitPrivateAdapter() {
        List<Class<? extends Object>> k10 = k();
        k10.add(PostLimitDetailModel.class);
        k10.add(FKEmptyViewModel.class);
        k10.add(FKTitleUiModel.class);
        k10.add(FKErrorViewModel.class);
        k10.add(FKFooterViewModel.class);
    }

    @Override // com.cupidapp.live.base.recyclerview.MutableColumnRecyclerAdapter
    public int u(int i10) {
        if (i10 >= 0 && !(j().get(i10) instanceof PostLimitDetailModel)) {
            return v();
        }
        return 1;
    }

    @Override // com.cupidapp.live.base.recyclerview.MutableColumnRecyclerAdapter
    public int v() {
        return 3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        FKBaseRecyclerViewHolder a10;
        s.i(parent, "parent");
        if (i10 == 0) {
            a10 = PostLimitPrivateViewHolder.f17816c.a(parent);
        } else if (i10 == 1) {
            a10 = FKEmptyListViewHolder.f12034c.a(parent);
        } else if (i10 == 2) {
            a10 = PrivateFeedTitleViewHolder.f17817c.a(parent);
        } else if (i10 != 3) {
            a10 = FKFooterViewHolder.f12036c.a(parent);
        } else {
            a10 = FKErrorListViewHolder.f12035c.a(parent);
        }
        a10.k(l());
        return a10;
    }
}
