package com.baidu.mobads.sdk.api;

import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface IXAdContainerFactory {
    Object getRemoteParam(String str, Object... objArr);

    double getRemoteVersion();

    void initCommonModuleObj(Object obj);

    void initConfig(JSONObject jSONObject);

    void onTaskDistribute(String str, JSONObject jSONObject);
}
