package com.amap.api.services.cloud;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class CloudImage implements Parcelable {
    public static final Parcelable.Creator<CloudImage> CREATOR = new Parcelable.Creator<CloudImage>() { // from class: com.amap.api.services.cloud.CloudImage.1
        private static CloudImage a(Parcel parcel) {
            return new CloudImage(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ CloudImage createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ CloudImage[] newArray(int i10) {
            return a(i10);
        }

        private static CloudImage[] a(int i10) {
            return new CloudImage[i10];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private String f8397a;

    /* renamed from: b, reason: collision with root package name */
    private String f8398b;

    /* renamed from: c, reason: collision with root package name */
    private String f8399c;

    public CloudImage(String str, String str2, String str3) {
        this.f8397a = str;
        this.f8398b = str2;
        this.f8399c = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getId() {
        return this.f8397a;
    }

    public String getPreurl() {
        return this.f8398b;
    }

    public String getUrl() {
        return this.f8399c;
    }

    public void setId(String str) {
        this.f8397a = str;
    }

    public void setPreurl(String str) {
        this.f8398b = str;
    }

    public void setUrl(String str) {
        this.f8399c = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f8397a);
        parcel.writeString(this.f8398b);
        parcel.writeString(this.f8399c);
    }

    public CloudImage(Parcel parcel) {
        this.f8397a = parcel.readString();
        this.f8398b = parcel.readString();
        this.f8399c = parcel.readString();
    }
}
