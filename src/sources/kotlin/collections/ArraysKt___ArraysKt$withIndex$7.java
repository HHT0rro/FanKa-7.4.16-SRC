package kotlin.collections;

import java.util.Iterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: _Arrays.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
final class ArraysKt___ArraysKt$withIndex$7 extends Lambda implements Function0<Iterator<? extends Double>> {
    public final /* synthetic */ double[] $this_withIndex;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArraysKt___ArraysKt$withIndex$7(double[] dArr) {
        super(0);
        this.$this_withIndex = dArr;
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final Iterator<? extends Double> invoke() {
        return kotlin.jvm.internal.i.d(this.$this_withIndex);
    }
}
