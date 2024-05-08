package com.cupidapp.live.scan.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import com.cupidapp.live.R$anim;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.permission.FKRxPermissionAlertDialog;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.utils.j;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.base.view.animation.FKLottieAnimationView;
import com.cupidapp.live.base.web.helper.WebUrlWhiteListHelper;
import com.huawei.hms.hmsscankit.OnResultCallback;
import com.huawei.hms.hmsscankit.RemoteView;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.ml.scan.HmsScanBase;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.c;
import kotlin.collections.m;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xb.b;

/* compiled from: ScanCodeActivity.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ScanCodeActivity extends FKBaseActivity {

    /* renamed from: u, reason: collision with root package name */
    @NotNull
    public static final a f17907u = new a(null);

    /* renamed from: v, reason: collision with root package name */
    @Nullable
    public static Function1<? super String, p> f17908v;

    /* renamed from: r, reason: collision with root package name */
    @Nullable
    public RemoteView f17910r;

    /* renamed from: s, reason: collision with root package name */
    @Nullable
    public String f17911s;

    /* renamed from: t, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17912t = new LinkedHashMap();

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public final Lazy f17909q = c.b(new Function0<b>() { // from class: com.cupidapp.live.scan.activity.ScanCodeActivity$mRxPermissions$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final b invoke() {
            return new b(ScanCodeActivity.this);
        }
    });

    /* compiled from: ScanCodeActivity.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void c(a aVar, Context context, Function1 function1, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                function1 = null;
            }
            aVar.b(context, function1);
        }

        public final void a(@Nullable Function1<? super String, p> function1) {
            ScanCodeActivity.f17908v = function1;
        }

        public final void b(@Nullable Context context, @Nullable Function1<? super String, p> function1) {
            if (context == null) {
                return;
            }
            context.startActivity(new Intent(context, (Class<?>) ScanCodeActivity.class));
            FKBaseActivity.f11750o.b(context, R$anim.alpha_in, R$anim.anim_activity_nothing);
            a(function1);
        }
    }

    public static final void o1(ScanCodeActivity this$0, HmsScan[] hmsScanArr) {
        s.i(this$0, "this$0");
        this$0.q1(hmsScanArr != null ? (HmsScan) m.B(hmsScanArr, 0) : null);
    }

    @Nullable
    public View k1(int i10) {
        Map<Integer, View> map = this.f17912t;
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

    public final void n1(Bundle bundle) {
        ((FKLottieAnimationView) k1(R$id.scan_ray_of_light_lottie_view)).L();
        RemoteView build = new RemoteView.Builder().setContext(this).setBoundingBox(null).setFormat(HmsScanBase.ALL_SCAN_TYPE, new int[0]).build();
        this.f17910r = build;
        build.setOnResultCallback(new OnResultCallback() { // from class: com.cupidapp.live.scan.activity.a
            @Override // com.huawei.hms.hmsscankit.OnResultCallback
            public final void onResult(HmsScan[] hmsScanArr) {
                ScanCodeActivity.o1(ScanCodeActivity.this, hmsScanArr);
            }
        });
        build.onCreate(bundle);
        ((FrameLayout) k1(R$id.scan_code_remote_view)).addView(build, new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable final Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_scan_code);
        d1(R$anim.anim_activity_nothing, Integer.valueOf(R$anim.alpha_out));
        FKRxPermissionAlertDialog.f12016a.k(this, p1(), new Function0<p>() { // from class: com.cupidapp.live.scan.activity.ScanCodeActivity$onCreate$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                ScanCodeActivity.this.n1(bundle);
            }
        }, new Function0<p>() { // from class: com.cupidapp.live.scan.activity.ScanCodeActivity$onCreate$2
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
                ScanCodeActivity.this.onBackPressed();
            }
        }, new Function0<p>() { // from class: com.cupidapp.live.scan.activity.ScanCodeActivity$onCreate$3
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
                ScanCodeActivity.this.onBackPressed();
            }
        }, new Function0<p>() { // from class: com.cupidapp.live.scan.activity.ScanCodeActivity$onCreate$4
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
                ScanCodeActivity.this.onBackPressed();
            }
        }, new Function0<p>() { // from class: com.cupidapp.live.scan.activity.ScanCodeActivity$onCreate$5
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
                ScanCodeActivity.this.onBackPressed();
            }
        });
        ((FKTitleBarLayout) k1(R$id.scan_code_title_bar)).setLeftImageClickEvent(new Function1<View, p>() { // from class: com.cupidapp.live.scan.activity.ScanCodeActivity$onCreate$6
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
                ScanCodeActivity.this.onBackPressed();
            }
        });
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        RemoteView remoteView = this.f17910r;
        if (remoteView != null) {
            remoteView.onDestroy();
        }
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        RemoteView remoteView = this.f17910r;
        if (remoteView != null) {
            remoteView.onPause();
        }
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f17911s = null;
        RemoteView remoteView = this.f17910r;
        if (remoteView != null) {
            remoteView.onResume();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        RemoteView remoteView = this.f17910r;
        if (remoteView != null) {
            remoteView.onStart();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        RemoteView remoteView = this.f17910r;
        if (remoteView != null) {
            remoteView.onStop();
        }
    }

    public final b p1() {
        return (b) this.f17909q.getValue();
    }

    public final void q1(HmsScan hmsScan) {
        if (hmsScan == null) {
            Function1<? super String, p> function1 = f17908v;
            if (function1 != null) {
                function1.invoke(null);
            }
            j.f12332a.a("ScanCodeActivity", "ScanCode hmsScan == null");
            return;
        }
        String result = hmsScan.getOriginalValue();
        if (s.d(result, this.f17911s)) {
            Function1<? super String, p> function12 = f17908v;
            if (function12 != null) {
                function12.invoke(null);
            }
            j.f12332a.a("ScanCodeActivity", "result == mResultStr 原始码值：" + this.f17911s);
            return;
        }
        this.f17911s = result;
        boolean z10 = false;
        if (result == null || result.length() == 0) {
            Function1<? super String, p> function13 = f17908v;
            if (function13 != null) {
                function13.invoke(null);
            }
            j.f12332a.a("ScanCodeActivity", "原始码值为空");
            return;
        }
        j.a aVar = j.f12332a;
        aVar.a("ScanCodeActivity", "原始码值：" + result);
        aVar.a("ScanCodeActivity", "码制式：" + hmsScan.getScanType());
        aVar.a("ScanCodeActivity", "结构化数据：" + hmsScan.getScanTypeForm());
        aVar.a("ScanCodeActivity", "码在图片中的位置：" + ((Object) hmsScan.getBorderRect()));
        if (f17908v == null) {
            s.h(result, "result");
            if ((kotlin.text.p.D(result, "https://", true) || kotlin.text.p.D(result, "http://", true)) && WebUrlWhiteListHelper.f13094a.d(result)) {
                z10 = true;
            }
            boolean D = kotlin.text.p.D(result, "finka2020://", true);
            if (!z10 && !D) {
                ScanCodeOtherResultActivity.f17913r.a(this, result);
            } else {
                j.a.b(com.cupidapp.live.base.router.j.f12156c, this, result, null, 4, null);
            }
            finish();
            return;
        }
        finish();
        Function1<? super String, p> function14 = f17908v;
        if (function14 != null) {
            function14.invoke(result);
        }
    }
}
