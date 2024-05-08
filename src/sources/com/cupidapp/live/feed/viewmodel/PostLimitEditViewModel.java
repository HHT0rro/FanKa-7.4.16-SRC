package com.cupidapp.live.feed.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.cupidapp.live.base.livedata.Event;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.f;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.network.j;
import com.cupidapp.live.base.network.model.StateResult;
import com.cupidapp.live.base.network.model.UploadImageFileResult;
import com.cupidapp.live.feed.model.PostLimitPublishModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.io.File;
import java.util.List;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PostLimitEditViewModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class PostLimitEditViewModel extends ViewModel {

    @NotNull
    private final MutableLiveData<Event<StateResult<PostLimitPublishModel>>> _publishResult;

    @NotNull
    private final LiveData<Event<StateResult<PostLimitPublishModel>>> publishResult;

    public PostLimitEditViewModel() {
        MutableLiveData<Event<StateResult<PostLimitPublishModel>>> mutableLiveData = new MutableLiveData<>();
        this._publishResult = mutableLiveData;
        this.publishResult = mutableLiveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void postLimitPublish(String str, List<String> list, Integer num) {
        Disposable disposed = NetworkClient.f11868a.l().C(str, list, num).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<PostLimitPublishModel, p>() { // from class: com.cupidapp.live.feed.viewmodel.PostLimitEditViewModel$postLimitPublish$$inlined$handle$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(PostLimitPublishModel postLimitPublishModel) {
                m2584invoke(postLimitPublishModel);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2584invoke(PostLimitPublishModel postLimitPublishModel) {
                MutableLiveData mutableLiveData;
                mutableLiveData = PostLimitEditViewModel.this._publishResult;
                mutableLiveData.setValue(new Event(new StateResult.c(postLimitPublishModel, null, 2, null)));
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.feed.viewmodel.PostLimitEditViewModel$postLimitPublish$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                MutableLiveData mutableLiveData;
                s.i(it, "it");
                String c4 = j.c(j.f12008a, it, false, 2, null);
                mutableLiveData = PostLimitEditViewModel.this._publishResult;
                mutableLiveData.setValue(new Event(new StateResult.a(c4, null, null, 6, null)));
                return Boolean.FALSE;
            }
        }, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    @NotNull
    public final LiveData<Event<StateResult<PostLimitPublishModel>>> getPublishResult() {
        return this.publishResult;
    }

    public final void postLimitImgUpload(@NotNull File file, boolean z10, @Nullable final List<String> list, @Nullable final Integer num) {
        s.i(file, "file");
        this._publishResult.setValue(new Event<>(new StateResult.b(null, null, 3, null)));
        Disposable disposed = NetworkClient.f11868a.i().f(f.a(file), Boolean.valueOf(z10)).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<UploadImageFileResult, p>() { // from class: com.cupidapp.live.feed.viewmodel.PostLimitEditViewModel$postLimitImgUpload$$inlined$handle$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(UploadImageFileResult uploadImageFileResult) {
                m2583invoke(uploadImageFileResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2583invoke(UploadImageFileResult uploadImageFileResult) {
                PostLimitEditViewModel.this.postLimitPublish(uploadImageFileResult.getImage().getImageId(), list, num);
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.feed.viewmodel.PostLimitEditViewModel$postLimitImgUpload$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                MutableLiveData mutableLiveData;
                s.i(it, "it");
                String c4 = j.c(j.f12008a, it, false, 2, null);
                mutableLiveData = PostLimitEditViewModel.this._publishResult;
                mutableLiveData.setValue(new Event(new StateResult.a(c4, null, null, 6, null)));
                return Boolean.FALSE;
            }
        }, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }
}
