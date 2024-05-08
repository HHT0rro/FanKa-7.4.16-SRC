package com.cupidapp.live.vip.layout;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.base.imageloader.BlurModel;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.imageloader.RoundCornerModel;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.vip.model.VipPrivilegeType;
import com.cupidapp.live.vip.model.VipPurchaseGuideUiModel;
import com.cupidapp.live.vip.model.VipType;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p1.g;
import z0.h;
import z0.u;
import z0.y;
import z0.z;

/* compiled from: VipPurchaseGuideLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VipPurchaseGuideViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f18792c = new a(null);

    /* compiled from: VipPurchaseGuideLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final VipPurchaseGuideViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new VipPurchaseGuideViewHolder(z.b(parent, R$layout.view_holder_vip_purchase_guide, false, 2, null));
        }
    }

    /* compiled from: VipPurchaseGuideLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18793a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f18794b;

        static {
            int[] iArr = new int[VipType.values().length];
            try {
                iArr[VipType.SUPER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[VipType.NORMAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[VipType.RAINBOW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[VipType.VISITOR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f18793a = iArr;
            int[] iArr2 = new int[VipPrivilegeType.values().length];
            try {
                iArr2[VipPrivilegeType.CustomStealth.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[VipPrivilegeType.SuperLike.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[VipPrivilegeType.PeopleNearby.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[VipPrivilegeType.ExclusiveLogo.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[VipPrivilegeType.DynamicAvatar.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[VipPrivilegeType.WealthRank.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr2[VipPrivilegeType.SuperBoost.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr2[VipPrivilegeType.AlohaGet.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr2[VipPrivilegeType.RainbowRecommend.ordinal()] = 9;
            } catch (NoSuchFieldError unused13) {
            }
            f18794b = iArr2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VipPurchaseGuideViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof VipPurchaseGuideUiModel) {
            VipPurchaseGuideUiModel vipPurchaseGuideUiModel = (VipPurchaseGuideUiModel) obj;
            ((ImageView) this.itemView.findViewById(R$id.vipPurchaseGuideImageView)).setImageResource(vipPurchaseGuideUiModel.getImageId());
            int i10 = b.f18793a[vipPurchaseGuideUiModel.getVipType().ordinal()];
            int i11 = -15066598;
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 3) {
                        if (i10 != 4) {
                            throw new NoWhenBranchMatchedException();
                        }
                    }
                }
                TextView config$lambda$0 = (TextView) this.itemView.findViewById(R$id.vipPurchaseGuideTitle);
                config$lambda$0.getPaint().setFakeBoldText(true);
                config$lambda$0.setTextColor(i11);
                config$lambda$0.setText(vipPurchaseGuideUiModel.getName());
                s.h(config$lambda$0, "config$lambda$0");
                VipType belongToMinimumVipType = vipPurchaseGuideUiModel.getPrivilegeType().getBelongToMinimumVipType();
                VipType vipType = VipType.RAINBOW;
                u.e(config$lambda$0, 0, 0, (belongToMinimumVipType == vipType || vipPurchaseGuideUiModel.getVipType() != vipType) ? 0 : R$mipmap.ic_rainbow_function_tag, 0, 11, null);
                TextView textView = (TextView) this.itemView.findViewById(R$id.vipPurchaseGuideContent);
                textView.setTextColor(i11);
                textView.setText(vipPurchaseGuideUiModel.getContent());
                ((ImageView) this.itemView.findViewById(R$id.vip_purchase_help)).setVisibility(8);
                r(vipPurchaseGuideUiModel.getPrivilegeType(), vipPurchaseGuideUiModel.getMarkIcon());
            }
            i11 = -1;
            TextView config$lambda$02 = (TextView) this.itemView.findViewById(R$id.vipPurchaseGuideTitle);
            config$lambda$02.getPaint().setFakeBoldText(true);
            config$lambda$02.setTextColor(i11);
            config$lambda$02.setText(vipPurchaseGuideUiModel.getName());
            s.h(config$lambda$02, "config$lambda$0");
            VipType belongToMinimumVipType2 = vipPurchaseGuideUiModel.getPrivilegeType().getBelongToMinimumVipType();
            VipType vipType2 = VipType.RAINBOW;
            u.e(config$lambda$02, 0, 0, (belongToMinimumVipType2 == vipType2 || vipPurchaseGuideUiModel.getVipType() != vipType2) ? 0 : R$mipmap.ic_rainbow_function_tag, 0, 11, null);
            TextView textView2 = (TextView) this.itemView.findViewById(R$id.vipPurchaseGuideContent);
            textView2.setTextColor(i11);
            textView2.setText(vipPurchaseGuideUiModel.getContent());
            ((ImageView) this.itemView.findViewById(R$id.vip_purchase_help)).setVisibility(8);
            r(vipPurchaseGuideUiModel.getPrivilegeType(), vipPurchaseGuideUiModel.getMarkIcon());
        }
    }

    public final void r(VipPrivilegeType vipPrivilegeType, Integer num) {
        ImageModel avatarImage;
        if (vipPrivilegeType == VipPrivilegeType.SuperLike) {
            ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(R$id.user_avatar_image_view);
            s.h(imageLoaderView, "itemView.user_avatar_image_view");
            y.m(imageLoaderView, null, null, Integer.valueOf(h.c(this, 40.0f)), null, 11, null);
        } else {
            ImageLoaderView imageLoaderView2 = (ImageLoaderView) this.itemView.findViewById(R$id.user_avatar_image_view);
            s.h(imageLoaderView2, "itemView.user_avatar_image_view");
            y.l(imageLoaderView2, 0, 0, 0, 0);
        }
        switch (b.f18794b[vipPrivilegeType.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                User X = g.f52734a.X();
                if (X != null) {
                    avatarImage = X.getAvatarImage();
                    break;
                }
            default:
                avatarImage = null;
                break;
        }
        if (avatarImage == null) {
            ((ImageLoaderView) this.itemView.findViewById(R$id.user_avatar_image_view)).setVisibility(8);
        } else {
            VipPrivilegeType vipPrivilegeType2 = VipPrivilegeType.RainbowRecommend;
            com.cupidapp.live.base.imageloader.b bVar = new com.cupidapp.live.base.imageloader.b(false, null, null, null, null, null, null, 0, 0, null, null, new RoundCornerModel(vipPrivilegeType != vipPrivilegeType2, h.c(this, 8.0f), vipPrivilegeType == vipPrivilegeType2 ? 0 : h.c(this, 1.0f), -1, false, false, false, false, 240, null), vipPrivilegeType == VipPrivilegeType.CustomStealth ? new BlurModel(5.0f, 0, 2, null) : null, false, 0, 0, false, null, null, 518143, null);
            int c4 = vipPrivilegeType == vipPrivilegeType2 ? h.c(this, 60.0f) : h.c(this, 64.0f);
            int c10 = vipPrivilegeType == vipPrivilegeType2 ? h.c(this, 80.0f) : h.c(this, 64.0f);
            View view = this.itemView;
            int i10 = R$id.user_avatar_image_view;
            ImageLoaderView imageLoaderView3 = (ImageLoaderView) view.findViewById(i10);
            s.h(imageLoaderView3, "itemView.user_avatar_image_view");
            y.n(imageLoaderView3, Integer.valueOf(c4), Integer.valueOf(c10));
            ((ImageLoaderView) this.itemView.findViewById(i10)).setVisibility(0);
            ImageLoaderView imageLoaderView4 = (ImageLoaderView) this.itemView.findViewById(i10);
            s.h(imageLoaderView4, "itemView.user_avatar_image_view");
            ImageLoaderView.g(imageLoaderView4, avatarImage, bVar, null, 4, null);
        }
        if (num == null) {
            ((ImageView) this.itemView.findViewById(R$id.mark_image_view)).setVisibility(8);
        } else {
            View view2 = this.itemView;
            int i11 = R$id.mark_image_view;
            ((ImageView) view2.findViewById(i11)).setVisibility(0);
            ((ImageView) this.itemView.findViewById(i11)).setImageResource(num.intValue());
        }
        if (vipPrivilegeType == VipPrivilegeType.CardBorder) {
            FrameLayout frameLayout = (FrameLayout) this.itemView.findViewById(R$id.avatar_bg_layout);
            s.h(frameLayout, "itemView.avatar_bg_layout");
            frameLayout.setVisibility(0);
            ImageLoaderView imageLoaderView5 = (ImageLoaderView) this.itemView.findViewById(R$id.avatar_imageview);
            s.h(imageLoaderView5, "itemView.avatar_imageview");
            User X2 = g.f52734a.X();
            ImageLoaderView.g(imageLoaderView5, X2 != null ? X2.getAvatarImage() : null, null, null, 6, null);
            return;
        }
        FrameLayout frameLayout2 = (FrameLayout) this.itemView.findViewById(R$id.avatar_bg_layout);
        s.h(frameLayout2, "itemView.avatar_bg_layout");
        frameLayout2.setVisibility(8);
    }
}
