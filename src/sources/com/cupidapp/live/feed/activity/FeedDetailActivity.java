package com.cupidapp.live.feed.activity;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.ConcatAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.internal.logging.nano.MetricsProto;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.fragment.EditInputBottomSheetDialog;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.RequestErrorCode;
import com.cupidapp.live.base.network.model.ConstantsResult;
import com.cupidapp.live.base.network.model.ConstantsUrlModel;
import com.cupidapp.live.base.network.model.FollowPrefer;
import com.cupidapp.live.base.network.model.ListResult;
import com.cupidapp.live.base.network.model.ProfileResult;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.network.model.ViewProfilePrefer;
import com.cupidapp.live.base.recyclerview.FKLoadMoreListener;
import com.cupidapp.live.base.recyclerview.helper.ExposureScene;
import com.cupidapp.live.base.recyclerview.helper.RecyclerExposureHelper;
import com.cupidapp.live.base.recyclerview.model.FKFooterViewModel;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.sensorslog.FeedSensorContext;
import com.cupidapp.live.base.sensorslog.PopupName;
import com.cupidapp.live.base.sensorslog.ProfileSensorContext;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.base.sensorslog.SensorsLogFeed;
import com.cupidapp.live.base.sensorslog.ShareBtnPos;
import com.cupidapp.live.base.share.fragment.ShareBottomFragment;
import com.cupidapp.live.base.share.fragment.ShareModel;
import com.cupidapp.live.base.share.helper.ShareBuilder;
import com.cupidapp.live.base.share.model.ShareBaseType;
import com.cupidapp.live.base.share.model.ShareItemHandledResult;
import com.cupidapp.live.base.share.model.ShareOperateType;
import com.cupidapp.live.base.share.model.SharePlatform;
import com.cupidapp.live.base.share.model.State;
import com.cupidapp.live.base.utils.n0;
import com.cupidapp.live.base.utils.o;
import com.cupidapp.live.base.view.CustomLayoutManager;
import com.cupidapp.live.base.view.ScrollTo;
import com.cupidapp.live.base.view.SnackbarModel;
import com.cupidapp.live.base.view.dialog.FKActionSheetDialog;
import com.cupidapp.live.base.view.dialog.FKActionSheetItemModel;
import com.cupidapp.live.base.view.dialog.FKAlertDialog;
import com.cupidapp.live.chat.model.SerializableContext;
import com.cupidapp.live.feed.FeedSort;
import com.cupidapp.live.feed.adapter.FeedDetailAdapter;
import com.cupidapp.live.feed.adapter.TrendFeedListAdapter;
import com.cupidapp.live.feed.fragment.FeedListItemClickOperate;
import com.cupidapp.live.feed.helper.FeedClickEventHelper;
import com.cupidapp.live.feed.helper.UserActionType;
import com.cupidapp.live.feed.holder.FeedDetailCommentLikeSuccessEvent;
import com.cupidapp.live.feed.holder.FeedDetailCommentTitleModel;
import com.cupidapp.live.feed.holder.FeedDetailCommentViewModel;
import com.cupidapp.live.feed.holder.FeedDetailNoCommentModel;
import com.cupidapp.live.feed.holder.FeedDetailOpenProfileEvent;
import com.cupidapp.live.feed.holder.FeedDetailPraiseListViewModel;
import com.cupidapp.live.feed.holder.FeedDetailShowMoreCommentViewModel;
import com.cupidapp.live.feed.holder.OpenProfileEvent;
import com.cupidapp.live.feed.holder.TrendFeedViewHolder;
import com.cupidapp.live.feed.layout.FeedDetailClickCommentItemTagModel;
import com.cupidapp.live.feed.layout.FeedDetailEditTextLayout;
import com.cupidapp.live.feed.layout.FeedDetailTitleBarLayout;
import com.cupidapp.live.feed.model.BottomGuideModel;
import com.cupidapp.live.feed.model.FeedLikeResult;
import com.cupidapp.live.feed.model.FeedModel;
import com.cupidapp.live.feed.model.FeedRcmdDivideUiModel;
import com.cupidapp.live.feed.model.PostCommentModel;
import com.cupidapp.live.liveshow.beauty.databeauty.UserData;
import com.cupidapp.live.mentionuser.atuser.AtUserActivity;
import com.cupidapp.live.profile.activity.CloseFriendManagerActivity;
import com.cupidapp.live.profile.activity.FocusUserManageActivity;
import com.cupidapp.live.profile.activity.PrivateFeedActivity;
import com.cupidapp.live.profile.activity.UserProfileActivity;
import com.cupidapp.live.profile.event.UserProfileDataChangeEvent;
import com.cupidapp.live.profile.model.FocusResultModel;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.profile.view.UserAlertDialogHelper;
import com.cupidapp.live.track.group.EnterWayType;
import com.cupidapp.live.track.group.GroupSocialLog;
import f2.a;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Function3;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.i0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x2.a;

