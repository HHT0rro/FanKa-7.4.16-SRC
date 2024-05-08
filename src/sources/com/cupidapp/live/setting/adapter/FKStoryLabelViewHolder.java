package com.cupidapp.live.setting.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.databinding.ViewHolderStoryLabelBinding;
import com.cupidapp.live.profile.model.FKStoryLabelItemModel;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.y;

/* compiled from: FKStoryLabelAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKStoryLabelViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final a f18093e = new a(null);

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final ViewHolderStoryLabelBinding f18094c;

    /* renamed from: d, reason: collision with root package name */
    public final int f18095d;

    /* compiled from: FKStoryLabelAdapter.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FKStoryLabelViewHolder a(@NotNull ViewGroup parent, int i10) {
            s.i(parent, "parent");
            ViewHolderStoryLabelBinding b4 = ViewHolderStoryLabelBinding.b(LayoutInflater.from(parent.getContext()), parent, false);
            s.h(b4, "inflate(\n               …rent, false\n            )");
            return new FKStoryLabelViewHolder(b4, i10);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public FKStoryLabelViewHolder(@org.jetbrains.annotations.NotNull com.cupidapp.live.databinding.ViewHolderStoryLabelBinding r3, int r4) {
        /*
            r2 = this;
            java.lang.String r0 = "binding"
            kotlin.jvm.internal.s.i(r3, r0)
            android.view.View r0 = r3.getRoot()
            java.lang.String r1 = "binding.root"
            kotlin.jvm.internal.s.h(r0, r1)
            r2.<init>(r0)
            r2.f18094c = r3
            r2.f18095d = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.setting.adapter.FKStoryLabelViewHolder.<init>(com.cupidapp.live.databinding.ViewHolderStoryLabelBinding, int):void");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof FKStoryLabelItemModel) {
            this.f18094c.d((FKStoryLabelItemModel) obj);
            this.f18094c.executePendingBindings();
            View itemView = this.itemView;
            s.h(itemView, "itemView");
            y.m(itemView, null, null, null, Integer.valueOf(getAbsoluteAdapterPosition() == this.f18095d + (-1) ? h.c(this, 55.0f) : 0), 7, null);
        }
    }
}
