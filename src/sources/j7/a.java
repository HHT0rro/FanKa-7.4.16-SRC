package j7;

import android.os.IInterface;
import android.os.Parcel;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final ClassLoader f50345a = a.class.getClassLoader();

    public static void a(Parcel parcel, boolean z10) {
        parcel.writeInt(z10 ? 1 : 0);
    }

    public static void b(Parcel parcel, IInterface iInterface) {
        if (iInterface == null) {
            parcel.writeStrongBinder(null);
        } else {
            parcel.writeStrongBinder(iInterface.asBinder());
        }
    }

    public static boolean c(Parcel parcel) {
        return parcel.readInt() != 0;
    }
}
