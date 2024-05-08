package com.cupidapp.live.liveshow.view.summary;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.view.RoundedFrameLayout;
import com.cupidapp.live.base.view.animation.FKWebpAnimationView;
import com.cupidapp.live.base.view.m;
import com.cupidapp.live.liveshow.model.AnchorModel;
import com.cupidapp.live.liveshow.model.CardInfoModel;
import com.cupidapp.live.liveshow.model.MiniProfilePopularFeedModel;
import com.cupidapp.live.liveshow.model.MiniProfileUserTagModel;
import com.cupidapp.live.liveshow.view.miniprofile.FKLiveMiniProfileTagLayout;
import com.cupidapp.live.liveshow.view.miniprofile.FKLiveMiniProfileTagView;
import com.cupidapp.live.liveshow.view.tag.UserGiftWallLayout;
import com.cupidapp.live.liveshow.view.tag.UserLiveShowRanksLinearLayout;
import com.cupidapp.live.profile.model.User;
import java.util.List;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.z;

/* compiled from: LiveEndAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveEndAnchorViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public static final a f15947f = new a(null);

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public AnimatorSet f15948c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public ObjectAnimator f15949d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public ObjectAnimator f15950e;

    /* compiled from: LiveEndAdapter.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final LiveEndAnchorViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new LiveEndAnchorViewHolder(z.b(parent, R$layout.view_holder_live_end_anchor, false, 2, null));
        }
    }

    /* compiled from: Animator.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class b implements Animator.AnimatorListener {
        public b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animator) {
            s.i(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animator) {
            s.i(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@NotNull Animator animator) {
            s.i(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animator) {
            s.i(animator, "animator");
            TextView textView = (TextView) LiveEndAnchorViewHolder.this.itemView.findViewById(R$id.popular_feed_textview);
            s.h(textView, "itemView.popular_feed_textview");
            textView.setVisibility(0);
        }
    }

    /* compiled from: Animator.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class c implements Animator.AnimatorListener {
        public c() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animator) {
            s.i(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animator) {
            s.i(animator, "animator");
            TextView textView = (TextView) LiveEndAnchorViewHolder.this.itemView.findViewById(R$id.popular_feed_textview);
            s.h(textView, "itemView.popular_feed_textview");
            textView.setVisibility(4);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@NotNull Animator animator) {
            s.i(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animator) {
            s.i(animator, "animator");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveEndAnchorViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
        RoundedFrameLayout roundedFrameLayout = (RoundedFrameLayout) itemView.findViewById(R$id.bg_container_layout);
        s.h(roundedFrameLayout, "itemView.bg_container_layout");
        m.a.d(roundedFrameLayout, h.c(this, 8.0f), 0.0f, h.c(this, 8.0f), 0.0f, 10, null);
        ((TextView) itemView.findViewById(R$id.live_end_textview)).getPaint().setFakeBoldText(true);
        ((TextView) itemView.findViewById(R$id.popular_feed_textview)).getPaint().setFakeBoldText(true);
        ((TextView) itemView.findViewById(R$id.username_textview)).getPaint().setFakeBoldText(true);
        ((TextView) itemView.findViewById(R$id.user_info_textview)).getPaint().setFakeBoldText(true);
        ((TextView) itemView.findViewById(R$id.view_profile_textview)).getPaint().setFakeBoldText(true);
        ((TextView) itemView.findViewById(R$id.match_status_textview)).getPaint().setFakeBoldText(true);
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof AnchorModel) {
            TextView textView = (TextView) this.itemView.findViewById(R$id.username_textview);
            AnchorModel anchorModel = (AnchorModel) obj;
            User user = anchorModel.getUser();
            textView.setText(user != null ? user.getName() : null);
            TextView textView2 = (TextView) this.itemView.findViewById(R$id.user_info_textview);
            User user2 = anchorModel.getUser();
            textView2.setText(user2 != null ? user2.getUserProfileSummaryInfo() : null);
            ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(R$id.avatar_imageview);
            s.h(imageLoaderView, "itemView.avatar_imageview");
            User user3 = anchorModel.getUser();
            ImageLoaderView.g(imageLoaderView, user3 != null ? user3.getAvatarImage() : null, null, null, 6, null);
            List<MiniProfilePopularFeedModel> popularFeedList = anchorModel.getPopularFeedList();
            boolean z10 = true;
            if ((popularFeedList != null ? popularFeedList.size() : 0) > 1) {
                t();
            } else {
                TextView textView3 = (TextView) this.itemView.findViewById(R$id.popular_feed_textview);
                s.h(textView3, "itemView.popular_feed_textview");
                textView3.setVisibility(4);
            }
            if (anchorModel.getAvatarBackgroundImage() == null) {
                ImageLoaderView imageLoaderView2 = (ImageLoaderView) this.itemView.findViewById(R$id.avatar_bg_imageview);
                s.h(imageLoaderView2, "itemView.avatar_bg_imageview");
                imageLoaderView2.setVisibility(4);
            } else {
                View view = this.itemView;
                int i10 = R$id.avatar_bg_imageview;
                ImageLoaderView imageLoaderView3 = (ImageLoaderView) view.findViewById(i10);
                s.h(imageLoaderView3, "itemView.avatar_bg_imageview");
                imageLoaderView3.setVisibility(0);
                ImageLoaderView imageLoaderView4 = (ImageLoaderView) this.itemView.findViewById(i10);
                s.h(imageLoaderView4, "itemView.avatar_bg_imageview");
                ImageLoaderView.g(imageLoaderView4, anchorModel.getAvatarBackgroundImage(), null, null, 6, null);
            }
            String avatarBackgroundAnimation = anchorModel.getAvatarBackgroundAnimation();
            if (avatarBackgroundAnimation == null || avatarBackgroundAnimation.length() == 0) {
                FKWebpAnimationView fKWebpAnimationView = (FKWebpAnimationView) this.itemView.findViewById(R$id.avatar_bg_animation_view);
                s.h(fKWebpAnimationView, "itemView.avatar_bg_animation_view");
                fKWebpAnimationView.setVisibility(4);
            } else {
                View view2 = this.itemView;
                int i11 = R$id.avatar_bg_animation_view;
                FKWebpAnimationView fKWebpAnimationView2 = (FKWebpAnimationView) view2.findViewById(i11);
                s.h(fKWebpAnimationView2, "itemView.avatar_bg_animation_view");
                fKWebpAnimationView2.setVisibility(0);
                FKWebpAnimationView fKWebpAnimationView3 = (FKWebpAnimationView) this.itemView.findViewById(i11);
                s.h(fKWebpAnimationView3, "itemView.avatar_bg_animation_view");
                FKWebpAnimationView.h(fKWebpAnimationView3, anchorModel.getAvatarBackgroundAnimation(), 0, new Function0<p>() { // from class: com.cupidapp.live.liveshow.view.summary.LiveEndAnchorViewHolder$config$1
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
                        ImageLoaderView imageLoaderView5 = (ImageLoaderView) LiveEndAnchorViewHolder.this.itemView.findViewById(R$id.avatar_bg_imageview);
                        s.h(imageLoaderView5, "itemView.avatar_bg_imageview");
                        imageLoaderView5.setVisibility(4);
                    }
                }, null, 10, null);
            }
            if (anchorModel.getBackgroundImage() == null) {
                ImageLoaderView imageLoaderView5 = (ImageLoaderView) this.itemView.findViewById(R$id.bg_imageview);
                s.h(imageLoaderView5, "itemView.bg_imageview");
                imageLoaderView5.setVisibility(4);
            } else {
                View view3 = this.itemView;
                int i12 = R$id.bg_imageview;
                ImageLoaderView imageLoaderView6 = (ImageLoaderView) view3.findViewById(i12);
                s.h(imageLoaderView6, "itemView.bg_imageview");
                imageLoaderView6.setVisibility(0);
                ImageLoaderView imageLoaderView7 = (ImageLoaderView) this.itemView.findViewById(i12);
                s.h(imageLoaderView7, "itemView.bg_imageview");
                ImageLoaderView.g(imageLoaderView7, anchorModel.getBackgroundImage(), null, null, 6, null);
            }
            String backgroundAnimation = anchorModel.getBackgroundAnimation();
            if (backgroundAnimation == null || backgroundAnimation.length() == 0) {
                FKWebpAnimationView fKWebpAnimationView4 = (FKWebpAnimationView) this.itemView.findViewById(R$id.bg_animation_view);
                s.h(fKWebpAnimationView4, "itemView.bg_animation_view");
                fKWebpAnimationView4.setVisibility(4);
            } else {
                View view4 = this.itemView;
                int i13 = R$id.bg_animation_view;
                FKWebpAnimationView fKWebpAnimationView5 = (FKWebpAnimationView) view4.findViewById(i13);
                s.h(fKWebpAnimationView5, "itemView.bg_animation_view");
                fKWebpAnimationView5.setVisibility(0);
                FKWebpAnimationView fKWebpAnimationView6 = (FKWebpAnimationView) this.itemView.findViewById(i13);
                s.h(fKWebpAnimationView6, "itemView.bg_animation_view");
                FKWebpAnimationView.h(fKWebpAnimationView6, anchorModel.getBackgroundAnimation(), 0, new Function0<p>() { // from class: com.cupidapp.live.liveshow.view.summary.LiveEndAnchorViewHolder$config$2
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
                        ImageLoaderView imageLoaderView8 = (ImageLoaderView) LiveEndAnchorViewHolder.this.itemView.findViewById(R$id.bg_imageview);
                        s.h(imageLoaderView8, "itemView.bg_imageview");
                        imageLoaderView8.setVisibility(4);
                    }
                }, null, 10, null);
            }
            ((LinearLayout) this.itemView.findViewById(R$id.first_tag_list_layout)).removeAllViews();
            List<MiniProfileUserTagModel> firstTagList = anchorModel.getFirstTagList();
            if (firstTagList != null) {
                for (MiniProfileUserTagModel miniProfileUserTagModel : firstTagList) {
                    Context context = this.itemView.getContext();
                    s.h(context, "itemView.context");
                    FKLiveMiniProfileTagView fKLiveMiniProfileTagView = new FKLiveMiniProfileTagView(context);
                    fKLiveMiniProfileTagView.b(miniProfileUserTagModel, h.c(fKLiveMiniProfileTagView, 20.0f));
                    ((LinearLayout) this.itemView.findViewById(R$id.first_tag_list_layout)).addView(fKLiveMiniProfileTagView);
                }
            }
            ((FKLiveMiniProfileTagLayout) this.itemView.findViewById(R$id.user_tag_layout)).c(anchorModel.getSecondTagList());
            r(anchorModel.getUser());
            List<CardInfoModel> liveCardList = anchorModel.getLiveCardList();
            if (liveCardList != null && !liveCardList.isEmpty()) {
                z10 = false;
            }
            if (z10) {
                ((UserLiveShowRanksLinearLayout) this.itemView.findViewById(R$id.user_rank_ll)).setVisibility(8);
            } else {
                View view5 = this.itemView;
                int i14 = R$id.user_rank_ll;
                ((UserLiveShowRanksLinearLayout) view5.findViewById(i14)).setVisibility(0);
                UserLiveShowRanksLinearLayout userLiveShowRanksLinearLayout = (UserLiveShowRanksLinearLayout) this.itemView.findViewById(i14);
                List<CardInfoModel> liveCardList2 = anchorModel.getLiveCardList();
                User user4 = anchorModel.getUser();
                userLiveShowRanksLinearLayout.a(liveCardList2, user4 != null ? user4.userId() : null);
            }
            s(anchorModel);
        }
    }

    public final void r(User user) {
        int i10;
        String string;
        if (user == null) {
            return;
        }
        if (user.getMe()) {
            LinearLayout linearLayout = (LinearLayout) this.itemView.findViewById(R$id.match_status_layout);
            s.h(linearLayout, "itemView.match_status_layout");
            linearLayout.setVisibility(8);
            return;
        }
        if (user.getMatch()) {
            i10 = R$mipmap.icon_live_profile_matched;
            string = this.itemView.getContext().getString(R$string.already_matched);
            s.h(string, "itemView.context.getStri…R.string.already_matched)");
        } else if (user.getAloha()) {
            i10 = R$mipmap.icon_live_profile_un_like;
            string = this.itemView.getContext().getString(R$string.have_follow);
            s.h(string, "itemView.context.getString(R.string.have_follow)");
        } else {
            i10 = R$mipmap.icon_live_profile_like;
            string = this.itemView.getContext().getString(R$string.follow);
            s.h(string, "itemView.context.getString(R.string.follow)");
        }
        LinearLayout linearLayout2 = (LinearLayout) this.itemView.findViewById(R$id.match_status_layout);
        s.h(linearLayout2, "itemView.match_status_layout");
        linearLayout2.setVisibility(0);
        ((ImageView) this.itemView.findViewById(R$id.match_status_imageview)).setImageResource(i10);
        ((TextView) this.itemView.findViewById(R$id.match_status_textview)).setText(string);
    }

    public final void s(AnchorModel anchorModel) {
        if (anchorModel.getGiftWall() == null) {
            ((UserGiftWallLayout) this.itemView.findViewById(R$id.user_gift_wall_layout)).setVisibility(8);
            return;
        }
        View view = this.itemView;
        int i10 = R$id.user_gift_wall_layout;
        ((UserGiftWallLayout) view.findViewById(i10)).setVisibility(0);
        UserGiftWallLayout userGiftWallLayout = (UserGiftWallLayout) this.itemView.findViewById(i10);
        s.h(userGiftWallLayout, "itemView.user_gift_wall_layout");
        UserGiftWallLayout.c(userGiftWallLayout, anchorModel.getGiftWall(), null, 2, null);
    }

    public final void t() {
        View view = this.itemView;
        int i10 = R$id.popular_feed_textview;
        ObjectAnimator startAnimation$lambda$3 = ObjectAnimator.ofFloat((TextView) view.findViewById(i10), (Property<TextView, Float>) View.TRANSLATION_Y, h.c(this, 39.0f), 0.0f);
        startAnimation$lambda$3.setStartDelay(300L);
        startAnimation$lambda$3.setDuration(200L);
        s.h(startAnimation$lambda$3, "startAnimation$lambda$3");
        startAnimation$lambda$3.addListener(new b());
        this.f15949d = startAnimation$lambda$3;
        ObjectAnimator startAnimation$lambda$5 = ObjectAnimator.ofFloat((TextView) this.itemView.findViewById(i10), (Property<TextView, Float>) View.ALPHA, 1.0f, 0.0f);
        startAnimation$lambda$5.setStartDelay(3300L);
        startAnimation$lambda$5.setDuration(200L);
        s.h(startAnimation$lambda$5, "startAnimation$lambda$5");
        startAnimation$lambda$5.addListener(new c());
        this.f15950e = startAnimation$lambda$5;
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(this.f15949d).with(this.f15950e);
        this.f15948c = animatorSet;
        animatorSet.start();
    }

    public final void u() {
        ((FKWebpAnimationView) this.itemView.findViewById(R$id.bg_animation_view)).i();
        ((FKWebpAnimationView) this.itemView.findViewById(R$id.avatar_bg_animation_view)).i();
        ObjectAnimator objectAnimator = this.f15949d;
        if (objectAnimator != null) {
            objectAnimator.removeAllListeners();
        }
        ObjectAnimator objectAnimator2 = this.f15950e;
        if (objectAnimator2 != null) {
            objectAnimator2.removeAllListeners();
        }
        AnimatorSet animatorSet = this.f15948c;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }
}
