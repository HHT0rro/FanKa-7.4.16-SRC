package com.cupidapp.live.liveshow.view.menu;

import android.view.ViewGroup;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.recyclerview.MutableColumnRecyclerAdapter;
import com.cupidapp.live.liveshow.model.LiveFunctionMenuListModel;
import com.cupidapp.live.liveshow.model.LiveFunctionMenuModel;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LiveFunctionMenuAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveFunctionMenuAdapter extends MutableColumnRecyclerAdapter {

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public Function1<? super LiveFunctionMenuModel, p> f15733g;

    public LiveFunctionMenuAdapter() {
        k().add(LiveFunctionMenuListModel.class);
        k().add(LiveFunctionMenuModel.class);
        k().add(MenuTitleModel.class);
    }

    @Override // com.cupidapp.live.base.recyclerview.MutableColumnRecyclerAdapter
    public int u(int i10) {
        if (i10 >= 0 && !(j().get(i10) instanceof LiveFunctionMenuModel)) {
            return v();
        }
        return 1;
    }

    @Override // com.cupidapp.live.base.recyclerview.MutableColumnRecyclerAdapter
    public int v() {
        return 5;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        FKBaseRecyclerViewHolder a10;
        s.i(parent, "parent");
        if (i10 == 0) {
            a10 = RectangleMenuViewHolder.f15745e.a(parent, this.f15733g);
        } else if (i10 != 1) {
            a10 = MenuTitleViewHolder.f15743c.a(parent);
        } else {
            a10 = SquareMenuViewHolder.f15748c.a(parent);
        }
        a10.k(l());
        return a10;
    }

    public final void y(@Nullable Function1<? super LiveFunctionMenuModel, p> function1) {
        this.f15733g = function1;
    }
}
