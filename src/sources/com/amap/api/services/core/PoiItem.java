package com.amap.api.services.core;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.poisearch.IndoorData;
import com.amap.api.services.poisearch.Photo;
import com.amap.api.services.poisearch.PoiItemExtension;
import com.amap.api.services.poisearch.SubPoiItem;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class PoiItem implements Parcelable {
    public static final Parcelable.Creator<PoiItem> CREATOR = new Parcelable.Creator<PoiItem>() { // from class: com.amap.api.services.core.PoiItem.1
        private static PoiItem a(Parcel parcel) {
            return new PoiItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ PoiItem createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ PoiItem[] newArray(int i10) {
            return a(i10);
        }

        private static PoiItem[] a(int i10) {
            return new PoiItem[i10];
        }
    };
    private String A;
    private String B;

    /* renamed from: a, reason: collision with root package name */
    private String f8438a;

    /* renamed from: b, reason: collision with root package name */
    private String f8439b;

    /* renamed from: c, reason: collision with root package name */
    private String f8440c;

    /* renamed from: d, reason: collision with root package name */
    private String f8441d;

    /* renamed from: e, reason: collision with root package name */
    private String f8442e;

    /* renamed from: f, reason: collision with root package name */
    private int f8443f;

    /* renamed from: g, reason: collision with root package name */
    private final LatLonPoint f8444g;

    /* renamed from: h, reason: collision with root package name */
    private final String f8445h;

    /* renamed from: i, reason: collision with root package name */
    private final String f8446i;

    /* renamed from: j, reason: collision with root package name */
    private LatLonPoint f8447j;

    /* renamed from: k, reason: collision with root package name */
    private LatLonPoint f8448k;

    /* renamed from: l, reason: collision with root package name */
    private String f8449l;

    /* renamed from: m, reason: collision with root package name */
    private String f8450m;

    /* renamed from: n, reason: collision with root package name */
    private String f8451n;

    /* renamed from: o, reason: collision with root package name */
    private String f8452o;

    /* renamed from: p, reason: collision with root package name */
    private String f8453p;

    /* renamed from: q, reason: collision with root package name */
    private String f8454q;

    /* renamed from: r, reason: collision with root package name */
    private String f8455r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f8456s;

    /* renamed from: t, reason: collision with root package name */
    private IndoorData f8457t;

    /* renamed from: u, reason: collision with root package name */
    private String f8458u;

    /* renamed from: v, reason: collision with root package name */
    private String f8459v;

    /* renamed from: w, reason: collision with root package name */
    private String f8460w;

    /* renamed from: x, reason: collision with root package name */
    private List<SubPoiItem> f8461x;

    /* renamed from: y, reason: collision with root package name */
    private List<Photo> f8462y;

    /* renamed from: z, reason: collision with root package name */
    private PoiItemExtension f8463z;

    public PoiItem(String str, LatLonPoint latLonPoint, String str2, String str3) {
        this.f8442e = "";
        this.f8443f = -1;
        this.f8461x = new ArrayList();
        this.f8462y = new ArrayList();
        this.f8438a = str;
        this.f8444g = latLonPoint;
        this.f8445h = str2;
        this.f8446i = str3;
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
        PoiItem poiItem = (PoiItem) obj;
        String str = this.f8438a;
        if (str == null) {
            if (poiItem.f8438a != null) {
                return false;
            }
        } else if (!str.equals(poiItem.f8438a)) {
            return false;
        }
        return true;
    }

    public String getAdCode() {
        return this.f8440c;
    }

    public String getAdName() {
        return this.f8455r;
    }

    public String getBusinessArea() {
        return this.f8459v;
    }

    public String getCityCode() {
        return this.f8441d;
    }

    public String getCityName() {
        return this.f8454q;
    }

    public String getDirection() {
        return this.f8452o;
    }

    public int getDistance() {
        return this.f8443f;
    }

    public String getEmail() {
        return this.f8451n;
    }

    public LatLonPoint getEnter() {
        return this.f8447j;
    }

    public LatLonPoint getExit() {
        return this.f8448k;
    }

    public IndoorData getIndoorData() {
        return this.f8457t;
    }

    public LatLonPoint getLatLonPoint() {
        return this.f8444g;
    }

    public String getParkingType() {
        return this.f8460w;
    }

    public List<Photo> getPhotos() {
        return this.f8462y;
    }

    public PoiItemExtension getPoiExtension() {
        return this.f8463z;
    }

    public String getPoiId() {
        return this.f8438a;
    }

    public String getPostcode() {
        return this.f8450m;
    }

    public String getProvinceCode() {
        return this.f8458u;
    }

    public String getProvinceName() {
        return this.f8453p;
    }

    public String getShopID() {
        return this.B;
    }

    public String getSnippet() {
        return this.f8446i;
    }

    public List<SubPoiItem> getSubPois() {
        return this.f8461x;
    }

    public String getTel() {
        return this.f8439b;
    }

    public String getTitle() {
        return this.f8445h;
    }

    public String getTypeCode() {
        return this.A;
    }

    public String getTypeDes() {
        return this.f8442e;
    }

    public String getWebsite() {
        return this.f8449l;
    }

    public int hashCode() {
        String str = this.f8438a;
        return (str == null ? 0 : str.hashCode()) + 31;
    }

    public boolean isIndoorMap() {
        return this.f8456s;
    }

    public void setAdCode(String str) {
        this.f8440c = str;
    }

    public void setAdName(String str) {
        this.f8455r = str;
    }

    public void setBusinessArea(String str) {
        this.f8459v = str;
    }

    public void setCityCode(String str) {
        this.f8441d = str;
    }

    public void setCityName(String str) {
        this.f8454q = str;
    }

    public void setDirection(String str) {
        this.f8452o = str;
    }

    public void setDistance(int i10) {
        this.f8443f = i10;
    }

    public void setEmail(String str) {
        this.f8451n = str;
    }

    public void setEnter(LatLonPoint latLonPoint) {
        this.f8447j = latLonPoint;
    }

    public void setExit(LatLonPoint latLonPoint) {
        this.f8448k = latLonPoint;
    }

    public void setIndoorDate(IndoorData indoorData) {
        this.f8457t = indoorData;
    }

    public void setIndoorMap(boolean z10) {
        this.f8456s = z10;
    }

    public void setParkingType(String str) {
        this.f8460w = str;
    }

    public void setPhotos(List<Photo> list) {
        this.f8462y = list;
    }

    public void setPoiExtension(PoiItemExtension poiItemExtension) {
        this.f8463z = poiItemExtension;
    }

    public void setPostcode(String str) {
        this.f8450m = str;
    }

    public void setProvinceCode(String str) {
        this.f8458u = str;
    }

    public void setProvinceName(String str) {
        this.f8453p = str;
    }

    public void setShopID(String str) {
        this.B = str;
    }

    public void setSubPois(List<SubPoiItem> list) {
        this.f8461x = list;
    }

    public void setTel(String str) {
        this.f8439b = str;
    }

    public void setTypeCode(String str) {
        this.A = str;
    }

    public void setTypeDes(String str) {
        this.f8442e = str;
    }

    public void setWebsite(String str) {
        this.f8449l = str;
    }

    public String toString() {
        return this.f8445h;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f8438a);
        parcel.writeString(this.f8440c);
        parcel.writeString(this.f8439b);
        parcel.writeString(this.f8442e);
        parcel.writeInt(this.f8443f);
        parcel.writeValue(this.f8444g);
        parcel.writeString(this.f8445h);
        parcel.writeString(this.f8446i);
        parcel.writeString(this.f8441d);
        parcel.writeValue(this.f8447j);
        parcel.writeValue(this.f8448k);
        parcel.writeString(this.f8449l);
        parcel.writeString(this.f8450m);
        parcel.writeString(this.f8451n);
        parcel.writeBooleanArray(new boolean[]{this.f8456s});
        parcel.writeString(this.f8452o);
        parcel.writeString(this.f8453p);
        parcel.writeString(this.f8454q);
        parcel.writeString(this.f8455r);
        parcel.writeString(this.f8458u);
        parcel.writeString(this.f8459v);
        parcel.writeString(this.f8460w);
        parcel.writeList(this.f8461x);
        parcel.writeValue(this.f8457t);
        parcel.writeTypedList(this.f8462y);
        parcel.writeParcelable(this.f8463z, i10);
        parcel.writeString(this.A);
        parcel.writeString(this.B);
    }

    public PoiItem(Parcel parcel) {
        this.f8442e = "";
        this.f8443f = -1;
        this.f8461x = new ArrayList();
        this.f8462y = new ArrayList();
        this.f8438a = parcel.readString();
        this.f8440c = parcel.readString();
        this.f8439b = parcel.readString();
        this.f8442e = parcel.readString();
        this.f8443f = parcel.readInt();
        this.f8444g = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f8445h = parcel.readString();
        this.f8446i = parcel.readString();
        this.f8441d = parcel.readString();
        this.f8447j = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f8448k = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f8449l = parcel.readString();
        this.f8450m = parcel.readString();
        this.f8451n = parcel.readString();
        boolean[] zArr = new boolean[1];
        parcel.readBooleanArray(zArr);
        this.f8456s = zArr[0];
        this.f8452o = parcel.readString();
        this.f8453p = parcel.readString();
        this.f8454q = parcel.readString();
        this.f8455r = parcel.readString();
        this.f8458u = parcel.readString();
        this.f8459v = parcel.readString();
        this.f8460w = parcel.readString();
        this.f8461x = parcel.readArrayList(SubPoiItem.class.getClassLoader());
        this.f8457t = (IndoorData) parcel.readValue(IndoorData.class.getClassLoader());
        this.f8462y = parcel.createTypedArrayList(Photo.CREATOR);
        this.f8463z = (PoiItemExtension) parcel.readParcelable(PoiItemExtension.class.getClassLoader());
        this.A = parcel.readString();
        this.B = parcel.readString();
    }
}
