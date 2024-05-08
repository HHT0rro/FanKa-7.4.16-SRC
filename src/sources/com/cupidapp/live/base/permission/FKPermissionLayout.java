package com.cupidapp.live.base.permission;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.cupidapp.live.R$drawable;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: FKPermissionLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKPermissionLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f12015b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKPermissionLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f12015b = new LinkedHashMap();
        f();
    }

    public static /* synthetic */ void setAlertText$default(FKPermissionLayout fKPermissionLayout, String str, String str2, String str3, String str4, String str5, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            str4 = null;
        }
        fKPermissionLayout.setAlertText(str, str2, str3, str4, str5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void setButtonClick$default(FKPermissionLayout fKPermissionLayout, Function0 function0, Function0 function02, Function0 function03, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            function0 = null;
        }
        if ((i10 & 2) != 0) {
            function02 = null;
        }
        if ((i10 & 4) != 0) {
            function03 = null;
        }
        fKPermissionLayout.setButtonClick(function0, function02, function03);
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f12015b;
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

    public final void b(Button button, PermissionType permissionType, boolean z10) {
        Context context = getContext();
        s.h(context, "context");
        if (RxPermissionHelperKt.h(context, permissionType)) {
            button.setClickable(false);
            button.setText(getContext().getString(R$string.authorize_app_permission_succeed));
            button.setTextColor(-5658199);
            button.setBackground(ResourcesCompat.getDrawable(getContext().getResources(), R$drawable.shape_gary_e_bg_twenty_corners, null));
            return;
        }
        button.setClickable(true);
        if (z10) {
            Context context2 = getContext();
            Context context3 = getContext();
            s.h(context3, "context");
            button.setText(context2.getString(R$string.authorize_app_permission_failed, RxPermissionHelperKt.f(context3, permissionType)));
            button.setTextColor(-14522);
            button.setBackground(ResourcesCompat.getDrawable(getContext().getResources(), R$drawable.shape_black_40_bg_twenty_corners, null));
            return;
        }
        Context context4 = getContext();
        Context context5 = getContext();
        s.h(context5, "context");
        button.setText(context4.getString(R$string.open_authorize_app_permission, RxPermissionHelperKt.f(context5, permissionType)));
        button.setTextColor(-1);
        button.setBackground(ResourcesCompat.getDrawable(getContext().getResources(), R$drawable.shape_red_bg_twenty_corners, null));
    }

    public final void c(@NotNull PermissionType firstPermission, @Nullable PermissionType permissionType, boolean z10) {
        s.i(firstPermission, "firstPermission");
        Button alertFirstButton = (Button) a(R$id.alertFirstButton);
        s.h(alertFirstButton, "alertFirstButton");
        b(alertFirstButton, firstPermission, z10);
        if (permissionType == null) {
            ((Button) a(R$id.alertSecondButton)).setVisibility(8);
            return;
        }
        int i10 = R$id.alertSecondButton;
        ((Button) a(i10)).setVisibility(0);
        Button alertSecondButton = (Button) a(i10);
        s.h(alertSecondButton, "alertSecondButton");
        b(alertSecondButton, permissionType, z10);
    }

    public final void d(@NotNull PermissionType firstPermission, @Nullable String str, boolean z10) {
        s.i(firstPermission, "firstPermission");
        Button alertFirstButton = (Button) a(R$id.alertFirstButton);
        s.h(alertFirstButton, "alertFirstButton");
        b(alertFirstButton, firstPermission, z10);
        if (str == null) {
            ((Button) a(R$id.alertSecondButton)).setVisibility(8);
            return;
        }
        int i10 = R$id.alertSecondButton;
        ((Button) a(i10)).setVisibility(0);
        ((Button) a(i10)).setText(str);
        ((Button) a(i10)).setTextColor(-1);
        ((Button) a(i10)).setBackground(ResourcesCompat.getDrawable(getContext().getResources(), R$drawable.shape_red_bg_twenty_corners, null));
    }

    public final void e() {
        int i10 = R$id.alertFirstButton;
        ((Button) a(i10)).setText(getContext().getString(R$string.go_to_open));
        ((Button) a(i10)).setBackground(ResourcesCompat.getDrawable(getContext().getResources(), R$drawable.shape_red_bg_twenty_corners, null));
        ((Button) a(R$id.alertSecondButton)).setVisibility(8);
        ((TextView) a(R$id.alertIgnoreButton)).setVisibility(8);
    }

    public final void f() {
        z.a(this, R$layout.layout_aloha_dialog, true);
    }

    public final void setAlertText(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        if (str != null) {
            ((TextView) a(R$id.alertTitle)).setText(str);
        }
        if (str2 != null) {
            ((TextView) a(R$id.alertContent)).setText(str2);
        }
        if (str4 != null) {
            int i10 = R$id.alertSecondButton;
            ((Button) a(i10)).setText(str4);
            ((Button) a(i10)).setVisibility(0);
        }
        ((Button) a(R$id.alertFirstButton)).setText(str3);
        if (str5 != null) {
            int i11 = R$id.alertIgnoreButton;
            ((TextView) a(i11)).setVisibility(0);
            ((TextView) a(i11)).setText(str5);
        }
    }

    public final void setButtonClick(@Nullable final Function0<p> function0, @Nullable final Function0<p> function02, @Nullable final Function0<p> function03) {
        Button alertFirstButton = (Button) a(R$id.alertFirstButton);
        s.h(alertFirstButton, "alertFirstButton");
        y.d(alertFirstButton, new Function1<View, p>() { // from class: com.cupidapp.live.base.permission.FKPermissionLayout$setButtonClick$1
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
                Function0<p> function04 = function0;
                if (function04 != null) {
                    function04.invoke();
                }
            }
        });
        Button alertSecondButton = (Button) a(R$id.alertSecondButton);
        s.h(alertSecondButton, "alertSecondButton");
        y.d(alertSecondButton, new Function1<View, p>() { // from class: com.cupidapp.live.base.permission.FKPermissionLayout$setButtonClick$2
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
                Function0<p> function04 = function02;
                if (function04 != null) {
                    function04.invoke();
                }
            }
        });
        TextView alertIgnoreButton = (TextView) a(R$id.alertIgnoreButton);
        s.h(alertIgnoreButton, "alertIgnoreButton");
        y.d(alertIgnoreButton, new Function1<View, p>() { // from class: com.cupidapp.live.base.permission.FKPermissionLayout$setButtonClick$3
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
                Function0<p> function04 = function03;
                if (function04 != null) {
                    function04.invoke();
                }
            }
        });
    }

    public final void setContentSpannableString(@Nullable SpannableStringBuilder spannableStringBuilder) {
        int i10 = R$id.alertContent;
        ((TextView) a(i10)).setMovementMethod(LinkMovementMethod.getInstance());
        ((TextView) a(i10)).setText(spannableStringBuilder);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKPermissionLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f12015b = new LinkedHashMap();
        f();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKPermissionLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f12015b = new LinkedHashMap();
        f();
    }
}
