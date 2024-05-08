package com.cupidapp.live.login.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.cupidapp.live.MainActivity;
import com.cupidapp.live.R$anim;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.network.model.StateResult;
import com.cupidapp.live.base.permission.FKRxPermissionAlertDialog;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick;
import com.cupidapp.live.base.utils.j;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.base.view.dialog.FKBottomLoft;
import com.cupidapp.live.login.activity.CompleteInfoAlbumActivity;
import com.cupidapp.live.login.viewmodel.CompleteInfoViewModel;
import com.cupidapp.live.mediapicker.model.CameraStartPosition;
import com.cupidapp.live.mediapicker.newmediapicker.fragment.MediaPickerFragment;
import com.cupidapp.live.mediapicker.newmediapicker.model.MediaType;
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
import z0.y;

/* compiled from: CompleteInfoAvatarActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class CompleteInfoAvatarActivity extends FKBaseActivity {

    /* renamed from: w */
    @NotNull
    public static final a f16069w = new a(null);

    /* renamed from: q */
    @NotNull
    public final Lazy f16070q;

    /* renamed from: t */
    @NotNull
    public final ActivityResultLauncher<Intent> f16073t;

    /* renamed from: u */
    public boolean f16074u;

    /* renamed from: v */
    @NotNull
    public Map<Integer, View> f16075v = new LinkedHashMap();

    /* renamed from: r */
    @NotNull
    public final Lazy f16071r = kotlin.c.b(new Function0<Boolean>() { // from class: com.cupidapp.live.login.activity.CompleteInfoAvatarActivity$returnBack$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final Boolean invoke() {
            return Boolean.valueOf(CompleteInfoAvatarActivity.this.getIntent().getBooleanExtra("RETURN_BACK", true));
        }
    });

    /* renamed from: s */
    @NotNull
    public final Lazy f16072s = kotlin.c.b(new Function0<xb.b>() { // from class: com.cupidapp.live.login.activity.CompleteInfoAvatarActivity$rxPermissions$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final xb.b invoke() {
            return new xb.b(CompleteInfoAvatarActivity.this);
        }
    });

    /* compiled from: CompleteInfoAvatarActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void b(a aVar, Context context, boolean z10, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                z10 = true;
            }
            aVar.a(context, z10);
        }

        public final void a(@Nullable Context context, boolean z10) {
            Intent intent = new Intent(context, (Class<?>) CompleteInfoAvatarActivity.class);
            intent.putExtra("RETURN_BACK", z10);
            if (context != null) {
                context.startActivity(intent);
            }
            FKBaseActivity.f11750o.b(context, 0, R$anim.alpha_out_duration_180);
        }
    }

    public CompleteInfoAvatarActivity() {
        final Function0 function0 = null;
        this.f16070q = new ViewModelLazy(v.b(CompleteInfoViewModel.class), new Function0<ViewModelStore>() { // from class: com.cupidapp.live.login.activity.CompleteInfoAvatarActivity$special$$inlined$viewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.cupidapp.live.login.activity.CompleteInfoAvatarActivity$special$$inlined$viewModels$default$1
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
        }, new Function0<CreationExtras>() { // from class: com.cupidapp.live.login.activity.CompleteInfoAvatarActivity$special$$inlined$viewModels$default$3
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
        ActivityResultLauncher<Intent> registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.cupidapp.live.login.activity.c
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                CompleteInfoAvatarActivity.z1((ActivityResult) obj);
            }
        });
        s.h(registerForActivityResult, "registerForActivityResul…        }\n        }\n    }");
        this.f16073t = registerForActivityResult;
    }

    public static final void w1(CompleteInfoAvatarActivity this$0, StateResult stateResult) {
        s.i(this$0, "this$0");
        if (stateResult instanceof StateResult.c) {
            this$0.f16074u = false;
            MainActivity.F.f(this$0, (r12 & 2) != 0 ? null : null, (r12 & 4) != 0 ? null : null, (r12 & 8) != 0 ? false : true, (r12 & 16) == 0 ? null : null, (r12 & 32) != 0 ? Boolean.FALSE : null);
        } else if (stateResult instanceof StateResult.a) {
            this$0.f16074u = false;
            this$0.V0();
        }
    }

    public static final void z1(ActivityResult activityResult) {
        if (activityResult.getResultCode() == -1) {
            j.f12332a.a("CompleteAlbum", "data: " + ((Object) activityResult.getData()));
        }
    }

    public final void A1() {
        FKBottomLoft.g(FKBottomLoft.f12709e.a(this).m(R$string.upload_avatar_guide_title), R$string.why_upload_my_real_avatar_illustrate, 0, 0, 6, null).k(R$string.choose_photo, new Function0<p>() { // from class: com.cupidapp.live.login.activity.CompleteInfoAvatarActivity$showGuideDialog$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ p invoke() {
                invoke2();
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                CompleteInfoAvatarActivity.this.y1();
                SensorsLogKeyButtonClick.RegisterAddAvatar.AddPhoto.click();
            }
        }).i(R$string.not_upload_yet, new Function0<p>() { // from class: com.cupidapp.live.login.activity.CompleteInfoAvatarActivity$showGuideDialog$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ p invoke() {
                invoke2();
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                CompleteInfoViewModel u12;
                CompleteInfoAvatarActivity.this.f16074u = true;
                CompleteInfoAvatarActivity.this.e1();
                u12 = CompleteInfoAvatarActivity.this.u1();
                u12.saveAvatar(null);
                SensorsLogKeyButtonClick.RegisterAddAvatar.SKIP_UPLOAD.click();
            }
        }).n();
    }

    @Nullable
    public View l1(int i10) {
        Map<Integer, View> map = this.f16075v;
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
        if (!s1() || this.f16074u) {
            return;
        }
        super.onBackPressed();
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_complete_info_avatar);
        d1(0, Integer.valueOf(R$anim.alpha_out_duration_180));
        x1();
        v1();
        r1();
        j1.c.b(j1.c.f50228a, SensorPosition.RegisterAddAvatar, null, null, 6, null);
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        com.cupidapp.live.login.helper.d.f16155a.a(kotlin.collections.s.m(l1(R$id.avatar_title), (FrameLayout) l1(R$id.add_avatar_layout), null, (ConstraintLayout) l1(R$id.avatar_guide_layout)));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        V0();
    }

    public final void r1() {
        int i10 = R$id.avatar_title_layout;
        ((FKTitleBarLayout) l1(i10)).setLeftImageClickEvent(new Function1<View, p>() { // from class: com.cupidapp.live.login.activity.CompleteInfoAvatarActivity$bindClickEvent$1
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
                CompleteInfoAvatarActivity.this.onBackPressed();
            }
        });
        ((FKTitleBarLayout) l1(i10)).setRightTextClickEvent(new Function1<View, p>() { // from class: com.cupidapp.live.login.activity.CompleteInfoAvatarActivity$bindClickEvent$2
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
                CompleteInfoAvatarActivity.this.A1();
            }
        });
        FrameLayout add_avatar_layout = (FrameLayout) l1(R$id.add_avatar_layout);
        s.h(add_avatar_layout, "add_avatar_layout");
        y.d(add_avatar_layout, new Function1<View, p>() { // from class: com.cupidapp.live.login.activity.CompleteInfoAvatarActivity$bindClickEvent$3
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
                CompleteInfoAvatarActivity.this.y1();
                SensorsLogKeyButtonClick.RegisterAddAvatar.AddPhoto.click();
            }
        });
        ImageView imageView = (ImageView) l1(R$id.clear_face_layout).findViewById(R$id.guide_help_imageview);
        s.h(imageView, "clear_face_layout.guide_help_imageview");
        y.d(imageView, new Function1<View, p>() { // from class: com.cupidapp.live.login.activity.CompleteInfoAvatarActivity$bindClickEvent$4
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
                CompleteInfoAvatarActivity.this.A1();
                SensorsLogKeyButtonClick.RegisterAddAvatar.SKIP_HELP.click();
            }
        });
    }

    public final boolean s1() {
        return ((Boolean) this.f16071r.getValue()).booleanValue();
    }

    public final xb.b t1() {
        return (xb.b) this.f16072s.getValue();
    }

    public final CompleteInfoViewModel u1() {
        return (CompleteInfoViewModel) this.f16070q.getValue();
    }

    public final void v1() {
        u1().getCompleteInfoLiveData().observe(this, new Observer() { // from class: com.cupidapp.live.login.activity.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CompleteInfoAvatarActivity.w1(CompleteInfoAvatarActivity.this, (StateResult) obj);
            }
        });
    }

    public final void x1() {
        if (s.d(CompleteInfoViewModel.Companion.a(), Boolean.TRUE)) {
            FKTitleBarLayout avatar_title_layout = (FKTitleBarLayout) l1(R$id.avatar_title_layout);
            s.h(avatar_title_layout, "avatar_title_layout");
            FKTitleBarLayout.setRightText$default(avatar_title_layout, getString(R$string.skip), -3750202, 0, false, 8, null);
        } else {
            ((FKTitleBarLayout) l1(R$id.avatar_title_layout)).setRightTextViewVisible(false);
        }
        ((FKTitleBarLayout) l1(R$id.avatar_title_layout)).setLeftImageVisible(s1());
        View l12 = l1(R$id.avatar_title);
        ((ImageView) l12.findViewById(R$id.title_imageview)).setImageResource(R$mipmap.icon_real_avatar);
        ((TextView) l12.findViewById(R$id.subtitle_textview)).setText(getString(R$string.real_avatar_effect));
        ((TextView) l1(R$id.add_avatar_textview)).getPaint().setFakeBoldText(true);
        View l13 = l1(R$id.clear_face_layout);
        int i10 = R$id.guide_imageview;
        ((ImageView) l13.findViewById(i10)).setImageResource(R$mipmap.icon_clear_face);
        int i11 = R$id.guide_textview;
        ((TextView) l13.findViewById(i11)).setText(getString(R$string.clear_face));
        int i12 = R$id.recommend_imageview;
        ((ImageView) l13.findViewById(i12)).setImageResource(R$mipmap.icon_right);
        int i13 = R$id.guide_help_imageview;
        ((ImageView) l13.findViewById(i13)).setVisibility(0);
        ImageView guide_help_imageview = (ImageView) l13.findViewById(i13);
        s.h(guide_help_imageview, "guide_help_imageview");
        y.d(guide_help_imageview, new Function1<View, p>() { // from class: com.cupidapp.live.login.activity.CompleteInfoAvatarActivity$initView$2$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(View view) {
                invoke2(view);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
            }
        });
        View l14 = l1(R$id.wonderful_figure_layout);
        ((ImageView) l14.findViewById(i10)).setImageResource(R$mipmap.icon_wonderful_figure);
        ((TextView) l14.findViewById(i11)).setText(getString(R$string.wonderful_figure));
        ((ImageView) l14.findViewById(i12)).setImageResource(R$mipmap.icon_right);
        View l15 = l1(R$id.too_much_occlusion_layout);
        ((ImageView) l15.findViewById(i10)).setImageResource(R$mipmap.icon_too_much_occlusion);
        ((TextView) l15.findViewById(i11)).setText(getString(R$string.too_much_occlusion));
        ((ImageView) l15.findViewById(i12)).setImageResource(R$mipmap.icon_wrong);
        View l16 = l1(R$id.landscape_landscape_layout);
        ((ImageView) l16.findViewById(i10)).setImageResource(R$mipmap.icon_landscape_landscape);
        ((TextView) l16.findViewById(i11)).setText(getString(R$string.landscape_landscape));
        ((ImageView) l16.findViewById(i12)).setImageResource(R$mipmap.icon_wrong);
    }

    public final void y1() {
        FKRxPermissionAlertDialog.f12016a.m(this, t1(), (r16 & 4) != 0 ? null : new Function0<p>() { // from class: com.cupidapp.live.login.activity.CompleteInfoAvatarActivity$openAlbum$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ p invoke() {
                invoke2();
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ActivityResultLauncher<Intent> activityResultLauncher;
                MediaPickerFragment.Config config = new MediaPickerFragment.Config(MediaType.IMAGE, true, false, false, false, CameraStartPosition.Avatar, SensorPosition.RegisterAddAvatar, null, 152, null);
                CompleteInfoAlbumActivity.a aVar = CompleteInfoAlbumActivity.f16067v;
                CompleteInfoAvatarActivity completeInfoAvatarActivity = CompleteInfoAvatarActivity.this;
                activityResultLauncher = completeInfoAvatarActivity.f16073t;
                aVar.a(completeInfoAvatarActivity, activityResultLauncher, config);
            }
        }, (r16 & 8) != 0 ? null : null, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? R$string.need_access_media_upload_better : 0);
    }
}
