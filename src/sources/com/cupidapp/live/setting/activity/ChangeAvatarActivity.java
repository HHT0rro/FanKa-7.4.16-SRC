package com.cupidapp.live.setting.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.FragmentTransaction;
import com.cupidapp.live.R$anim;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.extension.ImageAttributeModel;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.network.model.UploadImageFileResult;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorsLogFeed;
import com.cupidapp.live.base.utils.ImageResizeUtils;
import com.cupidapp.live.main.model.UserModifyResult;
import com.cupidapp.live.match.event.FakeUserUploadAvatarEvent;
import com.cupidapp.live.mediapicker.helper.FKFireBaseDetectorOptionsKt;
import com.cupidapp.live.mediapicker.model.CameraStartPosition;
import com.cupidapp.live.mediapicker.newmediapicker.fragment.MediaPickerFragment;
import com.cupidapp.live.mediapicker.newmediapicker.model.LocalMedia;
import com.cupidapp.live.mediapicker.newmediapicker.model.MediaType;
import com.cupidapp.live.mediapicker.newmediapicker.model.MimeType;
import com.cupidapp.live.notify.model.RefreshAttentionNotifyEvent;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.setting.fragment.FKBaseCropImageFragment;
import com.cupidapp.live.setting.fragment.FKCropImageFragment;
import com.cupidapp.live.setting.model.FKCropImageModel;
import com.cupidapp.live.track.group.GroupOthersLog;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ChangeAvatarActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ChangeAvatarActivity extends FKBaseActivity {

    /* renamed from: x, reason: collision with root package name */
    @NotNull
    public static final a f17927x = new a(null);

    /* renamed from: q, reason: collision with root package name */
    @Nullable
    public MediaPickerFragment f17928q;

    /* renamed from: r, reason: collision with root package name */
    @Nullable
    public FKBaseCropImageFragment f17929r;

    /* renamed from: t, reason: collision with root package name */
    public boolean f17931t;

    /* renamed from: u, reason: collision with root package name */
    @Nullable
    public ActivityResultLauncher<Intent> f17932u;

    /* renamed from: v, reason: collision with root package name */
    public long f17933v;

    /* renamed from: w, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17934w = new LinkedHashMap();

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    public final Lazy f17930s = kotlin.c.b(new Function0<ChangeAvatarModel>() { // from class: com.cupidapp.live.setting.activity.ChangeAvatarActivity$changeAvatarModel$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @Nullable
        public final ChangeAvatarModel invoke() {
            Intent intent = ChangeAvatarActivity.this.getIntent();
            kotlin.jvm.internal.s.h(intent, "intent");
            return (ChangeAvatarModel) z0.g.a(intent, ChangeAvatarModel.class);
        }
    });

    /* compiled from: ChangeAvatarActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@Nullable Context context, @NotNull ChangeAvatarModel changeAvatarModel) {
            kotlin.jvm.internal.s.i(changeAvatarModel, "changeAvatarModel");
            Intent intent = new Intent(context, (Class<?>) ChangeAvatarActivity.class);
            z0.g.c(intent, changeAvatarModel);
            if (context != null) {
                context.startActivity(intent);
            }
            FKBaseActivity.f11750o.b(context, R$anim.anim_activity_bottom_to_top, R$anim.anim_activity_nothing);
        }
    }

    /* compiled from: ChangeAvatarActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b implements MediaPickerFragment.b {
        public b() {
        }

        @Override // com.cupidapp.live.mediapicker.newmediapicker.fragment.MediaPickerFragment.b
        public void a() {
            ChangeAvatarActivity.this.finish();
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
            kotlin.jvm.internal.s.i(media, "media");
            ChangeAvatarActivity.this.f17931t = false;
            ChangeAvatarActivity.this.z1(media);
        }

        @Override // com.cupidapp.live.mediapicker.newmediapicker.fragment.MediaPickerFragment.b
        public void f() {
        }
    }

    public static final void w1(ChangeAvatarActivity this$0, ActivityResult activityResult) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        if (activityResult.getResultCode() == -1) {
            this$0.finish();
        }
    }

    public final void A1(long j10, int i10, int i11, Throwable th, String str) {
        SensorPosition changeAvatarPosition;
        long currentTimeMillis = System.currentTimeMillis() - this.f17933v;
        SensorsLogFeed sensorsLogFeed = SensorsLogFeed.f12208a;
        SensorsLogFeed.UploadFileType uploadFileType = SensorsLogFeed.UploadFileType.AVATAR;
        SensorPosition sensorPosition = SensorPosition.EditAvatar;
        boolean z10 = th == null;
        String a10 = com.cupidapp.live.base.network.j.f12008a.a(th);
        String message = a10 == null ? th != null ? th.getMessage() : null : a10;
        ChangeAvatarModel v12 = v1();
        sensorsLogFeed.O(currentTimeMillis, j10, i10, i11, uploadFileType, "图片", sensorPosition, z10, message, (r33 & 512) != 0 ? null : str, (r33 & 1024) != 0 ? null : null, (r33 & 2048) != 0 ? null : (v12 == null || (changeAvatarPosition = v12.getChangeAvatarPosition()) == null) ? null : changeAvatarPosition.getValue());
    }

    public final void B1(final File file) {
        String path = file.getPath();
        kotlin.jvm.internal.s.h(path, "file.path");
        FKFireBaseDetectorOptionsKt.h(this, path, new Function1<Boolean, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.ChangeAvatarActivity$uploadImageAndChangeAvatar$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return kotlin.p.f51048a;
            }

            public final void invoke(boolean z10) {
                ChangeAvatarActivity.this.f17933v = System.currentTimeMillis();
                final long a10 = z0.l.a(file);
                ImageAttributeModel l10 = z0.f.l(ChangeAvatarActivity.this, file.getPath());
                final int width = l10.getWidth();
                final int height = l10.getHeight();
                Observable<Result<UploadImageFileResult>> f10 = NetworkClient.f11868a.i().f(com.cupidapp.live.base.network.f.a(file), Boolean.valueOf(z10));
                final ChangeAvatarActivity changeAvatarActivity = ChangeAvatarActivity.this;
                Disposable disposed = f10.flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<UploadImageFileResult, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.ChangeAvatarActivity$uploadImageAndChangeAvatar$1$invoke$$inlined$handle$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ kotlin.p invoke(UploadImageFileResult uploadImageFileResult) {
                        m2781invoke(uploadImageFileResult);
                        return kotlin.p.f51048a;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m2781invoke(UploadImageFileResult uploadImageFileResult) {
                        UploadImageFileResult uploadImageFileResult2 = uploadImageFileResult;
                        ChangeAvatarActivity.this.A1(a10, width, height, null, uploadImageFileResult2.getImage().getImageId());
                        ChangeAvatarActivity.this.t1(uploadImageFileResult2.getImage());
                    }
                }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.setting.activity.ChangeAvatarActivity$uploadImageAndChangeAvatar$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @NotNull
                    public final Boolean invoke(@NotNull Throwable it) {
                        kotlin.jvm.internal.s.i(it, "it");
                        ChangeAvatarActivity.this.V0();
                        ChangeAvatarActivity.this.A1(a10, width, height, it, null);
                        return Boolean.FALSE;
                    }
                }, changeAvatarActivity)));
                if (disposed != null) {
                    kotlin.jvm.internal.s.h(disposed, "disposed");
                    if (changeAvatarActivity != null) {
                        changeAvatarActivity.H(disposed);
                    }
                }
                kotlin.jvm.internal.s.h(disposed, "disposed");
            }
        });
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity
    @NotNull
    public SensorPosition Q0() {
        return SensorPosition.EditAvatar;
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        u1();
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_change_avatar);
        y1();
        this.f17932u = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.cupidapp.live.setting.activity.a
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                ChangeAvatarActivity.w1(ChangeAvatarActivity.this, (ActivityResult) obj);
            }
        });
    }

    public final void t1(final ImageModel imageModel) {
        List<String> list;
        p1.g gVar = p1.g.f52734a;
        User X = gVar.X();
        Pair<String, String> videoIdAndCoverId = X != null ? X.getVideoIdAndCoverId() : null;
        User X2 = gVar.X();
        if (X2 != null) {
            ChangeAvatarModel v12 = v1();
            list = X2.getAvatarImageIdsByReset(v12 != null ? v12.getDeleteAvatarId() : null, imageModel.getImageId());
        } else {
            list = null;
        }
        Disposable disposed = NetworkClient.f11868a.N().A0(list, videoIdAndCoverId != null ? videoIdAndCoverId.getFirst() : null, videoIdAndCoverId != null ? videoIdAndCoverId.getSecond() : null).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<UserModifyResult, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.ChangeAvatarActivity$changeAvatar$$inlined$handle$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(UserModifyResult userModifyResult) {
                m2780invoke(userModifyResult);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2780invoke(UserModifyResult userModifyResult) {
                ChangeAvatarModel v13;
                ChangeAvatarActivity.this.V0();
                v13 = ChangeAvatarActivity.this.v1();
                String uploadSuccessToastStr = v13 != null ? v13.getUploadSuccessToastStr() : null;
                boolean z10 = false;
                if (uploadSuccessToastStr != null) {
                    if (uploadSuccessToastStr.length() > 0) {
                        z10 = true;
                    }
                }
                if (z10) {
                    com.cupidapp.live.base.view.h.f12779a.m(ChangeAvatarActivity.this, uploadSuccessToastStr);
                }
                p1.g.f52734a.B2(true);
                EventBus.c().o(new FakeUserUploadAvatarEvent());
                EventBus.c().o(new RefreshAttentionNotifyEvent());
                Intent intent = new Intent();
                z0.g.c(intent, imageModel);
                ChangeAvatarActivity.this.setResult(-1, intent);
                ChangeAvatarActivity.this.finish();
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.setting.activity.ChangeAvatarActivity$changeAvatar$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                kotlin.jvm.internal.s.i(it, "it");
                ChangeAvatarActivity.this.V0();
                return Boolean.FALSE;
            }
        }, this)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
            H(disposed);
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }

    public final void u1() {
        FKBaseCropImageFragment fKBaseCropImageFragment = this.f17929r;
        if (fKBaseCropImageFragment != null) {
            kotlin.jvm.internal.s.f(fKBaseCropImageFragment);
            if (fKBaseCropImageFragment.isAdded()) {
                FragmentTransaction customAnimations = getSupportFragmentManager().beginTransaction().setCustomAnimations(R$anim.anmi_left_in, R$anim.anmi_right_out);
                FKBaseCropImageFragment fKBaseCropImageFragment2 = this.f17929r;
                kotlin.jvm.internal.s.f(fKBaseCropImageFragment2);
                customAnimations.remove(fKBaseCropImageFragment2).commit();
                return;
            }
        }
        finish();
    }

    public final ChangeAvatarModel v1() {
        return (ChangeAvatarModel) this.f17930s.getValue();
    }

    public final void x1(final LocalMedia localMedia, String str) {
        final FKBaseCropImageFragment a10 = FKBaseCropImageFragment.f18109h.a(new FKCropImageFragment(), this, R$id.coverLayout, new FKCropImageModel(str, true));
        a10.X0(new Function0<kotlin.p>() { // from class: com.cupidapp.live.setting.activity.ChangeAvatarActivity$openCropImageFragment$1$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ kotlin.p invoke() {
                invoke2();
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ChangeAvatarActivity.this.u1();
            }
        });
        a10.Y0(new Function1<Bitmap, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.ChangeAvatarActivity$openCropImageFragment$1$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Bitmap bitmap) {
                invoke2(bitmap);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Bitmap bitmap) {
                kotlin.jvm.internal.s.i(bitmap, "bitmap");
                j1.g.b(j1.g.f50233a, LocalMedia.this.c(), SensorPosition.EditAvatar, 1, null, 8, null);
                a10.R0();
                File i10 = z0.k.f54819a.i(a10.getContext(), System.currentTimeMillis() + "_avatar.jpg");
                if (i10 != null) {
                    z0.f.f(bitmap, i10, 100);
                    this.B1(i10);
                }
            }
        });
        this.f17929r = a10;
    }

    public final void y1() {
        ChangeAvatarModel v12 = v1();
        this.f17928q = MediaPickerFragment.f17279p.a(this, Integer.valueOf(R$id.coverLayout), new b(), new MediaPickerFragment.Config(v12 != null && v12.isVideoAvatar() ? MediaType.VIDEO : MediaType.IMAGE, true, false, false, false, CameraStartPosition.Avatar, SensorPosition.EditAvatar, null, 144, null), 0, 0);
        d1(R$anim.anim_activity_nothing, Integer.valueOf(R$anim.anim_activity_top_to_bottom));
    }

    public final void z1(final LocalMedia localMedia) {
        final String d10 = localMedia.d();
        if (d10 != null) {
            MimeType.a aVar = MimeType.Companion;
            if (aVar.a(localMedia.c())) {
                e1();
                ImageResizeUtils.f12268a.m(this, this, kotlin.collections.r.e(d10), new Function1<Map<String, String>, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.ChangeAvatarActivity$pickMediaSuccess$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ kotlin.p invoke(Map<String, String> map) {
                        invoke2(map);
                        return kotlin.p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable Map<String, String> map) {
                        ChangeAvatarActivity.this.V0();
                        if (map == null || map.isEmpty()) {
                            return;
                        }
                        ChangeAvatarActivity.this.x1(localMedia, map.get(d10));
                    }
                }, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? null : null);
            } else if (aVar.b(localMedia.c())) {
                if (localMedia.a() < 2000) {
                    com.cupidapp.live.base.view.h.f12779a.l(this, R$string.video_too_short);
                } else {
                    GroupOthersLog.f18702a.t(ae.b.a(localMedia.a() / 1000.0d));
                    VideoAvatarCropActivity.f18028w.a(this, this.f17932u, d10, v1());
                }
            }
        }
    }
}
