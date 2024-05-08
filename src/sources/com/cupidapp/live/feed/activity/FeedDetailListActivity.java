package com.cupidapp.live.feed.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import com.cupidapp.live.AppApplication;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.sensorslog.FeedSensorContext;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.utils.o;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.feed.fragment.FeedDetailListFragment;
import com.cupidapp.live.feed.model.FeedModel;
import com.cupidapp.live.profile.model.User;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FeedDetailListActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FeedDetailListActivity extends FKBaseActivity {

    /* renamed from: v, reason: collision with root package name */
    @NotNull
    public static final a f14060v = new a(null);

    /* renamed from: q, reason: collision with root package name */
    @Nullable
    public FeedDetailListFragment f14061q;

    /* renamed from: r, reason: collision with root package name */
    @Nullable
    public ObjectAnimator f14062r;

    /* renamed from: s, reason: collision with root package name */
    @Nullable
    public ObjectAnimator f14063s;

    /* renamed from: t, reason: collision with root package name */
    @Nullable
    public com.cupidapp.live.base.utils.o f14064t;

    /* renamed from: u, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f14065u = new LinkedHashMap();

    /* compiled from: FeedDetailListActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull com.cupidapp.live.feed.helper.i dataSource, @Nullable String str, @NotNull FeedSensorContext sensorContext, boolean z10) {
            kotlin.jvm.internal.s.i(context, "context");
            kotlin.jvm.internal.s.i(dataSource, "dataSource");
            kotlin.jvm.internal.s.i(sensorContext, "sensorContext");
            Intent intent = new Intent(context, (Class<?>) FeedDetailListActivity.class);
            String valueOf = String.valueOf(System.currentTimeMillis());
            com.cupidapp.live.feed.helper.l.f14352a.a().put(valueOf, dataSource);
            intent.putExtra("FEED_MODEL_LIST", valueOf);
            intent.putExtra("FEED_MODEL_TITLE", str);
            z0.g.c(intent, sensorContext);
            intent.putExtra("FEED_DETAIL_LIST_DISPLAY_ALOHA_BUTTON", z10);
            context.startActivity(intent);
            FKBaseActivity.a.c(FKBaseActivity.f11750o, context, 0, 0, 6, null);
        }
    }

    /* compiled from: FeedDetailListActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class b implements o.c {
        public b() {
        }

        @Override // com.cupidapp.live.base.utils.o.c
        public void a(long j10) {
            User user;
            FeedDetailListFragment feedDetailListFragment = FeedDetailListActivity.this.f14061q;
            String str = null;
            FeedModel m12 = feedDetailListFragment != null ? feedDetailListFragment.m1() : null;
            j1.k kVar = j1.k.f50238a;
            SensorPosition sensorPosition = SensorPosition.PostStream;
            String feedContentType = m12 != null ? m12.getFeedContentType() : null;
            if (m12 != null && (user = m12.getUser()) != null) {
                str = user.userId();
            }
            kVar.a(sensorPosition, feedContentType, str, j10);
        }

        @Override // com.cupidapp.live.base.utils.o.c
        public void b(@NotNull String imageUriString, boolean z10) {
            User user;
            kotlin.jvm.internal.s.i(imageUriString, "imageUriString");
            FeedDetailListFragment feedDetailListFragment = FeedDetailListActivity.this.f14061q;
            String str = null;
            FeedModel m12 = feedDetailListFragment != null ? feedDetailListFragment.m1() : null;
            j1.k kVar = j1.k.f50238a;
            SensorPosition sensorPosition = SensorPosition.PostStream;
            String feedContentType = m12 != null ? m12.getFeedContentType() : null;
            if (m12 != null && (user = m12.getUser()) != null) {
                str = user.userId();
            }
            kVar.c(sensorPosition, feedContentType, str, z10);
        }
    }

    /* compiled from: FeedDetailListActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class c extends AnimatorListenerAdapter {
        public c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animation) {
            kotlin.jvm.internal.s.i(animation, "animation");
            ((TextView) FeedDetailListActivity.this.k1(R$id.seeMoreGuideTextView)).setVisibility(0);
        }
    }

    /* compiled from: FeedDetailListActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class d extends AnimatorListenerAdapter {
        public d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animation) {
            kotlin.jvm.internal.s.i(animation, "animation");
            ((TextView) FeedDetailListActivity.this.k1(R$id.seeMoreGuideTextView)).setVisibility(8);
        }
    }

    public static final void o1(FeedDetailListActivity this$0, float f10, float f11) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat((TextView) this$0.k1(R$id.seeMoreGuideTextView), (Property<TextView, Float>) View.Y, f10, f11);
        ofFloat.setDuration(300L);
        ofFloat.addListener(new d());
        this$0.f14063s = ofFloat;
        ofFloat.start();
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity
    @NotNull
    public SensorPosition Q0() {
        return SensorPosition.PostStream;
    }

    @Nullable
    public View k1(int i10) {
        Map<Integer, View> map = this.f14065u;
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

    public final void m1() {
        com.cupidapp.live.base.utils.o c4 = com.cupidapp.live.base.utils.o.f12354i.c(this);
        this.f14064t = c4;
        if (c4 != null) {
            c4.l(new b());
        }
    }

    public final void n1() {
        int i10 = R$id.seeMoreGuideTextView;
        ((TextView) k1(i10)).measure(View.MeasureSpec.makeMeasureSpec(z0.h.l(this), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(z0.h.l(this), Integer.MIN_VALUE));
        final float a10 = z0.s.f54824a.a();
        ViewGroup.LayoutParams layoutParams = ((TextView) k1(i10)).getLayoutParams();
        final float c4 = ((a10 - ((layoutParams instanceof ConstraintLayout.LayoutParams ? (ConstraintLayout.LayoutParams) layoutParams : null) != null ? r2.bottomMargin : z0.h.c(this, 54.0f))) - ((TextView) k1(i10)).getMeasuredHeight()) - z0.h.f(this);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat((TextView) k1(i10), (Property<TextView, Float>) View.Y, a10, c4);
        ofFloat.setDuration(500L);
        ofFloat.addListener(new c());
        this.f14062r = ofFloat;
        ofFloat.start();
        AppApplication.f11612d.h().j().postDelayed(new Runnable() { // from class: com.cupidapp.live.feed.activity.t
            @Override // java.lang.Runnable
            public final void run() {
                FeedDetailListActivity.o1(FeedDetailListActivity.this, c4, a10);
            }
        }, 2000L);
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, @Nullable Intent intent) {
        super.onActivityResult(i10, i11, intent);
        com.cupidapp.live.base.share.helper.d.f12255a.i(i10, i11, intent);
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_feed_detail_list);
        String stringExtra = getIntent().getStringExtra("FEED_MODEL_LIST");
        com.cupidapp.live.feed.helper.i iVar = stringExtra == null || stringExtra.length() == 0 ? null : com.cupidapp.live.feed.helper.l.f14352a.a().get(stringExtra);
        Intent intent = getIntent();
        kotlin.jvm.internal.s.h(intent, "intent");
        FeedSensorContext feedSensorContext = (FeedSensorContext) z0.g.a(intent, FeedSensorContext.class);
        if (feedSensorContext != null && iVar != null) {
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(FeedDetailListFragment.class.getSimpleName());
            FeedDetailListFragment feedDetailListFragment = findFragmentByTag instanceof FeedDetailListFragment ? (FeedDetailListFragment) findFragmentByTag : null;
            this.f14061q = feedDetailListFragment;
            if (feedDetailListFragment == null) {
                this.f14061q = new FeedDetailListFragment();
            }
            FeedDetailListFragment feedDetailListFragment2 = this.f14061q;
            if (feedDetailListFragment2 != null) {
                feedDetailListFragment2.V1(iVar, feedSensorContext, getIntent().getBooleanExtra("FEED_DETAIL_LIST_DISPLAY_ALOHA_BUTTON", false));
            }
        } else {
            finish();
        }
        FeedDetailListFragment feedDetailListFragment3 = this.f14061q;
        if (feedDetailListFragment3 != null) {
            getSupportFragmentManager().beginTransaction().replace(R$id.detailListContainer, feedDetailListFragment3, FeedDetailListFragment.class.getSimpleName()).commit();
        }
        int i10 = R$id.detailListTitleBarLayout;
        ((FKTitleBarLayout) k1(i10)).setLeftImageClickEvent(new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.feed.activity.FeedDetailListActivity$onCreate$2
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
                FeedDetailListActivity.this.finish();
            }
        });
        FKTitleBarLayout detailListTitleBarLayout = (FKTitleBarLayout) k1(i10);
        kotlin.jvm.internal.s.h(detailListTitleBarLayout, "detailListTitleBarLayout");
        Intent intent2 = getIntent();
        FKTitleBarLayout.setSingleTitle$default(detailListTitleBarLayout, intent2 != null ? intent2.getStringExtra("FEED_MODEL_TITLE") : null, null, 2, null);
        if (iVar != null && iVar.g() < iVar.b().size() - 1) {
            n1();
        }
        m1();
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        String stringExtra = getIntent().getStringExtra("FEED_MODEL_LIST");
        if (stringExtra != null) {
            com.cupidapp.live.feed.helper.l.f14352a.a().remove(stringExtra);
        }
        ObjectAnimator objectAnimator = this.f14062r;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        ObjectAnimator objectAnimator2 = this.f14063s;
        if (objectAnimator2 != null) {
            objectAnimator2.cancel();
        }
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        com.cupidapp.live.base.utils.o oVar = this.f14064t;
        if (oVar != null) {
            oVar.n();
        }
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        com.cupidapp.live.base.utils.o oVar = this.f14064t;
        if (oVar != null) {
            oVar.m();
        }
    }
}
