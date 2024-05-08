package com.tencent.cloud.huiyansdkface.wehttp2;

import android.content.Context;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.tencent.cloud.huiyansdkface.okhttp3.Cookie;
import com.tencent.cloud.huiyansdkface.okhttp3.HttpUrl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class WeWebViewCookie implements WeCookie {

    /* renamed from: b, reason: collision with root package name */
    private Context f42404b;

    public WeWebViewCookie(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("ctx 不能为null");
        }
        this.f42404b = context;
        CookieSyncManager.createInstance(context.getApplicationContext());
        CookieManager.getInstance();
    }

    @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeCookie
    public void clearCookie() {
        CookieManager.getInstance().removeAllCookie();
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.CookieJar
    public synchronized List<Cookie> loadForRequest(HttpUrl httpUrl) {
        Cookie parse;
        String cookie = CookieManager.getInstance().getCookie(httpUrl.toString());
        if (cookie == null) {
            return Collections.emptyList();
        }
        String[] split = cookie.split(";");
        ArrayList arrayList = new ArrayList();
        for (String str : split) {
            if (str != null && (parse = Cookie.parse(httpUrl, str)) != null) {
                arrayList.add(parse);
            }
        }
        return arrayList;
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.CookieJar
    public synchronized void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
        if (list != null) {
            if (list.size() != 0) {
                for (int i10 = 0; i10 < list.size(); i10++) {
                    CookieManager.getInstance().setCookie(httpUrl.toString(), list.get(i10).toString());
                }
                CookieSyncManager.getInstance().sync();
            }
        }
    }
}
