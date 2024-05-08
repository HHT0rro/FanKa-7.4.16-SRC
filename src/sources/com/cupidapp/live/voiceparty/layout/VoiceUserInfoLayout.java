package com.cupidapp.live.voiceparty.layout;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cupidapp.live.R$drawable;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.voiceparty.layout.VoiceUserInfoLayout;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.y;
import z0.z;

/* compiled from: VoiceUserInfoLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VoiceUserInfoLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public a f19033b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f19034c;

    /* compiled from: VoiceUserInfoLayout.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface a {
        void a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoiceUserInfoLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f19034c = new LinkedHashMap();
        h();
    }

    public static final void f(VoiceUserInfoLayout this$0, List list) {
        s.i(this$0, "this$0");
        int i10 = R$id.voice_user_interest_linearLayout;
        int width = ((LinearLayout) this$0.b(i10)).getWidth();
        LinearLayout g3 = this$0.g();
        ((LinearLayout) this$0.b(i10)).addView(g3);
        int c4 = h.c(this$0, 12.0f);
        Iterator<E> iterator2 = list.iterator2();
        int i11 = 0;
        while (iterator2.hasNext()) {
            String str = (String) iterator2.next();
            TextView textView = new TextView(this$0.getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMarginEnd(c4);
            textView.setLayoutParams(layoutParams);
            textView.setTextColor(-1);
            textView.setTextSize(14.0f);
            int c10 = h.c(textView, 6.0f);
            int c11 = h.c(textView, 12.0f);
            textView.setPadding(c11, c10, c11, c10);
            textView.setText(str);
            textView.setBackgroundResource(R$drawable.shape_white_bg_two_corners);
            textView.setBackgroundTintList(ColorStateList.valueOf(com.cupidapp.live.base.utils.h.a(-1, 0.1f)));
            textView.measure(View.MeasureSpec.makeMeasureSpec(width, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(h.c(this$0, 26.0f), Integer.MIN_VALUE));
            i11 += textView.getMeasuredWidth() + c4;
            if (i11 <= width) {
                g3.addView(textView);
            } else {
                int measuredWidth = textView.getMeasuredWidth();
                LinearLayout g10 = this$0.g();
                ((LinearLayout) this$0.b(R$id.voice_user_interest_linearLayout)).addView(g10);
                g10.addView(textView);
                i11 = measuredWidth;
                g3 = g10;
            }
        }
    }

    @Nullable
    public View b(int i10) {
        Map<Integer, View> map = this.f19034c;
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

    public final void d(@NotNull User user) {
        s.i(user, "user");
        ((TextView) b(R$id.voice_basic_user_info_text)).setText(user.getUserProfileSummaryInfo());
        String summary = user.getSummary();
        boolean z10 = true;
        if (summary == null || summary.length() == 0) {
            List<String> interest = user.getInterest();
            if (interest == null || interest.isEmpty()) {
                ((LinearLayout) b(R$id.voice_user_interest_linearLayout)).setVisibility(8);
                int i10 = R$id.voice_personal_introduction_text;
                ((TextView) b(i10)).setVisibility(0);
                ((TextView) b(i10)).setText(getContext().getString(R$string.insufficient_information_ask_directly));
                return;
            }
        }
        String summary2 = user.getSummary();
        if (summary2 == null || summary2.length() == 0) {
            ((TextView) b(R$id.voice_personal_introduction_text)).setVisibility(8);
        } else {
            int i11 = R$id.voice_personal_introduction_text;
            ((TextView) b(i11)).setVisibility(0);
            ((TextView) b(i11)).setText(user.getSummary());
        }
        List<String> interest2 = user.getInterest();
        if (interest2 != null && !interest2.isEmpty()) {
            z10 = false;
        }
        if (z10) {
            ((LinearLayout) b(R$id.voice_user_interest_linearLayout)).setVisibility(8);
        } else {
            ((LinearLayout) b(R$id.voice_user_interest_linearLayout)).setVisibility(0);
            e(user.getInterest());
        }
    }

    public final void e(final List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        ((LinearLayout) b(R$id.voice_user_interest_linearLayout)).post(new Runnable() { // from class: com.cupidapp.live.voiceparty.layout.b
            @Override // java.lang.Runnable
            public final void run() {
                VoiceUserInfoLayout.f(VoiceUserInfoLayout.this, list);
            }
        });
    }

    public final LinearLayout g() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = h.c(layoutParams, 12.0f);
        linearLayout.setLayoutParams(layoutParams);
        return linearLayout;
    }

    public final void h() {
        z.a(this, R$layout.layout_voice_user_info, true);
    }

    public final void i() {
        int i10 = R$id.voice_goto_profile_btn;
        ((TextView) b(i10)).setVisibility(0);
        TextView voice_goto_profile_btn = (TextView) b(i10);
        s.h(voice_goto_profile_btn, "voice_goto_profile_btn");
        y.d(voice_goto_profile_btn, new Function1<View, p>() { // from class: com.cupidapp.live.voiceparty.layout.VoiceUserInfoLayout$showGotoProfileBtn$1
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
                VoiceUserInfoLayout.a aVar;
                aVar = VoiceUserInfoLayout.this.f19033b;
                if (aVar != null) {
                    aVar.a();
                }
            }
        });
    }

    public final void setVoiceUserInfoListener(@NotNull a listener) {
        s.i(listener, "listener");
        this.f19033b = listener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoiceUserInfoLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f19034c = new LinkedHashMap();
        h();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoiceUserInfoLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f19034c = new LinkedHashMap();
        h();
    }
}
