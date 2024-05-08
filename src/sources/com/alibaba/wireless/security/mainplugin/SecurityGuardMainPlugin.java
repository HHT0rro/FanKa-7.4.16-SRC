package com.alibaba.wireless.security.mainplugin;

import android.content.Context;
import com.alibaba.wireless.security.framework.IRouterComponent;
import com.alibaba.wireless.security.framework.ISGPluginInfo;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.initialize.ISecurityGuardPlugin;
import com.taobao.wireless.security.adapter.datacollection.C0601;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.TimerTask;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class9.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class9.dex.bak */
public class SecurityGuardMainPlugin implements ISecurityGuardPlugin {
    public static ClassLoader sClassLoader;
    public static ClassLoader sParentClassLoader;

    /* renamed from: а, reason: contains not printable characters */
    private HashMap<Class, Object> f151 = null;

    /* renamed from: б, reason: contains not printable characters */
    private boolean f152 = true;

    /* renamed from: в, reason: contains not printable characters */
    private Context f153 = null;

    /* renamed from: г, reason: contains not printable characters */
    private ISGPluginInfo f154 = null;

    /* renamed from: д, reason: contains not printable characters */
    private IRouterComponent f155 = null;

    /* renamed from: е, reason: contains not printable characters */
    private C0076 f156 = new C0076();

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class9.dex
 */
    /* renamed from: com.alibaba.wireless.security.mainplugin.SecurityGuardMainPlugin$а, reason: contains not printable characters */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class9.dex.bak */
    class C0072 extends TimerTask {

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class9.dex
 */
        /* renamed from: com.alibaba.wireless.security.mainplugin.SecurityGuardMainPlugin$а$а, reason: contains not printable characters */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class9.dex.bak */
        class C0073 extends Thread {
            C0073() {
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    C0601.m2902(SecurityGuardMainPlugin.this.getContext());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }

        C0072() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            new C0073().start();
        }
    }

    public static ClassLoader getMainPluginClassLoader() {
        return sClassLoader;
    }

    public static ClassLoader getMainPluginParentClassLoader() {
        return sParentClassLoader;
    }

    /* renamed from: а, reason: contains not printable characters */
    private void m1918(String str) {
        if (str == null) {
            return;
        }
        this.f156.m1926(this.f151, str, this);
    }

    /* renamed from: а, reason: contains not printable characters */
    private boolean m1919() {
        Method method;
        Method method2;
        String str = "0";
        boolean silentMode = SecurityGuardManager.getSilentMode();
        boolean z10 = false;
        try {
            Class<?> cls = Class.forName("com.alibaba.wireless.security.open.securityguardaccsadapter.OrangeListener");
            if (cls != null && (method2 = cls.getMethod("getOrangeConfig", String.class, String.class, String.class)) != null) {
                str = (String) method2.invoke(cls, "securityguard_orange_namespace", "113", "0");
            }
        } catch (Throwable unused) {
        }
        boolean equals = "1".equals(str) | silentMode;
        try {
            Class<?> cls2 = Class.forName("com.taobao.adaemon.ADaemon");
            if (cls2 != null && (method = cls2.getMethod("isChannelMemOptimizeEnable", Context.class)) != null) {
                z10 = ((Boolean) method.invoke(cls2, this.f153)).booleanValue();
            }
        } catch (Throwable unused2) {
        }
        return equals | z10;
    }

    /* renamed from: б, reason: contains not printable characters */
    private void m1920() {
        this.f151 = new HashMap<>();
        this.f156.m1925(this.f151, this);
    }

    @Override // com.alibaba.wireless.security.open.initialize.ISecurityGuardPlugin
    public Context getContext() {
        return this.f153;
    }

    @Override // com.alibaba.wireless.security.open.initialize.ISecurityGuardPlugin
    public <T> T getInterface(Class<T> cls) {
        if (cls == null) {
            return null;
        }
        T t2 = (T) this.f151.get(cls);
        if (t2 != null && cls.isAssignableFrom(t2.getClass())) {
            return t2;
        }
        try {
            m1918(cls.getName());
            return (T) this.f151.get(cls);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.alibaba.wireless.security.open.initialize.ISecurityGuardPlugin
    public IRouterComponent getRouter() {
        return this.f155;
    }

    @Override // com.alibaba.wireless.security.open.initialize.ISecurityGuardPlugin
    public ISGPluginInfo getSGPluginInfo() {
        return this.f154;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x011d  */
    @Override // com.alibaba.wireless.security.open.initialize.ISecurityGuardPlugin
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.alibaba.wireless.security.framework.IRouterComponent onPluginLoaded(android.content.Context r18, com.alibaba.wireless.security.framework.IRouterComponent r19, com.alibaba.wireless.security.framework.ISGPluginInfo r20, java.lang.String r21, java.lang.Object... r22) throws com.alibaba.wireless.security.open.SecException {
        /*
            Method dump skipped, instructions count: 308
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.mainplugin.SecurityGuardMainPlugin.onPluginLoaded(android.content.Context, com.alibaba.wireless.security.framework.IRouterComponent, com.alibaba.wireless.security.framework.ISGPluginInfo, java.lang.String, java.lang.Object[]):com.alibaba.wireless.security.framework.IRouterComponent");
    }
}
