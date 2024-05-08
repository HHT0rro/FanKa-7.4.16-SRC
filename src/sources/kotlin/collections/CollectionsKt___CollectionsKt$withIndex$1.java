package kotlin.collections;

import java.util.Iterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: _Collections.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
final class CollectionsKt___CollectionsKt$withIndex$1 extends Lambda implements Function0<Iterator<Object>> {
    public final /* synthetic */ Iterable<Object> $this_withIndex;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CollectionsKt___CollectionsKt$withIndex$1(Iterable<Object> iterable) {
        super(0);
        this.$this_withIndex = iterable;
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final Iterator<Object> invoke() {
        return this.$this_withIndex.iterator2();
    }
}
