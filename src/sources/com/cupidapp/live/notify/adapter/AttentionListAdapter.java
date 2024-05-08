package com.cupidapp.live.notify.adapter;

import android.view.ViewGroup;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.recyclerview.FKBlankSpaceViewHolder;
import com.cupidapp.live.base.recyclerview.FKEmptyListViewHolder;
import com.cupidapp.live.base.recyclerview.MutableColumnRecyclerAdapter;
import com.cupidapp.live.base.recyclerview.model.FKBlankSpaceModel;
import com.cupidapp.live.base.recyclerview.model.FKEmptyViewModel;
import com.cupidapp.live.base.recyclerview.model.FKFooterViewModel;
import com.cupidapp.live.notify.model.AttentionNotifyModel;
import com.cupidapp.live.notify.model.AttentionStatusTitleViewModel;
import com.cupidapp.live.notify.viewholder.AttentionFakeTitleViewHolder;
import com.cupidapp.live.notify.viewholder.AttentionFakeTitleViewModel;
import com.cupidapp.live.notify.viewholder.AttentionFakeUploadViewHolder;
import com.cupidapp.live.notify.viewholder.AttentionNotifyFooterViewHolder;
import com.cupidapp.live.notify.viewholder.AttentionStatusTitleViewHolder;
import com.cupidapp.live.notify.viewholder.AttentionViewHolder;
import com.cupidapp.live.notify.viewholder.FakeUploadAvatarTipModel;
import com.cupidapp.live.notify.viewholder.NotifyTopTitleUiModel;
import com.cupidapp.live.notify.viewholder.NotifyTopTitleViewHolder;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: AttentionListAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class AttentionListAdapter extends MutableColumnRecyclerAdapter {
    public AttentionListAdapter() {
        List<Class<? extends Object>> k10 = k();
        k10.add(AttentionFakeTitleViewModel.class);
        k10.add(AttentionStatusTitleViewModel.class);
        k10.add(AttentionNotifyModel.class);
        k10.add(FakeUploadAvatarTipModel.class);
        k10.add(FKFooterViewModel.class);
        k10.add(NotifyTopTitleUiModel.class);
        k10.add(FKEmptyViewModel.class);
        k10.add(FKBlankSpaceModel.class);
    }

    @Override // com.cupidapp.live.base.recyclerview.MutableColumnRecyclerAdapter
    public int u(int i10) {
        if (i10 >= 0 && !(j().get(i10) instanceof AttentionNotifyModel)) {
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
        switch (i10) {
            case 0:
                a10 = AttentionFakeTitleViewHolder.f17569c.a(parent);
                break;
            case 1:
                a10 = AttentionStatusTitleViewHolder.f17572c.a(parent);
                break;
            case 2:
                a10 = AttentionViewHolder.f17573c.a(parent);
                break;
            case 3:
                a10 = AttentionFakeUploadViewHolder.f17570c.a(parent);
                break;
            case 4:
                a10 = AttentionNotifyFooterViewHolder.f17571c.a(parent);
                break;
            case 5:
                a10 = NotifyTopTitleViewHolder.f17577c.a(parent);
                break;
            case 6:
                a10 = FKEmptyListViewHolder.f12034c.a(parent);
                break;
            default:
                a10 = FKBlankSpaceViewHolder.f12032c.a(parent);
                break;
        }
        a10.k(l());
        return a10;
    }

    public final void y(@NotNull AttentionNotifyModel model) {
        s.i(model, "model");
        int indexOf = j().indexOf(model);
        if (f(indexOf)) {
            notifyItemChanged(indexOf);
        }
    }
}
