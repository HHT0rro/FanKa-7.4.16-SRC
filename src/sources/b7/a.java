package b7;

import androidx.annotation.RecentlyNonNull;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class a {
    @RecentlyNonNull
    public static <T> boolean a(@RecentlyNonNull T[] tArr, @RecentlyNonNull T t2) {
        int length = tArr != null ? tArr.length : 0;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                i10 = -1;
                break;
            }
            if (com.google.android.gms.common.internal.g.a(tArr[i10], t2)) {
                break;
            }
            i10++;
        }
        return i10 >= 0;
    }

    public static void b(@RecentlyNonNull StringBuilder sb2, @RecentlyNonNull double[] dArr) {
        int length = dArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (i10 != 0) {
                sb2.append(",");
            }
            sb2.append(Double.toString(dArr[i10]));
        }
    }

    public static void c(@RecentlyNonNull StringBuilder sb2, @RecentlyNonNull float[] fArr) {
        int length = fArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (i10 != 0) {
                sb2.append(",");
            }
            sb2.append(Float.toString(fArr[i10]));
        }
    }

    public static void d(@RecentlyNonNull StringBuilder sb2, @RecentlyNonNull int[] iArr) {
        int length = iArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (i10 != 0) {
                sb2.append(",");
            }
            sb2.append(Integer.toString(iArr[i10]));
        }
    }

    public static void e(@RecentlyNonNull StringBuilder sb2, @RecentlyNonNull long[] jArr) {
        int length = jArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (i10 != 0) {
                sb2.append(",");
            }
            sb2.append(Long.toString(jArr[i10]));
        }
    }

    public static <T> void f(@RecentlyNonNull StringBuilder sb2, @RecentlyNonNull T[] tArr) {
        int length = tArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (i10 != 0) {
                sb2.append(",");
            }
            sb2.append((Object) tArr[i10]);
        }
    }

    public static void g(@RecentlyNonNull StringBuilder sb2, @RecentlyNonNull boolean[] zArr) {
        int length = zArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (i10 != 0) {
                sb2.append(",");
            }
            sb2.append(Boolean.toString(zArr[i10]));
        }
    }

    public static void h(@RecentlyNonNull StringBuilder sb2, @RecentlyNonNull String[] strArr) {
        int length = strArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (i10 != 0) {
                sb2.append(",");
            }
            sb2.append("\"");
            sb2.append(strArr[i10]);
            sb2.append("\"");
        }
    }
}
