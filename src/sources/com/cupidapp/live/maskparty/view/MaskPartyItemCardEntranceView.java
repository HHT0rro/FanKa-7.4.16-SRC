package com.cupidapp.live.maskparty.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.view.animation.FKSVGAImageView;
import com.cupidapp.live.maskparty.model.ItemCardFeaturesItemModel;
import com.cupidapp.live.maskparty.model.ItemCardType;
import com.cupidapp.live.track.group.GroupOthersLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.r;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: MaskPartyItemCardEntranceView.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MaskPartyItemCardEntranceView extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public Function0<p> f16404b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16405c;

    /* compiled from: MaskPartyItemCardEntranceView.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f16406a;

        static {
            int[] iArr = new int[ItemCardType.values().length];
            try {
                iArr[ItemCardType.AttackMatch.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ItemCardType.CitySearch.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ItemCardType.SpeedUpMatch.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f16406a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaskPartyItemCardEntranceView(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f16405c = new LinkedHashMap();
        f();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f16405c;
        View view = map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i10);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    public final void c(@NotNull ItemCardFeaturesItemModel itemCard) {
        s.i(itemCard, "itemCard");
        setEnabled(false);
        RelativeLayout item_card_layout = (RelativeLayout) a(R$id.item_card_layout);
        s.h(item_card_layout, "item_card_layout");
        item_card_layout.setVisibility(0);
        int i10 = R$id.item_card_imageview;
        ((ImageView) a(i10)).setImageResource(itemCard.getBigIcon());
        ImageView item_card_imageview = (ImageView) a(i10);
        s.h(item_card_imageview, "item_card_imageview");
        y.m(item_card_imageview, Integer.valueOf(z0.h.c(this, 8.0f)), null, null, null, 14, null);
        ((TextView) a(R$id.item_card_content_textview)).setText(getContext().getString(R$string.item_card_in_effect, getContext().getString(itemCard.getTitle())));
        ImageView item_card_arrow_imageview = (ImageView) a(R$id.item_card_arrow_imageview);
        s.h(item_card_arrow_imageview, "item_card_arrow_imageview");
        item_card_arrow_imageview.setVisibility(8);
        LinearLayout item_card_content_layout = (LinearLayout) a(R$id.item_card_content_layout);
        s.h(item_card_content_layout, "item_card_content_layout");
        y.i(item_card_content_layout, (r18 & 1) != 0 ? 0.0f : z0.h.c(this, 6.0f), r.e(Integer.valueOf(com.cupidapp.live.base.utils.h.a(e(itemCard.getType()), 0.2f))), (r18 & 4) != 0 ? GradientDrawable.Orientation.LEFT_RIGHT : null, (r18 & 8) != 0 ? null : null, (r18 & 16) != 0 ? null : null, (r18 & 32) != 0 ? 0.0f : 0.0f, (r18 & 64) != 0 ? 0.0f : 0.0f);
    }

    public final void d(@Nullable String str) {
        h();
        if (str == null || str.length() == 0) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        setEnabled(true);
        RelativeLayout item_card_layout = (RelativeLayout) a(R$id.item_card_layout);
        s.h(item_card_layout, "item_card_layout");
        item_card_layout.setVisibility(0);
        int i10 = R$id.item_card_imageview;
        ((ImageView) a(i10)).setImageResource(R$mipmap.icon_mask_party_item_card_mini);
        ImageView item_card_imageview = (ImageView) a(i10);
        s.h(item_card_imageview, "item_card_imageview");
        y.m(item_card_imageview, Integer.valueOf(z0.h.c(this, 12.0f)), null, null, null, 14, null);
        ((TextView) a(R$id.item_card_content_textview)).setText(str);
        ImageView item_card_arrow_imageview = (ImageView) a(R$id.item_card_arrow_imageview);
        s.h(item_card_arrow_imageview, "item_card_arrow_imageview");
        item_card_arrow_imageview.setVisibility(0);
        LinearLayout item_card_content_layout = (LinearLayout) a(R$id.item_card_content_layout);
        s.h(item_card_content_layout, "item_card_content_layout");
        y.i(item_card_content_layout, (r18 & 1) != 0 ? 0.0f : z0.h.c(this, 6.0f), r.e(Integer.valueOf(com.cupidapp.live.base.utils.h.a(-1, 0.1f))), (r18 & 4) != 0 ? GradientDrawable.Orientation.LEFT_RIGHT : null, (r18 & 8) != 0 ? null : null, (r18 & 16) != 0 ? null : null, (r18 & 32) != 0 ? 0.0f : 0.0f, (r18 & 64) != 0 ? 0.0f : 0.0f);
    }

    public final int e(ItemCardType itemCardType) {
        int i10 = a.f16406a[itemCardType.ordinal()];
        if (i10 == 1) {
            return -14362903;
        }
        if (i10 != 2) {
            return i10 != 3 ? -1 : -21213;
        }
        return -35615;
    }

    public final void f() {
        z.a(this, R$layout.mask_party_item_card_entrance_view, true);
        setVisibility(8);
        y.d(this, new Function1<View, p>() { // from class: com.cupidapp.live.maskparty.view.MaskPartyItemCardEntranceView$initView$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(View view) {
                invoke2(view);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                MaskPartyItemCardEntranceView.this.h();
                Function0<p> clickCallback = MaskPartyItemCardEntranceView.this.getClickCallback();
                if (clickCallback != null) {
                    clickCallback.invoke();
                }
            }
        });
    }

    public final void g(@NotNull SensorPosition position) {
        s.i(position, "position");
        RelativeLayout item_card_layout = (RelativeLayout) a(R$id.item_card_layout);
        s.h(item_card_layout, "item_card_layout");
        item_card_layout.setVisibility(8);
        RelativeLayout item_card_guide_layout = (RelativeLayout) a(R$id.item_card_guide_layout);
        s.h(item_card_guide_layout, "item_card_guide_layout");
        item_card_guide_layout.setVisibility(0);
        FKSVGAImageView item_card_guide_animation_imageview = (FKSVGAImageView) a(R$id.item_card_guide_animation_imageview);
        s.h(item_card_guide_animation_imageview, "item_card_guide_animation_imageview");
        FKSVGAImageView.F(item_card_guide_animation_imageview, "mask_party_speed_up_match.svga", null, null, 6, null);
        GroupOthersLog.M(GroupOthersLog.f18702a, GroupOthersLog.GuideType.SPEED_CARD, position, null, null, 8, null);
    }

    @Nullable
    public final Function0<p> getClickCallback() {
        return this.f16404b;
    }

    public final void h() {
        int i10 = R$id.item_card_guide_animation_imageview;
        if (((FKSVGAImageView) a(i10)).k()) {
            ((FKSVGAImageView) a(i10)).K();
            RelativeLayout item_card_guide_layout = (RelativeLayout) a(R$id.item_card_guide_layout);
            s.h(item_card_guide_layout, "item_card_guide_layout");
            item_card_guide_layout.setVisibility(4);
            RelativeLayout item_card_layout = (RelativeLayout) a(R$id.item_card_layout);
            s.h(item_card_layout, "item_card_layout");
            item_card_layout.setVisibility(0);
        }
    }

    public final void setClickCallback(@Nullable Function0<p> function0) {
        this.f16404b = function0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaskPartyItemCardEntranceView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f16405c = new LinkedHashMap();
        f();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaskPartyItemCardEntranceView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f16405c = new LinkedHashMap();
        f();
    }
}
