package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.os.IBinder;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.MessageHandleService;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.push.fk;
import com.xiaomi.push.hu;
import com.xiaomi.push.i4;
import com.xiaomi.push.n7;
import com.xiaomi.push.o6;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class PushMessageHandler extends BaseService {

    /* renamed from: c, reason: collision with root package name */
    public static List<MiPushClient.ICallbackResult> f46950c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public static List<MiPushClient.a> f46951d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    public static ThreadPoolExecutor f46952e = new ThreadPoolExecutor(1, 1, 15, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface a extends Serializable {
    }

    public static void b() {
        synchronized (f46951d) {
            f46951d.clear();
        }
    }

    public static void c(long j10, String str, String str2) {
        synchronized (f46951d) {
            Iterator<MiPushClient.a> iterator2 = f46951d.iterator2();
            while (iterator2.hasNext()) {
                iterator2.next().c(j10, str, str2);
            }
        }
    }

    public static void d(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, (Class<?>) PushMessageHandler.class));
        try {
            context.startService(intent);
        } catch (Exception e2) {
            fc.c.i(e2.getMessage());
        }
    }

    public static void e(Context context, Intent intent) {
        fc.c.m("addjob PushMessageHandler " + ((Object) intent));
        if (intent != null) {
            s(context, intent);
            d(context);
        }
    }

    public static void f(Context context, Intent intent, ResolveInfo resolveInfo) {
        try {
            MessageHandleService.d(context.getApplicationContext(), new MessageHandleService.a(intent, (PushMessageReceiver) n7.c(context, resolveInfo.activityInfo.name).newInstance()));
            MessageHandleService.c(context, new Intent(context.getApplicationContext(), (Class<?>) MessageHandleService.class));
        } catch (Throwable th) {
            fc.c.k(th);
        }
    }

    public static void g(Context context, MiPushCommandMessage miPushCommandMessage) {
        synchronized (f46950c) {
            for (MiPushClient.ICallbackResult iCallbackResult : f46950c) {
            }
        }
    }

    public static void h(Context context, MiPushMessage miPushMessage) {
        synchronized (f46951d) {
            for (MiPushClient.a aVar : f46951d) {
                if (n(miPushMessage.getCategory(), aVar.a())) {
                    aVar.e(miPushMessage.getContent(), miPushMessage.getAlias(), miPushMessage.getTopic(), miPushMessage.isNotified());
                    aVar.d(miPushMessage);
                }
            }
        }
    }

    public static void i(Context context, a aVar) {
        if (aVar instanceof MiPushMessage) {
            h(context, (MiPushMessage) aVar);
            return;
        }
        if (aVar instanceof MiPushCommandMessage) {
            MiPushCommandMessage miPushCommandMessage = (MiPushCommandMessage) aVar;
            String command = miPushCommandMessage.getCommand();
            String str = null;
            if (fk.COMMAND_REGISTER.f266a.equals(command)) {
                List<String> commandArguments = miPushCommandMessage.getCommandArguments();
                if (commandArguments != null && !commandArguments.isEmpty()) {
                    str = commandArguments.get(0);
                }
                c(miPushCommandMessage.getResultCode(), miPushCommandMessage.getReason(), str);
                return;
            }
            if (fk.COMMAND_SET_ALIAS.f266a.equals(command) || fk.COMMAND_UNSET_ALIAS.f266a.equals(command) || fk.COMMAND_SET_ACCEPT_TIME.f266a.equals(command)) {
                k(context, miPushCommandMessage.getCategory(), command, miPushCommandMessage.getResultCode(), miPushCommandMessage.getReason(), miPushCommandMessage.getCommandArguments());
                return;
            }
            if (fk.COMMAND_SUBSCRIBE_TOPIC.f266a.equals(command)) {
                List<String> commandArguments2 = miPushCommandMessage.getCommandArguments();
                if (commandArguments2 != null && !commandArguments2.isEmpty()) {
                    str = commandArguments2.get(0);
                }
                j(context, miPushCommandMessage.getCategory(), miPushCommandMessage.getResultCode(), miPushCommandMessage.getReason(), str);
                return;
            }
            if (fk.COMMAND_UNSUBSCRIBE_TOPIC.f266a.equals(command)) {
                List<String> commandArguments3 = miPushCommandMessage.getCommandArguments();
                if (commandArguments3 != null && !commandArguments3.isEmpty()) {
                    str = commandArguments3.get(0);
                }
                q(context, miPushCommandMessage.getCategory(), miPushCommandMessage.getResultCode(), miPushCommandMessage.getReason(), str);
            }
        }
    }

    public static void j(Context context, String str, long j10, String str2, String str3) {
        synchronized (f46951d) {
            for (MiPushClient.a aVar : f46951d) {
                if (n(str, aVar.a())) {
                    aVar.f(j10, str2, str3);
                }
            }
        }
    }

    public static void k(Context context, String str, String str2, long j10, String str3, List<String> list) {
        synchronized (f46951d) {
            for (MiPushClient.a aVar : f46951d) {
                if (n(str, aVar.a())) {
                    aVar.b(str2, j10, str3, list);
                }
            }
        }
    }

    public static void l(MiPushClient.ICallbackResult iCallbackResult) {
        synchronized (f46950c) {
            if (!f46950c.contains(iCallbackResult)) {
                f46950c.add(iCallbackResult);
            }
        }
    }

    public static void m(MiPushClient.a aVar) {
        synchronized (f46951d) {
            if (!f46951d.contains(aVar)) {
                f46951d.add(aVar);
            }
        }
    }

    public static boolean n(String str, String str2) {
        return (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) || TextUtils.equals(str, str2);
    }

    public static void o() {
        synchronized (f46950c) {
            f46950c.clear();
        }
    }

    public static void p(Context context, Intent intent) {
        try {
            ResolveInfo resolveInfo = null;
            if ("com.xiaomi.mipush.sdk.WAKEUP".equals(intent.getAction())) {
                z0.a(context, intent, null);
                return;
            }
            if ("com.xiaomi.mipush.SEND_TINYDATA".equals(intent.getAction())) {
                hu huVar = new hu();
                o6.b(huVar, intent.getByteArrayExtra("mipush_payload"));
                fc.c.m("PushMessageHandler.onHandleIntent " + huVar.d());
                n.a(context, huVar);
                return;
            }
            if (1 == p.c(context)) {
                if (r()) {
                    fc.c.n("receive a message before application calling initialize");
                    return;
                }
                a b4 = e0.e(context).b(intent);
                if (b4 != null) {
                    i(context, b4);
                    return;
                }
                return;
            }
            if ("com.xiaomi.mipush.sdk.SYNC_LOG".equals(intent.getAction())) {
                g.f(context, false);
                return;
            }
            Intent intent2 = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
            intent2.setPackage(context.getPackageName());
            intent2.putExtras(intent);
            try {
                List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent2, 32);
                if (queryBroadcastReceivers != null) {
                    Iterator<ResolveInfo> iterator2 = queryBroadcastReceivers.iterator2();
                    while (true) {
                        if (!iterator2.hasNext()) {
                            break;
                        }
                        ResolveInfo next = iterator2.next();
                        ActivityInfo activityInfo = next.activityInfo;
                        if (activityInfo != null && activityInfo.packageName.equals(context.getPackageName()) && PushMessageReceiver.class.isAssignableFrom(n7.c(context, next.activityInfo.name))) {
                            resolveInfo = next;
                            break;
                        }
                    }
                }
                if (resolveInfo != null) {
                    f(context, intent2, resolveInfo);
                } else {
                    fc.c.n("cannot find the receiver to handler this message, check your manifest");
                    i4.a(context).e(context.getPackageName(), intent, "11");
                }
            } catch (Exception e2) {
                fc.c.k(e2);
                i4.a(context).e(context.getPackageName(), intent, "9");
            }
        } catch (Throwable th) {
            fc.c.k(th);
            i4.a(context).e(context.getPackageName(), intent, "10");
        }
    }

    public static void q(Context context, String str, long j10, String str2, String str3) {
        synchronized (f46951d) {
            for (MiPushClient.a aVar : f46951d) {
                if (n(str, aVar.a())) {
                    aVar.g(j10, str2, str3);
                }
            }
        }
    }

    public static boolean r() {
        return f46951d.isEmpty();
    }

    public static void s(Context context, Intent intent) {
        if (intent == null || f46952e.isShutdown()) {
            return;
        }
        f46952e.execute(new d0(context, intent));
    }

    @Override // com.xiaomi.mipush.sdk.BaseService
    public boolean a() {
        ThreadPoolExecutor threadPoolExecutor = f46952e;
        return (threadPoolExecutor == null || threadPoolExecutor.getQueue() == null || f46952e.getQueue().size() <= 0) ? false : true;
    }

    @Override // com.xiaomi.mipush.sdk.BaseService, android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // com.xiaomi.mipush.sdk.BaseService, android.app.Service
    public void onStart(Intent intent, int i10) {
        super.onStart(intent, i10);
        s(getApplicationContext(), intent);
    }
}
