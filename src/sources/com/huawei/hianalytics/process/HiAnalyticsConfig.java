package com.huawei.hianalytics.process;

import com.huawei.hianalytics.core.log.HiLog;
import com.huawei.hianalytics.i0;
import com.huawei.hianalytics.k0;
import com.huawei.hianalytics.log.LogTag;
import com.huawei.hianalytics.s;
import com.huawei.hianalytics.w;
import com.huawei.hianalytics.x;
import e9.a;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class HiAnalyticsConfig {
    public w lmn;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class Builder {
        public static final String TAG = LogTag.get(HiAnalyticsConfig.class, Builder.class);
        public String aaidCustom;
        public String androidIdCustom;
        public String channel;
        public String collectURL;
        public Map<String, String> httpHeaders;
        public String imeiCustom;
        public boolean isAndroidIdEnabled;
        public boolean isImeiEnabled;
        public boolean isMccMncEnabled;
        public boolean isSNEnabled;
        public boolean isSessionEnabled;
        public boolean isUDIDEnabled;
        public String snCustom;
        public String udidCustom;
        public int portLimitSize = 30;
        public int expiryTime = 7;
        public boolean isUUIDEnabled = false;
        public boolean isEncrypted = true;

        public Builder() {
            HiLog.setLogAdapter(new s());
        }

        public HiAnalyticsConfig build() {
            HiLog.d(TAG, "HiAnalyticsConfig.Builder.build() is executed.");
            return new HiAnalyticsConfig(this);
        }

        public Builder setAAID(String str) {
            HiLog.d(TAG, "HiAnalyticsConfig.Builder.setAaid is executed.");
            if (!i0.lmn("aaid_CustomSet", str, 4096)) {
                str = "";
            }
            this.aaidCustom = str;
            return this;
        }

        public Builder setAndroidId(String str) {
            HiLog.d(TAG, "HiAnalyticsConfig.Builder.setAndroidId() is executed.");
            if (!i0.lmn("AndroidId_CustomSet", str, 4096)) {
                str = "";
            }
            this.androidIdCustom = str;
            return this;
        }

        @Deprecated
        public Builder setAutoReportThreshold(int i10) {
            HiLog.i(TAG, "Builder.setAutoReportThreshold is Deprecated");
            return this;
        }

        public Builder setAutoReportThresholdSize(int i10) {
            HiLog.d(TAG, "HiAnalyticsConfig.Builder.setAutoReportThresholdSize() is executed.");
            this.portLimitSize = Math.min(Math.max(i10, 10), 100);
            return this;
        }

        public Builder setCacheExpireTime(int i10) {
            HiLog.d(TAG, "HiAnalyticsConfig.Builder.setCacheExpireTime() is executed.");
            this.expiryTime = Math.min(Math.max(i10, 2), 7);
            return this;
        }

        public Builder setChannel(String str) {
            String str2 = TAG;
            HiLog.d(str2, "HiAnalyticsConfig.Builder.setChannel() is executed.");
            String str3 = "";
            if (str == null) {
                str = "";
            }
            if (str.length() > 256) {
                StringBuilder b4 = a.b("setChannel: unsupported channel: channel.length() = ");
                b4.append(str.length());
                HiLog.i(str2, b4.toString());
            } else {
                str3 = str;
            }
            this.channel = str3;
            return this;
        }

        public Builder setCollectURL(String str) {
            String str2 = TAG;
            HiLog.i(str2, "HiAnalyticsConfig.Builder.setCollectURL() is executed.");
            if (!k0.lmn(str)) {
                HiLog.i(str2, "setCollectURL: url check failed");
                str = "";
            }
            if (str.endsWith("/") || str.endsWith("\\")) {
                str = str.substring(0, str.length() - 1);
            }
            this.collectURL = str;
            return this;
        }

        @Deprecated
        public Builder setEnableAndroidID(boolean z10) {
            HiLog.d(TAG, "HiAnalyticsConfig.Builder.setEnableAndroidID() is executed.");
            this.isAndroidIdEnabled = z10;
            return this;
        }

        @Deprecated
        public Builder setEnableImei(boolean z10) {
            HiLog.d(TAG, "HiAnalyticsConfig.Builder.setEnableImei() is executed.");
            this.isImeiEnabled = z10;
            return this;
        }

        public Builder setEnableMccMnc(boolean z10) {
            HiLog.d(TAG, "HiAnalyticsConfig.Builder.setEnableMccMnc() is executed.");
            this.isMccMncEnabled = z10;
            return this;
        }

        @Deprecated
        public Builder setEnableSN(boolean z10) {
            HiLog.d(TAG, "HiAnalyticsConfig.Builder.setEnableSN() is executed.");
            this.isSNEnabled = z10;
            return this;
        }

        public Builder setEnableSession(boolean z10) {
            HiLog.d(TAG, "HiAnalyticsConfig.Builder.setEnableSession() is executed.");
            this.isSessionEnabled = z10;
            return this;
        }

        @Deprecated
        public Builder setEnableUDID(boolean z10) {
            HiLog.d(TAG, "HiAnalyticsConfig.Builder.setEnableUDID() is executed.");
            this.isUDIDEnabled = z10;
            return this;
        }

        public Builder setEnableUUID(boolean z10) {
            HiLog.d(TAG, "HiAnalyticsConfig.Builder.setEnableUUID() is executed.");
            this.isUUIDEnabled = z10;
            return this;
        }

        public Builder setHttpHeader(Map<String, String> map) {
            if (map == null) {
                map = new HashMap<>();
            }
            LinkedHashMap<String, String> lmn = i0.lmn(map, 50, 1024L, 1024L, "x-hasdk");
            if (lmn != null && lmn.size() > 0) {
                this.httpHeaders = lmn;
            }
            return this;
        }

        public Builder setImei(String str) {
            HiLog.d(TAG, "HiAnalyticsConfig.Builder.setImei() is executed.");
            if (!i0.lmn("IMEI_CustomSet", str, 4096)) {
                str = "";
            }
            this.imeiCustom = str;
            return this;
        }

        public Builder setSN(String str) {
            HiLog.d(TAG, "HiAnalyticsConfig.Builder.setSN() is executed.");
            if (!i0.lmn("SN_CustomSet", str, 4096)) {
                str = "";
            }
            this.snCustom = str;
            return this;
        }

        public Builder setUdid(String str) {
            HiLog.d(TAG, "HiAnalyticsConfig.Builder.setUdid() is executed.");
            if (!i0.lmn("Udid_CustomSet", str, 4096)) {
                str = "";
            }
            this.udidCustom = str;
            return this;
        }
    }

    public HiAnalyticsConfig(HiAnalyticsConfig hiAnalyticsConfig) {
        this.lmn = new w(hiAnalyticsConfig.lmn);
    }

    public void ijk(boolean z10) {
        this.lmn.bcd = z10;
    }

    public final void ikl(boolean z10) {
        this.lmn.ikl = z10;
    }

    public final void klm(int i10) {
        this.lmn.def = i10;
    }

    public final void lmn(Builder builder) {
        x lmn = this.lmn.lmn();
        lmn.lmn = builder.isImeiEnabled;
        lmn.hij = builder.imeiCustom;
        lmn.ijk = builder.isAndroidIdEnabled;
        lmn.fgh = builder.androidIdCustom;
        lmn.klm = builder.isSNEnabled;
        lmn.efg = builder.snCustom;
        lmn.ikl = builder.isUDIDEnabled;
        lmn.ghi = builder.udidCustom;
    }

    public HiAnalyticsConfig(Builder builder) {
        this.lmn = new w();
        lmn(builder);
        klm(builder.channel);
        ikl(builder.collectURL);
        klm(builder.isMccMncEnabled);
        ikl(builder.isSessionEnabled);
        klm(builder.portLimitSize);
        lmn(builder.expiryTime);
        ijk(builder.isUUIDEnabled);
        lmn(builder.httpHeaders);
        lmn(builder.aaidCustom);
        lmn(builder.isEncrypted);
    }

    public final void ikl(String str) {
        this.lmn.hij = str;
    }

    public final void klm(boolean z10) {
        this.lmn.klm = z10;
    }

    public final void klm(String str) {
        this.lmn.ijk = str;
    }

    public final void lmn(Map<String, String> map) {
        this.lmn.f28847a = map;
    }

    public final void lmn(int i10) {
        this.lmn.cde = i10;
    }

    public final void lmn(String str) {
        this.lmn.f28848b = str;
    }

    public final void lmn(boolean z10) {
        this.lmn.f28851e = z10;
    }
}
