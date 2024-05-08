package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.RouteInfo;
import java.lang.reflect.Method;
import java.util.HashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class ap extends RouteInfo {

    /* renamed from: a, reason: collision with root package name */
    private w f9815a;

    public ap(String str) {
        setPath(str);
        b();
    }

    private void b() {
        RouteInfo routeInfo;
        try {
            Method declaredMethod = Class.forName(x.at + getPath()).getDeclaredMethod("getRoutesMap", new Class[0]);
            declaredMethod.setAccessible(true);
            HashMap hashMap = (HashMap) declaredMethod.invoke(null, new Object[0]);
            if (hashMap == null || hashMap.size() <= 0 || (routeInfo = (RouteInfo) hashMap.get(getPath())) == null) {
                return;
            }
            this.f9815a = (w) routeInfo.getDestination().getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Throwable unused) {
        }
    }

    public Object a() {
        return this.f9815a;
    }
}
