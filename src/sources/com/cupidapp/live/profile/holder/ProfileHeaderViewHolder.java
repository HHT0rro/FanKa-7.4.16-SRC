package com.cupidapp.live.profile.holder;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.imageloader.ImageLoaderUtil;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.match.view.FKClickAnimationLayout;
import com.cupidapp.live.match.view.FKShadowLayout;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.profile.view.ProfileMediaViewPagerLayout;
import com.cupidapp.live.profile.view.ProfileUserInfoLayout;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p1.g;
import z0.h;
import z0.y;
import z0.z;

/* compiled from: ProfileHeaderViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ProfileHeaderViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final a f17822e = new a(null);

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final Lifecycle f17823c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f17824d;

    /* compiled from: ProfileHeaderViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ProfileHeaderViewHolder a(@NotNull ViewGroup parent, @NotNull Lifecycle lifecycle) {
            s.i(parent, "parent");
            s.i(lifecycle, "lifecycle");
            ProfileHeaderViewHolder profileHeaderViewHolder = new ProfileHeaderViewHolder(z.b(parent, R$layout.view_holder_profile_header, false, 2, null), lifecycle);
            profileHeaderViewHolder.q();
            return profileHeaderViewHolder;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileHeaderViewHolder(@NotNull View itemView, @NotNull Lifecycle lifecycle) {
        super(itemView);
        s.i(itemView, "itemView");
        s.i(lifecycle, "lifecycle");
        this.f17823c = lifecycle;
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof ProfileHeaderViewModel) {
            ProfileMediaViewPagerLayout config$lambda$0 = (ProfileMediaViewPagerLayout) this.itemView.findViewById(R$id.profileMediaViewPagerLayout);
            s.h(config$lambda$0, "config$lambda$0");
            int l10 = (int) (((h.l(config$lambda$0) - (h.c(config$lambda$0, 17.0f) * 2)) * 4) / 3.0f);
            config$lambda$0.getLayoutParams().height = l10;
            ((FKShadowLayout) this.itemView.findViewById(R$id.shadowView)).getLayoutParams().height = l10;
            ProfileHeaderViewModel profileHeaderViewModel = (ProfileHeaderViewModel) obj;
            config$lambda$0.k(profileHeaderViewModel.getUser());
            u(profileHeaderViewModel);
            ((ProfileUserInfoLayout) this.itemView.findViewById(R$id.profileUserInfoLayout)).b(profileHeaderViewModel.getUser());
            if (profileHeaderViewModel.getUser().getMedalImage() != null) {
                View view = this.itemView;
                int i10 = R$id.img_profile_medal;
                ((ImageLoaderView) view.findViewById(i10)).setVisibility(0);
                ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(i10);
                s.h(imageLoaderView, "itemView.img_profile_medal");
                ImageLoaderView.g(imageLoaderView, profileHeaderViewModel.getUser().getMedalImage(), null, null, 6, null);
            } else {
                ((ImageLoaderView) this.itemView.findViewById(R$id.img_profile_medal)).setVisibility(8);
            }
            s(profileHeaderViewModel.getUser().getIndividuationFrameConfig());
        }
    }

    public final void s(String str) {
        if (str == null || str.length() == 0) {
            t(null);
            return;
        }
        ImageLoaderUtil imageLoaderUtil = ImageLoaderUtil.f11832a;
        Context context = this.itemView.getContext();
        s.h(context, "itemView.context");
        imageLoaderUtil.h(context, str, new Function1<Drawable, p>() { // from class: com.cupidapp.live.profile.holder.ProfileHeaderViewHolder$configProfileBorder$1
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
                ProfileHeaderViewHolder.this.t(drawable);
            }
        });
    }

    public final void t(Drawable drawable) {
        ((ProfileMediaViewPagerLayout) this.itemView.findViewById(R$id.profileMediaViewPagerLayout)).j(drawable);
        if (drawable == null) {
            FrameLayout frameLayout = (FrameLayout) this.itemView.findViewById(R$id.userRelationshipLayout);
            s.h(frameLayout, "itemView.userRelationshipLayout");
            y.m(frameLayout, null, null, Integer.valueOf(h.c(this, 8.0f)), null, 11, null);
            FKClickAnimationLayout fKClickAnimationLayout = (FKClickAnimationLayout) this.itemView.findViewById(R$id.profile_super_liked_by_me_btn_fl);
            s.h(fKClickAnimationLayout, "itemView.profile_super_liked_by_me_btn_fl");
            y.m(fKClickAnimationLayout, Integer.valueOf(h.c(this, 8.0f)), null, null, null, 14, null);
            ProfileUserInfoLayout profileUserInfoLayout = (ProfileUserInfoLayout) this.itemView.findViewById(R$id.profileUserInfoLayout);
            int c4 = h.c(this, 10.0f);
            int c10 = h.c(this, 10.0f);
            int c11 = h.c(this, 20.0f);
            s.h(profileUserInfoLayout, "profileUserInfoLayout");
            y.m(profileUserInfoLayout, Integer.valueOf(c4), Integer.valueOf(c11), Integer.valueOf(c10), null, 8, null);
            ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(R$id.img_profile_medal);
            s.h(imageLoaderView, "itemView.img_profile_medal");
            y.m(imageLoaderView, Integer.valueOf(h.c(this, 16.0f)), null, null, Integer.valueOf(h.c(this, 16.0f)), 6, null);
            return;
        }
        FrameLayout frameLayout2 = (FrameLayout) this.itemView.findViewById(R$id.userRelationshipLayout);
        s.h(frameLayout2, "itemView.userRelationshipLayout");
        y.m(frameLayout2, null, null, Integer.valueOf(h.c(this, 18.0f)), null, 11, null);
        FKClickAnimationLayout fKClickAnimationLayout2 = (FKClickAnimationLayout) this.itemView.findViewById(R$id.profile_super_liked_by_me_btn_fl);
        s.h(fKClickAnimationLayout2, "itemView.profile_super_liked_by_me_btn_fl");
        y.m(fKClickAnimationLayout2, Integer.valueOf(h.c(this, 18.0f)), null, null, null, 14, null);
        ProfileUserInfoLayout profileUserInfoLayout2 = (ProfileUserInfoLayout) this.itemView.findViewById(R$id.profileUserInfoLayout);
        int c12 = h.c(this, 20.0f);
        int c13 = h.c(this, 20.0f);
        int c14 = h.c(this, 30.0f);
        s.h(profileUserInfoLayout2, "profileUserInfoLayout");
        y.m(profileUserInfoLayout2, Integer.valueOf(c12), Integer.valueOf(c14), Integer.valueOf(c13), null, 8, null);
        ImageLoaderView imageLoaderView2 = (ImageLoaderView) this.itemView.findViewById(R$id.img_profile_medal);
        s.h(imageLoaderView2, "itemView.img_profile_medal");
        y.m(imageLoaderView2, Integer.valueOf(h.c(this, 26.0f)), null, null, Integer.valueOf(h.c(this, 26.0f)), 6, null);
    }

    public final void u(ProfileHeaderViewModel profileHeaderViewModel) {
        User user = profileHeaderViewModel.getUser();
        String userId = user.userId();
        User X = g.f52734a.X();
        String str = null;
        if (s.d(userId, X != null ? X.userId() : null)) {
            v();
        } else if (user.getMatch()) {
            x();
        } else {
            w(user.getAloha());
        }
        View view = this.itemView;
        int i10 = R$id.userRelationshipTextView;
        TextView textView = (TextView) view.findViewById(i10);
        if (user.getMatch()) {
            str = this.itemView.getContext().getString(R$string.already_matched);
        } else if (user.getAlohaGet() && user.getAlohaGetShow()) {
            str = this.itemView.getContext().getString(R$string.user_follow_you);
        }
        textView.setText(str);
        TextView textView2 = (TextView) this.itemView.findViewById(i10);
        CharSequence text = ((TextView) this.itemView.findViewById(i10)).getText();
        textView2.setVisibility(text == null || text.length() == 0 ? 8 : 0);
        ((ImageView) this.itemView.findViewById(R$id.userMatchedSignImageView)).setVisibility(user.getMatch() ? 0 : 8);
        View view2 = this.itemView;
        int i11 = R$id.profile_super_liked_by_me_btn;
        ((ImageView) view2.findViewById(i11)).setVisibility(4);
        if (user.isNotShowSuperLikeBtn()) {
            ((FKClickAnimationLayout) this.itemView.findViewById(R$id.profile_super_liked_by_me_btn_fl)).setVisibility(8);
            return;
        }
        ((FKClickAnimationLayout) this.itemView.findViewById(R$id.profile_super_liked_by_me_btn_fl)).setVisibility(0);
        if (!this.f17824d) {
            this.f17824d = true;
            Context context = this.itemView.getContext();
            s.h(context, "itemView.context");
            y(profileHeaderViewModel.getGuide(), user.getUnLimitSuperLikeRemains(context), profileHeaderViewModel.getSensorContext());
            return;
        }
        ((ImageView) this.itemView.findViewById(i11)).setVisibility(0);
    }

    public final void v() {
        ((ImageView) this.itemView.findViewById(R$id.followImageView)).setVisibility(8);
        ((ImageView) this.itemView.findViewById(R$id.messageImageView)).setVisibility(8);
        ((ImageView) this.itemView.findViewById(R$id.editMyProfileImageView)).setVisibility(0);
    }

    public final void w(boolean z10) {
        View view = this.itemView;
        int i10 = R$id.followImageView;
        ((ImageView) view.findViewById(i10)).setVisibility(0);
        ((ImageView) this.itemView.findViewById(i10)).setImageResource(z10 ? R$mipmap.icon_user_profile_followed : R$mipmap.match_follow_button);
        ((ImageView) this.itemView.findViewById(R$id.messageImageView)).setVisibility(8);
        ((ImageView) this.itemView.findViewById(R$id.editMyProfileImageView)).setVisibility(8);
    }

    public final void x() {
        ((ImageView) this.itemView.findViewById(R$id.followImageView)).setVisibility(8);
        ((ImageView) this.itemView.findViewById(R$id.messageImageView)).setVisibility(0);
        ((ImageView) this.itemView.findViewById(R$id.editMyProfileImageView)).setVisibility(8);
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x00a4, code lost:
    
        if ((r3.length() > 0) == true) goto L40;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x001c  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void y(com.cupidapp.live.profile.model.SuperLikeGuideResult r26, com.cupidapp.live.superboost.model.UnLimitRemainsUIModel r27, com.cupidapp.live.base.sensorslog.ProfileSensorContext r28) {
        /*
            r25 = this;
            r0 = r25
            r1 = 1
            r2 = 0
            if (r26 == 0) goto L19
            java.lang.String r3 = r26.getGuideText()
            if (r3 == 0) goto L19
            int r3 = r3.length()
            if (r3 <= 0) goto L14
            r3 = 1
            goto L15
        L14:
            r3 = 0
        L15:
            if (r3 != r1) goto L19
            r3 = 1
            goto L1a
        L19:
            r3 = 0
        L1a:
            if (r3 == 0) goto L1f
            java.lang.String r3 = "profile_superlike_bubble_guide.svga"
            goto L21
        L1f:
            java.lang.String r3 = "profile_superlike_guide.svga"
        L21:
            r5 = r3
            boolean r3 = r27.hasRemains()
            if (r3 == 0) goto L86
            android.view.View r1 = r0.itemView
            int r2 = com.cupidapp.live.R$id.profile_super_liked_by_me_btn
            android.view.View r1 = r1.findViewById(r2)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            if (r1 != 0) goto L35
            goto L39
        L35:
            r2 = 4
            r1.setVisibility(r2)
        L39:
            android.view.View r1 = r0.itemView
            int r2 = com.cupidapp.live.R$id.profile_superlike_svga
            android.view.View r1 = r1.findViewById(r2)
            r4 = r1
            com.cupidapp.live.base.view.animation.FKSVGAImageView r4 = (com.cupidapp.live.base.view.animation.FKSVGAImageView) r4
            if (r4 == 0) goto L72
            r1 = 1102053376(0x41b00000, float:22.0)
            java.lang.Float r6 = java.lang.Float.valueOf(r1)
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            kotlin.Pair r1 = new kotlin.Pair
            java.lang.String r2 = r27.getFormattedRemains()
            if (r2 != 0) goto L5a
            java.lang.String r2 = ""
        L5a:
            java.lang.String r3 = "home_ic_superlike_back_number"
            r1.<init>(r3, r2)
            java.util.Map r11 = kotlin.collections.h0.d(r1)
            r12 = 0
            r13 = 0
            com.cupidapp.live.profile.holder.ProfileHeaderViewHolder$showSuperLikeAnim$1 r14 = new com.cupidapp.live.profile.holder.ProfileHeaderViewHolder$showSuperLikeAnim$1
            r14.<init>()
            r15 = 0
            r16 = 1468(0x5bc, float:2.057E-42)
            r17 = 0
            com.cupidapp.live.base.view.animation.FKSVGAImageView.H(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
        L72:
            com.cupidapp.live.track.group.GroupOthersLog r18 = com.cupidapp.live.track.group.GroupOthersLog.f18702a
            com.cupidapp.live.track.group.GroupOthersLog$GuideType r19 = com.cupidapp.live.track.group.GroupOthersLog.GuideType.GUIDE_BUBBLE_REMAIN_TIPS
            com.cupidapp.live.base.sensorslog.SensorPosition r20 = com.cupidapp.live.base.sensorslog.SensorPosition.Profile
            com.cupidapp.live.base.sensorslog.SensorScene r21 = r28.getScene()
            r22 = 0
            r23 = 8
            r24 = 0
            com.cupidapp.live.track.group.GroupOthersLog.M(r18, r19, r20, r21, r22, r23, r24)
            goto Lbb
        L86:
            android.view.View r3 = r0.itemView
            int r4 = com.cupidapp.live.R$id.profile_super_liked_by_me_btn
            android.view.View r3 = r3.findViewById(r4)
            android.widget.ImageView r3 = (android.widget.ImageView) r3
            r3.setVisibility(r2)
            if (r26 == 0) goto La7
            java.lang.String r3 = r26.getGuideText()
            if (r3 == 0) goto La7
            int r3 = r3.length()
            if (r3 <= 0) goto La3
            r3 = 1
            goto La4
        La3:
            r3 = 0
        La4:
            if (r3 != r1) goto La7
            goto La8
        La7:
            r1 = 0
        La8:
            if (r1 == 0) goto Lbb
            com.cupidapp.live.track.group.GroupOthersLog r2 = com.cupidapp.live.track.group.GroupOthersLog.f18702a
            com.cupidapp.live.track.group.GroupOthersLog$GuideType r3 = com.cupidapp.live.track.group.GroupOthersLog.GuideType.GUIDE_BUBBLE
            com.cupidapp.live.base.sensorslog.SensorPosition r4 = com.cupidapp.live.base.sensorslog.SensorPosition.Profile
            com.cupidapp.live.base.sensorslog.SensorScene r5 = r28.getScene()
            r6 = 0
            r7 = 8
            r8 = 0
            com.cupidapp.live.track.group.GroupOthersLog.M(r2, r3, r4, r5, r6, r7, r8)
        Lbb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.profile.holder.ProfileHeaderViewHolder.y(com.cupidapp.live.profile.model.SuperLikeGuideResult, com.cupidapp.live.superboost.model.UnLimitRemainsUIModel, com.cupidapp.live.base.sensorslog.ProfileSensorContext):void");
    }

    public final void z() {
        ((ProfileMediaViewPagerLayout) this.itemView.findViewById(R$id.profileMediaViewPagerLayout)).p();
    }
}
