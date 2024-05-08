package com.kwad.sdk.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.collector.AppStatusRules;
import com.kwad.sdk.collector.c;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.service.ServiceProvider;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class f {
    private static Handler Ym;
    private static Messenger aOi;
    private static volatile ExecutorService aOj;
    private static volatile AppStatusRules aOk;
    private static WeakReference<Context> aOl;
    private static com.kwad.sdk.collector.h aOm;
    private static ServiceConnection axa = new ServiceConnection() { // from class: com.kwad.sdk.utils.f.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                Messenger messenger = new Messenger(iBinder);
                Message obtain = Message.obtain();
                obtain.what = 100;
                if (f.access$000()) {
                    obtain.replyTo = f.aOi;
                    try {
                        messenger.send(obtain);
                        return;
                    } catch (RemoteException unused) {
                        return;
                    }
                }
                com.kwad.sdk.core.e.c.w("AppStatusHelper", "clientMessenger init error");
            } catch (SecurityException e2) {
                com.kwad.sdk.core.e.c.printStackTraceOnly(e2);
                com.kwad.sdk.service.c.gatherException(e2);
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    };

    /* renamed from: com.kwad.sdk.utils.f$2, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class AnonymousClass2 extends ay {
        public final /* synthetic */ Context gq;

        public AnonymousClass2(Context context) {
            this.gq = context;
        }

        @Override // com.kwad.sdk.utils.ay
        public final void doTask() {
            com.kwad.sdk.collector.c.a(this.gq, new c.a() { // from class: com.kwad.sdk.utils.f.2.1
                @Override // com.kwad.sdk.collector.c.a
                public final void b(AppStatusRules appStatusRules) {
                    appStatusRules.initStatus(AnonymousClass2.this.gq);
                    AppStatusRules unused = f.aOk = appStatusRules;
                    f.b(AnonymousClass2.this.gq, f.aOk);
                    f.bH(AnonymousClass2.this.gq);
                    boolean di = bi.di(AnonymousClass2.this.gq);
                    boolean isAppStatusTargetNotEmpty = AppStatusRules.isAppStatusTargetNotEmpty(f.aOk);
                    com.kwad.sdk.core.e.c.d("AppStatusHelper", "appStatusTargetNotEmpty: " + isAppStatusTargetNotEmpty + ", permissionGranted: " + di);
                    if (di && isAppStatusTargetNotEmpty) {
                        long obtainDefaultScanInterval = f.aOk.obtainDefaultScanInterval();
                        if (obtainDefaultScanInterval > 0) {
                            f.c(AnonymousClass2.this.gq, obtainDefaultScanInterval);
                        } else {
                            f.bJ(AnonymousClass2.this.gq);
                        }
                    }
                    boolean isUploadTargetNotEmpty = AppStatusRules.isUploadTargetNotEmpty(f.aOk);
                    boolean z10 = f.aOk.obtainUploadConfigFileMaxSize() > 0;
                    com.kwad.sdk.core.e.c.d("AppStatusHelper", "uploadTargetNotEmpty: " + isUploadTargetNotEmpty + ", enableUpload: " + z10);
                    if (isUploadTargetNotEmpty && z10 && di) {
                        f.KT();
                        f.aOj.submit(new Runnable() { // from class: com.kwad.sdk.utils.f.2.1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                try {
                                    com.kwad.sdk.collector.j.a(AnonymousClass2.this.gq, f.aOk);
                                } catch (Throwable th) {
                                    com.kwad.sdk.service.c.gatherException(th);
                                    com.kwad.sdk.core.e.c.printStackTraceOnly(th);
                                }
                            }
                        });
                    }
                }

                @Override // com.kwad.sdk.collector.c.a
                public final void p(int i10, String str) {
                    com.kwad.sdk.core.e.c.e("AppStatusHelper", "fetchAppStatusConfig onFetchError: " + str + ", code: " + i10);
                }
            });
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface b {
        void u(List<com.kwad.sdk.collector.model.b> list);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class c extends Handler {
        public c(@NonNull Looper looper) {
            super(looper);
        }

        private static void N(List<a> list) {
            if (list == null) {
                return;
            }
            f.aOm.c(t.O(list));
        }

        private static void b(ArrayList<com.kwad.sdk.collector.model.b> arrayList) {
            JSONArray L;
            if (arrayList == null || (L = a.L(arrayList)) == null) {
                return;
            }
            f.aOm.c(L);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private void c(Message message) {
            ArrayList arrayList;
            List list;
            Bundle data = message.getData();
            Iterable<AppStatusRules.Strategy> iterable = null;
            if (data != null) {
                try {
                    if (data.containsKey("resultJson")) {
                        list = t.a(data.getString("resultJson"), new com.kwad.sdk.core.c<a>() { // from class: com.kwad.sdk.utils.f.c.1
                            private static a Lc() {
                                return new a();
                            }

                            @Override // com.kwad.sdk.core.c
                            public final /* synthetic */ a AW() {
                                return Lc();
                            }
                        });
                        arrayList = null;
                    } else {
                        arrayList = (ArrayList) data.getSerializable("data");
                        list = null;
                    }
                } catch (Throwable unused) {
                    arrayList = null;
                    list = null;
                }
                if (arrayList != null) {
                    com.kwad.sdk.core.e.c.d("AppStatusHelper", "ClientHandler: handleMessage data size: " + arrayList.size());
                    b(arrayList);
                }
                if (list != null) {
                    N(list);
                }
            }
            if (f.aOl != null && f.aOl.get() != 0 && data != null) {
                if (data.containsKey("allStrategyJson")) {
                    String string = data.getString("allStrategyJson");
                    if (string != null) {
                        iterable = t.a(string, new com.kwad.sdk.core.c<AppStatusRules.Strategy>() { // from class: com.kwad.sdk.utils.f.c.2
                            private static AppStatusRules.Strategy Ld() {
                                return new AppStatusRules.Strategy();
                            }

                            @Override // com.kwad.sdk.core.c
                            public final /* synthetic */ AppStatusRules.Strategy AW() {
                                return Ld();
                            }
                        });
                    }
                } else {
                    iterable = (ArrayList) data.getSerializable("allStrategy");
                }
                if (iterable != null) {
                    for (AppStatusRules.Strategy strategy : iterable) {
                        long needSaveLaunchTime = strategy.getNeedSaveLaunchTime();
                        if (needSaveLaunchTime >= 0) {
                            com.kwad.sdk.collector.i.a((Context) f.aOl.get(), strategy, needSaveLaunchTime);
                        }
                    }
                }
            }
            if (f.aOl == null || f.axa == null) {
                return;
            }
            com.kwad.sdk.core.e.c.d("AppStatusHelper", "unbindASService");
            com.kwad.sdk.collector.b.a.b((Context) f.aOl.get(), f.axa);
        }

        @Override // android.os.Handler
        public final void handleMessage(@NonNull Message message) {
            super.handleMessage(message);
            if (message.what != 101) {
                return;
            }
            try {
                c(message);
            } catch (Throwable th) {
                com.kwad.sdk.core.e.c.printStackTraceOnly(th);
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class d implements b {
        private b aOu = null;

        public d(b bVar) {
        }

        @Override // com.kwad.sdk.utils.f.b
        public final void u(List<com.kwad.sdk.collector.model.b> list) {
            JSONArray L = a.L(list);
            if (L != null) {
                f.aOm.c(L);
            }
            b bVar = this.aOu;
            if (bVar != null) {
                bVar.u(list);
            }
        }
    }

    private static List<com.kwad.sdk.collector.model.b> K(List<com.kwad.sdk.collector.model.b> list) {
        return list.isEmpty() ? list : new ArrayList(new LinkedHashSet(list));
    }

    public static AppStatusRules KR() {
        return aOk;
    }

    private static boolean KS() {
        if (aOi == null) {
            try {
                aOi = new Messenger(new c(Looper.getMainLooper()));
            } catch (Throwable unused) {
            }
        }
        return aOi != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void KT() {
        if (aOj == null) {
            synchronized (f.class) {
                if (aOj == null) {
                    ExecutorService FJ = GlobalThreadPools.FJ();
                    aOj = FJ;
                    com.kwad.sdk.core.threads.c.a((ThreadPoolExecutor) FJ, "appStatusHelper");
                }
            }
        }
    }

    private static boolean KU() {
        try {
            Class<?> cls = Class.forName("com.kwad.sdk.api.proxy.app.ServiceProxyRemote");
            Context context = ServiceProvider.getContext();
            return context.getPackageManager().queryIntentServices(new Intent(context, cls), 65536).size() > 0;
        } catch (ClassNotFoundException e2) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e2);
            return false;
        }
    }

    public static void a(Context context, long j10, com.kwad.sdk.collector.h hVar) {
        if (au.Mr() || com.kwad.sdk.core.config.d.X(PlaybackStateCompat.ACTION_PLAY_FROM_URI) || context == null || com.kwad.sdk.utils.c.bF(context)) {
            return;
        }
        aOm = hVar;
        boolean isInMainProcess = SystemUtil.isInMainProcess(context);
        com.kwad.sdk.core.e.c.d("AppStatusHelper", "isMainProcess: " + isInMainProcess);
        if (isInMainProcess) {
            aOl = new WeakReference<>(context);
            if (Ym == null) {
                Ym = new Handler(Looper.getMainLooper());
            }
            Ym.postDelayed(new AnonymousClass2(context), 30000L);
        }
    }

    public static /* synthetic */ boolean access$000() {
        return KS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public static void b(Context context, AppStatusRules appStatusRules) {
        File file = new File(context.getFilesDir(), "LOCAL_APP_STATUS_RULES_JSON");
        String jSONObject = appStatusRules.toJson().toString();
        if (TextUtils.isEmpty(jSONObject)) {
            return;
        }
        com.kwad.sdk.crash.utils.h.k(file.getAbsolutePath(), com.kwad.sdk.core.a.c.dH(jSONObject), false);
    }

    @WorkerThread
    public static void bH(Context context) {
        if (aOk == null) {
            aOk = bI(context);
        }
    }

    @Nullable
    @WorkerThread
    private static AppStatusRules bI(Context context) {
        File file = new File(context.getFilesDir(), "LOCAL_APP_STATUS_RULES_JSON");
        if (!file.exists()) {
            return null;
        }
        try {
            String I = com.kwad.sdk.crash.utils.h.I(file);
            if (TextUtils.isEmpty(I)) {
                return null;
            }
            if (com.kwad.sdk.core.a.c.dJ(I)) {
                I = com.kwad.sdk.core.a.c.dI(I);
            }
            JSONObject jSONObject = new JSONObject(I);
            AppStatusRules appStatusRules = new AppStatusRules();
            appStatusRules.parseJson(jSONObject);
            return appStatusRules;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void bJ(Context context) {
        if (context == null) {
            return;
        }
        boolean KU = KU();
        com.kwad.sdk.core.e.c.d("AppStatusHelper", "isServiceAvailable: " + KU);
        if (KU) {
            com.kwad.sdk.collector.b.a.a(context, axa);
        } else {
            a(context, new d(null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public static List<com.kwad.sdk.collector.model.b> bK(Context context) {
        if (!bi.di(context)) {
            return new ArrayList();
        }
        if (aOk == null) {
            aOk = bI(context);
        }
        return bL(context);
    }

    @RequiresPermission(com.kuaishou.weapon.p0.g.f36124j)
    private static List<com.kwad.sdk.collector.model.b> bL(Context context) {
        ArrayList arrayList = new ArrayList();
        if (au.Mr() || com.kwad.sdk.core.config.d.X(PlaybackStateCompat.ACTION_PLAY_FROM_URI) || com.kwad.sdk.utils.c.bF(context)) {
            return arrayList;
        }
        AppStatusRules KR = KR();
        for (AppStatusRules.Strategy strategy : com.kwad.sdk.collector.i.c(KR)) {
            arrayList.addAll(a(strategy));
            strategy.setNeedSaveLaunchTime(System.currentTimeMillis());
        }
        AppStatusRules.Strategy d10 = com.kwad.sdk.collector.i.d(KR);
        arrayList.addAll(a(d10));
        d10.setNeedSaveLaunchTime(System.currentTimeMillis());
        return K(arrayList);
    }

    public static void c(final Context context, final long j10) {
        if (Ym == null) {
            Ym = new Handler(Looper.getMainLooper());
        }
        Ym.post(new ay() { // from class: com.kwad.sdk.utils.f.3
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                f.bJ(context);
                f.Ym.postDelayed(this, j10);
            }
        });
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a implements com.kwad.sdk.core.b {
        private List<Long> aOs = new ArrayList();
        private String appName;
        private String packageName;

        private a(String str, String str2) {
            this.appName = str;
            this.packageName = str2;
        }

        @Nullable
        public static JSONArray L(List<com.kwad.sdk.collector.model.b> list) {
            List<a> list2;
            try {
                list2 = M(list);
            } catch (Exception e2) {
                com.kwad.sdk.service.c.gatherException(e2);
                list2 = null;
            }
            if (list2 == null) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            Iterator<a> iterator2 = list2.iterator2();
            while (iterator2.hasNext()) {
                jSONArray.put(iterator2.next().toJson());
            }
            return jSONArray;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Nullable
        private static List<a> M(List<com.kwad.sdk.collector.model.b> list) {
            a aVar;
            if (list != null && list.size() != 0) {
                HashMap hashMap = new HashMap();
                try {
                    for (com.kwad.sdk.collector.model.b bVar : list) {
                        String b4 = com.kwad.sdk.collector.model.c.b(bVar);
                        if (hashMap.containsKey(b4)) {
                            aVar = (a) hashMap.get(b4);
                        } else {
                            a aVar2 = new a(com.kwad.sdk.collector.model.c.a(bVar), com.kwad.sdk.collector.model.c.b(bVar));
                            hashMap.put(b4, aVar2);
                            aVar = aVar2;
                        }
                        long c4 = com.kwad.sdk.collector.model.c.c(bVar) / 1000;
                        if (aVar != null) {
                            aVar.aE(c4);
                        }
                    }
                    return new ArrayList(hashMap.values());
                } catch (ClassCastException e2) {
                    com.kwad.sdk.core.e.c.printStackTraceOnly(e2);
                }
            }
            return null;
        }

        private void aE(long j10) {
            this.aOs.add(Long.valueOf(j10));
        }

        @Override // com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.appName = jSONObject.optString("appName");
            this.packageName = jSONObject.optString("packageName");
            JSONArray optJSONArray = jSONObject.optJSONArray("runningTimes");
            if (optJSONArray != null) {
                this.aOs.clear();
                int length = optJSONArray.length();
                for (int i10 = 0; i10 < length; i10++) {
                    try {
                        this.aOs.add(Long.valueOf(optJSONArray.getLong(i10)));
                    } catch (JSONException e2) {
                        com.kwad.sdk.core.e.c.printStackTraceOnly(e2);
                    }
                }
            }
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            t.putValue(jSONObject, "appName", this.appName);
            t.putValue(jSONObject, "packageName", this.packageName);
            JSONArray jSONArray = new JSONArray();
            Iterator<Long> iterator2 = this.aOs.iterator2();
            while (iterator2.hasNext()) {
                jSONArray.put(iterator2.next().longValue());
            }
            t.putValue(jSONObject, "runningTimes", jSONArray);
            return jSONObject;
        }

        public a() {
        }
    }

    public static void a(final Context context, final b bVar) {
        if (context == null || au.Mr() || com.kwad.sdk.core.config.d.X(PlaybackStateCompat.ACTION_PLAY_FROM_URI) || com.kwad.sdk.utils.c.bF(context)) {
            return;
        }
        KT();
        aOj.submit(new Runnable() { // from class: com.kwad.sdk.utils.f.4
            @Override // java.lang.Runnable
            public final void run() {
                List bK;
                try {
                    HashSet hashSet = new HashSet();
                    if (!bi.di(context) || (bK = f.bK(context)) == null) {
                        return;
                    }
                    Iterator iterator2 = bK.iterator2();
                    while (iterator2.hasNext()) {
                        com.kwad.sdk.core.e.c.d("AppStatusHelper", "AppRunningInfo: " + ((Object) ((com.kwad.sdk.collector.model.b) iterator2.next())));
                    }
                    hashSet.addAll(bK);
                    if (bVar != null) {
                        bVar.u(new ArrayList(hashSet));
                    }
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.printStackTraceOnly(th);
                    com.kwad.sdk.service.c.gatherException(th);
                }
            }
        });
    }

    @NonNull
    private static List<com.kwad.sdk.collector.model.b> a(AppStatusRules.Strategy strategy) {
        boolean isNeedLaunch = strategy.isNeedLaunch();
        com.kwad.sdk.core.e.c.d("AppStatusHelper", "analysisByFile, strategy: " + strategy.getName() + ", needLaunch: " + isNeedLaunch);
        if (!isNeedLaunch) {
            return new ArrayList();
        }
        return com.kwad.sdk.collector.b.Av().a(strategy);
    }
}
