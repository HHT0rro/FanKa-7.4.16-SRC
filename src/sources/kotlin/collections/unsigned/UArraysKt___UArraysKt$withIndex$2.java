package kotlin.collections.unsigned;

import java.util.Iterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.k;
import kotlin.l;
import org.jetbrains.annotations.NotNull;

/* compiled from: _UArrays.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
final class UArraysKt___UArraysKt$withIndex$2 extends Lambda implements Function0<Iterator<? extends k>> {
    public final /* synthetic */ long[] $this_withIndex;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UArraysKt___UArraysKt$withIndex$2(long[] jArr) {
        super(0);
        this.$this_withIndex = jArr;
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final Iterator<? extends k> invoke() {
        return l.b(this.$this_withIndex);
    }
}
