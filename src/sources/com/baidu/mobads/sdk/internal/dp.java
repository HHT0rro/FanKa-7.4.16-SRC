package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import java.util.HashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class dp {

    /* renamed from: a, reason: collision with root package name */
    private Boolean f10208a;

    public dp(Context context, Activity activity, Boolean bool) {
        this.f10208a = bool;
        a().booleanValue();
    }

    public Boolean a() {
        return this.f10208a;
    }

    public HashMap<String, String> b() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("xyz", "hihihi");
        return hashMap;
    }

    public String c() {
        return "http://211.151.146.65:8080/wlantest/shanghai_sun/mock_ad_server_intersitial_video.json";
    }
}
