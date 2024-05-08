package com.alibaba.wireless.security.open.edgecomputing;

import android.os.Handler;
import android.util.Base64;
import com.alibaba.wireless.security.open.SecException;
import com.baidu.mobads.sdk.api.IAdInterListener;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class9.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class9.dex.bak */
public class ProxyUtil {

    /* renamed from: а, reason: contains not printable characters */
    private static volatile Handler f178;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class9.dex
 */
    /* renamed from: com.alibaba.wireless.security.open.edgecomputing.ProxyUtil$а, reason: contains not printable characters */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class9.dex.bak */
    static class C0080 implements InvocationHandler {

        /* renamed from: а, reason: contains not printable characters */
        final /* synthetic */ Object f179;

        /* renamed from: б, reason: contains not printable characters */
        final /* synthetic */ int f180;

        C0080(Object obj, int i10) {
            this.f179 = obj;
            this.f180 = i10;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String name = method.getName();
            Object obj2 = this.f179;
            try {
                ProxyUtil.m1938(this.f180, obj, name, objArr, obj2 != null ? obj2.getClass().getCanonicalName() : null);
            } catch (SecException unused) {
            }
            Object obj3 = this.f179;
            if (obj3 != null) {
                return method.invoke(obj3, objArr);
            }
            String name2 = method.getReturnType().getName();
            char c4 = 65535;
            switch (name2.hashCode()) {
                case -1808118735:
                    if (name2.equals("String")) {
                        c4 = 2;
                        break;
                    }
                    break;
                case -672261858:
                    if (name2.equals("Integer")) {
                        c4 = 3;
                        break;
                    }
                    break;
                case 104431:
                    if (name2.equals(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL)) {
                        c4 = 1;
                        break;
                    }
                    break;
                case 64711720:
                    if (name2.equals("boolean")) {
                        c4 = 0;
                        break;
                    }
                    break;
                case 1729365000:
                    if (name2.equals("Boolean")) {
                        c4 = 4;
                        break;
                    }
                    break;
            }
            if (c4 == 0) {
                return false;
            }
            if (c4 != 1) {
                if (c4 == 2) {
                    return "";
                }
                if (c4 != 3) {
                    if (c4 != 4) {
                        return null;
                    }
                    return Boolean.FALSE;
                }
            }
            return 0;
        }
    }

    public static Handler getHandler() {
        return f178;
    }

    public static Object getProxyInstance(String str, Object obj, int i10) {
        try {
            Class<?> cls = Class.forName(new String(Base64.decode(str, 0)));
            if (cls == null) {
                return null;
            }
            return Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new C0080(obj, i10));
        } catch (Exception unused) {
            return null;
        }
    }

    public static void init(Handler handler) {
        f178 = handler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: б, reason: contains not printable characters */
    public static void m1938(int i10, Object obj, String str, Object[] objArr, String str2) throws SecException {
        C0081.m1941().doCommand(i10, obj, str, objArr, str2);
    }
}
