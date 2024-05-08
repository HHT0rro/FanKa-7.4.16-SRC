package com.taobao.wireless.security.adapter.datacollection;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Process;
import android.util.Log;
import com.alibaba.wireless.security.framework.utils.UserTrackMethodJniBridge;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class9.dex
 */
/* renamed from: com.taobao.wireless.security.adapter.datacollection.в, reason: contains not printable characters */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class9.dex.bak */
public class C0601 {

    /* renamed from: а, reason: contains not printable characters */
    static List<String> f229 = new ArrayList(15);

    /* renamed from: б, reason: contains not printable characters */
    static List<C0603> f230 = new ArrayList(10);

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class9.dex
 */
    /* renamed from: com.taobao.wireless.security.adapter.datacollection.в$а, reason: contains not printable characters */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class9.dex.bak */
    static class C0602 extends BroadcastReceiver {
        C0602() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                String action = intent.getAction();
                synchronized (C0601.class) {
                    C0601.f230.add(new C0603(C0601.f229.indexOf(action), System.currentTimeMillis()));
                    if (C0601.f230.size() >= 10) {
                        C0601.m2904();
                        C0601.f230.clear();
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class9.dex
 */
    /* renamed from: com.taobao.wireless.security.adapter.datacollection.в$б, reason: contains not printable characters */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class9.dex.bak */
    public static class C0603 {

        /* renamed from: а, reason: contains not printable characters */
        int f231;

        /* renamed from: б, reason: contains not printable characters */
        long f232;

        public C0603(int i10, long j10) {
            this.f231 = i10;
            this.f232 = j10;
        }

        public String toString() {
            return this.f231 + "_" + this.f232;
        }
    }

    static {
        f229.add("android.intent.action.SCREEN_OFF");
        f229.add("android.intent.action.SCREEN_ON");
        f229.add("com.alibaba.action.ENTER_FOREGROUND");
        f229.add("com.alibaba.action.ENTER_BACKGROUND");
        f229.add("android.intent.action.AIRPLANE_MODE");
        f229.add("android.intent.action.TIME_SET");
        f229.add("com.alibaba.action.SCREEN_SHOT");
        f229.add("com.alibaba.action.SCREEN_RECORD");
        f229.add("android.bluetooth.adapter.action.STATE_CHANGED");
        f229.add("android.bluetooth.adapter.action.ACL_CONNECTED");
        f229.add("android.bluetooth.adapter.action.ACL_DISCONNECTED");
        f229.add("android.intent.action.PHONE_STATE");
        f229.add("android.intent.action.HEADSET_PLUG");
        f229.add("com.alibaba.action.PrimaryClipChanged");
        f229.add("android.net.conn.CONNECTIVITY_CHANGE");
        f229.add("com.alibaba.action.LC_ON_ACT_CREATED");
        f229.add("com.alibaba.action.LC_ON_ACT_STARTED");
        f229.add("com.alibaba.action.LC_ON_ACT_RESUMED");
        f229.add("com.alibaba.action.LC_ON_ACT_PAUSED");
        f229.add("com.alibaba.action.LC_ON_ACT_STOPPED");
        f229.add("com.alibaba.action.LC_ON_ACT_SAVE_INSTANCE_STATE");
        f229.add("com.alibaba.action.LC_ON_ACT_DESTROYED");
    }

    /* renamed from: а, reason: contains not printable characters */
    public static void m2902(Context context) {
        if (context != null && m2903()) {
            IntentFilter intentFilter = new IntentFilter();
            Iterator<String> iterator2 = f229.iterator2();
            while (iterator2.hasNext()) {
                intentFilter.addAction(iterator2.next());
            }
            context.registerReceiver(new C0602(), intentFilter);
        }
    }

    /* renamed from: б, reason: contains not printable characters */
    public static boolean m2903() {
        Method method;
        String str = "0";
        try {
            Class<?> cls = Class.forName("com.alibaba.wireless.security.open.securityguardaccsadapter.OrangeListener");
            if (cls != null && (method = cls.getMethod("getOrangeConfig", String.class, String.class, String.class)) != null) {
                str = (String) method.invoke(cls, "securityguard_orange_namespace", "132", "0");
            }
        } catch (Throwable th) {
            Log.e("SGNTF", "get notificationCollectionSwitch : " + th.getMessage());
        }
        return "1".equals(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: в, reason: contains not printable characters */
    public static void m2904() {
        StringBuilder sb2 = new StringBuilder();
        Iterator<C0603> iterator2 = f230.iterator2();
        while (iterator2.hasNext()) {
            sb2.append(iterator2.next().toString());
            sb2.append("|");
        }
        String str = null;
        try {
            str = SecurityGuardManager.getInstance(null).getSDKVerison();
        } catch (Throwable unused) {
        }
        sb2.deleteCharAt(sb2.length() - 1);
        UserTrackMethodJniBridge.addUtRecord("100184", 234, 0, "" + str, 0L, "", "" + Process.myPid(), sb2.toString(), "", "");
    }
}
