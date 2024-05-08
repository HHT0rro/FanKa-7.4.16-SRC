package com.cupidapp.live.notify.layout;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.R$style;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.permission.FKRxPermissionAlertDialog;
import com.cupidapp.live.base.sensorslog.PopupButtonName;
import com.cupidapp.live.base.sensorslog.PopupName;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.view.button.FKUniversalButton;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.setting.activity.ChangeAvatarActivity;
import com.cupidapp.live.setting.activity.ChangeAvatarModel;
import com.cupidapp.live.setting.model.AvatarProfileModel;
import j1.i;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p1.g;
import z0.y;
import z0.z;

/* compiled from: ReplaceAvatarTipLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ReplaceAvatarTipLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17566b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReplaceAvatarTipLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f17566b = new LinkedHashMap();
        d();
    }

    public static final void f(SensorPosition position, DialogInterface dialogInterface) {
        s.i(position, "$position");
        i.g(i.f50236a, PopupName.AVATAR_FAKE_POPUP, position, null, 4, null);
    }

    @Nullable
    public View b(int i10) {
        Map<Integer, View> map = this.f17566b;
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

    public final void c(final AlertDialog alertDialog, final SensorPosition sensorPosition) {
        ImageView replaceAvatarCloseImage = (ImageView) b(R$id.replaceAvatarCloseImage);
        s.h(replaceAvatarCloseImage, "replaceAvatarCloseImage");
        y.d(replaceAvatarCloseImage, new Function1<View, p>() { // from class: com.cupidapp.live.notify.layout.ReplaceAvatarTipLayout$bindClickEvent$1
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
                alertDialog.dismiss();
                i.f50236a.a(PopupName.AVATAR_FAKE_POPUP, PopupButtonName.Close, sensorPosition);
            }
        });
        FKUniversalButton replaceAvatarButton = (FKUniversalButton) b(R$id.replaceAvatarButton);
        s.h(replaceAvatarButton, "replaceAvatarButton");
        y.d(replaceAvatarButton, new Function1<View, p>() { // from class: com.cupidapp.live.notify.layout.ReplaceAvatarTipLayout$bindClickEvent$2
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
                Context context = ReplaceAvatarTipLayout.this.getContext();
                FragmentActivity fragmentActivity = context instanceof FragmentActivity ? (FragmentActivity) context : null;
                if (fragmentActivity != null) {
                    final SensorPosition sensorPosition2 = sensorPosition;
                    final AlertDialog alertDialog2 = alertDialog;
                    final ReplaceAvatarTipLayout replaceAvatarTipLayout = ReplaceAvatarTipLayout.this;
                    FKRxPermissionAlertDialog.f12016a.m(fragmentActivity, new xb.b(fragmentActivity), (r16 & 4) != 0 ? null : new Function0<p>() { // from class: com.cupidapp.live.notify.layout.ReplaceAvatarTipLayout$bindClickEvent$2$1$1
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
                            alertDialog2.dismiss();
                            User X = g.f52734a.X();
                            List<AvatarProfileModel> avatarProfile = X != null ? X.getAvatarProfile() : null;
                            if (avatarProfile != null && (avatarProfile.isEmpty() ^ true)) {
                                ImageModel avatarImage = avatarProfile.get(0).getAvatarImage();
                                ChangeAvatarModel changeAvatarModel = new ChangeAvatarModel(avatarImage != null ? avatarImage.getImageId() : null, sensorPosition2, replaceAvatarTipLayout.getContext().getString(R$string.upload_success_review_successful_to_unlock), false);
                                ChangeAvatarActivity.a aVar = ChangeAvatarActivity.f17927x;
                                Context context2 = replaceAvatarTipLayout.getContext();
                                aVar.a(context2 instanceof Activity ? (Activity) context2 : null, changeAvatarModel);
                            }
                        }
                    }, (r16 & 8) != 0 ? null : null, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? R$string.need_access_media_upload_better : 0);
                    i.f50236a.a(PopupName.AVATAR_FAKE_POPUP, PopupButtonName.UploadAvatar, sensorPosition2);
                }
            }
        });
    }

    public final void d() {
        z.a(this, R$layout.layout_replace_avatar_tip, true);
        ((TextView) b(R$id.replaceAvatarTitleTextView)).getPaint().setFakeBoldText(true);
    }

    public final void e(@NotNull final SensorPosition position) {
        s.i(position, "position");
        AlertDialog dialog = z0.b.f54812a.e(getContext()).setView(this).create();
        dialog.setCanceledOnTouchOutside(false);
        dialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.cupidapp.live.notify.layout.b
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                ReplaceAvatarTipLayout.f(SensorPosition.this, dialogInterface);
            }
        });
        s.h(dialog, "dialog");
        c(dialog, position);
        dialog.show();
        Window window = dialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setWindowAnimations(R$style.dialog_translate_anim);
            window.setLayout(-1, -2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReplaceAvatarTipLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f17566b = new LinkedHashMap();
        d();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReplaceAvatarTipLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f17566b = new LinkedHashMap();
        d();
    }
}
