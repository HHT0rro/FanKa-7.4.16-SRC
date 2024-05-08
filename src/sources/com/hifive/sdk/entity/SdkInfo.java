package com.hifive.sdk.entity;

import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: InitBean.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class SdkInfo implements Serializable {

    @NotNull
    private final String createTime;

    @NotNull
    private final String icon;

    @NotNull
    private final String name;

    @NotNull
    private final String releaseVersion;
    private final int version;

    public SdkInfo(@NotNull String createTime, @NotNull String icon, @NotNull String name, @NotNull String releaseVersion, int i10) {
        s.j(createTime, "createTime");
        s.j(icon, "icon");
        s.j(name, "name");
        s.j(releaseVersion, "releaseVersion");
        this.createTime = createTime;
        this.icon = icon;
        this.name = name;
        this.releaseVersion = releaseVersion;
        this.version = i10;
    }

    public static /* synthetic */ SdkInfo copy$default(SdkInfo sdkInfo, String str, String str2, String str3, String str4, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = sdkInfo.createTime;
        }
        if ((i11 & 2) != 0) {
            str2 = sdkInfo.icon;
        }
        String str5 = str2;
        if ((i11 & 4) != 0) {
            str3 = sdkInfo.name;
        }
        String str6 = str3;
        if ((i11 & 8) != 0) {
            str4 = sdkInfo.releaseVersion;
        }
        String str7 = str4;
        if ((i11 & 16) != 0) {
            i10 = sdkInfo.version;
        }
        return sdkInfo.copy(str, str5, str6, str7, i10);
    }

    @NotNull
    public final String component1() {
        return this.createTime;
    }

    @NotNull
    public final String component2() {
        return this.icon;
    }

    @NotNull
    public final String component3() {
        return this.name;
    }

    @NotNull
    public final String component4() {
        return this.releaseVersion;
    }

    public final int component5() {
        return this.version;
    }

    @NotNull
    public final SdkInfo copy(@NotNull String createTime, @NotNull String icon, @NotNull String name, @NotNull String releaseVersion, int i10) {
        s.j(createTime, "createTime");
        s.j(icon, "icon");
        s.j(name, "name");
        s.j(releaseVersion, "releaseVersion");
        return new SdkInfo(createTime, icon, name, releaseVersion, i10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof SdkInfo) {
                SdkInfo sdkInfo = (SdkInfo) obj;
                if (s.d(this.createTime, sdkInfo.createTime) && s.d(this.icon, sdkInfo.icon) && s.d(this.name, sdkInfo.name) && s.d(this.releaseVersion, sdkInfo.releaseVersion)) {
                    if (this.version == sdkInfo.version) {
                    }
                }
            }
            return false;
        }
        return true;
    }

    @NotNull
    public final String getCreateTime() {
        return this.createTime;
    }

    @NotNull
    public final String getIcon() {
        return this.icon;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getReleaseVersion() {
        return this.releaseVersion;
    }

    public final int getVersion() {
        return this.version;
    }

    public int hashCode() {
        String str = this.createTime;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.icon;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.name;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.releaseVersion;
        return ((hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31) + this.version;
    }

    @NotNull
    public String toString() {
        return "SdkInfo(createTime=" + this.createTime + ", icon=" + this.icon + ", name=" + this.name + ", releaseVersion=" + this.releaseVersion + ", version=" + this.version + ")";
    }
}
