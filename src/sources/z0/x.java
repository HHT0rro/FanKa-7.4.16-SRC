package z0;

import com.huawei.appgallery.agd.common.constant.SymbolValues;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: UriExtension.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class x {
    @NotNull
    public static final String a(@NotNull String str, @NotNull String key, @NotNull String value) {
        kotlin.jvm.internal.s.i(str, "<this>");
        kotlin.jvm.internal.s.i(key, "key");
        kotlin.jvm.internal.s.i(value, "value");
        String str2 = SymbolValues.QUESTION_EN_SYMBOL;
        if (StringsKt__StringsKt.K(str, SymbolValues.QUESTION_EN_SYMBOL, false, 2, null)) {
            str2 = "&";
        }
        return str + str2 + key + "=" + value;
    }
}
