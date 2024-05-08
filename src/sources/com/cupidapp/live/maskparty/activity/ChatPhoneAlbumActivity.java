package com.cupidapp.live.maskparty.activity;

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
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ChatPhoneAlbumActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ChatPhoneAlbumActivity extends PhoneAlbumActivity {

    /* renamed from: v, reason: collision with root package name */
    @NotNull
    public static final a f16226v = new a(null);

    /* renamed from: u, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16227u = new LinkedHashMap();

    /* compiled from: ChatPhoneAlbumActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull ActivityResultLauncher<Intent> launcher, @NotNull MediaPickerFragment.Config config, @Nullable String str, boolean z10) {
            s.i(context, "context");
            s.i(launcher, "launcher");
            s.i(config, "config");
            Intent intent = new Intent(context, (Class<?>) ChatPhoneAlbumActivity.class);
            PhoneAlbumActivity.f17267t.a(intent, config);
            intent.putExtra("CHAT_PHONE_ALBUM_OTHER_USER_ID", str);
            intent.putExtra("CHAT_PHONE_ALBUM_SHOW_SNAP_CHECK_BOX", z10);
            launcher.launch(intent);
            FKBaseActivity.f11750o.b(context, R$anim.anim_activity_bottom_to_top, R$anim.anim_activity_nothing);
        }
    }

    @Override // com.cupidapp.live.mediapicker.newmediapicker.activity.PhoneAlbumActivity
    public void n1(@NotNull LocalMedia media, @NotNull String path) {
        s.i(media, "media");
        s.i(path, "path");
        ActivityResultLauncher<Intent> o12 = o1();
        if (o12 != null) {
            ChatPreviewImageActivity.f16228r.a(this, o12, path, getIntent().getStringExtra("CHAT_PHONE_ALBUM_OTHER_USER_ID"), getIntent().getBooleanExtra("CHAT_PHONE_ALBUM_SHOW_SNAP_CHECK_BOX", true));
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
