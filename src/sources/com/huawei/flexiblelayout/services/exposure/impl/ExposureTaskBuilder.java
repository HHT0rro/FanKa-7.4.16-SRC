package com.huawei.flexiblelayout.services.exposure.impl;

import androidx.annotation.NonNull;
import com.huawei.flexiblelayout.FLayout;
import com.huawei.flexiblelayout.services.exposure.ExposureParam;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class ExposureTaskBuilder extends ChainExecutor<Param, ExposureTaskImpl> {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class Param {

        /* renamed from: a, reason: collision with root package name */
        @NonNull
        private final FLayout f28558a;

        /* renamed from: b, reason: collision with root package name */
        @NonNull
        private final ExposureParam f28559b;

        public Param(@NonNull FLayout fLayout, @NonNull ExposureParam exposureParam) {
            this.f28558a = fLayout;
            this.f28559b = exposureParam;
        }

        @NonNull
        public FLayout getFLayout() {
            return this.f28558a;
        }

        @NonNull
        public ExposureParam getParam() {
            return this.f28559b;
        }
    }
}
