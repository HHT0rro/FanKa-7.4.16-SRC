package com.cupidapp.live.feed.holder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.imageloader.RoundCornerModel;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: FeedDetailPraiseListViewHolder.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FeedDetailPraiseListViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f14380c = new a(null);

    /* compiled from: FeedDetailPraiseListViewHolder.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FeedDetailPraiseListViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new FeedDetailPraiseListViewHolder(z.b(parent, R$layout.view_holder_feed_detail_praise_list, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedDetailPraiseListViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof FeedDetailPraiseListViewModel) {
            FeedDetailPraiseListViewModel feedDetailPraiseListViewModel = (FeedDetailPraiseListViewModel) obj;
            int size = feedDetailPraiseListViewModel.getList().size();
            if (size > 0) {
                int i10 = 0;
                ((RelativeLayout) this.itemView.findViewById(R$id.detailPraiseListLayout)).setVisibility(0);
                ((RelativeLayout) this.itemView.findViewById(R$id.detailPraiseUserListLayout)).removeAllViews();
                View view = this.itemView;
                int i11 = R$id.arrowImageView;
                ((ImageView) view.findViewById(i11)).measure(View.MeasureSpec.makeMeasureSpec(z0.h.l(this), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(z0.h.k(this), 1073741824));
                int measuredWidth = ((ImageView) this.itemView.findViewById(i11)).getMeasuredWidth();
                int c4 = z0.h.c(this, 34.0f);
                int c10 = z0.h.c(this, 3.0f);
                int min = Math.min(((z0.h.l(this) - measuredWidth) - (z0.h.c(this, 9.0f) * 2)) / ((c10 * 2) + c4), size) - 1;
                if (min >= 0) {
                    while (i10 < size) {
                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(c4, c4);
                        layoutParams.setMargins(c10, c10, c10, c10);
                        layoutParams.addRule(15);
                        if (i10 != 0) {
                            layoutParams.addRule(1, i10);
                        } else {
                            layoutParams.addRule(9);
                        }
                        Context context = this.itemView.getContext();
                        s.h(context, "itemView.context");
                        ImageLoaderView imageLoaderView = new ImageLoaderView(context);
                        ImageLoaderView.g(imageLoaderView, feedDetailPraiseListViewModel.getList().get(i10).getAvatarImage(), new com.cupidapp.live.base.imageloader.b(false, null, null, null, null, null, null, 0, R$mipmap.icon_placeholder_circle_avatar, null, null, new RoundCornerModel(true, 0, 0, 0, false, false, false, false, 254, null), null, false, 0, 0, false, null, null, 521983, null), null, 4, null);
                        imageLoaderView.setLayoutParams(layoutParams);
                        int i12 = i10 + 1;
                        imageLoaderView.setId(i12);
                        ((RelativeLayout) this.itemView.findViewById(R$id.detailPraiseUserListLayout)).addView(imageLoaderView);
                        if (i10 == min) {
                            return;
                        } else {
                            i10 = i12;
                        }
                    }
                    return;
                }
                return;
            }
            ((RelativeLayout) this.itemView.findViewById(R$id.detailPraiseListLayout)).setVisibility(8);
        }
    }
}
