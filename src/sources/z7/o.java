package z7;

import androidx.annotation.GuardedBy;
import com.google.firebase.events.Event;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class o implements d8.c, d8.b {

    /* renamed from: a, reason: collision with root package name */
    @GuardedBy("this")
    public final Map<Class<?>, ConcurrentHashMap<d8.a<Object>, Executor>> f55012a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    @GuardedBy("this")
    public Queue<Event<?>> f55013b = new ArrayDeque();

    /* renamed from: c, reason: collision with root package name */
    public final Executor f55014c;

    public o(Executor executor) {
        this.f55014c = executor;
    }

    public void a() {
        Queue<Event<?>> queue;
        synchronized (this) {
            queue = this.f55013b;
            if (queue != null) {
                this.f55013b = null;
            } else {
                queue = null;
            }
        }
        if (queue != null) {
            Iterator<Event<?>> it = queue.iterator2();
            while (it.hasNext()) {
                d(it.next());
            }
        }
    }

    public final synchronized Set<Map.Entry<d8.a<Object>, Executor>> b(Event<?> event) {
        ConcurrentHashMap<d8.a<Object>, Executor> concurrentHashMap;
        concurrentHashMap = this.f55012a.get(event.getType());
        return concurrentHashMap == null ? Collections.emptySet() : concurrentHashMap.entrySet();
    }

    public void d(Event<?> event) {
        q.b(event);
        synchronized (this) {
            Queue<Event<?>> queue = this.f55013b;
            if (queue != null) {
                queue.add(event);
                return;
            }
            for (Map.Entry<d8.a<Object>, Executor> entry : b(event)) {
                entry.getValue().execute(n.a(entry, event));
            }
        }
    }
}
