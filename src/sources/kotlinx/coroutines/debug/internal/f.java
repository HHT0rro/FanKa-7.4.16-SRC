package kotlinx.coroutines.debug.internal;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import org.jetbrains.annotations.Nullable;

/* compiled from: ConcurrentWeakMap.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class f<T> extends WeakReference<T> {

    /* renamed from: a, reason: collision with root package name */
    public final int f51228a;

    public f(T t2, @Nullable ReferenceQueue<T> referenceQueue) {
        super(t2, referenceQueue);
        this.f51228a = t2 != null ? t2.hashCode() : 0;
    }
}
