package com.kwad.sdk.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.DownloadTask;
import com.kwad.sdk.api.proxy.app.DownloadService;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class a extends com.kwad.sdk.m.a {
    private com.kwad.sdk.c aNQ;
    private Service aNS;
    private final Map<String, Integer> aNR = new ConcurrentHashMap();
    private final HandlerC0545a aNT = new HandlerC0545a(this);

    /* renamed from: com.kwad.sdk.service.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class HandlerC0545a extends Handler {
        public final WeakReference<a> aNU;

        public HandlerC0545a(a aVar) {
            this.aNU = new WeakReference<>(aVar);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            a aVar = this.aNU.get();
            if (aVar != null && message.what == 1) {
                if (aVar.aNQ != null && aVar.aNQ.xR()) {
                    aVar.aNS.stopSelf();
                } else {
                    sendEmptyMessageDelayed(1, 30000L);
                }
            }
        }
    }

    private void g(Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            int intExtra = intent.getIntExtra("download_service_type_tag", 0);
            String stringExtra = intent.getStringExtra("download_service_id_tag");
            DownloadTask.DownloadRequest downloadRequest = (DownloadTask.DownloadRequest) intent.getSerializableExtra("download_service_args_tag");
            Integer num = TextUtils.isEmpty(stringExtra) ? null : this.aNR.get(stringExtra);
            int intValue = num != null ? num.intValue() : 0;
            if (intExtra == 1) {
                this.aNR.put(stringExtra, Integer.valueOf(this.aNQ.a(downloadRequest, (com.kwad.sdk.a) null)));
                return;
            }
            if (intExtra == 2) {
                this.aNQ.pause(intValue);
                return;
            }
            if (intExtra == 3) {
                this.aNQ.resume(intValue);
                return;
            }
            if (intExtra != 4) {
                return;
            }
            if (intValue != 0) {
                this.aNQ.cancel(intValue);
                return;
            }
            String stringExtra2 = intent.getStringExtra("download_service_path");
            if (stringExtra2 != null) {
                com.kwad.sdk.c.bS(stringExtra2);
            }
        } catch (Exception unused) {
        }
    }

    @InvokeBy(invokerClass = b.class, methodId = "initComponentProxyForInvoker")
    public static void register() {
        b.a(DownloadService.class, a.class);
    }

    @Override // com.kwad.sdk.m.a, com.kwad.sdk.api.proxy.IServiceProxy
    public void onCreate(Service service) {
        if (service == null) {
            return;
        }
        this.aNS = service;
        this.aNQ = com.kwad.sdk.c.xL();
        this.aNT.sendEmptyMessageDelayed(1, 30000L);
    }

    @Override // com.kwad.sdk.m.a, com.kwad.sdk.api.proxy.IServiceProxy
    public int onStartCommand(Service service, Intent intent, int i10, int i11) {
        g(intent);
        return super.onStartCommand(service, intent, i10, i11);
    }
}
