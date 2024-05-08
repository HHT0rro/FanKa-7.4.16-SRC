package com.cupidapp.live.setting.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.databinding.ViewHolderStoryLabelTipsBinding;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKStoryLabelAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKStoryLabelTipsViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f18089d = new a(null);

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final ViewHolderStoryLabelTipsBinding f18090c;

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
        public final FKStoryLabelTipsViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            ViewHolderStoryLabelTipsBinding b4 = ViewHolderStoryLabelTipsBinding.b(LayoutInflater.from(parent.getContext()), parent, false);
            s.h(b4, "inflate(\n               …rent, false\n            )");
            return new FKStoryLabelTipsViewHolder(b4);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public FKStoryLabelTipsViewHolder(@org.jetbrains.annotations.NotNull com.cupidapp.live.databinding.ViewHolderStoryLabelTipsBinding r3) {
        /*
            r2 = this;
            java.lang.String r0 = "binding"
            kotlin.jvm.internal.s.i(r3, r0)
            android.view.View r0 = r3.getRoot()
            java.lang.String r1 = "binding.root"
            kotlin.jvm.internal.s.h(r0, r1)
            r2.<init>(r0)
            r2.f18090c = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.setting.adapter.FKStoryLabelTipsViewHolder.<init>(com.cupidapp.live.databinding.ViewHolderStoryLabelTipsBinding):void");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof FKStoryLabelTipsModel) {
            this.f18090c.d((FKStoryLabelTipsModel) obj);
            this.f18090c.executePendingBindings();
        }
    }
}
