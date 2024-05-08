package kotlin.collections.unsigned;

import java.util.Iterator;
import kotlin.g;
import kotlin.h;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: _UArrays.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
final class UArraysKt___UArraysKt$withIndex$3 extends Lambda implements Function0<Iterator<? extends g>> {
    public final /* synthetic */ byte[] $this_withIndex;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UArraysKt___UArraysKt$withIndex$3(byte[] bArr) {
        super(0);
        this.$this_withIndex = bArr;
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final Iterator<? extends g> invoke() {
        return h.b(this.$this_withIndex);
    }
}
