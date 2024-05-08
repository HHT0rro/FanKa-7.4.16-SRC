package com.cupidapp.live.base.web.bridge;

import android.app.Activity;
import com.cupidapp.live.R$id;
import com.cupidapp.live.base.web.FKWebView;
import com.huawei.openalliance.ad.constant.as;
import com.tencent.connect.common.Constants;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: FKNativeCallH5Helper.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f13062a = new b();

    public final void a(@NotNull FKWebView webView, boolean z10, @Nullable String str) {
        s.i(webView, "webView");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("event", "checkCallback");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("success", z10);
            jSONObject2.put("errJson", str);
            jSONObject.put("params", jSONObject2);
            webView.x(jSONObject.toString());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final FKWebView b(Activity activity) {
        if (activity != null) {
            return (FKWebView) activity.findViewById(R$id.appWebView);
        }
        return null;
    }

    public final void c(@NotNull Activity activity, double d10, double d11) {
        s.i(activity, "activity");
        FKWebView b4 = b(activity);
        if (b4 == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("event", "locationSuccessCallback");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(as.au, d10);
            jSONObject2.put(as.at, d11);
            jSONObject.put("params", jSONObject2);
            b4.x(jSONObject.toString());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void d(@NotNull Activity activity, @Nullable String str, @Nullable Map<String, String> map) {
        FKWebView b4;
        s.i(activity, "activity");
        boolean z10 = false;
        if ((str == null || str.length() == 0) || (b4 = b(activity)) == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("event", str);
            if (map != null && (!map.isEmpty())) {
                z10 = true;
            }
            if (z10) {
                JSONObject jSONObject2 = new JSONObject();
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    jSONObject2.put(entry.getKey(), entry.getValue());
                }
                jSONObject.put("params", jSONObject2);
            }
            b4.x(jSONObject.toString());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void e(@NotNull FKWebView webView, boolean z10) {
        s.i(webView, "webView");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("event", "frontAndBackSwitch");
            jSONObject.put("params", z10);
            webView.x(jSONObject.toString());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void f(@NotNull FKWebView webView, @NotNull String lifeCycleState) {
        s.i(webView, "webView");
        s.i(lifeCycleState, "lifeCycleState");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("event", "lifeCycleEvent");
            jSONObject.put("params", lifeCycleState);
            webView.x(jSONObject.toString());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void g(@NotNull FKWebView webView, @Nullable String str) {
        s.i(webView, "webView");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("event", "shareClick");
            jSONObject.put("params", str);
            webView.x(jSONObject.toString());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void h(@NotNull FKWebView webView, @Nullable String str, boolean z10) {
        s.i(webView, "webView");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("event", "shareResult");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(Constants.PARAM_PLATFORM, str);
            jSONObject2.put("result", z10);
            jSONObject.put("params", jSONObject2);
            webView.x(jSONObject.toString());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void i(@NotNull FKWebView webView) {
        s.i(webView, "webView");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("event", "reloadData");
            webView.x(jSONObject.toString());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void j(@NotNull FKWebView webView, int i10, @Nullable String str) {
        s.i(webView, "webView");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("event", "vipBuyStateHandler");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("code", i10);
            jSONObject2.put("message", str);
            jSONObject.put("params", jSONObject2);
            webView.x(jSONObject.toString());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
