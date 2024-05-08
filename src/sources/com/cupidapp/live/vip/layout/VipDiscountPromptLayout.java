package com.cupidapp.live.vip.layout;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.utils.i;
import com.cupidapp.live.track.group.GroupOthersLog;
import com.cupidapp.live.vip.model.DiscountShowPlace;
import com.cupidapp.live.vip.model.VipDiscountPromptModel;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.r;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.v;
import z0.y;
import z0.z;

/* compiled from: VipDiscountPromptLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VipDiscountPromptLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final Lazy f18779b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f18780c;

    /* compiled from: VipDiscountPromptLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18781a;

        static {
            int[] iArr = new int[DiscountShowPlace.values().length];
            try {
                iArr[DiscountShowPlace.Feed.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DiscountShowPlace.Session.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f18781a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VipDiscountPromptLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f18780c = new LinkedHashMap();
        this.f18779b = kotlin.c.b(VipDiscountPromptLayout$countDownTimer$2.INSTANCE);
        c();
    }

    private final i getCountDownTimer() {
        return (i) this.f18779b.getValue();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f18780c;
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

    public final void b(@NotNull final VipDiscountPromptModel discount, @NotNull final DiscountShowPlace showPlace) {
        final SensorPosition sensorPosition;
        s.i(discount, "discount");
        s.i(showPlace, "showPlace");
        List<String> showPlace2 = discount.getShowPlace();
        if (!(showPlace2 != null && showPlace2.contains(showPlace.getPlace()))) {
            setVisibility(8);
            getCountDownTimer().g();
            return;
        }
        if (getVisibility() == 0) {
            return;
        }
        int i10 = a.f18781a[showPlace.ordinal()];
        if (i10 != 1) {
            sensorPosition = i10 != 2 ? null : SensorPosition.Message;
        } else {
            sensorPosition = SensorPosition.Feed;
        }
        GroupOthersLog.M(GroupOthersLog.f18702a, GroupOthersLog.GuideType.CHANNEL_FIRST_BUY_GUIDE, sensorPosition, null, null, 12, null);
        setVisibility(0);
        if (discount.getImage() != null) {
            int i11 = R$id.vip_discount_imageview;
            ImageLoaderView vip_discount_imageview = (ImageLoaderView) a(i11);
            s.h(vip_discount_imageview, "vip_discount_imageview");
            ImageLoaderView.g(vip_discount_imageview, discount.getImage(), null, null, 6, null);
            int scaleHeightByWidth = discount.getImage().getScaleHeightByWidth(h.l(this) - h.c(this, 16.0f));
            ImageLoaderView vip_discount_imageview2 = (ImageLoaderView) a(i11);
            s.h(vip_discount_imageview2, "vip_discount_imageview");
            y.o(vip_discount_imageview2, null, Integer.valueOf(scaleHeightByWidth), 1, null);
        }
        ((TextView) a(R$id.vip_discount_textview)).setText(discount.getTitle());
        Long timing = discount.getTiming();
        long longValue = (timing != null ? timing.longValue() : 0L) - System.currentTimeMillis();
        if (longValue > 0) {
            ((TextView) a(R$id.vip_discount_countdown_textview)).setText(v.c(longValue));
            getCountDownTimer().e(longValue, 1000L, new Function0<p>() { // from class: com.cupidapp.live.vip.layout.VipDiscountPromptLayout$configDiscountLayout$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ p invoke() {
                    invoke2();
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    VipDiscountPromptLayout.this.setVisibility(8);
                }
            }, new Function1<Long, p>() { // from class: com.cupidapp.live.vip.layout.VipDiscountPromptLayout$configDiscountLayout$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(Long l10) {
                    invoke(l10.longValue());
                    return p.f51048a;
                }

                public final void invoke(long j10) {
                    ((TextView) VipDiscountPromptLayout.this.a(R$id.vip_discount_countdown_textview)).setText(v.c(j10));
                }
            });
        }
        y.d(this, new Function1<View, p>() { // from class: com.cupidapp.live.vip.layout.VipDiscountPromptLayout$configDiscountLayout$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                Map<String, String> url = VipDiscountPromptModel.this.getUrl();
                j.a.b(j.f12156c, this.getContext(), url != null ? url.get(showPlace.getPlace()) : null, null, 4, null);
                GroupOthersLog.H(GroupOthersLog.f18702a, GroupOthersLog.GuideType.CHANNEL_FIRST_BUY_GUIDE, sensorPosition, null, 4, null);
            }
        });
    }

    public final void c() {
        z.a(this, R$layout.layout_vip_discount_prompt, true);
        setVisibility(8);
        ((TextView) a(R$id.vip_discount_textview)).getPaint().setFakeBoldText(true);
        TextView vip_discount_countdown_textview = (TextView) a(R$id.vip_discount_countdown_textview);
        s.h(vip_discount_countdown_textview, "vip_discount_countdown_textview");
        y.i(vip_discount_countdown_textview, (r18 & 1) != 0 ? 0.0f : h.c(this, 100.0f), r.e(Integer.valueOf(com.cupidapp.live.base.utils.h.a(-47872, 0.8f))), (r18 & 4) != 0 ? GradientDrawable.Orientation.LEFT_RIGHT : null, (r18 & 8) != 0 ? null : null, (r18 & 16) != 0 ? null : null, (r18 & 32) != 0 ? 0.0f : 0.0f, (r18 & 64) != 0 ? 0.0f : 0.0f);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getCountDownTimer().g();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VipDiscountPromptLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f18780c = new LinkedHashMap();
        this.f18779b = kotlin.c.b(VipDiscountPromptLayout$countDownTimer$2.INSTANCE);
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VipDiscountPromptLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f18780c = new LinkedHashMap();
        this.f18779b = kotlin.c.b(VipDiscountPromptLayout$countDownTimer$2.INSTANCE);
        c();
    }
}
