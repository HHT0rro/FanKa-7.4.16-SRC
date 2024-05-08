package com.cupidapp.live.match.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Paint;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.android.internal.logging.nano.MetricsProto;
import com.cupidapp.live.R$id;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.model.ConstantsResult;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.base.sensorslog.SensorsLogLiveShow;
import com.cupidapp.live.base.view.animation.FKSVGAImageView;
import com.cupidapp.live.liveshow.activity.FKLiveForViewerActivity;
import com.cupidapp.live.liveshow.activity.FKLiveForViewerViewModel;
import com.cupidapp.live.liveshow.constants.FKLiveType;
import com.cupidapp.live.liveshow.fragment.LiveInRoomSensorModel;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import com.cupidapp.live.liveshow.model.RedEnvelopeTagModel;
import com.cupidapp.live.match.adapter.FKSwipeCardAdapter;
import com.cupidapp.live.match.adapter.FKSwipeCardLiveViewHolder;
import com.cupidapp.live.match.adapter.FKSwipeCardViewHolder;
import com.cupidapp.live.match.adapter.SwipeCardCampaignViewHolder;
import com.cupidapp.live.match.helper.GuideAnimHelper;
import com.cupidapp.live.match.holder.SwipeCardMarketingPositionViewHolder;
import com.cupidapp.live.match.model.MatchGroupCampaignModel;
import com.cupidapp.live.match.model.MatchMarketingModel;
import com.cupidapp.live.match.model.MatchRecommendModel;
import com.cupidapp.live.match.model.MatchRecommendType;
import com.cupidapp.live.match.model.MatchRecommendUserModel;
import com.cupidapp.live.match.view.FKSwipeCardFakeAvatarTipLayout;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.profile.model.ZodiacElfInfoModel;
import com.cupidapp.live.track.group.GroupOthersLog;
import com.cupidapp.live.track.group.GroupSocialLog;
import com.huawei.quickcard.base.Attributes;
import com.irisdt.client.live.LiveProtos;
import com.yuyakaido.android.cardstackview.Direction;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.i0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKSwipeCardLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKSwipeCardLayout extends FKSwipeCardView implements FKSwipeCardFakeAvatarTipLayout.a {

    /* renamed from: f */
    @NotNull
    public final Lazy f16875f;

    /* renamed from: g */
    @Nullable
    public ObjectAnimator f16876g;

    /* renamed from: h */
    @Nullable
    public ObjectAnimator f16877h;

    /* renamed from: i */
    @Nullable
    public a0 f16878i;

    /* renamed from: j */
    @NotNull
    public Set<String> f16879j;

    /* renamed from: k */
    @NotNull
    public Set<String> f16880k;

    /* renamed from: l */
    @NotNull
    public final List<LiveShowModel> f16881l;

    /* renamed from: m */
    public int f16882m;

    /* renamed from: n */
    @Nullable
    public Long f16883n;

    /* renamed from: o */
    @NotNull
    public final List<MatchRecommendModel> f16884o;

    /* renamed from: p */
    @Nullable
    public MatchRecommendModel f16885p;

    /* renamed from: q */
    @Nullable
    public FKSwipeCardViewHolder f16886q;

    /* renamed from: r */
    @Nullable
    public FKSwipeCardLiveViewHolder f16887r;

    /* renamed from: s */
    @Nullable
    public LiveShowModel f16888s;

    /* renamed from: t */
    public boolean f16889t;

    /* renamed from: u */
    @Nullable
    public SwipeCardCampaignViewHolder f16890u;

    /* renamed from: v */
    @Nullable
    public MatchRecommendModel f16891v;

    /* renamed from: w */
    @NotNull
    public Map<Integer, View> f16892w;

    /* compiled from: FKSwipeCardLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a extends AnimatorListenerAdapter {

        /* renamed from: c */
        public final /* synthetic */ Function0<kotlin.p> f16894c;

        public a(Function0<kotlin.p> function0) {
            this.f16894c = function0;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animation) {
            kotlin.jvm.internal.s.i(animation, "animation");
            if (FKSwipeCardLayout.this.getVisibility() == 0) {
                FKSwipeCardLayout.this.setVisibility(8);
                this.f16894c.invoke();
            }
        }
    }

    /* compiled from: FKSwipeCardLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b extends AnimatorListenerAdapter {

        /* renamed from: c */
        public final /* synthetic */ Function0<kotlin.p> f16896c;

        public b(Function0<kotlin.p> function0) {
            this.f16896c = function0;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animation) {
            kotlin.jvm.internal.s.i(animation, "animation");
            if (FKSwipeCardLayout.this.getVisibility() == 0) {
                this.f16896c.invoke();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animation) {
            kotlin.jvm.internal.s.i(animation, "animation");
            FKSwipeCardLayout.this.setVisibility(0);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKSwipeCardLayout(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.f16892w = new LinkedHashMap();
        this.f16875f = kotlin.c.b(new Function0<FKSwipeCardAdapter>() { // from class: com.cupidapp.live.match.view.FKSwipeCardLayout$swipeCardAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FKSwipeCardAdapter invoke() {
                FKSwipeCardAdapter fKSwipeCardAdapter = new FKSwipeCardAdapter(FKSwipeCardLayout.this);
                final FKSwipeCardLayout fKSwipeCardLayout = FKSwipeCardLayout.this;
                fKSwipeCardAdapter.l().k(i0.h(kotlin.f.a(Integer.valueOf(R$id.left_click_view), new Function2<Object, Integer, kotlin.p>() { // from class: com.cupidapp.live.match.view.FKSwipeCardLayout$swipeCardAdapter$2$1$1
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
                        if (obj instanceof MatchRecommendUserModel) {
                            FKSwipeCardLayout.this.C(true, i10);
                        }
                    }
                }), kotlin.f.a(Integer.valueOf(R$id.right_click_view), new Function2<Object, Integer, kotlin.p>() { // from class: com.cupidapp.live.match.view.FKSwipeCardLayout$swipeCardAdapter$2$1$2
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
                        if (obj instanceof MatchRecommendUserModel) {
                            FKSwipeCardLayout.this.C(false, i10);
                        }
                    }
                }), kotlin.f.a(Integer.valueOf(R$id.swipe_card_user_info), new Function2<Object, Integer, kotlin.p>() { // from class: com.cupidapp.live.match.view.FKSwipeCardLayout$swipeCardAdapter$2$1$3
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    /* renamed from: invoke */
                    public /* bridge */ /* synthetic */ kotlin.p mo1743invoke(Object obj, Integer num) {
                        invoke(obj, num.intValue());
                        return kotlin.p.f51048a;
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:3:0x0004, code lost:
                    
                        r2 = r1.f16878i;
                     */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final void invoke(@org.jetbrains.annotations.Nullable java.lang.Object r1, int r2) {
                        /*
                            r0 = this;
                            boolean r2 = r1 instanceof com.cupidapp.live.match.model.MatchRecommendUserModel
                            if (r2 == 0) goto L11
                            com.cupidapp.live.match.view.FKSwipeCardLayout r2 = com.cupidapp.live.match.view.FKSwipeCardLayout.this
                            com.cupidapp.live.match.view.a0 r2 = com.cupidapp.live.match.view.FKSwipeCardLayout.A(r2)
                            if (r2 == 0) goto L11
                            com.cupidapp.live.match.model.MatchRecommendUserModel r1 = (com.cupidapp.live.match.model.MatchRecommendUserModel) r1
                            r2.l(r1)
                        L11:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.match.view.FKSwipeCardLayout$swipeCardAdapter$2$1$3.invoke(java.lang.Object, int):void");
                    }
                }), kotlin.f.a(Integer.valueOf(R$id.live_status_layout), new Function2<Object, Integer, kotlin.p>() { // from class: com.cupidapp.live.match.view.FKSwipeCardLayout$swipeCardAdapter$2$1$4
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
                        if (obj instanceof MatchRecommendUserModel) {
                            MatchRecommendUserModel matchRecommendUserModel = (MatchRecommendUserModel) obj;
                            if (matchRecommendUserModel.getLiveShow() != null) {
                                FKLiveForViewerActivity.G.a(FKSwipeCardLayout.this.getContext(), new FKLiveForViewerViewModel(matchRecommendUserModel.getLiveShow(), null, new LiveInRoomSensorModel("LIVE_WINDOW", null, SensorScene.Match, SensorPosition.Match, null, null, 48, null), false, 8, null), false);
                            }
                        }
                    }
                }), kotlin.f.a(Integer.valueOf(R$id.activity_img), new Function2<Object, Integer, kotlin.p>() { // from class: com.cupidapp.live.match.view.FKSwipeCardLayout$swipeCardAdapter$2$1$5
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
                        if (obj instanceof MatchGroupCampaignModel) {
                            MatchGroupCampaignModel matchGroupCampaignModel = (MatchGroupCampaignModel) obj;
                            matchGroupCampaignModel.setHasSeeContent(true);
                            j.a.b(com.cupidapp.live.base.router.j.f12156c, FKSwipeCardLayout.this.getContext(), matchGroupCampaignModel.getJumpUrl(), null, 4, null);
                            FKSwipeCardLayout.this.R((MatchRecommendModel) obj, GroupSocialLog.CampaignOperateAction.CARD);
                        }
                    }
                }), kotlin.f.a(Integer.valueOf(R$id.swipe_card_campaign_skip_btn), new Function2<Object, Integer, kotlin.p>() { // from class: com.cupidapp.live.match.view.FKSwipeCardLayout$swipeCardAdapter$2$1$6
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
                        if (obj instanceof MatchGroupCampaignModel) {
                            FKSwipeCardLayout.this.f0(false);
                            FKSwipeCardLayout.this.R((MatchRecommendModel) obj, GroupSocialLog.CampaignOperateAction.NOPE);
                        }
                    }
                }), kotlin.f.a(Integer.valueOf(R$id.swipe_card_campaign_see_btn), new Function2<Object, Integer, kotlin.p>() { // from class: com.cupidapp.live.match.view.FKSwipeCardLayout$swipeCardAdapter$2$1$7
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
                        if (obj instanceof MatchGroupCampaignModel) {
                            MatchGroupCampaignModel matchGroupCampaignModel = (MatchGroupCampaignModel) obj;
                            matchGroupCampaignModel.setHasSeeContent(true);
                            j.a.b(com.cupidapp.live.base.router.j.f12156c, FKSwipeCardLayout.this.getContext(), matchGroupCampaignModel.getJumpUrl(), null, 4, null);
                            FKSwipeCardLayout.this.R((MatchRecommendModel) obj, GroupSocialLog.CampaignOperateAction.ALOHA);
                        }
                    }
                }), kotlin.f.a(Integer.valueOf(R$id.swipe_card_campaign_cancel_nope_btn), new Function2<Object, Integer, kotlin.p>() { // from class: com.cupidapp.live.match.view.FKSwipeCardLayout$swipeCardAdapter$2$1$8
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    /* renamed from: invoke */
                    public /* bridge */ /* synthetic */ kotlin.p mo1743invoke(Object obj, Integer num) {
                        invoke(obj, num.intValue());
                        return kotlin.p.f51048a;
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:3:0x0004, code lost:
                    
                        r1 = r1.f16878i;
                     */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final void invoke(@org.jetbrains.annotations.Nullable java.lang.Object r1, int r2) {
                        /*
                            r0 = this;
                            boolean r1 = r1 instanceof com.cupidapp.live.match.model.MatchGroupCampaignModel
                            if (r1 == 0) goto Lf
                            com.cupidapp.live.match.view.FKSwipeCardLayout r1 = com.cupidapp.live.match.view.FKSwipeCardLayout.this
                            com.cupidapp.live.match.view.a0 r1 = com.cupidapp.live.match.view.FKSwipeCardLayout.A(r1)
                            if (r1 == 0) goto Lf
                            r1.w()
                        Lf:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.match.view.FKSwipeCardLayout$swipeCardAdapter$2$1$8.invoke(java.lang.Object, int):void");
                    }
                }), kotlin.f.a(Integer.valueOf(R$id.marketing_btn_img), new Function2<Object, Integer, kotlin.p>() { // from class: com.cupidapp.live.match.view.FKSwipeCardLayout$swipeCardAdapter$2$1$9
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
                        if (obj instanceof MatchMarketingModel) {
                            j.a.b(com.cupidapp.live.base.router.j.f12156c, FKSwipeCardLayout.this.getContext(), ((MatchMarketingModel) obj).getJumpUrl(), null, 4, null);
                            FKSwipeCardLayout.this.R((MatchRecommendModel) obj, GroupSocialLog.CampaignOperateAction.UPGRADE);
                        }
                    }
                }), kotlin.f.a(Integer.valueOf(R$id.marketing_skip_txt), new Function2<Object, Integer, kotlin.p>() { // from class: com.cupidapp.live.match.view.FKSwipeCardLayout$swipeCardAdapter$2$1$10
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
                        if (obj instanceof MatchMarketingModel) {
                            FKSwipeCardLayout.this.f0(false);
                            FKSwipeCardLayout.this.R((MatchRecommendModel) obj, GroupSocialLog.CampaignOperateAction.NOPE);
                        }
                    }
                }), kotlin.f.a(Integer.valueOf(R$id.marketing_see_txt), new Function2<Object, Integer, kotlin.p>() { // from class: com.cupidapp.live.match.view.FKSwipeCardLayout$swipeCardAdapter$2$1$11
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
                        if (obj instanceof MatchMarketingModel) {
                            j.a.b(com.cupidapp.live.base.router.j.f12156c, FKSwipeCardLayout.this.getContext(), ((MatchMarketingModel) obj).getJumpUrl(), null, 4, null);
                            FKSwipeCardLayout.this.R((MatchRecommendModel) obj, GroupSocialLog.CampaignOperateAction.ALOHA);
                        }
                    }
                }), kotlin.f.a(Integer.valueOf(R$id.marketing_cancel_img), new Function2<Object, Integer, kotlin.p>() { // from class: com.cupidapp.live.match.view.FKSwipeCardLayout$swipeCardAdapter$2$1$12
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    /* renamed from: invoke */
                    public /* bridge */ /* synthetic */ kotlin.p mo1743invoke(Object obj, Integer num) {
                        invoke(obj, num.intValue());
                        return kotlin.p.f51048a;
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:3:0x0004, code lost:
                    
                        r1 = r1.f16878i;
                     */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final void invoke(@org.jetbrains.annotations.Nullable java.lang.Object r1, int r2) {
                        /*
                            r0 = this;
                            boolean r1 = r1 instanceof com.cupidapp.live.match.model.MatchMarketingModel
                            if (r1 == 0) goto Lf
                            com.cupidapp.live.match.view.FKSwipeCardLayout r1 = com.cupidapp.live.match.view.FKSwipeCardLayout.this
                            com.cupidapp.live.match.view.a0 r1 = com.cupidapp.live.match.view.FKSwipeCardLayout.A(r1)
                            if (r1 == 0) goto Lf
                            r1.w()
                        Lf:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.match.view.FKSwipeCardLayout$swipeCardAdapter$2$1$12.invoke(java.lang.Object, int):void");
                    }
                })));
                fKSwipeCardAdapter.l().g(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.match.view.FKSwipeCardLayout$swipeCardAdapter$2$1$13
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                        invoke2(obj);
                        return kotlin.p.f51048a;
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:3:0x0004, code lost:
                    
                        r0 = r1.f16878i;
                     */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final void invoke2(@org.jetbrains.annotations.Nullable java.lang.Object r2) {
                        /*
                            r1 = this;
                            boolean r0 = r2 instanceof com.cupidapp.live.liveshow.model.LiveShowModel
                            if (r0 == 0) goto L11
                            com.cupidapp.live.match.view.FKSwipeCardLayout r0 = com.cupidapp.live.match.view.FKSwipeCardLayout.this
                            com.cupidapp.live.match.view.a0 r0 = com.cupidapp.live.match.view.FKSwipeCardLayout.A(r0)
                            if (r0 == 0) goto L11
                            com.cupidapp.live.liveshow.model.LiveShowModel r2 = (com.cupidapp.live.liveshow.model.LiveShowModel) r2
                            r0.t(r2)
                        L11:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.match.view.FKSwipeCardLayout$swipeCardAdapter$2$1$13.invoke2(java.lang.Object):void");
                    }
                });
                return fKSwipeCardAdapter;
            }
        });
        this.f16879j = new LinkedHashSet();
        this.f16880k = new LinkedHashSet();
        this.f16881l = new ArrayList();
        this.f16884o = new ArrayList();
        s();
    }

    public static /* synthetic */ Object K(FKSwipeCardLayout fKSwipeCardLayout, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 0;
        }
        return fKSwipeCardLayout.J(i10);
    }

    public static /* synthetic */ FKSwipeCardViewHolder O(FKSwipeCardLayout fKSwipeCardLayout, View view, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            view = null;
        }
        return fKSwipeCardLayout.N(view, i10);
    }

    public static final void V(View itemView, int i10, FKSwipeCardLayout this$0) {
        Map g3;
        kotlin.jvm.internal.s.i(itemView, "$itemView");
        kotlin.jvm.internal.s.i(this$0, "this$0");
        int width = itemView.getWidth();
        int i11 = (width * 256) / MetricsProto.MetricsEvent.PROVISIONING_SESSION_STARTED;
        int i12 = R$id.super_like_svga_view;
        FKSVGAImageView fKSVGAImageView = (FKSVGAImageView) itemView.findViewById(i12);
        kotlin.jvm.internal.s.h(fKSVGAImageView, "itemView.super_like_svga_view");
        z0.y.n(fKSVGAImageView, Integer.valueOf(width), Integer.valueOf(i11));
        com.cupidapp.live.superlike.view.h hVar = com.cupidapp.live.superlike.view.h.f18669a;
        String b4 = hVar.b(i10);
        Context context = this$0.getContext();
        kotlin.jvm.internal.s.h(context, "context");
        int c4 = hVar.c(context, i10);
        String valueOf = String.valueOf(i10);
        FKSVGAImageView fKSVGAImageView2 = (FKSVGAImageView) itemView.findViewById(i12);
        kotlin.jvm.internal.s.h(fKSVGAImageView2, "itemView.super_like_svga_view");
        if (i10 == 1) {
            g3 = null;
        } else {
            TextPaint textPaint = new TextPaint();
            textPaint.setTextSize(120.0f);
            textPaint.setColor(c4);
            textPaint.setStyle(Paint.Style.FILL);
            textPaint.setFakeBoldText(true);
            kotlin.p pVar = kotlin.p.f51048a;
            TextPaint textPaint2 = new TextPaint();
            textPaint2.setTextSize(120.0f);
            textPaint2.setColor(-1);
            textPaint2.setStrokeWidth(18.0f);
            textPaint2.setStyle(Paint.Style.FILL_AND_STROKE);
            textPaint2.setFakeBoldText(true);
            g3 = i0.g(new Pair("text", new Pair(textPaint, valueOf)), new Pair(Attributes.SelfStyle.OUTLINE, new Pair(textPaint2, valueOf)));
        }
        fKSVGAImageView2.I(b4, (r13 & 2) != 0 ? null : null, (r13 & 4) != 0 ? null : null, (r13 & 8) != 0 ? null : g3, (r13 & 16) != 0 ? null : null, (r13 & 32) == 0 ? null : null);
        ((FKSVGAImageView) itemView.findViewById(i12)).setVisibility(0);
    }

    public static final void Y(FKSwipeCardLayout this$0) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        this$0.t();
        this$0.n();
    }

    public static final void a0(FKSwipeCardLayout this$0) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        FKSwipeCardViewHolder fKSwipeCardViewHolder = this$0.f16886q;
        final View view = fKSwipeCardViewHolder != null ? fKSwipeCardViewHolder.itemView : null;
        if (view != null) {
            view.post(new Runnable() { // from class: com.cupidapp.live.match.view.m
                @Override // java.lang.Runnable
                public final void run() {
                    FKSwipeCardLayout.b0(FKSwipeCardLayout.this, view);
                }
            });
        }
    }

    public static final void b0(FKSwipeCardLayout this$0, View view) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        if (kotlin.jvm.internal.s.d(p1.g.f52734a.y1().c(), Boolean.TRUE)) {
            a0 a0Var = this$0.f16878i;
            if (a0Var != null) {
                a0Var.q();
            }
            GuideAnimHelper.f16763a.i(view, new Function0<kotlin.p>() { // from class: com.cupidapp.live.match.view.FKSwipeCardLayout$showGuideAnimation$1$1$1
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
                    a0 a0Var2;
                    FKSwipeCardViewHolder fKSwipeCardViewHolder;
                    a0 a0Var3;
                    a0Var2 = FKSwipeCardLayout.this.f16878i;
                    if (a0Var2 != null) {
                        a0Var2.p(null);
                    }
                    fKSwipeCardViewHolder = FKSwipeCardLayout.this.f16886q;
                    if (fKSwipeCardViewHolder != null) {
                        fKSwipeCardViewHolder.G();
                    }
                    a0Var3 = FKSwipeCardLayout.this.f16878i;
                    if (a0Var3 != null) {
                        a0Var3.m();
                    }
                }
            });
            GroupOthersLog.M(GroupOthersLog.f18702a, GroupOthersLog.GuideType.ANM_GUIDE, SensorPosition.Match, SensorScene.Match, null, 8, null);
            return;
        }
        a0 a0Var2 = this$0.f16878i;
        if (a0Var2 != null) {
            a0Var2.p(null);
        }
        FKSwipeCardViewHolder fKSwipeCardViewHolder = this$0.f16886q;
        if (fKSwipeCardViewHolder != null) {
            fKSwipeCardViewHolder.G();
        }
        a0 a0Var3 = this$0.f16878i;
        if (a0Var3 != null) {
            a0Var3.m();
        }
    }

    private final FKSwipeCardAdapter getSwipeCardAdapter() {
        return (FKSwipeCardAdapter) this.f16875f.getValue();
    }

    private final void s() {
        setAdapter(getSwipeCardAdapter());
        Q();
    }

    public final void C(boolean z10, int i10) {
        FKSwipeCardViewHolder O = O(this, null, i10, 1, null);
        if (O != null) {
            if (z10) {
                if (O.x()) {
                    ObjectAnimator objectAnimator = this.f16876g;
                    if (objectAnimator != null) {
                        objectAnimator.start();
                    }
                    g0();
                    return;
                }
                return;
            }
            if (O.E()) {
                ObjectAnimator objectAnimator2 = this.f16877h;
                if (objectAnimator2 != null) {
                    objectAnimator2.start();
                }
                g0();
            }
        }
    }

    public final void D() {
        p1.g gVar = p1.g.f52734a;
        if (gVar.i() != null) {
            gVar.V1(2);
            FKSwipeCardViewHolder N = N(null, 0);
            if (N != null) {
                N.H();
            }
            FKSwipeCardViewHolder N2 = N(null, 1);
            if (N2 != null) {
                N2.H();
            }
        }
    }

    public final void E() {
        this.f16884o.clear();
        getSwipeCardAdapter().j().clear();
        getSwipeCardAdapter().notifyDataSetChanged();
    }

    public final void F(@NotNull List<LiveShowModel> list) {
        kotlin.jvm.internal.s.i(list, "list");
        this.f16881l.addAll(list);
    }

    public final void G(@NotNull List<? extends MatchRecommendModel> cardList, boolean z10) {
        kotlin.jvm.internal.s.i(cardList, "cardList");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<Object> iterator2 = getSwipeCardAdapter().j().iterator2();
        while (true) {
            boolean z11 = true;
            if (!iterator2.hasNext()) {
                break;
            }
            Object next = iterator2.next();
            if (next instanceof MatchRecommendUserModel) {
                arrayList.add(((MatchRecommendUserModel) next).getUser().userId());
            } else if (next instanceof MatchGroupCampaignModel) {
                MatchGroupCampaignModel matchGroupCampaignModel = (MatchGroupCampaignModel) next;
                String cardId = matchGroupCampaignModel.getCardId();
                if (cardId != null && cardId.length() != 0) {
                    z11 = false;
                }
                if (!z11) {
                    String cardId2 = matchGroupCampaignModel.getCardId();
                    kotlin.jvm.internal.s.f(cardId2);
                    arrayList2.add(cardId2);
                }
            }
        }
        int size = getSwipeCardAdapter().j().size();
        ArrayList arrayList3 = new ArrayList();
        for (MatchRecommendModel matchRecommendModel : cardList) {
            if (matchRecommendModel instanceof MatchRecommendUserModel) {
                String userId = ((MatchRecommendUserModel) matchRecommendModel).getUser().userId();
                if (!this.f16879j.contains(userId) && !arrayList.contains(userId)) {
                    arrayList3.add(matchRecommendModel);
                }
            } else if (matchRecommendModel instanceof MatchGroupCampaignModel) {
                String cardId3 = ((MatchGroupCampaignModel) matchRecommendModel).getCardId();
                if (!CollectionsKt___CollectionsKt.L(this.f16880k, cardId3) && !CollectionsKt___CollectionsKt.L(arrayList2, cardId3)) {
                    arrayList3.add(matchRecommendModel);
                }
            } else if (matchRecommendModel instanceof MatchMarketingModel) {
                String configKey = ((MatchMarketingModel) matchRecommendModel).getConfigKey();
                if (!CollectionsKt___CollectionsKt.L(this.f16880k, configKey) && !CollectionsKt___CollectionsKt.L(arrayList2, configKey)) {
                    arrayList3.add(matchRecommendModel);
                }
            }
        }
        if (z10 && size == 0 && getVisibility() == 0) {
            this.f16884o.addAll(arrayList3);
        } else {
            if (!this.f16884o.isEmpty()) {
                getSwipeCardAdapter().e(this.f16884o);
                this.f16884o.clear();
            }
            getSwipeCardAdapter().e(arrayList3);
        }
        getSwipeCardAdapter().notifyDataSetChanged();
    }

    public final void H() {
        Integer liveShowIntervalInMatch;
        if (this.f16881l.isEmpty()) {
            a0 a0Var = this.f16878i;
            if (a0Var != null) {
                a0Var.r();
            }
        } else {
            int size = getSwipeCardAdapter().j().size();
            ConstantsResult q10 = p1.g.f52734a.q();
            int intValue = (q10 == null || (liveShowIntervalInMatch = q10.getLiveShowIntervalInMatch()) == null) ? 4 : liveShowIntervalInMatch.intValue();
            int i10 = intValue >= 4 ? intValue : 4;
            if (size >= 2 && this.f16882m == i10) {
                getSwipeCardAdapter().j().add(2, this.f16881l.get(0));
                getSwipeCardAdapter().notifyItemInserted(2);
                this.f16881l.remove(0);
            }
        }
        W();
    }

    public final SwipeCardCampaignViewHolder I(View view, int i10) {
        RecyclerView.ViewHolder r10;
        if (view == null) {
            r10 = q(i10);
        } else {
            r10 = r(view);
        }
        if (r10 instanceof SwipeCardCampaignViewHolder) {
            return (SwipeCardCampaignViewHolder) r10;
        }
        return null;
    }

    @NotNull
    public final Object J(int i10) {
        if (!getSwipeCardAdapter().j().isEmpty()) {
            return getSwipeCardAdapter().j().get(i10);
        }
        return new Object();
    }

    public final FKSwipeCardLiveViewHolder L(View view, int i10) {
        RecyclerView.ViewHolder r10;
        if (view == null) {
            r10 = q(i10);
        } else {
            r10 = r(view);
        }
        if (r10 instanceof FKSwipeCardLiveViewHolder) {
            return (FKSwipeCardLiveViewHolder) r10;
        }
        return null;
    }

    public final SwipeCardMarketingPositionViewHolder M(View view, int i10) {
        RecyclerView.ViewHolder r10;
        if (view == null) {
            r10 = q(i10);
        } else {
            r10 = r(view);
        }
        if (r10 instanceof SwipeCardMarketingPositionViewHolder) {
            return (SwipeCardMarketingPositionViewHolder) r10;
        }
        return null;
    }

    public final FKSwipeCardViewHolder N(View view, int i10) {
        RecyclerView.ViewHolder r10;
        if (view == null) {
            r10 = q(i10);
        } else {
            r10 = r(view);
        }
        if (r10 instanceof FKSwipeCardViewHolder) {
            return (FKSwipeCardViewHolder) r10;
        }
        return null;
    }

    public final void P(@NotNull Function0<kotlin.p> animationEnd) {
        kotlin.jvm.internal.s.i(animationEnd, "animationEnd");
        if (getVisibility() == 0) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, (Property<FKSwipeCardLayout, Float>) View.ALPHA, 1.0f, 0.0f);
            ofFloat.setDuration(300L);
            ofFloat.addListener(new a(animationEnd));
            ofFloat.start();
            return;
        }
        animationEnd.invoke();
    }

    public final void Q() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, (Property<FKSwipeCardLayout, Float>) View.ROTATION_Y, 0.0f, -2.0f);
        ofFloat.setDuration(40L);
        ofFloat.setRepeatCount(1);
        ofFloat.setRepeatMode(2);
        this.f16876g = ofFloat;
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, (Property<FKSwipeCardLayout, Float>) View.ROTATION_Y, 0.0f, 2.0f);
        ofFloat2.setDuration(40L);
        ofFloat2.setRepeatCount(1);
        ofFloat2.setRepeatMode(2);
        this.f16877h = ofFloat2;
    }

    public final void R(MatchRecommendModel matchRecommendModel, GroupSocialLog.CampaignOperateAction campaignOperateAction) {
        if (matchRecommendModel instanceof MatchGroupCampaignModel) {
            String type = matchRecommendModel.getType();
            if (kotlin.jvm.internal.s.d(type, MatchRecommendType.GroupCampaign.getType())) {
                MatchGroupCampaignModel matchGroupCampaignModel = (MatchGroupCampaignModel) matchRecommendModel;
                GroupSocialLog.f18708a.b(matchGroupCampaignModel.getTitle(), campaignOperateAction, matchGroupCampaignModel.getActivityId());
                return;
            } else {
                if (kotlin.jvm.internal.s.d(type, MatchRecommendType.HighEndDating.getType())) {
                    GroupSocialLog.f18708a.p(((MatchGroupCampaignModel) matchRecommendModel).getTitle(), campaignOperateAction);
                    return;
                }
                return;
            }
        }
        if (matchRecommendModel instanceof MatchMarketingModel) {
            GroupSocialLog.f18708a.p(((MatchMarketingModel) matchRecommendModel).getTitle(), campaignOperateAction);
        }
    }

    public final void S(LiveShowModel liveShowModel) {
        SensorsLogLiveShow sensorsLogLiveShow = SensorsLogLiveShow.f12212a;
        String itemId = liveShowModel.getItemId();
        String userId = liveShowModel.getUser().userId();
        SensorPosition sensorPosition = SensorPosition.Match;
        SensorScene sensorScene = SensorScene.Match;
        String viewerCount = liveShowModel.getViewerCount();
        Integer anchorPrivilegeType = liveShowModel.getAnchorPrivilegeType();
        String strategyId = liveShowModel.getStrategyId();
        SensorsLogLiveShow.EnterLiveShowSource enterLiveShowSource = SensorsLogLiveShow.EnterLiveShowSource.MATCH;
        FKLiveType liveType = liveShowModel.getLiveType();
        LiveProtos.CoverType coverType = liveShowModel.getCoverType();
        RedEnvelopeTagModel redPacketInfo = liveShowModel.getRedPacketInfo();
        sensorsLogLiveShow.o(itemId, userId, sensorPosition, sensorScene, (r33 & 16) != 0 ? null : viewerCount, (r33 & 32) != 0 ? null : anchorPrivilegeType, (r33 & 64) != 0 ? null : strategyId, (r33 & 128) != 0 ? null : enterLiveShowSource, (r33 & 256) != 0 ? null : liveType, (r33 & 512) != 0 ? null : coverType, (r33 & 1024) != 0 ? null : null, (r33 & 2048) != 0 ? null : null, (r33 & 4096) != 0 ? null : null, (r33 & 8192) != 0 ? null : redPacketInfo != null ? redPacketInfo.getIconCategory() : null);
        Observable<Result<Object>> j10 = NetworkClient.f11868a.A().j(liveShowModel.getItemId(), sensorPosition.getValue(), liveShowModel.getUser().userId());
        Object context = getContext();
        com.cupidapp.live.base.network.g gVar = context instanceof com.cupidapp.live.base.network.g ? (com.cupidapp.live.base.network.g) context : null;
        Disposable disposed = j10.flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.match.view.FKSwipeCardLayout$recommendLiveExposure$$inlined$handleByContext$default$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                invoke2(obj);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, gVar)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
            if (gVar != null) {
                gVar.H(disposed);
            }
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }

    public final void T(Direction direction) {
        a0 a0Var;
        if (!getSwipeCardAdapter().j().isEmpty()) {
            Object K = K(this, 0, 1, null);
            if (K instanceof MatchRecommendUserModel) {
                this.f16879j.add(((MatchRecommendUserModel) K).getUser().userId());
                this.f16891v = direction == Direction.Left ? (MatchRecommendModel) K : null;
            } else if (K instanceof LiveShowModel) {
                this.f16882m = 0;
                this.f16891v = null;
            } else if (K instanceof MatchGroupCampaignModel) {
                MatchGroupCampaignModel matchGroupCampaignModel = (MatchGroupCampaignModel) K;
                String cardId = matchGroupCampaignModel.getCardId();
                if (!(cardId == null || cardId.length() == 0)) {
                    Set<String> set = this.f16880k;
                    String cardId2 = matchGroupCampaignModel.getCardId();
                    kotlin.jvm.internal.s.f(cardId2);
                    set.add(cardId2);
                }
                this.f16891v = null;
            } else if (K instanceof MatchMarketingModel) {
                MatchMarketingModel matchMarketingModel = (MatchMarketingModel) K;
                String configKey = matchMarketingModel.getConfigKey();
                if (!(configKey == null || configKey.length() == 0)) {
                    this.f16880k.add(matchMarketingModel.getConfigKey());
                }
                this.f16891v = null;
            }
            getSwipeCardAdapter().j().remove(0);
            getSwipeCardAdapter().notifyItemRemoved(0);
            Object K2 = getSwipeCardAdapter().j().isEmpty() ^ true ? K(this, 0, 1, null) : null;
            a0 a0Var2 = this.f16878i;
            if (a0Var2 != null) {
                a0Var2.x(direction, K, K2, getCurrentCardIndexOfPhoto(), this.f16889t);
            }
        }
        if (getSwipeCardAdapter().j().isEmpty()) {
            a0 a0Var3 = this.f16878i;
            if (a0Var3 != null) {
                a0Var3.o();
                return;
            }
            return;
        }
        if (getSwipeCardAdapter().j().size() >= 5 || (a0Var = this.f16878i) == null) {
            return;
        }
        a0Var.v();
    }

    public final void U(final View view, final int i10) {
        if (i10 > 0) {
            view.post(new Runnable() { // from class: com.cupidapp.live.match.view.j
                @Override // java.lang.Runnable
                public final void run() {
                    FKSwipeCardLayout.V(View.this, i10, this);
                }
            });
        } else {
            ((FKSVGAImageView) view.findViewById(R$id.super_like_svga_view)).setVisibility(8);
        }
    }

    public final void W() {
        long currentTimeMillis = System.currentTimeMillis();
        Long l10 = this.f16883n;
        if (l10 != null) {
            kotlin.jvm.internal.s.f(l10);
            if (currentTimeMillis - l10.longValue() > 60000) {
                this.f16882m = 0;
                this.f16881l.clear();
            }
        }
        this.f16883n = Long.valueOf(currentTimeMillis);
    }

    public final void X(@Nullable MatchRecommendModel matchRecommendModel) {
        if (matchRecommendModel != null) {
            this.f16885p = matchRecommendModel;
            getSwipeCardAdapter().j().add(0, matchRecommendModel);
            getSwipeCardAdapter().notifyItemInserted(0);
            scrollToPosition(1);
            post(new Runnable() { // from class: com.cupidapp.live.match.view.l
                @Override // java.lang.Runnable
                public final void run() {
                    FKSwipeCardLayout.Y(FKSwipeCardLayout.this);
                }
            });
        }
    }

    public final void Z() {
        postDelayed(new Runnable() { // from class: com.cupidapp.live.match.view.k
            @Override // java.lang.Runnable
            public final void run() {
                FKSwipeCardLayout.a0(FKSwipeCardLayout.this);
            }
        }, 300L);
    }

    @Override // com.cupidapp.live.match.view.FKSwipeCardView, mc.a
    public void a(@Nullable Direction direction, float f10) {
        a0 a0Var;
        super.a(direction, f10);
        this.f16889t = true;
        if (!(K(this, 0, 1, null) instanceof MatchRecommendUserModel) || (a0Var = this.f16878i) == null) {
            return;
        }
        a0Var.s(f10);
    }

    @Override // com.cupidapp.live.match.view.FKSwipeCardView, mc.a
    public void b(@Nullable View view, int i10) {
        super.b(view, i10);
        Object J = J(i10);
        if (J instanceof LiveShowModel) {
            FKSwipeCardLiveViewHolder fKSwipeCardLiveViewHolder = this.f16887r;
            if (fKSwipeCardLiveViewHolder != null) {
                fKSwipeCardLiveViewHolder.v();
                return;
            }
            return;
        }
        if (J instanceof MatchRecommendUserModel) {
            FKSwipeCardViewHolder fKSwipeCardViewHolder = this.f16886q;
            if (fKSwipeCardViewHolder != null) {
                fKSwipeCardViewHolder.K();
            }
            FKSwipeCardViewHolder fKSwipeCardViewHolder2 = this.f16886q;
            if (fKSwipeCardViewHolder2 != null) {
                fKSwipeCardViewHolder2.J();
            }
        }
    }

    @Override // com.cupidapp.live.match.view.FKSwipeCardView, mc.a
    public void c(@Nullable Direction direction) {
        super.c(direction);
        this.f16882m++;
        T(direction);
        H();
        this.f16886q = null;
        this.f16887r = null;
        this.f16888s = null;
        this.f16890u = null;
        this.f16889t = false;
    }

    public final void c0(@NotNull Function0<kotlin.p> animationEnd) {
        kotlin.jvm.internal.s.i(animationEnd, "animationEnd");
        if (getVisibility() != 0) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, (Property<FKSwipeCardLayout, Float>) View.ALPHA, 0.0f, 1.0f);
            ofFloat.setDuration(300L);
            ofFloat.addListener(new b(animationEnd));
            ofFloat.start();
        }
    }

    @Override // com.cupidapp.live.match.view.FKSwipeCardView, mc.a
    public void d(@Nullable View view, int i10) {
        User user;
        super.d(view, i10);
        Object J = J(i10);
        if (J instanceof LiveShowModel) {
            LiveShowModel liveShowModel = (LiveShowModel) J;
            this.f16888s = liveShowModel;
            FKSwipeCardLiveViewHolder L = L(view, i10);
            this.f16887r = L;
            if (L != null) {
                L.u(liveShowModel);
            }
            S(liveShowModel);
            return;
        }
        if (J instanceof MatchRecommendUserModel) {
            MatchRecommendModel matchRecommendModel = this.f16885p;
            MatchRecommendUserModel matchRecommendUserModel = matchRecommendModel instanceof MatchRecommendUserModel ? (MatchRecommendUserModel) matchRecommendModel : null;
            MatchRecommendUserModel matchRecommendUserModel2 = (MatchRecommendUserModel) J;
            if (kotlin.jvm.internal.s.d((matchRecommendUserModel == null || (user = matchRecommendUserModel.getUser()) == null) ? null : user.userId(), matchRecommendUserModel2.getUser().userId())) {
                this.f16885p = null;
            }
            a0 a0Var = this.f16878i;
            if (a0Var != null) {
                a0Var.n((MatchRecommendModel) J);
            }
            FKSwipeCardViewHolder N = N(view, i10);
            this.f16886q = N;
            if (N != null) {
                ZodiacElfInfoModel zodiacInfo = matchRecommendUserModel2.getUser().getZodiacInfo();
                N.A(zodiacInfo != null ? zodiacInfo.getType() : null);
                N.C(matchRecommendUserModel2);
                N.z();
                if (kotlin.jvm.internal.s.d(p1.g.f52734a.y1().c(), Boolean.FALSE)) {
                    N.G();
                    a0 a0Var2 = this.f16878i;
                    if (a0Var2 != null) {
                        a0Var2.m();
                    }
                }
                if (matchRecommendUserModel2.getLiveShow() != null) {
                    N.I(matchRecommendUserModel2.getLiveShow());
                }
                View itemView = N.itemView;
                kotlin.jvm.internal.s.h(itemView, "itemView");
                Integer superLikedMeCombos = matchRecommendUserModel2.getUser().getSuperLikedMeCombos();
                U(itemView, superLikedMeCombos != null ? superLikedMeCombos.intValue() : 0);
                return;
            }
            return;
        }
        if (J instanceof MatchGroupCampaignModel) {
            a0 a0Var3 = this.f16878i;
            if (a0Var3 != null) {
                a0Var3.n((MatchRecommendModel) J);
            }
            MatchRecommendModel matchRecommendModel2 = this.f16885p;
            MatchGroupCampaignModel matchGroupCampaignModel = matchRecommendModel2 instanceof MatchGroupCampaignModel ? (MatchGroupCampaignModel) matchRecommendModel2 : null;
            if (kotlin.jvm.internal.s.d(matchGroupCampaignModel != null ? matchGroupCampaignModel.getCardId() : null, ((MatchGroupCampaignModel) J).getCardId())) {
                if (matchGroupCampaignModel != null) {
                    matchGroupCampaignModel.setHasSeeContent(false);
                }
                this.f16885p = null;
            }
            SwipeCardCampaignViewHolder I = I(view, i10);
            this.f16890u = I;
            if (I != null) {
                I.r(this.f16891v != null);
                return;
            }
            return;
        }
        if (J instanceof MatchMarketingModel) {
            a0 a0Var4 = this.f16878i;
            if (a0Var4 != null) {
                a0Var4.n((MatchRecommendModel) J);
            }
            MatchRecommendModel matchRecommendModel3 = this.f16885p;
            MatchMarketingModel matchMarketingModel = matchRecommendModel3 instanceof MatchMarketingModel ? (MatchMarketingModel) matchRecommendModel3 : null;
            if (kotlin.jvm.internal.s.d(matchMarketingModel != null ? matchMarketingModel.getConfigKey() : null, ((MatchMarketingModel) J).getConfigKey())) {
                this.f16885p = null;
            }
            SwipeCardMarketingPositionViewHolder M = M(view, i10);
            if (M != null) {
                M.r(this.f16891v != null);
            }
        }
    }

    public final void d0(boolean z10) {
        FKSwipeCardLiveViewHolder fKSwipeCardLiveViewHolder = this.f16887r;
        if (fKSwipeCardLiveViewHolder != null) {
            if (z10) {
                fKSwipeCardLiveViewHolder.v();
            } else {
                Object K = K(this, 0, 1, null);
                if (K instanceof LiveShowModel) {
                    fKSwipeCardLiveViewHolder.u((LiveShowModel) K);
                }
            }
        }
        FKSwipeCardViewHolder fKSwipeCardViewHolder = this.f16886q;
        if (fKSwipeCardViewHolder != null) {
            if (z10) {
                fKSwipeCardViewHolder.J();
                return;
            }
            Object K2 = K(this, 0, 1, null);
            if (K2 instanceof MatchRecommendUserModel) {
                MatchRecommendUserModel matchRecommendUserModel = (MatchRecommendUserModel) K2;
                if (matchRecommendUserModel.getLiveShow() != null) {
                    fKSwipeCardViewHolder.I(matchRecommendUserModel.getLiveShow());
                }
            }
        }
    }

    public final void e0(boolean z10) {
        FKSwipeCardViewHolder fKSwipeCardViewHolder = this.f16886q;
        if (fKSwipeCardViewHolder != null) {
            if (z10) {
                fKSwipeCardViewHolder.K();
            } else {
                fKSwipeCardViewHolder.z();
            }
        }
    }

    public final void f0(boolean z10) {
        setSwipeAnimationSetting(z10 ? Direction.Right : Direction.Left);
        o();
    }

    public final void g0() {
        Object systemService;
        if (Build.VERSION.SDK_INT >= 26) {
            VibrationEffect createOneShot = VibrationEffect.createOneShot(20L, -1);
            Context context = getContext();
            systemService = context != null ? context.getSystemService("vibrator") : null;
            kotlin.jvm.internal.s.g(systemService, "null cannot be cast to non-null type android.os.Vibrator");
            ((Vibrator) systemService).vibrate(createOneShot);
            return;
        }
        Context context2 = getContext();
        systemService = context2 != null ? context2.getSystemService("vibrator") : null;
        kotlin.jvm.internal.s.g(systemService, "null cannot be cast to non-null type android.os.Vibrator");
        ((Vibrator) systemService).vibrate(20L);
    }

    public final int getCurrentCardIndexOfPhoto() {
        FKSwipeCardViewHolder fKSwipeCardViewHolder = this.f16886q;
        if (fKSwipeCardViewHolder != null) {
            return fKSwipeCardViewHolder.w();
        }
        return 0;
    }

    @Nullable
    public final LiveShowModel getLiveShowCard() {
        return this.f16888s;
    }

    @NotNull
    public final List<Object> getSwipeCardData() {
        return getSwipeCardAdapter().j();
    }

    @Override // com.cupidapp.live.match.view.FKSwipeCardView, mc.a
    public void j() {
        a0 a0Var;
        super.j();
        if ((K(this, 0, 1, null) instanceof MatchRecommendUserModel) && (a0Var = this.f16878i) != null) {
            a0Var.j();
        }
        this.f16889t = false;
    }

    @Override // com.cupidapp.live.match.view.FKSwipeCardView, mc.a
    public void k() {
        super.k();
        this.f16882m--;
        a0 a0Var = this.f16878i;
        if (a0Var != null) {
            a0Var.k();
        }
    }

    @Override // com.cupidapp.live.match.view.FKSwipeCardFakeAvatarTipLayout.a
    public void l() {
        a0 a0Var = this.f16878i;
        if (a0Var != null) {
            a0Var.u();
        }
    }

    public final void setLiveShowCard(@Nullable LiveShowModel liveShowModel) {
        this.f16888s = liveShowModel;
    }

    public final void setSwipeCardListener(@NotNull a0 listener) {
        kotlin.jvm.internal.s.i(listener, "listener");
        this.f16878i = listener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKSwipeCardLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.i(context, "context");
        this.f16892w = new LinkedHashMap();
        this.f16875f = kotlin.c.b(new Function0<FKSwipeCardAdapter>() { // from class: com.cupidapp.live.match.view.FKSwipeCardLayout$swipeCardAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FKSwipeCardAdapter invoke() {
                FKSwipeCardAdapter fKSwipeCardAdapter = new FKSwipeCardAdapter(FKSwipeCardLayout.this);
                final FKSwipeCardLayout fKSwipeCardLayout = FKSwipeCardLayout.this;
                fKSwipeCardAdapter.l().k(i0.h(kotlin.f.a(Integer.valueOf(R$id.left_click_view), new Function2<Object, Integer, kotlin.p>() { // from class: com.cupidapp.live.match.view.FKSwipeCardLayout$swipeCardAdapter$2$1$1
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
                        if (obj instanceof MatchRecommendUserModel) {
                            FKSwipeCardLayout.this.C(true, i10);
                        }
                    }
                }), kotlin.f.a(Integer.valueOf(R$id.right_click_view), new Function2<Object, Integer, kotlin.p>() { // from class: com.cupidapp.live.match.view.FKSwipeCardLayout$swipeCardAdapter$2$1$2
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
                        if (obj instanceof MatchRecommendUserModel) {
                            FKSwipeCardLayout.this.C(false, i10);
                        }
                    }
                }), kotlin.f.a(Integer.valueOf(R$id.swipe_card_user_info), new Function2<Object, Integer, kotlin.p>() { // from class: com.cupidapp.live.match.view.FKSwipeCardLayout$swipeCardAdapter$2$1$3
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
                        /*  JADX ERROR: Method code generation error
                            java.lang.NullPointerException
                            */
                        /*
                            this = this;
                            boolean r2 = r1 instanceof com.cupidapp.live.match.model.MatchRecommendUserModel
                            if (r2 == 0) goto L11
                            com.cupidapp.live.match.view.FKSwipeCardLayout r2 = com.cupidapp.live.match.view.FKSwipeCardLayout.this
                            com.cupidapp.live.match.view.a0 r2 = com.cupidapp.live.match.view.FKSwipeCardLayout.A(r2)
                            if (r2 == 0) goto L11
                            com.cupidapp.live.match.model.MatchRecommendUserModel r1 = (com.cupidapp.live.match.model.MatchRecommendUserModel) r1
                            r2.l(r1)
                        L11:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.match.view.FKSwipeCardLayout$swipeCardAdapter$2$1$3.invoke(java.lang.Object, int):void");
                    }
                }), kotlin.f.a(Integer.valueOf(R$id.live_status_layout), new Function2<Object, Integer, kotlin.p>() { // from class: com.cupidapp.live.match.view.FKSwipeCardLayout$swipeCardAdapter$2$1$4
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
                        if (obj instanceof MatchRecommendUserModel) {
                            MatchRecommendUserModel matchRecommendUserModel = (MatchRecommendUserModel) obj;
                            if (matchRecommendUserModel.getLiveShow() != null) {
                                FKLiveForViewerActivity.G.a(FKSwipeCardLayout.this.getContext(), new FKLiveForViewerViewModel(matchRecommendUserModel.getLiveShow(), null, new LiveInRoomSensorModel("LIVE_WINDOW", null, SensorScene.Match, SensorPosition.Match, null, null, 48, null), false, 8, null), false);
                            }
                        }
                    }
                }), kotlin.f.a(Integer.valueOf(R$id.activity_img), new Function2<Object, Integer, kotlin.p>() { // from class: com.cupidapp.live.match.view.FKSwipeCardLayout$swipeCardAdapter$2$1$5
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
                        if (obj instanceof MatchGroupCampaignModel) {
                            MatchGroupCampaignModel matchGroupCampaignModel = (MatchGroupCampaignModel) obj;
                            matchGroupCampaignModel.setHasSeeContent(true);
                            j.a.b(com.cupidapp.live.base.router.j.f12156c, FKSwipeCardLayout.this.getContext(), matchGroupCampaignModel.getJumpUrl(), null, 4, null);
                            FKSwipeCardLayout.this.R((MatchRecommendModel) obj, GroupSocialLog.CampaignOperateAction.CARD);
                        }
                    }
                }), kotlin.f.a(Integer.valueOf(R$id.swipe_card_campaign_skip_btn), new Function2<Object, Integer, kotlin.p>() { // from class: com.cupidapp.live.match.view.FKSwipeCardLayout$swipeCardAdapter$2$1$6
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
                        if (obj instanceof MatchGroupCampaignModel) {
                            FKSwipeCardLayout.this.f0(false);
                            FKSwipeCardLayout.this.R((MatchRecommendModel) obj, GroupSocialLog.CampaignOperateAction.NOPE);
                        }
                    }
                }), kotlin.f.a(Integer.valueOf(R$id.swipe_card_campaign_see_btn), new Function2<Object, Integer, kotlin.p>() { // from class: com.cupidapp.live.match.view.FKSwipeCardLayout$swipeCardAdapter$2$1$7
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
                        if (obj instanceof MatchGroupCampaignModel) {
                            MatchGroupCampaignModel matchGroupCampaignModel = (MatchGroupCampaignModel) obj;
                            matchGroupCampaignModel.setHasSeeContent(true);
                            j.a.b(com.cupidapp.live.base.router.j.f12156c, FKSwipeCardLayout.this.getContext(), matchGroupCampaignModel.getJumpUrl(), null, 4, null);
                            FKSwipeCardLayout.this.R((MatchRecommendModel) obj, GroupSocialLog.CampaignOperateAction.ALOHA);
                        }
                    }
                }), kotlin.f.a(Integer.valueOf(R$id.swipe_card_campaign_cancel_nope_btn), new Function2<Object, Integer, kotlin.p>() { // from class: com.cupidapp.live.match.view.FKSwipeCardLayout$swipeCardAdapter$2$1$8
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
                        /*  JADX ERROR: Method code generation error
                            java.lang.NullPointerException
                            */
                        /*
                            this = this;
                            boolean r1 = r1 instanceof com.cupidapp.live.match.model.MatchGroupCampaignModel
                            if (r1 == 0) goto Lf
                            com.cupidapp.live.match.view.FKSwipeCardLayout r1 = com.cupidapp.live.match.view.FKSwipeCardLayout.this
                            com.cupidapp.live.match.view.a0 r1 = com.cupidapp.live.match.view.FKSwipeCardLayout.A(r1)
                            if (r1 == 0) goto Lf
                            r1.w()
                        Lf:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.match.view.FKSwipeCardLayout$swipeCardAdapter$2$1$8.invoke(java.lang.Object, int):void");
                    }
                }), kotlin.f.a(Integer.valueOf(R$id.marketing_btn_img), new Function2<Object, Integer, kotlin.p>() { // from class: com.cupidapp.live.match.view.FKSwipeCardLayout$swipeCardAdapter$2$1$9
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
                        if (obj instanceof MatchMarketingModel) {
                            j.a.b(com.cupidapp.live.base.router.j.f12156c, FKSwipeCardLayout.this.getContext(), ((MatchMarketingModel) obj).getJumpUrl(), null, 4, null);
                            FKSwipeCardLayout.this.R((MatchRecommendModel) obj, GroupSocialLog.CampaignOperateAction.UPGRADE);
                        }
                    }
                }), kotlin.f.a(Integer.valueOf(R$id.marketing_skip_txt), new Function2<Object, Integer, kotlin.p>() { // from class: com.cupidapp.live.match.view.FKSwipeCardLayout$swipeCardAdapter$2$1$10
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
                        if (obj instanceof MatchMarketingModel) {
                            FKSwipeCardLayout.this.f0(false);
                            FKSwipeCardLayout.this.R((MatchRecommendModel) obj, GroupSocialLog.CampaignOperateAction.NOPE);
                        }
                    }
                }), kotlin.f.a(Integer.valueOf(R$id.marketing_see_txt), new Function2<Object, Integer, kotlin.p>() { // from class: com.cupidapp.live.match.view.FKSwipeCardLayout$swipeCardAdapter$2$1$11
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
                        if (obj instanceof MatchMarketingModel) {
                            j.a.b(com.cupidapp.live.base.router.j.f12156c, FKSwipeCardLayout.this.getContext(), ((MatchMarketingModel) obj).getJumpUrl(), null, 4, null);
                            FKSwipeCardLayout.this.R((MatchRecommendModel) obj, GroupSocialLog.CampaignOperateAction.ALOHA);
                        }
                    }
                }), kotlin.f.a(Integer.valueOf(R$id.marketing_cancel_img), new Function2<Object, Integer, kotlin.p>() { // from class: com.cupidapp.live.match.view.FKSwipeCardLayout$swipeCardAdapter$2$1$12
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
                        /*  JADX ERROR: Method code generation error
                            java.lang.NullPointerException
                            */
                        /*
                            this = this;
                            boolean r1 = r1 instanceof com.cupidapp.live.match.model.MatchMarketingModel
                            if (r1 == 0) goto Lf
                            com.cupidapp.live.match.view.FKSwipeCardLayout r1 = com.cupidapp.live.match.view.FKSwipeCardLayout.this
                            com.cupidapp.live.match.view.a0 r1 = com.cupidapp.live.match.view.FKSwipeCardLayout.A(r1)
                            if (r1 == 0) goto Lf
                            r1.w()
                        Lf:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.match.view.FKSwipeCardLayout$swipeCardAdapter$2$1$12.invoke(java.lang.Object, int):void");
                    }
                })));
                fKSwipeCardAdapter.l().g(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.match.view.FKSwipeCardLayout$swipeCardAdapter$2$1$13
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                        invoke2(obj);
                        return kotlin.p.f51048a;
                    }

                    /* renamed from: invoke */
                    public final void invoke2(@Nullable Object obj) {
                        /*  JADX ERROR: Method code generation error
                            java.lang.NullPointerException
                            */
                        /*
                            this = this;
                            boolean r0 = r2 instanceof com.cupidapp.live.liveshow.model.LiveShowModel
                            if (r0 == 0) goto L11
                            com.cupidapp.live.match.view.FKSwipeCardLayout r0 = com.cupidapp.live.match.view.FKSwipeCardLayout.this
                            com.cupidapp.live.match.view.a0 r0 = com.cupidapp.live.match.view.FKSwipeCardLayout.A(r0)
                            if (r0 == 0) goto L11
                            com.cupidapp.live.liveshow.model.LiveShowModel r2 = (com.cupidapp.live.liveshow.model.LiveShowModel) r2
                            r0.t(r2)
                        L11:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.match.view.FKSwipeCardLayout$swipeCardAdapter$2$1$13.invoke2(java.lang.Object):void");
                    }
                });
                return fKSwipeCardAdapter;
            }
        });
        this.f16879j = new LinkedHashSet();
        this.f16880k = new LinkedHashSet();
        this.f16881l = new ArrayList();
        this.f16884o = new ArrayList();
        s();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKSwipeCardLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.s.i(context, "context");
        this.f16892w = new LinkedHashMap();
        this.f16875f = kotlin.c.b(new Function0<FKSwipeCardAdapter>() { // from class: com.cupidapp.live.match.view.FKSwipeCardLayout$swipeCardAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FKSwipeCardAdapter invoke() {
                FKSwipeCardAdapter fKSwipeCardAdapter = new FKSwipeCardAdapter(FKSwipeCardLayout.this);
                final FKSwipeCardLayout fKSwipeCardLayout = FKSwipeCardLayout.this;
                fKSwipeCardAdapter.l().k(i0.h(kotlin.f.a(Integer.valueOf(R$id.left_click_view), new Function2<Object, Integer, kotlin.p>() { // from class: com.cupidapp.live.match.view.FKSwipeCardLayout$swipeCardAdapter$2$1$1
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    /* renamed from: invoke */
                    public /* bridge */ /* synthetic */ kotlin.p mo1743invoke(Object obj, Integer num) {
                        invoke(obj, num.intValue());
                        return kotlin.p.f51048a;
                    }

                    public final void invoke(@Nullable Object obj, int i102) {
                        if (obj instanceof MatchRecommendUserModel) {
                            FKSwipeCardLayout.this.C(true, i102);
                        }
                    }
                }), kotlin.f.a(Integer.valueOf(R$id.right_click_view), new Function2<Object, Integer, kotlin.p>() { // from class: com.cupidapp.live.match.view.FKSwipeCardLayout$swipeCardAdapter$2$1$2
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    /* renamed from: invoke */
                    public /* bridge */ /* synthetic */ kotlin.p mo1743invoke(Object obj, Integer num) {
                        invoke(obj, num.intValue());
                        return kotlin.p.f51048a;
                    }

                    public final void invoke(@Nullable Object obj, int i102) {
                        if (obj instanceof MatchRecommendUserModel) {
                            FKSwipeCardLayout.this.C(false, i102);
                        }
                    }
                }), kotlin.f.a(Integer.valueOf(R$id.swipe_card_user_info), new Function2<Object, Integer, kotlin.p>() { // from class: com.cupidapp.live.match.view.FKSwipeCardLayout$swipeCardAdapter$2$1$3
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    /* renamed from: invoke */
                    public /* bridge */ /* synthetic */ kotlin.p mo1743invoke(Object obj, Integer num) {
                        invoke(obj, num.intValue());
                        return kotlin.p.f51048a;
                    }

                    /*  JADX ERROR: Method code generation error
                        java.lang.NullPointerException
                        */
                    public final void invoke(@org.jetbrains.annotations.Nullable java.lang.Object r1, int r2) {
                        /*
                            r0 = this;
                            boolean r2 = r1 instanceof com.cupidapp.live.match.model.MatchRecommendUserModel
                            if (r2 == 0) goto L11
                            com.cupidapp.live.match.view.FKSwipeCardLayout r2 = com.cupidapp.live.match.view.FKSwipeCardLayout.this
                            com.cupidapp.live.match.view.a0 r2 = com.cupidapp.live.match.view.FKSwipeCardLayout.A(r2)
                            if (r2 == 0) goto L11
                            com.cupidapp.live.match.model.MatchRecommendUserModel r1 = (com.cupidapp.live.match.model.MatchRecommendUserModel) r1
                            r2.l(r1)
                        L11:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.match.view.FKSwipeCardLayout$swipeCardAdapter$2$1$3.invoke(java.lang.Object, int):void");
                    }
                }), kotlin.f.a(Integer.valueOf(R$id.live_status_layout), new Function2<Object, Integer, kotlin.p>() { // from class: com.cupidapp.live.match.view.FKSwipeCardLayout$swipeCardAdapter$2$1$4
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    /* renamed from: invoke */
                    public /* bridge */ /* synthetic */ kotlin.p mo1743invoke(Object obj, Integer num) {
                        invoke(obj, num.intValue());
                        return kotlin.p.f51048a;
                    }

                    public final void invoke(@Nullable Object obj, int i102) {
                        if (obj instanceof MatchRecommendUserModel) {
                            MatchRecommendUserModel matchRecommendUserModel = (MatchRecommendUserModel) obj;
                            if (matchRecommendUserModel.getLiveShow() != null) {
                                FKLiveForViewerActivity.G.a(FKSwipeCardLayout.this.getContext(), new FKLiveForViewerViewModel(matchRecommendUserModel.getLiveShow(), null, new LiveInRoomSensorModel("LIVE_WINDOW", null, SensorScene.Match, SensorPosition.Match, null, null, 48, null), false, 8, null), false);
                            }
                        }
                    }
                }), kotlin.f.a(Integer.valueOf(R$id.activity_img), new Function2<Object, Integer, kotlin.p>() { // from class: com.cupidapp.live.match.view.FKSwipeCardLayout$swipeCardAdapter$2$1$5
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    /* renamed from: invoke */
                    public /* bridge */ /* synthetic */ kotlin.p mo1743invoke(Object obj, Integer num) {
                        invoke(obj, num.intValue());
                        return kotlin.p.f51048a;
                    }

                    public final void invoke(@Nullable Object obj, int i102) {
                        if (obj instanceof MatchGroupCampaignModel) {
                            MatchGroupCampaignModel matchGroupCampaignModel = (MatchGroupCampaignModel) obj;
                            matchGroupCampaignModel.setHasSeeContent(true);
                            j.a.b(com.cupidapp.live.base.router.j.f12156c, FKSwipeCardLayout.this.getContext(), matchGroupCampaignModel.getJumpUrl(), null, 4, null);
                            FKSwipeCardLayout.this.R((MatchRecommendModel) obj, GroupSocialLog.CampaignOperateAction.CARD);
                        }
                    }
                }), kotlin.f.a(Integer.valueOf(R$id.swipe_card_campaign_skip_btn), new Function2<Object, Integer, kotlin.p>() { // from class: com.cupidapp.live.match.view.FKSwipeCardLayout$swipeCardAdapter$2$1$6
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    /* renamed from: invoke */
                    public /* bridge */ /* synthetic */ kotlin.p mo1743invoke(Object obj, Integer num) {
                        invoke(obj, num.intValue());
                        return kotlin.p.f51048a;
                    }

                    public final void invoke(@Nullable Object obj, int i102) {
                        if (obj instanceof MatchGroupCampaignModel) {
                            FKSwipeCardLayout.this.f0(false);
                            FKSwipeCardLayout.this.R((MatchRecommendModel) obj, GroupSocialLog.CampaignOperateAction.NOPE);
                        }
                    }
                }), kotlin.f.a(Integer.valueOf(R$id.swipe_card_campaign_see_btn), new Function2<Object, Integer, kotlin.p>() { // from class: com.cupidapp.live.match.view.FKSwipeCardLayout$swipeCardAdapter$2$1$7
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    /* renamed from: invoke */
                    public /* bridge */ /* synthetic */ kotlin.p mo1743invoke(Object obj, Integer num) {
                        invoke(obj, num.intValue());
                        return kotlin.p.f51048a;
                    }

                    public final void invoke(@Nullable Object obj, int i102) {
                        if (obj instanceof MatchGroupCampaignModel) {
                            MatchGroupCampaignModel matchGroupCampaignModel = (MatchGroupCampaignModel) obj;
                            matchGroupCampaignModel.setHasSeeContent(true);
                            j.a.b(com.cupidapp.live.base.router.j.f12156c, FKSwipeCardLayout.this.getContext(), matchGroupCampaignModel.getJumpUrl(), null, 4, null);
                            FKSwipeCardLayout.this.R((MatchRecommendModel) obj, GroupSocialLog.CampaignOperateAction.ALOHA);
                        }
                    }
                }), kotlin.f.a(Integer.valueOf(R$id.swipe_card_campaign_cancel_nope_btn), new Function2<Object, Integer, kotlin.p>() { // from class: com.cupidapp.live.match.view.FKSwipeCardLayout$swipeCardAdapter$2$1$8
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    /* renamed from: invoke */
                    public /* bridge */ /* synthetic */ kotlin.p mo1743invoke(Object obj, Integer num) {
                        invoke(obj, num.intValue());
                        return kotlin.p.f51048a;
                    }

                    /*  JADX ERROR: Method code generation error
                        java.lang.NullPointerException
                        */
                    public final void invoke(@org.jetbrains.annotations.Nullable java.lang.Object r1, int r2) {
                        /*
                            r0 = this;
                            boolean r1 = r1 instanceof com.cupidapp.live.match.model.MatchGroupCampaignModel
                            if (r1 == 0) goto Lf
                            com.cupidapp.live.match.view.FKSwipeCardLayout r1 = com.cupidapp.live.match.view.FKSwipeCardLayout.this
                            com.cupidapp.live.match.view.a0 r1 = com.cupidapp.live.match.view.FKSwipeCardLayout.A(r1)
                            if (r1 == 0) goto Lf
                            r1.w()
                        Lf:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.match.view.FKSwipeCardLayout$swipeCardAdapter$2$1$8.invoke(java.lang.Object, int):void");
                    }
                }), kotlin.f.a(Integer.valueOf(R$id.marketing_btn_img), new Function2<Object, Integer, kotlin.p>() { // from class: com.cupidapp.live.match.view.FKSwipeCardLayout$swipeCardAdapter$2$1$9
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    /* renamed from: invoke */
                    public /* bridge */ /* synthetic */ kotlin.p mo1743invoke(Object obj, Integer num) {
                        invoke(obj, num.intValue());
                        return kotlin.p.f51048a;
                    }

                    public final void invoke(@Nullable Object obj, int i102) {
                        if (obj instanceof MatchMarketingModel) {
                            j.a.b(com.cupidapp.live.base.router.j.f12156c, FKSwipeCardLayout.this.getContext(), ((MatchMarketingModel) obj).getJumpUrl(), null, 4, null);
                            FKSwipeCardLayout.this.R((MatchRecommendModel) obj, GroupSocialLog.CampaignOperateAction.UPGRADE);
                        }
                    }
                }), kotlin.f.a(Integer.valueOf(R$id.marketing_skip_txt), new Function2<Object, Integer, kotlin.p>() { // from class: com.cupidapp.live.match.view.FKSwipeCardLayout$swipeCardAdapter$2$1$10
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    /* renamed from: invoke */
                    public /* bridge */ /* synthetic */ kotlin.p mo1743invoke(Object obj, Integer num) {
                        invoke(obj, num.intValue());
                        return kotlin.p.f51048a;
                    }

                    public final void invoke(@Nullable Object obj, int i102) {
                        if (obj instanceof MatchMarketingModel) {
                            FKSwipeCardLayout.this.f0(false);
                            FKSwipeCardLayout.this.R((MatchRecommendModel) obj, GroupSocialLog.CampaignOperateAction.NOPE);
                        }
                    }
                }), kotlin.f.a(Integer.valueOf(R$id.marketing_see_txt), new Function2<Object, Integer, kotlin.p>() { // from class: com.cupidapp.live.match.view.FKSwipeCardLayout$swipeCardAdapter$2$1$11
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    /* renamed from: invoke */
                    public /* bridge */ /* synthetic */ kotlin.p mo1743invoke(Object obj, Integer num) {
                        invoke(obj, num.intValue());
                        return kotlin.p.f51048a;
                    }

                    public final void invoke(@Nullable Object obj, int i102) {
                        if (obj instanceof MatchMarketingModel) {
                            j.a.b(com.cupidapp.live.base.router.j.f12156c, FKSwipeCardLayout.this.getContext(), ((MatchMarketingModel) obj).getJumpUrl(), null, 4, null);
                            FKSwipeCardLayout.this.R((MatchRecommendModel) obj, GroupSocialLog.CampaignOperateAction.ALOHA);
                        }
                    }
                }), kotlin.f.a(Integer.valueOf(R$id.marketing_cancel_img), new Function2<Object, Integer, kotlin.p>() { // from class: com.cupidapp.live.match.view.FKSwipeCardLayout$swipeCardAdapter$2$1$12
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    /* renamed from: invoke */
                    public /* bridge */ /* synthetic */ kotlin.p mo1743invoke(Object obj, Integer num) {
                        invoke(obj, num.intValue());
                        return kotlin.p.f51048a;
                    }

                    /*  JADX ERROR: Method code generation error
                        java.lang.NullPointerException
                        */
                    public final void invoke(@org.jetbrains.annotations.Nullable java.lang.Object r1, int r2) {
                        /*
                            r0 = this;
                            boolean r1 = r1 instanceof com.cupidapp.live.match.model.MatchMarketingModel
                            if (r1 == 0) goto Lf
                            com.cupidapp.live.match.view.FKSwipeCardLayout r1 = com.cupidapp.live.match.view.FKSwipeCardLayout.this
                            com.cupidapp.live.match.view.a0 r1 = com.cupidapp.live.match.view.FKSwipeCardLayout.A(r1)
                            if (r1 == 0) goto Lf
                            r1.w()
                        Lf:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.match.view.FKSwipeCardLayout$swipeCardAdapter$2$1$12.invoke(java.lang.Object, int):void");
                    }
                })));
                fKSwipeCardAdapter.l().g(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.match.view.FKSwipeCardLayout$swipeCardAdapter$2$1$13
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                        invoke2(obj);
                        return kotlin.p.f51048a;
                    }

                    /*  JADX ERROR: Method code generation error
                        java.lang.NullPointerException
                        */
                    /* renamed from: invoke */
                    public final void invoke2(@org.jetbrains.annotations.Nullable java.lang.Object r2) {
                        /*
                            r1 = this;
                            boolean r0 = r2 instanceof com.cupidapp.live.liveshow.model.LiveShowModel
                            if (r0 == 0) goto L11
                            com.cupidapp.live.match.view.FKSwipeCardLayout r0 = com.cupidapp.live.match.view.FKSwipeCardLayout.this
                            com.cupidapp.live.match.view.a0 r0 = com.cupidapp.live.match.view.FKSwipeCardLayout.A(r0)
                            if (r0 == 0) goto L11
                            com.cupidapp.live.liveshow.model.LiveShowModel r2 = (com.cupidapp.live.liveshow.model.LiveShowModel) r2
                            r0.t(r2)
                        L11:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.match.view.FKSwipeCardLayout$swipeCardAdapter$2$1$13.invoke2(java.lang.Object):void");
                    }
                });
                return fKSwipeCardAdapter;
            }
        });
        this.f16879j = new LinkedHashSet();
        this.f16880k = new LinkedHashSet();
        this.f16881l = new ArrayList();
        this.f16884o = new ArrayList();
        s();
    }
}
