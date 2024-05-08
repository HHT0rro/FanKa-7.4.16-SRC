package com.cupidapp.live.vip.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.view.BaseLayout;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.kwad.sdk.core.response.model.SdkConfigData;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$LongRef;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.u;
import z0.v;
import z0.z;

/* compiled from: VipDiscountTimeLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VipDiscountTimeLayout extends BaseLayout {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f18782d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VipDiscountTimeLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f18782d = new LinkedHashMap();
        l();
    }

    public static final void i(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Nullable
    public View f(int i10) {
        Map<Integer, View> map = this.f18782d;
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

    public final void h(@Nullable Long l10) {
        if (l10 == null || l10.longValue() <= 0) {
            setVisibility(8);
            return;
        }
        if (l10.longValue() <= System.currentTimeMillis() + 1000) {
            setVisibility(0);
            k(0L);
            return;
        }
        final Ref$LongRef ref$LongRef = new Ref$LongRef();
        ref$LongRef.element = (l10.longValue() - System.currentTimeMillis()) / 1000;
        setVisibility(0);
        Observable<Long> observeOn = Observable.intervalRange(0L, ref$LongRef.element + 1, 0L, 1L, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread());
        final Function1<Long, p> function1 = new Function1<Long, p>() { // from class: com.cupidapp.live.vip.layout.VipDiscountTimeLayout$configActivityCountDownLayout$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Long l11) {
                invoke2(l11);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Long l11) {
                VipDiscountTimeLayout vipDiscountTimeLayout = VipDiscountTimeLayout.this;
                Ref$LongRef ref$LongRef2 = ref$LongRef;
                long j10 = ref$LongRef2.element;
                ref$LongRef2.element = (-1) + j10;
                vipDiscountTimeLayout.k(j10);
            }
        };
        Disposable subscribe = observeOn.doOnNext(new Consumer() { // from class: com.cupidapp.live.vip.layout.b
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                VipDiscountTimeLayout.i(Function1.this, obj);
            }
        }).ignoreElements().subscribe();
        s.h(subscribe, "fun configActivityCountD…      .subscribe())\n    }");
        H(subscribe);
    }

    public final void j(int i10) {
        ((LinearLayout) f(R$id.root_ll)).setBackgroundColor(i10);
    }

    public final void k(long j10) {
        long j11 = RemoteMessageConst.DEFAULT_TTL;
        long j12 = j10 / j11;
        long j13 = j10 % j11;
        long j14 = SdkConfigData.DEFAULT_REQUEST_INTERVAL;
        long j15 = j13 / j14;
        long j16 = j13 % j14;
        long j17 = 60;
        ((TextView) f(R$id.day_value_text)).setText(v.l(j12));
        ((TextView) f(R$id.hour_value_text)).setText(v.l(j15));
        ((TextView) f(R$id.min_value_text)).setText(v.l(j16 / j17));
        ((TextView) f(R$id.second_value_text)).setText(v.l(j16 % j17));
    }

    public final void l() {
        z.a(this, R$layout.layout_vip_discount_time, true);
        TextView activity_count_down = (TextView) f(R$id.activity_count_down);
        s.h(activity_count_down, "activity_count_down");
        u.a(activity_count_down);
        TextView day_value_text = (TextView) f(R$id.day_value_text);
        s.h(day_value_text, "day_value_text");
        u.a(day_value_text);
        TextView day_text_view = (TextView) f(R$id.day_text_view);
        s.h(day_text_view, "day_text_view");
        u.a(day_text_view);
        TextView hour_value_text = (TextView) f(R$id.hour_value_text);
        s.h(hour_value_text, "hour_value_text");
        u.a(hour_value_text);
        TextView hour_text_view = (TextView) f(R$id.hour_text_view);
        s.h(hour_text_view, "hour_text_view");
        u.a(hour_text_view);
        TextView min_value_text = (TextView) f(R$id.min_value_text);
        s.h(min_value_text, "min_value_text");
        u.a(min_value_text);
        TextView min_text_view = (TextView) f(R$id.min_text_view);
        s.h(min_text_view, "min_text_view");
        u.a(min_text_view);
        TextView second_value_text = (TextView) f(R$id.second_value_text);
        s.h(second_value_text, "second_value_text");
        u.a(second_value_text);
        TextView second_text_view = (TextView) f(R$id.second_text_view);
        s.h(second_text_view, "second_text_view");
        u.a(second_text_view);
        setVisibility(8);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VipDiscountTimeLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f18782d = new LinkedHashMap();
        l();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VipDiscountTimeLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f18782d = new LinkedHashMap();
        l();
    }
}
