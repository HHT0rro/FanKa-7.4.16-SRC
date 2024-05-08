package com.huawei.quickcard.base.utils;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.quickcard.base.grs.CardServerConfig;
import com.huawei.quickcard.base.grs.INetworkAccessProvider;
import com.huawei.quickcard.base.grs.QuickCardServer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class CardServerUtil {

    /* renamed from: a, reason: collision with root package name */
    private static final String f33376a = "clientApi";

    /* renamed from: b, reason: collision with root package name */
    private static final String f33377b = "agc/apigw/AppGalleryQuickCardService/quickapp-service/v1/quickcard-developer/template/download";

    public static String getAgcPostUrl(Context context) {
        String url = CardServerConfig.getUrl();
        if (TextUtils.isEmpty(url)) {
            url = QuickCardServer.getAgcUri(context);
            if (TextUtils.isEmpty(url)) {
                return "";
            }
        }
        if (url.endsWith("/")) {
            return url + f33377b;
        }
        return url + "/agc/apigw/AppGalleryQuickCardService/quickapp-service/v1/quickcard-developer/template/download";
    }

    public static String getStorePostUrl(Context context) {
        String url = CardServerConfig.getUrl();
        if (TextUtils.isEmpty(url)) {
            url = QuickCardServer.getStoreUri(context);
            if (TextUtils.isEmpty(url)) {
                return "";
            }
        }
        if (url.endsWith("/")) {
            return url + "clientApi";
        }
        return url + "/clientApi";
    }

    public static boolean isNetworkAccess() {
        INetworkAccessProvider networkAccessProvider = CardServerConfig.getNetworkAccessProvider();
        return networkAccessProvider == null || networkAccessProvider.isNetworkAccessEnable();
    }
}
