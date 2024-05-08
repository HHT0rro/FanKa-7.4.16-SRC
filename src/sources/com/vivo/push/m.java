package com.vivo.push;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.vivo.push.sdk.PushMessageCallback;
import com.vivo.push.util.ContextDelegate;
import com.vivo.push.util.VivoPushException;
import com.vivo.push.util.ad;
import com.vivo.push.util.ag;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: PushClientManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    private static volatile m f46243a;

    /* renamed from: h, reason: collision with root package name */
    private Context f46250h;

    /* renamed from: j, reason: collision with root package name */
    private String f46252j;

    /* renamed from: m, reason: collision with root package name */
    private Boolean f46255m;

    /* renamed from: n, reason: collision with root package name */
    private Long f46256n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f46257o;

    /* renamed from: q, reason: collision with root package name */
    private int f46259q;

    /* renamed from: b, reason: collision with root package name */
    private long f46244b = -1;

    /* renamed from: c, reason: collision with root package name */
    private long f46245c = -1;

    /* renamed from: d, reason: collision with root package name */
    private long f46246d = -1;

    /* renamed from: e, reason: collision with root package name */
    private long f46247e = -1;

    /* renamed from: f, reason: collision with root package name */
    private long f46248f = -1;

    /* renamed from: g, reason: collision with root package name */
    private long f46249g = -1;

    /* renamed from: i, reason: collision with root package name */
    private boolean f46251i = true;

    /* renamed from: k, reason: collision with root package name */
    private SparseArray<a> f46253k = new SparseArray<>();

    /* renamed from: l, reason: collision with root package name */
    private int f46254l = 0;

    /* renamed from: p, reason: collision with root package name */
    private IPushClientFactory f46258p = new l();

    private m() {
    }

    public static List<String> c() {
        String g3 = com.vivo.push.restructure.a.a().e().g();
        ArrayList arrayList = new ArrayList();
        try {
        } catch (JSONException unused) {
            com.vivo.push.restructure.a.a().e().h();
            arrayList.clear();
            com.vivo.push.util.u.d("PushClientManager", "getTags error");
        }
        if (TextUtils.isEmpty(g3)) {
            return arrayList;
        }
        Iterator<String> keys = new JSONObject(g3).keys();
        while (keys.hasNext()) {
            arrayList.add(keys.next());
        }
        return arrayList;
    }

    private boolean l() {
        if (this.f46255m == null) {
            this.f46255m = Boolean.valueOf(k() >= 1230 && ag.d(this.f46250h));
        }
        return this.f46255m.booleanValue();
    }

    public final boolean d() {
        if (this.f46250h == null) {
            com.vivo.push.util.u.d("PushClientManager", "support:context is null");
            return false;
        }
        Boolean valueOf = Boolean.valueOf(l());
        this.f46255m = valueOf;
        return valueOf.booleanValue();
    }

    public final void e() {
        this.f46252j = null;
        com.vivo.push.restructure.a.a().e().j();
    }

    public final boolean f() {
        return this.f46257o;
    }

    public final boolean g() {
        return this.f46251i;
    }

    public final Context h() {
        return this.f46250h;
    }

    public final String i() {
        return this.f46252j;
    }

    public final int j() {
        return this.f46259q;
    }

    public final long k() {
        Context context = this.f46250h;
        if (context == null) {
            return -1L;
        }
        if (this.f46256n == null) {
            this.f46256n = Long.valueOf(ag.a(context));
        }
        return this.f46256n.longValue();
    }

    public static synchronized m a() {
        m mVar;
        synchronized (m.class) {
            if (f46243a == null) {
                f46243a = new m();
            }
            mVar = f46243a;
        }
        return mVar;
    }

    public final void b() throws VivoPushException {
        Context context = this.f46250h;
        if (context != null) {
            ag.b(context);
        }
    }

    public static void b(List<String> list) {
        JSONObject jSONObject;
        try {
            if (list.size() <= 0) {
                return;
            }
            String g3 = com.vivo.push.restructure.a.a().e().g();
            if (TextUtils.isEmpty(g3)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(g3);
            }
            Iterator<String> iterator2 = list.iterator2();
            while (iterator2.hasNext()) {
                jSONObject.remove(iterator2.next());
            }
            String jSONObject2 = jSONObject.toString();
            if (TextUtils.isEmpty(jSONObject2)) {
                com.vivo.push.restructure.a.a().e().h();
            } else {
                com.vivo.push.restructure.a.a().e().d(jSONObject2);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
            com.vivo.push.restructure.a.a().e().h();
        }
    }

    /* compiled from: PushClientManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private IPushActionListener f46260a;

        /* renamed from: b, reason: collision with root package name */
        private com.vivo.push.b.c f46261b;

        /* renamed from: c, reason: collision with root package name */
        private IPushActionListener f46262c;

        /* renamed from: d, reason: collision with root package name */
        private Runnable f46263d;

        /* renamed from: e, reason: collision with root package name */
        private Object[] f46264e;

        public a(com.vivo.push.b.c cVar, IPushActionListener iPushActionListener) {
            this.f46261b = cVar;
            this.f46260a = iPushActionListener;
        }

        public final void a(int i10, Object... objArr) {
            this.f46264e = objArr;
            IPushActionListener iPushActionListener = this.f46262c;
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(i10);
            }
            IPushActionListener iPushActionListener2 = this.f46260a;
            if (iPushActionListener2 != null) {
                iPushActionListener2.onStateChanged(i10);
            }
        }

        public final Object[] b() {
            return this.f46264e;
        }

        public final void a(Runnable runnable) {
            this.f46263d = runnable;
        }

        public final void a() {
            Runnable runnable = this.f46263d;
            if (runnable == null) {
                com.vivo.push.util.u.a("PushClientManager", "task is null");
            } else {
                runnable.run();
            }
        }

        public final void a(IPushActionListener iPushActionListener) {
            this.f46262c = iPushActionListener;
        }
    }

    public final synchronized void a(Context context) {
        if (this.f46250h == null) {
            this.f46250h = ContextDelegate.getContext(context);
            this.f46257o = com.vivo.push.util.aa.c(context, context.getPackageName());
            ad.b().a(this.f46250h);
            a(new com.vivo.push.b.g());
            this.f46252j = com.vivo.push.restructure.a.a().e().i();
        }
    }

    public final void c(List<String> list) {
        if (list.contains(this.f46252j)) {
            e();
        }
    }

    public static void a(List<String> list) {
        JSONObject jSONObject;
        try {
            if (list.size() <= 0) {
                return;
            }
            String g3 = com.vivo.push.restructure.a.a().e().g();
            if (TextUtils.isEmpty(g3)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(g3);
            }
            Iterator<String> iterator2 = list.iterator2();
            while (iterator2.hasNext()) {
                jSONObject.put(iterator2.next(), System.currentTimeMillis());
            }
            String jSONObject2 = jSONObject.toString();
            if (TextUtils.isEmpty(jSONObject2)) {
                com.vivo.push.restructure.a.a().e().h();
            } else {
                com.vivo.push.restructure.a.a().e().d(jSONObject2);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
            com.vivo.push.restructure.a.a().e().h();
        }
    }

    public final void c(IPushActionListener iPushActionListener, String str, String str2) {
        a(iPushActionListener, str, str2, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        t.a(new RunnableC0863r(this, str));
    }

    public final void b(IPushActionListener iPushActionListener, String str, String str2) {
        a(iPushActionListener, str, str2, 11);
    }

    public final void b(String str, String str2, String str3, IPushActionListener iPushActionListener) {
        if (this.f46250h == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(this.f46252j)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(0);
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(str)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(30002);
                return;
            }
            return;
        }
        if (str.length() > 70) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(30003);
                return;
            }
            return;
        }
        if (!a(this.f46247e)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(1002);
                return;
            }
            return;
        }
        if (this.f46257o) {
            if (!l()) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(101);
                    return;
                }
                return;
            } else if (TextUtils.isEmpty(com.vivo.push.restructure.a.a().h().b())) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(30001);
                    return;
                }
                return;
            }
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        com.vivo.push.b.a aVar = new com.vivo.push.b.a(false, this.f46250h.getPackageName(), arrayList);
        aVar.b(100);
        aVar.c(str2);
        aVar.d(str3);
        this.f46247e = SystemClock.elapsedRealtime();
        String a10 = a(new a(aVar, iPushActionListener));
        aVar.b(a10);
        a(aVar);
        c(a10);
    }

    public final void a(boolean z10) {
        this.f46251i = z10;
    }

    public final void a(IPushActionListener iPushActionListener, String str, String str2) {
        if (this.f46250h == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
                return;
            }
            return;
        }
        if (a(str, str2)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(10001);
                return;
            }
            return;
        }
        com.vivo.push.restructure.a.a().h().b();
        if (!a(this.f46244b)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(1002);
                return;
            }
            return;
        }
        this.f46244b = SystemClock.elapsedRealtime();
        String packageName = this.f46250h.getPackageName();
        a aVar = null;
        if (this.f46250h != null) {
            com.vivo.push.b.b bVar = new com.vivo.push.b.b(true, packageName);
            bVar.e();
            bVar.c(str);
            bVar.d(str2);
            bVar.b(100);
            if (this.f46257o) {
                if (l()) {
                    aVar = a(bVar, iPushActionListener);
                } else if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(101);
                }
            } else {
                aVar = a(bVar, iPushActionListener);
            }
        } else if (iPushActionListener != null) {
            iPushActionListener.onStateChanged(102);
        }
        if (aVar == null) {
            return;
        }
        aVar.a(new n(this, aVar, str, str2));
        aVar.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized a b(String str) {
        if (str != null) {
            try {
                int parseInt = Integer.parseInt(str);
                a aVar = this.f46253k.get(parseInt);
                this.f46253k.delete(parseInt);
                return aVar;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public final void b(ArrayList<String> arrayList, String str, String str2, IPushActionListener iPushActionListener) {
        if (this.f46250h == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
                return;
            }
            return;
        }
        if (!a(this.f46249g)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(1002);
                return;
            }
            return;
        }
        this.f46249g = SystemClock.elapsedRealtime();
        if (arrayList.size() < 0) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(20002);
                return;
            }
            return;
        }
        Iterator<String> iterator2 = arrayList.iterator2();
        while (iterator2.hasNext()) {
            if (iterator2.next().length() > 70) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(20003);
                    return;
                }
                return;
            }
        }
        if (this.f46257o) {
            if (!l()) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(101);
                    return;
                }
                return;
            } else if (TextUtils.isEmpty(com.vivo.push.restructure.a.a().h().b())) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(20001);
                    return;
                }
                return;
            }
        }
        com.vivo.push.b.z zVar = new com.vivo.push.b.z(false, this.f46250h.getPackageName(), arrayList);
        zVar.b(500);
        zVar.c(str);
        zVar.d(str2);
        String a10 = a(new a(zVar, iPushActionListener));
        zVar.b(a10);
        a(zVar);
        c(a10);
    }

    private a a(com.vivo.push.b.b bVar, IPushActionListener iPushActionListener) {
        a aVar = new a(bVar, iPushActionListener);
        String a10 = a(aVar);
        bVar.b(a10);
        aVar.a(new o(this, bVar, a10));
        return aVar;
    }

    private void a(IPushActionListener iPushActionListener, String str, String str2, int i10) {
        if (this.f46250h == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
                return;
            }
            return;
        }
        if (a(str, str2)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(10001);
            }
        } else if (!a(this.f46245c)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(1002);
            }
        } else {
            this.f46245c = SystemClock.elapsedRealtime();
            a a10 = a(iPushActionListener, this.f46250h.getPackageName(), str, str2, i10);
            if (a10 == null) {
                return;
            }
            a10.a(new p(this));
            a10.a();
        }
    }

    private a a(IPushActionListener iPushActionListener, String str, String str2, String str3, int i10) {
        if (this.f46250h == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
            }
            return null;
        }
        com.vivo.push.b.b bVar = new com.vivo.push.b.b(false, str);
        bVar.c(str2);
        bVar.d(str3);
        if (i10 > 0) {
            bVar.a(i10);
        }
        bVar.e();
        bVar.b(100);
        if (this.f46257o) {
            if (!l()) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(101);
                }
                return null;
            }
            a aVar = new a(bVar, iPushActionListener);
            String a10 = a(aVar);
            bVar.b(a10);
            aVar.a(new q(this, bVar, a10));
            return aVar;
        }
        if (bVar.a(this.f46250h) == 2) {
            return a(bVar, iPushActionListener);
        }
        return a(bVar, iPushActionListener);
    }

    public final void a(String str, int i10, Object... objArr) {
        a b4 = b(str);
        if (b4 != null) {
            b4.a(i10, objArr);
        } else {
            com.vivo.push.util.u.d("PushClientManager", "notifyApp token is null");
        }
    }

    public final void a(String str, String str2, String str3, IPushActionListener iPushActionListener) {
        if (this.f46250h == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
                return;
            }
            return;
        }
        if (!TextUtils.isEmpty(this.f46252j) && this.f46252j.equals(str)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(0);
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(str)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(30002);
                return;
            }
            return;
        }
        if (str.length() > 70) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(30003);
                return;
            }
            return;
        }
        if (!a(this.f46246d)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(1002);
                return;
            }
            return;
        }
        if (this.f46257o) {
            if (!l()) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(101);
                    return;
                }
                return;
            } else if (TextUtils.isEmpty(com.vivo.push.restructure.a.a().h().b())) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(30001);
                    return;
                }
                return;
            }
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        com.vivo.push.b.a aVar = new com.vivo.push.b.a(true, this.f46250h.getPackageName(), arrayList);
        aVar.b(100);
        aVar.c(str2);
        aVar.d(str3);
        this.f46246d = SystemClock.elapsedRealtime();
        String a10 = a(new a(aVar, iPushActionListener));
        aVar.b(a10);
        a(aVar);
        c(a10);
    }

    private static boolean a(long j10) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        return j10 == -1 || elapsedRealtime <= j10 || elapsedRealtime >= j10 + 2000;
    }

    private static boolean a(String str, String str2) {
        return TextUtils.isEmpty(str) || TextUtils.isEmpty(str2);
    }

    public final void a(String str) {
        this.f46252j = str;
        com.vivo.push.restructure.a.a().e().e(str);
    }

    public final void a(String str, int i10) {
        a b4 = b(str);
        if (b4 != null) {
            b4.a(i10, new Object[0]);
        } else {
            com.vivo.push.util.u.d("PushClientManager", "notifyStatusChanged token is null");
        }
    }

    private synchronized String a(a aVar) {
        int i10;
        this.f46253k.put(this.f46254l, aVar);
        i10 = this.f46254l;
        this.f46254l = i10 + 1;
        return Integer.toString(i10);
    }

    public final void a(ArrayList<String> arrayList, String str, String str2, IPushActionListener iPushActionListener) {
        if (this.f46250h == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
                return;
            }
            return;
        }
        if (!a(this.f46248f)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(1002);
                return;
            }
            return;
        }
        this.f46248f = SystemClock.elapsedRealtime();
        if (arrayList.size() < 0) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(20002);
                return;
            }
            return;
        }
        if (arrayList.size() + c().size() > 500) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(20004);
                return;
            }
            return;
        }
        Iterator<String> iterator2 = arrayList.iterator2();
        while (iterator2.hasNext()) {
            if (iterator2.next().length() > 70) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(20003);
                    return;
                }
                return;
            }
        }
        if (this.f46257o) {
            if (!l()) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(101);
                    return;
                }
                return;
            } else if (TextUtils.isEmpty(com.vivo.push.restructure.a.a().h().b())) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(20001);
                    return;
                }
                return;
            }
        }
        com.vivo.push.b.z zVar = new com.vivo.push.b.z(true, this.f46250h.getPackageName(), arrayList);
        zVar.b(500);
        zVar.c(str);
        zVar.d(str2);
        String a10 = a(new a(zVar, iPushActionListener));
        zVar.b(a10);
        a(zVar);
        c(a10);
    }

    public final int a(Intent intent, PushMessageCallback pushMessageCallback) {
        v createReceiverCommand = this.f46258p.createReceiverCommand(intent);
        Context context = a().f46250h;
        if (createReceiverCommand == null) {
            com.vivo.push.util.u.a("PushClientManager", "sendCommand, null command!");
            if (context == null) {
                return 2805;
            }
            com.vivo.push.util.u.c(context, "[执行指令失败]指令空！");
            return 2805;
        }
        com.vivo.push.f.aa createReceiveTask = this.f46258p.createReceiveTask(createReceiverCommand);
        if (createReceiveTask == null) {
            com.vivo.push.util.u.a("PushClientManager", "sendCommand, null command task! pushCommand = ".concat(String.valueOf(createReceiverCommand)));
            if (context == null) {
                return 2806;
            }
            com.vivo.push.util.u.c(context, "[执行指令失败]指令" + ((Object) createReceiverCommand) + "任务空！");
            return 2806;
        }
        if (context != null && !(createReceiverCommand instanceof com.vivo.push.b.n)) {
            com.vivo.push.util.u.a(context, "[接收指令]".concat(String.valueOf(createReceiverCommand)));
        }
        createReceiveTask.a(pushMessageCallback);
        createReceiveTask.run();
        return createReceiveTask.c();
    }

    public final void a(v vVar) {
        Context context = a().f46250h;
        if (vVar == null) {
            com.vivo.push.util.u.a("PushClientManager", "sendCommand, null command!");
            if (context != null) {
                com.vivo.push.util.u.c(context, "[执行指令失败]指令空！");
                return;
            }
            return;
        }
        s createTask = this.f46258p.createTask(vVar);
        if (createTask == null) {
            com.vivo.push.util.u.a("PushClientManager", "sendCommand, null command task! pushCommand = ".concat(String.valueOf(vVar)));
            if (context != null) {
                com.vivo.push.util.u.c(context, "[执行指令失败]指令" + ((Object) vVar) + "任务空！");
                return;
            }
            return;
        }
        com.vivo.push.util.u.d("PushClientManager", "client--sendCommand, command = ".concat(String.valueOf(vVar)));
        t.a(createTask);
    }
}
