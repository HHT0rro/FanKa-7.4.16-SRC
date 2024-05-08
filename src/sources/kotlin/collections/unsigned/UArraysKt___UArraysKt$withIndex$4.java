package kotlin.collections.unsigned;

import java.util.Iterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.n;
import kotlin.o;
import org.jetbrains.annotations.NotNull;

/* compiled from: _UArrays.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
final class UArraysKt___UArraysKt$withIndex$4 extends Lambda implements Function0<Iterator<? extends n>> {
    public final /* synthetic */ short[] $this_withIndex;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UArraysKt___UArraysKt$withIndex$4(short[] sArr) {
        super(0);
        this.$this_withIndex = sArr;
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final Iterator<? extends n> invoke() {
        return o.b(this.$this_withIndex);
    }
}
