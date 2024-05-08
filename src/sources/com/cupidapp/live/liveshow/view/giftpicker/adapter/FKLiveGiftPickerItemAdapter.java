package com.cupidapp.live.liveshow.view.giftpicker.adapter;

import android.view.ViewGroup;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: FKLiveGiftPickerItemAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveGiftPickerItemAdapter extends FKBaseRecyclerViewAdapter {
    public FKLiveGiftPickerItemAdapter() {
        k().add(FKLiveGiftPickerItemViewModel.class);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        s.i(parent, "parent");
        FKLiveGiftPickerItemViewHolder a10 = FKLiveGiftPickerItemViewHolder.f15426c.a(parent);
        a10.k(l());
        return a10;
    }
}
