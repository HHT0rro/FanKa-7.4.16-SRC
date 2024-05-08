package kc;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.service.notification.StatusBarNotification;
import android.util.Log;
import com.xiaomi.push.g7;
import com.xiaomi.push.hv;
import com.xiaomi.push.k0;
import com.xiaomi.push.n6;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.WeakHashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class h {

    /* renamed from: c, reason: collision with root package name */
    public static Context f50796c;

    /* renamed from: d, reason: collision with root package name */
    public static Object f50797d;

    /* renamed from: e, reason: collision with root package name */
    public static boolean f50798e;

    /* renamed from: a, reason: collision with root package name */
    public String f50800a;

    /* renamed from: b, reason: collision with root package name */
    public static final boolean f50795b = Log.isLoggable("NMHelper", 3);

    /* renamed from: f, reason: collision with root package name */
    public static WeakHashMap<Integer, h> f50799f = new WeakHashMap<>();

    public h(String str) {
        this.f50800a = str;
        r("create " + ((Object) this));
    }

    public static int a(String str) {
        if (Build.VERSION.SDK_INT < 24) {
            return -1;
        }
        try {
            return f50796c.getPackageManager().getPackageUid(str, 0);
        } catch (Exception unused) {
            return -1;
        }
    }

    public static NotificationManager c() {
        return (NotificationManager) f50796c.getSystemService("notification");
    }

    public static <T> T d(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return (T) obj.getClass().getMethod("getList", new Class[0]).invoke(obj, new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    public static Object e(List list) {
        return Class.forName("android.content.pm.ParceledListSlice").getConstructor(List.class).newInstance(list);
    }

    public static h i(Context context, String str) {
        m(context);
        int hashCode = str.hashCode();
        h hVar = f50799f.get(Integer.valueOf(hashCode));
        if (hVar != null) {
            return hVar;
        }
        h hVar2 = new h(str);
        f50799f.put(Integer.valueOf(hashCode), hVar2);
        return hVar2;
    }

    public static void m(Context context) {
        if (f50796c == null) {
            f50796c = context.getApplicationContext();
            NotificationManager c4 = c();
            Boolean bool = (Boolean) k0.e(c4, "isSystemConditionProviderEnabled", "xmsf_fake_condition_provider_path");
            s("fwk is support.init:" + ((Object) bool));
            boolean booleanValue = bool != null ? bool.booleanValue() : false;
            f50798e = booleanValue;
            if (booleanValue) {
                f50797d = k0.e(c4, "getService", new Object[0]);
            }
        }
    }

    public static boolean o() {
        if (g7.f() && j.d(f50796c).i(hv.NotificationBelongToAppSwitch.a(), true)) {
            return f50798e;
        }
        return false;
    }

    public static boolean p(Context context) {
        m(context);
        return o();
    }

    public static void s(String str) {
        fc.c.i("NMHelper:" + str);
    }

    public NotificationChannel b(String str) {
        NotificationChannel notificationChannel = null;
        try {
            if (o()) {
                List<NotificationChannel> h10 = h();
                if (h10 != null) {
                    for (NotificationChannel notificationChannel2 : h10) {
                        if (str.equals(notificationChannel2.getId())) {
                            try {
                                r("getNotificationChannel succ:" + str);
                                notificationChannel = notificationChannel2;
                                break;
                            } catch (Exception e2) {
                                e = e2;
                                notificationChannel = notificationChannel2;
                                s("getNotificationChannel error" + ((Object) e));
                                return notificationChannel;
                            }
                        }
                    }
                }
            } else {
                notificationChannel = c().getNotificationChannel(str);
            }
        } catch (Exception e10) {
            e = e10;
        }
        return notificationChannel;
    }

    public String f(String str) {
        String str2;
        if (o()) {
            r("get cid new format");
            str2 = "mipush|%s|%s";
        } else {
            r("get cid old format");
            str2 = "mipush_%s_%s";
        }
        return String.format(str2, this.f50800a, str);
    }

    public String g(String str, String str2) {
        if (!o()) {
            str = str2;
        }
        r("group summary cid is " + str);
        return str;
    }

    public List<NotificationChannel> h() {
        String str;
        String str2 = this.f50800a;
        List<NotificationChannel> list = null;
        try {
            if (o()) {
                int a10 = a(str2);
                if (a10 != -1) {
                    List<NotificationChannel> list2 = (List) d(k0.e(f50797d, "getNotificationChannelsForPackage", str2, Integer.valueOf(a10), Boolean.FALSE));
                    try {
                        r("getNotificationChannels succ:" + ((Object) list2));
                        str = "mipush|%s|%s";
                        list = list2;
                    } catch (Exception e2) {
                        e = e2;
                        list = list2;
                        s("getNotificationChannels error " + ((Object) e));
                        return list;
                    }
                } else {
                    str = null;
                }
            } else {
                list = c().getNotificationChannels();
                str = "mipush_%s_%s";
            }
            r("getNotificationChannels filter before:" + ((Object) list));
            if (g7.f() && list != null) {
                ArrayList arrayList = new ArrayList();
                String format = String.format(str, str2, "");
                for (NotificationChannel notificationChannel : list) {
                    if (notificationChannel.getId().startsWith(format)) {
                        arrayList.add(notificationChannel);
                    }
                }
                list = arrayList;
            }
            r("getNotificationChannels filter after:" + ((Object) list));
        } catch (Exception e10) {
            e = e10;
        }
        return list;
    }

    public void j(int i10) {
        String str = this.f50800a;
        try {
            if (o()) {
                k0.m(f50797d, "cancelNotificationWithTag", str, null, Integer.valueOf(i10));
                r("cancel succ:" + i10);
            } else {
                c().cancel(i10);
            }
        } catch (Exception e2) {
            r("cancel error" + ((Object) e2));
        }
    }

    public void k(int i10, Notification notification) {
        String str = this.f50800a;
        NotificationManager c4 = c();
        try {
            int i11 = Build.VERSION.SDK_INT;
            if (o()) {
                notification.extras.putString("xmsf_target_package", str);
                r("notify succ:" + i10);
                if (i11 >= 29) {
                    c4.notifyAsPackage(str, null, i10, notification);
                }
            }
            c4.notify(i10, notification);
        } catch (Exception e2) {
            r("notify error" + ((Object) e2));
        }
    }

    public void l(NotificationChannel notificationChannel) {
        String str = this.f50800a;
        try {
            if (o()) {
                int a10 = a(str);
                if (a10 != -1) {
                    k0.m(f50797d, "createNotificationChannelsForPackage", str, Integer.valueOf(a10), e(Arrays.asList(notificationChannel)));
                    r("createNotificationChannel succ:" + ((Object) notificationChannel));
                }
            } else {
                c().createNotificationChannel(notificationChannel);
            }
        } catch (Exception e2) {
            s("createNotificationChannel error" + ((Object) e2));
        }
    }

    public void n(String str) {
        c().deleteNotificationChannel(str);
        r("deleteNotificationChannel succ " + str);
    }

    public List<StatusBarNotification> q() {
        String str;
        String str2 = this.f50800a;
        NotificationManager c4 = c();
        try {
            if (o()) {
                int c10 = n6.c();
                r2 = c10 != -1 ? (List) d(k0.e(f50797d, "getAppActiveNotifications", str2, Integer.valueOf(c10))) : null;
                str = "getActiveNotifications succ:" + c10 + com.huawei.openalliance.ad.constant.u.bD + ((Object) r2);
            } else {
                StatusBarNotification[] activeNotifications = c4.getActiveNotifications();
                r("getActiveNotifications filter before:" + Arrays.toString(activeNotifications));
                boolean f10 = g7.f();
                if (activeNotifications != null && activeNotifications.length > 0) {
                    ArrayList arrayList = new ArrayList();
                    try {
                        for (StatusBarNotification statusBarNotification : activeNotifications) {
                            if (!f10 || str2.equals(i.b(statusBarNotification.getNotification()))) {
                                arrayList.add(statusBarNotification);
                            }
                        }
                        r2 = arrayList;
                    } catch (Exception e2) {
                        e = e2;
                        r2 = arrayList;
                        s("getActiveNotifications error " + ((Object) e));
                        return r2;
                    }
                }
                str = "getActiveNotifications filter after:" + ((Object) r2);
            }
            r(str);
        } catch (Exception e10) {
            e = e10;
        }
        return r2;
    }

    public void r(String str) {
        if (f50795b) {
            s(this.f50800a + "-->" + str);
        }
    }

    public String toString() {
        return "NotificationManagerHelper{" + this.f50800a + com.alipay.sdk.util.i.f4738d;
    }
}
