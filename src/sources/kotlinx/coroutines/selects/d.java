package kotlinx.coroutines.selects;

import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;

/* compiled from: Select.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface d<Q> {
    <R> void a(@NotNull f<? super R> fVar, @NotNull Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function2);
}
