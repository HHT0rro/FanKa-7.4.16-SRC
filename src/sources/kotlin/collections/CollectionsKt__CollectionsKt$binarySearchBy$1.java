package kotlin.collections;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Collections.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class CollectionsKt__CollectionsKt$binarySearchBy$1 extends Lambda implements Function1<Object, Integer> {
    public final /* synthetic */ Comparable<Object> $key;
    public final /* synthetic */ Function1<Object, Comparable<Object>> $selector;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CollectionsKt__CollectionsKt$binarySearchBy$1(Function1<Object, Comparable<Object>> function1, Comparable<Object> comparable) {
        super(1);
        this.$selector = function1;
        this.$key = comparable;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function1
    @NotNull
    public final Integer invoke(Object obj) {
        return Integer.valueOf(qd.a.a(this.$selector.invoke(obj), this.$key));
    }
}
