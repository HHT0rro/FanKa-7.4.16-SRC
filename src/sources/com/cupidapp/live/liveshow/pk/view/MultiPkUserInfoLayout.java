package com.cupidapp.live.liveshow.pk.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.mobads.sdk.internal.ck;
import com.cupidapp.live.R$drawable;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.imageloader.RoundCornerModel;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.model.FollowPrefer;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.network.model.SwipeCardUserLikeResult;
import com.cupidapp.live.base.sensorslog.SensorsLogLiveShow;
import com.cupidapp.live.base.view.BaseLayout;
import com.cupidapp.live.base.view.animation.FKSVGAImageView;
import com.cupidapp.live.liveshow.constants.FKLiveConstantsData;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import com.cupidapp.live.liveshow.pk.model.MultiLivePkResult;
import com.cupidapp.live.liveshow.view.miniprofile.FollowActorEvent;
import com.cupidapp.live.liveshow.view.miniprofile.ShowLiveMiniProfileViewModel;
import com.cupidapp.live.profile.model.User;
import com.irisdt.client.live.LiveProtos;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x2.a;
import z0.y;
import z0.z;

/* compiled from: MultiPkUserInfoLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class MultiPkUserInfoLayout extends BaseLayout {

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public l f15228d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public User f15229e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f15230f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15231g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiPkUserInfoLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15231g = new LinkedHashMap();
        this.f15230f = true;
        s();
    }

    public static /* synthetic */ void q(MultiPkUserInfoLayout multiPkUserInfoLayout, User user, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = true;
        }
        multiPkUserInfoLayout.p(user, z10);
    }

    @Nullable
    public View e(int i10) {
        Map<Integer, View> map = this.f15231g;
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

    public final void k() {
        x2.a N = NetworkClient.f11868a.N();
        User user = this.f15229e;
        Disposable disposed = a.C0836a.o(N, user != null ? user.userId() : null, null, null, FollowPrefer.MultiPk.getValue(), 0, null, null, null, 246, null).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<SwipeCardUserLikeResult, p>() { // from class: com.cupidapp.live.liveshow.pk.view.MultiPkUserInfoLayout$alohaUser$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(SwipeCardUserLikeResult swipeCardUserLikeResult) {
                m2636invoke(swipeCardUserLikeResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2636invoke(SwipeCardUserLikeResult swipeCardUserLikeResult) {
                User user2;
                ((ImageView) MultiPkUserInfoLayout.this.e(R$id.multi_pk_aloha_img)).setVisibility(4);
                com.cupidapp.live.base.view.h hVar = com.cupidapp.live.base.view.h.f12779a;
                Context context = MultiPkUserInfoLayout.this.getContext();
                Context context2 = MultiPkUserInfoLayout.this.getContext();
                Object[] objArr = new Object[1];
                user2 = MultiPkUserInfoLayout.this.f15229e;
                objArr[0] = user2 != null ? user2.getName() : null;
                hVar.m(context, context2.getString(R$string.has_followed_others, objArr));
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    public final void l(@Nullable List<User> list) {
        int i10 = R$id.multi_pk_gift_rank_layout;
        ((FrameLayout) e(i10)).removeAllViews();
        int i11 = 0;
        if (list == null || list.isEmpty()) {
            ((FrameLayout) e(i10)).setVisibility(8);
            return;
        }
        ((FrameLayout) e(i10)).setVisibility(0);
        for (Object obj : CollectionsKt___CollectionsKt.n0(list)) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                kotlin.collections.s.s();
            }
            View r10 = r(((User) obj).getAvatarImage());
            ((FrameLayout) e(R$id.multi_pk_gift_rank_layout)).addView(r10);
            y.m(r10, null, null, Integer.valueOf(i11 * z0.h.c(this, 13.0f)), null, 11, null);
            i11 = i12;
        }
    }

    public final void m(@Nullable String str) {
        Integer valueOf;
        if (s.d(str, MultiLivePkResult.LivePkWin.getValue())) {
            valueOf = Integer.valueOf(R$mipmap.multi_pk_win);
        } else if (s.d(str, MultiLivePkResult.LivePkFailed.getValue())) {
            valueOf = Integer.valueOf(R$mipmap.multi_pk_failed);
        } else {
            valueOf = s.d(str, MultiLivePkResult.LivePkDraw.getValue()) ? Integer.valueOf(R$mipmap.multi_pk_draw) : null;
        }
        if (valueOf == null) {
            ((ImageView) e(R$id.multi_pk_result_img)).setVisibility(8);
            return;
        }
        int i10 = R$id.multi_pk_result_img;
        ((ImageView) e(i10)).setVisibility(0);
        ((ImageView) e(i10)).setImageResource(valueOf.intValue());
    }

    public final void o(@Nullable String str, @Nullable Integer num, boolean z10) {
        int i10 = R$id.gift_score_layout;
        ((LinearLayout) e(i10)).setVisibility(0);
        ((TextView) e(R$id.gift_score_txt)).setText(str == null || str.length() == 0 ? ck.f10046d : str);
        boolean z11 = str == null || str.length() == 0;
        int i11 = R$mipmap.ic_gift_none;
        if (!z11) {
            if (num != null && num.intValue() == 1) {
                i11 = R$mipmap.ic_pk_first;
            } else if (num != null && num.intValue() == 2) {
                i11 = R$mipmap.ic_pk_second;
            } else if (num != null && num.intValue() == 3) {
                i11 = R$mipmap.ic_pk_third;
            } else if (num != null && num.intValue() == 4) {
                i11 = R$mipmap.ic_pk_fourth;
            }
        }
        ((ImageView) e(R$id.gift_score_img)).setImageResource(i11);
        ((LinearLayout) e(i10)).setBackgroundResource((num != null && num.intValue() == 1) ? R$drawable.multi_pk_first_rank_bg : R$drawable.rect_cor_100_sd_7f000000);
        e(R$id.top_one_view).setVisibility((num != null && num.intValue() == 1 && z10) ? 0 : 8);
    }

    @Override // com.cupidapp.live.base.view.BaseLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ((FKSVGAImageView) e(R$id.first_blood_animation)).K();
    }

    @he.j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull FollowActorEvent event) {
        User user;
        s.i(event, "event");
        User userModel = event.getUserModel();
        String userId = userModel.userId();
        User user2 = this.f15229e;
        String str = null;
        if (s.d(userId, user2 != null ? user2.userId() : null)) {
            String userId2 = userModel.userId();
            LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
            if (liveShowModel != null && (user = liveShowModel.getUser()) != null) {
                str = user.userId();
            }
            ((ImageView) e(R$id.multi_pk_aloha_img)).setVisibility((s.d(userId2, str) || userModel.getAloha() || userModel.isMyself()) ? 4 : 0);
        }
    }

    public final void p(@NotNull User user, boolean z10) {
        User user2;
        s.i(user, "user");
        this.f15229e = user;
        this.f15230f = z10;
        ((TextView) e(R$id.multi_pk_user_name_txt)).setText(user.getName());
        String userId = user.userId();
        LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
        boolean d10 = s.d(userId, (liveShowModel == null || (user2 = liveShowModel.getUser()) == null) ? null : user2.userId());
        if (!d10 && this.f15230f) {
            int i10 = R$id.multi_pk_horn_img;
            ((ImageView) e(i10)).setVisibility(0);
            ((ImageView) e(i10)).setSelected(false);
        } else {
            ((ImageView) e(R$id.multi_pk_horn_img)).setVisibility(8);
        }
        ((ImageView) e(R$id.multi_pk_aloha_img)).setVisibility((d10 || user.getAloha() || user.isMyself()) ? 4 : 0);
        ((TextView) e(R$id.gift_score_txt)).setText(ck.f10046d);
        ((LinearLayout) e(R$id.gift_score_layout)).setVisibility(8);
    }

    public final View r(ImageModel imageModel) {
        Context context = getContext();
        s.h(context, "context");
        ImageLoaderView imageLoaderView = new ImageLoaderView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(z0.h.c(imageLoaderView, 18.0f), z0.h.c(imageLoaderView, 18.0f));
        layoutParams.gravity = 8388613;
        imageLoaderView.setLayoutParams(layoutParams);
        ImageLoaderView.g(imageLoaderView, imageModel, new com.cupidapp.live.base.imageloader.b(false, null, null, null, null, null, null, 0, 0, null, null, new RoundCornerModel(true, 0, z0.h.c(imageLoaderView, 0.5f), -1, false, false, false, false, 242, null), null, false, 0, 0, false, null, null, 522239, null), null, 4, null);
        return imageLoaderView;
    }

    public final void s() {
        z.a(this, R$layout.layout_multi_pk_user_info, true);
        TextView multi_pk_user_name_txt = (TextView) e(R$id.multi_pk_user_name_txt);
        s.h(multi_pk_user_name_txt, "multi_pk_user_name_txt");
        y.d(multi_pk_user_name_txt, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.pk.view.MultiPkUserInfoLayout$initView$1
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
                boolean z10;
                User user;
                z10 = MultiPkUserInfoLayout.this.f15230f;
                if (z10) {
                    user = MultiPkUserInfoLayout.this.f15229e;
                    if (user != null && user.isMyself()) {
                        return;
                    }
                    MultiPkUserInfoLayout.this.v();
                    return;
                }
                MultiPkUserInfoLayout.this.v();
            }
        });
        LinearLayout gift_score_layout = (LinearLayout) e(R$id.gift_score_layout);
        s.h(gift_score_layout, "gift_score_layout");
        y.d(gift_score_layout, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.pk.view.MultiPkUserInfoLayout$initView$2
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
                l lVar;
                lVar = MultiPkUserInfoLayout.this.f15228d;
                if (lVar != null) {
                    lVar.a();
                }
            }
        });
        ImageView multi_pk_aloha_img = (ImageView) e(R$id.multi_pk_aloha_img);
        s.h(multi_pk_aloha_img, "multi_pk_aloha_img");
        y.d(multi_pk_aloha_img, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.pk.view.MultiPkUserInfoLayout$initView$3
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
                MultiPkUserInfoLayout.this.k();
            }
        });
        ImageView multi_pk_horn_img = (ImageView) e(R$id.multi_pk_horn_img);
        s.h(multi_pk_horn_img, "multi_pk_horn_img");
        y.d(multi_pk_horn_img, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.pk.view.MultiPkUserInfoLayout$initView$4
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
                l lVar;
                LiveShowModel liveShowModel;
                User user;
                lVar = MultiPkUserInfoLayout.this.f15228d;
                if (lVar != null) {
                    lVar.b(!((ImageView) MultiPkUserInfoLayout.this.e(R$id.multi_pk_horn_img)).isSelected());
                }
                if (((ImageView) MultiPkUserInfoLayout.this.e(R$id.multi_pk_horn_img)).isSelected() || (liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel()) == null) {
                    return;
                }
                MultiPkUserInfoLayout multiPkUserInfoLayout = MultiPkUserInfoLayout.this;
                SensorsLogLiveShow sensorsLogLiveShow = SensorsLogLiveShow.f12212a;
                String itemId = liveShowModel.getItemId();
                String userId = liveShowModel.getUser().userId();
                LiveProtos.Type type = LiveProtos.Type.SILENCE;
                user = multiPkUserInfoLayout.f15229e;
                sensorsLogLiveShow.f(itemId, userId, type, (r13 & 8) != 0 ? null : null, (r13 & 16) != 0 ? null : user != null ? user.userId() : null);
            }
        });
        FrameLayout multi_pk_gift_rank_layout = (FrameLayout) e(R$id.multi_pk_gift_rank_layout);
        s.h(multi_pk_gift_rank_layout, "multi_pk_gift_rank_layout");
        y.d(multi_pk_gift_rank_layout, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.pk.view.MultiPkUserInfoLayout$initView$5
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
                l lVar;
                lVar = MultiPkUserInfoLayout.this.f15228d;
                if (lVar != null) {
                    lVar.a();
                }
            }
        });
        y.d(this, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.pk.view.MultiPkUserInfoLayout$initView$6
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
                boolean z10;
                l lVar;
                User user;
                z10 = MultiPkUserInfoLayout.this.f15230f;
                if (z10) {
                    user = MultiPkUserInfoLayout.this.f15229e;
                    if (user != null && user.isMyself()) {
                        return;
                    }
                    MultiPkUserInfoLayout.this.v();
                    return;
                }
                lVar = MultiPkUserInfoLayout.this.f15228d;
                if (lVar != null) {
                    lVar.c();
                }
            }
        });
    }

    public final void setPkHornSelect(boolean z10) {
        ((ImageView) e(R$id.multi_pk_horn_img)).setSelected(z10);
    }

    public final void setPkInfoListener(@NotNull l listener) {
        s.i(listener, "listener");
        this.f15228d = listener;
    }

    public final void t() {
        m(null);
        o(null, null, false);
        l(null);
    }

    public final void u() {
        int i10 = R$id.first_blood_animation;
        ((FKSVGAImageView) e(i10)).setVisibility(0);
        FKSVGAImageView first_blood_animation = (FKSVGAImageView) e(i10);
        s.h(first_blood_animation, "first_blood_animation");
        FKSVGAImageView.F(first_blood_animation, "first_blood_prompt.svga", null, new Function0<p>() { // from class: com.cupidapp.live.liveshow.pk.view.MultiPkUserInfoLayout$showFirstBloodAnimation$1
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
                ((FKSVGAImageView) MultiPkUserInfoLayout.this.e(R$id.first_blood_animation)).setVisibility(8);
            }
        }, 2, null);
    }

    public final void v() {
        User user = this.f15229e;
        if (user != null) {
            EventBus.c().l(new ShowLiveMiniProfileViewModel(user.userId(), null, null, false, false, true, 30, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiPkUserInfoLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15231g = new LinkedHashMap();
        this.f15230f = true;
        s();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiPkUserInfoLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15231g = new LinkedHashMap();
        this.f15230f = true;
        s();
    }
}
