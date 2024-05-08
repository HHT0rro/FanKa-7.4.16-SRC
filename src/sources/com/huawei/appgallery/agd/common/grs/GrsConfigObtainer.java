package com.huawei.appgallery.agd.common.grs;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.huawei.appgallery.agd.common.CommonLog;
import com.huawei.appgallery.agd.common.FlavorApi;
import com.huawei.appgallery.agd.common.utils.ServerAddrConfig;
import com.huawei.appgallery.agd.serverreq.bean.BaseRequestBean;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.GrsClient;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class GrsConfigObtainer {
    public static final String URL_TYPE_BI = "BI";
    public static final String URL_TYPE_GALLERY = "GALLERYDOMAIN";
    public static final String URL_TYPE_QUICK_CARD = "QUICKCARD";
    public static final String URL_TYPE_STORE = "STORE";
    public static final String URL_TYPE_UC = "UC";

    /* renamed from: a, reason: collision with root package name */
    public static final Map<String, Map<String, String>> f27357a = new HashMap(1);

    /* renamed from: b, reason: collision with root package name */
    public static Map<String, String> f27358b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public static String f27359c = "";

    /* renamed from: d, reason: collision with root package name */
    public static GrsClient f27360d;

    public static void a() {
        if (f27358b.size() == 0) {
            f27358b.put(ServerAddrConfig.SERVER_STORE, URL_TYPE_STORE);
            f27358b.put(ServerAddrConfig.SERVER_UC, URL_TYPE_UC);
            f27358b.put(ServerAddrConfig.GALLERY_DOMAIN, URL_TYPE_GALLERY);
            f27358b.put(ServerAddrConfig.BI_SDK_SERVER, URL_TYPE_BI);
        }
    }

    public static boolean b(Context context) {
        GrsDataKeeper grsDataKeeper = GrsDataKeeper.getInstance();
        String appName = grsDataKeeper.getAppName(context);
        String homeCountry = grsDataKeeper.getHomeCountry();
        f27359c = homeCountry;
        GrsBaseInfo grsBaseInfo = new GrsBaseInfo();
        if (!TextUtils.isEmpty(appName)) {
            grsBaseInfo.setAppName(appName);
        }
        if (!TextUtils.isEmpty(homeCountry)) {
            grsBaseInfo.setSerCountry(homeCountry);
        }
        try {
            f27360d = new GrsClient(context, grsBaseInfo);
            return true;
        } catch (NullPointerException unused) {
            return false;
        }
    }

    public static synchronized Map<String, String> getGrsConfig(Context context, String str) {
        synchronized (GrsConfigObtainer.class) {
            if (f27360d == null || !f27359c.equals(GrsDataKeeper.getInstance().getHomeCountry())) {
                CommonLog commonLog = CommonLog.LOG;
                commonLog.i("GrsConfigObtainer", "grs not init ,do init ");
                if (!b(context)) {
                    commonLog.i("GrsConfigObtainer", "grs init failed");
                    return null;
                }
            }
            return f27360d.synGetGrsUrls(str);
        }
    }

    @Nullable
    public static synchronized String getServerUrl(Context context, String str, String str2) {
        Map<String, String> grsConfig;
        synchronized (GrsConfigObtainer.class) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                a();
                String str3 = f27358b.get(str);
                String homeCountry = GrsDataKeeper.getInstance().getHomeCountry();
                CommonLog.LOG.i("GrsConfigObtainer", "homeCountry is: " + homeCountry + ", grsServerType is:" + str3 + ", grsServerName is:" + str2);
                Map<String, Map<String, String>> map = f27357a;
                Map<String, String> map2 = map.get(homeCountry);
                Map<String, String> grsOfProperties = FlavorApi.getConfig().getGrsOfProperties();
                if (grsOfProperties != null && !grsOfProperties.isEmpty()) {
                    map2 = grsOfProperties;
                }
                String str4 = map2 != null ? map2.get(str3) : "";
                if (TextUtils.isEmpty(str4) && (grsConfig = getGrsConfig(context, str2)) != null) {
                    map.put(homeCountry, grsConfig);
                    str4 = grsConfig.get(str3);
                    for (Map.Entry<String, String> entry : grsConfig.entrySet()) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("initServerUrl for [");
                        sb2.append(entry.getKey());
                        sb2.append("]");
                        sb2.append(entry.getValue());
                    }
                }
                if (TextUtils.isEmpty(str4)) {
                    return "";
                }
                if (!ServerAddrConfig.SERVER_STORE.equals(str)) {
                    return str4;
                }
                return str4 + BaseRequestBean.STORE_API;
            }
            return "";
        }
    }
}
