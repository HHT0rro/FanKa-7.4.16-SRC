package com.cupidapp.live.liveshow.view;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.permission.PermissionType;
import com.cupidapp.live.base.permission.RxPermissionHelperKt;
import com.cupidapp.live.base.utils.LocationUtils;
import com.cupidapp.live.base.view.button.FKUniversalButton;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.r;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: PermissionRequestLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class PermissionRequestLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15311b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PermissionRequestLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15311b = new LinkedHashMap();
        f();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f15311b;
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

    public final void b(@NotNull String title, @NotNull String description, @NotNull PermissionType permissionType, boolean z10, @NotNull xb.b rxPermissions) {
        s.i(title, "title");
        s.i(description, "description");
        s.i(permissionType, "permissionType");
        s.i(rxPermissions, "rxPermissions");
        ((TextView) a(R$id.permissionTitle)).setText(title);
        ((TextView) a(R$id.permissionDescription)).setText(description);
        int i10 = R$id.permissionsLayout;
        ((LinearLayout) a(i10)).removeAllViews();
        ((LinearLayout) a(i10)).addView(e(permissionType, rxPermissions));
        if (z10) {
            ((LinearLayout) a(i10)).addView(d());
        }
    }

    public final FKUniversalButton c(boolean z10, String str) {
        Context context = getContext();
        s.h(context, "context");
        FKUniversalButton fKUniversalButton = new FKUniversalButton(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = z0.h.c(layoutParams, 10.0f);
        fKUniversalButton.setLayoutParams(layoutParams);
        fKUniversalButton.a(z10);
        fKUniversalButton.setText(str);
        return fKUniversalButton;
    }

    public final FKUniversalButton d() {
        if (LocationUtils.f12270h.b(getContext())) {
            String string = getContext().getString(R$string.authorize_app_permission_succeed);
            s.h(string, "context.getString(R.stri…e_app_permission_succeed)");
            return c(false, string);
        }
        String string2 = getContext().getString(R$string.open_the_location_service);
        s.h(string2, "context.getString(R.stri…pen_the_location_service)");
        final FKUniversalButton c4 = c(true, string2);
        y.d(c4, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.PermissionRequestLayout$createLocationServiceButton$1$1
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
                FKUniversalButton.this.getContext().startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
            }
        });
        return c4;
    }

    public final FKUniversalButton e(final PermissionType permissionType, final xb.b bVar) {
        Context context = getContext();
        s.h(context, "context");
        if (RxPermissionHelperKt.h(context, permissionType)) {
            String string = getContext().getString(R$string.authorize_app_permission_succeed);
            s.h(string, "context.getString(R.stri…e_app_permission_succeed)");
            return c(false, string);
        }
        Context context2 = getContext();
        Context context3 = getContext();
        s.h(context3, "context");
        String string2 = context2.getString(R$string.open_authorize_app_permission, RxPermissionHelperKt.f(context3, permissionType));
        s.h(string2, "context.getString(\n     …onType)\n                )");
        final FKUniversalButton c4 = c(true, string2);
        y.d(c4, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.PermissionRequestLayout$createPermissionButton$1$1
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
                Context context4 = FKUniversalButton.this.getContext();
                s.h(context4, "context");
                RxPermissionHelperKt.m(context4, bVar, r.e(permissionType), null, false, 24, null);
            }
        });
        return c4;
    }

    public final void f() {
        z.a(this, R$layout.layout_permission_request, true);
        ((TextView) a(R$id.permissionTitle)).getPaint().setFakeBoldText(true);
        ((TextView) a(R$id.permissionDescription)).getPaint().setFakeBoldText(true);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PermissionRequestLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15311b = new LinkedHashMap();
        f();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PermissionRequestLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15311b = new LinkedHashMap();
        f();
    }
}
