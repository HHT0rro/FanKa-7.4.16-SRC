package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class cv implements IOAdEventListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ cs f10123a;

    public cv(cs csVar) {
        this.f10123a = csVar;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        if (iOAdEvent != null) {
            try {
                if (iOAdEvent.getData() != null) {
                    Object obj = iOAdEvent.getData().get("intervalpages");
                    Object obj2 = iOAdEvent.getData().get("bannerseconds");
                    Object obj3 = iOAdEvent.getData().get("novelrouter");
                    Object obj4 = iOAdEvent.getData().get("entry");
                    Object obj5 = iOAdEvent.getData().get("channelId");
                    Object obj6 = iOAdEvent.getData().get(com.huawei.openalliance.ad.constant.as.f32246u);
                    if (obj3 != null) {
                        int intValue = obj != null ? ((Integer) obj).intValue() : 6;
                        int intValue2 = obj2 != null ? ((Integer) obj2).intValue() : 10;
                        int intValue3 = obj4 != null ? ((Integer) obj4).intValue() : 0;
                        int intValue4 = obj5 != null ? ((Integer) obj5).intValue() : 1022;
                        String str = obj6 != null ? (String) obj6 : null;
                        JSONObject jSONObject = new JSONObject();
                        if (ao.f()) {
                            jSONObject.put("status", "0");
                        } else {
                            jSONObject.put("status", "1");
                        }
                        this.f10123a.a(jSONObject);
                        this.f10123a.a(intValue, intValue2, (String) obj3, intValue3, intValue4, str);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
