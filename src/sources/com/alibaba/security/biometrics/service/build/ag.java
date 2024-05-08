package com.alibaba.security.biometrics.service.build;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.alibaba.security.common.log.RPLogging;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

/* compiled from: StateMachine.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ag {
    public static final int b_ = -1;
    public static final int c_ = -1;
    public static final boolean d_ = true;
    public static final boolean e_ = false;

    /* renamed from: i */
    private static final String f2564i = "StateMachine";
    public String a_;
    public boolean f_;
    public c g_;
    public HandlerThread h_;

    /* compiled from: StateMachine.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class b {

        /* renamed from: e */
        private static final int f2568e = 20;

        /* renamed from: a */
        public Vector<a> f2569a = new Vector<>();

        /* renamed from: b */
        public int f2570b = 20;

        /* renamed from: c */
        public int f2571c = 0;

        /* renamed from: d */
        public int f2572d = 0;

        private void a(int i10) {
            this.f2570b = i10;
            this.f2572d = 0;
            this.f2569a.clear();
        }

        private int b() {
            return this.f2572d;
        }

        private a b(int i10) {
            int i11 = this.f2571c + i10;
            int i12 = this.f2570b;
            if (i11 >= i12) {
                i11 -= i12;
            }
            if (i11 >= this.f2569a.size()) {
                return null;
            }
            return this.f2569a.get(i11);
        }

        private int a() {
            return this.f2569a.size();
        }

        public final void a(Message message, af afVar, af afVar2) {
            this.f2572d++;
            if (this.f2569a.size() < this.f2570b) {
                this.f2569a.add(new a(message, afVar, afVar2));
                return;
            }
            a aVar = this.f2569a.get(this.f2571c);
            int i10 = this.f2571c + 1;
            this.f2571c = i10;
            if (i10 >= this.f2570b) {
                this.f2571c = 0;
            }
            aVar.a(message, afVar, afVar2);
        }
    }

    /* compiled from: StateMachine.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class c extends Handler {

        /* renamed from: b */
        private static final Object f2573b = new Object();

        /* renamed from: a */
        private boolean f2574a;

        /* renamed from: c */
        private Message f2575c;

        /* renamed from: d */
        private b f2576d;

        /* renamed from: e */
        private boolean f2577e;

        /* renamed from: f */
        private C0031c[] f2578f;

        /* renamed from: g */
        private int f2579g;

        /* renamed from: h */
        private C0031c[] f2580h;

        /* renamed from: i */
        private int f2581i;

        /* renamed from: j */
        private a f2582j;

        /* renamed from: k */
        private b f2583k;

        /* renamed from: l */
        private ag f2584l;

        /* renamed from: m */
        private HashMap<af, C0031c> f2585m;

        /* renamed from: n */
        private af f2586n;

        /* renamed from: o */
        private af f2587o;

        /* renamed from: p */
        private ArrayList<Message> f2588p;

        /* compiled from: StateMachine.java */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
        public class a extends af {
            private a() {
            }

            @Override // com.alibaba.security.biometrics.service.build.af, com.alibaba.security.biometrics.service.build.ae
            public final boolean a(Message message) {
                ag unused = c.this.f2584l;
                return true;
            }

            public /* synthetic */ a(c cVar, byte b4) {
                this();
            }
        }

        /* compiled from: StateMachine.java */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
        public class b extends af {
            private b() {
            }

            @Override // com.alibaba.security.biometrics.service.build.af, com.alibaba.security.biometrics.service.build.ae
            public final boolean a(Message message) {
                return false;
            }

            public /* synthetic */ b(c cVar, byte b4) {
                this();
            }
        }

        /* compiled from: StateMachine.java */
        /* renamed from: com.alibaba.security.biometrics.service.build.ag$c$c */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
        public class C0031c {

            /* renamed from: a */
            public af f2591a;

            /* renamed from: b */
            public C0031c f2592b;

            /* renamed from: c */
            public boolean f2593c;

            private C0031c() {
            }

            public final String toString() {
                StringBuilder sb2 = new StringBuilder("state=");
                sb2.append(this.f2591a.d());
                sb2.append(",active=");
                sb2.append(this.f2593c);
                sb2.append(",parent=");
                C0031c c0031c = this.f2592b;
                sb2.append(c0031c == null ? "null" : c0031c.f2591a.d());
                return sb2.toString();
            }

            public /* synthetic */ C0031c(c cVar, byte b4) {
                this();
            }
        }

        public /* synthetic */ c(Looper looper, ag agVar, byte b4) {
            this(looper, agVar);
        }

        private final void b() {
            if (this.f2574a) {
                RPLogging.d("StateMachine", "completeConstruction: E");
            }
            int i10 = 0;
            for (C0031c c0031c : this.f2585m.values()) {
                int i11 = 0;
                while (c0031c != null) {
                    c0031c = c0031c.f2592b;
                    i11++;
                }
                if (i10 < i11) {
                    i10 = i11;
                }
            }
            if (this.f2574a) {
                RPLogging.d("StateMachine", "completeConstruction: maxDepth=".concat(String.valueOf(i10)));
            }
            this.f2578f = new C0031c[i10];
            this.f2580h = new C0031c[i10];
            e();
            this.f2577e = true;
            this.f2575c = obtainMessage(-1);
            a(0);
            a();
            if (this.f2574a) {
                RPLogging.d("StateMachine", "completeConstruction: X");
            }
        }

        private final void c() {
            for (int size = this.f2588p.size() - 1; size >= 0; size--) {
                Message message = this.f2588p.get(size);
                if (this.f2574a) {
                    RPLogging.d("StateMachine", "moveDeferredMessageAtFrontOfQueue; what=" + message.what);
                }
                sendMessageAtFrontOfQueue(message);
            }
            this.f2588p.clear();
        }

        private final Message f() {
            return this.f2575c;
        }

        private final ae g() {
            return this.f2578f[this.f2579g].f2591a;
        }

        private final void h() {
            if (this.f2574a) {
                RPLogging.d("StateMachine", "quit:");
            }
            sendMessage(obtainMessage(-1, f2573b));
        }

        private final boolean i() {
            return this.f2574a;
        }

        private final int j() {
            return this.f2576d.f2569a.size();
        }

        private final int k() {
            return this.f2576d.f2572d;
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            if (this.f2574a) {
                RPLogging.d("StateMachine", "handleMessage: E msg.what=" + message.what);
            }
            this.f2575c = message;
            if (this.f2577e) {
                b(message);
                a();
                if (this.f2574a) {
                    RPLogging.d("StateMachine", "handleMessage: X");
                }
            }
        }

        private c(Looper looper, ag agVar) {
            super(looper);
            this.f2574a = false;
            this.f2576d = new b();
            this.f2579g = -1;
            this.f2582j = new a(this, (byte) 0);
            this.f2583k = new b(this, (byte) 0);
            this.f2585m = new HashMap<>();
            this.f2588p = new ArrayList<>();
            this.f2584l = agVar;
            a(this.f2582j, (af) null);
            a(this.f2583k, (af) null);
        }

        private final int d() {
            int i10 = this.f2579g + 1;
            int i11 = i10;
            for (int i12 = this.f2581i - 1; i12 >= 0; i12--) {
                if (this.f2574a) {
                    RPLogging.d("StateMachine", "moveTempStackToStateStack: i=" + i12 + ",j=" + i11);
                }
                this.f2578f[i11] = this.f2580h[i12];
                i11++;
            }
            this.f2579g = i11 - 1;
            if (this.f2574a) {
                RPLogging.d("StateMachine", "moveTempStackToStateStack: X mStateStackTop=" + this.f2579g + ",startingIndex=" + i10 + ",Top=" + this.f2578f[this.f2579g].f2591a.d());
            }
            return i10;
        }

        private final void e() {
            if (this.f2574a) {
                RPLogging.d("StateMachine", "setupInitialStateStack: E mInitialState=" + this.f2586n.d());
            }
            C0031c c0031c = this.f2585m.get(this.f2586n);
            this.f2581i = 0;
            while (c0031c != null) {
                C0031c[] c0031cArr = this.f2580h;
                int i10 = this.f2581i;
                c0031cArr[i10] = c0031c;
                c0031c = c0031c.f2592b;
                this.f2581i = i10 + 1;
            }
            this.f2579g = -1;
            d();
        }

        public static /* synthetic */ int f(c cVar) {
            return cVar.f2576d.f2569a.size();
        }

        public static /* synthetic */ int g(c cVar) {
            return cVar.f2576d.f2572d;
        }

        public static /* synthetic */ void h(c cVar) {
            if (cVar.f2574a) {
                RPLogging.d("StateMachine", "quit:");
            }
            cVar.sendMessage(cVar.obtainMessage(-1, f2573b));
        }

        public static /* synthetic */ void j(c cVar) {
            if (cVar.f2574a) {
                RPLogging.d("StateMachine", "completeConstruction: E");
            }
            int i10 = 0;
            for (C0031c c0031c : cVar.f2585m.values()) {
                int i11 = 0;
                while (c0031c != null) {
                    c0031c = c0031c.f2592b;
                    i11++;
                }
                if (i10 < i11) {
                    i10 = i11;
                }
            }
            if (cVar.f2574a) {
                RPLogging.d("StateMachine", "completeConstruction: maxDepth=".concat(String.valueOf(i10)));
            }
            cVar.f2578f = new C0031c[i10];
            cVar.f2580h = new C0031c[i10];
            cVar.e();
            cVar.f2577e = true;
            cVar.f2575c = cVar.obtainMessage(-1);
            cVar.a(0);
            cVar.a();
            if (cVar.f2574a) {
                RPLogging.d("StateMachine", "completeConstruction: X");
            }
        }

        private void a() {
            af afVar = null;
            while (this.f2587o != null) {
                if (this.f2574a) {
                    RPLogging.d("StateMachine", "handleMessage: new destination call exit");
                }
                afVar = this.f2587o;
                this.f2587o = null;
                this.f2581i = 0;
                C0031c c0031c = this.f2585m.get(afVar);
                do {
                    C0031c[] c0031cArr = this.f2580h;
                    int i10 = this.f2581i;
                    this.f2581i = i10 + 1;
                    c0031cArr[i10] = c0031c;
                    c0031c = c0031c.f2592b;
                    if (c0031c == null) {
                        break;
                    }
                } while (!c0031c.f2593c);
                if (this.f2574a) {
                    RPLogging.d("StateMachine", "setupTempStateStackWithStatesToEnter: X mTempStateStackCount=" + this.f2581i + ",curStateInfo: " + ((Object) c0031c));
                }
                a(c0031c);
                a(d());
                c();
            }
            if (afVar == null || afVar != this.f2583k || this.f2584l.h_ == null) {
                return;
            }
            getLooper().quit();
            this.f2584l.h_ = null;
        }

        private final void c(Message message) {
            if (this.f2574a) {
                RPLogging.d("StateMachine", "deferMessage: msg=" + message.what);
            }
            Message obtainMessage = obtainMessage();
            obtainMessage.copyFrom(message);
            this.f2588p.add(obtainMessage);
        }

        private final a c(int i10) {
            b bVar = this.f2576d;
            int i11 = bVar.f2571c + i10;
            int i12 = bVar.f2570b;
            if (i11 >= i12) {
                i11 -= i12;
            }
            if (i11 >= bVar.f2569a.size()) {
                return null;
            }
            return bVar.f2569a.get(i11);
        }

        public static boolean d(Message message) {
            return message.what == -1 && message.obj == f2573b;
        }

        private final void b(Message message) {
            C0031c c0031c = this.f2578f[this.f2579g];
            if (this.f2574a) {
                RPLogging.d("StateMachine", "processMsg: " + c0031c.f2591a.d());
            }
            while (true) {
                if (c0031c.f2591a.a(message)) {
                    break;
                }
                c0031c = c0031c.f2592b;
                if (c0031c == null) {
                    ag agVar = this.f2584l;
                    if (agVar.g_.f2574a) {
                        RPLogging.e("StateMachine", agVar.a_ + " - unhandledMessage: msg.what=" + message.what);
                    }
                    if (d(message)) {
                        a((ae) this.f2583k);
                    }
                } else if (this.f2574a) {
                    RPLogging.d("StateMachine", "processMsg: " + c0031c.f2591a.d());
                }
            }
            if (c0031c != null) {
                this.f2576d.a(message, c0031c.f2591a, this.f2578f[this.f2579g].f2591a);
            } else {
                this.f2576d.a(message, null, null);
            }
        }

        public static /* synthetic */ ae c(c cVar) {
            return cVar.f2578f[cVar.f2579g].f2591a;
        }

        private final void a(C0031c c0031c) {
            while (true) {
                int i10 = this.f2579g;
                if (i10 < 0) {
                    return;
                }
                C0031c[] c0031cArr = this.f2578f;
                if (c0031cArr[i10] == c0031c) {
                    return;
                }
                af afVar = c0031cArr[i10].f2591a;
                if (this.f2574a) {
                    RPLogging.d("StateMachine", "invokeExitMethods: " + afVar.d());
                }
                C0031c[] c0031cArr2 = this.f2578f;
                int i11 = this.f2579g;
                c0031cArr2[i11].f2593c = false;
                this.f2579g = i11 - 1;
            }
        }

        private final void b(af afVar) {
            if (this.f2574a) {
                RPLogging.d("StateMachine", "setInitialState: initialState" + afVar.d());
            }
            this.f2586n = afVar;
        }

        private final void a(int i10) {
            while (i10 <= this.f2579g) {
                if (this.f2574a) {
                    RPLogging.d("StateMachine", "invokeEnterMethods: " + this.f2578f[i10].f2591a.d());
                }
                this.f2578f[i10].f2591a.b();
                this.f2578f[i10].f2593c = true;
                i10++;
            }
        }

        private final void b(int i10) {
            b bVar = this.f2576d;
            bVar.f2570b = i10;
            bVar.f2572d = 0;
            bVar.f2569a.clear();
        }

        private final C0031c a(af afVar) {
            this.f2581i = 0;
            C0031c c0031c = this.f2585m.get(afVar);
            do {
                C0031c[] c0031cArr = this.f2580h;
                int i10 = this.f2581i;
                this.f2581i = i10 + 1;
                c0031cArr[i10] = c0031c;
                c0031c = c0031c.f2592b;
                if (c0031c == null) {
                    break;
                }
            } while (!c0031c.f2593c);
            if (this.f2574a) {
                RPLogging.d("StateMachine", "setupTempStateStackWithStatesToEnter: X mTempStateStackCount=" + this.f2581i + ",curStateInfo: " + ((Object) c0031c));
            }
            return c0031c;
        }

        public static /* synthetic */ a b(c cVar, int i10) {
            b bVar = cVar.f2576d;
            int i11 = bVar.f2571c + i10;
            int i12 = bVar.f2570b;
            if (i11 >= i12) {
                i11 -= i12;
            }
            if (i11 >= bVar.f2569a.size()) {
                return null;
            }
            return bVar.f2569a.get(i11);
        }

        public final C0031c a(af afVar, af afVar2) {
            if (this.f2574a) {
                StringBuilder sb2 = new StringBuilder("addStateInternal: E state=");
                sb2.append(afVar.d());
                sb2.append(",parent=");
                sb2.append(afVar2 == null ? "" : afVar2.d());
                RPLogging.d("StateMachine", sb2.toString());
            }
            C0031c c0031c = null;
            if (afVar2 != null) {
                C0031c c0031c2 = this.f2585m.get(afVar2);
                c0031c = c0031c2 == null ? a(afVar2, (af) null) : c0031c2;
            }
            C0031c c0031c3 = this.f2585m.get(afVar);
            if (c0031c3 == null) {
                c0031c3 = new C0031c(this, (byte) 0);
                this.f2585m.put(afVar, c0031c3);
            }
            C0031c c0031c4 = c0031c3.f2592b;
            if (c0031c4 != null && c0031c4 != c0031c) {
                throw new RuntimeException("state already added");
            }
            c0031c3.f2591a = afVar;
            c0031c3.f2592b = c0031c;
            c0031c3.f2593c = false;
            if (this.f2574a) {
                RPLogging.d("StateMachine", "addStateInternal: X stateInfo: ".concat(String.valueOf(c0031c3)));
            }
            return c0031c3;
        }

        public final void a(ae aeVar) {
            this.f2587o = (af) aeVar;
            if (this.f2574a) {
                RPLogging.d("StateMachine", "StateMachine.transitionTo EX destState" + this.f2587o.d());
            }
        }

        private final void a(boolean z10) {
            this.f2574a = z10;
        }

        public static /* synthetic */ void a(c cVar, af afVar) {
            if (cVar.f2574a) {
                RPLogging.d("StateMachine", "setInitialState: initialState" + afVar.d());
            }
            cVar.f2586n = afVar;
        }

        public static /* synthetic */ void a(c cVar, Message message) {
            if (cVar.f2574a) {
                RPLogging.d("StateMachine", "deferMessage: msg=" + message.what);
            }
            Message obtainMessage = cVar.obtainMessage();
            obtainMessage.copyFrom(message);
            cVar.f2588p.add(obtainMessage);
        }

        public static /* synthetic */ void a(c cVar, int i10) {
            b bVar = cVar.f2576d;
            bVar.f2570b = i10;
            bVar.f2572d = 0;
            bVar.f2569a.clear();
        }
    }

    public ag(String str) {
        HandlerThread handlerThread = new HandlerThread(str);
        this.h_ = handlerThread;
        handlerThread.start();
        a(str, this.h_.getLooper());
    }

    private static /* synthetic */ HandlerThread b(ag agVar) {
        agVar.h_ = null;
        return null;
    }

    private void c() {
        c cVar = this.g_;
        cVar.a((ae) cVar.f2582j);
    }

    private Message d(int i10) {
        return Message.obtain(this.g_, i10);
    }

    private static void e() {
    }

    private void e(int i10) {
        this.g_.removeMessages(i10);
    }

    private static void f() {
    }

    private void f(int i10) {
        this.g_.sendMessageAtFrontOfQueue(d(i10));
    }

    private static void g() {
    }

    private void g(int i10) {
        this.g_.removeMessages(i10);
    }

    private String h() {
        return this.a_;
    }

    private int i() {
        return c.f(this.g_);
    }

    private int j() {
        return c.g(this.g_);
    }

    private Handler k() {
        return this.g_;
    }

    private Message l() {
        return Message.obtain(this.g_);
    }

    private void m() {
        if (this.f_) {
            this.f_ = false;
            c.h(this.g_);
        }
    }

    private boolean n() {
        return this.g_.f2574a;
    }

    private void a(String str, Looper looper) {
        this.a_ = str;
        this.g_ = new c(looper, this, (byte) 0);
    }

    private ae b() {
        return c.c(this.g_);
    }

    private void d(Message message) {
        this.g_.sendMessageAtFrontOfQueue(message);
    }

    private static boolean e(Message message) {
        return c.d(message);
    }

    public final void c(int i10) {
        this.g_.sendMessage(d(i10));
    }

    /* compiled from: StateMachine.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class a {

        /* renamed from: a */
        private int f2565a;

        /* renamed from: b */
        private af f2566b;

        /* renamed from: c */
        private af f2567c;

        public a(Message message, af afVar, af afVar2) {
            a(message, afVar, afVar2);
        }

        private af b() {
            return this.f2566b;
        }

        private af c() {
            return this.f2567c;
        }

        public final void a(Message message, af afVar, af afVar2) {
            this.f2565a = message.what;
            this.f2566b = afVar;
            this.f2567c = afVar2;
        }

        public final String toString() {
            return "what=" + this.f2565a + " state=" + a(this.f2566b) + " orgState=" + a(this.f2567c);
        }

        private int a() {
            return this.f2565a;
        }

        private static String a(Object obj) {
            if (obj == null) {
                return "null";
            }
            String name = obj.getClass().getName();
            return name.substring(name.lastIndexOf(36) + 1);
        }
    }

    private void b(af afVar) {
        c.a(this.g_, afVar);
    }

    private void c(Message message) {
        this.g_.sendMessage(message);
    }

    public final void d() {
        if (this.f_) {
            return;
        }
        this.f_ = true;
        c.j(this.g_);
    }

    private void b(Message message) {
        if (this.g_.f2574a) {
            RPLogging.e("StateMachine", this.a_ + " - unhandledMessage: msg.what=" + message.what);
        }
    }

    private void c(int i10, Object obj) {
        this.g_.sendMessageAtFrontOfQueue(a(i10, obj));
    }

    public final void a(af afVar, af afVar2) {
        this.g_.a(afVar, afVar2);
    }

    private Message a() {
        return this.g_.f2575c;
    }

    private a b(int i10) {
        return c.b(this.g_, i10);
    }

    private ag(String str, Looper looper) {
        a(str, looper);
    }

    public final void a(af afVar) {
        this.g_.a(afVar, (af) null);
    }

    public final void b(int i10, Object obj) {
        this.g_.sendMessage(a(i10, obj));
    }

    private void a(ae aeVar) {
        this.g_.a(aeVar);
    }

    private void a(Message message) {
        c.a(this.g_, message);
    }

    private void a(int i10) {
        c.a(this.g_, i10);
    }

    private Message a(int i10, Object obj) {
        return Message.obtain(this.g_, i10, obj);
    }

    private Message a(int i10, int i11, int i12) {
        return Message.obtain(this.g_, i10, i11, i12);
    }

    private Message a(int i10, int i11, int i12, Object obj) {
        return Message.obtain(this.g_, i10, i11, i12, obj);
    }

    private void a(int i10, long j10) {
        this.g_.sendMessageDelayed(d(i10), j10);
    }

    private void a(int i10, Object obj, long j10) {
        this.g_.sendMessageDelayed(a(i10, obj), j10);
    }

    private void a(Message message, long j10) {
        this.g_.sendMessageDelayed(message, j10);
    }

    private void a(boolean z10) {
        this.g_.f2574a = z10;
    }
}
