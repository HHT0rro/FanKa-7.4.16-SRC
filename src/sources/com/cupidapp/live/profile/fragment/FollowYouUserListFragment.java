package com.cupidapp.live.profile.fragment;

import android.view.View;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.network.model.ViewProfilePrefer;
import com.cupidapp.live.base.sensorslog.ProfileSensorContext;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.profile.activity.UserProfileActivity;
import com.cupidapp.live.profile.holder.NonexistentUserEnterViewModel;
import com.cupidapp.live.profile.holder.RelationType;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.profile.model.UserListResult;
import com.cupidapp.live.track.group.GroupSocialLog;
import io.reactivex.Observable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x2.a;

/* compiled from: RelationUserListFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FollowYouUserListFragment extends RelationUserListFragment {

    /* renamed from: n, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17748n = new LinkedHashMap();

    /* compiled from: RelationUserListFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f17749a;

        static {
            int[] iArr = new int[UserListOrder.values().length];
            try {
                iArr[UserListOrder.Active.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[UserListOrder.Location.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[UserListOrder.Newest.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f17749a = iArr;
        }
    }

    @Override // com.cupidapp.live.profile.fragment.RelationUserListFragment, com.cupidapp.live.base.fragment.FKBaseFragment
    public void N0() {
        this.f17748n.clear();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    @NotNull
    public SensorPosition O0() {
        return SensorPosition.MyAlohaGet;
    }

    @Override // com.cupidapp.live.profile.fragment.RelationUserListFragment
    public void P1(@NotNull User user) {
        s.i(user, "user");
        String value = ViewProfilePrefer.FollowerToProfile.getValue();
        boolean me2 = user.getMe();
        SensorPosition sensorPosition = SensorPosition.MyAlohaGet;
        SensorScene sensorScene = SensorScene.FollowerList;
        UserProfileActivity.a.b(UserProfileActivity.G, getContext(), user, new ProfileSensorContext(value, null, me2, sensorPosition, null, sensorScene), true, null, null, null, false, 240, null);
        GroupSocialLog.f18708a.u(sensorScene.getValue(), user.userId(), (r13 & 4) != 0 ? null : null, (r13 & 8) != 0 ? false : false, (r13 & 16) != 0 ? null : null);
    }

    @Override // com.cupidapp.live.profile.fragment.RelationUserListFragment
    @Nullable
    public View W0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f17748n;
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

    @Override // com.cupidapp.live.profile.fragment.RelationUserListFragment
    public void k1() {
        v1().d(new NonexistentUserEnterViewModel(u1()));
    }

    @Override // com.cupidapp.live.profile.fragment.RelationUserListFragment
    public boolean l1() {
        return false;
    }

    @Override // com.cupidapp.live.profile.fragment.RelationUserListFragment, com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        N0();
    }

    @Override // com.cupidapp.live.profile.fragment.RelationUserListFragment
    @NotNull
    public RelationType u1() {
        return RelationType.FollowYou;
    }

    @Override // com.cupidapp.live.profile.fragment.RelationUserListFragment
    @NotNull
    public Observable<Result<UserListResult>> w1(@Nullable String str) {
        int i10 = a.f17749a[s1().ordinal()];
        if (i10 == 1) {
            return a.C0836a.s(NetworkClient.f11868a.N(), str, 0, 2, null);
        }
        if (i10 == 2) {
            return a.C0836a.u(NetworkClient.f11868a.N(), str, 0, 2, null);
        }
        if (i10 == 3) {
            return NetworkClient.f11868a.N().a(str);
        }
        throw new NoWhenBranchMatchedException();
    }
}
