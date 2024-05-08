package com.cupidapp.live.hashtag.model;

import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: HashTagResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class HashTagInfoResult implements Serializable {

    @NotNull
    private final HashTag hashtag;

    public HashTagInfoResult(@NotNull HashTag hashtag) {
        s.i(hashtag, "hashtag");
        this.hashtag = hashtag;
    }

    public static /* synthetic */ HashTagInfoResult copy$default(HashTagInfoResult hashTagInfoResult, HashTag hashTag, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            hashTag = hashTagInfoResult.hashtag;
        }
        return hashTagInfoResult.copy(hashTag);
    }

    @NotNull
    public final HashTag component1() {
        return this.hashtag;
    }

    @NotNull
    public final HashTagInfoResult copy(@NotNull HashTag hashtag) {
        s.i(hashtag, "hashtag");
        return new HashTagInfoResult(hashtag);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof HashTagInfoResult) && s.d(this.hashtag, ((HashTagInfoResult) obj).hashtag);
    }

    @NotNull
    public final HashTag getHashtag() {
        return this.hashtag;
    }

    public int hashCode() {
        return this.hashtag.hashCode();
    }

    @NotNull
    public String toString() {
        return "HashTagInfoResult(hashtag=" + ((Object) this.hashtag) + ")";
    }
}
