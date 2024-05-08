package com.cupidapp.live.feed.layout;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.cupidapp.live.R$color;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.base.sensorslog.SensorsLogLiveShow;
import com.cupidapp.live.base.view.animation.FKLottieAnimationView;
import com.cupidapp.live.base.view.animation.a;
import com.cupidapp.live.liveshow.constants.FKLiveType;
import com.cupidapp.live.liveshow.model.LiveCoverTagModel;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import com.cupidapp.live.liveshow.model.RedEnvelopeTagModel;
import com.irisdt.client.live.LiveProtos;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function1;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: FeedTopRcmdLiveLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FeedTopRcmdLiveLayout extends LinearLayout {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public List<LiveShowModel> f14494b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public FKLottieAnimationView f14495c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f14496d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public Disposable f14497e;

    /* renamed from: f, reason: collision with root package name */
    public int f14498f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f14499g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f14500h = new LinkedHashMap();

    public FeedTopRcmdLiveLayout(@Nullable Context context) {
        super(context);
        this.f14496d = true;
    }

    public static final boolean k(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(obj)).booleanValue();
    }

    public static final void l(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void j(@Nullable List<LiveShowModel> list, @NotNull final Function1<? super LiveShowModel, kotlin.p> itemClick) {
        kotlin.jvm.internal.s.i(itemClick, "itemClick");
        this.f14494b = list;
        Disposable disposable = this.f14497e;
        if (disposable != null) {
            disposable.dispose();
        }
        this.f14499g = false;
        FKLottieAnimationView fKLottieAnimationView = this.f14495c;
        if (fKLottieAnimationView != null) {
            fKLottieAnimationView.M();
        }
        FKLottieAnimationView fKLottieAnimationView2 = this.f14495c;
        if (fKLottieAnimationView2 != null) {
            fKLottieAnimationView2.J();
        }
        ImageModel imageModel = null;
        this.f14495c = null;
        this.f14497e = null;
        this.f14498f = 0;
        removeAllViews();
        if (list != null) {
            int i10 = 0;
            for (LiveShowModel liveShowModel : list) {
                int i11 = i10 + 1;
                if (i10 < 0) {
                    kotlin.collections.s.s();
                }
                final LiveShowModel liveShowModel2 = liveShowModel;
                View b4 = z.b(this, R$layout.item_feed_rcmd_top_live_item, false, 2, imageModel);
                ImageLoaderView liveItemUserAvatar = (ImageLoaderView) b4.findViewById(R$id.liveItemUserAvatar);
                if (liveItemUserAvatar != null) {
                    kotlin.jvm.internal.s.h(liveItemUserAvatar, "liveItemUserAvatar");
                    ImageLoaderView.g(liveItemUserAvatar, liveShowModel2.getUser().getAvatarImage(), null, null, 6, null);
                }
                int i12 = R$id.liveItemUserName;
                TextView textView = (TextView) b4.findViewById(i12);
                if (textView != null) {
                    textView.setText(liveShowModel2.getUser().getName());
                }
                LiveCoverTagModel coverTag = liveShowModel2.getCoverTag();
                if ((coverTag != null ? coverTag.getImage() : imageModel) != null) {
                    ImageModel image = liveShowModel2.getCoverTag().getImage();
                    int scaleWidthByHeight = image.getScaleWidthByHeight(z0.h.c(this, 24.0f));
                    int i13 = R$id.rcmd_tag_icon;
                    ImageLoaderView imageLoaderView = (ImageLoaderView) b4.findViewById(i13);
                    kotlin.jvm.internal.s.h(imageLoaderView, "layout.rcmd_tag_icon");
                    y.n(imageLoaderView, Integer.valueOf(scaleWidthByHeight), Integer.valueOf(z0.h.c(this, 24.0f)));
                    ImageLoaderView imageLoaderView2 = (ImageLoaderView) b4.findViewById(i13);
                    kotlin.jvm.internal.s.h(imageLoaderView2, "layout.rcmd_tag_icon");
                    ImageLoaderView.g(imageLoaderView2, image, new com.cupidapp.live.base.imageloader.b(false, null, null, null, null, null, null, ContextCompat.getColor(getContext(), R$color.app_transparent), 0, null, null, null, null, false, 0, 0, false, null, null, 524159, null), null, 4, null);
                    ((ImageLoaderView) b4.findViewById(i13)).setVisibility(0);
                } else {
                    ((ImageLoaderView) b4.findViewById(R$id.rcmd_tag_icon)).setVisibility(4);
                }
                LiveCoverTagModel coverTag2 = liveShowModel2.getCoverTag();
                String text = coverTag2 != null ? coverTag2.getText() : null;
                if (text == null || text.length() == 0) {
                    ((TextView) b4.findViewById(R$id.rcmd_tag_txt)).setVisibility(4);
                } else {
                    int i14 = R$id.rcmd_tag_txt;
                    TextView textView2 = (TextView) b4.findViewById(i14);
                    LiveCoverTagModel coverTag3 = liveShowModel2.getCoverTag();
                    textView2.setText(coverTag3 != null ? coverTag3.getText() : null);
                    ((TextView) b4.findViewById(i14)).setVisibility(0);
                }
                TextView liveItemUserName = (TextView) b4.findViewById(i12);
                if (liveItemUserName != null) {
                    kotlin.jvm.internal.s.h(liveItemUserName, "liveItemUserName");
                    z0.u.a(liveItemUserName);
                }
                y.d(b4, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.feed.layout.FeedTopRcmdLiveLayout$configData$1$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
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
                        itemClick.invoke(liveShowModel2);
                    }
                });
                addView(b4);
                m(liveShowModel2, i10);
                i10 = i11;
                imageModel = null;
            }
        }
        if (this.f14497e == null) {
            Observable<Long> observeOn = Observable.interval(3L, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread());
            final Function1<Long, Boolean> function1 = new Function1<Long, Boolean>() { // from class: com.cupidapp.live.feed.layout.FeedTopRcmdLiveLayout$configData$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull Long it) {
                    boolean z10;
                    boolean z11;
                    boolean z12;
                    kotlin.jvm.internal.s.i(it, "it");
                    z10 = FeedTopRcmdLiveLayout.this.f14496d;
                    if (z10) {
                        z12 = FeedTopRcmdLiveLayout.this.f14499g;
                        if (!z12) {
                            z11 = true;
                            return Boolean.valueOf(z11);
                        }
                    }
                    z11 = false;
                    return Boolean.valueOf(z11);
                }
            };
            Observable<Long> filter = observeOn.filter(new Predicate() { // from class: com.cupidapp.live.feed.layout.h
                @Override // io.reactivex.functions.Predicate
                public final boolean test(Object obj) {
                    boolean k10;
                    k10 = FeedTopRcmdLiveLayout.k(Function1.this, obj);
                    return k10;
                }
            });
            final Function1<Long, kotlin.p> function12 = new Function1<Long, kotlin.p>() { // from class: com.cupidapp.live.feed.layout.FeedTopRcmdLiveLayout$configData$3

                /* compiled from: FeedTopRcmdLiveLayout.kt */
                @kotlin.d
                /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
                public static final class a implements com.cupidapp.live.base.view.animation.a {

                    /* renamed from: a, reason: collision with root package name */
                    public final /* synthetic */ View f14501a;

                    /* renamed from: b, reason: collision with root package name */
                    public final /* synthetic */ FeedTopRcmdLiveLayout f14502b;

                    public a(View view, FeedTopRcmdLiveLayout feedTopRcmdLiveLayout) {
                        this.f14501a = view;
                        this.f14502b = feedTopRcmdLiveLayout;
                    }

                    @Override // com.cupidapp.live.base.view.animation.a
                    public void onAnimationCancel(@NotNull Animator animator) {
                        a.C0145a.a(this, animator);
                    }

                    @Override // com.cupidapp.live.base.view.animation.a
                    public void onAnimationEnd(@Nullable Animator animator) {
                        a.C0145a.b(this, animator);
                    }

                    @Override // com.cupidapp.live.base.view.animation.a
                    public void onAnimationPause(@Nullable Animator animator) {
                        a.C0145a.c(this, animator);
                    }

                    @Override // com.cupidapp.live.base.view.animation.a
                    public void onAnimationRepeat(@NotNull Animator animator) {
                        a.C0145a.d(this, animator);
                    }

                    @Override // com.cupidapp.live.base.view.animation.a
                    public void onAnimationResume(@Nullable Animator animator) {
                        a.C0145a.e(this, animator);
                    }

                    @Override // com.cupidapp.live.base.view.animation.a
                    public void onAnimationStart(@Nullable Animator animator) {
                        a.C0145a.f(this, animator);
                    }

                    @Override // com.cupidapp.live.base.view.animation.a
                    public void onAnimationUpdate(@NotNull ValueAnimator animation) {
                        FKLottieAnimationView fKLottieAnimationView;
                        kotlin.jvm.internal.s.i(animation, "animation");
                        if (animation.getAnimatedFraction() == 1.0f) {
                            View view = this.f14501a;
                            if (view != null) {
                                view.setVisibility(0);
                            }
                            fKLottieAnimationView = this.f14502b.f14495c;
                            if (fKLottieAnimationView != null) {
                                fKLottieAnimationView.setVisibility(4);
                            }
                            this.f14502b.f14499g = false;
                        }
                    }
                }

                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ kotlin.p invoke(Long l10) {
                    invoke2(l10);
                    return kotlin.p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Long l10) {
                    FKLottieAnimationView fKLottieAnimationView3;
                    FKLottieAnimationView fKLottieAnimationView4;
                    int i15;
                    FKLottieAnimationView fKLottieAnimationView5;
                    FKLottieAnimationView fKLottieAnimationView6;
                    FKLottieAnimationView fKLottieAnimationView7;
                    FeedTopRcmdLiveLayout.this.f14499g = true;
                    fKLottieAnimationView3 = FeedTopRcmdLiveLayout.this.f14495c;
                    if (fKLottieAnimationView3 != null) {
                        fKLottieAnimationView3.M();
                    }
                    fKLottieAnimationView4 = FeedTopRcmdLiveLayout.this.f14495c;
                    if (fKLottieAnimationView4 != null) {
                        fKLottieAnimationView4.J();
                    }
                    FeedTopRcmdLiveLayout.this.f14495c = null;
                    FeedTopRcmdLiveLayout feedTopRcmdLiveLayout = FeedTopRcmdLiveLayout.this;
                    i15 = feedTopRcmdLiveLayout.f14498f;
                    feedTopRcmdLiveLayout.f14498f = i15 + 1;
                    View childAt = FeedTopRcmdLiveLayout.this.getChildAt(i15 % FeedTopRcmdLiveLayout.this.getChildCount());
                    View findViewById = childAt != null ? childAt.findViewById(R$id.liveItemUserAvatarCircle) : null;
                    FeedTopRcmdLiveLayout.this.f14495c = childAt != null ? (FKLottieAnimationView) childAt.findViewById(R$id.live_lottie) : null;
                    fKLottieAnimationView5 = FeedTopRcmdLiveLayout.this.f14495c;
                    if (fKLottieAnimationView5 != null) {
                        fKLottieAnimationView5.setVisibility(0);
                    }
                    fKLottieAnimationView6 = FeedTopRcmdLiveLayout.this.f14495c;
                    if (fKLottieAnimationView6 != null) {
                        fKLottieAnimationView6.L();
                    }
                    if (findViewById != null) {
                        findViewById.setVisibility(4);
                    }
                    fKLottieAnimationView7 = FeedTopRcmdLiveLayout.this.f14495c;
                    if (fKLottieAnimationView7 != null) {
                        fKLottieAnimationView7.F(new a(findViewById, FeedTopRcmdLiveLayout.this));
                    }
                }
            };
            this.f14497e = filter.subscribe(new Consumer() { // from class: com.cupidapp.live.feed.layout.g
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    FeedTopRcmdLiveLayout.l(Function1.this, obj);
                }
            });
        }
    }

    public final void m(LiveShowModel liveShowModel, int i10) {
        SensorsLogLiveShow sensorsLogLiveShow = SensorsLogLiveShow.f12212a;
        String itemId = liveShowModel.getItemId();
        String userId = liveShowModel.getUser().userId();
        SensorPosition sensorPosition = SensorPosition.Feed;
        SensorScene sensorScene = SensorScene.Feed;
        String viewerCount = liveShowModel.getViewerCount();
        Integer anchorPrivilegeType = liveShowModel.getAnchorPrivilegeType();
        String strategyId = liveShowModel.getStrategyId();
        SensorsLogLiveShow.EnterLiveShowSource enterLiveShowSource = SensorsLogLiveShow.EnterLiveShowSource.FOLLOWING_LIST;
        FKLiveType liveType = liveShowModel.getLiveType();
        LiveProtos.CoverType coverType = liveShowModel.getCoverType();
        RedEnvelopeTagModel redPacketInfo = liveShowModel.getRedPacketInfo();
        sensorsLogLiveShow.o(itemId, userId, sensorPosition, sensorScene, (r33 & 16) != 0 ? null : viewerCount, (r33 & 32) != 0 ? null : anchorPrivilegeType, (r33 & 64) != 0 ? null : strategyId, (r33 & 128) != 0 ? null : enterLiveShowSource, (r33 & 256) != 0 ? null : liveType, (r33 & 512) != 0 ? null : coverType, (r33 & 1024) != 0 ? null : null, (r33 & 2048) != 0 ? null : null, (r33 & 4096) != 0 ? null : null, (r33 & 8192) != 0 ? null : redPacketInfo != null ? redPacketInfo.getIconCategory() : null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        y0.a.b(y0.a.f54658a, this, null, 2, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        y0.a.f54658a.c(this);
    }

    @he.j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull i event) {
        kotlin.jvm.internal.s.i(event, "event");
        this.f14496d = event.a();
    }

    public FeedTopRcmdLiveLayout(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14496d = true;
    }

    public FeedTopRcmdLiveLayout(@Nullable Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f14496d = true;
    }
}
