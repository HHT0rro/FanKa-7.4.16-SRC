package com.cupidapp.live.notify.model;

import b2.a;
import com.cupidapp.live.feed.model.FeedModel;
import com.cupidapp.live.feed.model.PostCommentModel;
import com.cupidapp.live.profile.model.User;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PostNotifyModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class PostNotifyModel {

    @Nullable
    private final PostCommentModel comment;
    private final long createTime;

    @Nullable
    private User fromUser;

    @Nullable
    private final String notifyTypeText;

    @Nullable
    private final FeedModel post;

    @Nullable
    private final NotifyFriendPraiseModel praise;

    @Nullable
    private final String replyComment;

    @NotNull
    private final NotifyType type;
    private boolean unread;

    public PostNotifyModel(@NotNull NotifyType type, @Nullable User user, @Nullable FeedModel feedModel, boolean z10, @Nullable PostCommentModel postCommentModel, long j10, @Nullable String str, @Nullable String str2, @Nullable NotifyFriendPraiseModel notifyFriendPraiseModel) {
        s.i(type, "type");
        this.type = type;
        this.fromUser = user;
        this.post = feedModel;
        this.unread = z10;
        this.comment = postCommentModel;
        this.createTime = j10;
        this.replyComment = str;
        this.notifyTypeText = str2;
        this.praise = notifyFriendPraiseModel;
    }

    @NotNull
    public final NotifyType component1() {
        return this.type;
    }

    @Nullable
    public final User component2() {
        return this.fromUser;
    }

    @Nullable
    public final FeedModel component3() {
        return this.post;
    }

    public final boolean component4() {
        return this.unread;
    }

    @Nullable
    public final PostCommentModel component5() {
        return this.comment;
    }

    public final long component6() {
        return this.createTime;
    }

    @Nullable
    public final String component7() {
        return this.replyComment;
    }

    @Nullable
    public final String component8() {
        return this.notifyTypeText;
    }

    @Nullable
    public final NotifyFriendPraiseModel component9() {
        return this.praise;
    }

    @NotNull
    public final PostNotifyModel copy(@NotNull NotifyType type, @Nullable User user, @Nullable FeedModel feedModel, boolean z10, @Nullable PostCommentModel postCommentModel, long j10, @Nullable String str, @Nullable String str2, @Nullable NotifyFriendPraiseModel notifyFriendPraiseModel) {
        s.i(type, "type");
        return new PostNotifyModel(type, user, feedModel, z10, postCommentModel, j10, str, str2, notifyFriendPraiseModel);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PostNotifyModel)) {
            return false;
        }
        PostNotifyModel postNotifyModel = (PostNotifyModel) obj;
        return this.type == postNotifyModel.type && s.d(this.fromUser, postNotifyModel.fromUser) && s.d(this.post, postNotifyModel.post) && this.unread == postNotifyModel.unread && s.d(this.comment, postNotifyModel.comment) && this.createTime == postNotifyModel.createTime && s.d(this.replyComment, postNotifyModel.replyComment) && s.d(this.notifyTypeText, postNotifyModel.notifyTypeText) && s.d(this.praise, postNotifyModel.praise);
    }

    @Nullable
    public final PostCommentModel getComment() {
        return this.comment;
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    @Nullable
    public final User getFromUser() {
        return this.fromUser;
    }

    @Nullable
    public final String getNotifyTypeText() {
        return this.notifyTypeText;
    }

    @Nullable
    public final FeedModel getPost() {
        return this.post;
    }

    @Nullable
    public final NotifyFriendPraiseModel getPraise() {
        return this.praise;
    }

    @Nullable
    public final String getReplyComment() {
        return this.replyComment;
    }

    @NotNull
    public final NotifyType getType() {
        return this.type;
    }

    public final boolean getUnread() {
        return this.unread;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.type.hashCode() * 31;
        User user = this.fromUser;
        int hashCode2 = (hashCode + (user == null ? 0 : user.hashCode())) * 31;
        FeedModel feedModel = this.post;
        int hashCode3 = (hashCode2 + (feedModel == null ? 0 : feedModel.hashCode())) * 31;
        boolean z10 = this.unread;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        int i11 = (hashCode3 + i10) * 31;
        PostCommentModel postCommentModel = this.comment;
        int hashCode4 = (((i11 + (postCommentModel == null ? 0 : postCommentModel.hashCode())) * 31) + a.a(this.createTime)) * 31;
        String str = this.replyComment;
        int hashCode5 = (hashCode4 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.notifyTypeText;
        int hashCode6 = (hashCode5 + (str2 == null ? 0 : str2.hashCode())) * 31;
        NotifyFriendPraiseModel notifyFriendPraiseModel = this.praise;
        return hashCode6 + (notifyFriendPraiseModel != null ? notifyFriendPraiseModel.hashCode() : 0);
    }

    public final void setFromUser(@Nullable User user) {
        this.fromUser = user;
    }

    public final void setUnread(boolean z10) {
        this.unread = z10;
    }

    @NotNull
    public String toString() {
        NotifyType notifyType = this.type;
        User user = this.fromUser;
        FeedModel feedModel = this.post;
        boolean z10 = this.unread;
        PostCommentModel postCommentModel = this.comment;
        return "PostNotifyModel(type=" + ((Object) notifyType) + ", fromUser=" + ((Object) user) + ", post=" + ((Object) feedModel) + ", unread=" + z10 + ", comment=" + ((Object) postCommentModel) + ", createTime=" + this.createTime + ", replyComment=" + this.replyComment + ", notifyTypeText=" + this.notifyTypeText + ", praise=" + ((Object) this.praise) + ")";
    }

    public /* synthetic */ PostNotifyModel(NotifyType notifyType, User user, FeedModel feedModel, boolean z10, PostCommentModel postCommentModel, long j10, String str, String str2, NotifyFriendPraiseModel notifyFriendPraiseModel, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(notifyType, user, feedModel, (i10 & 8) != 0 ? false : z10, postCommentModel, (i10 & 32) != 0 ? 0L : j10, str, str2, notifyFriendPraiseModel);
    }
}
