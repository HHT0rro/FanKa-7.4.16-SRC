package com.huawei.quickcard.cardmanager.http;

import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ServerConfigUtil {

    /* renamed from: a, reason: collision with root package name */
    private static ServerConfig f33559a;

    public static Map<String, String> getPostHeaders() {
        HashMap hashMap = new HashMap();
        ServerConfig serverConfig = f33559a;
        return serverConfig != null ? serverConfig.getPostHeaders() : hashMap;
    }

    public static Map<String, String> getPostParamsForNewCard() {
        HashMap hashMap = new HashMap();
        ServerConfig serverConfig = f33559a;
        return serverConfig != null ? serverConfig.getPostParamsForNewCard() : hashMap;
    }

    public static void setServerConfig(ServerConfig serverConfig) {
        f33559a = serverConfig;
    }
}
