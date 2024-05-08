package com.cupidapp.live.flutter.interactive;

import android.content.Intent;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.permission.FKRxPermissionAlertDialog;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.mediapicker.model.CameraStartPosition;
import com.cupidapp.live.mediapicker.newmediapicker.fragment.MediaPickerFragment;
import com.cupidapp.live.mediapicker.newmediapicker.model.MediaType;
import com.cupidapp.live.mediapicker.newmediapicker.model.MimeType;
import com.cupidapp.live.notify.activity.AiPhotoSelectActivity;
import com.huawei.quickcard.base.Attributes;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FlutterMediaCallNative.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FlutterMediaCallNative implements MethodChannel.MethodCallHandler {

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public static final a f14660f = new a(null);

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public final FKBaseActivity f14661b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final ActivityResultContracts.StartActivityForResult f14662c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public MethodChannel.Result f14663d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public final ActivityResultLauncher<Intent> f14664e;

    /* compiled from: FlutterMediaCallNative.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@Nullable BinaryMessenger binaryMessenger, @NotNull String channelName, @Nullable FKBaseActivity fKBaseActivity) {
            s.i(channelName, "channelName");
            s.f(binaryMessenger);
            new MethodChannel(binaryMessenger, channelName).setMethodCallHandler(new FlutterMediaCallNative(fKBaseActivity));
        }
    }

    public FlutterMediaCallNative(@Nullable FKBaseActivity fKBaseActivity) {
        this.f14661b = fKBaseActivity;
        ActivityResultContracts.StartActivityForResult startActivityForResult = new ActivityResultContracts.StartActivityForResult();
        this.f14662c = startActivityForResult;
        this.f14664e = fKBaseActivity != null ? fKBaseActivity.registerForActivityResult(startActivityForResult, new ActivityResultCallback() { // from class: com.cupidapp.live.flutter.interactive.a
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                FlutterMediaCallNative.c(FlutterMediaCallNative.this, (ActivityResult) obj);
            }
        }) : null;
    }

    public static final void c(FlutterMediaCallNative this$0, ActivityResult activityResult) {
        s.i(this$0, "this$0");
        if (activityResult.getResultCode() == -1) {
            Intent data = activityResult.getData();
            String stringExtra = data != null ? data.getStringExtra("RESULT_IMAGE_PATH") : null;
            Intent data2 = activityResult.getData();
            String str = MimeType.Companion.b(data2 != null ? data2.getStringExtra("RESULT_IMAGE_TYPE") : null) ? "video" : Attributes.Component.IMAGE;
            MethodChannel.Result result = this$0.f14663d;
            if (result != null) {
                result.success("[{\"path\": \"" + stringExtra + "\",\"type\": \"" + str + "\"}]");
            }
        }
    }

    public final void d(MethodCall methodCall, final FKBaseActivity fKBaseActivity, final MediaType mediaType) {
        if (fKBaseActivity != null) {
            FKRxPermissionAlertDialog.f12016a.m(fKBaseActivity, new xb.b(fKBaseActivity), (r16 & 4) != 0 ? null : new Function0<p>() { // from class: com.cupidapp.live.flutter.interactive.FlutterMediaCallNative$pickMedia$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    ActivityResultLauncher<Intent> activityResultLauncher;
                    activityResultLauncher = FlutterMediaCallNative.this.f14664e;
                    if (activityResultLauncher != null) {
                        MediaType mediaType2 = mediaType;
                        AiPhotoSelectActivity.f17489w.a(fKBaseActivity, activityResultLauncher, new MediaPickerFragment.Config(mediaType2, true, false, false, false, CameraStartPosition.Web, SensorPosition.Unknown, null, 136, null));
                    }
                }
            }, (r16 & 8) != 0 ? null : null, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? R$string.need_access_media_upload_better : 0);
        }
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(@NotNull MethodCall call, @NotNull MethodChannel.Result result) {
        s.i(call, "call");
        s.i(result, "result");
        this.f14663d = result;
        String str = call.method;
        if (s.d(str, "pickImage")) {
            d(call, this.f14661b, MediaType.IMAGE);
        } else if (s.d(str, "pickMedia")) {
            d(call, this.f14661b, MediaType.ALL);
        } else {
            result.notImplemented();
        }
    }
}
