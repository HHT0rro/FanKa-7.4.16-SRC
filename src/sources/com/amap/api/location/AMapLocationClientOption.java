package com.amap.api.location;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.app.NotificationCompat;
import com.autonavi.aps.amapapi.utils.b;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class AMapLocationClientOption implements Parcelable, Cloneable {

    /* renamed from: d, reason: collision with root package name */
    private static int f8086d = 0;

    /* renamed from: e, reason: collision with root package name */
    private static int f8087e = 1;

    /* renamed from: f, reason: collision with root package name */
    private static int f8088f = 2;

    /* renamed from: g, reason: collision with root package name */
    private static int f8089g = 4;
    private boolean A;
    private int B;
    private int C;
    private boolean D;
    private boolean E;
    private float F;
    private AMapLocationPurpose G;

    /* renamed from: b, reason: collision with root package name */
    public boolean f8091b;

    /* renamed from: c, reason: collision with root package name */
    public String f8092c;

    /* renamed from: h, reason: collision with root package name */
    private long f8093h;

    /* renamed from: i, reason: collision with root package name */
    private long f8094i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f8095j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f8096k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f8097l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f8098m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f8099n;

    /* renamed from: o, reason: collision with root package name */
    private AMapLocationMode f8100o;

    /* renamed from: q, reason: collision with root package name */
    private boolean f8101q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f8102r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f8103s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f8104t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f8105u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f8106v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f8107w;

    /* renamed from: x, reason: collision with root package name */
    private long f8108x;

    /* renamed from: y, reason: collision with root package name */
    private long f8109y;

    /* renamed from: z, reason: collision with root package name */
    private GeoLanguage f8110z;

    /* renamed from: p, reason: collision with root package name */
    private static AMapLocationProtocol f8090p = AMapLocationProtocol.HTTP;

    /* renamed from: a, reason: collision with root package name */
    public static String f8085a = "";
    public static final Parcelable.Creator<AMapLocationClientOption> CREATOR = new Parcelable.Creator<AMapLocationClientOption>() { // from class: com.amap.api.location.AMapLocationClientOption.1
        private static AMapLocationClientOption a(Parcel parcel) {
            return new AMapLocationClientOption(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AMapLocationClientOption createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AMapLocationClientOption[] newArray(int i10) {
            return a(i10);
        }

        private static AMapLocationClientOption[] a(int i10) {
            return new AMapLocationClientOption[i10];
        }
    };
    public static boolean OPEN_ALWAYS_SCAN_WIFI = true;
    public static long SCAN_WIFI_INTERVAL = 30000;

    /* renamed from: com.amap.api.location.AMapLocationClientOption$2, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f8111a;

        static {
            int[] iArr = new int[AMapLocationPurpose.values().length];
            f8111a = iArr;
            try {
                iArr[AMapLocationPurpose.SignIn.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8111a[AMapLocationPurpose.Transport.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8111a[AMapLocationPurpose.Sport.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public enum AMapLocationMode {
        Battery_Saving,
        Device_Sensors,
        Hight_Accuracy
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public enum AMapLocationProtocol {
        HTTP(0),
        HTTPS(1);


        /* renamed from: a, reason: collision with root package name */
        private int f8114a;

        AMapLocationProtocol(int i10) {
            this.f8114a = i10;
        }

        public final int getValue() {
            return this.f8114a;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public enum AMapLocationPurpose {
        SignIn,
        Transport,
        Sport
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public enum GeoLanguage {
        DEFAULT,
        ZH,
        EN
    }

    public AMapLocationClientOption() {
        this.f8093h = 2000L;
        this.f8094i = b.f9640i;
        this.f8095j = false;
        this.f8096k = true;
        this.f8097l = true;
        this.f8098m = true;
        this.f8099n = true;
        this.f8100o = AMapLocationMode.Hight_Accuracy;
        this.f8101q = false;
        this.f8102r = false;
        this.f8103s = true;
        this.f8104t = true;
        this.f8105u = false;
        this.f8106v = false;
        this.f8107w = true;
        this.f8108x = 30000L;
        this.f8109y = 30000L;
        this.f8110z = GeoLanguage.DEFAULT;
        this.A = false;
        this.B = 1500;
        this.C = 21600000;
        this.D = false;
        this.E = true;
        this.F = 0.0f;
        this.G = null;
        this.f8091b = false;
        this.f8092c = null;
    }

    private AMapLocationClientOption a(AMapLocationClientOption aMapLocationClientOption) {
        this.f8093h = aMapLocationClientOption.f8093h;
        this.f8095j = aMapLocationClientOption.f8095j;
        this.f8100o = aMapLocationClientOption.f8100o;
        this.f8096k = aMapLocationClientOption.f8096k;
        this.f8101q = aMapLocationClientOption.f8101q;
        this.f8102r = aMapLocationClientOption.f8102r;
        this.D = aMapLocationClientOption.D;
        this.f8097l = aMapLocationClientOption.f8097l;
        this.f8098m = aMapLocationClientOption.f8098m;
        this.f8094i = aMapLocationClientOption.f8094i;
        this.f8103s = aMapLocationClientOption.f8103s;
        this.f8104t = aMapLocationClientOption.f8104t;
        this.f8105u = aMapLocationClientOption.f8105u;
        this.f8106v = aMapLocationClientOption.isSensorEnable();
        this.f8107w = aMapLocationClientOption.isWifiScan();
        this.f8108x = aMapLocationClientOption.f8108x;
        setLocationProtocol(aMapLocationClientOption.getLocationProtocol());
        this.f8110z = aMapLocationClientOption.f8110z;
        setDownloadCoordinateConvertLibrary(isDownloadCoordinateConvertLibrary());
        this.F = aMapLocationClientOption.F;
        this.G = aMapLocationClientOption.G;
        setOpenAlwaysScanWifi(isOpenAlwaysScanWifi());
        setScanWifiInterval(aMapLocationClientOption.getScanWifiInterval());
        this.f8109y = aMapLocationClientOption.f8109y;
        this.C = aMapLocationClientOption.getCacheTimeOut();
        this.A = aMapLocationClientOption.getCacheCallBack();
        this.B = aMapLocationClientOption.getCacheCallBackTime();
        this.E = aMapLocationClientOption.isSelfStartServiceEnable();
        return this;
    }

    public static String getAPIKEY() {
        return f8085a;
    }

    public static boolean isDownloadCoordinateConvertLibrary() {
        return false;
    }

    public static boolean isOpenAlwaysScanWifi() {
        return OPEN_ALWAYS_SCAN_WIFI;
    }

    public static void setDownloadCoordinateConvertLibrary(boolean z10) {
    }

    public static void setLocationProtocol(AMapLocationProtocol aMapLocationProtocol) {
        f8090p = aMapLocationProtocol;
    }

    public static void setOpenAlwaysScanWifi(boolean z10) {
        OPEN_ALWAYS_SCAN_WIFI = z10;
    }

    public static void setScanWifiInterval(long j10) {
        SCAN_WIFI_INTERVAL = j10;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean getCacheCallBack() {
        return this.A;
    }

    public int getCacheCallBackTime() {
        return this.B;
    }

    public int getCacheTimeOut() {
        return this.C;
    }

    public float getDeviceModeDistanceFilter() {
        return this.F;
    }

    public GeoLanguage getGeoLanguage() {
        return this.f8110z;
    }

    public long getGpsFirstTimeout() {
        return this.f8109y;
    }

    public long getHttpTimeOut() {
        return this.f8094i;
    }

    public long getInterval() {
        return this.f8093h;
    }

    public long getLastLocationLifeCycle() {
        return this.f8108x;
    }

    public AMapLocationMode getLocationMode() {
        return this.f8100o;
    }

    public AMapLocationProtocol getLocationProtocol() {
        return f8090p;
    }

    public AMapLocationPurpose getLocationPurpose() {
        return this.G;
    }

    public long getScanWifiInterval() {
        return SCAN_WIFI_INTERVAL;
    }

    public boolean isBeidouFirst() {
        return this.D;
    }

    public boolean isGpsFirst() {
        return this.f8102r;
    }

    public boolean isKillProcess() {
        return this.f8101q;
    }

    public boolean isLocationCacheEnable() {
        return this.f8104t;
    }

    public boolean isMockEnable() {
        return this.f8096k;
    }

    public boolean isNeedAddress() {
        return this.f8097l;
    }

    public boolean isOffset() {
        return this.f8103s;
    }

    public boolean isOnceLocation() {
        return this.f8095j;
    }

    public boolean isOnceLocationLatest() {
        return this.f8105u;
    }

    public boolean isSelfStartServiceEnable() {
        return this.E;
    }

    public boolean isSensorEnable() {
        return this.f8106v;
    }

    public boolean isWifiActiveScan() {
        return this.f8098m;
    }

    public boolean isWifiScan() {
        return this.f8107w;
    }

    public AMapLocationClientOption setBeidouFirst(boolean z10) {
        this.D = z10;
        return this;
    }

    public void setCacheCallBack(boolean z10) {
        this.A = z10;
    }

    public void setCacheCallBackTime(int i10) {
        this.B = i10;
    }

    public void setCacheTimeOut(int i10) {
        this.C = i10;
    }

    public AMapLocationClientOption setDeviceModeDistanceFilter(float f10) {
        if (f10 < 0.0f) {
            f10 = 0.0f;
        }
        this.F = f10;
        return this;
    }

    public AMapLocationClientOption setGeoLanguage(GeoLanguage geoLanguage) {
        this.f8110z = geoLanguage;
        return this;
    }

    public AMapLocationClientOption setGpsFirst(boolean z10) {
        this.f8102r = z10;
        return this;
    }

    public AMapLocationClientOption setGpsFirstTimeout(long j10) {
        if (j10 < 5000) {
            j10 = 5000;
        }
        if (j10 > 30000) {
            j10 = 30000;
        }
        this.f8109y = j10;
        return this;
    }

    public AMapLocationClientOption setHttpTimeOut(long j10) {
        this.f8094i = j10;
        return this;
    }

    public AMapLocationClientOption setInterval(long j10) {
        if (j10 <= 800) {
            j10 = 800;
        }
        this.f8093h = j10;
        return this;
    }

    public AMapLocationClientOption setKillProcess(boolean z10) {
        this.f8101q = z10;
        return this;
    }

    public AMapLocationClientOption setLastLocationLifeCycle(long j10) {
        this.f8108x = j10;
        return this;
    }

    public AMapLocationClientOption setLocationCacheEnable(boolean z10) {
        this.f8104t = z10;
        return this;
    }

    public AMapLocationClientOption setLocationMode(AMapLocationMode aMapLocationMode) {
        this.f8100o = aMapLocationMode;
        return this;
    }

    public AMapLocationClientOption setLocationPurpose(AMapLocationPurpose aMapLocationPurpose) {
        this.G = aMapLocationPurpose;
        if (aMapLocationPurpose != null) {
            int i10 = AnonymousClass2.f8111a[aMapLocationPurpose.ordinal()];
            if (i10 == 1) {
                this.f8100o = AMapLocationMode.Hight_Accuracy;
                this.f8095j = true;
                this.f8105u = true;
                this.f8102r = false;
                this.D = false;
                this.f8096k = false;
                this.f8107w = true;
                this.E = true;
                int i11 = f8086d;
                int i12 = f8087e;
                if ((i11 & i12) == 0) {
                    this.f8091b = true;
                    f8086d = i11 | i12;
                    this.f8092c = "signin";
                }
            } else if (i10 == 2) {
                int i13 = f8086d;
                int i14 = f8088f;
                if ((i13 & i14) == 0) {
                    this.f8091b = true;
                    f8086d = i13 | i14;
                    this.f8092c = NotificationCompat.CATEGORY_TRANSPORT;
                }
                this.f8100o = AMapLocationMode.Hight_Accuracy;
                this.f8095j = false;
                this.f8105u = false;
                this.f8102r = true;
                this.D = false;
                this.E = true;
                this.f8096k = false;
                this.f8107w = true;
            } else if (i10 == 3) {
                int i15 = f8086d;
                int i16 = f8089g;
                if ((i15 & i16) == 0) {
                    this.f8091b = true;
                    f8086d = i15 | i16;
                    this.f8092c = "sport";
                }
                this.f8100o = AMapLocationMode.Hight_Accuracy;
                this.f8095j = false;
                this.f8105u = false;
                this.f8102r = true;
                this.D = false;
                this.E = true;
                this.f8096k = false;
                this.f8107w = true;
            }
        }
        return this;
    }

    public AMapLocationClientOption setMockEnable(boolean z10) {
        this.f8096k = z10;
        return this;
    }

    public AMapLocationClientOption setNeedAddress(boolean z10) {
        this.f8097l = z10;
        return this;
    }

    public AMapLocationClientOption setOffset(boolean z10) {
        this.f8103s = z10;
        return this;
    }

    public AMapLocationClientOption setOnceLocation(boolean z10) {
        this.f8095j = z10;
        return this;
    }

    public AMapLocationClientOption setOnceLocationLatest(boolean z10) {
        this.f8105u = z10;
        return this;
    }

    public void setSelfStartServiceEnable(boolean z10) {
        this.E = z10;
    }

    public AMapLocationClientOption setSensorEnable(boolean z10) {
        this.f8106v = z10;
        return this;
    }

    public AMapLocationClientOption setWifiActiveScan(boolean z10) {
        this.f8098m = z10;
        this.f8099n = z10;
        return this;
    }

    public AMapLocationClientOption setWifiScan(boolean z10) {
        this.f8107w = z10;
        if (z10) {
            this.f8098m = this.f8099n;
        } else {
            this.f8098m = false;
        }
        return this;
    }

    public String toString() {
        return "interval:" + String.valueOf(this.f8093h) + "#isOnceLocation:" + String.valueOf(this.f8095j) + "#locationMode:" + String.valueOf(this.f8100o) + "#locationProtocol:" + String.valueOf(f8090p) + "#isMockEnable:" + String.valueOf(this.f8096k) + "#isKillProcess:" + String.valueOf(this.f8101q) + "#isGpsFirst:" + String.valueOf(this.f8102r) + "#isBeidouFirst:" + String.valueOf(this.D) + "#isSelfStartServiceEnable:" + String.valueOf(this.E) + "#isNeedAddress:" + String.valueOf(this.f8097l) + "#isWifiActiveScan:" + String.valueOf(this.f8098m) + "#wifiScan:" + String.valueOf(this.f8107w) + "#httpTimeOut:" + String.valueOf(this.f8094i) + "#isLocationCacheEnable:" + String.valueOf(this.f8104t) + "#isOnceLocationLatest:" + String.valueOf(this.f8105u) + "#sensorEnable:" + String.valueOf(this.f8106v) + "#geoLanguage:" + String.valueOf(this.f8110z) + "#locationPurpose:" + String.valueOf(this.G) + "#callback:" + String.valueOf(this.A) + "#time:" + String.valueOf(this.B) + "#";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeLong(this.f8093h);
        parcel.writeLong(this.f8094i);
        parcel.writeByte(this.f8095j ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f8096k ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f8097l ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f8098m ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f8099n ? (byte) 1 : (byte) 0);
        AMapLocationMode aMapLocationMode = this.f8100o;
        parcel.writeInt(aMapLocationMode == null ? -1 : aMapLocationMode.ordinal());
        parcel.writeByte(this.f8101q ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f8102r ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.D ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.E ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f8103s ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f8104t ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f8105u ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f8106v ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f8107w ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f8108x);
        parcel.writeInt(f8090p == null ? -1 : getLocationProtocol().ordinal());
        GeoLanguage geoLanguage = this.f8110z;
        parcel.writeInt(geoLanguage == null ? -1 : geoLanguage.ordinal());
        parcel.writeFloat(this.F);
        AMapLocationPurpose aMapLocationPurpose = this.G;
        parcel.writeInt(aMapLocationPurpose != null ? aMapLocationPurpose.ordinal() : -1);
        parcel.writeInt(OPEN_ALWAYS_SCAN_WIFI ? 1 : 0);
        parcel.writeLong(this.f8109y);
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public AMapLocationClientOption m1957clone() {
        try {
            super.clone();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return new AMapLocationClientOption().a(this);
    }

    public AMapLocationClientOption(Parcel parcel) {
        this.f8093h = 2000L;
        this.f8094i = b.f9640i;
        this.f8095j = false;
        this.f8096k = true;
        this.f8097l = true;
        this.f8098m = true;
        this.f8099n = true;
        AMapLocationMode aMapLocationMode = AMapLocationMode.Hight_Accuracy;
        this.f8100o = aMapLocationMode;
        this.f8101q = false;
        this.f8102r = false;
        this.f8103s = true;
        this.f8104t = true;
        this.f8105u = false;
        this.f8106v = false;
        this.f8107w = true;
        this.f8108x = 30000L;
        this.f8109y = 30000L;
        GeoLanguage geoLanguage = GeoLanguage.DEFAULT;
        this.f8110z = geoLanguage;
        this.A = false;
        this.B = 1500;
        this.C = 21600000;
        this.D = false;
        this.E = true;
        this.F = 0.0f;
        this.G = null;
        this.f8091b = false;
        this.f8092c = null;
        this.f8093h = parcel.readLong();
        this.f8094i = parcel.readLong();
        this.f8095j = parcel.readByte() != 0;
        this.f8096k = parcel.readByte() != 0;
        this.f8097l = parcel.readByte() != 0;
        this.f8098m = parcel.readByte() != 0;
        this.f8099n = parcel.readByte() != 0;
        int readInt = parcel.readInt();
        this.f8100o = readInt != -1 ? AMapLocationMode.values()[readInt] : aMapLocationMode;
        this.f8101q = parcel.readByte() != 0;
        this.f8102r = parcel.readByte() != 0;
        this.D = parcel.readByte() != 0;
        this.E = parcel.readByte() != 0;
        this.f8103s = parcel.readByte() != 0;
        this.f8104t = parcel.readByte() != 0;
        this.f8105u = parcel.readByte() != 0;
        this.f8106v = parcel.readByte() != 0;
        this.f8107w = parcel.readByte() != 0;
        this.f8108x = parcel.readLong();
        int readInt2 = parcel.readInt();
        f8090p = readInt2 == -1 ? AMapLocationProtocol.HTTP : AMapLocationProtocol.values()[readInt2];
        int readInt3 = parcel.readInt();
        this.f8110z = readInt3 != -1 ? GeoLanguage.values()[readInt3] : geoLanguage;
        this.F = parcel.readFloat();
        int readInt4 = parcel.readInt();
        this.G = readInt4 != -1 ? AMapLocationPurpose.values()[readInt4] : null;
        OPEN_ALWAYS_SCAN_WIFI = parcel.readByte() != 0;
        this.f8109y = parcel.readLong();
    }
}
