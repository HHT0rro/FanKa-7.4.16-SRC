package com.amap.api.services.cloud;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class CloudItem implements Parcelable {
    public static final Parcelable.Creator<CloudItem> CREATOR = new Parcelable.Creator<CloudItem>() { // from class: com.amap.api.services.cloud.CloudItem.1
        private static CloudItem a(Parcel parcel) {
            return new CloudItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ CloudItem createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ CloudItem[] newArray(int i10) {
            return a(i10);
        }

        private static CloudItem[] a(int i10) {
            return new CloudItem[i10];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private String f8400a;

    /* renamed from: b, reason: collision with root package name */
    private int f8401b;

    /* renamed from: c, reason: collision with root package name */
    private String f8402c;

    /* renamed from: d, reason: collision with root package name */
    private String f8403d;

    /* renamed from: e, reason: collision with root package name */
    private HashMap<String, String> f8404e;

    /* renamed from: f, reason: collision with root package name */
    private List<CloudImage> f8405f;
    public final LatLonPoint mPoint;
    public final String mSnippet;
    public final String mTitle;

    public CloudItem(String str, LatLonPoint latLonPoint, String str2, String str3) {
        this.f8401b = -1;
        this.f8400a = str;
        this.mPoint = latLonPoint;
        this.mTitle = str2;
        this.mSnippet = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CloudItem)) {
            return false;
        }
        CloudItem cloudItem = (CloudItem) obj;
        String str = this.f8400a;
        if (str == null) {
            if (cloudItem.f8400a != null) {
                return false;
            }
        } else if (!str.equals(cloudItem.f8400a)) {
            return false;
        }
        return true;
    }

    public List<CloudImage> getCloudImage() {
        return this.f8405f;
    }

    public String getCreatetime() {
        return this.f8402c;
    }

    public HashMap<String, String> getCustomfield() {
        return this.f8404e;
    }

    public int getDistance() {
        return this.f8401b;
    }

    public String getID() {
        return this.f8400a;
    }

    public LatLonPoint getLatLonPoint() {
        return this.mPoint;
    }

    public String getSnippet() {
        return this.mSnippet;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String getUpdatetime() {
        return this.f8403d;
    }

    public int hashCode() {
        String str = this.f8400a;
        return (str == null ? 0 : str.hashCode()) + 31;
    }

    public void setCreatetime(String str) {
        this.f8402c = str;
    }

    public void setCustomfield(HashMap<String, String> hashMap) {
        this.f8404e = hashMap;
    }

    public void setDistance(int i10) {
        this.f8401b = i10;
    }

    public void setUpdatetime(String str) {
        this.f8403d = str;
    }

    public void setmCloudImage(List<CloudImage> list) {
        this.f8405f = list;
    }

    public String toString() {
        return this.mTitle;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f8400a);
        parcel.writeInt(this.f8401b);
        parcel.writeValue(this.mPoint);
        parcel.writeString(this.mTitle);
        parcel.writeString(this.mSnippet);
        parcel.writeString(this.f8402c);
        parcel.writeString(this.f8403d);
        parcel.writeMap(this.f8404e);
        parcel.writeList(this.f8405f);
    }

    public CloudItem(Parcel parcel) {
        this.f8401b = -1;
        this.f8400a = parcel.readString();
        this.f8401b = parcel.readInt();
        this.mPoint = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.mTitle = parcel.readString();
        this.mSnippet = parcel.readString();
        this.f8402c = parcel.readString();
        this.f8403d = parcel.readString();
        HashMap<String, String> hashMap = new HashMap<>();
        this.f8404e = hashMap;
        parcel.readMap(hashMap, HashMap.class.getClassLoader());
        List arrayList = new ArrayList();
        this.f8405f = arrayList;
        parcel.readList(arrayList, getClass().getClassLoader());
    }
}
