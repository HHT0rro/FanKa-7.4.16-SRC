package com.cupidapp.live.notify.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.android.internal.logging.nano.MetricsProto;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.fragment.EditInputBottomSheetDialog;
import com.cupidapp.live.base.fragment.FKBaseFragment;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.RequestErrorCode;
import com.cupidapp.live.base.network.model.ProfileResult;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.network.model.ViewProfilePrefer;
import com.cupidapp.live.base.recyclerview.FKLoadMoreListener;
import com.cupidapp.live.base.recyclerview.helper.ExposureScene;
import com.cupidapp.live.base.recyclerview.helper.RecyclerExposureHelper;
import com.cupidapp.live.base.recyclerview.model.FKEmptyViewModel;
import com.cupidapp.live.base.recyclerview.model.FKFooterViewModel;
import com.cupidapp.live.base.sensorslog.FKSensorContext;
import com.cupidapp.live.base.sensorslog.FeedSensorContext;
import com.cupidapp.live.base.sensorslog.PopupName;
import com.cupidapp.live.base.sensorslog.ProfileSensorContext;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.base.view.FKSwipeRefreshLayout;
import com.cupidapp.live.feed.activity.FeedDetailActivity;
import com.cupidapp.live.feed.helper.UserActionType;
import com.cupidapp.live.feed.layout.FeedDetailClickCommentItemTagModel;
import com.cupidapp.live.feed.layout.FeedDetailEditTextLayout;
import com.cupidapp.live.feed.model.FeedModel;
import com.cupidapp.live.liveshow.beauty.databeauty.UserData;
import com.cupidapp.live.mentionuser.atuser.AtUserActivity;
import com.cupidapp.live.notify.adapter.PostNotifyAdapter;
import com.cupidapp.live.notify.model.NotifyFriendPraiseModel;
import com.cupidapp.live.notify.model.NotifyListResult;
import com.cupidapp.live.notify.model.NotifyType;
import com.cupidapp.live.notify.model.PostNotifyModel;
import com.cupidapp.live.profile.activity.CloseFriendManagerActivity;
import com.cupidapp.live.profile.activity.FriendPraiseActivity;
import com.cupidapp.live.profile.activity.UserProfileActivity;
import com.cupidapp.live.profile.model.FriendPraiseBundleData;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.profile.view.UserAlertDialogHelper;
import com.cupidapp.live.track.group.EnterWayType;
import com.cupidapp.live.track.group.GroupSocialLog;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.i0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x2.a;
import z0.t;

