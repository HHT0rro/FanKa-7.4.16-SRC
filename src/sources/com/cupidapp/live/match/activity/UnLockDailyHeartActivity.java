package com.cupidapp.live.match.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.activity.ComponentActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.R$anim;
import com.cupidapp.live.R$color;
import com.cupidapp.live.R$drawable;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.network.model.StateResult;
import com.cupidapp.live.base.recyclerview.decoration.MutableColumnDecoration;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.match.activity.NearByMiniProfileActivity;
import com.cupidapp.live.match.adapter.DailyUnLockModel;
import com.cupidapp.live.match.adapter.UnlockDailyHeartAdapter;
import com.cupidapp.live.match.model.NearbyUserModel;
import com.cupidapp.live.match.view.TipUiModel;
import com.cupidapp.live.match.viewmodel.UnlockDailyHeartViewModel;
import com.cupidapp.live.notify.model.DailyHeartModel;
import com.cupidapp.live.track.group.GroupOthersLog;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: UnLockDailyHeartActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class UnLockDailyHeartActivity extends FKBaseActivity {

    /* renamed from: t, reason: collision with root package name */
    @NotNull
    public static final a f16573t = new a(null);

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public final Lazy f16575r;

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16576s = new LinkedHashMap();

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public final Lazy f16574q = kotlin.c.b(new Function0<UnlockDailyHeartAdapter>() { // from class: com.cupidapp.live.match.activity.UnLockDailyHeartActivity$adapter$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final UnlockDailyHeartAdapter invoke() {
            UnlockDailyHeartAdapter unlockDailyHeartAdapter = new UnlockDailyHeartAdapter();
            final UnLockDailyHeartActivity unLockDailyHeartActivity = UnLockDailyHeartActivity.this;
            unlockDailyHeartAdapter.l().g(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.match.activity.UnLockDailyHeartActivity$adapter$2$1$1
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
                    UnlockDailyHeartViewModel o12;
                    if (obj instanceof DailyUnLockModel) {
                        o12 = UnLockDailyHeartActivity.this.o1();
                        DailyHeartModel unlockModel = o12.getUnlockModel();
                        if (unlockModel != null) {
                            UnLockDailyHeartActivity unLockDailyHeartActivity2 = UnLockDailyHeartActivity.this;
                            NearByMiniProfileActivity.a aVar = NearByMiniProfileActivity.f16517r;
                            NearbyUserModel fromUser = unlockModel.getFromUser();
                            SensorScene sensorScene = SensorScene.Match;
                            String string = unLockDailyHeartActivity2.getString(R$string.from_daily_heart);
                            int color = ContextCompat.getColor(unLockDailyHeartActivity2, R$color.yellow_925A0E);
                            kotlin.jvm.internal.s.h(string, "getString(R.string.from_daily_heart)");
                            aVar.a(unLockDailyHeartActivity2, fromUser, sensorScene, (r27 & 8) != 0 ? false : false, (r27 & 16) != 0 ? null : new TipUiModel(string, R$drawable.shape_from_heart_bg, color), (r27 & 32) != 0 ? false : false, (r27 & 64) != 0 ? null : null, (r27 & 128) != 0 ? null : SensorPosition.HeartUnlock, (r27 & 256) != 0 ? null : null, (r27 & 512) != 0 ? null : null, (r27 & 1024) != 0 ? false : false);
                            unLockDailyHeartActivity2.finish();
                        }
                    }
                }
            });
            return unlockDailyHeartAdapter;
        }
    });

    /* compiled from: UnLockDailyHeartActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context) {
            kotlin.jvm.internal.s.i(context, "context");
            context.startActivity(new Intent(context, (Class<?>) UnLockDailyHeartActivity.class));
            FKBaseActivity.f11750o.b(context, R$anim.alpha_in, R$anim.anim_activity_nothing_no_duration);
        }
    }

    public UnLockDailyHeartActivity() {
        final Function0 function0 = null;
        this.f16575r = new ViewModelLazy(kotlin.jvm.internal.v.b(UnlockDailyHeartViewModel.class), new Function0<ViewModelStore>() { // from class: com.cupidapp.live.match.activity.UnLockDailyHeartActivity$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = ComponentActivity.this.getViewModelStore();
                kotlin.jvm.internal.s.h(viewModelStore, "viewModelStore");
                return viewModelStore;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.cupidapp.live.match.activity.UnLockDailyHeartActivity$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ViewModelProvider.Factory invoke() {
                ViewModelProvider.Factory defaultViewModelProviderFactory = ComponentActivity.this.getDefaultViewModelProviderFactory();
                kotlin.jvm.internal.s.h(defaultViewModelProviderFactory, "defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        }, new Function0<CreationExtras>() { // from class: com.cupidapp.live.match.activity.UnLockDailyHeartActivity$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = Function0.this;
                if (function02 != null && (creationExtras = (CreationExtras) function02.invoke()) != null) {
                    return creationExtras;
                }
                CreationExtras defaultViewModelCreationExtras = this.getDefaultViewModelCreationExtras();
                kotlin.jvm.internal.s.h(defaultViewModelCreationExtras, "this.defaultViewModelCreationExtras");
                return defaultViewModelCreationExtras;
            }
        });
    }

    public static final void q1(UnLockDailyHeartActivity this$0, StateResult stateResult) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        List list = (List) stateResult.getData();
        if (list != null) {
            this$0.n1().j().clear();
            this$0.n1().j().addAll(list);
            this$0.n1().notifyDataSetChanged();
        }
    }

    @Nullable
    public View k1(int i10) {
        Map<Integer, View> map = this.f16576s;
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

    public final UnlockDailyHeartAdapter n1() {
        return (UnlockDailyHeartAdapter) this.f16574q.getValue();
    }

    public final UnlockDailyHeartViewModel o1() {
        return (UnlockDailyHeartViewModel) this.f16575r.getValue();
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_match_heart_beat);
        d1(R$anim.anim_activity_nothing_no_duration, Integer.valueOf(R$anim.anim_activity_nothing_no_duration));
        r1();
        p1();
        GroupOthersLog.d(GroupOthersLog.f18702a, SensorPosition.HeartUnlock.getValue(), null, null, 6, null);
    }

    public final void p1() {
        o1().getListLiveData().observe(this, new Observer() { // from class: com.cupidapp.live.match.activity.l0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                UnLockDailyHeartActivity.q1(UnLockDailyHeartActivity.this, (StateResult) obj);
            }
        });
    }

    public final void r1() {
        ((FKTitleBarLayout) k1(R$id.match_heart_title)).setLeftImageClickEvent(new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.activity.UnLockDailyHeartActivity$initView$1
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
                UnLockDailyHeartActivity.this.finish();
            }
        });
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, n1().v());
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.cupidapp.live.match.activity.UnLockDailyHeartActivity$initView$manager$1$1
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int i10) {
                UnlockDailyHeartAdapter n12;
                n12 = UnLockDailyHeartActivity.this.n1();
                return n12.u(i10);
            }
        });
        int i10 = R$id.match_heart_rv;
        ((RecyclerView) k1(i10)).setLayoutManager(gridLayoutManager);
        ((RecyclerView) k1(i10)).setAdapter(n1());
        ((RecyclerView) k1(i10)).addItemDecoration(new MutableColumnDecoration(n1(), z0.h.c(this, 5.0f)));
    }
}
