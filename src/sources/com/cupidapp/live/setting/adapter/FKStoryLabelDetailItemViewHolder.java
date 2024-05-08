package com.cupidapp.live.setting.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.databinding.ViewHolderStoryLabelDetailItemBinding;
import com.cupidapp.live.profile.model.FKStoryLabelItemModel;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;

/* compiled from: FKStoryLabelDetailAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKStoryLabelDetailItemViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final a f18086e = new a(null);

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final ViewHolderStoryLabelDetailItemBinding f18087c;

    /* renamed from: d, reason: collision with root package name */
    public int f18088d;

    /* compiled from: FKStoryLabelDetailAdapter.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FKStoryLabelDetailItemViewHolder a(@NotNull ViewGroup parent, int i10) {
            s.i(parent, "parent");
            ViewHolderStoryLabelDetailItemBinding b4 = ViewHolderStoryLabelDetailItemBinding.b(LayoutInflater.from(parent.getContext()), parent, false);
            s.h(b4, "inflate(\n               …rent, false\n            )");
            FKStoryLabelDetailItemViewHolder fKStoryLabelDetailItemViewHolder = new FKStoryLabelDetailItemViewHolder(b4);
            fKStoryLabelDetailItemViewHolder.f18088d = i10;
            return fKStoryLabelDetailItemViewHolder;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public FKStoryLabelDetailItemViewHolder(@org.jetbrains.annotations.NotNull com.cupidapp.live.databinding.ViewHolderStoryLabelDetailItemBinding r3) {
        /*
            r2 = this;
            java.lang.String r0 = "binding"
            kotlin.jvm.internal.s.i(r3, r0)
            android.view.View r0 = r3.getRoot()
            java.lang.String r1 = "binding.root"
            kotlin.jvm.internal.s.h(r0, r1)
            r2.<init>(r0)
            r2.f18087c = r3
            r3 = 1
            r2.f18088d = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.setting.adapter.FKStoryLabelDetailItemViewHolder.<init>(com.cupidapp.live.databinding.ViewHolderStoryLabelDetailItemBinding):void");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof FKStoryLabelItemModel) {
            this.f18087c.d((FKStoryLabelItemModel) obj);
            this.f18087c.executePendingBindings();
            int absoluteAdapterPosition = getAbsoluteAdapterPosition();
            if (absoluteAdapterPosition == 0) {
                this.itemView.setPadding(0, 0, 0, h.c(this, 5.0f));
            } else if (absoluteAdapterPosition == this.f18088d - 1) {
                this.itemView.setPadding(0, h.c(this, 5.0f), 0, 0);
            } else {
                this.itemView.setPadding(0, 0, 0, 0);
            }
        }
    }
}
