package com.cupidapp.live.liveshow.view.giftpicker.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.cupidapp.live.R$drawable;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.utils.h;
import com.cupidapp.live.liveshow.model.GiftExpireModel;
import com.cupidapp.live.liveshow.model.GiftItemModel;
import com.cupidapp.live.liveshow.model.GiftModel;
import com.cupidapp.live.liveshow.model.ParcelItemModel;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.u;
import z0.y;
import z0.z;

/* compiled from: FKLiveGiftPickerItemAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveGiftPickerItemViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f15426c = new a(null);

    /* compiled from: FKLiveGiftPickerItemAdapter.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FKLiveGiftPickerItemViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new FKLiveGiftPickerItemViewHolder(z.b(parent, R$layout.view_holder_live_gift_picker_item, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveGiftPickerItemViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
        TextView textView = (TextView) itemView.findViewById(R$id.giftNameTextView);
        s.h(textView, "itemView.giftNameTextView");
        u.f(textView, 12);
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof FKLiveGiftPickerItemViewModel) {
            FKLiveGiftPickerItemViewModel fKLiveGiftPickerItemViewModel = (FKLiveGiftPickerItemViewModel) obj;
            GiftItemModel giftItemModel = fKLiveGiftPickerItemViewModel.getGiftItemModel();
            if (giftItemModel instanceof GiftModel) {
                GiftModel giftModel = (GiftModel) giftItemModel;
                r(giftModel, fKLiveGiftPickerItemViewModel.isSelected());
                s(giftModel, fKLiveGiftPickerItemViewModel.isSelected());
                TextView textView = (TextView) this.itemView.findViewById(R$id.giftNameTextView);
                Boolean canUseGiftDiscount = giftModel.getCanUseGiftDiscount();
                Boolean bool = Boolean.FALSE;
                textView.setTextColor(s.d(canUseGiftDiscount, bool) ? h.a(-1, 0.3f) : -1);
                ((ImageView) this.itemView.findViewById(R$id.discountAngleIcon)).setVisibility(giftModel.getShowDiscountTag() ? 0 : 8);
                ((TextView) this.itemView.findViewById(R$id.giftCountTextView)).setVisibility(8);
                if (giftModel.getNamingAvatar() == null) {
                    ((ImageLoaderView) this.itemView.findViewById(R$id.naming_avatar_img)).setVisibility(8);
                } else {
                    View view = this.itemView;
                    int i10 = R$id.naming_avatar_img;
                    ImageLoaderView imageLoaderView = (ImageLoaderView) view.findViewById(i10);
                    s.h(imageLoaderView, "itemView.naming_avatar_img");
                    ImageLoaderView.g(imageLoaderView, giftModel.getNamingAvatar(), null, null, 6, null);
                    ((ImageLoaderView) this.itemView.findViewById(i10)).setVisibility(0);
                }
                if (giftModel.getSpokesmanUserIcon() == null) {
                    ((ImageLoaderView) this.itemView.findViewById(R$id.spokes_naming_avatar_img)).setVisibility(8);
                    ((ImageView) this.itemView.findViewById(R$id.spokes_naming_icon)).setVisibility(8);
                } else {
                    View view2 = this.itemView;
                    int i11 = R$id.spokes_naming_avatar_img;
                    ImageLoaderView imageLoaderView2 = (ImageLoaderView) view2.findViewById(i11);
                    s.h(imageLoaderView2, "itemView.spokes_naming_avatar_img");
                    ImageLoaderView.g(imageLoaderView2, giftModel.getSpokesmanUserIcon(), null, null, 6, null);
                    ((ImageLoaderView) this.itemView.findViewById(i11)).setVisibility(0);
                    ((ImageView) this.itemView.findViewById(R$id.spokes_naming_icon)).setVisibility(0);
                }
                if (giftModel.getLevelIcon() == null) {
                    ((ImageLoaderView) this.itemView.findViewById(R$id.level_icon_img)).setVisibility(8);
                } else {
                    View view3 = this.itemView;
                    int i12 = R$id.level_icon_img;
                    ((ImageLoaderView) view3.findViewById(i12)).setVisibility(0);
                    ImageModel levelIcon = giftModel.getLevelIcon();
                    Integer valueOf = levelIcon != null ? Integer.valueOf(levelIcon.getScaleWidthByHeight(z0.h.c(this, 14.0f))) : null;
                    ImageLoaderView imageLoaderView3 = (ImageLoaderView) this.itemView.findViewById(i12);
                    s.h(imageLoaderView3, "itemView.level_icon_img");
                    y.o(imageLoaderView3, valueOf, null, 2, null);
                    ImageLoaderView imageLoaderView4 = (ImageLoaderView) this.itemView.findViewById(i12);
                    s.h(imageLoaderView4, "itemView.level_icon_img");
                    ImageLoaderView.g(imageLoaderView4, giftModel.getLevelIcon(), null, null, 6, null);
                }
                this.itemView.setAlpha(s.d(giftModel.getUnlocked(), bool) ? 0.6f : 1.0f);
            } else if (giftItemModel instanceof ParcelItemModel) {
                ParcelItemModel parcelItemModel = (ParcelItemModel) giftItemModel;
                List<GiftExpireModel> expirationDetails = parcelItemModel.getExpirationDetails();
                if (expirationDetails == null || expirationDetails.isEmpty()) {
                    ((TextView) this.itemView.findViewById(R$id.giftPriceTextView)).setText(parcelItemModel.getExpireTime());
                } else {
                    ((TextView) this.itemView.findViewById(R$id.giftPriceTextView)).setText(this.itemView.getContext().getString(R$string.long_press_to_see_expired_time));
                }
                ((TextView) this.itemView.findViewById(R$id.giftPriceTextView)).setTextColor(-7829368);
                ((TextView) this.itemView.findViewById(R$id.giftNameTextView)).setTextColor(-1);
                ((ImageView) this.itemView.findViewById(R$id.discountAngleIcon)).setVisibility(8);
                if (parcelItemModel.getCount() > 1) {
                    View view4 = this.itemView;
                    int i13 = R$id.giftCountTextView;
                    ((TextView) view4.findViewById(i13)).setVisibility(0);
                    ((TextView) this.itemView.findViewById(i13)).setText(this.itemView.getContext().getString(R$string.gift_count, Integer.valueOf(parcelItemModel.getCount())));
                } else {
                    ((TextView) this.itemView.findViewById(R$id.giftCountTextView)).setVisibility(8);
                }
            }
            if (giftItemModel.getShowGiftTag()) {
                View view5 = this.itemView;
                int i14 = R$id.tag_imageview;
                ((ImageLoaderView) view5.findViewById(i14)).setVisibility(0);
                ImageModel giftTag = giftItemModel.getGiftTag();
                Integer valueOf2 = giftTag != null ? Integer.valueOf(giftTag.getScaleWidthByHeight(z0.h.c(this, 14.0f))) : null;
                ImageLoaderView imageLoaderView5 = (ImageLoaderView) this.itemView.findViewById(i14);
                s.h(imageLoaderView5, "itemView.tag_imageview");
                y.o(imageLoaderView5, valueOf2, null, 2, null);
                ImageLoaderView imageLoaderView6 = (ImageLoaderView) this.itemView.findViewById(i14);
                s.h(imageLoaderView6, "itemView.tag_imageview");
                ImageLoaderView.g(imageLoaderView6, giftItemModel.getGiftTag(), null, null, 6, null);
            } else {
                ((ImageLoaderView) this.itemView.findViewById(R$id.tag_imageview)).setVisibility(8);
            }
            ((TextView) this.itemView.findViewById(R$id.giftNameTextView)).setText(giftItemModel.getName());
            View view6 = this.itemView;
            int i15 = R$id.giftImageView;
            ImageLoaderView imageLoaderView7 = (ImageLoaderView) view6.findViewById(i15);
            s.h(imageLoaderView7, "itemView.giftImageView");
            ImageLoaderView.g(imageLoaderView7, giftItemModel.getImage(), null, null, 6, null);
            this.itemView.setBackgroundResource(fKLiveGiftPickerItemViewModel.isSelected() ? R$drawable.shape_gift_picker_item_checked : 0);
            if (giftItemModel.getNewArrivalTag() != null) {
                View view7 = this.itemView;
                int i16 = R$id.new_gift_tag_img;
                ((ImageLoaderView) view7.findViewById(i16)).setVisibility(0);
                ImageModel newArrivalTag = giftItemModel.getNewArrivalTag();
                Integer valueOf3 = newArrivalTag != null ? Integer.valueOf(newArrivalTag.getScaleWidthByHeight(z0.h.c(this, 14.0f))) : null;
                ImageLoaderView imageLoaderView8 = (ImageLoaderView) this.itemView.findViewById(i16);
                s.h(imageLoaderView8, "itemView.new_gift_tag_img");
                y.o(imageLoaderView8, valueOf3, null, 2, null);
                ImageLoaderView imageLoaderView9 = (ImageLoaderView) this.itemView.findViewById(i16);
                s.h(imageLoaderView9, "itemView.new_gift_tag_img");
                ImageLoaderView.g(imageLoaderView9, giftItemModel.getNewArrivalTag(), null, null, 6, null);
            } else {
                ((ImageLoaderView) this.itemView.findViewById(R$id.new_gift_tag_img)).setVisibility(8);
            }
            if (fKLiveGiftPickerItemViewModel.isSelected()) {
                ImageLoaderView imageLoaderView10 = (ImageLoaderView) this.itemView.findViewById(i15);
                s.h(imageLoaderView10, "itemView.giftImageView");
                fKLiveGiftPickerItemViewModel.showItemAnimator(imageLoaderView10);
                return;
            }
            fKLiveGiftPickerItemViewModel.stopItemAnimator();
        }
    }

    public final void r(GiftModel giftModel, boolean z10) {
        String string;
        if (giftModel.getFreeChance() > 0) {
            string = this.itemView.getContext().getString(R$string.gift_freeChance, Integer.valueOf(giftModel.getFreeChance()));
        } else if (giftModel.getDiscountPrice() != null && z10) {
            string = this.itemView.getContext().getString(R$string.gift_price, giftModel.getDiscountPrice());
        } else {
            string = this.itemView.getContext().getString(R$string.gift_price, Integer.valueOf(giftModel.getPrice()));
        }
        s.h(string, "if (model.freeChance > 0…)\n            }\n        }");
        ((TextView) this.itemView.findViewById(R$id.giftPriceTextView)).setText(string);
    }

    public final void s(GiftModel giftModel, boolean z10) {
        Boolean canUseGiftDiscount = giftModel.getCanUseGiftDiscount();
        int i10 = -1;
        if (s.d(canUseGiftDiscount, Boolean.FALSE)) {
            i10 = h.a(-1, 0.3f);
        } else if (s.d(canUseGiftDiscount, Boolean.TRUE)) {
            if (giftModel.getDiscountPrice() != null && z10) {
                i10 = -49088;
            }
        } else {
            i10 = giftModel.getFreeChance() > 0 ? -14522 : -7829368;
        }
        ((TextView) this.itemView.findViewById(R$id.giftPriceTextView)).setTextColor(i10);
    }
}
