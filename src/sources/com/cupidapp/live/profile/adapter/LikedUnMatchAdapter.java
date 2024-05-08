package com.cupidapp.live.profile.adapter;

import android.view.ViewGroup;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.recyclerview.FKEmptyListViewHolder;
import com.cupidapp.live.base.recyclerview.FKFooterWithSpaceViewHolder;
import com.cupidapp.live.base.recyclerview.model.FKEmptyViewModel;
import com.cupidapp.live.base.recyclerview.model.FKFooterWithSpaceModel;
import com.cupidapp.live.base.view.h;
import com.cupidapp.live.profile.holder.BanUserViewHolder;
import com.cupidapp.live.profile.holder.UnMatchViewHolder;
import com.cupidapp.live.profile.model.BanUserModel;
import com.cupidapp.live.profile.model.User;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.x;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: LikedUnMatchAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class LikedUnMatchAdapter extends FKBaseRecyclerViewAdapter {

    /* renamed from: f, reason: collision with root package name */
    public boolean f17717f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public List<String> f17718g = new ArrayList();

    public LikedUnMatchAdapter() {
        k().add(User.class);
        k().add(BanUserModel.class);
        k().add(FKFooterWithSpaceModel.class);
        k().add(FKEmptyViewModel.class);
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: o */
    public void onBindViewHolder(@NotNull FKBaseRecyclerViewHolder holder, int i10) {
        s.i(holder, "holder");
        super.onBindViewHolder(holder, i10);
        if (holder instanceof UnMatchViewHolder) {
            UnMatchViewHolder unMatchViewHolder = (UnMatchViewHolder) holder;
            unMatchViewHolder.s(this.f17717f);
            unMatchViewHolder.r(this.f17718g);
        }
    }

    public final void u(@NotNull String id2) {
        s.i(id2, "id");
        if (this.f17718g.size() == 50) {
            notifyDataSetChanged();
            h.f12779a.k(R$string.select_limit_max_50);
        } else {
            this.f17718g.add(id2);
            notifyDataSetChanged();
        }
    }

    public final void v(boolean z10) {
        if (this.f17717f != z10) {
            this.f17717f = z10;
            this.f17718g.clear();
            notifyDataSetChanged();
        }
    }

    public final void w(@NotNull final List<String> list) {
        s.i(list, "list");
        boolean B = x.B(j(), new Function1<Object, Boolean>() { // from class: com.cupidapp.live.profile.adapter.LikedUnMatchAdapter$clearSelectUsers$removed$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Object it) {
                s.i(it, "it");
                return Boolean.valueOf((it instanceof User) && list.contains(((User) it).userId()));
            }
        });
        this.f17718g.clear();
        if (B) {
            notifyDataSetChanged();
        }
    }

    @NotNull
    public final List<String> x() {
        return this.f17718g;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        FKBaseRecyclerViewHolder a10;
        s.i(parent, "parent");
        if (i10 == 0) {
            a10 = UnMatchViewHolder.f17831c.a(parent);
        } else if (i10 == 1) {
            a10 = BanUserViewHolder.f17801c.a(parent);
        } else if (i10 != 2) {
            a10 = FKEmptyListViewHolder.f12034c.a(parent);
        } else {
            a10 = FKFooterWithSpaceViewHolder.f12037c.a(parent);
        }
        a10.k(l());
        return a10;
    }

    public final void z(@NotNull String id2) {
        s.i(id2, "id");
        if (this.f17718g.remove(id2)) {
            notifyDataSetChanged();
        }
    }
}
