package com.amap.api.fence;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.location.DPoint;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class DistrictItem implements Parcelable {
    public static final Parcelable.Creator<DistrictItem> CREATOR = new Parcelable.Creator<DistrictItem>() { // from class: com.amap.api.fence.DistrictItem.1
        private static DistrictItem a(Parcel parcel) {
            return new DistrictItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DistrictItem createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DistrictItem[] newArray(int i10) {
            return a(i10);
        }

        private static DistrictItem[] a(int i10) {
            return new DistrictItem[i10];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private String f8022a;

    /* renamed from: b, reason: collision with root package name */
    private String f8023b;

    /* renamed from: c, reason: collision with root package name */
    private String f8024c;

    /* renamed from: d, reason: collision with root package name */
    private List<DPoint> f8025d;

    public DistrictItem() {
        this.f8022a = "";
        this.f8023b = null;
        this.f8024c = null;
        this.f8025d = null;
    }

    public static Parcelable.Creator<DistrictItem> getCreator() {
        return CREATOR;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAdcode() {
        return this.f8024c;
    }

    public String getCitycode() {
        return this.f8023b;
    }

    public String getDistrictName() {
        return this.f8022a;
    }

    public List<DPoint> getPolyline() {
        return this.f8025d;
    }

    public void setAdcode(String str) {
        this.f8024c = str;
    }

    public void setCitycode(String str) {
        this.f8023b = str;
    }

    public void setDistrictName(String str) {
        this.f8022a = str;
    }

    public void setPolyline(List<DPoint> list) {
        this.f8025d = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f8022a);
        parcel.writeString(this.f8023b);
        parcel.writeString(this.f8024c);
        parcel.writeTypedList(this.f8025d);
    }

    public DistrictItem(Parcel parcel) {
        this.f8022a = "";
        this.f8023b = null;
        this.f8024c = null;
        this.f8025d = null;
        this.f8022a = parcel.readString();
        this.f8023b = parcel.readString();
        this.f8024c = parcel.readString();
        this.f8025d = parcel.createTypedArrayList(DPoint.CREATOR);
    }
}
