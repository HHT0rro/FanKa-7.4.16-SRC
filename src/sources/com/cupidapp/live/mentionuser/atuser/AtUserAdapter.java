package com.cupidapp.live.mentionuser.atuser;

import android.view.ViewGroup;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.recyclerview.FKEmptyListViewHolder;
import com.cupidapp.live.base.recyclerview.model.FKEmptyViewModel;
import com.cupidapp.live.mentionuser.model.AtUserTitleUIModel;
import com.cupidapp.live.mentionuser.model.RecentAtUserUIModel;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.search.holder.SearchUserViewHolder;
import com.cupidapp.live.search.model.SearchModel;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AtUserAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class AtUserAdapter extends FKBaseRecyclerViewAdapter {

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public final Function1<User, p> f17479f;

    public AtUserAdapter() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AtUserAdapter(@Nullable Function1<? super User, p> function1) {
        this.f17479f = function1;
        k().add(SearchModel.class);
        k().add(AtUserTitleUIModel.class);
        k().add(RecentAtUserUIModel.class);
        k().add(User.class);
        k().add(FKEmptyViewModel.class);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        FKBaseRecyclerViewHolder a10;
        s.i(parent, "parent");
        if (i10 == 0) {
            a10 = SearchUserViewHolder.f17919c.a(parent);
        } else if (i10 == 1) {
            a10 = AtUserTitleViewHolder.f17480c.a(parent);
        } else if (i10 == 2) {
            a10 = RecentAtUserViewHolder.f17481d.a(parent, this.f17479f);
        } else if (i10 != 3) {
            a10 = FKEmptyListViewHolder.f12034c.a(parent);
        } else {
            a10 = RecommendAtUserViewHolder.f17483c.a(parent);
        }
        a10.k(l());
        return a10;
    }

    public /* synthetic */ AtUserAdapter(Function1 function1, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : function1);
    }
}
