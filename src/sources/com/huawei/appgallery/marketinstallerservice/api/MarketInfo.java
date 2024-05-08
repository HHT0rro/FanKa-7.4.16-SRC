package com.huawei.appgallery.marketinstallerservice.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.appgallery.marketinstallerservice.internal.framework.storekit.bean.InstallerNetTransmission;
import com.huawei.appgallery.marketinstallerservice.internal.framework.storekit.bean.JsonBean;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class MarketInfo extends JsonBean implements Parcelable {
    public static final Parcelable.Creator<MarketInfo> CREATOR = new Parcelable.Creator<MarketInfo>() { // from class: com.huawei.appgallery.marketinstallerservice.api.MarketInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MarketInfo createFromParcel(Parcel parcel) {
            return new MarketInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MarketInfo[] newArray(int i10) {
            return new MarketInfo[i10];
        }
    };

    @InstallerNetTransmission
    private String appName;

    @InstallerNetTransmission
    private String downUrl;

    @InstallerNetTransmission
    private long fileSize;

    @InstallerNetTransmission
    private String pkgName;

    @InstallerNetTransmission
    private String sha256;

    @InstallerNetTransmission
    private int versionCode;

    @InstallerNetTransmission
    private String versionName;

    public MarketInfo() {
    }

    public MarketInfo(Parcel parcel) {
        this.pkgName = parcel.readString();
        this.downUrl = parcel.readString();
        this.appName = parcel.readString();
        this.versionCode = parcel.readInt();
        this.versionName = parcel.readString();
        this.fileSize = parcel.readLong();
        this.sha256 = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAppName() {
        return this.appName;
    }

    public String getDownUrl() {
        return this.downUrl;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public String getPkgName() {
        return this.pkgName;
    }

    public String getSha256() {
        return this.sha256;
    }

    public int getVersionCode() {
        return this.versionCode;
    }

    public String getVersionName() {
        return this.versionName;
    }

    public void setAppName(String str) {
        this.appName = str;
    }

    public void setDownUrl(String str) {
        this.downUrl = str;
    }

    public void setFileSize(long j10) {
        this.fileSize = j10;
    }

    public void setPkgName(String str) {
        this.pkgName = str;
    }

    public void setSha256(String str) {
        this.sha256 = str;
    }

    public void setVersionCode(int i10) {
        this.versionCode = i10;
    }

    public void setVersionName(String str) {
        this.versionName = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.pkgName);
        parcel.writeString(this.downUrl);
        parcel.writeString(this.appName);
        parcel.writeInt(this.versionCode);
        parcel.writeString(this.versionName);
        parcel.writeLong(this.fileSize);
        parcel.writeString(this.sha256);
    }
}
