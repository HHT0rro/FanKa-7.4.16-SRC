package com.baidu.mobads.sdk.api;

import android.text.TextUtils;
import com.amap.api.services.district.DistrictSearchQuery;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class CPUWebAdRequestParam {
    private static final String DARK_MODE = "dark";
    private static final String LIGHT_MODE = "light";
    private final Map<String, Object> mParameters;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class Builder {
        private HashMap<String, Object> mExtras = new HashMap<>();

        public Builder addExtra(String str, String str2) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                this.mExtras.put(str, str2);
            }
            return this;
        }

        public CPUWebAdRequestParam build() {
            return new CPUWebAdRequestParam(this);
        }

        public Builder setCityIfLocalChannel(String str) {
            this.mExtras.put(DistrictSearchQuery.KEYWORDS_CITY, str);
            return this;
        }

        public Builder setCustomUserId(String str) {
            this.mExtras.put("outerId", str);
            return this;
        }

        public Builder setLpDarkMode(boolean z10) {
            this.mExtras.put("preferscolortheme", z10 ? "dark" : "light");
            return this;
        }

        public Builder setLpFontSize(CpuLpFontSize cpuLpFontSize) {
            this.mExtras.put("prefersfontsize", cpuLpFontSize.getValue());
            return this;
        }

        public Builder setSubChannelId(String str) {
            this.mExtras.put("scid", str);
            return this;
        }
    }

    public Map<String, Object> getParameters() {
        return this.mParameters;
    }

    private CPUWebAdRequestParam(Builder builder) {
        HashMap hashMap = new HashMap();
        this.mParameters = hashMap;
        if (builder == null || builder.mExtras == null) {
            return;
        }
        hashMap.putAll(builder.mExtras);
    }
}
