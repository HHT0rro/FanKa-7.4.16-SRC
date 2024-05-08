package com.cupidapp.live.profile.model;

import java.io.Serializable;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: NearByGuideModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class NearByGuideModel implements Serializable {

    @Nullable
    private final List<NearByGuideUserModel> list;

    @Nullable
    private final String subtitle;

    @Nullable
    private final String title;

    @Nullable
    private final String url;

    public NearByGuideModel(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable List<NearByGuideUserModel> list) {
        this.title = str;
        this.subtitle = str2;
        this.url = str3;
        this.list = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ NearByGuideModel copy$default(NearByGuideModel nearByGuideModel, String str, String str2, String str3, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = nearByGuideModel.title;
        }
        if ((i10 & 2) != 0) {
            str2 = nearByGuideModel.subtitle;
        }
        if ((i10 & 4) != 0) {
            str3 = nearByGuideModel.url;
        }
        if ((i10 & 8) != 0) {
            list = nearByGuideModel.list;
        }
        return nearByGuideModel.copy(str, str2, str3, list);
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
    public final String component3() {
        return this.url;
    }

    @Nullable
    public final List<NearByGuideUserModel> component4() {
        return this.list;
    }

    @NotNull
    public final NearByGuideModel copy(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable List<NearByGuideUserModel> list) {
        return new NearByGuideModel(str, str2, str3, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NearByGuideModel)) {
            return false;
        }
        NearByGuideModel nearByGuideModel = (NearByGuideModel) obj;
        return s.d(this.title, nearByGuideModel.title) && s.d(this.subtitle, nearByGuideModel.subtitle) && s.d(this.url, nearByGuideModel.url) && s.d(this.list, nearByGuideModel.list);
    }

    @Nullable
    public final List<NearByGuideUserModel> getList() {
        return this.list;
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
        String str3 = this.url;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        List<NearByGuideUserModel> list = this.list;
        return hashCode3 + (list != null ? list.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "NearByGuideModel(title=" + this.title + ", subtitle=" + this.subtitle + ", url=" + this.url + ", list=" + ((Object) this.list) + ")";
    }
}
