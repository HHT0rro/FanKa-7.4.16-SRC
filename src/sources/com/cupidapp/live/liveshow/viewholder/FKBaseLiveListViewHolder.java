package com.cupidapp.live.liveshow.viewholder;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.z;

/* compiled from: FKBaseLiveListViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKBaseLiveListViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f16030c = new a(null);

    /* compiled from: FKBaseLiveListViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FKBaseLiveListViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new FKBaseLiveListViewHolder(z.b(parent, R$layout.view_holder_base_live_list, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKBaseLiveListViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof LiveShowModel) {
            Drawable background = this.itemView.findViewById(R$id.baseLiveListShadowView).getBackground();
            GradientDrawable gradientDrawable = background instanceof GradientDrawable ? (GradientDrawable) background : null;
            float c4 = h.c(this, 5.0f);
            boolean z10 = true;
            if (gradientDrawable != null) {
                gradientDrawable.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, c4, c4, c4, c4});
            }
            int l10 = (h.l(this) - (h.c(this, 10.0f) * 4)) / 3;
            this.itemView.setLayoutParams(new RelativeLayout.LayoutParams(l10, l10));
            ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(R$id.liveListCoverImageView);
            s.h(imageLoaderView, "itemView.liveListCoverImageView");
            LiveShowModel liveShowModel = (LiveShowModel) obj;
            ImageLoaderView.g(imageLoaderView, liveShowModel.getCoverImage(), null, null, 6, null);
            ((TextView) this.itemView.findViewById(R$id.liveListUserNameTextView)).setText(liveShowModel.getUser().getName());
            ((TextView) this.itemView.findViewById(R$id.liveListViewCountTextView)).setText(liveShowModel.getFormatHeatValue());
            View view = this.itemView;
            int i10 = R$id.liveListLocalInfoTextView;
            ((TextView) view.findViewById(i10)).getPaint().setFakeBoldText(true);
            String locationInfo = liveShowModel.getLocationInfo();
            if (locationInfo != null && locationInfo.length() != 0) {
                z10 = false;
            }
            if (z10) {
                ((TextView) this.itemView.findViewById(i10)).setVisibility(8);
            } else {
                ((TextView) this.itemView.findViewById(i10)).setVisibility(0);
                ((TextView) this.itemView.findViewById(i10)).setText(liveShowModel.getLocationInfo());
            }
        }
    }
}
