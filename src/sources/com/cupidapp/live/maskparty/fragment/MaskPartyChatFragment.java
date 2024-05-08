package com.cupidapp.live.maskparty.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.livedata.EventObserver;
import com.cupidapp.live.maskparty.fragment.BaseMaskPartyChatFragment;
import com.cupidapp.live.maskparty.helper.MaskPartyPromptHelper;
import com.cupidapp.live.maskparty.model.MaskPartyChatDiceModel;
import com.cupidapp.live.maskparty.model.MaskPartyChatMessageModel;
import com.cupidapp.live.maskparty.model.MaskPartyChatNotifyMessageModel;
import com.cupidapp.live.maskparty.model.MaskPartyChatRoomModel;
import com.cupidapp.live.maskparty.model.MaskPartyQuestionItemModel;
import com.cupidapp.live.maskparty.model.MaskPartyType;
import com.cupidapp.live.maskparty.model.MessageActionType;
import com.cupidapp.live.maskparty.model.NoticeButtonType;
import com.cupidapp.live.maskparty.view.MaskPartyChatBottomLayout;
import com.cupidapp.live.maskparty.view.MaskPartyChatPromptLayout;
import com.cupidapp.live.maskparty.view.MaskPartyChatTitleLayout;
import com.cupidapp.live.maskparty.view.MaskPartyQuestionLayout;
import com.cupidapp.live.maskparty.viewmodel.BaseMaskPartyChatViewModel;
import com.cupidapp.live.maskparty.viewmodel.MaskPartyChatViewModel;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.track.group.GroupSocialLog;
import com.irisdt.client.post.PostAndSocialProtos;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MaskPartyChatFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MaskPartyChatFragment extends BaseMaskPartyChatFragment {

    /* renamed from: n, reason: collision with root package name */
    @NotNull
    public final Lazy f16282n;

    /* renamed from: o, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16283o = new LinkedHashMap();

    /* compiled from: MaskPartyChatFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a implements com.cupidapp.live.maskparty.view.m {
        public a() {
        }

        @Override // com.cupidapp.live.maskparty.view.m
        public void a(int i10) {
            User targetUserInfo;
            MaskPartyChatFragment.this.g1().selectQuestionType(i10);
            GroupSocialLog groupSocialLog = GroupSocialLog.f18708a;
            PostAndSocialProtos.Type type = PostAndSocialProtos.Type.CHOOSE_PROBLEM;
            BaseMaskPartyChatFragment.a aVar = BaseMaskPartyChatFragment.f16269l;
            MaskPartyChatRoomModel a10 = aVar.a();
            String str = null;
            String roomId = a10 != null ? a10.getRoomId() : null;
            MaskPartyChatRoomModel a11 = aVar.a();
            if (a11 != null && (targetUserInfo = a11.getTargetUserInfo()) != null) {
                str = targetUserInfo.userId();
            }
            groupSocialLog.R(type, (r15 & 2) != 0 ? null : roomId, (r15 & 4) != 0 ? null : str, (r15 & 8) != 0 ? null : Integer.valueOf(i10), (r15 & 16) != 0 ? null : null, (r15 & 32) != 0 ? false : false, (r15 & 64) == 0 ? null : null);
        }

        @Override // com.cupidapp.live.maskparty.view.m
        public void b(@NotNull MaskPartyQuestionItemModel question) {
            User targetUserInfo;
            kotlin.jvm.internal.s.i(question, "question");
            GroupSocialLog groupSocialLog = GroupSocialLog.f18708a;
            PostAndSocialProtos.Type type = PostAndSocialProtos.Type.ASK_QUESTION;
            BaseMaskPartyChatFragment.a aVar = BaseMaskPartyChatFragment.f16269l;
            MaskPartyChatRoomModel a10 = aVar.a();
            String str = null;
            String roomId = a10 != null ? a10.getRoomId() : null;
            MaskPartyChatRoomModel a11 = aVar.a();
            if (a11 != null && (targetUserInfo = a11.getTargetUserInfo()) != null) {
                str = targetUserInfo.userId();
            }
            groupSocialLog.R(type, (r15 & 2) != 0 ? null : roomId, (r15 & 4) != 0 ? null : str, (r15 & 8) != 0 ? null : Integer.valueOf(question.getIndex()), (r15 & 16) != 0 ? null : null, (r15 & 32) != 0 ? false : false, (r15 & 64) == 0 ? null : null);
            BaseMaskPartyChatViewModel.sendTextMessage$default(MaskPartyChatFragment.this.g1(), question.getContent(), MessageActionType.Question, null, 4, null);
        }
    }

    public MaskPartyChatFragment() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.cupidapp.live.maskparty.fragment.MaskPartyChatFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        this.f16282n = FragmentViewModelLazyKt.createViewModelLazy(this, kotlin.jvm.internal.v.b(MaskPartyChatViewModel.class), new Function0<ViewModelStore>() { // from class: com.cupidapp.live.maskparty.fragment.MaskPartyChatFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) Function0.this.invoke()).getViewModelStore();
                kotlin.jvm.internal.s.h(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, null);
    }

    public static final void G1(MaskPartyChatFragment this$0, Integer it) {
        User targetUserInfo;
        kotlin.jvm.internal.s.i(this$0, "this$0");
        int i10 = R$id.mask_party_chat_title_layout;
        MaskPartyChatTitleLayout maskPartyChatTitleLayout = (MaskPartyChatTitleLayout) this$0.Y0(i10);
        kotlin.jvm.internal.s.h(it, "it");
        maskPartyChatTitleLayout.d(it.intValue());
        if (MaskPartyChatRoomModel.Companion.a(it)) {
            return;
        }
        ((MaskPartyChatTitleLayout) this$0.Y0(i10)).e(false);
        this$0.f1().H(false);
        GroupSocialLog groupSocialLog = GroupSocialLog.f18708a;
        PostAndSocialProtos.Type type = PostAndSocialProtos.Type.SHOW_PROFILE;
        BaseMaskPartyChatFragment.a aVar = BaseMaskPartyChatFragment.f16269l;
        MaskPartyChatRoomModel a10 = aVar.a();
        String roomId = a10 != null ? a10.getRoomId() : null;
        MaskPartyChatRoomModel a11 = aVar.a();
        groupSocialLog.R(type, (r15 & 2) != 0 ? null : roomId, (r15 & 4) != 0 ? null : (a11 == null || (targetUserInfo = a11.getTargetUserInfo()) == null) ? null : targetUserInfo.userId(), (r15 & 8) != 0 ? null : null, (r15 & 16) != 0 ? null : null, (r15 & 32) != 0 ? false : false, (r15 & 64) == 0 ? kotlin.collections.r.e(MaskPartyType.MessageChat) : null);
    }

    public static final void H1(MaskPartyChatFragment this$0, List list) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        MaskPartyQuestionLayout maskPartyQuestionLayout = (MaskPartyQuestionLayout) this$0.Y0(R$id.mask_party_question_layout);
        kotlin.jvm.internal.s.h(list, "list");
        maskPartyQuestionLayout.i(list);
    }

    @Override // com.cupidapp.live.maskparty.fragment.BaseMaskPartyChatFragment
    public void A1() {
        MaskPartyPromptHelper.f16347a.h(getContext(), R$string.quit_chat_content, new Function0<kotlin.p>() { // from class: com.cupidapp.live.maskparty.fragment.MaskPartyChatFragment$showQuitRoomPrompt$1
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
                MaskPartyChatFragment.this.g1().quitChatRoom();
            }
        });
    }

    @Override // com.cupidapp.live.maskparty.fragment.BaseMaskPartyChatFragment
    public void B1(@NotNull MaskPartyChatRoomModel model) {
        kotlin.jvm.internal.s.i(model, "model");
        g1().insertTextMessage(model.getAutoMsg(), model.getTargetUserInfo());
        MaskPartyChatBottomLayout maskPartyChatBottomLayout = (MaskPartyChatBottomLayout) Y0(R$id.mask_party_chat_bottom_layout);
        String string = getString(R$string.shot);
        kotlin.jvm.internal.s.h(string, "getString(R.string.shot)");
        maskPartyChatBottomLayout.j(string, MessageActionType.Prepare, R$mipmap.icon_send_message_guide);
    }

    @Override // com.cupidapp.live.maskparty.fragment.BaseMaskPartyChatFragment
    public void C1(@NotNull MaskPartyChatMessageModel message) {
        kotlin.jvm.internal.s.i(message, "message");
        MaskPartyChatNotifyMessageModel notice = message.getNotice();
        Integer buttonType = notice != null ? notice.getButtonType() : null;
        int type = NoticeButtonType.Agree.getType();
        if (buttonType != null && buttonType.intValue() == type) {
            g1().playAgain(message);
            return;
        }
        int type2 = NoticeButtonType.Aloha.getType();
        if (buttonType != null && buttonType.intValue() == type2) {
            g1().alohaUser(message);
        }
    }

    @Override // com.cupidapp.live.maskparty.fragment.BaseMaskPartyChatFragment
    @NotNull
    /* renamed from: F1, reason: merged with bridge method [inline-methods] */
    public MaskPartyChatViewModel g1() {
        return (MaskPartyChatViewModel) this.f16282n.getValue();
    }

    public final void I1() {
        int i10 = R$id.one_more_time_imageview;
        ((ImageView) Y0(i10)).setImageResource(R$mipmap.icon_one_more_time);
        ImageView one_more_time_imageview = (ImageView) Y0(i10);
        kotlin.jvm.internal.s.h(one_more_time_imageview, "one_more_time_imageview");
        z0.y.d(one_more_time_imageview, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.maskparty.fragment.MaskPartyChatFragment$initOneMoreTimeView$1
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
                MaskPartyChatFragment.this.g1().playAgain(MaskPartyChatFragment.this.f1().D(NoticeButtonType.Agree));
            }
        });
    }

    public final void J1() {
        ((MaskPartyQuestionLayout) Y0(R$id.mask_party_question_layout)).setSelectListener(new a());
    }

    @Override // com.cupidapp.live.maskparty.fragment.BaseMaskPartyChatFragment, com.cupidapp.live.base.fragment.FKBaseFragment
    public void N0() {
        this.f16283o.clear();
    }

    @Override // com.cupidapp.live.maskparty.fragment.BaseMaskPartyChatFragment
    @Nullable
    public View Y0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f16283o;
        View view = map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null || (findViewById = view2.findViewById(i10)) == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    @Override // com.cupidapp.live.maskparty.fragment.BaseMaskPartyChatFragment
    public void h1() {
        super.h1();
        g1().getCurrentScoreLiveData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.maskparty.fragment.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MaskPartyChatFragment.G1(MaskPartyChatFragment.this, (Integer) obj);
            }
        });
        g1().getQuestionLiveData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.maskparty.fragment.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MaskPartyChatFragment.H1(MaskPartyChatFragment.this, (List) obj);
            }
        });
        g1().getShowPlayAgainEventLiveData().observe(getViewLifecycleOwner(), new EventObserver(new Function1<Boolean, kotlin.p>() { // from class: com.cupidapp.live.maskparty.fragment.MaskPartyChatFragment$initObserve$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return kotlin.p.f51048a;
            }

            public final void invoke(boolean z10) {
                ((ImageView) MaskPartyChatFragment.this.Y0(R$id.one_more_time_imageview)).setVisibility(z10 ? 0 : 8);
            }
        }));
        g1().getOpenProfileEventLiveData().observe(getViewLifecycleOwner(), new EventObserver(new Function1<Pair<? extends Boolean, ? extends User>, kotlin.p>() { // from class: com.cupidapp.live.maskparty.fragment.MaskPartyChatFragment$initObserve$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Pair<? extends Boolean, ? extends User> pair) {
                invoke2((Pair<Boolean, User>) pair);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Pair<Boolean, User> it) {
                kotlin.jvm.internal.s.i(it, "it");
                if (it.getFirst().booleanValue()) {
                    MaskPartyChatPromptLayout.a aVar = MaskPartyChatPromptLayout.f16388f;
                    Context context = MaskPartyChatFragment.this.getContext();
                    String string = MaskPartyChatFragment.this.getString(R$string.open_profile_prompt_content);
                    kotlin.jvm.internal.s.h(string, "getString(R.string.open_profile_prompt_content)");
                    aVar.c(context, string);
                    return;
                }
                MaskPartyChatFragment.this.z1(it.getSecond());
            }
        }));
        g1().getOpenAlbumEventLiveData().observe(getViewLifecycleOwner(), new EventObserver(new Function1<Pair<? extends Boolean, ? extends String>, kotlin.p>() { // from class: com.cupidapp.live.maskparty.fragment.MaskPartyChatFragment$initObserve$5
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Pair<? extends Boolean, ? extends String> pair) {
                invoke2((Pair<Boolean, String>) pair);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Pair<Boolean, String> it) {
                kotlin.jvm.internal.s.i(it, "it");
                if (it.getFirst().booleanValue()) {
                    MaskPartyChatPromptLayout.a aVar = MaskPartyChatPromptLayout.f16388f;
                    Context context = MaskPartyChatFragment.this.getContext();
                    String string = MaskPartyChatFragment.this.getString(R$string.open_album_prompt_content);
                    kotlin.jvm.internal.s.h(string, "getString(R.string.open_album_prompt_content)");
                    aVar.b(context, string);
                    return;
                }
                MaskPartyChatFragment.this.r1(it.getSecond());
            }
        }));
        g1().getLeaveRoomEventLiveData().observe(getViewLifecycleOwner(), new EventObserver(new Function1<Boolean, kotlin.p>() { // from class: com.cupidapp.live.maskparty.fragment.MaskPartyChatFragment$initObserve$6
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return kotlin.p.f51048a;
            }

            public final void invoke(boolean z10) {
                MaskPartyPromptHelper maskPartyPromptHelper = MaskPartyPromptHelper.f16347a;
                Context context = MaskPartyChatFragment.this.getContext();
                final MaskPartyChatFragment maskPartyChatFragment = MaskPartyChatFragment.this;
                Function1<Boolean, kotlin.p> function1 = new Function1<Boolean, kotlin.p>() { // from class: com.cupidapp.live.maskparty.fragment.MaskPartyChatFragment$initObserve$6.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ kotlin.p invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return kotlin.p.f51048a;
                    }

                    public final void invoke(boolean z11) {
                        MaskPartyChatFragment.this.d1(z11);
                    }
                };
                final MaskPartyChatFragment maskPartyChatFragment2 = MaskPartyChatFragment.this;
                maskPartyPromptHelper.d(context, z10, function1, new Function0<kotlin.p>() { // from class: com.cupidapp.live.maskparty.fragment.MaskPartyChatFragment$initObserve$6.2
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
                        BaseMaskPartyChatFragment.e1(MaskPartyChatFragment.this, false, 1, null);
                    }
                });
            }
        }));
    }

    @Override // com.cupidapp.live.maskparty.fragment.BaseMaskPartyChatFragment, com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        N0();
    }

    @Override // com.cupidapp.live.maskparty.fragment.BaseMaskPartyChatFragment, com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        kotlin.jvm.internal.s.i(view, "view");
        super.onViewCreated(view, bundle);
        J1();
        I1();
    }

    @Override // com.cupidapp.live.maskparty.fragment.BaseMaskPartyChatFragment
    public void t1(boolean z10, @NotNull String systemMessage) {
        kotlin.jvm.internal.s.i(systemMessage, "systemMessage");
        if (z10) {
            g1().getQuestionList();
        } else {
            g1().insertNoticeMessage(null, systemMessage);
        }
    }

    @Override // com.cupidapp.live.maskparty.fragment.BaseMaskPartyChatFragment
    public void u1() {
        p1.g gVar = p1.g.f52734a;
        if (kotlin.jvm.internal.s.d(gVar.j0(), Boolean.TRUE)) {
            gVar.M2(Boolean.FALSE);
            MaskPartyChatPromptLayout.f16388f.d(getContext());
        }
    }

    @Override // com.cupidapp.live.maskparty.fragment.BaseMaskPartyChatFragment
    public void y1(@NotNull MaskPartyChatDiceModel dice) {
        kotlin.jvm.internal.s.i(dice, "dice");
        MaskPartyChatMessageModel D = f1().D(NoticeButtonType.Agree);
        if (D != null) {
            g1().updateNoticeMessage(D);
        }
        if (dice.getNeedShowShotAnimation()) {
            w1(dice, "shot.svga");
        } else {
            g1().insertDiceMessage(dice);
        }
    }
}
