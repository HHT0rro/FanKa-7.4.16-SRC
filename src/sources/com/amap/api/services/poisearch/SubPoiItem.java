package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class SubPoiItem implements Parcelable {
    public static final Parcelable.Creator<SubPoiItem> CREATOR = new Parcelable.Creator<SubPoiItem>() { // from class: com.amap.api.services.poisearch.SubPoiItem.1
        private static SubPoiItem a(Parcel parcel) {
            return new SubPoiItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ SubPoiItem createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ SubPoiItem[] newArray(int i10) {
            return null;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private String f8686a;

    /* renamed from: b, reason: collision with root package name */
    private String f8687b;

    /* renamed from: c, reason: collision with root package name */
    private String f8688c;

    /* renamed from: d, reason: collision with root package name */
    private int f8689d;

    /* renamed from: e, reason: collision with root package name */
    private LatLonPoint f8690e;

    /* renamed from: f, reason: collision with root package name */
    private String f8691f;

    /* renamed from: g, reason: collision with root package name */
    private String f8692g;

    public SubPoiItem(String str, LatLonPoint latLonPoint, String str2, String str3) {
        this.f8686a = str;
        this.f8690e = latLonPoint;
        this.f8687b = str2;
        this.f8691f = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getDistance() {
        return this.f8689d;
    }

    public LatLonPoint getLatLonPoint() {
        return this.f8690e;
    }

    public String getPoiId() {
        return this.f8686a;
    }

    public String getSnippet() {
        return this.f8691f;
    }

    public String getSubName() {
        return this.f8688c;
    }

    public String getSubTypeDes() {
        return this.f8692g;
    }

    public String getTitle() {
        return this.f8687b;
    }

    public void setDistance(int i10) {
        this.f8689d = i10;
    }

    public void setLatLonPoint(LatLonPoint latLonPoint) {
        this.f8690e = latLonPoint;
    }

    public void setPoiId(String str) {
        this.f8686a = str;
    }

    public void setSnippet(String str) {
        this.f8691f = str;
    }

    public void setSubName(String str) {
        this.f8688c = str;
    }

    public void setSubTypeDes(String str) {
        this.f8692g = str;
    }

    public void setTitle(String str) {
        this.f8687b = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f8686a);
        parcel.writeString(this.f8687b);
        parcel.writeString(this.f8688c);
        parcel.writeInt(this.f8689d);
        parcel.writeValue(this.f8690e);
        parcel.writeString(this.f8691f);
        parcel.writeString(this.f8692g);
    }

    public SubPoiItem(Parcel parcel) {
        this.f8686a = parcel.readString();
        this.f8687b = parcel.readString();
        this.f8688c = parcel.readString();
        this.f8689d = parcel.readInt();
        this.f8690e = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f8691f = parcel.readString();
        this.f8692g = parcel.readString();
    }
}
