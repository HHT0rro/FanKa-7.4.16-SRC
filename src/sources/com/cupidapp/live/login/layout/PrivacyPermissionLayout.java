package com.cupidapp.live.login.layout;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.R$style;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.utils.h0;
import com.cupidapp.live.base.view.button.FKUniversalButton;
import com.cupidapp.live.base.view.dialog.FKBottomLoft;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: PrivacyPermissionLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class PrivacyPermissionLayout extends FrameLayout {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final a f16177e = new a(null);

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public static final String f16178f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public static final String f16179g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public static final String f16180h;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public static final List<String> f16181i;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public Function1<? super Boolean, p> f16182b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public AlertDialog f16183c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16184d;

    /* compiled from: PrivacyPermissionLayout.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final List<String> a() {
            return PrivacyPermissionLayout.f16181i;
        }
    }

    /* compiled from: PrivacyPermissionLayout.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b extends h0 {

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f16186c;

        public b(int i10) {
            this.f16186c = i10;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View widget) {
            s.i(widget, "widget");
            j.a.b(j.f12156c, PrivacyPermissionLayout.this.getContext(), PrivacyPermissionLayout.f16177e.a().get(this.f16186c), null, 4, null);
        }
    }

    static {
        NetworkClient networkClient = NetworkClient.f11868a;
        String str = networkClient.O() + "/doc/tos/finka202004";
        f16178f = str;
        String str2 = networkClient.O() + "/doc/privacy/finka202006/android";
        f16179g = str2;
        String str3 = networkClient.O() + "/doc/privacy-summary";
        f16180h = str3;
        f16181i = kotlin.collections.s.m(str, str2, str3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PrivacyPermissionLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f16184d = new LinkedHashMap();
        f();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f16184d;
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

    public final void f() {
        SpannableStringBuilder c4;
        SpannableStringBuilder append;
        z.a(this, R$layout.layout_privacy_permission, true);
        ((TextView) a(R$id.privacy_title_textview)).getPaint().setFakeBoldText(true);
        if (Build.VERSION.SDK_INT >= 28) {
            ((TextView) a(R$id.privacy_content_textview)).setTypeface(Typeface.create(Typeface.DEFAULT, 300, false));
        }
        ArrayList arrayList = new ArrayList();
        List o10 = kotlin.collections.s.o(getContext().getString(R$string.user_agreement), getContext().getString(R$string.privacy_policy), getContext().getString(R$string.privacy_policy_summary));
        int size = o10.size();
        for (int i10 = 0; i10 < size; i10++) {
            arrayList.add(new b(i10));
        }
        q1.d dVar = q1.d.f53006a;
        String string = getContext().getString(R$string.user_permission_agreement_content);
        s.h(string, "context.getString(R.stri…ission_agreement_content)");
        c4 = dVar.c(string, o10, (r18 & 4) != 0 ? null : -8618884, (r18 & 8) != 0 ? null : -1, (r18 & 16) != 0 ? false : true, (r18 & 32) != 0 ? null : arrayList, (r18 & 64) != 0 ? null : null);
        String string2 = getContext().getString(R$string.user_permission_agreement_description);
        s.h(string2, "context.getString(R.stri…on_agreement_description)");
        SpannableStringBuilder h10 = dVar.h(string2, kotlin.collections.s.m(getContext().getString(R$string.storage_permission), getContext().getString(R$string.phone_permission), getContext().getString(R$string.location_permission), getContext().getString(R$string.audio_permission), getContext().getString(R$string.camera_permission)), -8618884, -1, true);
        int i11 = R$id.privacy_content_textview;
        ((TextView) a(i11)).setText((c4 == null || (append = c4.append((CharSequence) "\n")) == null) ? null : append.append((CharSequence) h10));
        ((TextView) a(i11)).setMovementMethod(LinkMovementMethod.getInstance());
        FKUniversalButton agree_privacy_button = (FKUniversalButton) a(R$id.agree_privacy_button);
        s.h(agree_privacy_button, "agree_privacy_button");
        y.d(agree_privacy_button, new Function1<View, p>() { // from class: com.cupidapp.live.login.layout.PrivacyPermissionLayout$initView$2
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
                AlertDialog alertDialog;
                Function1 function1;
                alertDialog = PrivacyPermissionLayout.this.f16183c;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
                function1 = PrivacyPermissionLayout.this.f16182b;
                if (function1 != null) {
                    function1.invoke(Boolean.TRUE);
                }
            }
        });
        FKUniversalButton disagree_privacy_button = (FKUniversalButton) a(R$id.disagree_privacy_button);
        s.h(disagree_privacy_button, "disagree_privacy_button");
        y.d(disagree_privacy_button, new Function1<View, p>() { // from class: com.cupidapp.live.login.layout.PrivacyPermissionLayout$initView$3
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
                AlertDialog alertDialog;
                alertDialog = PrivacyPermissionLayout.this.f16183c;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
                PrivacyPermissionLayout.this.g();
            }
        });
    }

    public final void g() {
        FKBottomLoft.f12709e.a(getContext()).m(R$string.disagree_use_tips).e(R$string.disagree_use_tips_content, -8618884, 300).k(R$string.agree_terms, new Function0<p>() { // from class: com.cupidapp.live.login.layout.PrivacyPermissionLayout$showConfirmDialog$1
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
                Function1 function1;
                function1 = PrivacyPermissionLayout.this.f16182b;
                if (function1 != null) {
                    function1.invoke(Boolean.TRUE);
                }
            }
        }).i(R$string.disagree_and_exit, new Function0<p>() { // from class: com.cupidapp.live.login.layout.PrivacyPermissionLayout$showConfirmDialog$2
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
                Function1 function1;
                function1 = PrivacyPermissionLayout.this.f16182b;
                if (function1 != null) {
                    function1.invoke(Boolean.FALSE);
                }
            }
        }).d(false).n();
    }

    public final void h(@NotNull Function1<? super Boolean, p> agreeCallback) {
        Window window;
        s.i(agreeCallback, "agreeCallback");
        this.f16182b = agreeCallback;
        AlertDialog create = z0.b.f54812a.e(getContext()).setView(this).create();
        this.f16183c = create;
        if (create != null) {
            create.setCanceledOnTouchOutside(false);
        }
        AlertDialog alertDialog = this.f16183c;
        if (alertDialog != null) {
            alertDialog.show();
        }
        AlertDialog alertDialog2 = this.f16183c;
        if (alertDialog2 == null || (window = alertDialog2.getWindow()) == null) {
            return;
        }
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setWindowAnimations(R$style.dialog_translate_anim);
        window.setLayout(-1, -2);
        window.setGravity(80);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PrivacyPermissionLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f16184d = new LinkedHashMap();
        f();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PrivacyPermissionLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f16184d = new LinkedHashMap();
        f();
    }
}
