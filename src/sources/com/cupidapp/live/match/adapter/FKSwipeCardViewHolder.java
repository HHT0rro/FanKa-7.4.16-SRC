package com.cupidapp.live.match.adapter;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$raw;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.imageloader.ImageLoaderUtil;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.model.ConstantsResult;
import com.cupidapp.live.base.network.model.ConstantsUrlModel;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.base.sensorslog.SensorsLogMatch;
import com.cupidapp.live.base.video.AppVideoLayout;
import com.cupidapp.live.base.view.animation.FKLottieAnimationView;
import com.cupidapp.live.base.view.animation.FKSVGAImageView;
import com.cupidapp.live.base.view.indicator.TopIndicatorLayout;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import com.cupidapp.live.match.model.MatchCardItemModel;
import com.cupidapp.live.match.model.MatchCardUserPostModel;
import com.cupidapp.live.match.model.MatchCardUserSpecInfoModel;
import com.cupidapp.live.match.model.MatchRecommendUserModel;
import com.cupidapp.live.match.view.FKSwipeCardFakeAvatarTipLayout;
import com.cupidapp.live.match.view.FKSwipeCardUserInfoLayout;
import com.cupidapp.live.match.view.FKSwipeCardUserInfoModel;
import com.cupidapp.live.match.view.FakeTipStyle;
import com.cupidapp.live.match.view.SwipeCardLiveStatusLayout;
import com.cupidapp.live.profile.model.MBTIInfoModel;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.profile.model.UserTagModel;
import com.cupidapp.live.profile.model.UserVipDetailModel;
import com.cupidapp.live.profile.model.ZodiacElfInfoModel;
import com.cupidapp.live.profile.model.ZodiacElfType;
import com.cupidapp.live.setting.model.AvatarProfileModel;
import com.cupidapp.live.track.group.GroupOthersLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.t;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p1.g;
import z0.h;
import z0.x;
import z0.y;
import z0.z;

