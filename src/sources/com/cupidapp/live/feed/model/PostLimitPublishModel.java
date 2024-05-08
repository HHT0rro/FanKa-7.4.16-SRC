package com.cupidapp.live.feed.model;

import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PostLimitFriendsModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class PostLimitPublishModel implements Serializable {

    /* renamed from: id, reason: collision with root package name */
    @Nullable
    private final String f14612id;

    public PostLimitPublishModel(@Nullable String str) {
        this.f14612id = str;
    }

    public static /* synthetic */ PostLimitPublishModel copy$default(PostLimitPublishModel postLimitPublishModel, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = postLimitPublishModel.f14612id;
        }
        return postLimitPublishModel.copy(str);
    }

    @Nullable
    public final String component1() {
        return this.f14612id;
    }

    @NotNull
    public final PostLimitPublishModel copy(@Nullable String str) {
        return new PostLimitPublishModel(str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PostLimitPublishModel) && s.d(this.f14612id, ((PostLimitPublishModel) obj).f14612id);
    }

    @Nullable
    public final String getId() {
        return this.f14612id;
    }

    public int hashCode() {
        String str = this.f14612id;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    @NotNull
    public String toString() {
        return "PostLimitPublishModel(id=" + this.f14612id + ")";
    }
}
