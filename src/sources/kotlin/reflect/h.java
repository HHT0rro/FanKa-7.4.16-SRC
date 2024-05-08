package kotlin.reflect;

import kotlin.jvm.functions.Function2;
import kotlin.p;
import org.jetbrains.annotations.NotNull;

/* compiled from: KProperty.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface h<T, V> extends l<T, V>, j {

    /* compiled from: KProperty.kt */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface a<T, V> extends f<V>, Function2<T, V, p> {
    }

    @NotNull
    a<T, V> getSetter();
}
