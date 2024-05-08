package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class RailwayStationItem implements Parcelable {
    public static final Parcelable.Creator<RailwayStationItem> CREATOR = new Parcelable.Creator<RailwayStationItem>() { // from class: com.amap.api.services.route.RailwayStationItem.1
        private static RailwayStationItem a(Parcel parcel) {
            return new RailwayStationItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RailwayStationItem createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RailwayStationItem[] newArray(int i10) {
            return a(i10);
        }

        private static RailwayStationItem[] a(int i10) {
            return new RailwayStationItem[i10];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private String f8840a;

    /* renamed from: b, reason: collision with root package name */
    private String f8841b;

    /* renamed from: c, reason: collision with root package name */
    private LatLonPoint f8842c;

    /* renamed from: d, reason: collision with root package name */
    private String f8843d;

    /* renamed from: e, reason: collision with root package name */
    private String f8844e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f8845f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f8846g;

    /* renamed from: h, reason: collision with root package name */
    private float f8847h;

    public RailwayStationItem() {
        this.f8845f = false;
        this.f8846g = false;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAdcode() {
        return this.f8843d;
    }

    public String getID() {
        return this.f8840a;
    }

    public LatLonPoint getLocation() {
        return this.f8842c;
    }

    public String getName() {
        return this.f8841b;
    }

    public String getTime() {
        return this.f8844e;
    }

    public float getWait() {
        return this.f8847h;
    }

    public boolean isEnd() {
        return this.f8846g;
    }

    public boolean isStart() {
        return this.f8845f;
    }

    public void setAdcode(String str) {
        this.f8843d = str;
    }

    public void setID(String str) {
        this.f8840a = str;
    }

    public void setLocation(LatLonPoint latLonPoint) {
        this.f8842c = latLonPoint;
    }

    public void setName(String str) {
        this.f8841b = str;
    }

    public void setTime(String str) {
        this.f8844e = str;
    }

    public void setWait(float f10) {
        this.f8847h = f10;
    }

    public void setisEnd(boolean z10) {
        this.f8846g = z10;
    }

    public void setisStart(boolean z10) {
        this.f8845f = z10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f8840a);
        parcel.writeString(this.f8841b);
        parcel.writeParcelable(this.f8842c, i10);
        parcel.writeString(this.f8843d);
        parcel.writeString(this.f8844e);
        parcel.writeBooleanArray(new boolean[]{this.f8845f, this.f8846g});
        parcel.writeFloat(this.f8847h);
    }

    public RailwayStationItem(Parcel parcel) {
        this.f8845f = false;
        this.f8846g = false;
        this.f8840a = parcel.readString();
        this.f8841b = parcel.readString();
        this.f8842c = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f8843d = parcel.readString();
        this.f8844e = parcel.readString();
        boolean[] zArr = new boolean[2];
        parcel.readBooleanArray(zArr);
        this.f8845f = zArr[0];
        this.f8846g = zArr[1];
        this.f8847h = parcel.readFloat();
    }
}
