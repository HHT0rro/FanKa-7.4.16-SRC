package com.cupidapp.live.ai;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.ai.adapter.AiPhotoIdentifyResultAdapter;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.imageloader.b;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.network.model.FollowPrefer;
import com.cupidapp.live.base.network.model.ProfileResult;
import com.cupidapp.live.base.network.model.SwipeCardUserLikeResult;
import com.cupidapp.live.base.network.model.ViewProfilePrefer;
import com.cupidapp.live.base.sensorslog.FKSensorContext;
import com.cupidapp.live.base.sensorslog.ProfileSensorContext;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.chat2.activity.ChatDetailActivity;
import com.cupidapp.live.chat2.model.ChatBundleData;
import com.cupidapp.live.match.model.NearbyUserProfileModel;
import com.cupidapp.live.profile.activity.UserProfileActivity;
import com.cupidapp.live.profile.event.UserProfileDataChangeEvent;
import com.cupidapp.live.profile.logic.c;
import com.cupidapp.live.superlike.view.SuperLikeDialogLayout;
import com.cupidapp.live.track.group.GroupOthersLog;
import com.cupidapp.live.track.group.GroupSocialLog;
import com.cupidapp.live.vip.wrapper.VipPurchaseEntranceType;
import he.j;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.i0;
import kotlin.d;
import kotlin.f;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x2.a;
import z0.h;
import z0.t;
import z0.u;
import z0.y;

