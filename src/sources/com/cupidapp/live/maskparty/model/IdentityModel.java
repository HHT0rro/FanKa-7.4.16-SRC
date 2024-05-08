package com.cupidapp.live.maskparty.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MaskPartyScriptModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class IdentityModel {

    /* renamed from: id, reason: collision with root package name */
    private final int f16367id;

    @NotNull
    private final String identityInfo;

    public IdentityModel(int i10, @NotNull String identityInfo) {
        s.i(identityInfo, "identityInfo");
        this.f16367id = i10;
        this.identityInfo = identityInfo;
    }

    public static /* synthetic */ IdentityModel copy$default(IdentityModel identityModel, int i10, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = identityModel.f16367id;
        }
        if ((i11 & 2) != 0) {
            str = identityModel.identityInfo;
        }
        return identityModel.copy(i10, str);
    }

    public final int component1() {
        return this.f16367id;
    }

    @NotNull
    public final String component2() {
        return this.identityInfo;
    }

    @NotNull
    public final IdentityModel copy(int i10, @NotNull String identityInfo) {
        s.i(identityInfo, "identityInfo");
        return new IdentityModel(i10, identityInfo);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IdentityModel)) {
            return false;
        }
        IdentityModel identityModel = (IdentityModel) obj;
        return this.f16367id == identityModel.f16367id && s.d(this.identityInfo, identityModel.identityInfo);
    }

    public final int getId() {
        return this.f16367id;
    }

    @NotNull
    public final String getIdentityInfo() {
        return this.identityInfo;
    }

    public int hashCode() {
        return (this.f16367id * 31) + this.identityInfo.hashCode();
    }

    @NotNull
    public String toString() {
        return "IdentityModel(id=" + this.f16367id + ", identityInfo=" + this.identityInfo + ")";
    }
}
