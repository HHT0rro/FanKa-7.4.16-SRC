package com.cupidapp.live.login.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.cupidapp.live.R$anim;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.utils.p0;
import com.cupidapp.live.login.fragment.WelcomeFragment;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SignInActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class SignInActivity extends FKBaseActivity {

    /* renamed from: t */
    @NotNull
    public static final a f16116t = new a(null);

    /* renamed from: q */
    @Nullable
    public WelcomeFragment f16117q;

    /* renamed from: s */
    @NotNull
    public Map<Integer, View> f16119s = new LinkedHashMap();

    /* renamed from: r */
    @NotNull
    public final Lazy f16118r = kotlin.c.b(new Function0<Boolean>() { // from class: com.cupidapp.live.login.activity.SignInActivity$touristLogin$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final Boolean invoke() {
            return Boolean.valueOf(SignInActivity.this.getIntent().getBooleanExtra("TOURIST_LOGIN", false));
        }
    });

    /* compiled from: SignInActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void b(a aVar, Context context, boolean z10, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                z10 = false;
            }
            aVar.a(context, z10);
        }

        public final void a(@Nullable Context context, boolean z10) {
            if (context == null) {
                return;
            }
            Intent intent = new Intent(context, (Class<?>) SignInActivity.class);
            intent.putExtra("TOURIST_LOGIN", z10);
            context.startActivity(intent);
            FKBaseActivity.f11750o.b(context, R$anim.anim_activity_bottom_to_top, R$anim.anim_activity_nothing);
        }
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity
    @NotNull
    public SensorPosition Q0() {
        return R0() instanceof WelcomeFragment ? SensorPosition.Welcome : super.Q0();
    }

    public final boolean j1() {
        return ((Boolean) this.f16118r.getValue()).booleanValue();
    }

    public final void k1() {
        if (this.f16117q == null) {
            this.f16117q = WelcomeFragment.f16126g.b(j1());
        }
        FKBaseActivity.g1(this, this.f16117q, false, R$id.signInFragmentContainerLayout, false, false, 24, null);
        p0.c(this, true, 0, 2, null);
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (R0() instanceof WelcomeFragment) {
            if (j1()) {
                finish();
            } else {
                WelcomeFragment.f16126g.a(this);
            }
        }
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_sign_in);
        d1(R$anim.anim_activity_nothing, Integer.valueOf(R$anim.anim_activity_top_to_bottom));
        k1();
    }
}
