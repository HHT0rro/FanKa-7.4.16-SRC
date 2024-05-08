package s4;

import com.google.android.datatransport.runtime.TransportContext;
import java.util.Iterator;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/* compiled from: WorkInitializer.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f53614a;

    /* renamed from: b, reason: collision with root package name */
    public final com.google.android.datatransport.runtime.scheduling.persistence.b f53615b;

    /* renamed from: c, reason: collision with root package name */
    public final o f53616c;

    /* renamed from: d, reason: collision with root package name */
    public final t4.a f53617d;

    @Inject
    public m(Executor executor, com.google.android.datatransport.runtime.scheduling.persistence.b bVar, o oVar, t4.a aVar) {
        this.f53614a = executor;
        this.f53615b = bVar;
        this.f53616c = oVar;
        this.f53617d = aVar;
    }

    public static /* synthetic */ Object b(m mVar) {
        Iterator<TransportContext> iterator2 = mVar.f53615b.o().iterator2();
        while (iterator2.hasNext()) {
            mVar.f53616c.a(iterator2.next(), 1);
        }
        return null;
    }

    public void a() {
        this.f53614a.execute(k.a(this));
    }
}
