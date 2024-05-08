package com.huawei.hmf.orb.aidl.impl;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class GetServiceRequest implements Parcelable {
    public static final Parcelable.Creator<GetServiceRequest> CREATOR = new Parcelable.Creator<GetServiceRequest>() { // from class: com.huawei.hmf.orb.aidl.impl.GetServiceRequest.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GetServiceRequest createFromParcel(Parcel parcel) {
            return new GetServiceRequest(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GetServiceRequest[] newArray(int i10) {
            return new GetServiceRequest[i10];
        }
    };
    public static final int REMOTE_MODULE_INVOKER = 0;
    private Intent mBindIntent;
    private int mServiceId;

    public GetServiceRequest(int i10, Intent intent) {
        this.mServiceId = i10;
        this.mBindIntent = intent;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Intent getBindIntent() {
        return this.mBindIntent;
    }

    public int getServiceId() {
        return this.mServiceId;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable(this.mBindIntent, i10);
    }

    public GetServiceRequest(Parcel parcel) {
        this.mBindIntent = (Intent) parcel.readParcelable(Intent.class.getClassLoader());
    }
}
