package com.xiaomi.push.service;

import android.app.ActivityManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import android.widget.RemoteViews;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.quickcard.base.Attributes;
import com.xiaomi.push.g;
import com.xiaomi.push.g7;
import com.xiaomi.push.hq;
import com.xiaomi.push.i4;
import com.xiaomi.push.id;
import com.xiaomi.push.im;
import com.xiaomi.push.service.c;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static long f48207a;

    /* renamed from: b, reason: collision with root package name */
    public static final LinkedList<Pair<Integer, im>> f48208b = new LinkedList<>();

    /* renamed from: c, reason: collision with root package name */
    public static ExecutorService f48209c = Executors.newCachedThreadPool();

    /* renamed from: com.xiaomi.push.service.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class CallableC0715a implements Callable<Bitmap> {

        /* renamed from: b, reason: collision with root package name */
        public String f48210b;

        /* renamed from: c, reason: collision with root package name */
        public Context f48211c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f48212d;

        public CallableC0715a(String str, Context context, boolean z10) {
            this.f48211c = context;
            this.f48210b = str;
            this.f48212d = z10;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Bitmap call() {
            Bitmap bitmap = null;
            if (TextUtils.isEmpty(this.f48210b)) {
                fc.c.i("Failed get online picture/icon resource cause picUrl is empty");
                return null;
            }
            if (this.f48210b.startsWith("http")) {
                c.b d10 = com.xiaomi.push.service.c.d(this.f48211c, this.f48210b, this.f48212d);
                if (d10 != null) {
                    return d10.f48265a;
                }
            } else {
                bitmap = com.xiaomi.push.service.c.b(this.f48211c, this.f48210b);
                if (bitmap != null) {
                    return bitmap;
                }
            }
            fc.c.i("Failed get online picture/icon resource");
            return bitmap;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public Notification f48213a;

        /* renamed from: b, reason: collision with root package name */
        public long f48214b = 0;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public String f48215a;

        /* renamed from: b, reason: collision with root package name */
        public long f48216b = 0;
    }

    public static boolean A(im imVar) {
        id m3002a = imVar.m3002a();
        return z(m3002a) && m3002a.l();
    }

    public static boolean B(String str, String str2) {
        return TextUtils.isEmpty(str) || str2.contains(str);
    }

    public static boolean C(Map<String, String> map) {
        if (map == null || !map.containsKey("notify_foreground")) {
            return true;
        }
        return "1".equals(map.get("notify_foreground"));
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0072, code lost:
    
        r1 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0070, code lost:
    
        if (android.text.TextUtils.isEmpty(r3) == false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x004e, code lost:
    
        if (android.text.TextUtils.isEmpty(r3) == false) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String[] D(android.content.Context r3, com.xiaomi.push.id r4) {
        /*
            java.lang.String r0 = r4.m2978c()
            java.lang.String r1 = r4.d()
            java.util.Map r4 = r4.m2971a()
            if (r4 == 0) goto L73
            android.content.res.Resources r2 = r3.getResources()
            android.util.DisplayMetrics r2 = r2.getDisplayMetrics()
            int r2 = r2.widthPixels
            android.content.res.Resources r3 = r3.getResources()
            android.util.DisplayMetrics r3 = r3.getDisplayMetrics()
            float r3 = r3.density
            float r2 = (float) r2
            float r2 = r2 / r3
            r3 = 1056964608(0x3f000000, float:0.5)
            float r2 = r2 + r3
            java.lang.Float r3 = java.lang.Float.valueOf(r2)
            int r3 = r3.intValue()
            r2 = 320(0x140, float:4.48E-43)
            if (r3 > r2) goto L51
            java.lang.String r3 = "title_short"
            java.lang.Object r3 = r4.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            boolean r2 = android.text.TextUtils.isEmpty(r3)
            if (r2 != 0) goto L42
            r0 = r3
        L42:
            java.lang.String r3 = "description_short"
            java.lang.Object r3 = r4.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            if (r4 != 0) goto L73
            goto L72
        L51:
            r2 = 360(0x168, float:5.04E-43)
            if (r3 <= r2) goto L73
            java.lang.String r3 = "title_long"
            java.lang.Object r3 = r4.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            boolean r2 = android.text.TextUtils.isEmpty(r3)
            if (r2 != 0) goto L64
            r0 = r3
        L64:
            java.lang.String r3 = "description_long"
            java.lang.Object r3 = r4.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            if (r4 != 0) goto L73
        L72:
            r1 = r3
        L73:
            r3 = 2
            java.lang.String[] r3 = new java.lang.String[r3]
            r4 = 0
            r3[r4] = r0
            r4 = 1
            r3[r4] = r1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.a.D(android.content.Context, com.xiaomi.push.id):java.lang.String[]");
    }

    public static int E(Context context, String str) {
        int b4 = b(context, str, "mipush_notification");
        int b10 = b(context, str, "mipush_small_notification");
        if (b4 <= 0) {
            b4 = b10 > 0 ? b10 : context.getApplicationInfo().icon;
        }
        return b4 == 0 ? context.getApplicationInfo().logo : b4;
    }

    public static int F(Map<String, String> map) {
        if (map == null) {
            return 3;
        }
        String str = map.get("channel_importance");
        if (TextUtils.isEmpty(str)) {
            return 3;
        }
        try {
            fc.c.m("importance=3");
            return Integer.parseInt(str);
        } catch (Exception e2) {
            fc.c.n("parsing channel importance error: " + ((Object) e2));
            return 3;
        }
    }

    public static String G(im imVar) {
        return A(imVar) ? "E100002" : M(imVar) ? "E100000" : K(imVar) ? "E100001" : N(imVar) ? "E100003" : "";
    }

    public static void H(Context context, String str) {
        context.getSharedPreferences("pref_notify_type", 0).edit().remove(str).commit();
    }

    public static void I(Context context, String str, int i10) {
        context.getSharedPreferences("pref_notify_type", 0).edit().putInt(str, i10).commit();
    }

    public static boolean J(Context context, String str) {
        return context.getSharedPreferences("pref_notify_type", 0).contains(str);
    }

    public static boolean K(im imVar) {
        id m3002a = imVar.m3002a();
        return z(m3002a) && m3002a.f366b == 1 && !A(imVar);
    }

    public static int L(Map<String, String> map) {
        if (map == null) {
            return 0;
        }
        String str = map.get("notification_priority");
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            fc.c.m("priority=" + str);
            return Integer.parseInt(str);
        } catch (Exception e2) {
            fc.c.n("parsing notification priority error: " + ((Object) e2));
            return 0;
        }
    }

    public static boolean M(im imVar) {
        id m3002a = imVar.m3002a();
        return z(m3002a) && m3002a.f366b == 0 && !A(imVar);
    }

    public static boolean N(im imVar) {
        return imVar.a() == hq.Registration;
    }

    public static boolean O(im imVar) {
        return A(imVar) || M(imVar) || K(imVar);
    }

    public static int a(Context context, String str) {
        return context.getSharedPreferences("pref_notify_type", 0).getInt(str, Integer.MAX_VALUE);
    }

    public static int b(Context context, String str, String str2) {
        if (str.equals(context.getPackageName())) {
            return context.getResources().getIdentifier(str2, "drawable", str);
        }
        return 0;
    }

    public static int c(Map<String, String> map) {
        String str = map == null ? null : map.get("timeout");
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (Exception unused) {
            return 0;
        }
    }

    public static Notification.Builder d(Notification.Builder builder, Context context, String str, Map<String, String> map) {
        PendingIntent i10 = i(context, str, 1, map);
        if (i10 != null && !TextUtils.isEmpty(map.get("notification_style_button_left_name"))) {
            builder.addAction(0, map.get("notification_style_button_left_name"), i10);
        }
        PendingIntent i11 = i(context, str, 2, map);
        if (i11 != null && !TextUtils.isEmpty(map.get("notification_style_button_mid_name"))) {
            builder.addAction(0, map.get("notification_style_button_mid_name"), i11);
        }
        PendingIntent i12 = i(context, str, 3, map);
        if (i12 != null && !TextUtils.isEmpty(map.get("notification_style_button_right_name"))) {
            builder.addAction(0, map.get("notification_style_button_right_name"), i12);
        }
        return builder;
    }

    public static Notification.Builder e(Context context, Map<String, String> map, Notification.Builder builder, String str) {
        if ("2".equals(map.get("notification_style_type"))) {
            Bitmap l10 = l(context, map.get("notification_bigPic_uri"), false);
            if (l10 == null) {
                fc.c.i("can not get big picture.");
                return builder;
            }
            Notification.BigPictureStyle bigPictureStyle = new Notification.BigPictureStyle(builder);
            bigPictureStyle.bigPicture(l10);
            bigPictureStyle.setSummaryText(str);
            bigPictureStyle.bigLargeIcon((Bitmap) null);
            builder.setStyle(bigPictureStyle);
        } else if ("1".equals(map.get("notification_style_type"))) {
            builder.setStyle(new Notification.BigTextStyle().bigText(str));
        }
        return builder;
    }

    public static Notification f(Notification notification) {
        Object d10 = com.xiaomi.push.k0.d(notification, "extraNotification");
        if (d10 != null) {
            com.xiaomi.push.k0.e(d10, "setCustomizedIcon", Boolean.TRUE);
        }
        return notification;
    }

    public static Notification g(Notification notification, String str) {
        try {
            Field declaredField = Notification.class.getDeclaredField("extraNotification");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(notification);
            Method declaredMethod = obj.getClass().getDeclaredMethod("setTargetPkg", CharSequence.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(obj, str);
        } catch (Exception e2) {
            fc.c.k(e2);
        }
        return notification;
    }

    public static PendingIntent h(Context context, im imVar, id idVar, byte[] bArr, int i10) {
        Intent intent;
        ComponentName componentName;
        int i11 = M(imVar) ? 1000 : A(imVar) ? 3000 : -1;
        String m2970a = idVar != null ? idVar.m2970a() : "";
        if (idVar != null && !TextUtils.isEmpty(idVar.f373e)) {
            Intent intent2 = new Intent("android.intent.action.VIEW");
            intent2.setData(Uri.parse(idVar.f373e));
            intent2.addFlags(268435456);
            intent2.putExtra("messageId", m2970a);
            intent2.putExtra("eventMessageType", i11);
            return PendingIntent.getActivity(context, 0, intent2, 134217728);
        }
        if (A(imVar)) {
            intent = new Intent();
            componentName = new ComponentName("com.xiaomi.xmsf", "com.xiaomi.mipush.sdk.PushMessageHandler");
        } else {
            intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
            componentName = new ComponentName(imVar.f456b, "com.xiaomi.mipush.sdk.PushMessageHandler");
        }
        intent.setComponent(componentName);
        intent.putExtra("mipush_payload", bArr);
        intent.putExtra("mipush_notified", true);
        intent.addCategory(String.valueOf(i10));
        intent.addCategory(String.valueOf(m2970a));
        intent.putExtra("messageId", m2970a);
        intent.putExtra("eventMessageType", i11);
        if (!kc.g0.d(context, imVar.f456b, "com.xiaomi.mipush.MESSAGE_CLICKED")) {
            return PendingIntent.getService(context, 0, intent, 134217728);
        }
        Intent intent3 = new Intent();
        intent3.setAction("com.xiaomi.mipush.MESSAGE_CLICKED");
        intent3.setClassName(imVar.f456b, "com.xiaomi.mipush.sdk.BridgeActivity");
        intent3.addFlags(276824064);
        intent3.putExtra("mipush_serviceIntent", intent);
        intent3.addCategory(String.valueOf(i10));
        intent3.addCategory(String.valueOf(m2970a));
        return PendingIntent.getActivity(context, 0, intent3, 134217728);
    }

    public static PendingIntent i(Context context, String str, int i10, Map<String, String> map) {
        Intent j10;
        if (map == null || (j10 = j(context, str, i10, map)) == null) {
            return null;
        }
        return PendingIntent.getActivity(context, 0, j10, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x013f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.content.Intent j(android.content.Context r6, java.lang.String r7, int r8, java.util.Map<java.lang.String, java.lang.String> r9) {
        /*
            Method dump skipped, instructions count: 361
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.a.j(android.content.Context, java.lang.String, int, java.util.Map):android.content.Intent");
    }

    public static Bitmap k(Context context, int i10) {
        return m(context.getResources().getDrawable(i10));
    }

    public static Bitmap l(Context context, String str, boolean z10) {
        Bitmap bitmap;
        Future submit = f48209c.submit(new CallableC0715a(str, context, z10));
        try {
            try {
                bitmap = (Bitmap) submit.get(180L, TimeUnit.SECONDS);
                if (bitmap == null) {
                }
            } catch (InterruptedException | ExecutionException | TimeoutException e2) {
                fc.c.k(e2);
                submit.cancel(true);
                bitmap = null;
            }
            return bitmap;
        } finally {
            submit.cancel(true);
        }
    }

    public static Bitmap m(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        if (intrinsicWidth <= 0) {
            intrinsicWidth = 1;
        }
        int intrinsicHeight = drawable.getIntrinsicHeight();
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight > 0 ? intrinsicHeight : 1, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    public static RemoteViews n(Context context, im imVar, byte[] bArr) {
        id m3002a = imVar.m3002a();
        String r10 = r(imVar);
        Map<String, String> m2971a = m3002a.m2971a();
        if (m2971a == null) {
            return null;
        }
        String str = m2971a.get("layout_name");
        String str2 = m2971a.get("layout_value");
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                Resources resourcesForApplication = context.getPackageManager().getResourcesForApplication(r10);
                int identifier = resourcesForApplication.getIdentifier(str, "layout", r10);
                if (identifier == 0) {
                    return null;
                }
                RemoteViews remoteViews = new RemoteViews(r10, identifier);
                try {
                    JSONObject jSONObject = new JSONObject(str2);
                    if (jSONObject.has("text")) {
                        JSONObject jSONObject2 = jSONObject.getJSONObject("text");
                        Iterator<String> keys = jSONObject2.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            String string = jSONObject2.getString(next);
                            int identifier2 = resourcesForApplication.getIdentifier(next, "id", r10);
                            if (identifier2 > 0) {
                                remoteViews.setTextViewText(identifier2, string);
                            }
                        }
                    }
                    if (jSONObject.has(Attributes.Component.IMAGE)) {
                        JSONObject jSONObject3 = jSONObject.getJSONObject(Attributes.Component.IMAGE);
                        Iterator<String> keys2 = jSONObject3.keys();
                        while (keys2.hasNext()) {
                            String next2 = keys2.next();
                            String string2 = jSONObject3.getString(next2);
                            int identifier3 = resourcesForApplication.getIdentifier(next2, "id", r10);
                            int identifier4 = resourcesForApplication.getIdentifier(string2, "drawable", r10);
                            if (identifier3 > 0) {
                                remoteViews.setImageViewResource(identifier3, identifier4);
                            }
                        }
                    }
                    if (jSONObject.has("time")) {
                        JSONObject jSONObject4 = jSONObject.getJSONObject("time");
                        Iterator<String> keys3 = jSONObject4.keys();
                        while (keys3.hasNext()) {
                            String next3 = keys3.next();
                            String string3 = jSONObject4.getString(next3);
                            if (string3.length() == 0) {
                                string3 = "yy-MM-dd hh:mm";
                            }
                            int identifier5 = resourcesForApplication.getIdentifier(next3, "id", r10);
                            if (identifier5 > 0) {
                                remoteViews.setTextViewText(identifier5, new SimpleDateFormat(string3).format(new Date(System.currentTimeMillis())));
                            }
                        }
                    }
                    return remoteViews;
                } catch (JSONException e2) {
                    fc.c.k(e2);
                    return null;
                }
            } catch (PackageManager.NameNotFoundException e10) {
                fc.c.k(e10);
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x048f  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x04ac  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x04d2  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x04dd  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x04f3  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x051a  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x04a5  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x042e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0457  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0472  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0121 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x024d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.xiaomi.push.service.a.b o(android.content.Context r25, com.xiaomi.push.im r26, byte[] r27, android.widget.RemoteViews r28, android.app.PendingIntent r29) {
        /*
            Method dump skipped, instructions count: 1336
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.a.o(android.content.Context, com.xiaomi.push.im, byte[], android.widget.RemoteViews, android.app.PendingIntent):com.xiaomi.push.service.a$b");
    }

    public static c p(Context context, im imVar, byte[] bArr) {
        String str;
        c cVar = new c();
        g.a c4 = com.xiaomi.push.g.c(context, r(imVar), true);
        if (kc.i.e(context) && c4 == g.a.NOT_ALLOWED) {
            id m3002a = imVar.m3002a();
            if (m3002a != null) {
                i4.a(context.getApplicationContext()).h(imVar.b(), G(imVar), m3002a.m2970a(), "10:" + r(imVar));
            }
            str = "Do not notify because user block " + r(imVar) + "‘s notification";
        } else {
            id m3002a2 = imVar.m3002a();
            RemoteViews n10 = n(context, imVar, bArr);
            int hashCode = ((r(imVar).hashCode() / 10) * 10) + (m3002a2 != null ? m3002a2.c() : 0);
            PendingIntent h10 = h(context, imVar, m3002a2, bArr, hashCode);
            if (h10 != null) {
                b o10 = o(context, imVar, bArr, n10, h10);
                cVar.f48216b = o10.f48214b;
                cVar.f48215a = r(imVar);
                Notification notification = o10.f48213a;
                if (g7.f()) {
                    if (!TextUtils.isEmpty(m3002a2.m2970a())) {
                        notification.extras.putString("message_id", m3002a2.m2970a());
                    }
                    String str2 = m3002a2.m2976b() == null ? null : m3002a2.m2976b().get("score_info");
                    if (!TextUtils.isEmpty(str2)) {
                        notification.extras.putString("score_info", str2);
                    }
                    int i10 = -1;
                    if (M(imVar)) {
                        i10 = 1000;
                    } else if (A(imVar)) {
                        i10 = 3000;
                    }
                    notification.extras.putString("eventMessageType", String.valueOf(i10));
                    notification.extras.putString(HiAnalyticsConstant.BI_KEY_TARGET_PACKAGE, r(imVar));
                }
                String str3 = m3002a2.m2971a() != null ? m3002a2.m2971a().get("message_count") : null;
                if (g7.f() && str3 != null) {
                    try {
                        s(notification, Integer.parseInt(str3));
                    } catch (NumberFormatException e2) {
                        i4.a(context.getApplicationContext()).i(imVar.b(), G(imVar), m3002a2.m2970a(), "8");
                        fc.c.k(e2);
                    }
                }
                if (!g7.j() && "com.xiaomi.xmsf".equals(context.getPackageName())) {
                    g(notification, r(imVar));
                }
                kc.h i11 = kc.h.i(context, r(imVar));
                i11.k(hashCode, notification);
                if (g7.f() && "com.xiaomi.xmsf".equals(context.getPackageName())) {
                    kc.f.e().f(context, hashCode, notification);
                }
                if (A(imVar)) {
                    i4.a(context.getApplicationContext()).g(imVar.b(), G(imVar), m3002a2.m2970a(), 3002, null);
                }
                if (M(imVar)) {
                    i4.a(context.getApplicationContext()).g(imVar.b(), G(imVar), m3002a2.m2970a(), 1002, null);
                }
                if (Build.VERSION.SDK_INT < 26) {
                    com.xiaomi.push.n c10 = com.xiaomi.push.n.c(context);
                    c10.i(hashCode);
                    int c11 = c(m3002a2.m2971a());
                    if (c11 > 0) {
                        c10.n(new com.xiaomi.push.service.b(hashCode, i11), c11);
                    }
                }
                Pair<Integer, im> pair = new Pair<>(Integer.valueOf(hashCode), imVar);
                LinkedList<Pair<Integer, im>> linkedList = f48208b;
                synchronized (linkedList) {
                    linkedList.add(pair);
                    if (linkedList.size() > 100) {
                        linkedList.remove();
                    }
                }
                return cVar;
            }
            if (m3002a2 != null) {
                i4.a(context.getApplicationContext()).h(imVar.b(), G(imVar), m3002a2.m2970a(), "11");
            }
            str = "The click PendingIntent is null. ";
        }
        fc.c.i(str);
        return cVar;
    }

    public static String q(Context context, String str, Map<String, String> map) {
        return (map == null || TextUtils.isEmpty(map.get("channel_name"))) ? com.xiaomi.push.g.i(context, str) : map.get("channel_name");
    }

    public static String r(im imVar) {
        id m3002a;
        if ("com.xiaomi.xmsf".equals(imVar.f456b) && (m3002a = imVar.m3002a()) != null && m3002a.m2971a() != null) {
            String str = m3002a.m2971a().get("miui_package_name");
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return imVar.f456b;
    }

    public static void s(Notification notification, int i10) {
        Object d10 = com.xiaomi.push.k0.d(notification, "extraNotification");
        if (d10 != null) {
            com.xiaomi.push.k0.e(d10, "setMessageCount", Integer.valueOf(i10));
        }
    }

    public static void t(Context context, String str) {
        u(context, str, -1);
    }

    public static void u(Context context, String str, int i10) {
        kc.h i11 = kc.h.i(context, str);
        int hashCode = ((str.hashCode() / 10) * 10) + i10;
        LinkedList linkedList = new LinkedList();
        if (i10 >= 0) {
            i11.j(hashCode);
        }
        LinkedList<Pair<Integer, im>> linkedList2 = f48208b;
        synchronized (linkedList2) {
            Iterator<Pair<Integer, im>> it = linkedList2.iterator2();
            while (it.hasNext()) {
                Pair<Integer, im> next = it.next();
                im imVar = (im) next.second;
                if (imVar != null) {
                    String r10 = r(imVar);
                    if (i10 >= 0) {
                        if (hashCode == ((Integer) next.first).intValue() && TextUtils.equals(r10, str)) {
                            linkedList.add(next);
                        }
                    } else if (i10 == -1 && TextUtils.equals(r10, str)) {
                        i11.j(((Integer) next.first).intValue());
                        linkedList.add(next);
                    }
                }
            }
            LinkedList<Pair<Integer, im>> linkedList3 = f48208b;
            if (linkedList3 != null) {
                linkedList3.removeAll(linkedList);
                w(context, linkedList);
            }
        }
    }

    public static void v(Context context, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        LinkedList<Pair<Integer, im>> linkedList2 = f48208b;
        synchronized (linkedList2) {
            Iterator<Pair<Integer, im>> it = linkedList2.iterator2();
            while (it.hasNext()) {
                Pair<Integer, im> next = it.next();
                im imVar = (im) next.second;
                if (imVar != null) {
                    String r10 = r(imVar);
                    id m3002a = imVar.m3002a();
                    if (m3002a != null && TextUtils.equals(r10, str)) {
                        String m2978c = m3002a.m2978c();
                        String d10 = m3002a.d();
                        if (!TextUtils.isEmpty(m2978c) && !TextUtils.isEmpty(d10) && B(str2, m2978c) && B(str3, d10)) {
                            kc.h.i(context, str).j(((Integer) next.first).intValue());
                            linkedList.add(next);
                        }
                    }
                }
            }
            LinkedList<Pair<Integer, im>> linkedList3 = f48208b;
            if (linkedList3 != null) {
                linkedList3.removeAll(linkedList);
                w(context, linkedList);
            }
        }
    }

    public static void w(Context context, LinkedList<? extends Object> linkedList) {
        if (linkedList == null || linkedList.size() <= 0) {
            return;
        }
        kc.z.c(context, "category_clear_notification", "clear_notification", linkedList.size(), "");
    }

    public static void x(Object obj, Map<String, String> map) {
        if (map == null || TextUtils.isEmpty(map.get("channel_description"))) {
            return;
        }
        com.xiaomi.push.k0.e(obj, "setDescription", map.get("channel_description"));
    }

    public static boolean y(Context context, String str) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.importance == 100 && Arrays.asList(runningAppProcessInfo.pkgList).contains(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean z(id idVar) {
        if (idVar == null) {
            return false;
        }
        String m2970a = idVar.m2970a();
        return !TextUtils.isEmpty(m2970a) && m2970a.length() == 22 && "satuigmo".indexOf(m2970a.charAt(0)) >= 0;
    }
}
