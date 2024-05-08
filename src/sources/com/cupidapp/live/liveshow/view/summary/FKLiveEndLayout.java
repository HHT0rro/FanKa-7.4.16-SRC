package com.cupidapp.live.liveshow.view.summary;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.network.model.SwipeCardUserLikeResult;
import com.cupidapp.live.base.recyclerview.decoration.MutableColumnDecoration;
import com.cupidapp.live.base.recyclerview.model.FKFooterViewModel;
import com.cupidapp.live.base.sensorslog.ProfileSensorContext;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.base.utils.j;
import com.cupidapp.live.base.view.BaseLayout;
import com.cupidapp.live.liveshow.activity.FKLiveForViewerActivity;
import com.cupidapp.live.liveshow.activity.FKLiveForViewerViewModel;
import com.cupidapp.live.liveshow.fragment.LiveInRoomSensorModel;
import com.cupidapp.live.liveshow.model.AnchorModel;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import com.cupidapp.live.profile.activity.UserProfileActivity;
import com.cupidapp.live.profile.event.UserProfileDataChangeEvent;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.track.group.GroupSocialLog;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.c;
import kotlin.collections.i0;
import kotlin.d;
import kotlin.f;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x2.a;
import z0.h;
import z0.y;
import z0.z;

/* compiled from: FKLiveEndLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveEndLayout extends BaseLayout {

    /* renamed from: d, reason: collision with root package name */
    public float f15939d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public b f15940e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public final Lazy f15941f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15942g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveEndLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15942g = new LinkedHashMap();
        this.f15941f = c.b(new Function0<LiveEndAdapter>() { // from class: com.cupidapp.live.liveshow.view.summary.FKLiveEndLayout$liveEndAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final LiveEndAdapter invoke() {
                final LiveEndAdapter liveEndAdapter = new LiveEndAdapter();
                final FKLiveEndLayout fKLiveEndLayout = FKLiveEndLayout.this;
                liveEndAdapter.l().j(i0.h(f.a(Integer.valueOf(R$id.avatar_imageview), new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.view.summary.FKLiveEndLayout$liveEndAdapter$2$1$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(Object obj) {
                        invoke2(obj);
                        return p.f51048a;
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:3:0x0004, code lost:
                    
                        r0 = r1.f15940e;
                     */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final void invoke2(@org.jetbrains.annotations.Nullable java.lang.Object r2) {
                        /*
                            r1 = this;
                            boolean r0 = r2 instanceof com.cupidapp.live.liveshow.model.AnchorModel
                            if (r0 == 0) goto L11
                            com.cupidapp.live.liveshow.view.summary.FKLiveEndLayout r0 = com.cupidapp.live.liveshow.view.summary.FKLiveEndLayout.this
                            com.cupidapp.live.liveshow.view.summary.b r0 = com.cupidapp.live.liveshow.view.summary.FKLiveEndLayout.g(r0)
                            if (r0 == 0) goto L11
                            com.cupidapp.live.liveshow.model.AnchorModel r2 = (com.cupidapp.live.liveshow.model.AnchorModel) r2
                            r0.a(r2)
                        L11:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.liveshow.view.summary.FKLiveEndLayout$liveEndAdapter$2$1$1.invoke2(java.lang.Object):void");
                    }
                }), f.a(Integer.valueOf(R$id.view_profile_layout), new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.view.summary.FKLiveEndLayout$liveEndAdapter$2$1$2
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
                        if (obj instanceof AnchorModel) {
                            User user = ((AnchorModel) obj).getUser();
                            UserProfileActivity.G.a(FKLiveEndLayout.this.getContext(), user, new ProfileSensorContext(null, null, user != null ? user.getMe() : false, SensorPosition.LiveEnd, SensorPosition.LiveShowRoom, SensorScene.Live), (r21 & 8) != 0 ? false : true, (r21 & 16) != 0 ? null : null, (r21 & 32) != 0 ? null : null, (r21 & 64) != 0 ? null : null, (r21 & 128) != 0 ? false : false);
                        }
                    }
                }), f.a(Integer.valueOf(R$id.match_status_layout), new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.view.summary.FKLiveEndLayout$liveEndAdapter$2$1$3
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
                        if (obj instanceof AnchorModel) {
                            FKLiveEndLayout.this.j(((AnchorModel) obj).getUser());
                            liveEndAdapter.notifyItemChanged(0);
                        }
                    }
                })));
                liveEndAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.view.summary.FKLiveEndLayout$liveEndAdapter$2$1$4
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
                        if (obj instanceof LiveShowModel) {
                            FKLiveForViewerActivity.a.b(FKLiveForViewerActivity.G, FKLiveEndLayout.this.getContext(), new FKLiveForViewerViewModel((LiveShowModel) obj, null, new LiveInRoomSensorModel("LIVE_RECOMMEND", null, SensorScene.Live, SensorPosition.LiveEnd, null, null, 48, null), true), false, 4, null);
                        }
                    }
                });
                return liveEndAdapter;
            }
        });
        k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LiveEndAdapter getLiveEndAdapter() {
        return (LiveEndAdapter) this.f15941f.getValue();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(@Nullable MotionEvent motionEvent) {
        Integer valueOf = motionEvent != null ? Integer.valueOf(motionEvent.getAction()) : null;
        if (valueOf != null && valueOf.intValue() == 0) {
            this.f15939d = motionEvent.getY();
        } else if (valueOf != null && valueOf.intValue() == 2) {
            float y10 = this.f15939d - motionEvent.getY();
            boolean canScrollVertically = ((RecyclerView) e(R$id.live_end_recyclerview)).canScrollVertically((int) y10);
            j.f12332a.a("FKLiveEndLayout", "distance: " + y10 + " canScroll: " + canScrollVertically);
            if (canScrollVertically) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Nullable
    public View e(int i10) {
        Map<Integer, View> map = this.f15942g;
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

    public final void i(@NotNull AnchorModel anchorInfo, @Nullable List<LiveShowModel> list) {
        s.i(anchorInfo, "anchorInfo");
        boolean z10 = true;
        if (getVisibility() == 0) {
            return;
        }
        setVisibility(0);
        getLiveEndAdapter().j().clear();
        getLiveEndAdapter().d(anchorInfo);
        if (list != null && !list.isEmpty()) {
            z10 = false;
        }
        if (!z10) {
            LiveEndAdapter liveEndAdapter = getLiveEndAdapter();
            String string = getContext().getString(R$string.recommended_live);
            s.h(string, "context.getString(R.string.recommended_live)");
            liveEndAdapter.d(new LiveEndTitleModel(string));
            getLiveEndAdapter().e(list);
            getLiveEndAdapter().d(new FKFooterViewModel(false, false, null, 0, 57, 0, 46, null));
        }
        getLiveEndAdapter().notifyDataSetChanged();
        j1.c.b(j1.c.f50228a, SensorPosition.LiveEnd, null, null, 6, null);
    }

    public final void j(User user) {
        if (user == null) {
            return;
        }
        if (user.getAloha()) {
            user.setAloha(false);
            user.setMatch(false);
            Disposable disposed = a.C0836a.n(NetworkClient.f11868a.N(), user.userId(), null, null, 4, null).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<SwipeCardUserLikeResult, p>() { // from class: com.cupidapp.live.liveshow.view.summary.FKLiveEndLayout$followUser$$inlined$handle$default$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(SwipeCardUserLikeResult swipeCardUserLikeResult) {
                    m2660invoke(swipeCardUserLikeResult);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m2660invoke(SwipeCardUserLikeResult swipeCardUserLikeResult) {
                }
            }), new e(new ObservableExtensionKt$handle$disposed$2(null, this)));
            if (disposed != null) {
                s.h(disposed, "disposed");
                H(disposed);
            }
            s.h(disposed, "disposed");
            return;
        }
        if (user.getAlohaGet()) {
            user.setMatch(true);
        }
        user.setAloha(true);
        Disposable disposed2 = a.C0836a.o(NetworkClient.f11868a.N(), user.userId(), null, null, null, 0, null, null, null, 254, null).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<SwipeCardUserLikeResult, p>() { // from class: com.cupidapp.live.liveshow.view.summary.FKLiveEndLayout$followUser$$inlined$handle$default$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(SwipeCardUserLikeResult swipeCardUserLikeResult) {
                m2661invoke(swipeCardUserLikeResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2661invoke(SwipeCardUserLikeResult swipeCardUserLikeResult) {
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed2 != null) {
            s.h(disposed2, "disposed");
            H(disposed2);
        }
        s.h(disposed2, "disposed");
        GroupSocialLog.f18708a.B(true, SensorScene.Live.getValue(), user.userId(), (r52 & 8) != 0 ? 1 : 0, (r52 & 16) != 0 ? null : Boolean.valueOf(user.getMatch()), (r52 & 32) != 0 ? null : null, (r52 & 64) != 0 ? false : false, (r52 & 128) != 0 ? null : null, (r52 & 256) != 0 ? null : SensorPosition.LiveEnd, (r52 & 512) != 0 ? false : false, (r52 & 1024) != 0 ? null : null, (r52 & 2048) != 0 ? null : null, (r52 & 4096) != 0 ? 0 : 0, (r52 & 8192) != 0 ? null : null, (r52 & 16384) != 0 ? false : false, (32768 & r52) != 0 ? null : null, (65536 & r52) != 0 ? null : null, (131072 & r52) != 0 ? null : null, (262144 & r52) != 0 ? null : null, (524288 & r52) != 0 ? null : null, (1048576 & r52) != 0 ? null : null, (2097152 & r52) != 0 ? null : null, (4194304 & r52) != 0 ? null : null, (r52 & 8388608) != 0 ? null : null);
    }

    public final void k() {
        z.a(this, R$layout.layout_live_end, true);
        Context context = getContext();
        s.h(context, "context");
        int i10 = R$id.live_end_close_imageview;
        ImageView live_end_close_imageview = (ImageView) e(i10);
        s.h(live_end_close_imageview, "live_end_close_imageview");
        com.cupidapp.live.base.view.s.b(context, live_end_close_imageview);
        setVisibility(8);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), getLiveEndAdapter().v());
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.cupidapp.live.liveshow.view.summary.FKLiveEndLayout$initView$manager$1$1
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int i11) {
                LiveEndAdapter liveEndAdapter;
                liveEndAdapter = FKLiveEndLayout.this.getLiveEndAdapter();
                return liveEndAdapter.u(i11);
            }
        });
        RecyclerView initView$lambda$1 = (RecyclerView) e(R$id.live_end_recyclerview);
        initView$lambda$1.setAdapter(getLiveEndAdapter());
        initView$lambda$1.setLayoutManager(gridLayoutManager);
        LiveEndAdapter liveEndAdapter = getLiveEndAdapter();
        s.h(initView$lambda$1, "initView$lambda$1");
        initView$lambda$1.addItemDecoration(new MutableColumnDecoration(liveEndAdapter, h.c(initView$lambda$1, 16.0f)));
        RecyclerView.ItemAnimator itemAnimator = initView$lambda$1.getItemAnimator();
        SimpleItemAnimator simpleItemAnimator = itemAnimator instanceof SimpleItemAnimator ? (SimpleItemAnimator) itemAnimator : null;
        if (simpleItemAnimator != null) {
            simpleItemAnimator.setSupportsChangeAnimations(false);
        }
        ImageView live_end_close_imageview2 = (ImageView) e(i10);
        s.h(live_end_close_imageview2, "live_end_close_imageview");
        y.d(live_end_close_imageview2, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.summary.FKLiveEndLayout$initView$2
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
                bVar = FKLiveEndLayout.this.f15940e;
                if (bVar != null) {
                    bVar.b();
                }
            }
        });
    }

    @Override // com.cupidapp.live.base.view.BaseLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        RecyclerView.ViewHolder findViewHolderForLayoutPosition = ((RecyclerView) e(R$id.live_end_recyclerview)).findViewHolderForLayoutPosition(0);
        LiveEndAnchorViewHolder liveEndAnchorViewHolder = findViewHolderForLayoutPosition instanceof LiveEndAnchorViewHolder ? (LiveEndAnchorViewHolder) findViewHolderForLayoutPosition : null;
        if (liveEndAnchorViewHolder != null) {
            liveEndAnchorViewHolder.u();
        }
    }

    @he.j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull UserProfileDataChangeEvent event) {
        s.i(event, "event");
        EventBus.c().r(event);
        Object obj = getLiveEndAdapter().j().get(0);
        AnchorModel anchorModel = obj instanceof AnchorModel ? (AnchorModel) obj : null;
        User user = anchorModel != null ? anchorModel.getUser() : null;
        if (user != null) {
            user.setAloha(event.getUser().getAloha());
            user.setMatch(event.getUser().getMatch());
        }
        getLiveEndAdapter().notifyItemChanged(0);
    }

    public final void setListener(@NotNull b listener) {
        s.i(listener, "listener");
        this.f15940e = listener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveEndLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15942g = new LinkedHashMap();
        this.f15941f = c.b(new Function0<LiveEndAdapter>() { // from class: com.cupidapp.live.liveshow.view.summary.FKLiveEndLayout$liveEndAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final LiveEndAdapter invoke() {
                final LiveEndAdapter liveEndAdapter = new LiveEndAdapter();
                final FKLiveEndLayout fKLiveEndLayout = FKLiveEndLayout.this;
                liveEndAdapter.l().j(i0.h(f.a(Integer.valueOf(R$id.avatar_imageview), new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.view.summary.FKLiveEndLayout$liveEndAdapter$2$1$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(Object obj) {
                        invoke2(obj);
                        return p.f51048a;
                    }

                    /* renamed from: invoke */
                    public final void invoke2(@Nullable Object obj) {
                        /*  JADX ERROR: Method code generation error
                            java.lang.NullPointerException
                            */
                        /*
                            this = this;
                            boolean r0 = r2 instanceof com.cupidapp.live.liveshow.model.AnchorModel
                            if (r0 == 0) goto L11
                            com.cupidapp.live.liveshow.view.summary.FKLiveEndLayout r0 = com.cupidapp.live.liveshow.view.summary.FKLiveEndLayout.this
                            com.cupidapp.live.liveshow.view.summary.b r0 = com.cupidapp.live.liveshow.view.summary.FKLiveEndLayout.g(r0)
                            if (r0 == 0) goto L11
                            com.cupidapp.live.liveshow.model.AnchorModel r2 = (com.cupidapp.live.liveshow.model.AnchorModel) r2
                            r0.a(r2)
                        L11:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.liveshow.view.summary.FKLiveEndLayout$liveEndAdapter$2$1$1.invoke2(java.lang.Object):void");
                    }
                }), f.a(Integer.valueOf(R$id.view_profile_layout), new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.view.summary.FKLiveEndLayout$liveEndAdapter$2$1$2
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
                        if (obj instanceof AnchorModel) {
                            User user = ((AnchorModel) obj).getUser();
                            UserProfileActivity.G.a(FKLiveEndLayout.this.getContext(), user, new ProfileSensorContext(null, null, user != null ? user.getMe() : false, SensorPosition.LiveEnd, SensorPosition.LiveShowRoom, SensorScene.Live), (r21 & 8) != 0 ? false : true, (r21 & 16) != 0 ? null : null, (r21 & 32) != 0 ? null : null, (r21 & 64) != 0 ? null : null, (r21 & 128) != 0 ? false : false);
                        }
                    }
                }), f.a(Integer.valueOf(R$id.match_status_layout), new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.view.summary.FKLiveEndLayout$liveEndAdapter$2$1$3
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
                        if (obj instanceof AnchorModel) {
                            FKLiveEndLayout.this.j(((AnchorModel) obj).getUser());
                            liveEndAdapter.notifyItemChanged(0);
                        }
                    }
                })));
                liveEndAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.view.summary.FKLiveEndLayout$liveEndAdapter$2$1$4
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
                        if (obj instanceof LiveShowModel) {
                            FKLiveForViewerActivity.a.b(FKLiveForViewerActivity.G, FKLiveEndLayout.this.getContext(), new FKLiveForViewerViewModel((LiveShowModel) obj, null, new LiveInRoomSensorModel("LIVE_RECOMMEND", null, SensorScene.Live, SensorPosition.LiveEnd, null, null, 48, null), true), false, 4, null);
                        }
                    }
                });
                return liveEndAdapter;
            }
        });
        k();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveEndLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15942g = new LinkedHashMap();
        this.f15941f = c.b(new Function0<LiveEndAdapter>() { // from class: com.cupidapp.live.liveshow.view.summary.FKLiveEndLayout$liveEndAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final LiveEndAdapter invoke() {
                final LiveEndAdapter liveEndAdapter = new LiveEndAdapter();
                final FKLiveEndLayout fKLiveEndLayout = FKLiveEndLayout.this;
                liveEndAdapter.l().j(i0.h(f.a(Integer.valueOf(R$id.avatar_imageview), new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.view.summary.FKLiveEndLayout$liveEndAdapter$2$1$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(Object obj) {
                        invoke2(obj);
                        return p.f51048a;
                    }

                    /*  JADX ERROR: Method code generation error
                        java.lang.NullPointerException
                        */
                    /* renamed from: invoke */
                    public final void invoke2(@org.jetbrains.annotations.Nullable java.lang.Object r2) {
                        /*
                            r1 = this;
                            boolean r0 = r2 instanceof com.cupidapp.live.liveshow.model.AnchorModel
                            if (r0 == 0) goto L11
                            com.cupidapp.live.liveshow.view.summary.FKLiveEndLayout r0 = com.cupidapp.live.liveshow.view.summary.FKLiveEndLayout.this
                            com.cupidapp.live.liveshow.view.summary.b r0 = com.cupidapp.live.liveshow.view.summary.FKLiveEndLayout.g(r0)
                            if (r0 == 0) goto L11
                            com.cupidapp.live.liveshow.model.AnchorModel r2 = (com.cupidapp.live.liveshow.model.AnchorModel) r2
                            r0.a(r2)
                        L11:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.liveshow.view.summary.FKLiveEndLayout$liveEndAdapter$2$1$1.invoke2(java.lang.Object):void");
                    }
                }), f.a(Integer.valueOf(R$id.view_profile_layout), new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.view.summary.FKLiveEndLayout$liveEndAdapter$2$1$2
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
                        if (obj instanceof AnchorModel) {
                            User user = ((AnchorModel) obj).getUser();
                            UserProfileActivity.G.a(FKLiveEndLayout.this.getContext(), user, new ProfileSensorContext(null, null, user != null ? user.getMe() : false, SensorPosition.LiveEnd, SensorPosition.LiveShowRoom, SensorScene.Live), (r21 & 8) != 0 ? false : true, (r21 & 16) != 0 ? null : null, (r21 & 32) != 0 ? null : null, (r21 & 64) != 0 ? null : null, (r21 & 128) != 0 ? false : false);
                        }
                    }
                }), f.a(Integer.valueOf(R$id.match_status_layout), new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.view.summary.FKLiveEndLayout$liveEndAdapter$2$1$3
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
                        if (obj instanceof AnchorModel) {
                            FKLiveEndLayout.this.j(((AnchorModel) obj).getUser());
                            liveEndAdapter.notifyItemChanged(0);
                        }
                    }
                })));
                liveEndAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.view.summary.FKLiveEndLayout$liveEndAdapter$2$1$4
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
                        if (obj instanceof LiveShowModel) {
                            FKLiveForViewerActivity.a.b(FKLiveForViewerActivity.G, FKLiveEndLayout.this.getContext(), new FKLiveForViewerViewModel((LiveShowModel) obj, null, new LiveInRoomSensorModel("LIVE_RECOMMEND", null, SensorScene.Live, SensorPosition.LiveEnd, null, null, 48, null), true), false, 4, null);
                        }
                    }
                });
                return liveEndAdapter;
            }
        });
        k();
    }
}
