package com.cupidapp.live.profile.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.fragment.FKBaseFragment;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.utils.o;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.chat.fragment.ContactSessionContainerFragment;
import com.cupidapp.live.profile.fragment.FollowYouUserListFragment;
import com.cupidapp.live.profile.fragment.FollowYouUserNeedPurchaseListFragment;
import com.cupidapp.live.profile.fragment.MatchedUserListFragment;
import com.cupidapp.live.profile.fragment.YouFollowedUserListFragment;
import com.cupidapp.live.profile.model.User;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: RelationUserListActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class RelationUserListActivity extends FKBaseActivity {

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    public static final a f17672s = new a(null);

    /* renamed from: q, reason: collision with root package name */
    @Nullable
    public com.cupidapp.live.base.utils.o f17673q;

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17674r = new LinkedHashMap();

    /* compiled from: RelationUserListActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Intent a(@NotNull Context context) {
            kotlin.jvm.internal.s.i(context, "context");
            return ContactSessionContainerFragment.a.b(ContactSessionContainerFragment.f13146u, context, null, 2, null);
        }

        public final void b(@Nullable Context context, int i10) {
            Intent intent = new Intent(context, (Class<?>) RelationUserListActivity.class);
            intent.putExtra("RelationUserListIndex", i10);
            if (context != null) {
                context.startActivity(intent);
            }
            FKBaseActivity.a.c(FKBaseActivity.f11750o, context, 0, 0, 6, null);
        }
    }

    /* compiled from: RelationUserListActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b implements o.c {
        public b() {
        }

        @Override // com.cupidapp.live.base.utils.o.c
        public void a(long j10) {
            j1.k.f50238a.a(RelationUserListActivity.this.Q0(), (i10 & 2) != 0 ? null : null, (i10 & 4) != 0 ? null : null, j10);
        }

        @Override // com.cupidapp.live.base.utils.o.c
        public void b(@NotNull String imageUriString, boolean z10) {
            kotlin.jvm.internal.s.i(imageUriString, "imageUriString");
            j1.k.f50238a.d(RelationUserListActivity.this.Q0(), z10);
        }
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity
    @NotNull
    public SensorPosition Q0() {
        SensorPosition O0;
        FKBaseFragment R0 = R0();
        return (R0 == null || (O0 = R0.O0()) == null) ? SensorPosition.Unknown : O0;
    }

    @Nullable
    public View j1(int i10) {
        Map<Integer, View> map = this.f17674r;
        View view = map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i10);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    public final void k1() {
        com.cupidapp.live.base.utils.o c4 = com.cupidapp.live.base.utils.o.f12354i.c(this);
        this.f17673q = c4;
        if (c4 != null) {
            c4.l(new b());
        }
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        String string;
        FKBaseFragment followYouUserListFragment;
        super.onCreate(bundle);
        setContentView(R$layout.activity_fragment_title_container);
        boolean z10 = false;
        int intExtra = getIntent().getIntExtra("RelationUserListIndex", 0);
        if (intExtra == 1) {
            string = getString(R$string.popularity);
            kotlin.jvm.internal.s.h(string, "getString(R.string.popularity)");
            User X = p1.g.f52734a.X();
            if (X != null && X.getAlohaGetRequired()) {
                z10 = true;
            }
            if (z10) {
                followYouUserListFragment = FollowYouUserNeedPurchaseListFragment.f17750i.a();
            } else {
                followYouUserListFragment = new FollowYouUserListFragment();
            }
        } else if (intExtra != 2) {
            string = getString(R$string.match);
            kotlin.jvm.internal.s.h(string, "getString(R.string.match)");
            followYouUserListFragment = new MatchedUserListFragment();
        } else {
            string = getString(R$string.concern);
            kotlin.jvm.internal.s.h(string, "getString(R.string.concern)");
            followYouUserListFragment = new YouFollowedUserListFragment();
        }
        FKBaseFragment fKBaseFragment = followYouUserListFragment;
        FKTitleBarLayout onCreate$lambda$0 = (FKTitleBarLayout) j1(R$id.containerTitleLayout);
        kotlin.jvm.internal.s.h(onCreate$lambda$0, "onCreate$lambda$0");
        FKTitleBarLayout.setSingleTitle$default(onCreate$lambda$0, string, null, 2, null);
        onCreate$lambda$0.setLeftImageClickEvent(new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.profile.activity.RelationUserListActivity$onCreate$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(View view) {
                invoke2(view);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                RelationUserListActivity.this.finish();
            }
        });
        FKBaseActivity.g1(this, fKBaseFragment, false, R$id.containerLayout, false, false, 24, null);
        k1();
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        com.cupidapp.live.base.utils.o oVar = this.f17673q;
        if (oVar != null) {
            oVar.n();
        }
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        com.cupidapp.live.base.utils.o oVar = this.f17673q;
        if (oVar != null) {
            oVar.m();
        }
    }
}
