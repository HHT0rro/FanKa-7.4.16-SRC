package com.cupidapp.live.hashtag.model;

import java.io.Serializable;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: HashTagResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class HashTagRecommend implements Serializable {

    @Nullable
    private final List<HashTag> hashTags;

    @Nullable
    private final String title;

    public HashTagRecommend(@Nullable List<HashTag> list, @Nullable String str) {
        this.hashTags = list;
        this.title = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HashTagRecommend copy$default(HashTagRecommend hashTagRecommend, List list, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = hashTagRecommend.hashTags;
        }
        if ((i10 & 2) != 0) {
            str = hashTagRecommend.title;
        }
        return hashTagRecommend.copy(list, str);
    }

    @Nullable
    public final List<HashTag> component1() {
        return this.hashTags;
    }

    @Nullable
    public final String component2() {
        return this.title;
    }

    @NotNull
    public final HashTagRecommend copy(@Nullable List<HashTag> list, @Nullable String str) {
        return new HashTagRecommend(list, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HashTagRecommend)) {
            return false;
        }
        HashTagRecommend hashTagRecommend = (HashTagRecommend) obj;
        return s.d(this.hashTags, hashTagRecommend.hashTags) && s.d(this.title, hashTagRecommend.title);
    }

    @Nullable
    public final List<HashTag> getHashTags() {
        return this.hashTags;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        List<HashTag> list = this.hashTags;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        String str = this.title;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        List<HashTag> list = this.hashTags;
        return "HashTagRecommend(hashTags=" + ((Object) list) + ", title=" + this.title + ")";
    }
}
