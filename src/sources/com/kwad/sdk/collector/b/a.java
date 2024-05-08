package com.kwad.sdk.collector.b;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.os.RemoteException;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.api.proxy.app.ServiceProxyRemote;
import com.kwad.sdk.collector.AppStatusRules;
import com.kwad.sdk.collector.d;
import com.kwad.sdk.collector.model.b;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.utils.SystemUtil;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.f;
import com.kwad.sdk.utils.t;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class a extends com.kwad.sdk.m.a {
    private static AtomicBoolean anJ = new AtomicBoolean(false);
    public static volatile Message anK;
    private HandlerC0512a anH = new HandlerC0512a(0);
    private Messenger anI = new Messenger(this.anH);

    /* renamed from: com.kwad.sdk.collector.b.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class HandlerC0512a extends Handler {
        private WeakReference<Service> anM;

        private HandlerC0512a() {
        }

        public final void a(@Nullable Service service) {
            if (service != null) {
                this.anM = new WeakReference<>(service);
            } else {
                this.anM = null;
            }
        }

        @Override // android.os.Handler
        public final void handleMessage(@NonNull Message message) {
            super.handleMessage(message);
            c.d("RemoteService", "handleMessage");
            WeakReference<Service> weakReference = this.anM;
            Service service = weakReference != null ? weakReference.get() : null;
            if (service == null) {
                return;
            }
            if (!a.AF().get()) {
                c.d("RemoteService", "save buffered message");
                a.anK = Message.obtain(message);
                return;
            }
            final Messenger messenger = message.replyTo;
            int i10 = message.what;
            c.d("RemoteService", "handleMessage what: " + i10);
            if (i10 != 100) {
                return;
            }
            final Bundle bundle = new Bundle();
            f.a(service, new f.b() { // from class: com.kwad.sdk.collector.b.a.a.1
                @Override // com.kwad.sdk.utils.f.b
                public final void u(List<b> list) {
                    c.d("RemoteService", "RemoteService: onAppStatusResult list: " + ((Object) list));
                    if (list != null && !list.isEmpty()) {
                        c.d("RemoteService", "RemoteService: onAppStatusResult: " + list.size());
                        JSONArray L = f.a.L(list);
                        String jSONArray = L != null ? L.toString() : null;
                        c.d("RemoteService", "resultJson :" + jSONArray);
                        if (jSONArray != null) {
                            AppStatusRules KR = f.KR();
                            ArrayList<AppStatusRules.Strategy> allStrategy = KR != null ? KR.getAllStrategy() : null;
                            String jSONArray2 = allStrategy != null ? t.O(allStrategy).toString() : null;
                            bundle.putString("resultJson", jSONArray);
                            bundle.putString("allStrategyJson", jSONArray2);
                        }
                    }
                    try {
                        Message obtain = Message.obtain();
                        obtain.what = 101;
                        obtain.setData(bundle);
                        messenger.send(obtain);
                    } catch (RemoteException unused) {
                    }
                    if (list == null || list.isEmpty()) {
                        return;
                    }
                    Iterator<b> iterator2 = list.iterator2();
                    while (iterator2.hasNext()) {
                        iterator2.next().destroy();
                    }
                }
            });
        }

        public /* synthetic */ HandlerC0512a(byte b4) {
            this();
        }
    }

    public static AtomicBoolean AF() {
        return anJ;
    }

    private static boolean aO(Context context) {
        String processName = aq.getProcessName(context);
        return (processName == null || context.getPackageName().equals(processName)) ? false : true;
    }

    public static void b(@NonNull Context context, ServiceConnection serviceConnection) {
        c.d("RemoteService", "unbindASService");
        try {
            context.unbindService(serviceConnection);
        } catch (Exception e2) {
            c.printStackTrace(e2);
        }
    }

    @InvokeBy(invokerClass = com.kwad.sdk.service.b.class, methodId = "initComponentProxyForInvoker")
    public static void register() {
        try {
            com.kwad.sdk.service.b.a(Class.forName("com.kwad.sdk.api.proxy.app.ServiceProxyRemote"), a.class);
        } catch (Throwable unused) {
        }
    }

    @Override // com.kwad.sdk.m.a, com.kwad.sdk.api.proxy.IServiceProxy
    public IBinder onBind(@NonNull Service service, Intent intent) {
        return this.anI.getBinder();
    }

    @Override // com.kwad.sdk.m.a, com.kwad.sdk.api.proxy.IServiceProxy
    public void onCreate(Service service) {
        super.onCreate(service);
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                WebView.setDataDirectorySuffix(aq.getProcessName(service.getApplicationContext()));
            } catch (Exception e2) {
                c.d("RemoteService", "WebView has already been initialized " + e2.getMessage());
            }
        }
        c.d("RemoteService", "onCreate processName:" + aq.getProcessName(service));
        if (!SystemUtil.isInMainProcess(service)) {
            d.a(service, new d.a() { // from class: com.kwad.sdk.collector.b.a.1
                @Override // com.kwad.sdk.collector.d.a
                public final void cq(String str) {
                    c.e("RemoteService", "onLoadError: " + str);
                    a.anJ.set(false);
                }

                @Override // com.kwad.sdk.collector.d.a
                public final void onLoaded() {
                    c.d("RemoteService", "onLoaded");
                    a.anJ.set(true);
                    if (a.anK != null) {
                        a.this.anH.handleMessage(a.anK);
                        a.anK = null;
                    }
                }
            });
        } else {
            anJ.set(true);
        }
        this.anH.a(service);
    }

    @Override // com.kwad.sdk.m.a, com.kwad.sdk.api.proxy.IServiceProxy
    public void onDestroy(@NonNull Service service) {
        super.onDestroy(service);
        c.d("RemoteService", "onDestroy");
        this.anH.a(null);
        if (aO(service)) {
            c.d("RemoteService", "goto kill myself");
            Process.killProcess(Process.myPid());
        }
    }

    public static void a(@NonNull Context context, ServiceConnection serviceConnection) {
        c.d("RemoteService", "bindASService");
        context.bindService(new Intent(context, (Class<?>) ServiceProxyRemote.class), serviceConnection, 1);
    }
}
