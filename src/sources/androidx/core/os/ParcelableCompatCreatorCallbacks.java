package androidx.core.os;

import android.os.Parcel;

@Deprecated
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface ParcelableCompatCreatorCallbacks<T> {
    T createFromParcel(Parcel parcel, ClassLoader classLoader);

    T[] newArray(int i10);
}
