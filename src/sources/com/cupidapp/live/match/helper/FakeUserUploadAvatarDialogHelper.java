package com.cupidapp.live.match.helper;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.g;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.permission.FKRxPermissionAlertDialog;
import com.cupidapp.live.base.sensorslog.PopupButtonName;
import com.cupidapp.live.base.sensorslog.PopupName;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.setting.activity.ChangeAvatarActivity;
import com.cupidapp.live.setting.activity.ChangeAvatarModel;
import com.cupidapp.live.setting.model.AvatarProfileModel;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.t;
import z0.u;
import z0.y;

/* compiled from: FakeUserUploadAvatarDialogHelper.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FakeUserUploadAvatarDialogHelper {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final FakeUserUploadAvatarDialogHelper f16755a = new FakeUserUploadAvatarDialogHelper();

    /* JADX WARN: Multi-variable type inference failed */
    public final void d(SensorPosition sensorPosition, Context context, final a aVar) {
        Observable<Result<Object>> Z = NetworkClient.f11868a.N().Z(sensorPosition == SensorPosition.NotifyAloha ? "notify" : "aloha");
        FakeUserUploadAvatarDialogHelper$closeDialog$2 fakeUserUploadAvatarDialogHelper$closeDialog$2 = new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.match.helper.FakeUserUploadAvatarDialogHelper$closeDialog$2
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                s.i(it, "it");
                return Boolean.TRUE;
            }
        };
        g gVar = context instanceof g ? (g) context : null;
        Disposable disposed = Z.flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<Object, p>() { // from class: com.cupidapp.live.match.helper.FakeUserUploadAvatarDialogHelper$closeDialog$$inlined$handleByContext$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Object obj) {
                invoke2(obj);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
                a.this.dismiss();
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(fakeUserUploadAvatarDialogHelper$closeDialog$2, gVar)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            if (gVar != null) {
                gVar.H(disposed);
            }
        }
        s.h(disposed, "disposed");
        j1.i.f50236a.a(PopupName.FAKE_UPLOAD_AVATAR, PopupButtonName.Close, sensorPosition);
    }

    public final void e(final Context context, xb.b bVar, final AlertDialog alertDialog, final SensorPosition sensorPosition) {
        FKRxPermissionAlertDialog.f12016a.m(context, bVar, (r16 & 4) != 0 ? null : new Function0<p>() { // from class: com.cupidapp.live.match.helper.FakeUserUploadAvatarDialogHelper$confirmDialog$1
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
                alertDialog.dismiss();
                FakeUserUploadAvatarDialogHelper.f16755a.f(sensorPosition, context);
            }
        }, (r16 & 8) != 0 ? null : null, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? R$string.need_access_media_upload_better : 0);
        j1.i.f50236a.a(PopupName.FAKE_UPLOAD_AVATAR, PopupButtonName.UPLOAD_AVATAR, sensorPosition);
    }

    public final void f(SensorPosition sensorPosition, Context context) {
        String string;
        AvatarProfileModel avatarProfileModel;
        ImageModel avatarImage;
        User X = p1.g.f52734a.X();
        List<AvatarProfileModel> avatarProfile = X != null ? X.getAvatarProfile() : null;
        String imageId = (!(avatarProfile != null && avatarProfile.size() == 6) || (avatarProfileModel = (AvatarProfileModel) CollectionsKt___CollectionsKt.f0(avatarProfile)) == null || (avatarImage = avatarProfileModel.getAvatarImage()) == null) ? null : avatarImage.getImageId();
        if (sensorPosition == SensorPosition.Match) {
            string = context.getString(R$string.upload_success_to_swipe);
        } else {
            string = context.getString(R$string.upload_success);
        }
        ChangeAvatarActivity.f17927x.a(context instanceof Activity ? (Activity) context : null, new ChangeAvatarModel(imageId, sensorPosition, string, false));
    }

    public final void g(@NotNull xb.b rxPermissions, @NotNull Context context, @NotNull SensorPosition sensorPosition, @NotNull a clickListener) {
        s.i(rxPermissions, "rxPermissions");
        s.i(context, "context");
        s.i(sensorPosition, "sensorPosition");
        s.i(clickListener, "clickListener");
        h(rxPermissions, context, sensorPosition, clickListener);
        j1.i.g(j1.i.f50236a, PopupName.FAKE_UPLOAD_AVATAR, sensorPosition, null, 4, null);
    }

    public final void h(final xb.b bVar, final Context context, final SensorPosition sensorPosition, final a aVar) {
        final AlertDialog g3;
        View layout = View.inflate(context, R$layout.dialog_no_avatar_detail, null);
        ImageLoaderView myIcon = (ImageLoaderView) layout.findViewById(R$id.no_avatar_avatar);
        TextView confirmBtn = (TextView) layout.findViewById(R$id.dialog_bottom_btn);
        TextView textView = (TextView) layout.findViewById(R$id.no_avatar_heart_title);
        ImageView closeView = (ImageView) layout.findViewById(R$id.no_avatar_close);
        String string = context.getString(R$string.accept_more_like);
        s.h(string, "context.getString(R.string.accept_more_like)");
        textView.setText(t.k(string, -49088, new String[]{context.getString(R$string.four_hundred_percent)}, false, 4, null));
        s.h(myIcon, "myIcon");
        User X = p1.g.f52734a.X();
        ImageLoaderView.g(myIcon, X != null ? X.getAvatarImage() : null, null, null, 6, null);
        s.h(confirmBtn, "confirmBtn");
        u.a(confirmBtn);
        z0.b bVar2 = z0.b.f54812a;
        s.h(layout, "layout");
        g3 = bVar2.g(context, layout, 0, 0, -1, -2, (r32 & 64) != 0 ? 17 : 80, (r32 & 128) != 0 ? null : null, (r32 & 256) != 0 ? null : null, (r32 & 512) != 0 ? null : null, (r32 & 1024) != 0 ? null : null, (r32 & 2048) != 0 ? null : null, (r32 & 4096) != 0 ? null : null, (r32 & 8192) != 0 ? null : null);
        g3.setCancelable(false);
        g3.setCanceledOnTouchOutside(false);
        s.h(closeView, "closeView");
        y.d(closeView, new Function1<View, p>() { // from class: com.cupidapp.live.match.helper.FakeUserUploadAvatarDialogHelper$showUploadAvatarDetailDialog$1
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
                g3.dismiss();
                FakeUserUploadAvatarDialogHelper.f16755a.d(sensorPosition, context, aVar);
            }
        });
        y.d(confirmBtn, new Function1<View, p>() { // from class: com.cupidapp.live.match.helper.FakeUserUploadAvatarDialogHelper$showUploadAvatarDetailDialog$2
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
                FakeUserUploadAvatarDialogHelper.f16755a.e(context, bVar, g3, sensorPosition);
            }
        });
    }
}
