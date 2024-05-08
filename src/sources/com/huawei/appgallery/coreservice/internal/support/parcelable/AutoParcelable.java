package com.huawei.appgallery.coreservice.internal.support.parcelable;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.appgallery.coreservice.internal.support.parcelable.b.e;
import java.lang.reflect.Array;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class AutoParcelable implements Parcelable {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class AutoCreator<T extends AutoParcelable> implements Parcelable.Creator<T> {

        /* renamed from: a, reason: collision with root package name */
        public final Class<T> f27583a;

        public AutoCreator(Class<T> cls) {
            this.f27583a = cls;
        }

        @Override // android.os.Parcelable.Creator
        public T createFromParcel(Parcel parcel) {
            return (T) e.a(this.f27583a, parcel);
        }

        @Override // android.os.Parcelable.Creator
        public T[] newArray(int i10) {
            return (T[]) ((AutoParcelable[]) Array.newInstance((Class<?>) this.f27583a, i10));
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        e.e(this, parcel, i10);
    }
}
