package com.cupidapp.live.profile.adapter;

import android.view.ViewGroup;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.profile.holder.FriendPraiseDetailViewHolder;
import com.cupidapp.live.profile.model.FriendPraiseDetailModel;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FriendPraiseDetailAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FriendPraiseDetailAdapter extends FKBaseRecyclerViewAdapter {
    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: q */
    public void onViewDetachedFromWindow(@NotNull FKBaseRecyclerViewHolder holder) {
        s.i(holder, "holder");
        super.onViewDetachedFromWindow(holder);
        FriendPraiseDetailViewHolder friendPraiseDetailViewHolder = holder instanceof FriendPraiseDetailViewHolder ? (FriendPraiseDetailViewHolder) holder : null;
        if (friendPraiseDetailViewHolder != null) {
            friendPraiseDetailViewHolder.s();
        }
    }

    public final void u(@Nullable List<FriendPraiseDetailModel> list, @Nullable Boolean bool) {
        if (bool != null) {
            bool.booleanValue();
            if (list == null || list.isEmpty()) {
                if (bool.booleanValue()) {
                    return;
                }
                int size = j().size();
                j().clear();
                notifyItemRangeRemoved(0, size);
                return;
            }
            if (bool.booleanValue()) {
                notifyItemRangeInserted(e(list), list.size());
                return;
            }
            j().clear();
            e(list);
            notifyDataSetChanged();
        }
    }

    public final void v(@NotNull FriendPraiseDetailModel model) {
        s.i(model, "model");
        int indexOf = j().indexOf(model);
        if (f(indexOf)) {
            j().remove(indexOf);
            notifyItemRemoved(indexOf);
        }
    }

    public final boolean w() {
        return !j().isEmpty();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        s.i(parent, "parent");
        FriendPraiseDetailViewHolder a10 = FriendPraiseDetailViewHolder.f17808d.a(parent);
        a10.k(l());
        return a10;
    }

    public final void y(@NotNull FriendPraiseDetailModel model) {
        s.i(model, "model");
        for (Object obj : j()) {
            if (obj instanceof FriendPraiseDetailModel) {
                ((FriendPraiseDetailModel) obj).setHomePageDisplay(Boolean.FALSE);
            }
        }
        model.setHomePageDisplay(Boolean.TRUE);
        notifyItemRangeChanged(0, j().size());
    }

    public final void z(@NotNull FriendPraiseDetailModel model) {
        s.i(model, "model");
        int indexOf = j().indexOf(model);
        if (f(indexOf)) {
            j().set(indexOf, model);
            notifyItemChanged(indexOf);
        }
    }
}
