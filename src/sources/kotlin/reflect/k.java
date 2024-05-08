package kotlin.reflect;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.j;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: KProperty.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface k<V> extends j<V>, Function0<V> {

    /* compiled from: KProperty.kt */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface a<V> extends j.a<V>, Function0<V> {
    }

    @Nullable
    Object getDelegate();

    @NotNull
    a<V> getGetter();
}
