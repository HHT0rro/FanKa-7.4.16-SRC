package com.cupidapp.live.chat.viewholder;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.cupidapp.live.R$drawable;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.imageloader.BlurModel;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.imageloader.b;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.view.UserIconViewLayout;
import com.cupidapp.live.base.view.animation.FKLottieAnimationView;
import com.cupidapp.live.chat.model.InboxSessionModel;
import com.cupidapp.live.chat.model.InboxSessionType;
import com.cupidapp.live.chat.service.VisitorInfoModel;
import com.cupidapp.live.main.view.FKUnreadCountTextView;
import com.cupidapp.live.profile.logic.c;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.superlike.view.SuperLikeTagView;
import com.google.android.material.badge.BadgeDrawable;
import java.util.Arrays;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.jvm.internal.y;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.m;
import z0.t;
import z0.u;
import z0.v;
import z0.z;

/* compiled from: ContactSessionListViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ContactSessionListViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f13251d = new a(null);

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public AnimatorSet f13252c;

    /* compiled from: ContactSessionListViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ContactSessionListViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new ContactSessionListViewHolder(z.b(parent, R$layout.view_holder_contact_session_list, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContactSessionListViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
        ((TextView) itemView.findViewById(R$id.sessionUserNameTextView)).getPaint().setFakeBoldText(true);
        ((TextView) itemView.findViewById(R$id.sessionLastMessageTextView)).getPaint().setFakeBoldText(true);
        ((TextView) itemView.findViewById(R$id.sessionTimeStampTextView)).getPaint().setFakeBoldText(true);
    }

    public final void A(VisitorInfoModel visitorInfoModel, InboxSessionModel inboxSessionModel) {
        if (visitorInfoModel != null && visitorInfoModel.getVisitorEnable()) {
            ((TextView) this.itemView.findViewById(R$id.sessionTimeStampTextView)).setVisibility(8);
            return;
        }
        View view = this.itemView;
        int i10 = R$id.sessionTimeStampTextView;
        ((TextView) view.findViewById(i10)).setVisibility(0);
        TextView textView = (TextView) this.itemView.findViewById(i10);
        Long updateTimeMillis = inboxSessionModel.getUpdateTimeMillis();
        textView.setText(updateTimeMillis != null ? v.n(updateTimeMillis.longValue(), this.itemView.getContext()) : null);
    }

    public final void B(InboxSessionModel inboxSessionModel) {
        if (inboxSessionModel.getCountdown() != null) {
            Integer countdown = inboxSessionModel.getCountdown();
            if ((countdown != null ? countdown.intValue() : 0) > 0) {
                View view = this.itemView;
                int i10 = R$id.wait_unlock_txt;
                TextView textView = (TextView) view.findViewById(i10);
                s.h(textView, "itemView.wait_unlock_txt");
                u.a(textView);
                ((TextView) this.itemView.findViewById(i10)).setText(this.itemView.getContext().getString(R$string.say_hi_not_need_pay));
                ((TextView) this.itemView.findViewById(i10)).setVisibility(0);
                View view2 = this.itemView;
                int i11 = R$id.sessionTimeStampTextView;
                ((TextView) view2.findViewById(i11)).setVisibility(0);
                TextView textView2 = (TextView) this.itemView.findViewById(i11);
                Context context = this.itemView.getContext();
                Object[] objArr = new Object[1];
                Integer countdown2 = inboxSessionModel.getCountdown();
                objArr[0] = countdown2 != null ? v.h(countdown2.intValue()) : null;
                textView2.setText(context.getString(R$string.invalid_after_several_time, objArr));
                return;
            }
        }
        ((TextView) this.itemView.findViewById(R$id.wait_unlock_txt)).setVisibility(8);
        A(inboxSessionModel.getVisitorInfo(), inboxSessionModel);
    }

    public final void C() {
        AnimatorSet animatorSet = this.f13252c;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        View view = this.itemView;
        int i10 = R$id.session_avatar_layout;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat((FrameLayout) view.findViewById(i10), (Property<FrameLayout, Float>) View.SCALE_X, 1.0f, 0.96f);
        ofFloat.setRepeatMode(2);
        ofFloat.setRepeatCount(-1);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat((FrameLayout) this.itemView.findViewById(i10), (Property<FrameLayout, Float>) View.SCALE_Y, 1.0f, 0.96f);
        ofFloat2.setRepeatMode(2);
        ofFloat2.setRepeatCount(-1);
        animatorSet2.play(ofFloat).with(ofFloat2);
        animatorSet2.setDuration(400L);
        this.f13252c = animatorSet2;
        animatorSet2.start();
    }

    public final void D() {
        FrameLayout frameLayout = (FrameLayout) this.itemView.findViewById(R$id.session_avatar_layout);
        frameLayout.setScaleX(1.0f);
        frameLayout.setScaleY(1.0f);
        AnimatorSet animatorSet = this.f13252c;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        this.f13252c = null;
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof InboxSessionModel) {
            InboxSessionModel inboxSessionModel = (InboxSessionModel) obj;
            VisitorInfoModel visitorInfo = inboxSessionModel.getVisitorInfo();
            String type = inboxSessionModel.getType();
            if (s.d(type, InboxSessionType.VisitorSession.getType())) {
                if (visitorInfo != null) {
                    y(visitorInfo);
                }
                A(visitorInfo, inboxSessionModel);
            } else if (s.d(type, InboxSessionType.GroupSession.getType())) {
                s(inboxSessionModel);
                A(visitorInfo, inboxSessionModel);
            } else if (s.d(type, InboxSessionType.NearBySession.getType())) {
                v(inboxSessionModel);
            } else {
                w(inboxSessionModel);
            }
            String lastMessage = inboxSessionModel.getLastMessage();
            if (lastMessage == null || lastMessage.length() == 0) {
                ((TextView) this.itemView.findViewById(R$id.sessionLastMessageTextView)).setVisibility(4);
                return;
            }
            View view = this.itemView;
            int i10 = R$id.sessionLastMessageTextView;
            ((TextView) view.findViewById(i10)).setVisibility(0);
            ((TextView) this.itemView.findViewById(i10)).setText(t.a(inboxSessionModel.getLastMessage(), -49088));
        }
    }

    public final void r(int i10) {
        if (i10 < 1) {
            ((RelativeLayout) this.itemView.findViewById(R$id.contact_session_root_layout)).setBackgroundColor(-1);
            return;
        }
        if (i10 < 2) {
            ((RelativeLayout) this.itemView.findViewById(R$id.contact_session_root_layout)).setBackgroundResource(R$drawable.chat_item_bg_superlike_count1);
            return;
        }
        if (i10 < 6) {
            ((RelativeLayout) this.itemView.findViewById(R$id.contact_session_root_layout)).setBackgroundResource(R$drawable.chat_item_bg_superlike_count2);
            return;
        }
        if (i10 < 11) {
            ((RelativeLayout) this.itemView.findViewById(R$id.contact_session_root_layout)).setBackgroundResource(R$drawable.chat_item_bg_superlike_count3);
        } else if (i10 < 16) {
            ((RelativeLayout) this.itemView.findViewById(R$id.contact_session_root_layout)).setBackgroundResource(R$drawable.chat_item_bg_superlike_count4);
        } else {
            ((RelativeLayout) this.itemView.findViewById(R$id.contact_session_root_layout)).setBackgroundResource(R$drawable.chat_item_bg_superlike_count5);
        }
    }

    public final void s(InboxSessionModel inboxSessionModel) {
        ((TextView) this.itemView.findViewById(R$id.wait_unlock_txt)).setVisibility(8);
        ((ImageView) this.itemView.findViewById(R$id.visitorEntranceImage)).setVisibility(4);
        ((TextView) this.itemView.findViewById(R$id.visitorsCount)).setVisibility(8);
        ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(R$id.sessionUserAvatarImageView);
        s.h(imageLoaderView, "itemView.sessionUserAvatarImageView");
        ImageLoaderView.g(imageLoaderView, inboxSessionModel.getGroupAvatar(), null, null, 6, null);
        ((TextView) this.itemView.findViewById(R$id.sessionUserNameTextView)).setText(inboxSessionModel.getGroupName());
        if (inboxSessionModel.getNotDisturb()) {
            View findViewById = this.itemView.findViewById(R$id.session_red_dot_view);
            s.h(findViewById, "itemView.session_red_dot_view");
            findViewById.setVisibility(inboxSessionModel.getRedDot() ? 0 : 8);
            ImageView imageView = (ImageView) this.itemView.findViewById(R$id.notDisturbIcon);
            s.h(imageView, "itemView.notDisturbIcon");
            imageView.setVisibility(0);
            ((FKUnreadCountTextView) this.itemView.findViewById(R$id.sessionUnreadCountView)).setVisibility(8);
        } else {
            ((ImageView) this.itemView.findViewById(R$id.notDisturbIcon)).setVisibility(8);
            View findViewById2 = this.itemView.findViewById(R$id.session_red_dot_view);
            s.h(findViewById2, "itemView.session_red_dot_view");
            findViewById2.setVisibility(8);
            if (inboxSessionModel.getUnread() > 0) {
                View view = this.itemView;
                int i10 = R$id.sessionUnreadCountView;
                ((FKUnreadCountTextView) view.findViewById(i10)).setVisibility(0);
                ((FKUnreadCountTextView) this.itemView.findViewById(i10)).setText(m.d(inboxSessionModel.getUnread()));
            } else {
                ((FKUnreadCountTextView) this.itemView.findViewById(R$id.sessionUnreadCountView)).setVisibility(8);
            }
        }
        u(false);
        UserIconViewLayout userIconViewLayout = (UserIconViewLayout) this.itemView.findViewById(R$id.vipIconImageView);
        s.h(userIconViewLayout, "itemView.vipIconImageView");
        userIconViewLayout.setVisibility(8);
        ((ImageLoaderView) this.itemView.findViewById(R$id.official_label_img)).setVisibility(8);
        ImageView imageView2 = (ImageView) this.itemView.findViewById(R$id.focus_tag_img);
        s.h(imageView2, "itemView.focus_tag_img");
        imageView2.setVisibility(8);
        x(0);
        TextView textView = (TextView) this.itemView.findViewById(R$id.count_down_text);
        s.h(textView, "itemView.count_down_text");
        textView.setVisibility(8);
        ((ImageView) this.itemView.findViewById(R$id.viewMessagePrivatelyIcon)).setVisibility(8);
        ImageView imageView3 = (ImageView) this.itemView.findViewById(R$id.topping_imageview);
        s.h(imageView3, "itemView.topping_imageview");
        imageView3.setVisibility(8);
    }

    public final void t(InboxSessionModel inboxSessionModel) {
        Integer maskRemainSec = inboxSessionModel.getMaskRemainSec();
        int intValue = maskRemainSec != null ? maskRemainSec.intValue() : 0;
        if (intValue > 0) {
            View view = this.itemView;
            int i10 = R$id.count_down_text;
            ((TextView) view.findViewById(i10)).setVisibility(0);
            TextView textView = (TextView) this.itemView.findViewById(i10);
            s.h(textView, "itemView.count_down_text");
            u.a(textView);
            ((TextView) this.itemView.findViewById(i10)).setText(z(v.d(intValue)));
            return;
        }
        ((TextView) this.itemView.findViewById(R$id.count_down_text)).setVisibility(8);
    }

    public final void u(boolean z10) {
        if (z10) {
            this.itemView.findViewById(R$id.session_user_living_bg).setVisibility(0);
            FKLottieAnimationView fKLottieAnimationView = (FKLottieAnimationView) this.itemView.findViewById(R$id.session_living_bg_img);
            fKLottieAnimationView.setVisibility(0);
            fKLottieAnimationView.L();
            FKLottieAnimationView fKLottieAnimationView2 = (FKLottieAnimationView) this.itemView.findViewById(R$id.session_living_sub_img);
            fKLottieAnimationView2.setVisibility(0);
            fKLottieAnimationView2.L();
            C();
            return;
        }
        this.itemView.findViewById(R$id.session_user_living_bg).setVisibility(4);
        FKLottieAnimationView fKLottieAnimationView3 = (FKLottieAnimationView) this.itemView.findViewById(R$id.session_living_bg_img);
        fKLottieAnimationView3.M();
        fKLottieAnimationView3.setVisibility(8);
        FKLottieAnimationView fKLottieAnimationView4 = (FKLottieAnimationView) this.itemView.findViewById(R$id.session_living_sub_img);
        fKLottieAnimationView4.M();
        fKLottieAnimationView4.setVisibility(8);
        D();
    }

    public final void v(InboxSessionModel inboxSessionModel) {
        String nickname;
        Integer countdown = inboxSessionModel.getCountdown();
        View view = this.itemView;
        int i10 = R$id.visitorEntranceImage;
        ((ImageView) view.findViewById(i10)).setVisibility(4);
        View view2 = this.itemView;
        int i11 = R$id.visitorsCount;
        ((TextView) view2.findViewById(i11)).setVisibility(8);
        if (countdown != null && countdown.intValue() > 0) {
            View view3 = this.itemView;
            int i12 = R$id.wait_unlock_txt;
            TextView textView = (TextView) view3.findViewById(i12);
            s.h(textView, "itemView.wait_unlock_txt");
            u.a(textView);
            ((TextView) this.itemView.findViewById(i12)).setVisibility(0);
            ((TextView) this.itemView.findViewById(i12)).setText(this.itemView.getContext().getString(R$string.wait_unlock));
            View view4 = this.itemView;
            int i13 = R$id.sessionTimeStampTextView;
            ((TextView) view4.findViewById(i13)).setVisibility(0);
            TextView textView2 = (TextView) this.itemView.findViewById(i13);
            y yVar = y.f51038a;
            String string = this.itemView.getContext().getString(R$string.disappear_after_several_time_of_nearby);
            s.h(string, "itemView.context.getStri…r_several_time_of_nearby)");
            String format = String.format(string, Arrays.copyOf(new Object[]{v.h(countdown.intValue())}, 1));
            s.h(format, "format(format, *args)");
            textView2.setText(format);
        } else {
            ((TextView) this.itemView.findViewById(R$id.sessionTimeStampTextView)).setVisibility(8);
            ((TextView) this.itemView.findViewById(R$id.wait_unlock_txt)).setVisibility(8);
        }
        TextView textView3 = (TextView) this.itemView.findViewById(R$id.sessionUserNameTextView);
        User sender = inboxSessionModel.getSender();
        if (sender == null || (nickname = sender.getName()) == null) {
            User sender2 = inboxSessionModel.getSender();
            nickname = sender2 != null ? sender2.getNickname() : null;
        }
        textView3.setText(nickname);
        ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(R$id.sessionUserAvatarImageView);
        s.h(imageLoaderView, "itemView.sessionUserAvatarImageView");
        User sender3 = inboxSessionModel.getSender();
        ImageLoaderView.g(imageLoaderView, sender3 != null ? sender3.getAvatarImage() : null, null, null, 6, null);
        View findViewById = this.itemView.findViewById(R$id.session_red_dot_view);
        s.h(findViewById, "itemView.session_red_dot_view");
        findViewById.setVisibility(8);
        ((FKUnreadCountTextView) this.itemView.findViewById(R$id.sessionUnreadCountView)).setVisibility(8);
        UserIconViewLayout userIconViewLayout = (UserIconViewLayout) this.itemView.findViewById(R$id.vipIconImageView);
        s.h(userIconViewLayout, "itemView.vipIconImageView");
        userIconViewLayout.setVisibility(8);
        ((ImageLoaderView) this.itemView.findViewById(R$id.official_label_img)).setVisibility(8);
        ImageView imageView = (ImageView) this.itemView.findViewById(R$id.focus_tag_img);
        s.h(imageView, "itemView.focus_tag_img");
        imageView.setVisibility(8);
        ((ImageView) this.itemView.findViewById(R$id.viewMessagePrivatelyIcon)).setVisibility(8);
        View view5 = this.itemView;
        int i14 = R$id.topping_imageview;
        ImageView imageView2 = (ImageView) view5.findViewById(i14);
        s.h(imageView2, "itemView.topping_imageview");
        imageView2.setVisibility(8);
        ((ImageView) this.itemView.findViewById(i10)).setVisibility(4);
        ((TextView) this.itemView.findViewById(i11)).setVisibility(8);
        ((ImageView) this.itemView.findViewById(R$id.notDisturbIcon)).setVisibility(8);
        u(false);
        x(0);
        TextView textView4 = (TextView) this.itemView.findViewById(R$id.count_down_text);
        s.h(textView4, "itemView.count_down_text");
        textView4.setVisibility(8);
        ImageView imageView3 = (ImageView) this.itemView.findViewById(i14);
        s.h(imageView3, "itemView.topping_imageview");
        imageView3.setVisibility(8);
    }

    public final void w(InboxSessionModel inboxSessionModel) {
        Integer superLikedMeCombos;
        ((ImageView) this.itemView.findViewById(R$id.notDisturbIcon)).setVisibility(8);
        ((ImageView) this.itemView.findViewById(R$id.visitorEntranceImage)).setVisibility(4);
        ((TextView) this.itemView.findViewById(R$id.visitorsCount)).setVisibility(8);
        ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(R$id.sessionUserAvatarImageView);
        s.h(imageLoaderView, "itemView.sessionUserAvatarImageView");
        User sender = inboxSessionModel.getSender();
        ImageLoaderView.g(imageLoaderView, sender != null ? sender.getAvatarImage() : null, null, null, 6, null);
        UserIconViewLayout userIconViewLayout = (UserIconViewLayout) this.itemView.findViewById(R$id.vipIconImageView);
        s.h(userIconViewLayout, "itemView.vipIconImageView");
        User sender2 = inboxSessionModel.getSender();
        UserIconViewLayout.d(userIconViewLayout, sender2 != null ? sender2.getUserVipModel() : null, SensorPosition.Unknown, UserIconViewLayout.VipIconPositionRef.Other, false, 8, null);
        if (inboxSessionModel.getOfficialAccountIcon() != null) {
            View view = this.itemView;
            int i10 = R$id.official_label_img;
            ((ImageLoaderView) view.findViewById(i10)).setVisibility(0);
            int scaleWidthByHeight = inboxSessionModel.getOfficialAccountIcon().getScaleWidthByHeight(h.c(this, 16.0f));
            ImageLoaderView imageLoaderView2 = (ImageLoaderView) this.itemView.findViewById(i10);
            s.h(imageLoaderView2, "itemView.official_label_img");
            z0.y.o(imageLoaderView2, Integer.valueOf(scaleWidthByHeight), null, 2, null);
            ImageLoaderView imageLoaderView3 = (ImageLoaderView) this.itemView.findViewById(i10);
            s.h(imageLoaderView3, "itemView.official_label_img");
            ImageLoaderView.g(imageLoaderView3, inboxSessionModel.getOfficialAccountIcon(), null, null, 6, null);
        } else {
            ((ImageLoaderView) this.itemView.findViewById(R$id.official_label_img)).setVisibility(8);
        }
        TextView textView = (TextView) this.itemView.findViewById(R$id.sessionUserNameTextView);
        User sender3 = inboxSessionModel.getSender();
        textView.setText(sender3 != null ? sender3.getName() : null);
        View findViewById = this.itemView.findViewById(R$id.session_red_dot_view);
        Boolean chatStatusDot = inboxSessionModel.getChatStatusDot();
        Boolean bool = Boolean.TRUE;
        findViewById.setVisibility(s.d(chatStatusDot, bool) ? 0 : 8);
        if (inboxSessionModel.getUnread() > 0) {
            View view2 = this.itemView;
            int i11 = R$id.sessionUnreadCountView;
            ((FKUnreadCountTextView) view2.findViewById(i11)).setVisibility(0);
            ((FKUnreadCountTextView) this.itemView.findViewById(i11)).setText(m.d(inboxSessionModel.getUnread()));
        } else {
            ((FKUnreadCountTextView) this.itemView.findViewById(R$id.sessionUnreadCountView)).setVisibility(8);
        }
        ((ImageView) this.itemView.findViewById(R$id.viewMessagePrivatelyIcon)).setVisibility(s.d(inboxSessionModel.getStealthMessage(), bool) ? 0 : 8);
        User sender4 = inboxSessionModel.getSender();
        x((sender4 == null || (superLikedMeCombos = sender4.getSuperLikedMeCombos()) == null) ? 0 : superLikedMeCombos.intValue());
        User sender5 = inboxSessionModel.getSender();
        if ((sender5 != null && sender5.getFocus()) && !c.f17839a.a(inboxSessionModel.getSender().userId())) {
            ((ImageView) this.itemView.findViewById(R$id.focus_tag_img)).setVisibility(0);
            ((ImageView) this.itemView.findViewById(R$id.topping_imageview)).setVisibility(0);
        } else {
            ((ImageView) this.itemView.findViewById(R$id.focus_tag_img)).setVisibility(8);
            ((ImageView) this.itemView.findViewById(R$id.topping_imageview)).setVisibility(8);
        }
        t(inboxSessionModel);
        u(inboxSessionModel.inLiveShow());
        B(inboxSessionModel);
    }

    public final void x(int i10) {
        ((SuperLikeTagView) this.itemView.findViewById(R$id.session_super_like_me_img)).c(Integer.valueOf(i10));
        r(i10);
    }

    public final void y(VisitorInfoModel visitorInfoModel) {
        ((TextView) this.itemView.findViewById(R$id.wait_unlock_txt)).setVisibility(8);
        ((ImageView) this.itemView.findViewById(R$id.notDisturbIcon)).setVisibility(8);
        ((ImageView) this.itemView.findViewById(R$id.visitorEntranceImage)).setVisibility(0);
        View view = this.itemView;
        int i10 = R$id.visitorsCount;
        ((TextView) view.findViewById(i10)).setVisibility(8);
        ((ImageView) this.itemView.findViewById(R$id.focus_tag_img)).setVisibility(8);
        ((ImageView) this.itemView.findViewById(R$id.topping_imageview)).setVisibility(8);
        ((TextView) this.itemView.findViewById(R$id.count_down_text)).setVisibility(8);
        if (visitorInfoModel.getVisitorEnable()) {
            ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(R$id.sessionUserAvatarImageView);
            s.h(imageLoaderView, "itemView.sessionUserAvatarImageView");
            ImageLoaderView.g(imageLoaderView, visitorInfoModel.getPretendAvatar(), new b(false, null, null, null, null, null, null, 0, 0, null, null, null, null, false, 0, 0, false, null, null, 520191, null), null, 4, null);
        } else {
            ImageLoaderView imageLoaderView2 = (ImageLoaderView) this.itemView.findViewById(R$id.sessionUserAvatarImageView);
            s.h(imageLoaderView2, "itemView.sessionUserAvatarImageView");
            ImageLoaderView.g(imageLoaderView2, visitorInfoModel.getPretendAvatar(), new b(false, null, null, null, null, null, null, 0, 0, null, null, null, new BlurModel(0.0f, 0, 3, null), false, 0, 0, false, null, null, 520191, null), null, 4, null);
            if (visitorInfoModel.getVisitorCount() > 0) {
                ((TextView) this.itemView.findViewById(i10)).setVisibility(0);
                ((TextView) this.itemView.findViewById(i10)).setText(" " + ((Object) q1.d.f53006a.g(m.d(visitorInfoModel.getVisitorCount()), BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX, new AbsoluteSizeSpan(h.c(this, 14.0f)))) + " ");
            }
        }
        ((TextView) this.itemView.findViewById(R$id.sessionUserNameTextView)).setText(q1.d.f53006a.g(visitorInfoModel.getPretendName(), m.d(visitorInfoModel.getNewVisitorCount()), new ForegroundColorSpan(-49088)));
        ((UserIconViewLayout) this.itemView.findViewById(R$id.vipIconImageView)).setVisibility(8);
        ((ImageLoaderView) this.itemView.findViewById(R$id.official_label_img)).setVisibility(8);
        ((FKUnreadCountTextView) this.itemView.findViewById(R$id.sessionUnreadCountView)).setVisibility(8);
        this.itemView.findViewById(R$id.session_red_dot_view).setVisibility(visitorInfoModel.getNewVisitorCount() > 0 ? 0 : 8);
        ((ImageView) this.itemView.findViewById(R$id.viewMessagePrivatelyIcon)).setVisibility(8);
        x(0);
        u(false);
    }

    public final String z(String str) {
        String string = this.itemView.getContext().getString(R$string.disappear_after_several_time_of_nearby, str);
        s.h(string, "itemView.context.getStri…ral_time_of_nearby, time)");
        return string;
    }
}
