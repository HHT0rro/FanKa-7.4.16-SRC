package com.cupidapp.live.profile.activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.profile.model.ProfileSpecListModel;
import com.cupidapp.live.profile.model.ProfileSpecModifyResult;
import com.cupidapp.live.profile.model.User;
import com.huawei.hms.mlsdk.common.AgConnectInfo;
import com.huawei.quickcard.base.Attributes;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.i0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKBaseProfileSpecActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class FKBaseProfileSpecActivity extends FKBaseActivity {

    /* renamed from: t, reason: collision with root package name */
    @NotNull
    public static final a f17612t = new a(null);

    /* renamed from: u, reason: collision with root package name */
    @NotNull
    public static final Map<String, Class<? extends FKBaseProfileSpecActivity>> f17613u = i0.h(kotlin.f.a(Attributes.Style.RANGE, ProfileNumberPickerActivity.class), kotlin.f.a("date", ProfileDatePickerActivity.class), kotlin.f.a("select", ProfileOptionsActivity.class), kotlin.f.a(Attributes.InputType.CHECK_BOX, ProfileOptionsActivity.class), kotlin.f.a(AgConnectInfo.AgConnectKey.REGION, ProfileLocationActivity.class));

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17616s = new LinkedHashMap();

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public final Lazy f17614q = kotlin.c.b(new Function0<String>() { // from class: com.cupidapp.live.profile.activity.FKBaseProfileSpecActivity$specItemId$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @Nullable
        public final String invoke() {
            return FKBaseProfileSpecActivity.this.getIntent().getStringExtra("PROFILE_SPEC_ID_BUNDLE_KEY");
        }
    });

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public final Lazy f17615r = kotlin.c.b(new Function0<ProfileSpecListModel>() { // from class: com.cupidapp.live.profile.activity.FKBaseProfileSpecActivity$profileSpecModel$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @Nullable
        public final ProfileSpecListModel invoke() {
            List<ProfileSpecListModel> profileSpecList;
            User X = p1.g.f52734a.X();
            ProfileSpecListModel profileSpecListModel = null;
            if (X == null || (profileSpecList = X.getProfileSpecList()) == null) {
                return null;
            }
            FKBaseProfileSpecActivity fKBaseProfileSpecActivity = FKBaseProfileSpecActivity.this;
            Iterator<ProfileSpecListModel> iterator2 = profileSpecList.iterator2();
            while (true) {
                if (!iterator2.hasNext()) {
                    break;
                }
                ProfileSpecListModel next = iterator2.next();
                if (kotlin.jvm.internal.s.d(next.getItemId(), fKBaseProfileSpecActivity.l1())) {
                    profileSpecListModel = next;
                    break;
                }
            }
            return profileSpecListModel;
        }
    });

    /* compiled from: FKBaseProfileSpecActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull String type, @NotNull String profileSpecId) {
            kotlin.jvm.internal.s.i(context, "context");
            kotlin.jvm.internal.s.i(type, "type");
            kotlin.jvm.internal.s.i(profileSpecId, "profileSpecId");
            Class cls = (Class) FKBaseProfileSpecActivity.f17613u.get(type);
            if (cls != null) {
                Intent intent = new Intent(context, (Class<?>) cls);
                intent.putExtra("PROFILE_SPEC_ID_BUNDLE_KEY", profileSpecId);
                context.startActivity(intent);
                FKBaseActivity.a.c(FKBaseActivity.f11750o, context, 0, 0, 6, null);
            }
        }
    }

    @Nullable
    public final ProfileSpecListModel k1() {
        return (ProfileSpecListModel) this.f17615r.getValue();
    }

    @Nullable
    public final String l1() {
        return (String) this.f17614q.getValue();
    }

    public final void m1(@Nullable List<String> list) {
        Observable<Result<ProfileSpecModifyResult>> r02;
        if (l1() == null) {
            return;
        }
        e1();
        if (list == null || list.isEmpty()) {
            x2.a N = NetworkClient.f11868a.N();
            String l12 = l1();
            kotlin.jvm.internal.s.f(l12);
            r02 = N.l(l12);
        } else {
            x2.a N2 = NetworkClient.f11868a.N();
            String l13 = l1();
            kotlin.jvm.internal.s.f(l13);
            r02 = N2.r0(l13, list);
        }
        Disposable disposed = r02.flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<ProfileSpecModifyResult, kotlin.p>() { // from class: com.cupidapp.live.profile.activity.FKBaseProfileSpecActivity$saveSpecItemData$$inlined$handle$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(ProfileSpecModifyResult profileSpecModifyResult) {
                m2756invoke(profileSpecModifyResult);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2756invoke(ProfileSpecModifyResult profileSpecModifyResult) {
                ProfileSpecModifyResult profileSpecModifyResult2 = profileSpecModifyResult;
                FKBaseProfileSpecActivity.this.V0();
                p1.g gVar = p1.g.f52734a;
                gVar.B2(true);
                User X = gVar.X();
                if (X != null) {
                    List<ProfileSpecListModel> profileSpecList = X.getProfileSpecList();
                    if (profileSpecList != null) {
                        profileSpecList.clear();
                    }
                    List<ProfileSpecListModel> profileSpecList2 = X.getProfileSpecList();
                    if (profileSpecList2 != null) {
                        profileSpecList2.addAll(profileSpecModifyResult2.getList());
                    }
                    gVar.A2(X);
                }
                ProfileSpecListModel k12 = FKBaseProfileSpecActivity.this.k1();
                if (k12 != null) {
                    j1.d.f50229a.b(k12.getName(), SensorPosition.EditProfile);
                }
                com.cupidapp.live.base.view.h.f12779a.c(FKBaseProfileSpecActivity.this, R$string.save_success);
                FKBaseProfileSpecActivity.this.finish();
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.profile.activity.FKBaseProfileSpecActivity$saveSpecItemData$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                kotlin.jvm.internal.s.i(it, "it");
                FKBaseProfileSpecActivity.this.V0();
                FKBaseProfileSpecActivity.this.finish();
                return Boolean.FALSE;
            }
        }, this)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
            H(disposed);
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }
}
