package com.cupidapp.live.profile.fragment;

import android.view.View;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.fragment.FKBaseListFragment;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.model.ListResult;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.network.model.ViewProfilePrefer;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import com.cupidapp.live.base.recyclerview.model.FKEmptyViewModel;
import com.cupidapp.live.base.sensorslog.ProfileSensorContext;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.profile.activity.UserProfileActivity;
import com.cupidapp.live.profile.adapter.FKDontLookHimListIAdapter;
import com.cupidapp.live.profile.event.UserProfileDataChangeEvent;
import com.cupidapp.live.profile.model.User;
import io.reactivex.Observable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKDontLookHimUserListFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKDontLookHimUserListFragment extends FKBaseListFragment<User> {

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17738j = new LinkedHashMap();

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public final Lazy f17737i = kotlin.c.b(new Function0<FKDontLookHimListIAdapter>() { // from class: com.cupidapp.live.profile.fragment.FKDontLookHimUserListFragment$dontLookHimAdapter$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final FKDontLookHimListIAdapter invoke() {
            FKDontLookHimListIAdapter fKDontLookHimListIAdapter = new FKDontLookHimListIAdapter();
            final FKDontLookHimUserListFragment fKDontLookHimUserListFragment = FKDontLookHimUserListFragment.this;
            fKDontLookHimListIAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.profile.fragment.FKDontLookHimUserListFragment$dontLookHimAdapter$2$1$1
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
                    if (obj instanceof User) {
                        User user = (User) obj;
                        UserProfileActivity.G.a(FKDontLookHimUserListFragment.this.getContext(), user, new ProfileSensorContext(ViewProfilePrefer.BlackListToProfile.getValue(), null, user.getMe(), SensorPosition.BlackListPage, SensorPosition.PrivacySetting, null), (r21 & 8) != 0 ? false : true, (r21 & 16) != 0 ? null : null, (r21 & 32) != 0 ? null : null, (r21 & 64) != 0 ? null : null, (r21 & 128) != 0 ? false : false);
                    }
                }
            });
            return fKDontLookHimListIAdapter;
        }
    });

    @Override // com.cupidapp.live.base.fragment.FKBaseListFragment, com.cupidapp.live.base.fragment.FKBaseFragment
    public void N0() {
        this.f17738j.clear();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseListFragment
    @Nullable
    public View T0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f17738j;
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
    @Nullable
    public FKEmptyViewModel Z0() {
        return new FKEmptyViewModel(Integer.valueOf(R$mipmap.icon_dont_look_him_empty), Integer.valueOf(R$string.dont_look_him_empty_prompt), null, null, null, null, null, false, null, null, 1020, null);
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseListFragment
    @NotNull
    public FKBaseRecyclerViewAdapter d1() {
        return m1();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseListFragment
    @Nullable
    public Observable<Result<ListResult<User>>> e1(@Nullable String str) {
        return NetworkClient.f11868a.N().M0(str);
    }

    public final FKDontLookHimListIAdapter m1() {
        return (FKDontLookHimListIAdapter) this.f17737i.getValue();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseListFragment, com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        N0();
    }

    @he.j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull UserProfileDataChangeEvent event) {
        boolean z10;
        Object obj;
        FKEmptyViewModel Z0;
        s.i(event, "event");
        EventBus.c().r(event);
        User user = event.getUser();
        if (user.getSkipReceiveFeed()) {
            return;
        }
        Iterator<Object> iterator2 = m1().j().iterator2();
        while (true) {
            z10 = true;
            if (!iterator2.hasNext()) {
                obj = null;
                break;
            } else {
                obj = iterator2.next();
                if ((obj instanceof User) && s.d(((User) obj).userId(), user.userId())) {
                    break;
                }
            }
        }
        if (obj != null) {
            int indexOf = m1().j().indexOf(obj);
            m1().j().remove(obj);
            m1().notifyItemRemoved(indexOf);
            List<Object> j10 = m1().j();
            if (j10 != null && !j10.isEmpty()) {
                z10 = false;
            }
            if (!z10 || (Z0 = Z0()) == null) {
                return;
            }
            m1().d(Z0);
            m1().notifyItemInserted(0);
        }
    }
}
