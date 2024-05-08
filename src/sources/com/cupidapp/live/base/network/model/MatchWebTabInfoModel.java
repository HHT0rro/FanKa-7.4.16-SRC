package com.cupidapp.live.base.network.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ConstantsResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class MatchWebTabInfoModel {

    @Nullable
    private final String name;

    @Nullable
    private final String trackName;

    @Nullable
    private final String url;

    public MatchWebTabInfoModel(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        this.name = str;
        this.url = str2;
        this.trackName = str3;
    }

    public static /* synthetic */ MatchWebTabInfoModel copy$default(MatchWebTabInfoModel matchWebTabInfoModel, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = matchWebTabInfoModel.name;
        }
        if ((i10 & 2) != 0) {
            str2 = matchWebTabInfoModel.url;
        }
        if ((i10 & 4) != 0) {
            str3 = matchWebTabInfoModel.trackName;
        }
        return matchWebTabInfoModel.copy(str, str2, str3);
    }

    @Nullable
    public final String component1() {
        return this.name;
    }

    @Nullable
    public final String component2() {
        return this.url;
    }

    @Nullable
    public final String component3() {
        return this.trackName;
    }

    @NotNull
    public final MatchWebTabInfoModel copy(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        return new MatchWebTabInfoModel(str, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MatchWebTabInfoModel)) {
            return false;
        }
        MatchWebTabInfoModel matchWebTabInfoModel = (MatchWebTabInfoModel) obj;
        return s.d(this.name, matchWebTabInfoModel.name) && s.d(this.url, matchWebTabInfoModel.url) && s.d(this.trackName, matchWebTabInfoModel.trackName);
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final String getTrackName() {
        return this.trackName;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        String str = this.name;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.url;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.trackName;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "MatchWebTabInfoModel(name=" + this.name + ", url=" + this.url + ", trackName=" + this.trackName + ")";
    }
}
