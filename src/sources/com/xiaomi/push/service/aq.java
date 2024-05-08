package com.xiaomi.push.service;

import android.content.Context;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.connect.common.Constants;
import com.xiaomi.push.service.XMPushService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class aq {

    /* renamed from: c, reason: collision with root package name */
    public static aq f48219c;

    /* renamed from: a, reason: collision with root package name */
    public ConcurrentHashMap<String, HashMap<String, b>> f48220a = new ConcurrentHashMap<>();

    /* renamed from: b, reason: collision with root package name */
    public List<a> f48221b = new ArrayList();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface a {
        void a();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public String f48222a;

        /* renamed from: b, reason: collision with root package name */
        public String f48223b;

        /* renamed from: c, reason: collision with root package name */
        public String f48224c;

        /* renamed from: d, reason: collision with root package name */
        public String f48225d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f48226e;

        /* renamed from: f, reason: collision with root package name */
        public String f48227f;

        /* renamed from: g, reason: collision with root package name */
        public String f48228g;

        /* renamed from: h, reason: collision with root package name */
        public String f48229h;

        /* renamed from: i, reason: collision with root package name */
        public String f48230i;

        /* renamed from: j, reason: collision with root package name */
        public String f48231j;

        /* renamed from: k, reason: collision with root package name */
        public v f48232k;

        /* renamed from: l, reason: collision with root package name */
        public Context f48233l;

        /* renamed from: p, reason: collision with root package name */
        public XMPushService f48237p;

        /* renamed from: r, reason: collision with root package name */
        public Messenger f48239r;

        /* renamed from: m, reason: collision with root package name */
        public c f48234m = c.unbind;

        /* renamed from: n, reason: collision with root package name */
        public int f48235n = 0;

        /* renamed from: o, reason: collision with root package name */
        public List<a> f48236o = new ArrayList();

        /* renamed from: q, reason: collision with root package name */
        public c f48238q = null;

        /* renamed from: s, reason: collision with root package name */
        public boolean f48240s = false;

        /* renamed from: t, reason: collision with root package name */
        public XMPushService.b f48241t = new XMPushService.b(this);

        /* renamed from: u, reason: collision with root package name */
        public IBinder.DeathRecipient f48242u = null;

        /* renamed from: v, reason: collision with root package name */
        public final C0716b f48243v = new C0716b();

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
        public interface a {
            void a(c cVar, c cVar2, int i10);
        }

        /* renamed from: com.xiaomi.push.service.aq$b$b, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
        public class C0716b extends XMPushService.i {

            /* renamed from: c, reason: collision with root package name */
            public int f48244c;

            /* renamed from: d, reason: collision with root package name */
            public int f48245d;

            /* renamed from: e, reason: collision with root package name */
            public String f48246e;

            /* renamed from: f, reason: collision with root package name */
            public String f48247f;

            public C0716b() {
                super(0);
            }

            @Override // com.xiaomi.push.service.XMPushService.i
            public String a() {
                return "notify job";
            }

            @Override // com.xiaomi.push.service.XMPushService.i
            public void b() {
                if (b.this.l(this.f48244c, this.f48245d, this.f48247f)) {
                    b.this.g(this.f48244c, this.f48245d, this.f48246e, this.f48247f);
                    return;
                }
                fc.c.l(" ignore notify client :" + b.this.f48229h);
            }

            public XMPushService.i c(int i10, int i11, String str, String str2) {
                this.f48244c = i10;
                this.f48245d = i11;
                this.f48247f = str2;
                this.f48246e = str;
                return this;
            }
        }

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
        public class c implements IBinder.DeathRecipient {

            /* renamed from: a, reason: collision with root package name */
            public final b f48249a;

            /* renamed from: b, reason: collision with root package name */
            public final Messenger f48250b;

            public c(b bVar, Messenger messenger) {
                this.f48249a = bVar;
                this.f48250b = messenger;
            }

            @Override // android.os.IBinder.DeathRecipient
            public void binderDied() {
                fc.c.l("peer died, chid = " + this.f48249a.f48229h);
                b.this.f48237p.x(new f(this, 0), 0L);
                if ("9".equals(this.f48249a.f48229h) && "com.xiaomi.xmsf".equals(b.this.f48237p.getPackageName())) {
                    b.this.f48237p.x(new g(this, 0), 60000L);
                }
            }
        }

        public b() {
        }

        public b(XMPushService xMPushService) {
            this.f48237p = xMPushService;
            i(new e(this));
        }

        public static String e(String str) {
            int lastIndexOf;
            return (TextUtils.isEmpty(str) || (lastIndexOf = str.lastIndexOf("/")) == -1) ? "" : str.substring(lastIndexOf + 1);
        }

        public long a() {
            return (((long) ((Math.random() * 20.0d) - 10.0d)) + ((this.f48235n + 1) * 15)) * 1000;
        }

        public String d(int i10) {
            return i10 != 1 ? i10 != 2 ? i10 != 3 ? "unknown" : "KICK" : "CLOSE" : "OPEN";
        }

        public void f() {
            try {
                Messenger messenger = this.f48239r;
                if (messenger != null && this.f48242u != null) {
                    messenger.getBinder().unlinkToDeath(this.f48242u, 0);
                }
            } catch (Exception unused) {
            }
            this.f48238q = null;
        }

        public final void g(int i10, int i11, String str, String str2) {
            c cVar = this.f48234m;
            this.f48238q = cVar;
            if (i10 == 2) {
                this.f48232k.f(this.f48233l, this, i11);
                return;
            }
            if (i10 == 3) {
                this.f48232k.g(this.f48233l, this, str2, str);
                return;
            }
            if (i10 == 1) {
                boolean z10 = cVar == c.binded;
                if (!z10 && "wait".equals(str2)) {
                    this.f48235n++;
                } else if (z10) {
                    this.f48235n = 0;
                    if (this.f48239r != null) {
                        try {
                            this.f48239r.send(Message.obtain(null, 16, this.f48237p.f48174p));
                        } catch (RemoteException unused) {
                        }
                    }
                }
                this.f48232k.h(this.f48237p, this, z10, i11, str);
            }
        }

        public void h(Messenger messenger) {
            f();
            try {
                if (messenger != null) {
                    this.f48239r = messenger;
                    this.f48240s = true;
                    this.f48242u = new c(this, messenger);
                    messenger.getBinder().linkToDeath(this.f48242u, 0);
                } else {
                    fc.c.l("peer linked with old sdk chid = " + this.f48229h);
                }
            } catch (Exception e2) {
                fc.c.l("peer linkToDeath err: " + e2.getMessage());
                this.f48239r = null;
                this.f48240s = false;
            }
        }

        public void i(a aVar) {
            synchronized (this.f48236o) {
                this.f48236o.add(aVar);
            }
        }

        public void k(c cVar, int i10, int i11, String str, String str2) {
            boolean z10;
            synchronized (this.f48236o) {
                Iterator<a> iterator2 = this.f48236o.iterator2();
                while (iterator2.hasNext()) {
                    iterator2.next().a(this.f48234m, cVar, i11);
                }
            }
            c cVar2 = this.f48234m;
            int i12 = 0;
            if (cVar2 != cVar) {
                fc.c.i(String.format("update the client %7$s status. %1$s->%2$s %3$s %4$s %5$s %6$s", cVar2, cVar, d(i10), kc.n.a(i11), str, str2, this.f48229h));
                this.f48234m = cVar;
            }
            if (this.f48232k == null) {
                fc.c.n("status changed while the client dispatcher is missing");
                return;
            }
            if (cVar == c.binding) {
                return;
            }
            if (this.f48238q != null && (z10 = this.f48240s)) {
                i12 = (this.f48239r == null || !z10) ? Constants.REQUEST_API : 1000;
            }
            this.f48237p.Q(this.f48243v);
            if (o(i10, i11, str2)) {
                g(i10, i11, str, str2);
            } else {
                this.f48237p.x(this.f48243v.c(i10, i11, str, str2), i12);
            }
        }

        public final boolean l(int i10, int i11, String str) {
            boolean z10;
            StringBuilder sb2;
            String str2;
            c cVar = this.f48238q;
            if (cVar == null || !(z10 = this.f48240s)) {
                return true;
            }
            if (cVar == this.f48234m) {
                sb2 = new StringBuilder();
                str2 = " status recovered, don't notify client:";
            } else {
                if (this.f48239r != null && z10) {
                    fc.c.l("Peer alive notify status to client:" + this.f48229h);
                    return true;
                }
                sb2 = new StringBuilder();
                str2 = "peer died, ignore notify ";
            }
            sb2.append(str2);
            sb2.append(this.f48229h);
            fc.c.l(sb2.toString());
            return false;
        }

        public void n(a aVar) {
            synchronized (this.f48236o) {
                this.f48236o.remove(aVar);
            }
        }

        public final boolean o(int i10, int i11, String str) {
            if (i10 == 1) {
                return (this.f48234m == c.binded || !this.f48237p.a0() || i11 == 21 || (i11 == 7 && "wait".equals(str))) ? false : true;
            }
            if (i10 == 2) {
                return this.f48237p.a0();
            }
            if (i10 != 3) {
                return false;
            }
            return !"wait".equals(str);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public enum c {
        unbind,
        binding,
        binded
    }

    public static synchronized aq c() {
        aq aqVar;
        synchronized (aq.class) {
            if (f48219c == null) {
                f48219c = new aq();
            }
            aqVar = f48219c;
        }
        return aqVar;
    }

    public synchronized int a() {
        return this.f48220a.size();
    }

    public synchronized b b(String str, String str2) {
        HashMap<String, b> hashMap = this.f48220a.get(str);
        if (hashMap == null) {
            return null;
        }
        return hashMap.get(d(str2));
    }

    public final String d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int indexOf = str.indexOf("@");
        return indexOf > 0 ? str.substring(0, indexOf) : str;
    }

    public synchronized ArrayList<b> e() {
        ArrayList<b> arrayList;
        arrayList = new ArrayList<>();
        Iterator<HashMap<String, b>> iterator2 = this.f48220a.values().iterator2();
        while (iterator2.hasNext()) {
            arrayList.addAll(iterator2.next().values());
        }
        return arrayList;
    }

    public synchronized Collection<b> f(String str) {
        if (this.f48220a.containsKey(str)) {
            return ((HashMap) this.f48220a.get(str).clone()).values();
        }
        return new ArrayList();
    }

    public synchronized List<String> g(String str) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<HashMap<String, b>> iterator2 = this.f48220a.values().iterator2();
        while (iterator2.hasNext()) {
            for (b bVar : iterator2.next().values()) {
                if (str.equals(bVar.f48222a)) {
                    arrayList.add(bVar.f48229h);
                }
            }
        }
        return arrayList;
    }

    public synchronized void h() {
        Iterator<b> iterator2 = e().iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().f();
        }
        this.f48220a.clear();
    }

    public synchronized void i(Context context) {
        Iterator<HashMap<String, b>> iterator2 = this.f48220a.values().iterator2();
        while (iterator2.hasNext()) {
            Iterator<b> iterator22 = iterator2.next().values().iterator2();
            while (iterator22.hasNext()) {
                iterator22.next().k(c.unbind, 1, 3, null, null);
            }
        }
    }

    public synchronized void j(Context context, int i10) {
        Iterator<HashMap<String, b>> iterator2 = this.f48220a.values().iterator2();
        while (iterator2.hasNext()) {
            Iterator<b> iterator22 = iterator2.next().values().iterator2();
            while (iterator22.hasNext()) {
                iterator22.next().k(c.unbind, 2, i10, null, null);
            }
        }
    }

    public synchronized void k(a aVar) {
        this.f48221b.add(aVar);
    }

    public synchronized void l(b bVar) {
        HashMap<String, b> hashMap = this.f48220a.get(bVar.f48229h);
        if (hashMap == null) {
            hashMap = new HashMap<>();
            this.f48220a.put(bVar.f48229h, hashMap);
        }
        hashMap.put(d(bVar.f48223b), bVar);
        Iterator<a> iterator2 = this.f48221b.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().a();
        }
    }

    public synchronized void m(String str) {
        HashMap<String, b> hashMap = this.f48220a.get(str);
        if (hashMap != null) {
            Iterator<b> iterator2 = hashMap.values().iterator2();
            while (iterator2.hasNext()) {
                iterator2.next().f();
            }
            hashMap.clear();
            this.f48220a.remove(str);
        }
        Iterator<a> iterator22 = this.f48221b.iterator2();
        while (iterator22.hasNext()) {
            iterator22.next().a();
        }
    }

    public synchronized void n(String str, String str2) {
        HashMap<String, b> hashMap = this.f48220a.get(str);
        if (hashMap != null) {
            b bVar = hashMap.get(d(str2));
            if (bVar != null) {
                bVar.f();
            }
            hashMap.remove(d(str2));
            if (hashMap.isEmpty()) {
                this.f48220a.remove(str);
            }
        }
        Iterator<a> iterator2 = this.f48221b.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().a();
        }
    }

    public synchronized void o() {
        this.f48221b.clear();
    }
}
