package com.cupidapp.live.login.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResultLauncher;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.network.model.StateResult;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick;
import com.cupidapp.live.base.view.FKCropImageLayout;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.login.activity.CompleteInfoWelcomeActivity;
import com.cupidapp.live.login.layout.LoginNextButton;
import com.cupidapp.live.login.viewmodel.CompleteInfoViewModel;
import com.cupidapp.live.mediapicker.helper.FKFireBaseDetectorOptionsKt;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.jvm.internal.v;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.k;
import z0.y;

/* compiled from: CompleteInfoCutAvatarActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class CompleteInfoCutAvatarActivity extends FKBaseActivity {

    /* renamed from: v, reason: collision with root package name */
    @NotNull
    public static final a f16076v = new a(null);

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public final Lazy f16077q;

    /* renamed from: r, reason: collision with root package name */
    @Nullable
    public File f16078r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f16079s;

    /* renamed from: t, reason: collision with root package name */
    @Nullable
    public String f16080t;

    /* renamed from: u, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16081u = new LinkedHashMap();

    /* compiled from: CompleteInfoCutAvatarActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull ActivityResultLauncher<Intent> launcher, @NotNull String path, @Nullable String str) {
            s.i(context, "context");
            s.i(launcher, "launcher");
            s.i(path, "path");
            Intent intent = new Intent(context, (Class<?>) CompleteInfoCutAvatarActivity.class);
            intent.putExtra("AVATAR_PATH", path);
            intent.putExtra("ORIGIN_PAGE", str);
            launcher.launch(intent);
            FKBaseActivity.a.c(FKBaseActivity.f11750o, context, 0, 0, 6, null);
        }
    }

    public CompleteInfoCutAvatarActivity() {
        final Function0 function0 = null;
        this.f16077q = new ViewModelLazy(v.b(CompleteInfoViewModel.class), new Function0<ViewModelStore>() { // from class: com.cupidapp.live.login.activity.CompleteInfoCutAvatarActivity$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = ComponentActivity.this.getViewModelStore();
                s.h(viewModelStore, "viewModelStore");
                return viewModelStore;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.cupidapp.live.login.activity.CompleteInfoCutAvatarActivity$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ViewModelProvider.Factory invoke() {
                ViewModelProvider.Factory defaultViewModelProviderFactory = ComponentActivity.this.getDefaultViewModelProviderFactory();
                s.h(defaultViewModelProviderFactory, "defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        }, new Function0<CreationExtras>() { // from class: com.cupidapp.live.login.activity.CompleteInfoCutAvatarActivity$special$$inlined$viewModels$default$3
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
                s.h(defaultViewModelCreationExtras, "this.defaultViewModelCreationExtras");
                return defaultViewModelCreationExtras;
            }
        });
    }

    public static final void s1(CompleteInfoCutAvatarActivity this$0, StateResult stateResult) {
        s.i(this$0, "this$0");
        if (stateResult instanceof StateResult.b) {
            this$0.f16079s = true;
            ((LoginNextButton) this$0.k1(R$id.cut_avatar_next_button)).e();
            return;
        }
        if (stateResult instanceof StateResult.c) {
            this$0.f16079s = false;
            CompleteInfoWelcomeActivity.a aVar = CompleteInfoWelcomeActivity.f16086s;
            File file = this$0.f16078r;
            s.f(file);
            String path = file.getPath();
            s.h(path, "avatarFile!!.path");
            aVar.a(this$0, path);
            return;
        }
        if (stateResult instanceof StateResult.a) {
            this$0.f16079s = false;
            ((LoginNextButton) this$0.k1(R$id.cut_avatar_next_button)).b();
        }
    }

    @Nullable
    public View k1(int i10) {
        Map<Integer, View> map = this.f16081u;
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

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.f16079s) {
            return;
        }
        super.onBackPressed();
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_complete_info_cut_avatar);
        t1();
        r1();
        p1();
        this.f16080t = getIntent().getStringExtra("ORIGIN_PAGE");
        j1.c.b(j1.c.f50228a, SensorPosition.RegisterImageCrop, null, null, 6, null);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        ((LoginNextButton) k1(R$id.cut_avatar_next_button)).b();
    }

    public final void p1() {
        ((FKTitleBarLayout) k1(R$id.cut_avatar_title_layout)).setLeftImageClickEvent(new Function1<View, p>() { // from class: com.cupidapp.live.login.activity.CompleteInfoCutAvatarActivity$bindClickEvent$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(View view) {
                invoke2(view);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                CompleteInfoCutAvatarActivity.this.onBackPressed();
            }
        });
        LoginNextButton cut_avatar_next_button = (LoginNextButton) k1(R$id.cut_avatar_next_button);
        s.h(cut_avatar_next_button, "cut_avatar_next_button");
        y.d(cut_avatar_next_button, new Function1<View, p>() { // from class: com.cupidapp.live.login.activity.CompleteInfoCutAvatarActivity$bindClickEvent$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(View view) {
                invoke2(view);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                CompleteInfoCutAvatarActivity.this.u1();
                SensorsLogKeyButtonClick.RegisterImageCrop.Complete.click();
            }
        });
    }

    public final CompleteInfoViewModel q1() {
        return (CompleteInfoViewModel) this.f16077q.getValue();
    }

    public final void r1() {
        q1().getCompleteInfoLiveData().observe(this, new Observer() { // from class: com.cupidapp.live.login.activity.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CompleteInfoCutAvatarActivity.s1(CompleteInfoCutAvatarActivity.this, (StateResult) obj);
            }
        });
    }

    public final void t1() {
        ((FKCropImageLayout) k1(R$id.cut_avatar_image_layout)).setImageFromPath(getIntent().getStringExtra("AVATAR_PATH"));
        ((LoginNextButton) k1(R$id.cut_avatar_next_button)).setSelected(true);
    }

    public final void u1() {
        Bitmap w3 = ((FKCropImageLayout) k1(R$id.cut_avatar_image_layout)).w(500.0f);
        File i10 = k.f54819a.i(this, System.currentTimeMillis() + "_avatar.jpg");
        this.f16078r = i10;
        if (w3 == null || i10 == null) {
            return;
        }
        s.f(i10);
        z0.f.f(w3, i10, 100);
        File file = this.f16078r;
        s.f(file);
        String path = file.getPath();
        s.h(path, "avatarFile!!.path");
        FKFireBaseDetectorOptionsKt.h(this, path, new Function1<Boolean, p>() { // from class: com.cupidapp.live.login.activity.CompleteInfoCutAvatarActivity$saveAvatar$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return p.f51048a;
            }

            public final void invoke(boolean z10) {
                CompleteInfoViewModel q12;
                File file2;
                String str;
                q12 = CompleteInfoCutAvatarActivity.this.q1();
                CompleteInfoCutAvatarActivity completeInfoCutAvatarActivity = CompleteInfoCutAvatarActivity.this;
                file2 = completeInfoCutAvatarActivity.f16078r;
                s.f(file2);
                str = CompleteInfoCutAvatarActivity.this.f16080t;
                q12.uploadAvatar(completeInfoCutAvatarActivity, file2, z10, str);
            }
        });
    }
}
