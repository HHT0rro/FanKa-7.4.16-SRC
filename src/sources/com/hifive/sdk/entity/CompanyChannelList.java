package com.hifive.sdk.entity;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: InitBean.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class CompanyChannelList {

    @NotNull
    private final String channelId;

    @NotNull
    private final String channelName;

    @NotNull
    private final String channelUrl;

    public CompanyChannelList(@NotNull String channelId, @NotNull String channelName, @NotNull String channelUrl) {
        s.j(channelId, "channelId");
        s.j(channelName, "channelName");
        s.j(channelUrl, "channelUrl");
        this.channelId = channelId;
        this.channelName = channelName;
        this.channelUrl = channelUrl;
    }

    public static /* synthetic */ CompanyChannelList copy$default(CompanyChannelList companyChannelList, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = companyChannelList.channelId;
        }
        if ((i10 & 2) != 0) {
            str2 = companyChannelList.channelName;
        }
        if ((i10 & 4) != 0) {
            str3 = companyChannelList.channelUrl;
        }
        return companyChannelList.copy(str, str2, str3);
    }

    @NotNull
    public final String component1() {
        return this.channelId;
    }

    @NotNull
    public final String component2() {
        return this.channelName;
    }

    @NotNull
    public final String component3() {
        return this.channelUrl;
    }

    @NotNull
    public final CompanyChannelList copy(@NotNull String channelId, @NotNull String channelName, @NotNull String channelUrl) {
        s.j(channelId, "channelId");
        s.j(channelName, "channelName");
        s.j(channelUrl, "channelUrl");
        return new CompanyChannelList(channelId, channelName, channelUrl);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CompanyChannelList)) {
            return false;
        }
        CompanyChannelList companyChannelList = (CompanyChannelList) obj;
        return s.d(this.channelId, companyChannelList.channelId) && s.d(this.channelName, companyChannelList.channelName) && s.d(this.channelUrl, companyChannelList.channelUrl);
    }

    @NotNull
    public final String getChannelId() {
        return this.channelId;
    }

    @NotNull
    public final String getChannelName() {
        return this.channelName;
    }

    @NotNull
    public final String getChannelUrl() {
        return this.channelUrl;
    }

    public int hashCode() {
        String str = this.channelId;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.channelName;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.channelUrl;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "CompanyChannelList(channelId=" + this.channelId + ", channelName=" + this.channelName + ", channelUrl=" + this.channelUrl + ")";
    }
}
