package com.huawei.hianalytics.framework;

import com.huawei.hianalytics.framework.config.ICallback;
import com.huawei.hianalytics.framework.session.SessionHandler;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class a implements HAFrameworkInstance {

    /* renamed from: a, reason: collision with root package name */
    public String f28759a;

    public a(String str) {
        this.f28759a = str;
    }

    @Override // com.huawei.hianalytics.framework.HAFrameworkInstance
    public void clearCacheDataAll() {
        e.a().a(this.f28759a);
    }

    @Override // com.huawei.hianalytics.framework.HAFrameworkInstance
    public void clearCacheDataByTag() {
        e.a().a(this.f28759a);
    }

    @Override // com.huawei.hianalytics.framework.HAFrameworkInstance
    public void clearCacheDataByTagType(String str) {
        e.a().a(this.f28759a, str);
    }

    @Override // com.huawei.hianalytics.framework.HAFrameworkInstance
    public void onBackground(long j10) {
        SessionHandler.getInstance().onBackground(this.f28759a, j10);
    }

    @Override // com.huawei.hianalytics.framework.HAFrameworkInstance
    public void onEvent(String str, String str2, JSONObject jSONObject, ICallback iCallback) {
        e.a().a(this.f28759a, str, str2, jSONObject, iCallback);
    }

    @Override // com.huawei.hianalytics.framework.HAFrameworkInstance
    public void onForeground(long j10) {
        SessionHandler.getInstance().onForeground(this.f28759a, j10);
    }

    @Override // com.huawei.hianalytics.framework.HAFrameworkInstance
    public void onReport(String str, ICallback iCallback) {
        e.a().a(this.f28759a, str, iCallback, "");
    }

    @Override // com.huawei.hianalytics.framework.HAFrameworkInstance
    public void onStreamEvent(String str, String str2, JSONObject jSONObject, ICallback iCallback) {
        e.a().b(this.f28759a, str, str2, jSONObject, iCallback);
    }

    @Override // com.huawei.hianalytics.framework.HAFrameworkInstance
    public void setMinSessionDuration(long j10) {
        SessionHandler.getInstance().setMinSessionDuration(this.f28759a, j10);
    }

    @Override // com.huawei.hianalytics.framework.HAFrameworkInstance
    public void setNeedRefreshSession(boolean z10) {
        com.huawei.hianalytics.framework.data.a a10 = b.a(this.f28759a);
        if (a10 != null) {
            a10.a(z10);
        }
    }

    @Override // com.huawei.hianalytics.framework.HAFrameworkInstance
    public void setSessionTimeoutDuration(long j10) {
        SessionHandler.getInstance().setSessionTimeoutDuration(this.f28759a, j10);
    }

    @Override // com.huawei.hianalytics.framework.HAFrameworkInstance
    public void onEvent(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, ICallback iCallback) {
        e.a().a(this.f28759a, str, str2, jSONObject, jSONObject2, jSONObject3, iCallback);
    }

    @Override // com.huawei.hianalytics.framework.HAFrameworkInstance
    public void onStreamEvent(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, ICallback iCallback) {
        e.a().b(this.f28759a, str, str2, jSONObject, jSONObject2, jSONObject3, iCallback);
    }
}
