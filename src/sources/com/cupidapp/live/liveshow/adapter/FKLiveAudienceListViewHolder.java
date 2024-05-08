package com.cupidapp.live.liveshow.adapter;

import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.cupidapp.live.R$drawable;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.utils.h;
import kotlin.collections.r;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: FKLiveAudienceListAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveAudienceListViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f14801c = new a(null);

    /* compiled from: FKLiveAudienceListAdapter.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FKLiveAudienceListViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new FKLiveAudienceListViewHolder(z.b(parent, R$layout.view_holder_live_audience_list, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveAudienceListViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof LiveSeatItemModel) {
            ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(R$id.audienceAvatarImageView);
            s.h(imageLoaderView, "itemView.audienceAvatarImageView");
            LiveSeatItemModel liveSeatItemModel = (LiveSeatItemModel) obj;
            ImageLoaderView.g(imageLoaderView, liveSeatItemModel.getUserAvatar(), null, null, 6, null);
            String consumption = liveSeatItemModel.getConsumption();
            if (consumption == null) {
                consumption = "0";
            }
            if (s.d(consumption, "0")) {
                r(null, -1, h.a(-16777216, 0.7f), liveSeatItemModel.getBorderImage());
            } else {
                int absoluteAdapterPosition = getAbsoluteAdapterPosition();
                if (absoluteAdapterPosition == 0) {
                    r(Integer.valueOf(R$mipmap.icon_consume_first), -15066598, -10882, liveSeatItemModel.getBorderImage());
                } else if (absoluteAdapterPosition == 1) {
                    r(Integer.valueOf(R$mipmap.icon_consume_second), -15066598, -855310, liveSeatItemModel.getBorderImage());
                } else if (absoluteAdapterPosition != 2) {
                    r(null, -1, h.a(-16777216, 0.7f), liveSeatItemModel.getBorderImage());
                } else {
                    r(Integer.valueOf(R$mipmap.icon_consume_third), -15066598, -12114, liveSeatItemModel.getBorderImage());
                }
            }
            ((TextView) this.itemView.findViewById(R$id.consumeTextView)).setText(consumption);
        }
    }

    public final void r(Integer num, int i10, int i11, ImageModel imageModel) {
        if (imageModel != null) {
            View view = this.itemView;
            int i12 = R$id.avatar_border_imageview;
            ImageLoaderView imageLoaderView = (ImageLoaderView) view.findViewById(i12);
            s.h(imageLoaderView, "itemView.avatar_border_imageview");
            imageLoaderView.setVisibility(0);
            ImageLoaderView imageLoaderView2 = (ImageLoaderView) this.itemView.findViewById(i12);
            s.h(imageLoaderView2, "itemView.avatar_border_imageview");
            ImageLoaderView.g(imageLoaderView2, imageModel, null, null, 6, null);
            ((FrameLayout) this.itemView.findViewById(R$id.audienceAvatarContainerLayout)).setBackground(null);
            ImageView imageView = (ImageView) this.itemView.findViewById(R$id.consumeImageView);
            s.h(imageView, "itemView.consumeImageView");
            imageView.setVisibility(8);
        } else if (num != null) {
            View view2 = this.itemView;
            int i13 = R$id.consumeImageView;
            ImageView imageView2 = (ImageView) view2.findViewById(i13);
            s.h(imageView2, "itemView.consumeImageView");
            imageView2.setVisibility(0);
            ((ImageView) this.itemView.findViewById(i13)).setImageResource(num.intValue());
            ((FrameLayout) this.itemView.findViewById(R$id.audienceAvatarContainerLayout)).setBackgroundResource(R$drawable.shape_d8_circle_bg);
            ImageLoaderView imageLoaderView3 = (ImageLoaderView) this.itemView.findViewById(R$id.avatar_border_imageview);
            s.h(imageLoaderView3, "itemView.avatar_border_imageview");
            imageLoaderView3.setVisibility(8);
        } else {
            ((FrameLayout) this.itemView.findViewById(R$id.audienceAvatarContainerLayout)).setBackground(null);
            ImageLoaderView imageLoaderView4 = (ImageLoaderView) this.itemView.findViewById(R$id.avatar_border_imageview);
            s.h(imageLoaderView4, "itemView.avatar_border_imageview");
            imageLoaderView4.setVisibility(8);
            ImageView imageView3 = (ImageView) this.itemView.findViewById(R$id.consumeImageView);
            s.h(imageView3, "itemView.consumeImageView");
            imageView3.setVisibility(8);
        }
        View view3 = this.itemView;
        int i14 = R$id.consumeTextView;
        ((TextView) view3.findViewById(i14)).setTextColor(i10);
        TextView textView = (TextView) this.itemView.findViewById(i14);
        s.h(textView, "itemView.consumeTextView");
        y.i(textView, (r18 & 1) != 0 ? 0.0f : z0.h.c(this, 6.0f), r.e(Integer.valueOf(i11)), (r18 & 4) != 0 ? GradientDrawable.Orientation.LEFT_RIGHT : null, (r18 & 8) != 0 ? null : null, (r18 & 16) != 0 ? null : null, (r18 & 32) != 0 ? 0.0f : 0.0f, (r18 & 64) != 0 ? 0.0f : 0.0f);
    }
}
