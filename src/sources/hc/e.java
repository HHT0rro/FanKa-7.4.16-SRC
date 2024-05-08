package hc;

import com.xiaomi.push.n;
import java.util.concurrent.ExecutorService;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class e extends n.a {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f49571b;

    public e(b bVar) {
        this.f49571b = bVar;
    }

    @Override // com.xiaomi.push.n.a
    public int a() {
        return 100888;
    }

    @Override // java.lang.Runnable
    public void run() {
        int a10;
        ExecutorService executorService;
        a10 = this.f49571b.a();
        if (a10 > 0) {
            executorService = this.f49571b.f49559a;
            executorService.execute(new f(this));
        }
    }
}
