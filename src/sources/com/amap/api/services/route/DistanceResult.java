package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.route.DistanceSearch;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class DistanceResult implements Parcelable {
    public static final Parcelable.Creator<DistanceResult> CREATOR = new Parcelable.Creator<DistanceResult>() { // from class: com.amap.api.services.route.DistanceResult.1
        private static DistanceResult a(Parcel parcel) {
            return new DistanceResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DistanceResult createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DistanceResult[] newArray(int i10) {
            return a(i10);
        }

        private static DistanceResult[] a(int i10) {
            return new DistanceResult[i10];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private DistanceSearch.DistanceQuery f8763a;

    /* renamed from: b, reason: collision with root package name */
    private List<DistanceItem> f8764b;

    public DistanceResult() {
        this.f8764b = null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public DistanceSearch.DistanceQuery getDistanceQuery() {
        return this.f8763a;
    }

    public List<DistanceItem> getDistanceResults() {
        return this.f8764b;
    }

    public void setDistanceQuery(DistanceSearch.DistanceQuery distanceQuery) {
        this.f8763a = distanceQuery;
    }

    public void setDistanceResults(List<DistanceItem> list) {
        this.f8764b = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeTypedList(this.f8764b);
    }

    public DistanceResult(Parcel parcel) {
        this.f8764b = null;
        this.f8764b = parcel.createTypedArrayList(DistanceItem.CREATOR);
    }
}
