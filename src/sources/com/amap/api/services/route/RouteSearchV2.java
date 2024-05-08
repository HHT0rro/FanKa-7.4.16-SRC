package com.amap.api.services.route;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.col.s.bs;
import com.amap.api.col.s.n;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.interfaces.IRouteSearchV2;
import com.amap.api.services.route.RouteSearch;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class RouteSearchV2 {

    /* renamed from: a, reason: collision with root package name */
    private IRouteSearchV2 f8931a;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public class AlternativeRoute {
        public static final int ALTERNATIVE_ROUTE_ONE = 1;
        public static final int ALTERNATIVE_ROUTE_THREE = 3;
        public static final int ALTERNATIVE_ROUTE_TWO = 2;

        public AlternativeRoute() {
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class BusMode {
        public static final int BUS_COMFORTABLE = 4;
        public static final int BUS_DEFAULT = 0;
        public static final int BUS_LEASE_CHANGE = 2;
        public static final int BUS_LEASE_WALK = 3;
        public static final int BUS_NO_SUBWAY = 5;
        public static final int BUS_SAVE_MONEY = 1;
        public static final int BUS_SUBWAY = 6;
        public static final int BUS_SUBWAY_FIRST = 7;
        public static final int BUS_WASTE_LESS = 8;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class BusRouteQuery implements Parcelable, Cloneable {
        public static final Parcelable.Creator<BusRouteQuery> CREATOR = new Parcelable.Creator<BusRouteQuery>() { // from class: com.amap.api.services.route.RouteSearchV2.BusRouteQuery.1
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
        private FromAndTo f8933a;

        /* renamed from: b, reason: collision with root package name */
        private int f8934b;

        /* renamed from: c, reason: collision with root package name */
        private String f8935c;

        /* renamed from: d, reason: collision with root package name */
        private String f8936d;

        /* renamed from: e, reason: collision with root package name */
        private String f8937e;

        /* renamed from: f, reason: collision with root package name */
        private String f8938f;

        /* renamed from: g, reason: collision with root package name */
        private int f8939g;

        /* renamed from: h, reason: collision with root package name */
        private String f8940h;

        /* renamed from: i, reason: collision with root package name */
        private String f8941i;

        /* renamed from: j, reason: collision with root package name */
        private String f8942j;

        /* renamed from: k, reason: collision with root package name */
        private String f8943k;

        /* renamed from: l, reason: collision with root package name */
        private int f8944l;

        /* renamed from: m, reason: collision with root package name */
        private int f8945m;

        /* renamed from: n, reason: collision with root package name */
        private int f8946n;

        /* renamed from: o, reason: collision with root package name */
        private int f8947o;

        public BusRouteQuery(FromAndTo fromAndTo, int i10, String str, int i11) {
            this.f8944l = 5;
            this.f8945m = 0;
            this.f8946n = 4;
            this.f8947o = 1;
            this.f8933a = fromAndTo;
            this.f8934b = i10;
            this.f8935c = str;
            this.f8939g = i11;
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
            if (this.f8934b == busRouteQuery.f8934b && this.f8939g == busRouteQuery.f8939g && this.f8940h.equals(busRouteQuery.f8940h) && this.f8941i.equals(busRouteQuery.f8941i) && this.f8944l == busRouteQuery.f8944l && this.f8945m == busRouteQuery.f8945m && this.f8946n == busRouteQuery.f8946n && this.f8947o == busRouteQuery.f8947o && this.f8933a.equals(busRouteQuery.f8933a) && this.f8935c.equals(busRouteQuery.f8935c) && this.f8936d.equals(busRouteQuery.f8936d) && this.f8937e.equals(busRouteQuery.f8937e) && this.f8938f.equals(busRouteQuery.f8938f) && this.f8942j.equals(busRouteQuery.f8942j)) {
                return this.f8943k.equals(busRouteQuery.f8943k);
            }
            return false;
        }

        public String getAd1() {
            return this.f8942j;
        }

        public String getAd2() {
            return this.f8943k;
        }

        public int getAlternativeRoute() {
            return this.f8944l;
        }

        public String getCity() {
            return this.f8935c;
        }

        public String getCityd() {
            return this.f8936d;
        }

        public String getDate() {
            return this.f8937e;
        }

        public String getDestinationPoiId() {
            return this.f8941i;
        }

        public FromAndTo getFromAndTo() {
            return this.f8933a;
        }

        public int getMaxTrans() {
            return this.f8946n;
        }

        public int getMode() {
            return this.f8934b;
        }

        public int getMultiExport() {
            return this.f8945m;
        }

        public int getNightFlag() {
            return this.f8939g;
        }

        public String getOriginPoiId() {
            return this.f8940h;
        }

        public int getShowFields() {
            return this.f8947o;
        }

        public String getTime() {
            return this.f8938f;
        }

        public int hashCode() {
            return (((((((((((((((((((((((((((this.f8933a.hashCode() * 31) + this.f8934b) * 31) + this.f8935c.hashCode()) * 31) + this.f8936d.hashCode()) * 31) + this.f8937e.hashCode()) * 31) + this.f8938f.hashCode()) * 31) + this.f8939g) * 31) + this.f8940h.hashCode()) * 31) + this.f8941i.hashCode()) * 31) + this.f8942j.hashCode()) * 31) + this.f8943k.hashCode()) * 31) + this.f8944l) * 31) + this.f8945m) * 31) + this.f8946n) * 31) + this.f8947o;
        }

        public void setAd1(String str) {
            this.f8942j = str;
        }

        public void setAd2(String str) {
            this.f8943k = str;
        }

        public void setAlternativeRoute(int i10) {
            this.f8944l = i10;
        }

        public void setCityd(String str) {
            this.f8936d = str;
        }

        public void setDate(String str) {
            this.f8937e = str;
        }

        public void setDestinationPoiId(String str) {
            this.f8941i = str;
        }

        public void setMaxTrans(int i10) {
            this.f8946n = i10;
        }

        public void setMultiExport(int i10) {
            this.f8945m = i10;
        }

        public void setOriginPoiId(String str) {
            this.f8940h = str;
        }

        public void setShowFields(int i10) {
            this.f8947o = i10;
        }

        public void setTime(String str) {
            this.f8938f = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeParcelable(this.f8933a, i10);
            parcel.writeInt(this.f8934b);
            parcel.writeString(this.f8935c);
            parcel.writeInt(this.f8939g);
            parcel.writeString(this.f8936d);
            parcel.writeInt(this.f8947o);
            parcel.writeString(this.f8940h);
            parcel.writeString(this.f8941i);
            parcel.writeString(this.f8942j);
            parcel.writeString(this.f8943k);
            parcel.writeInt(this.f8944l);
            parcel.writeInt(this.f8946n);
            parcel.writeInt(this.f8945m);
            parcel.writeString(this.f8937e);
            parcel.writeString(this.f8938f);
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public BusRouteQuery m1989clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e2) {
                n.a(e2, "RouteSearchV2", "BusRouteQueryclone");
            }
            BusRouteQuery busRouteQuery = new BusRouteQuery(this.f8933a, this.f8934b, this.f8935c, this.f8939g);
            busRouteQuery.setCityd(this.f8936d);
            busRouteQuery.setShowFields(this.f8947o);
            busRouteQuery.setDate(this.f8937e);
            busRouteQuery.setTime(this.f8938f);
            busRouteQuery.setAd1(this.f8942j);
            busRouteQuery.setAd2(this.f8943k);
            busRouteQuery.setOriginPoiId(this.f8940h);
            busRouteQuery.setDestinationPoiId(this.f8941i);
            busRouteQuery.setMaxTrans(this.f8946n);
            busRouteQuery.setMultiExport(this.f8945m);
            busRouteQuery.setAlternativeRoute(this.f8944l);
            return busRouteQuery;
        }

        public BusRouteQuery(Parcel parcel) {
            this.f8934b = 0;
            this.f8939g = 0;
            this.f8944l = 5;
            this.f8945m = 0;
            this.f8946n = 4;
            this.f8947o = 1;
            this.f8933a = (FromAndTo) parcel.readParcelable(FromAndTo.class.getClassLoader());
            this.f8934b = parcel.readInt();
            this.f8935c = parcel.readString();
            this.f8939g = parcel.readInt();
            this.f8936d = parcel.readString();
            this.f8947o = parcel.readInt();
            this.f8940h = parcel.readString();
            this.f8941i = parcel.readString();
            this.f8937e = parcel.readString();
            this.f8938f = parcel.readString();
            this.f8946n = parcel.readInt();
            this.f8945m = parcel.readInt();
            this.f8944l = parcel.readInt();
            this.f8942j = parcel.readString();
            this.f8943k = parcel.readString();
        }

        public BusRouteQuery() {
            this.f8934b = 0;
            this.f8939g = 0;
            this.f8944l = 5;
            this.f8945m = 0;
            this.f8946n = 4;
            this.f8947o = 1;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class CurveCost {

        /* renamed from: a, reason: collision with root package name */
        private float f8948a;

        /* renamed from: b, reason: collision with root package name */
        private float f8949b;

        public float getAccess() {
            return this.f8948a;
        }

        public float getValue() {
            return this.f8949b;
        }

        public void setAccess(float f10) {
            this.f8948a = f10;
        }

        public void setValue(float f10) {
            this.f8949b = f10;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class CustomCostMode {

        /* renamed from: a, reason: collision with root package name */
        private List<SpeedCost> f8950a;

        /* renamed from: b, reason: collision with root package name */
        private CurveCost f8951b;

        /* renamed from: c, reason: collision with root package name */
        private SlopeCost f8952c;

        /* renamed from: d, reason: collision with root package name */
        private float f8953d;

        /* renamed from: e, reason: collision with root package name */
        private TransCost f8954e;

        /* renamed from: f, reason: collision with root package name */
        private float f8955f;

        /* renamed from: g, reason: collision with root package name */
        private PowerTrainLoss f8956g;

        public float getAuxCost() {
            return this.f8953d;
        }

        public CurveCost getCurveCost() {
            return this.f8951b;
        }

        public float getFerryCost() {
            return this.f8955f;
        }

        public PowerTrainLoss getPowerTrainLosses() {
            return this.f8956g;
        }

        public SlopeCost getSlopeCost() {
            return this.f8952c;
        }

        public List<SpeedCost> getSpeedCosts() {
            return this.f8950a;
        }

        public TransCost getTransCost() {
            return this.f8954e;
        }

        public void setAuxCost(float f10) {
            this.f8953d = f10;
        }

        public void setCurveCost(CurveCost curveCost) {
            this.f8951b = curveCost;
        }

        public void setFerryCost(float f10) {
            this.f8955f = f10;
        }

        public void setPowerTrainLosses(PowerTrainLoss powerTrainLoss) {
            this.f8956g = powerTrainLoss;
        }

        public void setSlopeCost(SlopeCost slopeCost) {
            this.f8952c = slopeCost;
        }

        public void setSpeedCosts(List<SpeedCost> list) {
            this.f8950a = list;
        }

        public void setTransCost(TransCost transCost) {
            this.f8954e = transCost;
        }

        public String toJson() {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                List<SpeedCost> list = this.f8950a;
                if (list != null) {
                    for (SpeedCost speedCost : list) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("speed", speedCost.getSpeed());
                        jSONObject2.put("value", speedCost.getValue());
                        jSONArray.put(jSONObject2);
                    }
                    jSONObject.put("speed_cost", jSONArray);
                }
                if (this.f8951b != null) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("access", this.f8951b.getAccess());
                    jSONObject3.put("value", this.f8951b.getValue());
                    jSONObject.put("curve_cost", jSONObject3);
                }
                if (this.f8952c != null) {
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("up", this.f8952c.getUp());
                    jSONObject4.put("down", this.f8952c.getDown());
                    jSONObject.put("slope_cost", jSONObject4);
                }
                jSONObject.put("aux_cost", this.f8953d);
                if (this.f8954e != null) {
                    JSONObject jSONObject5 = new JSONObject();
                    jSONObject5.put("access", this.f8954e.getAccess());
                    jSONObject5.put("decess", this.f8954e.getDecess());
                    jSONObject.put("trans_cost", jSONObject5);
                }
                jSONObject.put("ferry_cost", this.f8955f);
                if (this.f8956g != null) {
                    JSONArray jSONArray2 = new JSONArray();
                    JSONObject jSONObject6 = new JSONObject();
                    jSONObject6.put("powerdemand", this.f8956g.getPowerDemand());
                    jSONObject6.put("value", this.f8956g.getPowerDemandValue());
                    JSONObject jSONObject7 = new JSONObject();
                    jSONObject7.put("speed", this.f8956g.getSpeed());
                    jSONObject7.put("value", this.f8956g.getSpeedValue());
                    jSONArray2.put(jSONObject6);
                    jSONArray2.put(jSONObject7);
                    jSONObject.put("powertrain_loss", jSONArray2);
                }
                return jSONObject.toString();
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class DriveRouteQuery implements Parcelable, Cloneable {
        public static final Parcelable.Creator<DriveRouteQuery> CREATOR = new Parcelable.Creator<DriveRouteQuery>() { // from class: com.amap.api.services.route.RouteSearchV2.DriveRouteQuery.1
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
        private FromAndTo f8957a;

        /* renamed from: b, reason: collision with root package name */
        private NewEnergy f8958b;

        /* renamed from: c, reason: collision with root package name */
        private int f8959c;

        /* renamed from: d, reason: collision with root package name */
        private List<LatLonPoint> f8960d;

        /* renamed from: e, reason: collision with root package name */
        private List<List<LatLonPoint>> f8961e;

        /* renamed from: f, reason: collision with root package name */
        private String f8962f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f8963g;

        /* renamed from: h, reason: collision with root package name */
        private int f8964h;

        /* renamed from: i, reason: collision with root package name */
        private String f8965i;

        /* renamed from: j, reason: collision with root package name */
        private int f8966j;

        public DriveRouteQuery(FromAndTo fromAndTo, DrivingStrategy drivingStrategy, List<LatLonPoint> list, List<List<LatLonPoint>> list2, String str) {
            this.f8959c = DrivingStrategy.DEFAULT.getValue();
            this.f8963g = true;
            this.f8964h = 0;
            this.f8965i = null;
            this.f8966j = 1;
            this.f8957a = fromAndTo;
            this.f8959c = drivingStrategy.getValue();
            this.f8960d = list;
            this.f8961e = list2;
            this.f8962f = str;
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
            String str = this.f8962f;
            if (str == null) {
                if (driveRouteQuery.f8962f != null) {
                    return false;
                }
            } else if (!str.equals(driveRouteQuery.f8962f)) {
                return false;
            }
            List<List<LatLonPoint>> list = this.f8961e;
            if (list == null) {
                if (driveRouteQuery.f8961e != null) {
                    return false;
                }
            } else if (!list.equals(driveRouteQuery.f8961e)) {
                return false;
            }
            FromAndTo fromAndTo = this.f8957a;
            if (fromAndTo == null) {
                if (driveRouteQuery.f8957a != null) {
                    return false;
                }
            } else if (!fromAndTo.equals(driveRouteQuery.f8957a)) {
                return false;
            }
            if (this.f8959c != driveRouteQuery.f8959c) {
                return false;
            }
            List<LatLonPoint> list2 = this.f8960d;
            if (list2 == null) {
                if (driveRouteQuery.f8960d != null) {
                    return false;
                }
            } else if (!list2.equals(driveRouteQuery.f8960d) || this.f8963g != driveRouteQuery.isUseFerry() || this.f8964h != driveRouteQuery.f8964h || this.f8966j != driveRouteQuery.f8966j) {
                return false;
            }
            return true;
        }

        public String getAvoidRoad() {
            return this.f8962f;
        }

        public List<List<LatLonPoint>> getAvoidpolygons() {
            return this.f8961e;
        }

        public String getAvoidpolygonsStr() {
            StringBuffer stringBuffer = new StringBuffer();
            List<List<LatLonPoint>> list = this.f8961e;
            if (list == null || list.size() == 0) {
                return null;
            }
            for (int i10 = 0; i10 < this.f8961e.size(); i10++) {
                List<LatLonPoint> list2 = this.f8961e.get(i10);
                for (int i11 = 0; i11 < list2.size(); i11++) {
                    LatLonPoint latLonPoint = list2.get(i11);
                    stringBuffer.append(latLonPoint.getLongitude());
                    stringBuffer.append(",");
                    stringBuffer.append(latLonPoint.getLatitude());
                    if (i11 < list2.size() - 1) {
                        stringBuffer.append(";");
                    }
                }
                if (i10 < this.f8961e.size() - 1) {
                    stringBuffer.append("|");
                }
            }
            return stringBuffer.toString();
        }

        public int getCarType() {
            return this.f8964h;
        }

        public String getExclude() {
            return this.f8965i;
        }

        public FromAndTo getFromAndTo() {
            return this.f8957a;
        }

        public DrivingStrategy getMode() {
            return DrivingStrategy.fromValue(this.f8959c);
        }

        public NewEnergy getNewEnergy() {
            return this.f8958b;
        }

        public List<LatLonPoint> getPassedByPoints() {
            return this.f8960d;
        }

        public String getPassedPointStr() {
            StringBuffer stringBuffer = new StringBuffer();
            List<LatLonPoint> list = this.f8960d;
            if (list == null || list.size() == 0) {
                return null;
            }
            for (int i10 = 0; i10 < this.f8960d.size(); i10++) {
                LatLonPoint latLonPoint = this.f8960d.get(i10);
                stringBuffer.append(latLonPoint.getLongitude());
                stringBuffer.append(",");
                stringBuffer.append(latLonPoint.getLatitude());
                if (i10 < this.f8960d.size() - 1) {
                    stringBuffer.append(";");
                }
            }
            return stringBuffer.toString();
        }

        public int getShowFields() {
            return this.f8966j;
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
            String str = this.f8962f;
            int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
            List<List<LatLonPoint>> list = this.f8961e;
            int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
            FromAndTo fromAndTo = this.f8957a;
            int hashCode3 = (((hashCode2 + (fromAndTo == null ? 0 : fromAndTo.hashCode())) * 31) + this.f8959c) * 31;
            List<LatLonPoint> list2 = this.f8960d;
            return ((hashCode3 + (list2 != null ? list2.hashCode() : 0)) * 31) + this.f8964h;
        }

        public boolean isUseFerry() {
            return this.f8963g;
        }

        public void setCarType(int i10) {
            this.f8964h = i10;
        }

        public void setExclude(String str) {
            this.f8965i = str;
        }

        public void setNewEnergy(NewEnergy newEnergy) {
            this.f8958b = newEnergy;
        }

        public void setShowFields(int i10) {
            this.f8966j = i10;
        }

        public void setUseFerry(boolean z10) {
            this.f8963g = z10;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeParcelable(this.f8957a, i10);
            parcel.writeInt(this.f8959c);
            parcel.writeTypedList(this.f8960d);
            List<List<LatLonPoint>> list = this.f8961e;
            if (list == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(list.size());
                Iterator<List<LatLonPoint>> iterator2 = this.f8961e.iterator2();
                while (iterator2.hasNext()) {
                    parcel.writeTypedList(iterator2.next());
                }
            }
            parcel.writeString(this.f8962f);
            parcel.writeInt(this.f8963g ? 1 : 0);
            parcel.writeInt(this.f8964h);
            parcel.writeString(this.f8965i);
            parcel.writeInt(this.f8966j);
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public DriveRouteQuery m1990clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e2) {
                n.a(e2, "RouteSearchV2", "DriveRouteQueryclone");
            }
            DriveRouteQuery driveRouteQuery = new DriveRouteQuery(this.f8957a, DrivingStrategy.fromValue(this.f8959c), this.f8960d, this.f8961e, this.f8962f);
            driveRouteQuery.setUseFerry(this.f8963g);
            driveRouteQuery.setCarType(this.f8964h);
            driveRouteQuery.setExclude(this.f8965i);
            driveRouteQuery.setShowFields(this.f8966j);
            driveRouteQuery.setNewEnergy(this.f8958b);
            return driveRouteQuery;
        }

        public DriveRouteQuery(Parcel parcel) {
            this.f8959c = DrivingStrategy.DEFAULT.getValue();
            this.f8963g = true;
            this.f8964h = 0;
            this.f8965i = null;
            this.f8966j = 1;
            this.f8957a = (FromAndTo) parcel.readParcelable(FromAndTo.class.getClassLoader());
            this.f8959c = parcel.readInt();
            this.f8960d = parcel.createTypedArrayList(LatLonPoint.CREATOR);
            int readInt = parcel.readInt();
            if (readInt == 0) {
                this.f8961e = null;
            } else {
                this.f8961e = new ArrayList();
            }
            for (int i10 = 0; i10 < readInt; i10++) {
                this.f8961e.add(parcel.createTypedArrayList(LatLonPoint.CREATOR));
            }
            this.f8962f = parcel.readString();
            this.f8963g = parcel.readInt() == 1;
            this.f8964h = parcel.readInt();
            this.f8965i = parcel.readString();
            this.f8966j = parcel.readInt();
        }

        public DriveRouteQuery() {
            this.f8959c = DrivingStrategy.DEFAULT.getValue();
            this.f8963g = true;
            this.f8964h = 0;
            this.f8965i = null;
            this.f8966j = 1;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum DrivingStrategy {
        DEFAULT(32),
        AVOID_CONGESTION(33),
        HIGHWAY_PRIORITY(34),
        AVOID_HIGHWAY(35),
        LESS_CHARGE(36),
        ROAD_PRIORITY(37),
        SPEED_PRIORITY(38),
        AVOID_CONGESTION_HIGHWAY_PRIORITY(39),
        AVOID_CONGESTION_AVOID_HIGHWAY(40),
        AVOID_CONGESTION_LESS_CHARGE(41),
        LESS_CHARGE_AVOID_HIGHWAY(42),
        AVOID_CONGESTION_LESS_CHARGE_AVOID_HIGHWAY(43),
        AVOID_CONGESTION_ROAD_PRIORITY(44),
        AVOID_CONGESTION_SPEED_PRIORITY(45);


        /* renamed from: a, reason: collision with root package name */
        public int f8968a;

        DrivingStrategy(int i10) {
            this.f8968a = i10;
        }

        public static DrivingStrategy fromValue(int i10) {
            return values()[i10 - 32];
        }

        public final int getValue() {
            return this.f8968a;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class FromAndTo implements Parcelable, Cloneable {
        public static final Parcelable.Creator<FromAndTo> CREATOR = new Parcelable.Creator<FromAndTo>() { // from class: com.amap.api.services.route.RouteSearchV2.FromAndTo.1
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
        private LatLonPoint f8969a;

        /* renamed from: b, reason: collision with root package name */
        private LatLonPoint f8970b;

        /* renamed from: c, reason: collision with root package name */
        private String f8971c;

        /* renamed from: d, reason: collision with root package name */
        private String f8972d;

        /* renamed from: e, reason: collision with root package name */
        private String f8973e;

        /* renamed from: f, reason: collision with root package name */
        private String f8974f;

        /* renamed from: g, reason: collision with root package name */
        private String f8975g;

        public FromAndTo(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
            this.f8969a = latLonPoint;
            this.f8970b = latLonPoint2;
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
            String str = this.f8972d;
            if (str == null) {
                if (fromAndTo.f8972d != null) {
                    return false;
                }
            } else if (!str.equals(fromAndTo.f8972d)) {
                return false;
            }
            LatLonPoint latLonPoint = this.f8969a;
            if (latLonPoint == null) {
                if (fromAndTo.f8969a != null) {
                    return false;
                }
            } else if (!latLonPoint.equals(fromAndTo.f8969a)) {
                return false;
            }
            String str2 = this.f8971c;
            if (str2 == null) {
                if (fromAndTo.f8971c != null) {
                    return false;
                }
            } else if (!str2.equals(fromAndTo.f8971c)) {
                return false;
            }
            LatLonPoint latLonPoint2 = this.f8970b;
            if (latLonPoint2 == null) {
                if (fromAndTo.f8970b != null) {
                    return false;
                }
            } else if (!latLonPoint2.equals(fromAndTo.f8970b)) {
                return false;
            }
            String str3 = this.f8973e;
            if (str3 == null) {
                if (fromAndTo.f8973e != null) {
                    return false;
                }
            } else if (!str3.equals(fromAndTo.f8973e)) {
                return false;
            }
            String str4 = this.f8974f;
            if (str4 == null) {
                if (fromAndTo.f8974f != null) {
                    return false;
                }
            } else if (!str4.equals(fromAndTo.f8974f)) {
                return false;
            }
            return true;
        }

        public String getDestinationPoiID() {
            return this.f8972d;
        }

        public String getDestinationType() {
            return this.f8974f;
        }

        public LatLonPoint getFrom() {
            return this.f8969a;
        }

        public String getOriginType() {
            return this.f8973e;
        }

        public String getPlateNumber() {
            return this.f8975g;
        }

        public String getStartPoiID() {
            return this.f8971c;
        }

        public LatLonPoint getTo() {
            return this.f8970b;
        }

        public int hashCode() {
            String str = this.f8972d;
            int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
            LatLonPoint latLonPoint = this.f8969a;
            int hashCode2 = (hashCode + (latLonPoint == null ? 0 : latLonPoint.hashCode())) * 31;
            String str2 = this.f8971c;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            LatLonPoint latLonPoint2 = this.f8970b;
            int hashCode4 = (hashCode3 + (latLonPoint2 == null ? 0 : latLonPoint2.hashCode())) * 31;
            String str3 = this.f8973e;
            int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.f8974f;
            return hashCode5 + (str4 != null ? str4.hashCode() : 0);
        }

        public void setDestinationPoiID(String str) {
            this.f8972d = str;
        }

        public void setDestinationType(String str) {
            this.f8974f = str;
        }

        public void setOriginType(String str) {
            this.f8973e = str;
        }

        public void setPlateNumber(String str) {
            this.f8975g = str;
        }

        public void setStartPoiID(String str) {
            this.f8971c = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeParcelable(this.f8969a, i10);
            parcel.writeParcelable(this.f8970b, i10);
            parcel.writeString(this.f8971c);
            parcel.writeString(this.f8972d);
            parcel.writeString(this.f8973e);
            parcel.writeString(this.f8974f);
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public FromAndTo m1991clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e2) {
                n.a(e2, "RouteSearchV2", "FromAndToclone");
            }
            FromAndTo fromAndTo = new FromAndTo(this.f8969a, this.f8970b);
            fromAndTo.setStartPoiID(this.f8971c);
            fromAndTo.setDestinationPoiID(this.f8972d);
            fromAndTo.setOriginType(this.f8973e);
            fromAndTo.setDestinationType(this.f8974f);
            return fromAndTo;
        }

        public FromAndTo(Parcel parcel) {
            this.f8969a = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
            this.f8970b = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
            this.f8971c = parcel.readString();
            this.f8972d = parcel.readString();
            this.f8973e = parcel.readString();
            this.f8974f = parcel.readString();
        }

        public FromAndTo() {
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class NewEnergy {

        /* renamed from: a, reason: collision with root package name */
        private String f8976a;

        /* renamed from: b, reason: collision with root package name */
        private CustomCostMode f8977b;

        /* renamed from: h, reason: collision with root package name */
        private String f8983h;

        /* renamed from: c, reason: collision with root package name */
        private float f8978c = -1.0f;

        /* renamed from: d, reason: collision with root package name */
        private float f8979d = -1.0f;

        /* renamed from: e, reason: collision with root package name */
        private float f8980e = 1.5f;

        /* renamed from: f, reason: collision with root package name */
        private float f8981f = 100.0f;

        /* renamed from: g, reason: collision with root package name */
        private float f8982g = 0.0f;

        /* renamed from: i, reason: collision with root package name */
        private int f8984i = 0;

        public String buildParam() {
            StringBuilder sb2 = new StringBuilder();
            if (this.f8976a != null) {
                sb2.append("&key=");
                sb2.append(this.f8976a);
            }
            if (this.f8977b != null) {
                sb2.append("&custom_cost_mode=");
                sb2.append(this.f8977b.toJson());
            }
            if (this.f8978c > 0.0f) {
                sb2.append("&max_vehicle_charge=");
                sb2.append(this.f8978c);
            }
            if (this.f8979d > 0.0f) {
                sb2.append("&vehicle_charge=");
                sb2.append(this.f8979d);
            }
            sb2.append("&load=");
            sb2.append(this.f8980e);
            sb2.append("&leaving_percent=");
            sb2.append(this.f8981f);
            sb2.append("&arriving_percent=");
            sb2.append(this.f8982g);
            if (this.f8983h != null) {
                sb2.append("&custom_charging_arguments=");
                sb2.append(this.f8983h);
            }
            if (this.f8984i > 0) {
                sb2.append("&waypoints_arriving_percent=");
                sb2.append(this.f8984i);
            }
            return sb2.toString();
        }

        public float getArrivingPercent() {
            return this.f8982g;
        }

        public String getCustomChargingArguments() {
            return this.f8983h;
        }

        public CustomCostMode getCustomCostMode() {
            return this.f8977b;
        }

        public String getKey() {
            return this.f8976a;
        }

        public float getLeavingPercent() {
            return this.f8981f;
        }

        public float getLoad() {
            return this.f8980e;
        }

        public float getMaxVehicleCharge() {
            return this.f8978c;
        }

        public float getVehicleCharge() {
            return this.f8979d;
        }

        public int getWaypointsArrivingPercent() {
            return this.f8984i;
        }

        public void setArrivingPercent(float f10) {
            this.f8982g = f10;
        }

        public void setCustomChargingArguments(String str) {
            this.f8983h = str;
        }

        public void setCustomCostMode(CustomCostMode customCostMode) {
            this.f8977b = customCostMode;
        }

        public void setKey(String str) {
            this.f8976a = str;
        }

        public void setLeavingPercent(float f10) {
            this.f8981f = f10;
        }

        public void setLoad(float f10) {
            this.f8980e = f10;
        }

        public void setMaxVehicleCharge(float f10) {
            this.f8978c = f10;
        }

        public void setVehicleCharge(float f10) {
            this.f8979d = f10;
        }

        public void setWaypointsArrivingPercent(int i10) {
            this.f8984i = i10;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface OnRoutePlanSearchListener {
        void onDriveRoutePlanSearched(DriveRoutePlanResult driveRoutePlanResult, int i10);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface OnRouteSearchListener {
        void onBusRouteSearched(BusRouteResultV2 busRouteResultV2, int i10);

        void onDriveRouteSearched(DriveRouteResultV2 driveRouteResultV2, int i10);

        void onRideRouteSearched(RideRouteResultV2 rideRouteResultV2, int i10);

        void onWalkRouteSearched(WalkRouteResultV2 walkRouteResultV2, int i10);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface OnTruckRouteSearchListener {
        void onTruckRouteSearched(TruckRouteRestult truckRouteRestult, int i10);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class PowerTrainLoss {

        /* renamed from: a, reason: collision with root package name */
        private int f8985a;

        /* renamed from: b, reason: collision with root package name */
        private float f8986b;

        /* renamed from: c, reason: collision with root package name */
        private int f8987c;

        /* renamed from: d, reason: collision with root package name */
        private int f8988d;

        public int getPowerDemand() {
            return this.f8985a;
        }

        public float getPowerDemandValue() {
            return this.f8986b;
        }

        public int getSpeed() {
            return this.f8987c;
        }

        public int getSpeedValue() {
            return this.f8988d;
        }

        public void setPowerDemand(int i10) {
            this.f8985a = i10;
        }

        public void setPowerDemandValue(float f10) {
            this.f8986b = f10;
        }

        public void setSpeed(int i10) {
            this.f8987c = i10;
        }

        public void setSpeedValue(int i10) {
            this.f8988d = i10;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class RideRouteQuery implements Parcelable, Cloneable {
        public static final Parcelable.Creator<RideRouteQuery> CREATOR = new Parcelable.Creator<RideRouteQuery>() { // from class: com.amap.api.services.route.RouteSearchV2.RideRouteQuery.1
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
        private FromAndTo f8989a;

        /* renamed from: b, reason: collision with root package name */
        private int f8990b;

        /* renamed from: c, reason: collision with root package name */
        private int f8991c;

        public RideRouteQuery(FromAndTo fromAndTo) {
            this.f8990b = 1;
            this.f8991c = 1;
            this.f8989a = fromAndTo;
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
            FromAndTo fromAndTo = this.f8989a;
            if (fromAndTo == null) {
                if (rideRouteQuery.f8989a != null) {
                    return false;
                }
            } else if (!fromAndTo.equals(rideRouteQuery.f8989a)) {
                return false;
            }
            return this.f8990b == rideRouteQuery.f8990b && this.f8991c == rideRouteQuery.f8991c;
        }

        public int getAlternativeRoute() {
            return this.f8991c;
        }

        public FromAndTo getFromAndTo() {
            return this.f8989a;
        }

        public int getShowFields() {
            return this.f8990b;
        }

        public int hashCode() {
            FromAndTo fromAndTo = this.f8989a;
            return (((((fromAndTo == null ? 0 : fromAndTo.hashCode()) + 31) * 31) + this.f8990b) * 31) + this.f8991c;
        }

        public void setAlternativeRoute(int i10) {
            this.f8991c = i10;
        }

        public void setShowFields(int i10) {
            this.f8990b = i10;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeParcelable(this.f8989a, i10);
            parcel.writeInt(this.f8991c);
            parcel.writeInt(this.f8990b);
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public RideRouteQuery m1992clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e2) {
                n.a(e2, "RouteSearchV2", "RideRouteQueryclone");
            }
            RideRouteQuery rideRouteQuery = new RideRouteQuery(this.f8989a);
            rideRouteQuery.setShowFields(this.f8990b);
            rideRouteQuery.setAlternativeRoute(this.f8991c);
            return rideRouteQuery;
        }

        public RideRouteQuery(Parcel parcel) {
            this.f8990b = 1;
            this.f8991c = 1;
            this.f8989a = (FromAndTo) parcel.readParcelable(RouteSearch.FromAndTo.class.getClassLoader());
            this.f8991c = parcel.readInt();
            this.f8990b = parcel.readInt();
        }

        public RideRouteQuery() {
            this.f8990b = 1;
            this.f8991c = 1;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class ShowFields {
        public static final int ALL = -1;
        public static final int CHARGE_STATION_INFO = 64;
        public static final int CITIES = 8;
        public static final int COST = 1;
        public static final int ELEC_COSUME_INFO = 32;
        public static final int NAVI = 4;
        public static final int POLINE = 16;
        public static final int TMCS = 2;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class SlopeCost {

        /* renamed from: a, reason: collision with root package name */
        private float f8992a;

        /* renamed from: b, reason: collision with root package name */
        private float f8993b;

        public float getDown() {
            return this.f8993b;
        }

        public float getUp() {
            return this.f8992a;
        }

        public void setDown(float f10) {
            this.f8993b = f10;
        }

        public void setUp(float f10) {
            this.f8992a = f10;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class SpeedCost {

        /* renamed from: a, reason: collision with root package name */
        private int f8994a;

        /* renamed from: b, reason: collision with root package name */
        private float f8995b;

        public int getSpeed() {
            return this.f8994a;
        }

        public float getValue() {
            return this.f8995b;
        }

        public void setSpeed(int i10) {
            this.f8994a = i10;
        }

        public void setValue(float f10) {
            this.f8995b = f10;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class TransCost {

        /* renamed from: a, reason: collision with root package name */
        private float f8996a;

        /* renamed from: b, reason: collision with root package name */
        private float f8997b;

        public float getAccess() {
            return this.f8996a;
        }

        public float getDecess() {
            return this.f8997b;
        }

        public void setAccess(float f10) {
            this.f8996a = f10;
        }

        public void setDecess(float f10) {
            this.f8997b = f10;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class WalkRouteQuery implements Parcelable, Cloneable {
        public static final Parcelable.Creator<WalkRouteQuery> CREATOR = new Parcelable.Creator<WalkRouteQuery>() { // from class: com.amap.api.services.route.RouteSearchV2.WalkRouteQuery.1
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
        private FromAndTo f8998a;

        /* renamed from: b, reason: collision with root package name */
        private int f8999b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f9000c;

        /* renamed from: d, reason: collision with root package name */
        private int f9001d;

        public WalkRouteQuery(FromAndTo fromAndTo) {
            this.f8999b = 1;
            this.f9000c = false;
            this.f9001d = 1;
            this.f8998a = fromAndTo;
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
            if (this.f8999b == walkRouteQuery.f8999b && this.f9000c == walkRouteQuery.f9000c && this.f9001d == walkRouteQuery.f9001d) {
                return this.f8998a.equals(walkRouteQuery.f8998a);
            }
            return false;
        }

        public int getAlternativeRoute() {
            return this.f9001d;
        }

        public FromAndTo getFromAndTo() {
            return this.f8998a;
        }

        public int getShowFields() {
            return this.f8999b;
        }

        public int hashCode() {
            return (((((this.f8998a.hashCode() * 31) + this.f8999b) * 31) + (this.f9000c ? 1 : 0)) * 31) + this.f9001d;
        }

        public boolean isIndoor() {
            return this.f9000c;
        }

        public void setAlternativeRoute(int i10) {
            this.f9001d = i10;
        }

        public void setIndoor(boolean z10) {
            this.f9000c = z10;
        }

        public void setShowFields(int i10) {
            this.f8999b = i10;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeParcelable(this.f8998a, i10);
            parcel.writeBooleanArray(new boolean[]{this.f9000c});
            parcel.writeInt(this.f9001d);
            parcel.writeInt(this.f8999b);
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public WalkRouteQuery m1993clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e2) {
                n.a(e2, "RouteSearchV2", "WalkRouteQueryclone");
            }
            WalkRouteQuery walkRouteQuery = new WalkRouteQuery(this.f8998a);
            walkRouteQuery.setShowFields(this.f8999b);
            walkRouteQuery.setIndoor(this.f9000c);
            walkRouteQuery.setAlternativeRoute(this.f9001d);
            return walkRouteQuery;
        }

        public WalkRouteQuery(Parcel parcel) {
            this.f8999b = 1;
            this.f9000c = false;
            this.f9001d = 1;
            this.f8998a = (FromAndTo) parcel.readParcelable(FromAndTo.class.getClassLoader());
            boolean[] zArr = new boolean[1];
            parcel.readBooleanArray(zArr);
            this.f9000c = zArr[0];
            this.f9001d = parcel.readInt();
            this.f8999b = parcel.readInt();
        }

        public WalkRouteQuery() {
            this.f8999b = 1;
            this.f9000c = false;
            this.f9001d = 1;
        }
    }

    public RouteSearchV2(Context context) throws AMapException {
        if (this.f8931a == null) {
            try {
                this.f8931a = new bs(context);
            } catch (Exception e2) {
                e2.printStackTrace();
                if (e2 instanceof AMapException) {
                    throw ((AMapException) e2);
                }
            }
        }
    }

    public BusRouteResultV2 calculateBusRoute(BusRouteQuery busRouteQuery) throws AMapException {
        IRouteSearchV2 iRouteSearchV2 = this.f8931a;
        if (iRouteSearchV2 != null) {
            return iRouteSearchV2.calculateBusRoute(busRouteQuery);
        }
        return null;
    }

    public void calculateBusRouteAsyn(BusRouteQuery busRouteQuery) {
        IRouteSearchV2 iRouteSearchV2 = this.f8931a;
        if (iRouteSearchV2 != null) {
            iRouteSearchV2.calculateBusRouteAsyn(busRouteQuery);
        }
    }

    public DriveRouteResultV2 calculateDriveRoute(DriveRouteQuery driveRouteQuery) throws AMapException {
        IRouteSearchV2 iRouteSearchV2 = this.f8931a;
        if (iRouteSearchV2 != null) {
            return iRouteSearchV2.calculateDriveRoute(driveRouteQuery);
        }
        return null;
    }

    public void calculateDriveRouteAsyn(DriveRouteQuery driveRouteQuery) {
        IRouteSearchV2 iRouteSearchV2 = this.f8931a;
        if (iRouteSearchV2 != null) {
            iRouteSearchV2.calculateDriveRouteAsyn(driveRouteQuery);
        }
    }

    public RideRouteResultV2 calculateRideRoute(RideRouteQuery rideRouteQuery) throws AMapException {
        IRouteSearchV2 iRouteSearchV2 = this.f8931a;
        if (iRouteSearchV2 != null) {
            return iRouteSearchV2.calculateRideRoute(rideRouteQuery);
        }
        return null;
    }

    public void calculateRideRouteAsyn(RideRouteQuery rideRouteQuery) {
        IRouteSearchV2 iRouteSearchV2 = this.f8931a;
        if (iRouteSearchV2 != null) {
            iRouteSearchV2.calculateRideRouteAsyn(rideRouteQuery);
        }
    }

    public WalkRouteResultV2 calculateWalkRoute(WalkRouteQuery walkRouteQuery) throws AMapException {
        IRouteSearchV2 iRouteSearchV2 = this.f8931a;
        if (iRouteSearchV2 != null) {
            return iRouteSearchV2.calculateWalkRoute(walkRouteQuery);
        }
        return null;
    }

    public void calculateWalkRouteAsyn(WalkRouteQuery walkRouteQuery) {
        IRouteSearchV2 iRouteSearchV2 = this.f8931a;
        if (iRouteSearchV2 != null) {
            iRouteSearchV2.calculateWalkRouteAsyn(walkRouteQuery);
        }
    }

    public void setRouteSearchListener(OnRouteSearchListener onRouteSearchListener) {
        IRouteSearchV2 iRouteSearchV2 = this.f8931a;
        if (iRouteSearchV2 != null) {
            iRouteSearchV2.setRouteSearchListener(onRouteSearchListener);
        }
    }
}
