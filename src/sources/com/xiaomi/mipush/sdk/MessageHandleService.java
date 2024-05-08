package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.turingface.sdk.mfa.ITuringIoTFeatureMap;
import com.xiaomi.mipush.sdk.PushMessageHandler;
import com.xiaomi.push.fk;
import com.xiaomi.push.i4;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class MessageHandleService extends BaseService {

    /* renamed from: c, reason: collision with root package name */
    public static ConcurrentLinkedQueue<a> f46942c = new ConcurrentLinkedQueue<>();

    /* renamed from: d, reason: collision with root package name */
    public static ExecutorService f46943d = new ThreadPoolExecutor(1, 1, 15, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public PushMessageReceiver f46944a;

        /* renamed from: b, reason: collision with root package name */
        public Intent f46945b;

        public a(Intent intent, PushMessageReceiver pushMessageReceiver) {
            this.f46944a = pushMessageReceiver;
            this.f46945b = intent;
        }

        public Intent a() {
            return this.f46945b;
        }

        public PushMessageReceiver b() {
            return this.f46944a;
        }
    }

    public static void c(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        e(context);
    }

    public static void d(Context context, a aVar) {
        if (aVar != null) {
            f46942c.add(aVar);
            e(context);
            g(context);
        }
    }

    public static void e(Context context) {
        if (f46943d.isShutdown()) {
            return;
        }
        f46943d.execute(new s(context));
    }

    public static void f(Context context) {
        String[] stringArrayExtra;
        try {
            a poll = f46942c.poll();
            if (poll == null) {
                return;
            }
            PushMessageReceiver b4 = poll.b();
            Intent a10 = poll.a();
            int intExtra = a10.getIntExtra(RemoteMessageConst.MSGTYPE, 1);
            if (intExtra == 1) {
                PushMessageHandler.a b10 = e0.e(context).b(a10);
                int intExtra2 = a10.getIntExtra("eventMessageType", -1);
                if (b10 == null) {
                    return;
                }
                if (b10 instanceof MiPushMessage) {
                    MiPushMessage miPushMessage = (MiPushMessage) b10;
                    if (!miPushMessage.isArrivedMessage()) {
                        b4.onReceiveMessage(context, miPushMessage);
                    }
                    if (miPushMessage.getPassThrough() == 1) {
                        i4.a(context.getApplicationContext()).d(context.getPackageName(), a10, 2004, null);
                        fc.c.i("begin execute onReceivePassThroughMessage from " + miPushMessage.getMessageId());
                        b4.onReceivePassThroughMessage(context, miPushMessage);
                        return;
                    }
                    if (!miPushMessage.isNotified()) {
                        b4.onNotificationMessageArrived(context, miPushMessage);
                        return;
                    }
                    if (intExtra2 == 1000) {
                        i4.a(context.getApplicationContext()).d(context.getPackageName(), a10, 1007, null);
                    } else {
                        i4.a(context.getApplicationContext()).d(context.getPackageName(), a10, ITuringIoTFeatureMap.RIOT_SIM_NUMBER, null);
                    }
                    fc.c.i("begin execute onNotificationMessageClicked from\u3000" + miPushMessage.getMessageId());
                    b4.onNotificationMessageClicked(context, miPushMessage);
                    return;
                }
                if (!(b10 instanceof MiPushCommandMessage)) {
                    return;
                }
                MiPushCommandMessage miPushCommandMessage = (MiPushCommandMessage) b10;
                fc.c.i("begin execute onCommandResult, command=" + miPushCommandMessage.getCommand() + ", resultCode=" + miPushCommandMessage.getResultCode() + ", reason=" + miPushCommandMessage.getReason());
                b4.onCommandResult(context, miPushCommandMessage);
                if (!TextUtils.equals(miPushCommandMessage.getCommand(), fk.COMMAND_REGISTER.f266a)) {
                    return;
                }
                b4.onReceiveRegisterResult(context, miPushCommandMessage);
                PushMessageHandler.g(context, miPushCommandMessage);
                if (miPushCommandMessage.getResultCode() != 0) {
                    return;
                }
            } else {
                if (intExtra != 3) {
                    if (intExtra == 5 && "error_lack_of_permission".equals(a10.getStringExtra("error_type")) && (stringArrayExtra = a10.getStringArrayExtra("error_message")) != null) {
                        fc.c.i("begin execute onRequirePermissions, lack of necessary permissions");
                        b4.onRequirePermissions(context, stringArrayExtra);
                        return;
                    }
                    return;
                }
                MiPushCommandMessage miPushCommandMessage2 = (MiPushCommandMessage) a10.getSerializableExtra("key_command");
                fc.c.i("(Local) begin execute onCommandResult, command=" + miPushCommandMessage2.getCommand() + ", resultCode=" + miPushCommandMessage2.getResultCode() + ", reason=" + miPushCommandMessage2.getReason());
                b4.onCommandResult(context, miPushCommandMessage2);
                if (!TextUtils.equals(miPushCommandMessage2.getCommand(), fk.COMMAND_REGISTER.f266a)) {
                    return;
                }
                b4.onReceiveRegisterResult(context, miPushCommandMessage2);
                PushMessageHandler.g(context, miPushCommandMessage2);
                if (miPushCommandMessage2.getResultCode() != 0) {
                    return;
                }
            }
            t0.f(context);
        } catch (RuntimeException e2) {
            fc.c.k(e2);
        }
    }

    public static void g(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, (Class<?>) MessageHandleService.class));
        com.xiaomi.push.n.c(context).g(new r(context, intent));
    }

    @Override // com.xiaomi.mipush.sdk.BaseService
    public boolean a() {
        ConcurrentLinkedQueue<a> concurrentLinkedQueue = f46942c;
        return concurrentLinkedQueue != null && concurrentLinkedQueue.size() > 0;
    }

    @Override // com.xiaomi.mipush.sdk.BaseService, android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // com.xiaomi.mipush.sdk.BaseService, android.app.Service
    public void onStart(Intent intent, int i10) {
        super.onStart(intent, i10);
    }
}
