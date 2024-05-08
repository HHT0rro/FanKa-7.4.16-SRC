package kotlin.text;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Regex.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class RegexKt$fromInt$1$1 extends Lambda implements Function1<Enum<Object>, Boolean> {
    public final /* synthetic */ int $value;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RegexKt$fromInt$1$1(int i10) {
        super(1);
        this.$value = i10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function1
    @NotNull
    public final Boolean invoke(Enum<Object> r32) {
        e eVar = (e) r32;
        return Boolean.valueOf((this.$value & eVar.getMask()) == eVar.getValue());
    }
}
