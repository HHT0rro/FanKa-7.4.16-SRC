package kotlin.jvm.internal;

import kotlin.KotlinNothingValueException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: localVariableReferences.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class MutableLocalVariableReference extends MutablePropertyReference0 {
    @Override // kotlin.jvm.internal.MutablePropertyReference0
    @Nullable
    public Object get() {
        t.b();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.jvm.internal.CallableReference
    @NotNull
    public kotlin.reflect.d getOwner() {
        t.b();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0
    public void set(@Nullable Object obj) {
        t.b();
        throw new KotlinNothingValueException();
    }
}