/* compiled from: BaseNotifyFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class BaseNotifyFragment extends FKBaseFragment {

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public String f17522f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public String f17523g;

    /* renamed from: i, reason: collision with root package name */
    public int f17525i;

    /* renamed from: j, reason: collision with root package name */
    public int f17526j;

    /* renamed from: k, reason: collision with root package name */
    @Nullable
    public EditInputBottomSheetDialog f17527k;

    /* renamed from: l, reason: collision with root package name */
    @Nullable
    public FeedDetailEditTextLayout f17528l;

    /* renamed from: n, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17530n = new LinkedHashMap();

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public final Lazy f17521e = kotlin.c.b(new Function0<PostNotifyAdapter>() { // from class: com.cupidapp.live.notify.fragment.BaseNotifyFragment$postNotifyAdapter$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final PostNotifyAdapter invoke() {
            PostNotifyAdapter D1;
            D1 = BaseNotifyFragment.this.D1();
            return D1;
        }
    });

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public final Lazy f17524h = kotlin.c.b(new Function0<FKLoadMoreListener>() { // from class: com.cupidapp.live.notify.fragment.BaseNotifyFragment$loadMoreListener$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final FKLoadMoreListener invoke() {
            final BaseNotifyFragment baseNotifyFragment = BaseNotifyFragment.this;
            return new FKLoadMoreListener(new Function0<p>() { // from class: com.cupidapp.live.notify.fragment.BaseNotifyFragment$loadMoreListener$2.1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ p invoke() {
                    invoke2();
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    String str;
                    String str2;
                    str = BaseNotifyFragment.this.f17522f;
                    if (str == null || str.length() == 0) {
                        return;
                    }
                    BaseNotifyFragment baseNotifyFragment2 = BaseNotifyFragment.this;
                    str2 = baseNotifyFragment2.f17522f;
                    baseNotifyFragment2.w1(str2);
                }
            });
        }
    });

    /* renamed from: m, reason: collision with root package name */
    public final int f17529m = MetricsProto.MetricsEvent.PROVISIONING_TRAMPOLINE_ACTIVITY_TIME_MS;

    /* compiled from: BaseNotifyFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f17531a;

        static {
            int[] iArr = new int[NotifyType.values().length];
            try {
                iArr[NotifyType.PostComment.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[NotifyType.PostCommentReplyOnMyPost.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[NotifyType.PostCommentReplyOnOthersPost.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[NotifyType.PostTag.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[NotifyType.PostAt.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[NotifyType.PostCommentAt.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[NotifyType.PostLike.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[NotifyType.PostCommentLike.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[NotifyType.NewCloseFriend.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[NotifyType.PraiseLike.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[NotifyType.NewPraise.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[NotifyType.Announce.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            f17531a = iArr;
        }
    }

    public static final void F1(BaseNotifyFragment this$0) {
        s.i(this$0, "this$0");
        this$0.f17525i = this$0.v1();
        x1(this$0, null, 1, null);
    }

    public static final void p1(BaseNotifyFragment this$0, DialogInterface dialogInterface) {
        s.i(this$0, "this$0");
        FeedDetailEditTextLayout feedDetailEditTextLayout = this$0.f17528l;
        if (feedDetailEditTextLayout != null) {
            feedDetailEditTextLayout.s();
        }
    }

    public static /* synthetic */ void x1(BaseNotifyFragment baseNotifyFragment, String str, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getNotifyList");
        }
        if ((i10 & 1) != 0) {
            str = null;
        }
        baseNotifyFragment.w1(str);
    }

    public final SensorPosition A1(PostNotifyModel postNotifyModel) {
        switch (a.f17531a[postNotifyModel.getType().ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 9:
            case 11:
            case 12:
                return SensorPosition.NotifyMention;
            case 7:
            case 8:
            case 10:
                return SensorPosition.NotifyGetLike;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final SensorScene B1(PostNotifyModel postNotifyModel) {
        switch (a.f17531a[postNotifyModel.getType().ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 9:
            case 11:
            case 12:
                return SensorScene.NotificationComment;
            case 7:
            case 8:
            case 10:
                return SensorScene.NotificationLike;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final void C1(PostNotifyModel postNotifyModel, UserActionType userActionType) {
        String postId;
        FeedModel post = postNotifyModel.getPost();
        if (post == null || (postId = post.getPostId()) == null) {
            return;
        }
        com.cupidapp.live.feed.helper.h.f14329a.e(postId, postNotifyModel.getPost().getTagId(), userActionType, A1(postNotifyModel), SensorPosition.Notify, (r18 & 32) != 0 ? null : null, (r18 & 64) != 0 ? null : postNotifyModel.getPost().getPostStatisticsCallback());
    }

    public final PostNotifyAdapter D1() {
        final PostNotifyAdapter postNotifyAdapter = new PostNotifyAdapter(new Function2<String, PostNotifyModel, p>() { // from class: com.cupidapp.live.notify.fragment.BaseNotifyFragment$initAdapter$1
            {
                super(2);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String userId, @NotNull PostNotifyModel model) {
                s.i(userId, "userId");
                s.i(model, "model");
                BaseNotifyFragment.this.N1(userId, model);
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: invoke */
            public /* bridge */ /* synthetic */ p mo1743invoke(String str, PostNotifyModel postNotifyModel) {
                invoke2(str, postNotifyModel);
                return p.f51048a;
            }
        });
        postNotifyAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.notify.fragment.BaseNotifyFragment$initAdapter$2$1
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
            public final void invoke2(@Nullable Object obj) {
                if (obj instanceof PostNotifyModel) {
                    BaseNotifyFragment.this.G1((PostNotifyModel) obj, postNotifyAdapter.j().indexOf(obj));
                }
            }
        });
        postNotifyAdapter.l().k(i0.h(kotlin.f.a(Integer.valueOf(R$id.notifyUserAvatarImageView), new Function2<Object, Integer, p>() { // from class: com.cupidapp.live.notify.fragment.BaseNotifyFragment$initAdapter$2$2

            /* compiled from: BaseNotifyFragment.kt */
            @kotlin.d
            /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
            public /* synthetic */ class a {

                /* renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f17532a;

                static {
                    int[] iArr = new int[NotifyType.values().length];
                    try {
                        iArr[NotifyType.NewPraise.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    f17532a = iArr;
                }
            }

            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: invoke */
            public /* bridge */ /* synthetic */ p mo1743invoke(Object obj, Integer num) {
                invoke(obj, num.intValue());
                return p.f51048a;
            }

            public final void invoke(@Nullable Object obj, int i10) {
                SensorScene B1;
                String str;
                if (obj instanceof PostNotifyModel) {
                    PostNotifyModel postNotifyModel = (PostNotifyModel) obj;
                    if (a.f17532a[postNotifyModel.getType().ordinal()] == 1) {
                        BaseNotifyFragment.this.L1();
                        return;
                    }
                    GroupSocialLog groupSocialLog = GroupSocialLog.f18708a;
                    B1 = BaseNotifyFragment.this.B1(postNotifyModel);
                    String value = B1.getValue();
                    User fromUser = postNotifyModel.getFromUser();
                    if (fromUser == null || (str = fromUser.userId()) == null) {
                        str = "";
                    }
                    groupSocialLog.u(value, str, (r13 & 4) != 0 ? null : null, (r13 & 8) != 0 ? false : false, (r13 & 16) != 0 ? null : null);
                    BaseNotifyFragment.this.M1(postNotifyModel, i10);
                }
            }
        }), kotlin.f.a(Integer.valueOf(R$id.notifyPostImageView), new Function2<Object, Integer, p>() { // from class: com.cupidapp.live.notify.fragment.BaseNotifyFragment$initAdapter$2$3

            /* compiled from: BaseNotifyFragment.kt */
            @kotlin.d
            /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
            public /* synthetic */ class a {

                /* renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f17533a;

                static {
                    int[] iArr = new int[NotifyType.values().length];
                    try {
                        iArr[NotifyType.NewPraise.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[NotifyType.PraiseLike.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[NotifyType.NewCloseFriend.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    f17533a = iArr;
                }
            }

            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: invoke */
            public /* bridge */ /* synthetic */ p mo1743invoke(Object obj, Integer num) {
                invoke(obj, num.intValue());
                return p.f51048a;
            }

            public final void invoke(@Nullable Object obj, int i10) {
                if (obj instanceof PostNotifyModel) {
                    PostNotifyModel postNotifyModel = (PostNotifyModel) obj;
                    int i11 = a.f17533a[postNotifyModel.getType().ordinal()];
                    if (i11 == 1 || i11 == 2) {
                        BaseNotifyFragment.this.L1();
                    } else if (i11 != 3) {
                        BaseNotifyFragment.this.K1(postNotifyModel, i10);
                    } else {
                        BaseNotifyFragment.this.J1();
                    }
                }
            }
        }), kotlin.f.a(Integer.valueOf(R$id.notifyReplyLayout), new Function2<Object, Integer, p>() { // from class: com.cupidapp.live.notify.fragment.BaseNotifyFragment$initAdapter$2$4
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: invoke */
            public /* bridge */ /* synthetic */ p mo1743invoke(Object obj, Integer num) {
                invoke(obj, num.intValue());
                return p.f51048a;
            }

            public final void invoke(@Nullable Object obj, int i10) {
                if (obj instanceof PostNotifyModel) {
                    Context context = BaseNotifyFragment.this.getContext();
                    if (context != null) {
                        BaseNotifyFragment.this.o1(context, (PostNotifyModel) obj, i10);
                    }
                    BaseNotifyFragment.this.C1((PostNotifyModel) obj, UserActionType.Comment);
                }
            }
        }), kotlin.f.a(Integer.valueOf(R$id.set_close_friend_txt), new Function2<Object, Integer, p>() { // from class: com.cupidapp.live.notify.fragment.BaseNotifyFragment$initAdapter$2$5
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: invoke */
            public /* bridge */ /* synthetic */ p mo1743invoke(Object obj, Integer num) {
                invoke(obj, num.intValue());
                return p.f51048a;
            }

            public final void invoke(@Nullable Object obj, int i10) {
                User fromUser;
                if (!(obj instanceof PostNotifyModel) || (fromUser = ((PostNotifyModel) obj).getFromUser()) == null) {
                    return;
                }
                BaseNotifyFragment.this.q1(fromUser);
            }
        }), kotlin.f.a(Integer.valueOf(R$id.friend_praise_show_in_profile_btn), new Function2<Object, Integer, p>() { // from class: com.cupidapp.live.notify.fragment.BaseNotifyFragment$initAdapter$2$6
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: invoke */
            public /* bridge */ /* synthetic */ p mo1743invoke(Object obj, Integer num) {
                invoke(obj, num.intValue());
                return p.f51048a;
            }

            public final void invoke(@Nullable Object obj, int i10) {
                if (obj instanceof PostNotifyModel) {
                    BaseNotifyFragment.this.s1((PostNotifyModel) obj);
                }
            }
        })));
        ExposureScene H1 = H1();
        RecyclerView baseNotifyRecyclerView = (RecyclerView) U0(R$id.baseNotifyRecyclerView);
        s.h(baseNotifyRecyclerView, "baseNotifyRecyclerView");
        postNotifyAdapter.t(new RecyclerExposureHelper(H1, baseNotifyRecyclerView, 0.0f, 0L, null, new Function1<List<? extends h1.a>, p>() { // from class: com.cupidapp.live.notify.fragment.BaseNotifyFragment$initAdapter$2$7
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(List<? extends h1.a> list) {
                invoke2((List<h1.a>) list);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull List<h1.a> itemList) {
                SensorScene I1;
                String travelCity;
                s.i(itemList, "itemList");
                BaseNotifyFragment baseNotifyFragment = BaseNotifyFragment.this;
                Iterator<h1.a> iterator2 = itemList.iterator2();
                while (iterator2.hasNext()) {
                    Object a10 = iterator2.next().a();
                    if (a10 instanceof PostNotifyModel) {
                        I1 = baseNotifyFragment.I1();
                        GroupSocialLog groupSocialLog = GroupSocialLog.f18708a;
                        String value = I1.getValue();
                        PostNotifyModel postNotifyModel = (PostNotifyModel) a10;
                        User fromUser = postNotifyModel.getFromUser();
                        String userId = fromUser != null ? fromUser.userId() : null;
                        User fromUser2 = postNotifyModel.getFromUser();
                        boolean z10 = false;
                        if (fromUser2 != null && (travelCity = fromUser2.getTravelCity()) != null) {
                            if (travelCity.length() > 0) {
                                z10 = true;
                            }
                        }
                        groupSocialLog.w(value, userId, (r29 & 4) != 0 ? null : null, (r29 & 8) != 0 ? false : false, (r29 & 16) != 0 ? null : null, (r29 & 32) != 0 ? 0 : 0, (r29 & 64) != 0 ? null : null, (r29 & 128) != 0 ? null : null, (r29 & 256) != 0 ? false : false, (r29 & 512) != 0 ? false : false, (r29 & 1024) != 0 ? false : false, (r29 & 2048) != 0 ? false : z10);
                    }
                }
            }
        }, 28, null));
        return postNotifyAdapter;
    }

    public final void E1() {
        RecyclerView recyclerView = (RecyclerView) U0(R$id.baseNotifyRecyclerView);
        recyclerView.setItemAnimator(null);
        recyclerView.setAdapter(z1());
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.addOnScrollListener(u1());
        ((FKSwipeRefreshLayout) U0(R$id.baseNotifyRefreshLayout)).setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.cupidapp.live.notify.fragment.j
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                BaseNotifyFragment.F1(BaseNotifyFragment.this);
            }
        });
    }

    public final void G1(PostNotifyModel postNotifyModel, int i10) {
        switch (a.f17531a[postNotifyModel.getType().ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                K1(postNotifyModel, i10);
                return;
            case 7:
            case 8:
            case 9:
                M1(postNotifyModel, i10);
                return;
            case 10:
            case 11:
                L1();
                return;
            default:
                return;
        }
    }

    public final ExposureScene H1() {
        return this instanceof PostLikeNotifyFragment ? ExposureScene.NotificationLike : ExposureScene.NotificationComment;
    }

    public final SensorScene I1() {
        return this instanceof PostLikeNotifyFragment ? SensorScene.NotificationLike : SensorScene.NotificationComment;
    }

    public final void J1() {
        CloseFriendManagerActivity.f17591r.a(getContext(), new FKSensorContext(SensorPosition.NotifyMention, SensorPosition.Unknown, null, SensorScene.NotificationComment));
    }

    public final void K1(PostNotifyModel postNotifyModel, int i10) {
        postNotifyModel.setUnread(false);
        z1().notifyItemChanged(i10);
        FeedModel post = postNotifyModel.getPost();
        if (post != null) {
            FeedDetailActivity.Q.a(getContext(), post, false, new FeedSensorContext(SensorPosition.FeedDetail, A1(postNotifyModel), SensorPosition.Unknown, B1(postNotifyModel)), (r25 & 16) != 0 ? false : false, (r25 & 32) != 0 ? false : false, (r25 & 64) != 0 ? null : null, (r25 & 128) != 0 ? null : null, (r25 & 256) != 0 ? null : null, (r25 & 512) != 0 ? null : null);
        }
    }

    public final void L1() {
        FriendPraiseActivity.A.a(getContext(), new FriendPraiseBundleData(O0()));
    }

    public final void M1(PostNotifyModel postNotifyModel, int i10) {
        postNotifyModel.setUnread(false);
        z1().notifyItemChanged(i10);
        User fromUser = postNotifyModel.getFromUser();
        if (fromUser != null) {
            O1(postNotifyModel, fromUser);
        }
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    public void N0() {
        this.f17530n.clear();
    }

    public final void N1(String str, final PostNotifyModel postNotifyModel) {
        Observable z10 = a.C0836a.z(NetworkClient.f11868a.N(), str, null, null, false, null, 30, null);
        Object context = getContext();
        com.cupidapp.live.base.network.g gVar = context instanceof com.cupidapp.live.base.network.g ? (com.cupidapp.live.base.network.g) context : null;
        Disposable disposed = z10.flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<ProfileResult, p>() { // from class: com.cupidapp.live.notify.fragment.BaseNotifyFragment$openProfile$$inlined$handleByContext$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(ProfileResult profileResult) {
                m2746invoke(profileResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2746invoke(ProfileResult profileResult) {
                BaseNotifyFragment.this.O1(postNotifyModel, profileResult.getUser());
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

    public final void O1(PostNotifyModel postNotifyModel, User user) {
        UserProfileActivity.G.a(getContext(), user, new ProfileSensorContext((postNotifyModel.getType() == NotifyType.PostLike ? ViewProfilePrefer.NotifyPostLikeToProfile : ViewProfilePrefer.NotifyMentionToProfile).getValue(), null, user.getMe(), A1(postNotifyModel), A1(postNotifyModel), B1(postNotifyModel)), (r21 & 8) != 0 ? false : false, (r21 & 16) != 0 ? null : null, (r21 & 32) != 0 ? null : null, (r21 & 64) != 0 ? null : null, (r21 & 128) != 0 ? false : false);
    }

    public final void P1(@Nullable String str) {
        this.f17523g = str;
    }

    @Nullable
    public View U0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f17530n;
        View view = map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null || (findViewById = view2.findViewById(i10)) == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    public abstract void n1();

    public final void o1(Context context, final PostNotifyModel postNotifyModel, int i10) {
        if (postNotifyModel.getComment() == null) {
            return;
        }
        postNotifyModel.setUnread(false);
        z1().notifyItemChanged(i10);
        FeedSensorContext feedSensorContext = new FeedSensorContext(SensorPosition.NotifyMention, SensorPosition.Notify, null, SensorScene.NotificationComment);
        if (this.f17527k == null) {
            FeedDetailEditTextLayout feedDetailEditTextLayout = new FeedDetailEditTextLayout(context);
            FeedDetailEditTextLayout.setFeedModelAndCallback$default(feedDetailEditTextLayout, postNotifyModel.getPost(), feedSensorContext, null, null, null, new Function1<Boolean, p>() { // from class: com.cupidapp.live.notify.fragment.BaseNotifyFragment$clickReplyComment$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return p.f51048a;
                }

                public final void invoke(boolean z10) {
                    int i11;
                    SensorPosition A1;
                    AtUserActivity.a aVar = AtUserActivity.f17473u;
                    BaseNotifyFragment baseNotifyFragment = BaseNotifyFragment.this;
                    i11 = baseNotifyFragment.f17529m;
                    aVar.b(baseNotifyFragment, i11, z10);
                    GroupSocialLog groupSocialLog = GroupSocialLog.f18708a;
                    A1 = BaseNotifyFragment.this.A1(postNotifyModel);
                    groupSocialLog.Q(A1, z10 ? EnterWayType.WRITE : EnterWayType.CLICK);
                }
            }, 28, null);
            this.f17528l = feedDetailEditTextLayout;
            EditInputBottomSheetDialog editInputBottomSheetDialog = new EditInputBottomSheetDialog(context, false, 2, null);
            this.f17527k = editInputBottomSheetDialog;
            FeedDetailEditTextLayout feedDetailEditTextLayout2 = this.f17528l;
            s.f(feedDetailEditTextLayout2);
            editInputBottomSheetDialog.setContentView(feedDetailEditTextLayout2);
        }
        FeedDetailEditTextLayout feedDetailEditTextLayout3 = this.f17528l;
        if (feedDetailEditTextLayout3 != null) {
            feedDetailEditTextLayout3.q(new FeedDetailClickCommentItemTagModel(i10, postNotifyModel.getComment()));
        }
        EditInputBottomSheetDialog editInputBottomSheetDialog2 = this.f17527k;
        if (editInputBottomSheetDialog2 != null) {
            editInputBottomSheetDialog2.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.cupidapp.live.notify.fragment.i
                @Override // android.content.DialogInterface.OnShowListener
                public final void onShow(DialogInterface dialogInterface) {
                    BaseNotifyFragment.p1(BaseNotifyFragment.this, dialogInterface);
                }
            });
        }
        EditInputBottomSheetDialog editInputBottomSheetDialog3 = this.f17527k;
        if (editInputBottomSheetDialog3 != null) {
            editInputBottomSheetDialog3.show();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i10, int i11, @Nullable Intent intent) {
        Bundle extras;
        Bundle extras2;
        super.onActivityResult(i10, i11, intent);
        if (i11 == -1 && i10 == this.f17529m) {
            Serializable serializable = (intent == null || (extras2 = intent.getExtras()) == null) ? null : extras2.getSerializable(UserData.NAME);
            User user = serializable instanceof User ? (User) serializable : null;
            boolean z10 = (intent == null || (extras = intent.getExtras()) == null) ? false : extras.getBoolean("hasInsertAtSymbol");
            FeedDetailEditTextLayout feedDetailEditTextLayout = this.f17528l;
            if (feedDetailEditTextLayout != null) {
                feedDetailEditTextLayout.o(user != null ? user.userId() : null, user != null ? user.getName() : null, z10);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        s.i(inflater, "inflater");
        return inflater.inflate(R$layout.fragment_base_notify, viewGroup, false);
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        N0();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        RecyclerView.LayoutManager layoutManager = ((RecyclerView) U0(R$id.baseNotifyRecyclerView)).getLayoutManager();
        LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
        int findFirstVisibleItemPosition = linearLayoutManager != null ? linearLayoutManager.findFirstVisibleItemPosition() : 0;
        int v12 = v1();
        if (z1().n() <= 0 || (findFirstVisibleItemPosition <= 1 && v12 > 0)) {
            x1(this, null, 1, null);
        }
        this.f17525i = v12;
        RecyclerExposureHelper g3 = z1().g();
        if (g3 != null) {
            g3.i();
        }
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        s.i(view, "view");
        super.onViewCreated(view, bundle);
        E1();
    }

    public final void q1(final User user) {
        Observable<Result<Object>> O0 = NetworkClient.f11868a.N().O0(user.userId(), true);
        Object context = getContext();
        Function1<Throwable, Boolean> function1 = new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.notify.fragment.BaseNotifyFragment$closeFriend$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable error) {
                s.i(error, "error");
                String a10 = com.cupidapp.live.base.network.j.f12008a.a(error);
                Integer valueOf = a10 != null ? Integer.valueOf(t.q(a10)) : null;
                String message = error.getMessage();
                int value = RequestErrorCode.CloseFriendNoRemains.getValue();
                boolean z10 = true;
                if (valueOf != null && valueOf.intValue() == value) {
                    if (!(message == null || message.length() == 0)) {
                        Context context2 = BaseNotifyFragment.this.getContext();
                        if (context2 != null) {
                            final BaseNotifyFragment baseNotifyFragment = BaseNotifyFragment.this;
                            UserAlertDialogHelper.f17874a.a(context2, SensorPosition.NotifyMention, message, PopupName.CLOSE_FRIENDS_LIMIT, new Function0<p>() { // from class: com.cupidapp.live.notify.fragment.BaseNotifyFragment$closeFriend$2$1$1
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ p invoke() {
                                    invoke2();
                                    return p.f51048a;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    BaseNotifyFragment.this.J1();
                                }
                            });
                        }
                        return Boolean.valueOf(z10);
                    }
                }
                z10 = false;
                return Boolean.valueOf(z10);
            }
        };
        com.cupidapp.live.base.network.g gVar = context instanceof com.cupidapp.live.base.network.g ? (com.cupidapp.live.base.network.g) context : null;
        Disposable disposed = O0.flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, p>() { // from class: com.cupidapp.live.notify.fragment.BaseNotifyFragment$closeFriend$$inlined$handleByContext$1
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
                PostNotifyAdapter z1;
                PostNotifyAdapter z12;
                User fromUser;
                User.this.setCloseFriend(true);
                z1 = this.z1();
                for (Object obj2 : z1.j()) {
                    if (obj2 instanceof PostNotifyModel) {
                        PostNotifyModel postNotifyModel = (PostNotifyModel) obj2;
                        if (postNotifyModel.getType() == NotifyType.NewCloseFriend && (fromUser = postNotifyModel.getFromUser()) != null) {
                            fromUser.setCloseFriend(true);
                        }
                    }
                }
                z12 = this.z1();
                z12.notifyDataSetChanged();
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(function1, gVar)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            if (gVar != null) {
                gVar.H(disposed);
            }
        }
        s.h(disposed, "disposed");
    }

    public final void r1() {
        int i10 = this.f17525i;
        if (i10 <= 30 || this.f17526j > i10) {
            return;
        }
        int min = Math.min(kotlin.collections.s.l(z1().j()), this.f17525i);
        for (int i11 = this.f17526j; i11 < min; i11++) {
            Object obj = z1().j().get(i11);
            if (obj instanceof PostNotifyModel) {
                ((PostNotifyModel) obj).setUnread(true);
            }
        }
    }

    public final void s1(final PostNotifyModel postNotifyModel) {
        NotifyFriendPraiseModel praise = postNotifyModel.getPraise();
        String praiseId = praise != null ? praise.getPraiseId() : null;
        NotifyFriendPraiseModel praise2 = postNotifyModel.getPraise();
        if (praise2 != null ? s.d(praise2.getHomePageDisplay(), Boolean.TRUE) : false) {
            return;
        }
        if (praiseId == null || praiseId.length() == 0) {
            return;
        }
        Disposable disposed = NetworkClient.f11868a.N().I0(praiseId, true).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, p>() { // from class: com.cupidapp.live.notify.fragment.BaseNotifyFragment$friendPraiseShowInProfile$$inlined$handle$default$1
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
                PostNotifyAdapter z1;
                z1 = BaseNotifyFragment.this.z1();
                z1.w(postNotifyModel);
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    public final void t1(@Nullable String str, @NotNull NotifyListResult<PostNotifyModel> result) {
        String string;
        s.i(result, "result");
        this.f17522f = result.getNextCursorId();
        this.f17523g = result.getType();
        if (str == null) {
            z1().v(result.getCloseFriendDefaultImage());
            z1().j().clear();
            z1().d(new FKFooterViewModel(false, false, null, 0, 0, 0, 63, null));
        }
        List<PostNotifyModel> list = result.getList();
        boolean z10 = true;
        if (list == null || list.isEmpty()) {
            if (this instanceof PostLikeNotifyFragment) {
                string = getString(R$string.empty_post_like_notify);
            } else {
                string = this instanceof PostCommentNotifyFragment ? getString(R$string.empty_post_comment_notify) : "";
            }
            String str2 = string;
            s.h(str2, "when (this) {\n          … else -> \"\"\n            }");
            z1().d(new FKEmptyViewModel(null, null, str2, null, null, null, null, false, null, null, 1019, null));
        } else {
            z1().e(result.getList());
        }
        if (str != null) {
            r1();
        }
        String str3 = this.f17522f;
        if (str3 != null && str3.length() != 0) {
            z10 = false;
        }
        if (z10) {
            z1().s();
        }
        z1().notifyDataSetChanged();
        ((FKSwipeRefreshLayout) U0(R$id.baseNotifyRefreshLayout)).setRefreshing(false);
        u1().c(false);
        n1();
    }

    public final FKLoadMoreListener u1() {
        return (FKLoadMoreListener) this.f17524h.getValue();
    }

    public final int v1() {
        if (this instanceof PostLikeNotifyFragment) {
            return p1.g.f52734a.B0();
        }
        if (this instanceof PostCommentNotifyFragment) {
            return p1.g.f52734a.C0();
        }
        return 0;
    }

    public abstract void w1(@Nullable String str);

    @Nullable
    public final String y1() {
        return this.f17523g;
    }

    public final PostNotifyAdapter z1() {
        return (PostNotifyAdapter) this.f17521e.getValue();
    }
}
