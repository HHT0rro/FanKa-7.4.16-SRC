package z0;

import android.content.Context;
import com.cupidapp.live.R$string;
import java.text.DecimalFormat;
import org.jetbrains.annotations.NotNull;

/* compiled from: FormatCountExtension.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class m {
    @NotNull
    public static final String a(int i10) {
        String format = new DecimalFormat("#,###").format(Integer.valueOf(i10));
        kotlin.jvm.internal.s.h(format, "df.format(this)");
        return format;
    }

    @NotNull
    public static final String b(double d10) {
        try {
            String format = new DecimalFormat("#0.####").format(d10);
            kotlin.jvm.internal.s.h(format, "{\n        decimalFormat.format(this)\n    }");
            return format;
        } catch (Exception unused) {
            return "";
        }
    }

    @NotNull
    public static final String c(int i10) {
        return i10 > 999 ? "999+" : String.valueOf(i10);
    }

    @NotNull
    public static final String d(int i10) {
        return i10 > 99 ? "99+" : String.valueOf(i10);
    }

    @NotNull
    public static final String e(int i10, @NotNull Context context) {
        kotlin.jvm.internal.s.i(context, "context");
        if (i10 < 0) {
            return "";
        }
        if (i10 < 10000) {
            return String.valueOf(i10);
        }
        return ((i10 / 1000) / 10.0f) + context.getString(R$string.ten_thousand);
    }
}
