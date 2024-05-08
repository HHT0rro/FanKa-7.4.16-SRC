package com.cupidapp.live.club.fragment;

import android.os.Bundle;
import android.view.View;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.fragment.FKBaseListFragment;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.model.ListResult;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import com.cupidapp.live.base.recyclerview.model.FKEmptyViewModel;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.club.adapter.ClubEnterRequestAdapter;
import com.cupidapp.live.club.model.ClubEnterRequestUserModel;
import io.reactivex.Observable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.i0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ClubEnterRequestListFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ClubEnterRequestListFragment extends FKBaseListFragment<ClubEnterRequestUserModel> {

    /* renamed from: l, reason: collision with root package name */
    @NotNull
    public static final a f13567l = new a(null);

    /* renamed from: i, reason: collision with root package name */
    public boolean f13568i;

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f13570k = new LinkedHashMap();

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    public final ClubEnterRequestAdapter f13569j = new ClubEnterRequestAdapter();

    /* compiled from: ClubEnterRequestListFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ClubEnterRequestListFragment a(@NotNull String clubId) {
            kotlin.jvm.internal.s.i(clubId, "clubId");
            ClubEnterRequestListFragment clubEnterRequestListFragment = new ClubEnterRequestListFragment();
            Bundle bundle = new Bundle();
            bundle.putString("CLUB_ENTER_REQUEST_CLUB_ID", clubId);
            clubEnterRequestListFragment.setArguments(bundle);
            return clubEnterRequestListFragment;
        }
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseListFragment, com.cupidapp.live.base.fragment.FKBaseFragment
    public void N0() {
        this.f13570k.clear();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseListFragment
    @Nullable
    public View T0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f13570k;
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

    @Override // com.cupidapp.live.base.fragment.FKBaseListFragment
    @NotNull
    public FKEmptyViewModel Z0() {
        return new FKEmptyViewModel(null, Integer.valueOf(R$string.enter_request_empty_tips), null, null, null, null, null, false, null, null, 1021, null);
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseListFragment
    @NotNull
    public FKBaseRecyclerViewAdapter d1() {
        ClubEnterRequestAdapter clubEnterRequestAdapter = this.f13569j;
        clubEnterRequestAdapter.l().j(i0.h(kotlin.f.a(Integer.valueOf(R$id.club_enter_request_to_confirm_btn), new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.club.fragment.ClubEnterRequestListFragment$getRecyclerAdapter$1$1
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
                if (obj instanceof ClubEnterRequestUserModel) {
                    j.a.b(com.cupidapp.live.base.router.j.f12156c, ClubEnterRequestListFragment.this.getContext(), ((ClubEnterRequestUserModel) obj).getJumpUrl(), null, 4, null);
                }
            }
        })));
        return clubEnterRequestAdapter;
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseListFragment
    @Nullable
    public Observable<Result<ListResult<ClubEnterRequestUserModel>>> e1(@Nullable String str) {
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("CLUB_ENTER_REQUEST_CLUB_ID") : null;
        if (string == null || string.length() == 0) {
            return null;
        }
        return NetworkClient.f11868a.u().y(string, str);
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseListFragment, com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        N0();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.f13568i) {
            l1();
        } else {
            this.f13568i = true;
        }
    }
}
