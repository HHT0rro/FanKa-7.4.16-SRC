package com.cupidapp.live.liveshow.pk.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.sensorslog.SensorsLogLiveShow;
import com.cupidapp.live.liveshow.constants.FKLiveConstantsData;
import com.cupidapp.live.liveshow.model.LivePkFriendListResult;
import com.cupidapp.live.liveshow.model.LivePkRequestResult;
import com.cupidapp.live.liveshow.model.LivePkUserModel;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import com.cupidapp.live.liveshow.pk.adapter.FKLivePkFriendListAdapter;
import com.cupidapp.live.liveshow.pk.adapter.LivePkEmptyListModel;
import com.cupidapp.live.liveshow.pk.fragment.FKLivePkFriendListFragment;
import com.cupidapp.live.liveshow.view.miniprofile.ShowLiveMiniProfileViewModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.c;
import kotlin.collections.i0;
import kotlin.d;
import kotlin.f;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;

/* compiled from: FKLivePkFriendListFragment.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLivePkFriendListFragment extends BaseBottomSheetDialogFragment {

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public static final a f15114h = new a(null);

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public b f15115e;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15117g = new LinkedHashMap();

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public final Lazy f15116f = c.b(new Function0<FKLivePkFriendListAdapter>() { // from class: com.cupidapp.live.liveshow.pk.fragment.FKLivePkFriendListFragment$pkFriendListAdapter$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final FKLivePkFriendListAdapter invoke() {
            FKLivePkFriendListAdapter fKLivePkFriendListAdapter = new FKLivePkFriendListAdapter();
            final FKLivePkFriendListFragment fKLivePkFriendListFragment = FKLivePkFriendListFragment.this;
            fKLivePkFriendListAdapter.l().j(i0.h(f.a(Integer.valueOf(R$id.friendAvatarLayout), new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.pk.fragment.FKLivePkFriendListFragment$pkFriendListAdapter$2$1$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(Object obj) {
                    invoke2(obj);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable Object obj) {
                    if (obj instanceof LivePkUserModel) {
                        FKLivePkFriendListFragment.this.j1((LivePkUserModel) obj);
                    }
                }
            }), f.a(Integer.valueOf(R$id.friendNameTextView), new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.pk.fragment.FKLivePkFriendListFragment$pkFriendListAdapter$2$1$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(Object obj) {
                    invoke2(obj);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable Object obj) {
                    if (obj instanceof LivePkUserModel) {
                        FKLivePkFriendListFragment.this.j1((LivePkUserModel) obj);
                    }
                }
            }), f.a(Integer.valueOf(R$id.challengeFriendButton), new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.pk.fragment.FKLivePkFriendListFragment$pkFriendListAdapter$2$1$3
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(Object obj) {
                    invoke2(obj);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable final Object obj) {
                    if (obj instanceof LivePkUserModel) {
                        FKLivePkFriendListFragment fKLivePkFriendListFragment2 = FKLivePkFriendListFragment.this;
                        String id2 = ((LivePkUserModel) obj).getId();
                        final FKLivePkFriendListFragment fKLivePkFriendListFragment3 = FKLivePkFriendListFragment.this;
                        fKLivePkFriendListFragment2.e1(id2, new Function1<Integer, p>() { // from class: com.cupidapp.live.liveshow.pk.fragment.FKLivePkFriendListFragment$pkFriendListAdapter$2$1$3.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ p invoke(Integer num) {
                                invoke(num.intValue());
                                return p.f51048a;
                            }

                            public final void invoke(int i10) {
                                FKLivePkFriendListFragment.b bVar;
                                SensorsLogLiveShow.f12212a.r(SensorsLogLiveShow.PkRequestType.ChallengeFriends);
                                FKLivePkFriendListFragment.this.dismiss();
                                bVar = FKLivePkFriendListFragment.this.f15115e;
                                if (bVar != null) {
                                    bVar.b((LivePkUserModel) obj, i10);
                                }
                            }
                        });
                    }
                }
            })));
            return fKLivePkFriendListAdapter;
        }
    });

    /* compiled from: FKLivePkFriendListFragment.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final FKLivePkFriendListFragment a(@Nullable FragmentManager fragmentManager, @NotNull b listener) {
            s.i(listener, "listener");
            if (fragmentManager == null) {
                return null;
            }
            FKLivePkFriendListFragment fKLivePkFriendListFragment = new FKLivePkFriendListFragment();
            fKLivePkFriendListFragment.f15115e = listener;
            fKLivePkFriendListFragment.show(fragmentManager, FKLivePkFriendListFragment.class.getSimpleName());
            return fKLivePkFriendListFragment;
        }
    }

    /* compiled from: FKLivePkFriendListFragment.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface b {
        void a();

        void b(@NotNull LivePkUserModel livePkUserModel, int i10);
    }

    @Override // com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment
    public void O0() {
        this.f15117g.clear();
    }

    @Nullable
    public View V0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f15117g;
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

    public final void d1() {
        ImageView backView = (ImageView) V0(R$id.backView);
        s.h(backView, "backView");
        y.d(backView, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.pk.fragment.FKLivePkFriendListFragment$bindClickEvent$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(View view) {
                invoke2(view);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                FKLivePkFriendListFragment.b bVar;
                FKLivePkFriendListFragment.this.dismiss();
                bVar = FKLivePkFriendListFragment.this.f15115e;
                if (bVar != null) {
                    bVar.a();
                }
            }
        });
        ImageView notAcceptButton = (ImageView) V0(R$id.notAcceptButton);
        s.h(notAcceptButton, "notAcceptButton");
        y.d(notAcceptButton, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.pk.fragment.FKLivePkFriendListFragment$bindClickEvent$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(View view) {
                invoke2(view);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                FKLivePkFriendListFragment fKLivePkFriendListFragment = FKLivePkFriendListFragment.this;
                fKLivePkFriendListFragment.i1(((ImageView) fKLivePkFriendListFragment.V0(R$id.notAcceptButton)).isSelected());
            }
        });
    }

    public final void e1(String str, final Function1<? super Integer, p> function1) {
        String itemId;
        LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
        if (liveShowModel == null || (itemId = liveShowModel.getItemId()) == null) {
            return;
        }
        Disposable disposed = NetworkClient.f11868a.r().K0(itemId, str, false).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<LivePkRequestResult, p>() { // from class: com.cupidapp.live.liveshow.pk.fragment.FKLivePkFriendListFragment$challengeFriend$$inlined$handle$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(LivePkRequestResult livePkRequestResult) {
                m2625invoke(livePkRequestResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2625invoke(LivePkRequestResult livePkRequestResult) {
                LivePkRequestResult livePkRequestResult2 = livePkRequestResult;
                Function1 function12 = Function1.this;
                if (function12 != null) {
                    function12.invoke(Integer.valueOf(livePkRequestResult2.getWaitSec()));
                }
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.liveshow.pk.fragment.FKLivePkFriendListFragment$challengeFriend$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                s.i(it, "it");
                FKLivePkFriendListFragment.this.f1();
                return Boolean.FALSE;
            }
        }, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    public final void f1() {
        String itemId;
        LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
        if (liveShowModel == null || (itemId = liveShowModel.getItemId()) == null) {
            return;
        }
        Disposable disposed = NetworkClient.f11868a.r().r(itemId).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<LivePkFriendListResult, p>() { // from class: com.cupidapp.live.liveshow.pk.fragment.FKLivePkFriendListFragment$getPkFriendList$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(LivePkFriendListResult livePkFriendListResult) {
                m2626invoke(livePkFriendListResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2626invoke(LivePkFriendListResult livePkFriendListResult) {
                FKLivePkFriendListAdapter g12;
                FKLivePkFriendListAdapter g13;
                FKLivePkFriendListAdapter g14;
                FKLivePkFriendListAdapter g15;
                FKLivePkFriendListAdapter g16;
                LivePkFriendListResult livePkFriendListResult2 = livePkFriendListResult;
                boolean z10 = true;
                ((ImageView) FKLivePkFriendListFragment.this.V0(R$id.notAcceptButton)).setSelected(!livePkFriendListResult2.getAppointAccept());
                g12 = FKLivePkFriendListFragment.this.g1();
                g12.j().clear();
                List<LivePkUserModel> friendList = livePkFriendListResult2.getFriendList();
                if (!(friendList == null || friendList.isEmpty())) {
                    g16 = FKLivePkFriendListFragment.this.g1();
                    g16.e(livePkFriendListResult2.getFriendList());
                } else {
                    List<LivePkUserModel> requestList = livePkFriendListResult2.getRequestList();
                    if (requestList != null && !requestList.isEmpty()) {
                        z10 = false;
                    }
                    if (!z10) {
                        g14 = FKLivePkFriendListFragment.this.g1();
                        g14.e(livePkFriendListResult2.getRequestList());
                    } else {
                        g13 = FKLivePkFriendListFragment.this.g1();
                        String string = FKLivePkFriendListFragment.this.getString(R$string.no_friends_to_invite);
                        s.h(string, "getString(R.string.no_friends_to_invite)");
                        g13.d(new LivePkEmptyListModel(string));
                    }
                }
                g15 = FKLivePkFriendListFragment.this.g1();
                g15.notifyDataSetChanged();
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    public final FKLivePkFriendListAdapter g1() {
        return (FKLivePkFriendListAdapter) this.f15116f.getValue();
    }

    public final void h1() {
        int i10 = R$id.challengeFriendsRecyclerView;
        RecyclerView recyclerView = (RecyclerView) V0(i10);
        recyclerView.setAdapter(g1());
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 1, false));
        RecyclerView challengeFriendsRecyclerView = (RecyclerView) V0(i10);
        s.h(challengeFriendsRecyclerView, "challengeFriendsRecyclerView");
        U0(challengeFriendsRecyclerView);
    }

    public final void i1(final boolean z10) {
        String itemId;
        LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
        if (liveShowModel == null || (itemId = liveShowModel.getItemId()) == null) {
            return;
        }
        Disposable disposed = NetworkClient.f11868a.r().M0(itemId, z10).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.pk.fragment.FKLivePkFriendListFragment$notAcceptLivePk$$inlined$handle$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                ((ImageView) FKLivePkFriendListFragment.this.V0(R$id.notAcceptButton)).setSelected(!z10);
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    public final void j1(LivePkUserModel livePkUserModel) {
        EventBus.c().l(new ShowLiveMiniProfileViewModel(livePkUserModel.getUser().userId(), null, null, false, false, false, 62, null));
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        s.i(inflater, "inflater");
        return inflater.inflate(R$layout.fragment_live_pk_friend_list, viewGroup, false);
    }

    @Override // com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        O0();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        R0(3, true);
    }

    @Override // com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        s.i(view, "view");
        super.onViewCreated(view, bundle);
        Dialog dialog = getDialog();
        if (dialog != null) {
            z0.d.g(dialog, 0.0f);
        }
        h1();
        d1();
        f1();
    }
}
