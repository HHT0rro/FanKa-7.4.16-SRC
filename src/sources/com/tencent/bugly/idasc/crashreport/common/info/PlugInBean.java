package com.tencent.bugly.idasc.crashreport.common.info;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class PlugInBean implements Parcelable {
    public static final Parcelable.Creator<PlugInBean> CREATOR = new Parcelable.Creator<PlugInBean>() { // from class: com.tencent.bugly.idasc.crashreport.common.info.PlugInBean.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ PlugInBean createFromParcel(Parcel parcel) {
            return new PlugInBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ PlugInBean[] newArray(int i10) {
            return new PlugInBean[i10];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public final String f39382a;

    /* renamed from: b, reason: collision with root package name */
    public final String f39383b;

    /* renamed from: c, reason: collision with root package name */
    public final String f39384c;

    public PlugInBean(Parcel parcel) {
        this.f39382a = parcel.readString();
        this.f39383b = parcel.readString();
        this.f39384c = parcel.readString();
    }

    public PlugInBean(String str, String str2, String str3) {
        this.f39382a = str;
        this.f39383b = str2;
        this.f39384c = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "plid:" + this.f39382a + " plV:" + this.f39383b + " plUUID:" + this.f39384c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f39382a);
        parcel.writeString(this.f39383b);
        parcel.writeString(this.f39384c);
    }
}
