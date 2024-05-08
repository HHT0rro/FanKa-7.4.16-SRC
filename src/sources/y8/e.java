package y8;

import android.content.Context;
import android.content.Intent;
import com.heytap.msp.push.mode.MessageStat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class e {
    public static void a(Context context, MessageStat messageStat) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(messageStat);
        b(context, linkedList);
    }

    public static void b(Context context, List<MessageStat> list) {
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(list);
        c.a("isSupportStatisticByMcs:" + c(context) + ",list size:" + linkedList.size());
        if (linkedList.size() <= 0 || !c(context)) {
            return;
        }
        d(context, linkedList);
    }

    public static boolean c(Context context) {
        String D = t8.b.C().D();
        return g.c(context, D) && g.e(context, D) >= 1017;
    }

    public static void d(Context context, List<MessageStat> list) {
        try {
            Intent intent = new Intent();
            intent.setAction(t8.b.C().E());
            intent.setPackage(t8.b.C().D());
            intent.putExtra("appPackage", context.getPackageName());
            intent.putExtra("type", 12291);
            intent.putExtra("count", list.size());
            ArrayList<String> arrayList = new ArrayList<>();
            Iterator<MessageStat> iterator2 = list.iterator2();
            while (iterator2.hasNext()) {
                arrayList.add(iterator2.next().toJsonObject());
            }
            intent.putStringArrayListExtra("list", arrayList);
            context.startService(intent);
        } catch (Exception e2) {
            c.b("statisticMessage--Exception" + e2.getMessage());
        }
    }
}
