package com.baidu.mobads.sdk.internal;

import android.webkit.WebView;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class ai implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JSONObject f9770a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ WebView f9771b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ae f9772c;

    public ai(ae aeVar, JSONObject jSONObject, WebView webView) {
        this.f9772c = aeVar;
        this.f9770a = jSONObject;
        this.f9771b = webView;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f9770a == null || this.f9771b == null) {
            return;
        }
        this.f9771b.loadUrl("javascript:window.sdkCallback.userInteractCb(\"" + this.f9770a.toString().replace("\"", "\\\"") + "\")");
    }
}
