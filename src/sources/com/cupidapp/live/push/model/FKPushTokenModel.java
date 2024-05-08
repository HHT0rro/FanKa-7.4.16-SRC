package com.cupidapp.live.push.model;

import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKPushTokenModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKPushTokenModel {

    @Nullable
    private String token;

    @Nullable
    private String type;

    public FKPushTokenModel() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public FKPushTokenModel(@Nullable String str, @Nullable String str2) {
        this.token = str;
        this.type = str2;
    }

    @Nullable
    public final String getToken() {
        return this.token;
    }

    @Nullable
    public final String getType() {
        return this.type;
    }

    public final void setToken(@Nullable String str) {
        this.token = str;
    }

    public final void setType(@Nullable String str) {
        this.type = str;
    }

    public /* synthetic */ FKPushTokenModel(String str, String str2, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2);
    }
}
