package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class SubPoiItemV2 implements Parcelable {
    public static final Parcelable.Creator<SubPoiItemV2> CREATOR = new Parcelable.Creator<SubPoiItemV2>() { // from class: com.amap.api.services.poisearch.SubPoiItemV2.1
        private static SubPoiItemV2 a(Parcel parcel) {
            return new SubPoiItemV2(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ SubPoiItemV2 createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ SubPoiItemV2[] newArray(int i10) {
            return null;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private String f8693a;

    /* renamed from: b, reason: collision with root package name */
    private String f8694b;

    /* renamed from: c, reason: collision with root package name */
    private LatLonPoint f8695c;

    /* renamed from: d, reason: collision with root package name */
    private String f8696d;

    /* renamed from: e, reason: collision with root package name */
    private String f8697e;

    /* renamed from: f, reason: collision with root package name */
    private String f8698f;

    public SubPoiItemV2(String str, LatLonPoint latLonPoint, String str2, String str3) {
        this.f8693a = str;
        this.f8695c = latLonPoint;
        this.f8694b = str2;
        this.f8696d = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LatLonPoint getLatLonPoint() {
        return this.f8695c;
    }

    public String getPoiId() {
        return this.f8693a;
    }

    public String getSnippet() {
        return this.f8696d;
    }

    public String getSubTypeDes() {
        return this.f8697e;
    }

    public String getTitle() {
        return this.f8694b;
    }

    public String getTypeCode() {
        return this.f8698f;
    }

    public void setLatLonPoint(LatLonPoint latLonPoint) {
        this.f8695c = latLonPoint;
    }

    public void setPoiId(String str) {
        this.f8693a = str;
    }

    public void setSnippet(String str) {
        this.f8696d = str;
    }

    public void setSubTypeDes(String str) {
        this.f8697e = str;
    }

    public void setTitle(String str) {
        this.f8694b = str;
    }

    public void setTypeCode(String str) {
        this.f8698f = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f8693a);
        parcel.writeString(this.f8694b);
        parcel.writeValue(this.f8695c);
        parcel.writeString(this.f8696d);
        parcel.writeString(this.f8697e);
        parcel.writeString(this.f8698f);
    }

    public SubPoiItemV2(Parcel parcel) {
        this.f8693a = parcel.readString();
        this.f8694b = parcel.readString();
        this.f8695c = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f8696d = parcel.readString();
        this.f8697e = parcel.readString();
        this.f8698f = parcel.readString();
    }
}
