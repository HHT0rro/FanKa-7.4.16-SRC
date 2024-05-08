package com.taobao.wireless.security.adapter.datareport;

import com.alibaba.wireless.security.framework.IRouterComponent;
import com.alibaba.wireless.security.open.initialize.ISecurityGuardPlugin;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class9.dex
 */
/* renamed from: com.taobao.wireless.security.adapter.datareport.а, reason: contains not printable characters */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class9.dex.bak */
public class C0606 {

    /* renamed from: а, reason: contains not printable characters */
    private static IRouterComponent f249;

    /* renamed from: б, reason: contains not printable characters */
    private static Executor f250;

    /* renamed from: в, reason: contains not printable characters */
    private static Boolean f251;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class9.dex
 */
    /* renamed from: com.taobao.wireless.security.adapter.datareport.а$а, reason: contains not printable characters */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class9.dex.bak */
    static class ThreadFactoryC0607 implements ThreadFactory {
        ThreadFactoryC0607() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "SGNE");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class9.dex
 */
    /* renamed from: com.taobao.wireless.security.adapter.datareport.а$б, reason: contains not printable characters */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class9.dex.bak */
    public static class RunnableC0608 implements Runnable {

        /* renamed from: а, reason: contains not printable characters */
        final /* synthetic */ C0609 f252;

        RunnableC0608(C0609 c0609) {
            this.f252 = c0609;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                C0606.f249.doCommand(13701, this.f252.m2927(), Integer.valueOf(this.f252.m2916()), Integer.valueOf(this.f252.m2920()), Integer.valueOf(this.f252.m2923()), Long.valueOf(this.f252.m2925()), Long.valueOf(this.f252.m2926()));
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class9.dex
 */
    /* renamed from: com.taobao.wireless.security.adapter.datareport.а$в, reason: contains not printable characters */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class9.dex.bak */
    public static class C0609 {

        /* renamed from: а, reason: contains not printable characters */
        String f253;

        /* renamed from: б, reason: contains not printable characters */
        int f254;

        /* renamed from: в, reason: contains not printable characters */
        int f255;

        /* renamed from: г, reason: contains not printable characters */
        int f256;

        /* renamed from: д, reason: contains not printable characters */
        long f257;

        /* renamed from: е, reason: contains not printable characters */
        long f258;

        /* renamed from: а, reason: contains not printable characters */
        public int m2916() {
            return this.f254;
        }

        /* renamed from: а, reason: contains not printable characters */
        public void m2917(int i10) {
            this.f254 = i10;
        }

        /* renamed from: а, reason: contains not printable characters */
        public void m2918(long j10) {
            this.f257 = j10;
        }

        /* renamed from: а, reason: contains not printable characters */
        public void m2919(String str) {
            this.f253 = str;
        }

        /* renamed from: б, reason: contains not printable characters */
        public int m2920() {
            return this.f255;
        }

        /* renamed from: б, reason: contains not printable characters */
        public void m2921(int i10) {
            this.f255 = i10;
        }

        /* renamed from: б, reason: contains not printable characters */
        public void m2922(long j10) {
            this.f258 = j10;
        }

        /* renamed from: в, reason: contains not printable characters */
        public int m2923() {
            return this.f256;
        }

        /* renamed from: в, reason: contains not printable characters */
        public void m2924(int i10) {
            this.f256 = i10;
        }

        /* renamed from: г, reason: contains not printable characters */
        public long m2925() {
            return this.f257;
        }

        /* renamed from: д, reason: contains not printable characters */
        public long m2926() {
            return this.f258;
        }

        /* renamed from: е, reason: contains not printable characters */
        public String m2927() {
            return this.f253;
        }
    }

    /* renamed from: а, reason: contains not printable characters */
    public static void m2911(ISecurityGuardPlugin iSecurityGuardPlugin) {
        f249 = iSecurityGuardPlugin.getRouter();
        f250 = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(30), new ThreadFactoryC0607(), new ThreadPoolExecutor.DiscardPolicy());
    }

    /* renamed from: а, reason: contains not printable characters */
    public static void m2912(C0609 c0609) {
        if (f249 == null || f250 == null || c0609 == null || !m2913()) {
            return;
        }
        f250.execute(new RunnableC0608(c0609));
    }

    /* renamed from: а, reason: contains not printable characters */
    private static boolean m2913() {
        IRouterComponent iRouterComponent = f249;
        if (iRouterComponent == null) {
            return false;
        }
        if (f251 == null) {
            try {
                Integer num = (Integer) iRouterComponent.doCommand(13702, new Object[0]);
                if (num != null) {
                    f251 = Boolean.valueOf(num.equals(1));
                }
            } catch (Throwable unused) {
            }
        }
        Boolean bool = f251;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    /* renamed from: в, reason: contains not printable characters */
    public static boolean m2915() {
        return f249 != null && m2913();
    }
}
