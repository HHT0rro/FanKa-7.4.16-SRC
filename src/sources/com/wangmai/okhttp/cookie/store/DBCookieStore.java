package com.wangmai.okhttp.cookie.store;

import android.content.Context;
import com.wangmai.okhttp.cookie.SerializableCookie;
import com.wangmai.okhttp.db.CookieManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.Cookie;
import okhttp3.HttpUrl;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class DBCookieStore implements CookieStore {
    public final Map<String, ConcurrentHashMap<String, Cookie>> cookies;

    public DBCookieStore(Context context) {
        CookieManager.init(context);
        this.cookies = new HashMap();
        for (SerializableCookie serializableCookie : CookieManager.getInstance().queryAll()) {
            if (!this.cookies.containsKey(serializableCookie.host)) {
                this.cookies.put(serializableCookie.host, new ConcurrentHashMap<>());
            }
            Cookie cookie = serializableCookie.getCookie();
            this.cookies.get(serializableCookie.host).put(getCookieToken(cookie), cookie);
        }
    }

    private String getCookieToken(Cookie cookie) {
        return cookie.name() + "@" + cookie.domain();
    }

    public static boolean isCookieExpired(Cookie cookie) {
        return cookie.expiresAt() < System.currentTimeMillis();
    }

    @Override // com.wangmai.okhttp.cookie.store.CookieStore
    public synchronized List<Cookie> getAllCookie() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<String> iterator2 = this.cookies.h().iterator2();
        while (iterator2.hasNext()) {
            arrayList.addAll(this.cookies.get(iterator2.next()).values());
        }
        return arrayList;
    }

    @Override // com.wangmai.okhttp.cookie.store.CookieStore
    public synchronized List<Cookie> getCookie(HttpUrl httpUrl) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        ConcurrentHashMap<String, Cookie> concurrentHashMap = this.cookies.get(httpUrl.host());
        if (concurrentHashMap != null) {
            arrayList.addAll(concurrentHashMap.values());
        }
        return arrayList;
    }

    @Override // com.wangmai.okhttp.cookie.store.CookieStore
    public synchronized List<Cookie> loadCookie(HttpUrl httpUrl) {
        ArrayList arrayList = new ArrayList();
        if (!this.cookies.containsKey(httpUrl.host())) {
            return arrayList;
        }
        Iterator<SerializableCookie> iterator2 = CookieManager.getInstance().query("host=?", new String[]{httpUrl.host()}).iterator2();
        while (iterator2.hasNext()) {
            Cookie cookie = iterator2.next().getCookie();
            if (isCookieExpired(cookie)) {
                removeCookie(httpUrl, cookie);
            } else {
                arrayList.add(cookie);
            }
        }
        return arrayList;
    }

    @Override // com.wangmai.okhttp.cookie.store.CookieStore
    public synchronized boolean removeAllCookie() {
        this.cookies.clear();
        CookieManager.getInstance().deleteAll();
        return true;
    }

    @Override // com.wangmai.okhttp.cookie.store.CookieStore
    public synchronized boolean removeCookie(HttpUrl httpUrl, Cookie cookie) {
        if (!this.cookies.containsKey(httpUrl.host())) {
            return false;
        }
        String cookieToken = getCookieToken(cookie);
        if (!this.cookies.get(httpUrl.host()).containsKey(cookieToken)) {
            return false;
        }
        this.cookies.get(httpUrl.host()).remove(cookieToken);
        CookieManager.getInstance().delete("host=? and name=? and domain=?", new String[]{httpUrl.host(), cookie.name(), cookie.domain()});
        return true;
    }

    @Override // com.wangmai.okhttp.cookie.store.CookieStore
    public synchronized void saveCookie(HttpUrl httpUrl, List<Cookie> list) {
        Iterator<Cookie> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            saveCookie(httpUrl, iterator2.next());
        }
    }

    @Override // com.wangmai.okhttp.cookie.store.CookieStore
    public synchronized void saveCookie(HttpUrl httpUrl, Cookie cookie) {
        if (!this.cookies.containsKey(httpUrl.host())) {
            this.cookies.put(httpUrl.host(), new ConcurrentHashMap<>());
        }
        if (isCookieExpired(cookie)) {
            removeCookie(httpUrl, cookie);
        } else {
            this.cookies.get(httpUrl.host()).put(getCookieToken(cookie), cookie);
            CookieManager.getInstance().replace((CookieManager) new SerializableCookie(httpUrl.host(), cookie));
        }
    }

    @Override // com.wangmai.okhttp.cookie.store.CookieStore
    public synchronized boolean removeCookie(HttpUrl httpUrl) {
        if (!this.cookies.containsKey(httpUrl.host())) {
            return false;
        }
        this.cookies.remove(httpUrl.host());
        CookieManager.getInstance().delete("host=?", new String[]{httpUrl.host()});
        return true;
    }
}
