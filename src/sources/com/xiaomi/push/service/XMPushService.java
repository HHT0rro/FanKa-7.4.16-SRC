package com.xiaomi.push.service;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.Process;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import com.huawei.appgallery.agd.common.constant.SystemPropertyValues;
import com.xiaomi.push.a5;
import com.xiaomi.push.e2;
import com.xiaomi.push.f6;
import com.xiaomi.push.g7;
import com.xiaomi.push.gh;
import com.xiaomi.push.gp;
import com.xiaomi.push.h4;
import com.xiaomi.push.h6;
import com.xiaomi.push.hq;
import com.xiaomi.push.hu;
import com.xiaomi.push.hv;
import com.xiaomi.push.i4;
import com.xiaomi.push.i5;
import com.xiaomi.push.i6;
import com.xiaomi.push.im;
import com.xiaomi.push.ip;
import com.xiaomi.push.iq;
import com.xiaomi.push.j4;
import com.xiaomi.push.j5;
import com.xiaomi.push.jg;
import com.xiaomi.push.k5;
import com.xiaomi.push.l6;
import com.xiaomi.push.n4;
import com.xiaomi.push.n6;
import com.xiaomi.push.n7;
import com.xiaomi.push.o0;
import com.xiaomi.push.o6;
import com.xiaomi.push.s4;
import com.xiaomi.push.service.aq;
import com.xiaomi.push.service.w;
import com.xiaomi.push.t0;
import com.xiaomi.push.u4;
import com.xiaomi.push.v1;
import com.xiaomi.push.v4;
import com.xiaomi.push.x3;
import com.xiaomi.push.x4;
import com.xiaomi.push.y5;
import com.xiaomi.push.z4;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class XMPushService extends Service implements x4 {

    /* renamed from: v, reason: collision with root package name */
    public static final int f48158v = Process.myPid();

    /* renamed from: w, reason: collision with root package name */
    public static int f48159w;

    /* renamed from: b, reason: collision with root package name */
    public v4 f48160b;

    /* renamed from: c, reason: collision with root package name */
    public com.xiaomi.push.service.h f48161c;

    /* renamed from: d, reason: collision with root package name */
    public String f48162d;

    /* renamed from: e, reason: collision with root package name */
    public e f48163e;

    /* renamed from: f, reason: collision with root package name */
    public p f48164f;

    /* renamed from: k, reason: collision with root package name */
    public s4 f48169k;

    /* renamed from: l, reason: collision with root package name */
    public u4 f48170l;

    /* renamed from: m, reason: collision with root package name */
    public v f48171m;

    /* renamed from: t, reason: collision with root package name */
    public ContentObserver f48178t;

    /* renamed from: u, reason: collision with root package name */
    public ContentObserver f48179u;

    /* renamed from: g, reason: collision with root package name */
    public int f48165g = 0;

    /* renamed from: h, reason: collision with root package name */
    public int f48166h = 0;

    /* renamed from: i, reason: collision with root package name */
    public long f48167i = 0;

    /* renamed from: j, reason: collision with root package name */
    public Class f48168j = XMJobService.class;

    /* renamed from: n, reason: collision with root package name */
    public com.xiaomi.push.service.d f48172n = null;

    /* renamed from: o, reason: collision with root package name */
    public w f48173o = null;

    /* renamed from: p, reason: collision with root package name */
    public Messenger f48174p = null;

    /* renamed from: q, reason: collision with root package name */
    public Collection<kc.e> f48175q = Collections.synchronizedCollection(new ArrayList());

    /* renamed from: r, reason: collision with root package name */
    public ArrayList<l> f48176r = new ArrayList<>();

    /* renamed from: s, reason: collision with root package name */
    public z4 f48177s = new com.xiaomi.push.service.l(this);

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class a extends i {

        /* renamed from: c, reason: collision with root package name */
        public aq.b f48180c;

        public a(aq.b bVar) {
            super(9);
            this.f48180c = bVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String a() {
            return "bind the client. " + this.f48180c.f48229h;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void b() {
            String str;
            try {
                if (!XMPushService.this.a0()) {
                    fc.c.n("trying bind while the connection is not created, quit!");
                    return;
                }
                aq c4 = aq.c();
                aq.b bVar = this.f48180c;
                aq.b b4 = c4.b(bVar.f48229h, bVar.f48223b);
                if (b4 == null) {
                    str = "ignore bind because the channel " + this.f48180c.f48229h + " is removed ";
                } else if (b4.f48234m == aq.c.unbind) {
                    b4.k(aq.c.binding, 0, 0, null, null);
                    XMPushService.this.f48170l.k(b4);
                    h6.f(XMPushService.this, b4);
                    return;
                } else {
                    str = "trying duplicate bind, ingore! " + ((Object) b4.f48234m);
                }
                fc.c.i(str);
            } catch (Exception e2) {
                fc.c.k(e2);
                XMPushService.this.r(10, e2);
            } catch (Throwable unused) {
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class b extends i {

        /* renamed from: c, reason: collision with root package name */
        public final aq.b f48182c;

        public b(aq.b bVar) {
            super(12);
            this.f48182c = bVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String a() {
            return "bind time out. chid=" + this.f48182c.f48229h;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void b() {
            this.f48182c.k(aq.c.unbind, 1, 21, null, null);
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return TextUtils.equals(((b) obj).f48182c.f48229h, this.f48182c.f48229h);
            }
            return false;
        }

        public int hashCode() {
            return this.f48182c.f48229h.hashCode();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class c extends i {

        /* renamed from: c, reason: collision with root package name */
        public n4 f48183c;

        public c(n4 n4Var) {
            super(8);
            this.f48183c = n4Var;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String a() {
            return "receive a message.";
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void b() {
            XMPushService.this.f48172n.a(this.f48183c);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class d extends i {
        public d() {
            super(1);
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String a() {
            return "do reconnect..";
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void b() {
            if (XMPushService.this.I()) {
                XMPushService.this.g0();
            } else {
                fc.c.i("should not connect. quit the job.");
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class e extends BroadcastReceiver {
        public e() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            XMPushService.this.onStart(intent, XMPushService.f48159w);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class f extends i {

        /* renamed from: c, reason: collision with root package name */
        public int f48187c;

        /* renamed from: d, reason: collision with root package name */
        public Exception f48188d;

        public f(int i10, Exception exc) {
            super(2);
            this.f48187c = i10;
            this.f48188d = exc;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String a() {
            return "disconnect the connection.";
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void b() {
            XMPushService.this.r(this.f48187c, this.f48188d);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class g extends i {
        public g() {
            super(65535);
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String a() {
            return "Init Job";
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void b() {
            XMPushService.this.V();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class h extends i {

        /* renamed from: c, reason: collision with root package name */
        public Intent f48191c;

        public h(Intent intent) {
            super(15);
            this.f48191c = intent;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String a() {
            return "Handle intent action = " + this.f48191c.getAction();
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void b() {
            XMPushService.this.W(this.f48191c);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static abstract class i extends w.b {
        public i(int i10) {
            super(i10);
        }

        public abstract String a();

        public abstract void b();

        @Override // java.lang.Runnable
        public void run() {
            int i10 = this.f48338b;
            if (i10 != 4 && i10 != 8) {
                fc.c.i("JOB: " + a());
            }
            b();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class j extends i {
        public j() {
            super(5);
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String a() {
            return "ask the job queue to quit";
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void b() {
            XMPushService.this.f48173o.b();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class k extends i {

        /* renamed from: c, reason: collision with root package name */
        public k5 f48194c;

        public k(k5 k5Var) {
            super(8);
            this.f48194c = k5Var;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String a() {
            return "receive a message.";
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void b() {
            XMPushService.this.f48172n.c(this.f48194c);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface l {
        void a();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class m extends i {

        /* renamed from: c, reason: collision with root package name */
        public boolean f48196c;

        public m(boolean z10) {
            super(4);
            this.f48196c = z10;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String a() {
            return "send ping..";
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void b() {
            if (XMPushService.this.a0()) {
                try {
                    if (!this.f48196c) {
                        h6.a();
                    }
                    XMPushService.this.f48170l.x(this.f48196c);
                } catch (gh e2) {
                    fc.c.k(e2);
                    XMPushService.this.r(10, e2);
                }
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class n extends i {

        /* renamed from: c, reason: collision with root package name */
        public aq.b f48198c;

        public n(aq.b bVar) {
            super(4);
            this.f48198c = bVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String a() {
            return "rebind the client. " + this.f48198c.f48229h;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void b() {
            try {
                this.f48198c.k(aq.c.unbind, 1, 16, null, null);
                u4 u4Var = XMPushService.this.f48170l;
                aq.b bVar = this.f48198c;
                u4Var.m(bVar.f48229h, bVar.f48223b);
                this.f48198c.k(aq.c.binding, 1, 16, null, null);
                XMPushService.this.f48170l.k(this.f48198c);
            } catch (gh e2) {
                fc.c.k(e2);
                XMPushService.this.r(10, e2);
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class o extends i {
        public o() {
            super(3);
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String a() {
            return "reset the connection.";
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void b() {
            XMPushService.this.r(11, null);
            if (XMPushService.this.I()) {
                XMPushService.this.g0();
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class p extends BroadcastReceiver {
        public p() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            XMPushService.this.onStart(intent, 1);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class q extends i {

        /* renamed from: c, reason: collision with root package name */
        public aq.b f48202c;

        /* renamed from: d, reason: collision with root package name */
        public int f48203d;

        /* renamed from: e, reason: collision with root package name */
        public String f48204e;

        /* renamed from: f, reason: collision with root package name */
        public String f48205f;

        public q(aq.b bVar, int i10, String str, String str2) {
            super(9);
            this.f48202c = bVar;
            this.f48203d = i10;
            this.f48204e = str;
            this.f48205f = str2;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String a() {
            return "unbind the channel. " + this.f48202c.f48229h;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void b() {
            if (this.f48202c.f48234m != aq.c.unbind && XMPushService.this.f48170l != null) {
                try {
                    u4 u4Var = XMPushService.this.f48170l;
                    aq.b bVar = this.f48202c;
                    u4Var.m(bVar.f48229h, bVar.f48223b);
                } catch (gh e2) {
                    fc.c.k(e2);
                    XMPushService.this.r(10, e2);
                }
            }
            this.f48202c.k(aq.c.unbind, this.f48203d, 0, this.f48205f, this.f48204e);
        }
    }

    static {
        v1.n("cn.app.chat.xiaomi.net", "cn.app.chat.xiaomi.net");
        f48159w = 1;
    }

    public void B(aq.b bVar) {
        if (bVar != null) {
            long a10 = bVar.a();
            fc.c.i("schedule rebind job in " + (a10 / 1000));
            x(new a(bVar), a10);
        }
    }

    public final void C(String str, int i10) {
        Collection<aq.b> f10 = aq.c().f(str);
        if (f10 != null) {
            for (aq.b bVar : f10) {
                if (bVar != null) {
                    w(new q(bVar, i10, null, null));
                }
            }
        }
        aq.c().m(str);
    }

    public void D(String str, String str2, int i10, String str3, String str4) {
        aq.b b4 = aq.c().b(str, str2);
        if (b4 != null) {
            w(new q(b4, i10, str4, str3));
        }
        aq.c().n(str, str2);
    }

    public void E(String str, byte[] bArr, boolean z10) {
        Collection<aq.b> f10 = aq.c().f("5");
        if (f10.isEmpty()) {
            if (!z10) {
                return;
            }
        } else if (f10.iterator2().next().f48234m == aq.c.binded) {
            w(new com.xiaomi.push.service.m(this, 4, str, bArr));
            return;
        } else if (!z10) {
            return;
        }
        kc.j0.f(str, bArr);
    }

    public void F(boolean z10) {
        this.f48161c.c(z10);
    }

    public void G(byte[] bArr, String str) {
        if (bArr == null) {
            kc.j0.b(this, str, bArr, 70000003, "null payload");
            fc.c.i("register request without payload");
            return;
        }
        im imVar = new im();
        try {
            o6.b(imVar, bArr);
            if (imVar.f449a == hq.Registration) {
                iq iqVar = new iq();
                try {
                    o6.b(iqVar, imVar.m3008a());
                    kc.j0.d(imVar.b(), bArr);
                    w(new b0(this, imVar.b(), iqVar.b(), iqVar.c(), bArr));
                    i4.a(getApplicationContext()).g(imVar.b(), "E100003", iqVar.a(), 6002, null);
                } catch (jg e2) {
                    fc.c.k(e2);
                    kc.j0.b(this, str, bArr, 70000003, " data action error.");
                }
            } else {
                kc.j0.b(this, str, bArr, 70000003, " registration action required.");
                fc.c.i("register request with invalid payload");
            }
        } catch (jg e10) {
            fc.c.k(e10);
            kc.j0.b(this, str, bArr, 70000003, " data container error.");
        }
    }

    public void H(n4[] n4VarArr) {
        u4 u4Var = this.f48170l;
        if (u4Var == null) {
            throw new gh("try send msg while connection is null.");
        }
        u4Var.n(n4VarArr);
    }

    public boolean I() {
        return com.xiaomi.push.j0.p(this) && aq.c().a() > 0 && !T() && l0() && !j0() && !h0();
    }

    public boolean J(int i10) {
        return this.f48173o.h(i10);
    }

    public final boolean L(String str, Intent intent) {
        aq.b b4 = aq.c().b(str, intent.getStringExtra(kc.n.f50832n));
        boolean z10 = false;
        if (b4 == null || str == null) {
            return false;
        }
        String stringExtra = intent.getStringExtra(kc.n.f50844z);
        String stringExtra2 = intent.getStringExtra(kc.n.f50837s);
        if (!TextUtils.isEmpty(b4.f48231j) && !TextUtils.equals(stringExtra, b4.f48231j)) {
            fc.c.i("session changed. old session=" + b4.f48231j + ", new session=" + stringExtra + " chid = " + str);
            z10 = true;
        }
        if (stringExtra2.equals(b4.f48230i)) {
            return z10;
        }
        fc.c.i("security changed. chid = " + str + " sechash = " + o0.b(stringExtra2));
        return true;
    }

    public final int[] M() {
        String[] split;
        String c4 = kc.j.d(getApplicationContext()).c(hv.FallDownTimeRange.a(), "");
        if (!TextUtils.isEmpty(c4) && (split = c4.split(",")) != null && split.length >= 2) {
            int[] iArr = new int[2];
            try {
                iArr[0] = Integer.valueOf(split[0]).intValue();
                iArr[1] = Integer.valueOf(split[1]).intValue();
                if (iArr[0] >= 0 && iArr[0] <= 23 && iArr[1] >= 0 && iArr[1] <= 23) {
                    if (iArr[0] != iArr[1]) {
                        return iArr;
                    }
                }
            } catch (NumberFormatException e2) {
                fc.c.n("parse falldown time range failure: " + ((Object) e2));
            }
        }
        return null;
    }

    public v N() {
        return this.f48171m;
    }

    public void O() {
        Iterator iterator2 = new ArrayList(this.f48176r).iterator2();
        while (iterator2.hasNext()) {
            ((l) iterator2.next()).a();
        }
    }

    public final void P(Intent intent) {
        String stringExtra = intent.getStringExtra(kc.n.f50841w);
        String stringExtra2 = intent.getStringExtra(kc.n.f50844z);
        Parcelable[] parcelableArrayExtra = intent.getParcelableArrayExtra("ext_packets");
        int length = parcelableArrayExtra.length;
        j5[] j5VarArr = new j5[length];
        intent.getBooleanExtra("ext_encrypt", true);
        for (int i10 = 0; i10 < parcelableArrayExtra.length; i10++) {
            j5VarArr[i10] = new j5((Bundle) parcelableArrayExtra[i10]);
            j5VarArr[i10] = (j5) i(j5VarArr[i10], stringExtra, stringExtra2);
            if (j5VarArr[i10] == null) {
                return;
            }
        }
        aq c4 = aq.c();
        n4[] n4VarArr = new n4[length];
        for (int i11 = 0; i11 < length; i11++) {
            j5 j5Var = j5VarArr[i11];
            n4VarArr[i11] = n4.b(j5Var, c4.b(j5Var.m(), j5Var.q()).f48230i);
        }
        X(new u(this, n4VarArr));
    }

    public void Q(i iVar) {
        this.f48173o.d(iVar.f48338b, iVar);
    }

    public final void S(boolean z10) {
        this.f48167i = System.currentTimeMillis();
        if (a0()) {
            if (this.f48170l.C() || this.f48170l.D() || com.xiaomi.push.j0.r(this)) {
                X(new m(z10));
                return;
            }
            X(new f(17, null));
        }
        F(true);
    }

    public boolean T() {
        try {
            Class<?> c4 = n7.c(this, "miui.os.Build");
            Field field = c4.getField("IS_CM_CUSTOMIZATION_TEST");
            Field field2 = c4.getField("IS_CU_CUSTOMIZATION_TEST");
            Field field3 = c4.getField("IS_CT_CUSTOMIZATION_TEST");
            if (!field.getBoolean(null) && !field2.getBoolean(null)) {
                if (!field3.getBoolean(null)) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public final void V() {
        String str;
        kc.a c4 = kc.a.c(getApplicationContext());
        String a10 = c4.a();
        fc.c.i("region of cache is " + a10);
        if (TextUtils.isEmpty(a10)) {
            a10 = n();
        }
        if (TextUtils.isEmpty(a10)) {
            this.f48162d = com.xiaomi.push.o.China.name();
        } else {
            this.f48162d = a10;
            c4.e(a10);
            if (com.xiaomi.push.o.Global.name().equals(this.f48162d)) {
                str = "app.chat.global.xiaomi.net";
            } else if (com.xiaomi.push.o.Europe.name().equals(this.f48162d)) {
                str = "fr.app.chat.global.xiaomi.net";
            } else if (com.xiaomi.push.o.Russia.name().equals(this.f48162d)) {
                str = "ru.app.chat.global.xiaomi.net";
            } else if (com.xiaomi.push.o.India.name().equals(this.f48162d)) {
                str = "idmb.app.chat.global.xiaomi.net";
            }
            v4.d(str);
        }
        if (com.xiaomi.push.o.China.name().equals(this.f48162d)) {
            v4.d("cn.app.chat.xiaomi.net");
        }
        if (l0()) {
            r rVar = new r(this, 11);
            w(rVar);
            a0.g(new s(this, rVar));
        }
        try {
            if (n7.g()) {
                this.f48171m.d(this);
            }
        } catch (Exception e2) {
            fc.c.k(e2);
        }
    }

    public final void W(Intent intent) {
        String str;
        v vVar;
        boolean z10;
        int i10;
        String format;
        i nVar;
        String str2;
        String c4;
        String str3;
        com.xiaomi.push.service.i iVar;
        aq c10 = aq.c();
        boolean z11 = true;
        int i11 = 0;
        if (kc.n.f50822d.equalsIgnoreCase(intent.getAction()) || kc.n.f50828j.equalsIgnoreCase(intent.getAction())) {
            String stringExtra = intent.getStringExtra(kc.n.f50834p);
            if (!TextUtils.isEmpty(intent.getStringExtra(kc.n.f50837s))) {
                if (stringExtra == null) {
                    str = "channel id is empty, do nothing!";
                    fc.c.n(str);
                    return;
                }
                boolean L = L(stringExtra, intent);
                aq.b k10 = k(stringExtra, intent);
                if (com.xiaomi.push.j0.p(this)) {
                    if (a0()) {
                        aq.c cVar = k10.f48234m;
                        if (cVar == aq.c.unbind) {
                            nVar = new a(k10);
                        } else if (L) {
                            nVar = new n(k10);
                        } else if (cVar == aq.c.binding) {
                            format = String.format("the client is binding. %1$s %2$s.", k10.f48229h, aq.b.e(k10.f48223b));
                        } else {
                            if (cVar != aq.c.binded) {
                                return;
                            }
                            vVar = this.f48171m;
                            z10 = true;
                            i10 = 0;
                        }
                        X(nVar);
                        return;
                    }
                    F(true);
                    return;
                }
                vVar = this.f48171m;
                z10 = false;
                i10 = 2;
                vVar.h(this, k10, z10, i10, null);
                return;
            }
            format = "security is empty. ignore.";
            fc.c.i(format);
            return;
        }
        if (kc.n.f50827i.equalsIgnoreCase(intent.getAction())) {
            String stringExtra2 = intent.getStringExtra(kc.n.f50841w);
            String stringExtra3 = intent.getStringExtra(kc.n.f50834p);
            String stringExtra4 = intent.getStringExtra(kc.n.f50832n);
            fc.c.i("Service called close channel chid = " + stringExtra3 + " res = " + aq.b.e(stringExtra4));
            if (TextUtils.isEmpty(stringExtra3)) {
                Iterator<String> iterator2 = c10.g(stringExtra2).iterator2();
                while (iterator2.hasNext()) {
                    C(iterator2.next(), 2);
                }
                return;
            } else if (TextUtils.isEmpty(stringExtra4)) {
                C(stringExtra3, 2);
                return;
            } else {
                D(stringExtra3, stringExtra4, 2, null, null);
                return;
            }
        }
        if (kc.n.f50823e.equalsIgnoreCase(intent.getAction())) {
            t(intent);
            return;
        }
        if (kc.n.f50825g.equalsIgnoreCase(intent.getAction())) {
            P(intent);
            return;
        }
        if (kc.n.f50824f.equalsIgnoreCase(intent.getAction())) {
            k5 i12 = i(new i5(intent.getBundleExtra("ext_packet")), intent.getStringExtra(kc.n.f50841w), intent.getStringExtra(kc.n.f50844z));
            if (i12 == null) {
                return;
            } else {
                iVar = new com.xiaomi.push.service.i(this, n4.b(i12, c10.b(i12.m(), i12.q()).f48230i));
            }
        } else {
            if (!kc.n.f50826h.equalsIgnoreCase(intent.getAction())) {
                if (!kc.n.f50829k.equals(intent.getAction())) {
                    aq.b bVar = null;
                    if (!kc.n.f50830l.equals(intent.getAction())) {
                        if ("android.intent.action.SCREEN_ON".equals(intent.getAction()) || "android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                            if ("android.intent.action.SCREEN_ON".equals(intent.getAction())) {
                                if (n0()) {
                                    return;
                                }
                                fc.c.i("exit falldown mode, activate alarm.");
                                e0();
                                if (a0() || d0()) {
                                    return;
                                }
                                F(true);
                                return;
                            }
                            if (!"android.intent.action.SCREEN_OFF".equals(intent.getAction()) || !n0() || !j4.e()) {
                                return;
                            } else {
                                str2 = "enter falldown mode, stop alarm.";
                            }
                        } else if ("com.xiaomi.mipush.REGISTER_APP".equals(intent.getAction())) {
                            if (kc.q.c(getApplicationContext()).d() && kc.q.c(getApplicationContext()).a() == 0) {
                                str3 = "register without being provisioned. " + intent.getStringExtra("mipush_app_package");
                            } else {
                                byte[] byteArrayExtra = intent.getByteArrayExtra("mipush_payload");
                                String stringExtra5 = intent.getStringExtra("mipush_app_package");
                                boolean booleanExtra = intent.getBooleanExtra("mipush_env_chanage", false);
                                int intExtra = intent.getIntExtra("mipush_env_type", 1);
                                kc.i0.a(this).h(stringExtra5);
                                if (!booleanExtra || "com.xiaomi.xmsf".equals(getPackageName())) {
                                    G(byteArrayExtra, stringExtra5);
                                    return;
                                }
                                nVar = new t(this, 14, intExtra, byteArrayExtra, stringExtra5);
                            }
                        } else {
                            if ("com.xiaomi.mipush.SEND_MESSAGE".equals(intent.getAction()) || "com.xiaomi.mipush.UNREGISTER_APP".equals(intent.getAction())) {
                                String stringExtra6 = intent.getStringExtra("mipush_app_package");
                                byte[] byteArrayExtra2 = intent.getByteArrayExtra("mipush_payload");
                                boolean booleanExtra2 = intent.getBooleanExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
                                if ("com.xiaomi.mipush.UNREGISTER_APP".equals(intent.getAction())) {
                                    kc.i0.a(this).b(stringExtra6);
                                }
                                E(stringExtra6, byteArrayExtra2, booleanExtra2);
                                return;
                            }
                            if (!kc.r.f50850a.equals(intent.getAction())) {
                                if (kc.r.f50851b.equals(intent.getAction())) {
                                    String stringExtra7 = intent.getStringExtra("data_cleared_pkg_name");
                                    if (stringExtra7 == null || TextUtils.isEmpty(stringExtra7.trim())) {
                                        return;
                                    }
                                    fc.c.i("clear notifications of package " + stringExtra7);
                                    com.xiaomi.push.service.a.t(this, stringExtra7);
                                    return;
                                }
                                if ("com.xiaomi.mipush.CLEAR_NOTIFICATION".equals(intent.getAction())) {
                                    String stringExtra8 = intent.getStringExtra(kc.n.f50841w);
                                    int intExtra2 = intent.getIntExtra(kc.n.f50842x, -2);
                                    if (TextUtils.isEmpty(stringExtra8)) {
                                        return;
                                    }
                                    if (intExtra2 >= -1) {
                                        com.xiaomi.push.service.a.u(this, stringExtra8, intExtra2);
                                        return;
                                    } else {
                                        com.xiaomi.push.service.a.v(this, stringExtra8, intent.getStringExtra(kc.n.B), intent.getStringExtra(kc.n.C));
                                        return;
                                    }
                                }
                                if ("com.xiaomi.mipush.SET_NOTIFICATION_TYPE".equals(intent.getAction())) {
                                    String stringExtra9 = intent.getStringExtra(kc.n.f50841w);
                                    String stringExtra10 = intent.getStringExtra(kc.n.A);
                                    if (intent.hasExtra(kc.n.f50843y)) {
                                        int intExtra3 = intent.getIntExtra(kc.n.f50843y, 0);
                                        c4 = o0.c(stringExtra9 + intExtra3);
                                        i11 = intExtra3;
                                        z11 = false;
                                    } else {
                                        c4 = o0.c(stringExtra9);
                                    }
                                    if (!TextUtils.isEmpty(stringExtra9) && TextUtils.equals(stringExtra10, c4)) {
                                        if (z11) {
                                            com.xiaomi.push.service.a.H(this, stringExtra9);
                                            return;
                                        } else {
                                            com.xiaomi.push.service.a.I(this, stringExtra9, i11);
                                            return;
                                        }
                                    }
                                    str = "invalid notification for " + stringExtra9;
                                    fc.c.n(str);
                                    return;
                                }
                                if ("com.xiaomi.mipush.DISABLE_PUSH".equals(intent.getAction())) {
                                    String stringExtra11 = intent.getStringExtra("mipush_app_package");
                                    if (!TextUtils.isEmpty(stringExtra11)) {
                                        kc.i0.a(this).d(stringExtra11);
                                    }
                                    if ("com.xiaomi.xmsf".equals(getPackageName())) {
                                        return;
                                    }
                                    r(19, null);
                                    e0();
                                    stopSelf();
                                    return;
                                }
                                if ("com.xiaomi.mipush.DISABLE_PUSH_MESSAGE".equals(intent.getAction()) || "com.xiaomi.mipush.ENABLE_PUSH_MESSAGE".equals(intent.getAction())) {
                                    String stringExtra12 = intent.getStringExtra("mipush_app_package");
                                    byte[] byteArrayExtra3 = intent.getByteArrayExtra("mipush_payload");
                                    String stringExtra13 = intent.getStringExtra("mipush_app_id");
                                    String stringExtra14 = intent.getStringExtra("mipush_app_token");
                                    if ("com.xiaomi.mipush.DISABLE_PUSH_MESSAGE".equals(intent.getAction())) {
                                        kc.i0.a(this).f(stringExtra12);
                                    }
                                    if ("com.xiaomi.mipush.ENABLE_PUSH_MESSAGE".equals(intent.getAction())) {
                                        kc.i0.a(this).i(stringExtra12);
                                        kc.i0.a(this).j(stringExtra12);
                                    }
                                    if (byteArrayExtra3 == null) {
                                        kc.j0.b(this, stringExtra12, byteArrayExtra3, 70000003, "null payload");
                                        return;
                                    }
                                    kc.j0.f(stringExtra12, byteArrayExtra3);
                                    w(new b0(this, stringExtra12, stringExtra13, stringExtra14, byteArrayExtra3));
                                    if ("com.xiaomi.mipush.ENABLE_PUSH_MESSAGE".equals(intent.getAction()) && this.f48163e == null) {
                                        this.f48163e = new e();
                                        registerReceiver(this.f48163e, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                                        return;
                                    }
                                    return;
                                }
                                if ("com.xiaomi.mipush.SEND_TINYDATA".equals(intent.getAction())) {
                                    String stringExtra15 = intent.getStringExtra("mipush_app_package");
                                    byte[] byteArrayExtra4 = intent.getByteArrayExtra("mipush_payload");
                                    hu huVar = new hu();
                                    try {
                                        o6.b(huVar, byteArrayExtra4);
                                        l6.a(this).e(huVar, stringExtra15);
                                        return;
                                    } catch (jg e2) {
                                        fc.c.k(e2);
                                        return;
                                    }
                                }
                                if ("com.xiaomi.push.timer".equalsIgnoreCase(intent.getAction())) {
                                    fc.c.i("Service called on timer");
                                    if (!n0()) {
                                        j4.d(false);
                                        if (!f0()) {
                                            return;
                                        }
                                    } else if (!j4.e()) {
                                        return;
                                    } else {
                                        str2 = "enter falldown mode, stop alarm";
                                    }
                                } else {
                                    if (!"com.xiaomi.push.check_alive".equalsIgnoreCase(intent.getAction())) {
                                        if ("com.xiaomi.mipush.thirdparty".equals(intent.getAction())) {
                                            fc.c.i("on thirdpart push :" + intent.getStringExtra("com.xiaomi.mipush.thirdparty_DESC"));
                                            j4.c(this, intent.getIntExtra("com.xiaomi.mipush.thirdparty_LEVEL", 0));
                                            return;
                                        }
                                        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                                            b0();
                                            return;
                                        }
                                        if ("action_cr_config".equals(intent.getAction())) {
                                            boolean booleanExtra3 = intent.getBooleanExtra("action_cr_event_switch", false);
                                            long longExtra = intent.getLongExtra("action_cr_event_frequency", 86400L);
                                            boolean booleanExtra4 = intent.getBooleanExtra("action_cr_perf_switch", false);
                                            long longExtra2 = intent.getLongExtra("action_cr_perf_frequency", 86400L);
                                            boolean booleanExtra5 = intent.getBooleanExtra("action_cr_event_en", true);
                                            long longExtra3 = intent.getLongExtra("action_cr_max_file_size", 1048576L);
                                            gc.a h10 = gc.a.b().l(booleanExtra3).k(longExtra).o(booleanExtra4).n(longExtra2).i(t0.b(getApplicationContext())).j(booleanExtra5).m(longExtra3).h(getApplicationContext());
                                            if ("com.xiaomi.xmsf".equals(getPackageName()) || longExtra <= 0 || longExtra2 <= 0 || longExtra3 <= 0) {
                                                return;
                                            }
                                            h4.m(getApplicationContext(), h10);
                                            return;
                                        }
                                        if (!"action_help_ping".equals(intent.getAction())) {
                                            if ("action_aw_app_logic".equals(intent.getAction())) {
                                                c0(intent);
                                                return;
                                            }
                                            return;
                                        }
                                        boolean booleanExtra6 = intent.getBooleanExtra("extra_help_ping_switch", false);
                                        int intExtra4 = intent.getIntExtra("extra_help_ping_frequency", 0);
                                        if (intExtra4 >= 0 && intExtra4 < 30) {
                                            fc.c.m("aw_ping: frquency need > 30s.");
                                            intExtra4 = 30;
                                        }
                                        boolean z12 = intExtra4 >= 0 ? booleanExtra6 : false;
                                        fc.c.i("aw_ping: receive a aw_ping message. switch: " + z12 + " frequency: " + intExtra4);
                                        if (!z12 || intExtra4 <= 0 || "com.xiaomi.xmsf".equals(getPackageName())) {
                                            return;
                                        }
                                        u(intent, intExtra4);
                                        return;
                                    }
                                    fc.c.i("Service called on check alive.");
                                    if (!f0()) {
                                        return;
                                    }
                                }
                                S(false);
                                return;
                            }
                            String stringExtra16 = intent.getStringExtra("uninstall_pkg_name");
                            if (stringExtra16 == null || TextUtils.isEmpty(stringExtra16.trim())) {
                                return;
                            }
                            try {
                                getPackageManager().getPackageInfo(stringExtra16, 0);
                                z11 = false;
                            } catch (PackageManager.NameNotFoundException unused) {
                            }
                            if (!"com.xiaomi.channel".equals(stringExtra16) || aq.c().f("1").isEmpty() || !z11) {
                                SharedPreferences sharedPreferences = getSharedPreferences("pref_registered_pkg_names", 0);
                                String string = sharedPreferences.getString(stringExtra16, null);
                                if (TextUtils.isEmpty(string) || !z11) {
                                    return;
                                }
                                SharedPreferences.Editor edit = sharedPreferences.edit();
                                edit.remove(stringExtra16);
                                edit.commit();
                                if (com.xiaomi.push.service.a.J(this, stringExtra16)) {
                                    com.xiaomi.push.service.a.H(this, stringExtra16);
                                }
                                com.xiaomi.push.service.a.t(this, stringExtra16);
                                if (!a0() || string == null) {
                                    return;
                                }
                                try {
                                    j0.h(this, j0.c(stringExtra16, string));
                                    fc.c.i("uninstall " + stringExtra16 + " msg sent");
                                    return;
                                } catch (gh e10) {
                                    fc.c.n("Fail to send Message: " + e10.getMessage());
                                    r(10, e10);
                                    return;
                                }
                            }
                            C("1", 0);
                            str3 = "close the miliao channel as the app is uninstalled.";
                        }
                        fc.c.i(str2);
                        j4.a();
                        return;
                    }
                    String stringExtra17 = intent.getStringExtra(kc.n.f50841w);
                    List<String> g3 = c10.g(stringExtra17);
                    if (!g3.isEmpty()) {
                        String stringExtra18 = intent.getStringExtra(kc.n.f50834p);
                        String stringExtra19 = intent.getStringExtra(kc.n.f50832n);
                        if (TextUtils.isEmpty(stringExtra18)) {
                            stringExtra18 = g3.get(0);
                        }
                        if (TextUtils.isEmpty(stringExtra19)) {
                            Collection<aq.b> f10 = c10.f(stringExtra18);
                            if (f10 != null && !f10.isEmpty()) {
                                bVar = f10.iterator2().next();
                            }
                        } else {
                            bVar = c10.b(stringExtra18, stringExtra19);
                        }
                        if (bVar != null) {
                            if (intent.hasExtra(kc.n.f50839u)) {
                                bVar.f48227f = intent.getStringExtra(kc.n.f50839u);
                            }
                            if (intent.hasExtra(kc.n.f50840v)) {
                                bVar.f48228g = intent.getStringExtra(kc.n.f50840v);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    str3 = "open channel should be called first before update info, pkg=" + stringExtra17;
                    fc.c.i(str3);
                    return;
                }
                String stringExtra20 = intent.getStringExtra(kc.n.f50834p);
                String stringExtra21 = intent.getStringExtra(kc.n.f50832n);
                if (stringExtra20 == null) {
                    return;
                }
                fc.c.i("request reset connection from chid = " + stringExtra20);
                aq.b b4 = aq.c().b(stringExtra20, stringExtra21);
                if (b4 == null || !b4.f48230i.equals(intent.getStringExtra(kc.n.f50837s)) || b4.f48234m != aq.c.binded) {
                    return;
                }
                u4 e11 = e();
                if (e11 != null && e11.p(System.currentTimeMillis() - 15000)) {
                    return;
                } else {
                    nVar = new o();
                }
                X(nVar);
                return;
            }
            k5 i13 = i(new gp(intent.getBundleExtra("ext_packet")), intent.getStringExtra(kc.n.f50841w), intent.getStringExtra(kc.n.f50844z));
            if (i13 == null) {
                return;
            } else {
                iVar = new com.xiaomi.push.service.i(this, n4.b(i13, c10.b(i13.m(), i13.q()).f48230i));
            }
        }
        X(iVar);
    }

    public final void X(i iVar) {
        this.f48173o.e(iVar);
    }

    public final void Z(boolean z10) {
        try {
            if (n7.g()) {
                if (!z10) {
                    sendBroadcast(new Intent("miui.intent.action.NETWORK_BLOCKED"));
                    return;
                }
                sendBroadcast(new Intent("miui.intent.action.NETWORK_CONNECTED"));
                for (kc.e eVar : (kc.e[]) this.f48175q.toArray(new kc.e[0])) {
                    eVar.a();
                }
            }
        } catch (Exception e2) {
            fc.c.k(e2);
        }
    }

    @Override // com.xiaomi.push.x4
    public void a(u4 u4Var, int i10, Exception exc) {
        f6.e().a(u4Var, i10, exc);
        if (n0()) {
            return;
        }
        F(false);
    }

    public boolean a0() {
        u4 u4Var = this.f48170l;
        return u4Var != null && u4Var.A();
    }

    @Override // com.xiaomi.push.x4
    public void b(u4 u4Var, Exception exc) {
        f6.e().b(u4Var, exc);
        Z(false);
        if (n0()) {
            return;
        }
        F(false);
    }

    public final void b0() {
        NetworkInfo networkInfo;
        try {
            networkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e2) {
            fc.c.k(e2);
            networkInfo = null;
        }
        if (networkInfo != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("network changed,");
            sb2.append("[type: " + networkInfo.getTypeName() + "[" + networkInfo.getSubtypeName() + "], state: " + ((Object) networkInfo.getState()) + "/" + ((Object) networkInfo.getDetailedState()));
            fc.c.i(sb2.toString());
            NetworkInfo.State state = networkInfo.getState();
            if (state == NetworkInfo.State.SUSPENDED || state == NetworkInfo.State.UNKNOWN) {
                return;
            }
        } else {
            fc.c.i("network changed, no active network");
        }
        if (f6.e() != null) {
            f6.e().f();
        }
        y5.h(this);
        this.f48169k.B();
        if (com.xiaomi.push.j0.p(this)) {
            if (a0() && f0()) {
                S(false);
            }
            if (!a0() && !d0()) {
                this.f48173o.c(1);
                w(new d());
            }
            e2.b(this).d();
        } else {
            w(new f(2, null));
        }
        e0();
    }

    @Override // com.xiaomi.push.x4
    public void c(u4 u4Var) {
        fc.c.m("begin to connect...");
        f6.e().c(u4Var);
    }

    public final void c0(Intent intent) {
        int i10;
        try {
            x3.b(getApplicationContext()).j(new kc.p());
            String stringExtra = intent.getStringExtra("mipush_app_package");
            byte[] byteArrayExtra = intent.getByteArrayExtra("mipush_payload");
            if (byteArrayExtra == null) {
                return;
            }
            ip ipVar = new ip();
            o6.b(ipVar, byteArrayExtra);
            String b4 = ipVar.b();
            Map<String, String> m3017a = ipVar.m3017a();
            if (m3017a != null) {
                String str = m3017a.get("extra_help_aw_info");
                String str2 = m3017a.get("extra_aw_app_online_cmd");
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                try {
                    i10 = Integer.parseInt(str2);
                } catch (NumberFormatException unused) {
                    i10 = 0;
                }
                if (TextUtils.isEmpty(stringExtra) || TextUtils.isEmpty(b4) || TextUtils.isEmpty(str)) {
                    return;
                }
                x3.b(getApplicationContext()).f(this, str, i10, stringExtra, b4);
            }
        } catch (jg e2) {
            fc.c.n("aw_logic: translate fail. " + e2.getMessage());
        }
    }

    @Override // com.xiaomi.push.x4
    public void d(u4 u4Var) {
        f6.e().d(u4Var);
        Z(true);
        this.f48161c.b();
        if (!j4.e() && !n0()) {
            fc.c.i("reconnection successful, reactivate alarm.");
            j4.d(true);
        }
        Iterator<aq.b> iterator2 = aq.c().e().iterator2();
        while (iterator2.hasNext()) {
            w(new a(iterator2.next()));
        }
    }

    public boolean d0() {
        u4 u4Var = this.f48170l;
        return u4Var != null && u4Var.y();
    }

    public u4 e() {
        return this.f48170l;
    }

    public final void e0() {
        if (!I()) {
            j4.a();
        } else {
            if (j4.e()) {
                return;
            }
            j4.d(true);
        }
    }

    public final boolean f0() {
        if (System.currentTimeMillis() - this.f48167i < 30000) {
            return false;
        }
        return com.xiaomi.push.j0.q(this);
    }

    public final void g0() {
        String str;
        u4 u4Var = this.f48170l;
        if (u4Var == null || !u4Var.y()) {
            u4 u4Var2 = this.f48170l;
            if (u4Var2 == null || !u4Var2.A()) {
                this.f48160b.k(com.xiaomi.push.j0.g(this));
                i0();
                if (this.f48170l == null) {
                    aq.c().i(this);
                    Z(false);
                    return;
                }
                return;
            }
            str = "try to connect while is connected.";
        } else {
            str = "try to connect while connecting.";
        }
        fc.c.n(str);
    }

    public final boolean h0() {
        return "com.xiaomi.xmsf".equals(getPackageName()) && Settings.Secure.getInt(getContentResolver(), "EXTREME_POWER_MODE_ENABLE", 0) == 1;
    }

    public final k5 i(k5 k5Var, String str, String str2) {
        StringBuilder sb2;
        String str3;
        aq c4 = aq.c();
        List<String> g3 = c4.g(str);
        if (g3.isEmpty()) {
            sb2 = new StringBuilder();
            str3 = "open channel should be called first before sending a packet, pkg=";
        } else {
            k5Var.v(str);
            str = k5Var.m();
            if (TextUtils.isEmpty(str)) {
                str = g3.get(0);
                k5Var.p(str);
            }
            aq.b b4 = c4.b(str, k5Var.q());
            if (!a0()) {
                sb2 = new StringBuilder();
                str3 = "drop a packet as the channel is not connected, chid=";
            } else {
                if (b4 != null && b4.f48234m == aq.c.binded) {
                    if (TextUtils.equals(str2, b4.f48231j)) {
                        return k5Var;
                    }
                    sb2 = new StringBuilder();
                    sb2.append("invalid session. ");
                    sb2.append(str2);
                    fc.c.i(sb2.toString());
                    return null;
                }
                sb2 = new StringBuilder();
                str3 = "drop a packet as the channel is not opened, chid=";
            }
        }
        sb2.append(str3);
        sb2.append(str);
        fc.c.i(sb2.toString());
        return null;
    }

    public final void i0() {
        try {
            this.f48169k.i(this.f48177s, new kc.c0(this));
            this.f48169k.P();
            this.f48170l = this.f48169k;
        } catch (gh e2) {
            fc.c.j("fail to create Slim connection", e2);
            this.f48169k.t(3, e2);
        }
    }

    public final boolean j0() {
        return "com.xiaomi.xmsf".equals(getPackageName()) && Settings.System.getInt(getContentResolver(), "power_supersave_mode_open", 0) == 1;
    }

    public final aq.b k(String str, Intent intent) {
        aq.b b4 = aq.c().b(str, intent.getStringExtra(kc.n.f50832n));
        if (b4 == null) {
            b4 = new aq.b(this);
        }
        b4.f48229h = intent.getStringExtra(kc.n.f50834p);
        b4.f48223b = intent.getStringExtra(kc.n.f50832n);
        b4.f48224c = intent.getStringExtra(kc.n.f50835q);
        b4.f48222a = intent.getStringExtra(kc.n.f50841w);
        b4.f48227f = intent.getStringExtra(kc.n.f50839u);
        b4.f48228g = intent.getStringExtra(kc.n.f50840v);
        b4.f48226e = intent.getBooleanExtra(kc.n.f50838t, false);
        b4.f48230i = intent.getStringExtra(kc.n.f50837s);
        b4.f48231j = intent.getStringExtra(kc.n.f50844z);
        b4.f48225d = intent.getStringExtra(kc.n.f50836r);
        b4.f48232k = this.f48171m;
        b4.h((Messenger) intent.getParcelableExtra(kc.n.D));
        b4.f48233l = getApplicationContext();
        aq.c().l(b4);
        return b4;
    }

    public final void k0() {
    }

    public v l() {
        return new v();
    }

    public final boolean l0() {
        return "com.xiaomi.xmsf".equals(getPackageName()) || !kc.i0.a(this).e(getPackageName());
    }

    public final void m0() {
        synchronized (this.f48176r) {
            this.f48176r.clear();
        }
    }

    public final String n() {
        String h10;
        com.xiaomi.push.u.a();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Object obj = new Object();
        String str = null;
        if ("com.xiaomi.xmsf".equals(getPackageName())) {
            kc.q c4 = kc.q.c(this);
            h10 = null;
            while (true) {
                if (!TextUtils.isEmpty(h10) && c4.a() != 0) {
                    break;
                }
                if (TextUtils.isEmpty(h10)) {
                    h10 = g7.d("ro.miui.region");
                    if (TextUtils.isEmpty(h10)) {
                        h10 = g7.d(SystemPropertyValues.PROP_REGION_KEY);
                    }
                }
                try {
                    synchronized (obj) {
                        obj.wait(100L);
                    }
                } catch (InterruptedException unused) {
                }
            }
        } else {
            h10 = g7.h();
        }
        if (!TextUtils.isEmpty(h10)) {
            kc.a.c(getApplicationContext()).g(h10);
            str = g7.b(h10).name();
        }
        fc.c.i("wait region :" + str + " cost = " + (SystemClock.elapsedRealtime() - elapsedRealtime));
        return str;
    }

    public final boolean n0() {
        return getApplicationContext().getPackageName().equals("com.xiaomi.xmsf") && o0() && !n6.r(this) && !n6.l(getApplicationContext());
    }

    public final boolean o0() {
        int intValue = Integer.valueOf(String.format("%tH", new Date())).intValue();
        int i10 = this.f48165g;
        int i11 = this.f48166h;
        if (i10 > i11) {
            if (intValue >= i10 || intValue < i11) {
                return true;
            }
        } else if (i10 < i11 && intValue >= i10 && intValue < i11) {
            return true;
        }
        return false;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f48174p.getBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        n7.f(this);
        z a10 = a0.a(this);
        if (a10 != null) {
            com.xiaomi.push.e.b(a10.f48366g);
        }
        this.f48174p = new Messenger(new kc.d0(this));
        kc.o.d(this);
        kc.e0 e0Var = new kc.e0(this, null, 5222, "xiaomi.com", null);
        this.f48160b = e0Var;
        e0Var.g(true);
        this.f48169k = new s4(this, this.f48160b);
        this.f48171m = l();
        j4.b(this);
        this.f48169k.h(this);
        this.f48172n = new com.xiaomi.push.service.d(this);
        this.f48161c = new com.xiaomi.push.service.h(this);
        new kc.f0().b();
        f6.f().j(this);
        this.f48173o = new w("Connection Controller Thread");
        aq c4 = aq.c();
        c4.o();
        c4.k(new com.xiaomi.push.service.o(this));
        if (p0()) {
            k0();
        }
        l6.a(this).d(new x(this), "UPLOADER_PUSH_CHANNEL");
        y(new i6(this));
        w(new g());
        this.f48175q.add(com.xiaomi.push.service.j.c(this));
        if (l0()) {
            this.f48163e = new e();
            registerReceiver(this.f48163e, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
        if ("com.xiaomi.xmsf".equals(getPackageName())) {
            Uri uriFor = Settings.Secure.getUriFor("EXTREME_POWER_MODE_ENABLE");
            if (uriFor != null) {
                this.f48178t = new com.xiaomi.push.service.p(this, new Handler(Looper.getMainLooper()));
                try {
                    getContentResolver().registerContentObserver(uriFor, false, this.f48178t);
                } catch (Throwable th) {
                    fc.c.i("register observer err:" + th.getMessage());
                }
            }
            Uri uriFor2 = Settings.System.getUriFor("power_supersave_mode_open");
            if (uriFor2 != null) {
                this.f48179u = new com.xiaomi.push.service.q(this, new Handler(Looper.getMainLooper()));
                try {
                    getContentResolver().registerContentObserver(uriFor2, false, this.f48179u);
                } catch (Throwable th2) {
                    fc.c.n("register super-power-mode observer err:" + th2.getMessage());
                }
            }
            int[] M = M();
            if (M != null) {
                this.f48164f = new p();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.SCREEN_ON");
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
                registerReceiver(this.f48164f, intentFilter);
                this.f48165g = M[0];
                this.f48166h = M[1];
                fc.c.i("falldown initialized: " + this.f48165g + "," + this.f48166h);
            }
        }
        fc.c.i("XMPushService created pid = " + f48158v);
    }

    @Override // android.app.Service
    public void onDestroy() {
        e eVar = this.f48163e;
        if (eVar != null) {
            s(eVar);
            this.f48163e = null;
        }
        p pVar = this.f48164f;
        if (pVar != null) {
            s(pVar);
            this.f48164f = null;
        }
        if ("com.xiaomi.xmsf".equals(getPackageName()) && this.f48178t != null) {
            try {
                getContentResolver().unregisterContentObserver(this.f48178t);
            } catch (Throwable th) {
                fc.c.i("unregister observer err:" + th.getMessage());
            }
        }
        if ("com.xiaomi.xmsf".equals(getPackageName()) && this.f48179u != null) {
            try {
                getContentResolver().unregisterContentObserver(this.f48179u);
            } catch (Throwable th2) {
                fc.c.n("unregister super-power-mode err:" + th2.getMessage());
            }
        }
        this.f48175q.clear();
        this.f48173o.i();
        w(new com.xiaomi.push.service.n(this, 2));
        w(new j());
        aq.c().o();
        aq.c().j(this, 15);
        aq.c().h();
        this.f48169k.v(this);
        kc.x.h().i();
        j4.a();
        m0();
        super.onDestroy();
        fc.c.i("Service destroyed");
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i10) {
        h hVar;
        long currentTimeMillis = System.currentTimeMillis();
        if (intent == null) {
            fc.c.n("onStart() with intent NULL");
        } else {
            fc.c.m(String.format("onStart() with intent.Action = %s, chid = %s, pkg = %s|%s, from-bridge = %s", intent.getAction(), intent.getStringExtra(kc.n.f50834p), intent.getStringExtra(kc.n.f50841w), intent.getStringExtra("mipush_app_package"), intent.getStringExtra("ext_is_xmpushservice_bridge")));
        }
        if (intent != null && intent.getAction() != null) {
            if ("com.xiaomi.push.timer".equalsIgnoreCase(intent.getAction()) || "com.xiaomi.push.check_alive".equalsIgnoreCase(intent.getAction())) {
                if (this.f48173o.g()) {
                    fc.c.n("ERROR, the job controller is blocked.");
                    aq.c().j(this, 14);
                    stopSelf();
                } else {
                    hVar = new h(intent);
                    w(hVar);
                }
            } else if (!"com.xiaomi.push.network_status_changed".equalsIgnoreCase(intent.getAction())) {
                hVar = new h(intent);
                w(hVar);
            }
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (currentTimeMillis2 > 50) {
            fc.c.m("[Prefs] spend " + currentTimeMillis2 + " ms, too more times.");
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        onStart(intent, i11);
        return f48159w;
    }

    public void p() {
        if (System.currentTimeMillis() - this.f48167i >= a5.a() && com.xiaomi.push.j0.q(this)) {
            S(true);
        }
    }

    public final boolean p0() {
        if (TextUtils.equals(getPackageName(), "com.xiaomi.xmsf")) {
            return false;
        }
        return kc.j.d(this).i(hv.ForegroundServiceSwitch.a(), false);
    }

    public void q(int i10) {
        this.f48173o.c(i10);
    }

    public void r(int i10, Exception exc) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("disconnect ");
        sb2.append(hashCode());
        sb2.append(", ");
        u4 u4Var = this.f48170l;
        sb2.append((Object) (u4Var == null ? null : Integer.valueOf(u4Var.hashCode())));
        fc.c.i(sb2.toString());
        u4 u4Var2 = this.f48170l;
        if (u4Var2 != null) {
            u4Var2.t(i10, exc);
            this.f48170l = null;
        }
        q(7);
        q(4);
        aq.c().j(this, i10);
    }

    public final void s(BroadcastReceiver broadcastReceiver) {
        if (broadcastReceiver != null) {
            try {
                unregisterReceiver(broadcastReceiver);
            } catch (IllegalArgumentException e2) {
                fc.c.k(e2);
            }
        }
    }

    public final void t(Intent intent) {
        String stringExtra = intent.getStringExtra(kc.n.f50841w);
        String stringExtra2 = intent.getStringExtra(kc.n.f50844z);
        Bundle bundleExtra = intent.getBundleExtra("ext_packet");
        aq c4 = aq.c();
        n4 n4Var = null;
        if (bundleExtra != null) {
            j5 j5Var = (j5) i(new j5(bundleExtra), stringExtra, stringExtra2);
            if (j5Var == null) {
                return;
            } else {
                n4Var = n4.b(j5Var, c4.b(j5Var.m(), j5Var.q()).f48230i);
            }
        } else {
            byte[] byteArrayExtra = intent.getByteArrayExtra("ext_raw_packet");
            if (byteArrayExtra != null) {
                long longExtra = intent.getLongExtra(kc.n.f50832n, 0L);
                String stringExtra3 = intent.getStringExtra(kc.n.f50833o);
                String stringExtra4 = intent.getStringExtra("ext_chid");
                aq.b b4 = c4.b(stringExtra4, Long.toString(longExtra));
                if (b4 != null) {
                    n4 n4Var2 = new n4();
                    try {
                        n4Var2.g(Integer.parseInt(stringExtra4));
                    } catch (NumberFormatException unused) {
                    }
                    n4Var2.j("SECMSG", null);
                    n4Var2.h(longExtra, "xiaomi.com", stringExtra3);
                    n4Var2.i(intent.getStringExtra("ext_pkt_id"));
                    n4Var2.l(byteArrayExtra, b4.f48230i);
                    n4Var = n4Var2;
                }
            }
        }
        if (n4Var != null) {
            X(new com.xiaomi.push.service.i(this, n4Var));
        }
    }

    public final void u(Intent intent, int i10) {
        byte[] byteArrayExtra = intent.getByteArrayExtra("mipush_payload");
        boolean booleanExtra = intent.getBooleanExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
        ip ipVar = new ip();
        try {
            o6.b(ipVar, byteArrayExtra);
            com.xiaomi.push.n.c(getApplicationContext()).k(new kc.t(ipVar, new WeakReference(this), booleanExtra), i10);
        } catch (jg unused) {
            fc.c.n("aw_ping : send help app ping  error");
        }
    }

    public void v(n4 n4Var) {
        u4 u4Var = this.f48170l;
        if (u4Var == null) {
            throw new gh("try send msg while connection is null.");
        }
        u4Var.u(n4Var);
    }

    public void w(i iVar) {
        x(iVar, 0L);
    }

    public void x(i iVar, long j10) {
        try {
            this.f48173o.f(iVar, j10);
        } catch (IllegalStateException e2) {
            fc.c.i("can't execute job err = " + e2.getMessage());
        }
    }

    public void y(l lVar) {
        synchronized (this.f48176r) {
            this.f48176r.add(lVar);
        }
    }
}
