package k8;

import androidx.annotation.RecentlyNonNull;
import com.google.mlkit.common.model.RemoteModel;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.mlkit:common@@17.1.1 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public final Map<Class<? extends RemoteModel>, e8.a<Object>> f50735a = new HashMap();

    /* compiled from: com.google.mlkit:common@@17.1.1 */
    /* renamed from: k8.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class C0771a {

        /* renamed from: a, reason: collision with root package name */
        public final Class<? extends RemoteModel> f50736a;

        /* renamed from: b, reason: collision with root package name */
        public final e8.a<Object> f50737b;

        /* JADX WARN: Multi-variable type inference failed */
        public <RemoteT extends RemoteModel> C0771a(@RecentlyNonNull Class<RemoteT> cls, @RecentlyNonNull e8.a<Object> aVar) {
            this.f50736a = cls;
            this.f50737b = aVar;
        }

        public final Class<? extends RemoteModel> a() {
            return this.f50736a;
        }

        public final e8.a<Object> b() {
            return this.f50737b;
        }
    }

    public a(@RecentlyNonNull Set<C0771a> set) {
        for (C0771a c0771a : set) {
            this.f50735a.put(c0771a.a(), c0771a.b());
        }
    }
}
