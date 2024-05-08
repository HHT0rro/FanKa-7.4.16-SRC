package kotlin.collections;

import java.util.Iterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: _Arrays.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
final class ArraysKt___ArraysKt$withIndex$1 extends Lambda implements Function0<Iterator<Object>> {
    public final /* synthetic */ Object[] $this_withIndex;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArraysKt___ArraysKt$withIndex$1(Object[] objArr) {
        super(0);
        this.$this_withIndex = objArr;
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final Iterator<Object> invoke() {
        return kotlin.jvm.internal.h.a(this.$this_withIndex);
    }
}
