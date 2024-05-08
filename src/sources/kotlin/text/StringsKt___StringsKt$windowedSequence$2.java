package kotlin.text;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* compiled from: _Strings.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
final class StringsKt___StringsKt$windowedSequence$2 extends Lambda implements Function1<Integer, Object> {
    public final /* synthetic */ int $size;
    public final /* synthetic */ CharSequence $this_windowedSequence;
    public final /* synthetic */ Function1<CharSequence, Object> $transform;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public StringsKt___StringsKt$windowedSequence$2(int i10, CharSequence charSequence, Function1<? super CharSequence, Object> function1) {
        super(1);
        this.$size = i10;
        this.$this_windowedSequence = charSequence;
        this.$transform = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Integer num) {
        return invoke(num.intValue());
    }

    public final Object invoke(int i10) {
        int i11 = this.$size + i10;
        if (i11 < 0 || i11 > this.$this_windowedSequence.length()) {
            i11 = this.$this_windowedSequence.length();
        }
        return this.$transform.invoke(this.$this_windowedSequence.subSequence(i10, i11));
    }
}
