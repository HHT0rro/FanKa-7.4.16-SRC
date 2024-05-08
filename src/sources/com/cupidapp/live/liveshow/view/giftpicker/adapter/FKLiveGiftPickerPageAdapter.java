package com.cupidapp.live.liveshow.view.giftpicker.adapter;

import android.view.ViewGroup;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;

/* compiled from: FKLiveGiftPickerPageAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveGiftPickerPageAdapter extends FKBaseRecyclerViewAdapter {

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public final Function1<FKLiveGiftPickerItemViewModel, p> f15428f;

    /* JADX WARN: Multi-variable type inference failed */
    public FKLiveGiftPickerPageAdapter(@NotNull Function1<? super FKLiveGiftPickerItemViewModel, p> showGiftExpiredList) {
        s.i(showGiftExpiredList, "showGiftExpiredList");
        this.f15428f = showGiftExpiredList;
        k().add(FKLiveGiftPickerPageViewModel.class);
        k().add(FKLiveGiftPickerEmptyUiModel.class);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        s.i(parent, "parent");
        if (i10 == 0) {
            return FKLiveGiftPickerPageViewHolder.f15429e.a(parent, this.f15428f);
        }
        return FKLiveGiftEmptyViewHolder.f15424c.a(parent);
    }
}
