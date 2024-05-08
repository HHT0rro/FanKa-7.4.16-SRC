package kotlin;

import java.io.Serializable;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Lazy.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class UnsafeLazyImpl<T> implements Lazy<T>, Serializable {

    @Nullable
    private Object _value;

    @Nullable
    private Function0<? extends T> initializer;

    public UnsafeLazyImpl(@NotNull Function0<? extends T> initializer) {
        s.i(initializer, "initializer");
        this.initializer = initializer;
        this._value = m.f51043a;
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(getValue());
    }

    @Override // kotlin.Lazy
    public T getValue() {
        if (this._value == m.f51043a) {
            Function0<? extends T> function0 = this.initializer;
            s.f(function0);
            this._value = function0.invoke();
            this.initializer = null;
        }
        return (T) this._value;
    }

    public boolean isInitialized() {
        return this._value != m.f51043a;
    }

    @NotNull
    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
