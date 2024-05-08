package com.cupidapp.live.login.viewmodel;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.cupidapp.live.base.extension.ImageAttributeModel;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.network.j;
import com.cupidapp.live.base.network.model.ProfileResult;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.network.model.StateResult;
import com.cupidapp.live.base.network.model.UploadImageFileResult;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorsLogAccount;
import com.cupidapp.live.base.sensorslog.SensorsLogFeed;
import com.cupidapp.live.login.helper.LoginMethod;
import com.cupidapp.live.login.viewmodel.CompleteInfoViewModel;
import com.cupidapp.live.main.model.UserModifyResult;
import com.cupidapp.live.profile.model.CompatResult;
import com.cupidapp.live.profile.model.ProfileComplementResult;
import com.cupidapp.live.profile.model.ProfileSpecListModel;
import com.cupidapp.live.profile.model.ProfileSpecModifyResult;
import com.cupidapp.live.profile.model.User;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.io.File;
import java.util.concurrent.TimeUnit;
import kotlin.collections.r;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import okhttp3.FormBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p1.g;
import x2.a;
import z0.f;
import z0.l;

/* compiled from: CompleteInfoViewModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class CompleteInfoViewModel extends ViewModel {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @Nullable
    private static String accountSign;

    @Nullable
    private static LoginMethod loginMethod;

    @Nullable
    private static Boolean showSkipButton;

    @NotNull
    private final MutableLiveData<ProfileSpecListModel> _birthdayRangeLiveData;

    @NotNull
    private final MutableLiveData<StateResult<Boolean>> _completeInfoLiveData;

    @NotNull
    private final MutableLiveData<StateResult<String>> _saveBirthdayLiveData;

    @NotNull
    private final MutableLiveData<StateResult<String>> _saveNickNameLiveData;

    @NotNull
    private final LiveData<ProfileSpecListModel> birthdayRangeLiveData;

    @NotNull
    private final LiveData<StateResult<Boolean>> completeInfoLiveData;

    @NotNull
    private final LiveData<StateResult<String>> saveBirthdayLiveData;

    @NotNull
    private final LiveData<StateResult<String>> saveNickNameLiveData;
    private long uploadStartTime;

    /* compiled from: CompleteInfoViewModel.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final Boolean a() {
            return CompleteInfoViewModel.showSkipButton;
        }

        public final void b(@Nullable String str) {
            CompleteInfoViewModel.accountSign = str;
        }

        public final void c(@Nullable LoginMethod loginMethod) {
            CompleteInfoViewModel.loginMethod = loginMethod;
        }
    }

    public CompleteInfoViewModel() {
        MutableLiveData<StateResult<String>> mutableLiveData = new MutableLiveData<>();
        this._saveNickNameLiveData = mutableLiveData;
        this.saveNickNameLiveData = mutableLiveData;
        MutableLiveData<ProfileSpecListModel> mutableLiveData2 = new MutableLiveData<>();
        this._birthdayRangeLiveData = mutableLiveData2;
        this.birthdayRangeLiveData = mutableLiveData2;
        MutableLiveData<StateResult<String>> mutableLiveData3 = new MutableLiveData<>();
        this._saveBirthdayLiveData = mutableLiveData3;
        this.saveBirthdayLiveData = mutableLiveData3;
        MutableLiveData<StateResult<Boolean>> mutableLiveData4 = new MutableLiveData<>();
        this._completeInfoLiveData = mutableLiveData4;
        this.completeInfoLiveData = mutableLiveData4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getUserData(final boolean z10) {
        String userId;
        User X = g.f52734a.X();
        if (X == null || (userId = X.userId()) == null) {
            return;
        }
        Disposable disposed = a.C0836a.z(NetworkClient.f11868a.N(), userId, null, null, false, null, 30, null).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<ProfileResult, p>() { // from class: com.cupidapp.live.login.viewmodel.CompleteInfoViewModel$getUserData$$inlined$handle$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(ProfileResult profileResult) {
                m2672invoke(profileResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2672invoke(ProfileResult profileResult) {
                MutableLiveData mutableLiveData;
                g.f52734a.A2(profileResult.getUser());
                mutableLiveData = CompleteInfoViewModel.this._completeInfoLiveData;
                mutableLiveData.setValue(new StateResult.c(Boolean.valueOf(z10), null, 2, null));
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.login.viewmodel.CompleteInfoViewModel$getUserData$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                MutableLiveData mutableLiveData;
                s.i(it, "it");
                mutableLiveData = CompleteInfoViewModel.this._completeInfoLiveData;
                mutableLiveData.setValue(new StateResult.a(null, null, null, 7, null));
                return Boolean.FALSE;
            }
        }, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sensorsUploadFile(long j10, int i10, int i11, Throwable th, String str, String str2) {
        String str3;
        long currentTimeMillis = System.currentTimeMillis() - this.uploadStartTime;
        SensorsLogFeed sensorsLogFeed = SensorsLogFeed.f12208a;
        SensorsLogFeed.UploadFileType uploadFileType = SensorsLogFeed.UploadFileType.AVATAR;
        SensorPosition sensorPosition = SensorPosition.RegisterImageCrop;
        boolean z10 = th == null;
        String a10 = j.f12008a.a(th);
        if (a10 == null) {
            str3 = th != null ? th.getMessage() : null;
        } else {
            str3 = a10;
        }
        sensorsLogFeed.O(currentTimeMillis, j10, i10, i11, uploadFileType, "图片", sensorPosition, z10, str3, (r33 & 512) != 0 ? null : str, (r33 & 1024) != 0 ? null : null, (r33 & 2048) != 0 ? null : str2);
    }

    public final void getBirthdayRange() {
        Disposable disposed = NetworkClient.f11868a.N().s0().flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<ProfileComplementResult, p>() { // from class: com.cupidapp.live.login.viewmodel.CompleteInfoViewModel$getBirthdayRange$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(ProfileComplementResult profileComplementResult) {
                m2671invoke(profileComplementResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2671invoke(ProfileComplementResult profileComplementResult) {
                MutableLiveData mutableLiveData;
                mutableLiveData = CompleteInfoViewModel.this._birthdayRangeLiveData;
                mutableLiveData.setValue(profileComplementResult.getBirthday());
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    @NotNull
    public final LiveData<ProfileSpecListModel> getBirthdayRangeLiveData() {
        return this.birthdayRangeLiveData;
    }

    @NotNull
    public final LiveData<StateResult<Boolean>> getCompleteInfoLiveData() {
        return this.completeInfoLiveData;
    }

    @NotNull
    public final LiveData<StateResult<String>> getSaveBirthdayLiveData() {
        return this.saveBirthdayLiveData;
    }

    @NotNull
    public final LiveData<StateResult<String>> getSaveNickNameLiveData() {
        return this.saveNickNameLiveData;
    }

    public final void saveAvatar(@Nullable final String str) {
        FormBody.Builder builder = new FormBody.Builder(null, 1, null);
        if (str != null) {
            builder.add("avatarImageId", str);
        }
        builder.add("deviceId", com.cupidapp.live.base.safe.e.f12185a.a());
        Disposable disposed = NetworkClient.f11868a.N().y(builder.build()).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<CompatResult, p>() { // from class: com.cupidapp.live.login.viewmodel.CompleteInfoViewModel$saveAvatar$$inlined$handle$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(CompatResult compatResult) {
                m2673invoke(compatResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2673invoke(CompatResult compatResult) {
                String str2;
                LoginMethod loginMethod2;
                CompleteInfoViewModel.this.getUserData(str != null);
                SensorsLogAccount sensorsLogAccount = SensorsLogAccount.f12205a;
                str2 = CompleteInfoViewModel.accountSign;
                loginMethod2 = CompleteInfoViewModel.loginMethod;
                sensorsLogAccount.l(str2, loginMethod2);
                CompleteInfoViewModel.Companion companion = CompleteInfoViewModel.Companion;
                CompleteInfoViewModel.accountSign = null;
                CompleteInfoViewModel.loginMethod = null;
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.login.viewmodel.CompleteInfoViewModel$saveAvatar$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                MutableLiveData mutableLiveData;
                s.i(it, "it");
                mutableLiveData = CompleteInfoViewModel.this._completeInfoLiveData;
                mutableLiveData.setValue(new StateResult.a(null, null, null, 7, null));
                return Boolean.FALSE;
            }
        }, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    public final void saveBirthday(@NotNull final String birthday) {
        String itemId;
        s.i(birthday, "birthday");
        ProfileSpecListModel value = this._birthdayRangeLiveData.getValue();
        if (value == null || (itemId = value.getItemId()) == null) {
            return;
        }
        this._saveBirthdayLiveData.setValue(new StateResult.b(null, null, 3, null));
        Observable<Result<ProfileSpecModifyResult>> delay = NetworkClient.f11868a.N().r0(itemId, r.e(birthday)).delay(600L, TimeUnit.MILLISECONDS);
        s.h(delay, "NetworkClient.userServic…S, TimeUnit.MILLISECONDS)");
        Disposable disposed = delay.flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<ProfileSpecModifyResult, p>() { // from class: com.cupidapp.live.login.viewmodel.CompleteInfoViewModel$saveBirthday$$inlined$handle$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(ProfileSpecModifyResult profileSpecModifyResult) {
                m2674invoke(profileSpecModifyResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2674invoke(ProfileSpecModifyResult profileSpecModifyResult) {
                MutableLiveData mutableLiveData;
                mutableLiveData = CompleteInfoViewModel.this._saveBirthdayLiveData;
                mutableLiveData.setValue(new StateResult.c(birthday, null, 2, null));
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.login.viewmodel.CompleteInfoViewModel$saveBirthday$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                MutableLiveData mutableLiveData;
                s.i(it, "it");
                mutableLiveData = CompleteInfoViewModel.this._saveBirthdayLiveData;
                mutableLiveData.setValue(new StateResult.a(null, null, null, 7, null));
                return Boolean.FALSE;
            }
        }, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    public final void saveNickName(@NotNull final String nickName) {
        s.i(nickName, "nickName");
        this._saveNickNameLiveData.setValue(new StateResult.b(null, null, 3, null));
        Observable delay = a.C0836a.y(NetworkClient.f11868a.N(), nickName, null, 2, null).delay(600L, TimeUnit.MILLISECONDS);
        s.h(delay, "NetworkClient.userServic…S, TimeUnit.MILLISECONDS)");
        Disposable disposed = delay.flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<UserModifyResult, p>() { // from class: com.cupidapp.live.login.viewmodel.CompleteInfoViewModel$saveNickName$$inlined$handle$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(UserModifyResult userModifyResult) {
                m2675invoke(userModifyResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2675invoke(UserModifyResult userModifyResult) {
                MutableLiveData mutableLiveData;
                CompleteInfoViewModel.Companion companion = CompleteInfoViewModel.Companion;
                CompleteInfoViewModel.showSkipButton = userModifyResult.getShowSkipButton();
                mutableLiveData = CompleteInfoViewModel.this._saveNickNameLiveData;
                mutableLiveData.setValue(new StateResult.c(nickName, null, 2, null));
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.login.viewmodel.CompleteInfoViewModel$saveNickName$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                MutableLiveData mutableLiveData;
                s.i(it, "it");
                mutableLiveData = CompleteInfoViewModel.this._saveNickNameLiveData;
                mutableLiveData.setValue(new StateResult.a(null, null, null, 7, null));
                return Boolean.FALSE;
            }
        }, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    public final void uploadAvatar(@NotNull Context context, @NotNull File file, boolean z10, @Nullable final String str) {
        s.i(context, "context");
        s.i(file, "file");
        this._completeInfoLiveData.setValue(new StateResult.b(null, null, 3, null));
        this.uploadStartTime = System.currentTimeMillis();
        final long a10 = l.a(file);
        ImageAttributeModel l10 = f.l(context, file.getPath());
        final int width = l10.getWidth();
        final int height = l10.getHeight();
        Observable<Result<UploadImageFileResult>> delay = NetworkClient.f11868a.i().f(com.cupidapp.live.base.network.f.a(file), Boolean.valueOf(z10)).delay(600L, TimeUnit.MILLISECONDS);
        s.h(delay, "NetworkClient.commonServ…S, TimeUnit.MILLISECONDS)");
        Disposable disposed = delay.flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<UploadImageFileResult, p>() { // from class: com.cupidapp.live.login.viewmodel.CompleteInfoViewModel$uploadAvatar$$inlined$handle$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(UploadImageFileResult uploadImageFileResult) {
                m2676invoke(uploadImageFileResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2676invoke(UploadImageFileResult uploadImageFileResult) {
                UploadImageFileResult uploadImageFileResult2 = uploadImageFileResult;
                CompleteInfoViewModel.this.saveAvatar(uploadImageFileResult2.getImage().getImageId());
                CompleteInfoViewModel.this.sensorsUploadFile(a10, width, height, null, uploadImageFileResult2.getImage().getImageId(), str);
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.login.viewmodel.CompleteInfoViewModel$uploadAvatar$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                MutableLiveData mutableLiveData;
                s.i(it, "it");
                mutableLiveData = CompleteInfoViewModel.this._completeInfoLiveData;
                mutableLiveData.setValue(new StateResult.a(null, null, null, 7, null));
                CompleteInfoViewModel.this.sensorsUploadFile(a10, width, height, it, null, str);
                return Boolean.FALSE;
            }
        }, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }
}
