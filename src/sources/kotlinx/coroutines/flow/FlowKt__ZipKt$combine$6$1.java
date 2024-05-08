package kotlinx.coroutines.flow;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* compiled from: Zip.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class FlowKt__ZipKt$combine$6$1 extends Lambda implements Function0<Object[]> {
    public final /* synthetic */ c<Object>[] $flowArray;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__ZipKt$combine$6$1(c<Object>[] cVarArr) {
        super(0);
        this.$flowArray = cVarArr;
    }

    @Override // kotlin.jvm.functions.Function0
    @Nullable
    public final Object[] invoke() {
        int length = this.$flowArray.length;
        kotlin.jvm.internal.s.o(0, "T?");
        return new Object[length];
    }
}
