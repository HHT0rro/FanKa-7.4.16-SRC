package com.cupidapp.live.setting.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.setting.activity.BindPhoneActivity;
import com.cupidapp.live.setting.activity.CheckPasswordActivity;
import com.cupidapp.live.setting.fragment.CheckPasswordFragment;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CheckPasswordActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class CheckPasswordActivity extends FKBaseActivity {

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public static final a f17941r = new a(null);

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17942q = new LinkedHashMap();

    /* compiled from: CheckPasswordActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context) {
            kotlin.jvm.internal.s.i(context, "context");
            context.startActivity(new Intent(context, (Class<?>) CheckPasswordActivity.class));
            FKBaseActivity.a.c(FKBaseActivity.f11750o, context, 0, 0, 6, null);
        }
    }

    /* compiled from: CheckPasswordActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b extends CheckPasswordFragment.a {
        public b() {
        }

        public static final void e(CheckPasswordActivity this$0) {
            kotlin.jvm.internal.s.i(this$0, "this$0");
            this$0.finish();
        }

        @Override // com.cupidapp.live.setting.fragment.CheckPasswordFragment.a
        public void a() {
            CheckPasswordActivity.this.finish();
        }

        @Override // com.cupidapp.live.setting.fragment.CheckPasswordFragment.a
        public void c() {
            BindPhoneActivity.a.b(BindPhoneActivity.f17923t, CheckPasswordActivity.this, false, 2, null);
            FrameLayout frameLayout = (FrameLayout) CheckPasswordActivity.this.j1(R$id.fragmentContainerLayout);
            final CheckPasswordActivity checkPasswordActivity = CheckPasswordActivity.this;
            frameLayout.postDelayed(new Runnable() { // from class: com.cupidapp.live.setting.activity.b
                @Override // java.lang.Runnable
                public final void run() {
                    CheckPasswordActivity.b.e(CheckPasswordActivity.this);
                }
            }, 300L);
        }
    }

    @Nullable
    public View j1(int i10) {
        Map<Integer, View> map = this.f17942q;
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

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_check_password);
        j1.c.b(j1.c.f50228a, SensorPosition.ChangePasswordVerify, null, null, 6, null);
        CheckPasswordFragment.b bVar = CheckPasswordFragment.f18105h;
        String string = getString(R$string.modify_phone_number);
        kotlin.jvm.internal.s.h(string, "getString(R.string.modify_phone_number)");
        getSupportFragmentManager().beginTransaction().replace(R$id.fragmentContainerLayout, bVar.a(string, new b())).commit();
    }
}
