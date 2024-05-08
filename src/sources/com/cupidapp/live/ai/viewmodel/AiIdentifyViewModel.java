package com.cupidapp.live.ai.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import com.cupidapp.live.ai.model.AiIdentifyGraphModel;
import com.cupidapp.live.ai.model.AiIdentifyModel;
import com.cupidapp.live.base.livedata.CombineLiveData;
import com.cupidapp.live.base.livedata.Event;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.f;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.network.model.StateResult;
import com.cupidapp.live.match.model.NearbyUserProfileModel;
import com.cupidapp.live.match.model.PurchaseProductType;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.io.File;
import java.util.List;
import kotlin.Pair;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AiIdentifyViewModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class AiIdentifyViewModel extends ViewModel {

    @NotNull
    private final MutableLiveData<AiIdentifyGraphModel> _identifyInfoLiveData;

    @NotNull
    private final MutableLiveData<Event<Pair<StateResult<List<NearbyUserProfileModel>>, String>>> _listLiveData;

    @NotNull
    private MutableLiveData<String> _sourceImgPath;

    @NotNull
    private final LiveData<Pair<String, String>> currentImageSelectLiveData;

    @Nullable
    private Integer freeUseCount;

    @NotNull
    private final LiveData<AiIdentifyGraphModel> identifyInfoLiveData;

    @NotNull
    private final LiveData<Event<Pair<StateResult<List<NearbyUserProfileModel>>, String>>> listLiveData;

    @NotNull
    private final LiveData<String> sourceImgPath;

    public AiIdentifyViewModel() {
        MutableLiveData<AiIdentifyGraphModel> mutableLiveData = new MutableLiveData<>();
        this._identifyInfoLiveData = mutableLiveData;
        this.identifyInfoLiveData = mutableLiveData;
        MutableLiveData<String> mutableLiveData2 = new MutableLiveData<>();
        this._sourceImgPath = mutableLiveData2;
        this.sourceImgPath = mutableLiveData2;
        this.currentImageSelectLiveData = Transformations.distinctUntilChanged(new CombineLiveData(mutableLiveData, this._sourceImgPath, new Function2<AiIdentifyGraphModel, String, Pair<? extends String, ? extends String>>() { // from class: com.cupidapp.live.ai.viewmodel.AiIdentifyViewModel$currentImageSelectLiveData$1
            @Override // kotlin.jvm.functions.Function2
            @Nullable
            /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public final Pair<String, String> mo1743invoke(@Nullable AiIdentifyGraphModel aiIdentifyGraphModel, @Nullable String str) {
                Pair<String, String> pair;
                if (str == null || str.length() == 0) {
                    pair = new Pair<>(str, aiIdentifyGraphModel != null ? aiIdentifyGraphModel.getTip() : null);
                } else {
                    pair = new Pair<>(str, aiIdentifyGraphModel != null ? aiIdentifyGraphModel.getScanTip() : null);
                }
                return pair;
            }
        }));
        MutableLiveData<Event<Pair<StateResult<List<NearbyUserProfileModel>>, String>>> mutableLiveData3 = new MutableLiveData<>();
        this._listLiveData = mutableLiveData3;
        this.listLiveData = mutableLiveData3;
        loadData();
    }

    @NotNull
    public final LiveData<Pair<String, String>> getCurrentImageSelectLiveData() {
        return this.currentImageSelectLiveData;
    }

    @NotNull
    public final LiveData<AiIdentifyGraphModel> getIdentifyInfoLiveData() {
        return this.identifyInfoLiveData;
    }

    @NotNull
    public final LiveData<Event<Pair<StateResult<List<NearbyUserProfileModel>>, String>>> getListLiveData() {
        return this.listLiveData;
    }

    @NotNull
    public final LiveData<String> getSourceImgPath() {
        return this.sourceImgPath;
    }

    public final void loadData() {
        Disposable disposed = NetworkClient.f11868a.N().n().flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<AiIdentifyGraphModel, p>() { // from class: com.cupidapp.live.ai.viewmodel.AiIdentifyViewModel$loadData$$inlined$handle$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(AiIdentifyGraphModel aiIdentifyGraphModel) {
                m2449invoke(aiIdentifyGraphModel);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2449invoke(AiIdentifyGraphModel aiIdentifyGraphModel) {
                MutableLiveData mutableLiveData;
                AiIdentifyGraphModel aiIdentifyGraphModel2 = aiIdentifyGraphModel;
                Integer freeCount = aiIdentifyGraphModel2.getFreeCount();
                int intValue = freeCount != null ? freeCount.intValue() : 0;
                AiIdentifyViewModel.this.freeUseCount = (PurchaseProductType.Companion.f(aiIdentifyGraphModel2.getProductRequire()) != PurchaseProductType.NO || intValue <= 0) ? null : Integer.valueOf(intValue);
                mutableLiveData = AiIdentifyViewModel.this._identifyInfoLiveData;
                mutableLiveData.setValue(aiIdentifyGraphModel2);
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.ai.viewmodel.AiIdentifyViewModel$loadData$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                MutableLiveData mutableLiveData;
                s.i(it, "it");
                mutableLiveData = AiIdentifyViewModel.this._identifyInfoLiveData;
                mutableLiveData.setValue(null);
                return Boolean.FALSE;
            }
        }, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    public final boolean noFreeCount() {
        Integer num = this.freeUseCount;
        if (num != null) {
            return (num != null ? num.intValue() : 0) <= 0;
        }
        return false;
    }

    public final void searchImage() {
        Pair<StateResult<List<NearbyUserProfileModel>>, String> peekContent;
        final String value = this.sourceImgPath.getValue();
        if (value == null || value.length() == 0) {
            return;
        }
        Event<Pair<StateResult<List<NearbyUserProfileModel>>, String>> value2 = this.listLiveData.getValue();
        if (((value2 == null || (peekContent = value2.peekContent()) == null) ? null : peekContent.getFirst()) instanceof StateResult.b) {
            return;
        }
        this._listLiveData.setValue(new Event<>(new Pair(new StateResult.b(null, null, 3, null), value)));
        Disposable disposed = NetworkClient.f11868a.N().x(f.a(new File(value))).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<AiIdentifyModel, p>() { // from class: com.cupidapp.live.ai.viewmodel.AiIdentifyViewModel$searchImage$$inlined$handle$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(AiIdentifyModel aiIdentifyModel) {
                m2450invoke(aiIdentifyModel);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2450invoke(AiIdentifyModel aiIdentifyModel) {
                Integer num;
                MutableLiveData mutableLiveData;
                AiIdentifyModel aiIdentifyModel2 = aiIdentifyModel;
                num = AiIdentifyViewModel.this.freeUseCount;
                if (num != null) {
                    AiIdentifyViewModel.this.freeUseCount = Integer.valueOf(num.intValue() - 1);
                }
                mutableLiveData = AiIdentifyViewModel.this._listLiveData;
                List<NearbyUserProfileModel> list = aiIdentifyModel2.getList();
                if (list == null) {
                    list = kotlin.collections.s.j();
                }
                mutableLiveData.setValue(new Event(new Pair(new StateResult.c(list, null, 2, null), value)));
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.ai.viewmodel.AiIdentifyViewModel$searchImage$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                MutableLiveData mutableLiveData;
                s.i(it, "it");
                mutableLiveData = AiIdentifyViewModel.this._listLiveData;
                mutableLiveData.setValue(new Event(new Pair(new StateResult.a(it.getMessage(), null, null, 6, null), value)));
                return Boolean.FALSE;
            }
        }, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    public final void selectPhoto(@Nullable String str) {
        if (str == null) {
            return;
        }
        this._sourceImgPath.setValue(str);
    }
}
