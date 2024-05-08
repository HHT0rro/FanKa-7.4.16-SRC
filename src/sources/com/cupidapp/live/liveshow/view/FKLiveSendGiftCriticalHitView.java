package com.cupidapp.live.liveshow.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.sensorslog.SensorLogActivity;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorsLogLiveShow;
import com.cupidapp.live.liveshow.activity.FKLiveOpenWebFragmentEvent;
import com.cupidapp.live.liveshow.model.FKCriticalHitModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: FKLiveSendGiftCriticalHitView.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveSendGiftCriticalHitView extends FrameLayout {

    /* renamed from: b */
    public boolean f15261b;

    /* renamed from: c */
    @Nullable
    public ValueAnimator f15262c;

    /* renamed from: d */
    @NotNull
    public Map<Integer, View> f15263d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveSendGiftCriticalHitView(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15263d = new LinkedHashMap();
        g();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void f(FKLiveSendGiftCriticalHitView fKLiveSendGiftCriticalHitView, FKCriticalHitModel fKCriticalHitModel, boolean z10, Function0 function0, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            function0 = null;
        }
        fKLiveSendGiftCriticalHitView.e(fKCriticalHitModel, z10, function0);
    }

    public static final void k(FKLiveSendGiftCriticalHitView this$0, int i10, final Function0 function0, ValueAnimator it) {
        s.i(this$0, "this$0");
        s.i(it, "it");
        Object animatedValue = it.getAnimatedValue();
        s.g(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int intValue = i10 - ((Integer) animatedValue).intValue();
        ((TextView) this$0.c(R$id.critical_hit_count_down_view)).setText(this$0.getContext().getString(R$string.count_down_seconds, Integer.valueOf(intValue)));
        if (intValue == 0) {
            this$0.postDelayed(new Runnable() { // from class: com.cupidapp.live.liveshow.view.e
                @Override // java.lang.Runnable
                public final void run() {
                    FKLiveSendGiftCriticalHitView.l(FKLiveSendGiftCriticalHitView.this, function0);
                }
            }, 1000L);
        }
    }

    public static final void l(FKLiveSendGiftCriticalHitView this$0, Function0 function0) {
        s.i(this$0, "this$0");
        this$0.setVisibility(8);
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Nullable
    public View c(int i10) {
        Map<Integer, View> map = this.f15263d;
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

    public final void e(@Nullable FKCriticalHitModel fKCriticalHitModel, boolean z10, @Nullable Function0<p> function0) {
        this.f15261b = z10;
        m();
        if (fKCriticalHitModel == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        ImageLoaderView critical_hit_gift_image_view = (ImageLoaderView) c(R$id.critical_hit_gift_image_view);
        s.h(critical_hit_gift_image_view, "critical_hit_gift_image_view");
        ImageLoaderView.g(critical_hit_gift_image_view, fKCriticalHitModel.getIconImage(), null, null, 6, null);
        ((TextView) c(R$id.critical_hit_rate_view)).setText(fKCriticalHitModel.getText());
        int currentTimeMillis = fKCriticalHitModel.getCurrentTimeMillis() != null ? (int) ((System.currentTimeMillis() - fKCriticalHitModel.getCurrentTimeMillis().longValue()) / 1000) : 0;
        if (fKCriticalHitModel.getCountdown() != null) {
            j(currentTimeMillis >= 0 ? fKCriticalHitModel.getCountdown().intValue() - currentTimeMillis : fKCriticalHitModel.getCountdown().intValue(), function0);
            if (!z10) {
                SensorsLogLiveShow.f12212a.b(fKCriticalHitModel.getCategory(), fKCriticalHitModel.getCountdown().intValue());
            }
        }
        final String url = fKCriticalHitModel.getUrl();
        if (url != null) {
            y.d(this, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.FKLiveSendGiftCriticalHitView$configCriticalHitView$1$1
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
                    EventBus.c().l(new FKLiveOpenWebFragmentEvent(String.this, false, 2, null));
                    this.h(String.this, SensorLogActivity.Type.HIGHLIGHT_MOMENT_COUNT_DOWN.getType());
                }
            });
        }
        i(fKCriticalHitModel.getUrl(), SensorLogActivity.Type.HIGHLIGHT_MOMENT_COUNT_DOWN.getType());
    }

    public final void g() {
        z.a(this, R$layout.live_send_gift_critical_hit_view, true);
        ((TextView) c(R$id.critical_hit_rate_view)).getPaint().setFakeBoldText(true);
        setVisibility(8);
    }

    public final void h(String str, String str2) {
        SensorLogActivity.f12204a.a((this.f15261b ? SensorPosition.LiveShowRoom : SensorPosition.AnchorLiveShowRoom).getValue(), str, str2);
    }

    public final void i(String str, String str2) {
        SensorLogActivity.f12204a.b((this.f15261b ? SensorPosition.LiveShowRoom : SensorPosition.AnchorLiveShowRoom).getValue(), str, str2);
    }

    public final void j(final int i10, final Function0<p> function0) {
        ValueAnimator ofInt = ValueAnimator.ofInt(i10);
        ofInt.setDuration(i10 * 1000);
        ofInt.setInterpolator(new LinearInterpolator());
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.cupidapp.live.liveshow.view.d
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                FKLiveSendGiftCriticalHitView.k(FKLiveSendGiftCriticalHitView.this, i10, function0, valueAnimator);
            }
        });
        this.f15262c = ofInt;
        ofInt.start();
    }

    public final void m() {
        ValueAnimator valueAnimator = this.f15262c;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
        }
        ValueAnimator valueAnimator2 = this.f15262c;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
        this.f15262c = null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveSendGiftCriticalHitView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15263d = new LinkedHashMap();
        g();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveSendGiftCriticalHitView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15263d = new LinkedHashMap();
        g();
    }
}
