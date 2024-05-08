package com.vivo.push.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.HandlerThread;
import com.vivo.push.PushClient;
import com.vivo.push.cache.ClientConfigManagerImpl;
import com.vivo.push.m;
import com.vivo.push.util.ContextDelegate;
import com.vivo.push.util.VivoPushException;
import com.vivo.push.util.u;
import com.vivo.push.util.x;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class PushServiceReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    private static HandlerThread f46363a;

    /* renamed from: b, reason: collision with root package name */
    private static Handler f46364b;

    /* renamed from: c, reason: collision with root package name */
    private static a f46365c = new a();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private Context f46366a;

        /* renamed from: b, reason: collision with root package name */
        private String f46367b;

        public static /* synthetic */ void a(a aVar, Context context, String str) {
            aVar.f46366a = ContextDelegate.getContext(context);
            aVar.f46367b = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            NetworkInfo a10 = x.a(this.f46366a);
            if (!(a10 != null ? a10.isConnectedOrConnecting() : false)) {
                u.d("PushServiceReceiver", this.f46366a.getPackageName() + ": 无网络  by " + this.f46367b);
                u.a(this.f46366a, "触发静态广播:无网络(" + this.f46367b + "," + this.f46366a.getPackageName() + ")");
                return;
            }
            u.d("PushServiceReceiver", this.f46366a.getPackageName() + ": 执行开始出发动作: " + this.f46367b);
            u.a(this.f46366a, "触发静态广播(" + this.f46367b + "," + this.f46366a.getPackageName() + ")");
            m.a().a(this.f46366a);
            if (ClientConfigManagerImpl.getInstance(this.f46366a).isCancleBroadcastReceiver()) {
                return;
            }
            try {
                PushClient.getInstance(this.f46366a).initialize(com.vivo.push.restructure.a.a().e().l());
            } catch (VivoPushException e2) {
                e2.printStackTrace();
                u.a(this.f46366a, " 初始化异常 error= " + e2.getMessage());
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Context context2 = ContextDelegate.getContext(context);
        String action = intent.getAction();
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action) || "android.intent.action.ACTION_POWER_CONNECTED".equals(action) || "android.intent.action.ACTION_POWER_DISCONNECTED".equals(action)) {
            if (f46363a == null) {
                HandlerThread handlerThread = new HandlerThread("PushServiceReceiver");
                f46363a = handlerThread;
                handlerThread.start();
                f46364b = new Handler(f46363a.getLooper());
            }
            u.d("PushServiceReceiver", context2.getPackageName() + ": start PushSerevice for by " + action + "  ; handler : " + ((Object) f46364b));
            a.a(f46365c, context2, action);
            f46364b.removeCallbacks(f46365c);
            f46364b.postDelayed(f46365c, 2000L);
        }
    }
}
