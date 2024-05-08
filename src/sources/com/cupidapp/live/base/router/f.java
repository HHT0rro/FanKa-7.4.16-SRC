package com.cupidapp.live.base.router;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.Toast;
import com.alibaba.security.realidentity.RPEventListener;
import com.alibaba.security.realidentity.RPResult;
import com.alibaba.security.realidentity.RPVerify;
import com.cupidapp.live.R$id;
import com.cupidapp.live.base.web.FKWebView;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AliyunCloudAuth.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class f implements h {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final a f12125b = new a(null);

    /* compiled from: AliyunCloudAuth.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context) {
            s.i(context, "context");
            RPVerify.init(context);
        }
    }

    /* compiled from: AliyunCloudAuth.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class b extends RPEventListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f12126a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FKWebView f12127b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f12128c;

        /* compiled from: AliyunCloudAuth.kt */
        @kotlin.d
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
        public /* synthetic */ class a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f12129a;

            static {
                int[] iArr = new int[RPResult.values().length];
                try {
                    iArr[RPResult.AUDIT_PASS.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[RPResult.AUDIT_FAIL.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[RPResult.AUDIT_NOT.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                f12129a = iArr;
            }
        }

        public b(Context context, FKWebView fKWebView, String str) {
            this.f12126a = context;
            this.f12127b = fKWebView;
            this.f12128c = str;
        }

        @Override // com.alibaba.security.realidentity.RPEventListener
        public void onFinish(@Nullable RPResult rPResult, @Nullable String str, @Nullable String str2) {
            if (rPResult != RPResult.AUDIT_PASS) {
                if (str == null || str.length() == 0) {
                    str = String.valueOf(rPResult != null ? Integer.valueOf(rPResult.code) : null);
                }
                if (str2 == null || str2.length() == 0) {
                    str2 = rPResult != null ? rPResult.message : null;
                }
                Toast.makeText(this.f12126a, "code:" + str + " message: " + str2, 0).show();
            }
            if ((rPResult == null ? -1 : a.f12129a[rPResult.ordinal()]) != 1) {
                return;
            }
            this.f12127b.u(this.f12128c);
        }

        @Override // com.alibaba.security.realidentity.RPEventListener
        public void onStart() {
            this.f12127b.onActivityResume();
        }
    }

    @Override // com.cupidapp.live.base.router.h
    public void a(@Nullable Context context, @NotNull Uri uri, @Nullable String str) {
        s.i(uri, "uri");
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity == null) {
            return;
        }
        String queryParameter = uri.getQueryParameter("url");
        String queryParameter2 = uri.getQueryParameter("token");
        View findViewById = activity.findViewById(R$id.appWebView);
        s.h(findViewById, "activity.findViewById(R.id.appWebView)");
        FKWebView fKWebView = (FKWebView) findViewById;
        boolean z10 = true;
        if (queryParameter == null || queryParameter.length() == 0) {
            return;
        }
        if (queryParameter2 != null && queryParameter2.length() != 0) {
            z10 = false;
        }
        if (z10) {
            return;
        }
        String uri2 = uri.toString();
        s.h(uri2, "uri.toString()");
        if (StringsKt__StringsKt.K(uri2, "cloudauth", false, 2, null)) {
            RPVerify.start(context, queryParameter2, new b(context, fKWebView, queryParameter));
        }
    }
}
