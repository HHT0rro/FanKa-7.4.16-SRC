package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.view.View;
import android.webkit.WebView;
import com.baidu.mobads.sdk.api.NativeCPUManager;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
class ah implements NativeCPUManager.DataPostBackListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f9768a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ae f9769b;

    public ah(ae aeVar, Object obj) {
        this.f9769b = aeVar;
        this.f9768a = obj;
    }

    @Override // com.baidu.mobads.sdk.api.NativeCPUManager.DataPostBackListener
    public void postback(JSONObject jSONObject) {
        Object obj = this.f9768a;
        if (obj instanceof Activity) {
            View findViewById = ((Activity) obj).findViewById(17);
            if (findViewById instanceof WebView) {
                this.f9769b.a((WebView) findViewById, jSONObject);
            }
        }
    }
}
