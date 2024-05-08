package kotlin.reflect;

import kotlin.jvm.functions.Function2;
import kotlin.reflect.j;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: KProperty.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface m<D, E, V> extends j<V>, Function2<D, E, V> {

    /* compiled from: KProperty.kt */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface a<D, E, V> extends j.a<V>, Function2<D, E, V> {
    }

    @Nullable
    Object getDelegate(D d10, E e2);

    @NotNull
    a<D, E, V> getGetter();
}
