package com.cupidapp.live.hashtag.list;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.databinding.ItemHashtagContentBinding;
import com.cupidapp.live.hashtag.model.HashTag;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: HashTagContentViewHolder.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class HashTagContentViewHolder extends RecyclerView.ViewHolder {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final a f14716b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public final ItemHashtagContentBinding f14717a;

    /* compiled from: HashTagContentViewHolder.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final HashTagContentViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            ItemHashtagContentBinding binding = (ItemHashtagContentBinding) DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R$layout.item_hashtag_content, parent, false);
            s.h(binding, "binding");
            return new HashTagContentViewHolder(binding);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HashTagContentViewHolder(@NotNull ItemHashtagContentBinding binding) {
        super(binding.getRoot());
        s.i(binding, "binding");
        this.f14717a = binding;
    }

    public final void i(@NotNull HashTagListViewModel viewModel, @Nullable HashTag hashTag) {
        s.i(viewModel, "viewModel");
        this.f14717a.c(viewModel);
        this.f14717a.b(hashTag);
        this.f14717a.f13975e.getPaint().setFakeBoldText(true);
        this.f14717a.executePendingBindings();
    }
}
