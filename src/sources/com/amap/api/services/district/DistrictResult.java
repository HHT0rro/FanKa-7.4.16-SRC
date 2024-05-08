package com.amap.api.services.district;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.AMapException;
import java.util.ArrayList;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class DistrictResult implements Parcelable {
    public Parcelable.Creator<DistrictResult> CREATOR;

    /* renamed from: a, reason: collision with root package name */
    private DistrictSearchQuery f8497a;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<DistrictItem> f8498b;

    /* renamed from: c, reason: collision with root package name */
    private int f8499c;

    /* renamed from: d, reason: collision with root package name */
    private AMapException f8500d;

    public DistrictResult(DistrictSearchQuery districtSearchQuery, ArrayList<DistrictItem> arrayList) {
        this.f8498b = new ArrayList<>();
        this.CREATOR = new Parcelable.Creator<DistrictResult>() { // from class: com.amap.api.services.district.DistrictResult.1
            private static DistrictResult a(Parcel parcel) {
                return new DistrictResult(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ DistrictResult createFromParcel(Parcel parcel) {
                return a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ DistrictResult[] newArray(int i10) {
                return a(i10);
            }

            private static DistrictResult[] a(int i10) {
                return new DistrictResult[i10];
            }
        };
        this.f8497a = districtSearchQuery;
        this.f8498b = arrayList;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || DistrictResult.class != obj.getClass()) {
            return false;
        }
        DistrictResult districtResult = (DistrictResult) obj;
        DistrictSearchQuery districtSearchQuery = this.f8497a;
        if (districtSearchQuery == null) {
            if (districtResult.f8497a != null) {
                return false;
            }
        } else if (!districtSearchQuery.equals(districtResult.f8497a)) {
            return false;
        }
        ArrayList<DistrictItem> arrayList = this.f8498b;
        if (arrayList == null) {
            if (districtResult.f8498b != null) {
                return false;
            }
        } else if (!arrayList.equals(districtResult.f8498b)) {
            return false;
        }
        return true;
    }

    public final AMapException getAMapException() {
        return this.f8500d;
    }

    public final ArrayList<DistrictItem> getDistrict() {
        return this.f8498b;
    }

    public final int getPageCount() {
        return this.f8499c;
    }

    public final DistrictSearchQuery getQuery() {
        return this.f8497a;
    }

    public final int hashCode() {
        DistrictSearchQuery districtSearchQuery = this.f8497a;
        int hashCode = ((districtSearchQuery == null ? 0 : districtSearchQuery.hashCode()) + 31) * 31;
        ArrayList<DistrictItem> arrayList = this.f8498b;
        return hashCode + (arrayList != null ? arrayList.hashCode() : 0);
    }

    public final void setAMapException(AMapException aMapException) {
        this.f8500d = aMapException;
    }

    public final void setDistrict(ArrayList<DistrictItem> arrayList) {
        this.f8498b = arrayList;
    }

    public final void setPageCount(int i10) {
        this.f8499c = i10;
    }

    public final void setQuery(DistrictSearchQuery districtSearchQuery) {
        this.f8497a = districtSearchQuery;
    }

    public final String toString() {
        return "DistrictResult [mDisQuery=" + ((Object) this.f8497a) + ", mDistricts=" + ((Object) this.f8498b) + "]";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable(this.f8497a, i10);
        parcel.writeTypedList(this.f8498b);
    }

    public DistrictResult() {
        this.f8498b = new ArrayList<>();
        this.CREATOR = new Parcelable.Creator<DistrictResult>() { // from class: com.amap.api.services.district.DistrictResult.1
            private static DistrictResult a(Parcel parcel) {
                return new DistrictResult(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ DistrictResult createFromParcel(Parcel parcel) {
                return a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ DistrictResult[] newArray(int i10) {
                return a(i10);
            }

            private static DistrictResult[] a(int i10) {
                return new DistrictResult[i10];
            }
        };
    }

    public DistrictResult(Parcel parcel) {
        this.f8498b = new ArrayList<>();
        this.CREATOR = new Parcelable.Creator<DistrictResult>() { // from class: com.amap.api.services.district.DistrictResult.1
            private static DistrictResult a(Parcel parcel2) {
                return new DistrictResult(parcel2);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ DistrictResult createFromParcel(Parcel parcel2) {
                return a(parcel2);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ DistrictResult[] newArray(int i10) {
                return a(i10);
            }

            private static DistrictResult[] a(int i10) {
                return new DistrictResult[i10];
            }
        };
        this.f8497a = (DistrictSearchQuery) parcel.readParcelable(DistrictSearchQuery.class.getClassLoader());
        this.f8498b = parcel.createTypedArrayList(DistrictItem.CREATOR);
    }
}
