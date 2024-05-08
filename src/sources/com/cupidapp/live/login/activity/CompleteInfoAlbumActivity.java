package com.cupidapp.live.login.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.activity.result.ActivityResultLauncher;
import com.cupidapp.live.R$anim;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.utils.j;
import com.cupidapp.live.login.activity.CompleteInfoCutAvatarActivity;
import com.cupidapp.live.mediapicker.newmediapicker.activity.PhoneAlbumActivity;
import com.cupidapp.live.mediapicker.newmediapicker.fragment.MediaPickerFragment;
import com.cupidapp.live.mediapicker.newmediapicker.model.LocalMedia;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CompleteInfoAlbumActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class CompleteInfoAlbumActivity extends PhoneAlbumActivity {

    /* renamed from: v, reason: collision with root package name */
    @NotNull
    public static final a f16067v = new a(null);

    /* renamed from: u, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16068u = new LinkedHashMap();

    /* compiled from: CompleteInfoAlbumActivity.kt */
    @kotlin.d
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
            Intent intent = new Intent(context, (Class<?>) CompleteInfoAlbumActivity.class);
            PhoneAlbumActivity.f17267t.a(intent, config);
            launcher.launch(intent);
            FKBaseActivity.f11750o.b(context, R$anim.anim_activity_bottom_to_top, R$anim.anim_activity_nothing);
        }
    }

    @Override // com.cupidapp.live.mediapicker.newmediapicker.activity.PhoneAlbumActivity
    public void n1(@NotNull LocalMedia media, @NotNull String path) {
        SensorPosition showPosition;
        s.i(media, "media");
        s.i(path, "path");
        j.f12332a.a("CompleteAlbum", "media: " + ((Object) media) + " path: " + path);
        ActivityResultLauncher<Intent> o12 = o1();
        if (o12 != null) {
            CompleteInfoCutAvatarActivity.a aVar = CompleteInfoCutAvatarActivity.f16076v;
            MediaPickerFragment.Config m12 = m1();
            aVar.a(this, o12, path, (m12 == null || (showPosition = m12.getShowPosition()) == null) ? null : showPosition.getValue());
        }
    }

    @Override // com.cupidapp.live.mediapicker.newmediapicker.activity.PhoneAlbumActivity, com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        d1(0, Integer.valueOf(R$anim.anim_activity_top_to_bottom));
    }

    @Override // com.cupidapp.live.mediapicker.newmediapicker.activity.PhoneAlbumActivity
    public void p1(@Nullable Intent intent) {
        j.f12332a.a("CompleteAlbum", "data: " + ((Object) intent));
    }
}
