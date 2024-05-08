package com.cupidapp.live.maskparty.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import com.cupidapp.live.base.grpc.CuConnectorOuterClass;
import com.cupidapp.live.base.grpc.GrpcMessageRouter;
import com.cupidapp.live.base.grpc.IGrpcMessageListener;
import com.cupidapp.live.base.livedata.Event;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.network.model.StateResult;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.maskparty.model.ItemCardFeaturesItemModel;
import com.cupidapp.live.maskparty.model.MaskPartyConfigModel;
import com.cupidapp.live.maskparty.model.MaskPartyItemCardConfigModel;
import com.cupidapp.live.maskparty.model.MaskPartyMatchBtnType;
import com.cupidapp.live.maskparty.model.MaskPartyMatchConfigResult;
import com.cupidapp.live.maskparty.model.MaskPartyMatchStatusModel;
import com.cupidapp.live.maskparty.model.MaskPartyMatchSuccessModel;
import com.cupidapp.live.maskparty.model.MaskPartyModel;
import com.cupidapp.live.maskparty.model.MaskPartyStartMatchResult;
import com.cupidapp.live.maskparty.model.MaskPartyType;
import com.cupidapp.live.maskparty.viewmodel.MaskPartyMatchViewModel;
import com.cupidapp.live.track.group.GroupOthersLog;
import com.cupidapp.live.track.group.GroupSocialLog;
import com.irisdt.client.post.PostAndSocialProtos;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.r;
import kotlin.collections.t;
import kotlin.collections.x;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p1.g;

