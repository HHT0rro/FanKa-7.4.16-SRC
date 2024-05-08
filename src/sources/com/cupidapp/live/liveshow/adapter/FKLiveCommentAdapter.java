package com.cupidapp.live.liveshow.adapter;

import android.view.ViewGroup;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveCommentAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveCommentAdapter extends FKBaseRecyclerViewAdapter {

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public static final a f14806h = new a(null);

    /* renamed from: f, reason: collision with root package name */
    public boolean f14807f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public String f14808g;

    /* compiled from: FKLiveCommentAdapter.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public FKLiveCommentAdapter() {
        List<Class<? extends Object>> k10 = k();
        k10.add(FKLiveCommentMessageViewModel.class);
        k10.add(FKLiveSystemMessageViewModel.class);
        k10.add(FKLiveGiftMessageViewModel.class);
        k10.add(LiveCommentMessageGuideModel.class);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public FKBaseRecyclerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i10) {
        FKBaseRecyclerViewHolder a10;
        s.i(parent, "parent");
        if (i10 == 0) {
            a10 = FKLiveCommentMessageViewHolder.f14809c.a(parent, this.f14807f);
        } else if (i10 == 1) {
            a10 = FKLiveSystemMessageViewHolder.f14826c.a(parent, this.f14807f);
        } else if (i10 != 2) {
            a10 = LiveCommentGuideMessageViewHolder.f14829c.a(parent);
        } else {
            a10 = FKLiveGiftMessageViewHolder.f14825c.a(parent, this.f14807f, this.f14808g);
        }
        a10.k(l());
        return a10;
    }

    public final void v(@Nullable String str) {
        this.f14808g = str;
    }

    public final void w(boolean z10) {
        this.f14807f = z10;
    }
}
