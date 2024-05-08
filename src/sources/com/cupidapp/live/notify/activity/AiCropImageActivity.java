package com.cupidapp.live.notify.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import androidx.activity.result.ActivityResultLauncher;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.activity.FKBaseActivity;
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

/* compiled from: AiCropImageActivity.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class AiCropImageActivity extends FKBaseActivity {

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public static final a f17487r = new a(null);

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17488q = new LinkedHashMap();

    /* compiled from: AiCropImageActivity.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull ActivityResultLauncher<Intent> launcher, @Nullable String str) {
            s.i(context, "context");
            s.i(launcher, "launcher");
            Intent intent = new Intent(context, (Class<?>) AiCropImageActivity.class);
            intent.putExtra("path", str);
            launcher.launch(intent);
        }
    }

    public final void j1(String str) {
        final FKBaseCropImageFragment a10 = FKBaseCropImageFragment.f18109h.a(new AiPhotoCropImageFragment(), this, R$id.fragment_container, new FKCropImageModel(str, true));
        a10.X0(new Function0<p>() { // from class: com.cupidapp.live.notify.activity.AiCropImageActivity$openCropImageFragment$1$1
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
                AiCropImageActivity.this.finish();
            }
        });
        a10.Y0(new Function1<Bitmap, p>() { // from class: com.cupidapp.live.notify.activity.AiCropImageActivity$openCropImageFragment$1$2
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
                    this.setResult(-1, intent);
                    this.finish();
                }
            }
        });
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_ai_crop_image);
        j1(getIntent().getStringExtra("path"));
    }
}
