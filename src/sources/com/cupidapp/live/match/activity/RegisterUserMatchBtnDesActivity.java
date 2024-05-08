package com.cupidapp.live.match.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.cupidapp.live.R$color;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.appdialog.model.ActivationType;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.view.animation.FKLottieAnimationView;
import com.cupidapp.live.profile.event.ShowGuideBubbleEvent;
import com.cupidapp.live.track.group.GroupOthersLog;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: RegisterUserMatchBtnDesActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class RegisterUserMatchBtnDesActivity extends FKBaseActivity {

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    public static final a f16544s = new a(null);

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16546r = new LinkedHashMap();

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public final Lazy f16545q = kotlin.c.b(new Function0<String>() { // from class: com.cupidapp.live.match.activity.RegisterUserMatchBtnDesActivity$type$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @Nullable
        public final String invoke() {
            return RegisterUserMatchBtnDesActivity.this.getIntent().getStringExtra("data_type");
        }
    });

    /* compiled from: RegisterUserMatchBtnDesActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull String type) {
            kotlin.jvm.internal.s.i(context, "context");
            kotlin.jvm.internal.s.i(type, "type");
            Intent intent = new Intent(context, (Class<?>) RegisterUserMatchBtnDesActivity.class);
            intent.putExtra("data_type", type);
            context.startActivity(intent);
        }
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity
    @NotNull
    public SensorPosition Q0() {
        return SensorPosition.NewUserGuideIntro;
    }

    @Nullable
    public View j1(int i10) {
        Map<Integer, View> map = this.f16546r;
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

    public final String l1() {
        return (String) this.f16545q.getValue();
    }

    public final void m1() {
        int color;
        int i10;
        String str;
        String str2;
        String l12 = l1();
        if (kotlin.jvm.internal.s.d(l12, ActivationType.SuperLike.getValue())) {
            color = ContextCompat.getColor(this, R$color.purple_7A69FF);
            i10 = R$mipmap.new_guide_superlike_contents;
            str = "lottie/match/anim_guide_superlike.json";
        } else if (kotlin.jvm.internal.s.d(l12, ActivationType.SuperBoost.getValue())) {
            color = ContextCompat.getColor(this, R$color.yellow_FFD300);
            i10 = R$mipmap.new_guide_superboost_contents;
            str = "lottie/match/anim_guide_superboost.json";
        } else {
            color = ContextCompat.getColor(this, R$color.prime_red);
            i10 = R$mipmap.new_guide_recall_contents;
            str = "lottie/match/anim_guide_recall.json";
        }
        int i11 = R$id.guide_lottie;
        ((FKLottieAnimationView) j1(i11)).setLottieAnimation(str);
        ((FKLottieAnimationView) j1(i11)).L();
        int i12 = R$id.guide_confirm_btn;
        ((TextView) j1(i12)).setBackgroundTintList(ColorStateList.valueOf(color));
        ((ImageView) j1(R$id.guide_img)).setImageResource(i10);
        TextView guide_confirm_btn = (TextView) j1(i12);
        kotlin.jvm.internal.s.h(guide_confirm_btn, "guide_confirm_btn");
        z0.u.a(guide_confirm_btn);
        TextView guide_confirm_btn2 = (TextView) j1(i12);
        kotlin.jvm.internal.s.h(guide_confirm_btn2, "guide_confirm_btn");
        z0.y.d(guide_confirm_btn2, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.activity.RegisterUserMatchBtnDesActivity$initView$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(View view) {
                invoke2(view);
                return kotlin.p.f51048a;
            }

            /* JADX WARN: Code restructure failed: missing block: B:4:0x001f, code lost:
            
                if (r1 == null) goto L6;
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void invoke2(@org.jetbrains.annotations.Nullable android.view.View r4) {
                /*
                    r3 = this;
                    com.cupidapp.live.track.group.GroupOthersLog r4 = com.cupidapp.live.track.group.GroupOthersLog.f18702a
                    com.cupidapp.live.match.activity.RegisterUserMatchBtnDesActivity r0 = com.cupidapp.live.match.activity.RegisterUserMatchBtnDesActivity.this
                    com.cupidapp.live.base.sensorslog.SensorPosition r0 = r0.Q0()
                    java.lang.String r0 = r0.getValue()
                    com.cupidapp.live.match.activity.RegisterUserMatchBtnDesActivity r1 = com.cupidapp.live.match.activity.RegisterUserMatchBtnDesActivity.this
                    java.lang.String r1 = com.cupidapp.live.match.activity.RegisterUserMatchBtnDesActivity.k1(r1)
                    if (r1 == 0) goto L21
                    java.util.Locale r2 = java.util.Locale.ROOT
                    java.lang.String r1 = r1.toUpperCase(r2)
                    java.lang.String r2 = "this as java.lang.String).toUpperCase(Locale.ROOT)"
                    kotlin.jvm.internal.s.h(r1, r2)
                    if (r1 != 0) goto L23
                L21:
                    java.lang.String r1 = ""
                L23:
                    r4.Q(r0, r1)
                    com.cupidapp.live.match.activity.RegisterUserMatchBtnDesActivity r4 = com.cupidapp.live.match.activity.RegisterUserMatchBtnDesActivity.this
                    r4.finish()
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.match.activity.RegisterUserMatchBtnDesActivity$initView$1.invoke2(android.view.View):void");
            }
        });
        ((ConstraintLayout) j1(R$id.guide_root)).setVisibility(0);
        GroupOthersLog groupOthersLog = GroupOthersLog.f18702a;
        String value = Q0().getValue();
        String l13 = l1();
        if (l13 != null) {
            str2 = l13.toUpperCase(Locale.ROOT);
            kotlin.jvm.internal.s.h(str2, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        } else {
            str2 = null;
        }
        GroupOthersLog.d(groupOthersLog, value, str2, null, 4, null);
        EventBus.c().o(new ShowGuideBubbleEvent(l1()));
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_register_user_match_btn_des);
        m1();
    }
}