/* compiled from: MaskPartyMatchViewModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MaskPartyMatchViewModel extends ViewModel implements IGrpcMessageListener {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @Nullable
    private static List<Integer> partyType;

    @NotNull
    private final MutableLiveData<Event<StateResult<MaskPartyMatchBtnType>>> _btnClickState;

    @NotNull
    private final MutableLiveData<Event<Boolean>> _itemCardEntranceClickEventLiveData;

    @NotNull
    private final MutableLiveData<Pair<String, Boolean>> _itemCardEntranceLiveData;

    @NotNull
    private final MutableLiveData<Pair<MaskPartyMatchConfigResult, List<Integer>>> _maskPartyMatchLiveData;

    @NotNull
    private final MutableLiveData<ImageModel> _matchAvatarLiveData;

    @NotNull
    private final MutableLiveData<MaskPartyMatchStatusModel> _matchStatus;

    @NotNull
    private final MutableLiveData<Event<MaskPartyMatchSuccessModel>> _matchSuccessEventLiveData;

    @NotNull
    private final MutableLiveData<Event<Boolean>> _quitMatchEventLiveData;

    @NotNull
    private final MutableLiveData<Event<MaskPartyItemCardConfigModel>> _showItemCardDialogEventLiveData;

    @NotNull
    private final MutableLiveData<Event<Integer>> _showNoTimesEventLiveData;

    @NotNull
    private final MutableLiveData<Event<Boolean>> _stopMatchEventLiveData;

    @NotNull
    private final LiveData<Event<StateResult<MaskPartyMatchBtnType>>> btnClickState;

    @NotNull
    private final LiveData<Event<Boolean>> itemCardEntranceClickEventLiveData;

    @NotNull
    private final LiveData<Pair<String, Boolean>> itemCardEntranceLiveData;

    @NotNull
    private final LiveData<Pair<MaskPartyMatchConfigResult, List<Integer>>> maskPartyMatchLiveData;

    @NotNull
    private final LiveData<ImageModel> matchAvatarLiveData;

    @NotNull
    private final LiveData<MaskPartyMatchStatusModel> matchStatus;

    @NotNull
    private final LiveData<Event<MaskPartyMatchSuccessModel>> matchSuccessEventLiveData;
    private boolean matching;

    @NotNull
    private final LiveData<Event<Boolean>> quitMatchEventLiveData;
    private boolean rematch;

    @Nullable
    private List<MaskPartyModel> selectedMaskParty;

    @NotNull
    private final LiveData<Event<MaskPartyItemCardConfigModel>> showItemCardDialogEventLiveData;

    @NotNull
    private final LiveData<Event<Integer>> showNoTimesEventLiveData;
    private long startMatchTime;

    @NotNull
    private final LiveData<Event<Boolean>> stopMatchEventLiveData;

    /* compiled from: MaskPartyMatchViewModel.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final List<Integer> a() {
            return MaskPartyMatchViewModel.partyType;
        }

        public final void b(@Nullable List<Integer> list) {
            MaskPartyMatchViewModel.partyType = list;
        }
    }

    /* compiled from: MaskPartyMatchViewModel.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f16479a;

        static {
            int[] iArr = new int[CuConnectorOuterClass.MessageType.values().length];
            try {
                iArr[CuConnectorOuterClass.MessageType.MaskMatchSuccess.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f16479a = iArr;
        }
    }

    /* compiled from: Comparisons.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t2, T t10) {
            return qd.a.a(Integer.valueOf(((MaskPartyModel) t2).getType()), Integer.valueOf(((MaskPartyModel) t10).getType()));
        }
    }

    public MaskPartyMatchViewModel() {
        GrpcMessageRouter.INSTANCE.addIGrpcMessageListener(this);
        MutableLiveData<Pair<MaskPartyMatchConfigResult, List<Integer>>> mutableLiveData = new MutableLiveData<>();
        this._maskPartyMatchLiveData = mutableLiveData;
        this.maskPartyMatchLiveData = mutableLiveData;
        MutableLiveData<Event<Integer>> mutableLiveData2 = new MutableLiveData<>();
        this._showNoTimesEventLiveData = mutableLiveData2;
        this.showNoTimesEventLiveData = mutableLiveData2;
        MutableLiveData<MaskPartyMatchStatusModel> mutableLiveData3 = new MutableLiveData<>();
        this._matchStatus = mutableLiveData3;
        this.matchStatus = Transformations.distinctUntilChanged(mutableLiveData3);
        MutableLiveData<ImageModel> mutableLiveData4 = new MutableLiveData<>();
        this._matchAvatarLiveData = mutableLiveData4;
        this.matchAvatarLiveData = Transformations.distinctUntilChanged(mutableLiveData4);
        MutableLiveData<Event<Boolean>> mutableLiveData5 = new MutableLiveData<>();
        this._quitMatchEventLiveData = mutableLiveData5;
        this.quitMatchEventLiveData = mutableLiveData5;
        MutableLiveData<Event<MaskPartyMatchSuccessModel>> mutableLiveData6 = new MutableLiveData<>();
        this._matchSuccessEventLiveData = mutableLiveData6;
        this.matchSuccessEventLiveData = mutableLiveData6;
        MutableLiveData<Event<Boolean>> mutableLiveData7 = new MutableLiveData<>();
        this._stopMatchEventLiveData = mutableLiveData7;
        this.stopMatchEventLiveData = mutableLiveData7;
        MutableLiveData<Pair<String, Boolean>> mutableLiveData8 = new MutableLiveData<>();
        this._itemCardEntranceLiveData = mutableLiveData8;
        this.itemCardEntranceLiveData = mutableLiveData8;
        MutableLiveData<Event<MaskPartyItemCardConfigModel>> mutableLiveData9 = new MutableLiveData<>();
        this._showItemCardDialogEventLiveData = mutableLiveData9;
        this.showItemCardDialogEventLiveData = mutableLiveData9;
        MutableLiveData<Event<Boolean>> mutableLiveData10 = new MutableLiveData<>();
        this._itemCardEntranceClickEventLiveData = mutableLiveData10;
        this.itemCardEntranceClickEventLiveData = mutableLiveData10;
        MutableLiveData<Event<StateResult<MaskPartyMatchBtnType>>> mutableLiveData11 = new MutableLiveData<>();
        this._btnClickState = mutableLiveData11;
        this.btnClickState = mutableLiveData11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<MaskPartyModel> getSelectParty(List<Integer> list, MaskPartyMatchConfigResult maskPartyMatchConfigResult) {
        ArrayList arrayList = new ArrayList();
        List<MaskPartyConfigModel> gameEntrance = maskPartyMatchConfigResult.getGameEntrance();
        ArrayList<MaskPartyModel> arrayList2 = new ArrayList();
        Iterator<MaskPartyConfigModel> iterator2 = gameEntrance.iterator2();
        while (iterator2.hasNext()) {
            x.x(arrayList2, iterator2.next().getPlayTypeInfo());
        }
        for (MaskPartyModel maskPartyModel : arrayList2) {
            if (list.contains(Integer.valueOf(maskPartyModel.getType()))) {
                arrayList.add(maskPartyModel);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<MaskPartyModel> getSelectedMaskParty() {
        List<MaskPartyModel> list = this.selectedMaskParty;
        if (list != null) {
            return CollectionsKt___CollectionsKt.s0(list, new b());
        }
        return null;
    }

    public static /* synthetic */ void showItemCardDialog$default(MaskPartyMatchViewModel maskPartyMatchViewModel, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 0;
        }
        maskPartyMatchViewModel.showItemCardDialog(i10);
    }

    private final void startPartyMatch() {
        List<MaskPartyModel> selectedMaskParty = getSelectedMaskParty();
        if (selectedMaskParty != null) {
            boolean z10 = true;
            this.matching = true;
            final MaskPartyMatchBtnType maskPartyMatchBtnType = MaskPartyMatchBtnType.START_MATCH_BTN;
            this._btnClickState.setValue(new Event<>(new StateResult.b(maskPartyMatchBtnType, null, 2, null)));
            this.startMatchTime = System.currentTimeMillis();
            if (isVoiceChatType()) {
                GroupSocialLog.f18708a.a0(PostAndSocialProtos.Type.START, (r13 & 2) != 0 ? null : null, (r13 & 4) != 0 ? null : null, (r13 & 8) != 0 ? null : null, (r13 & 16) != 0 ? null : null);
            } else {
                GroupSocialLog groupSocialLog = GroupSocialLog.f18708a;
                PostAndSocialProtos.Type type = PostAndSocialProtos.Type.START;
                ArrayList arrayList = new ArrayList(t.t(selectedMaskParty, 10));
                Iterator<MaskPartyModel> iterator2 = selectedMaskParty.iterator2();
                while (iterator2.hasNext()) {
                    arrayList.add(MaskPartyType.Companion.a(Integer.valueOf(iterator2.next().getType())));
                }
                groupSocialLog.R(type, (r15 & 2) != 0 ? null : null, (r15 & 4) != 0 ? null : null, (r15 & 8) != 0 ? null : null, (r15 & 16) != 0 ? null : null, (r15 & 32) != 0 ? false : false, (r15 & 64) == 0 ? arrayList : null);
            }
            ItemCardFeaturesItemModel N = g.f52734a.N();
            z2.a z11 = NetworkClient.f11868a.z();
            ArrayList arrayList2 = new ArrayList(t.t(selectedMaskParty, 10));
            Iterator<MaskPartyModel> iterator22 = selectedMaskParty.iterator2();
            while (iterator22.hasNext()) {
                arrayList2.add(Integer.valueOf(iterator22.next().getType()));
            }
            boolean z12 = this.rematch;
            List<Integer> e2 = N == null ? null : r.e(Integer.valueOf(N.getType().getType()));
            List<Integer> values = N != null ? N.getValues() : null;
            if (values != null && !values.isEmpty()) {
                z10 = false;
            }
            Disposable disposed = z11.i(arrayList2, z12, e2, (z10 || N == null) ? null : N.getValues()).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<MaskPartyStartMatchResult, p>() { // from class: com.cupidapp.live.maskparty.viewmodel.MaskPartyMatchViewModel$startPartyMatch$lambda$10$$inlined$handle$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(MaskPartyStartMatchResult maskPartyStartMatchResult) {
                    m2694invoke(maskPartyStartMatchResult);
                    return p.f51048a;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* renamed from: invoke, reason: collision with other method in class */
                public final void m2694invoke(MaskPartyStartMatchResult maskPartyStartMatchResult) {
                    MutableLiveData mutableLiveData;
                    MutableLiveData mutableLiveData2;
                    boolean z13;
                    MutableLiveData mutableLiveData3;
                    MutableLiveData mutableLiveData4;
                    MaskPartyMatchConfigResult maskPartyMatchConfigResult;
                    MaskPartyStartMatchResult maskPartyStartMatchResult2 = maskPartyStartMatchResult;
                    MaskPartyMatchViewModel.this.matching = maskPartyStartMatchResult2.getConfineMatchSeconds() == null;
                    mutableLiveData = MaskPartyMatchViewModel.this._btnClickState;
                    String str = null;
                    mutableLiveData.setValue(new Event(new StateResult.c(maskPartyMatchBtnType, null, 2, null)));
                    mutableLiveData2 = MaskPartyMatchViewModel.this._matchStatus;
                    z13 = MaskPartyMatchViewModel.this.matching;
                    mutableLiveData2.setValue(new MaskPartyMatchStatusModel(z13, false, maskPartyStartMatchResult2.getConfineMatchSeconds(), MaskPartyMatchViewModel.this.isVoiceChatType()));
                    mutableLiveData3 = MaskPartyMatchViewModel.this._itemCardEntranceLiveData;
                    mutableLiveData4 = MaskPartyMatchViewModel.this._maskPartyMatchLiveData;
                    Pair pair = (Pair) mutableLiveData4.getValue();
                    if (pair != null && (maskPartyMatchConfigResult = (MaskPartyMatchConfigResult) pair.getFirst()) != null) {
                        str = maskPartyMatchConfigResult.getEnterTitle();
                    }
                    mutableLiveData3.setValue(new Pair(str, Boolean.TRUE));
                }
            }), new e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.maskparty.viewmodel.MaskPartyMatchViewModel$startPartyMatch$1$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull Throwable it) {
                    MutableLiveData mutableLiveData;
                    s.i(it, "it");
                    MaskPartyMatchViewModel.this.matching = false;
                    mutableLiveData = MaskPartyMatchViewModel.this._btnClickState;
                    mutableLiveData.setValue(new Event(new StateResult.a(null, maskPartyMatchBtnType, null, 5, null)));
                    return Boolean.FALSE;
                }
            }, null)));
            if (disposed != null) {
                s.h(disposed, "disposed");
            }
            s.h(disposed, "disposed");
        }
    }

    public final void changeAvatar(@NotNull String id2) {
        s.i(id2, "id");
        Disposable disposed = NetworkClient.f11868a.z().d(id2).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<Object, p>() { // from class: com.cupidapp.live.maskparty.viewmodel.MaskPartyMatchViewModel$changeAvatar$$inlined$handle$default$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Object obj) {
                invoke2(obj);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    @NotNull
    public final LiveData<Event<StateResult<MaskPartyMatchBtnType>>> getBtnClickState() {
        return this.btnClickState;
    }

    @NotNull
    public final LiveData<Event<Boolean>> getItemCardEntranceClickEventLiveData() {
        return this.itemCardEntranceClickEventLiveData;
    }

    @NotNull
    public final LiveData<Pair<String, Boolean>> getItemCardEntranceLiveData() {
        return this.itemCardEntranceLiveData;
    }

    public final void getMaskPartyMatchInfo(boolean z10) {
        this.rematch = z10;
        if (this.matching) {
            return;
        }
        Disposable disposed = NetworkClient.f11868a.z().h().flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<MaskPartyMatchConfigResult, p>() { // from class: com.cupidapp.live.maskparty.viewmodel.MaskPartyMatchViewModel$getMaskPartyMatchInfo$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(MaskPartyMatchConfigResult maskPartyMatchConfigResult) {
                m2693invoke(maskPartyMatchConfigResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2693invoke(MaskPartyMatchConfigResult maskPartyMatchConfigResult) {
                List selectedMaskParty;
                List<MaskPartyModel> selectedMaskParty2;
                MutableLiveData mutableLiveData;
                MutableLiveData mutableLiveData2;
                List selectedMaskParty3;
                MutableLiveData mutableLiveData3;
                MutableLiveData mutableLiveData4;
                MaskPartyMatchConfigResult maskPartyMatchConfigResult2 = maskPartyMatchConfigResult;
                ArrayList arrayList = null;
                if (maskPartyMatchConfigResult2.getItemCardRemains() == 0) {
                    g.f52734a.P1(null);
                }
                MaskPartyMatchViewModel maskPartyMatchViewModel = MaskPartyMatchViewModel.this;
                selectedMaskParty = maskPartyMatchViewModel.getSelectedMaskParty();
                if (selectedMaskParty == null || selectedMaskParty.isEmpty()) {
                    List list = MaskPartyMatchViewModel.partyType;
                    if (!(list == null || list.isEmpty())) {
                        MaskPartyMatchViewModel maskPartyMatchViewModel2 = MaskPartyMatchViewModel.this;
                        List list2 = MaskPartyMatchViewModel.partyType;
                        s.f(list2);
                        selectedMaskParty2 = maskPartyMatchViewModel2.getSelectParty(list2, maskPartyMatchConfigResult2);
                    } else {
                        List<Integer> selectedTypeList = maskPartyMatchConfigResult2.getSelectedTypeList();
                        if (!(selectedTypeList == null || selectedTypeList.isEmpty())) {
                            selectedMaskParty2 = MaskPartyMatchViewModel.this.getSelectParty(maskPartyMatchConfigResult2.getSelectedTypeList(), maskPartyMatchConfigResult2);
                        } else {
                            MaskPartyConfigModel maskPartyConfigModel = (MaskPartyConfigModel) CollectionsKt___CollectionsKt.V(maskPartyMatchConfigResult2.getGameEntrance());
                            selectedMaskParty2 = maskPartyConfigModel != null ? maskPartyConfigModel.getPlayTypeInfo() : null;
                        }
                    }
                } else {
                    selectedMaskParty2 = MaskPartyMatchViewModel.this.getSelectedMaskParty();
                }
                maskPartyMatchViewModel.selectedMaskParty = selectedMaskParty2;
                MaskPartyMatchViewModel.Companion companion = MaskPartyMatchViewModel.Companion;
                MaskPartyMatchViewModel.partyType = null;
                mutableLiveData = MaskPartyMatchViewModel.this._matchAvatarLiveData;
                if (mutableLiveData.getValue() == 0) {
                    mutableLiveData4 = MaskPartyMatchViewModel.this._matchAvatarLiveData;
                    mutableLiveData4.setValue(CollectionsKt___CollectionsKt.V(maskPartyMatchConfigResult2.getAvatarList()));
                }
                mutableLiveData2 = MaskPartyMatchViewModel.this._maskPartyMatchLiveData;
                selectedMaskParty3 = MaskPartyMatchViewModel.this.getSelectedMaskParty();
                if (selectedMaskParty3 != null) {
                    arrayList = new ArrayList(t.t(selectedMaskParty3, 10));
                    Iterator<E> iterator2 = selectedMaskParty3.iterator2();
                    while (iterator2.hasNext()) {
                        arrayList.add(Integer.valueOf(((MaskPartyModel) iterator2.next()).getType()));
                    }
                }
                mutableLiveData2.setValue(new Pair(maskPartyMatchConfigResult2, arrayList));
                mutableLiveData3 = MaskPartyMatchViewModel.this._itemCardEntranceLiveData;
                mutableLiveData3.setValue(new Pair(maskPartyMatchConfigResult2.getEnterTitle(), Boolean.FALSE));
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    @NotNull
    public final LiveData<Pair<MaskPartyMatchConfigResult, List<Integer>>> getMaskPartyMatchLiveData() {
        return this.maskPartyMatchLiveData;
    }

    @NotNull
    public final LiveData<ImageModel> getMatchAvatarLiveData() {
        return this.matchAvatarLiveData;
    }

    @NotNull
    public final LiveData<MaskPartyMatchStatusModel> getMatchStatus() {
        return this.matchStatus;
    }

    @NotNull
    public final LiveData<Event<MaskPartyMatchSuccessModel>> getMatchSuccessEventLiveData() {
        return this.matchSuccessEventLiveData;
    }

    @NotNull
    public final LiveData<Event<Boolean>> getQuitMatchEventLiveData() {
        return this.quitMatchEventLiveData;
    }

    @NotNull
    public final LiveData<Event<MaskPartyItemCardConfigModel>> getShowItemCardDialogEventLiveData() {
        return this.showItemCardDialogEventLiveData;
    }

    @NotNull
    public final LiveData<Event<Integer>> getShowNoTimesEventLiveData() {
        return this.showNoTimesEventLiveData;
    }

    @NotNull
    public final LiveData<Event<Boolean>> getStopMatchEventLiveData() {
        return this.stopMatchEventLiveData;
    }

    public final boolean isVoiceChatType() {
        List<MaskPartyModel> selectedMaskParty = getSelectedMaskParty();
        if (selectedMaskParty != null) {
            ArrayList arrayList = new ArrayList(t.t(selectedMaskParty, 10));
            Iterator<MaskPartyModel> iterator2 = selectedMaskParty.iterator2();
            while (iterator2.hasNext()) {
                arrayList.add(Integer.valueOf(iterator2.next().getType()));
            }
            if (arrayList.contains(Integer.valueOf(MaskPartyType.VoiceChat.getType()))) {
                return true;
            }
        }
        return false;
    }

    public final void itemCardEntranceClick(@NotNull SensorPosition position) {
        GroupOthersLog.ItemCardEntrance itemCardEntrance;
        s.i(position, "position");
        MaskPartyMatchStatusModel value = this._matchStatus.getValue();
        boolean z10 = value != null && value.getMatching();
        if (z10) {
            itemCardEntrance = GroupOthersLog.ItemCardEntrance.MATCH_PROP_CARD;
        } else {
            itemCardEntrance = GroupOthersLog.ItemCardEntrance.PROP_CARD;
        }
        GroupOthersLog.f18702a.v(position, itemCardEntrance);
        if (z10) {
            if (this.rematch) {
                this._stopMatchEventLiveData.setValue(new Event<>(Boolean.TRUE));
                return;
            }
            stopMatch(false);
        }
        showItemCardDialog$default(this, 0, 1, null);
    }

    public final void maskMatchPropCardTipWindow() {
        Disposable disposed = NetworkClient.f11868a.z().w().flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<Object, p>() { // from class: com.cupidapp.live.maskparty.viewmodel.MaskPartyMatchViewModel$maskMatchPropCardTipWindow$$inlined$handle$default$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Object obj) {
                invoke2(obj);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        GrpcMessageRouter.INSTANCE.removeIGrpcMessageListener(this);
    }

    @Override // com.cupidapp.live.base.grpc.IGrpcMessageListener
    public void onReceiveGrpcMessage(@NotNull CuConnectorOuterClass.MessageType type, @NotNull Object model) {
        s.i(type, "type");
        s.i(model, "model");
        if (a.f16479a[type.ordinal()] == 1 && (model instanceof MaskPartyMatchSuccessModel) && this.matching) {
            this.matching = false;
            this._matchStatus.setValue(new MaskPartyMatchStatusModel(false, false, null, isVoiceChatType()));
            this._matchSuccessEventLiveData.setValue(new Event<>(model));
            int currentTimeMillis = (int) ((System.currentTimeMillis() - this.startMatchTime) / 1000);
            if (isVoiceChatType()) {
                GroupSocialLog.f18708a.a0(PostAndSocialProtos.Type.ENTER_VOICE_ROOM, (r13 & 2) != 0 ? null : ((MaskPartyMatchSuccessModel) model).getRoomId(), (r13 & 4) != 0 ? null : null, (r13 & 8) != 0 ? null : null, (r13 & 16) != 0 ? null : Long.valueOf(currentTimeMillis));
            } else {
                MaskPartyMatchSuccessModel maskPartyMatchSuccessModel = (MaskPartyMatchSuccessModel) model;
                GroupSocialLog.f18708a.R(PostAndSocialProtos.Type.MATCH, (r15 & 2) != 0 ? null : maskPartyMatchSuccessModel.getRoomId(), (r15 & 4) != 0 ? null : null, (r15 & 8) != 0 ? null : null, (r15 & 16) != 0 ? null : Integer.valueOf(currentTimeMillis), (r15 & 32) != 0 ? false : false, (r15 & 64) == 0 ? r.e(MaskPartyType.Companion.a(Integer.valueOf(maskPartyMatchSuccessModel.getType()))) : null);
            }
        }
    }

    public final void setMatchAvatar() {
        MaskPartyMatchConfigResult first;
        List<ImageModel> avatarList;
        ImageModel value;
        ImageModel imageModel;
        Pair<MaskPartyMatchConfigResult, List<Integer>> value2 = this._maskPartyMatchLiveData.getValue();
        if (value2 == null || (first = value2.getFirst()) == null || (avatarList = first.getAvatarList()) == null || (value = this._matchAvatarLiveData.getValue()) == null || !avatarList.contains(value)) {
            return;
        }
        int indexOf = avatarList.indexOf(value);
        if (indexOf < avatarList.size() - 1) {
            imageModel = avatarList.get(indexOf + 1);
        } else {
            imageModel = (ImageModel) CollectionsKt___CollectionsKt.V(avatarList);
        }
        this._matchAvatarLiveData.setValue(imageModel);
    }

    public final boolean setQuitMatchEvent() {
        MaskPartyMatchStatusModel value = this._matchStatus.getValue();
        boolean matching = value != null ? value.getMatching() : false;
        this._quitMatchEventLiveData.setValue(new Event<>(Boolean.valueOf(matching)));
        return matching;
    }

    public final void setSelectParty(@NotNull List<MaskPartyModel> partyList) {
        s.i(partyList, "partyList");
        this.selectedMaskParty = partyList;
    }

    public final void showItemCardDialog(int i10) {
        Pair<MaskPartyMatchConfigResult, List<Integer>> value = this._maskPartyMatchLiveData.getValue();
        if (value != null) {
            this._showItemCardDialogEventLiveData.setValue(new Event<>(new MaskPartyItemCardConfigModel(i10, value.getFirst().getItemCardRemains(), value.getFirst().getItemCardDetailUrl(), value.getFirst().getItemCardOrderUrl())));
        }
    }

    public final void startMatch() {
        MaskPartyConfigModel maskPartyConfigModel;
        MaskPartyMatchConfigResult first;
        MaskPartyConfigModel maskPartyConfigModel2;
        MaskPartyMatchConfigResult first2;
        if (this.rematch) {
            startPartyMatch();
            return;
        }
        Pair<MaskPartyMatchConfigResult, List<Integer>> value = this._maskPartyMatchLiveData.getValue();
        Boolean bool = null;
        List<MaskPartyConfigModel> gameEntrance = (value == null || (first2 = value.getFirst()) == null) ? null : first2.getGameEntrance();
        int i10 = 0;
        if (isVoiceChatType()) {
            if (gameEntrance != null && (maskPartyConfigModel2 = gameEntrance.get(1)) != null) {
                bool = Boolean.valueOf(maskPartyConfigModel2.hasRemains());
            }
        } else if (gameEntrance != null && (maskPartyConfigModel = gameEntrance.get(0)) != null) {
            bool = Boolean.valueOf(maskPartyConfigModel.hasRemains());
        }
        if (s.d(bool, Boolean.FALSE)) {
            Pair<MaskPartyMatchConfigResult, List<Integer>> value2 = this._maskPartyMatchLiveData.getValue();
            if (value2 != null && (first = value2.getFirst()) != null) {
                i10 = first.getItemCardRemains();
            }
            this._showNoTimesEventLiveData.setValue(new Event<>(Integer.valueOf(i10)));
            return;
        }
        startPartyMatch();
    }

    public final void stopMatch() {
        MaskPartyMatchStatusModel value = this._matchStatus.getValue();
        if (value != null && value.getMatching()) {
            if (this.rematch) {
                this._stopMatchEventLiveData.setValue(new Event<>(Boolean.FALSE));
            } else {
                stopMatch(false);
            }
        }
    }

    public final void useItemCardMatchNumber() {
        Disposable disposed = NetworkClient.f11868a.z().r().flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<Object, p>() { // from class: com.cupidapp.live.maskparty.viewmodel.MaskPartyMatchViewModel$useItemCardMatchNumber$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Object obj) {
                invoke2(obj);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
                MaskPartyMatchViewModel.this.getMaskPartyMatchInfo(false);
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    public final void stopMatch(final boolean z10) {
        List<MaskPartyModel> selectedMaskParty = getSelectedMaskParty();
        if (selectedMaskParty == null) {
            return;
        }
        final MaskPartyMatchBtnType maskPartyMatchBtnType = MaskPartyMatchBtnType.STOP_MATCH_BTN;
        this._btnClickState.setValue(new Event<>(new StateResult.b(maskPartyMatchBtnType, null, 2, null)));
        int currentTimeMillis = (int) ((System.currentTimeMillis() - this.startMatchTime) / 1000);
        if (isVoiceChatType()) {
            GroupSocialLog.f18708a.a0(PostAndSocialProtos.Type.STOP, (r13 & 2) != 0 ? null : null, (r13 & 4) != 0 ? null : null, (r13 & 8) != 0 ? null : null, (r13 & 16) != 0 ? null : Long.valueOf(currentTimeMillis));
        } else {
            GroupSocialLog groupSocialLog = GroupSocialLog.f18708a;
            PostAndSocialProtos.Type type = PostAndSocialProtos.Type.STOP;
            Integer valueOf = Integer.valueOf(currentTimeMillis);
            ArrayList arrayList = new ArrayList(t.t(selectedMaskParty, 10));
            Iterator<MaskPartyModel> iterator2 = selectedMaskParty.iterator2();
            while (iterator2.hasNext()) {
                arrayList.add(MaskPartyType.Companion.a(Integer.valueOf(iterator2.next().getType())));
            }
            groupSocialLog.R(type, (r15 & 2) != 0 ? null : null, (r15 & 4) != 0 ? null : null, (r15 & 8) != 0 ? null : null, (r15 & 16) != 0 ? null : valueOf, (r15 & 32) != 0 ? false : false, (r15 & 64) == 0 ? arrayList : null);
        }
        z2.a z11 = NetworkClient.f11868a.z();
        ArrayList arrayList2 = new ArrayList(t.t(selectedMaskParty, 10));
        Iterator<MaskPartyModel> iterator22 = selectedMaskParty.iterator2();
        while (iterator22.hasNext()) {
            arrayList2.add(Integer.valueOf(iterator22.next().getType()));
        }
        Disposable disposed = z11.m(arrayList2, this.rematch).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<Object, p>() { // from class: com.cupidapp.live.maskparty.viewmodel.MaskPartyMatchViewModel$stopMatch$$inlined$handle$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Object obj) {
                invoke2(obj);
                return p.f51048a;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
                MutableLiveData mutableLiveData;
                MutableLiveData mutableLiveData2;
                MutableLiveData mutableLiveData3;
                MutableLiveData mutableLiveData4;
                MaskPartyMatchConfigResult maskPartyMatchConfigResult;
                MaskPartyMatchViewModel.this.rematch = false;
                MaskPartyMatchViewModel.this.matching = false;
                mutableLiveData = MaskPartyMatchViewModel.this._btnClickState;
                String str = null;
                mutableLiveData.setValue(new Event(new StateResult.c(maskPartyMatchBtnType, null, 2, null)));
                mutableLiveData2 = MaskPartyMatchViewModel.this._matchStatus;
                mutableLiveData2.setValue(new MaskPartyMatchStatusModel(false, z10, null, MaskPartyMatchViewModel.this.isVoiceChatType()));
                mutableLiveData3 = MaskPartyMatchViewModel.this._itemCardEntranceLiveData;
                mutableLiveData4 = MaskPartyMatchViewModel.this._maskPartyMatchLiveData;
                Pair pair = (Pair) mutableLiveData4.getValue();
                if (pair != null && (maskPartyMatchConfigResult = (MaskPartyMatchConfigResult) pair.getFirst()) != null) {
                    str = maskPartyMatchConfigResult.getEnterTitle();
                }
                mutableLiveData3.setValue(new Pair(str, Boolean.FALSE));
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.maskparty.viewmodel.MaskPartyMatchViewModel$stopMatch$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                MutableLiveData mutableLiveData;
                s.i(it, "it");
                mutableLiveData = MaskPartyMatchViewModel.this._btnClickState;
                mutableLiveData.setValue(new Event(new StateResult.a(null, maskPartyMatchBtnType, null, 5, null)));
                return Boolean.FALSE;
            }
        }, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }
}
