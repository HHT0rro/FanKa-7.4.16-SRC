package com.cupidapp.live.liveshow.view.privilege;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.grpc.LiveAnchorPrivilegeInUseConnectorMessage;
import com.cupidapp.live.base.grpc.LiveAnchorPrivilegeLineUpConnectorMessage;
import com.cupidapp.live.base.grpc.LivePrivilegeType;
import com.cupidapp.live.base.utils.i;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.c;
import kotlin.collections.r;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.v;
import z0.y;
import z0.z;

/* compiled from: FKLivePrivilegeStatusLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLivePrivilegeStatusLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final Lazy f15839b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15840c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLivePrivilegeStatusLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15840c = new LinkedHashMap();
        this.f15839b = c.b(FKLivePrivilegeStatusLayout$countDownTimer$2.INSTANCE);
        e();
    }

    private final i getCountDownTimer() {
        return (i) this.f15839b.getValue();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f15840c;
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

    public final void b(int i10) {
        int i11;
        int i12 = 0;
        if (i10 == LivePrivilegeType.ExposureType.getType()) {
            i12 = R$mipmap.icon_exposure_bg;
            i11 = R$mipmap.icon_exposure;
        } else if (i10 == LivePrivilegeType.RecommendType.getType()) {
            i12 = R$mipmap.icon_recommend_bg;
            i11 = R$mipmap.icon_recommend;
        } else {
            i11 = 0;
        }
        ((ImageView) a(R$id.privilegeImageView)).setImageResource(i12);
        ((ImageView) a(R$id.privilegeIconView)).setImageResource(i11);
    }

    public final void c(@NotNull LiveAnchorPrivilegeInUseConnectorMessage privilegeModel) {
        String str;
        s.i(privilegeModel, "privilegeModel");
        setVisibility(0);
        b(privilegeModel.getPrivilegeType());
        int privilegeType = privilegeModel.getPrivilegeType();
        String str2 = "";
        if (privilegeType == LivePrivilegeType.ExposureType.getType()) {
            str2 = getContext().getString(R$string.rising_star_anchor);
            s.h(str2, "context.getString(R.string.rising_star_anchor)");
            str = getContext().getString(R$string.exposure_time);
            s.h(str, "context.getString(R.string.exposure_time)");
        } else if (privilegeType == LivePrivilegeType.RecommendType.getType()) {
            str2 = getContext().getString(R$string.popular_recommendation);
            s.h(str2, "context.getString(R.string.popular_recommendation)");
            str = getContext().getString(R$string.recommended_duration);
            s.h(str, "context.getString(R.string.recommended_duration)");
        } else {
            str = "";
        }
        ((TextView) a(R$id.privilegeStatus)).setText(getContext().getString(R$string.certain_privilege_in_use, str2));
        f(privilegeModel.getUsefulLifeSeconds(), str);
    }

    public final void d(@NotNull LiveAnchorPrivilegeLineUpConnectorMessage privilegeModel) {
        s.i(privilegeModel, "privilegeModel");
        setVisibility(0);
        g();
        b(privilegeModel.getPrivilegeType());
        ((TextView) a(R$id.privilegeStatus)).setText(getContext().getString(R$string.privilege_in_line));
        TextView textView = (TextView) a(R$id.privilegeUseInfo);
        q1.d dVar = q1.d.f53006a;
        String string = getContext().getString(R$string.there_is_also_several, Integer.valueOf(privilegeModel.getPosition()));
        s.h(string, "context.getString(R.stri… privilegeModel.position)");
        textView.setText(dVar.h(string, r.e(String.valueOf(privilegeModel.getPosition())), -49088, null, true));
    }

    public final void e() {
        z.a(this, R$layout.layout_live_privilege_status, true);
        setVisibility(8);
        RelativeLayout privilegeLayout = (RelativeLayout) a(R$id.privilegeLayout);
        s.h(privilegeLayout, "privilegeLayout");
        y.d(privilegeLayout, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.privilege.FKLivePrivilegeStatusLayout$initView$1
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
                ((RelativeLayout) FKLivePrivilegeStatusLayout.this.a(R$id.privilegeLayout)).setVisibility(8);
                ((TextView) FKLivePrivilegeStatusLayout.this.a(R$id.privilegeTextView)).setVisibility(0);
            }
        });
        TextView privilegeTextView = (TextView) a(R$id.privilegeTextView);
        s.h(privilegeTextView, "privilegeTextView");
        y.d(privilegeTextView, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.privilege.FKLivePrivilegeStatusLayout$initView$2
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
                ((TextView) FKLivePrivilegeStatusLayout.this.a(R$id.privilegeTextView)).setVisibility(8);
                ((RelativeLayout) FKLivePrivilegeStatusLayout.this.a(R$id.privilegeLayout)).setVisibility(0);
            }
        });
    }

    public final void f(int i10, final String str) {
        getCountDownTimer().c(Integer.valueOf(i10), 1, new Function0<p>() { // from class: com.cupidapp.live.liveshow.view.privilege.FKLivePrivilegeStatusLayout$startCountDown$1
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
                FKLivePrivilegeStatusLayout.this.setVisibility(8);
            }
        }, new Function1<Integer, p>() { // from class: com.cupidapp.live.liveshow.view.privilege.FKLivePrivilegeStatusLayout$startCountDown$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Integer num) {
                invoke(num.intValue());
                return p.f51048a;
            }

            public final void invoke(int i11) {
                ((TextView) this.a(R$id.privilegeUseInfo)).setText(new SpannableStringBuilder(String.this).append((CharSequence) q1.d.f53006a.f(v.j(i11), new ForegroundColorSpan(-49088))));
            }
        });
    }

    public final void g() {
        getCountDownTimer().g();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLivePrivilegeStatusLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15840c = new LinkedHashMap();
        this.f15839b = c.b(FKLivePrivilegeStatusLayout$countDownTimer$2.INSTANCE);
        e();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLivePrivilegeStatusLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15840c = new LinkedHashMap();
        this.f15839b = c.b(FKLivePrivilegeStatusLayout$countDownTimer$2.INSTANCE);
        e();
    }
}
