package com.cupidapp.live.liveshow.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.activity.result.ActivityResultLauncher;
import com.cupidapp.live.R$anim;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.liveshow.activity.FKLiveCoverCropActivity;
import com.cupidapp.live.mediapicker.newmediapicker.activity.PhoneAlbumActivity;
import com.cupidapp.live.mediapicker.newmediapicker.fragment.MediaPickerFragment;
import com.cupidapp.live.mediapicker.newmediapicker.model.LocalMedia;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveCoverAlbumActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveCoverAlbumActivity extends PhoneAlbumActivity {

    /* renamed from: v, reason: collision with root package name */
    @NotNull
    public static final a f14746v = new a(null);

    /* renamed from: u, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f14747u = new LinkedHashMap();

    /* compiled from: FKLiveCoverAlbumActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Activity activity, @NotNull MediaPickerFragment.Config config) {
            s.i(activity, "activity");
            s.i(config, "config");
            Intent intent = new Intent(activity, (Class<?>) FKLiveCoverAlbumActivity.class);
            PhoneAlbumActivity.f17267t.a(intent, config);
            activity.startActivityForResult(intent, 221203);
            FKBaseActivity.f11750o.b(activity, R$anim.anim_activity_bottom_to_top, R$anim.anim_activity_nothing);
        }
    }

    @Override // com.cupidapp.live.mediapicker.newmediapicker.activity.PhoneAlbumActivity
    public void n1(@NotNull LocalMedia media, @NotNull String path) {
        s.i(media, "media");
        s.i(path, "path");
        ActivityResultLauncher<Intent> o12 = o1();
        if (o12 != null) {
            FKLiveCoverCropActivity.a aVar = FKLiveCoverCropActivity.f14748t;
            MediaPickerFragment.Config m12 = m1();
            aVar.a(this, o12, path, m12 != null ? m12.getShowPosition() : null);
        }
    }

    @Override // com.cupidapp.live.mediapicker.newmediapicker.activity.PhoneAlbumActivity, com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        d1(R$anim.anim_activity_nothing, Integer.valueOf(R$anim.anim_activity_top_to_bottom));
    }

    @Override // com.cupidapp.live.mediapicker.newmediapicker.activity.PhoneAlbumActivity
    public void p1(@Nullable Intent intent) {
        setResult(-1, intent);
        finish();
    }
}