/* compiled from: AiPhotoIdentifyResultActivity.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class AiPhotoIdentifyResultActivity extends FKBaseActivity {

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    public static final a f11641s = new a(null);

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public final AiPhotoIdentifyResultAdapter f11642q;

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f11643r = new LinkedHashMap();

    /* compiled from: AiPhotoIdentifyResultActivity.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull AiPhotoIdentifyModel model) {
            s.i(context, "context");
            s.i(model, "model");
            Intent intent = new Intent(context, (Class<?>) AiPhotoIdentifyResultActivity.class);
            intent.putExtra("PHOTO_IDENTIFY", model);
            context.startActivity(intent);
            FKBaseActivity.a.c(FKBaseActivity.f11750o, context, 0, 0, 6, null);
        }
    }

    public AiPhotoIdentifyResultActivity() {
        AiPhotoIdentifyResultAdapter aiPhotoIdentifyResultAdapter = new AiPhotoIdentifyResultAdapter();
        aiPhotoIdentifyResultAdapter.l().j(i0.h(f.a(Integer.valueOf(R$id.ai_user_info_root), new Function1<Object, p>() { // from class: com.cupidapp.live.ai.AiPhotoIdentifyResultActivity$resultAdapter$1$1
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
                if (obj instanceof NearbyUserProfileModel) {
                    AiPhotoIdentifyResultActivity.this.w1((NearbyUserProfileModel) obj);
                }
            }
        })));
        this.f11642q = aiPhotoIdentifyResultAdapter;
    }

    public final void A1(final NearbyUserProfileModel nearbyUserProfileModel) {
        SuperLikeDialogLayout.Companion companion = SuperLikeDialogLayout.f18632h;
        Lifecycle lifecycle = getLifecycle();
        String id2 = nearbyUserProfileModel.getId();
        String value = FollowPrefer.Nearby.getValue();
        VipPurchaseEntranceType vipPurchaseEntranceType = VipPurchaseEntranceType.AiIdentify;
        SensorPosition Q0 = Q0();
        s.h(lifecycle, "lifecycle");
        companion.b(this, lifecycle, id2, null, value, vipPurchaseEntranceType, (r27 & 64) != 0 ? null : null, Q0, (r27 & 256) != 0 ? 1 : 0, new Function1<SwipeCardUserLikeResult, p>() { // from class: com.cupidapp.live.ai.AiPhotoIdentifyResultActivity$superLikeUser$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(SwipeCardUserLikeResult swipeCardUserLikeResult) {
                invoke2(swipeCardUserLikeResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull SwipeCardUserLikeResult it) {
                s.i(it, "it");
                AiPhotoIdentifyResultActivity.this.u1(true, nearbyUserProfileModel, it);
            }
        }, (r27 & 1024) != 0 ? null : new Function1<SwipeCardUserLikeResult, p>() { // from class: com.cupidapp.live.ai.AiPhotoIdentifyResultActivity$superLikeUser$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(SwipeCardUserLikeResult swipeCardUserLikeResult) {
                invoke2(swipeCardUserLikeResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull SwipeCardUserLikeResult result) {
                s.i(result, "result");
                GroupSocialLog.f18708a.B(true, SensorScene.AI_FACE_IDENTITY.getValue(), NearbyUserProfileModel.this.getId(), (r52 & 8) != 0 ? 1 : 1, (r52 & 16) != 0 ? null : Boolean.valueOf(result.getUser().isAlohaMatched()), (r52 & 32) != 0 ? null : result.getRecommendContext(), (r52 & 64) != 0 ? false : false, (r52 & 128) != 0 ? null : null, (r52 & 256) != 0 ? null : this.Q0(), (r52 & 512) != 0 ? false : true, (r52 & 1024) != 0 ? null : null, (r52 & 2048) != 0 ? null : null, (r52 & 4096) != 0 ? 0 : 0, (r52 & 8192) != 0 ? null : null, (r52 & 16384) != 0 ? false : false, (32768 & r52) != 0 ? null : null, (65536 & r52) != 0 ? null : null, (131072 & r52) != 0 ? null : null, (262144 & r52) != 0 ? null : Boolean.valueOf(result.getUser().getProfileLevelIcon() != null), (524288 & r52) != 0 ? null : null, (1048576 & r52) != 0 ? null : null, (2097152 & r52) != 0 ? null : null, (4194304 & r52) != 0 ? null : null, (r52 & 8388608) != 0 ? null : null);
            }
        });
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity
    @NotNull
    public SensorPosition Q0() {
        return SensorPosition.AiIdentifyResult;
    }

    @Nullable
    public View j1(int i10) {
        Map<Integer, View> map = this.f11643r;
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

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_ai_identify_result);
        y1();
        x1();
        GroupOthersLog.d(GroupOthersLog.f18702a, Q0().getValue(), null, null, 6, null);
    }

    @j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull UserProfileDataChangeEvent event) {
        Object obj;
        s.i(event, "event");
        EventBus.c().r(event);
        Iterator<Object> iterator2 = this.f11642q.j().iterator2();
        while (true) {
            if (!iterator2.hasNext()) {
                obj = null;
                break;
            } else {
                obj = iterator2.next();
                if ((obj instanceof NearbyUserProfileModel) && s.d(((NearbyUserProfileModel) obj).getId(), event.getUser().userId())) {
                    break;
                }
            }
        }
        if (obj != null && (obj instanceof NearbyUserProfileModel)) {
            NearbyUserProfileModel nearbyUserProfileModel = (NearbyUserProfileModel) obj;
            nearbyUserProfileModel.setAloha(Boolean.valueOf(event.getUser().getAloha()));
            nearbyUserProfileModel.setAlohaGet(Boolean.valueOf(event.getUser().getAlohaGet()));
            nearbyUserProfileModel.setSuperLikedByMe(event.getUser().isSuperlikeByMe());
            nearbyUserProfileModel.setMatch(Boolean.valueOf(event.getUser().getMatch()));
        }
        NearbyUserProfileModel v12 = v1();
        if (v12 != null) {
            s1(v12);
        }
    }

    public final void s1(NearbyUserProfileModel nearbyUserProfileModel) {
        int i10;
        RelativeLayout relativeLayout = (RelativeLayout) j1(R$id.ai_identify_like_rl);
        c cVar = c.f17839a;
        if (cVar.a(nearbyUserProfileModel.getId())) {
            i10 = 8;
        } else {
            Boolean match = nearbyUserProfileModel.getMatch();
            Boolean bool = Boolean.TRUE;
            if (s.d(match, bool)) {
                ((ImageView) j1(R$id.startChatButton)).setVisibility(0);
                ((ImageView) j1(R$id.followImage)).setVisibility(8);
                ((ImageView) j1(R$id.cancelFollowButton)).setVisibility(8);
            } else if (s.d(nearbyUserProfileModel.getAloha(), bool)) {
                ((ImageView) j1(R$id.startChatButton)).setVisibility(8);
                ((ImageView) j1(R$id.followImage)).setVisibility(8);
                ((ImageView) j1(R$id.cancelFollowButton)).setVisibility(0);
            } else {
                ((ImageView) j1(R$id.cancelFollowButton)).setVisibility(8);
                ((ImageView) j1(R$id.startChatButton)).setVisibility(8);
                ((ImageView) j1(R$id.followImage)).setVisibility(0);
            }
            i10 = 0;
        }
        relativeLayout.setVisibility(i10);
        ((ImageView) j1(R$id.ai_identify_superlike)).setVisibility((cVar.a(nearbyUserProfileModel.getId()) || nearbyUserProfileModel.isNotShowSuperLikeBtn()) ? 8 : 0);
    }

    public final void t1(final NearbyUserProfileModel nearbyUserProfileModel) {
        Disposable disposed = a.C0836a.o(NetworkClient.f11868a.N(), nearbyUserProfileModel.getId(), null, null, FollowPrefer.AiGraph.getValue(), 0, null, null, null, 246, null).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<SwipeCardUserLikeResult, p>() { // from class: com.cupidapp.live.ai.AiPhotoIdentifyResultActivity$followClick$$inlined$handle$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(SwipeCardUserLikeResult swipeCardUserLikeResult) {
                m2446invoke(swipeCardUserLikeResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2446invoke(SwipeCardUserLikeResult swipeCardUserLikeResult) {
                SwipeCardUserLikeResult swipeCardUserLikeResult2 = swipeCardUserLikeResult;
                AiPhotoIdentifyResultActivity.this.u1(false, nearbyUserProfileModel, swipeCardUserLikeResult2);
                GroupSocialLog.f18708a.B(true, SensorScene.AI_FACE_IDENTITY.getValue(), nearbyUserProfileModel.getId(), (r52 & 8) != 0 ? 1 : 1, (r52 & 16) != 0 ? null : Boolean.valueOf(swipeCardUserLikeResult2.getUser().isAlohaMatched()), (r52 & 32) != 0 ? null : swipeCardUserLikeResult2.getRecommendContext(), (r52 & 64) != 0 ? false : false, (r52 & 128) != 0 ? null : null, (r52 & 256) != 0 ? null : AiPhotoIdentifyResultActivity.this.Q0(), (r52 & 512) != 0 ? false : false, (r52 & 1024) != 0 ? null : null, (r52 & 2048) != 0 ? null : null, (r52 & 4096) != 0 ? 0 : 0, (r52 & 8192) != 0 ? null : null, (r52 & 16384) != 0 ? false : false, (32768 & r52) != 0 ? null : null, (65536 & r52) != 0 ? null : null, (131072 & r52) != 0 ? null : null, (262144 & r52) != 0 ? null : Boolean.valueOf(swipeCardUserLikeResult2.getUser().getProfileLevelIcon() != null), (524288 & r52) != 0 ? null : null, (1048576 & r52) != 0 ? null : null, (2097152 & r52) != 0 ? null : null, (4194304 & r52) != 0 ? null : null, (r52 & 8388608) != 0 ? null : null);
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    public final void u1(boolean z10, NearbyUserProfileModel nearbyUserProfileModel, SwipeCardUserLikeResult swipeCardUserLikeResult) {
        nearbyUserProfileModel.setSuperLikedByMe(z10);
        nearbyUserProfileModel.setMatch(Boolean.valueOf(swipeCardUserLikeResult.getUser().getMatch()));
        nearbyUserProfileModel.setAloha(Boolean.valueOf(swipeCardUserLikeResult.getUser().getAloha()));
        s1(nearbyUserProfileModel);
    }

    public final NearbyUserProfileModel v1() {
        ViewPager2 viewPager2 = (ViewPager2) j1(R$id.ai_identify_viewpager);
        Object W = CollectionsKt___CollectionsKt.W(this.f11642q.j(), viewPager2 != null ? viewPager2.getCurrentItem() : -1);
        if (W == null || !(W instanceof NearbyUserProfileModel)) {
            return null;
        }
        return (NearbyUserProfileModel) W;
    }

    public final void w1(final NearbyUserProfileModel nearbyUserProfileModel) {
        Disposable disposed = a.C0836a.z(NetworkClient.f11868a.N(), nearbyUserProfileModel.getId(), null, null, false, null, 30, null).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<ProfileResult, p>() { // from class: com.cupidapp.live.ai.AiPhotoIdentifyResultActivity$gotoUserProfile$$inlined$handle$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(ProfileResult profileResult) {
                m2447invoke(profileResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2447invoke(ProfileResult profileResult) {
                UserProfileActivity.G.a(this, profileResult.getUser(), new ProfileSensorContext(ViewProfilePrefer.AiGraph.getValue(), null, c.f17839a.a(NearbyUserProfileModel.this.getId()), this.Q0(), null, SensorScene.AI_FACE_IDENTITY), (r21 & 8) != 0 ? false : true, (r21 & 16) != 0 ? null : null, (r21 & 32) != 0 ? null : null, (r21 & 64) != 0 ? null : null, (r21 & 128) != 0 ? false : false);
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    public final void x1() {
        ((FKTitleBarLayout) j1(R$id.ai_identify_result_title)).setLeftImageClickEvent(new Function1<View, p>() { // from class: com.cupidapp.live.ai.AiPhotoIdentifyResultActivity$initClick$1
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
                AiPhotoIdentifyResultActivity.this.onBackPressed();
            }
        });
        ImageView followImage = (ImageView) j1(R$id.followImage);
        s.h(followImage, "followImage");
        y.d(followImage, new Function1<View, p>() { // from class: com.cupidapp.live.ai.AiPhotoIdentifyResultActivity$initClick$2
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
                NearbyUserProfileModel v12;
                v12 = AiPhotoIdentifyResultActivity.this.v1();
                if (v12 != null) {
                    AiPhotoIdentifyResultActivity.this.t1(v12);
                }
            }
        });
        ImageView ai_identify_superlike = (ImageView) j1(R$id.ai_identify_superlike);
        s.h(ai_identify_superlike, "ai_identify_superlike");
        y.d(ai_identify_superlike, new Function1<View, p>() { // from class: com.cupidapp.live.ai.AiPhotoIdentifyResultActivity$initClick$3
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
                NearbyUserProfileModel v12;
                v12 = AiPhotoIdentifyResultActivity.this.v1();
                if (v12 != null) {
                    AiPhotoIdentifyResultActivity.this.A1(v12);
                }
            }
        });
        ImageView startChatButton = (ImageView) j1(R$id.startChatButton);
        s.h(startChatButton, "startChatButton");
        y.d(startChatButton, new Function1<View, p>() { // from class: com.cupidapp.live.ai.AiPhotoIdentifyResultActivity$initClick$4
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
                NearbyUserProfileModel v12;
                String id2;
                v12 = AiPhotoIdentifyResultActivity.this.v1();
                if (v12 == null || (id2 = v12.getId()) == null) {
                    return;
                }
                AiPhotoIdentifyResultActivity.this.z1(id2);
            }
        });
    }

    public final void y1() {
        List<NearbyUserProfileModel> list;
        AiPhotoIdentifyModel aiPhotoIdentifyModel = (AiPhotoIdentifyModel) getIntent().getSerializableExtra("PHOTO_IDENTIFY");
        ImageLoaderView ai_identify_local_img = (ImageLoaderView) j1(R$id.ai_identify_local_img);
        s.h(ai_identify_local_img, "ai_identify_local_img");
        ImageLoaderView.f(ai_identify_local_img, new b(false, aiPhotoIdentifyModel != null ? aiPhotoIdentifyModel.getLocalPath() : null, null, null, null, null, null, 0, 0, null, null, null, null, false, 0, 0, false, null, null, 524285, null), null, 2, null);
        int i10 = R$id.ai_identify_title;
        TextView ai_identify_title = (TextView) j1(i10);
        s.h(ai_identify_title, "ai_identify_title");
        u.a(ai_identify_title);
        TextView textView = (TextView) j1(i10);
        kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f51038a;
        String string = getString(R$string.ai_rcmd_user);
        s.h(string, "getString(R.string.ai_rcmd_user)");
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf((aiPhotoIdentifyModel == null || (list = aiPhotoIdentifyModel.getList()) == null) ? 0 : list.size());
        String format = String.format(string, Arrays.copyOf(objArr, 1));
        s.h(format, "format(format, *args)");
        textView.setText(t.a(format, -49088));
        int l10 = ((h.l(this) - h.c(this, 46.0f)) * 4) / 3;
        int i11 = R$id.ai_identify_viewpager;
        ViewPager2 ai_identify_viewpager = (ViewPager2) j1(i11);
        s.h(ai_identify_viewpager, "ai_identify_viewpager");
        y.o(ai_identify_viewpager, null, Integer.valueOf(l10), 1, null);
        ViewPager2 viewPager2 = (ViewPager2) j1(i11);
        viewPager2.setOffscreenPageLimit(2);
        View childAt = viewPager2.getChildAt(0);
        if (childAt instanceof RecyclerView) {
            RecyclerView recyclerView = (RecyclerView) childAt;
            int c4 = h.c(recyclerView, 23.0f);
            recyclerView.setPadding(c4, 0, c4, 0);
            recyclerView.setClipToPadding(false);
        }
        ((ViewPager2) j1(i11)).setAdapter(this.f11642q);
        this.f11642q.e(aiPhotoIdentifyModel != null ? aiPhotoIdentifyModel.getList() : null);
        this.f11642q.notifyDataSetChanged();
        ((ViewPager2) j1(i11)).registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: com.cupidapp.live.ai.AiPhotoIdentifyResultActivity$initView$2
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int i12) {
                AiPhotoIdentifyResultAdapter aiPhotoIdentifyResultAdapter;
                aiPhotoIdentifyResultAdapter = AiPhotoIdentifyResultActivity.this.f11642q;
                Object W = CollectionsKt___CollectionsKt.W(aiPhotoIdentifyResultAdapter.j(), i12);
                if (W == null || !(W instanceof NearbyUserProfileModel)) {
                    return;
                }
                AiPhotoIdentifyResultActivity.this.s1((NearbyUserProfileModel) W);
            }
        });
    }

    public final void z1(String str) {
        Disposable disposed = a.C0836a.z(NetworkClient.f11868a.N(), str, null, null, false, null, 30, null).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<ProfileResult, p>() { // from class: com.cupidapp.live.ai.AiPhotoIdentifyResultActivity$openChatDetail$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(ProfileResult profileResult) {
                m2448invoke(profileResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2448invoke(ProfileResult profileResult) {
                ProfileResult profileResult2 = profileResult;
                ChatDetailActivity.f13276r.a(AiPhotoIdentifyResultActivity.this, new ChatBundleData(profileResult2.getUser(), profileResult2.getUser().userId(), new FKSensorContext(AiPhotoIdentifyResultActivity.this.Q0(), SensorPosition.AiIdentify, null, SensorScene.AI_FACE_IDENTITY), null, false, false, false, false, false, 504, null));
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }
}
