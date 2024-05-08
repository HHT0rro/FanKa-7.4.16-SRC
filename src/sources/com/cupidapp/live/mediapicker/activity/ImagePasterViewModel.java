package com.cupidapp.live.mediapicker.activity;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import com.cupidapp.live.base.livedata.Event;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.model.ListResult;
import com.cupidapp.live.base.network.model.StateResult;
import com.cupidapp.live.base.sensorslog.SensorsLogFeed;
import com.cupidapp.live.mediapicker.fragment.ImagePasterSourceModel;
import com.cupidapp.live.mediapicker.model.FrameAspectRatio;
import com.cupidapp.live.mediapicker.model.ImageTrimModel;
import com.cupidapp.live.mediapicker.model.PasterModel;
import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ImagePasterViewModel.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ImagePasterViewModel extends ViewModel {

    @NotNull
    private MutableLiveData<StateResult<List<PasterModel>>> _imagePasterResult;

    @NotNull
    private MutableLiveData<PasterModel> _imagePasterSelect;

    @NotNull
    private MutableLiveData<Event<ImageTrimModel>> _openImageTrimFragment;

    @NotNull
    private MutableLiveData<Event<Boolean>> _showLoading;

    @NotNull
    private MutableLiveData<Event<String>> _sourceImgPath;

    @NotNull
    private final LiveData<StateResult<List<PasterModel>>> imagePasterResult;

    @NotNull
    private final LiveData<PasterModel> imagePasterSelect;

    @NotNull
    private final LiveData<Event<ImageTrimModel>> openImageTrimFragment;

    @NotNull
    private final LiveData<Event<Boolean>> showLoading;

    @NotNull
    private final LiveData<Event<String>> sourceImgPath;

    @Nullable
    private String webTitle;

    public ImagePasterViewModel() {
        MutableLiveData<StateResult<List<PasterModel>>> mutableLiveData = new MutableLiveData<>();
        this._imagePasterResult = mutableLiveData;
        this.imagePasterResult = Transformations.distinctUntilChanged(mutableLiveData);
        MutableLiveData<Event<Boolean>> mutableLiveData2 = new MutableLiveData<>();
        this._showLoading = mutableLiveData2;
        this.showLoading = mutableLiveData2;
        MutableLiveData<PasterModel> mutableLiveData3 = new MutableLiveData<>();
        this._imagePasterSelect = mutableLiveData3;
        this.imagePasterSelect = Transformations.distinctUntilChanged(mutableLiveData3);
        MutableLiveData<Event<ImageTrimModel>> mutableLiveData4 = new MutableLiveData<>();
        this._openImageTrimFragment = mutableLiveData4;
        this.openImageTrimFragment = mutableLiveData4;
        MutableLiveData<Event<String>> mutableLiveData5 = new MutableLiveData<>();
        this._sourceImgPath = mutableLiveData5;
        this.sourceImgPath = mutableLiveData5;
        loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void saveImgRecord$lambda$2() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void saveImgRecord$lambda$3(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void changeLoadingState(boolean z10) {
        this._showLoading.setValue(new Event<>(Boolean.valueOf(z10)));
    }

    public final void changePaster(@Nullable PasterModel pasterModel) {
        if (pasterModel != null) {
            this._imagePasterSelect.setValue(pasterModel);
            SensorsLogFeed.f12208a.H(SensorsLogFeed.BtnName.STICKER, this.webTitle, pasterModel.getId());
        }
    }

    public final void changePasterSourceImgPath(@Nullable String str) {
        if (str == null) {
            return;
        }
        this._sourceImgPath.setValue(new Event<>(str));
    }

    @NotNull
    public final LiveData<StateResult<List<PasterModel>>> getImagePasterResult() {
        return this.imagePasterResult;
    }

    @NotNull
    public final LiveData<PasterModel> getImagePasterSelect() {
        return this.imagePasterSelect;
    }

    @NotNull
    public final LiveData<Event<ImageTrimModel>> getOpenImageTrimFragment() {
        return this.openImageTrimFragment;
    }

    @NotNull
    public final LiveData<Event<Boolean>> getShowLoading() {
        return this.showLoading;
    }

    @NotNull
    public final LiveData<Event<String>> getSourceImgPath() {
        return this.sourceImgPath;
    }

    public final void initData(@Nullable String str) {
        this.webTitle = str;
    }

    public final void loadData() {
        if ((this.imagePasterResult.getValue() instanceof StateResult.c) || (this.imagePasterResult.getValue() instanceof StateResult.b)) {
            return;
        }
        this._imagePasterResult.setValue(new StateResult.b(null, null, 3, null));
        Disposable disposed = NetworkClient.f11868a.l().B().flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<ListResult<PasterModel>, p>() { // from class: com.cupidapp.live.mediapicker.activity.ImagePasterViewModel$loadData$$inlined$handle$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(ListResult<PasterModel> listResult) {
                m2740invoke(listResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2740invoke(ListResult<PasterModel> listResult) {
                MutableLiveData mutableLiveData;
                MutableLiveData mutableLiveData2;
                List<PasterModel> list = listResult.getList();
                if (list != null) {
                    mutableLiveData = ImagePasterViewModel.this._imagePasterResult;
                    mutableLiveData.setValue(new StateResult.c(list, null, 2, null));
                    if (!list.isEmpty()) {
                        mutableLiveData2 = ImagePasterViewModel.this._imagePasterSelect;
                        mutableLiveData2.setValue(CollectionsKt___CollectionsKt.V(list));
                    }
                }
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.mediapicker.activity.ImagePasterViewModel$loadData$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                MutableLiveData mutableLiveData;
                s.i(it, "it");
                mutableLiveData = ImagePasterViewModel.this._imagePasterResult;
                mutableLiveData.setValue(new StateResult.a(null, null, null, 7, null));
                return Boolean.TRUE;
            }
        }, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    public final void openImagePasterTrimFragment(@NotNull ImagePasterSourceModel model, @NotNull FrameAspectRatio frameAspectRatio) {
        s.i(model, "model");
        s.i(frameAspectRatio, "frameAspectRatio");
        if (model.getMediaContentPath() == null || model.getOriginPath() == null) {
            return;
        }
        this._openImageTrimFragment.setValue(new Event<>(new ImageTrimModel(model.getMediaContentPath(), model.getOriginPath(), frameAspectRatio.getRatio(), null)));
    }

    public final void saveImgRecord() {
        Completable subscribeOn = NetworkClient.f11868a.l().y().subscribeOn(Schedulers.io());
        h hVar = new Action() { // from class: com.cupidapp.live.mediapicker.activity.h
            @Override // io.reactivex.functions.Action
            public final void run() {
                ImagePasterViewModel.saveImgRecord$lambda$2();
            }
        };
        final ImagePasterViewModel$saveImgRecord$2 imagePasterViewModel$saveImgRecord$2 = new Function1<Throwable, p>() { // from class: com.cupidapp.live.mediapicker.activity.ImagePasterViewModel$saveImgRecord$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Throwable th) {
                invoke2(th);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
            }
        };
        subscribeOn.subscribe(hVar, new Consumer() { // from class: com.cupidapp.live.mediapicker.activity.i
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ImagePasterViewModel.saveImgRecord$lambda$3(Function1.this, obj);
            }
        });
    }
}
