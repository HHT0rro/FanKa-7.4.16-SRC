package com.cupidapp.live.feed.holder;

import android.view.View;
import android.view.ViewGroup;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.view.PromotionNearGuideLayout;
import com.cupidapp.live.feed.model.PromotionNearByGuideModel;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: PromotionNearByGuideViewHolder.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class PromotionNearByGuideViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f14408c = new a(null);

    /* compiled from: PromotionNearByGuideViewHolder.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final PromotionNearByGuideViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new PromotionNearByGuideViewHolder(z.b(parent, R$layout.item_promotion_near_by_guide, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PromotionNearByGuideViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof PromotionNearByGuideModel) {
            ((PromotionNearGuideLayout) this.itemView.findViewById(R$id.promotion_guide_root)).b((PromotionNearByGuideModel) obj, SensorPosition.Feed);
        }
    }
}
