package com.cupidapp.live.setting.viewmodel;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import com.cupidapp.live.base.livedata.Event;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.network.model.EquityModel;
import com.cupidapp.live.base.network.model.InnerFunctionModel;
import com.cupidapp.live.base.network.model.MarketingSpotModel;
import com.cupidapp.live.base.network.model.ProfileInfoResult;
import com.cupidapp.live.base.network.model.ProfileResult;
import com.cupidapp.live.base.network.model.ProfileTaskResult;
import com.cupidapp.live.base.network.model.TodayLuckyScoreModel;
import com.cupidapp.live.liveshow.model.AdModel;
import com.cupidapp.live.liveshow.model.AdViewModel;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.setting.helper.MultiAccountUserIdManager;
import com.cupidapp.live.setting.model.EditInfoPromptModel;
import com.cupidapp.live.setting.model.GameModel;
import com.cupidapp.live.setting.model.MultiAccountUserIdsModel;
import com.cupidapp.live.setting.model.ProfilePasterAdModel;
import com.cupidapp.live.setting.model.SwitchAccountResult;
import com.cupidapp.live.setting.model.UserFunctionEntranceUiModel;
import com.cupidapp.live.setting.model.UserInfoUiModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.t;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import n3.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p1.g;
import x2.a;

/* compiled from: UserInfoContainerViewModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class UserInfoContainerViewModel extends AndroidViewModel {

    @NotNull
    private final MutableLiveData<Pair<AdViewModel, String>> _adLiveData;

    @NotNull
    private final MutableLiveData<EditInfoPromptModel> _editInfoPromptData;

    @NotNull
    private final MutableLiveData<List<GameModel>> _entranceListLiveData;

    @NotNull
    private final MutableLiveData<List<EquityModel>> _featuredServicesListLiveData;

    @NotNull
    private final MutableLiveData<TodayLuckyScoreModel> _luckyScoreLiveData;

    @NotNull
    private final MutableLiveData<MarketingSpotModel> _marketingSpotData;

    @NotNull
    private final MutableLiveData<Event<Pair<String, String>>> _matchListGuideLiveData;

    @NotNull
    private final MutableLiveData<Integer> _multiAccountUnreadCount;

    @NotNull
    private final MutableLiveData<ProfilePasterAdModel> _profilePasterAdLiveData;

    @NotNull
    private final MutableLiveData<User> _userLiveData;

    @NotNull
    private final MutableLiveData<ProfileTaskResult> _userTasksLiveData;

    @NotNull
    private final MutableLiveData<List<EquityModel>> _valueEquityTopLiveData;

    @NotNull
    private final LiveData<Pair<AdViewModel, String>> adLiveData;

    @NotNull
    private final Application context;

    @NotNull
    private final LiveData<EditInfoPromptModel> editInfoPromptData;

    @NotNull
    private final LiveData<List<UserFunctionEntranceUiModel>> entranceListLiveData;

    @NotNull
    private final LiveData<List<EquityModel>> featuredServicesListLiveData;

    @Nullable
    private List<? extends List<InnerFunctionModel>> innerFunctions;

    @NotNull
    private final LiveData<TodayLuckyScoreModel> luckyScoreLiveData;
    private boolean mIsInitializedUserData;

    @Nullable
    private SwitchAccountResult mSwitchAccountResult;

    @NotNull
    private final LiveData<MarketingSpotModel> marketingSpotData;

    @NotNull
    private final LiveData<Event<Pair<String, String>>> matchListGuideLiveData;

    @NotNull
    private final LiveData<Integer> multiAccountUnreadCount;

    @NotNull
    private final LiveData<ProfilePasterAdModel> profilePasterAdLiveData;

    @NotNull
    private final LiveData<UserInfoUiModel> userLiveData;

    @NotNull
    private final LiveData<ProfileTaskResult> userTasksLiveData;

    @NotNull
    private final LiveData<List<EquityModel>> valueEquityTopLiveData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserInfoContainerViewModel(@NotNull Application context) {
        super(context);
        s.i(context, "context");
        this.context = context;
        MutableLiveData<User> mutableLiveData = new MutableLiveData<>();
        this._userLiveData = mutableLiveData;
        this.userLiveData = Transformations.distinctUntilChanged(Transformations.map(mutableLiveData, new Function1<User, UserInfoUiModel>() { // from class: com.cupidapp.live.setting.viewmodel.UserInfoContainerViewModel$userLiveData$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final UserInfoUiModel invoke(User it) {
                s.h(it, "it");
                return new UserInfoUiModel(it, it.getAvatarImage(), it.getName(), it.getFormatMatchCount(), it.getFormatAlohaGetCount(), it.getFormatAlohaCount(), it.getFormatPostCount(), it.getSummary());
            }
        }));
        MutableLiveData<EditInfoPromptModel> mutableLiveData2 = new MutableLiveData<>();
        this._editInfoPromptData = mutableLiveData2;
        this.editInfoPromptData = mutableLiveData2;
        MutableLiveData<ProfileTaskResult> mutableLiveData3 = new MutableLiveData<>();
        this._userTasksLiveData = mutableLiveData3;
        this.userTasksLiveData = mutableLiveData3;
        MutableLiveData<TodayLuckyScoreModel> mutableLiveData4 = new MutableLiveData<>();
        this._luckyScoreLiveData = mutableLiveData4;
        this.luckyScoreLiveData = mutableLiveData4;
        MutableLiveData<ProfilePasterAdModel> mutableLiveData5 = new MutableLiveData<>();
        this._profilePasterAdLiveData = mutableLiveData5;
        this.profilePasterAdLiveData = Transformations.distinctUntilChanged(mutableLiveData5);
        MutableLiveData<Pair<AdViewModel, String>> mutableLiveData6 = new MutableLiveData<>();
        this._adLiveData = mutableLiveData6;
        this.adLiveData = Transformations.distinctUntilChanged(mutableLiveData6);
        MutableLiveData<List<GameModel>> mutableLiveData7 = new MutableLiveData<>();
        this._entranceListLiveData = mutableLiveData7;
        this.entranceListLiveData = Transformations.map(mutableLiveData7, new Function1<List<GameModel>, List<UserFunctionEntranceUiModel>>() { // from class: com.cupidapp.live.setting.viewmodel.UserInfoContainerViewModel$entranceListLiveData$1
            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final List<UserFunctionEntranceUiModel> invoke(@Nullable List<GameModel> list) {
                if (list == null) {
                    return null;
                }
                ArrayList arrayList = new ArrayList(t.t(list, 10));
                for (GameModel gameModel : list) {
                    arrayList.add(new UserFunctionEntranceUiModel(gameModel.getIcon(), null, gameModel.getTitle(), gameModel.getUrl(), gameModel.getTrackName(), gameModel.getRemains(), gameModel.getMosaic(), gameModel.getShowAvatar(), false, gameModel.getEntranceType(), 258, null));
                }
                return arrayList;
            }
        });
        MutableLiveData<List<EquityModel>> mutableLiveData8 = new MutableLiveData<>();
        this._valueEquityTopLiveData = mutableLiveData8;
        this.valueEquityTopLiveData = Transformations.distinctUntilChanged(mutableLiveData8);
        MutableLiveData<List<EquityModel>> mutableLiveData9 = new MutableLiveData<>();
        this._featuredServicesListLiveData = mutableLiveData9;
        this.featuredServicesListLiveData = Transformations.distinctUntilChanged(mutableLiveData9);
        MutableLiveData<Integer> mutableLiveData10 = new MutableLiveData<>();
        this._multiAccountUnreadCount = mutableLiveData10;
        this.multiAccountUnreadCount = Transformations.distinctUntilChanged(mutableLiveData10);
        MutableLiveData<MarketingSpotModel> mutableLiveData11 = new MutableLiveData<>();
        this._marketingSpotData = mutableLiveData11;
        this.marketingSpotData = mutableLiveData11;
        MutableLiveData<Event<Pair<String, String>>> mutableLiveData12 = new MutableLiveData<>();
        this._matchListGuideLiveData = mutableLiveData12;
        this.matchListGuideLiveData = mutableLiveData12;
    }

    public final void callMultiAccountUnreadCountApi() {
        MultiAccountUserIdsModel p02 = g.f52734a.p0();
        List<String> list = p02 != null ? p02.getList() : null;
        if (list == null || list.isEmpty()) {
            return;
        }
        Disposable disposed = b.a.a(NetworkClient.f11868a.w(), list, true, false, 4, null).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<SwitchAccountResult, p>() { // from class: com.cupidapp.live.setting.viewmodel.UserInfoContainerViewModel$callMultiAccountUnreadCountApi$$inlined$handle$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(SwitchAccountResult switchAccountResult) {
                m2811invoke(switchAccountResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2811invoke(SwitchAccountResult switchAccountResult) {
                MutableLiveData mutableLiveData;
                SwitchAccountResult switchAccountResult2 = switchAccountResult;
                UserInfoContainerViewModel.this.setMSwitchAccountResult(switchAccountResult2);
                mutableLiveData = UserInfoContainerViewModel.this._multiAccountUnreadCount;
                int otherUnReadCount = switchAccountResult2.getOtherUnReadCount();
                if (otherUnReadCount == null) {
                    otherUnReadCount = 0;
                }
                mutableLiveData.setValue(otherUnReadCount);
                MultiAccountUserIdManager.f18178a.c(switchAccountResult2.getAccountList());
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.setting.viewmodel.UserInfoContainerViewModel$callMultiAccountUnreadCountApi$2
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                s.i(it, "it");
                return Boolean.TRUE;
            }
        }, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    @NotNull
    public final LiveData<Pair<AdViewModel, String>> getAdLiveData() {
        return this.adLiveData;
    }

    @NotNull
    public final Application getContext() {
        return this.context;
    }

    @NotNull
    public final LiveData<EditInfoPromptModel> getEditInfoPromptData() {
        return this.editInfoPromptData;
    }

    @NotNull
    public final LiveData<List<UserFunctionEntranceUiModel>> getEntranceListLiveData() {
        return this.entranceListLiveData;
    }

    @NotNull
    public final LiveData<List<EquityModel>> getFeaturedServicesListLiveData() {
        return this.featuredServicesListLiveData;
    }

    @Nullable
    public final List<List<InnerFunctionModel>> getInnerFunction() {
        return this.innerFunctions;
    }

    @NotNull
    public final LiveData<TodayLuckyScoreModel> getLuckyScoreLiveData() {
        return this.luckyScoreLiveData;
    }

    @Nullable
    public final SwitchAccountResult getMSwitchAccountResult() {
        return this.mSwitchAccountResult;
    }

    @NotNull
    public final LiveData<MarketingSpotModel> getMarketingSpotData() {
        return this.marketingSpotData;
    }

    @NotNull
    public final LiveData<Event<Pair<String, String>>> getMatchListGuideLiveData() {
        return this.matchListGuideLiveData;
    }

    @NotNull
    public final LiveData<Integer> getMultiAccountUnreadCount() {
        return this.multiAccountUnreadCount;
    }

    @NotNull
    public final LiveData<ProfilePasterAdModel> getProfilePasterAdLiveData() {
        return this.profilePasterAdLiveData;
    }

    @NotNull
    public final LiveData<UserInfoUiModel> getUserLiveData() {
        return this.userLiveData;
    }

    @NotNull
    public final LiveData<ProfileTaskResult> getUserTasksLiveData() {
        return this.userTasksLiveData;
    }

    @NotNull
    public final LiveData<List<EquityModel>> getValueEquityTopLiveData() {
        return this.valueEquityTopLiveData;
    }

    public final void loadUserData() {
        String userId;
        User X = g.f52734a.X();
        if (X == null || (userId = X.userId()) == null) {
            return;
        }
        NetworkClient networkClient = NetworkClient.f11868a;
        Disposable disposed = networkClient.N().C().flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<ProfileInfoResult, p>() { // from class: com.cupidapp.live.setting.viewmodel.UserInfoContainerViewModel$loadUserData$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(ProfileInfoResult profileInfoResult) {
                m2813invoke(profileInfoResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2813invoke(ProfileInfoResult profileInfoResult) {
                MutableLiveData mutableLiveData;
                MutableLiveData mutableLiveData2;
                MutableLiveData mutableLiveData3;
                MutableLiveData mutableLiveData4;
                MutableLiveData mutableLiveData5;
                MutableLiveData mutableLiveData6;
                MutableLiveData mutableLiveData7;
                MutableLiveData mutableLiveData8;
                MutableLiveData mutableLiveData9;
                ProfileInfoResult profileInfoResult2 = profileInfoResult;
                mutableLiveData = UserInfoContainerViewModel.this._luckyScoreLiveData;
                mutableLiveData.setValue(profileInfoResult2.getTodayLuckyScore());
                mutableLiveData2 = UserInfoContainerViewModel.this._valueEquityTopLiveData;
                mutableLiveData2.setValue(profileInfoResult2.getValueEquityTopList());
                mutableLiveData3 = UserInfoContainerViewModel.this._featuredServicesListLiveData;
                mutableLiveData3.setValue(profileInfoResult2.getFeaturedServicesList());
                mutableLiveData4 = UserInfoContainerViewModel.this._entranceListLiveData;
                mutableLiveData4.setValue(profileInfoResult2.getOutFunctionList());
                mutableLiveData5 = UserInfoContainerViewModel.this._profilePasterAdLiveData;
                mutableLiveData5.setValue(profileInfoResult2.getProfilePasterAd());
                List<AdModel> ad2 = profileInfoResult2.getAd();
                if (ad2 == null || ad2.isEmpty()) {
                    mutableLiveData9 = UserInfoContainerViewModel.this._adLiveData;
                    mutableLiveData9.setValue(new Pair(null, profileInfoResult2.getAdMoreUrl()));
                } else {
                    mutableLiveData6 = UserInfoContainerViewModel.this._adLiveData;
                    mutableLiveData6.setValue(new Pair(new AdViewModel(profileInfoResult2.getAd()), profileInfoResult2.getAdMoreUrl()));
                }
                UserInfoContainerViewModel userInfoContainerViewModel = UserInfoContainerViewModel.this;
                List<List<InnerFunctionModel>> innerFunction = profileInfoResult2.getInnerFunction();
                if (innerFunction == null) {
                    innerFunction = new ArrayList<>();
                }
                userInfoContainerViewModel.innerFunctions = innerFunction;
                mutableLiveData7 = UserInfoContainerViewModel.this._marketingSpotData;
                mutableLiveData7.setValue(profileInfoResult2.getMarketingSpot());
                mutableLiveData8 = UserInfoContainerViewModel.this._matchListGuideLiveData;
                mutableLiveData8.setValue(new Event(new Pair(profileInfoResult2.getMatchListGuideName(), profileInfoResult2.getMatchListGuideContent())));
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
        Disposable disposed2 = a.C0836a.z(networkClient.N(), userId, null, null, false, null, 30, null).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<ProfileResult, p>() { // from class: com.cupidapp.live.setting.viewmodel.UserInfoContainerViewModel$loadUserData$$inlined$handle$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(ProfileResult profileResult) {
                m2812invoke(profileResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2812invoke(ProfileResult profileResult) {
                MutableLiveData mutableLiveData;
                MutableLiveData mutableLiveData2;
                ProfileResult profileResult2 = profileResult;
                g.f52734a.A2(profileResult2.getUser());
                mutableLiveData = UserInfoContainerViewModel.this._userLiveData;
                mutableLiveData.setValue(profileResult2.getUser());
                mutableLiveData2 = UserInfoContainerViewModel.this._editInfoPromptData;
                mutableLiveData2.setValue(new EditInfoPromptModel(profileResult2.getUser().getInfoProgress(), profileResult2.getUser().getShowStoryLabel(), profileResult2.getUser().getStoryLabelList()));
                UserInfoContainerViewModel.this.mIsInitializedUserData = true;
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.setting.viewmodel.UserInfoContainerViewModel$loadUserData$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                boolean z10;
                s.i(it, "it");
                z10 = UserInfoContainerViewModel.this.mIsInitializedUserData;
                UserInfoContainerViewModel.this.mIsInitializedUserData = true;
                return Boolean.valueOf(z10);
            }
        }, null)));
        if (disposed2 != null) {
            s.h(disposed2, "disposed");
        }
        s.h(disposed2, "disposed");
    }

    public final void loadUserTasks() {
        Disposable disposed = NetworkClient.f11868a.N().A().flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<ProfileTaskResult, p>() { // from class: com.cupidapp.live.setting.viewmodel.UserInfoContainerViewModel$loadUserTasks$$inlined$handle$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(ProfileTaskResult profileTaskResult) {
                m2814invoke(profileTaskResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2814invoke(ProfileTaskResult profileTaskResult) {
                MutableLiveData mutableLiveData;
                mutableLiveData = UserInfoContainerViewModel.this._userTasksLiveData;
                mutableLiveData.setValue(profileTaskResult);
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.setting.viewmodel.UserInfoContainerViewModel$loadUserTasks$2
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                s.i(it, "it");
                return Boolean.TRUE;
            }
        }, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    public final void setMSwitchAccountResult(@Nullable SwitchAccountResult switchAccountResult) {
        this.mSwitchAccountResult = switchAccountResult;
    }
}