/* compiled from: FKSwipeCardAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKSwipeCardViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public static final a f16626i = new a(null);

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final FKSwipeCardFakeAvatarTipLayout.a f16627c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public final List<MatchCardItemModel> f16628d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public User f16629e;

    /* renamed from: f, reason: collision with root package name */
    public int f16630f;

    /* renamed from: g, reason: collision with root package name */
    public int f16631g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public String f16632h;

    /* compiled from: FKSwipeCardAdapter.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FKSwipeCardViewHolder a(@NotNull ViewGroup parent, @NotNull FKSwipeCardFakeAvatarTipLayout.a callback) {
            s.i(parent, "parent");
            s.i(callback, "callback");
            return new FKSwipeCardViewHolder(z.b(parent, R$layout.view_holder_swipe_card, false, 2, null), callback);
        }
    }

    /* compiled from: FKSwipeCardAdapter.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animation) {
            s.i(animation, "animation");
            ((ConstraintLayout) FKSwipeCardViewHolder.this.itemView.findViewById(R$id.click_guide_layout)).setVisibility(0);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKSwipeCardViewHolder(@NotNull final View itemView, @NotNull FKSwipeCardFakeAvatarTipLayout.a callback) {
        super(itemView);
        s.i(itemView, "itemView");
        s.i(callback, "callback");
        this.f16627c = callback;
        this.f16628d = new ArrayList();
        ((AppVideoLayout) itemView.findViewById(R$id.swipe_card_video_avatar)).setCornerRadius(h.c(this, 8.0f));
        ConstraintLayout constraintLayout = (ConstraintLayout) itemView.findViewById(R$id.click_guide_layout);
        s.h(constraintLayout, "itemView.click_guide_layout");
        y.d(constraintLayout, new Function1<View, p>() { // from class: com.cupidapp.live.match.adapter.FKSwipeCardViewHolder.1
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
                ((ConstraintLayout) View.this.findViewById(R$id.click_guide_layout)).setVisibility(8);
            }
        });
    }

    public final void A(@Nullable Integer num) {
        int i10;
        int value = ZodiacElfType.HEART_BEAT.getValue();
        if (num != null && num.intValue() == value) {
            i10 = R$raw.lottie_zodiac_elf_heartbeat;
        } else {
            int value2 = ZodiacElfType.ASK_QUESTION.getValue();
            if (num != null && num.intValue() == value2) {
                i10 = R$raw.lottie_zodiac_elf_ask_question;
            } else {
                i10 = (num != null && num.intValue() == ZodiacElfType.ZODIAC_ELF.getValue()) ? R$raw.lottie_zodiac_elf : 0;
            }
        }
        if (i10 > 0) {
            View view = this.itemView;
            int i11 = R$id.swipe_card_lottie_view;
            ((FKLottieAnimationView) view.findViewById(i11)).setLottieAnimation(i10);
            ((FKLottieAnimationView) this.itemView.findViewById(i11)).L();
        }
    }

    public final void B(String str) {
        if (str == null || str.length() == 0) {
            ((RelativeLayout) this.itemView.findViewById(R$id.match_travel_tag_rl)).setVisibility(8);
            return;
        }
        ((TextView) this.itemView.findViewById(R$id.travel_city_txt)).setText(str);
        View view = this.itemView;
        int i10 = R$id.match_travel_tag_rl;
        ((RelativeLayout) view.findViewById(i10)).setVisibility(0);
        RelativeLayout relativeLayout = (RelativeLayout) this.itemView.findViewById(i10);
        s.h(relativeLayout, "itemView.match_travel_tag_rl");
        y.d(relativeLayout, new Function1<View, p>() { // from class: com.cupidapp.live.match.adapter.FKSwipeCardViewHolder$renderTravelTag$1
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
                ConstantsUrlModel urlModel;
                String travelH5Url;
                j.a aVar = j.f12156c;
                Context context = FKSwipeCardViewHolder.this.itemView.getContext();
                ConstantsResult q10 = g.f52734a.q();
                j.a.b(aVar, context, (q10 == null || (urlModel = q10.getUrlModel()) == null || (travelH5Url = urlModel.getTravelH5Url()) == null) ? null : x.a(travelH5Url, "entrance_name", "MATCH"), null, 4, null);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void C(@org.jetbrains.annotations.NotNull com.cupidapp.live.match.model.MatchRecommendUserModel r22) {
        /*
            r21 = this;
            r0 = r21
            java.lang.String r1 = "card"
            r2 = r22
            kotlin.jvm.internal.s.i(r2, r1)
            com.cupidapp.live.track.group.GroupSocialLog r3 = com.cupidapp.live.track.group.GroupSocialLog.f18708a
            com.cupidapp.live.base.sensorslog.SensorScene r1 = com.cupidapp.live.base.sensorslog.SensorScene.Match
            java.lang.String r4 = r1.getValue()
            com.cupidapp.live.profile.model.User r5 = r22.getUser()
            java.lang.String r5 = r5.userId()
            java.util.Map r6 = r22.getRecommendContext()
            com.cupidapp.live.profile.model.User r8 = r22.getUser()
            java.util.List<com.cupidapp.live.match.model.MatchCardItemModel> r7 = r0.f16628d
            int r9 = r7.size()
            java.lang.String r10 = r0.f16632h
            java.util.List<com.cupidapp.live.match.model.MatchCardItemModel> r7 = r0.f16628d
            r11 = 0
            java.lang.Object r7 = r7.get(r11)
            com.cupidapp.live.match.model.MatchCardItemModel r7 = (com.cupidapp.live.match.model.MatchCardItemModel) r7
            com.cupidapp.live.base.network.model.ImageModel r7 = r7.getAvatar()
            r18 = 0
            if (r7 == 0) goto L40
            java.lang.String r7 = r7.getImageId()
            r12 = r7
            goto L42
        L40:
            r12 = r18
        L42:
            com.cupidapp.live.profile.model.User r7 = r22.getUser()
            java.lang.String r7 = r7.getNewUserTag()
            r13 = 1
            if (r7 == 0) goto L56
            int r7 = r7.length()
            if (r7 != 0) goto L54
            goto L56
        L54:
            r7 = 0
            goto L57
        L56:
            r7 = 1
        L57:
            r14 = r7 ^ 1
            com.cupidapp.live.liveshow.model.LiveShowModel r7 = r22.getLiveShow()
            if (r7 == 0) goto L61
            r15 = 1
            goto L62
        L61:
            r15 = 0
        L62:
            r16 = 0
            com.cupidapp.live.profile.model.User r7 = r22.getUser()
            java.lang.String r7 = r7.getTravelCity()
            if (r7 == 0) goto L7c
            int r7 = r7.length()
            if (r7 <= 0) goto L76
            r7 = 1
            goto L77
        L76:
            r7 = 0
        L77:
            if (r7 != r13) goto L7c
            r17 = 1
            goto L7e
        L7c:
            r17 = 0
        L7e:
            r19 = 1024(0x400, float:1.435E-42)
            r20 = 0
            r7 = 1
            r11 = r12
            r12 = r14
            r13 = r15
            r14 = r16
            r15 = r17
            r16 = r19
            r17 = r20
            com.cupidapp.live.track.group.GroupSocialLog.x(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            com.cupidapp.live.liveshow.model.LiveShowModel r3 = r22.getLiveShow()
            if (r3 == 0) goto Lc4
            com.cupidapp.live.liveshow.model.LiveShowModel r2 = r22.getLiveShow()
            com.cupidapp.live.base.sensorslog.SensorsLogLiveShow r4 = com.cupidapp.live.base.sensorslog.SensorsLogLiveShow.f12212a
            java.lang.String r5 = r2.getItemId()
            r6 = 0
            com.cupidapp.live.base.sensorslog.SensorPosition r7 = com.cupidapp.live.base.sensorslog.SensorPosition.Match
            r9 = 0
            r10 = 0
            r11 = 0
            com.cupidapp.live.base.sensorslog.SensorsLogLiveShow$EnterLiveShowSource r12 = com.cupidapp.live.base.sensorslog.SensorsLogLiveShow.EnterLiveShowSource.LIVE_WINDOW
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            com.cupidapp.live.liveshow.model.RedEnvelopeTagModel r2 = r2.getRedPacketInfo()
            if (r2 == 0) goto Lbc
            java.lang.String r2 = r2.getIconCategory()
            r18 = r2
        Lbc:
            r19 = 7168(0x1c00, float:1.0045E-41)
            r20 = 0
            r8 = r1
            com.cupidapp.live.base.sensorslog.SensorsLogLiveShow.p(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
        Lc4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.match.adapter.FKSwipeCardViewHolder.C(com.cupidapp.live.match.model.MatchRecommendUserModel):void");
    }

    public final void D(String str, ImageModel imageModel) {
        if (this.f16631g > this.f16630f) {
            User user = this.f16629e;
            if (user != null) {
                SensorsLogMatch.f12215a.d(user.userId(), this.f16631g, this.f16628d.size(), null, SensorPosition.Match, SensorScene.Match, str, imageModel != null ? imageModel.getImageId() : null);
            }
            this.f16630f = this.f16631g;
        }
    }

    public final boolean E() {
        if (this.f16631g >= this.f16628d.size() - 1) {
            return true;
        }
        this.f16631g++;
        L(true);
        return false;
    }

    public final boolean F(MatchCardItemModel matchCardItemModel) {
        if (this.f16631g != 0) {
            String summary = matchCardItemModel.getSummary();
            if (!(summary == null || summary.length() == 0)) {
                return false;
            }
            List<String> commonhobby = matchCardItemModel.getCommonhobby();
            if (!(commonhobby == null || commonhobby.isEmpty())) {
                return false;
            }
            List<MatchCardUserSpecInfoModel> profile = matchCardItemModel.getProfile();
            if (!(profile == null || profile.isEmpty())) {
                return false;
            }
            List<MatchCardUserPostModel> post = matchCardItemModel.getPost();
            if (!(post == null || post.isEmpty()) || matchCardItemModel.getUserStoryLabel() != null) {
                return false;
            }
        }
        return true;
    }

    public final void G() {
        if (this.f16628d.size() > 1) {
            g gVar = g.f52734a;
            if (s.d(gVar.z1().c(), Boolean.TRUE)) {
                gVar.z1().d(Boolean.FALSE);
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat((ConstraintLayout) this.itemView.findViewById(R$id.click_guide_layout), (Property<ConstraintLayout, Float>) View.ALPHA, 0.0f, 1.0f);
                ofFloat.setDuration(1000L);
                ofFloat.addListener(new b());
                ofFloat.start();
                return;
            }
        }
        ((ConstraintLayout) this.itemView.findViewById(R$id.click_guide_layout)).setVisibility(8);
    }

    public final void H() {
        FakeTipStyle fakeTipStyle;
        if (o() instanceof MatchRecommendUserModel) {
            Object o10 = o();
            s.g(o10, "null cannot be cast to non-null type com.cupidapp.live.match.model.MatchRecommendUserModel");
            Boolean avatarWindowTipShow = ((MatchRecommendUserModel) o10).getAvatarWindowTipShow();
            Boolean bool = Boolean.TRUE;
            if (s.d(avatarWindowTipShow, bool)) {
                g gVar = g.f52734a;
                Integer i10 = gVar.i();
                if (i10 != null && i10.intValue() == 1) {
                    fakeTipStyle = FakeTipStyle.CAN_SEE_DETAIL;
                } else {
                    Integer i11 = gVar.i();
                    if (i11 != null && i11.intValue() == 2) {
                        if (s.d(gVar.A1(), bool)) {
                            gVar.H3(Boolean.FALSE);
                            fakeTipStyle = FakeTipStyle.UPLOAD_TIP_GUIDE;
                        } else {
                            fakeTipStyle = FakeTipStyle.UPLOAD_TIP;
                        }
                    } else {
                        fakeTipStyle = FakeTipStyle.NONE;
                    }
                }
            } else {
                fakeTipStyle = FakeTipStyle.NONE;
            }
        } else {
            fakeTipStyle = FakeTipStyle.NONE;
        }
        FKSwipeCardFakeAvatarTipLayout fKSwipeCardFakeAvatarTipLayout = (FKSwipeCardFakeAvatarTipLayout) this.itemView.findViewById(R$id.fake_avatar_layout);
        if (fKSwipeCardFakeAvatarTipLayout != null) {
            fKSwipeCardFakeAvatarTipLayout.h(fakeTipStyle);
        }
    }

    public final void I(@NotNull LiveShowModel liveShow) {
        s.i(liveShow, "liveShow");
        ((SwipeCardLiveStatusLayout) this.itemView.findViewById(R$id.live_status_layout)).d(liveShow);
    }

    public final void J() {
        ((SwipeCardLiveStatusLayout) this.itemView.findViewById(R$id.live_status_layout)).e();
    }

    public final void K() {
        View view = this.itemView;
        int i10 = R$id.swipe_card_video_avatar;
        AppVideoLayout appVideoLayout = (AppVideoLayout) view.findViewById(i10);
        s.h(appVideoLayout, "itemView.swipe_card_video_avatar");
        if (appVideoLayout.getVisibility() == 0) {
            ((AppVideoLayout) this.itemView.findViewById(i10)).f();
        }
    }

    public final void L(boolean z10) {
        int size = this.f16628d.size();
        int i10 = this.f16631g;
        if (i10 >= 0 && i10 < size) {
            MatchCardItemModel matchCardItemModel = this.f16628d.get(i10);
            if (z10) {
                K();
            }
            if (matchCardItemModel.getVideo() == null) {
                View view = this.itemView;
                int i11 = R$id.swipe_card_avatar;
                ((ImageLoaderView) view.findViewById(i11)).setVisibility(0);
                ((AppVideoLayout) this.itemView.findViewById(R$id.swipe_card_video_avatar)).setVisibility(8);
                ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(i11);
                s.h(imageLoaderView, "itemView.swipe_card_avatar");
                ImageLoaderView.g(imageLoaderView, matchCardItemModel.getAvatar(), null, null, 6, null);
            } else {
                ((ImageLoaderView) this.itemView.findViewById(R$id.swipe_card_avatar)).setVisibility(8);
                View view2 = this.itemView;
                int i12 = R$id.swipe_card_video_avatar;
                ((AppVideoLayout) view2.findViewById(i12)).setVisibility(0);
                ((AppVideoLayout) this.itemView.findViewById(i12)).d(matchCardItemModel.getVideo(), matchCardItemModel.getAvatar());
            }
            if (z10) {
                z();
            }
            ((TopIndicatorLayout) this.itemView.findViewById(R$id.swipe_card_top_indicator)).setCurrentPager(this.f16631g);
            v(matchCardItemModel, z10);
        }
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof MatchRecommendUserModel) {
            this.f16628d.clear();
            MatchRecommendUserModel matchRecommendUserModel = (MatchRecommendUserModel) obj;
            this.f16629e = matchRecommendUserModel.getUser();
            this.f16630f = 0;
            this.f16631g = 0;
            List<MatchCardItemModel> multiAvatars = matchRecommendUserModel.getMultiAvatars();
            if (!(multiAvatars == null || multiAvatars.isEmpty())) {
                this.f16628d.addAll(matchRecommendUserModel.getMultiAvatars());
            } else {
                List<AvatarProfileModel> avatarProfile = matchRecommendUserModel.getUser().getAvatarProfile();
                List<MatchCardItemModel> list = this.f16628d;
                ArrayList arrayList = new ArrayList(t.t(avatarProfile, 10));
                for (AvatarProfileModel avatarProfileModel : avatarProfile) {
                    arrayList.add(new MatchCardItemModel(avatarProfileModel.getAvatarImage(), avatarProfileModel.getAvatarVideo(), null, null, null, null, null, 124, null));
                }
                list.addAll(arrayList);
            }
            ((TopIndicatorLayout) this.itemView.findViewById(R$id.swipe_card_top_indicator)).setPagerCount(this.f16628d.size());
            L(false);
            ((FKSwipeCardFakeAvatarTipLayout) this.itemView.findViewById(R$id.fake_avatar_layout)).setCallback(this.f16627c);
            if (matchRecommendUserModel.getAlohaGetIcon() != null) {
                View view = this.itemView;
                int i10 = R$id.aloha_tip_view;
                ((ImageLoaderView) view.findViewById(i10)).setVisibility(0);
                int c4 = h.c(this, 20.0f);
                int scaleWidthByHeight = matchRecommendUserModel.getAlohaGetIcon().getScaleWidthByHeight(c4);
                ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(i10);
                s.h(imageLoaderView, "itemView.aloha_tip_view");
                y.n(imageLoaderView, Integer.valueOf(scaleWidthByHeight), Integer.valueOf(c4));
                ImageLoaderView imageLoaderView2 = (ImageLoaderView) this.itemView.findViewById(i10);
                s.h(imageLoaderView2, "itemView.aloha_tip_view");
                ImageLoaderView.g(imageLoaderView2, matchRecommendUserModel.getAlohaGetIcon(), null, null, 6, null);
                GroupOthersLog.M(GroupOthersLog.f18702a, GroupOthersLog.GuideType.HE_LIKES_YOU, SensorPosition.Match, SensorScene.Match, null, 8, null);
            } else {
                ((ImageLoaderView) this.itemView.findViewById(R$id.aloha_tip_view)).setVisibility(8);
            }
            B(matchRecommendUserModel.getUser().getTravelCity());
            ((SwipeCardLiveStatusLayout) this.itemView.findViewById(R$id.live_status_layout)).b(matchRecommendUserModel.getLiveShow());
            ((FKSVGAImageView) this.itemView.findViewById(R$id.super_like_svga_view)).setVisibility(8);
            y(matchRecommendUserModel.getUser().getIndividuationFrameConfig());
        }
    }

    public final void u(Drawable drawable) {
        View view = this.itemView;
        int i10 = R$id.swipe_card_border_img;
        view.findViewById(i10).setBackground(drawable);
        if (drawable == null) {
            ((CardView) this.itemView.findViewById(R$id.swipe_card_parent_card_view)).setRadius(h.c(this, 8.0f));
            this.itemView.findViewById(i10).setVisibility(8);
            TopIndicatorLayout topIndicatorLayout = (TopIndicatorLayout) this.itemView.findViewById(R$id.swipe_card_top_indicator);
            s.h(topIndicatorLayout, "itemView.swipe_card_top_indicator");
            y.m(topIndicatorLayout, null, Integer.valueOf(h.c(this, 12.0f)), null, null, 13, null);
            LinearLayout linearLayout = (LinearLayout) this.itemView.findViewById(R$id.swipe_card_right_top_linear_layout);
            s.h(linearLayout, "itemView.swipe_card_right_top_linear_layout");
            y.m(linearLayout, null, null, Integer.valueOf(h.c(this, 12.0f)), null, 11, null);
            FKSwipeCardUserInfoLayout fKSwipeCardUserInfoLayout = (FKSwipeCardUserInfoLayout) this.itemView.findViewById(R$id.swipe_card_user_info);
            s.h(fKSwipeCardUserInfoLayout, "itemView.swipe_card_user_info");
            y.m(fKSwipeCardUserInfoLayout, Integer.valueOf(h.c(this, 0.0f)), null, null, null, 14, null);
            return;
        }
        ((CardView) this.itemView.findViewById(R$id.swipe_card_parent_card_view)).setRadius(h.c(this, 16.0f));
        this.itemView.findViewById(i10).setVisibility(0);
        TopIndicatorLayout topIndicatorLayout2 = (TopIndicatorLayout) this.itemView.findViewById(R$id.swipe_card_top_indicator);
        s.h(topIndicatorLayout2, "itemView.swipe_card_top_indicator");
        y.m(topIndicatorLayout2, null, Integer.valueOf(h.c(this, 14.0f)), null, null, 13, null);
        LinearLayout linearLayout2 = (LinearLayout) this.itemView.findViewById(R$id.swipe_card_right_top_linear_layout);
        s.h(linearLayout2, "itemView.swipe_card_right_top_linear_layout");
        y.m(linearLayout2, null, null, Integer.valueOf(h.c(this, 22.0f)), null, 11, null);
        FKSwipeCardUserInfoLayout fKSwipeCardUserInfoLayout2 = (FKSwipeCardUserInfoLayout) this.itemView.findViewById(R$id.swipe_card_user_info);
        s.h(fKSwipeCardUserInfoLayout2, "itemView.swipe_card_user_info");
        y.m(fKSwipeCardUserInfoLayout2, Integer.valueOf(h.c(this, 4.0f)), null, null, null, 14, null);
    }

    public final void v(final MatchCardItemModel matchCardItemModel, final boolean z10) {
        String str;
        String str2;
        String str3;
        ZodiacElfInfoModel zodiacElfInfoModel;
        MBTIInfoModel mBTIInfoModel;
        String userProfileSummaryInfo;
        User user;
        if (F(matchCardItemModel)) {
            User user2 = this.f16629e;
            if ((user2 != null ? user2.getAge() : null) != null) {
                User user3 = this.f16629e;
                String userProfileSummaryInfo2 = user3 != null ? user3.getUserProfileSummaryInfo() : null;
                if (!(userProfileSummaryInfo2 == null || userProfileSummaryInfo2.length() == 0)) {
                    Context context = this.itemView.getContext();
                    User user4 = this.f16629e;
                    s.f(user4);
                    User user5 = this.f16629e;
                    s.f(user5);
                    userProfileSummaryInfo = context.getString(R$string.age_and_basic_info, user4.getAge(), user5.getUserProfileSummaryInfo());
                } else {
                    Context context2 = this.itemView.getContext();
                    User user6 = this.f16629e;
                    s.f(user6);
                    userProfileSummaryInfo = context2.getString(R$string.comma_and_user_age, user6.getAge());
                }
            } else {
                User user7 = this.f16629e;
                userProfileSummaryInfo = user7 != null ? user7.getUserProfileSummaryInfo() : null;
            }
            User user8 = this.f16629e;
            String activeDesc = user8 != null ? user8.getActiveDesc() : null;
            User user9 = this.f16629e;
            String newUserTag = user9 != null ? user9.getNewUserTag() : null;
            User user10 = this.f16629e;
            ZodiacElfInfoModel zodiacInfo = user10 != null ? user10.getZodiacInfo() : null;
            str2 = userProfileSummaryInfo;
            str = activeDesc;
            str3 = newUserTag;
            zodiacElfInfoModel = zodiacInfo;
            mBTIInfoModel = (activeDesc == null && newUserTag == null && zodiacInfo == null && (user = this.f16629e) != null) ? user.getMbtiInfo() : null;
        } else {
            str = null;
            str2 = null;
            str3 = null;
            zodiacElfInfoModel = null;
            mBTIInfoModel = null;
        }
        FKSwipeCardUserInfoLayout fKSwipeCardUserInfoLayout = (FKSwipeCardUserInfoLayout) this.itemView.findViewById(R$id.swipe_card_user_info);
        User user11 = this.f16629e;
        String name = user11 != null ? user11.getName() : null;
        User user12 = this.f16629e;
        UserVipDetailModel userVipModel = user12 != null ? user12.getUserVipModel() : null;
        User user13 = this.f16629e;
        List<UserTagModel> userTags = user13 != null ? user13.getUserTags() : null;
        User user14 = this.f16629e;
        String userTagsEmptyText = user14 != null ? user14.getUserTagsEmptyText() : null;
        User user15 = this.f16629e;
        ImageModel profileLevelIcon = user15 != null ? user15.getProfileLevelIcon() : null;
        User user16 = this.f16629e;
        fKSwipeCardUserInfoLayout.m(new FKSwipeCardUserInfoModel(name, userVipModel, str, str2, userTags, userTagsEmptyText, matchCardItemModel, str3, profileLevelIcon, user16 != null ? user16.getGroupMedal() : null, zodiacElfInfoModel, mBTIInfoModel), z10, new Function1<String, p>() { // from class: com.cupidapp.live.match.adapter.FKSwipeCardViewHolder$configUserInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(String str4) {
                invoke2(str4);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable String str4) {
                if (z10) {
                    this.D(str4, matchCardItemModel.getAvatar());
                } else {
                    this.f16632h = str4;
                }
            }
        });
    }

    public final int w() {
        return this.f16631g;
    }

    public final boolean x() {
        int i10 = this.f16631g;
        if (i10 <= 0) {
            return true;
        }
        this.f16631g = i10 - 1;
        L(true);
        return false;
    }

    public final void y(String str) {
        if (str == null || str.length() == 0) {
            u(null);
            return;
        }
        ImageLoaderUtil imageLoaderUtil = ImageLoaderUtil.f11832a;
        Context context = this.itemView.getContext();
        s.h(context, "itemView.context");
        imageLoaderUtil.h(context, str, new Function1<Drawable, p>() { // from class: com.cupidapp.live.match.adapter.FKSwipeCardViewHolder$loadSwipeCardBorder$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Drawable drawable) {
                invoke2(drawable);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Drawable drawable) {
                FKSwipeCardViewHolder.this.u(drawable);
            }
        });
    }

    public final void z() {
        View view = this.itemView;
        int i10 = R$id.swipe_card_video_avatar;
        AppVideoLayout appVideoLayout = (AppVideoLayout) view.findViewById(i10);
        s.h(appVideoLayout, "itemView.swipe_card_video_avatar");
        if (appVideoLayout.getVisibility() == 0) {
            ((AppVideoLayout) this.itemView.findViewById(i10)).e();
        }
    }
}
