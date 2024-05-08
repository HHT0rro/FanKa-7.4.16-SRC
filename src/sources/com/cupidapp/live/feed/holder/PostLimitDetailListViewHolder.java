package com.cupidapp.live.feed.holder;

import android.view.View;
import android.view.ViewGroup;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.sensorslog.FKSensorContext;
import com.cupidapp.live.feed.layout.PostLimitPagerLayout;
import com.cupidapp.live.feed.layout.j;
import com.cupidapp.live.feed.layout.p;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: PostLimitDetailListViewHolder.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class PostLimitDetailListViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public static final a f14401f = new a(null);

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public final FKSensorContext f14402c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public final p f14403d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public final j f14404e;

    /* compiled from: PostLimitDetailListViewHolder.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final PostLimitDetailListViewHolder a(@NotNull ViewGroup parent, @Nullable FKSensorContext fKSensorContext, @Nullable p pVar, @NotNull j listener) {
            s.i(parent, "parent");
            s.i(listener, "listener");
            return new PostLimitDetailListViewHolder(z.b(parent, R$layout.item_post_limit_detail_pager, false, 2, null), fKSensorContext, pVar, listener);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostLimitDetailListViewHolder(@NotNull View itemView, @Nullable FKSensorContext fKSensorContext, @Nullable p pVar, @NotNull j listener) {
        super(itemView);
        s.i(itemView, "itemView");
        s.i(listener, "listener");
        this.f14402c = fKSensorContext;
        this.f14403d = pVar;
        this.f14404e = listener;
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof List) {
            ((PostLimitPagerLayout) this.itemView.findViewById(R$id.post_detail)).s((List) obj, this.f14402c, this.f14403d, this.f14404e);
        }
    }
}
