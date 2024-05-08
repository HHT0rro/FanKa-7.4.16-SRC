package com.cupidapp.live.maskparty.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import com.cupidapp.live.R$anim;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.utils.p0;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.chat.service.SnapCaptureStatusModel;
import com.tencent.vasdolly.helper.ChannelReaderUtil;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;

/* compiled from: ChatPreviewImageActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ChatPreviewImageActivity extends FKBaseActivity {

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public static final a f16228r = new a(null);

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16229q = new LinkedHashMap();

    /* compiled from: ChatPreviewImageActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull ActivityResultLauncher<Intent> launcher, @NotNull String path, @Nullable String str, boolean z10) {
            s.i(context, "context");
            s.i(launcher, "launcher");
            s.i(path, "path");
            Intent intent = new Intent(context, (Class<?>) ChatPreviewImageActivity.class);
            intent.putExtra("CHAT_PREVIEW_SHOW_IMAGE_PATH", path);
            intent.putExtra("CHAT_PREVIEW_OTHER_USER_ID", str);
            intent.putExtra("CHAT_PREVIEW_SHOW_SNAP_CHECK_BOX", z10);
            launcher.launch(intent);
        }
    }

    public static final void p1(ChatPreviewImageActivity this$0, CompoundButton compoundButton, boolean z10) {
        String string;
        s.i(this$0, "this$0");
        if (z10) {
            string = this$0.getString(R$string.snap_message_confirm);
        } else {
            string = this$0.getString(R$string.snap_message);
        }
        compoundButton.setText(string);
    }

    public static final void s1(ChatPreviewImageActivity this$0, String path, boolean z10, DialogInterface dialogInterface, int i10) {
        s.i(this$0, "this$0");
        s.i(path, "$path");
        this$0.q1(path, z10);
    }

    @Nullable
    public View l1(int i10) {
        Map<Integer, View> map = this.f16229q;
        View view = map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i10);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    public final void o1(final String str) {
        ((FKTitleBarLayout) l1(R$id.chat_preview_image_title_bar)).setLeftImageClickEvent(new Function1<View, p>() { // from class: com.cupidapp.live.maskparty.activity.ChatPreviewImageActivity$bindClickEvent$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(View view) {
                invoke2(view);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                ChatPreviewImageActivity.this.finish();
            }
        });
        ((CheckBox) l1(R$id.chat_preview_image_snap_checkbox)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.cupidapp.live.maskparty.activity.b
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                ChatPreviewImageActivity.p1(ChatPreviewImageActivity.this, compoundButton, z10);
            }
        });
        TextView chat_preview_image_send_btn = (TextView) l1(R$id.chat_preview_image_send_btn);
        s.h(chat_preview_image_send_btn, "chat_preview_image_send_btn");
        y.d(chat_preview_image_send_btn, new Function1<View, p>() { // from class: com.cupidapp.live.maskparty.activity.ChatPreviewImageActivity$bindClickEvent$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(View view) {
                invoke2(view);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                final boolean isChecked = ((CheckBox) ChatPreviewImageActivity.this.l1(R$id.chat_preview_image_snap_checkbox)).isChecked();
                String stringExtra = ChatPreviewImageActivity.this.getIntent().getStringExtra("CHAT_PREVIEW_OTHER_USER_ID");
                if (isChecked) {
                    if (!(stringExtra == null || stringExtra.length() == 0)) {
                        Observable<Result<SnapCaptureStatusModel>> g3 = NetworkClient.f11868a.j().g(stringExtra);
                        final ChatPreviewImageActivity chatPreviewImageActivity = ChatPreviewImageActivity.this;
                        final String str2 = str;
                        Disposable disposed = g3.flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<SnapCaptureStatusModel, p>() { // from class: com.cupidapp.live.maskparty.activity.ChatPreviewImageActivity$bindClickEvent$3$invoke$$inlined$handle$default$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ p invoke(SnapCaptureStatusModel snapCaptureStatusModel) {
                                m2680invoke(snapCaptureStatusModel);
                                return p.f51048a;
                            }

                            /* renamed from: invoke, reason: collision with other method in class */
                            public final void m2680invoke(SnapCaptureStatusModel snapCaptureStatusModel) {
                                if (s.d(snapCaptureStatusModel.getSnapCapture(), Boolean.TRUE)) {
                                    ChatPreviewImageActivity.this.r1(str2, isChecked);
                                } else {
                                    ChatPreviewImageActivity.this.q1(str2, isChecked);
                                }
                            }
                        }), new e(new ObservableExtensionKt$handle$disposed$2(null, chatPreviewImageActivity)));
                        if (disposed != null) {
                            s.h(disposed, "disposed");
                            if (chatPreviewImageActivity != null) {
                                chatPreviewImageActivity.H(disposed);
                            }
                        }
                        s.h(disposed, "disposed");
                        return;
                    }
                }
                ChatPreviewImageActivity.this.q1(str, isChecked);
            }
        });
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_chat_preview_image);
        p0.b(this, true, -15066598);
        d1(R$anim.anim_activity_nothing, null);
        String stringExtra = getIntent().getStringExtra("CHAT_PREVIEW_SHOW_IMAGE_PATH");
        if (stringExtra == null || stringExtra.length() == 0) {
            finish();
            return;
        }
        ImageLoaderView chat_preview_image = (ImageLoaderView) l1(R$id.chat_preview_image);
        s.h(chat_preview_image, "chat_preview_image");
        ImageLoaderView.f(chat_preview_image, new com.cupidapp.live.base.imageloader.b(false, stringExtra, null, null, null, null, null, 0, 0, null, null, null, null, false, 0, 0, false, null, null, 524285, null), null, 2, null);
        o1(stringExtra);
        t1();
        if (getIntent().getBooleanExtra("CHAT_PREVIEW_SHOW_SNAP_CHECK_BOX", true)) {
            ((CheckBox) l1(R$id.chat_preview_image_snap_checkbox)).setVisibility(0);
        } else {
            ((CheckBox) l1(R$id.chat_preview_image_snap_checkbox)).setVisibility(8);
        }
    }

    public final void q1(String str, boolean z10) {
        Intent intent = new Intent();
        intent.putExtra("CHAT_PREVIEW_SEND_IMAGE_PATH", str);
        intent.putExtra("CHAT_PREVIEW_SEND_IMAGE_IS_SNAP", z10);
        setResult(-1, intent);
        finish();
    }

    public final void r1(final String str, final boolean z10) {
        AlertDialog.Builder negativeButton = z0.b.f54812a.e(this).setTitle(R$string.screenshot_risk_warning_title).setMessage(R$string.screenshot_risk_warning_description).setPositiveButton(R$string.still_send, new DialogInterface.OnClickListener() { // from class: com.cupidapp.live.maskparty.activity.a
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                ChatPreviewImageActivity.s1(ChatPreviewImageActivity.this, str, z10, dialogInterface, i10);
            }
        }).setNegativeButton(R$string.do_not_send, (DialogInterface.OnClickListener) null);
        s.h(negativeButton, "AlertDialogExtension.cre…string.do_not_send, null)");
        z0.d.b(negativeButton);
    }

    public final void t1() {
        if (s.d(ChannelReaderUtil.getChannel(this), "Xiaomi")) {
            ((CheckBox) l1(R$id.chat_preview_image_snap_checkbox)).setVisibility(8);
        }
    }
}
