package com.amap.api.location;

import com.amap.api.location.AMapLocationClientOption;
import com.autonavi.aps.amapapi.utils.b;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class AMapLocationQualityReport implements Cloneable {
    public static final int GPS_STATUS_MODE_SAVING = 3;
    public static final int GPS_STATUS_NOGPSPERMISSION = 4;
    public static final int GPS_STATUS_NOGPSPROVIDER = 1;
    public static final int GPS_STATUS_OFF = 2;
    public static final int GPS_STATUS_OK = 0;

    /* renamed from: b, reason: collision with root package name */
    private boolean f8118b = false;

    /* renamed from: c, reason: collision with root package name */
    private int f8119c = 2;

    /* renamed from: d, reason: collision with root package name */
    private int f8120d = 0;

    /* renamed from: e, reason: collision with root package name */
    private String f8121e = GrsBaseInfo.CountryCodeSource.UNKNOWN;

    /* renamed from: f, reason: collision with root package name */
    private long f8122f = 0;

    /* renamed from: g, reason: collision with root package name */
    private boolean f8123g = false;

    /* renamed from: a, reason: collision with root package name */
    public AMapLocationClientOption.AMapLocationMode f8117a = AMapLocationClientOption.AMapLocationMode.Hight_Accuracy;

    public String getAdviseMessage() {
        StringBuffer stringBuffer = new StringBuffer();
        AMapLocationClientOption.AMapLocationMode aMapLocationMode = this.f8117a;
        if (aMapLocationMode != AMapLocationClientOption.AMapLocationMode.Battery_Saving) {
            int i10 = this.f8119c;
            if (i10 != 0) {
                if (i10 == 1) {
                    stringBuffer.append("您的设备没有GPS模块或者GPS模块异常，无法进行GPS定位\n");
                } else if (i10 == 2) {
                    stringBuffer.append("您的设备关闭了GPS定位功能，开启GPS定位功能有助于提高定位的精确度\n");
                } else if (i10 == 3) {
                    stringBuffer.append("您的设备当前设置的定位模式不包含GPS定位，选择包含GPS模式的定位模式有助于提高定位的精确度\n");
                } else if (i10 == 4) {
                    stringBuffer.append("您的设置禁用了GPS定位权限，开启GPS定位权限有助于提高定位的精确度\n");
                }
            } else if (aMapLocationMode == AMapLocationClientOption.AMapLocationMode.Device_Sensors && this.f8120d < 4) {
                stringBuffer.append("当前GPS信号弱，位置更新可能会延迟\n");
            }
        }
        if (this.f8117a != AMapLocationClientOption.AMapLocationMode.Device_Sensors) {
            if ("DISCONNECTED".equals(this.f8121e)) {
                stringBuffer.append("您的设备未连接到网络，无法进行网络定位\n");
            } else if ("2G".equals(this.f8121e)) {
                stringBuffer.append("您的设备网络状态不太好，网络定位可能会有延迟\n");
            }
            if (!this.f8118b) {
                stringBuffer.append("您的设备WIFI开关已关闭，打开WIFI开关有助于提高定位的成功率\n");
            }
        }
        return stringBuffer.toString();
    }

    public int getGPSSatellites() {
        return this.f8120d;
    }

    public int getGPSStatus() {
        return this.f8119c;
    }

    public long getNetUseTime() {
        return this.f8122f;
    }

    public String getNetworkType() {
        return this.f8121e;
    }

    public boolean isInstalledHighDangerMockApp() {
        return this.f8123g;
    }

    public boolean isWifiAble() {
        return this.f8118b;
    }

    public void setGPSSatellites(int i10) {
        this.f8120d = i10;
    }

    public void setGpsStatus(int i10) {
        this.f8119c = i10;
    }

    public void setInstallHighDangerMockApp(boolean z10) {
        this.f8123g = z10;
    }

    public void setLocationMode(AMapLocationClientOption.AMapLocationMode aMapLocationMode) {
        this.f8117a = aMapLocationMode;
    }

    public void setNetUseTime(long j10) {
        this.f8122f = j10;
    }

    public void setNetworkType(String str) {
        this.f8121e = str;
    }

    public void setWifiAble(boolean z10) {
        this.f8118b = z10;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public AMapLocationQualityReport m1958clone() {
        AMapLocationQualityReport aMapLocationQualityReport = new AMapLocationQualityReport();
        try {
            super.clone();
        } catch (Throwable unused) {
        }
        try {
            aMapLocationQualityReport.setGpsStatus(this.f8119c);
            aMapLocationQualityReport.setGPSSatellites(this.f8120d);
            aMapLocationQualityReport.setWifiAble(this.f8118b);
            aMapLocationQualityReport.setNetUseTime(this.f8122f);
            aMapLocationQualityReport.setNetworkType(this.f8121e);
            aMapLocationQualityReport.setLocationMode(this.f8117a);
            aMapLocationQualityReport.setInstallHighDangerMockApp(this.f8123g);
        } catch (Throwable th) {
            b.a(th, "AMapLocationQualityReport", "clone");
        }
        return aMapLocationQualityReport;
    }
}
