package com.cupidapp.live.club.adapter;

import android.view.ViewGroup;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.recyclerview.FKEmptyListViewHolder;
import com.cupidapp.live.base.recyclerview.FKFooterWithSpaceViewHolder;
import com.cupidapp.live.base.recyclerview.model.FKEmptyViewModel;
import com.cupidapp.live.base.recyclerview.model.FKFooterWithSpaceModel;
import com.cupidapp.live.base.view.h;
import com.cupidapp.live.club.viewholder.ClubAtUserViewHolder;
import com.cupidapp.live.profile.model.User;
import java.util.ArrayList;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: ClubAtUserListAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ClubAtUserListAdapter extends FKBaseRecyclerViewAdapter {

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public static final a f13509h = new a(null);

    /* renamed from: f, reason: collision with root package name */
    public boolean f13510f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public List<String> f13511g = new ArrayList();

    /* compiled from: ClubAtUserListAdapter.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ClubAtUserListAdapter() {
        k().add(User.class);
        k().add(FKEmptyViewModel.class);
        k().add(FKFooterWithSpaceModel.class);
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: o */
    public void onBindViewHolder(@NotNull FKBaseRecyclerViewHolder holder, int i10) {
        s.i(holder, "holder");
        super.onBindViewHolder(holder, i10);
        if (holder instanceof ClubAtUserViewHolder) {
            ClubAtUserViewHolder clubAtUserViewHolder = (ClubAtUserViewHolder) holder;
            clubAtUserViewHolder.s(this.f13510f);
            clubAtUserViewHolder.r(this.f13511g);
        }
    }

    public final void u(@NotNull String id2, int i10) {
        s.i(id2, "id");
        if (this.f13511g.size() >= i10) {
            notifyDataSetChanged();
            h.f12779a.k(R$string.club_at_user_max_nine);
        } else {
            this.f13511g.add(id2);
            notifyDataSetChanged();
        }
    }

    public final void v(boolean z10) {
        if (this.f13510f != z10) {
            this.f13510f = z10;
            this.f13511g.clear();
            notifyDataSetChanged();
        }
    }

    @NotNull
    public final List<String> w() {
        return this.f13511g;
    }

    public final boolean x() {
        return this.f13510f;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        FKBaseRecyclerViewHolder a10;
        s.i(parent, "parent");
        if (i10 == 0) {
            a10 = ClubAtUserViewHolder.f13682c.a(parent);
        } else if (i10 != 1) {
            a10 = FKFooterWithSpaceViewHolder.f12037c.a(parent);
        } else {
            a10 = FKEmptyListViewHolder.f12034c.a(parent);
        }
        a10.k(l());
        return a10;
    }

    public final void z(@NotNull String id2) {
        s.i(id2, "id");
        if (this.f13511g.remove(id2)) {
            notifyDataSetChanged();
        }
    }
}
