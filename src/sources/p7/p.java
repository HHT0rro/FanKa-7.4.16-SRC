package p7;

import androidx.annotation.NonNull;
import java.util.ArrayDeque;
import java.util.Queue;

/* compiled from: com.google.android.gms:play-services-tasks@@17.2.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class p<TResult> {

    /* renamed from: a, reason: collision with root package name */
    public final Object f52927a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public Queue<q<TResult>> f52928b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f52929c;

    public final void a(@NonNull f<TResult> fVar) {
        q<TResult> poll;
        synchronized (this.f52927a) {
            if (this.f52928b != null && !this.f52929c) {
                this.f52929c = true;
                while (true) {
                    synchronized (this.f52927a) {
                        poll = this.f52928b.poll();
                        if (poll == null) {
                            this.f52929c = false;
                            return;
                        }
                    }
                    poll.a(fVar);
                }
            }
        }
    }

    public final void b(@NonNull q<TResult> qVar) {
        synchronized (this.f52927a) {
            if (this.f52928b == null) {
                this.f52928b = new ArrayDeque();
            }
            this.f52928b.add(qVar);
        }
    }
}
