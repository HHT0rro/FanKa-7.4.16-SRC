package kotlin.collections;

import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: AbstractMap.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
final class AbstractMap$toString$1 extends Lambda implements Function1<Map.Entry<Object, Object>, CharSequence> {
    public final /* synthetic */ c<Object, Object> this$0;

    public AbstractMap$toString$1(c<Object, Object> cVar) {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    @NotNull
    public final CharSequence invoke(@NotNull Map.Entry<Object, Object> it) {
        kotlin.jvm.internal.s.i(it, "it");
        return c.a(null, it);
    }
}
