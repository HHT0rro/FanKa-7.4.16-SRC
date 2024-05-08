package com.cupidapp.live.setting.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.databinding.ViewHolderStoryLabelTitleBinding;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKStoryLabelAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKStoryLabelTitleViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f18091d = new a(null);

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final ViewHolderStoryLabelTitleBinding f18092c;

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
        public final FKStoryLabelTitleViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            ViewHolderStoryLabelTitleBinding b4 = ViewHolderStoryLabelTitleBinding.b(LayoutInflater.from(parent.getContext()), parent, false);
            s.h(b4, "inflate(\n               …rent, false\n            )");
            return new FKStoryLabelTitleViewHolder(b4);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public FKStoryLabelTitleViewHolder(@org.jetbrains.annotations.NotNull com.cupidapp.live.databinding.ViewHolderStoryLabelTitleBinding r3) {
        /*
            r2 = this;
            java.lang.String r0 = "binding"
            kotlin.jvm.internal.s.i(r3, r0)
            android.view.View r0 = r3.getRoot()
            java.lang.String r1 = "binding.root"
            kotlin.jvm.internal.s.h(r0, r1)
            r2.<init>(r0)
            r2.f18092c = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.setting.adapter.FKStoryLabelTitleViewHolder.<init>(com.cupidapp.live.databinding.ViewHolderStoryLabelTitleBinding):void");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof FKStoryLabelTitleModel) {
            this.f18092c.d((FKStoryLabelTitleModel) obj);
            this.f18092c.executePendingBindings();
        }
    }
}
