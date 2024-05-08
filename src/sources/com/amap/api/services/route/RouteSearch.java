package com.amap.api.services.route;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.col.s.br;
import com.amap.api.col.s.n;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.interfaces.IRouteSearch;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class RouteSearch {
    public static final int BUS_COMFORTABLE = 4;
    public static final int BUS_DEFAULT = 0;
    public static final int BUS_LEASE_CHANGE = 2;
    public static final int BUS_LEASE_WALK = 3;
    public static final int BUS_NO_SUBWAY = 5;
    public static final int BUS_SAVE_MONEY = 1;
    public static final int BusComfortable = 4;
    public static final int BusDefault = 0;
    public static final int BusLeaseChange = 2;
    public static final int BusLeaseWalk = 3;
    public static final int BusNoSubway = 5;
    public static final int BusSaveMoney = 1;
    public static final int DRIVEING_PLAN_AVOID_CONGESTION_CHOICE_HIGHWAY = 9;
    public static final int DRIVEING_PLAN_AVOID_CONGESTION_FASTEST_SAVE_MONEY = 11;
    public static final int DRIVEING_PLAN_AVOID_CONGESTION_NO_HIGHWAY = 4;
    public static final int DRIVEING_PLAN_AVOID_CONGESTION_SAVE_MONEY = 6;
    public static final int DRIVEING_PLAN_AVOID_CONGESTION_SAVE_MONEY_NO_HIGHWAY = 7;
    public static final int DRIVEING_PLAN_CHOICE_HIGHWAY = 8;
    public static final int DRIVEING_PLAN_DEFAULT = 1;
    public static final int DRIVEING_PLAN_FASTEST_SHORTEST = 10;
    public static final int DRIVEING_PLAN_NO_HIGHWAY = 2;
    public static final int DRIVEING_PLAN_SAVE_MONEY = 3;
    public static final int DRIVEING_PLAN_SAVE_MONEY_NO_HIGHWAY = 5;
    public static final String DRIVING_EXCLUDE_FERRY = "ferry";
    public static final String DRIVING_EXCLUDE_MOTORWAY = "motorway";
    public static final String DRIVING_EXCLUDE_TOLL = "toll";
    public static final int DRIVING_MULTI_CHOICE_AVOID_CONGESTION = 12;
    public static final int DRIVING_MULTI_CHOICE_AVOID_CONGESTION_NO_HIGHWAY = 15;
    public static final int DRIVING_MULTI_CHOICE_AVOID_CONGESTION_NO_HIGHWAY_SAVE_MONEY = 18;
    public static final int DRIVING_MULTI_CHOICE_AVOID_CONGESTION_SAVE_MONEY = 17;
    public static final int DRIVING_MULTI_CHOICE_HIGHWAY = 19;
    public static final int DRIVING_MULTI_CHOICE_HIGHWAY_AVOID_CONGESTION = 20;
    public static final int DRIVING_MULTI_CHOICE_NO_HIGHWAY = 13;
    public static final int DRIVING_MULTI_CHOICE_SAVE_MONEY = 14;
    public static final int DRIVING_MULTI_CHOICE_SAVE_MONEY_NO_HIGHWAY = 16;
    public static final int DRIVING_MULTI_STRATEGY_FASTEST_SAVE_MONEY_SHORTEST = 5;
    public static final int DRIVING_MULTI_STRATEGY_FASTEST_SHORTEST = 11;
    public static final int DRIVING_MULTI_STRATEGY_FASTEST_SHORTEST_AVOID_CONGESTION = 10;
    public static final int DRIVING_NORMAL_CAR = 0;
    public static final int DRIVING_PLUGIN_HYBRID_CAR = 2;
    public static final int DRIVING_PURE_ELECTRIC_VEHICLE = 1;
    public static final int DRIVING_SINGLE_AVOID_CONGESTION = 4;
    public static final int DRIVING_SINGLE_DEFAULT = 0;
    public static final int DRIVING_SINGLE_NO_EXPRESSWAYS = 3;
    public static final int DRIVING_SINGLE_NO_HIGHWAY = 6;
    public static final int DRIVING_SINGLE_NO_HIGHWAY_SAVE_MONEY = 7;
    public static final int DRIVING_SINGLE_NO_HIGHWAY_SAVE_MONEY_AVOID_CONGESTION = 9;
    public static final int DRIVING_SINGLE_SAVE_MONEY = 1;
    public static final int DRIVING_SINGLE_SAVE_MONEY_AVOID_CONGESTION = 8;
    public static final int DRIVING_SINGLE_SHORTEST = 2;
    public static final int DrivingAvoidCongestion = 4;
    public static final int DrivingDefault = 0;
    public static final int DrivingMultiStrategy = 5;
    public static final int DrivingNoExpressways = 3;
    public static final int DrivingNoHighAvoidCongestionSaveMoney = 9;
    public static final int DrivingNoHighWay = 6;
    public static final int DrivingNoHighWaySaveMoney = 7;
    public static final int DrivingSaveMoney = 1;
    public static final int DrivingSaveMoneyAvoidCongestion = 8;
    public static final int DrivingShortDistance = 2;
    public static final String EXTENSIONS_ALL = "all";
    public static final String EXTENSIONS_BASE = "base";
    public static final int RIDING_DEFAULT = 0;
    public static final int RIDING_FAST = 2;
    public static final int RIDING_RECOMMEND = 1;
    public static final int RidingDefault = 0;
    public static final int RidingFast = 2;
    public static final int RidingRecommend = 1;
    public static final int TRUCK_AVOID_CONGESTION = 1;
    public static final int TRUCK_AVOID_CONGESTION_CHOICE_HIGHWAY = 9;
    public static final int TRUCK_AVOID_CONGESTION_NO_HIGHWAY = 4;
    public static final int TRUCK_AVOID_CONGESTION__SAVE_MONEY = 6;
    public static final int TRUCK_AVOID_CONGESTION__SAVE_MONEY_NO_HIGHWAY = 7;
    public static final int TRUCK_CHOICE_HIGHWAY = 8;
    public static final int TRUCK_NO_HIGHWAY = 2;
    public static final int TRUCK_SAVE_MONEY = 3;
    public static final int TRUCK_SAVE_MONEY_NO_HIGHWAY = 5;
    public static final int TRUCK_SIZE_HEAVY = 4;
    public static final int TRUCK_SIZE_LIGHT = 2;
    public static final int TRUCK_SIZE_MEDIUM = 3;
    public static final int TRUCK_SIZE_MINI = 1;
    public static final int WALK_DEFAULT = 0;
    public static final int WALK_MULTI_PATH = 1;
    public static final int WalkDefault = 0;
    public static final int WalkMultipath = 1;

    /* renamed from: a, reason: collision with root package name */
    private IRouteSearch f8883a;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class BusRouteQuery implements Parcelable, Cloneable {
        public static final Parcelable.Creator<BusRouteQuery> CREATOR = new Parcelable.Creator<BusRouteQuery>() { // from class: com.amap.api.services.route.RouteSearch.BusRouteQuery.1
            private static BusRouteQuery a(Parcel parcel) {
                return new BusRouteQuery(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ BusRouteQuery createFromParcel(Parcel parcel) {
                return a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ BusRouteQuery[] newArray(int i10) {
                return a(i10);
            }

            private static BusRouteQuery[] a(int i10) {
                return new BusRouteQuery[i10];
            }
        };

        /* renamed from: a, reason: collision with root package name */
        private FromAndTo f8884a;

        /* renamed from: b, reason: collision with root package name */
        private int f8885b;

        /* renamed from: c, reason: collision with root package name */
        private String f8886c;

        /* renamed from: d, reason: collision with root package name */
        private String f8887d;

        /* renamed from: e, reason: collision with root package name */
        private int f8888e;

        /* renamed from: f, reason: collision with root package name */
        private String f8889f;

        public BusRouteQuery(FromAndTo fromAndTo, int i10, String str, int i11) {
            this.f8889f = "base";
            this.f8884a = fromAndTo;
            this.f8885b = i10;
            this.f8886c = str;
            this.f8888e = i11;
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
            BusRouteQuery busRouteQuery = (BusRouteQuery) obj;
            String str = this.f8886c;
            if (str == null) {
                if (busRouteQuery.f8886c != null) {
                    return false;
                }
            } else if (!str.equals(busRouteQuery.f8886c)) {
                return false;
            }
            String str2 = this.f8887d;
            if (str2 == null) {
                if (busRouteQuery.f8887d != null) {
                    return false;
                }
            } else if (!str2.equals(busRouteQuery.f8887d)) {
                return false;
            }
            String str3 = this.f8889f;
            if (str3 == null) {
                if (busRouteQuery.f8889f != null) {
                    return false;
                }
            } else if (!str3.equals(busRouteQuery.f8889f)) {
                return false;
            }
            FromAndTo fromAndTo = this.f8884a;
            if (fromAndTo == null) {
                if (busRouteQuery.f8884a != null) {
                    return false;
                }
            } else if (!fromAndTo.equals(busRouteQuery.f8884a)) {
                return false;
            }
            return this.f8885b == busRouteQuery.f8885b && this.f8888e == busRouteQuery.f8888e;
        }

        public String getCity() {
            return this.f8886c;
        }

        public String getCityd() {
            return this.f8887d;
        }

        public String getExtensions() {
            return this.f8889f;
        }

        public FromAndTo getFromAndTo() {
            return this.f8884a;
        }

        public int getMode() {
            return this.f8885b;
        }

        public int getNightFlag() {
            return this.f8888e;
        }

        public int hashCode() {
            String str = this.f8886c;
            int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
            FromAndTo fromAndTo = this.f8884a;
            int hashCode2 = (((((hashCode + (fromAndTo == null ? 0 : fromAndTo.hashCode())) * 31) + this.f8885b) * 31) + this.f8888e) * 31;
            String str2 = this.f8887d;
            return hashCode2 + (str2 != null ? str2.hashCode() : 0);
        }

        public void setCityd(String str) {
            this.f8887d = str;
        }

        public void setExtensions(String str) {
            this.f8889f = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeParcelable(this.f8884a, i10);
            parcel.writeInt(this.f8885b);
            parcel.writeString(this.f8886c);
            parcel.writeInt(this.f8888e);
            parcel.writeString(this.f8887d);
            parcel.writeString(this.f8889f);
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public BusRouteQuery m1982clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e2) {
                n.a(e2, "RouteSearch", "BusRouteQueryclone");
            }
            BusRouteQuery busRouteQuery = new BusRouteQuery(this.f8884a, this.f8885b, this.f8886c, this.f8888e);
            busRouteQuery.setCityd(this.f8887d);
            busRouteQuery.setExtensions(this.f8889f);
            return busRouteQuery;
        }

        public BusRouteQuery(Parcel parcel) {
            this.f8889f = "base";
            this.f8884a = (FromAndTo) parcel.readParcelable(FromAndTo.class.getClassLoader());
            this.f8885b = parcel.readInt();
            this.f8886c = parcel.readString();
            this.f8888e = parcel.readInt();
            this.f8887d = parcel.readString();
            this.f8889f = parcel.readString();
        }

        public BusRouteQuery() {
            this.f8889f = "base";
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class DrivePlanQuery implements Parcelable, Cloneable {
        public static final Parcelable.Creator<DrivePlanQuery> CREATOR = new Parcelable.Creator<DrivePlanQuery>() { // from class: com.amap.api.services.route.RouteSearch.DrivePlanQuery.1
            private static DrivePlanQuery a(Parcel parcel) {
                return new DrivePlanQuery(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ DrivePlanQuery createFromParcel(Parcel parcel) {
                return a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ DrivePlanQuery[] newArray(int i10) {
                return a(i10);
            }

            private static DrivePlanQuery[] a(int i10) {
                return new DrivePlanQuery[i10];
            }
        };

        /* renamed from: a, reason: collision with root package name */
        private FromAndTo f8890a;

        /* renamed from: b, reason: collision with root package name */
        private String f8891b;

        /* renamed from: c, reason: collision with root package name */
        private int f8892c;

        /* renamed from: d, reason: collision with root package name */
        private int f8893d;

        /* renamed from: e, reason: collision with root package name */
        private int f8894e;

        /* renamed from: f, reason: collision with root package name */
        private int f8895f;

        /* renamed from: g, reason: collision with root package name */
        private int f8896g;

        public DrivePlanQuery(FromAndTo fromAndTo, int i10, int i11, int i12) {
            this.f8892c = 1;
            this.f8893d = 0;
            this.f8890a = fromAndTo;
            this.f8894e = i10;
            this.f8895f = i11;
            this.f8896g = i12;
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
            DrivePlanQuery drivePlanQuery = (DrivePlanQuery) obj;
            FromAndTo fromAndTo = this.f8890a;
            if (fromAndTo == null) {
                if (drivePlanQuery.f8890a != null) {
                    return false;
                }
            } else if (!fromAndTo.equals(drivePlanQuery.f8890a)) {
                return false;
            }
            String str = this.f8891b;
            if (str == null) {
                if (drivePlanQuery.f8891b != null) {
                    return false;
                }
            } else if (!str.equals(drivePlanQuery.f8891b)) {
                return false;
            }
            return this.f8892c == drivePlanQuery.f8892c && this.f8893d == drivePlanQuery.f8893d && this.f8894e == drivePlanQuery.f8894e && this.f8895f == drivePlanQuery.f8895f && this.f8896g == drivePlanQuery.f8896g;
        }

        public int getCarType() {
            return this.f8893d;
        }

        public int getCount() {
            return this.f8896g;
        }

        public String getDestParentPoiID() {
            return this.f8891b;
        }

        public int getFirstTime() {
            return this.f8894e;
        }

        public FromAndTo getFromAndTo() {
            return this.f8890a;
        }

        public int getInterval() {
            return this.f8895f;
        }

        public int getMode() {
            return this.f8892c;
        }

        public int hashCode() {
            FromAndTo fromAndTo = this.f8890a;
            int hashCode = ((fromAndTo == null ? 0 : fromAndTo.hashCode()) + 31) * 31;
            String str = this.f8891b;
            return ((((((((((hashCode + (str != null ? str.hashCode() : 0)) * 31) + this.f8892c) * 31) + this.f8893d) * 31) + this.f8894e) * 31) + this.f8895f) * 31) + this.f8896g;
        }

        public void setCarType(int i10) {
            this.f8893d = i10;
        }

        public void setDestParentPoiID(String str) {
            this.f8891b = str;
        }

        public void setMode(int i10) {
            this.f8892c = i10;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeParcelable(this.f8890a, i10);
            parcel.writeString(this.f8891b);
            parcel.writeInt(this.f8892c);
            parcel.writeInt(this.f8893d);
            parcel.writeInt(this.f8894e);
            parcel.writeInt(this.f8895f);
            parcel.writeInt(this.f8896g);
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public DrivePlanQuery m1983clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e2) {
                n.a(e2, "RouteSearch", "DriveRouteQueryclone");
            }
            DrivePlanQuery drivePlanQuery = new DrivePlanQuery(this.f8890a, this.f8894e, this.f8895f, this.f8896g);
            drivePlanQuery.setDestParentPoiID(this.f8891b);
            drivePlanQuery.setMode(this.f8892c);
            drivePlanQuery.setCarType(this.f8893d);
            return drivePlanQuery;
        }

        public DrivePlanQuery() {
            this.f8892c = 1;
            this.f8893d = 0;
            this.f8894e = 0;
            this.f8895f = 0;
            this.f8896g = 48;
        }

        public DrivePlanQuery(Parcel parcel) {
            this.f8892c = 1;
            this.f8893d = 0;
            this.f8894e = 0;
            this.f8895f = 0;
            this.f8896g = 48;
            this.f8890a = (FromAndTo) parcel.readParcelable(FromAndTo.class.getClassLoader());
            this.f8891b = parcel.readString();
            this.f8892c = parcel.readInt();
            this.f8893d = parcel.readInt();
            this.f8894e = parcel.readInt();
            this.f8895f = parcel.readInt();
            this.f8896g = parcel.readInt();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class DriveRouteQuery implements Parcelable, Cloneable {
        public static final Parcelable.Creator<DriveRouteQuery> CREATOR = new Parcelable.Creator<DriveRouteQuery>() { // from class: com.amap.api.services.route.RouteSearch.DriveRouteQuery.1
            private static DriveRouteQuery a(Parcel parcel) {
                return new DriveRouteQuery(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ DriveRouteQuery createFromParcel(Parcel parcel) {
                return a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ DriveRouteQuery[] newArray(int i10) {
                return a(i10);
            }

            private static DriveRouteQuery[] a(int i10) {
                return new DriveRouteQuery[i10];
            }
        };

        /* renamed from: a, reason: collision with root package name */
        private FromAndTo f8897a;

        /* renamed from: b, reason: collision with root package name */
        private int f8898b;

        /* renamed from: c, reason: collision with root package name */
        private List<LatLonPoint> f8899c;

        /* renamed from: d, reason: collision with root package name */
        private List<List<LatLonPoint>> f8900d;

        /* renamed from: e, reason: collision with root package name */
        private String f8901e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f8902f;

        /* renamed from: g, reason: collision with root package name */
        private int f8903g;

        /* renamed from: h, reason: collision with root package name */
        private String f8904h;

        /* renamed from: i, reason: collision with root package name */
        private String f8905i;

        public DriveRouteQuery(FromAndTo fromAndTo, int i10, List<LatLonPoint> list, List<List<LatLonPoint>> list2, String str) {
            this.f8902f = true;
            this.f8903g = 0;
            this.f8904h = null;
            this.f8905i = "base";
            this.f8897a = fromAndTo;
            this.f8898b = i10;
            this.f8899c = list;
            this.f8900d = list2;
            this.f8901e = str;
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
            DriveRouteQuery driveRouteQuery = (DriveRouteQuery) obj;
            String str = this.f8901e;
            if (str == null) {
                if (driveRouteQuery.f8901e != null) {
                    return false;
                }
            } else if (!str.equals(driveRouteQuery.f8901e)) {
                return false;
            }
            List<List<LatLonPoint>> list = this.f8900d;
            if (list == null) {
                if (driveRouteQuery.f8900d != null) {
                    return false;
                }
            } else if (!list.equals(driveRouteQuery.f8900d)) {
                return false;
            }
            FromAndTo fromAndTo = this.f8897a;
            if (fromAndTo == null) {
                if (driveRouteQuery.f8897a != null) {
                    return false;
                }
            } else if (!fromAndTo.equals(driveRouteQuery.f8897a)) {
                return false;
            }
            if (this.f8898b != driveRouteQuery.f8898b) {
                return false;
            }
            List<LatLonPoint> list2 = this.f8899c;
            if (list2 == null) {
                if (driveRouteQuery.f8899c != null) {
                    return false;
                }
            } else if (!list2.equals(driveRouteQuery.f8899c) || this.f8902f != driveRouteQuery.isUseFerry() || this.f8903g != driveRouteQuery.f8903g) {
                return false;
            }
            String str2 = this.f8905i;
            if (str2 == null) {
                if (driveRouteQuery.f8905i != null) {
                    return false;
                }
            } else if (!str2.equals(driveRouteQuery.f8905i)) {
                return false;
            }
            return true;
        }

        public String getAvoidRoad() {
            return this.f8901e;
        }

        public List<List<LatLonPoint>> getAvoidpolygons() {
            return this.f8900d;
        }

        public String getAvoidpolygonsStr() {
            StringBuffer stringBuffer = new StringBuffer();
            List<List<LatLonPoint>> list = this.f8900d;
            if (list == null || list.size() == 0) {
                return null;
            }
            for (int i10 = 0; i10 < this.f8900d.size(); i10++) {
                List<LatLonPoint> list2 = this.f8900d.get(i10);
                for (int i11 = 0; i11 < list2.size(); i11++) {
                    LatLonPoint latLonPoint = list2.get(i11);
                    stringBuffer.append(latLonPoint.getLongitude());
                    stringBuffer.append(",");
                    stringBuffer.append(latLonPoint.getLatitude());
                    if (i11 < list2.size() - 1) {
                        stringBuffer.append(";");
                    }
                }
                if (i10 < this.f8900d.size() - 1) {
                    stringBuffer.append("|");
                }
            }
            return stringBuffer.toString();
        }

        public int getCarType() {
            return this.f8903g;
        }

        public String getExclude() {
            return this.f8904h;
        }

        public String getExtensions() {
            return this.f8905i;
        }

        public FromAndTo getFromAndTo() {
            return this.f8897a;
        }

        public int getMode() {
            return this.f8898b;
        }

        public List<LatLonPoint> getPassedByPoints() {
            return this.f8899c;
        }

        public String getPassedPointStr() {
            StringBuffer stringBuffer = new StringBuffer();
            List<LatLonPoint> list = this.f8899c;
            if (list == null || list.size() == 0) {
                return null;
            }
            for (int i10 = 0; i10 < this.f8899c.size(); i10++) {
                LatLonPoint latLonPoint = this.f8899c.get(i10);
                stringBuffer.append(latLonPoint.getLongitude());
                stringBuffer.append(",");
                stringBuffer.append(latLonPoint.getLatitude());
                if (i10 < this.f8899c.size() - 1) {
                    stringBuffer.append(";");
                }
            }
            return stringBuffer.toString();
        }

        public boolean hasAvoidRoad() {
            return !n.a(getAvoidRoad());
        }

        public boolean hasAvoidpolygons() {
            return !n.a(getAvoidpolygonsStr());
        }

        public boolean hasPassPoint() {
            return !n.a(getPassedPointStr());
        }

        public int hashCode() {
            String str = this.f8901e;
            int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
            List<List<LatLonPoint>> list = this.f8900d;
            int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
            FromAndTo fromAndTo = this.f8897a;
            int hashCode3 = (((hashCode2 + (fromAndTo == null ? 0 : fromAndTo.hashCode())) * 31) + this.f8898b) * 31;
            List<LatLonPoint> list2 = this.f8899c;
            return ((hashCode3 + (list2 != null ? list2.hashCode() : 0)) * 31) + this.f8903g;
        }

        public boolean isUseFerry() {
            return this.f8902f;
        }

        public void setCarType(int i10) {
            this.f8903g = i10;
        }

        public void setExclude(String str) {
            this.f8904h = str;
        }

        public void setExtensions(String str) {
            this.f8905i = str;
        }

        public void setUseFerry(boolean z10) {
            this.f8902f = z10;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeParcelable(this.f8897a, i10);
            parcel.writeInt(this.f8898b);
            parcel.writeTypedList(this.f8899c);
            List<List<LatLonPoint>> list = this.f8900d;
            if (list == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(list.size());
                Iterator<List<LatLonPoint>> iterator2 = this.f8900d.iterator2();
                while (iterator2.hasNext()) {
                    parcel.writeTypedList(iterator2.next());
                }
            }
            parcel.writeString(this.f8901e);
            parcel.writeInt(this.f8902f ? 1 : 0);
            parcel.writeInt(this.f8903g);
            parcel.writeString(this.f8904h);
            parcel.writeString(this.f8905i);
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public DriveRouteQuery m1984clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e2) {
                n.a(e2, "RouteSearch", "DriveRouteQueryclone");
            }
            DriveRouteQuery driveRouteQuery = new DriveRouteQuery(this.f8897a, this.f8898b, this.f8899c, this.f8900d, this.f8901e);
            driveRouteQuery.setUseFerry(this.f8902f);
            driveRouteQuery.setCarType(this.f8903g);
            driveRouteQuery.setExclude(this.f8904h);
            driveRouteQuery.setExtensions(this.f8905i);
            return driveRouteQuery;
        }

        public DriveRouteQuery(Parcel parcel) {
            this.f8902f = true;
            this.f8903g = 0;
            this.f8904h = null;
            this.f8905i = "base";
            this.f8897a = (FromAndTo) parcel.readParcelable(FromAndTo.class.getClassLoader());
            this.f8898b = parcel.readInt();
            this.f8899c = parcel.createTypedArrayList(LatLonPoint.CREATOR);
            int readInt = parcel.readInt();
            if (readInt == 0) {
                this.f8900d = null;
            } else {
                this.f8900d = new ArrayList();
            }
            for (int i10 = 0; i10 < readInt; i10++) {
                this.f8900d.add(parcel.createTypedArrayList(LatLonPoint.CREATOR));
            }
            this.f8901e = parcel.readString();
            this.f8902f = parcel.readInt() == 1;
            this.f8903g = parcel.readInt();
            this.f8904h = parcel.readString();
            this.f8905i = parcel.readString();
        }

        public DriveRouteQuery() {
            this.f8902f = true;
            this.f8903g = 0;
            this.f8904h = null;
            this.f8905i = "base";
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class FromAndTo implements Parcelable, Cloneable {
        public static final Parcelable.Creator<FromAndTo> CREATOR = new Parcelable.Creator<FromAndTo>() { // from class: com.amap.api.services.route.RouteSearch.FromAndTo.1
            private static FromAndTo a(Parcel parcel) {
                return new FromAndTo(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ FromAndTo createFromParcel(Parcel parcel) {
                return a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ FromAndTo[] newArray(int i10) {
                return a(i10);
            }

            private static FromAndTo[] a(int i10) {
                return new FromAndTo[i10];
            }
        };

        /* renamed from: a, reason: collision with root package name */
        private LatLonPoint f8906a;

        /* renamed from: b, reason: collision with root package name */
        private LatLonPoint f8907b;

        /* renamed from: c, reason: collision with root package name */
        private String f8908c;

        /* renamed from: d, reason: collision with root package name */
        private String f8909d;

        /* renamed from: e, reason: collision with root package name */
        private String f8910e;

        /* renamed from: f, reason: collision with root package name */
        private String f8911f;

        /* renamed from: g, reason: collision with root package name */
        private String f8912g;

        /* renamed from: h, reason: collision with root package name */
        private String f8913h;

        public FromAndTo(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
            this.f8906a = latLonPoint;
            this.f8907b = latLonPoint2;
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
            FromAndTo fromAndTo = (FromAndTo) obj;
            String str = this.f8909d;
            if (str == null) {
                if (fromAndTo.f8909d != null) {
                    return false;
                }
            } else if (!str.equals(fromAndTo.f8909d)) {
                return false;
            }
            LatLonPoint latLonPoint = this.f8906a;
            if (latLonPoint == null) {
                if (fromAndTo.f8906a != null) {
                    return false;
                }
            } else if (!latLonPoint.equals(fromAndTo.f8906a)) {
                return false;
            }
            String str2 = this.f8908c;
            if (str2 == null) {
                if (fromAndTo.f8908c != null) {
                    return false;
                }
            } else if (!str2.equals(fromAndTo.f8908c)) {
                return false;
            }
            LatLonPoint latLonPoint2 = this.f8907b;
            if (latLonPoint2 == null) {
                if (fromAndTo.f8907b != null) {
                    return false;
                }
            } else if (!latLonPoint2.equals(fromAndTo.f8907b)) {
                return false;
            }
            String str3 = this.f8910e;
            if (str3 == null) {
                if (fromAndTo.f8910e != null) {
                    return false;
                }
            } else if (!str3.equals(fromAndTo.f8910e)) {
                return false;
            }
            String str4 = this.f8911f;
            if (str4 == null) {
                if (fromAndTo.f8911f != null) {
                    return false;
                }
            } else if (!str4.equals(fromAndTo.f8911f)) {
                return false;
            }
            return true;
        }

        public String getDestinationPoiID() {
            return this.f8909d;
        }

        public String getDestinationType() {
            return this.f8911f;
        }

        public LatLonPoint getFrom() {
            return this.f8906a;
        }

        public String getOriginType() {
            return this.f8910e;
        }

        public String getPlateNumber() {
            return this.f8913h;
        }

        public String getPlateProvince() {
            return this.f8912g;
        }

        public String getStartPoiID() {
            return this.f8908c;
        }

        public LatLonPoint getTo() {
            return this.f8907b;
        }

        public int hashCode() {
            String str = this.f8909d;
            int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
            LatLonPoint latLonPoint = this.f8906a;
            int hashCode2 = (hashCode + (latLonPoint == null ? 0 : latLonPoint.hashCode())) * 31;
            String str2 = this.f8908c;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            LatLonPoint latLonPoint2 = this.f8907b;
            int hashCode4 = (hashCode3 + (latLonPoint2 == null ? 0 : latLonPoint2.hashCode())) * 31;
            String str3 = this.f8910e;
            int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.f8911f;
            return hashCode5 + (str4 != null ? str4.hashCode() : 0);
        }

        public void setDestinationPoiID(String str) {
            this.f8909d = str;
        }

        public void setDestinationType(String str) {
            this.f8911f = str;
        }

        public void setOriginType(String str) {
            this.f8910e = str;
        }

        public void setPlateNumber(String str) {
            this.f8913h = str;
        }

        public void setPlateProvince(String str) {
            this.f8912g = str;
        }

        public void setStartPoiID(String str) {
            this.f8908c = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeParcelable(this.f8906a, i10);
            parcel.writeParcelable(this.f8907b, i10);
            parcel.writeString(this.f8908c);
            parcel.writeString(this.f8909d);
            parcel.writeString(this.f8910e);
            parcel.writeString(this.f8911f);
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public FromAndTo m1985clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e2) {
                n.a(e2, "RouteSearch", "FromAndToclone");
            }
            FromAndTo fromAndTo = new FromAndTo(this.f8906a, this.f8907b);
            fromAndTo.setStartPoiID(this.f8908c);
            fromAndTo.setDestinationPoiID(this.f8909d);
            fromAndTo.setOriginType(this.f8910e);
            fromAndTo.setDestinationType(this.f8911f);
            return fromAndTo;
        }

        public FromAndTo(Parcel parcel) {
            this.f8906a = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
            this.f8907b = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
            this.f8908c = parcel.readString();
            this.f8909d = parcel.readString();
            this.f8910e = parcel.readString();
            this.f8911f = parcel.readString();
        }

        public FromAndTo() {
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface OnRoutePlanSearchListener {
        void onDriveRoutePlanSearched(DriveRoutePlanResult driveRoutePlanResult, int i10);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface OnRouteSearchListener {
        void onBusRouteSearched(BusRouteResult busRouteResult, int i10);

        void onDriveRouteSearched(DriveRouteResult driveRouteResult, int i10);

        void onRideRouteSearched(RideRouteResult rideRouteResult, int i10);

        void onWalkRouteSearched(WalkRouteResult walkRouteResult, int i10);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface OnTruckRouteSearchListener {
        void onTruckRouteSearched(TruckRouteRestult truckRouteRestult, int i10);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class RideRouteQuery implements Parcelable, Cloneable {
        public static final Parcelable.Creator<RideRouteQuery> CREATOR = new Parcelable.Creator<RideRouteQuery>() { // from class: com.amap.api.services.route.RouteSearch.RideRouteQuery.1
            private static RideRouteQuery a(Parcel parcel) {
                return new RideRouteQuery(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ RideRouteQuery createFromParcel(Parcel parcel) {
                return a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ RideRouteQuery[] newArray(int i10) {
                return a(i10);
            }

            private static RideRouteQuery[] a(int i10) {
                return new RideRouteQuery[i10];
            }
        };

        /* renamed from: a, reason: collision with root package name */
        private FromAndTo f8914a;

        /* renamed from: b, reason: collision with root package name */
        private int f8915b;

        /* renamed from: c, reason: collision with root package name */
        private String f8916c;

        public RideRouteQuery(FromAndTo fromAndTo, int i10) {
            this.f8916c = "base";
            this.f8914a = fromAndTo;
            this.f8915b = i10;
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
            RideRouteQuery rideRouteQuery = (RideRouteQuery) obj;
            FromAndTo fromAndTo = this.f8914a;
            if (fromAndTo == null) {
                if (rideRouteQuery.f8914a != null) {
                    return false;
                }
            } else if (!fromAndTo.equals(rideRouteQuery.f8914a)) {
                return false;
            }
            return this.f8915b == rideRouteQuery.f8915b;
        }

        public String getExtensions() {
            return this.f8916c;
        }

        public FromAndTo getFromAndTo() {
            return this.f8914a;
        }

        public int getMode() {
            return this.f8915b;
        }

        public int hashCode() {
            FromAndTo fromAndTo = this.f8914a;
            return (((fromAndTo == null ? 0 : fromAndTo.hashCode()) + 31) * 31) + this.f8915b;
        }

        public void setExtensions(String str) {
            this.f8916c = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeParcelable(this.f8914a, i10);
            parcel.writeInt(this.f8915b);
            parcel.writeString(this.f8916c);
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public RideRouteQuery m1986clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e2) {
                n.a(e2, "RouteSearch", "RideRouteQueryclone");
            }
            RideRouteQuery rideRouteQuery = new RideRouteQuery(this.f8914a);
            rideRouteQuery.setExtensions(this.f8916c);
            return rideRouteQuery;
        }

        public RideRouteQuery(FromAndTo fromAndTo) {
            this.f8916c = "base";
            this.f8914a = fromAndTo;
        }

        public RideRouteQuery(Parcel parcel) {
            this.f8916c = "base";
            this.f8914a = (FromAndTo) parcel.readParcelable(FromAndTo.class.getClassLoader());
            this.f8915b = parcel.readInt();
            this.f8916c = parcel.readString();
        }

        public RideRouteQuery() {
            this.f8916c = "base";
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class TruckRouteQuery implements Parcelable, Cloneable {
        public static final Parcelable.Creator<TruckRouteQuery> CREATOR = new Parcelable.Creator<TruckRouteQuery>() { // from class: com.amap.api.services.route.RouteSearch.TruckRouteQuery.1
            private static TruckRouteQuery a(Parcel parcel) {
                return new TruckRouteQuery(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ TruckRouteQuery createFromParcel(Parcel parcel) {
                return a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ TruckRouteQuery[] newArray(int i10) {
                return a(i10);
            }

            private static TruckRouteQuery[] a(int i10) {
                return new TruckRouteQuery[i10];
            }
        };

        /* renamed from: a, reason: collision with root package name */
        private FromAndTo f8917a;

        /* renamed from: b, reason: collision with root package name */
        private int f8918b;

        /* renamed from: c, reason: collision with root package name */
        private int f8919c;

        /* renamed from: d, reason: collision with root package name */
        private List<LatLonPoint> f8920d;

        /* renamed from: e, reason: collision with root package name */
        private float f8921e;

        /* renamed from: f, reason: collision with root package name */
        private float f8922f;

        /* renamed from: g, reason: collision with root package name */
        private float f8923g;

        /* renamed from: h, reason: collision with root package name */
        private float f8924h;

        /* renamed from: i, reason: collision with root package name */
        private float f8925i;

        /* renamed from: j, reason: collision with root package name */
        private String f8926j;

        public TruckRouteQuery(FromAndTo fromAndTo, int i10, List<LatLonPoint> list, int i11) {
            this.f8926j = "base";
            this.f8917a = fromAndTo;
            this.f8919c = i10;
            this.f8920d = list;
            this.f8918b = i11;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String getExtensions() {
            return this.f8926j;
        }

        public FromAndTo getFromAndTo() {
            return this.f8917a;
        }

        public int getMode() {
            return this.f8919c;
        }

        public List<LatLonPoint> getPassedByPoints() {
            return this.f8920d;
        }

        public String getPassedPointStr() {
            StringBuffer stringBuffer = new StringBuffer();
            List<LatLonPoint> list = this.f8920d;
            if (list == null || list.size() == 0) {
                return null;
            }
            for (int i10 = 0; i10 < this.f8920d.size(); i10++) {
                LatLonPoint latLonPoint = this.f8920d.get(i10);
                stringBuffer.append(latLonPoint.getLongitude());
                stringBuffer.append(",");
                stringBuffer.append(latLonPoint.getLatitude());
                if (i10 < this.f8920d.size() - 1) {
                    stringBuffer.append(";");
                }
            }
            return stringBuffer.toString();
        }

        public float getTruckAxis() {
            return this.f8925i;
        }

        public float getTruckHeight() {
            return this.f8921e;
        }

        public float getTruckLoad() {
            return this.f8923g;
        }

        public int getTruckSize() {
            return this.f8918b;
        }

        public float getTruckWeight() {
            return this.f8924h;
        }

        public float getTruckWidth() {
            return this.f8922f;
        }

        public boolean hasPassPoint() {
            return !n.a(getPassedPointStr());
        }

        public void setExtensions(String str) {
            this.f8926j = str;
        }

        public void setMode(int i10) {
            this.f8919c = i10;
        }

        public void setTruckAxis(float f10) {
            this.f8925i = f10;
        }

        public void setTruckHeight(float f10) {
            this.f8921e = f10;
        }

        public void setTruckLoad(float f10) {
            this.f8923g = f10;
        }

        public void setTruckSize(int i10) {
            this.f8918b = i10;
        }

        public void setTruckWeight(float f10) {
            this.f8924h = f10;
        }

        public void setTruckWidth(float f10) {
            this.f8922f = f10;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeParcelable(this.f8917a, i10);
            parcel.writeInt(this.f8918b);
            parcel.writeInt(this.f8919c);
            parcel.writeTypedList(this.f8920d);
            parcel.writeFloat(this.f8921e);
            parcel.writeFloat(this.f8922f);
            parcel.writeFloat(this.f8923g);
            parcel.writeFloat(this.f8924h);
            parcel.writeFloat(this.f8925i);
            parcel.writeString(this.f8926j);
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public TruckRouteQuery m1987clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e2) {
                n.a(e2, "RouteSearch", "TruckRouteQueryclone");
            }
            TruckRouteQuery truckRouteQuery = new TruckRouteQuery(this.f8917a, this.f8919c, this.f8920d, this.f8918b);
            truckRouteQuery.setExtensions(this.f8926j);
            return truckRouteQuery;
        }

        public TruckRouteQuery(Parcel parcel) {
            this.f8918b = 2;
            this.f8926j = "base";
            this.f8917a = (FromAndTo) parcel.readParcelable(FromAndTo.class.getClassLoader());
            this.f8918b = parcel.readInt();
            this.f8919c = parcel.readInt();
            this.f8920d = parcel.createTypedArrayList(LatLonPoint.CREATOR);
            this.f8921e = parcel.readFloat();
            this.f8922f = parcel.readFloat();
            this.f8923g = parcel.readFloat();
            this.f8924h = parcel.readFloat();
            this.f8925i = parcel.readFloat();
            this.f8926j = parcel.readString();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class WalkRouteQuery implements Parcelable, Cloneable {
        public static final Parcelable.Creator<WalkRouteQuery> CREATOR = new Parcelable.Creator<WalkRouteQuery>() { // from class: com.amap.api.services.route.RouteSearch.WalkRouteQuery.1
            private static WalkRouteQuery a(Parcel parcel) {
                return new WalkRouteQuery(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ WalkRouteQuery createFromParcel(Parcel parcel) {
                return a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ WalkRouteQuery[] newArray(int i10) {
                return a(i10);
            }

            private static WalkRouteQuery[] a(int i10) {
                return new WalkRouteQuery[i10];
            }
        };

        /* renamed from: a, reason: collision with root package name */
        private FromAndTo f8927a;

        /* renamed from: b, reason: collision with root package name */
        private int f8928b;

        /* renamed from: c, reason: collision with root package name */
        private String f8929c;

        public WalkRouteQuery(FromAndTo fromAndTo, int i10) {
            this.f8929c = "base";
            this.f8927a = fromAndTo;
            this.f8928b = i10;
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
            WalkRouteQuery walkRouteQuery = (WalkRouteQuery) obj;
            FromAndTo fromAndTo = this.f8927a;
            if (fromAndTo == null) {
                if (walkRouteQuery.f8927a != null) {
                    return false;
                }
            } else if (!fromAndTo.equals(walkRouteQuery.f8927a)) {
                return false;
            }
            String str = this.f8929c;
            if (str == null) {
                if (walkRouteQuery.f8929c != null) {
                    return false;
                }
            } else if (!str.equals(walkRouteQuery.f8929c)) {
                return false;
            }
            return this.f8928b == walkRouteQuery.f8928b;
        }

        public String getExtensions() {
            return this.f8929c;
        }

        public FromAndTo getFromAndTo() {
            return this.f8927a;
        }

        public int getMode() {
            return this.f8928b;
        }

        public int hashCode() {
            FromAndTo fromAndTo = this.f8927a;
            return (((fromAndTo == null ? 0 : fromAndTo.hashCode()) + 31) * 31) + this.f8928b;
        }

        public void setExtensions(String str) {
            this.f8929c = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeParcelable(this.f8927a, i10);
            parcel.writeInt(this.f8928b);
            parcel.writeString(this.f8929c);
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public WalkRouteQuery m1988clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e2) {
                n.a(e2, "RouteSearch", "WalkRouteQueryclone");
            }
            WalkRouteQuery walkRouteQuery = new WalkRouteQuery(this.f8927a);
            walkRouteQuery.setExtensions(this.f8929c);
            return walkRouteQuery;
        }

        public WalkRouteQuery(FromAndTo fromAndTo) {
            this.f8929c = "base";
            this.f8927a = fromAndTo;
        }

        public WalkRouteQuery(Parcel parcel) {
            this.f8929c = "base";
            this.f8927a = (FromAndTo) parcel.readParcelable(FromAndTo.class.getClassLoader());
            this.f8928b = parcel.readInt();
            this.f8929c = parcel.readString();
        }

        public WalkRouteQuery() {
            this.f8929c = "base";
        }
    }

    public RouteSearch(Context context) throws AMapException {
        if (this.f8883a == null) {
            try {
                this.f8883a = new br(context);
            } catch (Exception e2) {
                e2.printStackTrace();
                if (e2 instanceof AMapException) {
                    throw ((AMapException) e2);
                }
            }
        }
    }

    public BusRouteResult calculateBusRoute(BusRouteQuery busRouteQuery) throws AMapException {
        IRouteSearch iRouteSearch = this.f8883a;
        if (iRouteSearch != null) {
            return iRouteSearch.calculateBusRoute(busRouteQuery);
        }
        return null;
    }

    public void calculateBusRouteAsyn(BusRouteQuery busRouteQuery) {
        IRouteSearch iRouteSearch = this.f8883a;
        if (iRouteSearch != null) {
            iRouteSearch.calculateBusRouteAsyn(busRouteQuery);
        }
    }

    public DriveRoutePlanResult calculateDrivePlan(DrivePlanQuery drivePlanQuery) throws AMapException {
        IRouteSearch iRouteSearch = this.f8883a;
        if (iRouteSearch != null) {
            return iRouteSearch.calculateDrivePlan(drivePlanQuery);
        }
        return null;
    }

    public void calculateDrivePlanAsyn(DrivePlanQuery drivePlanQuery) {
        IRouteSearch iRouteSearch = this.f8883a;
        if (iRouteSearch != null) {
            iRouteSearch.calculateDrivePlanAsyn(drivePlanQuery);
        }
    }

    public DriveRouteResult calculateDriveRoute(DriveRouteQuery driveRouteQuery) throws AMapException {
        IRouteSearch iRouteSearch = this.f8883a;
        if (iRouteSearch != null) {
            return iRouteSearch.calculateDriveRoute(driveRouteQuery);
        }
        return null;
    }

    public void calculateDriveRouteAsyn(DriveRouteQuery driveRouteQuery) {
        IRouteSearch iRouteSearch = this.f8883a;
        if (iRouteSearch != null) {
            iRouteSearch.calculateDriveRouteAsyn(driveRouteQuery);
        }
    }

    public RideRouteResult calculateRideRoute(RideRouteQuery rideRouteQuery) throws AMapException {
        IRouteSearch iRouteSearch = this.f8883a;
        if (iRouteSearch != null) {
            return iRouteSearch.calculateRideRoute(rideRouteQuery);
        }
        return null;
    }

    public void calculateRideRouteAsyn(RideRouteQuery rideRouteQuery) {
        IRouteSearch iRouteSearch = this.f8883a;
        if (iRouteSearch != null) {
            iRouteSearch.calculateRideRouteAsyn(rideRouteQuery);
        }
    }

    public TruckRouteRestult calculateTruckRoute(TruckRouteQuery truckRouteQuery) throws AMapException {
        IRouteSearch iRouteSearch = this.f8883a;
        if (iRouteSearch != null) {
            return iRouteSearch.calculateTruckRoute(truckRouteQuery);
        }
        return null;
    }

    public void calculateTruckRouteAsyn(TruckRouteQuery truckRouteQuery) {
        IRouteSearch iRouteSearch = this.f8883a;
        if (iRouteSearch != null) {
            iRouteSearch.calculateTruckRouteAsyn(truckRouteQuery);
        }
    }

    public WalkRouteResult calculateWalkRoute(WalkRouteQuery walkRouteQuery) throws AMapException {
        IRouteSearch iRouteSearch = this.f8883a;
        if (iRouteSearch != null) {
            return iRouteSearch.calculateWalkRoute(walkRouteQuery);
        }
        return null;
    }

    public void calculateWalkRouteAsyn(WalkRouteQuery walkRouteQuery) {
        IRouteSearch iRouteSearch = this.f8883a;
        if (iRouteSearch != null) {
            iRouteSearch.calculateWalkRouteAsyn(walkRouteQuery);
        }
    }

    public void setOnRoutePlanSearchListener(OnRoutePlanSearchListener onRoutePlanSearchListener) {
        IRouteSearch iRouteSearch = this.f8883a;
        if (iRouteSearch != null) {
            iRouteSearch.setOnRoutePlanSearchListener(onRoutePlanSearchListener);
        }
    }

    public void setOnTruckRouteSearchListener(OnTruckRouteSearchListener onTruckRouteSearchListener) {
        IRouteSearch iRouteSearch = this.f8883a;
        if (iRouteSearch != null) {
            iRouteSearch.setOnTruckRouteSearchListener(onTruckRouteSearchListener);
        }
    }

    public void setRouteSearchListener(OnRouteSearchListener onRouteSearchListener) {
        IRouteSearch iRouteSearch = this.f8883a;
        if (iRouteSearch != null) {
            iRouteSearch.setRouteSearchListener(onRouteSearchListener);
        }
    }
}
