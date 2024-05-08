package com.cupidapp.live.base.network.model;

import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BaseUrlModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class BaseUrlModel {

    @NotNull
    private final String addrLog;

    @Nullable
    private final List<String> authRequiredHost;

    @NotNull
    private final String urlPrefixApi;

    @NotNull
    private final String urlPrefixWww;

    public BaseUrlModel(@NotNull String urlPrefixApi, @NotNull String urlPrefixWww, @NotNull String addrLog, @Nullable List<String> list) {
        s.i(urlPrefixApi, "urlPrefixApi");
        s.i(urlPrefixWww, "urlPrefixWww");
        s.i(addrLog, "addrLog");
        this.urlPrefixApi = urlPrefixApi;
        this.urlPrefixWww = urlPrefixWww;
        this.addrLog = addrLog;
        this.authRequiredHost = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BaseUrlModel copy$default(BaseUrlModel baseUrlModel, String str, String str2, String str3, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = baseUrlModel.urlPrefixApi;
        }
        if ((i10 & 2) != 0) {
            str2 = baseUrlModel.urlPrefixWww;
        }
        if ((i10 & 4) != 0) {
            str3 = baseUrlModel.addrLog;
        }
        if ((i10 & 8) != 0) {
            list = baseUrlModel.authRequiredHost;
        }
        return baseUrlModel.copy(str, str2, str3, list);
    }

    @NotNull
    public final String component1() {
        return this.urlPrefixApi;
    }

    @NotNull
    public final String component2() {
        return this.urlPrefixWww;
    }

    @NotNull
    public final String component3() {
        return this.addrLog;
    }

    @Nullable
    public final List<String> component4() {
        return this.authRequiredHost;
    }

    @NotNull
    public final BaseUrlModel copy(@NotNull String urlPrefixApi, @NotNull String urlPrefixWww, @NotNull String addrLog, @Nullable List<String> list) {
        s.i(urlPrefixApi, "urlPrefixApi");
        s.i(urlPrefixWww, "urlPrefixWww");
        s.i(addrLog, "addrLog");
        return new BaseUrlModel(urlPrefixApi, urlPrefixWww, addrLog, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BaseUrlModel)) {
            return false;
        }
        BaseUrlModel baseUrlModel = (BaseUrlModel) obj;
        return s.d(this.urlPrefixApi, baseUrlModel.urlPrefixApi) && s.d(this.urlPrefixWww, baseUrlModel.urlPrefixWww) && s.d(this.addrLog, baseUrlModel.addrLog) && s.d(this.authRequiredHost, baseUrlModel.authRequiredHost);
    }

    @NotNull
    public final String getAddrLog() {
        return this.addrLog;
    }

    @Nullable
    public final List<String> getAuthRequiredHost() {
        return this.authRequiredHost;
    }

    @NotNull
    public final String getUrlPrefixApi() {
        return this.urlPrefixApi;
    }

    @NotNull
    public final String getUrlPrefixWww() {
        return this.urlPrefixWww;
    }

    public int hashCode() {
        int hashCode = ((((this.urlPrefixApi.hashCode() * 31) + this.urlPrefixWww.hashCode()) * 31) + this.addrLog.hashCode()) * 31;
        List<String> list = this.authRequiredHost;
        return hashCode + (list == null ? 0 : list.hashCode());
    }

    @NotNull
    public String toString() {
        return "BaseUrlModel(urlPrefixApi=" + this.urlPrefixApi + ", urlPrefixWww=" + this.urlPrefixWww + ", addrLog=" + this.addrLog + ", authRequiredHost=" + ((Object) this.authRequiredHost) + ")";
    }

    public /* synthetic */ BaseUrlModel(String str, String str2, String str3, List list, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? "https://api.finka.cn" : str, (i10 & 2) != 0 ? "https://www.finka.cn" : str2, (i10 & 4) != 0 ? "aloha-log.enjoymeet.com" : str3, list);
    }
}
