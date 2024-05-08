package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Atomic.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class d<T> extends y {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f51377a = AtomicReferenceFieldUpdater.newUpdater(d.class, Object.class, "_consensus");

    @NotNull
    private volatile /* synthetic */ Object _consensus = c.f51373a;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.internal.y
    @NotNull
    public d<?> a() {
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.internal.y
    @Nullable
    public final Object c(@Nullable Object obj) {
        Object obj2 = this._consensus;
        if (obj2 == c.f51373a) {
            obj2 = e(i(obj));
        }
        d(obj, obj2);
        return obj2;
    }

    public abstract void d(T t2, @Nullable Object obj);

    @Nullable
    public final Object e(@Nullable Object obj) {
        Object obj2 = this._consensus;
        Object obj3 = c.f51373a;
        return obj2 != obj3 ? obj2 : androidx.concurrent.futures.a.a(f51377a, this, obj3, obj) ? obj : this._consensus;
    }

    @Nullable
    public final Object f() {
        return this._consensus;
    }

    public long g() {
        return 0L;
    }

    public final boolean h() {
        return this._consensus != c.f51373a;
    }

    @Nullable
    public abstract Object i(T t2);
}
