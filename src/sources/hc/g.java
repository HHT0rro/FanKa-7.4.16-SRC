package hc;

import com.xiaomi.push.n;
import java.util.concurrent.ExecutorService;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class g extends n.a {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f49573b;

    public g(b bVar) {
        this.f49573b = bVar;
    }

    @Override // com.xiaomi.push.n.a
    public int a() {
        return 100889;
    }

    @Override // java.lang.Runnable
    public void run() {
        int q10;
        ExecutorService executorService;
        q10 = this.f49573b.q();
        if (q10 > 0) {
            executorService = this.f49573b.f49559a;
            executorService.execute(new h(this));
        }
    }
}
