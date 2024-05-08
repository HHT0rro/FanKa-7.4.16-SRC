package com.cupidapp.live.liveshow.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.extension.ImageAttributeModel;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.network.j;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.network.model.UploadImageFileResult;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorsLogFeed;
import com.cupidapp.live.base.view.FKCropImageLayout;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.base.view.dialog.h;
import com.cupidapp.live.mediapicker.helper.FKFireBaseDetectorOptionsKt;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.io.File;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.k;
import z0.l;
import z0.y;

/* compiled from: FKLiveCoverCropActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveCoverCropActivity extends FKBaseActivity {

    /* renamed from: t, reason: collision with root package name */
    @NotNull
    public static final a f14748t = new a(null);

    /* renamed from: r, reason: collision with root package name */
    public long f14750r;

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f14751s = new LinkedHashMap();

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public final Lazy f14749q = kotlin.c.b(new Function0<SensorPosition>() { // from class: com.cupidapp.live.liveshow.activity.FKLiveCoverCropActivity$mSource$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @Nullable
        public final SensorPosition invoke() {
            Serializable serializableExtra = FKLiveCoverCropActivity.this.getIntent().getSerializableExtra("LIVE_COVER_CROP_SOURCE");
            if (serializableExtra instanceof SensorPosition) {
                return (SensorPosition) serializableExtra;
            }
            return null;
        }
    });

    /* compiled from: FKLiveCoverCropActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull ActivityResultLauncher<Intent> launcher, @NotNull String path, @Nullable SensorPosition sensorPosition) {
            s.i(context, "context");
            s.i(launcher, "launcher");
            s.i(path, "path");
            Intent intent = new Intent(context, (Class<?>) FKLiveCoverCropActivity.class);
            intent.putExtra("LIVE_COVER_CROP_IMAGE_PATH", path);
            intent.putExtra("LIVE_COVER_CROP_SOURCE", sensorPosition);
            launcher.launch(intent);
            FKBaseActivity.a.c(FKBaseActivity.f11750o, context, 0, 0, 6, null);
        }
    }

    /* compiled from: FKLiveCoverCropActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14752a;

        static {
            int[] iArr = new int[SensorPosition.values().length];
            try {
                iArr[SensorPosition.PreviewLiveShow.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SensorPosition.PREVIEW_CONSULT_SHOW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f14752a = iArr;
        }
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity
    @NotNull
    public SensorPosition Q0() {
        SensorPosition r12 = r1();
        if ((r12 == null ? -1 : b.f14752a[r12.ordinal()]) == 1) {
            return SensorPosition.LivePageCutCover;
        }
        return SensorPosition.ConsultPageCutCover;
    }

    @Nullable
    public View j1(int i10) {
        Map<Integer, View> map = this.f14751s;
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
        setContentView(R$layout.activity_live_cover_crop);
        s1();
        p1();
        t1();
    }

    public final void p1() {
        ((FKTitleBarLayout) j1(R$id.live_cover_crop_image_title)).setLeftImageClickEvent(new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.activity.FKLiveCoverCropActivity$bindClickEvent$1
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
                FKLiveCoverCropActivity.this.onBackPressed();
            }
        });
        TextView live_cover_crop_image_save_btn = (TextView) j1(R$id.live_cover_crop_image_save_btn);
        s.h(live_cover_crop_image_save_btn, "live_cover_crop_image_save_btn");
        y.d(live_cover_crop_image_save_btn, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.activity.FKLiveCoverCropActivity$bindClickEvent$2
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
                FKLiveCoverCropActivity.this.q1();
            }
        });
    }

    public final void q1() {
        h hVar = h.f12743a;
        h.d(hVar, getString(R$string.uploading), false, 2, null);
        Bitmap w3 = ((FKCropImageLayout) j1(R$id.live_cover_crop_image_layout)).w(1080.0f);
        final File i10 = k.f54819a.i(this, System.currentTimeMillis() + "_live_cover.jpg");
        if (w3 != null && i10 != null) {
            z0.f.f(w3, i10, 100);
            String path = i10.getPath();
            s.h(path, "file.path");
            FKFireBaseDetectorOptionsKt.h(this, path, new Function1<Boolean, p>() { // from class: com.cupidapp.live.liveshow.activity.FKLiveCoverCropActivity$clickSaveBtn$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return p.f51048a;
                }

                public final void invoke(boolean z10) {
                    FKLiveCoverCropActivity.this.x1(i10, z10);
                }
            });
            return;
        }
        hVar.b();
    }

    public final SensorPosition r1() {
        return (SensorPosition) this.f14749q.getValue();
    }

    public final void s1() {
        ((FKCropImageLayout) j1(R$id.live_cover_crop_image_layout)).setImageFromPath(getIntent().getStringExtra("LIVE_COVER_CROP_IMAGE_PATH"));
    }

    public final void t1() {
        j1.c.b(j1.c.f50228a, Q0(), null, null, 6, null);
    }

    public final void u1(long j10, int i10, int i11, Throwable th) {
        SensorsLogFeed.UploadFileType uploadFileType;
        String str;
        long currentTimeMillis = System.currentTimeMillis() - this.f14750r;
        SensorPosition r12 = r1();
        if ((r12 == null ? -1 : b.f14752a[r12.ordinal()]) == 1) {
            uploadFileType = SensorsLogFeed.UploadFileType.LIVE_SHOW_COVER;
        } else {
            uploadFileType = SensorsLogFeed.UploadFileType.CONSULT_COVER;
        }
        SensorsLogFeed.UploadFileType uploadFileType2 = uploadFileType;
        SensorsLogFeed sensorsLogFeed = SensorsLogFeed.f12208a;
        SensorPosition r13 = r1();
        boolean z10 = th == null;
        String a10 = j.f12008a.a(th);
        if (a10 == null) {
            str = th != null ? th.getMessage() : null;
        } else {
            str = a10;
        }
        sensorsLogFeed.O(currentTimeMillis, j10, i10, i11, uploadFileType2, "图片", r13, z10, str, (r33 & 512) != 0 ? null : null, (r33 & 1024) != 0 ? null : null, (r33 & 2048) != 0 ? null : null);
    }

    public final void v1(final ImageModel imageModel) {
        SensorPosition r12 = r1();
        int i10 = r12 == null ? -1 : b.f14752a[r12.ordinal()];
        if (i10 == 1) {
            Disposable disposed = NetworkClient.f11868a.r().d(imageModel.getImageId()).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.activity.FKLiveCoverCropActivity$saveLiveCoverImage$$inlined$handle$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(Object obj) {
                    invoke2(obj);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object obj) {
                    com.cupidapp.live.base.view.h.f12779a.l(FKLiveCoverCropActivity.this, R$string.uploaded_success_cover_under_review);
                    h.f12743a.b();
                    FKLiveCoverCropActivity.this.w1(imageModel);
                }
            }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.liveshow.activity.FKLiveCoverCropActivity$saveLiveCoverImage$2
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull Throwable it) {
                    s.i(it, "it");
                    h.f12743a.b();
                    return Boolean.FALSE;
                }
            }, this)));
            if (disposed != null) {
                s.h(disposed, "disposed");
                H(disposed);
            }
            s.h(disposed, "disposed");
            return;
        }
        if (i10 != 2) {
            return;
        }
        Disposable disposed2 = NetworkClient.f11868a.v().f(imageModel.getImageId()).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.activity.FKLiveCoverCropActivity$saveLiveCoverImage$$inlined$handle$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Object obj) {
                invoke2(obj);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
                com.cupidapp.live.base.view.h.f12779a.l(FKLiveCoverCropActivity.this, R$string.uploaded_success_cover_under_review);
                h.f12743a.b();
                FKLiveCoverCropActivity.this.w1(imageModel);
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.liveshow.activity.FKLiveCoverCropActivity$saveLiveCoverImage$4
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                s.i(it, "it");
                h.f12743a.b();
                return Boolean.FALSE;
            }
        }, this)));
        if (disposed2 != null) {
            s.h(disposed2, "disposed");
            H(disposed2);
        }
        s.h(disposed2, "disposed");
    }

    public final void w1(ImageModel imageModel) {
        Intent intent = new Intent();
        intent.putExtra("ACTIVITY_RESULT_IMAGE_MODEL", imageModel);
        setResult(-1, intent);
        finish();
    }

    public final void x1(File file, boolean z10) {
        this.f14750r = System.currentTimeMillis();
        final long a10 = l.a(file);
        ImageAttributeModel l10 = z0.f.l(this, file.getPath());
        final int width = l10.getWidth();
        final int height = l10.getHeight();
        Disposable disposed = NetworkClient.f11868a.i().f(com.cupidapp.live.base.network.f.a(file), Boolean.valueOf(z10)).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<UploadImageFileResult, p>() { // from class: com.cupidapp.live.liveshow.activity.FKLiveCoverCropActivity$uploadLiveCoverImage$$inlined$handle$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(UploadImageFileResult uploadImageFileResult) {
                m2592invoke(uploadImageFileResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2592invoke(UploadImageFileResult uploadImageFileResult) {
                FKLiveCoverCropActivity.this.u1(a10, width, height, null);
                FKLiveCoverCropActivity.this.v1(uploadImageFileResult.getImage());
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.liveshow.activity.FKLiveCoverCropActivity$uploadLiveCoverImage$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                s.i(it, "it");
                FKLiveCoverCropActivity.this.u1(a10, width, height, it);
                h.f12743a.b();
                return Boolean.FALSE;
            }
        }, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }
}
