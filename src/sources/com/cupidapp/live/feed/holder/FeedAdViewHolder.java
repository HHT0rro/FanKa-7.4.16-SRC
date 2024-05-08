package com.cupidapp.live.feed.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.view.ViewGroupKt;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.feed.model.FKExpressAdModel;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: FeedAdViewHolder.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FeedAdViewHolder extends FKBaseRecyclerViewHolder implements d {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f14374c = new a(null);

    /* compiled from: FeedAdViewHolder.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FeedAdViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new FeedAdViewHolder(z.b(parent, R$layout.view_holder_feed_ad, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedAdViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.feed.holder.d
    public void a() {
    }

    @Override // com.cupidapp.live.feed.holder.d
    public void b() {
    }

    @Override // com.cupidapp.live.feed.holder.d
    public void c() {
    }

    @Override // com.cupidapp.live.feed.holder.d
    public void f() {
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof FKExpressAdModel) {
            View view = this.itemView;
            int i10 = R$id.feedAdView;
            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(i10);
            s.h(relativeLayout, "itemView.feedAdView");
            View view2 = (View) SequencesKt___SequencesKt.m(ViewGroupKt.getChildren(relativeLayout));
            FKExpressAdModel fKExpressAdModel = (FKExpressAdModel) obj;
            if (fKExpressAdModel.getView() == null) {
                ((RelativeLayout) this.itemView.findViewById(i10)).removeAllViews();
                View itemView = this.itemView;
                s.h(itemView, "itemView");
                y.m(itemView, null, 0, null, 0, 5, null);
                this.itemView.setVisibility(8);
                return;
            }
            View view3 = fKExpressAdModel.getView();
            if ((view3 != null ? view3.getParent() : null) != null || s.d(fKExpressAdModel.getView(), view2)) {
                return;
            }
            this.itemView.setVisibility(0);
            ((RelativeLayout) this.itemView.findViewById(i10)).removeAllViews();
            ((RelativeLayout) this.itemView.findViewById(i10)).addView(fKExpressAdModel.getView());
            View itemView2 = this.itemView;
            s.h(itemView2, "itemView");
            y.m(itemView2, null, Integer.valueOf(z0.h.c(this, 8.0f)), null, Integer.valueOf(z0.h.c(this, 30.0f)), 5, null);
        }
    }
}
