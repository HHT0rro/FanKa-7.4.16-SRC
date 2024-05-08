package com.sina.weibo.sdk.web;

import android.os.Parcel;
import android.os.Parcelable;
import com.sina.weibo.sdk.auth.AuthInfo;
import java.io.Serializable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class WebData implements Parcelable, Serializable {
    public static final Parcelable.Creator<WebData> CREATOR = new Parcelable.Creator<WebData>() { // from class: com.sina.weibo.sdk.web.WebData.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ WebData createFromParcel(Parcel parcel) {
            return new WebData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ WebData[] newArray(int i10) {
            return new WebData[i10];
        }
    };
    private static final long serialVersionUID = -4038177938155795889L;
    public AuthInfo at;
    public String au;

    /* renamed from: i, reason: collision with root package name */
    public String f38371i;
    public int type;

    public WebData(AuthInfo authInfo, int i10, String str, String str2) {
        this.at = authInfo;
        this.type = i10;
        this.f38371i = str;
        this.au = str2;
    }

    public final AuthInfo b() {
        return this.at;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final int getType() {
        return this.type;
    }

    public final String getUrl() {
        return this.f38371i;
    }

    public final String v() {
        return this.au;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable(this.at, i10);
        parcel.writeInt(this.type);
        parcel.writeString(this.f38371i);
        parcel.writeString(this.au);
    }

    public WebData(Parcel parcel) {
        this.at = (AuthInfo) parcel.readParcelable(AuthInfo.class.getClassLoader());
        this.type = parcel.readInt();
        this.f38371i = parcel.readString();
        this.au = parcel.readString();
    }
}
