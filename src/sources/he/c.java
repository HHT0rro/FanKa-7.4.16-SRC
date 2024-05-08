package he;

import android.os.Looper;
import he.e;
import he.f;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: EventBusBuilder.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class c {

    /* renamed from: m, reason: collision with root package name */
    public static final ExecutorService f49608m = Executors.newCachedThreadPool();

    /* renamed from: e, reason: collision with root package name */
    public boolean f49613e;

    /* renamed from: g, reason: collision with root package name */
    public boolean f49615g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f49616h;

    /* renamed from: j, reason: collision with root package name */
    public List<ie.b> f49618j;

    /* renamed from: k, reason: collision with root package name */
    public e f49619k;

    /* renamed from: l, reason: collision with root package name */
    public f f49620l;

    /* renamed from: a, reason: collision with root package name */
    public boolean f49609a = true;

    /* renamed from: b, reason: collision with root package name */
    public boolean f49610b = true;

    /* renamed from: c, reason: collision with root package name */
    public boolean f49611c = true;

    /* renamed from: d, reason: collision with root package name */
    public boolean f49612d = true;

    /* renamed from: f, reason: collision with root package name */
    public boolean f49614f = true;

    /* renamed from: i, reason: collision with root package name */
    public ExecutorService f49617i = f49608m;

    public Object a() {
        try {
            return Looper.getMainLooper();
        } catch (RuntimeException unused) {
            return null;
        }
    }

    public e b() {
        e eVar = this.f49619k;
        return eVar != null ? eVar : (!e.a.c() || a() == null) ? new e.b() : new e.a("EventBus");
    }

    public f c() {
        Object a10;
        f fVar = this.f49620l;
        if (fVar != null) {
            return fVar;
        }
        if (!e.a.c() || (a10 = a()) == null) {
            return null;
        }
        return new f.a((Looper) a10);
    }
}
