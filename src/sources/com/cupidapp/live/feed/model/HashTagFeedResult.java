package com.cupidapp.live.feed.model;

import com.cupidapp.live.hashtag.model.HashTag;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: HashTagFeedResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class HashTagFeedResult {

    @NotNull
    private final HashTag hashtag;

    @Nullable
    private final List<FeedModel> list;

    @Nullable
    private final String nextCursorId;

    public HashTagFeedResult(@NotNull HashTag hashtag, @Nullable List<FeedModel> list, @Nullable String str) {
        s.i(hashtag, "hashtag");
        this.hashtag = hashtag;
        this.list = list;
        this.nextCursorId = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HashTagFeedResult copy$default(HashTagFeedResult hashTagFeedResult, HashTag hashTag, List list, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            hashTag = hashTagFeedResult.hashtag;
        }
        if ((i10 & 2) != 0) {
            list = hashTagFeedResult.list;
        }
        if ((i10 & 4) != 0) {
            str = hashTagFeedResult.nextCursorId;
        }
        return hashTagFeedResult.copy(hashTag, list, str);
    }

    @NotNull
    public final HashTag component1() {
        return this.hashtag;
    }

    @Nullable
    public final List<FeedModel> component2() {
        return this.list;
    }

    @Nullable
    public final String component3() {
        return this.nextCursorId;
    }

    @NotNull
    public final HashTagFeedResult copy(@NotNull HashTag hashtag, @Nullable List<FeedModel> list, @Nullable String str) {
        s.i(hashtag, "hashtag");
        return new HashTagFeedResult(hashtag, list, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HashTagFeedResult)) {
            return false;
        }
        HashTagFeedResult hashTagFeedResult = (HashTagFeedResult) obj;
        return s.d(this.hashtag, hashTagFeedResult.hashtag) && s.d(this.list, hashTagFeedResult.list) && s.d(this.nextCursorId, hashTagFeedResult.nextCursorId);
    }

    @NotNull
    public final HashTag getHashtag() {
        return this.hashtag;
    }

    @Nullable
    public final List<FeedModel> getList() {
        return this.list;
    }

    @Nullable
    public final String getNextCursorId() {
        return this.nextCursorId;
    }

    public int hashCode() {
        int hashCode = this.hashtag.hashCode() * 31;
        List<FeedModel> list = this.list;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        String str = this.nextCursorId;
        return hashCode2 + (str != null ? str.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        HashTag hashTag = this.hashtag;
        List<FeedModel> list = this.list;
        return "HashTagFeedResult(hashtag=" + ((Object) hashTag) + ", list=" + ((Object) list) + ", nextCursorId=" + this.nextCursorId + ")";
    }

    public /* synthetic */ HashTagFeedResult(HashTag hashTag, List list, String str, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(hashTag, list, (i10 & 4) != 0 ? null : str);
    }
}
