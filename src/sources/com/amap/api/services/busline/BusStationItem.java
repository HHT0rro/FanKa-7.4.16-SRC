package com.amap.api.services.busline;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class BusStationItem implements Parcelable {
    public static final Parcelable.Creator<BusStationItem> CREATOR = new Parcelable.Creator<BusStationItem>() { // from class: com.amap.api.services.busline.BusStationItem.1
        private static BusStationItem a(Parcel parcel) {
            return new BusStationItem(parcel, (byte) 0);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ BusStationItem createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ BusStationItem[] newArray(int i10) {
            return null;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private String f8381a;

    /* renamed from: b, reason: collision with root package name */
    private String f8382b;

    /* renamed from: c, reason: collision with root package name */
    private LatLonPoint f8383c;

    /* renamed from: d, reason: collision with root package name */
    private String f8384d;

    /* renamed from: e, reason: collision with root package name */
    private String f8385e;

    /* renamed from: f, reason: collision with root package name */
    private List<BusLineItem> f8386f;

    public /* synthetic */ BusStationItem(Parcel parcel, byte b4) {
        this(parcel);
    }

    private static String a(List<BusLineItem> list) {
        StringBuffer stringBuffer = new StringBuffer();
        if (list != null) {
            for (int i10 = 0; i10 < list.size(); i10++) {
                stringBuffer.append(list.get(i10).getBusLineName());
                if (i10 < list.size() - 1) {
                    stringBuffer.append("|");
                }
            }
        }
        return stringBuffer.toString();
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
        BusStationItem busStationItem = (BusStationItem) obj;
        String str = this.f8381a;
        if (str == null) {
            if (busStationItem.f8381a != null) {
                return false;
            }
        } else if (!str.equals(busStationItem.f8381a)) {
            return false;
        }
        return true;
    }

    public String getAdCode() {
        return this.f8385e;
    }

    public List<BusLineItem> getBusLineItems() {
        return this.f8386f;
    }

    public String getBusStationId() {
        return this.f8381a;
    }

    public String getBusStationName() {
        return this.f8382b;
    }

    public String getCityCode() {
        return this.f8384d;
    }

    public LatLonPoint getLatLonPoint() {
        return this.f8383c;
    }

    public int hashCode() {
        String str = this.f8381a;
        return (str == null ? 0 : str.hashCode()) + 31;
    }

    public void setAdCode(String str) {
        this.f8385e = str;
    }

    public void setBusLineItems(List<BusLineItem> list) {
        this.f8386f = list;
    }

    public void setBusStationId(String str) {
        this.f8381a = str;
    }

    public void setBusStationName(String str) {
        this.f8382b = str;
    }

    public void setCityCode(String str) {
        this.f8384d = str;
    }

    public void setLatLonPoint(LatLonPoint latLonPoint) {
        this.f8383c = latLonPoint;
    }

    public String toString() {
        return "BusStationName: " + this.f8382b + " LatLonPoint: " + this.f8383c.toString() + " BusLines: " + a(this.f8386f) + " CityCode: " + this.f8384d + " AdCode: " + this.f8385e;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f8382b);
        parcel.writeString(this.f8381a);
        parcel.writeValue(this.f8383c);
        parcel.writeString(this.f8384d);
        parcel.writeString(this.f8385e);
        parcel.writeList(this.f8386f);
    }

    public BusStationItem() {
        this.f8386f = new ArrayList();
    }

    private BusStationItem(Parcel parcel) {
        this.f8386f = new ArrayList();
        this.f8382b = parcel.readString();
        this.f8381a = parcel.readString();
        this.f8383c = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f8384d = parcel.readString();
        this.f8385e = parcel.readString();
        this.f8386f = parcel.readArrayList(BusLineItem.class.getClassLoader());
    }
}
