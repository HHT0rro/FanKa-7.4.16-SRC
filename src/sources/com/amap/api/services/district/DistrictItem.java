package com.amap.api.services.district;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class DistrictItem implements Parcelable {
    public static final Parcelable.Creator<DistrictItem> CREATOR = new Parcelable.Creator<DistrictItem>() { // from class: com.amap.api.services.district.DistrictItem.1
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
    private String f8490a;

    /* renamed from: b, reason: collision with root package name */
    private String f8491b;

    /* renamed from: c, reason: collision with root package name */
    private String f8492c;

    /* renamed from: d, reason: collision with root package name */
    private LatLonPoint f8493d;

    /* renamed from: e, reason: collision with root package name */
    private String f8494e;

    /* renamed from: f, reason: collision with root package name */
    private List<DistrictItem> f8495f;

    /* renamed from: g, reason: collision with root package name */
    private String[] f8496g;

    public DistrictItem() {
        this.f8495f = new ArrayList();
        this.f8496g = new String[0];
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String[] districtBoundary() {
        return this.f8496g;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || DistrictItem.class != obj.getClass()) {
            return false;
        }
        DistrictItem districtItem = (DistrictItem) obj;
        String str = this.f8491b;
        if (str == null) {
            if (districtItem.f8491b != null) {
                return false;
            }
        } else if (!str.equals(districtItem.f8491b)) {
            return false;
        }
        LatLonPoint latLonPoint = this.f8493d;
        if (latLonPoint == null) {
            if (districtItem.f8493d != null) {
                return false;
            }
        } else if (!latLonPoint.equals(districtItem.f8493d)) {
            return false;
        }
        String str2 = this.f8490a;
        if (str2 == null) {
            if (districtItem.f8490a != null) {
                return false;
            }
        } else if (!str2.equals(districtItem.f8490a)) {
            return false;
        }
        if (!Arrays.equals(this.f8496g, districtItem.f8496g)) {
            return false;
        }
        List<DistrictItem> list = this.f8495f;
        if (list == null) {
            if (districtItem.f8495f != null) {
                return false;
            }
        } else if (!list.equals(districtItem.f8495f)) {
            return false;
        }
        String str3 = this.f8494e;
        if (str3 == null) {
            if (districtItem.f8494e != null) {
                return false;
            }
        } else if (!str3.equals(districtItem.f8494e)) {
            return false;
        }
        String str4 = this.f8492c;
        if (str4 == null) {
            if (districtItem.f8492c != null) {
                return false;
            }
        } else if (!str4.equals(districtItem.f8492c)) {
            return false;
        }
        return true;
    }

    public final String getAdcode() {
        return this.f8491b;
    }

    public final LatLonPoint getCenter() {
        return this.f8493d;
    }

    public final String getCitycode() {
        return this.f8490a;
    }

    public final String getLevel() {
        return this.f8494e;
    }

    public final String getName() {
        return this.f8492c;
    }

    public final List<DistrictItem> getSubDistrict() {
        return this.f8495f;
    }

    public final int hashCode() {
        String str = this.f8491b;
        int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        LatLonPoint latLonPoint = this.f8493d;
        int hashCode2 = (hashCode + (latLonPoint == null ? 0 : latLonPoint.hashCode())) * 31;
        String str2 = this.f8490a;
        int hashCode3 = (((hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + Arrays.hashCode(this.f8496g)) * 31;
        List<DistrictItem> list = this.f8495f;
        int hashCode4 = (hashCode3 + (list == null ? 0 : list.hashCode())) * 31;
        String str3 = this.f8494e;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.f8492c;
        return hashCode5 + (str4 != null ? str4.hashCode() : 0);
    }

    public final void setAdcode(String str) {
        this.f8491b = str;
    }

    public final void setCenter(LatLonPoint latLonPoint) {
        this.f8493d = latLonPoint;
    }

    public final void setCitycode(String str) {
        this.f8490a = str;
    }

    public final void setDistrictBoundary(String[] strArr) {
        this.f8496g = strArr;
    }

    public final void setLevel(String str) {
        this.f8494e = str;
    }

    public final void setName(String str) {
        this.f8492c = str;
    }

    public final void setSubDistrict(ArrayList<DistrictItem> arrayList) {
        this.f8495f = arrayList;
    }

    public final String toString() {
        return "DistrictItem [mCitycode=" + this.f8490a + ", mAdcode=" + this.f8491b + ", mName=" + this.f8492c + ", mCenter=" + ((Object) this.f8493d) + ", mLevel=" + this.f8494e + ", mDistricts=" + ((Object) this.f8495f) + "]";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f8490a);
        parcel.writeString(this.f8491b);
        parcel.writeString(this.f8492c);
        parcel.writeParcelable(this.f8493d, i10);
        parcel.writeString(this.f8494e);
        parcel.writeTypedList(this.f8495f);
        parcel.writeInt(this.f8496g.length);
        parcel.writeStringArray(this.f8496g);
    }

    public DistrictItem(String str, String str2, String str3, LatLonPoint latLonPoint, String str4) {
        this.f8495f = new ArrayList();
        this.f8496g = new String[0];
        this.f8492c = str;
        this.f8490a = str2;
        this.f8491b = str3;
        this.f8493d = latLonPoint;
        this.f8494e = str4;
    }

    public DistrictItem(Parcel parcel) {
        this.f8495f = new ArrayList();
        this.f8496g = new String[0];
        this.f8490a = parcel.readString();
        this.f8491b = parcel.readString();
        this.f8492c = parcel.readString();
        this.f8493d = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f8494e = parcel.readString();
        this.f8495f = parcel.createTypedArrayList(CREATOR);
        String[] strArr = new String[parcel.readInt()];
        this.f8496g = strArr;
        parcel.readStringArray(strArr);
    }
}
