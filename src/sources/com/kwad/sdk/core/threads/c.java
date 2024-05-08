package com.kwad.sdk.core.threads;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.text.TextUtils;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.g;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class c {
    public static final String TAG = "c";
    private static int aAM;
    private static int aAN;
    private static int aAO;
    private static final ConcurrentHashMap<ThreadPoolExecutor, Long> aAP = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<ThreadPoolExecutor, String> aAQ = new ConcurrentHashMap<>();
    private static long interval;
    private static long startTime;

    public static /* synthetic */ int FS() {
        int i10 = aAM;
        aAM = i10 + 1;
        return i10;
    }

    public static void a(ThreadPoolExecutor threadPoolExecutor, String str) {
        aAP.put(threadPoolExecutor, Long.valueOf(threadPoolExecutor.getCompletedTaskCount()));
        aAQ.put(threadPoolExecutor, str);
    }

    public static void cH(final String str) {
        g.execute(new ay() { // from class: com.kwad.sdk.core.threads.c.1
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                d eu;
                int i10;
                if (TextUtils.isEmpty(String.this) || (eu = c.eu(String.this)) == null || (i10 = eu.aAN) == 0) {
                    return;
                }
                int unused = c.aAN = i10;
                if (Math.random() * c.aAN >= 1.0d) {
                    return;
                }
                c.a(eu);
            }
        });
    }

    public static d eu(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            d dVar = new d();
            dVar.parseJson(jSONObject);
            return dVar;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static b b(ThreadPoolExecutor threadPoolExecutor, String str) {
        if (threadPoolExecutor == 0) {
            return null;
        }
        b bVar = new b();
        bVar.aAC = str;
        bVar.aAD = threadPoolExecutor.getCorePoolSize();
        bVar.aAE = threadPoolExecutor.getMaximumPoolSize();
        bVar.aAF = threadPoolExecutor.getPoolSize();
        bVar.aAG = threadPoolExecutor.getActiveCount();
        bVar.aAJ = threadPoolExecutor.getQueue() == null ? 0 : threadPoolExecutor.getQueue().size();
        ConcurrentHashMap<ThreadPoolExecutor, Long> concurrentHashMap = aAP;
        long longValue = (!concurrentHashMap.containsKey(threadPoolExecutor) || concurrentHashMap.get(threadPoolExecutor) == null) ? 0L : concurrentHashMap.get(threadPoolExecutor).longValue();
        long completedTaskCount = threadPoolExecutor.getCompletedTaskCount();
        bVar.aAI = completedTaskCount - longValue;
        concurrentHashMap.put(threadPoolExecutor, Long.valueOf(completedTaskCount));
        if (threadPoolExecutor instanceof com.kwad.sdk.core.threads.a.c) {
            bVar.aAH = ((com.kwad.sdk.core.threads.a.c) threadPoolExecutor).FW();
        } else {
            bVar.aAH = 0L;
        }
        bVar.aAK = SystemClock.elapsedRealtime() - startTime;
        bVar.interval = interval;
        bVar.aAL = aAN;
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(d dVar) {
        com.kwad.sdk.core.threads.a.b.aAU = true;
        com.kwad.sdk.core.threads.a.a.aAU = true;
        interval = dVar.interval;
        aAO = dVar.aAT;
        HandlerThread handlerThread = new HandlerThread("pollingHT");
        handlerThread.start();
        final Handler handler = new Handler(handlerThread.getLooper());
        startTime = SystemClock.elapsedRealtime();
        handler.post(new ay() { // from class: com.kwad.sdk.core.threads.c.2
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                ExecutorService et;
                for (String str : GlobalThreadPools.FM()) {
                    if (str != null && !c.aAQ.containsValue(str) && (et = GlobalThreadPools.et(str)) != null && (et instanceof ThreadPoolExecutor) && !c.aAP.containsKey(et)) {
                        c.a((ThreadPoolExecutor) et, str);
                    }
                }
                int i10 = 0;
                for (ThreadPoolExecutor threadPoolExecutor : c.aAQ.h()) {
                    String str2 = (String) c.aAQ.get(threadPoolExecutor);
                    i10 += threadPoolExecutor.getPoolSize();
                    b b4 = c.b(threadPoolExecutor, str2);
                    if (b4 != null) {
                        com.kwad.sdk.commercial.b.r(b4);
                    }
                }
                b bVar = new b();
                bVar.aAC = "total";
                bVar.aAF = i10;
                com.kwad.sdk.commercial.b.r(bVar);
                c.FS();
                if (c.aAM < c.aAO) {
                    handler.postDelayed(this, c.interval);
                }
            }
        });
    }
}
