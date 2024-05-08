package com.cupidapp.live.match.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.cupidapp.live.R$anim;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.network.model.RewardDetailModel;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.base.view.button.FKUniversalButton;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: NormalRewardCardActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class NormalRewardCardActivity extends FKBaseActivity {

    /* renamed from: u, reason: collision with root package name */
    @NotNull
    public static final a f16539u = new a(null);

    /* renamed from: s, reason: collision with root package name */
    @Nullable
    public String f16542s;

    /* renamed from: t, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16543t = new LinkedHashMap();

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public final Lazy f16540q = kotlin.c.b(new Function0<String>() { // from class: com.cupidapp.live.match.activity.NormalRewardCardActivity$taskId$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final String invoke() {
            String stringExtra = NormalRewardCardActivity.this.getIntent().getStringExtra(MonitorConstants.EXTRA_DOWNLOAD_TASK_ID);
            return stringExtra == null ? "" : stringExtra;
        }
    });

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public final Lazy f16541r = kotlin.c.b(new Function0<String>() { // from class: com.cupidapp.live.match.activity.NormalRewardCardActivity$taskType$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final String invoke() {
            String stringExtra = NormalRewardCardActivity.this.getIntent().getStringExtra("task_type");
            return stringExtra == null ? "" : stringExtra;
        }
    });

    /* compiled from: NormalRewardCardActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@Nullable Context context, @NotNull String taskId, @Nullable String str) {
            kotlin.jvm.internal.s.i(taskId, "taskId");
            if (context == null) {
                return;
            }
            Intent intent = new Intent(context, (Class<?>) NormalRewardCardActivity.class);
            intent.putExtra(MonitorConstants.EXTRA_DOWNLOAD_TASK_ID, taskId);
            intent.putExtra("task_type", str);
            context.startActivity(intent);
            FKBaseActivity.f11750o.b(context, R$anim.anim_activity_bottom_to_top, R$anim.anmi_stop);
        }
    }

    @Nullable
    public View j1(int i10) {
        Map<Integer, View> map = this.f16543t;
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

    public final void o1() {
        ((FKTitleBarLayout) j1(R$id.card_super_like_title)).setLeftImageClickEvent(new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.activity.NormalRewardCardActivity$bindEvent$1
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
                NormalRewardCardActivity.this.finish();
            }
        });
        FKUniversalButton card_super_like_btn = (FKUniversalButton) j1(R$id.card_super_like_btn);
        kotlin.jvm.internal.s.h(card_super_like_btn, "card_super_like_btn");
        z0.y.d(card_super_like_btn, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.activity.NormalRewardCardActivity$bindEvent$2
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
                String taskId;
                String q12;
                x2.a N = NetworkClient.f11868a.N();
                taskId = NormalRewardCardActivity.this.p1();
                kotlin.jvm.internal.s.h(taskId, "taskId");
                q12 = NormalRewardCardActivity.this.q1();
                Observable<Result<Object>> D = N.D(taskId, q12);
                final NormalRewardCardActivity normalRewardCardActivity = NormalRewardCardActivity.this;
                NormalRewardCardActivity normalRewardCardActivity2 = normalRewardCardActivity instanceof com.cupidapp.live.base.network.g ? normalRewardCardActivity : null;
                Disposable disposed = D.flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.match.activity.NormalRewardCardActivity$bindEvent$2$invoke$$inlined$handleByContext$default$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                        invoke2(obj);
                        return kotlin.p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object obj) {
                        String str;
                        j.a aVar = com.cupidapp.live.base.router.j.f12156c;
                        NormalRewardCardActivity normalRewardCardActivity3 = NormalRewardCardActivity.this;
                        str = normalRewardCardActivity3.f16542s;
                        j.a.b(aVar, normalRewardCardActivity3, str, null, 4, null);
                        NormalRewardCardActivity.this.finish();
                    }
                }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, normalRewardCardActivity2)));
                if (disposed != null) {
                    kotlin.jvm.internal.s.h(disposed, "disposed");
                    if (normalRewardCardActivity2 != null) {
                        normalRewardCardActivity2.H(disposed);
                    }
                }
                kotlin.jvm.internal.s.h(disposed, "disposed");
            }
        });
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        d1(R$anim.anmi_stop, Integer.valueOf(R$anim.anim_activity_top_to_bottom));
        setContentView(R$layout.activity_normal_reward);
        r1();
        o1();
    }

    public final String p1() {
        return (String) this.f16540q.getValue();
    }

    public final String q1() {
        return (String) this.f16541r.getValue();
    }

    public final void r1() {
        x2.a N = NetworkClient.f11868a.N();
        String taskId = p1();
        kotlin.jvm.internal.s.h(taskId, "taskId");
        Disposable disposed = N.o0(taskId, q1()).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<RewardDetailModel, kotlin.p>() { // from class: com.cupidapp.live.match.activity.NormalRewardCardActivity$initReward$$inlined$handleByContext$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(RewardDetailModel rewardDetailModel) {
                m2703invoke(rewardDetailModel);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2703invoke(RewardDetailModel rewardDetailModel) {
                RewardDetailModel rewardDetailModel2 = rewardDetailModel;
                ImageLoaderView task_reward_img = (ImageLoaderView) NormalRewardCardActivity.this.j1(R$id.task_reward_img);
                kotlin.jvm.internal.s.h(task_reward_img, "task_reward_img");
                ImageLoaderView.g(task_reward_img, rewardDetailModel2.getIcon(), null, null, 6, null);
                ((TextView) NormalRewardCardActivity.this.j1(R$id.task_reward_name)).setText(rewardDetailModel2.getTitle());
                ((TextView) NormalRewardCardActivity.this.j1(R$id.task_reward_des)).setText(rewardDetailModel2.getDesc());
                ((TextView) NormalRewardCardActivity.this.j1(R$id.task_reward_expire_txt)).setText(rewardDetailModel2.getValidTime());
                NormalRewardCardActivity.this.f16542s = rewardDetailModel2.getJumpUrl();
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
            H(disposed);
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }
}
