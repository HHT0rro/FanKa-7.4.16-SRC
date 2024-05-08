package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.annotation.KeepName;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
@KeepName
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class BinderWrapper implements Parcelable {

    @RecentlyNonNull
    public static final Parcelable.Creator<BinderWrapper> CREATOR = new t();

    /* renamed from: b, reason: collision with root package name */
    public IBinder f23604b;

    public BinderWrapper(Parcel parcel) {
        this.f23604b = parcel.readStrongBinder();
    }

    @Override // android.os.Parcelable
    @RecentlyNonNull
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i10) {
        parcel.writeStrongBinder(this.f23604b);
    }

    public /* synthetic */ BinderWrapper(Parcel parcel, t tVar) {
        this(parcel);
    }
}
