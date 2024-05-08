package kotlin.reflect;

import kotlin.jvm.functions.Function3;
import kotlin.p;
import org.jetbrains.annotations.NotNull;

/* compiled from: KProperty.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface i<D, E, V> extends m<D, E, V>, j {

    /* compiled from: KProperty.kt */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface a<D, E, V> extends f<V>, Function3<D, E, V, p> {
    }

    @NotNull
    a<D, E, V> getSetter();
}
