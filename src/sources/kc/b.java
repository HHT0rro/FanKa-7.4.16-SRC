package kc;

import android.content.SharedPreferences;
import com.xiaomi.push.p0;
import com.xiaomi.push.service.XMPushService;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static Object f50776a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static Map<String, Queue<String>> f50777b = new HashMap();

    public static boolean a(XMPushService xMPushService, String str, String str2) {
        synchronized (f50776a) {
            SharedPreferences sharedPreferences = xMPushService.getSharedPreferences("push_message_ids", 0);
            Queue<String> queue = f50777b.get(str);
            if (queue == null) {
                String[] split = sharedPreferences.getString(str, "").split(",");
                LinkedList linkedList = new LinkedList();
                for (String str3 : split) {
                    linkedList.add(str3);
                }
                f50777b.put(str, linkedList);
                queue = linkedList;
            }
            if (queue.contains(str2)) {
                return true;
            }
            queue.add(str2);
            if (queue.size() > 25) {
                queue.poll();
            }
            String d10 = p0.d(queue, ",");
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString(str, d10);
            edit.commit();
            return false;
        }
    }
}
