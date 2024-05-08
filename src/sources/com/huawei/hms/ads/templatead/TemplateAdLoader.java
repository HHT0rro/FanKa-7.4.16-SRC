package com.huawei.hms.ads.templatead;

import android.content.Context;
import com.huawei.hms.ads.AdListener;
import com.huawei.hms.ads.AdParam;
import com.huawei.hms.ads.annotation.AllApi;
import com.huawei.hms.ads.annotation.GlobalApi;
import com.huawei.hms.ads.h;
import com.huawei.hms.ads.nativead.NativeAdConfiguration;
import com.huawei.hms.ads.o;

@AllApi
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class TemplateAdLoader {
    private o Code;

    @AllApi
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class Builder {
        private o Code;

        @GlobalApi
        public Builder(Context context, String str) {
            this.Code = new h(context, str);
        }

        @GlobalApi
        public TemplateAdLoader build() {
            return new TemplateAdLoader(this);
        }

        @GlobalApi
        public Builder setAdListener(AdListener adListener) {
            this.Code.Code(adListener);
            return this;
        }

        @GlobalApi
        public Builder setAdsReturnedFromThread(boolean z10) {
            this.Code.Code(z10);
            return this;
        }

        @GlobalApi
        public Builder setNativeAdOptions(NativeAdConfiguration nativeAdConfiguration) {
            this.Code.Code(nativeAdConfiguration);
            return this;
        }

        @GlobalApi
        public Builder setTemplateAdListener(TemplateAdListener templateAdListener) {
            return this;
        }
    }

    private TemplateAdLoader(Builder builder) {
        this.Code = builder.Code;
    }

    @AllApi
    public void loadNativeAd(AdParam adParam) {
        this.Code.Code(adParam);
    }
}
