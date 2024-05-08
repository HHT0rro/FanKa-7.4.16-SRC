package com.huawei.hms.ads.instreamad;

import android.content.Context;
import com.huawei.hms.ads.AdParam;
import com.huawei.hms.ads.annotation.GlobalApi;
import com.huawei.hms.ads.x;
import com.huawei.hms.ads.y;

@GlobalApi
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class InstreamAdLoader {
    private x Code;

    @GlobalApi
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class Builder {
        private x Code;

        @GlobalApi
        public Builder(Context context, String str) {
            this.Code = new y(context, str);
        }

        @GlobalApi
        public InstreamAdLoader build() {
            return new InstreamAdLoader(this);
        }

        @GlobalApi
        public Builder setInstreamAdLoadListener(InstreamAdLoadListener instreamAdLoadListener) {
            this.Code.Code(instreamAdLoadListener);
            return this;
        }

        @GlobalApi
        public Builder setMaxCount(int i10) {
            this.Code.V(i10);
            return this;
        }

        @GlobalApi
        public Builder setTotalDuration(int i10) {
            this.Code.Code(i10);
            return this;
        }
    }

    private InstreamAdLoader(Builder builder) {
        this.Code = builder.Code;
    }

    @GlobalApi
    public boolean isLoading() {
        return this.Code.Code();
    }

    @GlobalApi
    public void loadAd(AdParam adParam) {
        this.Code.Code(adParam);
    }
}
