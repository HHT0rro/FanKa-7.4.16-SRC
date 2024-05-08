package com.cupidapp.live.base.network.model;

import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BaseUrlModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class BaseUrlResult {

    @Nullable
    private final BaseUrlModel data;
    private boolean success;

    public BaseUrlResult(boolean z10, @Nullable BaseUrlModel baseUrlModel) {
        this.success = z10;
        this.data = baseUrlModel;
    }

    public static /* synthetic */ BaseUrlResult copy$default(BaseUrlResult baseUrlResult, boolean z10, BaseUrlModel baseUrlModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = baseUrlResult.success;
        }
        if ((i10 & 2) != 0) {
            baseUrlModel = baseUrlResult.data;
        }
        return baseUrlResult.copy(z10, baseUrlModel);
    }

    public final boolean component1() {
        return this.success;
    }

    @Nullable
    public final BaseUrlModel component2() {
        return this.data;
    }

    @NotNull
    public final BaseUrlResult copy(boolean z10, @Nullable BaseUrlModel baseUrlModel) {
        return new BaseUrlResult(z10, baseUrlModel);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BaseUrlResult)) {
            return false;
        }
        BaseUrlResult baseUrlResult = (BaseUrlResult) obj;
        return this.success == baseUrlResult.success && s.d(this.data, baseUrlResult.data);
    }

    @Nullable
    public final BaseUrlModel getData() {
        return this.data;
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
        BaseUrlModel baseUrlModel = this.data;
        return i10 + (baseUrlModel == null ? 0 : baseUrlModel.hashCode());
    }

    public final void setSuccess(boolean z10) {
        this.success = z10;
    }

    @NotNull
    public String toString() {
        return "BaseUrlResult(success=" + this.success + ", data=" + ((Object) this.data) + ")";
    }

    public /* synthetic */ BaseUrlResult(boolean z10, BaseUrlModel baseUrlModel, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? true : z10, baseUrlModel);
    }
}
