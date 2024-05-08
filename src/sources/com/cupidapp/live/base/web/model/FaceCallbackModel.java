package com.cupidapp.live.base.web.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FaceCallbackModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FaceCallbackModel {

    @Nullable
    private final String errJson;
    private final boolean success;

    public FaceCallbackModel(boolean z10, @Nullable String str) {
        this.success = z10;
        this.errJson = str;
    }

    public static /* synthetic */ FaceCallbackModel copy$default(FaceCallbackModel faceCallbackModel, boolean z10, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = faceCallbackModel.success;
        }
        if ((i10 & 2) != 0) {
            str = faceCallbackModel.errJson;
        }
        return faceCallbackModel.copy(z10, str);
    }

    public final boolean component1() {
        return this.success;
    }

    @Nullable
    public final String component2() {
        return this.errJson;
    }

    @NotNull
    public final FaceCallbackModel copy(boolean z10, @Nullable String str) {
        return new FaceCallbackModel(z10, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FaceCallbackModel)) {
            return false;
        }
        FaceCallbackModel faceCallbackModel = (FaceCallbackModel) obj;
        return this.success == faceCallbackModel.success && s.d(this.errJson, faceCallbackModel.errJson);
    }

    @Nullable
    public final String getErrJson() {
        return this.errJson;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z10 = this.success;
        ?? r02 = z10;
        if (z10) {
            r02 = 1;
        }
        int i10 = r02 * 31;
        String str = this.errJson;
        return i10 + (str == null ? 0 : str.hashCode());
    }

    @NotNull
    public String toString() {
        return "FaceCallbackModel(success=" + this.success + ", errJson=" + this.errJson + ")";
    }
}
