package com.tencent.cloud.huiyansdkface.wehttp2;

import com.tencent.cloud.huiyansdkface.okhttp3.Cookie;
import com.tencent.cloud.huiyansdkface.okhttp3.HttpUrl;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class MemoryCookieJar implements WeCookie, Iterable<Cookie> {

    /* renamed from: b, reason: collision with root package name */
    private HashSet<NamedCookie> f42285b = new HashSet<>();

    @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeCookie
    public void clearCookie() {
        this.f42285b.clear();
    }

    @Override // java.lang.Iterable
    /* renamed from: iterator */
    public Iterator<Cookie> iterator2() {
        final Iterator<NamedCookie> iterator2 = this.f42285b.iterator2();
        return new Iterator<Cookie>() { // from class: com.tencent.cloud.huiyansdkface.wehttp2.MemoryCookieJar.1
            @Override // java.util.Iterator
            public boolean hasNext() {
                return iterator2.hasNext();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.Iterator
            public Cookie next() {
                return ((NamedCookie) iterator2.next()).a();
            }

            @Override // java.util.Iterator
            public void remove() {
                iterator2.remove();
            }
        };
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.CookieJar
    public synchronized List<Cookie> loadForRequest(HttpUrl httpUrl) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<Cookie> iterator2 = iterator2();
        while (iterator2.hasNext()) {
            Cookie next = iterator2.next();
            if (next.expiresAt() < System.currentTimeMillis()) {
                iterator2.remove();
            } else if (next.matches(httpUrl)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.CookieJar
    public synchronized void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
        for (NamedCookie namedCookie : NamedCookie.a(list)) {
            this.f42285b.remove(namedCookie);
            this.f42285b.add(namedCookie);
        }
    }
}
