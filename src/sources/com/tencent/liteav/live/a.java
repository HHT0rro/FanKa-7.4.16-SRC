package com.tencent.liteav.live;

import com.tencent.rtmp.ui.TXCloudVideoView;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static Method f43121a;

    /* renamed from: b, reason: collision with root package name */
    private static Method f43122b;

    static {
        try {
            Method declaredMethod = TXCloudVideoView.class.getDeclaredMethod("setShowLogCallback", WeakReference.class);
            f43121a = declaredMethod;
            declaredMethod.setAccessible(true);
            Method declaredMethod2 = TXCloudVideoView.class.getDeclaredMethod("isShowLogEnabled", new Class[0]);
            f43122b = declaredMethod2;
            declaredMethod2.setAccessible(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static boolean a(TXCloudVideoView tXCloudVideoView) {
        if (tXCloudVideoView == null) {
            return false;
        }
        try {
            Object invoke = f43122b.invoke(tXCloudVideoView, new Object[0]);
            if (invoke == null || !(invoke instanceof Boolean)) {
                return false;
            }
            return ((Boolean) invoke).booleanValue();
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static void a(TXCloudVideoView tXCloudVideoView, WeakReference<TXCloudVideoView.b> weakReference) {
        if (tXCloudVideoView == null) {
            return;
        }
        try {
            f43121a.invoke(tXCloudVideoView, weakReference);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
