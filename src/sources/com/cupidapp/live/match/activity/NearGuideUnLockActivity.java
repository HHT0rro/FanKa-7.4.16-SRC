package com.cupidapp.live.match.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.router.PurchaseSuccessEvent;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.base.view.button.FKUniversalButton;
import com.cupidapp.live.liveshow.beauty.databeauty.UserData;
import com.cupidapp.live.track.group.GroupOthersLog;
import com.cupidapp.live.vip.PurchaseDialogManager;
import com.cupidapp.live.vip.wrapper.VipPurchaseEntranceType;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: NearGuideUnLockActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class NearGuideUnLockActivity extends FKBaseActivity {

    /* renamed from: u, reason: collision with root package name */
    @NotNull
    public static final a f16519u = new a(null);

    /* renamed from: r, reason: collision with root package name */
    @Nullable
    public Disposable f16521r;

    /* renamed from: s, reason: collision with root package name */
    public int f16522s;

    /* renamed from: t, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16523t = new LinkedHashMap();

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public final Lazy f16520q = kotlin.c.b(new Function0<PurchaseDialogManager>() { // from class: com.cupidapp.live.match.activity.NearGuideUnLockActivity$purchaseManager$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final PurchaseDialogManager invoke() {
            NearGuideUnLockActivity nearGuideUnLockActivity = NearGuideUnLockActivity.this;
            Lifecycle lifecycle = nearGuideUnLockActivity.getLifecycle();
            kotlin.jvm.internal.s.h(lifecycle, "this.lifecycle");
            return new PurchaseDialogManager(nearGuideUnLockActivity, lifecycle);
        }
    });

    /* compiled from: NearGuideUnLockActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@Nullable Context context, @NotNull NearUnLockUserModel user) {
            kotlin.jvm.internal.s.i(user, "user");
            Intent intent = new Intent(context, (Class<?>) NearGuideUnLockActivity.class);
            intent.putExtra(UserData.NAME, user);
            if (context != null) {
                context.startActivity(intent);
            }
            FKBaseActivity.a.c(FKBaseActivity.f11750o, context, 0, 0, 6, null);
        }
    }

    public static final void s1(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final boolean t1(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(obj)).booleanValue();
    }

    public static final void u1(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void v1(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity
    @NotNull
    public SensorPosition Q0() {
        return SensorPosition.UnlockNearBy;
    }

    @Nullable
    public View n1(int i10) {
        Map<Integer, View> map = this.f16523t;
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
        setContentView(R$layout.activity_near_guide_un_lock);
        int i10 = R$id.near_unlock_location;
        TextView near_unlock_location = (TextView) n1(i10);
        kotlin.jvm.internal.s.h(near_unlock_location, "near_unlock_location");
        z0.u.a(near_unlock_location);
        Serializable serializableExtra = getIntent().getSerializableExtra(UserData.NAME);
        NearUnLockUserModel nearUnLockUserModel = serializableExtra instanceof NearUnLockUserModel ? (NearUnLockUserModel) serializableExtra : null;
        r1(nearUnLockUserModel != null ? nearUnLockUserModel.getRemainTime() : null);
        ImageLoaderView near_unlock_avatar = (ImageLoaderView) n1(R$id.near_unlock_avatar);
        kotlin.jvm.internal.s.h(near_unlock_avatar, "near_unlock_avatar");
        ImageLoaderView.g(near_unlock_avatar, nearUnLockUserModel != null ? nearUnLockUserModel.getAvatar() : null, null, null, 6, null);
        ((TextView) n1(i10)).setText(nearUnLockUserModel != null ? nearUnLockUserModel.getDistance() : null);
        FKUniversalButton unlock_near_btn = (FKUniversalButton) n1(R$id.unlock_near_btn);
        kotlin.jvm.internal.s.h(unlock_near_btn, "unlock_near_btn");
        z0.y.d(unlock_near_btn, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.activity.NearGuideUnLockActivity$onCreate$1
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
                PurchaseDialogManager w12;
                w12 = NearGuideUnLockActivity.this.w1();
                PurchaseDialogManager.j(w12, VipPurchaseEntranceType.NearbyUnLock, null, null, false, 14, null);
                SensorsLogKeyButtonClick.UnlockNearby.UNLOCK.click();
            }
        });
        ((FKTitleBarLayout) n1(R$id.near_guide_unlock_title)).setLeftImageClickEvent(new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.activity.NearGuideUnLockActivity$onCreate$2
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
                NearGuideUnLockActivity.this.finish();
            }
        });
        GroupOthersLog.d(GroupOthersLog.f18702a, Q0().getValue(), null, null, 6, null);
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Disposable disposable = this.f16521r;
        if (disposable != null) {
            disposable.dispose();
        }
        super.onDestroy();
    }

    @he.j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull PurchaseSuccessEvent event) {
        kotlin.jvm.internal.s.i(event, "event");
        EventBus.c().r(event);
        finish();
    }

    public final void r1(Integer num) {
        this.f16522s = num != null ? num.intValue() : 0;
        ((TextView) n1(R$id.near_unlock_time)).setText(z0.v.h(this.f16522s));
        if (this.f16521r != null || this.f16522s <= 0) {
            return;
        }
        Observable<Long> observeOn = Observable.interval(1L, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread());
        final Function1<Long, kotlin.p> function1 = new Function1<Long, kotlin.p>() { // from class: com.cupidapp.live.match.activity.NearGuideUnLockActivity$changeTime$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Long l10) {
                invoke2(l10);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Long l10) {
                int i10;
                NearGuideUnLockActivity nearGuideUnLockActivity = NearGuideUnLockActivity.this;
                i10 = nearGuideUnLockActivity.f16522s;
                nearGuideUnLockActivity.f16522s = i10 - 1;
            }
        };
        Observable<Long> doOnNext = observeOn.doOnNext(new Consumer() { // from class: com.cupidapp.live.match.activity.s
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                NearGuideUnLockActivity.s1(Function1.this, obj);
            }
        });
        final Function1<Long, Boolean> function12 = new Function1<Long, Boolean>() { // from class: com.cupidapp.live.match.activity.NearGuideUnLockActivity$changeTime$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Long it) {
                int i10;
                kotlin.jvm.internal.s.i(it, "it");
                i10 = NearGuideUnLockActivity.this.f16522s;
                return Boolean.valueOf(i10 >= 0);
            }
        };
        Observable<Long> filter = doOnNext.filter(new Predicate() { // from class: com.cupidapp.live.match.activity.t
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean t12;
                t12 = NearGuideUnLockActivity.t1(Function1.this, obj);
                return t12;
            }
        });
        final Function1<Long, kotlin.p> function13 = new Function1<Long, kotlin.p>() { // from class: com.cupidapp.live.match.activity.NearGuideUnLockActivity$changeTime$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Long l10) {
                invoke2(l10);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Long l10) {
                int i10;
                TextView textView = (TextView) NearGuideUnLockActivity.this.n1(R$id.near_unlock_time);
                if (textView == null) {
                    return;
                }
                i10 = NearGuideUnLockActivity.this.f16522s;
                textView.setText(z0.v.h(i10));
            }
        };
        Consumer<? super Long> consumer = new Consumer() { // from class: com.cupidapp.live.match.activity.q
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                NearGuideUnLockActivity.u1(Function1.this, obj);
            }
        };
        final NearGuideUnLockActivity$changeTime$4 nearGuideUnLockActivity$changeTime$4 = new Function1<Throwable, kotlin.p>() { // from class: com.cupidapp.live.match.activity.NearGuideUnLockActivity$changeTime$4
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Throwable th) {
                invoke2(th);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
            }
        };
        this.f16521r = filter.subscribe(consumer, new Consumer() { // from class: com.cupidapp.live.match.activity.r
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                NearGuideUnLockActivity.v1(Function1.this, obj);
            }
        });
    }

    public final PurchaseDialogManager w1() {
        return (PurchaseDialogManager) this.f16520q.getValue();
    }
}
