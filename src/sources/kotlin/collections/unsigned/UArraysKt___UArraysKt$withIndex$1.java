package kotlin.collections.unsigned;

import java.util.Iterator;
import kotlin.i;
import kotlin.j;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: _UArrays.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
final class UArraysKt___UArraysKt$withIndex$1 extends Lambda implements Function0<Iterator<? extends i>> {
    public final /* synthetic */ int[] $this_withIndex;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UArraysKt___UArraysKt$withIndex$1(int[] iArr) {
        super(0);
        this.$this_withIndex = iArr;
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final Iterator<? extends i> invoke() {
        return j.b(this.$this_withIndex);
    }
}
