package com.cupidapp.live.profile.activity;

import android.view.ViewGroup;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.recyclerview.FKFooterViewHolder;
import com.cupidapp.live.base.recyclerview.model.FKFooterViewModel;
import com.cupidapp.live.profile.model.User;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* compiled from: NonexistentUserActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class NonexistentUserAdapter extends FKBaseRecyclerViewAdapter {
    public NonexistentUserAdapter() {
        List<Class<? extends Object>> k10 = k();
        k10.add(User.class);
        k10.add(FKFooterViewModel.class);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        FKBaseRecyclerViewHolder a10;
        kotlin.jvm.internal.s.i(parent, "parent");
        if (i10 == 0) {
            a10 = NonexistentUserViewHolder.f17647c.a(parent);
        } else {
            a10 = FKFooterViewHolder.f12036c.a(parent);
        }
        a10.k(l());
        return a10;
    }
}
