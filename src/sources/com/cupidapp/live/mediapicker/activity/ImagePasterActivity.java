package com.cupidapp.live.mediapicker.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.cupidapp.live.R$anim;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.livedata.EventObserver;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.utils.ImageResizeUtils;
import com.cupidapp.live.hashtag.model.HashTagSimpleModel;
import com.cupidapp.live.mediapicker.fragment.ImagePasterFragment;
import com.cupidapp.live.mediapicker.fragment.ImagePasterSourceModel;
import com.cupidapp.live.mediapicker.fragment.ImagePasterTrimFragment;
import com.cupidapp.live.mediapicker.model.CameraStartPosition;
import com.cupidapp.live.mediapicker.model.FrameAspectRatio;
import com.cupidapp.live.mediapicker.model.ImageTrimModel;
import com.cupidapp.live.mediapicker.newmediapicker.fragment.MediaPickerFragment;
import com.cupidapp.live.mediapicker.newmediapicker.model.LocalMedia;
import com.cupidapp.live.mediapicker.newmediapicker.model.MediaType;
import com.cupidapp.live.mediapicker.newmediapicker.model.MimeType;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.r;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.jvm.internal.v;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ImagePasterActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ImagePasterActivity extends FKBaseActivity {

    /* renamed from: v, reason: collision with root package name */
    @NotNull
    public static final a f17098v = new a(null);

    /* renamed from: q, reason: collision with root package name */
    @Nullable
    public String f17099q;

    /* renamed from: r, reason: collision with root package name */
    @Nullable
    public HashTagSimpleModel f17100r;

    /* renamed from: s, reason: collision with root package name */
    @Nullable
    public View f17101s;

    /* renamed from: t, reason: collision with root package name */
    @NotNull
    public final Lazy f17102t;

    /* renamed from: u, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17103u = new LinkedHashMap();

    /* compiled from: ImagePasterActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @Nullable String str, @Nullable HashTagSimpleModel hashTagSimpleModel) {
            s.i(context, "context");
            Intent intent = new Intent(context, (Class<?>) ImagePasterActivity.class);
            intent.putExtra(TTDownloadField.TT_WEB_TITLE, str);
            intent.putExtra("hashTagSimple", hashTagSimpleModel);
            context.startActivity(intent);
        }
    }

    /* compiled from: ImagePasterActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b implements MediaPickerFragment.b {
        public b() {
        }

        @Override // com.cupidapp.live.mediapicker.newmediapicker.fragment.MediaPickerFragment.b
        public void a() {
            ImagePasterActivity.this.onBackPressed();
        }

        @Override // com.cupidapp.live.mediapicker.newmediapicker.fragment.MediaPickerFragment.b
        public void b(int i10) {
            MediaPickerFragment.b.a.e(this, i10);
        }

        @Override // com.cupidapp.live.mediapicker.newmediapicker.fragment.MediaPickerFragment.b
        public void c(@NotNull List<String> list) {
            MediaPickerFragment.b.a.a(this, list);
        }

        @Override // com.cupidapp.live.mediapicker.newmediapicker.fragment.MediaPickerFragment.b
        public void d(long j10, int i10, int i11) {
            MediaPickerFragment.b.a.d(this, j10, i10, i11);
        }

        @Override // com.cupidapp.live.mediapicker.newmediapicker.fragment.MediaPickerFragment.b
        public void e(@NotNull LocalMedia media, int i10) {
            s.i(media, "media");
            ImagePasterActivity.this.t1(media);
        }

        @Override // com.cupidapp.live.mediapicker.newmediapicker.fragment.MediaPickerFragment.b
        public void f() {
        }
    }

    public ImagePasterActivity() {
        final Function0 function0 = null;
        this.f17102t = new ViewModelLazy(v.b(ImagePasterViewModel.class), new Function0<ViewModelStore>() { // from class: com.cupidapp.live.mediapicker.activity.ImagePasterActivity$special$$inlined$viewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.cupidapp.live.mediapicker.activity.ImagePasterActivity$special$$inlined$viewModels$default$1
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
        }, new Function0<CreationExtras>() { // from class: com.cupidapp.live.mediapicker.activity.ImagePasterActivity$special$$inlined$viewModels$default$3
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

    public static final void v1(ImagePasterActivity this$0, ImageTrimModel model) {
        s.i(this$0, "this$0");
        s.i(model, "$model");
        this$0.getSupportFragmentManager().beginTransaction().add(R$id.fragment_container, ImagePasterTrimFragment.f17184j.a(model, ((RelativeLayout) this$0.k1(R$id.paster_root)).getHeight())).setCustomAnimations(R$anim.anim_activity_common_start, 0, 0, R$anim.anim_activity_common_hide_by_start).addToBackStack(null).commit();
    }

    @Nullable
    public View k1(int i10) {
        Map<Integer, View> map = this.f17103u;
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

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, @Nullable Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i11 == -1 && i10 == 1212) {
            finish();
        }
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        q1().changeLoadingState(false);
        super.onBackPressed();
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_image_paster);
        this.f17099q = getIntent().getStringExtra(TTDownloadField.TT_WEB_TITLE);
        Serializable serializableExtra = getIntent().getSerializableExtra("hashTagSimple");
        this.f17100r = serializableExtra instanceof HashTagSimpleModel ? (HashTagSimpleModel) serializableExtra : null;
        this.f17101s = findViewById(R$id.paster_progress_bar);
        w1();
        r1();
    }

    public final ImagePasterViewModel q1() {
        return (ImagePasterViewModel) this.f17102t.getValue();
    }

    public final void r1() {
        q1().getShowLoading().observe(this, new EventObserver(new Function1<Boolean, p>() { // from class: com.cupidapp.live.mediapicker.activity.ImagePasterActivity$initObserve$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return p.f51048a;
            }

            public final void invoke(boolean z10) {
                View view;
                View view2;
                if (z10) {
                    view2 = ImagePasterActivity.this.f17101s;
                    if (view2 == null) {
                        return;
                    }
                    view2.setVisibility(0);
                    return;
                }
                view = ImagePasterActivity.this.f17101s;
                if (view == null) {
                    return;
                }
                view.setVisibility(8);
            }
        }));
        q1().getOpenImageTrimFragment().observe(this, new EventObserver(new Function1<ImageTrimModel, p>() { // from class: com.cupidapp.live.mediapicker.activity.ImagePasterActivity$initObserve$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(ImageTrimModel imageTrimModel) {
                invoke2(imageTrimModel);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull ImageTrimModel model) {
                s.i(model, "model");
                ImagePasterActivity.this.u1(model);
            }
        }));
    }

    public final void s1(LocalMedia localMedia, String str) {
        getSupportFragmentManager().beginTransaction().add(R$id.fragment_container, ImagePasterFragment.f17177j.a(new ImagePasterSourceModel(localMedia.d(), str, FrameAspectRatio.THREE_TO_FOUR, localMedia.c(), this.f17099q, this.f17100r))).setCustomAnimations(R$anim.anim_activity_common_start, 0, 0, R$anim.anim_activity_common_hide_by_start).addToBackStack(null).commit();
    }

    public final void t1(final LocalMedia localMedia) {
        final String d10 = localMedia.d();
        if (d10 == null || !MimeType.Companion.a(localMedia.c())) {
            return;
        }
        q1().changeLoadingState(true);
        ImageResizeUtils.f12268a.m(this, this, r.e(d10), new Function1<Map<String, String>, p>() { // from class: com.cupidapp.live.mediapicker.activity.ImagePasterActivity$pickMediaSuccess$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Map<String, String> map) {
                invoke2(map);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Map<String, String> map) {
                ImagePasterViewModel q12;
                String str;
                q12 = ImagePasterActivity.this.q1();
                q12.changeLoadingState(false);
                if ((map == null || map.isEmpty()) || (str = map.get(d10)) == null) {
                    return;
                }
                ImagePasterActivity.this.s1(localMedia, str);
            }
        }, null, FrameAspectRatio.THREE_TO_FOUR);
    }

    public final void u1(final ImageTrimModel imageTrimModel) {
        ((RelativeLayout) k1(R$id.paster_root)).post(new Runnable() { // from class: com.cupidapp.live.mediapicker.activity.g
            @Override // java.lang.Runnable
            public final void run() {
                ImagePasterActivity.v1(ImagePasterActivity.this, imageTrimModel);
            }
        });
    }

    public final void w1() {
        getSupportFragmentManager().beginTransaction().replace(R$id.fragment_container, MediaPickerFragment.f17279p.b(new MediaPickerFragment.Config(MediaType.IMAGE, true, false, false, false, CameraStartPosition.Web, SensorPosition.Web, this.f17099q), new b())).setCustomAnimations(R$anim.anim_activity_bottom_to_top, R$anim.anim_activity_top_to_bottom).commitAllowingStateLoss();
    }
}
