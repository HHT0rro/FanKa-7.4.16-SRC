package kotlin.sequences;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: _SequencesJvm.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
final class SequencesKt___SequencesJvmKt$filterIsInstance$1 extends Lambda implements Function1<Object, Boolean> {
    public final /* synthetic */ Class<Object> $klass;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SequencesKt___SequencesJvmKt$filterIsInstance$1(Class<Object> cls) {
        super(1);
        this.$klass = cls;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function1
    @NotNull
    public final Boolean invoke(@Nullable Object obj) {
        return Boolean.valueOf(this.$klass.isInstance(obj));
    }
}
