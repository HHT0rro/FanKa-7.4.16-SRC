package com.cupidapp.live.feed.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.activity.result.ActivityResultLauncher;
import com.cupidapp.live.R$anim;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.mediapicker.newmediapicker.activity.PhoneAlbumActivity;
import com.cupidapp.live.mediapicker.newmediapicker.fragment.MediaPickerFragment;
import com.cupidapp.live.mediapicker.newmediapicker.model.LocalMedia;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PostLimitEditAlbumActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class PostLimitEditAlbumActivity extends PhoneAlbumActivity {

    /* renamed from: v, reason: collision with root package name */
    @NotNull
    public static final a f14126v = new a(null);

    /* renamed from: u, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f14127u = new LinkedHashMap();

    /* compiled from: PostLimitEditAlbumActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull ActivityResultLauncher<Intent> launcher, @NotNull MediaPickerFragment.Config config) {
            kotlin.jvm.internal.s.i(context, "context");
            kotlin.jvm.internal.s.i(launcher, "launcher");
            kotlin.jvm.internal.s.i(config, "config");
            Intent intent = new Intent(context, (Class<?>) PostLimitEditAlbumActivity.class);
            PhoneAlbumActivity.f17267t.a(intent, config);
            launcher.launch(intent);
            FKBaseActivity.f11750o.b(context, R$anim.anim_activity_bottom_to_top, R$anim.anim_activity_nothing);
        }
    }

    @Override // com.cupidapp.live.mediapicker.newmediapicker.activity.PhoneAlbumActivity
    public void n1(@NotNull LocalMedia media, @NotNull String path) {
        kotlin.jvm.internal.s.i(media, "media");
        kotlin.jvm.internal.s.i(path, "path");
        Intent intent = new Intent();
        intent.putExtra("POST_LIMIT_EDIT_IMAGE_PATH", path);
        setResult(-1, intent);
        finish();
    }

    @Override // com.cupidapp.live.mediapicker.newmediapicker.activity.PhoneAlbumActivity, com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        d1(R$anim.anim_activity_nothing, Integer.valueOf(R$anim.anim_activity_top_to_bottom));
    }

    @Override // com.cupidapp.live.mediapicker.newmediapicker.activity.PhoneAlbumActivity
    public void p1(@Nullable Intent intent) {
    }
}
