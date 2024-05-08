package com.cupidapp.live.profile.activity;

import android.os.Bundle;
import android.view.View;
import com.cupidapp.live.base.fragment.FKBaseListFragment;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.model.ListResult;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewAdapter;
import com.cupidapp.live.base.sensorslog.ProfileSensorContext;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.profile.holder.RelationType;
import com.cupidapp.live.profile.model.User;
import io.reactivex.Observable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x2.a;

/* compiled from: NonexistentUserActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class NonexistentUserFragment extends FKBaseListFragment<User> {

    /* renamed from: l, reason: collision with root package name */
    @NotNull
    public static final a f17641l = new a(null);

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17644k = new LinkedHashMap();

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public final Lazy f17642i = kotlin.c.b(new Function0<NonexistentUserAdapter>() { // from class: com.cupidapp.live.profile.activity.NonexistentUserFragment$nonexistentUserAdapter$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final NonexistentUserAdapter invoke() {
            NonexistentUserAdapter nonexistentUserAdapter = new NonexistentUserAdapter();
            final NonexistentUserFragment nonexistentUserFragment = NonexistentUserFragment.this;
            nonexistentUserAdapter.l().g(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.profile.activity.NonexistentUserFragment$nonexistentUserAdapter$2$1$1

                /* compiled from: NonexistentUserActivity.kt */
                @kotlin.d
                /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
                public /* synthetic */ class a {

                    /* renamed from: a, reason: collision with root package name */
                    public static final /* synthetic */ int[] f17646a;

                    static {
                        int[] iArr = new int[RelationType.values().length];
                        try {
                            iArr[RelationType.Matched.ordinal()] = 1;
                        } catch (NoSuchFieldError unused) {
                        }
                        try {
                            iArr[RelationType.FollowYou.ordinal()] = 2;
                        } catch (NoSuchFieldError unused2) {
                        }
                        try {
                            iArr[RelationType.YouFollowed.ordinal()] = 3;
                        } catch (NoSuchFieldError unused3) {
                        }
                        f17646a = iArr;
                    }
                }

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
                    RelationType o12;
                    SensorPosition sensorPosition;
                    SensorScene sensorScene;
                    SensorScene sensorScene2;
                    SensorPosition sensorPosition2;
                    if (obj instanceof User) {
                        o12 = NonexistentUserFragment.this.o1();
                        int i10 = o12 == null ? -1 : a.f17646a[o12.ordinal()];
                        if (i10 == 1) {
                            sensorPosition = SensorPosition.Contacts;
                            sensorScene = SensorScene.MatchList;
                        } else if (i10 == 2) {
                            sensorPosition = SensorPosition.MyAlohaGet;
                            sensorScene = SensorScene.FollowerList;
                        } else if (i10 == 3) {
                            sensorPosition = SensorPosition.MyAloha;
                            sensorScene = SensorScene.FollowingList;
                        } else {
                            sensorPosition2 = null;
                            sensorScene2 = null;
                            User user = (User) obj;
                            UserProfileActivity.G.a(NonexistentUserFragment.this.getContext(), user, new ProfileSensorContext(null, null, user.getMe(), SensorPosition.BlockedUserList, sensorPosition2, sensorScene2), (r21 & 8) != 0 ? false : false, (r21 & 16) != 0 ? null : null, (r21 & 32) != 0 ? null : null, (r21 & 64) != 0 ? null : null, (r21 & 128) != 0 ? false : false);
                        }
                        sensorScene2 = sensorScene;
                        sensorPosition2 = sensorPosition;
                        User user2 = (User) obj;
                        UserProfileActivity.G.a(NonexistentUserFragment.this.getContext(), user2, new ProfileSensorContext(null, null, user2.getMe(), SensorPosition.BlockedUserList, sensorPosition2, sensorScene2), (r21 & 8) != 0 ? false : false, (r21 & 16) != 0 ? null : null, (r21 & 32) != 0 ? null : null, (r21 & 64) != 0 ? null : null, (r21 & 128) != 0 ? false : false);
                    }
                }
            });
            return nonexistentUserAdapter;
        }
    });

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    public final Lazy f17643j = kotlin.c.b(new Function0<RelationType>() { // from class: com.cupidapp.live.profile.activity.NonexistentUserFragment$relationType$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @Nullable
        public final RelationType invoke() {
            Bundle arguments = NonexistentUserFragment.this.getArguments();
            if (arguments != null) {
                return (RelationType) z0.g.b(arguments, RelationType.class);
            }
            return null;
        }
    });

    /* compiled from: NonexistentUserActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final NonexistentUserFragment a(@NotNull RelationType relationType) {
            kotlin.jvm.internal.s.i(relationType, "relationType");
            NonexistentUserFragment nonexistentUserFragment = new NonexistentUserFragment();
            Bundle bundle = new Bundle();
            z0.g.d(bundle, relationType);
            nonexistentUserFragment.setArguments(bundle);
            return nonexistentUserFragment;
        }
    }

    /* compiled from: NonexistentUserActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f17645a;

        static {
            int[] iArr = new int[RelationType.values().length];
            try {
                iArr[RelationType.Matched.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RelationType.FollowYou.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[RelationType.YouFollowed.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f17645a = iArr;
        }
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseListFragment, com.cupidapp.live.base.fragment.FKBaseFragment
    public void N0() {
        this.f17644k.clear();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseListFragment
    @Nullable
    public View T0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f17644k;
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
    public FKBaseRecyclerViewAdapter d1() {
        return n1();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseListFragment
    @Nullable
    public Observable<Result<ListResult<User>>> e1(@Nullable String str) {
        RelationType o12 = o1();
        int i10 = o12 == null ? -1 : b.f17645a[o12.ordinal()];
        if (i10 == 1) {
            return a.C0836a.l(NetworkClient.f11868a.N(), str, 0, 2, null);
        }
        if (i10 == 2) {
            return a.C0836a.t(NetworkClient.f11868a.N(), str, 0, 2, null);
        }
        if (i10 != 3) {
            return null;
        }
        return a.C0836a.q(NetworkClient.f11868a.N(), str, 0, 2, null);
    }

    public final NonexistentUserAdapter n1() {
        return (NonexistentUserAdapter) this.f17642i.getValue();
    }

    public final RelationType o1() {
        return (RelationType) this.f17643j.getValue();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseListFragment, com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        N0();
    }
}
