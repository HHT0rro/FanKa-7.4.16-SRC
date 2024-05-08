package com.cupidapp.live.feed.holder;

import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.utils.h0;
import com.cupidapp.live.base.view.UserIconViewLayout;
import com.cupidapp.live.feed.model.PostCommentModel;
import com.cupidapp.live.profile.model.User;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import kotlin.text.StringsKt__StringsKt;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.u;
import z0.v;
import z0.y;
import z0.z;

/* compiled from: FeedDetailCommentViewHolder.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FeedDetailCommentViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f14377d = new a(null);

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final List<Object> f14378c;

    /* compiled from: FeedDetailCommentViewHolder.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FeedDetailCommentViewHolder a(@NotNull ViewGroup parent, @NotNull List<? extends Object> list) {
            s.i(parent, "parent");
            s.i(list, "list");
            return new FeedDetailCommentViewHolder(z.b(parent, R$layout.view_holder_feed_detail_comment, false, 2, null), list);
        }
    }

    /* compiled from: FeedDetailCommentViewHolder.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class b extends h0 {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PostCommentModel f14379b;

        public b(PostCommentModel postCommentModel) {
            this.f14379b = postCommentModel;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View widget) {
            s.i(widget, "widget");
            User replyUser = this.f14379b.getReplyUser();
            if (replyUser != null) {
                EventBus.c().l(new FeedDetailOpenProfileEvent(replyUser));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedDetailCommentViewHolder(@NotNull View itemView, @NotNull List<? extends Object> list) {
        super(itemView);
        s.i(itemView, "itemView");
        s.i(list, "list");
        this.f14378c = list;
    }

    public static /* synthetic */ void B(FeedDetailCommentViewHolder feedDetailCommentViewHolder, FeedDetailCommentViewModel feedDetailCommentViewModel, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        feedDetailCommentViewHolder.A(feedDetailCommentViewModel, i10, z10);
    }

    public static /* synthetic */ void D(FeedDetailCommentViewHolder feedDetailCommentViewHolder, FeedDetailCommentViewModel feedDetailCommentViewModel, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        feedDetailCommentViewHolder.C(feedDetailCommentViewModel, i10, z10);
    }

    public final void A(final FeedDetailCommentViewModel feedDetailCommentViewModel, int i10, boolean z10) {
        View view = this.itemView;
        int i11 = R$id.detailLikeTextView;
        TextView textView = (TextView) view.findViewById(i11);
        s.h(textView, "itemView.detailLikeTextView");
        u.e(textView, 0, 0, R$mipmap.icon_comment_like_highlight, 0, 11, null);
        String y10 = y(feedDetailCommentViewModel.getCommentModel().getLikeCount(), i10, true);
        ((TextView) this.itemView.findViewById(i11)).setText(y10);
        if (z10) {
            feedDetailCommentViewModel.getCommentModel().setLikeCount(y10);
            feedDetailCommentViewModel.getCommentModel().setLiked(Boolean.TRUE);
            Observable<Result<Object>> T = NetworkClient.f11868a.l().T(feedDetailCommentViewModel.getPostId(), feedDetailCommentViewModel.getCommentModel().getId());
            Object context = this.itemView.getContext();
            com.cupidapp.live.base.network.g gVar = context instanceof com.cupidapp.live.base.network.g ? (com.cupidapp.live.base.network.g) context : null;
            Disposable disposed = T.flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, p>() { // from class: com.cupidapp.live.feed.holder.FeedDetailCommentViewHolder$showLikeStyle$$inlined$handleByContext$default$1
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
                    EventBus.c().l(new FeedDetailCommentLikeSuccessEvent(FeedDetailCommentViewModel.this.getCommentModel()));
                }
            }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, gVar)));
            if (disposed != null) {
                s.h(disposed, "disposed");
                if (gVar != null) {
                    gVar.H(disposed);
                }
            }
            s.h(disposed, "disposed");
        }
    }

    public final void C(FeedDetailCommentViewModel feedDetailCommentViewModel, int i10, boolean z10) {
        View view = this.itemView;
        int i11 = R$id.detailLikeTextView;
        TextView textView = (TextView) view.findViewById(i11);
        s.h(textView, "itemView.detailLikeTextView");
        u.e(textView, 0, 0, R$mipmap.icon_comment_like, 0, 11, null);
        String y10 = y(feedDetailCommentViewModel.getCommentModel().getLikeCount(), i10, false);
        ((TextView) this.itemView.findViewById(i11)).setText(y10);
        if (z10) {
            feedDetailCommentViewModel.getCommentModel().setLikeCount(y10);
            feedDetailCommentViewModel.getCommentModel().setLiked(Boolean.FALSE);
            Observable<Result<Object>> h10 = NetworkClient.f11868a.l().h(feedDetailCommentViewModel.getPostId(), feedDetailCommentViewModel.getCommentModel().getId());
            Object context = this.itemView.getContext();
            com.cupidapp.live.base.network.g gVar = context instanceof com.cupidapp.live.base.network.g ? (com.cupidapp.live.base.network.g) context : null;
            Disposable disposed = h10.flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, p>() { // from class: com.cupidapp.live.feed.holder.FeedDetailCommentViewHolder$showNotLikeStyle$$inlined$handleByContext$default$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(Object obj) {
                    invoke2(obj);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object obj) {
                }
            }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, gVar)));
            if (disposed != null) {
                s.h(disposed, "disposed");
                if (gVar != null) {
                    gVar.H(disposed);
                }
            }
            s.h(disposed, "disposed");
        }
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable final Object obj) {
        if (obj instanceof FeedDetailCommentViewModel) {
            View view = this.itemView;
            int i10 = R$id.detailUserAvatarImageView;
            ((ImageLoaderView) view.findViewById(i10)).setVisibility(0);
            FeedDetailCommentViewModel feedDetailCommentViewModel = (FeedDetailCommentViewModel) obj;
            User user = feedDetailCommentViewModel.getCommentModel().getUser();
            UserIconViewLayout userIconViewLayout = (UserIconViewLayout) this.itemView.findViewById(R$id.detailVipImg);
            s.h(userIconViewLayout, "itemView.detailVipImg");
            UserIconViewLayout.d(userIconViewLayout, user.getUserVipModel(), SensorPosition.Unknown, UserIconViewLayout.VipIconPositionRef.Other, false, 8, null);
            ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(i10);
            s.h(imageLoaderView, "itemView.detailUserAvatarImageView");
            ImageLoaderView.g(imageLoaderView, feedDetailCommentViewModel.getCommentModel().getUser().getAvatarImage(), null, null, 6, null);
            ((TextView) this.itemView.findViewById(R$id.detailUserNameTextView)).setText(feedDetailCommentViewModel.getCommentModel().getUser().getName());
            Boolean author = feedDetailCommentViewModel.getCommentModel().getAuthor();
            Boolean bool = Boolean.TRUE;
            if (s.d(author, bool)) {
                ((ImageView) this.itemView.findViewById(R$id.detailAuthorImg)).setVisibility(0);
            } else {
                ((ImageView) this.itemView.findViewById(R$id.detailAuthorImg)).setVisibility(8);
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(v.n(feedDetailCommentViewModel.getCommentModel().getCreateTimeMillis(), this.itemView.getContext()));
            String publishIpCityName = feedDetailCommentViewModel.getCommentModel().getPublishIpCityName();
            if (!(publishIpCityName == null || publishIpCityName.length() == 0)) {
                sb2.append(" · " + feedDetailCommentViewModel.getCommentModel().getPublishIpCityName());
            }
            ((TextView) this.itemView.findViewById(R$id.detailTimeTextView)).setText(sb2);
            t(feedDetailCommentViewModel.getCommentModel());
            if (s.d(feedDetailCommentViewModel.getCommentModel().getDelete(), bool)) {
                ((TextView) this.itemView.findViewById(R$id.detailLikeTextView)).setVisibility(4);
            } else {
                ((TextView) this.itemView.findViewById(R$id.detailLikeTextView)).setVisibility(0);
                if (s.d(feedDetailCommentViewModel.getCommentModel().getLiked(), bool)) {
                    B(this, feedDetailCommentViewModel, 0, false, 4, null);
                } else {
                    D(this, feedDetailCommentViewModel, 0, false, 4, null);
                }
                RelativeLayout relativeLayout = (RelativeLayout) this.itemView.findViewById(R$id.detailLikeLl);
                s.h(relativeLayout, "itemView.detailLikeLl");
                y.d(relativeLayout, new Function1<View, p>() { // from class: com.cupidapp.live.feed.holder.FeedDetailCommentViewHolder$config$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(View view2) {
                        invoke2(view2);
                        return p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable View view2) {
                        if (s.d(((FeedDetailCommentViewModel) Object.this).getCommentModel().getLiked(), Boolean.TRUE)) {
                            this.C((FeedDetailCommentViewModel) Object.this, 1, true);
                        } else {
                            this.A((FeedDetailCommentViewModel) Object.this, 1, true);
                        }
                    }
                });
            }
            v(feedDetailCommentViewModel.getCommentModel());
            u(feedDetailCommentViewModel.getCommentModel());
        }
    }

    public final void t(PostCommentModel postCommentModel) {
        CharSequence c4;
        if (s.d(postCommentModel.getDelete(), Boolean.TRUE)) {
            View view = this.itemView;
            int i10 = R$id.alreadyDeleteCommentTextView;
            ((TextView) view.findViewById(i10)).setText(com.cupidapp.live.feed.helper.a.b(com.cupidapp.live.feed.helper.a.f14304a, postCommentModel.getReplaceAtList(), postCommentModel.getComment(), 0, new Function1<String, p>() { // from class: com.cupidapp.live.feed.holder.FeedDetailCommentViewHolder$configCommentText$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(String str) {
                    invoke2(str);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull String it) {
                    s.i(it, "it");
                    EventBus.c().l(new OpenProfileEvent(it));
                }
            }, 4, null));
            ((TextView) this.itemView.findViewById(i10)).setMovementMethod(LinkMovementMethod.getInstance());
            ((TextView) this.itemView.findViewById(i10)).setVisibility(0);
            ((TextView) this.itemView.findViewById(R$id.reply_txt)).setVisibility(8);
            ((TextView) this.itemView.findViewById(R$id.detailCommentTextView)).setVisibility(8);
            return;
        }
        View view2 = this.itemView;
        int i11 = R$id.reply_txt;
        ((TextView) view2.findViewById(i11)).getPaint().setFakeBoldText(true);
        ((TextView) this.itemView.findViewById(i11)).setVisibility(0);
        ((TextView) this.itemView.findViewById(R$id.alreadyDeleteCommentTextView)).setVisibility(8);
        View view3 = this.itemView;
        int i12 = R$id.detailCommentTextView;
        ((TextView) view3.findViewById(i12)).setVisibility(0);
        User replyUser = postCommentModel.getReplyUser();
        String name = replyUser != null ? replyUser.getName() : null;
        User replyUser2 = postCommentModel.getReplyUser();
        if (!s.d(replyUser2 != null ? replyUser2.userId() : null, postCommentModel.getParentCommentUserId()) && name != null) {
            String string = this.itemView.getContext().getString(R$string.comment_in_reply, name, postCommentModel.getComment());
            s.h(string, "itemView.context.getStri…yUserName, model.comment)");
            c4 = q1.d.f53006a.c(string, kotlin.collections.s.o(name), (r18 & 4) != 0 ? null : -8618884, (r18 & 8) != 0 ? null : null, (r18 & 16) != 0 ? false : false, (r18 & 32) != 0 ? null : kotlin.collections.s.o(new b(postCommentModel)), (r18 & 64) != 0 ? null : null);
            ((TextView) this.itemView.findViewById(i12)).setText(com.cupidapp.live.feed.helper.a.b(com.cupidapp.live.feed.helper.a.f14304a, postCommentModel.getReplaceAtList(), c4 != null ? c4 : string, 0, new Function1<String, p>() { // from class: com.cupidapp.live.feed.holder.FeedDetailCommentViewHolder$configCommentText$3
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(String str) {
                    invoke2(str);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull String it) {
                    s.i(it, "it");
                    EventBus.c().l(new OpenProfileEvent(it));
                }
            }, 4, null));
            ((TextView) this.itemView.findViewById(i12)).setMovementMethod(LinkMovementMethod.getInstance());
            return;
        }
        ((TextView) this.itemView.findViewById(i12)).setText(com.cupidapp.live.feed.helper.a.b(com.cupidapp.live.feed.helper.a.f14304a, postCommentModel.getReplaceAtList(), postCommentModel.getComment(), 0, new Function1<String, p>() { // from class: com.cupidapp.live.feed.holder.FeedDetailCommentViewHolder$configCommentText$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(String str) {
                invoke2(str);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String it) {
                s.i(it, "it");
                EventBus.c().l(new OpenProfileEvent(it));
            }
        }, 4, null));
        ((TextView) this.itemView.findViewById(i12)).setMovementMethod(LinkMovementMethod.getInstance());
    }

    public final void u(@NotNull PostCommentModel model) {
        s.i(model, "model");
        if (z(model)) {
            this.itemView.findViewById(R$id.detailCommentDivider).setVisibility(0);
        } else {
            this.itemView.findViewById(R$id.detailCommentDivider).setVisibility(4);
        }
    }

    public final void v(PostCommentModel postCommentModel) {
        boolean d10 = s.d(postCommentModel.getParent(), Boolean.TRUE);
        x(d10);
        w(d10);
    }

    public final void w(boolean z10) {
        int c4;
        int c10;
        int i10;
        View view = this.itemView;
        int i11 = R$id.detailUserAvatarImageView;
        ViewGroup.LayoutParams layoutParams = ((ImageLoaderView) view.findViewById(i11)).getLayoutParams();
        s.g(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        if (z10) {
            c4 = z0.h.c(this, 12.0f);
            c10 = z0.h.c(this, 36.0f);
            i10 = c4;
        } else {
            c4 = z0.h.c(this, 62.0f);
            c10 = z0.h.c(this, 24.0f);
            i10 = 0;
        }
        layoutParams2.setMargins(c4, i10, 0, 0);
        layoutParams2.width = c10;
        layoutParams2.height = c10;
        ((ImageLoaderView) this.itemView.findViewById(i11)).setLayoutParams(layoutParams2);
    }

    public final void x(boolean z10) {
        int c4;
        View view = this.itemView;
        int i10 = R$id.detailUserNameTextView;
        ViewGroup.LayoutParams layoutParams = ((TextView) view.findViewById(i10)).getLayoutParams();
        s.g(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        if (z10) {
            c4 = z0.h.c(this, 15.0f);
        } else {
            c4 = z0.h.c(this, 10.0f);
        }
        layoutParams2.setMargins(c4, 0, 0, 0);
        ((TextView) this.itemView.findViewById(i10)).setLayoutParams(layoutParams2);
    }

    public final String y(String str, int i10, boolean z10) {
        String str2;
        if (!(str == null || str.length() == 0)) {
            str2 = (StringsKt__StringsKt.I(str, IAdInterListener.AdReqParam.WIDTH, true) || StringsKt__StringsKt.I(str, "k", true)) ? "0" : str;
            return str;
        }
        try {
            int parseInt = Integer.parseInt(str2);
            if (z10) {
                return String.valueOf(parseInt + i10);
            }
            return parseInt > i10 ? String.valueOf(parseInt - i10) : "";
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
        }
    }

    public final boolean z(PostCommentModel postCommentModel) {
        int i10;
        Iterator<Object> iterator2 = this.f14378c.iterator2();
        int i11 = 0;
        while (true) {
            if (!iterator2.hasNext()) {
                i11 = -1;
                break;
            }
            Object next = iterator2.next();
            if (next instanceof FeedDetailCommentViewModel ? s.d(((FeedDetailCommentViewModel) next).getCommentModel().getId(), postCommentModel.getId()) : false) {
                break;
            }
            i11++;
        }
        if (i11 < 0 || (i10 = i11 + 1) >= this.f14378c.size()) {
            return false;
        }
        Object obj = this.f14378c.get(i10);
        if (obj instanceof FeedDetailCommentViewModel) {
            return s.d(((FeedDetailCommentViewModel) obj).getCommentModel().getParent(), Boolean.TRUE);
        }
        return !(obj instanceof FeedDetailShowMoreCommentViewModel);
    }
}
