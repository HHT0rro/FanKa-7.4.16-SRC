package z0;

import com.google.android.material.badge.BadgeDrawable;
import org.jetbrains.annotations.NotNull;

/* compiled from: MathExtension.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class q {
    @NotNull
    public static final String a(int i10) {
        String[] strArr = {"一", "二", "三", "四", "五", "六", "七", "八", "九", "十"};
        int i11 = i10 / 10;
        boolean z10 = false;
        if (!(1 <= i11 && i11 < 10)) {
            if (1 <= i10 && i10 < 10) {
                z10 = true;
            }
            return z10 ? strArr[i10 - 1] : "";
        }
        return (i11 > 1 ? a(i11) : "") + kotlin.collections.m.G(strArr) + a(i10 % 10);
    }

    @NotNull
    public static final String b(int i10) {
        if (i10 >= 100) {
            return (i10 - (i10 % 100)) + BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX;
        }
        return String.valueOf(i10 - (i10 % 10));
    }

    public static final float c(float f10) {
        return Math.round(f10 * 100) / 100.0f;
    }
}
