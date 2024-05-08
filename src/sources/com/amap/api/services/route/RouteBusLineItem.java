package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.busline.BusLineItem;
import com.amap.api.services.busline.BusStationItem;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class RouteBusLineItem extends BusLineItem {
    public static final Parcelable.Creator<RouteBusLineItem> CREATOR = new Parcelable.Creator<RouteBusLineItem>() { // from class: com.amap.api.services.route.RouteBusLineItem.1
        private static RouteBusLineItem a(Parcel parcel) {
            return new RouteBusLineItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RouteBusLineItem createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ RouteBusLineItem[] newArray(int i10) {
            return null;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private BusStationItem f8862a;

    /* renamed from: b, reason: collision with root package name */
    private BusStationItem f8863b;

    /* renamed from: c, reason: collision with root package name */
    private List<LatLonPoint> f8864c;

    /* renamed from: d, reason: collision with root package name */
    private int f8865d;

    /* renamed from: e, reason: collision with root package name */
    private List<BusStationItem> f8866e;

    /* renamed from: f, reason: collision with root package name */
    private float f8867f;

    public RouteBusLineItem(Parcel parcel) {
        super(parcel);
        this.f8864c = new ArrayList();
        this.f8866e = new ArrayList();
        this.f8862a = (BusStationItem) parcel.readParcelable(BusStationItem.class.getClassLoader());
        this.f8863b = (BusStationItem) parcel.readParcelable(BusStationItem.class.getClassLoader());
        this.f8864c = parcel.createTypedArrayList(LatLonPoint.CREATOR);
        this.f8865d = parcel.readInt();
        this.f8866e = parcel.createTypedArrayList(BusStationItem.CREATOR);
        this.f8867f = parcel.readFloat();
    }

    @Override // com.amap.api.services.busline.BusLineItem, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.amap.api.services.busline.BusLineItem
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj) || getClass() != obj.getClass()) {
            return false;
        }
        RouteBusLineItem routeBusLineItem = (RouteBusLineItem) obj;
        BusStationItem busStationItem = this.f8863b;
        if (busStationItem == null) {
            if (routeBusLineItem.f8863b != null) {
                return false;
            }
        } else if (!busStationItem.equals(routeBusLineItem.f8863b)) {
            return false;
        }
        BusStationItem busStationItem2 = this.f8862a;
        if (busStationItem2 == null) {
            if (routeBusLineItem.f8862a != null) {
                return false;
            }
        } else if (!busStationItem2.equals(routeBusLineItem.f8862a)) {
            return false;
        }
        return true;
    }

    public BusStationItem getArrivalBusStation() {
        return this.f8863b;
    }

    public BusStationItem getDepartureBusStation() {
        return this.f8862a;
    }

    public float getDuration() {
        return this.f8867f;
    }

    public int getPassStationNum() {
        return this.f8865d;
    }

    public List<BusStationItem> getPassStations() {
        return this.f8866e;
    }

    public List<LatLonPoint> getPolyline() {
        return this.f8864c;
    }

    @Override // com.amap.api.services.busline.BusLineItem
    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        BusStationItem busStationItem = this.f8863b;
        int hashCode2 = (hashCode + (busStationItem == null ? 0 : busStationItem.hashCode())) * 31;
        BusStationItem busStationItem2 = this.f8862a;
        return hashCode2 + (busStationItem2 != null ? busStationItem2.hashCode() : 0);
    }

    public void setArrivalBusStation(BusStationItem busStationItem) {
        this.f8863b = busStationItem;
    }

    public void setDepartureBusStation(BusStationItem busStationItem) {
        this.f8862a = busStationItem;
    }

    public void setDuration(float f10) {
        this.f8867f = f10;
    }

    public void setPassStationNum(int i10) {
        this.f8865d = i10;
    }

    public void setPassStations(List<BusStationItem> list) {
        this.f8866e = list;
    }

    public void setPolyline(List<LatLonPoint> list) {
        this.f8864c = list;
    }

    @Override // com.amap.api.services.busline.BusLineItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeParcelable(this.f8862a, i10);
        parcel.writeParcelable(this.f8863b, i10);
        parcel.writeTypedList(this.f8864c);
        parcel.writeInt(this.f8865d);
        parcel.writeTypedList(this.f8866e);
        parcel.writeFloat(this.f8867f);
    }

    public RouteBusLineItem() {
        this.f8864c = new ArrayList();
        this.f8866e = new ArrayList();
    }
}
