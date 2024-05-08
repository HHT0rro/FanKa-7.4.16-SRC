package com.cupidapp.live.liveshow.view.liveinfo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.R$drawable;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.network.model.FollowPrefer;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.network.model.ListResult;
import com.cupidapp.live.base.network.model.SwipeCardUserLikeResult;
import com.cupidapp.live.base.recyclerview.helper.ExposureScene;
import com.cupidapp.live.base.recyclerview.helper.RecyclerExposureHelper;
import com.cupidapp.live.base.scrolltext.RollingTextView;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.base.sensorslog.SensorsLogLiveShow;
import com.cupidapp.live.base.view.BaseLayout;
import com.cupidapp.live.base.view.animation.FKSVGAImageView;
import com.cupidapp.live.liveshow.adapter.FKLiveAudienceListAdapter;
import com.cupidapp.live.liveshow.adapter.LiveSeatItemModel;
import com.cupidapp.live.liveshow.constants.FKLiveConstantsData;
import com.cupidapp.live.liveshow.fanclub.model.FanClubStatus;
import com.cupidapp.live.liveshow.model.AnchorGradeInfoModel;
import com.cupidapp.live.liveshow.model.AnchorInfoBorderModel;
import com.cupidapp.live.liveshow.model.HeatValuesModel;
import com.cupidapp.live.liveshow.model.LiveSeatResult;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import com.cupidapp.live.liveshow.model.LiveShowResult;
import com.cupidapp.live.liveshow.view.dialog.ShowLiveHeatCountEvent;
import com.cupidapp.live.liveshow.view.miniprofile.FollowActorEvent;
import com.cupidapp.live.liveshow.view.miniprofile.ShowLiveMiniProfileViewModel;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.track.group.GroupSocialLog;
import com.irisdt.client.live.LiveProtos;
import he.j;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.i0;
import kotlin.collections.t;
import kotlin.d;
import kotlin.f;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x2.a;
import z0.h;
import z0.m;
import z0.u;
import z0.y;
import z0.z;

/* compiled from: FKActorInfoAndAudienceLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKActorInfoAndAudienceLayout extends BaseLayout {

    /* renamed from: d */
    @Nullable
    public b f15698d;

    /* renamed from: e */
    @NotNull
    public FKLiveAudienceListAdapter f15699e;

    /* renamed from: f */
    @NotNull
    public String f15700f;

    /* renamed from: g */
    @Nullable
    public ImageModel f15701g;

    /* renamed from: h */
    @Nullable
    public String f15702h;

    /* renamed from: i */
    @NotNull
    public Map<Integer, View> f15703i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKActorInfoAndAudienceLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15703i = new LinkedHashMap();
        FKLiveAudienceListAdapter fKLiveAudienceListAdapter = new FKLiveAudienceListAdapter();
        fKLiveAudienceListAdapter.l().j(i0.h(f.a(Integer.valueOf(R$id.audienceAvatarImageView), FKActorInfoAndAudienceLayout$audienceListAdapter$1$1.INSTANCE)));
        this.f15699e = fKLiveAudienceListAdapter;
        this.f15700f = "";
        w();
    }

    public static /* synthetic */ void p(FKActorInfoAndAudienceLayout fKActorInfoAndAudienceLayout, LiveShowModel liveShowModel, String str, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str = null;
        }
        fKActorInfoAndAudienceLayout.o(liveShowModel, str);
    }

    public final void A() {
        int i10 = R$id.aloha_actor_imageview;
        ((FKSVGAImageView) e(i10)).setVisibility(0);
        ((FKSVGAImageView) e(i10)).s();
    }

    @Nullable
    public View e(int i10) {
        Map<Integer, View> map = this.f15703i;
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

    @NotNull
    public final String getWatchPeakCount() {
        return this.f15700f;
    }

    public final void k(@Nullable List<LiveSeatResult> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        List<LiveSeatItemModel> v2 = v(list);
        List<Object> j10 = this.f15699e.j();
        ArrayList arrayList = new ArrayList();
        for (Object obj : j10) {
            if (obj instanceof LiveSeatItemModel) {
                arrayList.add(obj);
            }
        }
        if (s.d(arrayList, v2)) {
            return;
        }
        this.f15699e.j().clear();
        this.f15699e.e(v2);
        this.f15699e.notifyDataSetChanged();
    }

    public final void l() {
        ImageLoaderView actorUserAvatarImageView = (ImageLoaderView) e(R$id.actorUserAvatarImageView);
        s.h(actorUserAvatarImageView, "actorUserAvatarImageView");
        y.d(actorUserAvatarImageView, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.liveinfo.FKActorInfoAndAudienceLayout$bindClickEvent$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(View view) {
                invoke2(view);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                LiveShowModel liveShowModel;
                FKLiveConstantsData fKLiveConstantsData = FKLiveConstantsData.INSTANCE;
                LiveShowModel liveShowModel2 = fKLiveConstantsData.getLiveShowModel();
                if ((liveShowModel2 != null && liveShowModel2.getMine()) || (liveShowModel = fKLiveConstantsData.getLiveShowModel()) == null) {
                    return;
                }
                GroupSocialLog.f18708a.u(SensorScene.Live.getValue(), liveShowModel.getUser().userId(), (r13 & 4) != 0 ? null : null, (r13 & 8) != 0 ? false : false, (r13 & 16) != 0 ? null : null);
                EventBus.c().l(new ShowLiveMiniProfileViewModel(liveShowModel.getUser().userId(), null, null, false, true, true, 14, null));
            }
        });
        FKSVGAImageView aloha_actor_imageview = (FKSVGAImageView) e(R$id.aloha_actor_imageview);
        s.h(aloha_actor_imageview, "aloha_actor_imageview");
        y.d(aloha_actor_imageview, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.liveinfo.FKActorInfoAndAudienceLayout$bindClickEvent$2
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
                FKActorInfoAndAudienceLayout.this.u();
            }
        });
        ImageView fan_club_imageview = (ImageView) e(R$id.fan_club_imageview);
        s.h(fan_club_imageview, "fan_club_imageview");
        y.d(fan_club_imageview, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.liveinfo.FKActorInfoAndAudienceLayout$bindClickEvent$3
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
                b bVar;
                String str;
                bVar = FKActorInfoAndAudienceLayout.this.f15698d;
                if (bVar != null) {
                    bVar.c();
                }
                LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
                if (liveShowModel != null) {
                    FKActorInfoAndAudienceLayout fKActorInfoAndAudienceLayout = FKActorInfoAndAudienceLayout.this;
                    SensorsLogLiveShow sensorsLogLiveShow = SensorsLogLiveShow.f12212a;
                    String itemId = liveShowModel.getItemId();
                    String userId = liveShowModel.getUser().userId();
                    LiveProtos.Type type = LiveProtos.Type.TOP_FANS_GROUP;
                    str = fKActorInfoAndAudienceLayout.f15702h;
                    sensorsLogLiveShow.f(itemId, userId, type, (r13 & 8) != 0 ? null : str, (r13 & 16) != 0 ? null : null);
                }
            }
        });
    }

    public final void m(@Nullable AnchorGradeInfoModel anchorGradeInfoModel) {
        if (anchorGradeInfoModel == null) {
            return;
        }
        if (anchorGradeInfoModel.getAvatarBadge() != null) {
            int i10 = R$id.avatarBorderImageView;
            ((ImageLoaderView) e(i10)).setVisibility(0);
            if (s.d(anchorGradeInfoModel.getAvatarBadge(), this.f15701g)) {
                return;
            }
            this.f15701g = anchorGradeInfoModel.getAvatarBadge();
            ImageLoaderView avatarBorderImageView = (ImageLoaderView) e(i10);
            s.h(avatarBorderImageView, "avatarBorderImageView");
            ImageLoaderView.g(avatarBorderImageView, anchorGradeInfoModel.getAvatarBadge(), null, null, 6, null);
            return;
        }
        ((ImageLoaderView) e(R$id.avatarBorderImageView)).setVisibility(4);
    }

    public final void o(@NotNull LiveShowModel liveShow, @Nullable String str) {
        s.i(liveShow, "liveShow");
        this.f15702h = str;
        User user = liveShow.getUser();
        ImageLoaderView actorUserAvatarImageView = (ImageLoaderView) e(R$id.actorUserAvatarImageView);
        s.h(actorUserAvatarImageView, "actorUserAvatarImageView");
        ImageLoaderView.g(actorUserAvatarImageView, user.getAvatarImage(), null, null, 6, null);
        ((TextView) e(R$id.actorUserNameTextView)).setText(user.getName());
        y(liveShow.getViewerCount());
        setFollowView(user);
    }

    @j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull FollowActorEvent event) {
        User user;
        s.i(event, "event");
        String userId = event.getUserModel().userId();
        LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
        if (s.d(userId, (liveShowModel == null || (user = liveShowModel.getUser()) == null) ? null : user.userId())) {
            setFollowView(event.getUserModel());
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(@Nullable MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public final void q(@Nullable AnchorInfoBorderModel anchorInfoBorderModel) {
        if (anchorInfoBorderModel == null) {
            ((RelativeLayout) e(R$id.actorInfoContainerLayout)).setBackgroundResource(R$drawable.shape_actor_info_bg);
            return;
        }
        int i10 = R$id.star_challenge_left_top_img;
        ((ImageLoaderView) e(i10)).setVisibility(0);
        ImageLoaderView star_challenge_left_top_img = (ImageLoaderView) e(i10);
        s.h(star_challenge_left_top_img, "star_challenge_left_top_img");
        ImageLoaderView.g(star_challenge_left_top_img, anchorInfoBorderModel.getLeftTopImage(), null, null, 6, null);
        int i11 = R$id.star_challenge_right_bottom_img;
        ((ImageLoaderView) e(i11)).setVisibility(0);
        ImageLoaderView star_challenge_right_bottom_img = (ImageLoaderView) e(i11);
        s.h(star_challenge_right_bottom_img, "star_challenge_right_bottom_img");
        ImageLoaderView.g(star_challenge_right_bottom_img, anchorInfoBorderModel.getRightBottomImage(), null, null, 6, null);
        float c4 = h.c(this, 100.0f);
        List m10 = kotlin.collections.s.m(Integer.valueOf(com.cupidapp.live.base.utils.h.b(anchorInfoBorderModel.getStartBackgroundColor())), Integer.valueOf(com.cupidapp.live.base.utils.h.b(anchorInfoBorderModel.getEndBackgroundColor())));
        RelativeLayout actorInfoContainerLayout = (RelativeLayout) e(R$id.actorInfoContainerLayout);
        s.h(actorInfoContainerLayout, "actorInfoContainerLayout");
        y.h(actorInfoContainerLayout, c4, c4, c4, c4, m10, anchorInfoBorderModel.getGradientOrientation(), Integer.valueOf(h.c(this, 1.0f)), Integer.valueOf(com.cupidapp.live.base.utils.h.b(anchorInfoBorderModel.getBorderColor())));
    }

    public final void r() {
        LiveShowResult fkLiveShowResult = FKLiveConstantsData.INSTANCE.getFkLiveShowResult();
        if (fkLiveShowResult != null && fkLiveShowResult.getMemberInClubStatus() == FanClubStatus.HasJoined.getStatus()) {
            ((ImageView) e(R$id.fan_club_imageview)).setVisibility(8);
        } else if (((FKSVGAImageView) e(R$id.aloha_actor_imageview)).getVisibility() != 0) {
            ((ImageView) e(R$id.fan_club_imageview)).setVisibility(0);
        }
    }

    public final void s(@Nullable final HeatValuesModel heatValuesModel) {
        int total = heatValuesModel != null ? heatValuesModel.getTotal() : 0;
        boolean z10 = true;
        if (total > 10000000) {
            RollingTextView rollingTextView = (RollingTextView) e(R$id.liveHeatCountTextView);
            Context context = getContext();
            s.h(context, "context");
            rollingTextView.setText(m.e(total, context), false);
        } else {
            ((RollingTextView) e(R$id.liveHeatCountTextView)).setText(m.a(heatValuesModel != null ? heatValuesModel.getTotal() : 0), true);
        }
        RelativeLayout actorUserInfoLayout = (RelativeLayout) e(R$id.actorUserInfoLayout);
        s.h(actorUserInfoLayout, "actorUserInfoLayout");
        y.d(actorUserInfoLayout, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.liveinfo.FKActorInfoAndAudienceLayout$configHeatValues$1
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
                EventBus.c().l(new ShowLiveHeatCountEvent(HeatValuesModel.this, true));
            }
        });
        String increment = heatValuesModel != null ? heatValuesModel.getIncrement() : null;
        if (increment != null && increment.length() != 0) {
            z10 = false;
        }
        if (z10) {
            ((TextView) e(R$id.increment_hot_txt)).setVisibility(4);
        } else {
            int i10 = R$id.increment_hot_txt;
            ((TextView) e(i10)).setText(heatValuesModel != null ? heatValuesModel.getIncrement() : null);
            ((TextView) e(i10)).setVisibility(0);
            LiveHotIncrementAnimHelper liveHotIncrementAnimHelper = LiveHotIncrementAnimHelper.f15723a;
            TextView increment_hot_txt = (TextView) e(i10);
            s.h(increment_hot_txt, "increment_hot_txt");
            liveHotIncrementAnimHelper.j(increment_hot_txt);
        }
        EventBus.c().l(new ShowLiveHeatCountEvent(heatValuesModel, false));
    }

    public final void setFollowView(@NotNull User user) {
        s.i(user, "user");
        if (user.getMe()) {
            x();
            ((ImageView) e(R$id.fan_club_imageview)).setVisibility(8);
        } else if (user.getAloha()) {
            x();
            r();
        } else {
            ((ImageView) e(R$id.fan_club_imageview)).setVisibility(8);
            A();
        }
    }

    public final void setListener(@NotNull b listener) {
        s.i(listener, "listener");
        this.f15698d = listener;
    }

    public final void t() {
        String itemId;
        LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
        if (liveShowModel == null || (itemId = liveShowModel.getItemId()) == null) {
            return;
        }
        Disposable disposed = NetworkClient.f11868a.r().e(itemId).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<ListResult<LiveSeatResult>, p>() { // from class: com.cupidapp.live.liveshow.view.liveinfo.FKActorInfoAndAudienceLayout$configLiveShowAudienceView$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(ListResult<LiveSeatResult> listResult) {
                m2650invoke(listResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2650invoke(ListResult<LiveSeatResult> listResult) {
                FKLiveAudienceListAdapter fKLiveAudienceListAdapter;
                FKLiveAudienceListAdapter fKLiveAudienceListAdapter2;
                List<? extends Object> v2;
                FKLiveAudienceListAdapter fKLiveAudienceListAdapter3;
                List<LiveSeatResult> list = listResult.getList();
                if (list != null) {
                    fKLiveAudienceListAdapter = FKActorInfoAndAudienceLayout.this.f15699e;
                    fKLiveAudienceListAdapter.j().clear();
                    fKLiveAudienceListAdapter2 = FKActorInfoAndAudienceLayout.this.f15699e;
                    v2 = FKActorInfoAndAudienceLayout.this.v(list);
                    fKLiveAudienceListAdapter2.e(v2);
                    fKLiveAudienceListAdapter3 = FKActorInfoAndAudienceLayout.this.f15699e;
                    fKLiveAudienceListAdapter3.notifyDataSetChanged();
                }
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    public final void u() {
        FKLiveConstantsData fKLiveConstantsData = FKLiveConstantsData.INSTANCE;
        LiveShowModel liveShowModel = fKLiveConstantsData.getLiveShowModel();
        if (liveShowModel == null) {
            return;
        }
        final String userId = liveShowModel.getUser().userId();
        x2.a N = NetworkClient.f11868a.N();
        LiveShowModel liveShowModel2 = fKLiveConstantsData.getLiveShowModel();
        Disposable disposed = a.C0836a.o(N, userId, null, liveShowModel2 != null ? liveShowModel2.getItemId() : null, FollowPrefer.LiveShow.getValue(), 0, null, null, null, 242, null).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<SwipeCardUserLikeResult, p>() { // from class: com.cupidapp.live.liveshow.view.liveinfo.FKActorInfoAndAudienceLayout$followActor$$inlined$handle$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(SwipeCardUserLikeResult swipeCardUserLikeResult) {
                m2651invoke(swipeCardUserLikeResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2651invoke(SwipeCardUserLikeResult swipeCardUserLikeResult) {
                SwipeCardUserLikeResult swipeCardUserLikeResult2 = swipeCardUserLikeResult;
                LiveShowModel liveShowModel3 = FKLiveConstantsData.INSTANCE.getLiveShowModel();
                User user = liveShowModel3 != null ? liveShowModel3.getUser() : null;
                if (user != null) {
                    user.setAloha(true);
                }
                com.cupidapp.live.base.view.h.f12779a.c(FKActorInfoAndAudienceLayout.this.getContext(), R$string.follow_success);
                FKActorInfoAndAudienceLayout.this.setFollowView(swipeCardUserLikeResult2.getUser());
                GroupSocialLog.f18708a.B(true, SensorScene.Live.getValue(), userId, (r52 & 8) != 0 ? 1 : 1, (r52 & 16) != 0 ? null : Boolean.valueOf(swipeCardUserLikeResult2.getUser().isAlohaMatched()), (r52 & 32) != 0 ? null : swipeCardUserLikeResult2.getRecommendContext(), (r52 & 64) != 0 ? false : false, (r52 & 128) != 0 ? null : null, (r52 & 256) != 0 ? null : null, (r52 & 512) != 0 ? false : false, (r52 & 1024) != 0 ? null : null, (r52 & 2048) != 0 ? null : null, (r52 & 4096) != 0 ? 0 : 0, (r52 & 8192) != 0 ? null : null, (r52 & 16384) != 0 ? false : false, (32768 & r52) != 0 ? null : null, (65536 & r52) != 0 ? null : null, (131072 & r52) != 0 ? null : null, (262144 & r52) != 0 ? null : null, (524288 & r52) != 0 ? null : null, (1048576 & r52) != 0 ? null : null, (2097152 & r52) != 0 ? null : null, (4194304 & r52) != 0 ? null : null, (r52 & 8388608) != 0 ? null : null);
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
        SensorsLogLiveShow.f12212a.f(liveShowModel.getItemId(), userId, LiveProtos.Type.FOLLOW, (r13 & 8) != 0 ? null : this.f15702h, (r13 & 16) != 0 ? null : null);
    }

    public final List<LiveSeatItemModel> v(List<LiveSeatResult> list) {
        ArrayList arrayList = new ArrayList(t.t(list, 10));
        for (LiveSeatResult liveSeatResult : list) {
            arrayList.add(new LiveSeatItemModel(liveSeatResult.getUser().userId(), liveSeatResult.getUser().getAvatarImage(), liveSeatResult.getConsumption(), liveSeatResult.getIconImage()));
        }
        return arrayList;
    }

    public final void w() {
        z.a(this, R$layout.layout_actor_info_and_audience, true);
        ((TextView) e(R$id.actorUserNameTextView)).getPaint().setFakeBoldText(true);
        TextView increment_hot_txt = (TextView) e(R$id.increment_hot_txt);
        s.h(increment_hot_txt, "increment_hot_txt");
        u.a(increment_hot_txt);
        int i10 = R$id.liveShowAudienceRecyclerView;
        ((RecyclerView) e(i10)).setAdapter(this.f15699e);
        FKLiveAudienceListAdapter fKLiveAudienceListAdapter = this.f15699e;
        ExposureScene exposureScene = ExposureScene.LiveWatcherList;
        RecyclerView liveShowAudienceRecyclerView = (RecyclerView) e(i10);
        s.h(liveShowAudienceRecyclerView, "liveShowAudienceRecyclerView");
        fKLiveAudienceListAdapter.t(new RecyclerExposureHelper(exposureScene, liveShowAudienceRecyclerView, 0.0f, 0L, null, new Function1<List<? extends h1.a>, p>() { // from class: com.cupidapp.live.liveshow.view.liveinfo.FKActorInfoAndAudienceLayout$initView$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(List<? extends h1.a> list) {
                invoke2((List<h1.a>) list);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull List<h1.a> itemList) {
                s.i(itemList, "itemList");
                Iterator<h1.a> iterator2 = itemList.iterator2();
                while (iterator2.hasNext()) {
                    Object a10 = iterator2.next().a();
                    if (a10 instanceof LiveSeatItemModel) {
                        GroupSocialLog.f18708a.w(SensorScene.Live.getValue(), ((LiveSeatItemModel) a10).getUserId(), (r29 & 4) != 0 ? null : null, (r29 & 8) != 0 ? false : false, (r29 & 16) != 0 ? null : null, (r29 & 32) != 0 ? 0 : 0, (r29 & 64) != 0 ? null : null, (r29 & 128) != 0 ? null : null, (r29 & 256) != 0 ? false : false, (r29 & 512) != 0 ? false : false, (r29 & 1024) != 0 ? false : false, (r29 & 2048) != 0 ? false : false);
                    }
                }
            }
        }, 28, null));
        int i11 = R$id.liveHeatCountTextView;
        ((RollingTextView) e(i11)).setAnimationDuration(400L);
        ((RollingTextView) e(i11)).g("0123456789");
        l();
    }

    public final void x() {
        int i10 = R$id.aloha_actor_imageview;
        ((FKSVGAImageView) e(i10)).p();
        ((FKSVGAImageView) e(i10)).setVisibility(8);
    }

    public final void y(@Nullable String str) {
        if ((str == null || str.length() == 0) || str.compareTo(this.f15700f) <= 0) {
            return;
        }
        this.f15700f = str;
    }

    public final void z(@Nullable String str) {
        if (str == null) {
            return;
        }
        List<Object> j10 = this.f15699e.j();
        ArrayList arrayList = new ArrayList();
        for (Object obj : j10) {
            if (obj instanceof LiveSeatItemModel) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (s.d(((LiveSeatItemModel) obj2).getUserId(), str)) {
                arrayList2.add(obj2);
            }
        }
        this.f15699e.j().removeAll(arrayList2);
        this.f15699e.notifyDataSetChanged();
    }

    @j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull JoinedFanClubEvent event) {
        s.i(event, "event");
        LiveShowResult fkLiveShowResult = FKLiveConstantsData.INSTANCE.getFkLiveShowResult();
        if (fkLiveShowResult != null) {
            fkLiveShowResult.setMemberInClubStatus(event.getStatus().getStatus());
        }
        r();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKActorInfoAndAudienceLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15703i = new LinkedHashMap();
        FKLiveAudienceListAdapter fKLiveAudienceListAdapter = new FKLiveAudienceListAdapter();
        fKLiveAudienceListAdapter.l().j(i0.h(f.a(Integer.valueOf(R$id.audienceAvatarImageView), FKActorInfoAndAudienceLayout$audienceListAdapter$1$1.INSTANCE)));
        this.f15699e = fKLiveAudienceListAdapter;
        this.f15700f = "";
        w();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKActorInfoAndAudienceLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15703i = new LinkedHashMap();
        FKLiveAudienceListAdapter fKLiveAudienceListAdapter = new FKLiveAudienceListAdapter();
        fKLiveAudienceListAdapter.l().j(i0.h(f.a(Integer.valueOf(R$id.audienceAvatarImageView), FKActorInfoAndAudienceLayout$audienceListAdapter$1$1.INSTANCE)));
        this.f15699e = fKLiveAudienceListAdapter;
        this.f15700f = "";
        w();
    }
}
