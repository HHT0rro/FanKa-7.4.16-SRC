package com.amap.api.services.route;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.col.s.bj;
import com.amap.api.col.s.n;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.interfaces.IDistanceSearch;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class DistanceSearch {
    public static final String EXTENSIONS_ALL = "all";
    public static final String EXTENSIONS_BASE = "base";
    public static final int TYPE_DISTANCE = 0;
    public static final int TYPE_DRIVING_DISTANCE = 1;
    public static final int TYPE_WALK_DISTANCE = 3;

    /* renamed from: a, reason: collision with root package name */
    private IDistanceSearch f8765a;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class DistanceQuery implements Parcelable, Cloneable {
        public static final Parcelable.Creator<DistanceQuery> CREATOR = new Parcelable.Creator<DistanceQuery>() { // from class: com.amap.api.services.route.DistanceSearch.DistanceQuery.1
            private static DistanceQuery a(Parcel parcel) {
                return new DistanceQuery(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ DistanceQuery createFromParcel(Parcel parcel) {
                return a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ DistanceQuery[] newArray(int i10) {
                return a(i10);
            }

            private static DistanceQuery[] a(int i10) {
                return new DistanceQuery[i10];
            }
        };

        /* renamed from: a, reason: collision with root package name */
        private int f8766a;

        /* renamed from: b, reason: collision with root package name */
        private List<LatLonPoint> f8767b;

        /* renamed from: c, reason: collision with root package name */
        private LatLonPoint f8768c;

        /* renamed from: d, reason: collision with root package name */
        private String f8769d;

        /* renamed from: e, reason: collision with root package name */
        private int f8770e;

        public DistanceQuery() {
            this.f8766a = 1;
            this.f8767b = new ArrayList();
            this.f8769d = "base";
            this.f8770e = 4;
        }

        public void addOrigins(LatLonPoint... latLonPointArr) {
            for (LatLonPoint latLonPoint : latLonPointArr) {
                if (latLonPoint != null) {
                    this.f8767b.add(latLonPoint);
                }
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public LatLonPoint getDestination() {
            return this.f8768c;
        }

        public String getExtensions() {
            return this.f8769d;
        }

        public int getMode() {
            return this.f8770e;
        }

        public List<LatLonPoint> getOrigins() {
            return this.f8767b;
        }

        public int getType() {
            return this.f8766a;
        }

        public void setDestination(LatLonPoint latLonPoint) {
            this.f8768c = latLonPoint;
        }

        public void setExtensions(String str) {
            this.f8769d = str;
        }

        public void setMode(int i10) {
            this.f8770e = i10;
        }

        public void setOrigins(List<LatLonPoint> list) {
            if (list != null) {
                this.f8767b = list;
            }
        }

        public void setType(int i10) {
            this.f8766a = i10;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeInt(this.f8766a);
            parcel.writeTypedList(this.f8767b);
            parcel.writeParcelable(this.f8768c, i10);
            parcel.writeString(this.f8769d);
            parcel.writeInt(this.f8770e);
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public DistanceQuery m1981clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e2) {
                n.a(e2, "DistanceSearch", "DistanceQueryclone");
            }
            DistanceQuery distanceQuery = new DistanceQuery();
            distanceQuery.setType(this.f8766a);
            distanceQuery.setOrigins(this.f8767b);
            distanceQuery.setDestination(this.f8768c);
            distanceQuery.setExtensions(this.f8769d);
            distanceQuery.setMode(this.f8770e);
            return distanceQuery;
        }

        public DistanceQuery(Parcel parcel) {
            this.f8766a = 1;
            this.f8767b = new ArrayList();
            this.f8769d = "base";
            this.f8770e = 4;
            this.f8766a = parcel.readInt();
            this.f8767b = parcel.createTypedArrayList(LatLonPoint.CREATOR);
            this.f8768c = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
            this.f8769d = parcel.readString();
            this.f8770e = parcel.readInt();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface OnDistanceSearchListener {
        void onDistanceSearched(DistanceResult distanceResult, int i10);
    }

    public DistanceSearch(Context context) throws AMapException {
        if (this.f8765a == null) {
            try {
                this.f8765a = new bj(context);
            } catch (Exception e2) {
                e2.printStackTrace();
                if (e2 instanceof AMapException) {
                    throw ((AMapException) e2);
                }
            }
        }
    }

    public DistanceResult calculateRouteDistance(DistanceQuery distanceQuery) throws AMapException {
        IDistanceSearch iDistanceSearch = this.f8765a;
        if (iDistanceSearch != null) {
            return iDistanceSearch.calculateRouteDistance(distanceQuery);
        }
        return null;
    }

    public void calculateRouteDistanceAsyn(DistanceQuery distanceQuery) {
        IDistanceSearch iDistanceSearch = this.f8765a;
        if (iDistanceSearch != null) {
            iDistanceSearch.calculateRouteDistanceAsyn(distanceQuery);
        }
    }

    public void setDistanceSearchListener(OnDistanceSearchListener onDistanceSearchListener) {
        IDistanceSearch iDistanceSearch = this.f8765a;
        if (iDistanceSearch != null) {
            iDistanceSearch.setDistanceSearchListener(onDistanceSearchListener);
        }
    }
}
