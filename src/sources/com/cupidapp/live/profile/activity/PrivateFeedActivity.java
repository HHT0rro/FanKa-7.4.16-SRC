package com.cupidapp.live.profile.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.sensorslog.FKSensorContext;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorsLogFeed;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.base.view.tabview.TopTabView;
import com.cupidapp.live.profile.fragment.PostLimitPrivateFragment;
import com.cupidapp.live.profile.fragment.PrivateFeedFragment;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PrivateFeedActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class PrivateFeedActivity extends FKBaseActivity {

    /* renamed from: v, reason: collision with root package name */
    @NotNull
    public static final a f17650v = new a(null);

    /* renamed from: t, reason: collision with root package name */
    public int f17654t;

    /* renamed from: u, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17655u = new LinkedHashMap();

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public final Lazy f17651q = kotlin.c.b(new Function0<FKSensorContext>() { // from class: com.cupidapp.live.profile.activity.PrivateFeedActivity$sensorContext$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @Nullable
        public final FKSensorContext invoke() {
            Serializable serializableExtra = PrivateFeedActivity.this.getIntent().getSerializableExtra("sensorContext");
            if (serializableExtra instanceof FKSensorContext) {
                return (FKSensorContext) serializableExtra;
            }
            return null;
        }
    });

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public final Lazy f17652r = kotlin.c.b(new Function0<PrivateFeedFragment>() { // from class: com.cupidapp.live.profile.activity.PrivateFeedActivity$privateFeedFragment$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final PrivateFeedFragment invoke() {
            FKSensorContext r12;
            PrivateFeedFragment.a aVar = PrivateFeedFragment.f17769l;
            r12 = PrivateFeedActivity.this.r1();
            return aVar.a(r12);
        }
    });

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    public final Lazy f17653s = kotlin.c.b(new Function0<PostLimitPrivateFragment>() { // from class: com.cupidapp.live.profile.activity.PrivateFeedActivity$privatePostLimitFragment$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final PostLimitPrivateFragment invoke() {
            FKSensorContext r12;
            PostLimitPrivateFragment.a aVar = PostLimitPrivateFragment.f17760m;
            r12 = PrivateFeedActivity.this.r1();
            return aVar.a(r12);
        }
    });

    /* compiled from: PrivateFeedActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@Nullable Context context, @NotNull FKSensorContext sensorContext) {
            kotlin.jvm.internal.s.i(sensorContext, "sensorContext");
            if (context == null) {
                return;
            }
            Intent intent = new Intent(context, (Class<?>) PrivateFeedActivity.class);
            intent.putExtra("sensorContext", sensorContext);
            context.startActivity(intent);
            FKBaseActivity.a.c(FKBaseActivity.f11750o, context, 0, 0, 6, null);
        }
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity
    @NotNull
    public SensorPosition Q0() {
        return SensorPosition.PrivateFeed;
    }

    @Nullable
    public View j1(int i10) {
        Map<Integer, View> map = this.f17655u;
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

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_private_feed);
        ((FKTitleBarLayout) j1(R$id.privateFeedTitleLayout)).setLeftImageClickEvent(new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.profile.activity.PrivateFeedActivity$onCreate$1
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
                PrivateFeedActivity.this.onBackPressed();
            }
        });
        int i10 = R$id.private_top;
        ((TopTabView) j1(i10)).b(kotlin.collections.s.m(getString(R$string.post), getString(R$string.limit_post)), 0);
        ((TopTabView) j1(i10)).setClickListener(new Function1<Integer, kotlin.p>() { // from class: com.cupidapp.live.profile.activity.PrivateFeedActivity$onCreate$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Integer num) {
                invoke(num.intValue());
                return kotlin.p.f51048a;
            }

            public final void invoke(int i11) {
                int i12;
                PostLimitPrivateFragment q12;
                PrivateFeedFragment p12;
                i12 = PrivateFeedActivity.this.f17654t;
                if (i12 != i11) {
                    ((TopTabView) PrivateFeedActivity.this.j1(R$id.private_top)).a(i11);
                    if (i11 == 0) {
                        PrivateFeedActivity privateFeedActivity = PrivateFeedActivity.this;
                        p12 = privateFeedActivity.p1();
                        FKBaseActivity.g1(privateFeedActivity, p12, false, R$id.privateFeedContainerLayout, false, false, 16, null);
                    } else {
                        PrivateFeedActivity privateFeedActivity2 = PrivateFeedActivity.this;
                        q12 = privateFeedActivity2.q1();
                        FKBaseActivity.g1(privateFeedActivity2, q12, false, R$id.privateFeedContainerLayout, false, false, 16, null);
                    }
                    PrivateFeedActivity.this.f17654t = i11;
                }
            }
        });
        FKBaseActivity.g1(this, p1(), false, R$id.privateFeedContainerLayout, false, false, 24, null);
        SensorsLogFeed.f12208a.z();
    }

    public final PrivateFeedFragment p1() {
        return (PrivateFeedFragment) this.f17652r.getValue();
    }

    public final PostLimitPrivateFragment q1() {
        return (PostLimitPrivateFragment) this.f17653s.getValue();
    }

    public final FKSensorContext r1() {
        return (FKSensorContext) this.f17651q.getValue();
    }
}
