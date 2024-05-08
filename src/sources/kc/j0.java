package kc;

import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import com.xiaomi.push.gh;
import com.xiaomi.push.service.XMPushService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class j0 {

    /* renamed from: a, reason: collision with root package name */
    public static final Map<String, byte[]> f50813a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public static ArrayList<Pair<String, byte[]>> f50814b = new ArrayList<>();

    public static void a(Context context, int i10, String str) {
        Map<String, byte[]> map = f50813a;
        synchronized (map) {
            for (String str2 : map.h()) {
                b(context, str2, f50813a.get(str2), i10, str);
            }
            f50813a.clear();
        }
    }

    public static void b(Context context, String str, byte[] bArr, int i10, String str2) {
        Intent intent = new Intent("com.xiaomi.mipush.ERROR");
        intent.setPackage(str);
        intent.putExtra("mipush_payload", bArr);
        intent.putExtra("mipush_error_code", i10);
        intent.putExtra("mipush_error_msg", str2);
        context.sendBroadcast(intent, com.xiaomi.push.service.j0.f(str));
    }

    public static void c(XMPushService xMPushService) {
        try {
            Map<String, byte[]> map = f50813a;
            synchronized (map) {
                for (String str : map.h()) {
                    com.xiaomi.push.service.j0.k(xMPushService, str, f50813a.get(str));
                }
                f50813a.clear();
            }
        } catch (gh e2) {
            fc.c.k(e2);
            xMPushService.r(10, e2);
        }
    }

    public static void d(String str, byte[] bArr) {
        Map<String, byte[]> map = f50813a;
        synchronized (map) {
            map.put(str, bArr);
        }
    }

    public static void e(XMPushService xMPushService) {
        ArrayList<Pair<String, byte[]>> arrayList;
        try {
            synchronized (f50814b) {
                arrayList = f50814b;
                f50814b = new ArrayList<>();
            }
            Iterator<Pair<String, byte[]>> iterator2 = arrayList.iterator2();
            while (iterator2.hasNext()) {
                Pair<String, byte[]> next = iterator2.next();
                com.xiaomi.push.service.j0.k(xMPushService, (String) next.first, (byte[]) next.second);
            }
        } catch (gh e2) {
            fc.c.k(e2);
            xMPushService.r(10, e2);
        }
    }

    public static void f(String str, byte[] bArr) {
        synchronized (f50814b) {
            f50814b.add(new Pair<>(str, bArr));
            if (f50814b.size() > 50) {
                f50814b.remove(0);
            }
        }
    }
}
