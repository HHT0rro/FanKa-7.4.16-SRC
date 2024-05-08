package com.amap.api.location;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.textclassifier.TextClassifier;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.services.district.DistrictSearchQuery;
import com.autonavi.aps.amapapi.utils.b;
import com.autonavi.aps.amapapi.utils.j;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class AMapLocation extends Location implements Cloneable {
    public static final String COORD_TYPE_GCJ02 = "GCJ02";
    public static final String COORD_TYPE_WGS84 = "WGS84";
    public static final Parcelable.Creator<AMapLocation> CREATOR = new Parcelable.Creator<AMapLocation>() { // from class: com.amap.api.location.AMapLocation.1
        private static AMapLocation a(Parcel parcel) {
            AMapLocation aMapLocation = new AMapLocation((Location) Location.CREATOR.createFromParcel(parcel));
            aMapLocation.f8064h = parcel.readString();
            aMapLocation.f8065i = parcel.readString();
            aMapLocation.B = parcel.readString();
            aMapLocation.f8057a = parcel.readString();
            aMapLocation.f8061e = parcel.readString();
            aMapLocation.f8063g = parcel.readString();
            aMapLocation.f8067k = parcel.readString();
            aMapLocation.f8062f = parcel.readString();
            aMapLocation.f8072p = parcel.readInt();
            aMapLocation.f8073q = parcel.readString();
            aMapLocation.f8058b = parcel.readString();
            aMapLocation.F = parcel.readInt() != 0;
            aMapLocation.f8071o = parcel.readInt() != 0;
            aMapLocation.f8076t = parcel.readDouble();
            aMapLocation.f8074r = parcel.readString();
            aMapLocation.f8075s = parcel.readInt();
            aMapLocation.f8077u = parcel.readDouble();
            aMapLocation.D = parcel.readInt() != 0;
            aMapLocation.f8070n = parcel.readString();
            aMapLocation.f8066j = parcel.readString();
            aMapLocation.f8060d = parcel.readString();
            aMapLocation.f8068l = parcel.readString();
            aMapLocation.A = parcel.readInt();
            aMapLocation.C = parcel.readInt();
            aMapLocation.f8069m = parcel.readString();
            aMapLocation.E = parcel.readString();
            aMapLocation.G = parcel.readString();
            aMapLocation.H = parcel.readInt();
            aMapLocation.I = parcel.readInt();
            return aMapLocation;
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AMapLocation createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AMapLocation[] newArray(int i10) {
            return a(i10);
        }

        private static AMapLocation[] a(int i10) {
            return new AMapLocation[i10];
        }
    };
    public static final int ERROR_CODE_AIRPLANEMODE_WIFIOFF = 18;
    public static final int ERROR_CODE_FAILURE_AUTH = 7;
    public static final int ERROR_CODE_FAILURE_CELL = 11;
    public static final int ERROR_CODE_FAILURE_COARSE_LOCATION = 20;
    public static final int ERROR_CODE_FAILURE_CONNECTION = 4;
    public static final int ERROR_CODE_FAILURE_INIT = 9;
    public static final int ERROR_CODE_FAILURE_LOCATION = 6;
    public static final int ERROR_CODE_FAILURE_LOCATION_PARAMETER = 3;
    public static final int ERROR_CODE_FAILURE_LOCATION_PERMISSION = 12;
    public static final int ERROR_CODE_FAILURE_NOENOUGHSATELLITES = 14;
    public static final int ERROR_CODE_FAILURE_NOWIFIANDAP = 13;
    public static final int ERROR_CODE_FAILURE_PARSER = 5;
    public static final int ERROR_CODE_FAILURE_SIMULATION_LOCATION = 15;
    public static final int ERROR_CODE_FAILURE_WIFI_INFO = 2;
    public static final int ERROR_CODE_INVALID_PARAMETER = 1;
    public static final int ERROR_CODE_NOCGI_WIFIOFF = 19;
    public static final int ERROR_CODE_NO_COMPENSATION_CACHE = 33;
    public static final int ERROR_CODE_SERVICE_FAIL = 10;
    public static final int ERROR_CODE_UNKNOWN = 8;
    public static final int GPS_ACCURACY_BAD = 0;
    public static final int GPS_ACCURACY_GOOD = 1;
    public static final int GPS_ACCURACY_UNKNOWN = -1;
    public static final int LOCATION_COMPENSATION = 10;
    public static final int LOCATION_SUCCESS = 0;
    public static final int LOCATION_TYPE_AMAP = 7;
    public static final int LOCATION_TYPE_CELL = 6;
    public static final int LOCATION_TYPE_COARSE_LOCATION = 11;
    public static final int LOCATION_TYPE_FAST = 3;
    public static final int LOCATION_TYPE_FIX_CACHE = 4;
    public static final int LOCATION_TYPE_GPS = 1;
    public static final int LOCATION_TYPE_LAST_LOCATION_CACHE = 9;
    public static final int LOCATION_TYPE_OFFLINE = 8;
    public static final int LOCATION_TYPE_SAME_REQ = 2;
    public static final int LOCATION_TYPE_WIFI = 5;
    public static final int TRUSTED_LEVEL_BAD = 4;
    public static final int TRUSTED_LEVEL_HIGH = 1;
    public static final int TRUSTED_LEVEL_LOW = 3;
    public static final int TRUSTED_LEVEL_NORMAL = 2;
    private int A;
    private String B;
    private int C;
    private boolean D;
    private String E;
    private boolean F;
    private String G;
    private int H;
    private int I;

    /* renamed from: a, reason: collision with root package name */
    public String f8057a;

    /* renamed from: b, reason: collision with root package name */
    public String f8058b;

    /* renamed from: c, reason: collision with root package name */
    public AMapLocationQualityReport f8059c;

    /* renamed from: d, reason: collision with root package name */
    private String f8060d;

    /* renamed from: e, reason: collision with root package name */
    private String f8061e;

    /* renamed from: f, reason: collision with root package name */
    private String f8062f;

    /* renamed from: g, reason: collision with root package name */
    private String f8063g;

    /* renamed from: h, reason: collision with root package name */
    private String f8064h;

    /* renamed from: i, reason: collision with root package name */
    private String f8065i;

    /* renamed from: j, reason: collision with root package name */
    private String f8066j;

    /* renamed from: k, reason: collision with root package name */
    private String f8067k;

    /* renamed from: l, reason: collision with root package name */
    private String f8068l;

    /* renamed from: m, reason: collision with root package name */
    private String f8069m;

    /* renamed from: n, reason: collision with root package name */
    private String f8070n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f8071o;

    /* renamed from: p, reason: collision with root package name */
    private int f8072p;

    /* renamed from: q, reason: collision with root package name */
    private String f8073q;

    /* renamed from: r, reason: collision with root package name */
    private String f8074r;

    /* renamed from: s, reason: collision with root package name */
    private int f8075s;

    /* renamed from: t, reason: collision with root package name */
    private double f8076t;

    /* renamed from: u, reason: collision with root package name */
    private double f8077u;

    /* renamed from: v, reason: collision with root package name */
    private double f8078v;

    /* renamed from: w, reason: collision with root package name */
    private float f8079w;

    /* renamed from: x, reason: collision with root package name */
    private float f8080x;

    /* renamed from: y, reason: collision with root package name */
    private Bundle f8081y;

    /* renamed from: z, reason: collision with root package name */
    private String f8082z;

    public AMapLocation(String str) {
        super(str);
        this.f8060d = "";
        this.f8061e = "";
        this.f8062f = "";
        this.f8063g = "";
        this.f8064h = "";
        this.f8065i = "";
        this.f8066j = "";
        this.f8067k = "";
        this.f8068l = "";
        this.f8069m = "";
        this.f8070n = "";
        this.f8071o = true;
        this.f8072p = 0;
        this.f8073q = "success";
        this.f8074r = "";
        this.f8075s = 0;
        this.f8076t = ShadowDrawableWrapper.COS_45;
        this.f8077u = ShadowDrawableWrapper.COS_45;
        this.f8078v = ShadowDrawableWrapper.COS_45;
        this.f8079w = 0.0f;
        this.f8080x = 0.0f;
        this.f8081y = null;
        this.A = 0;
        this.B = "";
        this.C = -1;
        this.D = false;
        this.E = "";
        this.F = false;
        this.f8057a = "";
        this.f8058b = "";
        this.f8059c = new AMapLocationQualityReport();
        this.G = COORD_TYPE_GCJ02;
        this.H = 1;
        this.f8082z = str;
    }

    @Override // android.location.Location, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.location.Location
    public float getAccuracy() {
        return super.getAccuracy();
    }

    public String getAdCode() {
        return this.f8064h;
    }

    public String getAddress() {
        return this.f8065i;
    }

    @Override // android.location.Location
    public double getAltitude() {
        return this.f8078v;
    }

    public String getAoiName() {
        return this.B;
    }

    @Override // android.location.Location
    public float getBearing() {
        return this.f8080x;
    }

    public String getBuildingId() {
        return this.f8057a;
    }

    public String getCity() {
        return this.f8061e;
    }

    public String getCityCode() {
        return this.f8063g;
    }

    public int getConScenario() {
        return this.I;
    }

    public String getCoordType() {
        return this.G;
    }

    public String getCountry() {
        return this.f8067k;
    }

    public String getDescription() {
        return this.E;
    }

    public String getDistrict() {
        return this.f8062f;
    }

    public int getErrorCode() {
        return this.f8072p;
    }

    public String getErrorInfo() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f8073q);
        if (this.f8072p != 0) {
            sb2.append(" 请到http://lbs.amap.com/api/android-location-sdk/guide/utilities/errorcode/查看错误码说明");
            sb2.append(",错误详细信息:" + this.f8074r);
        }
        return sb2.toString();
    }

    @Override // android.location.Location
    public Bundle getExtras() {
        return this.f8081y;
    }

    public String getFloor() {
        return this.f8058b;
    }

    public int getGpsAccuracyStatus() {
        return this.C;
    }

    @Override // android.location.Location
    public double getLatitude() {
        return this.f8076t;
    }

    public String getLocationDetail() {
        return this.f8074r;
    }

    public AMapLocationQualityReport getLocationQualityReport() {
        return this.f8059c;
    }

    public int getLocationType() {
        return this.f8075s;
    }

    @Override // android.location.Location
    public double getLongitude() {
        return this.f8077u;
    }

    public String getPoiName() {
        return this.f8066j;
    }

    @Override // android.location.Location
    public String getProvider() {
        return this.f8082z;
    }

    public String getProvince() {
        return this.f8060d;
    }

    public String getRoad() {
        return this.f8068l;
    }

    public int getSatellites() {
        return this.A;
    }

    @Override // android.location.Location
    public float getSpeed() {
        return this.f8079w;
    }

    public String getStreet() {
        return this.f8069m;
    }

    public String getStreetNum() {
        return this.f8070n;
    }

    public int getTrustedLevel() {
        return this.H;
    }

    public boolean isFixLastLocation() {
        return this.F;
    }

    @Override // android.location.Location
    public boolean isMock() {
        return this.D;
    }

    public boolean isOffset() {
        return this.f8071o;
    }

    public void setAdCode(String str) {
        this.f8064h = str;
    }

    public void setAddress(String str) {
        this.f8065i = str;
    }

    @Override // android.location.Location
    public void setAltitude(double d10) {
        super.setAltitude(d10);
        this.f8078v = d10;
    }

    public void setAoiName(String str) {
        this.B = str;
    }

    @Override // android.location.Location
    public void setBearing(float f10) {
        super.setBearing(f10);
        while (f10 < 0.0f) {
            f10 += 360.0f;
        }
        while (f10 >= 360.0f) {
            f10 -= 360.0f;
        }
        this.f8080x = f10;
    }

    public void setBuildingId(String str) {
        this.f8057a = str;
    }

    public void setCity(String str) {
        this.f8061e = str;
    }

    public void setCityCode(String str) {
        this.f8063g = str;
    }

    public void setConScenario(int i10) {
        this.I = i10;
    }

    public void setCoordType(String str) {
        this.G = str;
    }

    public void setCountry(String str) {
        this.f8067k = str;
    }

    public void setDescription(String str) {
        this.E = str;
    }

    public void setDistrict(String str) {
        this.f8062f = str;
    }

    public void setErrorCode(int i10) {
        if (this.f8072p != 0) {
            return;
        }
        this.f8073q = j.a(i10);
        this.f8072p = i10;
    }

    public void setErrorInfo(String str) {
        this.f8073q = str;
    }

    @Override // android.location.Location
    public void setExtras(Bundle bundle) {
        super.setExtras(bundle);
        this.f8081y = bundle == null ? null : new Bundle(bundle);
    }

    public void setFixLastLocation(boolean z10) {
        this.F = z10;
    }

    public void setFloor(String str) {
        if (!TextUtils.isEmpty(str)) {
            str = str.replace("F", "");
            try {
                Integer.parseInt(str);
            } catch (Throwable th) {
                b.a(th, "AmapLoc", "setFloor");
                str = null;
            }
        }
        this.f8058b = str;
    }

    public void setGpsAccuracyStatus(int i10) {
        this.C = i10;
    }

    @Override // android.location.Location
    public void setLatitude(double d10) {
        this.f8076t = d10;
    }

    public void setLocationDetail(String str) {
        this.f8074r = str;
    }

    public void setLocationQualityReport(AMapLocationQualityReport aMapLocationQualityReport) {
        if (aMapLocationQualityReport == null) {
            return;
        }
        this.f8059c = aMapLocationQualityReport;
    }

    public void setLocationType(int i10) {
        this.f8075s = i10;
    }

    @Override // android.location.Location
    public void setLongitude(double d10) {
        this.f8077u = d10;
    }

    @Override // android.location.Location
    public void setMock(boolean z10) {
        this.D = z10;
    }

    public void setNumber(String str) {
        this.f8070n = str;
    }

    public void setOffset(boolean z10) {
        this.f8071o = z10;
    }

    public void setPoiName(String str) {
        this.f8066j = str;
    }

    @Override // android.location.Location
    public void setProvider(String str) {
        super.setProvider(str);
        this.f8082z = str;
    }

    public void setProvince(String str) {
        this.f8060d = str;
    }

    public void setRoad(String str) {
        this.f8068l = str;
    }

    public void setSatellites(int i10) {
        this.A = i10;
    }

    @Override // android.location.Location
    public void setSpeed(float f10) {
        super.setSpeed(f10);
        this.f8079w = f10;
    }

    public void setStreet(String str) {
        this.f8069m = str;
    }

    public void setTrustedLevel(int i10) {
        this.H = i10;
    }

    public JSONObject toJson(int i10) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (i10 == 1) {
                try {
                    jSONObject.put("altitude", getAltitude());
                    jSONObject.put("speed", getSpeed());
                    jSONObject.put("bearing", getBearing());
                } catch (Throwable unused) {
                }
                jSONObject.put("citycode", this.f8063g);
                jSONObject.put("adcode", this.f8064h);
                jSONObject.put("country", this.f8067k);
                jSONObject.put(DistrictSearchQuery.KEYWORDS_PROVINCE, this.f8060d);
                jSONObject.put(DistrictSearchQuery.KEYWORDS_CITY, this.f8061e);
                jSONObject.put(DistrictSearchQuery.KEYWORDS_DISTRICT, this.f8062f);
                jSONObject.put("road", this.f8068l);
                jSONObject.put("street", this.f8069m);
                jSONObject.put("number", this.f8070n);
                jSONObject.put("poiname", this.f8066j);
                jSONObject.put("errorCode", this.f8072p);
                jSONObject.put(MyLocationStyle.ERROR_INFO, this.f8073q);
                jSONObject.put(MyLocationStyle.LOCATION_TYPE, this.f8075s);
                jSONObject.put("locationDetail", this.f8074r);
                jSONObject.put("aoiname", this.B);
                jSONObject.put(TextClassifier.TYPE_ADDRESS, this.f8065i);
                jSONObject.put("poiid", this.f8057a);
                jSONObject.put("floor", this.f8058b);
                jSONObject.put("description", this.E);
            } else if (i10 != 2) {
                if (i10 != 3) {
                    return jSONObject;
                }
                jSONObject.put("provider", getProvider());
                jSONObject.put("lon", getLongitude());
                jSONObject.put("lat", getLatitude());
                jSONObject.put("accuracy", getAccuracy());
                jSONObject.put("isOffset", this.f8071o);
                jSONObject.put("isFixLastLocation", this.F);
                jSONObject.put("coordType", this.G);
                return jSONObject;
            }
            jSONObject.put("time", getTime());
            jSONObject.put("provider", getProvider());
            jSONObject.put("lon", getLongitude());
            jSONObject.put("lat", getLatitude());
            jSONObject.put("accuracy", getAccuracy());
            jSONObject.put("isOffset", this.f8071o);
            jSONObject.put("isFixLastLocation", this.F);
            jSONObject.put("coordType", this.G);
            return jSONObject;
        } catch (Throwable th) {
            b.a(th, "AmapLoc", "toStr");
            return null;
        }
    }

    public String toStr() {
        return toStr(1);
    }

    @Override // android.location.Location
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            stringBuffer.append("latitude=" + this.f8076t + "#");
            stringBuffer.append("longitude=" + this.f8077u + "#");
            stringBuffer.append("province=" + this.f8060d + "#");
            stringBuffer.append("coordType=" + this.G + "#");
            stringBuffer.append("city=" + this.f8061e + "#");
            stringBuffer.append("district=" + this.f8062f + "#");
            stringBuffer.append("cityCode=" + this.f8063g + "#");
            stringBuffer.append("adCode=" + this.f8064h + "#");
            stringBuffer.append("address=" + this.f8065i + "#");
            stringBuffer.append("country=" + this.f8067k + "#");
            stringBuffer.append("road=" + this.f8068l + "#");
            stringBuffer.append("poiName=" + this.f8066j + "#");
            stringBuffer.append("street=" + this.f8069m + "#");
            stringBuffer.append("streetNum=" + this.f8070n + "#");
            stringBuffer.append("aoiName=" + this.B + "#");
            stringBuffer.append("poiid=" + this.f8057a + "#");
            stringBuffer.append("floor=" + this.f8058b + "#");
            stringBuffer.append("errorCode=" + this.f8072p + "#");
            stringBuffer.append("errorInfo=" + this.f8073q + "#");
            stringBuffer.append("locationDetail=" + this.f8074r + "#");
            stringBuffer.append("description=" + this.E + "#");
            stringBuffer.append("locationType=" + this.f8075s + "#");
            StringBuilder sb2 = new StringBuilder("conScenario=");
            sb2.append(this.I);
            stringBuffer.append(sb2.toString());
        } catch (Throwable unused) {
        }
        return stringBuffer.toString();
    }

    @Override // android.location.Location, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        try {
            super.writeToParcel(parcel, i10);
            parcel.writeString(this.f8064h);
            parcel.writeString(this.f8065i);
            parcel.writeString(this.B);
            parcel.writeString(this.f8057a);
            parcel.writeString(this.f8061e);
            parcel.writeString(this.f8063g);
            parcel.writeString(this.f8067k);
            parcel.writeString(this.f8062f);
            parcel.writeInt(this.f8072p);
            parcel.writeString(this.f8073q);
            parcel.writeString(this.f8058b);
            int i11 = 1;
            parcel.writeInt(this.F ? 1 : 0);
            parcel.writeInt(this.f8071o ? 1 : 0);
            parcel.writeDouble(this.f8076t);
            parcel.writeString(this.f8074r);
            parcel.writeInt(this.f8075s);
            parcel.writeDouble(this.f8077u);
            if (!this.D) {
                i11 = 0;
            }
            parcel.writeInt(i11);
            parcel.writeString(this.f8070n);
            parcel.writeString(this.f8066j);
            parcel.writeString(this.f8060d);
            parcel.writeString(this.f8068l);
            parcel.writeInt(this.A);
            parcel.writeInt(this.C);
            parcel.writeString(this.f8069m);
            parcel.writeString(this.E);
            parcel.writeString(this.G);
            parcel.writeInt(this.H);
            parcel.writeInt(this.I);
        } catch (Throwable th) {
            b.a(th, "AMapLocation", "writeToParcel");
        }
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public AMapLocation m1956clone() {
        try {
            super.clone();
        } catch (Throwable unused) {
        }
        AMapLocation aMapLocation = new AMapLocation(this);
        try {
            aMapLocation.setLatitude(this.f8076t);
            aMapLocation.setLongitude(this.f8077u);
            aMapLocation.setAdCode(this.f8064h);
            aMapLocation.setAddress(this.f8065i);
            aMapLocation.setAoiName(this.B);
            aMapLocation.setBuildingId(this.f8057a);
            aMapLocation.setCity(this.f8061e);
            aMapLocation.setCityCode(this.f8063g);
            aMapLocation.setCountry(this.f8067k);
            aMapLocation.setDistrict(this.f8062f);
            aMapLocation.setErrorCode(this.f8072p);
            aMapLocation.setErrorInfo(this.f8073q);
            aMapLocation.setFloor(this.f8058b);
            aMapLocation.setFixLastLocation(this.F);
            aMapLocation.setOffset(this.f8071o);
            aMapLocation.setLocationDetail(this.f8074r);
            aMapLocation.setLocationType(this.f8075s);
            aMapLocation.setMock(this.D);
            aMapLocation.setNumber(this.f8070n);
            aMapLocation.setPoiName(this.f8066j);
            aMapLocation.setProvince(this.f8060d);
            aMapLocation.setRoad(this.f8068l);
            aMapLocation.setSatellites(this.A);
            aMapLocation.setGpsAccuracyStatus(this.C);
            aMapLocation.setStreet(this.f8069m);
            aMapLocation.setDescription(this.E);
            aMapLocation.setExtras(getExtras());
            AMapLocationQualityReport aMapLocationQualityReport = this.f8059c;
            if (aMapLocationQualityReport != null) {
                aMapLocation.setLocationQualityReport(aMapLocationQualityReport.m1958clone());
            }
            aMapLocation.setCoordType(this.G);
            aMapLocation.setTrustedLevel(this.H);
            aMapLocation.setConScenario(this.I);
        } catch (Throwable th) {
            b.a(th, "AMapLocation", "clone");
        }
        return aMapLocation;
    }

    public String toStr(int i10) {
        JSONObject jSONObject;
        try {
            jSONObject = toJson(i10);
        } catch (Throwable th) {
            b.a(th, "AMapLocation", "toStr part2");
            jSONObject = null;
        }
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.toString();
    }

    public AMapLocation(Location location) {
        super(location);
        this.f8060d = "";
        this.f8061e = "";
        this.f8062f = "";
        this.f8063g = "";
        this.f8064h = "";
        this.f8065i = "";
        this.f8066j = "";
        this.f8067k = "";
        this.f8068l = "";
        this.f8069m = "";
        this.f8070n = "";
        this.f8071o = true;
        this.f8072p = 0;
        this.f8073q = "success";
        this.f8074r = "";
        this.f8075s = 0;
        this.f8076t = ShadowDrawableWrapper.COS_45;
        this.f8077u = ShadowDrawableWrapper.COS_45;
        this.f8078v = ShadowDrawableWrapper.COS_45;
        this.f8079w = 0.0f;
        this.f8080x = 0.0f;
        this.f8081y = null;
        this.A = 0;
        this.B = "";
        this.C = -1;
        this.D = false;
        this.E = "";
        this.F = false;
        this.f8057a = "";
        this.f8058b = "";
        this.f8059c = new AMapLocationQualityReport();
        this.G = COORD_TYPE_GCJ02;
        this.H = 1;
        this.f8076t = location.getLatitude();
        this.f8077u = location.getLongitude();
        this.f8078v = location.getAltitude();
        this.f8080x = location.getBearing();
        this.f8079w = location.getSpeed();
        this.f8082z = location.getProvider();
        this.f8081y = location.getExtras() != null ? new Bundle(location.getExtras()) : null;
    }
}
