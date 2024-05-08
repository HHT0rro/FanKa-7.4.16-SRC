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
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.livedata.EventObserver;
import com.cupidapp.live.maskparty.adapter.MaskPartyChatAdapter;
import com.cupidapp.live.maskparty.helper.MaskPartyPromptHelper;
import com.cupidapp.live.maskparty.helper.MaskPartyScriptHelper;
import com.cupidapp.live.maskparty.holder.PublicProfileModel;
import com.cupidapp.live.maskparty.model.GuessIdentityModel;
import com.cupidapp.live.maskparty.model.IdentityModel;
import com.cupidapp.live.maskparty.model.MaskPartyChatDiceModel;
import com.cupidapp.live.maskparty.model.MaskPartyChatRoomModel;
import com.cupidapp.live.maskparty.model.MaskPartyScriptModel;
import com.cupidapp.live.maskparty.model.MaskPartyScriptTaskModel;
import com.cupidapp.live.maskparty.model.MessageActionType;
import com.cupidapp.live.maskparty.model.ScriptRoleModel;
import com.cupidapp.live.maskparty.model.ScriptTaskScoreModel;
import com.cupidapp.live.maskparty.view.MaskPartyChatBottomLayout;
import com.cupidapp.live.maskparty.view.MaskPartyChatPromptLayout;
import com.cupidapp.live.maskparty.view.MaskPartyChatTitleLayout;
import com.cupidapp.live.maskparty.viewmodel.BaseMaskPartyChatViewModel;
import com.cupidapp.live.maskparty.viewmodel.MaskPartyScriptKillViewModel;
import com.cupidapp.live.profile.model.User;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.i0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MaskPartyScriptKillFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MaskPartyScriptKillFragment extends BaseMaskPartyChatFragment {

    /* renamed from: n, reason: collision with root package name */
    @NotNull
    public final Lazy f16313n;

    /* renamed from: o, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16314o = new LinkedHashMap();

    public MaskPartyScriptKillFragment() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.cupidapp.live.maskparty.fragment.MaskPartyScriptKillFragment$special$$inlined$viewModels$default$1
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
        this.f16313n = FragmentViewModelLazyKt.createViewModelLazy(this, kotlin.jvm.internal.v.b(MaskPartyScriptKillViewModel.class), new Function0<ViewModelStore>() { // from class: com.cupidapp.live.maskparty.fragment.MaskPartyScriptKillFragment$special$$inlined$viewModels$default$2
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

    public static final void M1(MaskPartyScriptKillFragment this$0, Integer it) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        MaskPartyChatTitleLayout maskPartyChatTitleLayout = (MaskPartyChatTitleLayout) this$0.Y0(R$id.mask_party_chat_title_layout);
        kotlin.jvm.internal.s.h(it, "it");
        maskPartyChatTitleLayout.d(it.intValue());
    }

    public static final void N1(MaskPartyScriptKillFragment this$0, User it) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        kotlin.jvm.internal.s.h(it, "it");
        this$0.z1(it);
    }

    public static final void O1(MaskPartyScriptKillFragment this$0, Pair pair) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        if (((Boolean) pair.getFirst()).booleanValue()) {
            MaskPartyChatPromptLayout.a aVar = MaskPartyChatPromptLayout.f16388f;
            Context context = this$0.getContext();
            String string = this$0.getString(R$string.script_kill_open_album_prompt);
            kotlin.jvm.internal.s.h(string, "getString(R.string.script_kill_open_album_prompt)");
            aVar.b(context, string);
            return;
        }
        this$0.r1((String) pair.getSecond());
    }

    public static final void P1(MaskPartyScriptKillFragment this$0, ScriptTaskScoreModel it) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        MaskPartyChatAdapter f12 = this$0.f1();
        kotlin.jvm.internal.s.h(it, "it");
        ((RecyclerView) this$0.Y0(R$id.mask_party_chat_recycler_view)).scrollToPosition(f12.y(it));
    }

    public static final void Q1(MaskPartyScriptKillFragment this$0, Boolean bool) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        ((MaskPartyChatTitleLayout) this$0.Y0(R$id.mask_party_chat_title_layout)).e(false);
        this$0.f1().H(false);
    }

    public static final void R1(MaskPartyScriptKillFragment this$0, Integer num) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        MaskPartyChatAdapter f12 = this$0.f1();
        String string = this$0.getString(R$string.public_profile_content, num);
        kotlin.jvm.internal.s.h(string, "getString(R.string.public_profile_content, it)");
        ((RecyclerView) this$0.Y0(R$id.mask_party_chat_recycler_view)).scrollToPosition(f12.w(string));
    }

    public static final void S1(MaskPartyScriptKillFragment this$0, Boolean bool) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        List<Object> j10 = this$0.f1().j();
        ArrayList arrayList = new ArrayList();
        for (Object obj : j10) {
            if (obj instanceof ScriptTaskScoreModel) {
                arrayList.add(obj);
            }
        }
        ScriptTaskScoreModel scriptTaskScoreModel = (ScriptTaskScoreModel) CollectionsKt___CollectionsKt.V(arrayList);
        if (scriptTaskScoreModel != null) {
            int indexOf = this$0.f1().j().indexOf(scriptTaskScoreModel);
            scriptTaskScoreModel.setPublic(true);
            this$0.f1().notifyItemChanged(indexOf);
        }
        List<Object> j11 = this$0.f1().j();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : j11) {
            if (obj2 instanceof PublicProfileModel) {
                arrayList2.add(obj2);
            }
        }
        PublicProfileModel publicProfileModel = (PublicProfileModel) CollectionsKt___CollectionsKt.V(arrayList2);
        if (publicProfileModel != null) {
            int indexOf2 = this$0.f1().j().indexOf(publicProfileModel);
            publicProfileModel.setPublic(true);
            this$0.f1().notifyItemChanged(indexOf2);
        }
    }

    @Override // com.cupidapp.live.maskparty.fragment.BaseMaskPartyChatFragment
    public void A1() {
        MaskPartyPromptHelper.f16347a.h(getContext(), R$string.script_kill_quit_prompt, new Function0<kotlin.p>() { // from class: com.cupidapp.live.maskparty.fragment.MaskPartyScriptKillFragment$showQuitRoomPrompt$1
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
                MaskPartyScriptKillFragment.this.g1().quitChatRoom();
            }
        });
    }

    @Override // com.cupidapp.live.maskparty.fragment.BaseMaskPartyChatFragment
    public void B1(@NotNull MaskPartyChatRoomModel model) {
        kotlin.jvm.internal.s.i(model, "model");
        String autoMsg = model.getAutoMsg();
        if (!(autoMsg == null || autoMsg.length() == 0)) {
            f1().x(model.getAutoMsg());
        }
        MaskPartyChatBottomLayout maskPartyChatBottomLayout = (MaskPartyChatBottomLayout) Y0(R$id.mask_party_chat_bottom_layout);
        String string = getString(R$string.script_default_message);
        kotlin.jvm.internal.s.h(string, "getString(R.string.script_default_message)");
        maskPartyChatBottomLayout.j(string, MessageActionType.Prepare, R$mipmap.icon_script_send_message_guide);
        g1().getScript();
    }

    @Override // com.cupidapp.live.maskparty.fragment.BaseMaskPartyChatFragment
    @NotNull
    /* renamed from: K1, reason: merged with bridge method [inline-methods] */
    public MaskPartyScriptKillViewModel g1() {
        return (MaskPartyScriptKillViewModel) this.f16313n.getValue();
    }

    public final void L1() {
        f1().l().k(i0.h(kotlin.f.a(Integer.valueOf(R$id.public_profile_button), new Function2<Object, Integer, kotlin.p>() { // from class: com.cupidapp.live.maskparty.fragment.MaskPartyScriptKillFragment$initAdapterClickEvent$1
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
                if (obj instanceof ScriptTaskScoreModel) {
                    ScriptTaskScoreModel scriptTaskScoreModel = (ScriptTaskScoreModel) obj;
                    if (!scriptTaskScoreModel.getPublic()) {
                        MaskPartyScriptKillFragment.this.g1().publicProfile();
                        scriptTaskScoreModel.setPublic(true);
                        MaskPartyScriptKillFragment.this.f1().notifyItemChanged(i10);
                    }
                }
                if (obj instanceof PublicProfileModel) {
                    PublicProfileModel publicProfileModel = (PublicProfileModel) obj;
                    if (!publicProfileModel.getPublic()) {
                        MaskPartyScriptKillFragment.this.g1().publicProfile();
                        publicProfileModel.setPublic(true);
                    }
                }
                MaskPartyScriptKillFragment.this.f1().notifyItemChanged(i10);
            }
        })));
    }

    @Override // com.cupidapp.live.maskparty.fragment.BaseMaskPartyChatFragment, com.cupidapp.live.base.fragment.FKBaseFragment
    public void N0() {
        this.f16314o.clear();
    }

    public final void T1() {
        int i10 = R$id.one_more_time_imageview;
        ((ImageView) Y0(i10)).setImageResource(R$mipmap.icon_script_task);
        ImageView one_more_time_imageview = (ImageView) Y0(i10);
        kotlin.jvm.internal.s.h(one_more_time_imageview, "one_more_time_imageview");
        z0.y.d(one_more_time_imageview, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.maskparty.fragment.MaskPartyScriptKillFragment$initScriptTaskView$1
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
                MaskPartyScriptKillFragment.this.g1().getScriptTaskInfo(true);
            }
        });
    }

    @Override // com.cupidapp.live.maskparty.fragment.BaseMaskPartyChatFragment
    @Nullable
    public View Y0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f16314o;
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
        g1().getCurrentProgressLiveData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.maskparty.fragment.w
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MaskPartyScriptKillFragment.M1(MaskPartyScriptKillFragment.this, (Integer) obj);
            }
        });
        g1().getScriptInfoEventLiveData().observe(getViewLifecycleOwner(), new EventObserver(new Function1<MaskPartyScriptModel, kotlin.p>() { // from class: com.cupidapp.live.maskparty.fragment.MaskPartyScriptKillFragment$initObserve$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(MaskPartyScriptModel maskPartyScriptModel) {
                invoke2(maskPartyScriptModel);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull MaskPartyScriptModel it) {
                kotlin.jvm.internal.s.i(it, "it");
                MaskPartyScriptHelper.f16348a.e(MaskPartyScriptKillFragment.this.getContext(), it);
            }
        }));
        g1().getShowChooseRoleEventLiveData().observe(getViewLifecycleOwner(), new EventObserver(new Function1<List<? extends ScriptRoleModel>, kotlin.p>() { // from class: com.cupidapp.live.maskparty.fragment.MaskPartyScriptKillFragment$initObserve$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(List<? extends ScriptRoleModel> list) {
                invoke2((List<ScriptRoleModel>) list);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull List<ScriptRoleModel> it) {
                kotlin.jvm.internal.s.i(it, "it");
                MaskPartyScriptHelper maskPartyScriptHelper = MaskPartyScriptHelper.f16348a;
                Context context = MaskPartyScriptKillFragment.this.getContext();
                final MaskPartyScriptKillFragment maskPartyScriptKillFragment = MaskPartyScriptKillFragment.this;
                maskPartyScriptHelper.g(context, it, new Function1<ScriptRoleModel, kotlin.p>() { // from class: com.cupidapp.live.maskparty.fragment.MaskPartyScriptKillFragment$initObserve$3.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ kotlin.p invoke(ScriptRoleModel scriptRoleModel) {
                        invoke2(scriptRoleModel);
                        return kotlin.p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull ScriptRoleModel role) {
                        kotlin.jvm.internal.s.i(role, "role");
                        MaskPartyScriptKillFragment.this.g1().selectRole(role.getId());
                    }
                });
            }
        }));
        g1().getScriptTaskEventLiveData().observe(getViewLifecycleOwner(), new EventObserver(new Function1<Pair<? extends MaskPartyScriptTaskModel, ? extends Boolean>, kotlin.p>() { // from class: com.cupidapp.live.maskparty.fragment.MaskPartyScriptKillFragment$initObserve$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Pair<? extends MaskPartyScriptTaskModel, ? extends Boolean> pair) {
                invoke2((Pair<MaskPartyScriptTaskModel, Boolean>) pair);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Pair<MaskPartyScriptTaskModel, Boolean> it) {
                kotlin.jvm.internal.s.i(it, "it");
                MaskPartyScriptKillFragment maskPartyScriptKillFragment = MaskPartyScriptKillFragment.this;
                int i10 = R$id.one_more_time_imageview;
                ImageView one_more_time_imageview = (ImageView) maskPartyScriptKillFragment.Y0(i10);
                kotlin.jvm.internal.s.h(one_more_time_imageview, "one_more_time_imageview");
                if (!(one_more_time_imageview.getVisibility() == 0)) {
                    ImageView one_more_time_imageview2 = (ImageView) MaskPartyScriptKillFragment.this.Y0(i10);
                    kotlin.jvm.internal.s.h(one_more_time_imageview2, "one_more_time_imageview");
                    one_more_time_imageview2.setVisibility(0);
                }
                final MaskPartyScriptTaskModel first = it.getFirst();
                boolean booleanValue = it.getSecond().booleanValue();
                MaskPartyScriptHelper maskPartyScriptHelper = MaskPartyScriptHelper.f16348a;
                Context context = MaskPartyScriptKillFragment.this.getContext();
                final MaskPartyScriptKillFragment maskPartyScriptKillFragment2 = MaskPartyScriptKillFragment.this;
                maskPartyScriptHelper.f(context, first, booleanValue, new Function0<kotlin.p>() { // from class: com.cupidapp.live.maskparty.fragment.MaskPartyScriptKillFragment$initObserve$4.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        BaseMaskPartyChatViewModel.sendTextMessage$default(MaskPartyScriptKillFragment.this.g1(), first.getPrologue(), MessageActionType.Ordinary, null, 4, null);
                    }
                });
            }
        }));
        g1().getJudgeIdentityEventLiveData().observe(getViewLifecycleOwner(), new EventObserver(new Function1<GuessIdentityModel, kotlin.p>() { // from class: com.cupidapp.live.maskparty.fragment.MaskPartyScriptKillFragment$initObserve$5
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(GuessIdentityModel guessIdentityModel) {
                invoke2(guessIdentityModel);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull GuessIdentityModel identity) {
                kotlin.jvm.internal.s.i(identity, "identity");
                MaskPartyScriptHelper maskPartyScriptHelper = MaskPartyScriptHelper.f16348a;
                Context context = MaskPartyScriptKillFragment.this.getContext();
                final MaskPartyScriptKillFragment maskPartyScriptKillFragment = MaskPartyScriptKillFragment.this;
                maskPartyScriptHelper.d(context, identity, new Function1<IdentityModel, kotlin.p>() { // from class: com.cupidapp.live.maskparty.fragment.MaskPartyScriptKillFragment$initObserve$5.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ kotlin.p invoke(IdentityModel identityModel) {
                        invoke2(identityModel);
                        return kotlin.p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull IdentityModel it) {
                        kotlin.jvm.internal.s.i(it, "it");
                        MaskPartyScriptKillFragment.this.g1().judgeIdentity(it.getId());
                    }
                });
            }
        }));
        g1().getStartCountDownEventLiveData().observe(getViewLifecycleOwner(), new EventObserver(new Function1<Pair<? extends Integer, ? extends Integer>, kotlin.p>() { // from class: com.cupidapp.live.maskparty.fragment.MaskPartyScriptKillFragment$initObserve$6
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Pair<? extends Integer, ? extends Integer> pair) {
                invoke2((Pair<Integer, Integer>) pair);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Pair<Integer, Integer> it) {
                kotlin.jvm.internal.s.i(it, "it");
                final int intValue = it.getFirst().intValue();
                final int intValue2 = it.getSecond().intValue();
                final int i10 = intValue / 10;
                MaskPartyScriptHelper maskPartyScriptHelper = MaskPartyScriptHelper.f16348a;
                final MaskPartyScriptKillFragment maskPartyScriptKillFragment = MaskPartyScriptKillFragment.this;
                maskPartyScriptHelper.h(intValue, intValue2, new Function1<Integer, kotlin.p>() { // from class: com.cupidapp.live.maskparty.fragment.MaskPartyScriptKillFragment$initObserve$6.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ kotlin.p invoke(Integer num) {
                        invoke(num.intValue());
                        return kotlin.p.f51048a;
                    }

                    public final void invoke(int i11) {
                        if (i11 % i10 == 0) {
                            maskPartyScriptKillFragment.g1().updateCurrentProgress((i11 / i10) * 10);
                        }
                        if (i11 == intValue) {
                            maskPartyScriptKillFragment.g1().showJudgeIdentityDialog();
                        } else if (i11 == intValue2) {
                            maskPartyScriptKillFragment.g1().addPublicProfilePrompt(intValue2);
                        }
                    }
                });
            }
        }));
        g1().getShowOpenProfilePromptEventLiveData().observe(getViewLifecycleOwner(), new EventObserver(new Function1<Boolean, kotlin.p>() { // from class: com.cupidapp.live.maskparty.fragment.MaskPartyScriptKillFragment$initObserve$7
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return kotlin.p.f51048a;
            }

            public final void invoke(boolean z10) {
                MaskPartyChatPromptLayout.a aVar = MaskPartyChatPromptLayout.f16388f;
                Context context = MaskPartyScriptKillFragment.this.getContext();
                String string = MaskPartyScriptKillFragment.this.getString(R$string.script_kill_open_profile_prompt_content);
                kotlin.jvm.internal.s.h(string, "getString(R.string.scrip…n_profile_prompt_content)");
                aVar.c(context, string);
            }
        }));
        g1().getShowPublicProfilePromptEventLiveData().observe(getViewLifecycleOwner(), new EventObserver(new Function1<Pair<? extends Boolean, ? extends Boolean>, kotlin.p>() { // from class: com.cupidapp.live.maskparty.fragment.MaskPartyScriptKillFragment$initObserve$8
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Pair<? extends Boolean, ? extends Boolean> pair) {
                invoke2((Pair<Boolean, Boolean>) pair);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Pair<Boolean, Boolean> it) {
                kotlin.jvm.internal.s.i(it, "it");
                if (!it.getFirst().booleanValue()) {
                    MaskPartyPromptHelper maskPartyPromptHelper = MaskPartyPromptHelper.f16347a;
                    Context context = MaskPartyScriptKillFragment.this.getContext();
                    final MaskPartyScriptKillFragment maskPartyScriptKillFragment = MaskPartyScriptKillFragment.this;
                    maskPartyPromptHelper.f(context, new Function0<kotlin.p>() { // from class: com.cupidapp.live.maskparty.fragment.MaskPartyScriptKillFragment$initObserve$8.1
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
                            MaskPartyScriptKillFragment.this.g1().publicProfile();
                        }
                    });
                    return;
                }
                if (it.getSecond().booleanValue()) {
                    return;
                }
                com.cupidapp.live.base.view.h.f12779a.k(R$string.others_public_profile_prompt);
            }
        }));
        g1().getOpenProfileLiveData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.maskparty.fragment.t
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MaskPartyScriptKillFragment.N1(MaskPartyScriptKillFragment.this, (User) obj);
            }
        });
        g1().getOpenAlbumLiveData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.maskparty.fragment.y
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MaskPartyScriptKillFragment.O1(MaskPartyScriptKillFragment.this, (Pair) obj);
            }
        });
        g1().getScriptTaskScoreLiveData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.maskparty.fragment.s
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MaskPartyScriptKillFragment.P1(MaskPartyScriptKillFragment.this, (ScriptTaskScoreModel) obj);
            }
        });
        g1().getOthersPublicProfileLiveData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.maskparty.fragment.u
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MaskPartyScriptKillFragment.Q1(MaskPartyScriptKillFragment.this, (Boolean) obj);
            }
        });
        g1().getLeaveRoomEventLiveData().observe(getViewLifecycleOwner(), new EventObserver(new Function1<Boolean, kotlin.p>() { // from class: com.cupidapp.live.maskparty.fragment.MaskPartyScriptKillFragment$initObserve$13
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return kotlin.p.f51048a;
            }

            public final void invoke(boolean z10) {
                MaskPartyScriptHelper.f16348a.i();
                MaskPartyPromptHelper maskPartyPromptHelper = MaskPartyPromptHelper.f16347a;
                Context context = MaskPartyScriptKillFragment.this.getContext();
                final MaskPartyScriptKillFragment maskPartyScriptKillFragment = MaskPartyScriptKillFragment.this;
                maskPartyPromptHelper.c(context, z10, new Function0<kotlin.p>() { // from class: com.cupidapp.live.maskparty.fragment.MaskPartyScriptKillFragment$initObserve$13.1
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
                        BaseMaskPartyChatFragment.e1(MaskPartyScriptKillFragment.this, false, 1, null);
                    }
                });
            }
        }));
        g1().getShowPublicProfileLiveData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.maskparty.fragment.x
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MaskPartyScriptKillFragment.R1(MaskPartyScriptKillFragment.this, (Integer) obj);
            }
        });
        g1().getPublicMyProfileLiveData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.maskparty.fragment.v
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MaskPartyScriptKillFragment.S1(MaskPartyScriptKillFragment.this, (Boolean) obj);
            }
        });
    }

    @Override // com.cupidapp.live.maskparty.fragment.BaseMaskPartyChatFragment, com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        MaskPartyScriptHelper.f16348a.i();
        N0();
    }

    @Override // com.cupidapp.live.maskparty.fragment.BaseMaskPartyChatFragment, com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        kotlin.jvm.internal.s.i(view, "view");
        super.onViewCreated(view, bundle);
        T1();
        L1();
    }

    @Override // com.cupidapp.live.maskparty.fragment.BaseMaskPartyChatFragment
    public void s1() {
        MaskPartyScriptHelper.f16348a.i();
    }

    @Override // com.cupidapp.live.maskparty.fragment.BaseMaskPartyChatFragment
    public void t1(boolean z10, @NotNull String systemMessage) {
        kotlin.jvm.internal.s.i(systemMessage, "systemMessage");
        g1().insertNoticeMessage(null, systemMessage);
        if (z10) {
            g1().showChooseRoleDialog();
        }
        g1().startCountDown();
    }

    @Override // com.cupidapp.live.maskparty.fragment.BaseMaskPartyChatFragment
    public void y1(@NotNull MaskPartyChatDiceModel dice) {
        kotlin.jvm.internal.s.i(dice, "dice");
        if (dice.getNeedShowShotAnimation()) {
            w1(dice, "script_kill_action.svga");
        } else {
            g1().insertDiceMessage(dice);
        }
    }
}
