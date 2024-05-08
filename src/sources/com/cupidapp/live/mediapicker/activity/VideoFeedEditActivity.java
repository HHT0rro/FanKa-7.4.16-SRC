package com.cupidapp.live.mediapicker.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.mediapicker.fragment.VideoEditFragment;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VideoFeedEditActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VideoFeedEditActivity extends FKBaseActivity {

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public static final a f17134r = new a(null);

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17135q = new LinkedHashMap();

    /* compiled from: VideoFeedEditActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Activity activity, int i10, @NotNull VideoEditFragment.Config config) {
            s.i(activity, "activity");
            s.i(config, "config");
            Intent intent = new Intent(activity, (Class<?>) VideoFeedEditActivity.class);
            z0.g.c(intent, config);
            activity.startActivityForResult(intent, i10);
            FKBaseActivity.a.c(FKBaseActivity.f11750o, activity, 0, 0, 6, null);
        }
    }

    /* compiled from: VideoFeedEditActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b implements com.cupidapp.live.base.activity.g {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ VideoEditFragment f17136b;

        public b(VideoEditFragment videoEditFragment) {
            this.f17136b = videoEditFragment;
        }

        @Override // com.cupidapp.live.base.activity.g
        public boolean a() {
            return this.f17136b.onBackPressed();
        }
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, @Nullable Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i11 == -1 && i10 == 1616) {
            setResult(-1);
            finish();
        }
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_video_feed_edit);
        Intent intent = getIntent();
        s.h(intent, "intent");
        VideoEditFragment.Config config = (VideoEditFragment.Config) z0.g.a(intent, VideoEditFragment.Config.class);
        if (config == null) {
            finish();
            return;
        }
        VideoEditFragment a10 = VideoEditFragment.f17194k.a(config);
        FKBaseActivity.g1(this, a10, false, R$id.video_feed_edit_root_layout, false, false, 24, null);
        z0(new b(a10));
    }
}
