package com.huawei.hmf.services.ui.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hmf.services.ui.ref.ReferenceType;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class ReferenceTypeImpl<T> implements ReferenceType<T>, Parcelable {
    public static final Parcelable.Creator<ReferenceTypeImpl> CREATOR = new Parcelable.Creator<ReferenceTypeImpl>() { // from class: com.huawei.hmf.services.ui.internal.ReferenceTypeImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ReferenceTypeImpl createFromParcel(Parcel parcel) {
            return new ReferenceTypeImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ReferenceTypeImpl[] newArray(int i10) {
            return new ReferenceTypeImpl[i10];
        }
    };

    /* renamed from: id, reason: collision with root package name */
    private Long f28852id;
    private transient T value;

    public ReferenceTypeImpl() {
    }

    public static <T> ReferenceTypeImpl<T> create(T t2) {
        return new ReferenceTypeImpl<>(ObjectPool.getInstance().add(t2), t2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.huawei.hmf.services.ui.ref.ReferenceType
    public void free() {
        ObjectPool.getInstance().remove(this.f28852id);
    }

    @Override // com.huawei.hmf.services.ui.ref.ReferenceType
    public T get() {
        if (this.value == null) {
            this.value = (T) ObjectPool.getInstance().get(this.f28852id);
        }
        return this.value;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeLong(this.f28852id.longValue());
    }

    public ReferenceTypeImpl(Long l10, T t2) {
        this.f28852id = l10;
        this.value = t2;
    }

    public ReferenceTypeImpl(Parcel parcel) {
        this.f28852id = Long.valueOf(parcel.readLong());
    }
}
