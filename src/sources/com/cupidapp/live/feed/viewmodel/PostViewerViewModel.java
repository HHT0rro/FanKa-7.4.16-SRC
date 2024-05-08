package com.cupidapp.live.feed.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.android.internal.logging.nano.MetricsProto;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.network.model.ListResult;
import com.cupidapp.live.base.recyclerview.model.FKEmptyViewModel;
import com.cupidapp.live.base.recyclerview.model.FKFooterViewModel;
import com.cupidapp.live.profile.model.User;
import f2.a;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.collections.s;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.z;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PostViewerViewModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class PostViewerViewModel extends ViewModel {

    @NotNull
    private final MutableLiveData<List<Object>> _viewerLiveData;

    @Nullable
    private String nextCursorId;

    @NotNull
    private final LiveData<List<Object>> viewerLiveData;

    public PostViewerViewModel() {
        MutableLiveData<List<Object>> mutableLiveData = new MutableLiveData<>();
        this._viewerLiveData = mutableLiveData;
        this.viewerLiveData = mutableLiveData;
    }

    private final void loadViewerList(String str) {
        Disposable disposed = a.C0731a.o(NetworkClient.f11868a.l(), str, this.nextCursorId, 0, 4, null).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<ListResult<User>, p>() { // from class: com.cupidapp.live.feed.viewmodel.PostViewerViewModel$loadViewerList$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(ListResult<User> listResult) {
                m2587invoke(listResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2587invoke(ListResult<User> listResult) {
                String str2;
                MutableLiveData mutableLiveData;
                String str3;
                MutableLiveData mutableLiveData2;
                MutableLiveData mutableLiveData3;
                ListResult<User> listResult2 = listResult;
                str2 = PostViewerViewModel.this.nextCursorId;
                if (str2 == null || str2.length() == 0) {
                    List<User> list = listResult2.getList();
                    if (list == null || list.isEmpty()) {
                        mutableLiveData3 = PostViewerViewModel.this._viewerLiveData;
                        mutableLiveData3.setValue(s.o(new FKEmptyViewModel(null, Integer.valueOf(R$string.no_viewer), null, -5658199, null, null, Float.valueOf(16.0f), false, null, null, MetricsProto.MetricsEvent.FIELD_AUTOFILL_FORGED_COMPONENT_NAME, null)));
                        PostViewerViewModel.this.nextCursorId = listResult2.getNextCursorId();
                    }
                }
                mutableLiveData = PostViewerViewModel.this._viewerLiveData;
                T value = mutableLiveData.getValue();
                Object obj = null;
                List list2 = z.l(value) ? (List) value : null;
                if (list2 == null) {
                    list2 = new ArrayList();
                }
                str3 = PostViewerViewModel.this.nextCursorId;
                if (str3 == null) {
                    List<User> list3 = listResult2.getList();
                    if (list3 != null) {
                        list2.clear();
                        list2.addAll(list3);
                    }
                } else {
                    List<User> list4 = listResult2.getList();
                    if (list4 != null) {
                        list2.addAll(list4);
                    }
                }
                ListIterator listIterator = list2.listIterator(list2.size());
                while (true) {
                    if (!listIterator.hasPrevious()) {
                        break;
                    }
                    Object previous = listIterator.previous();
                    if (previous instanceof FKFooterViewModel) {
                        obj = previous;
                        break;
                    }
                }
                if (obj != null) {
                    list2.remove(obj);
                }
                String nextCursorId = listResult2.getNextCursorId();
                if (!(nextCursorId == null || nextCursorId.length() == 0)) {
                    list2.add(new FKFooterViewModel(false, false, null, 0, 0, 0, 63, null));
                }
                mutableLiveData2 = PostViewerViewModel.this._viewerLiveData;
                mutableLiveData2.setValue(list2);
                PostViewerViewModel.this.nextCursorId = listResult2.getNextCursorId();
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object] */
    public final void changeUser(@NotNull User user) {
        User user2;
        kotlin.jvm.internal.s.i(user, "user");
        List<Object> value = this._viewerLiveData.getValue();
        List<Object> list = z.l(value) ? value : null;
        if (list == null) {
            list = new ArrayList<>();
        }
        Iterator<Object> iterator2 = list.iterator2();
        while (true) {
            if (!iterator2.hasNext()) {
                user2 = 0;
                break;
            } else {
                user2 = iterator2.next();
                if ((user2 instanceof User) && kotlin.jvm.internal.s.d(((User) user2).userId(), user.userId())) {
                    break;
                }
            }
        }
        User user3 = user2 instanceof User ? user2 : null;
        if (user3 != null) {
            user3.setAloha(true);
        }
        if (user3 != null) {
            user3.setSuperLikedByMe(user.getSuperLikedByMe());
        }
        if (user3 != null) {
            user3.setSuperLikedByMeCombos(user.getSuperLikedByMeCombos());
        }
        if (user3 != null) {
            user3.setCanSendInboxMessage(user.getCanSendInboxMessage());
        }
        this._viewerLiveData.setValue(list);
    }

    @NotNull
    public final LiveData<List<Object>> getViewerLiveData() {
        return this.viewerLiveData;
    }

    public final void loadData(@NotNull String postLimitId) {
        kotlin.jvm.internal.s.i(postLimitId, "postLimitId");
        this.nextCursorId = null;
        loadViewerList(postLimitId);
    }

    public final void loadMore(@NotNull String postLimitId) {
        kotlin.jvm.internal.s.i(postLimitId, "postLimitId");
        String str = this.nextCursorId;
        if (str == null || str.length() == 0) {
            return;
        }
        loadViewerList(postLimitId);
    }
}
