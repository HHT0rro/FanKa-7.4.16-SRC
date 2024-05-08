package com.tencent.bugly.crashreport.common.info;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: BUGLY */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class PlugInBean implements Parcelable {
    public static final Parcelable.Creator<PlugInBean> CREATOR = new Parcelable.Creator<PlugInBean>() { // from class: com.tencent.bugly.crashreport.common.info.PlugInBean.1
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
    public final String f39085a;

    /* renamed from: b, reason: collision with root package name */
    public final String f39086b;

    /* renamed from: c, reason: collision with root package name */
    public final String f39087c;

    public PlugInBean(String str, String str2, String str3) {
        this.f39085a = str;
        this.f39086b = str2;
        this.f39087c = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "plid:" + this.f39085a + " plV:" + this.f39086b + " plUUID:" + this.f39087c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f39085a);
        parcel.writeString(this.f39086b);
        parcel.writeString(this.f39087c);
    }

    public PlugInBean(Parcel parcel) {
        this.f39085a = parcel.readString();
        this.f39086b = parcel.readString();
        this.f39087c = parcel.readString();
    }
}
