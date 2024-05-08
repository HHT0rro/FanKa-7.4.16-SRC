package com.cupidapp.live.setting.adapter;

import android.view.ViewGroup;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.profile.model.FKStoryLabelItemModel;
import com.cupidapp.live.profile.model.FKStoryLabelListModel;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p1.g;

/* compiled from: FKStoryLabelAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKStoryLabelAdapter extends FKBaseRecyclerViewAdapter {
    public FKStoryLabelAdapter() {
        k().add(FKStoryLabelTipsModel.class);
        k().add(FKStoryLabelTitleModel.class);
        k().add(FKStoryLabelItemModel.class);
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter
    public void m(@Nullable List<? extends Object> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        j().clear();
        g gVar = g.f52734a;
        if (s.d(gVar.o1().c(), Boolean.TRUE)) {
            d(new FKStoryLabelTipsModel(R$string.story_label_tips));
            gVar.o1().d(Boolean.FALSE);
        }
        for (Object obj : list) {
            if (obj instanceof FKStoryLabelListModel) {
                FKStoryLabelListModel fKStoryLabelListModel = (FKStoryLabelListModel) obj;
                d(new FKStoryLabelTitleModel(fKStoryLabelListModel.getIcon(), fKStoryLabelListModel.getTitle()));
                e(fKStoryLabelListModel.getLabelList());
            }
        }
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        FKBaseRecyclerViewHolder a10;
        s.i(parent, "parent");
        if (i10 == 0) {
            a10 = FKStoryLabelTipsViewHolder.f18089d.a(parent);
        } else if (i10 != 1) {
            a10 = FKStoryLabelViewHolder.f18093e.a(parent, n());
        } else {
            a10 = FKStoryLabelTitleViewHolder.f18091d.a(parent);
        }
        a10.k(l());
        return a10;
    }
}
