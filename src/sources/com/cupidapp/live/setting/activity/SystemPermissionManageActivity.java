package com.cupidapp.live.setting.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.view.FKItemLayout;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.base.view.button.FKUniversalButton;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SystemPermissionManageActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class SystemPermissionManageActivity extends FKBaseActivity {

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public static final a f18019r = new a(null);

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f18020q = new LinkedHashMap();

    /* compiled from: SystemPermissionManageActivity.kt */
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
            context.startActivity(new Intent(context, (Class<?>) SystemPermissionManageActivity.class));
            FKBaseActivity.a.c(FKBaseActivity.f11750o, context, 0, 0, 6, null);
        }
    }

    @Nullable
    public View j1(int i10) {
        Map<Integer, View> map = this.f18020q;
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

    public final void k1() {
        ((FKTitleBarLayout) j1(R$id.system_permission_manage_title)).setLeftImageClickEvent(new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.SystemPermissionManageActivity$bindClickEvent$1
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
                SystemPermissionManageActivity.this.onBackPressed();
            }
        });
        FKUniversalButton go_to_system_permission_setting_btn = (FKUniversalButton) j1(R$id.go_to_system_permission_setting_btn);
        kotlin.jvm.internal.s.h(go_to_system_permission_setting_btn, "go_to_system_permission_setting_btn");
        z0.y.d(go_to_system_permission_setting_btn, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.SystemPermissionManageActivity$bindClickEvent$2
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
                z0.h.o(SystemPermissionManageActivity.this);
            }
        });
    }

    public final void l1() {
        if (z0.h.b(this, com.kuaishou.weapon.p0.g.f36117c)) {
            ((FKItemLayout) j1(R$id.phone_permission_layout)).setVisibility(0);
        } else {
            ((FKItemLayout) j1(R$id.phone_permission_layout)).setVisibility(8);
        }
        if (z0.h.b(this, com.kuaishou.weapon.p0.g.f36122h) && z0.h.b(this, com.kuaishou.weapon.p0.g.f36121g)) {
            ((FKItemLayout) j1(R$id.location_permission_layout)).setVisibility(0);
        } else {
            ((FKItemLayout) j1(R$id.location_permission_layout)).setVisibility(8);
        }
        if (z0.h.b(this, com.kuaishou.weapon.p0.g.f36124j) && z0.h.b(this, com.kuaishou.weapon.p0.g.f36123i)) {
            ((FKItemLayout) j1(R$id.storage_permission_layout)).setVisibility(0);
        } else {
            ((FKItemLayout) j1(R$id.storage_permission_layout)).setVisibility(8);
        }
        if (z0.h.b(this, "android.permission.RECORD_AUDIO")) {
            ((FKItemLayout) j1(R$id.microphone_permission_layout)).setVisibility(0);
        } else {
            ((FKItemLayout) j1(R$id.microphone_permission_layout)).setVisibility(8);
        }
        if (z0.h.b(this, "android.permission.CAMERA")) {
            ((FKItemLayout) j1(R$id.camera_permission_layout)).setVisibility(0);
        } else {
            ((FKItemLayout) j1(R$id.camera_permission_layout)).setVisibility(8);
        }
        if (Build.VERSION.SDK_INT >= 23 && !Settings.canDrawOverlays(this)) {
            ((FKItemLayout) j1(R$id.floating_window_permission_layout)).setVisibility(8);
        } else {
            ((FKItemLayout) j1(R$id.floating_window_permission_layout)).setVisibility(0);
        }
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_system_permission_manage);
        k1();
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        l1();
    }
}
