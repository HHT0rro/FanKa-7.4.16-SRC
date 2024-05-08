package com.cupidapp.live.hashtag.model;

import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: HashTagResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class HashTagAggregationModel {

    @Nullable
    private final List<HashTag> hashTags;

    @Nullable
    private final String itemId;

    @Nullable
    private final String title;

    public HashTagAggregationModel(@Nullable List<HashTag> list, @Nullable String str, @Nullable String str2) {
        this.hashTags = list;
        this.itemId = str;
        this.title = str2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HashTagAggregationModel copy$default(HashTagAggregationModel hashTagAggregationModel, List list, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = hashTagAggregationModel.hashTags;
        }
        if ((i10 & 2) != 0) {
            str = hashTagAggregationModel.itemId;
        }
        if ((i10 & 4) != 0) {
            str2 = hashTagAggregationModel.title;
        }
        return hashTagAggregationModel.copy(list, str, str2);
    }

    @Nullable
    public final List<HashTag> component1() {
        return this.hashTags;
    }

    @Nullable
    public final String component2() {
        return this.itemId;
    }

    @Nullable
    public final String component3() {
        return this.title;
    }

    @NotNull
    public final HashTagAggregationModel copy(@Nullable List<HashTag> list, @Nullable String str, @Nullable String str2) {
        return new HashTagAggregationModel(list, str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HashTagAggregationModel)) {
            return false;
        }
        HashTagAggregationModel hashTagAggregationModel = (HashTagAggregationModel) obj;
        return s.d(this.hashTags, hashTagAggregationModel.hashTags) && s.d(this.itemId, hashTagAggregationModel.itemId) && s.d(this.title, hashTagAggregationModel.title);
    }

    @Nullable
    public final List<HashTag> getHashTags() {
        return this.hashTags;
    }

    @Nullable
    public final String getItemId() {
        return this.itemId;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        List<HashTag> list = this.hashTags;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        String str = this.itemId;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.title;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        List<HashTag> list = this.hashTags;
        return "HashTagAggregationModel(hashTags=" + ((Object) list) + ", itemId=" + this.itemId + ", title=" + this.title + ")";
    }
}
