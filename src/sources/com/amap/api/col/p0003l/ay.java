package com.amap.api.col.p0003l;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import org.json.JSONException;

/* compiled from: OfflineDownloadManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ay {

    /* renamed from: a, reason: collision with root package name */
    public static String f5077a = "";

    /* renamed from: b, reason: collision with root package name */
    public static boolean f5078b = false;

    /* renamed from: d, reason: collision with root package name */
    public static String f5079d = "";

    /* renamed from: k, reason: collision with root package name */
    private static volatile ay f5080k;

    /* renamed from: f, reason: collision with root package name */
    public bc f5083f;

    /* renamed from: g, reason: collision with root package name */
    public be f5084g;

    /* renamed from: i, reason: collision with root package name */
    private Context f5086i;

    /* renamed from: l, reason: collision with root package name */
    private a f5088l;

    /* renamed from: m, reason: collision with root package name */
    private bh f5089m;

    /* renamed from: n, reason: collision with root package name */
    private bn f5090n;

    /* renamed from: j, reason: collision with root package name */
    private boolean f5087j = true;

    /* renamed from: c, reason: collision with root package name */
    public List<ax> f5081c = new Vector();

    /* renamed from: o, reason: collision with root package name */
    private jd f5091o = null;

    /* renamed from: p, reason: collision with root package name */
    private jd f5092p = null;

    /* renamed from: q, reason: collision with root package name */
    private jd f5093q = null;

    /* renamed from: e, reason: collision with root package name */
    public b f5082e = null;

    /* renamed from: h, reason: collision with root package name */
    public bb f5085h = null;

    /* renamed from: r, reason: collision with root package name */
    private boolean f5094r = true;

    /* compiled from: OfflineDownloadManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface a {
        void a();

        void a(ax axVar);

        void b(ax axVar);

        void c(ax axVar);
    }

    /* compiled from: OfflineDownloadManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            try {
                message.getData();
                Object obj = message.obj;
                if (obj instanceof ax) {
                    ax axVar = (ax) obj;
                    axVar.getCity();
                    axVar.getcompleteCode();
                    axVar.getState();
                    if (ay.this.f5088l != null) {
                        ay.this.f5088l.a(axVar);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private ay(Context context) {
        this.f5086i = context;
    }

    public static /* synthetic */ boolean f(ay ayVar) {
        ayVar.f5087j = false;
        return false;
    }

    private void g() {
        try {
            bi a10 = this.f5090n.a("000001");
            if (a10 != null) {
                this.f5090n.c("000001");
                a10.c("100000");
                this.f5090n.a(a10);
            }
        } catch (Throwable th) {
            gy.b(th, "OfflineDownloadManager", "changeBadCase");
        }
    }

    private void h() {
        String c4;
        if ("".equals(dx.c(this.f5086i))) {
            return;
        }
        File file = new File(dx.c(this.f5086i) + "offlinemapv4.png");
        if (!file.exists()) {
            c4 = bv.a(this.f5086i, "offlinemapv4.png");
        } else {
            c4 = bv.c(file);
        }
        if (c4 != null) {
            try {
                h(c4);
            } catch (JSONException e2) {
                if (file.exists()) {
                    file.delete();
                }
                gy.b(e2, "MapDownloadManager", "paseJson io");
                e2.printStackTrace();
            }
        }
    }

    private void i() {
        Iterator<bi> iterator2 = this.f5090n.a().iterator2();
        while (iterator2.hasNext()) {
            bi next = iterator2.next();
            if (next != null && next.c() != null && next.e().length() > 0) {
                int i10 = next.f5143l;
                if (i10 != 4 && i10 != 7 && i10 >= 0) {
                    next.f5143l = 3;
                }
                ax i11 = i(next.c());
                if (i11 != null) {
                    String d10 = next.d();
                    if (d10 != null && b(f5079d, d10)) {
                        i11.a(7);
                    } else {
                        i11.a(next.f5143l);
                        i11.setCompleteCode(next.g());
                    }
                    if (next.d().length() > 0) {
                        i11.setVersion(next.d());
                    }
                    List<String> b4 = this.f5090n.b(next.e());
                    StringBuffer stringBuffer = new StringBuffer();
                    Iterator<String> iterator22 = b4.iterator2();
                    while (iterator22.hasNext()) {
                        stringBuffer.append(iterator22.next());
                        stringBuffer.append(";");
                    }
                    i11.a(stringBuffer.toString());
                    bc bcVar = this.f5083f;
                    if (bcVar != null) {
                        bcVar.a(i11);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() throws AMapException {
        if (!dx.d(this.f5086i)) {
            throw new AMapException(AMapException.ERROR_CONNECTION);
        }
    }

    private static void k() {
        f5080k = null;
        f5078b = true;
    }

    private void l() {
        synchronized (this) {
            this.f5088l = null;
        }
    }

    public final void b() {
        i();
        a aVar = this.f5088l;
        if (aVar != null) {
            try {
                aVar.a();
            } catch (Throwable th) {
                gy.b(th, "OfflineDownloadManager", "verifyCallBack");
            }
        }
    }

    public final void c() throws AMapException {
        if (this.f5083f == null) {
            return;
        }
        bf bfVar = new bf(this.f5086i, "");
        bfVar.a(this.f5086i);
        List<OfflineMapProvince> c4 = bfVar.c();
        if (this.f5081c != null) {
            this.f5083f.a(c4);
        }
        List<ax> list = this.f5081c;
        if (list != null) {
            synchronized (list) {
                Iterator<OfflineMapProvince> iterator2 = this.f5083f.a().iterator2();
                while (iterator2.hasNext()) {
                    Iterator<OfflineMapCity> iterator22 = iterator2.next().getCityList().iterator2();
                    while (iterator22.hasNext()) {
                        OfflineMapCity next = iterator22.next();
                        for (ax axVar : this.f5081c) {
                            if (next.getPinyin().equals(axVar.getPinyin())) {
                                String version = axVar.getVersion();
                                if (axVar.getState() == 4 && f5079d.length() > 0 && b(f5079d, version)) {
                                    axVar.j();
                                    axVar.setUrl(next.getUrl());
                                    axVar.s();
                                } else {
                                    axVar.setCity(next.getCity());
                                    axVar.setUrl(next.getUrl());
                                    axVar.s();
                                    axVar.setAdcode(next.getAdcode());
                                    axVar.setVersion(next.getVersion());
                                    axVar.setSize(next.getSize());
                                    axVar.setCode(next.getCode());
                                    axVar.setJianpin(next.getJianpin());
                                    axVar.setPinyin(next.getPinyin());
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public final void d() {
        synchronized (this.f5081c) {
            for (ax axVar : this.f5081c) {
                if (axVar.c().equals(axVar.f5058c) || axVar.c().equals(axVar.f5057b)) {
                    d(axVar);
                    axVar.g();
                }
            }
        }
    }

    public final void e() {
        synchronized (this.f5081c) {
            Iterator<ax> iterator2 = this.f5081c.iterator2();
            while (true) {
                if (!iterator2.hasNext()) {
                    break;
                }
                ax next = iterator2.next();
                if (next.c().equals(next.f5058c)) {
                    next.g();
                    break;
                }
            }
        }
    }

    public final void f() {
        jd jdVar = this.f5091o;
        if (jdVar != null) {
            jdVar.e();
        }
        jd jdVar2 = this.f5093q;
        if (jdVar2 != null) {
            jdVar2.e();
            this.f5093q = null;
        }
        bb bbVar = this.f5085h;
        if (bbVar != null) {
            if (bbVar.isAlive()) {
                this.f5085h.interrupt();
            }
            this.f5085h = null;
        }
        b bVar = this.f5082e;
        if (bVar != null) {
            bVar.removeCallbacksAndMessages(null);
            this.f5082e = null;
        }
        bh bhVar = this.f5089m;
        if (bhVar != null) {
            bhVar.b();
            this.f5089m = null;
        }
        bc bcVar = this.f5083f;
        if (bcVar != null) {
            bcVar.g();
        }
        k();
        this.f5087j = true;
        l();
    }

    private ax j(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        synchronized (this.f5081c) {
            for (ax axVar : this.f5081c) {
                if (str.equals(axVar.getCode())) {
                    return axVar;
                }
            }
            return null;
        }
    }

    private static void k(String str) {
        f5077a = str;
    }

    public static ay a(Context context) {
        if (f5080k == null) {
            synchronized (ay.class) {
                if (f5080k == null && !f5078b) {
                    f5080k = new ay(context.getApplicationContext());
                }
            }
        }
        return f5080k;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(String str, String str2) {
        for (int i10 = 0; i10 < str2.length(); i10++) {
            try {
                if (str.charAt(i10) > str2.charAt(i10)) {
                    return true;
                }
                if (str.charAt(i10) < str2.charAt(i10)) {
                    return false;
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public final String g(String str) {
        ax i10;
        return (str == null || (i10 = i(str)) == null) ? "" : i10.getAdcode();
    }

    public final void e(String str) throws AMapException {
        ax i10 = i(str);
        if (str != null && str.length() > 0 && i10 != null) {
            f(i10);
            return;
        }
        throw new AMapException("无效的参数 - IllegalArgumentException");
    }

    public final boolean b(String str) {
        return i(str) != null;
    }

    public final void d(String str) {
        ax i10 = i(str);
        if (i10 != null) {
            i10.f();
        }
    }

    public final void b(ax axVar) {
        try {
            bh bhVar = this.f5089m;
            if (bhVar != null) {
                bhVar.a(axVar, this.f5086i);
            }
        } catch (fi e2) {
            e2.printStackTrace();
        }
    }

    private void h(String str) throws JSONException {
        bc bcVar;
        List<OfflineMapProvince> a10 = bv.a(str, this.f5086i.getApplicationContext());
        if (a10 == null || a10.size() == 0 || (bcVar = this.f5083f) == null) {
            return;
        }
        bcVar.a(a10);
    }

    public final void a() {
        this.f5090n = bn.a(this.f5086i.getApplicationContext());
        g();
        this.f5082e = new b(this.f5086i.getMainLooper());
        this.f5083f = new bc(this.f5086i);
        this.f5089m = bh.a();
        k(dx.c(this.f5086i));
        try {
            h();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        synchronized (this.f5081c) {
            Iterator<OfflineMapProvince> iterator2 = this.f5083f.a().iterator2();
            while (iterator2.hasNext()) {
                Iterator<OfflineMapCity> iterator22 = iterator2.next().getCityList().iterator2();
                while (iterator22.hasNext()) {
                    OfflineMapCity next = iterator22.next();
                    if (next != null) {
                        this.f5081c.add(new ax(this.f5086i, next));
                    }
                }
            }
        }
        bb bbVar = new bb(this.f5086i);
        this.f5085h = bbVar;
        bbVar.start();
    }

    public final void d(ax axVar) {
        bh bhVar = this.f5089m;
        if (bhVar != null) {
            bhVar.a(axVar);
        }
    }

    public final void e(ax axVar) {
        bh bhVar = this.f5089m;
        if (bhVar != null) {
            bhVar.b(axVar);
        }
    }

    public final void f(String str) throws AMapException {
        ax j10 = j(str);
        if (j10 != null) {
            f(j10);
            return;
        }
        throw new AMapException("无效的参数 - IllegalArgumentException");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ax i(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        synchronized (this.f5081c) {
            for (ax axVar : this.f5081c) {
                if (str.equals(axVar.getCity()) || str.equals(axVar.getPinyin())) {
                    return axVar;
                }
            }
            return null;
        }
    }

    private void f(final ax axVar) throws AMapException {
        j();
        if (axVar != null) {
            if (this.f5093q == null) {
                this.f5093q = dw.a("AMapOfflineDownload");
            }
            try {
                this.f5093q.a(new je() { // from class: com.amap.api.col.3l.ay.3
                    @Override // com.amap.api.col.p0003l.je
                    public final void runTask() {
                        try {
                            if (ay.this.f5087j) {
                                ay.this.j();
                                az c4 = new ba(ay.this.f5086i, ay.f5079d).c();
                                if (c4 != null) {
                                    ay.f(ay.this);
                                    if (c4.a()) {
                                        ay.this.c();
                                    }
                                }
                            }
                            axVar.setVersion(ay.f5079d);
                            axVar.f();
                        } catch (AMapException e2) {
                            e2.printStackTrace();
                        } catch (Throwable th) {
                            gy.b(th, "OfflineDownloadManager", "startDownloadRunnable");
                        }
                    }
                });
                return;
            } catch (Throwable th) {
                gy.b(th, "startDownload", "downloadExcecRunnable");
                return;
            }
        }
        throw new AMapException("无效的参数 - IllegalArgumentException");
    }

    public final void a(final String str) {
        try {
            if (str == null) {
                a aVar = this.f5088l;
                if (aVar != null) {
                    aVar.b(null);
                    return;
                }
                return;
            }
            if (this.f5091o == null) {
                this.f5091o = dw.a("AMapOfflineCheckUpdate");
            }
            this.f5091o.a(new je() { // from class: com.amap.api.col.3l.ay.1
                @Override // com.amap.api.col.p0003l.je
                public final void runTask() {
                    ax i10 = ay.this.i(str);
                    if (i10 != null) {
                        try {
                            if (!i10.c().equals(i10.f5058c) && !i10.c().equals(i10.f5060e)) {
                                String pinyin = i10.getPinyin();
                                if (pinyin.length() > 0) {
                                    String d10 = ay.this.f5090n.d(pinyin);
                                    if (d10 == null) {
                                        d10 = i10.getVersion();
                                    }
                                    if (ay.f5079d.length() > 0 && d10 != null && ay.b(ay.f5079d, d10)) {
                                        i10.j();
                                    }
                                }
                            }
                            if (ay.this.f5088l != null) {
                                synchronized (ay.this) {
                                    try {
                                        ay.this.f5088l.b(i10);
                                    } finally {
                                        return;
                                    }
                                }
                                return;
                            }
                            return;
                        } catch (Exception unused) {
                            if (ay.this.f5088l != null) {
                                synchronized (ay.this) {
                                    try {
                                        ay.this.f5088l.b(i10);
                                    } finally {
                                        return;
                                    }
                                    return;
                                }
                            }
                            return;
                        } catch (Throwable th) {
                            if (ay.this.f5088l != null) {
                                synchronized (ay.this) {
                                    try {
                                        ay.this.f5088l.b(i10);
                                    } finally {
                                        throw th;
                                    }
                                }
                            }
                            throw th;
                        }
                    }
                    ay.this.j();
                    az c4 = new ba(ay.this.f5086i, ay.f5079d).c();
                    if (ay.this.f5088l != null) {
                        if (c4 == null) {
                            if (ay.this.f5088l != null) {
                                synchronized (ay.this) {
                                    try {
                                        ay.this.f5088l.b(i10);
                                    } finally {
                                        return;
                                    }
                                }
                                return;
                            }
                            return;
                        }
                        if (c4.a()) {
                            ay.this.c();
                        }
                    }
                    if (ay.this.f5088l != null) {
                        synchronized (ay.this) {
                            try {
                                ay.this.f5088l.b(i10);
                            } finally {
                            }
                        }
                    }
                }
            });
        } catch (Throwable th) {
            gy.b(th, "OfflineDownloadManager", "checkUpdate");
        }
    }

    public final void c(String str) {
        ax i10 = i(str);
        if (i10 == null) {
            a aVar = this.f5088l;
            if (aVar != null) {
                try {
                    aVar.c(i10);
                    return;
                } catch (Throwable th) {
                    gy.b(th, "OfflineDownloadManager", "remove");
                    return;
                }
            }
            return;
        }
        d(i10);
        a(i10, true);
    }

    public final void a(ax axVar) {
        a(axVar, false);
    }

    public final void c(ax axVar) {
        bc bcVar = this.f5083f;
        if (bcVar != null) {
            bcVar.a(axVar);
        }
        b bVar = this.f5082e;
        if (bVar != null) {
            Message obtainMessage = bVar.obtainMessage();
            obtainMessage.obj = axVar;
            this.f5082e.sendMessage(obtainMessage);
        }
    }

    private void a(final ax axVar, final boolean z10) {
        if (this.f5084g == null) {
            this.f5084g = new be(this.f5086i);
        }
        if (this.f5092p == null) {
            this.f5092p = dw.a("AMapOfflineRemove");
        }
        try {
            this.f5092p.a(new je() { // from class: com.amap.api.col.3l.ay.2
                @Override // com.amap.api.col.p0003l.je
                public final void runTask() {
                    try {
                        if (axVar.c().equals(axVar.f5056a)) {
                            if (ay.this.f5088l != null) {
                                ay.this.f5088l.c(axVar);
                                return;
                            }
                            return;
                        }
                        if (axVar.getState() != 7 && axVar.getState() != -1) {
                            ay.this.f5084g.a(axVar);
                            if (ay.this.f5088l != null) {
                                ay.this.f5088l.c(axVar);
                                return;
                            }
                            return;
                        }
                        ay.this.f5084g.a(axVar);
                        if (!z10 || ay.this.f5088l == null) {
                            return;
                        }
                        ay.this.f5088l.c(axVar);
                    } catch (Throwable th) {
                        gy.b(th, "requestDelete", "removeExcecRunnable");
                    }
                }
            });
        } catch (Throwable th) {
            gy.b(th, "requestDelete", "removeExcecRunnable");
        }
    }

    public final void a(a aVar) {
        this.f5088l = aVar;
    }
}
