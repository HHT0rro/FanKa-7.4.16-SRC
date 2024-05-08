package com.cupidapp.live.login.model;

import kotlin.d;
import org.jetbrains.annotations.Nullable;

/* compiled from: AliAuthModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class AliAuthModel {

    @Nullable
    private String code;

    @Nullable
    private String msg;
    private int requestCode;

    @Nullable
    private String vendorName;

    @Nullable
    public final String getCode() {
        return this.code;
    }

    @Nullable
    public final String getMsg() {
        return this.msg;
    }

    public final int getRequestCode() {
        return this.requestCode;
    }

    @Nullable
    public final String getVendorName() {
        return this.vendorName;
    }

    public final void setCode(@Nullable String str) {
        this.code = str;
    }

    public final void setMsg(@Nullable String str) {
        this.msg = str;
    }

    public final void setRequestCode(int i10) {
        this.requestCode = i10;
    }

    public final void setVendorName(@Nullable String str) {
        this.vendorName = str;
    }
}
