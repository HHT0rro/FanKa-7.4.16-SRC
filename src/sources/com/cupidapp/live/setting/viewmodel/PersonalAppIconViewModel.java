package com.cupidapp.live.setting.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.livedata.CombineLiveData;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.network.model.ConstantsResult;
import com.cupidapp.live.base.view.h;
import com.cupidapp.live.setting.model.AppIcon;
import com.cupidapp.live.setting.model.AppIconListModel;
import com.cupidapp.live.setting.model.AppIconLocalDataModel;
import com.cupidapp.live.setting.model.AppIconModel;
import com.cupidapp.live.setting.model.PrivacySettingDataResult;
import com.cupidapp.live.track.group.GroupSocialLog;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.List;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p1.g;
import x2.a;

/* compiled from: PersonalAppIconViewModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class PersonalAppIconViewModel extends ViewModel {

    @NotNull
    private final MutableLiveData<AppIconLocalDataModel> _isUsingItemLiveData;

    @NotNull
    private final MutableLiveData<List<AppIconLocalDataModel>> _listLiveData;

    @NotNull
    private final MutableLiveData<AppIconLocalDataModel> _selectItemLiveData;

    @NotNull
    private final CombineLiveData<AppIconLocalDataModel, AppIconLocalDataModel, Boolean> confirmBtnStatus;

    @NotNull
    private final LiveData<AppIconLocalDataModel> isUsingItemLiveData;

    @NotNull
    private final LiveData<List<AppIconLocalDataModel>> listLiveData;

    @NotNull
    private final LiveData<AppIconLocalDataModel> selectItemLiveData;

    public PersonalAppIconViewModel() {
        MutableLiveData<List<AppIconLocalDataModel>> mutableLiveData = new MutableLiveData<>();
        this._listLiveData = mutableLiveData;
        this.listLiveData = Transformations.distinctUntilChanged(mutableLiveData);
        MutableLiveData<AppIconLocalDataModel> mutableLiveData2 = new MutableLiveData<>();
        this._selectItemLiveData = mutableLiveData2;
        this.selectItemLiveData = mutableLiveData2;
        MutableLiveData<AppIconLocalDataModel> mutableLiveData3 = new MutableLiveData<>();
        this._isUsingItemLiveData = mutableLiveData3;
        this.isUsingItemLiveData = Transformations.distinctUntilChanged(mutableLiveData3);
        this.confirmBtnStatus = new CombineLiveData<>(mutableLiveData2, mutableLiveData3, new Function2<AppIconLocalDataModel, AppIconLocalDataModel, Boolean>() { // from class: com.cupidapp.live.setting.viewmodel.PersonalAppIconViewModel$confirmBtnStatus$1
            @Override // kotlin.jvm.functions.Function2
            @Nullable
            /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public final Boolean mo1743invoke(@Nullable AppIconLocalDataModel appIconLocalDataModel, @Nullable AppIconLocalDataModel appIconLocalDataModel2) {
                return Boolean.valueOf(!s.d(appIconLocalDataModel, appIconLocalDataModel2));
            }
        });
        loadData();
    }

    public final void changeSelectItem(@NotNull AppIconLocalDataModel model) {
        s.i(model, "model");
        this._selectItemLiveData.setValue(model);
    }

    @NotNull
    public final CombineLiveData<AppIconLocalDataModel, AppIconLocalDataModel, Boolean> getConfirmBtnStatus() {
        return this.confirmBtnStatus;
    }

    @NotNull
    public final LiveData<List<AppIconLocalDataModel>> getListLiveData() {
        return this.listLiveData;
    }

    @NotNull
    public final LiveData<AppIconLocalDataModel> getSelectItemLiveData() {
        return this.selectItemLiveData;
    }

    @NotNull
    public final LiveData<AppIconLocalDataModel> isUsingItemLiveData() {
        return this.isUsingItemLiveData;
    }

    public final void loadData() {
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        Disposable disposed = NetworkClient.f11868a.i().b().flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<AppIconListModel, p>() { // from class: com.cupidapp.live.setting.viewmodel.PersonalAppIconViewModel$loadData$$inlined$handle$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(AppIconListModel appIconListModel) {
                m2806invoke(appIconListModel);
                return p.f51048a;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r3v3, types: [T, java.lang.Object, com.cupidapp.live.setting.model.AppIconLocalDataModel] */
            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2806invoke(AppIconListModel appIconListModel) {
                MutableLiveData mutableLiveData;
                MutableLiveData mutableLiveData2;
                MutableLiveData mutableLiveData3;
                mutableLiveData = PersonalAppIconViewModel.this._listLiveData;
                List<AppIconModel> icons = appIconListModel.getIcons();
                ArrayList arrayList = null;
                if (icons != null) {
                    ArrayList arrayList2 = new ArrayList();
                    for (AppIconModel appIconModel : icons) {
                        ConstantsResult q10 = g.f52734a.q();
                        String customAppIcon = q10 != null ? q10.getCustomAppIcon() : null;
                        ?? mapToAppIcon = appIconModel.mapToAppIcon();
                        if (customAppIcon == null || customAppIcon.length() == 0) {
                            if (s.d(mapToAppIcon != 0 ? mapToAppIcon.getName() : null, AppIcon.SystemIcon.getValue())) {
                                ref$ObjectRef.element = mapToAppIcon;
                            }
                        } else if (s.d(mapToAppIcon != 0 ? mapToAppIcon.getName() : null, customAppIcon)) {
                            ref$ObjectRef.element = mapToAppIcon;
                        }
                        if (mapToAppIcon != 0) {
                            arrayList2.add(mapToAppIcon);
                        }
                    }
                    arrayList = arrayList2;
                }
                mutableLiveData.setValue(arrayList);
                AppIconLocalDataModel appIconLocalDataModel = (AppIconLocalDataModel) ref$ObjectRef.element;
                if (appIconLocalDataModel != null) {
                    mutableLiveData2 = PersonalAppIconViewModel.this._selectItemLiveData;
                    mutableLiveData2.setValue(appIconLocalDataModel);
                    mutableLiveData3 = PersonalAppIconViewModel.this._isUsingItemLiveData;
                    mutableLiveData3.setValue(appIconLocalDataModel);
                }
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    public final void saveIcon(@NotNull final AppIconLocalDataModel item) {
        s.i(item, "item");
        Disposable disposed = a.C0836a.f(NetworkClient.f11868a.N(), null, null, null, null, null, null, null, item.getName(), null, null, null, null, 3967, null).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<PrivacySettingDataResult, p>() { // from class: com.cupidapp.live.setting.viewmodel.PersonalAppIconViewModel$saveIcon$$inlined$handle$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(PrivacySettingDataResult privacySettingDataResult) {
                m2807invoke(privacySettingDataResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2807invoke(PrivacySettingDataResult privacySettingDataResult) {
                MutableLiveData mutableLiveData;
                ConstantsResult q10 = g.f52734a.q();
                if (q10 != null) {
                    q10.setCustomAppIcon(AppIconLocalDataModel.this.getName());
                }
                h.f12779a.b(R$string.set_success);
                mutableLiveData = this._isUsingItemLiveData;
                mutableLiveData.setValue(AppIconLocalDataModel.this);
                GroupSocialLog.f18708a.O(AppIconLocalDataModel.this.getName());
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }
}
