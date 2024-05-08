package com.google.mlkit.common.sdkinternal.model;

import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;

/* compiled from: com.google.mlkit:common@@17.1.1 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class ModelValidator$ValidationResult {

    @RecentlyNonNull
    public static final ModelValidator$ValidationResult VALID = new ModelValidator$ValidationResult(ErrorCode.OK, null);
    private final ErrorCode zza;

    @Nullable
    private final String zzb;

    /* compiled from: com.google.mlkit:common@@17.1.1 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public enum ErrorCode {
        OK,
        TFLITE_VERSION_INCOMPATIBLE,
        MODEL_FORMAT_INVALID
    }

    public ModelValidator$ValidationResult(@RecentlyNonNull ErrorCode errorCode, @Nullable String str) {
        this.zza = errorCode;
        this.zzb = str;
    }

    @RecentlyNonNull
    public ErrorCode getErrorCode() {
        return this.zza;
    }

    @RecentlyNullable
    public String getErrorMessage() {
        return this.zzb;
    }

    public boolean isValid() {
        return this.zza == ErrorCode.OK;
    }
}
