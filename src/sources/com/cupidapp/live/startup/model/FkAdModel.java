package com.cupidapp.live.startup.model;

import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: StartupModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FkAdModel implements Serializable {

    @Nullable
    private final String adAppId;

    @Nullable
    private final String adAppKey;

    @NotNull
    private final String adId;

    @Nullable
    private final String provider;

    @Nullable
    private final String unitId;

    public FkAdModel(@NotNull String adId, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        s.i(adId, "adId");
        this.adId = adId;
        this.unitId = str;
        this.provider = str2;
        this.adAppId = str3;
        this.adAppKey = str4;
    }

    public static /* synthetic */ FkAdModel copy$default(FkAdModel fkAdModel, String str, String str2, String str3, String str4, String str5, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = fkAdModel.adId;
        }
        if ((i10 & 2) != 0) {
            str2 = fkAdModel.unitId;
        }
        String str6 = str2;
        if ((i10 & 4) != 0) {
            str3 = fkAdModel.provider;
        }
        String str7 = str3;
        if ((i10 & 8) != 0) {
            str4 = fkAdModel.adAppId;
        }
        String str8 = str4;
        if ((i10 & 16) != 0) {
            str5 = fkAdModel.adAppKey;
        }
        return fkAdModel.copy(str, str6, str7, str8, str5);
    }

    @NotNull
    public final String component1() {
        return this.adId;
    }

    @Nullable
    public final String component2() {
        return this.unitId;
    }

    @Nullable
    public final String component3() {
        return this.provider;
    }

    @Nullable
    public final String component4() {
        return this.adAppId;
    }

    @Nullable
    public final String component5() {
        return this.adAppKey;
    }

    @NotNull
    public final FkAdModel copy(@NotNull String adId, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        s.i(adId, "adId");
        return new FkAdModel(adId, str, str2, str3, str4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FkAdModel)) {
            return false;
        }
        FkAdModel fkAdModel = (FkAdModel) obj;
        return s.d(this.adId, fkAdModel.adId) && s.d(this.unitId, fkAdModel.unitId) && s.d(this.provider, fkAdModel.provider) && s.d(this.adAppId, fkAdModel.adAppId) && s.d(this.adAppKey, fkAdModel.adAppKey);
    }

    @Nullable
    public final String getAdAppId() {
        return this.adAppId;
    }

    @Nullable
    public final String getAdAppKey() {
        return this.adAppKey;
    }

    @NotNull
    public final String getAdId() {
        return this.adId;
    }

    @Nullable
    public final String getProvider() {
        return this.provider;
    }

    @Nullable
    public final String getUnitId() {
        return this.unitId;
    }

    public int hashCode() {
        int hashCode = this.adId.hashCode() * 31;
        String str = this.unitId;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.provider;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.adAppId;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.adAppKey;
        return hashCode4 + (str4 != null ? str4.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "FkAdModel(adId=" + this.adId + ", unitId=" + this.unitId + ", provider=" + this.provider + ", adAppId=" + this.adAppId + ", adAppKey=" + this.adAppKey + ")";
    }
}
