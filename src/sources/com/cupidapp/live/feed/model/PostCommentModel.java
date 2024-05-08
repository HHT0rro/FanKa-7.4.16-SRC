package com.cupidapp.live.feed.model;

import b2.a;
import com.cupidapp.live.mentionuser.model.ReplaceAtModel;
import com.cupidapp.live.profile.model.User;
import java.io.Serializable;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FeedTagModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class PostCommentModel implements Serializable {

    @Nullable
    private final Boolean author;

    @NotNull
    private String comment;

    @Nullable
    private final Integer commentCount;
    private final long createTimeMillis;

    @Nullable
    private Boolean delete;

    @Nullable
    private final Long deleteLastTime;

    /* renamed from: id, reason: collision with root package name */
    @NotNull
    private final String f14610id;

    @Nullable
    private String likeCount;

    @Nullable
    private Boolean liked;

    @Nullable
    private final List<PostCommentModel> nextLevelComments;

    @Nullable
    private final String nextLevelCursor;

    @Nullable
    private final Boolean parent;

    @Nullable
    private final String parentCommentUserId;

    @Nullable
    private final String publishIpCityName;

    @Nullable
    private final List<ReplaceAtModel> replaceAtList;

    @Nullable
    private User replyUser;

    @Nullable
    private final String reportData;

    @NotNull
    private final String type;

    @NotNull
    private User user;
    private final boolean whisper;

    public PostCommentModel(@NotNull String id2, @NotNull String type, @NotNull String comment, @NotNull User user, long j10, @Nullable User user2, boolean z10, @Nullable String str, @Nullable List<PostCommentModel> list, @Nullable Boolean bool, @Nullable String str2, @Nullable String str3, @Nullable Boolean bool2, @Nullable Boolean bool3, @Nullable Integer num, @Nullable Boolean bool4, @Nullable String str4, @Nullable Long l10, @Nullable List<ReplaceAtModel> list2, @Nullable String str5) {
        s.i(id2, "id");
        s.i(type, "type");
        s.i(comment, "comment");
        s.i(user, "user");
        this.f14610id = id2;
        this.type = type;
        this.comment = comment;
        this.user = user;
        this.createTimeMillis = j10;
        this.replyUser = user2;
        this.whisper = z10;
        this.reportData = str;
        this.nextLevelComments = list;
        this.author = bool;
        this.likeCount = str2;
        this.nextLevelCursor = str3;
        this.parent = bool2;
        this.delete = bool3;
        this.commentCount = num;
        this.liked = bool4;
        this.parentCommentUserId = str4;
        this.deleteLastTime = l10;
        this.replaceAtList = list2;
        this.publishIpCityName = str5;
    }

    @NotNull
    public final String component1() {
        return this.f14610id;
    }

    @Nullable
    public final Boolean component10() {
        return this.author;
    }

    @Nullable
    public final String component11() {
        return this.likeCount;
    }

    @Nullable
    public final String component12() {
        return this.nextLevelCursor;
    }

    @Nullable
    public final Boolean component13() {
        return this.parent;
    }

    @Nullable
    public final Boolean component14() {
        return this.delete;
    }

    @Nullable
    public final Integer component15() {
        return this.commentCount;
    }

    @Nullable
    public final Boolean component16() {
        return this.liked;
    }

    @Nullable
    public final String component17() {
        return this.parentCommentUserId;
    }

    @Nullable
    public final Long component18() {
        return this.deleteLastTime;
    }

    @Nullable
    public final List<ReplaceAtModel> component19() {
        return this.replaceAtList;
    }

    @NotNull
    public final String component2() {
        return this.type;
    }

    @Nullable
    public final String component20() {
        return this.publishIpCityName;
    }

    @NotNull
    public final String component3() {
        return this.comment;
    }

    @NotNull
    public final User component4() {
        return this.user;
    }

    public final long component5() {
        return this.createTimeMillis;
    }

    @Nullable
    public final User component6() {
        return this.replyUser;
    }

    public final boolean component7() {
        return this.whisper;
    }

    @Nullable
    public final String component8() {
        return this.reportData;
    }

    @Nullable
    public final List<PostCommentModel> component9() {
        return this.nextLevelComments;
    }

    @NotNull
    public final PostCommentModel copy(@NotNull String id2, @NotNull String type, @NotNull String comment, @NotNull User user, long j10, @Nullable User user2, boolean z10, @Nullable String str, @Nullable List<PostCommentModel> list, @Nullable Boolean bool, @Nullable String str2, @Nullable String str3, @Nullable Boolean bool2, @Nullable Boolean bool3, @Nullable Integer num, @Nullable Boolean bool4, @Nullable String str4, @Nullable Long l10, @Nullable List<ReplaceAtModel> list2, @Nullable String str5) {
        s.i(id2, "id");
        s.i(type, "type");
        s.i(comment, "comment");
        s.i(user, "user");
        return new PostCommentModel(id2, type, comment, user, j10, user2, z10, str, list, bool, str2, str3, bool2, bool3, num, bool4, str4, l10, list2, str5);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PostCommentModel)) {
            return false;
        }
        PostCommentModel postCommentModel = (PostCommentModel) obj;
        return s.d(this.f14610id, postCommentModel.f14610id) && s.d(this.type, postCommentModel.type) && s.d(this.comment, postCommentModel.comment) && s.d(this.user, postCommentModel.user) && this.createTimeMillis == postCommentModel.createTimeMillis && s.d(this.replyUser, postCommentModel.replyUser) && this.whisper == postCommentModel.whisper && s.d(this.reportData, postCommentModel.reportData) && s.d(this.nextLevelComments, postCommentModel.nextLevelComments) && s.d(this.author, postCommentModel.author) && s.d(this.likeCount, postCommentModel.likeCount) && s.d(this.nextLevelCursor, postCommentModel.nextLevelCursor) && s.d(this.parent, postCommentModel.parent) && s.d(this.delete, postCommentModel.delete) && s.d(this.commentCount, postCommentModel.commentCount) && s.d(this.liked, postCommentModel.liked) && s.d(this.parentCommentUserId, postCommentModel.parentCommentUserId) && s.d(this.deleteLastTime, postCommentModel.deleteLastTime) && s.d(this.replaceAtList, postCommentModel.replaceAtList) && s.d(this.publishIpCityName, postCommentModel.publishIpCityName);
    }

    @Nullable
    public final Boolean getAuthor() {
        return this.author;
    }

    @NotNull
    public final String getComment() {
        return this.comment;
    }

    @Nullable
    public final Integer getCommentCount() {
        return this.commentCount;
    }

    public final long getCreateTimeMillis() {
        return this.createTimeMillis;
    }

    @Nullable
    public final Boolean getDelete() {
        return this.delete;
    }

    @Nullable
    public final Long getDeleteLastTime() {
        return this.deleteLastTime;
    }

    @NotNull
    public final String getId() {
        return this.f14610id;
    }

    @Nullable
    public final String getLikeCount() {
        return this.likeCount;
    }

    @Nullable
    public final Boolean getLiked() {
        return this.liked;
    }

    @Nullable
    public final List<PostCommentModel> getNextLevelComments() {
        return this.nextLevelComments;
    }

    @Nullable
    public final String getNextLevelCursor() {
        return this.nextLevelCursor;
    }

    @Nullable
    public final Boolean getParent() {
        return this.parent;
    }

    @Nullable
    public final String getParentCommentUserId() {
        return this.parentCommentUserId;
    }

    @Nullable
    public final String getPublishIpCityName() {
        return this.publishIpCityName;
    }

    @Nullable
    public final List<ReplaceAtModel> getReplaceAtList() {
        return this.replaceAtList;
    }

    @Nullable
    public final User getReplyUser() {
        return this.replyUser;
    }

    @Nullable
    public final String getReportData() {
        return this.reportData;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    @NotNull
    public final User getUser() {
        return this.user;
    }

    public final boolean getWhisper() {
        return this.whisper;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((((this.f14610id.hashCode() * 31) + this.type.hashCode()) * 31) + this.comment.hashCode()) * 31) + this.user.hashCode()) * 31) + a.a(this.createTimeMillis)) * 31;
        User user = this.replyUser;
        int hashCode2 = (hashCode + (user == null ? 0 : user.hashCode())) * 31;
        boolean z10 = this.whisper;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        int i11 = (hashCode2 + i10) * 31;
        String str = this.reportData;
        int hashCode3 = (i11 + (str == null ? 0 : str.hashCode())) * 31;
        List<PostCommentModel> list = this.nextLevelComments;
        int hashCode4 = (hashCode3 + (list == null ? 0 : list.hashCode())) * 31;
        Boolean bool = this.author;
        int hashCode5 = (hashCode4 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str2 = this.likeCount;
        int hashCode6 = (hashCode5 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.nextLevelCursor;
        int hashCode7 = (hashCode6 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Boolean bool2 = this.parent;
        int hashCode8 = (hashCode7 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.delete;
        int hashCode9 = (hashCode8 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        Integer num = this.commentCount;
        int hashCode10 = (hashCode9 + (num == null ? 0 : num.hashCode())) * 31;
        Boolean bool4 = this.liked;
        int hashCode11 = (hashCode10 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
        String str4 = this.parentCommentUserId;
        int hashCode12 = (hashCode11 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Long l10 = this.deleteLastTime;
        int hashCode13 = (hashCode12 + (l10 == null ? 0 : l10.hashCode())) * 31;
        List<ReplaceAtModel> list2 = this.replaceAtList;
        int hashCode14 = (hashCode13 + (list2 == null ? 0 : list2.hashCode())) * 31;
        String str5 = this.publishIpCityName;
        return hashCode14 + (str5 != null ? str5.hashCode() : 0);
    }

    public final void setComment(@NotNull String str) {
        s.i(str, "<set-?>");
        this.comment = str;
    }

    public final void setDelete(@Nullable Boolean bool) {
        this.delete = bool;
    }

    public final void setLikeCount(@Nullable String str) {
        this.likeCount = str;
    }

    public final void setLiked(@Nullable Boolean bool) {
        this.liked = bool;
    }

    public final void setReplyUser(@Nullable User user) {
        this.replyUser = user;
    }

    public final void setUser(@NotNull User user) {
        s.i(user, "<set-?>");
        this.user = user;
    }

    @NotNull
    public String toString() {
        String str = this.f14610id;
        String str2 = this.type;
        String str3 = this.comment;
        User user = this.user;
        long j10 = this.createTimeMillis;
        User user2 = this.replyUser;
        boolean z10 = this.whisper;
        String str4 = this.reportData;
        List<PostCommentModel> list = this.nextLevelComments;
        Boolean bool = this.author;
        String str5 = this.likeCount;
        String str6 = this.nextLevelCursor;
        Boolean bool2 = this.parent;
        Boolean bool3 = this.delete;
        Integer num = this.commentCount;
        Boolean bool4 = this.liked;
        String str7 = this.parentCommentUserId;
        Long l10 = this.deleteLastTime;
        List<ReplaceAtModel> list2 = this.replaceAtList;
        return "PostCommentModel(id=" + str + ", type=" + str2 + ", comment=" + str3 + ", user=" + ((Object) user) + ", createTimeMillis=" + j10 + ", replyUser=" + ((Object) user2) + ", whisper=" + z10 + ", reportData=" + str4 + ", nextLevelComments=" + ((Object) list) + ", author=" + ((Object) bool) + ", likeCount=" + str5 + ", nextLevelCursor=" + str6 + ", parent=" + ((Object) bool2) + ", delete=" + ((Object) bool3) + ", commentCount=" + ((Object) num) + ", liked=" + ((Object) bool4) + ", parentCommentUserId=" + str7 + ", deleteLastTime=" + ((Object) l10) + ", replaceAtList=" + ((Object) list2) + ", publishIpCityName=" + this.publishIpCityName + ")";
    }
}
