package com.cupidapp.live.match.view;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.permission.PermissionType;
import com.cupidapp.live.base.permission.RxPermissionHelperKt;
import com.cupidapp.live.base.utils.LocationUtils;
import com.cupidapp.live.base.view.button.FKUniversalButton;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKNearByPermissionRequestLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKNearByPermissionRequestLayout extends FrameLayout {

    /* renamed from: b */
    @NotNull
    public Map<Integer, View> f16858b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKNearByPermissionRequestLayout(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.f16858b = new LinkedHashMap();
        g();
    }

    public static /* synthetic */ void c(FKNearByPermissionRequestLayout fKNearByPermissionRequestLayout, String str, String str2, PermissionType permissionType, boolean z10, xb.b bVar, boolean z11, int i10, int i11, Object obj) {
        fKNearByPermissionRequestLayout.b(str, str2, permissionType, (i11 & 8) != 0 ? false : z10, bVar, (i11 & 32) != 0 ? true : z11, (i11 & 64) != 0 ? R$mipmap.icon_location_failed : i10);
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f16858b;
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

    public final void b(@NotNull String title, @NotNull String description, @NotNull PermissionType permissionType, boolean z10, @NotNull xb.b rxPermissions, boolean z11, int i10) {
        kotlin.jvm.internal.s.i(title, "title");
        kotlin.jvm.internal.s.i(description, "description");
        kotlin.jvm.internal.s.i(permissionType, "permissionType");
        kotlin.jvm.internal.s.i(rxPermissions, "rxPermissions");
        int i11 = -15066598;
        int i12 = -1;
        if (z11) {
            i11 = -1;
            i12 = -15066598;
        }
        int i13 = R$id.nearby_permission_title_text;
        TextView nearby_permission_title_text = (TextView) a(i13);
        kotlin.jvm.internal.s.h(nearby_permission_title_text, "nearby_permission_title_text");
        z0.u.a(nearby_permission_title_text);
        ((TextView) a(i13)).setTextColor(i11);
        ((ImageView) a(R$id.permission_img)).setImageResource(i10);
        ((ConstraintLayout) a(R$id.permission_root)).setBackgroundColor(i12);
        ((TextView) a(i13)).setText(title);
        ((TextView) a(R$id.nearby_permission_description_text)).setText(description);
        int i14 = R$id.nearby_permission_btn_layout;
        ((LinearLayout) a(i14)).removeAllViews();
        ((LinearLayout) a(i14)).addView(f(permissionType, rxPermissions, i12));
        if (z10) {
            ((LinearLayout) a(i14)).addView(e(i12));
        }
    }

    public final FKUniversalButton d(boolean z10, String str, int i10) {
        Context context = getContext();
        kotlin.jvm.internal.s.h(context, "context");
        FKUniversalButton fKUniversalButton = new FKUniversalButton(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = z0.h.c(layoutParams, 16.0f);
        fKUniversalButton.setLayoutParams(layoutParams);
        if (z10) {
            fKUniversalButton.setEnabled(true);
            fKUniversalButton.setBackground(fKUniversalButton.b(i10, 100, 1, -49088));
            fKUniversalButton.setTextColor(-49088);
        } else {
            fKUniversalButton.setEnabled(false);
            fKUniversalButton.setBackground(fKUniversalButton.b(i10, 100, 1, -8618884));
            fKUniversalButton.setTextColor(-8618884);
        }
        fKUniversalButton.setText(str);
        return fKUniversalButton;
    }

    public final FKUniversalButton e(int i10) {
        if (LocationUtils.f12270h.b(getContext())) {
            String string = getContext().getString(R$string.authorize_app_permission_succeed);
            kotlin.jvm.internal.s.h(string, "context.getString(R.stri…e_app_permission_succeed)");
            return d(false, string, i10);
        }
        String string2 = getContext().getString(R$string.open_the_location_service);
        kotlin.jvm.internal.s.h(string2, "context.getString(R.stri…pen_the_location_service)");
        final FKUniversalButton d10 = d(true, string2, i10);
        z0.y.d(d10, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.view.FKNearByPermissionRequestLayout$createLocationServiceButton$1$1
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
                FKUniversalButton.this.getContext().startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
            }
        });
        return d10;
    }

    public final FKUniversalButton f(final PermissionType permissionType, final xb.b bVar, int i10) {
        Context context = getContext();
        kotlin.jvm.internal.s.h(context, "context");
        if (RxPermissionHelperKt.h(context, permissionType)) {
            String string = getContext().getString(R$string.authorize_app_permission_succeed);
            kotlin.jvm.internal.s.h(string, "context.getString(R.stri…e_app_permission_succeed)");
            return d(false, string, i10);
        }
        Context context2 = getContext();
        Context context3 = getContext();
        kotlin.jvm.internal.s.h(context3, "context");
        String string2 = context2.getString(R$string.open_authorize_app_permission, RxPermissionHelperKt.f(context3, permissionType));
        kotlin.jvm.internal.s.h(string2, "context.getString(\n     …onType)\n                )");
        final FKUniversalButton d10 = d(true, string2, i10);
        z0.y.d(d10, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.view.FKNearByPermissionRequestLayout$createPermissionButton$1$1
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
                Context context4 = FKUniversalButton.this.getContext();
                kotlin.jvm.internal.s.h(context4, "context");
                RxPermissionHelperKt.m(context4, bVar, kotlin.collections.r.e(permissionType), null, false, 24, null);
            }
        });
        return d10;
    }

    public final void g() {
        z0.z.a(this, R$layout.layout_nearby_permission_request_layout, true);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKNearByPermissionRequestLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.i(context, "context");
        this.f16858b = new LinkedHashMap();
        g();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKNearByPermissionRequestLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.s.i(context, "context");
        this.f16858b = new LinkedHashMap();
        g();
    }
}
