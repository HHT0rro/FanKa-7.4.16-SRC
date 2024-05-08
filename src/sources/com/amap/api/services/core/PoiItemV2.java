package com.amap.api.services.core;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.poisearch.Business;
import com.amap.api.services.poisearch.IndoorDataV2;
import com.amap.api.services.poisearch.Photo;
import com.amap.api.services.poisearch.PoiNavi;
import com.amap.api.services.poisearch.SubPoiItemV2;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class PoiItemV2 implements Parcelable {
    public static final Parcelable.Creator<PoiItem> CREATOR = new Parcelable.Creator<PoiItem>() { // from class: com.amap.api.services.core.PoiItemV2.1
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

    /* renamed from: a, reason: collision with root package name */
    private String f8464a;

    /* renamed from: b, reason: collision with root package name */
    private String f8465b;

    /* renamed from: c, reason: collision with root package name */
    private String f8466c;

    /* renamed from: d, reason: collision with root package name */
    private String f8467d;

    /* renamed from: e, reason: collision with root package name */
    private final LatLonPoint f8468e;

    /* renamed from: f, reason: collision with root package name */
    private final String f8469f;

    /* renamed from: g, reason: collision with root package name */
    private final String f8470g;

    /* renamed from: h, reason: collision with root package name */
    private String f8471h;

    /* renamed from: i, reason: collision with root package name */
    private String f8472i;

    /* renamed from: j, reason: collision with root package name */
    private String f8473j;

    /* renamed from: k, reason: collision with root package name */
    private String f8474k;

    /* renamed from: l, reason: collision with root package name */
    private String f8475l;

    /* renamed from: m, reason: collision with root package name */
    private List<SubPoiItemV2> f8476m;

    /* renamed from: n, reason: collision with root package name */
    private Business f8477n;

    /* renamed from: o, reason: collision with root package name */
    private IndoorDataV2 f8478o;

    /* renamed from: p, reason: collision with root package name */
    private PoiNavi f8479p;

    /* renamed from: q, reason: collision with root package name */
    private List<Photo> f8480q;

    public PoiItemV2(String str, LatLonPoint latLonPoint, String str2, String str3) {
        this.f8467d = "";
        this.f8476m = new ArrayList();
        this.f8480q = new ArrayList();
        this.f8464a = str;
        this.f8468e = latLonPoint;
        this.f8469f = str2;
        this.f8470g = str3;
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
        PoiItemV2 poiItemV2 = (PoiItemV2) obj;
        String str = this.f8464a;
        if (str == null) {
            if (poiItemV2.f8464a != null) {
                return false;
            }
        } else if (!str.equals(poiItemV2.f8464a)) {
            return false;
        }
        return true;
    }

    public String getAdCode() {
        return this.f8465b;
    }

    public String getAdName() {
        return this.f8474k;
    }

    public Business getBusiness() {
        return this.f8477n;
    }

    public String getCityCode() {
        return this.f8466c;
    }

    public String getCityName() {
        return this.f8473j;
    }

    public IndoorDataV2 getIndoorData() {
        return this.f8478o;
    }

    public LatLonPoint getLatLonPoint() {
        return this.f8468e;
    }

    public List<Photo> getPhotos() {
        return this.f8480q;
    }

    public String getPoiId() {
        return this.f8464a;
    }

    public PoiNavi getPoiNavi() {
        return this.f8479p;
    }

    public String getProvinceCode() {
        return this.f8475l;
    }

    public String getProvinceName() {
        return this.f8472i;
    }

    public String getSnippet() {
        return this.f8470g;
    }

    public List<SubPoiItemV2> getSubPois() {
        return this.f8476m;
    }

    public String getTitle() {
        return this.f8469f;
    }

    public String getTypeCode() {
        return this.f8471h;
    }

    public String getTypeDes() {
        return this.f8467d;
    }

    public int hashCode() {
        String str = this.f8464a;
        return (str == null ? 0 : str.hashCode()) + 31;
    }

    public void setAdCode(String str) {
        this.f8465b = str;
    }

    public void setAdName(String str) {
        this.f8474k = str;
    }

    public void setBusiness(Business business) {
        this.f8477n = business;
    }

    public void setCityCode(String str) {
        this.f8466c = str;
    }

    public void setCityName(String str) {
        this.f8473j = str;
    }

    public void setIndoorData(IndoorDataV2 indoorDataV2) {
        this.f8478o = indoorDataV2;
    }

    public void setPhotos(List<Photo> list) {
        this.f8480q = list;
    }

    public void setPoiNavi(PoiNavi poiNavi) {
        this.f8479p = poiNavi;
    }

    public void setProvinceCode(String str) {
        this.f8475l = str;
    }

    public void setProvinceName(String str) {
        this.f8472i = str;
    }

    public void setSubPois(List<SubPoiItemV2> list) {
        this.f8476m = list;
    }

    public void setTypeCode(String str) {
        this.f8471h = str;
    }

    public void setTypeDes(String str) {
        this.f8467d = str;
    }

    public String toString() {
        return this.f8469f;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f8464a);
        parcel.writeString(this.f8465b);
        parcel.writeString(this.f8467d);
        parcel.writeValue(this.f8468e);
        parcel.writeString(this.f8469f);
        parcel.writeString(this.f8470g);
        parcel.writeString(this.f8466c);
        parcel.writeString(this.f8472i);
        parcel.writeString(this.f8473j);
        parcel.writeString(this.f8474k);
        parcel.writeString(this.f8475l);
        parcel.writeString(this.f8471h);
        parcel.writeList(this.f8476m);
        parcel.writeValue(this.f8477n);
        parcel.writeValue(this.f8478o);
        parcel.writeValue(this.f8479p);
        parcel.writeTypedList(this.f8480q);
    }

    public PoiItemV2(Parcel parcel) {
        this.f8467d = "";
        this.f8476m = new ArrayList();
        this.f8480q = new ArrayList();
        this.f8464a = parcel.readString();
        this.f8465b = parcel.readString();
        this.f8467d = parcel.readString();
        this.f8468e = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f8469f = parcel.readString();
        this.f8470g = parcel.readString();
        this.f8466c = parcel.readString();
        this.f8472i = parcel.readString();
        this.f8473j = parcel.readString();
        this.f8474k = parcel.readString();
        this.f8475l = parcel.readString();
        this.f8471h = parcel.readString();
        this.f8476m = parcel.readArrayList(SubPoiItemV2.class.getClassLoader());
        this.f8477n = (Business) parcel.readValue(Business.class.getClassLoader());
        this.f8478o = (IndoorDataV2) parcel.readValue(IndoorDataV2.class.getClassLoader());
        this.f8479p = (PoiNavi) parcel.readValue(PoiNavi.class.getClassLoader());
        this.f8480q = parcel.createTypedArrayList(Photo.CREATOR);
    }
}
