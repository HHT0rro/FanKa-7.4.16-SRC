package kotlin.reflect;

import kotlin.jvm.functions.Function1;
import kotlin.p;
import org.jetbrains.annotations.NotNull;

/* compiled from: KProperty.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface g<V> extends k<V>, j {

    /* compiled from: KProperty.kt */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface a<V> extends f<V>, Function1<V, p> {
    }

    @NotNull
    a<V> getSetter();
}
