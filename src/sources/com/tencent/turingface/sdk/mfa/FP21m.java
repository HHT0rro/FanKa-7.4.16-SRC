package com.tencent.turingface.sdk.mfa;

import android.os.Handler;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class FP21m implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Window f45585a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f45586b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ww1Z6 f45587c;

    public FP21m(Window window, String str, Ww1Z6 ww1Z6) {
        this.f45585a = window;
        this.f45586b = str;
        this.f45587c = ww1Z6;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        Object obj;
        Object obj2;
        Object a10;
        try {
            View decorView = this.f45585a.getDecorView();
            decorView.getViewTreeObserver().removeOnPreDrawListener(this);
            obj = null;
            try {
                Method declaredMethod = View.class.getDeclaredMethod("getViewRootImpl", new Class[0]);
                declaredMethod.setAccessible(true);
                obj2 = declaredMethod.invoke(decorView, new Object[0]);
            } catch (Throwable unused) {
                obj2 = null;
            }
        } catch (Throwable unused2) {
        }
        if (obj2 == null) {
            return true;
        }
        Class<?> cls = obj2.getClass();
        HashMap<Class<?>, HashMap<String, Field>> hashMap = JF943.f45610a;
        try {
            Method a11 = JF943.a(cls);
            if (a11 != null) {
                obj = a11.invoke(obj2, null);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (obj == null || (a10 = JF943.a(obj.getClass(), "mHandler", obj)) == null) {
            return true;
        }
        Field declaredField = Handler.class.getDeclaredField("mCallback");
        declaredField.setAccessible(true);
        Handler.Callback callback = (Handler.Callback) declaredField.get(a10);
        if (callback instanceof IyjbE) {
            return true;
        }
        declaredField.set(a10, new IyjbE(callback, this.f45587c, this.f45586b));
        return true;
    }
}
