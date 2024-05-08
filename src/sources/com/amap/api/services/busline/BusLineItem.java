package com.amap.api.services.busline;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.col.s.n;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class BusLineItem implements Parcelable {
    public static final Parcelable.Creator<BusLineItem> CREATOR = new Parcelable.Creator<BusLineItem>() { // from class: com.amap.api.services.busline.BusLineItem.1
        private static BusLineItem a(Parcel parcel) {
            return new BusLineItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ BusLineItem createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ BusLineItem[] newArray(int i10) {
            return null;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private float f8353a;

    /* renamed from: b, reason: collision with root package name */
    private String f8354b;

    /* renamed from: c, reason: collision with root package name */
    private String f8355c;

    /* renamed from: d, reason: collision with root package name */
    private String f8356d;

    /* renamed from: e, reason: collision with root package name */
    private List<LatLonPoint> f8357e;

    /* renamed from: f, reason: collision with root package name */
    private List<LatLonPoint> f8358f;

    /* renamed from: g, reason: collision with root package name */
    private String f8359g;

    /* renamed from: h, reason: collision with root package name */
    private String f8360h;

    /* renamed from: i, reason: collision with root package name */
    private String f8361i;

    /* renamed from: j, reason: collision with root package name */
    private Date f8362j;

    /* renamed from: k, reason: collision with root package name */
    private Date f8363k;

    /* renamed from: l, reason: collision with root package name */
    private String f8364l;

    /* renamed from: m, reason: collision with root package name */
    private float f8365m;

    /* renamed from: n, reason: collision with root package name */
    private float f8366n;

    /* renamed from: o, reason: collision with root package name */
    private List<BusStationItem> f8367o;

    public BusLineItem() {
        this.f8357e = new ArrayList();
        this.f8358f = new ArrayList();
        this.f8367o = new ArrayList();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BusLineItem busLineItem = (BusLineItem) obj;
        String str = this.f8359g;
        if (str == null) {
            if (busLineItem.f8359g != null) {
                return false;
            }
        } else if (!str.equals(busLineItem.f8359g)) {
            return false;
        }
        return true;
    }

    public float getBasicPrice() {
        return this.f8365m;
    }

    public List<LatLonPoint> getBounds() {
        return this.f8358f;
    }

    public String getBusCompany() {
        return this.f8364l;
    }

    public String getBusLineId() {
        return this.f8359g;
    }

    public String getBusLineName() {
        return this.f8354b;
    }

    public String getBusLineType() {
        return this.f8355c;
    }

    public List<BusStationItem> getBusStations() {
        return this.f8367o;
    }

    public String getCityCode() {
        return this.f8356d;
    }

    public List<LatLonPoint> getDirectionsCoordinates() {
        return this.f8357e;
    }

    public float getDistance() {
        return this.f8353a;
    }

    public Date getFirstBusTime() {
        Date date = this.f8362j;
        if (date == null) {
            return null;
        }
        return (Date) date.clone();
    }

    public Date getLastBusTime() {
        Date date = this.f8363k;
        if (date == null) {
            return null;
        }
        return (Date) date.clone();
    }

    public String getOriginatingStation() {
        return this.f8360h;
    }

    public String getTerminalStation() {
        return this.f8361i;
    }

    public float getTotalPrice() {
        return this.f8366n;
    }

    public int hashCode() {
        String str = this.f8359g;
        return (str == null ? 0 : str.hashCode()) + 31;
    }

    public void setBasicPrice(float f10) {
        this.f8365m = f10;
    }

    public void setBounds(List<LatLonPoint> list) {
        this.f8358f = list;
    }

    public void setBusCompany(String str) {
        this.f8364l = str;
    }

    public void setBusLineId(String str) {
        this.f8359g = str;
    }

    public void setBusLineName(String str) {
        this.f8354b = str;
    }

    public void setBusLineType(String str) {
        this.f8355c = str;
    }

    public void setBusStations(List<BusStationItem> list) {
        this.f8367o = list;
    }

    public void setCityCode(String str) {
        this.f8356d = str;
    }

    public void setDirectionsCoordinates(List<LatLonPoint> list) {
        this.f8357e = list;
    }

    public void setDistance(float f10) {
        this.f8353a = f10;
    }

    public void setFirstBusTime(Date date) {
        if (date == null) {
            this.f8362j = null;
        } else {
            this.f8362j = (Date) date.clone();
        }
    }

    public void setLastBusTime(Date date) {
        if (date == null) {
            this.f8363k = null;
        } else {
            this.f8363k = (Date) date.clone();
        }
    }

    public void setOriginatingStation(String str) {
        this.f8360h = str;
    }

    public void setTerminalStation(String str) {
        this.f8361i = str;
    }

    public void setTotalPrice(float f10) {
        this.f8366n = f10;
    }

    public String toString() {
        return this.f8354b + " " + n.a(this.f8362j) + "-" + n.a(this.f8363k);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeFloat(this.f8353a);
        parcel.writeString(this.f8354b);
        parcel.writeString(this.f8355c);
        parcel.writeString(this.f8356d);
        parcel.writeList(this.f8357e);
        parcel.writeList(this.f8358f);
        parcel.writeString(this.f8359g);
        parcel.writeString(this.f8360h);
        parcel.writeString(this.f8361i);
        parcel.writeString(n.a(this.f8362j));
        parcel.writeString(n.a(this.f8363k));
        parcel.writeString(this.f8364l);
        parcel.writeFloat(this.f8365m);
        parcel.writeFloat(this.f8366n);
        parcel.writeList(this.f8367o);
    }

    public BusLineItem(Parcel parcel) {
        this.f8357e = new ArrayList();
        this.f8358f = new ArrayList();
        this.f8367o = new ArrayList();
        this.f8353a = parcel.readFloat();
        this.f8354b = parcel.readString();
        this.f8355c = parcel.readString();
        this.f8356d = parcel.readString();
        this.f8357e = parcel.readArrayList(LatLonPoint.class.getClassLoader());
        this.f8358f = parcel.readArrayList(LatLonPoint.class.getClassLoader());
        this.f8359g = parcel.readString();
        this.f8360h = parcel.readString();
        this.f8361i = parcel.readString();
        this.f8362j = n.e(parcel.readString());
        this.f8363k = n.e(parcel.readString());
        this.f8364l = parcel.readString();
        this.f8365m = parcel.readFloat();
        this.f8366n = parcel.readFloat();
        this.f8367o = parcel.readArrayList(BusStationItem.class.getClassLoader());
    }
}
