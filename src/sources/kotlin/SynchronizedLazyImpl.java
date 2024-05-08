package kotlin;

import java.io.Serializable;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LazyJVM.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class SynchronizedLazyImpl<T> implements Lazy<T>, Serializable {

    @Nullable
    private volatile Object _value;

    @Nullable
    private Function0<? extends T> initializer;

    @NotNull
    private final Object lock;

    public SynchronizedLazyImpl(@NotNull Function0<? extends T> initializer, @Nullable Object obj) {
        s.i(initializer, "initializer");
        this.initializer = initializer;
        this._value = m.f51043a;
        this.lock = obj == null ? this : obj;
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(getValue());
    }

    @Override // kotlin.Lazy
    public T getValue() {
        T t2;
        T t10 = (T) this._value;
        m mVar = m.f51043a;
        if (t10 != mVar) {
            return t10;
        }
        synchronized (this.lock) {
            t2 = (T) this._value;
            if (t2 == mVar) {
                Function0<? extends T> function0 = this.initializer;
                s.f(function0);
                t2 = function0.invoke();
                this._value = t2;
                this.initializer = null;
            }
        }
        return t2;
    }

    public boolean isInitialized() {
        return this._value != m.f51043a;
    }

    @NotNull
    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }

    public /* synthetic */ SynchronizedLazyImpl(Function0 function0, Object obj, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(function0, (i10 & 2) != 0 ? null : obj);
    }
}