/* compiled from: FeedDetailActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FeedDetailActivity extends FKBaseActivity implements com.cupidapp.live.feed.holder.b, com.cupidapp.live.feed.fragment.i {

    @NotNull
    public static final a Q = new a(null);

    @Nullable
    public com.cupidapp.live.feed.helper.j A;

    @Nullable
    public com.cupidapp.live.base.view.o B;

    @Nullable
    public Disposable C;
    public int D;

    @Nullable
    public com.cupidapp.live.base.utils.o F;

    @Nullable
    public EditInputBottomSheetDialog G;

    @Nullable
    public FeedDetailEditTextLayout H;

    @Nullable
    public FeedListItemClickOperate N;

    @Nullable
    public FeedClickEventHelper O;

    /* renamed from: q */
    @Nullable
    public FeedModel f14038q;

    /* renamed from: r */
    @Nullable
    public String f14039r;

    /* renamed from: s */
    public FeedSensorContext f14040s;

    /* renamed from: v */
    @Nullable
    public String f14043v;

    /* renamed from: w */
    @Nullable
    public String f14044w;

    /* renamed from: x */
    public boolean f14045x;

    /* renamed from: y */
    public boolean f14046y;

    @NotNull
    public Map<Integer, View> P = new LinkedHashMap();

    /* renamed from: t */
    @NotNull
    public final Lazy f14041t = kotlin.c.b(new Function0<FeedDetailAdapter>() { // from class: com.cupidapp.live.feed.activity.FeedDetailActivity$feedDetailAdapter$2

        /* compiled from: FeedDetailActivity.kt */
        @kotlin.d
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
        public static final class a implements com.cupidapp.live.feed.holder.c {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ FeedDetailActivity f14054a;

            public a(FeedDetailActivity feedDetailActivity) {
                this.f14054a = feedDetailActivity;
            }

            @Override // com.cupidapp.live.feed.holder.c
            public void a(@NotNull FeedModel model) {
                kotlin.jvm.internal.s.i(model, "model");
            }

            @Override // com.cupidapp.live.feed.holder.c
            public void b(@NotNull String userId) {
                FeedListItemClickOperate feedListItemClickOperate;
                kotlin.jvm.internal.s.i(userId, "userId");
                feedListItemClickOperate = this.f14054a.N;
                if (feedListItemClickOperate != null) {
                    feedListItemClickOperate.t(userId);
                }
            }
        }

        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final FeedDetailAdapter invoke() {
            FeedDetailActivity feedDetailActivity = FeedDetailActivity.this;
            return new FeedDetailAdapter(feedDetailActivity, new a(feedDetailActivity));
        }
    });

    /* renamed from: u */
    @NotNull
    public final Lazy f14042u = kotlin.c.b(new Function0<TrendFeedListAdapter>() { // from class: com.cupidapp.live.feed.activity.FeedDetailActivity$feedAdapter$2

        /* compiled from: FeedDetailActivity.kt */
        @kotlin.d
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
        public static final class a implements com.cupidapp.live.feed.holder.c {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ FeedDetailActivity f14053a;

            public a(FeedDetailActivity feedDetailActivity) {
                this.f14053a = feedDetailActivity;
            }

            @Override // com.cupidapp.live.feed.holder.c
            public void a(@NotNull FeedModel model) {
                FeedListItemClickOperate feedListItemClickOperate;
                kotlin.jvm.internal.s.i(model, "model");
                feedListItemClickOperate = this.f14053a.N;
                if (feedListItemClickOperate != null) {
                    feedListItemClickOperate.q(model, SensorsLogFeed.BtnName.DESCRIBE, false, false, false);
                }
            }

            @Override // com.cupidapp.live.feed.holder.c
            public void b(@NotNull String userId) {
                FeedListItemClickOperate feedListItemClickOperate;
                kotlin.jvm.internal.s.i(userId, "userId");
                feedListItemClickOperate = this.f14053a.N;
                if (feedListItemClickOperate != null) {
                    feedListItemClickOperate.t(userId);
                }
            }
        }

        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final TrendFeedListAdapter invoke() {
            FeedSensorContext feedSensorContext;
            feedSensorContext = FeedDetailActivity.this.f14040s;
            if (feedSensorContext == null) {
                kotlin.jvm.internal.s.A("sensorContext");
                feedSensorContext = null;
            }
            return new TrendFeedListAdapter(feedSensorContext, 0, null, new a(FeedDetailActivity.this));
        }
    });

    /* renamed from: z */
    @NotNull
    public final Lazy f14047z = kotlin.c.b(new Function0<FKLoadMoreListener>() { // from class: com.cupidapp.live.feed.activity.FeedDetailActivity$loadMoreListener$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final FKLoadMoreListener invoke() {
            final FeedDetailActivity feedDetailActivity = FeedDetailActivity.this;
            return new FKLoadMoreListener(new Function0<kotlin.p>() { // from class: com.cupidapp.live.feed.activity.FeedDetailActivity$loadMoreListener$2.1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ kotlin.p invoke() {
                    invoke2();
                    return kotlin.p.f51048a;
                }

                /* JADX WARN: Code restructure failed: missing block: B:23:0x004c, code lost:
                
                    if ((r0.length() > 0) == true) goto L27;
                 */
                /* JADX WARN: Removed duplicated region for block: B:12:0x0024  */
                /* JADX WARN: Removed duplicated region for block: B:9:0x001a  */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final void invoke2() {
                    /*
                        r3 = this;
                        com.cupidapp.live.feed.activity.FeedDetailActivity r0 = com.cupidapp.live.feed.activity.FeedDetailActivity.this
                        java.lang.String r0 = com.cupidapp.live.feed.activity.FeedDetailActivity.T1(r0)
                        r1 = 1
                        r2 = 0
                        if (r0 == 0) goto L17
                        int r0 = r0.length()
                        if (r0 <= 0) goto L12
                        r0 = 1
                        goto L13
                    L12:
                        r0 = 0
                    L13:
                        if (r0 != r1) goto L17
                        r0 = 1
                        goto L18
                    L17:
                        r0 = 0
                    L18:
                        if (r0 == 0) goto L24
                        com.cupidapp.live.feed.activity.FeedDetailActivity r0 = com.cupidapp.live.feed.activity.FeedDetailActivity.this
                        java.lang.String r1 = com.cupidapp.live.feed.activity.FeedDetailActivity.T1(r0)
                        com.cupidapp.live.feed.activity.FeedDetailActivity.R1(r0, r1)
                        goto L5b
                    L24:
                        com.cupidapp.live.feed.activity.FeedDetailActivity r0 = com.cupidapp.live.feed.activity.FeedDetailActivity.this
                        boolean r0 = com.cupidapp.live.feed.activity.FeedDetailActivity.M1(r0)
                        if (r0 != 0) goto L33
                        com.cupidapp.live.feed.activity.FeedDetailActivity r0 = com.cupidapp.live.feed.activity.FeedDetailActivity.this
                        r1 = 0
                        com.cupidapp.live.feed.activity.FeedDetailActivity.Z1(r0, r1)
                        goto L5b
                    L33:
                        com.cupidapp.live.feed.activity.FeedDetailActivity r0 = com.cupidapp.live.feed.activity.FeedDetailActivity.this
                        boolean r0 = com.cupidapp.live.feed.activity.FeedDetailActivity.M1(r0)
                        if (r0 == 0) goto L5b
                        com.cupidapp.live.feed.activity.FeedDetailActivity r0 = com.cupidapp.live.feed.activity.FeedDetailActivity.this
                        java.lang.String r0 = com.cupidapp.live.feed.activity.FeedDetailActivity.L1(r0)
                        if (r0 == 0) goto L4f
                        int r0 = r0.length()
                        if (r0 <= 0) goto L4b
                        r0 = 1
                        goto L4c
                    L4b:
                        r0 = 0
                    L4c:
                        if (r0 != r1) goto L4f
                        goto L50
                    L4f:
                        r1 = 0
                    L50:
                        if (r1 == 0) goto L5b
                        com.cupidapp.live.feed.activity.FeedDetailActivity r0 = com.cupidapp.live.feed.activity.FeedDetailActivity.this
                        java.lang.String r1 = com.cupidapp.live.feed.activity.FeedDetailActivity.L1(r0)
                        com.cupidapp.live.feed.activity.FeedDetailActivity.Z1(r0, r1)
                    L5b:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.feed.activity.FeedDetailActivity$loadMoreListener$2.AnonymousClass1.invoke2():void");
                }
            });
        }
    });

    @NotNull
    public final Lazy E = kotlin.c.b(new Function0<Map<String, ? extends Object>>() { // from class: com.cupidapp.live.feed.activity.FeedDetailActivity$recommendContext$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @Nullable
        public final Map<String, ? extends Object> invoke() {
            Intent intent = FeedDetailActivity.this.getIntent();
            kotlin.jvm.internal.s.h(intent, "intent");
            SerializableContext serializableContext = (SerializableContext) z0.g.a(intent, SerializableContext.class);
            if (serializableContext != null) {
                return serializableContext.getMap();
            }
            return null;
        }
    });

    @NotNull
    public final Lazy I = kotlin.c.b(new Function0<String>() { // from class: com.cupidapp.live.feed.activity.FeedDetailActivity$markCommentId$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @Nullable
        public final String invoke() {
            return FeedDetailActivity.this.getIntent().getStringExtra("markComment");
        }
    });

    @NotNull
    public final Lazy J = kotlin.c.b(new Function0<Boolean>() { // from class: com.cupidapp.live.feed.activity.FeedDetailActivity$seeMoreComment$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final Boolean invoke() {
            return Boolean.valueOf(FeedDetailActivity.this.getIntent().getBooleanExtra("FeedDetailSeeMoreComment", false));
        }
    });

    @NotNull
    public final Lazy K = kotlin.c.b(new Function0<String>() { // from class: com.cupidapp.live.feed.activity.FeedDetailActivity$postId$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @Nullable
        public final String invoke() {
            return FeedDetailActivity.this.getIntent().getStringExtra("POST_ID");
        }
    });

    @NotNull
    public final Lazy L = kotlin.c.b(new Function0<Integer>() { // from class: com.cupidapp.live.feed.activity.FeedDetailActivity$videoAutoPlayMinHeight$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final Integer invoke() {
            return Integer.valueOf(-z0.h.c(FeedDetailActivity.this, 52.0f));
        }
    });

    @NotNull
    public final Lazy M = kotlin.c.b(new Function0<Integer>() { // from class: com.cupidapp.live.feed.activity.FeedDetailActivity$videoAutoPlayMaxHeight$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final Integer invoke() {
            return Integer.valueOf(((z0.h.k(FeedDetailActivity.this) * 3) / 5) - z0.h.c(FeedDetailActivity.this, 100.0f));
        }
    });

    /* compiled from: FeedDetailActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void b(a aVar, Context context, FeedModel feedModel, boolean z10, FeedSensorContext feedSensorContext, boolean z11, boolean z12, String str, Map map, String str2, String str3, int i10, Object obj) {
            aVar.a(context, feedModel, z10, feedSensorContext, (i10 & 16) != 0 ? false : z11, (i10 & 32) != 0 ? false : z12, (i10 & 64) != 0 ? null : str, (i10 & 128) != 0 ? null : map, (i10 & 256) != 0 ? null : str2, (i10 & 512) != 0 ? null : str3);
        }

        public final void a(@Nullable Context context, @Nullable FeedModel feedModel, boolean z10, @NotNull FeedSensorContext sensorContext, boolean z11, boolean z12, @Nullable String str, @Nullable Map<String, ? extends Object> map, @Nullable String str2, @Nullable String str3) {
            kotlin.jvm.internal.s.i(sensorContext, "sensorContext");
            Intent intent = new Intent(context, (Class<?>) FeedDetailActivity.class);
            if (feedModel != null) {
                z0.g.c(intent, feedModel);
            }
            intent.putExtra("FeedDetailShowInputMethod", z10);
            intent.putExtra("FeedDetailSeeMoreComment", z11);
            intent.putExtra("FeedDetailNoCommentShowInputMethod", z12);
            intent.putExtra("feedModelCallback", str2);
            intent.putExtra("markComment", str);
            z0.g.c(intent, sensorContext);
            if (map != null) {
                z0.g.c(intent, new SerializableContext(map));
            }
            intent.putExtra("POST_ID", str3);
            if (context != null) {
                context.startActivity(intent);
            }
            FKBaseActivity.a.c(FKBaseActivity.f11750o, context, 0, 0, 6, null);
        }
    }

    /* compiled from: FeedDetailActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class b implements View.OnLayoutChangeListener {
        public b() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(@NotNull View v2, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
            com.cupidapp.live.feed.helper.j jVar;
            kotlin.jvm.internal.s.i(v2, "v");
            if (FeedDetailActivity.this.getLifecycle().getCurrentState() == Lifecycle.State.RESUMED && (jVar = FeedDetailActivity.this.A) != null) {
                jVar.k();
            }
            try {
                ((RecyclerView) FeedDetailActivity.this.y1(R$id.detailRecyclerView)).removeOnLayoutChangeListener(this);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* compiled from: FeedDetailActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class c implements com.cupidapp.live.feed.layout.d {
        public c() {
        }

        @Override // com.cupidapp.live.feed.layout.d
        public void a() {
            FeedClickEventHelper feedClickEventHelper;
            ((FeedDetailTitleBarLayout) FeedDetailActivity.this.y1(R$id.feedDetailTitleLayout)).setAlohaButtonVisible(false);
            FeedModel feedModel = FeedDetailActivity.this.f14038q;
            if (feedModel == null || (feedClickEventHelper = FeedDetailActivity.this.O) == null) {
                return;
            }
            feedClickEventHelper.h(feedModel);
        }

        @Override // com.cupidapp.live.feed.layout.d
        public void b() {
            FeedClickEventHelper feedClickEventHelper;
            FeedModel feedModel = FeedDetailActivity.this.f14038q;
            if (feedModel == null || (feedClickEventHelper = FeedDetailActivity.this.O) == null) {
                return;
            }
            feedClickEventHelper.t(feedModel);
        }

        @Override // com.cupidapp.live.feed.layout.d
        public void c() {
            if (FeedDetailActivity.this.f14038q != null) {
                FeedDetailActivity feedDetailActivity = FeedDetailActivity.this;
                feedDetailActivity.x3(feedDetailActivity.f14038q, ShareBtnPos.ShareTopBtn);
            }
        }

        @Override // com.cupidapp.live.feed.layout.d
        public void d() {
            EditInputBottomSheetDialog editInputBottomSheetDialog = FeedDetailActivity.this.G;
            if (editInputBottomSheetDialog != null) {
                editInputBottomSheetDialog.dismiss();
            }
            FeedDetailActivity.this.finish();
        }

        @Override // com.cupidapp.live.feed.layout.d
        public void e() {
            FeedClickEventHelper feedClickEventHelper;
            FeedModel feedModel = FeedDetailActivity.this.f14038q;
            if (feedModel == null || (feedClickEventHelper = FeedDetailActivity.this.O) == null) {
                return;
            }
            feedClickEventHelper.t(feedModel);
        }
    }

    /* compiled from: FeedDetailActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class d implements o.c {
        public d() {
        }

        @Override // com.cupidapp.live.base.utils.o.c
        public void a(long j10) {
            User user;
            j1.k kVar = j1.k.f50238a;
            SensorPosition sensorPosition = SensorPosition.FeedDetail;
            FeedModel feedModel = FeedDetailActivity.this.f14038q;
            String str = null;
            String feedContentType = feedModel != null ? feedModel.getFeedContentType() : null;
            FeedModel feedModel2 = FeedDetailActivity.this.f14038q;
            if (feedModel2 != null && (user = feedModel2.getUser()) != null) {
                str = user.userId();
            }
            kVar.a(sensorPosition, feedContentType, str, j10);
        }

        @Override // com.cupidapp.live.base.utils.o.c
        public void b(@NotNull String imageUriString, boolean z10) {
            User user;
            kotlin.jvm.internal.s.i(imageUriString, "imageUriString");
            j1.k kVar = j1.k.f50238a;
            SensorPosition sensorPosition = SensorPosition.FeedDetail;
            FeedModel feedModel = FeedDetailActivity.this.f14038q;
            String str = null;
            String feedContentType = feedModel != null ? feedModel.getFeedContentType() : null;
            FeedModel feedModel2 = FeedDetailActivity.this.f14038q;
            if (feedModel2 != null && (user = feedModel2.getUser()) != null) {
                str = user.userId();
            }
            kVar.c(sensorPosition, feedContentType, str, z10);
        }
    }

    public static final void B3(ValueAnimator valueAnimator, View view, ValueAnimator it) {
        kotlin.jvm.internal.s.i(it, "it");
        Object animatedValue = valueAnimator.getAnimatedValue();
        kotlin.jvm.internal.s.g(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        view.setAlpha(((Float) animatedValue).floatValue());
    }

    public static final FeedModel D2(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        return (FeedModel) tmp0.invoke(obj);
    }

    public static final List E2(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        return (List) tmp0.invoke(obj);
    }

    public static final ListResult F2(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        return (ListResult) tmp0.invoke(obj);
    }

    public static final Pair G2(FeedModel feedModel, List userList, ListResult comments) {
        kotlin.jvm.internal.s.i(feedModel, "<anonymous parameter 0>");
        kotlin.jvm.internal.s.i(userList, "userList");
        kotlin.jvm.internal.s.i(comments, "comments");
        return new Pair(userList, comments);
    }

    public static final void H2(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void I2(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void J2(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void b3(FeedDetailActivity this$0, View view) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        FeedModel feedModel = this$0.f14038q;
        if (feedModel != null) {
            this$0.x3(feedModel, ShareBtnPos.ShareBottomBtn);
        }
    }

    public static final void c3(FeedDetailActivity this$0, View view) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        if (((RecyclerView) this$0.y1(R$id.detailRecyclerView)).canScrollVertically(1) && this$0.C3(null)) {
            return;
        }
        this$0.y3(null, null);
    }

    public static final void d3(FeedDetailActivity this$0, View view) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        this$0.y3(null, null);
    }

    public static final void e3(FeedDetailActivity this$0, View view) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        FeedModel feedModel = this$0.f14038q;
        if (feedModel != null) {
            FeedClickEventHelper feedClickEventHelper = this$0.O;
            if (feedClickEventHelper != null && feedClickEventHelper.p(feedModel)) {
                return;
            }
            if (feedModel.getLiked()) {
                this$0.t2(feedModel);
            } else {
                this$0.A2(feedModel);
            }
        }
    }

    public static final void i3(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final boolean k3(FeedDetailActivity this$0, View view, MotionEvent motionEvent) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        view.performClick();
        EditInputBottomSheetDialog editInputBottomSheetDialog = this$0.G;
        if (editInputBottomSheetDialog == null) {
            return true;
        }
        editInputBottomSheetDialog.dismiss();
        return true;
    }

    public static final void z3(FeedDetailActivity this$0, DialogInterface dialogInterface) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        FeedDetailEditTextLayout feedDetailEditTextLayout = this$0.H;
        if (feedDetailEditTextLayout != null) {
            feedDetailEditTextLayout.s();
        }
    }

    public final void A2(final FeedModel feedModel) {
        final Map h10 = i0.h(kotlin.f.a(Integer.valueOf(RequestErrorCode.YouBlacklistedTheOtherPerson.getValue()), new Function1<String, kotlin.p>() { // from class: com.cupidapp.live.feed.activity.FeedDetailActivity$feedLike$errorCodeInterceptor$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(String str) {
                invoke2(str);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable String str) {
                FKAlertDialog.G(FKAlertDialog.w(FKAlertDialog.a.c(FKAlertDialog.f12698l, FeedDetailActivity.this, false, 2, null).n(str), 0, null, null, 7, null), null, 1, null);
            }
        }));
        Disposable disposed = NetworkClient.f11868a.l().A(feedModel.getPostId()).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<FeedLikeResult, kotlin.p>() { // from class: com.cupidapp.live.feed.activity.FeedDetailActivity$feedLike$$inlined$handleByContext$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(FeedLikeResult feedLikeResult) {
                m2551invoke(feedLikeResult);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2551invoke(FeedLikeResult feedLikeResult) {
                FeedModel.this.praise();
                this.s3();
                this.r3();
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.feed.activity.FeedDetailActivity$feedLike$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                kotlin.jvm.internal.s.i(it, "it");
                com.cupidapp.live.base.network.j.f(com.cupidapp.live.base.network.j.f12008a, it, FeedDetailActivity.this, h10, null, 8, null);
                return Boolean.TRUE;
            }
        }, this)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
            H(disposed);
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
        SensorsLogFeed sensorsLogFeed = SensorsLogFeed.f12208a;
        String userId = feedModel.getUser().userId();
        String postId = feedModel.getPostId();
        FeedSensorContext feedSensorContext = this.f14040s;
        FeedSensorContext feedSensorContext2 = null;
        if (feedSensorContext == null) {
            kotlin.jvm.internal.s.A("sensorContext");
            feedSensorContext = null;
        }
        SensorPosition position = feedSensorContext.getPosition();
        FeedSensorContext feedSensorContext3 = this.f14040s;
        if (feedSensorContext3 == null) {
            kotlin.jvm.internal.s.A("sensorContext");
        } else {
            feedSensorContext2 = feedSensorContext3;
        }
        sensorsLogFeed.m(userId, postId, position, feedSensorContext2.getScene(), SensorsLogFeed.LikeCommentType.Feed, feedModel.getUser().getAloha(), feedModel.getStrategyId(), p1.g.f52734a.x());
    }

    public final void A3(final View view) {
        if (view == null) {
            return;
        }
        final ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat.setStartDelay(2000L);
        ofFloat.setDuration(500L);
        view.setAlpha(1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.cupidapp.live.feed.activity.e
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                FeedDetailActivity.B3(ofFloat, view, valueAnimator);
            }
        });
        ofFloat.start();
    }

    public final void B2(final FeedModel feedModel) {
        Y2(feedModel, UserActionType.Share);
        Disposable disposed = NetworkClient.f11868a.l().q(feedModel.getPostId()).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.feed.activity.FeedDetailActivity$feedShare$$inlined$handleByContext$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                invoke2(obj);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
                FeedModel.this.share();
                this.t3();
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.feed.activity.FeedDetailActivity$feedShare$2
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                kotlin.jvm.internal.s.i(it, "it");
                return Boolean.TRUE;
            }
        }, this)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
            H(disposed);
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }

    public final void C2() {
        final String S2;
        FeedModel feedModel = this.f14038q;
        if (feedModel != null) {
            N2().d(feedModel);
            N2().notifyDataSetChanged();
        }
        FeedModel feedModel2 = this.f14038q;
        if ((feedModel2 == null || (S2 = feedModel2.getPostId()) == null) && (S2 = S2()) == null) {
            return;
        }
        FeedModel feedModel3 = this.f14038q;
        final String recommendId = feedModel3 != null ? feedModel3.getRecommendId() : null;
        FeedModel feedModel4 = this.f14038q;
        final String postStatisticsSource = feedModel4 != null ? feedModel4.getPostStatisticsSource() : null;
        NetworkClient networkClient = NetworkClient.f11868a;
        Observable<R> flatMap = networkClient.l().J(S2).flatMap(new com.cupidapp.live.base.network.i());
        final Function1<ListResult<FeedModel>, FeedModel> function1 = new Function1<ListResult<FeedModel>, FeedModel>() { // from class: com.cupidapp.live.feed.activity.FeedDetailActivity$firstGetFeedDetailData$feedDetail$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final FeedModel invoke(@NotNull ListResult<FeedModel> it) {
                kotlin.jvm.internal.s.i(it, "it");
                List<FeedModel> list = it.getList();
                if (list != null) {
                    FeedDetailActivity feedDetailActivity = FeedDetailActivity.this;
                    String str = recommendId;
                    String str2 = postStatisticsSource;
                    if (!list.isEmpty()) {
                        feedDetailActivity.f14038q = list.get(0);
                        FeedModel feedModel5 = feedDetailActivity.f14038q;
                        if (feedModel5 != null) {
                            feedModel5.setRecommendId(str);
                        }
                        FeedModel feedModel6 = feedDetailActivity.f14038q;
                        if (feedModel6 != null) {
                            feedModel6.setPostStatisticsSource(str2);
                        }
                    }
                }
                return FeedDetailActivity.this.f14038q;
            }
        };
        Observable map = flatMap.map(new Function() { // from class: com.cupidapp.live.feed.activity.h
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                FeedModel D2;
                D2 = FeedDetailActivity.D2(Function1.this, obj);
                return D2;
            }
        });
        Observable d10 = a.C0836a.d(networkClient.N(), S2, null, 12, 2, null);
        final FeedDetailActivity$firstGetFeedDetailData$praiseUserList$1 feedDetailActivity$firstGetFeedDetailData$praiseUserList$1 = new Function1<Result<? extends ListResult<User>>, List<User>>() { // from class: com.cupidapp.live.feed.activity.FeedDetailActivity$firstGetFeedDetailData$praiseUserList$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ List<User> invoke(Result<? extends ListResult<User>> result) {
                return invoke2((Result<ListResult<User>>) result);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final List<User> invoke2(@NotNull Result<ListResult<User>> it) {
                List<User> list;
                kotlin.jvm.internal.s.i(it, "it");
                ListResult<User> data = it.getData();
                return (data == null || (list = data.getList()) == null) ? new ArrayList() : list;
            }
        };
        Observable map2 = d10.map(new Function() { // from class: com.cupidapp.live.feed.activity.i
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List E2;
                E2 = FeedDetailActivity.E2(Function1.this, obj);
                return E2;
            }
        });
        Observable b4 = a.C0731a.b(networkClient.l(), S2, null, null, 0, null, 30, null);
        final FeedDetailActivity$firstGetFeedDetailData$comment$1 feedDetailActivity$firstGetFeedDetailData$comment$1 = new Function1<Result<? extends ListResult<PostCommentModel>>, ListResult<PostCommentModel>>() { // from class: com.cupidapp.live.feed.activity.FeedDetailActivity$firstGetFeedDetailData$comment$1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final ListResult<PostCommentModel> invoke2(@NotNull Result<ListResult<PostCommentModel>> it) {
                kotlin.jvm.internal.s.i(it, "it");
                ListResult<PostCommentModel> data = it.getData();
                return data == null ? new ListResult<>(null, null) : data;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ ListResult<PostCommentModel> invoke(Result<? extends ListResult<PostCommentModel>> result) {
                return invoke2((Result<ListResult<PostCommentModel>>) result);
            }
        };
        Observable zip = Observable.zip(map, map2, b4.map(new Function() { // from class: com.cupidapp.live.feed.activity.j
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ListResult F2;
                F2 = FeedDetailActivity.F2(Function1.this, obj);
                return F2;
            }
        }), new Function3() { // from class: com.cupidapp.live.feed.activity.g
            @Override // io.reactivex.functions.Function3
            public final Object apply(Object obj, Object obj2, Object obj3) {
                Pair G2;
                G2 = FeedDetailActivity.G2((FeedModel) obj, (List) obj2, (ListResult) obj3);
                return G2;
            }
        });
        final Function1<Pair<? extends List<User>, ? extends ListResult<PostCommentModel>>, kotlin.p> function12 = new Function1<Pair<? extends List<User>, ? extends ListResult<PostCommentModel>>, kotlin.p>() { // from class: com.cupidapp.live.feed.activity.FeedDetailActivity$firstGetFeedDetailData$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Pair<? extends List<User>, ? extends ListResult<PostCommentModel>> pair) {
                invoke2((Pair<? extends List<User>, ListResult<PostCommentModel>>) pair);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Pair<? extends List<User>, ListResult<PostCommentModel>> pair) {
                FeedDetailAdapter N2;
                FeedDetailAdapter N22;
                FeedDetailAdapter N23;
                FeedModel feedModel5 = FeedDetailActivity.this.f14038q;
                if (feedModel5 != null) {
                    FeedDetailActivity feedDetailActivity = FeedDetailActivity.this;
                    N2 = feedDetailActivity.N2();
                    N2.j().clear();
                    N22 = feedDetailActivity.N2();
                    N22.j().add(0, feedModel5);
                    User user = feedModel5.getUser();
                    if (user != null && user.getMe()) {
                        List<User> first = pair.getFirst();
                        if (first == null || first.isEmpty()) {
                            return;
                        }
                        N23 = feedDetailActivity.N2();
                        N23.j().add(1, new FeedDetailPraiseListViewModel(pair.getFirst()));
                    }
                }
            }
        };
        Observable observeOn = zip.doOnNext(new Consumer() { // from class: com.cupidapp.live.feed.activity.r
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                FeedDetailActivity.H2(Function1.this, obj);
            }
        }).observeOn(AndroidSchedulers.mainThread());
        final Function1<Pair<? extends List<User>, ? extends ListResult<PostCommentModel>>, kotlin.p> function13 = new Function1<Pair<? extends List<User>, ? extends ListResult<PostCommentModel>>, kotlin.p>() { // from class: com.cupidapp.live.feed.activity.FeedDetailActivity$firstGetFeedDetailData$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Pair<? extends List<User>, ? extends ListResult<PostCommentModel>> pair) {
                invoke2((Pair<? extends List<User>, ListResult<PostCommentModel>>) pair);
                return kotlin.p.f51048a;
            }

            /* JADX WARN: Removed duplicated region for block: B:20:0x0084  */
            /* JADX WARN: Removed duplicated region for block: B:23:0x0094  */
            /* JADX WARN: Removed duplicated region for block: B:26:0x00a4  */
            /* JADX WARN: Removed duplicated region for block: B:39:0x00dd  */
            /* JADX WARN: Removed duplicated region for block: B:46:0x0103  */
            /* JADX WARN: Removed duplicated region for block: B:49:0x0109  */
            /* JADX WARN: Removed duplicated region for block: B:51:0x00e3  */
            /* JADX WARN: Removed duplicated region for block: B:54:0x00aa  */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void invoke2(kotlin.Pair<? extends java.util.List<com.cupidapp.live.profile.model.User>, com.cupidapp.live.base.network.model.ListResult<com.cupidapp.live.feed.model.PostCommentModel>> r17) {
                /*
                    Method dump skipped, instructions count: 271
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.feed.activity.FeedDetailActivity$firstGetFeedDetailData$4.invoke2(kotlin.Pair):void");
            }
        };
        Consumer consumer = new Consumer() { // from class: com.cupidapp.live.feed.activity.f
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                FeedDetailActivity.I2(Function1.this, obj);
            }
        };
        final Function1<Throwable, kotlin.p> function14 = new Function1<Throwable, kotlin.p>() { // from class: com.cupidapp.live.feed.activity.FeedDetailActivity$firstGetFeedDetailData$5
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Throwable th) {
                invoke2(th);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                FeedDetailActivity.this.K2();
                com.cupidapp.live.base.network.j jVar = com.cupidapp.live.base.network.j.f12008a;
                kotlin.jvm.internal.s.h(it, "it");
                com.cupidapp.live.base.network.j.f(jVar, it, null, null, null, 14, null);
            }
        };
        this.C = observeOn.subscribe(consumer, new Consumer() { // from class: com.cupidapp.live.feed.activity.s
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                FeedDetailActivity.J2(Function1.this, obj);
            }
        });
    }

    public final boolean C3(String str) {
        boolean z10;
        int i10;
        final int i11 = -1;
        if (str == null || str.length() == 0) {
            i10 = 0;
            for (Object obj : N2().j()) {
                if ((obj instanceof FeedDetailPraiseListViewModel) || (obj instanceof FeedDetailCommentViewModel)) {
                    i11 = i10;
                    break;
                }
                i10++;
            }
            z10 = false;
        } else {
            Iterator<Object> iterator2 = N2().j().iterator2();
            int i12 = 0;
            while (true) {
                if (!iterator2.hasNext()) {
                    i12 = -1;
                    break;
                }
                Object next = iterator2.next();
                if ((next instanceof FeedDetailCommentViewModel) && kotlin.jvm.internal.s.d(((FeedDetailCommentViewModel) next).getCommentModel().getId(), str)) {
                    break;
                }
                i12++;
            }
            if (i12 == -1) {
                i10 = 0;
                for (Object obj2 : N2().j()) {
                    if ((obj2 instanceof FeedDetailPraiseListViewModel) || (obj2 instanceof FeedDetailCommentViewModel)) {
                        i11 = i10;
                        break;
                    }
                    i10++;
                }
                z10 = false;
            } else {
                i11 = i12;
                z10 = true;
            }
        }
        n3();
        if (i11 <= 0 || this.D >= i11) {
            return false;
        }
        int i13 = R$id.detailRecyclerView;
        ((RecyclerView) y1(i13)).smoothScrollToPosition(i11);
        if (!z10) {
            return true;
        }
        ((RecyclerView) y1(i13)).addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.cupidapp.live.feed.activity.FeedDetailActivity$smoothScrollToPosition$scrollListenerForCommentAnim$1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int i14) {
                View view;
                kotlin.jvm.internal.s.i(recyclerView, "recyclerView");
                super.onScrollStateChanged(recyclerView, i14);
                if (i14 == 0) {
                    FeedDetailActivity feedDetailActivity = FeedDetailActivity.this;
                    int i15 = R$id.detailRecyclerView;
                    ((RecyclerView) feedDetailActivity.y1(i15)).removeOnScrollListener(this);
                    FeedDetailActivity feedDetailActivity2 = FeedDetailActivity.this;
                    RecyclerView.ViewHolder findViewHolderForLayoutPosition = ((RecyclerView) feedDetailActivity2.y1(i15)).findViewHolderForLayoutPosition(i11);
                    feedDetailActivity2.A3((findViewHolderForLayoutPosition == null || (view = findViewHolderForLayoutPosition.itemView) == null) ? null : view.findViewById(R$id.foregroundAnimView));
                }
            }
        });
        return true;
    }

    public final void K2() {
        O2().c(false);
        FKFooterViewModel h10 = N2().h();
        if (h10 == null) {
            return;
        }
        h10.setShowProgress(false);
    }

    public final void L2(String str, ListResult<PostCommentModel> listResult, boolean z10, boolean z11) {
        boolean z12;
        this.f14043v = listResult.getNextCursorId();
        if (z11) {
            N2().d(new FeedDetailCommentTitleModel(this.f14038q));
        }
        List<PostCommentModel> list = listResult.getList();
        if (list == null || list.isEmpty()) {
            N2().d(new FeedDetailNoCommentModel());
            z12 = true;
        } else {
            List<PostCommentModel> list2 = listResult.getList();
            if (list2 != null) {
                for (PostCommentModel postCommentModel : list2) {
                    N2().d(new FeedDetailCommentViewModel(str, postCommentModel));
                    List<PostCommentModel> nextLevelComments = postCommentModel.getNextLevelComments();
                    if (!(nextLevelComments == null || nextLevelComments.isEmpty())) {
                        FeedDetailAdapter N2 = N2();
                        List<PostCommentModel> nextLevelComments2 = postCommentModel.getNextLevelComments();
                        ArrayList arrayList = new ArrayList(kotlin.collections.t.t(nextLevelComments2, 10));
                        Iterator<PostCommentModel> iterator2 = nextLevelComments2.iterator2();
                        while (iterator2.hasNext()) {
                            arrayList.add(new FeedDetailCommentViewModel(str, iterator2.next()));
                        }
                        N2.e(arrayList);
                    }
                    if (postCommentModel.getCommentCount() != null) {
                        int intValue = postCommentModel.getCommentCount().intValue();
                        List<PostCommentModel> nextLevelComments3 = postCommentModel.getNextLevelComments();
                        int size = intValue - (nextLevelComments3 != null ? nextLevelComments3.size() : 0);
                        if (size > 0) {
                            String nextLevelCursor = postCommentModel.getNextLevelCursor();
                            if (!(nextLevelCursor == null || nextLevelCursor.length() == 0)) {
                                N2().d(new FeedDetailShowMoreCommentViewModel(postCommentModel, postCommentModel.getNextLevelCursor(), false, Integer.valueOf(size)));
                            }
                        }
                    }
                }
            }
            z12 = false;
        }
        if (getIntent().getBooleanExtra("FeedDetailNoCommentShowInputMethod", false)) {
            z10 = z10 || z12;
        }
        v2(z10);
        O2().c(false);
        FKFooterViewModel h10 = N2().h();
        if (h10 != null) {
            String str2 = this.f14043v;
            h10.setShowProgress(!(str2 == null || str2.length() == 0));
        }
        N2().notifyDataSetChanged();
    }

    public final TrendFeedListAdapter M2() {
        return (TrendFeedListAdapter) this.f14042u.getValue();
    }

    public final FeedDetailAdapter N2() {
        return (FeedDetailAdapter) this.f14041t.getValue();
    }

    public final FKLoadMoreListener O2() {
        return (FKLoadMoreListener) this.f14047z.getValue();
    }

    @Override // com.cupidapp.live.feed.holder.b
    public void P(@NotNull FeedModel model) {
        kotlin.jvm.internal.s.i(model, "model");
        s3();
        r3();
    }

    public final String P2() {
        return (String) this.I.getValue();
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity
    @NotNull
    public SensorPosition Q0() {
        return SensorPosition.FeedDetail;
    }

    public final void Q2(String str) {
        FeedModel feedModel = this.f14038q;
        final String postId = feedModel != null ? feedModel.getPostId() : null;
        if (postId == null || postId.length() == 0) {
            return;
        }
        if (str == null || str.length() == 0) {
            return;
        }
        Disposable disposed = a.C0731a.b(NetworkClient.f11868a.l(), postId, str, null, 0, null, 28, null).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<ListResult<PostCommentModel>, kotlin.p>() { // from class: com.cupidapp.live.feed.activity.FeedDetailActivity$getMoreFirstCommentData$$inlined$handle$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(ListResult<PostCommentModel> listResult) {
                m2552invoke(listResult);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2552invoke(ListResult<PostCommentModel> listResult) {
                String str2;
                ListResult<PostCommentModel> listResult2 = listResult;
                FeedDetailActivity.this.L2(postId, listResult2, false, false);
                String nextCursorId = listResult2.getNextCursorId();
                if (nextCursorId == null || nextCursorId.length() == 0) {
                    FeedDetailActivity feedDetailActivity = FeedDetailActivity.this;
                    str2 = feedDetailActivity.f14044w;
                    feedDetailActivity.h3(str2);
                }
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.feed.activity.FeedDetailActivity$getMoreFirstCommentData$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                kotlin.jvm.internal.s.i(it, "it");
                FeedDetailActivity.this.K2();
                return Boolean.FALSE;
            }
        }, this)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
            H(disposed);
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }

    public final void R2(final int i10, final FeedDetailShowMoreCommentViewModel feedDetailShowMoreCommentViewModel) {
        FeedModel feedModel = this.f14038q;
        final String postId = feedModel != null ? feedModel.getPostId() : null;
        if (postId == null || postId.length() == 0) {
            return;
        }
        String nextLevelCursor = feedDetailShowMoreCommentViewModel.getNextLevelCursor();
        if (nextLevelCursor == null || nextLevelCursor.length() == 0) {
            return;
        }
        Disposable disposed = a.C0731a.b(NetworkClient.f11868a.l(), postId, feedDetailShowMoreCommentViewModel.getNextLevelCursor(), feedDetailShowMoreCommentViewModel.getFirstCommentModel().getId(), 0, null, 24, null).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<ListResult<PostCommentModel>, kotlin.p>() { // from class: com.cupidapp.live.feed.activity.FeedDetailActivity$getMoreSecondCommentData$$inlined$handle$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(ListResult<PostCommentModel> listResult) {
                m2553invoke(listResult);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2553invoke(ListResult<PostCommentModel> listResult) {
                FeedDetailAdapter N2;
                int i11;
                FeedDetailAdapter N22;
                List<PostCommentModel> list;
                FeedDetailAdapter N23;
                FeedDetailAdapter N24;
                ListResult<PostCommentModel> listResult2 = listResult;
                FeedDetailShowMoreCommentViewModel.this.setNextLevelCursor(listResult2.getNextCursorId());
                String nextCursorId = listResult2.getNextCursorId();
                if (nextCursorId == null || nextCursorId.length() == 0) {
                    N24 = this.N2();
                    N24.j().remove(i10);
                } else {
                    FeedDetailShowMoreCommentViewModel.this.setShowMoreText(true);
                }
                List<PostCommentModel> list2 = listResult2.getList();
                if (!(list2 == null || list2.isEmpty()) && (i11 = i10) >= 0) {
                    N22 = this.N2();
                    if (i11 <= N22.j().size() && (list = listResult2.getList()) != null) {
                        ArrayList arrayList = new ArrayList(kotlin.collections.t.t(list, 10));
                        Iterator<PostCommentModel> iterator2 = list.iterator2();
                        while (iterator2.hasNext()) {
                            arrayList.add(new FeedDetailCommentViewModel(postId, iterator2.next()));
                        }
                        N23 = this.N2();
                        N23.j().addAll(i10, arrayList);
                    }
                }
                N2 = this.N2();
                N2.notifyDataSetChanged();
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
            H(disposed);
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }

    public final String S2() {
        return (String) this.K.getValue();
    }

    public final Map<String, Object> T2() {
        return (Map) this.E.getValue();
    }

    public final boolean U2() {
        return ((Boolean) this.J.getValue()).booleanValue();
    }

    @Override // com.cupidapp.live.feed.fragment.i
    @Nullable
    public TrendFeedViewHolder V(int i10) {
        RecyclerView.ViewHolder findViewHolderForAdapterPosition = ((RecyclerView) y1(R$id.detailRecyclerView)).findViewHolderForAdapterPosition(i10);
        if (findViewHolderForAdapterPosition instanceof TrendFeedViewHolder) {
            return (TrendFeedViewHolder) findViewHolderForAdapterPosition;
        }
        return null;
    }

    public final int V2() {
        return ((Number) this.M.getValue()).intValue();
    }

    public final int W2() {
        return ((Number) this.L.getValue()).intValue();
    }

    public final void X2() {
        PrivateFeedActivity.a aVar = PrivateFeedActivity.f17650v;
        FeedSensorContext feedSensorContext = this.f14040s;
        if (feedSensorContext == null) {
            kotlin.jvm.internal.s.A("sensorContext");
            feedSensorContext = null;
        }
        aVar.a(this, feedSensorContext);
    }

    public final void Y2(FeedModel feedModel, UserActionType userActionType) {
        com.cupidapp.live.feed.helper.h hVar = com.cupidapp.live.feed.helper.h.f14329a;
        String postId = feedModel.getPostId();
        Integer tagId = feedModel.getTagId();
        FeedSensorContext feedSensorContext = this.f14040s;
        FeedSensorContext feedSensorContext2 = null;
        if (feedSensorContext == null) {
            kotlin.jvm.internal.s.A("sensorContext");
            feedSensorContext = null;
        }
        SensorPosition position = feedSensorContext.getPosition();
        FeedSensorContext feedSensorContext3 = this.f14040s;
        if (feedSensorContext3 == null) {
            kotlin.jvm.internal.s.A("sensorContext");
        } else {
            feedSensorContext2 = feedSensorContext3;
        }
        hVar.e(postId, tagId, userActionType, position, feedSensorContext2.getSource(), (r18 & 32) != 0 ? null : null, (r18 & 64) != 0 ? null : this.f14039r);
    }

    public final void Z2() {
        FeedSensorContext feedSensorContext;
        FeedSensorContext feedSensorContext2;
        Map<Integer, Function1<Object, kotlin.p>> k10;
        Lifecycle lifecycle = getLifecycle();
        kotlin.jvm.internal.s.h(lifecycle, "lifecycle");
        RecyclerView detailRecyclerView = (RecyclerView) y1(R$id.detailRecyclerView);
        kotlin.jvm.internal.s.h(detailRecyclerView, "detailRecyclerView");
        FeedSensorContext feedSensorContext3 = this.f14040s;
        if (feedSensorContext3 == null) {
            kotlin.jvm.internal.s.A("sensorContext");
            feedSensorContext = null;
        } else {
            feedSensorContext = feedSensorContext3;
        }
        FeedClickEventHelper feedClickEventHelper = new FeedClickEventHelper(lifecycle, this, detailRecyclerView, true, feedSensorContext, null, null, new List[]{N2().j(), M2().j()}, 96, null);
        this.O = feedClickEventHelper;
        TrendFeedListAdapter M2 = M2();
        FeedSensorContext feedSensorContext4 = this.f14040s;
        if (feedSensorContext4 == null) {
            kotlin.jvm.internal.s.A("sensorContext");
            feedSensorContext2 = null;
        } else {
            feedSensorContext2 = feedSensorContext4;
        }
        this.N = new FeedListItemClickOperate(this, M2, this, feedSensorContext2, false, feedClickEventHelper, this);
        FeedClickEventHelper feedClickEventHelper2 = this.O;
        if (feedClickEventHelper2 != null && (k10 = feedClickEventHelper2.k()) != null) {
            k10.putAll(i0.h(kotlin.f.a(Integer.valueOf(R$id.detailUserAvatarImageView), new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.feed.activity.FeedDetailActivity$initClick$2$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                    invoke2(obj);
                    return kotlin.p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable Object obj) {
                    if (obj instanceof FeedDetailCommentViewModel) {
                        FeedDetailActivity.this.l3(((FeedDetailCommentViewModel) obj).getCommentModel().getUser());
                    }
                }
            }), kotlin.f.a(Integer.valueOf(R$id.detailUserNameTextView), new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.feed.activity.FeedDetailActivity$initClick$2$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                    invoke2(obj);
                    return kotlin.p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable Object obj) {
                    if (obj instanceof FeedDetailCommentViewModel) {
                        FeedDetailActivity.this.l3(((FeedDetailCommentViewModel) obj).getCommentModel().getUser());
                    }
                }
            }), kotlin.f.a(Integer.valueOf(R$id.detailPraiseListLayout), new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.feed.activity.FeedDetailActivity$initClick$2$3
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                    invoke2(obj);
                    return kotlin.p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable Object obj) {
                    FeedModel feedModel;
                    if (!(obj instanceof FeedDetailPraiseListViewModel) || (feedModel = FeedDetailActivity.this.f14038q) == null) {
                        return;
                    }
                    FeedLikedUserListActivity.f14069r.a(FeedDetailActivity.this, feedModel.getPostId(), feedModel.getLikeCount());
                }
            }), kotlin.f.a(Integer.valueOf(R$id.commentTitleInputTxt), new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.feed.activity.FeedDetailActivity$initClick$2$4
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                    invoke2(obj);
                    return kotlin.p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable Object obj) {
                    FeedDetailActivity.this.y3(null, null);
                }
            }), kotlin.f.a(Integer.valueOf(R$id.noCommentTextView), new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.feed.activity.FeedDetailActivity$initClick$2$5
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                    invoke2(obj);
                    return kotlin.p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable Object obj) {
                    FeedDetailActivity.this.y3(null, null);
                }
            })));
            N2().l().j(k10);
        }
        N2().l().k(i0.h(kotlin.f.a(Integer.valueOf(R$id.detailCommentLayout), new Function2<Object, Integer, kotlin.p>() { // from class: com.cupidapp.live.feed.activity.FeedDetailActivity$initClick$3
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: invoke */
            public /* bridge */ /* synthetic */ kotlin.p mo1743invoke(Object obj, Integer num) {
                invoke(obj, num.intValue());
                return kotlin.p.f51048a;
            }

            public final void invoke(@Nullable Object obj, int i10) {
                if (obj instanceof FeedDetailCommentViewModel) {
                    FeedDetailActivity.this.y3(Integer.valueOf(i10), ((FeedDetailCommentViewModel) obj).getCommentModel());
                }
            }
        }), kotlin.f.a(Integer.valueOf(R$id.detailCommentTextView), new Function2<Object, Integer, kotlin.p>() { // from class: com.cupidapp.live.feed.activity.FeedDetailActivity$initClick$4
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: invoke */
            public /* bridge */ /* synthetic */ kotlin.p mo1743invoke(Object obj, Integer num) {
                invoke(obj, num.intValue());
                return kotlin.p.f51048a;
            }

            public final void invoke(@Nullable Object obj, int i10) {
                if (obj instanceof FeedDetailCommentViewModel) {
                    FeedDetailActivity.this.y3(Integer.valueOf(i10), ((FeedDetailCommentViewModel) obj).getCommentModel());
                }
            }
        }), kotlin.f.a(Integer.valueOf(R$id.commentShowMoreTextView), new Function2<Object, Integer, kotlin.p>() { // from class: com.cupidapp.live.feed.activity.FeedDetailActivity$initClick$5
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: invoke */
            public /* bridge */ /* synthetic */ kotlin.p mo1743invoke(Object obj, Integer num) {
                invoke(obj, num.intValue());
                return kotlin.p.f51048a;
            }

            public final void invoke(@Nullable Object obj, int i10) {
                if (obj instanceof FeedDetailShowMoreCommentViewModel) {
                    FeedDetailActivity.this.R2(i10, (FeedDetailShowMoreCommentViewModel) obj);
                }
            }
        })));
        N2().l().l(i0.h(kotlin.f.a(Integer.valueOf(R$id.detailCommentLayout), new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.feed.activity.FeedDetailActivity$initClick$6
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                invoke2(obj);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Object obj) {
                if (obj instanceof FeedDetailCommentViewModel) {
                    FeedDetailActivity.this.j3((FeedDetailCommentViewModel) obj);
                }
            }
        })));
    }

    public final void a3() {
        p3();
        ((TextView) y1(R$id.leaveMsgTxt)).setOnClickListener(new View.OnClickListener() { // from class: com.cupidapp.live.feed.activity.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedDetailActivity.d3(FeedDetailActivity.this, view);
            }
        });
        RelativeLayout find_him_rl = (RelativeLayout) y1(R$id.find_him_rl);
        kotlin.jvm.internal.s.h(find_him_rl, "find_him_rl");
        z0.y.d(find_him_rl, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.feed.activity.FeedDetailActivity$initFeedDetailManager$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(View view) {
                invoke2(view);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                BottomGuideModel bottomGuide;
                j.a aVar = com.cupidapp.live.base.router.j.f12156c;
                FeedDetailActivity feedDetailActivity = FeedDetailActivity.this;
                FeedModel feedModel = feedDetailActivity.f14038q;
                j.a.b(aVar, feedDetailActivity, (feedModel == null || (bottomGuide = feedModel.getBottomGuide()) == null) ? null : bottomGuide.getJumpUrl(), null, 4, null);
            }
        });
        ((TextView) y1(R$id.praiseTxt)).setOnClickListener(new View.OnClickListener() { // from class: com.cupidapp.live.feed.activity.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedDetailActivity.e3(FeedDetailActivity.this, view);
            }
        });
        ((TextView) y1(R$id.shareTxt)).setOnClickListener(new View.OnClickListener() { // from class: com.cupidapp.live.feed.activity.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedDetailActivity.b3(FeedDetailActivity.this, view);
            }
        });
        ((TextView) y1(R$id.commentTxt)).setOnClickListener(new View.OnClickListener() { // from class: com.cupidapp.live.feed.activity.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedDetailActivity.c3(FeedDetailActivity.this, view);
            }
        });
    }

    public final void f3() {
        FeedDetailAdapter N2 = N2();
        FeedSensorContext feedSensorContext = this.f14040s;
        if (feedSensorContext == null) {
            kotlin.jvm.internal.s.A("sensorContext");
            feedSensorContext = null;
        }
        N2.v(feedSensorContext, T2());
        Z2();
        ConcatAdapter.Config build = new ConcatAdapter.Config.Builder().setIsolateViewTypes(true).build();
        kotlin.jvm.internal.s.h(build, "Builder().setIsolateViewTypes(true).build()");
        ConcatAdapter concatAdapter = new ConcatAdapter(build, (RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) new RecyclerView.Adapter[]{N2(), M2()});
        TrendFeedListAdapter M2 = M2();
        int i10 = R$id.detailRecyclerView;
        RecyclerView detailRecyclerView = (RecyclerView) y1(i10);
        kotlin.jvm.internal.s.h(detailRecyclerView, "detailRecyclerView");
        TrendFeedListAdapter.E(M2, detailRecyclerView, ExposureScene.FeedDetail, null, 4, null);
        M2().x(true);
        RecyclerView recyclerView = (RecyclerView) y1(i10);
        Context context = recyclerView.getContext();
        kotlin.jvm.internal.s.h(context, "context");
        recyclerView.setLayoutManager(new CustomLayoutManager(context, 1, ScrollTo.Start, null, 8, null));
        recyclerView.setAdapter(concatAdapter);
        Context context2 = recyclerView.getContext();
        kotlin.jvm.internal.s.h(context2, "context");
        kotlin.jvm.internal.s.h(recyclerView, "this");
        this.A = new com.cupidapp.live.feed.helper.j(context2, recyclerView, V2(), W2(), N2().j(), M2().j());
        recyclerView.addOnScrollListener(O2());
    }

    public final void g3(Integer num, PostCommentModel postCommentModel) {
        String postId;
        FeedClickEventHelper feedClickEventHelper;
        User user;
        User user2;
        int intValue;
        FeedModel feedModel = this.f14038q;
        if (feedModel == null || (postId = feedModel.getPostId()) == null) {
            return;
        }
        FeedModel feedModel2 = this.f14038q;
        if (feedModel2 != null) {
            Y2(feedModel2, UserActionType.Comment);
        }
        List<Object> j10 = N2().j();
        ArrayList arrayList = new ArrayList();
        for (Object obj : j10) {
            if (obj instanceof FeedDetailNoCommentModel) {
                arrayList.add(obj);
            }
        }
        if (!arrayList.isEmpty()) {
            N2().j().removeAll(arrayList);
        }
        int i10 = -1;
        if (kotlin.jvm.internal.s.d(postCommentModel.getParent(), Boolean.FALSE)) {
            if (num != null && (intValue = num.intValue() + 1) >= 0 && intValue <= N2().j().size()) {
                N2().j().add(intValue, new FeedDetailCommentViewModel(postId, postCommentModel));
            }
        } else {
            Iterator<Object> iterator2 = N2().j().iterator2();
            int i11 = 0;
            while (true) {
                if (!iterator2.hasNext()) {
                    i11 = -1;
                    break;
                } else if (iterator2.next() instanceof FeedDetailCommentViewModel) {
                    break;
                } else {
                    i11++;
                }
            }
            if (i11 >= 0 && i11 < N2().j().size()) {
                N2().j().add(i11, new FeedDetailCommentViewModel(postId, postCommentModel));
            } else {
                Iterator<Object> iterator22 = N2().j().iterator2();
                int i12 = 0;
                while (true) {
                    if (!iterator22.hasNext()) {
                        i12 = -1;
                        break;
                    } else if (iterator22.next() instanceof FeedRcmdDivideUiModel) {
                        break;
                    } else {
                        i12++;
                    }
                }
                if (i12 >= 0) {
                    N2().c(i12, new FeedDetailCommentViewModel(postId, postCommentModel));
                } else {
                    N2().d(new FeedDetailCommentViewModel(postId, postCommentModel));
                }
            }
        }
        r2(1, true);
        N2().notifyDataSetChanged();
        FeedModel feedModel3 = this.f14038q;
        if ((feedModel3 == null || (user2 = feedModel3.getUser()) == null || !user2.getFocus()) ? false : true) {
            FeedClickEventHelper feedClickEventHelper2 = this.O;
            if (feedClickEventHelper2 != null) {
                feedClickEventHelper2.r(FeedSort.Focus);
            }
        } else {
            FeedModel feedModel4 = this.f14038q;
            if (((feedModel4 == null || (user = feedModel4.getUser()) == null || !user.getCloseFriend()) ? false : true) && (feedClickEventHelper = this.O) != null) {
                feedClickEventHelper.r(FeedSort.CloseFriend);
            }
        }
        Iterator<Object> iterator23 = N2().j().iterator2();
        int i13 = 0;
        while (true) {
            if (!iterator23.hasNext()) {
                break;
            }
            Object next = iterator23.next();
            if ((next instanceof FeedDetailPraiseListViewModel) || (next instanceof FeedDetailCommentViewModel)) {
                i10 = i13;
                break;
            }
            i13++;
        }
        if (i10 >= 0) {
            ((RecyclerView) y1(R$id.detailRecyclerView)).scrollToPosition(i10);
        }
    }

    public final void h3(final String str) {
        if (this.f14046y) {
            return;
        }
        this.f14046y = true;
        f2.a l10 = NetworkClient.f11868a.l();
        FeedModel feedModel = this.f14038q;
        Observable<Result<ListResult<FeedModel>>> O = l10.O(str, feedModel != null ? feedModel.getPostId() : null);
        final Function1<Result<? extends ListResult<FeedModel>>, kotlin.p> function1 = new Function1<Result<? extends ListResult<FeedModel>>, kotlin.p>() { // from class: com.cupidapp.live.feed.activity.FeedDetailActivity$loadRcmdData$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Result<? extends ListResult<FeedModel>> result) {
                invoke2((Result<ListResult<FeedModel>>) result);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<ListResult<FeedModel>> result) {
                FeedDetailActivity.this.f14045x = true;
            }
        };
        Observable<Result<ListResult<FeedModel>>> doOnNext = O.doOnNext(new Consumer() { // from class: com.cupidapp.live.feed.activity.q
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                FeedDetailActivity.i3(Function1.this, obj);
            }
        });
        kotlin.jvm.internal.s.h(doOnNext, "private fun loadRcmdData…    true\n        })\n    }");
        Disposable disposed = doOnNext.flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<ListResult<FeedModel>, kotlin.p>() { // from class: com.cupidapp.live.feed.activity.FeedDetailActivity$loadRcmdData$$inlined$handleByContext$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(ListResult<FeedModel> listResult) {
                m2554invoke(listResult);
                return kotlin.p.f51048a;
            }

            /* JADX WARN: Removed duplicated region for block: B:53:0x00d7  */
            /* JADX WARN: Removed duplicated region for block: B:60:0x0114  */
            /* renamed from: invoke, reason: collision with other method in class */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void m2554invoke(com.cupidapp.live.base.network.model.ListResult<com.cupidapp.live.feed.model.FeedModel> r14) {
                /*
                    Method dump skipped, instructions count: 291
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.feed.activity.FeedDetailActivity$loadRcmdData$$inlined$handleByContext$1.m2554invoke(java.lang.Object):void");
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.feed.activity.FeedDetailActivity$loadRcmdData$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                FKLoadMoreListener O2;
                kotlin.jvm.internal.s.i(it, "it");
                O2 = FeedDetailActivity.this.O2();
                O2.c(false);
                FeedDetailActivity.this.f14046y = false;
                String str2 = str;
                if (str2 == null || str2.length() == 0) {
                    FeedDetailActivity.this.u3();
                }
                return Boolean.TRUE;
            }
        }, this)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
            H(disposed);
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }

    public final void j3(final FeedDetailCommentViewModel feedDetailCommentViewModel) {
        User user;
        FeedModel feedModel = this.f14038q;
        final String postId = feedModel != null ? feedModel.getPostId() : null;
        if (postId == null || postId.length() == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        final PostCommentModel commentModel = feedDetailCommentViewModel.getCommentModel();
        FeedModel feedModel2 = this.f14038q;
        final boolean z10 = (feedModel2 == null || (user = feedModel2.getUser()) == null || !user.getMe()) ? false : true;
        boolean z11 = commentModel.getUser().getMe() && commentModel.getDeleteLastTime() != null && System.currentTimeMillis() <= commentModel.getDeleteLastTime().longValue();
        Boolean delete = commentModel.getDelete();
        if (!(delete != null ? delete.booleanValue() : false) && (z10 || z11)) {
            arrayList.add(new FKActionSheetItemModel(R$string.delete_post, null, null, null, null, new Function0<kotlin.p>() { // from class: com.cupidapp.live.feed.activity.FeedDetailActivity$longClickCommentItem$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ kotlin.p invoke() {
                    invoke2();
                    return kotlin.p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    FeedDetailActivity.this.z2(z10, postId, feedDetailCommentViewModel);
                }
            }, 30, null));
        }
        if (!commentModel.getUser().getMe()) {
            arrayList.add(new FKActionSheetItemModel(R$string.report, null, null, null, null, new Function0<kotlin.p>() { // from class: com.cupidapp.live.feed.activity.FeedDetailActivity$longClickCommentItem$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ kotlin.p invoke() {
                    invoke2();
                    return kotlin.p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    j.a.b(com.cupidapp.live.base.router.j.f12156c, this, n0.f12353a.b(PostCommentModel.this.getReportData(), SensorPosition.FeedDetail, PostCommentModel.this.getUser().userId()), null, 4, null);
                }
            }, 30, null));
        }
        FKActionSheetDialog.f12692f.a(this).f(arrayList).h();
    }

    @Override // com.cupidapp.live.feed.fragment.i
    public void k() {
        s2();
    }

    public final void l3(User user) {
        FeedModel feedModel;
        User user2;
        String value = ViewProfilePrefer.FeedDetailCommentToProfile.getValue();
        boolean me2 = user.getMe();
        SensorPosition sensorPosition = SensorPosition.Comment;
        FeedSensorContext feedSensorContext = this.f14040s;
        String str = null;
        if (feedSensorContext == null) {
            kotlin.jvm.internal.s.A("sensorContext");
            feedSensorContext = null;
        }
        SensorPosition position = feedSensorContext.getPosition();
        FeedSensorContext feedSensorContext2 = this.f14040s;
        if (feedSensorContext2 == null) {
            kotlin.jvm.internal.s.A("sensorContext");
            feedSensorContext2 = null;
        }
        ProfileSensorContext profileSensorContext = new ProfileSensorContext(value, null, me2, sensorPosition, position, feedSensorContext2.getScene());
        UserProfileActivity.a aVar = UserProfileActivity.G;
        Map<String, Object> T2 = T2();
        FeedModel feedModel2 = this.f14038q;
        if (kotlin.jvm.internal.s.d((feedModel2 == null || (user2 = feedModel2.getUser()) == null) ? null : user2.userId(), user.userId()) && (feedModel = this.f14038q) != null) {
            str = feedModel.getPostStatisticsSource();
        }
        aVar.a(this, user, profileSensorContext, (r21 & 8) != 0 ? false : true, (r21 & 16) != 0 ? null : T2, (r21 & 32) != 0 ? null : null, (r21 & 64) != 0 ? null : str, (r21 & 128) != 0 ? false : false);
    }

    public final void m3(String str) {
        Disposable disposed = a.C0836a.z(NetworkClient.f11868a.N(), str, null, null, false, null, 30, null).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<ProfileResult, kotlin.p>() { // from class: com.cupidapp.live.feed.activity.FeedDetailActivity$openUserProfile$$inlined$handleByContext$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(ProfileResult profileResult) {
                m2555invoke(profileResult);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2555invoke(ProfileResult profileResult) {
                FeedDetailActivity.this.l3(profileResult.getUser());
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
            H(disposed);
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }

    @Override // com.cupidapp.live.feed.fragment.i
    public void n0() {
        List<Object> j10 = M2().j();
        Object obj = null;
        if (j10 != null) {
            Iterator<Object> iterator2 = j10.iterator2();
            while (true) {
                if (!iterator2.hasNext()) {
                    break;
                }
                Object next = iterator2.next();
                if (next instanceof FeedModel) {
                    obj = next;
                    break;
                }
            }
        }
        if (obj == null) {
            M2().j().clear();
            M2().notifyDataSetChanged();
        }
    }

    public final void n3() {
        int findFirstVisibleItemPosition;
        RecyclerView.LayoutManager layoutManager = ((RecyclerView) y1(R$id.detailRecyclerView)).getLayoutManager();
        LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
        if (linearLayoutManager == null || (findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition()) == -1) {
            return;
        }
        this.D = findFirstVisibleItemPosition;
    }

    public final void o3() {
        FeedModel feedModel = this.f14038q;
        if ((feedModel != null ? feedModel.getCommentCount() : 0) > 0) {
            TextView textView = (TextView) y1(R$id.commentTxt);
            FeedModel feedModel2 = this.f14038q;
            textView.setText(String.valueOf(feedModel2 != null ? z0.m.e(feedModel2.getCommentCount(), this) : null));
            return;
        }
        ((TextView) y1(R$id.commentTxt)).setText(R$string.comment);
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, @Nullable Intent intent) {
        Bundle extras;
        Bundle extras2;
        super.onActivityResult(i10, i11, intent);
        if (i11 == -1 && i10 == 523) {
            Serializable serializable = (intent == null || (extras2 = intent.getExtras()) == null) ? null : extras2.getSerializable(UserData.NAME);
            User user = serializable instanceof User ? (User) serializable : null;
            boolean z10 = (intent == null || (extras = intent.getExtras()) == null) ? false : extras.getBoolean("hasInsertAtSymbol");
            FeedDetailEditTextLayout feedDetailEditTextLayout = this.H;
            if (feedDetailEditTextLayout != null) {
                feedDetailEditTextLayout.o(user != null ? user.userId() : null, user != null ? user.getName() : null, z10);
            }
        }
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_feed_detail);
        Intent intent = getIntent();
        kotlin.jvm.internal.s.h(intent, "intent");
        this.f14038q = (FeedModel) z0.g.a(intent, FeedModel.class);
        Intent intent2 = getIntent();
        kotlin.jvm.internal.s.h(intent2, "intent");
        FeedSensorContext feedSensorContext = (FeedSensorContext) z0.g.a(intent2, FeedSensorContext.class);
        this.f14039r = getIntent().getStringExtra("feedModelCallback");
        if (feedSensorContext == null) {
            finish();
            return;
        }
        this.f14040s = feedSensorContext;
        w2();
        ((FeedDetailTitleBarLayout) y1(R$id.feedDetailTitleLayout)).c(this.f14038q);
        f3();
        a3();
        this.B = new com.cupidapp.live.base.view.o(this);
        y1(R$id.blankAreaHideSoftKeyboardView).setOnTouchListener(new View.OnTouchListener() { // from class: com.cupidapp.live.feed.activity.p
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean k32;
                k32 = FeedDetailActivity.k3(FeedDetailActivity.this, view, motionEvent);
                return k32;
            }
        });
        w3();
        C2();
        j1.c.b(j1.c.f50228a, SensorPosition.FeedDetail, null, null, 4, null);
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Disposable disposable = this.C;
        if (disposable != null) {
            disposable.dispose();
        }
        com.cupidapp.live.base.view.o oVar = this.B;
        if (oVar != null) {
            oVar.d();
        }
    }

    @he.j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull UserProfileDataChangeEvent event) {
        kotlin.jvm.internal.s.i(event, "event");
        EventBus.c().r(event);
        u2(event.getUser());
        FeedListItemClickOperate feedListItemClickOperate = this.N;
        if (feedListItemClickOperate != null) {
            feedListItemClickOperate.A(event.getUser());
        }
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        com.cupidapp.live.feed.helper.j jVar = this.A;
        if (jVar != null) {
            jVar.o();
        }
        com.cupidapp.live.base.utils.o oVar = this.F;
        if (oVar != null) {
            oVar.n();
        }
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        com.cupidapp.live.feed.helper.j jVar = this.A;
        if (jVar != null) {
            jVar.k();
        }
        com.cupidapp.live.base.utils.o oVar = this.F;
        if (oVar != null) {
            oVar.m();
        }
    }

    public final void p3() {
        q3();
        s3();
        t3();
        o3();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001d, code lost:
    
        if ((r3.length() > 0) == true) goto L40;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void q3() {
        /*
            r8 = this;
            com.cupidapp.live.feed.model.FeedModel r0 = r8.f14038q
            if (r0 == 0) goto L9
            com.cupidapp.live.feed.model.BottomGuideModel r0 = r0.getBottomGuide()
            goto La
        L9:
            r0 = 0
        La:
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L20
            java.lang.String r3 = r0.getTitle()
            if (r3 == 0) goto L20
            int r3 = r3.length()
            if (r3 <= 0) goto L1c
            r3 = 1
            goto L1d
        L1c:
            r3 = 0
        L1d:
            if (r3 != r1) goto L20
            goto L21
        L20:
            r1 = 0
        L21:
            r3 = 8
            if (r1 == 0) goto L73
            int r1 = com.cupidapp.live.R$id.find_him_rl
            android.view.View r1 = r8.y1(r1)
            android.widget.RelativeLayout r1 = (android.widget.RelativeLayout) r1
            r1.setVisibility(r2)
            int r1 = com.cupidapp.live.R$id.leaveMsgTxt
            android.view.View r1 = r8.y1(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r1.setVisibility(r3)
            int r1 = com.cupidapp.live.R$id.find_him_img
            android.view.View r1 = r8.y1(r1)
            r2 = r1
            com.cupidapp.live.base.imageloader.ImageLoaderView r2 = (com.cupidapp.live.base.imageloader.ImageLoaderView) r2
            java.lang.String r1 = "find_him_img"
            kotlin.jvm.internal.s.h(r2, r1)
            com.cupidapp.live.base.network.model.ImageModel r3 = r0.getIcon()
            r4 = 0
            r5 = 0
            r6 = 6
            r7 = 0
            com.cupidapp.live.base.imageloader.ImageLoaderView.g(r2, r3, r4, r5, r6, r7)
            int r1 = com.cupidapp.live.R$id.find_him_title
            android.view.View r1 = r8.y1(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            java.lang.String r2 = r0.getTitle()
            r1.setText(r2)
            int r1 = com.cupidapp.live.R$id.find_him_subtitle
            android.view.View r1 = r8.y1(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            java.lang.String r0 = r0.getSubTitle()
            r1.setText(r0)
            goto L89
        L73:
            int r0 = com.cupidapp.live.R$id.leaveMsgTxt
            android.view.View r0 = r8.y1(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r0.setVisibility(r2)
            int r0 = com.cupidapp.live.R$id.find_him_rl
            android.view.View r0 = r8.y1(r0)
            android.widget.RelativeLayout r0 = (android.widget.RelativeLayout) r0
            r0.setVisibility(r3)
        L89:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.feed.activity.FeedDetailActivity.q3():void");
    }

    public final void r2(int i10, boolean z10) {
        Object obj;
        Iterator<Object> iterator2 = N2().j().iterator2();
        while (true) {
            if (!iterator2.hasNext()) {
                obj = null;
                break;
            } else {
                obj = iterator2.next();
                if (obj instanceof FeedModel) {
                    break;
                }
            }
        }
        FeedModel feedModel = obj instanceof FeedModel ? (FeedModel) obj : null;
        if (feedModel == null) {
            return;
        }
        if (z10) {
            feedModel.setCommentCount(feedModel.getCommentCount() + i10);
        } else {
            feedModel.setCommentCount(feedModel.getCommentCount() - i10);
        }
        N2().notifyDataSetChanged();
        o3();
    }

    public final void r3() {
        User X;
        User user;
        Object obj;
        User user2;
        FeedModel feedModel = this.f14038q;
        if (!((feedModel == null || (user2 = feedModel.getUser()) == null || !user2.getMe()) ? false : true) || (X = p1.g.f52734a.X()) == null) {
            return;
        }
        Iterator<Object> iterator2 = N2().j().iterator2();
        while (true) {
            user = null;
            if (!iterator2.hasNext()) {
                obj = null;
                break;
            } else {
                obj = iterator2.next();
                if (obj instanceof FeedDetailPraiseListViewModel) {
                    break;
                }
            }
        }
        FeedModel feedModel2 = this.f14038q;
        if (feedModel2 != null && feedModel2.getLiked()) {
            if (obj == null) {
                N2().j().add(1, new FeedDetailPraiseListViewModel(kotlin.collections.s.o(X)));
                N2().notifyDataSetChanged();
                return;
            }
            FeedDetailPraiseListViewModel feedDetailPraiseListViewModel = (FeedDetailPraiseListViewModel) obj;
            if (feedDetailPraiseListViewModel.getList().contains(X)) {
                return;
            }
            feedDetailPraiseListViewModel.getList().add(X);
            N2().notifyDataSetChanged();
            return;
        }
        if (obj != null) {
            FeedDetailPraiseListViewModel feedDetailPraiseListViewModel2 = (FeedDetailPraiseListViewModel) obj;
            Iterator<User> iterator22 = feedDetailPraiseListViewModel2.getList().iterator2();
            while (true) {
                if (!iterator22.hasNext()) {
                    break;
                }
                User next = iterator22.next();
                if (kotlin.jvm.internal.s.d(next.userId(), X.userId())) {
                    user = next;
                    break;
                }
            }
            User user3 = user;
            if (user3 != null) {
                feedDetailPraiseListViewModel2.getList().remove(user3);
                if (feedDetailPraiseListViewModel2.getList().size() == 0) {
                    N2().j().remove(obj);
                }
                N2().notifyDataSetChanged();
            }
        }
    }

    public final void s2() {
        ((RecyclerView) y1(R$id.detailRecyclerView)).addOnLayoutChangeListener(new b());
    }

    public final void s3() {
        String string;
        if (this.f14038q == null) {
            return;
        }
        int i10 = R$id.praiseTxt;
        if (((TextView) y1(i10)) == null) {
            return;
        }
        TextView textView = (TextView) y1(i10);
        FeedModel feedModel = this.f14038q;
        if ((feedModel != null ? feedModel.getLikeCount() : 0) > 0) {
            FeedModel feedModel2 = this.f14038q;
            string = feedModel2 != null ? z0.m.e(feedModel2.getLikeCount(), this) : null;
        } else {
            string = getString(R$string.click_praise);
        }
        textView.setText(string);
        FeedModel feedModel3 = this.f14038q;
        kotlin.jvm.internal.s.f(feedModel3);
        if (feedModel3.getLiked()) {
            Drawable drawable = ContextCompat.getDrawable(this, R$mipmap.icon_feed_detail_like_highlight);
            if (drawable != null) {
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            }
            ((TextView) y1(i10)).setCompoundDrawables(null, drawable, null, null);
            return;
        }
        Drawable drawable2 = ContextCompat.getDrawable(this, R$mipmap.icon_feed_detail_like);
        if (drawable2 != null) {
            drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
        }
        ((TextView) y1(i10)).setCompoundDrawables(null, drawable2, null, null);
    }

    public final void t2(final FeedModel feedModel) {
        FeedSensorContext feedSensorContext = null;
        Disposable disposed = NetworkClient.f11868a.l().D(feedModel.getPostId()).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.feed.activity.FeedDetailActivity$cancelFeedLike$$inlined$handleByContext$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                invoke2(obj);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
                FeedModel.this.cancelPraise();
                this.s3();
                this.r3();
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
            H(disposed);
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
        SensorsLogFeed sensorsLogFeed = SensorsLogFeed.f12208a;
        FeedSensorContext feedSensorContext2 = this.f14040s;
        if (feedSensorContext2 == null) {
            kotlin.jvm.internal.s.A("sensorContext");
            feedSensorContext2 = null;
        }
        SensorScene scene = feedSensorContext2.getScene();
        FeedSensorContext feedSensorContext3 = this.f14040s;
        if (feedSensorContext3 == null) {
            kotlin.jvm.internal.s.A("sensorContext");
        } else {
            feedSensorContext = feedSensorContext3;
        }
        sensorsLogFeed.n(scene, feedSensorContext.getPosition(), feedModel.getPostId(), feedModel.getUser().userId(), feedModel.getUser().getAloha(), feedModel.getStrategyId(), p1.g.f52734a.x());
    }

    public final void t3() {
        Integer feedShareCount;
        Integer feedShareCount2;
        FeedModel feedModel = this.f14038q;
        if (((feedModel == null || (feedShareCount2 = feedModel.getFeedShareCount()) == null) ? 0 : feedShareCount2.intValue()) > 0) {
            TextView textView = (TextView) y1(R$id.shareTxt);
            FeedModel feedModel2 = this.f14038q;
            textView.setText(String.valueOf((feedModel2 == null || (feedShareCount = feedModel2.getFeedShareCount()) == null) ? null : z0.m.e(feedShareCount.intValue(), this)));
            return;
        }
        ((TextView) y1(R$id.shareTxt)).setText(R$string.share);
    }

    public final void u2(User user) {
        User user2;
        List<Object> j10 = N2().j();
        ArrayList arrayList = new ArrayList();
        for (Object obj : j10) {
            if (obj instanceof FeedModel) {
                arrayList.add(obj);
            }
        }
        FeedModel feedModel = (FeedModel) CollectionsKt___CollectionsKt.V(arrayList);
        if (kotlin.jvm.internal.s.d((feedModel == null || (user2 = feedModel.getUser()) == null) ? null : user2.userId(), user.userId())) {
            feedModel.getUser().setSkipReceiveFeed(user.getSkipReceiveFeed());
            ((FeedDetailTitleBarLayout) y1(R$id.feedDetailTitleLayout)).setAlohaButtonVisible((user.getAloha() || feedModel.getUser().getMe()) ? false : true);
        }
    }

    public final void u3() {
        s2();
        ((RecyclerView) y1(R$id.detailRecyclerView)).addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.cupidapp.live.feed.activity.FeedDetailActivity$renderVideo$1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int i10) {
                kotlin.jvm.internal.s.i(recyclerView, "recyclerView");
                if (i10 == 0) {
                    com.cupidapp.live.feed.helper.j jVar = FeedDetailActivity.this.A;
                    if (jVar != null) {
                        jVar.k();
                    }
                    FeedDetailActivity.this.n3();
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NotNull RecyclerView recyclerView, int i10, int i11) {
                kotlin.jvm.internal.s.i(recyclerView, "recyclerView");
            }
        });
    }

    public final void v2(final boolean z10) {
        ((RecyclerView) y1(R$id.detailRecyclerView)).addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.cupidapp.live.feed.activity.FeedDetailActivity$checkAndInputMethodShow$1
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(@NotNull View v2, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
                com.cupidapp.live.base.view.o oVar;
                boolean U2;
                String P2;
                kotlin.jvm.internal.s.i(v2, "v");
                oVar = FeedDetailActivity.this.B;
                if (oVar != null) {
                    final FeedDetailActivity feedDetailActivity = FeedDetailActivity.this;
                    oVar.b(new Function2<Integer, Boolean, kotlin.p>() { // from class: com.cupidapp.live.feed.activity.FeedDetailActivity$checkAndInputMethodShow$1$onLayoutChange$1
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        /* renamed from: invoke */
                        public /* bridge */ /* synthetic */ kotlin.p mo1743invoke(Integer num, Boolean bool) {
                            invoke(num.intValue(), bool.booleanValue());
                            return kotlin.p.f51048a;
                        }

                        public final void invoke(int i18, boolean z11) {
                            if (z11) {
                                FeedDetailActivity.this.y1(R$id.blankAreaHideSoftKeyboardView).setVisibility(0);
                            } else {
                                FeedDetailActivity.this.y1(R$id.blankAreaHideSoftKeyboardView).setVisibility(8);
                                FeedDetailActivity.this.y2();
                            }
                        }
                    });
                }
                if (z10) {
                    FeedDetailActivity.this.y3(null, null);
                }
                U2 = FeedDetailActivity.this.U2();
                if (U2) {
                    FeedDetailActivity feedDetailActivity2 = FeedDetailActivity.this;
                    P2 = feedDetailActivity2.P2();
                    feedDetailActivity2.C3(P2);
                }
                try {
                    ((RecyclerView) FeedDetailActivity.this.y1(R$id.detailRecyclerView)).removeOnLayoutChangeListener(this);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        });
    }

    public final void v3() {
        RecyclerExposureHelper.f12092j.d(ExposureScene.Feed);
    }

    public final void w2() {
        ((FeedDetailTitleBarLayout) y1(R$id.feedDetailTitleLayout)).setListener(new c());
    }

    public final void w3() {
        com.cupidapp.live.base.utils.o c4 = com.cupidapp.live.base.utils.o.f12354i.c(this);
        this.F = c4;
        if (c4 != null) {
            c4.l(new d());
        }
    }

    public final void x2(final boolean z10, String str, final FeedDetailCommentViewModel feedDetailCommentViewModel) {
        FeedModel feedModel = this.f14038q;
        if (feedModel != null) {
            Y2(feedModel, UserActionType.DeleteComment);
            SensorsLogFeed sensorsLogFeed = SensorsLogFeed.f12208a;
            FeedSensorContext feedSensorContext = this.f14040s;
            if (feedSensorContext == null) {
                kotlin.jvm.internal.s.A("sensorContext");
                feedSensorContext = null;
            }
            SensorScene scene = feedSensorContext.getScene();
            FeedSensorContext feedSensorContext2 = this.f14040s;
            if (feedSensorContext2 == null) {
                kotlin.jvm.internal.s.A("sensorContext");
                feedSensorContext2 = null;
            }
            sensorsLogFeed.o(scene, feedSensorContext2.getPosition(), str, feedModel.getUser().userId(), Boolean.valueOf(feedModel.getUser().getAloha()), feedDetailCommentViewModel.getCommentModel().getComment(), feedModel.getStrategyId(), p1.g.f52734a.x());
        }
        Disposable disposed = NetworkClient.f11868a.l().r(str, feedDetailCommentViewModel.getCommentModel().getId()).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.feed.activity.FeedDetailActivity$deleteComment$$inlined$handle$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                invoke2(obj);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
                FeedDetailAdapter N2;
                FeedDetailAdapter N22;
                FeedDetailAdapter N23;
                FeedDetailAdapter N24;
                FeedDetailAdapter N25;
                FeedDetailAdapter N26;
                FeedDetailAdapter N27;
                int i10;
                FeedDetailAdapter N28;
                FeedDetailAdapter N29;
                FeedDetailAdapter N210;
                if (kotlin.jvm.internal.s.d(FeedDetailCommentViewModel.this.getCommentModel().getParent(), Boolean.TRUE)) {
                    N25 = this.N2();
                    int indexOf = N25.j().indexOf(FeedDetailCommentViewModel.this);
                    N26 = this.N2();
                    int size = N26.j().size();
                    if (indexOf != -1 && indexOf < size) {
                        ArrayList arrayList = new ArrayList();
                        N27 = this.N2();
                        arrayList.add(N27.j().get(indexOf));
                        for (int i11 = indexOf + 1; i11 < size; i11++) {
                            N210 = this.N2();
                            Object obj2 = N210.j().get(i11);
                            if ((obj2 instanceof FeedDetailCommentViewModel) && kotlin.jvm.internal.s.d(((FeedDetailCommentViewModel) obj2).getCommentModel().getParent(), Boolean.TRUE)) {
                                break;
                            }
                            arrayList.add(obj2);
                        }
                        if (z10) {
                            N29 = this.N2();
                            N29.j().removeAll(arrayList);
                            this.r2(arrayList.size(), false);
                        } else {
                            if (arrayList.isEmpty()) {
                                i10 = 0;
                            } else {
                                Iterator<E> iterator2 = arrayList.iterator2();
                                i10 = 0;
                                while (iterator2.hasNext()) {
                                    if ((iterator2.next() instanceof FeedDetailCommentViewModel) && (i10 = i10 + 1) < 0) {
                                        kotlin.collections.s.r();
                                    }
                                }
                            }
                            if (i10 >= 2) {
                                PostCommentModel commentModel = FeedDetailCommentViewModel.this.getCommentModel();
                                String string = this.getString(R$string.the_comment_deleted);
                                kotlin.jvm.internal.s.h(string, "getString(R.string.the_comment_deleted)");
                                commentModel.setComment(string);
                                FeedDetailCommentViewModel.this.getCommentModel().setDelete(Boolean.TRUE);
                            } else {
                                N28 = this.N2();
                                N28.j().remove(FeedDetailCommentViewModel.this);
                                this.r2(1, false);
                            }
                        }
                    }
                } else {
                    N2 = this.N2();
                    N2.j().remove(FeedDetailCommentViewModel.this);
                    this.r2(1, false);
                }
                N22 = this.N2();
                if (kotlin.collections.z.H(N22.j(), FeedDetailCommentViewModel.class).isEmpty()) {
                    N24 = this.N2();
                    N24.d(new FeedDetailNoCommentModel());
                }
                N23 = this.N2();
                N23.notifyDataSetChanged();
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
            H(disposed);
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }

    public final void x3(final FeedModel feedModel, ShareBtnPos shareBtnPos) {
        ConstantsUrlModel urlModel;
        if (feedModel == null) {
            return;
        }
        ShareBuilder d10 = com.cupidapp.live.base.share.helper.d.f12255a.d(this, feedModel, Q0(), shareBtnPos);
        ArrayList arrayList = new ArrayList();
        p1.g gVar = p1.g.f52734a;
        ConstantsResult q10 = gVar.q();
        if ((q10 == null || (urlModel = q10.getUrlModel()) == null || !urlModel.showFeedSpread()) ? false : true) {
            arrayList.add(ShareOperateType.FEED_SPREAD);
        }
        String userId = feedModel.getUser().userId();
        User X = gVar.X();
        if (kotlin.jvm.internal.s.d(userId, X != null ? X.userId() : null)) {
            arrayList.add(feedModel.getShareOperateType());
            arrayList.add(ShareOperateType.DELETE);
        } else {
            if (feedModel.getUser().getFocus()) {
                arrayList.add(ShareOperateType.UN_FOCUS);
            } else {
                arrayList.add(ShareOperateType.FOCUS);
            }
            if (feedModel.getUser().getCloseFriend()) {
                arrayList.add(ShareOperateType.UN_CLOSE_FRIEND);
            } else if (feedModel.getUser().getMatch() && feedModel.getUser().getAloha()) {
                arrayList.add(ShareOperateType.CLOSE_FRIEND);
            }
            if (feedModel.getUser().getAloha() || feedModel.getUser().getMatch()) {
                arrayList.add(!feedModel.getUser().getSkipReceiveFeed() ? ShareOperateType.DONT_LOOK_HIM : ShareOperateType.LOOK_HIM);
            }
            if (feedModel.getUser().getAloha()) {
                arrayList.add(ShareOperateType.DISLIKE_U);
            }
            arrayList.add(ShareOperateType.REPORT);
        }
        ShareBottomFragment a10 = ShareBottomFragment.f12224k.a();
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        kotlin.jvm.internal.s.h(supportFragmentManager, "supportFragmentManager");
        a10.v1(supportFragmentManager, new ShareModel(feedModel.getUser().userId(), feedModel.getPostId(), d10, FollowPrefer.FeedDetail, arrayList, SensorPosition.FeedDetail, Boolean.valueOf(feedModel.getUser().getSuperLikedByMe()), null, null, feedModel.getPostStatisticsSource(), null, 1408, null), new com.cupidapp.live.base.share.view.b() { // from class: com.cupidapp.live.feed.activity.FeedDetailActivity$showFeedMenuDialog$2
            @Override // com.cupidapp.live.base.share.view.b
            public void a(@NotNull ShareItemHandledResult result) {
                FeedSensorContext feedSensorContext;
                FeedSensorContext feedSensorContext2;
                FeedSensorContext feedSensorContext3;
                FeedSensorContext feedSensorContext4;
                FeedSensorContext feedSensorContext5;
                FeedSensorContext feedSensorContext6;
                kotlin.jvm.internal.s.i(result, "result");
                FeedSensorContext feedSensorContext7 = null;
                if (result.getState() == State.SUCCESS) {
                    ShareBaseType type = result.getType();
                    if (type == ShareOperateType.DISLIKE_U) {
                        feedModel.getUser().setFocus(false);
                        feedModel.getUser().setAloha(false);
                        feedModel.getUser().setMatch(false);
                        feedModel.getUser().setCloseFriend(false);
                        EventBus.c().o(new UserProfileDataChangeEvent(feedModel.getUser(), false));
                        return;
                    }
                    if (type == ShareOperateType.DONT_LOOK_HIM) {
                        feedModel.getUser().setSkipReceiveFeed(true);
                        com.cupidapp.live.base.view.h.f12779a.b(R$string.has_dont_look_him);
                        return;
                    }
                    if (type == ShareOperateType.LOOK_HIM) {
                        feedModel.getUser().setSkipReceiveFeed(false);
                        com.cupidapp.live.base.view.h.f12779a.b(R$string.has_cancel_dont_look);
                        return;
                    }
                    if (type == ShareOperateType.DELETE) {
                        FeedDetailActivity.this.finish();
                        return;
                    }
                    if (type == ShareOperateType.PRIVATE) {
                        FeedDetailActivity.this.finish();
                        com.cupidapp.live.base.view.g gVar2 = com.cupidapp.live.base.view.g.f12778a;
                        String string = FeedDetailActivity.this.getString(R$string.private_and_move);
                        kotlin.jvm.internal.s.h(string, "getString(R.string.private_and_move)");
                        String string2 = FeedDetailActivity.this.getString(R$string.see_right_now);
                        Integer valueOf = Integer.valueOf(R$mipmap.icon_snack_lock);
                        final FeedDetailActivity feedDetailActivity = FeedDetailActivity.this;
                        com.cupidapp.live.base.view.g.c(gVar2, new SnackbarModel(string, 0.0f, string2, 0, null, 0.0f, null, null, valueOf, 0, 0, new Function0<kotlin.p>() { // from class: com.cupidapp.live.feed.activity.FeedDetailActivity$showFeedMenuDialog$2$handled$1
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ kotlin.p invoke() {
                                invoke2();
                                return kotlin.p.f51048a;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                FeedDetailActivity.this.X2();
                            }
                        }, 1786, null), FeedDetailActivity.this.getLocalClassName(), false, 4, null);
                        return;
                    }
                    if (type == ShareOperateType.UN_PRIVATE) {
                        com.cupidapp.live.base.view.h.f12779a.l(FeedDetailActivity.this, R$string.move_out);
                        FeedDetailActivity.this.finish();
                        return;
                    }
                    if (type == ShareOperateType.FOCUS) {
                        if (result.getData() instanceof FocusResultModel) {
                            feedModel.getUser().setFocus(true);
                            feedModel.getUser().setAloha(((FocusResultModel) result.getData()).getAloha());
                            feedModel.getUser().setMatch(((FocusResultModel) result.getData()).getMatch());
                            EventBus.c().o(new UserProfileDataChangeEvent(feedModel.getUser(), false));
                        }
                        com.cupidapp.live.base.view.h.f12779a.l(FeedDetailActivity.this, R$string.focus_success);
                        GroupSocialLog groupSocialLog = GroupSocialLog.f18708a;
                        String userId2 = feedModel.getUser().userId();
                        SensorPosition sensorPosition = SensorPosition.FeedDetail;
                        feedSensorContext6 = FeedDetailActivity.this.f14040s;
                        if (feedSensorContext6 == null) {
                            kotlin.jvm.internal.s.A("sensorContext");
                        } else {
                            feedSensorContext7 = feedSensorContext6;
                        }
                        groupSocialLog.Z(userId2, sensorPosition, feedSensorContext7.getSource(), true);
                        return;
                    }
                    if (type == ShareOperateType.UN_FOCUS) {
                        if (result.getData() instanceof FocusResultModel) {
                            feedModel.getUser().setAloha(((FocusResultModel) result.getData()).getAloha());
                            feedModel.getUser().setMatch(((FocusResultModel) result.getData()).getMatch());
                        }
                        feedModel.getUser().setFocus(false);
                        EventBus.c().o(new UserProfileDataChangeEvent(feedModel.getUser(), false));
                        com.cupidapp.live.base.view.h.f12779a.l(FeedDetailActivity.this, R$string.unfocus_success);
                        GroupSocialLog groupSocialLog2 = GroupSocialLog.f18708a;
                        String userId3 = feedModel.getUser().userId();
                        SensorPosition sensorPosition2 = SensorPosition.FeedDetail;
                        feedSensorContext5 = FeedDetailActivity.this.f14040s;
                        if (feedSensorContext5 == null) {
                            kotlin.jvm.internal.s.A("sensorContext");
                        } else {
                            feedSensorContext7 = feedSensorContext5;
                        }
                        groupSocialLog2.Z(userId3, sensorPosition2, feedSensorContext7.getSource(), false);
                        return;
                    }
                    if (type == ShareOperateType.CLOSE_FRIEND) {
                        feedModel.getUser().setCloseFriend(true);
                        com.cupidapp.live.base.view.h.f12779a.l(FeedDetailActivity.this, R$string.close_friend_suc);
                        GroupSocialLog groupSocialLog3 = GroupSocialLog.f18708a;
                        String userId4 = feedModel.getUser().userId();
                        SensorPosition sensorPosition3 = SensorPosition.FeedDetail;
                        feedSensorContext4 = FeedDetailActivity.this.f14040s;
                        if (feedSensorContext4 == null) {
                            kotlin.jvm.internal.s.A("sensorContext");
                        } else {
                            feedSensorContext7 = feedSensorContext4;
                        }
                        groupSocialLog3.Y(userId4, sensorPosition3, feedSensorContext7.getSource(), true);
                        return;
                    }
                    if (type == ShareOperateType.UN_CLOSE_FRIEND) {
                        feedModel.getUser().setCloseFriend(false);
                        com.cupidapp.live.base.view.h.f12779a.l(FeedDetailActivity.this, R$string.un_close_friend_suc);
                        GroupSocialLog groupSocialLog4 = GroupSocialLog.f18708a;
                        String userId5 = feedModel.getUser().userId();
                        SensorPosition sensorPosition4 = SensorPosition.FeedDetail;
                        feedSensorContext3 = FeedDetailActivity.this.f14040s;
                        if (feedSensorContext3 == null) {
                            kotlin.jvm.internal.s.A("sensorContext");
                        } else {
                            feedSensorContext7 = feedSensorContext3;
                        }
                        groupSocialLog4.Y(userId5, sensorPosition4, feedSensorContext7.getSource(), false);
                        return;
                    }
                    return;
                }
                if (result.getState() == State.FAILURE) {
                    ShareBaseType type2 = result.getType();
                    if (type2 == ShareOperateType.FOCUS) {
                        if (result.getData() instanceof String) {
                            UserAlertDialogHelper userAlertDialogHelper = UserAlertDialogHelper.f17874a;
                            FeedDetailActivity feedDetailActivity2 = FeedDetailActivity.this;
                            feedSensorContext2 = feedDetailActivity2.f14040s;
                            if (feedSensorContext2 == null) {
                                kotlin.jvm.internal.s.A("sensorContext");
                            } else {
                                feedSensorContext7 = feedSensorContext2;
                            }
                            SensorPosition position = feedSensorContext7.getPosition();
                            String str = (String) result.getData();
                            PopupName popupName = PopupName.SPECIAL_ATTENTION_LIMIT;
                            final FeedDetailActivity feedDetailActivity3 = FeedDetailActivity.this;
                            userAlertDialogHelper.a(feedDetailActivity2, position, str, popupName, new Function0<kotlin.p>() { // from class: com.cupidapp.live.feed.activity.FeedDetailActivity$showFeedMenuDialog$2$handled$2
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ kotlin.p invoke() {
                                    invoke2();
                                    return kotlin.p.f51048a;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    FeedSensorContext feedSensorContext8;
                                    FocusUserManageActivity.a aVar = FocusUserManageActivity.f17618r;
                                    FeedDetailActivity feedDetailActivity4 = FeedDetailActivity.this;
                                    feedSensorContext8 = feedDetailActivity4.f14040s;
                                    if (feedSensorContext8 == null) {
                                        kotlin.jvm.internal.s.A("sensorContext");
                                        feedSensorContext8 = null;
                                    }
                                    aVar.a(feedDetailActivity4, feedSensorContext8);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    if (type2 == ShareOperateType.CLOSE_FRIEND && (result.getData() instanceof String)) {
                        UserAlertDialogHelper userAlertDialogHelper2 = UserAlertDialogHelper.f17874a;
                        FeedDetailActivity feedDetailActivity4 = FeedDetailActivity.this;
                        feedSensorContext = feedDetailActivity4.f14040s;
                        if (feedSensorContext == null) {
                            kotlin.jvm.internal.s.A("sensorContext");
                        } else {
                            feedSensorContext7 = feedSensorContext;
                        }
                        SensorPosition position2 = feedSensorContext7.getPosition();
                        String str2 = (String) result.getData();
                        PopupName popupName2 = PopupName.CLOSE_FRIENDS_LIMIT;
                        final FeedDetailActivity feedDetailActivity5 = FeedDetailActivity.this;
                        userAlertDialogHelper2.a(feedDetailActivity4, position2, str2, popupName2, new Function0<kotlin.p>() { // from class: com.cupidapp.live.feed.activity.FeedDetailActivity$showFeedMenuDialog$2$handled$3
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ kotlin.p invoke() {
                                invoke2();
                                return kotlin.p.f51048a;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                FeedSensorContext feedSensorContext8;
                                CloseFriendManagerActivity.a aVar = CloseFriendManagerActivity.f17591r;
                                FeedDetailActivity feedDetailActivity6 = FeedDetailActivity.this;
                                feedSensorContext8 = feedDetailActivity6.f14040s;
                                if (feedSensorContext8 == null) {
                                    kotlin.jvm.internal.s.A("sensorContext");
                                    feedSensorContext8 = null;
                                }
                                aVar.a(feedDetailActivity6, feedSensorContext8);
                            }
                        });
                    }
                }
            }

            @Override // com.cupidapp.live.base.share.view.b
            public void b(@NotNull ShareBaseType type) {
                FeedSensorContext feedSensorContext;
                FeedSensorContext feedSensorContext2;
                FeedSensorContext feedSensorContext3;
                FeedSensorContext feedSensorContext4;
                kotlin.jvm.internal.s.i(type, "type");
                if (type instanceof SharePlatform) {
                    FeedDetailActivity.this.B2(feedModel);
                    return;
                }
                FeedSensorContext feedSensorContext5 = null;
                if (type == ShareOperateType.DISLIKE_U) {
                    SensorsLogFeed sensorsLogFeed = SensorsLogFeed.f12208a;
                    feedSensorContext3 = FeedDetailActivity.this.f14040s;
                    if (feedSensorContext3 == null) {
                        kotlin.jvm.internal.s.A("sensorContext");
                        feedSensorContext3 = null;
                    }
                    SensorScene scene = feedSensorContext3.getScene();
                    String value = scene != null ? scene.getValue() : null;
                    String userId2 = feedModel.getUser().userId();
                    feedSensorContext4 = FeedDetailActivity.this.f14040s;
                    if (feedSensorContext4 == null) {
                        kotlin.jvm.internal.s.A("sensorContext");
                    } else {
                        feedSensorContext5 = feedSensorContext4;
                    }
                    sensorsLogFeed.b(value, userId2, feedSensorContext5.getPosition(), feedModel.getUser().getSuperLikedByMe());
                    return;
                }
                if (type == ShareOperateType.REPORT) {
                    j.a.b(com.cupidapp.live.base.router.j.f12156c, FeedDetailActivity.this, n0.f12353a.b(feedModel.getReportData(), SensorPosition.FeedDetail, feedModel.getUser().userId()), null, 4, null);
                    return;
                }
                if (type == ShareOperateType.DONT_LOOK_HIM) {
                    GroupSocialLog groupSocialLog = GroupSocialLog.f18708a;
                    String userId3 = feedModel.getUser().userId();
                    SensorPosition sensorPosition = SensorPosition.FeedDetail;
                    feedSensorContext2 = FeedDetailActivity.this.f14040s;
                    if (feedSensorContext2 == null) {
                        kotlin.jvm.internal.s.A("sensorContext");
                    } else {
                        feedSensorContext5 = feedSensorContext2;
                    }
                    groupSocialLog.n(userId3, sensorPosition, feedSensorContext5.getScene(), feedModel.getUser().getMatch(), feedModel.getUser().getAloha());
                    return;
                }
                if (type == ShareOperateType.LOOK_HIM) {
                    GroupSocialLog groupSocialLog2 = GroupSocialLog.f18708a;
                    String userId4 = feedModel.getUser().userId();
                    SensorPosition sensorPosition2 = SensorPosition.FeedDetail;
                    feedSensorContext = FeedDetailActivity.this.f14040s;
                    if (feedSensorContext == null) {
                        kotlin.jvm.internal.s.A("sensorContext");
                    } else {
                        feedSensorContext5 = feedSensorContext;
                    }
                    groupSocialLog2.N(userId4, sensorPosition2, feedSensorContext5.getScene(), feedModel.getUser().getMatch(), feedModel.getUser().getAloha());
                    return;
                }
                if (type == ShareOperateType.PRIVATE) {
                    SensorsLogFeed.f12208a.x(feedModel.getPostId(), SensorPosition.FeedDetail);
                } else if (type == ShareOperateType.UN_PRIVATE) {
                    SensorsLogFeed.f12208a.v(feedModel.getPostId(), SensorPosition.FeedDetail);
                }
            }
        });
    }

    @Nullable
    public View y1(int i10) {
        Map<Integer, View> map = this.P;
        View view = map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i10);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    public final void y2() {
        RecyclerView recyclerView = (RecyclerView) y1(R$id.detailRecyclerView);
        recyclerView.setFocusable(true);
        recyclerView.setFocusableInTouchMode(true);
        recyclerView.requestFocus();
    }

    public final void y3(Integer num, PostCommentModel postCommentModel) {
        FeedSensorContext feedSensorContext;
        if (this.G == null) {
            final FeedDetailEditTextLayout feedDetailEditTextLayout = new FeedDetailEditTextLayout(this);
            FeedModel feedModel = this.f14038q;
            FeedSensorContext feedSensorContext2 = this.f14040s;
            if (feedSensorContext2 == null) {
                kotlin.jvm.internal.s.A("sensorContext");
                feedSensorContext = null;
            } else {
                feedSensorContext = feedSensorContext2;
            }
            feedDetailEditTextLayout.setFeedModelAndCallback(feedModel, feedSensorContext, T2(), new Function0<kotlin.p>() { // from class: com.cupidapp.live.feed.activity.FeedDetailActivity$showInputDialog$1$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ kotlin.p invoke() {
                    invoke2();
                    return kotlin.p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    FeedDetailActivity.this.y2();
                }
            }, new Function2<Integer, PostCommentModel, kotlin.p>() { // from class: com.cupidapp.live.feed.activity.FeedDetailActivity$showInputDialog$1$2
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                /* renamed from: invoke */
                public /* bridge */ /* synthetic */ kotlin.p mo1743invoke(Integer num2, PostCommentModel postCommentModel2) {
                    invoke2(num2, postCommentModel2);
                    return kotlin.p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable Integer num2, @NotNull PostCommentModel model) {
                    kotlin.jvm.internal.s.i(model, "model");
                    FeedDetailActivity.this.g3(num2, model);
                    EditInputBottomSheetDialog editInputBottomSheetDialog = FeedDetailActivity.this.G;
                    if (editInputBottomSheetDialog != null) {
                        editInputBottomSheetDialog.dismiss();
                    }
                }
            }, new Function1<Boolean, kotlin.p>() { // from class: com.cupidapp.live.feed.activity.FeedDetailActivity$showInputDialog$1$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ kotlin.p invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return kotlin.p.f51048a;
                }

                public final void invoke(boolean z10) {
                    FeedSensorContext feedSensorContext3;
                    FeedDetailEditTextLayout.this.r();
                    AtUserActivity.f17473u.a(this, MetricsProto.MetricsEvent.PROVISIONING_TRAMPOLINE_ACTIVITY_TIME_MS, z10);
                    GroupSocialLog groupSocialLog = GroupSocialLog.f18708a;
                    feedSensorContext3 = this.f14040s;
                    if (feedSensorContext3 == null) {
                        kotlin.jvm.internal.s.A("sensorContext");
                        feedSensorContext3 = null;
                    }
                    groupSocialLog.Q(feedSensorContext3.getPosition(), z10 ? EnterWayType.WRITE : EnterWayType.CLICK);
                }
            });
            this.H = feedDetailEditTextLayout;
            EditInputBottomSheetDialog editInputBottomSheetDialog = new EditInputBottomSheetDialog(this, false, 2, null);
            this.G = editInputBottomSheetDialog;
            editInputBottomSheetDialog.setContentView(feedDetailEditTextLayout);
        }
        if (num != null && postCommentModel != null) {
            FeedDetailEditTextLayout feedDetailEditTextLayout2 = this.H;
            if (feedDetailEditTextLayout2 != null) {
                feedDetailEditTextLayout2.q(new FeedDetailClickCommentItemTagModel(num.intValue(), postCommentModel));
            }
        } else {
            FeedDetailEditTextLayout feedDetailEditTextLayout3 = this.H;
            if (feedDetailEditTextLayout3 != null) {
                feedDetailEditTextLayout3.q(null);
            }
        }
        EditInputBottomSheetDialog editInputBottomSheetDialog2 = this.G;
        if (editInputBottomSheetDialog2 != null) {
            editInputBottomSheetDialog2.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.cupidapp.live.feed.activity.k
                @Override // android.content.DialogInterface.OnShowListener
                public final void onShow(DialogInterface dialogInterface) {
                    FeedDetailActivity.z3(FeedDetailActivity.this, dialogInterface);
                }
            });
        }
        EditInputBottomSheetDialog editInputBottomSheetDialog3 = this.G;
        if (editInputBottomSheetDialog3 != null) {
            editInputBottomSheetDialog3.show();
        }
    }

    @Override // com.cupidapp.live.feed.fragment.i
    public void z(@NotNull FeedModel postModel) {
        kotlin.jvm.internal.s.i(postModel, "postModel");
        com.cupidapp.live.feed.helper.j jVar = this.A;
        if (jVar != null) {
            jVar.l(postModel);
        }
    }

    public final void z2(final boolean z10, final String str, final FeedDetailCommentViewModel feedDetailCommentViewModel) {
        if (z10 && kotlin.jvm.internal.s.d(feedDetailCommentViewModel.getCommentModel().getParent(), Boolean.TRUE)) {
            FKAlertDialog.G(FKAlertDialog.r(FKAlertDialog.w(FKAlertDialog.o(FKAlertDialog.a.c(FKAlertDialog.f12698l, this, false, 2, null), R$string.feed_author_delete_comment_confirm_again, 0, 2, null), R$string.delete, null, new Function0<kotlin.p>() { // from class: com.cupidapp.live.feed.activity.FeedDetailActivity$feedAuthorConfirmAgain$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ kotlin.p invoke() {
                    invoke2();
                    return kotlin.p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    FeedDetailActivity.this.x2(z10, str, feedDetailCommentViewModel);
                }
            }, 2, null), 0, null, 3, null), null, 1, null);
        } else {
            x2(z10, str, feedDetailCommentViewModel);
        }
    }

    @he.j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull FeedDetailOpenProfileEvent event) {
        kotlin.jvm.internal.s.i(event, "event");
        l3(event.getUser());
    }

    @he.j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull OpenProfileEvent event) {
        kotlin.jvm.internal.s.i(event, "event");
        m3(event.getUserId());
    }

    @he.j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull FeedDetailCommentLikeSuccessEvent event) {
        SensorsLogFeed.LikeCommentType likeCommentType;
        kotlin.jvm.internal.s.i(event, "event");
        FeedModel feedModel = this.f14038q;
        if (feedModel != null) {
            if (kotlin.jvm.internal.s.d(event.getCommentModel().getParent(), Boolean.TRUE)) {
                likeCommentType = SensorsLogFeed.LikeCommentType.FirstLevelComment;
            } else {
                likeCommentType = SensorsLogFeed.LikeCommentType.SecondLevelComment;
            }
            SensorsLogFeed.LikeCommentType likeCommentType2 = likeCommentType;
            SensorsLogFeed sensorsLogFeed = SensorsLogFeed.f12208a;
            String userId = feedModel.getUser().userId();
            String postId = feedModel.getPostId();
            FeedSensorContext feedSensorContext = this.f14040s;
            FeedSensorContext feedSensorContext2 = null;
            if (feedSensorContext == null) {
                kotlin.jvm.internal.s.A("sensorContext");
                feedSensorContext = null;
            }
            SensorPosition position = feedSensorContext.getPosition();
            FeedSensorContext feedSensorContext3 = this.f14040s;
            if (feedSensorContext3 == null) {
                kotlin.jvm.internal.s.A("sensorContext");
            } else {
                feedSensorContext2 = feedSensorContext3;
            }
            sensorsLogFeed.m(userId, postId, position, feedSensorContext2.getScene(), likeCommentType2, feedModel.getUser().getAloha(), feedModel.getStrategyId(), p1.g.f52734a.x());
        }
    }
}
