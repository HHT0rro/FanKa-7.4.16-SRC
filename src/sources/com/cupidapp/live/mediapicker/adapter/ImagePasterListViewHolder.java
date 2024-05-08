package com.cupidapp.live.mediapicker.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.databinding.ItemPasterBinding;
import com.cupidapp.live.mediapicker.activity.ImagePasterViewModel;
import com.cupidapp.live.mediapicker.model.PasterModel;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ImagePasterListAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ImagePasterListViewHolder extends RecyclerView.ViewHolder {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final a f17158b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public final ItemPasterBinding f17159a;

    /* compiled from: ImagePasterListAdapter.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ImagePasterListViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            ItemPasterBinding binding = (ItemPasterBinding) DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R$layout.item_paster, parent, false);
            s.h(binding, "binding");
            return new ImagePasterListViewHolder(binding);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImagePasterListViewHolder(@NotNull ItemPasterBinding binding) {
        super(binding.getRoot());
        s.i(binding, "binding");
        this.f17159a = binding;
    }

    public final void i(@NotNull ImagePasterViewModel viewModel, @Nullable PasterModel pasterModel) {
        s.i(viewModel, "viewModel");
        this.f17159a.c(viewModel);
        this.f17159a.b(pasterModel);
        this.f17159a.executePendingBindings();
    }
}
