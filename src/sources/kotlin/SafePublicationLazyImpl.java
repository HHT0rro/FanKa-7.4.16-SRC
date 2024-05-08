package kotlin;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LazyJVM.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
final class SafePublicationLazyImpl<T> implements Lazy<T>, Serializable {

    @NotNull
    public static final a Companion = new a(null);
    private static final AtomicReferenceFieldUpdater<SafePublicationLazyImpl<?>, Object> valueUpdater = AtomicReferenceFieldUpdater.newUpdater(SafePublicationLazyImpl.class, Object.class, "_value");

    @Nullable
    private volatile Object _value;

    /* renamed from: final, reason: not valid java name */
    @NotNull
    private final Object f620final;

    @Nullable
    private volatile Function0<? extends T> initializer;

    /* compiled from: LazyJVM.kt */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public SafePublicationLazyImpl(@NotNull Function0<? extends T> initializer) {
        s.i(initializer, "initializer");
        this.initializer = initializer;
        m mVar = m.f51043a;
        this._value = mVar;
        this.f620final = mVar;
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(getValue());
    }

    @Override // kotlin.Lazy
    public T getValue() {
        T t2 = (T) this._value;
        m mVar = m.f51043a;
        if (t2 != mVar) {
            return t2;
        }
        Function0<? extends T> function0 = this.initializer;
        if (function0 != null) {
            T invoke = function0.invoke();
            if (androidx.concurrent.futures.a.a(valueUpdater, this, mVar, invoke)) {
                this.initializer = null;
                return invoke;
            }
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
