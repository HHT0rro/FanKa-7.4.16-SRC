package com.bytedance.sdk.openadsdk.mediation.bridge;

import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class MediationResultBuilder {

    /* renamed from: m, reason: collision with root package name */
    private boolean f11295m = false;
    private int dk = -1;
    private String ej = null;

    /* renamed from: l, reason: collision with root package name */
    private ValueSet f11294l = null;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class ResultImpl implements Result {
        private final int dk;
        private final String ej;

        /* renamed from: l, reason: collision with root package name */
        private final ValueSet f11296l;

        /* renamed from: m, reason: collision with root package name */
        private final boolean f11297m;

        @Override // com.bykv.vk.openvk.api.proto.Result
        public int code() {
            return this.dk;
        }

        @Override // com.bykv.vk.openvk.api.proto.Result
        public boolean isSuccess() {
            return this.f11297m;
        }

        @Override // com.bykv.vk.openvk.api.proto.Result
        public String message() {
            return this.ej;
        }

        @Override // com.bykv.vk.openvk.api.proto.Result
        public ValueSet values() {
            return this.f11296l;
        }

        private ResultImpl(boolean z10, int i10, String str, ValueSet valueSet) {
            this.f11297m = z10;
            this.dk = i10;
            this.ej = str;
            this.f11296l = valueSet;
        }
    }

    private MediationResultBuilder() {
    }

    public static final MediationResultBuilder create() {
        return new MediationResultBuilder();
    }

    public Result build() {
        boolean z10 = this.f11295m;
        int i10 = this.dk;
        String str = this.ej;
        ValueSet valueSet = this.f11294l;
        if (valueSet == null) {
            valueSet = MediationValueSetBuilder.create().build();
        }
        return new ResultImpl(z10, i10, str, valueSet);
    }

    public MediationResultBuilder setCode(int i10) {
        this.dk = i10;
        return this;
    }

    public MediationResultBuilder setMessage(String str) {
        this.ej = str;
        return this;
    }

    public MediationResultBuilder setSuccess(boolean z10) {
        this.f11295m = z10;
        return this;
    }

    public MediationResultBuilder setValues(ValueSet valueSet) {
        this.f11294l = valueSet;
        return this;
    }
}
