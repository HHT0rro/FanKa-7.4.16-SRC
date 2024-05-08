package com.cupidapp.live.match.model;

import com.cupidapp.live.base.network.model.ImageModel;
import com.google.gson.annotations.SerializedName;
import com.tencent.open.SocialConstants;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: NearByModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MapOverPopResult {

    @Nullable
    private final List<ImageModel> avatars;

    @SerializedName(alternate = {SocialConstants.PARAM_APP_DESC}, value = "subtitle")
    @Nullable
    private final String subtitle;

    @Nullable
    private final String title;

    @Nullable
    private final String url;

    public MapOverPopResult(@Nullable String str, @Nullable String str2, @Nullable List<ImageModel> list, @Nullable String str3) {
        this.title = str;
        this.subtitle = str2;
        this.avatars = list;
        this.url = str3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MapOverPopResult copy$default(MapOverPopResult mapOverPopResult, String str, String str2, List list, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = mapOverPopResult.title;
        }
        if ((i10 & 2) != 0) {
            str2 = mapOverPopResult.subtitle;
        }
        if ((i10 & 4) != 0) {
            list = mapOverPopResult.avatars;
        }
        if ((i10 & 8) != 0) {
            str3 = mapOverPopResult.url;
        }
        return mapOverPopResult.copy(str, str2, list, str3);
    }

    @Nullable
    public final String component1() {
        return this.title;
    }

    @Nullable
    public final String component2() {
        return this.subtitle;
    }

    @Nullable
    public final List<ImageModel> component3() {
        return this.avatars;
    }

    @Nullable
    public final String component4() {
        return this.url;
    }

    @NotNull
    public final MapOverPopResult copy(@Nullable String str, @Nullable String str2, @Nullable List<ImageModel> list, @Nullable String str3) {
        return new MapOverPopResult(str, str2, list, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MapOverPopResult)) {
            return false;
        }
        MapOverPopResult mapOverPopResult = (MapOverPopResult) obj;
        return s.d(this.title, mapOverPopResult.title) && s.d(this.subtitle, mapOverPopResult.subtitle) && s.d(this.avatars, mapOverPopResult.avatars) && s.d(this.url, mapOverPopResult.url);
    }

    @Nullable
    public final List<ImageModel> getAvatars() {
        return this.avatars;
    }

    @Nullable
    public final String getSubtitle() {
        return this.subtitle;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        String str = this.title;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.subtitle;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<ImageModel> list = this.avatars;
        int hashCode3 = (hashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        String str3 = this.url;
        return hashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        String str = this.title;
        String str2 = this.subtitle;
        List<ImageModel> list = this.avatars;
        return "MapOverPopResult(title=" + str + ", subtitle=" + str2 + ", avatars=" + ((Object) list) + ", url=" + this.url + ")";
    }
}
