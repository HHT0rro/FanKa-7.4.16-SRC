package com.cupidapp.live.maskparty.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.fragment.FKBaseFragment;
import com.cupidapp.live.base.livedata.EventObserver;
import com.cupidapp.live.base.network.model.ViewProfilePrefer;
import com.cupidapp.live.base.permission.FKRxPermissionAlertDialog;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.sensorslog.PopupButtonName;
import com.cupidapp.live.base.sensorslog.PopupName;
import com.cupidapp.live.base.sensorslog.ProfileSensorContext;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick;
import com.cupidapp.live.base.utils.n0;
import com.cupidapp.live.base.utils.o;
import com.cupidapp.live.base.utils.p0;
import com.cupidapp.live.base.view.animation.FKSVGAImageView;
import com.cupidapp.live.maskparty.activity.ChatPhoneAlbumActivity;
import com.cupidapp.live.maskparty.activity.MaskPartyLookSnapImageActivity;
import com.cupidapp.live.maskparty.activity.MaskPartyMatchActivity;
import com.cupidapp.live.maskparty.adapter.MaskPartyChatAdapter;
import com.cupidapp.live.maskparty.helper.MaskPartyPromptHelper;
import com.cupidapp.live.maskparty.model.DiceAnimationFinishEvent;
import com.cupidapp.live.maskparty.model.HangUpPopupType;
import com.cupidapp.live.maskparty.model.MaskPartyChatDiceModel;
import com.cupidapp.live.maskparty.model.MaskPartyChatMessageBindLongClickEvent;
import com.cupidapp.live.maskparty.model.MaskPartyChatMessageModel;
import com.cupidapp.live.maskparty.model.MaskPartyChatMessageSendFailResendEvent;
import com.cupidapp.live.maskparty.model.MaskPartyChatMessageType;
import com.cupidapp.live.maskparty.model.MaskPartyChatNotifyMessageModel;
import com.cupidapp.live.maskparty.model.MaskPartyChatRoomModel;
import com.cupidapp.live.maskparty.model.MaskPartyHangUpMessageModel;
import com.cupidapp.live.maskparty.model.MaskPartyLongClickActionType;
import com.cupidapp.live.maskparty.model.MaskPartyType;
import com.cupidapp.live.maskparty.model.MessageActionType;
import com.cupidapp.live.maskparty.model.NoticeButtonType;
import com.cupidapp.live.maskparty.model.SnapMessageDestroyEvent;
import com.cupidapp.live.maskparty.view.MaskPartyChatBottomLayout;
import com.cupidapp.live.maskparty.view.MaskPartyChatPromptLayout;
import com.cupidapp.live.maskparty.view.MaskPartyChatTitleLayout;
import com.cupidapp.live.maskparty.view.MaskPartyMessageActionLayout;
import com.cupidapp.live.maskparty.viewmodel.BaseMaskPartyChatViewModel;
import com.cupidapp.live.mediapicker.model.CameraStartPosition;
import com.cupidapp.live.mediapicker.newmediapicker.fragment.MediaPickerFragment;
import com.cupidapp.live.mediapicker.newmediapicker.model.MediaType;
import com.cupidapp.live.profile.activity.UserProfileActivity;
import com.cupidapp.live.profile.event.UserProfileDataChangeEvent;
import com.cupidapp.live.profile.model.User;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BaseMaskPartyChatFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class BaseMaskPartyChatFragment extends FKBaseFragment {

    /* renamed from: l, reason: collision with root package name */
    @NotNull
    public static final a f16269l = new a(null);

    /* renamed from: m, reason: collision with root package name */
    @Nullable
    public static MaskPartyChatRoomModel f16270m;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public Observer<MaskPartyChatMessageModel> f16271e;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public ActivityResultLauncher<Intent> f16274h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    public com.cupidapp.live.base.view.o f16275i;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    public com.cupidapp.live.base.utils.o f16276j;

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16277k = new LinkedHashMap();

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public final MaskPartyChatAdapter f16272f = new MaskPartyChatAdapter();

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public final Lazy f16273g = kotlin.c.b(new Function0<Boolean>() { // from class: com.cupidapp.live.maskparty.fragment.BaseMaskPartyChatFragment$isRecommendMatch$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @Nullable
        public final Boolean invoke() {
            Bundle arguments = BaseMaskPartyChatFragment.this.getArguments();
            if (arguments != null) {
                return Boolean.valueOf(arguments.getBoolean("IS_RECOMMEND_MATCH"));
            }
            return null;
        }
    });

    /* compiled from: BaseMaskPartyChatFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final MaskPartyChatRoomModel a() {
            return BaseMaskPartyChatFragment.f16270m;
        }

        @Nullable
        public final BaseMaskPartyChatFragment b(@NotNull String roomId, int i10, boolean z10) {
            BaseMaskPartyChatFragment maskPartyScriptKillFragment;
            kotlin.jvm.internal.s.i(roomId, "roomId");
            if (i10 == MaskPartyType.MessageChat.getType()) {
                maskPartyScriptKillFragment = new MaskPartyChatFragment();
            } else {
                maskPartyScriptKillFragment = i10 == MaskPartyType.ScriptKill.getType() ? new MaskPartyScriptKillFragment() : null;
            }
            if (maskPartyScriptKillFragment != null) {
                Bundle bundle = new Bundle();
                bundle.putString("MASK_PARTY_ROOM_ID", roomId);
                bundle.putInt("MASK_PARTY_TYPE", i10);
                bundle.putBoolean("IS_RECOMMEND_MATCH", z10);
                maskPartyScriptKillFragment.setArguments(bundle);
            }
            return maskPartyScriptKillFragment;
        }
    }

    /* compiled from: BaseMaskPartyChatFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b implements com.cupidapp.live.maskparty.view.g {
        public b() {
        }

        @Override // com.cupidapp.live.maskparty.view.g
        public void a() {
            BaseMaskPartyChatFragment.this.onBackPressed();
        }

        @Override // com.cupidapp.live.maskparty.view.g
        public void b() {
            BaseMaskPartyChatFragment.this.g1().openProfile();
        }
    }

    /* compiled from: BaseMaskPartyChatFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class c implements com.cupidapp.live.maskparty.view.c {
        public c() {
        }

        @Override // com.cupidapp.live.maskparty.view.c
        public void a() {
            BaseMaskPartyChatFragment.this.g1().openAlbum();
        }

        @Override // com.cupidapp.live.maskparty.view.c
        public void b() {
            BaseMaskPartyChatFragment.this.g1().typing();
        }

        @Override // com.cupidapp.live.maskparty.view.c
        public void c(@NotNull String textMessage, @NotNull MessageActionType type, boolean z10) {
            kotlin.jvm.internal.s.i(textMessage, "textMessage");
            kotlin.jvm.internal.s.i(type, "type");
            BaseMaskPartyChatViewModel.sendTextMessage$default(BaseMaskPartyChatFragment.this.g1(), textMessage, type, null, 4, null);
            if (z10) {
                BaseMaskPartyChatFragment.this.u1();
            }
        }
    }

    /* compiled from: BaseMaskPartyChatFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class d implements o.c {
        @Override // com.cupidapp.live.base.utils.o.c
        public void a(long j10) {
            o.c.a.a(this, j10);
        }

        @Override // com.cupidapp.live.base.utils.o.c
        public void b(@NotNull String imageUriString, boolean z10) {
            kotlin.jvm.internal.s.i(imageUriString, "imageUriString");
            j1.k.f50238a.d(SensorPosition.ChatRoom, z10);
        }
    }

    public static /* synthetic */ void e1(BaseMaskPartyChatFragment baseMaskPartyChatFragment, boolean z10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: finishActivity");
        }
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        baseMaskPartyChatFragment.d1(z10);
    }

    public static final void i1(BaseMaskPartyChatFragment this$0, MaskPartyChatRoomModel model) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        f16270m = model;
        ((MaskPartyChatTitleLayout) this$0.Y0(R$id.mask_party_chat_title_layout)).f(model.getTargetUserInfo(), true);
        MaskPartyChatAdapter maskPartyChatAdapter = this$0.f16272f;
        kotlin.jvm.internal.s.h(model, "model");
        maskPartyChatAdapter.z(model);
        this$0.B1(model);
    }

    public static final void j1(BaseMaskPartyChatFragment this$0, MaskPartyChatMessageModel model) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        kotlin.jvm.internal.s.i(model, "model");
        ((RecyclerView) this$0.Y0(R$id.mask_party_chat_recycler_view)).scrollToPosition(this$0.f16272f.v(model));
    }

    public static final void k1(BaseMaskPartyChatFragment this$0, Pair pair) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        this$0.f16272f.G(((Number) pair.getFirst()).longValue(), (MaskPartyChatMessageModel) pair.getSecond());
    }

    public static final void l1(BaseMaskPartyChatFragment this$0, Boolean it) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        kotlin.jvm.internal.s.h(it, "it");
        if (it.booleanValue() && !kotlin.jvm.internal.s.d(this$0.p1(), Boolean.TRUE)) {
            Intent intent = new Intent();
            intent.putExtra("MASK_PARTY_SHOW_ITEM_CARD_PROMPT", true);
            FragmentActivity activity = this$0.getActivity();
            if (activity != null) {
                activity.setResult(-1, intent);
            }
        }
        FragmentActivity activity2 = this$0.getActivity();
        if (activity2 != null) {
            activity2.finish();
        }
    }

    public static final boolean o1(RecyclerView recyclerView, View view, MotionEvent motionEvent) {
        recyclerView.performClick();
        if (motionEvent.getAction() != 2) {
            return false;
        }
        Context context = recyclerView.getContext();
        kotlin.jvm.internal.s.h(context, "context");
        z0.h.q(context, null, 1, null);
        return false;
    }

    public static final void q1(BaseMaskPartyChatFragment this$0, ActivityResult activityResult) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        if (activityResult.getResultCode() == -1) {
            Intent data = activityResult.getData();
            Boolean valueOf = data != null ? Boolean.valueOf(data.getBooleanExtra("CHAT_PREVIEW_SEND_IMAGE_IS_SNAP", false)) : null;
            Intent data2 = activityResult.getData();
            BaseMaskPartyChatViewModel.sendImageMessage$default(this$0.g1(), valueOf, data2 != null ? data2.getStringExtra("CHAT_PREVIEW_SEND_IMAGE_PATH") : null, null, 4, null);
        }
    }

    public void A1() {
    }

    public void B1(@NotNull MaskPartyChatRoomModel model) {
        kotlin.jvm.internal.s.i(model, "model");
    }

    public void C1(@NotNull MaskPartyChatMessageModel message) {
        kotlin.jvm.internal.s.i(message, "message");
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    public void N0() {
        this.f16277k.clear();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    @NotNull
    public SensorPosition O0() {
        return SensorPosition.ChatRoom;
    }

    @Nullable
    public View Y0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f16277k;
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

    public final void c1() {
        ((MaskPartyChatTitleLayout) Y0(R$id.mask_party_chat_title_layout)).setCallback(new b());
        ((MaskPartyChatBottomLayout) Y0(R$id.mask_party_chat_bottom_layout)).setCallback(new c());
    }

    public final void d1(boolean z10) {
        if (z10) {
            if (kotlin.jvm.internal.s.d(p1(), Boolean.TRUE)) {
                MaskPartyMatchActivity.a.b(MaskPartyMatchActivity.f16245r, getContext(), kotlin.collections.r.e(Integer.valueOf(requireArguments().getInt("MASK_PARTY_TYPE"))), false, true, null, 20, null);
            } else {
                Intent intent = new Intent();
                intent.putExtra("MASK_PARTY_REMATCH", true);
                FragmentActivity activity = getActivity();
                if (activity != null) {
                    activity.setResult(-1, intent);
                }
            }
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null) {
            activity2.finish();
        }
    }

    @NotNull
    public final MaskPartyChatAdapter f1() {
        return this.f16272f;
    }

    @NotNull
    public abstract BaseMaskPartyChatViewModel g1();

    public void h1() {
        g1().getChatRoomModelLiveData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.maskparty.fragment.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BaseMaskPartyChatFragment.i1(BaseMaskPartyChatFragment.this, (MaskPartyChatRoomModel) obj);
            }
        });
        this.f16271e = new Observer() { // from class: com.cupidapp.live.maskparty.fragment.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BaseMaskPartyChatFragment.j1(BaseMaskPartyChatFragment.this, (MaskPartyChatMessageModel) obj);
            }
        };
        LiveData<MaskPartyChatMessageModel> newMessageLiveData = g1().getNewMessageLiveData();
        Observer<MaskPartyChatMessageModel> observer = this.f16271e;
        kotlin.jvm.internal.s.f(observer);
        newMessageLiveData.observeForever(observer);
        g1().getReplaceMessage().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.maskparty.fragment.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BaseMaskPartyChatFragment.k1(BaseMaskPartyChatFragment.this, (Pair) obj);
            }
        });
        g1().getCancelMessageEventLiveData().observe(getViewLifecycleOwner(), new EventObserver(new Function1<MaskPartyChatMessageModel, kotlin.p>() { // from class: com.cupidapp.live.maskparty.fragment.BaseMaskPartyChatFragment$initObserve$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(MaskPartyChatMessageModel maskPartyChatMessageModel) {
                invoke2(maskPartyChatMessageModel);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull MaskPartyChatMessageModel message) {
                MaskPartyChatNotifyMessageModel maskPartyChatNotifyMessageModel;
                kotlin.jvm.internal.s.i(message, "message");
                MaskPartyChatAdapter f12 = BaseMaskPartyChatFragment.this.f1();
                String itemId = message.getItemId();
                kotlin.jvm.internal.s.f(itemId);
                Integer A = f12.A(itemId);
                if (A != null) {
                    BaseMaskPartyChatFragment baseMaskPartyChatFragment = BaseMaskPartyChatFragment.this;
                    int intValue = A.intValue();
                    boolean d10 = kotlin.jvm.internal.s.d(message.getType(), MaskPartyChatMessageType.InboxMessageText.getValue());
                    com.cupidapp.live.maskparty.helper.a aVar = com.cupidapp.live.maskparty.helper.a.f16351a;
                    if (d10) {
                        maskPartyChatNotifyMessageModel = new MaskPartyChatNotifyMessageModel(null, baseMaskPartyChatFragment.getString(R$string.you_cancel_the_message) + " " + baseMaskPartyChatFragment.getString(R$string.reedit), Integer.valueOf(NoticeButtonType.Reedit.getType()), baseMaskPartyChatFragment.getString(R$string.reedit), null, null, message.getText(), 49, null);
                    } else {
                        maskPartyChatNotifyMessageModel = null;
                    }
                    baseMaskPartyChatFragment.f1().u(intValue, aVar.f(maskPartyChatNotifyMessageModel, d10 ? null : baseMaskPartyChatFragment.getString(R$string.you_cancel_the_message)));
                }
            }
        }));
        g1().getDeleteMessageEventLiveData().observe(getViewLifecycleOwner(), new EventObserver(new Function1<Pair<? extends String, ? extends Boolean>, kotlin.p>() { // from class: com.cupidapp.live.maskparty.fragment.BaseMaskPartyChatFragment$initObserve$5
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Pair<? extends String, ? extends Boolean> pair) {
                invoke2((Pair<String, Boolean>) pair);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Pair<String, Boolean> it) {
                kotlin.jvm.internal.s.i(it, "it");
                Integer A = BaseMaskPartyChatFragment.this.f1().A(it.getFirst());
                if (A != null) {
                    BaseMaskPartyChatFragment baseMaskPartyChatFragment = BaseMaskPartyChatFragment.this;
                    int intValue = A.intValue();
                    if (it.getSecond().booleanValue()) {
                        baseMaskPartyChatFragment.f1().u(intValue, com.cupidapp.live.maskparty.helper.a.f16351a.f(null, baseMaskPartyChatFragment.getString(R$string.other_cancel_the_message)));
                    }
                }
            }
        }));
        g1().getTypingEventLiveData().observe(getViewLifecycleOwner(), new EventObserver(new Function1<String, kotlin.p>() { // from class: com.cupidapp.live.maskparty.fragment.BaseMaskPartyChatFragment$initObserve$6
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(String str) {
                invoke2(str);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String it) {
                kotlin.jvm.internal.s.i(it, "it");
                ((MaskPartyChatTitleLayout) BaseMaskPartyChatFragment.this.Y0(R$id.mask_party_chat_title_layout)).g(it);
            }
        }));
        g1().getPlayDiceEventLiveData().observe(getViewLifecycleOwner(), new EventObserver(new Function1<MaskPartyChatDiceModel, kotlin.p>() { // from class: com.cupidapp.live.maskparty.fragment.BaseMaskPartyChatFragment$initObserve$7
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(MaskPartyChatDiceModel maskPartyChatDiceModel) {
                invoke2(maskPartyChatDiceModel);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull MaskPartyChatDiceModel it) {
                kotlin.jvm.internal.s.i(it, "it");
                BaseMaskPartyChatFragment.this.y1(it);
            }
        }));
        g1().getShowSendImageGuideEventLiveData().observe(getViewLifecycleOwner(), new EventObserver(new Function1<Boolean, kotlin.p>() { // from class: com.cupidapp.live.maskparty.fragment.BaseMaskPartyChatFragment$initObserve$8
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return kotlin.p.f51048a;
            }

            public final void invoke(boolean z10) {
                ((MaskPartyChatBottomLayout) BaseMaskPartyChatFragment.this.Y0(R$id.mask_party_chat_bottom_layout)).q();
            }
        }));
        g1().getHangUpPromptEventLiveData().observe(getViewLifecycleOwner(), new EventObserver(new Function1<MaskPartyHangUpMessageModel, kotlin.p>() { // from class: com.cupidapp.live.maskparty.fragment.BaseMaskPartyChatFragment$initObserve$9
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(MaskPartyHangUpMessageModel maskPartyHangUpMessageModel) {
                invoke2(maskPartyHangUpMessageModel);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull MaskPartyHangUpMessageModel it) {
                kotlin.jvm.internal.s.i(it, "it");
                BaseMaskPartyChatFragment.this.x1(it);
            }
        }));
        g1().getQuitRoomLiveData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.maskparty.fragment.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BaseMaskPartyChatFragment.l1(BaseMaskPartyChatFragment.this, (Boolean) obj);
            }
        });
    }

    public final void m1() {
        FragmentActivity activity;
        if (this.f16275i == null && (activity = getActivity()) != null) {
            com.cupidapp.live.base.view.o oVar = new com.cupidapp.live.base.view.o(activity);
            this.f16275i = oVar;
            oVar.b(new Function2<Integer, Boolean, kotlin.p>() { // from class: com.cupidapp.live.maskparty.fragment.BaseMaskPartyChatFragment$initSoftKeyboardWatcher$1$1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                /* renamed from: invoke */
                public /* bridge */ /* synthetic */ kotlin.p mo1743invoke(Integer num, Boolean bool) {
                    invoke(num.intValue(), bool.booleanValue());
                    return kotlin.p.f51048a;
                }

                public final void invoke(int i10, boolean z10) {
                    if (z10 && (!BaseMaskPartyChatFragment.this.f1().j().isEmpty())) {
                        ((RecyclerView) BaseMaskPartyChatFragment.this.Y0(R$id.mask_party_chat_recycler_view)).scrollToPosition(kotlin.collections.s.l(BaseMaskPartyChatFragment.this.f1().j()));
                    }
                }
            });
        }
    }

    public final void n1() {
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("MASK_PARTY_ROOM_ID") : null;
        if (string == null || string.length() == 0) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        g1().getChatRoomData(string);
        final RecyclerView recyclerView = (RecyclerView) Y0(R$id.mask_party_chat_recycler_view);
        recyclerView.setItemAnimator(null);
        recyclerView.setAdapter(this.f16272f);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setOnTouchListener(new View.OnTouchListener() { // from class: com.cupidapp.live.maskparty.fragment.a
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean o12;
                o12 = BaseMaskPartyChatFragment.o1(RecyclerView.this, view, motionEvent);
                return o12;
            }
        });
        m1();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    public boolean onBackPressed() {
        try {
            if (g1().isMaskState()) {
                A1();
            } else {
                g1().quitChatRoom();
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.f16274h = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.cupidapp.live.maskparty.fragment.b
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                BaseMaskPartyChatFragment.q1(BaseMaskPartyChatFragment.this, (ActivityResult) obj);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        kotlin.jvm.internal.s.i(inflater, "inflater");
        return inflater.inflate(R$layout.fragment_mask_party_chat, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        f16270m = null;
        com.cupidapp.live.base.view.o oVar = this.f16275i;
        if (oVar != null) {
            oVar.d();
        }
        this.f16275i = null;
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Observer<MaskPartyChatMessageModel> observer = this.f16271e;
        if (observer != null) {
            g1().getNewMessageLiveData().removeObserver(observer);
        }
        super.onDestroyView();
        ((FKSVGAImageView) Y0(R$id.mask_party_animation_view)).K();
        List<Object> j10 = this.f16272f.j();
        ArrayList arrayList = new ArrayList();
        for (Object obj : j10) {
            if (obj instanceof MaskPartyChatMessageModel) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (((MaskPartyChatMessageModel) obj2).snapImageModel()) {
                arrayList2.add(obj2);
            }
        }
        Iterator<E> iterator2 = arrayList2.iterator2();
        while (iterator2.hasNext()) {
            ((MaskPartyChatMessageModel) iterator2.next()).stopSnapCountDown();
        }
        N0();
    }

    @he.j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull DiceAnimationFinishEvent event) {
        kotlin.jvm.internal.s.i(event, "event");
        EventBus.c().r(event);
        MaskPartyChatDiceModel dice = event.getDice();
        String roomId = dice.getRoomId();
        MaskPartyChatRoomModel maskPartyChatRoomModel = f16270m;
        if (kotlin.jvm.internal.s.d(roomId, maskPartyChatRoomModel != null ? maskPartyChatRoomModel.getRoomId() : null)) {
            t1(dice.isWin(), dice.getDiceAnimationCompleteMessage());
        }
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        com.cupidapp.live.base.utils.o oVar = this.f16276j;
        if (oVar != null) {
            oVar.n();
        }
        com.cupidapp.live.push.d.f17892a.j(false);
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        com.cupidapp.live.base.utils.o oVar = this.f16276j;
        if (oVar != null) {
            oVar.m();
        }
        com.cupidapp.live.push.d.f17892a.j(true);
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        kotlin.jvm.internal.s.i(view, "view");
        super.onViewCreated(view, bundle);
        p0.b(getActivity(), true, com.cupidapp.live.base.utils.h.a(-16777216, 0.4f));
        n1();
        h1();
        c1();
        v1();
    }

    public final Boolean p1() {
        return (Boolean) this.f16273g.getValue();
    }

    public final void r1(@NotNull final String userId) {
        kotlin.jvm.internal.s.i(userId, "userId");
        final Context context = getContext();
        if (context != null) {
            z0.h.q(context, null, 1, null);
            FKRxPermissionAlertDialog.f12016a.m(context, new xb.b(this), (r16 & 4) != 0 ? null : new Function0<kotlin.p>() { // from class: com.cupidapp.live.maskparty.fragment.BaseMaskPartyChatFragment$openAlbum$1$1
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
                    ActivityResultLauncher activityResultLauncher;
                    activityResultLauncher = BaseMaskPartyChatFragment.this.f16274h;
                    if (activityResultLauncher != null) {
                        BaseMaskPartyChatFragment baseMaskPartyChatFragment = BaseMaskPartyChatFragment.this;
                        Context context2 = context;
                        String str = userId;
                        MediaPickerFragment.Config config = new MediaPickerFragment.Config(MediaType.IMAGE, true, false, false, false, CameraStartPosition.Chat, baseMaskPartyChatFragment.O0(), null, 152, null);
                        ChatPhoneAlbumActivity.a aVar = ChatPhoneAlbumActivity.f16226v;
                        kotlin.jvm.internal.s.h(context2, "context");
                        aVar.a(context2, activityResultLauncher, config, str, (r12 & 16) != 0);
                    }
                }
            }, (r16 & 8) != 0 ? null : null, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? R$string.need_access_media_upload_better : 0);
        }
    }

    public void s1() {
    }

    public void t1(boolean z10, @NotNull String systemMessage) {
        kotlin.jvm.internal.s.i(systemMessage, "systemMessage");
    }

    public void u1() {
    }

    public final void v1() {
        Context context = getContext();
        if (context != null) {
            com.cupidapp.live.base.utils.o c4 = com.cupidapp.live.base.utils.o.f12354i.c(context);
            this.f16276j = c4;
            if (c4 != null) {
                c4.l(new d());
            }
        }
    }

    public final void w1(@NotNull final MaskPartyChatDiceModel dice, @NotNull String animation) {
        kotlin.jvm.internal.s.i(dice, "dice");
        kotlin.jvm.internal.s.i(animation, "animation");
        int i10 = R$id.mask_party_animation_view;
        ((FKSVGAImageView) Y0(i10)).setVisibility(0);
        FKSVGAImageView mask_party_animation_view = (FKSVGAImageView) Y0(i10);
        kotlin.jvm.internal.s.h(mask_party_animation_view, "mask_party_animation_view");
        FKSVGAImageView.F(mask_party_animation_view, animation, null, new Function0<kotlin.p>() { // from class: com.cupidapp.live.maskparty.fragment.BaseMaskPartyChatFragment$showAnimation$1
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
                ((FKSVGAImageView) BaseMaskPartyChatFragment.this.Y0(R$id.mask_party_animation_view)).setVisibility(8);
                BaseMaskPartyChatFragment.this.g1().insertNoticeMessage(null, dice.getShotCompleteMessage());
                BaseMaskPartyChatFragment.this.g1().insertDiceMessage(dice);
            }
        }, 2, null);
    }

    public final void x1(MaskPartyHangUpMessageModel maskPartyHangUpMessageModel) {
        int popupType = maskPartyHangUpMessageModel.getPopupType();
        if (popupType == HangUpPopupType.HangUpConfirm.getType()) {
            MaskPartyChatPromptLayout.f16388f.a(getContext(), maskPartyHangUpMessageModel.getCountDownSeconds(), new com.cupidapp.live.maskparty.view.f() { // from class: com.cupidapp.live.maskparty.fragment.BaseMaskPartyChatFragment$showHangUpPrompt$1
                @Override // com.cupidapp.live.maskparty.view.f
                public void a() {
                    BaseMaskPartyChatFragment.this.g1().confirmInRoom();
                    j1.i.f50236a.a(PopupName.MASK_PARTY_HANG_UP, PopupButtonName.Confirm, SensorPosition.ChatRoom);
                }

                @Override // com.cupidapp.live.maskparty.view.f
                public void b() {
                    MaskPartyPromptHelper maskPartyPromptHelper = MaskPartyPromptHelper.f16347a;
                    Context context = BaseMaskPartyChatFragment.this.getContext();
                    final BaseMaskPartyChatFragment baseMaskPartyChatFragment = BaseMaskPartyChatFragment.this;
                    maskPartyPromptHelper.b(context, new Function0<kotlin.p>() { // from class: com.cupidapp.live.maskparty.fragment.BaseMaskPartyChatFragment$showHangUpPrompt$1$countDownFinished$1
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
                            BaseMaskPartyChatFragment.e1(BaseMaskPartyChatFragment.this, false, 1, null);
                        }
                    });
                }
            });
        } else if (popupType == HangUpPopupType.OtherKickRoom.getType()) {
            s1();
            MaskPartyPromptHelper.f16347a.e(getContext(), new Function0<kotlin.p>() { // from class: com.cupidapp.live.maskparty.fragment.BaseMaskPartyChatFragment$showHangUpPrompt$2
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
                    BaseMaskPartyChatFragment.this.d1(true);
                }
            }, new Function0<kotlin.p>() { // from class: com.cupidapp.live.maskparty.fragment.BaseMaskPartyChatFragment$showHangUpPrompt$3
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
                    BaseMaskPartyChatFragment.e1(BaseMaskPartyChatFragment.this, false, 1, null);
                }
            });
        }
    }

    public void y1(@NotNull MaskPartyChatDiceModel dice) {
        kotlin.jvm.internal.s.i(dice, "dice");
    }

    public final void z1(@NotNull User user) {
        kotlin.jvm.internal.s.i(user, "user");
        UserProfileActivity.G.a(getContext(), user, new ProfileSensorContext(ViewProfilePrefer.MaskMatch.getValue(), null, false, SensorPosition.ChatRoom, null, null), (r21 & 8) != 0 ? false : true, (r21 & 16) != 0 ? null : null, (r21 & 32) != 0 ? null : null, (r21 & 64) != 0 ? null : null, (r21 & 128) != 0 ? false : false);
    }

    @he.j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull final MaskPartyChatMessageBindLongClickEvent event) {
        kotlin.jvm.internal.s.i(event, "event");
        MaskPartyMessageActionLayout.f16426e.a(getContext(), event.getActions(), event.getPopupLocation(), new Function1<MaskPartyLongClickActionType, kotlin.p>() { // from class: com.cupidapp.live.maskparty.fragment.BaseMaskPartyChatFragment$onEvent$1

            /* compiled from: BaseMaskPartyChatFragment.kt */
            @kotlin.d
            /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
            public /* synthetic */ class a {

                /* renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f16280a;

                static {
                    int[] iArr = new int[MaskPartyLongClickActionType.values().length];
                    try {
                        iArr[MaskPartyLongClickActionType.Copy.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[MaskPartyLongClickActionType.Cancel.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[MaskPartyLongClickActionType.Destroy.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[MaskPartyLongClickActionType.Delete.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    try {
                        iArr[MaskPartyLongClickActionType.Report.ordinal()] = 5;
                    } catch (NoSuchFieldError unused5) {
                    }
                    f16280a = iArr;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(MaskPartyLongClickActionType maskPartyLongClickActionType) {
                invoke2(maskPartyLongClickActionType);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull MaskPartyLongClickActionType it) {
                kotlin.jvm.internal.s.i(it, "it");
                int i10 = a.f16280a[it.ordinal()];
                if (i10 == 1) {
                    String text = MaskPartyChatMessageBindLongClickEvent.this.getModel().getText();
                    if (text != null) {
                        q1.c.f53005a.b(this.getContext(), text);
                        return;
                    }
                    return;
                }
                if (i10 == 2 || i10 == 3) {
                    this.g1().cancelMessage(MaskPartyChatMessageBindLongClickEvent.this.getModel());
                    return;
                }
                if (i10 == 4) {
                    this.g1().deleteMessage(MaskPartyChatMessageBindLongClickEvent.this.getModel());
                    return;
                }
                if (i10 != 5) {
                    return;
                }
                n0 n0Var = n0.f12353a;
                String reportData = MaskPartyChatMessageBindLongClickEvent.this.getModel().getReportData();
                SensorPosition O0 = this.O0();
                User sender = MaskPartyChatMessageBindLongClickEvent.this.getModel().getSender();
                j.a.b(com.cupidapp.live.base.router.j.f12156c, this.getContext(), n0Var.b(reportData, O0, sender != null ? sender.userId() : null), null, 4, null);
            }
        });
    }

    @he.j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull MaskPartyChatMessageSendFailResendEvent event) {
        kotlin.jvm.internal.s.i(event, "event");
        g1().resendMessage(event.getFailModel());
    }

    @he.j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull MaskPartyChatMessageModel event) {
        Integer buttonType;
        kotlin.jvm.internal.s.i(event, "event");
        MaskPartyChatNotifyMessageModel notice = event.getNotice();
        if (notice == null || (buttonType = notice.getButtonType()) == null) {
            return;
        }
        buttonType.intValue();
        Integer buttonType2 = notice.getButtonType();
        int type = NoticeButtonType.Reedit.getType();
        if (buttonType2 != null && buttonType2.intValue() == type) {
            String cancelMessage = notice.getCancelMessage();
            if (cancelMessage != null) {
                ((MaskPartyChatBottomLayout) Y0(R$id.mask_party_chat_bottom_layout)).o(cancelMessage);
            }
            SensorsLogKeyButtonClick.ChatRoom.Reedit.click();
            return;
        }
        C1(event);
    }

    @he.j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull UserProfileDataChangeEvent event) {
        kotlin.jvm.internal.s.i(event, "event");
        EventBus.c().r(event);
        MaskPartyChatMessageModel D = this.f16272f.D(NoticeButtonType.Aloha);
        if (D != null) {
            g1().updateAlohaStatus(event.getUser(), D);
        }
    }

    @he.j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull SnapMessageDestroyEvent event) {
        kotlin.jvm.internal.s.i(event, "event");
        EventBus.c().r(event);
        this.f16272f.F();
        MaskPartyLookSnapImageActivity.f16234x.a(null);
    }
}
