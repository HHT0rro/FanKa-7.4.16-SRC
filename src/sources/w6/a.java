package w6;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class a {
    @RecentlyNonNull
    public static int a(@RecentlyNonNull Parcel parcel) {
        return t(parcel, 20293);
    }

    public static void b(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i10) {
        w(parcel, i10);
    }

    public static void c(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i10, @RecentlyNonNull boolean z10) {
        u(parcel, i10, 4);
        parcel.writeInt(z10 ? 1 : 0);
    }

    public static void d(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i10, @RecentlyNonNull Bundle bundle, @RecentlyNonNull boolean z10) {
        if (bundle == null) {
            if (z10) {
                u(parcel, i10, 0);
            }
        } else {
            int t2 = t(parcel, i10);
            parcel.writeBundle(bundle);
            w(parcel, t2);
        }
    }

    public static void e(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i10, @RecentlyNonNull byte[] bArr, @RecentlyNonNull boolean z10) {
        if (bArr == null) {
            if (z10) {
                u(parcel, i10, 0);
            }
        } else {
            int t2 = t(parcel, i10);
            parcel.writeByteArray(bArr);
            w(parcel, t2);
        }
    }

    public static void f(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i10, @RecentlyNonNull byte[][] bArr, @RecentlyNonNull boolean z10) {
        if (bArr == null) {
            if (z10) {
                u(parcel, i10, 0);
                return;
            }
            return;
        }
        int t2 = t(parcel, i10);
        parcel.writeInt(bArr.length);
        for (byte[] bArr2 : bArr) {
            parcel.writeByteArray(bArr2);
        }
        w(parcel, t2);
    }

    public static void g(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i10, @RecentlyNonNull double d10) {
        u(parcel, i10, 8);
        parcel.writeDouble(d10);
    }

    public static void h(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i10, @RecentlyNonNull float f10) {
        u(parcel, i10, 4);
        parcel.writeFloat(f10);
    }

    public static void i(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i10, @RecentlyNonNull IBinder iBinder, @RecentlyNonNull boolean z10) {
        if (iBinder == null) {
            if (z10) {
                u(parcel, i10, 0);
            }
        } else {
            int t2 = t(parcel, i10);
            parcel.writeStrongBinder(iBinder);
            w(parcel, t2);
        }
    }

    public static void j(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i10, @RecentlyNonNull int i11) {
        u(parcel, i10, 4);
        parcel.writeInt(i11);
    }

    public static void k(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i10, @RecentlyNonNull int[] iArr, @RecentlyNonNull boolean z10) {
        if (iArr == null) {
            if (z10) {
                u(parcel, i10, 0);
            }
        } else {
            int t2 = t(parcel, i10);
            parcel.writeIntArray(iArr);
            w(parcel, t2);
        }
    }

    public static void l(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i10, @RecentlyNonNull long j10) {
        u(parcel, i10, 8);
        parcel.writeLong(j10);
    }

    public static void m(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i10, @RecentlyNonNull Parcel parcel2, @RecentlyNonNull boolean z10) {
        if (parcel2 == null) {
            if (z10) {
                u(parcel, i10, 0);
            }
        } else {
            int t2 = t(parcel, i10);
            parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            w(parcel, t2);
        }
    }

    public static void n(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i10, @RecentlyNonNull Parcelable parcelable, @RecentlyNonNull int i11, @RecentlyNonNull boolean z10) {
        if (parcelable == null) {
            if (z10) {
                u(parcel, i10, 0);
            }
        } else {
            int t2 = t(parcel, i10);
            parcelable.writeToParcel(parcel, i11);
            w(parcel, t2);
        }
    }

    public static void o(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i10, @RecentlyNonNull String str, @RecentlyNonNull boolean z10) {
        if (str == null) {
            if (z10) {
                u(parcel, i10, 0);
            }
        } else {
            int t2 = t(parcel, i10);
            parcel.writeString(str);
            w(parcel, t2);
        }
    }

    public static void p(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i10, @RecentlyNonNull String[] strArr, @RecentlyNonNull boolean z10) {
        if (strArr == null) {
            if (z10) {
                u(parcel, i10, 0);
            }
        } else {
            int t2 = t(parcel, i10);
            parcel.writeStringArray(strArr);
            w(parcel, t2);
        }
    }

    public static void q(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i10, @RecentlyNonNull List<String> list, @RecentlyNonNull boolean z10) {
        if (list == null) {
            if (z10) {
                u(parcel, i10, 0);
            }
        } else {
            int t2 = t(parcel, i10);
            parcel.writeStringList(list);
            w(parcel, t2);
        }
    }

    public static <T extends Parcelable> void r(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i10, @RecentlyNonNull T[] tArr, @RecentlyNonNull int i11, @RecentlyNonNull boolean z10) {
        if (tArr == null) {
            if (z10) {
                u(parcel, i10, 0);
                return;
            }
            return;
        }
        int t2 = t(parcel, i10);
        parcel.writeInt(tArr.length);
        for (T t10 : tArr) {
            if (t10 == null) {
                parcel.writeInt(0);
            } else {
                v(parcel, t10, i11);
            }
        }
        w(parcel, t2);
    }

    public static <T extends Parcelable> void s(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i10, @RecentlyNonNull List<T> list, @RecentlyNonNull boolean z10) {
        if (list == null) {
            if (z10) {
                u(parcel, i10, 0);
                return;
            }
            return;
        }
        int t2 = t(parcel, i10);
        int size = list.size();
        parcel.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            T t10 = list.get(i11);
            if (t10 == null) {
                parcel.writeInt(0);
            } else {
                v(parcel, t10, 0);
            }
        }
        w(parcel, t2);
    }

    public static int t(Parcel parcel, int i10) {
        parcel.writeInt(i10 | (-65536));
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    public static void u(Parcel parcel, int i10, int i11) {
        if (i11 >= 65535) {
            parcel.writeInt(i10 | (-65536));
            parcel.writeInt(i11);
        } else {
            parcel.writeInt(i10 | (i11 << 16));
        }
    }

    public static <T extends Parcelable> void v(Parcel parcel, T t2, int i10) {
        int dataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int dataPosition2 = parcel.dataPosition();
        t2.writeToParcel(parcel, i10);
        int dataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(dataPosition);
        parcel.writeInt(dataPosition3 - dataPosition2);
        parcel.setDataPosition(dataPosition3);
    }

    public static void w(Parcel parcel, int i10) {
        int dataPosition = parcel.dataPosition();
        parcel.setDataPosition(i10 - 4);
        parcel.writeInt(dataPosition - i10);
        parcel.setDataPosition(dataPosition);
    }
}
