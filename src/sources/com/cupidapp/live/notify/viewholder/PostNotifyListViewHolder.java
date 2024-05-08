package com.cupidapp.live.notify.viewholder;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.base.sensorslog.SensorsLogFeed;
import com.cupidapp.live.base.view.UserIconViewLayout;
import com.cupidapp.live.feed.helper.UserActionType;
import com.cupidapp.live.feed.helper.h;
import com.cupidapp.live.feed.model.FeedModel;
import com.cupidapp.live.feed.model.PostCommentModel;
import com.cupidapp.live.mentionuser.model.ReplaceAtModel;
import com.cupidapp.live.notify.model.NotifyFriendPraiseModel;
import com.cupidapp.live.notify.model.NotifyType;
import com.cupidapp.live.notify.model.PostNotifyModel;
import com.cupidapp.live.profile.logic.c;
import com.cupidapp.live.profile.model.User;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.List;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p1.g;
import z0.v;
import z0.y;
import z0.z;

/* compiled from: PostNotifyListViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class PostNotifyListViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final a f17578e = new a(null);

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public final ImageModel f17579c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public final Function2<String, PostNotifyModel, p> f17580d;

    /* compiled from: PostNotifyListViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final PostNotifyListViewHolder a(@NotNull ViewGroup parent, @Nullable ImageModel imageModel, @NotNull Function2<? super String, ? super PostNotifyModel, p> atUserClickListener) {
            s.i(parent, "parent");
            s.i(atUserClickListener, "atUserClickListener");
            return new PostNotifyListViewHolder(z.b(parent, R$layout.view_holder_post_notify, false, 2, null), imageModel, atUserClickListener);
        }
    }

    /* compiled from: PostNotifyListViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f17581a;

        static {
            int[] iArr = new int[NotifyType.values().length];
            try {
                iArr[NotifyType.PostTag.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[NotifyType.PostComment.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[NotifyType.PostCommentReplyOnMyPost.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[NotifyType.PostCommentReplyOnOthersPost.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[NotifyType.PostLike.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[NotifyType.PostCommentLike.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[NotifyType.PostAt.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[NotifyType.PostCommentAt.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[NotifyType.Announce.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[NotifyType.NewCloseFriend.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[NotifyType.PraiseLike.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[NotifyType.NewPraise.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            f17581a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PostNotifyListViewHolder(@NotNull View itemView, @Nullable ImageModel imageModel, @NotNull Function2<? super String, ? super PostNotifyModel, p> atUserClickListener) {
        super(itemView);
        s.i(itemView, "itemView");
        s.i(atUserClickListener, "atUserClickListener");
        this.f17579c = imageModel;
        this.f17580d = atUserClickListener;
    }

    public static /* synthetic */ void E(PostNotifyListViewHolder postNotifyListViewHolder, PostNotifyModel postNotifyModel, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        postNotifyListViewHolder.D(postNotifyModel, z10);
    }

    public static /* synthetic */ void G(PostNotifyListViewHolder postNotifyListViewHolder, PostNotifyModel postNotifyModel, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        postNotifyListViewHolder.F(postNotifyModel, z10);
    }

    @NotNull
    public final Function2<String, PostNotifyModel, p> A() {
        return this.f17580d;
    }

    public final SpannableStringBuilder B(final PostNotifyModel postNotifyModel, List<ReplaceAtModel> list, CharSequence charSequence) {
        return com.cupidapp.live.feed.helper.a.b(com.cupidapp.live.feed.helper.a.f14304a, list, charSequence, 0, new Function1<String, p>() { // from class: com.cupidapp.live.notify.viewholder.PostNotifyListViewHolder$getFormatComment$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(String str) {
                invoke2(str);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String it) {
                s.i(it, "it");
                PostNotifyListViewHolder.this.A().mo1743invoke(it, postNotifyModel);
            }
        }, 4, null);
    }

    public final void C(PostNotifyModel postNotifyModel) {
        SensorsLogFeed.LikeCommentType likeCommentType;
        if (postNotifyModel.getPost() == null || postNotifyModel.getComment() == null) {
            return;
        }
        if (s.d(postNotifyModel.getComment().getParent(), Boolean.TRUE)) {
            likeCommentType = SensorsLogFeed.LikeCommentType.FirstLevelComment;
        } else {
            likeCommentType = SensorsLogFeed.LikeCommentType.SecondLevelComment;
        }
        SensorsLogFeed.f12208a.m(postNotifyModel.getPost().getUser().userId(), postNotifyModel.getPost().getPostId(), SensorPosition.NotifyMention, SensorScene.NotificationComment, likeCommentType, postNotifyModel.getPost().getUser().getAloha(), postNotifyModel.getPost().getStrategyId(), g.f52734a.x());
    }

    public final void D(final PostNotifyModel postNotifyModel, boolean z10) {
        ((ImageView) this.itemView.findViewById(R$id.notifyLikeImageView)).setImageResource(R$mipmap.icon_notify_like_highlight);
        ((TextView) this.itemView.findViewById(R$id.notifyLikeTextView)).setVisibility(8);
        if (z10) {
            PostCommentModel comment = postNotifyModel.getComment();
            if (comment != null) {
                comment.setLiked(Boolean.TRUE);
            }
            FeedModel post = postNotifyModel.getPost();
            if ((post != null ? post.getPostId() : null) != null) {
                PostCommentModel comment2 = postNotifyModel.getComment();
                if ((comment2 != null ? comment2.getId() : null) != null) {
                    Observable<Result<Object>> T = NetworkClient.f11868a.l().T(postNotifyModel.getPost().getPostId(), postNotifyModel.getComment().getId());
                    Object context = this.itemView.getContext();
                    com.cupidapp.live.base.network.g gVar = context instanceof com.cupidapp.live.base.network.g ? (com.cupidapp.live.base.network.g) context : null;
                    Disposable disposed = T.flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<Object, p>() { // from class: com.cupidapp.live.notify.viewholder.PostNotifyListViewHolder$showLikeStyle$$inlined$handleByContext$default$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ p invoke(Object obj) {
                            invoke2(obj);
                            return p.f51048a;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Object obj) {
                            PostNotifyListViewHolder.this.C(postNotifyModel);
                        }
                    }), new e(new ObservableExtensionKt$handle$disposed$2(null, gVar)));
                    if (disposed != null) {
                        s.h(disposed, "disposed");
                        if (gVar != null) {
                            gVar.H(disposed);
                        }
                    }
                    s.h(disposed, "disposed");
                }
            }
        }
    }

    public final void F(PostNotifyModel postNotifyModel, boolean z10) {
        ((ImageView) this.itemView.findViewById(R$id.notifyLikeImageView)).setImageResource(R$mipmap.icon_notify_like);
        ((TextView) this.itemView.findViewById(R$id.notifyLikeTextView)).setVisibility(0);
        if (z10) {
            PostCommentModel comment = postNotifyModel.getComment();
            if (comment != null) {
                comment.setLiked(Boolean.FALSE);
            }
            FeedModel post = postNotifyModel.getPost();
            if ((post != null ? post.getPostId() : null) != null) {
                PostCommentModel comment2 = postNotifyModel.getComment();
                if ((comment2 != null ? comment2.getId() : null) != null) {
                    Observable<Result<Object>> h10 = NetworkClient.f11868a.l().h(postNotifyModel.getPost().getPostId(), postNotifyModel.getComment().getId());
                    Object context = this.itemView.getContext();
                    com.cupidapp.live.base.network.g gVar = context instanceof com.cupidapp.live.base.network.g ? (com.cupidapp.live.base.network.g) context : null;
                    Disposable disposed = h10.flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<Object, p>() { // from class: com.cupidapp.live.notify.viewholder.PostNotifyListViewHolder$showNotLikeStyle$$inlined$handleByContext$default$1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ p invoke(Object obj) {
                            invoke2(obj);
                            return p.f51048a;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Object obj) {
                        }
                    }), new e(new ObservableExtensionKt$handle$disposed$2(null, gVar)));
                    if (disposed != null) {
                        s.h(disposed, "disposed");
                        if (gVar != null) {
                            gVar.H(disposed);
                        }
                    }
                    s.h(disposed, "disposed");
                }
            }
        }
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof PostNotifyModel) {
            ((TextView) this.itemView.findViewById(R$id.friend_praise_show_in_profile_btn)).setVisibility(8);
            ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(R$id.notifyUserAvatarImageView);
            s.h(imageLoaderView, "itemView.notifyUserAvatarImageView");
            PostNotifyModel postNotifyModel = (PostNotifyModel) obj;
            User fromUser = postNotifyModel.getFromUser();
            ImageLoaderView.g(imageLoaderView, fromUser != null ? fromUser.getAvatarImage() : null, null, null, 6, null);
            User fromUser2 = postNotifyModel.getFromUser();
            if (fromUser2 != null) {
                UserIconViewLayout userIconViewLayout = (UserIconViewLayout) this.itemView.findViewById(R$id.vipIconImageView);
                s.h(userIconViewLayout, "itemView.vipIconImageView");
                UserIconViewLayout.d(userIconViewLayout, fromUser2.getUserVipModel(), SensorPosition.Unknown, UserIconViewLayout.VipIconPositionRef.Other, false, 8, null);
                User fromUser3 = postNotifyModel.getFromUser();
                if (fromUser3 != null && fromUser3.getFocus()) {
                    c cVar = c.f17839a;
                    User fromUser4 = postNotifyModel.getFromUser();
                    if (!cVar.a(fromUser4 != null ? fromUser4.userId() : null)) {
                        ((ImageView) this.itemView.findViewById(R$id.focusTagImg)).setVisibility(0);
                        ((ImageView) this.itemView.findViewById(R$id.closeFriendImg)).setVisibility(8);
                    }
                }
                ((ImageView) this.itemView.findViewById(R$id.focusTagImg)).setVisibility(8);
                User fromUser5 = postNotifyModel.getFromUser();
                if (fromUser5 != null && fromUser5.getCloseFriend()) {
                    ((ImageView) this.itemView.findViewById(R$id.closeFriendImg)).setVisibility(0);
                } else {
                    ((ImageView) this.itemView.findViewById(R$id.closeFriendImg)).setVisibility(8);
                }
            }
            View view = this.itemView;
            int i10 = R$id.notifyPostImageView;
            ((ImageLoaderView) view.findViewById(i10)).setVisibility(0);
            ImageLoaderView imageLoaderView2 = (ImageLoaderView) this.itemView.findViewById(i10);
            s.h(imageLoaderView2, "itemView.notifyPostImageView");
            FeedModel post = postNotifyModel.getPost();
            ImageLoaderView.g(imageLoaderView2, post != null ? post.getImageListFirst() : null, null, null, 6, null);
            ((TextView) this.itemView.findViewById(R$id.notifyUserNameTextView)).getPaint().setFakeBoldText(true);
            ((TextView) this.itemView.findViewById(R$id.set_close_friend_txt)).setVisibility(8);
            switch (b.f17581a[postNotifyModel.getType().ordinal()]) {
                case 1:
                    z(postNotifyModel);
                    break;
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                    w(postNotifyModel);
                    break;
                case 9:
                    u(postNotifyModel);
                    break;
                case 10:
                    v(postNotifyModel);
                    break;
                case 11:
                case 12:
                    x(postNotifyModel);
                    break;
            }
            this.itemView.setBackgroundColor(postNotifyModel.getUnread() ? -526345 : -1);
        }
    }

    public final void u(PostNotifyModel postNotifyModel) {
        TextView textView = (TextView) this.itemView.findViewById(R$id.notifyUserNameTextView);
        textView.setVisibility(0);
        User fromUser = postNotifyModel.getFromUser();
        textView.setText(fromUser != null ? fromUser.getName() : null);
        TextView textView2 = (TextView) this.itemView.findViewById(R$id.notifyTypeTextView);
        textView2.setVisibility(0);
        textView2.setText("");
        TextView textView3 = (TextView) this.itemView.findViewById(R$id.notifyTimeTextView);
        textView3.setVisibility(0);
        textView3.setText(v.n(postNotifyModel.getCreateTime(), this.itemView.getContext()));
        ((TextView) this.itemView.findViewById(R$id.notifyCommentContentTextView)).setVisibility(8);
        ((TextView) this.itemView.findViewById(R$id.alreadyDeleteCommentTextView)).setVisibility(8);
        ((TextView) this.itemView.findViewById(R$id.notifyPostTagTextView)).setVisibility(8);
        ((ImageLoaderView) this.itemView.findViewById(R$id.notifyPostImageView)).setVisibility(8);
        this.itemView.findViewById(R$id.notifyVerticalBarView).setVisibility(8);
        ((TextView) this.itemView.findViewById(R$id.notifyReplyCommentTextView)).setVisibility(8);
        ((LinearLayout) this.itemView.findViewById(R$id.notifyLikeLayout)).setVisibility(8);
        ((LinearLayout) this.itemView.findViewById(R$id.notifyReplyLayout)).setVisibility(8);
    }

    public final void v(PostNotifyModel postNotifyModel) {
        TextView textView = (TextView) this.itemView.findViewById(R$id.notifyUserNameTextView);
        textView.setVisibility(0);
        User fromUser = postNotifyModel.getFromUser();
        textView.setText(fromUser != null ? fromUser.getName() : null);
        TextView textView2 = (TextView) this.itemView.findViewById(R$id.notifyTypeTextView);
        textView2.setVisibility(0);
        textView2.setText(this.itemView.getContext().getString(R$string.set_you_close_friend));
        TextView textView3 = (TextView) this.itemView.findViewById(R$id.notifyTimeTextView);
        textView3.setVisibility(0);
        textView3.setText(this.itemView.getContext().getString(R$string.center_of_the_dot, v.n(postNotifyModel.getCreateTime(), this.itemView.getContext())));
        ImageLoaderView configCloseFriendView$lambda$10 = (ImageLoaderView) this.itemView.findViewById(R$id.notifyPostImageView);
        configCloseFriendView$lambda$10.setVisibility(0);
        s.h(configCloseFriendView$lambda$10, "configCloseFriendView$lambda$10");
        ImageLoaderView.g(configCloseFriendView$lambda$10, this.f17579c, null, null, 6, null);
        User fromUser2 = postNotifyModel.getFromUser();
        if ((fromUser2 == null || fromUser2.getCloseFriend()) ? false : true) {
            ((TextView) this.itemView.findViewById(R$id.set_close_friend_txt)).setVisibility(0);
        }
        ((TextView) this.itemView.findViewById(R$id.notifyCommentContentTextView)).setVisibility(8);
        ((TextView) this.itemView.findViewById(R$id.alreadyDeleteCommentTextView)).setVisibility(8);
        ((TextView) this.itemView.findViewById(R$id.notifyPostTagTextView)).setVisibility(8);
        this.itemView.findViewById(R$id.notifyVerticalBarView).setVisibility(8);
        ((TextView) this.itemView.findViewById(R$id.notifyReplyCommentTextView)).setVisibility(8);
        ((LinearLayout) this.itemView.findViewById(R$id.notifyLikeLayout)).setVisibility(8);
        ((LinearLayout) this.itemView.findViewById(R$id.notifyReplyLayout)).setVisibility(8);
    }

    public final void w(PostNotifyModel postNotifyModel) {
        TextView textView = (TextView) this.itemView.findViewById(R$id.notifyUserNameTextView);
        textView.setVisibility(0);
        User fromUser = postNotifyModel.getFromUser();
        textView.setText(fromUser != null ? fromUser.getName() : null);
        TextView textView2 = (TextView) this.itemView.findViewById(R$id.notifyTypeTextView);
        textView2.setVisibility(0);
        textView2.setText(postNotifyModel.getNotifyTypeText());
        TextView textView3 = (TextView) this.itemView.findViewById(R$id.notifyTimeTextView);
        textView3.setVisibility(0);
        boolean z10 = true;
        textView3.setText(this.itemView.getContext().getString(R$string.center_of_the_dot, v.n(postNotifyModel.getCreateTime(), this.itemView.getContext())));
        if (postNotifyModel.getType() == NotifyType.PostAt) {
            ((TextView) this.itemView.findViewById(R$id.alreadyDeleteCommentTextView)).setVisibility(8);
            FeedModel post = postNotifyModel.getPost();
            String description = post != null ? post.getDescription() : null;
            if (description == null || description.length() == 0) {
                ((TextView) this.itemView.findViewById(R$id.notifyCommentContentTextView)).setVisibility(8);
            } else {
                View view = this.itemView;
                int i10 = R$id.notifyCommentContentTextView;
                ((TextView) view.findViewById(i10)).setVisibility(0);
                ((TextView) this.itemView.findViewById(i10)).setText(B(postNotifyModel, postNotifyModel.getPost().getReplaceAtList(), description));
                ((TextView) this.itemView.findViewById(i10)).setMovementMethod(LinkMovementMethod.getInstance());
            }
        } else {
            if (postNotifyModel.getType() != NotifyType.PostLike && postNotifyModel.getType() != NotifyType.PostCommentLike) {
                PostCommentModel comment = postNotifyModel.getComment();
                if ((comment != null ? comment.getComment() : null) != null) {
                    SpannableStringBuilder B = B(postNotifyModel, postNotifyModel.getComment().getReplaceAtList(), postNotifyModel.getComment().getComment());
                    if (s.d(postNotifyModel.getComment().getDelete(), Boolean.TRUE)) {
                        View view2 = this.itemView;
                        int i11 = R$id.alreadyDeleteCommentTextView;
                        ((TextView) view2.findViewById(i11)).setVisibility(0);
                        ((TextView) this.itemView.findViewById(i11)).setText(B);
                        ((TextView) this.itemView.findViewById(i11)).setMovementMethod(LinkMovementMethod.getInstance());
                        ((TextView) this.itemView.findViewById(R$id.notifyCommentContentTextView)).setVisibility(8);
                    } else {
                        View view3 = this.itemView;
                        int i12 = R$id.notifyCommentContentTextView;
                        ((TextView) view3.findViewById(i12)).setVisibility(0);
                        ((TextView) this.itemView.findViewById(i12)).setText(B);
                        ((TextView) this.itemView.findViewById(i12)).setMovementMethod(LinkMovementMethod.getInstance());
                        ((TextView) this.itemView.findViewById(R$id.alreadyDeleteCommentTextView)).setVisibility(8);
                    }
                }
            }
            ((TextView) this.itemView.findViewById(R$id.notifyCommentContentTextView)).setVisibility(8);
            ((TextView) this.itemView.findViewById(R$id.alreadyDeleteCommentTextView)).setVisibility(8);
        }
        String replyComment = postNotifyModel.getReplyComment();
        if (replyComment != null && replyComment.length() != 0) {
            z10 = false;
        }
        if (z10) {
            this.itemView.findViewById(R$id.notifyVerticalBarView).setVisibility(8);
            ((TextView) this.itemView.findViewById(R$id.notifyReplyCommentTextView)).setVisibility(8);
        } else {
            this.itemView.findViewById(R$id.notifyVerticalBarView).setVisibility(0);
            View view4 = this.itemView;
            int i13 = R$id.notifyReplyCommentTextView;
            ((TextView) view4.findViewById(i13)).setVisibility(0);
            ((TextView) this.itemView.findViewById(i13)).setText(postNotifyModel.getReplyComment());
        }
        switch (b.f17581a[postNotifyModel.getType().ordinal()]) {
            case 2:
            case 3:
            case 4:
            case 8:
                PostCommentModel comment2 = postNotifyModel.getComment();
                if (comment2 != null ? s.d(comment2.getDelete(), Boolean.TRUE) : false) {
                    ((LinearLayout) this.itemView.findViewById(R$id.notifyLikeLayout)).setVisibility(8);
                    ((LinearLayout) this.itemView.findViewById(R$id.notifyReplyLayout)).setVisibility(8);
                    break;
                } else {
                    ((LinearLayout) this.itemView.findViewById(R$id.notifyLikeLayout)).setVisibility(0);
                    ((LinearLayout) this.itemView.findViewById(R$id.notifyReplyLayout)).setVisibility(0);
                    y(postNotifyModel);
                    break;
                }
            case 5:
            case 6:
            case 7:
                ((LinearLayout) this.itemView.findViewById(R$id.notifyLikeLayout)).setVisibility(8);
                ((LinearLayout) this.itemView.findViewById(R$id.notifyReplyLayout)).setVisibility(8);
                break;
        }
        ((TextView) this.itemView.findViewById(R$id.notifyPostTagTextView)).setVisibility(8);
    }

    public final void x(PostNotifyModel postNotifyModel) {
        TextView textView = (TextView) this.itemView.findViewById(R$id.notifyUserNameTextView);
        textView.setVisibility(0);
        User fromUser = postNotifyModel.getFromUser();
        textView.setText(fromUser != null ? fromUser.getName() : null);
        TextView textView2 = (TextView) this.itemView.findViewById(R$id.notifyTypeTextView);
        textView2.setVisibility(0);
        textView2.setText(postNotifyModel.getNotifyTypeText());
        TextView textView3 = (TextView) this.itemView.findViewById(R$id.notifyTimeTextView);
        textView3.setVisibility(0);
        textView3.setText(this.itemView.getContext().getString(R$string.center_of_the_dot, v.n(postNotifyModel.getCreateTime(), this.itemView.getContext())));
        ImageLoaderView configFriendPraiseView$lambda$4 = (ImageLoaderView) this.itemView.findViewById(R$id.notifyPostImageView);
        configFriendPraiseView$lambda$4.setVisibility(0);
        s.h(configFriendPraiseView$lambda$4, "configFriendPraiseView$lambda$4");
        NotifyFriendPraiseModel praise = postNotifyModel.getPraise();
        ImageLoaderView.g(configFriendPraiseView$lambda$4, praise != null ? praise.getPraiseIcon() : null, null, null, 6, null);
        if (postNotifyModel.getType() == NotifyType.NewPraise) {
            TextView textView4 = (TextView) this.itemView.findViewById(R$id.notifyCommentContentTextView);
            textView4.setVisibility(0);
            NotifyFriendPraiseModel praise2 = postNotifyModel.getPraise();
            textView4.setText(praise2 != null ? praise2.getContent() : null);
            TextView textView5 = (TextView) this.itemView.findViewById(R$id.friend_praise_show_in_profile_btn);
            textView5.setVisibility(0);
            NotifyFriendPraiseModel praise3 = postNotifyModel.getPraise();
            if (praise3 != null ? s.d(praise3.getHomePageDisplay(), Boolean.TRUE) : false) {
                textView5.setText(this.itemView.getContext().getString(R$string.already_set_as_profile_display));
                textView5.setTextColor(-3750202);
            } else {
                textView5.setText(this.itemView.getContext().getString(R$string.set_as_profile_display));
                textView5.setTextColor(-15066598);
            }
        } else {
            ((TextView) this.itemView.findViewById(R$id.notifyCommentContentTextView)).setVisibility(8);
            ((TextView) this.itemView.findViewById(R$id.friend_praise_show_in_profile_btn)).setVisibility(8);
        }
        ((TextView) this.itemView.findViewById(R$id.alreadyDeleteCommentTextView)).setVisibility(8);
        ((TextView) this.itemView.findViewById(R$id.notifyPostTagTextView)).setVisibility(8);
        this.itemView.findViewById(R$id.notifyVerticalBarView).setVisibility(8);
        ((TextView) this.itemView.findViewById(R$id.notifyReplyCommentTextView)).setVisibility(8);
        ((TextView) this.itemView.findViewById(R$id.set_close_friend_txt)).setVisibility(8);
        ((LinearLayout) this.itemView.findViewById(R$id.notifyReplyLayout)).setVisibility(8);
        ((LinearLayout) this.itemView.findViewById(R$id.notifyLikeLayout)).setVisibility(8);
    }

    public final void y(final PostNotifyModel postNotifyModel) {
        PostCommentModel comment = postNotifyModel.getComment();
        if (comment != null ? s.d(comment.getLiked(), Boolean.TRUE) : false) {
            E(this, postNotifyModel, false, 2, null);
        } else {
            G(this, postNotifyModel, false, 2, null);
        }
        LinearLayout linearLayout = (LinearLayout) this.itemView.findViewById(R$id.notifyLikeLayout);
        s.h(linearLayout, "itemView.notifyLikeLayout");
        y.d(linearLayout, new Function1<View, p>() { // from class: com.cupidapp.live.notify.viewholder.PostNotifyListViewHolder$configNotifyLikeImage$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(View view) {
                invoke2(view);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                FeedModel post = PostNotifyModel.this.getPost();
                if (post != null) {
                    PostNotifyModel postNotifyModel2 = PostNotifyModel.this;
                    h hVar = h.f14329a;
                    String postId = post.getPostId();
                    Integer tagId = post.getTagId();
                    PostCommentModel comment2 = postNotifyModel2.getComment();
                    hVar.e(postId, tagId, comment2 != null ? s.d(comment2.getLiked(), Boolean.TRUE) : false ? UserActionType.CancelPraise : UserActionType.Praise, SensorPosition.NotifyMention, SensorPosition.Notify, (r18 & 32) != 0 ? null : null, (r18 & 64) != 0 ? null : post.getPostStatisticsCallback());
                }
                PostCommentModel comment3 = PostNotifyModel.this.getComment();
                if (comment3 != null ? s.d(comment3.getLiked(), Boolean.TRUE) : false) {
                    this.F(PostNotifyModel.this, true);
                } else {
                    this.D(PostNotifyModel.this, true);
                }
                PostNotifyModel.this.setUnread(false);
                this.itemView.setBackgroundColor(-1);
            }
        });
    }

    public final void z(PostNotifyModel postNotifyModel) {
        String str;
        String name;
        Context context = this.itemView.getContext();
        Object[] objArr = new Object[1];
        User fromUser = postNotifyModel.getFromUser();
        if (fromUser == null || (str = fromUser.getName()) == null) {
            str = "";
        }
        objArr[0] = str;
        String string = context.getString(R$string.notify_post_tag_description, objArr);
        s.h(string, "itemView.context.getStri…ser?.name ?: \"\"\n        )");
        SpannableString spannableString = new SpannableString(string);
        StyleSpan styleSpan = new StyleSpan(1);
        User fromUser2 = postNotifyModel.getFromUser();
        spannableString.setSpan(styleSpan, 0, (fromUser2 == null || (name = fromUser2.getName()) == null) ? 0 : name.length(), 33);
        View view = this.itemView;
        int i10 = R$id.notifyPostTagTextView;
        ((TextView) view.findViewById(i10)).setText(string);
        ((TextView) this.itemView.findViewById(i10)).setVisibility(0);
        ((TextView) this.itemView.findViewById(R$id.notifyUserNameTextView)).setVisibility(8);
        ((TextView) this.itemView.findViewById(R$id.notifyTypeTextView)).setVisibility(8);
        ((TextView) this.itemView.findViewById(R$id.notifyTimeTextView)).setVisibility(8);
        ((TextView) this.itemView.findViewById(R$id.notifyCommentContentTextView)).setVisibility(8);
        ((TextView) this.itemView.findViewById(R$id.alreadyDeleteCommentTextView)).setVisibility(8);
        this.itemView.findViewById(R$id.notifyVerticalBarView).setVisibility(8);
        ((TextView) this.itemView.findViewById(R$id.notifyReplyCommentTextView)).setVisibility(8);
        ((LinearLayout) this.itemView.findViewById(R$id.notifyLikeLayout)).setVisibility(8);
        ((LinearLayout) this.itemView.findViewById(R$id.notifyReplyLayout)).setVisibility(8);
    }
}
