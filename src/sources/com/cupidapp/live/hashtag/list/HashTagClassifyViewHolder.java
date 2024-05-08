package com.cupidapp.live.hashtag.list;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.databinding.ItemClassifyHashtagBinding;
import com.cupidapp.live.hashtag.model.ui.HashTagClassifyModel;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: HashTagClassifyViewHolder.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class HashTagClassifyViewHolder extends RecyclerView.ViewHolder {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final a f14711b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public final ItemClassifyHashtagBinding f14712a;

    /* compiled from: HashTagClassifyViewHolder.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final HashTagClassifyViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            ItemClassifyHashtagBinding binding = (ItemClassifyHashtagBinding) DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R$layout.item_classify_hashtag, parent, false);
            s.h(binding, "binding");
            return new HashTagClassifyViewHolder(binding);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HashTagClassifyViewHolder(@NotNull ItemClassifyHashtagBinding binding) {
        super(binding.getRoot());
        s.i(binding, "binding");
        this.f14712a = binding;
    }

    public final void i(@NotNull HashTagListViewModel viewModel, @NotNull HashTagClassifyModel item) {
        s.i(viewModel, "viewModel");
        s.i(item, "item");
        this.f14712a.c(viewModel);
        this.f14712a.b(item);
        this.f14712a.executePendingBindings();
    }
}
