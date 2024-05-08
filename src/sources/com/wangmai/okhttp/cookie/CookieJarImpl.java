package com.wangmai.okhttp.cookie;

import com.wangmai.okhttp.cookie.store.CookieStore;
import java.util.List;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class CookieJarImpl implements CookieJar {
    public CookieStore cookieStore;

    public CookieJarImpl(CookieStore cookieStore) {
        if (cookieStore != null) {
            this.cookieStore = cookieStore;
            return;
        }
        throw new IllegalArgumentException("cookieStore can not be null!");
    }

    public CookieStore getCookieStore() {
        return this.cookieStore;
    }

    @Override // okhttp3.CookieJar
    public synchronized List<Cookie> loadForRequest(HttpUrl httpUrl) {
        return this.cookieStore.loadCookie(httpUrl);
    }

    @Override // okhttp3.CookieJar
    public synchronized void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
        this.cookieStore.saveCookie(httpUrl, list);
    }
}
