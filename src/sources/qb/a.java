package qb;

import android.graphics.BitmapFactory;
import kotlin.Pair;
import kotlin.f;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: BitmapSampleSizeCalculator.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f53191a = new a();

    public final int a(@NotNull BitmapFactory.Options options, int i10, int i11) {
        s.j(options, "options");
        Pair a10 = f.a(Integer.valueOf(options.outHeight), Integer.valueOf(options.outWidth));
        int intValue = ((Number) a10.component1()).intValue();
        int intValue2 = ((Number) a10.component2()).intValue();
        int i12 = 1;
        if (i11 > 0 && i10 > 0 && (intValue > i11 || intValue2 > i10)) {
            int i13 = intValue / 2;
            int i14 = intValue2 / 2;
            while (i13 / i12 >= i11 && i14 / i12 >= i10) {
                i12 *= 2;
            }
        }
        return i12;
    }
}
