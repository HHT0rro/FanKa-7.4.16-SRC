package com.cupidapp.live.notify.adapter;

import android.view.ViewGroup;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.recyclerview.FKEmptyListViewHolder;
import com.cupidapp.live.base.recyclerview.FKFooterViewHolder;
import com.cupidapp.live.base.recyclerview.model.FKEmptyViewModel;
import com.cupidapp.live.base.recyclerview.model.FKFooterViewModel;
import com.cupidapp.live.notify.model.NotifyFriendPraiseModel;
import com.cupidapp.live.notify.model.PostNotifyModel;
import com.cupidapp.live.notify.viewholder.PostNotifyListViewHolder;
import java.util.List;
import kotlin.d;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PostNotifyAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class PostNotifyAdapter extends FKBaseRecyclerViewAdapter {

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public final Function2<String, PostNotifyModel, p> f17496f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public ImageModel f17497g;

    /* JADX WARN: Multi-variable type inference failed */
    public PostNotifyAdapter(@NotNull Function2<? super String, ? super PostNotifyModel, p> atUserClickListener) {
        s.i(atUserClickListener, "atUserClickListener");
        this.f17496f = atUserClickListener;
        List<Class<? extends Object>> k10 = k();
        k10.add(PostNotifyModel.class);
        k10.add(FKFooterViewModel.class);
        k10.add(FKEmptyViewModel.class);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        FKBaseRecyclerViewHolder a10;
        s.i(parent, "parent");
        if (i10 == 0) {
            a10 = PostNotifyListViewHolder.f17578e.a(parent, this.f17497g, this.f17496f);
        } else if (i10 != 1) {
            a10 = FKEmptyListViewHolder.f12034c.a(parent);
        } else {
            a10 = FKFooterViewHolder.f12036c.a(parent);
        }
        a10.k(l());
        return a10;
    }

    public final void v(@Nullable ImageModel imageModel) {
        this.f17497g = imageModel;
    }

    public final void w(@NotNull PostNotifyModel model) {
        NotifyFriendPraiseModel praise;
        s.i(model, "model");
        for (Object obj : j()) {
            if ((obj instanceof PostNotifyModel) && (praise = ((PostNotifyModel) obj).getPraise()) != null) {
                praise.setHomePageDisplay(Boolean.FALSE);
            }
        }
        NotifyFriendPraiseModel praise2 = model.getPraise();
        if (praise2 != null) {
            praise2.setHomePageDisplay(Boolean.TRUE);
        }
        notifyItemRangeChanged(0, j().size());
    }
}
