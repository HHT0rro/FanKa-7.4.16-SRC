package com.cupidapp.live.match.model;

import java.util.List;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FilterModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class SVipKeywordOptionModel {

    @Nullable
    private final Map<String, List<KeyWordOptionModel>> options;
    private final int productType;

    @Nullable
    private final String title;

    /* JADX WARN: Multi-variable type inference failed */
    public SVipKeywordOptionModel(@Nullable Map<String, ? extends List<KeyWordOptionModel>> map, @Nullable String str, int i10) {
        this.options = map;
        this.title = str;
        this.productType = i10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SVipKeywordOptionModel copy$default(SVipKeywordOptionModel sVipKeywordOptionModel, Map map, String str, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            map = sVipKeywordOptionModel.options;
        }
        if ((i11 & 2) != 0) {
            str = sVipKeywordOptionModel.title;
        }
        if ((i11 & 4) != 0) {
            i10 = sVipKeywordOptionModel.productType;
        }
        return sVipKeywordOptionModel.copy(map, str, i10);
    }

    @Nullable
    public final Map<String, List<KeyWordOptionModel>> component1() {
        return this.options;
    }

    @Nullable
    public final String component2() {
        return this.title;
    }

    public final int component3() {
        return this.productType;
    }

    @NotNull
    public final SVipKeywordOptionModel copy(@Nullable Map<String, ? extends List<KeyWordOptionModel>> map, @Nullable String str, int i10) {
        return new SVipKeywordOptionModel(map, str, i10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SVipKeywordOptionModel)) {
            return false;
        }
        SVipKeywordOptionModel sVipKeywordOptionModel = (SVipKeywordOptionModel) obj;
        return s.d(this.options, sVipKeywordOptionModel.options) && s.d(this.title, sVipKeywordOptionModel.title) && this.productType == sVipKeywordOptionModel.productType;
    }

    @Nullable
    public final Map<String, List<KeyWordOptionModel>> getOptions() {
        return this.options;
    }

    public final int getProductType() {
        return this.productType;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        Map<String, List<KeyWordOptionModel>> map = this.options;
        int hashCode = (map == null ? 0 : map.hashCode()) * 31;
        String str = this.title;
        return ((hashCode + (str != null ? str.hashCode() : 0)) * 31) + this.productType;
    }

    @NotNull
    public String toString() {
        Map<String, List<KeyWordOptionModel>> map = this.options;
        return "SVipKeywordOptionModel(options=" + ((Object) map) + ", title=" + this.title + ", productType=" + this.productType + ")";
    }
}
