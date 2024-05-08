package com.cupidapp.live.mediapicker.newmediapicker.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.utils.ImageResizeUtils;
import com.cupidapp.live.mediapicker.newmediapicker.fragment.MediaPickerFragment;
import com.cupidapp.live.mediapicker.newmediapicker.model.LocalMedia;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.r;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.g;

/* compiled from: PhoneAlbumActivity.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class PhoneAlbumActivity extends FKBaseActivity {

    /* renamed from: t, reason: collision with root package name */
    @NotNull
    public static final a f17267t = new a(null);

    /* renamed from: q, reason: collision with root package name */
    @Nullable
    public MediaPickerFragment.Config f17268q;

    /* renamed from: r, reason: collision with root package name */
    @Nullable
    public ActivityResultLauncher<Intent> f17269r;

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17270s = new LinkedHashMap();

    /* compiled from: PhoneAlbumActivity.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Intent intent, @NotNull MediaPickerFragment.Config config) {
            s.i(intent, "intent");
            s.i(config, "config");
            g.c(intent, config);
        }
    }

    /* compiled from: PhoneAlbumActivity.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b implements MediaPickerFragment.b {
        public b() {
        }

        @Override // com.cupidapp.live.mediapicker.newmediapicker.fragment.MediaPickerFragment.b
        public void a() {
            PhoneAlbumActivity.this.finish();
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
            PhoneAlbumActivity.this.q1(media);
        }

        @Override // com.cupidapp.live.mediapicker.newmediapicker.fragment.MediaPickerFragment.b
        public void f() {
        }
    }

    public static final void s1(PhoneAlbumActivity this$0, ActivityResult activityResult) {
        s.i(this$0, "this$0");
        if (activityResult.getResultCode() == -1) {
            this$0.p1(activityResult.getData());
        }
    }

    @Nullable
    public final MediaPickerFragment.Config m1() {
        return this.f17268q;
    }

    public abstract void n1(@NotNull LocalMedia localMedia, @NotNull String str);

    @Nullable
    public final ActivityResultLauncher<Intent> o1() {
        return this.f17269r;
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_single_fragment);
        Intent intent = getIntent();
        s.h(intent, "intent");
        MediaPickerFragment.Config config = (MediaPickerFragment.Config) g.a(intent, MediaPickerFragment.Config.class);
        this.f17268q = config;
        if (config == null) {
            finish();
            return;
        }
        r1();
        MediaPickerFragment.a aVar = MediaPickerFragment.f17279p;
        MediaPickerFragment.Config config2 = this.f17268q;
        s.f(config2);
        FKBaseActivity.g1(this, aVar.b(config2, new b()), false, R$id.single_fragment_root_layout, false, false, 24, null);
    }

    public abstract void p1(@Nullable Intent intent);

    public final void q1(final LocalMedia localMedia) {
        final String d10 = localMedia.d();
        if (d10 == null || d10.length() == 0) {
            return;
        }
        e1();
        ImageResizeUtils.f12268a.m(this, this, r.e(d10), new Function1<Map<String, String>, p>() { // from class: com.cupidapp.live.mediapicker.newmediapicker.activity.PhoneAlbumActivity$imageResize$1
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
                String str;
                MediaPickerFragment.Config config;
                PhoneAlbumActivity.this.V0();
                if (map == null || (str = map.get(d10)) == null) {
                    return;
                }
                LocalMedia localMedia2 = localMedia;
                PhoneAlbumActivity phoneAlbumActivity = PhoneAlbumActivity.this;
                j1.g gVar = j1.g.f50233a;
                String c4 = localMedia2.c();
                config = phoneAlbumActivity.f17268q;
                j1.g.b(gVar, c4, config != null ? config.getShowPosition() : null, 1, null, 8, null);
                phoneAlbumActivity.n1(localMedia2, str);
            }
        }, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? null : null);
    }

    public final void r1() {
        this.f17269r = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.cupidapp.live.mediapicker.newmediapicker.activity.a
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                PhoneAlbumActivity.s1(PhoneAlbumActivity.this, (ActivityResult) obj);
            }
        });
    }
}
