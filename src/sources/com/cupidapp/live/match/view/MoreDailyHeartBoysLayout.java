package com.cupidapp.live.match.view;

import android.content.Context;
import android.os.CountDownTimer;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.view.BaseLayout;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MoreDailyHeartBoysLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MoreDailyHeartBoysLayout extends BaseLayout {

    /* renamed from: d */
    @Nullable
    public CountDownTimer f16970d;

    /* renamed from: e */
    @NotNull
    public Map<Integer, View> f16971e;

    /* compiled from: MoreDailyHeartBoysLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a extends CountDownTimer {
        public a() {
            super(5000L, 5000L);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            MoreDailyHeartBoysLayout.this.setVisibility(8);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j10) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MoreDailyHeartBoysLayout(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.f16971e = new LinkedHashMap();
        h();
    }

    public static /* synthetic */ void g(MoreDailyHeartBoysLayout moreDailyHeartBoysLayout, SpannableString spannableString, List list, int i10, int i11, Integer num, Function0 function0, int i12, Object obj) {
        moreDailyHeartBoysLayout.f(spannableString, (i12 & 2) != 0 ? null : list, i10, i11, (i12 & 16) != 0 ? null : num, (i12 & 32) != 0 ? null : function0);
    }

    @Nullable
    public View e(int i10) {
        Map<Integer, View> map = this.f16971e;
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

    public final void f(@NotNull SpannableString content, @Nullable List<ImageModel> list, @DrawableRes int i10, @ColorInt int i11, @DrawableRes @Nullable Integer num, @Nullable final Function0<kotlin.p> function0) {
        ImageLoaderView imageLoaderView;
        ImageLoaderView imageLoaderView2;
        kotlin.jvm.internal.s.i(content, "content");
        setVisibility(0);
        e(R$id.root_bg).setBackgroundResource(i10);
        int size = list != null ? list.size() : 0;
        if (size > 0) {
            ((RelativeLayout) e(R$id.match_heart_preview_rl)).setVisibility(0);
            ImageLoaderView imageLoaderView3 = (ImageLoaderView) e(R$id.match_heart_first_avatar);
            if (imageLoaderView3 != null) {
                ImageLoaderView.g(imageLoaderView3, list != null ? list.get(0) : null, null, null, 6, null);
            }
        } else {
            ((RelativeLayout) e(R$id.match_heart_preview_rl)).setVisibility(8);
        }
        if (size > 1 && (imageLoaderView2 = (ImageLoaderView) e(R$id.match_heart_second_avatar)) != null) {
            ImageLoaderView.g(imageLoaderView2, list != null ? list.get(1) : null, null, null, 6, null);
        }
        if (size > 2 && (imageLoaderView = (ImageLoaderView) e(R$id.match_heart_third_avatar)) != null) {
            ImageLoaderView.g(imageLoaderView, list != null ? list.get(2) : null, null, null, 6, null);
        }
        int i12 = R$id.match_heart_avatar_tip;
        ((TextView) e(i12)).setTextColor(i11);
        ((TextView) e(i12)).setText(content);
        if (num != null) {
            TextView match_heart_avatar_tip = (TextView) e(i12);
            kotlin.jvm.internal.s.h(match_heart_avatar_tip, "match_heart_avatar_tip");
            z0.u.e(match_heart_avatar_tip, 0, 0, num.intValue(), 0, 11, null);
        }
        CountDownTimer countDownTimer = this.f16970d;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        CountDownTimer countDownTimer2 = this.f16970d;
        if (countDownTimer2 != null) {
            countDownTimer2.start();
        }
        z0.y.d(this, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.view.MoreDailyHeartBoysLayout$configData$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(View view) {
                invoke2(view);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                Function0<kotlin.p> function02 = function0;
                if (function02 != null) {
                    function02.invoke();
                }
            }
        });
    }

    public final void h() {
        z0.z.a(this, R$layout.layout_heart_beat, true);
        setVisibility(8);
        TextView match_heart_avatar_tip = (TextView) e(R$id.match_heart_avatar_tip);
        kotlin.jvm.internal.s.h(match_heart_avatar_tip, "match_heart_avatar_tip");
        z0.u.a(match_heart_avatar_tip);
        this.f16970d = new a();
    }

    @Override // com.cupidapp.live.base.view.BaseLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        CountDownTimer countDownTimer = this.f16970d;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.f16970d = null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MoreDailyHeartBoysLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.i(context, "context");
        this.f16971e = new LinkedHashMap();
        h();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MoreDailyHeartBoysLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.s.i(context, "context");
        this.f16971e = new LinkedHashMap();
        h();
    }
}
