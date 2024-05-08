package kotlin.reflect;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.j;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: KProperty.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface l<T, V> extends j<V>, Function1<T, V> {

    /* compiled from: KProperty.kt */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface a<T, V> extends j.a<V>, Function1<T, V> {
    }

    @Nullable
    Object getDelegate(T t2);

    @NotNull
    a<T, V> getGetter();
}
