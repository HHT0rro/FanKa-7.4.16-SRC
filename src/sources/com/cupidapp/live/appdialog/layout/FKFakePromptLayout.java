package com.cupidapp.live.appdialog.layout;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.R$style;
import com.cupidapp.live.appdialog.model.FakeAvatarModel;
import com.cupidapp.live.appdialog.model.WindowType;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.permission.FKRxPermissionAlertDialog;
import com.cupidapp.live.base.sensorslog.PopupButtonName;
import com.cupidapp.live.base.sensorslog.PopupName;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.view.BaseLayout;
import com.cupidapp.live.base.view.button.FKUniversalButton;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.setting.activity.ChangeAvatarActivity;
import com.cupidapp.live.setting.activity.ChangeAvatarModel;
import com.cupidapp.live.setting.model.AvatarProfileModel;
import e1.a;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: FKFakePromptLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKFakePromptLayout extends BaseLayout {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final a f11668e = new a(null);

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f11669d;

    /* compiled from: FKFakePromptLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKFakePromptLayout(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.f11669d = new LinkedHashMap();
        h();
    }

    public static final void j(FakeAvatarModel fakeAvatar, FKFakePromptLayout this$0, SensorPosition position, DialogInterface dialogInterface) {
        kotlin.jvm.internal.s.i(fakeAvatar, "$fakeAvatar");
        kotlin.jvm.internal.s.i(this$0, "this$0");
        kotlin.jvm.internal.s.i(position, "$position");
        Observable c4 = a.C0726a.c(NetworkClient.f11868a.i(), fakeAvatar.getScene(), WindowType.FakeAvatar.getType(), null, null, null, null, null, null, null, null, 1020, null);
        Object context = this$0.getContext();
        com.cupidapp.live.base.network.g gVar = context instanceof com.cupidapp.live.base.network.g ? (com.cupidapp.live.base.network.g) context : null;
        Disposable disposed = c4.flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.appdialog.layout.FKFakePromptLayout$showFakePrompt$lambda$1$$inlined$handleByContext$default$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                invoke2(obj);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, gVar)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
            if (gVar != null) {
                gVar.H(disposed);
            }
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
        j1.i.g(j1.i.f50236a, PopupName.AVATAR_FAKE_POPUP, position, null, 4, null);
    }

    @Nullable
    public View f(int i10) {
        Map<Integer, View> map = this.f11669d;
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

    public final void g(final AlertDialog alertDialog, final SensorPosition sensorPosition) {
        ImageView fakeAvatarCloseImage = (ImageView) f(R$id.fakeAvatarCloseImage);
        kotlin.jvm.internal.s.h(fakeAvatarCloseImage, "fakeAvatarCloseImage");
        y.d(fakeAvatarCloseImage, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.appdialog.layout.FKFakePromptLayout$bindClickEvent$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(View view) {
                invoke2(view);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                alertDialog.dismiss();
                j1.i.f50236a.a(PopupName.AVATAR_FAKE_POPUP, PopupButtonName.Close, sensorPosition);
            }
        });
        FKUniversalButton changeAvatarButton = (FKUniversalButton) f(R$id.changeAvatarButton);
        kotlin.jvm.internal.s.h(changeAvatarButton, "changeAvatarButton");
        y.d(changeAvatarButton, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.appdialog.layout.FKFakePromptLayout$bindClickEvent$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(View view) {
                invoke2(view);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                Context context = FKFakePromptLayout.this.getContext();
                FragmentActivity fragmentActivity = context instanceof FragmentActivity ? (FragmentActivity) context : null;
                if (fragmentActivity != null) {
                    final SensorPosition sensorPosition2 = sensorPosition;
                    final AlertDialog alertDialog2 = alertDialog;
                    final FKFakePromptLayout fKFakePromptLayout = FKFakePromptLayout.this;
                    FKRxPermissionAlertDialog.f12016a.m(fragmentActivity, new xb.b(fragmentActivity), (r16 & 4) != 0 ? null : new Function0<kotlin.p>() { // from class: com.cupidapp.live.appdialog.layout.FKFakePromptLayout$bindClickEvent$2$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ kotlin.p invoke() {
                            invoke2();
                            return kotlin.p.f51048a;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            List<AvatarProfileModel> avatarProfile;
                            AvatarProfileModel avatarProfileModel;
                            ImageModel avatarImage;
                            alertDialog2.dismiss();
                            User X = p1.g.f52734a.X();
                            ChangeAvatarModel changeAvatarModel = new ChangeAvatarModel((X == null || (avatarProfile = X.getAvatarProfile()) == null || (avatarProfileModel = avatarProfile.get(0)) == null || (avatarImage = avatarProfileModel.getAvatarImage()) == null) ? null : avatarImage.getImageId(), sensorPosition2, fKFakePromptLayout.getContext().getString(R$string.upload_success), false);
                            ChangeAvatarActivity.a aVar = ChangeAvatarActivity.f17927x;
                            Context context2 = fKFakePromptLayout.getContext();
                            aVar.a(context2 instanceof Activity ? (Activity) context2 : null, changeAvatarModel);
                        }
                    }, (r16 & 8) != 0 ? null : null, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? R$string.need_access_media_upload_better : 0);
                    j1.i.f50236a.a(PopupName.AVATAR_FAKE_POPUP, PopupButtonName.UploadAvatar, sensorPosition2);
                }
            }
        });
    }

    public final void h() {
        z.a(this, R$layout.layout_fake_prompt, true);
        ((TextView) f(R$id.fakePromptTitle)).getPaint().setFakeBoldText(true);
    }

    public final void i(@NotNull final FakeAvatarModel fakeAvatar, @NotNull final SensorPosition position) {
        kotlin.jvm.internal.s.i(fakeAvatar, "fakeAvatar");
        kotlin.jvm.internal.s.i(position, "position");
        if (fakeAvatar.getFakeAvatar() == null) {
            ((ImageLoaderView) f(R$id.fakeAvatarImage)).setVisibility(8);
            ((ImageView) f(R$id.fake_avatar_remind_sign_img)).setVisibility(8);
        } else {
            int i10 = R$id.fakeAvatarImage;
            ImageLoaderView fakeAvatarImage = (ImageLoaderView) f(i10);
            kotlin.jvm.internal.s.h(fakeAvatarImage, "fakeAvatarImage");
            ImageLoaderView.g(fakeAvatarImage, fakeAvatar.getFakeAvatar(), null, null, 6, null);
            ((ImageLoaderView) f(i10)).setVisibility(0);
            ((ImageView) f(R$id.fake_avatar_remind_sign_img)).setVisibility(0);
        }
        ((TextView) f(R$id.fakePromptTitle)).setText(fakeAvatar.getContent());
        ((ImageView) f(R$id.fakeAvatarCloseImage)).setVisibility(fakeAvatar.getCanClose() ? 0 : 8);
        AlertDialog dialog = z0.b.f54812a.e(getContext()).setView(this).create();
        dialog.setCanceledOnTouchOutside(false);
        dialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.cupidapp.live.appdialog.layout.d
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                FKFakePromptLayout.j(FakeAvatarModel.this, this, position, dialogInterface);
            }
        });
        kotlin.jvm.internal.s.h(dialog, "dialog");
        g(dialog, position);
        dialog.show();
        Window window = dialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setWindowAnimations(R$style.dialog_translate_anim);
            window.setLayout(-1, -2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKFakePromptLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.i(context, "context");
        this.f11669d = new LinkedHashMap();
        h();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKFakePromptLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.s.i(context, "context");
        this.f11669d = new LinkedHashMap();
        h();
    }
}
