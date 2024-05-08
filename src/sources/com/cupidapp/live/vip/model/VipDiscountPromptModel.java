package com.cupidapp.live.vip.model;

import com.cupidapp.live.base.network.model.ImageModel;
import java.util.List;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VipDiscountPromptModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VipDiscountPromptModel {

    @Nullable
    private final ImageModel image;

    @Nullable
    private final List<String> showPlace;

    @Nullable
    private final Long timing;

    @Nullable
    private final String title;

    @Nullable
    private final Map<String, String> url;

    public VipDiscountPromptModel(@Nullable String str, @Nullable ImageModel imageModel, @Nullable Long l10, @Nullable List<String> list, @Nullable Map<String, String> map) {
        this.title = str;
        this.image = imageModel;
        this.timing = l10;
        this.showPlace = list;
        this.url = map;
    }

    public static /* synthetic */ VipDiscountPromptModel copy$default(VipDiscountPromptModel vipDiscountPromptModel, String str, ImageModel imageModel, Long l10, List list, Map map, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = vipDiscountPromptModel.title;
        }
        if ((i10 & 2) != 0) {
            imageModel = vipDiscountPromptModel.image;
        }
        ImageModel imageModel2 = imageModel;
        if ((i10 & 4) != 0) {
            l10 = vipDiscountPromptModel.timing;
        }
        Long l11 = l10;
        if ((i10 & 8) != 0) {
            list = vipDiscountPromptModel.showPlace;
        }
        List list2 = list;
        if ((i10 & 16) != 0) {
            map = vipDiscountPromptModel.url;
        }
        return vipDiscountPromptModel.copy(str, imageModel2, l11, list2, map);
    }

    @Nullable
    public final String component1() {
        return this.title;
    }

    @Nullable
    public final ImageModel component2() {
        return this.image;
    }

    @Nullable
    public final Long component3() {
        return this.timing;
    }

    @Nullable
    public final List<String> component4() {
        return this.showPlace;
    }

    @Nullable
    public final Map<String, String> component5() {
        return this.url;
    }

    @NotNull
    public final VipDiscountPromptModel copy(@Nullable String str, @Nullable ImageModel imageModel, @Nullable Long l10, @Nullable List<String> list, @Nullable Map<String, String> map) {
        return new VipDiscountPromptModel(str, imageModel, l10, list, map);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VipDiscountPromptModel)) {
            return false;
        }
        VipDiscountPromptModel vipDiscountPromptModel = (VipDiscountPromptModel) obj;
        return s.d(this.title, vipDiscountPromptModel.title) && s.d(this.image, vipDiscountPromptModel.image) && s.d(this.timing, vipDiscountPromptModel.timing) && s.d(this.showPlace, vipDiscountPromptModel.showPlace) && s.d(this.url, vipDiscountPromptModel.url);
    }

    @Nullable
    public final ImageModel getImage() {
        return this.image;
    }

    @Nullable
    public final List<String> getShowPlace() {
        return this.showPlace;
    }

    @Nullable
    public final Long getTiming() {
        return this.timing;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final Map<String, String> getUrl() {
        return this.url;
    }

    public int hashCode() {
        String str = this.title;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        ImageModel imageModel = this.image;
        int hashCode2 = (hashCode + (imageModel == null ? 0 : imageModel.hashCode())) * 31;
        Long l10 = this.timing;
        int hashCode3 = (hashCode2 + (l10 == null ? 0 : l10.hashCode())) * 31;
        List<String> list = this.showPlace;
        int hashCode4 = (hashCode3 + (list == null ? 0 : list.hashCode())) * 31;
        Map<String, String> map = this.url;
        return hashCode4 + (map != null ? map.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "VipDiscountPromptModel(title=" + this.title + ", image=" + ((Object) this.image) + ", timing=" + ((Object) this.timing) + ", showPlace=" + ((Object) this.showPlace) + ", url=" + ((Object) this.url) + ")";
    }
}
