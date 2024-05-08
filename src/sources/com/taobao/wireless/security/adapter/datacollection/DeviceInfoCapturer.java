package com.taobao.wireless.security.adapter.datacollection;

import android.content.Context;
import com.alibaba.wireless.security.mainplugin.SecurityGuardMainPlugin;
import com.alibaba.wireless.security.open.initialize.ISecurityGuardPlugin;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class9.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class9.dex.bak */
public class DeviceInfoCapturer {

    /* renamed from: а, reason: contains not printable characters */
    private static Context f220 = null;

    /* renamed from: б, reason: contains not printable characters */
    private static C0599 f221 = null;

    /* renamed from: в, reason: contains not printable characters */
    private static SecurityGuardMainPlugin f222 = null;

    /* renamed from: г, reason: contains not printable characters */
    private static volatile boolean f223 = false;

    /* renamed from: д, reason: contains not printable characters */
    private static Object f224;

    private DeviceInfoCapturer() {
    }

    public static String doCommandForString(int i10) {
        if (!f223) {
            synchronized (f224) {
                if (!f223) {
                    C0604.m2906(f220);
                    C0600.m2899(f220);
                    C0605.m2910(f220);
                    f223 = true;
                }
            }
        }
        String str = null;
        if (i10 != 0) {
            if (i10 != 109) {
                if (i10 == 126) {
                    str = m2891();
                } else if (i10 == 130) {
                    str = C0600.m2897();
                } else if (i10 == 135) {
                    str = C0605.m2909();
                } else if (i10 == 146) {
                    str = C0600.m2900();
                } else if (i10 != 104 && i10 != 105) {
                    switch (i10) {
                        case 121:
                            str = m2890();
                            break;
                        case 122:
                            str = C0604.m2908();
                            break;
                        case 123:
                            str = C0604.m2905();
                            break;
                    }
                }
            }
            return str;
        }
        str = C0604.m2907("android.hardware.wifi") ? "1" : "0";
        return str;
    }

    public static void initialize(ISecurityGuardPlugin iSecurityGuardPlugin, C0599 c0599) {
        f222 = (SecurityGuardMainPlugin) iSecurityGuardPlugin;
        f220 = f222.getContext();
        f221 = c0599;
        f224 = new Object();
    }

    /* renamed from: а, reason: contains not printable characters */
    private static String m2890() {
        C0599 c0599 = f221;
        if (c0599 != null) {
            return c0599.m2894();
        }
        return null;
    }

    /* renamed from: б, reason: contains not printable characters */
    private static String m2891() {
        C0599 c0599 = f221;
        if (c0599 != null) {
            return c0599.m2895(64);
        }
        return null;
    }
}
