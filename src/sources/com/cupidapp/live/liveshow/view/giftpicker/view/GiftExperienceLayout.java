package com.cupidapp.live.liveshow.view.giftpicker.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.liveshow.model.ExperienceModel;
import com.cupidapp.live.liveshow.model.LiveGiftActivityModel;
import com.cupidapp.live.liveshow.view.miniprofile.FKLiveUserRankView;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.u;
import z0.y;
import z0.z;

/* compiled from: GiftExperienceLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class GiftExperienceLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public ExperienceModel f15556b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public String f15557c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public Function1<? super String, p> f15558d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15559e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GiftExperienceLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15559e = new LinkedHashMap();
        g();
    }

    public static final void f(GiftExperienceLayout this$0, float f10, float f11, Long l10, ExperienceModel it, float f12) {
        String string;
        s.i(this$0, "this$0");
        s.i(it, "$it");
        int width = ((CardView) this$0.b(R$id.experience_card_view)).getWidth();
        float f13 = width;
        float f14 = (f10 / f11) * f13;
        float longValue = ((f10 + ((float) (l10 != null ? l10.longValue() : 0L))) / f11) * f13;
        TextView textView = (TextView) this$0.b(R$id.experience_textview);
        if (l10 != null) {
            string = this$0.getContext().getString(R$string.increase_experience, l10);
        } else if (it.getMaxLevel()) {
            string = this$0.getContext().getString(R$string.reached_the_highest_level);
        } else {
            string = this$0.getContext().getString(R$string.need_several_experience_to_upgrade, Integer.valueOf((int) f12));
        }
        textView.setText(string);
        View current_experience_view = this$0.b(R$id.current_experience_view);
        s.h(current_experience_view, "current_experience_view");
        y.o(current_experience_view, Integer.valueOf((int) f14), null, 2, null);
        View increase_experience_view = this$0.b(R$id.increase_experience_view);
        s.h(increase_experience_view, "increase_experience_view");
        if (longValue < f13) {
            width = (int) longValue;
        }
        y.o(increase_experience_view, Integer.valueOf(width), null, 2, null);
    }

    @Nullable
    public View b(int i10) {
        Map<Integer, View> map = this.f15559e;
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

    public final void d(@Nullable ExperienceModel experienceModel, @Nullable LiveGiftActivityModel liveGiftActivityModel) {
        this.f15556b = experienceModel;
        this.f15557c = liveGiftActivityModel != null ? liveGiftActivityModel.getPath() : null;
        ((FKLiveUserRankView) b(R$id.live_rank_view)).h(experienceModel != null ? experienceModel.getCurrentLevelIcon() : null);
        ((TextView) b(R$id.next_level_textview)).setText(experienceModel != null ? experienceModel.getNextLevelText() : null);
        if ((liveGiftActivityModel != null ? liveGiftActivityModel.getIcon() : null) != null) {
            int i10 = R$id.noble_imageview;
            ImageLoaderView noble_imageview = (ImageLoaderView) b(i10);
            s.h(noble_imageview, "noble_imageview");
            ImageLoaderView.g(noble_imageview, liveGiftActivityModel.getIcon(), null, null, 6, null);
            int scaleWidthByHeight = liveGiftActivityModel.getIcon().getScaleWidthByHeight(z0.h.c(this, 24.0f));
            ImageLoaderView noble_imageview2 = (ImageLoaderView) b(i10);
            s.h(noble_imageview2, "noble_imageview");
            y.o(noble_imageview2, Integer.valueOf(scaleWidthByHeight), null, 2, null);
        }
        e(null);
    }

    public final void e(@Nullable final Long l10) {
        final ExperienceModel experienceModel = this.f15556b;
        if (experienceModel != null) {
            final float currentExp = (float) experienceModel.getCurrentExp();
            final float nextLevelNeedExp = (float) experienceModel.getNextLevelNeedExp();
            final float f10 = nextLevelNeedExp - currentExp;
            ((CardView) b(R$id.experience_card_view)).post(new Runnable() { // from class: com.cupidapp.live.liveshow.view.giftpicker.view.l
                @Override // java.lang.Runnable
                public final void run() {
                    GiftExperienceLayout.f(GiftExperienceLayout.this, currentExp, nextLevelNeedExp, l10, experienceModel, f10);
                }
            });
        }
    }

    public final void g() {
        z.a(this, R$layout.layout_gift_experience, true);
        TextView next_level_textview = (TextView) b(R$id.next_level_textview);
        s.h(next_level_textview, "next_level_textview");
        u.a(next_level_textview);
        ImageLoaderView noble_imageview = (ImageLoaderView) b(R$id.noble_imageview);
        s.h(noble_imageview, "noble_imageview");
        y.d(noble_imageview, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.view.GiftExperienceLayout$initView$1
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
                String str;
                Function1<String, p> clickNobleCallback;
                str = GiftExperienceLayout.this.f15557c;
                if (str == null || (clickNobleCallback = GiftExperienceLayout.this.getClickNobleCallback()) == null) {
                    return;
                }
                clickNobleCallback.invoke(str);
            }
        });
    }

    @Nullable
    public final Function1<String, p> getClickNobleCallback() {
        return this.f15558d;
    }

    public final void setClickNobleCallback(@Nullable Function1<? super String, p> function1) {
        this.f15558d = function1;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GiftExperienceLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15559e = new LinkedHashMap();
        g();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GiftExperienceLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15559e = new LinkedHashMap();
        g();
    }
}
