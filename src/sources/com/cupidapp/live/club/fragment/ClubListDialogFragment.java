package com.cupidapp.live.club.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.club.activity.ClubChatActivity;
import com.cupidapp.live.club.adapter.ClubListDialogAdapter;
import com.cupidapp.live.club.model.ClubModel;
import com.cupidapp.live.club.viewmodel.ClubListViewModel;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.u;

/* compiled from: ClubListDialogFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ClubListDialogFragment extends BaseBottomSheetDialogFragment {

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public static final a f13571h = new a(null);

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public final Lazy f13572e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public final Lazy f13573f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f13574g = new LinkedHashMap();

    /* compiled from: ClubListDialogFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull FragmentManager manager, @NotNull String userId, @NotNull String userName) {
            kotlin.jvm.internal.s.i(manager, "manager");
            kotlin.jvm.internal.s.i(userId, "userId");
            kotlin.jvm.internal.s.i(userName, "userName");
            ClubListDialogFragment clubListDialogFragment = new ClubListDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putString("USER_ID", userId);
            bundle.putString("USER_NAME", userName);
            clubListDialogFragment.setArguments(bundle);
            clubListDialogFragment.show(manager, ClubListDialogFragment.class.getSimpleName());
        }
    }

    public ClubListDialogFragment() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.cupidapp.live.club.fragment.ClubListDialogFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        this.f13572e = FragmentViewModelLazyKt.createViewModelLazy(this, v.b(ClubListViewModel.class), new Function0<ViewModelStore>() { // from class: com.cupidapp.live.club.fragment.ClubListDialogFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) Function0.this.invoke()).getViewModelStore();
                kotlin.jvm.internal.s.h(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, null);
        this.f13573f = kotlin.c.b(new Function0<ClubListDialogAdapter>() { // from class: com.cupidapp.live.club.fragment.ClubListDialogFragment$clubListAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ClubListDialogAdapter invoke() {
                ClubListDialogAdapter clubListDialogAdapter = new ClubListDialogAdapter();
                final ClubListDialogFragment clubListDialogFragment = ClubListDialogFragment.this;
                clubListDialogAdapter.l().g(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.club.fragment.ClubListDialogFragment$clubListAdapter$2$1$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                        invoke2(obj);
                        return kotlin.p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable Object obj) {
                        ClubListDialogFragment.this.dismiss();
                        if (obj instanceof ClubModel) {
                            ClubModel clubModel = (ClubModel) obj;
                            if (kotlin.jvm.internal.s.d(clubModel.getJoined(), Boolean.TRUE)) {
                                ClubChatActivity.f13469x.a(ClubListDialogFragment.this.getContext(), clubModel.getGroupId());
                            } else {
                                j.a.b(com.cupidapp.live.base.router.j.f12156c, ClubListDialogFragment.this.getContext(), clubModel.getJumpUrl(), null, 4, null);
                            }
                        }
                    }
                });
                return clubListDialogAdapter;
            }
        });
    }

    public static final void a1(ClubListDialogFragment this$0, List list) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        this$0.X0().e(list);
        this$0.X0().notifyDataSetChanged();
    }

    @Override // com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment
    public void O0() {
        this.f13574g.clear();
    }

    @Nullable
    public View W0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f13574g;
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

    public final ClubListDialogAdapter X0() {
        return (ClubListDialogAdapter) this.f13573f.getValue();
    }

    public final ClubListViewModel Y0() {
        return (ClubListViewModel) this.f13572e.getValue();
    }

    public final void Z0() {
        Y0().getClubListDialogLiveData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.club.fragment.q
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ClubListDialogFragment.a1(ClubListDialogFragment.this, (List) obj);
            }
        });
    }

    public final void b1() {
        String string;
        int i10 = R$id.club_list_recyclerview;
        RecyclerView club_list_recyclerview = (RecyclerView) W0(i10);
        kotlin.jvm.internal.s.h(club_list_recyclerview, "club_list_recyclerview");
        U0(club_list_recyclerview);
        int i11 = R$id.club_list_title_textview;
        TextView club_list_title_textview = (TextView) W0(i11);
        kotlin.jvm.internal.s.h(club_list_title_textview, "club_list_title_textview");
        u.a(club_list_title_textview);
        Bundle arguments = getArguments();
        String string2 = arguments != null ? arguments.getString("USER_NAME") : null;
        TextView textView = (TextView) W0(i11);
        Object[] objArr = new Object[1];
        objArr[0] = string2 != null ? z0.t.p(string2, 10, null, 2, null) : null;
        textView.setText(getString(R$string.others_club, objArr));
        RecyclerView recyclerView = (RecyclerView) W0(i10);
        recyclerView.setAdapter(X0());
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 1, false));
        Bundle arguments2 = getArguments();
        if (arguments2 == null || (string = arguments2.getString("USER_ID")) == null) {
            return;
        }
        Y0().getClubListDialogData(string);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        kotlin.jvm.internal.s.i(inflater, "inflater");
        return inflater.inflate(R$layout.fragment_club_list_dialog, viewGroup, false);
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
        kotlin.jvm.internal.s.i(view, "view");
        super.onViewCreated(view, bundle);
        b1();
        Z0();
    }
}
