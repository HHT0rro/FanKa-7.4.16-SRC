package kotlin.jvm.internal;

import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* compiled from: TypeReference.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
final class TypeReference$asString$args$1 extends Lambda implements Function1<kotlin.reflect.o, CharSequence> {
    public final /* synthetic */ a0 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TypeReference$asString$args$1(a0 a0Var) {
        super(1);
        this.this$0 = a0Var;
    }

    @Override // kotlin.jvm.functions.Function1
    @NotNull
    public final CharSequence invoke(@NotNull kotlin.reflect.o it) {
        String b4;
        s.i(it, "it");
        b4 = this.this$0.b(it);
        return b4;
    }
}
