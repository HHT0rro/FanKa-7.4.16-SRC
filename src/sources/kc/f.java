package kc;

import android.app.Notification;
import android.app.NotificationChannel;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import com.xiaomi.push.g7;
import com.xiaomi.push.hv;
import com.xiaomi.push.k0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public static f f50788a = new f();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        public List<b> f50789a;

        /* renamed from: b, reason: collision with root package name */
        public List<b> f50790b;

        public a() {
            this.f50789a = new ArrayList();
            this.f50790b = new ArrayList();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        public int f50792a;

        /* renamed from: b, reason: collision with root package name */
        public Notification f50793b;

        public b(int i10, Notification notification) {
            this.f50792a = i10;
            this.f50793b = notification;
        }

        public String toString() {
            return "id:" + this.f50792a;
        }
    }

    public static f e() {
        return f50788a;
    }

    public final int a(String str, String str2) {
        return ("GroupSummary" + str + str2).hashCode();
    }

    public final String b(Notification notification) {
        Bundle bundle;
        if (notification == null || (bundle = notification.extras) == null) {
            return null;
        }
        return bundle.getString("push_src_group_name");
    }

    public String c(Context context, Notification.Builder builder, String str) {
        if (!k() || !m(context)) {
            return str;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Bundle extras = builder.getExtras();
        extras.putString("push_src_group_name", str);
        extras.putLong("push_src_group_time", currentTimeMillis);
        return String.format("pushmask_%s_%s", Long.valueOf(currentTimeMillis), str);
    }

    public final List<StatusBarNotification> d(h hVar) {
        List<StatusBarNotification> q10 = hVar != null ? hVar.q() : null;
        if (q10 == null || q10.size() == 0) {
            return null;
        }
        return q10;
    }

    public void f(Context context, int i10, Notification notification) {
        if (k()) {
            if (m(context)) {
                try {
                    o(context, i10, notification);
                } catch (Exception e2) {
                    fc.c.i("group notify handle restore error " + ((Object) e2));
                }
            }
            if (q(context)) {
                try {
                    g(context, i10, notification, true);
                } catch (Exception e10) {
                    fc.c.i("group notify handle auto error " + ((Object) e10));
                }
            }
        }
    }

    public final void g(Context context, int i10, Notification notification, boolean z10) {
        String str;
        String b4 = i.b(notification);
        if (TextUtils.isEmpty(b4)) {
            str = "group auto not extract pkg from notification:" + i10;
        } else {
            h i11 = h.i(context, b4);
            List<StatusBarNotification> d10 = d(i11);
            if (d10 != null) {
                String n10 = n(notification);
                HashMap hashMap = new HashMap();
                for (StatusBarNotification statusBarNotification : d10) {
                    if (statusBarNotification.getNotification() != null && statusBarNotification.getId() != i10) {
                        j(hashMap, statusBarNotification);
                    }
                }
                for (Map.Entry<String, a> entry : hashMap.entrySet()) {
                    String key = entry.getKey();
                    if (!TextUtils.isEmpty(key)) {
                        a value = entry.getValue();
                        if (z10 && key.equals(n10) && !p(notification)) {
                            (l(notification) ? value.f50790b : value.f50789a).add(new b(i10, notification));
                        }
                        int size = value.f50789a.size();
                        if (value.f50790b.size() <= 0) {
                            if (size >= 2) {
                                i(context, b4, key, value.f50789a.get(0).f50793b);
                            }
                        } else if (size <= 0) {
                            h(context, b4, key);
                        } else if (size >= 2 && !m(context)) {
                            b bVar = value.f50790b.get(0);
                            fc.c.l("group refresh:" + ((Object) bVar));
                            bVar.f50793b.when = System.currentTimeMillis();
                            i11.k(bVar.f50792a, bVar.f50793b);
                        }
                    }
                }
                return;
            }
            str = "group auto not get notifications";
        }
        fc.c.i(str);
    }

    public final void h(Context context, String str, String str2) {
        fc.c.l("group cancel summary:" + str2);
        h.i(context, str).j(a(str, str2));
    }

    public final void i(Context context, String str, String str2, Notification notification) {
        Notification.Builder defaults;
        try {
            if (TextUtils.isEmpty(str2)) {
                fc.c.i("group show summary group is null");
                return;
            }
            int a10 = i.a(context, str);
            if (a10 == 0) {
                fc.c.i("group show summary not get icon from " + str);
                return;
            }
            h i10 = h.i(context, str);
            if (Build.VERSION.SDK_INT >= 26) {
                String g3 = i10.g(notification.getChannelId(), "groupSummary");
                NotificationChannel b4 = i10.b(g3);
                if ("groupSummary".equals(g3) && b4 == null) {
                    i10.l(new NotificationChannel(g3, "group_summary", 3));
                }
                defaults = new Notification.Builder(context, g3);
            } else {
                defaults = new Notification.Builder(context).setPriority(0).setDefaults(-1);
            }
            Notification build = defaults.setContentTitle("GroupSummary").setContentText("GroupSummary").setSmallIcon(Icon.createWithResource(str, a10)).setAutoCancel(true).setGroup(str2).setGroupSummary(true).build();
            if (!g7.j() && "com.xiaomi.xmsf".equals(context.getPackageName())) {
                i.c(build, str);
            }
            int a11 = a(str, str2);
            i10.k(a11, build);
            fc.c.l("group show summary notify:" + a11);
        } catch (Exception e2) {
            fc.c.i("group show summary error " + ((Object) e2));
        }
    }

    public final void j(Map<String, a> map, StatusBarNotification statusBarNotification) {
        String n10 = n(statusBarNotification.getNotification());
        a aVar = map.get(n10);
        if (aVar == null) {
            aVar = new a();
            map.put(n10, aVar);
        }
        (l(statusBarNotification.getNotification()) ? aVar.f50790b : aVar.f50789a).add(new b(statusBarNotification.getId(), statusBarNotification.getNotification()));
    }

    public final boolean k() {
        return Build.VERSION.SDK_INT >= 24;
    }

    public final boolean l(Notification notification) {
        if (notification == null) {
            return false;
        }
        Object e2 = k0.e(notification, "isGroupSummary", null);
        if (e2 instanceof Boolean) {
            return ((Boolean) e2).booleanValue();
        }
        return false;
    }

    public final boolean m(Context context) {
        if (q(context) && h.p(context)) {
            return j.d(context).i(hv.LatestNotificationNotIntoGroupSwitch.a(), true);
        }
        return false;
    }

    public final String n(Notification notification) {
        if (notification == null) {
            return null;
        }
        return p(notification) ? b(notification) : notification.getGroup();
    }

    public final void o(Context context, int i10, Notification notification) {
        String str;
        String b4 = i.b(notification);
        if (TextUtils.isEmpty(b4)) {
            str = "group restore not extract pkg from notification:" + i10;
        } else {
            h i11 = h.i(context, b4);
            List<StatusBarNotification> d10 = d(i11);
            if (d10 != null) {
                for (StatusBarNotification statusBarNotification : d10) {
                    Notification notification2 = statusBarNotification.getNotification();
                    if (notification2 != null && p(notification2) && statusBarNotification.getId() != i10) {
                        Notification.Builder recoverBuilder = Notification.Builder.recoverBuilder(context, statusBarNotification.getNotification());
                        recoverBuilder.setGroup(b(notification2));
                        i11.k(statusBarNotification.getId(), recoverBuilder.build());
                        fc.c.l("group restore notification:" + statusBarNotification.getId());
                    }
                }
                return;
            }
            str = "group restore not get notifications";
        }
        fc.c.i(str);
    }

    public final boolean p(Notification notification) {
        Bundle bundle;
        if (notification == null || notification.getGroup() == null || (bundle = notification.extras) == null) {
            return false;
        }
        return notification.getGroup().equals(String.format("pushmask_%s_%s", Long.valueOf(bundle.getLong("push_src_group_time")), b(notification)));
    }

    public final boolean q(Context context) {
        return j.d(context).i(hv.NotificationAutoGroupSwitch.a(), true);
    }
}
