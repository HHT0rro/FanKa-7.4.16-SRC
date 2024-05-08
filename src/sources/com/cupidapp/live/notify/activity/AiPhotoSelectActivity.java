package com.cupidapp.live.notify.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.FragmentTransaction;
import com.cupidapp.live.R$anim;
import com.cupidapp.live.R$id;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.mediapicker.newmediapicker.activity.PhoneAlbumActivity;
import com.cupidapp.live.mediapicker.newmediapicker.fragment.MediaPickerFragment;
import com.cupidapp.live.mediapicker.newmediapicker.model.LocalMedia;
import com.cupidapp.live.setting.fragment.AiPhotoCropImageFragment;
import com.cupidapp.live.setting.fragment.FKBaseCropImageFragment;
import com.cupidapp.live.setting.model.FKCropImageModel;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.f;
import z0.k;

/* compiled from: AiPhotoSelectActivity.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class AiPhotoSelectActivity extends PhoneAlbumActivity {

    /* renamed from: w, reason: collision with root package name */
    @NotNull
    public static final a f17489w = new a(null);

    /* renamed from: u, reason: collision with root package name */
    @Nullable
    public FKBaseCropImageFragment f17490u;

    /* renamed from: v, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17491v = new LinkedHashMap();

    /* compiled from: AiPhotoSelectActivity.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull ActivityResultLauncher<Intent> launcher, @NotNull MediaPickerFragment.Config config) {
            s.i(context, "context");
            s.i(launcher, "launcher");
            s.i(config, "config");
            Intent intent = new Intent(context, (Class<?>) AiPhotoSelectActivity.class);
            PhoneAlbumActivity.f17267t.a(intent, config);
            launcher.launch(intent);
            FKBaseActivity.f11750o.b(context, R$anim.anim_activity_bottom_to_top, R$anim.anim_activity_nothing);
        }
    }

    @Override // com.cupidapp.live.mediapicker.newmediapicker.activity.PhoneAlbumActivity
    public void n1(@NotNull LocalMedia media, @NotNull String path) {
        s.i(media, "media");
        s.i(path, "path");
        v1(media, path);
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        u1();
    }

    @Override // com.cupidapp.live.mediapicker.newmediapicker.activity.PhoneAlbumActivity, com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        d1(R$anim.anim_activity_nothing, Integer.valueOf(R$anim.anim_activity_top_to_bottom));
    }

    @Override // com.cupidapp.live.mediapicker.newmediapicker.activity.PhoneAlbumActivity
    public void p1(@Nullable Intent intent) {
    }

    public final void u1() {
        FKBaseCropImageFragment fKBaseCropImageFragment = this.f17490u;
        if (fKBaseCropImageFragment != null) {
            s.f(fKBaseCropImageFragment);
            if (fKBaseCropImageFragment.isAdded()) {
                FragmentTransaction customAnimations = getSupportFragmentManager().beginTransaction().setCustomAnimations(R$anim.anmi_left_in, R$anim.anmi_right_out);
                FKBaseCropImageFragment fKBaseCropImageFragment2 = this.f17490u;
                s.f(fKBaseCropImageFragment2);
                customAnimations.remove(fKBaseCropImageFragment2).commitAllowingStateLoss();
                return;
            }
        }
        finish();
    }

    public final void v1(final LocalMedia localMedia, String str) {
        final FKBaseCropImageFragment a10 = FKBaseCropImageFragment.f18109h.a(new AiPhotoCropImageFragment(), this, R$id.single_fragment_root_layout, new FKCropImageModel(str, true));
        a10.X0(new Function0<p>() { // from class: com.cupidapp.live.notify.activity.AiPhotoSelectActivity$openCropImageFragment$1$1
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
                AiPhotoSelectActivity.this.u1();
            }
        });
        a10.Y0(new Function1<Bitmap, p>() { // from class: com.cupidapp.live.notify.activity.AiPhotoSelectActivity$openCropImageFragment$1$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Bitmap bitmap) {
                invoke2(bitmap);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Bitmap bitmap) {
                s.i(bitmap, "bitmap");
                FKBaseCropImageFragment.this.R0();
                File i10 = k.f54819a.i(FKBaseCropImageFragment.this.getContext(), System.currentTimeMillis() + "_ai.jpg");
                if (i10 != null) {
                    f.f(bitmap, i10, 100);
                    Intent intent = new Intent();
                    intent.putExtra("RESULT_IMAGE_PATH", i10.getPath());
                    intent.putExtra("RESULT_IMAGE_TYPE", localMedia.c());
                    this.setResult(-1, intent);
                    this.finish();
                }
            }
        });
        this.f17490u = a10;
    }
}
