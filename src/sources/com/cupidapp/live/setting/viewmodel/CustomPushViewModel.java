package com.cupidapp.live.setting.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.cupidapp.live.base.livedata.Event;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.j;
import com.cupidapp.live.setting.model.PushPostRange;
import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;

/* compiled from: CustomPushViewModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class CustomPushViewModel extends ViewModel {

    @NotNull
    private final MutableLiveData<Event<p>> _openSystemPushEvent;

    @NotNull
    private final MutableLiveData<PushRangeChoice> _selectPushRangeLiveData;

    @NotNull
    private final MutableLiveData<PushTypeChoice> _selectPushTypeLiveData;

    @NotNull
    private final LiveData<Event<p>> openSystemPushEvent;

    @NotNull
    private final MutableLiveData<PushRangeChoice> selectPushRangeLiveData;

    @NotNull
    private final MutableLiveData<PushTypeChoice> selectPushTypeLiveData;

    public CustomPushViewModel() {
        MutableLiveData<PushTypeChoice> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue(PushTypeChoice.IMPORTANT_PUSH);
        this._selectPushTypeLiveData = mutableLiveData;
        this.selectPushTypeLiveData = mutableLiveData;
        MutableLiveData<PushRangeChoice> mutableLiveData2 = new MutableLiveData<>();
        mutableLiveData2.setValue(PushRangeChoice.PRIVACY_FIRST);
        this._selectPushRangeLiveData = mutableLiveData2;
        this.selectPushRangeLiveData = mutableLiveData2;
        MutableLiveData<Event<p>> mutableLiveData3 = new MutableLiveData<>();
        this._openSystemPushEvent = mutableLiveData3;
        this.openSystemPushEvent = mutableLiveData3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void saveCustomPush$lambda$2(CustomPushViewModel this$0) {
        s.i(this$0, "this$0");
        this$0._openSystemPushEvent.setValue(new Event<>(p.f51048a));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void saveCustomPush$lambda$3(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void changePushRange(@NotNull PushRangeChoice privacyFirst) {
        s.i(privacyFirst, "privacyFirst");
        this._selectPushRangeLiveData.setValue(privacyFirst);
    }

    public final void changePushType(@NotNull PushTypeChoice importantPush) {
        s.i(importantPush, "importantPush");
        this._selectPushTypeLiveData.setValue(importantPush);
    }

    @NotNull
    public final LiveData<Event<p>> getOpenSystemPushEvent() {
        return this.openSystemPushEvent;
    }

    @NotNull
    public final MutableLiveData<PushRangeChoice> getSelectPushRangeLiveData() {
        return this.selectPushRangeLiveData;
    }

    @NotNull
    public final MutableLiveData<PushTypeChoice> getSelectPushTypeLiveData() {
        return this.selectPushTypeLiveData;
    }

    public final void saveCustomPush() {
        NetworkClient networkClient = NetworkClient.f11868a;
        n3.a B = networkClient.B();
        PushTypeChoice value = this.selectPushTypeLiveData.getValue();
        PushTypeChoice pushTypeChoice = PushTypeChoice.ALL_PUSH;
        Completable ignoreElements = B.b(value == pushTypeChoice).ignoreElements();
        HashMap<String, Object> hashMap = new HashMap<>();
        Boolean bool = Boolean.TRUE;
        hashMap.put("pushInbox", bool);
        hashMap.put("pushGreet", bool);
        hashMap.put("pushAloha", bool);
        hashMap.put("pushNewMatch", bool);
        if (this.selectPushTypeLiveData.getValue() == pushTypeChoice) {
            PushPostRange pushPostRange = PushPostRange.ALL;
            hashMap.put("pushPostCommentV2", Integer.valueOf(pushPostRange.getValue()));
            hashMap.put("pushPostLikeV2", Integer.valueOf(pushPostRange.getValue()));
            hashMap.put("pushPostPublishV2", Integer.valueOf(pushPostRange.getValue()));
            hashMap.put("pushPostAtV2", Integer.valueOf(pushPostRange.getValue()));
        } else {
            PushPostRange pushPostRange2 = PushPostRange.FOCUS;
            hashMap.put("pushPostCommentV2", Integer.valueOf(pushPostRange2.getValue()));
            hashMap.put("pushPostLikeV2", Integer.valueOf(pushPostRange2.getValue()));
            hashMap.put("pushPostPublishV2", Integer.valueOf(pushPostRange2.getValue()));
            hashMap.put("pushPostAtV2", Integer.valueOf(pushPostRange2.getValue()));
        }
        if (this.selectPushRangeLiveData.getValue() == PushRangeChoice.PRIVACY_FIRST) {
            hashMap.put("pushHideDetail", bool);
            Boolean bool2 = Boolean.FALSE;
            hashMap.put("pushSound", bool2);
            hashMap.put("pushVibration", bool2);
        } else {
            hashMap.put("pushHideDetail", Boolean.FALSE);
            hashMap.put("pushSound", bool);
            hashMap.put("pushVibration", bool);
        }
        Completable observeOn = ignoreElements.mergeWith(networkClient.B().i(hashMap).ignoreElements()).observeOn(AndroidSchedulers.mainThread());
        Action action = new Action() { // from class: com.cupidapp.live.setting.viewmodel.a
            @Override // io.reactivex.functions.Action
            public final void run() {
                CustomPushViewModel.saveCustomPush$lambda$2(CustomPushViewModel.this);
            }
        };
        final CustomPushViewModel$saveCustomPush$2 customPushViewModel$saveCustomPush$2 = new Function1<Throwable, p>() { // from class: com.cupidapp.live.setting.viewmodel.CustomPushViewModel$saveCustomPush$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Throwable th) {
                invoke2(th);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                j jVar = j.f12008a;
                s.h(it, "it");
                j.f(jVar, it, null, null, null, 14, null);
            }
        };
        observeOn.subscribe(action, new Consumer() { // from class: com.cupidapp.live.setting.viewmodel.b
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                CustomPushViewModel.saveCustomPush$lambda$3(Function1.this, obj);
            }
        });
    }
}
