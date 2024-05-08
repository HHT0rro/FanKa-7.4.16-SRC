package ld;

import android.os.Handler;
import android.os.HandlerThread;
import java.util.HashMap;
import java.util.Map;
import rc.e;

/* compiled from: AdThreadExecutor.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class b {

    /* compiled from: AdThreadExecutor.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Runnable f51695b;

        public a(Runnable runnable) {
            this.f51695b = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f51695b.run();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void a(Runnable runnable, long j10) {
        HandlerThread handlerThread;
        HashMap<String, HandlerThread> hashMap = ld.a.f51694a;
        synchronized (hashMap) {
            handlerThread = hashMap.get("tanx_exposer_sdk");
            if (handlerThread != null && handlerThread.getLooper() == null) {
                hashMap.remove("tanx_exposer_sdk");
                handlerThread = null;
            }
            if (handlerThread == null) {
                handlerThread = new HandlerThread("tanx_exposer_sdk");
                handlerThread.start();
                hashMap.put("tanx_exposer_sdk", handlerThread);
            }
        }
        new Handler(handlerThread.getLooper()).postDelayed(new a(runnable), j10);
    }

    public static void b(String str, Map<String, Object> map, boolean z10) {
        rc.b.c(str, map);
        rc.a f10 = e.a.f53381a.f();
        if (f10 != null) {
            if (z10 && f10.b()) {
                return;
            }
            f10.i().getClass();
            int i10 = md.b.f51991a;
            try {
                uc.a aVar = md.a.f51990a;
                if (aVar != null) {
                    aVar.a("tanx_exposer_sdk_trace", i10, str, null, null, map);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
