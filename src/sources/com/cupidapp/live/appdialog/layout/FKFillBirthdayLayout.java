package com.cupidapp.live.appdialog.layout;

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
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$style;
import com.cupidapp.live.appdialog.model.FillBirthdayModel;
import com.cupidapp.live.appdialog.model.WindowType;
import com.cupidapp.live.base.extension.DateFormatPattern;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.sensorslog.PopupButtonName;
import com.cupidapp.live.base.sensorslog.PopupName;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.view.BaseLayout;
import com.cupidapp.live.base.view.button.FKUniversalButton;
import com.cupidapp.live.profile.model.ProfileComplementResult;
import com.cupidapp.live.profile.model.ProfileSpecListModel;
import com.cupidapp.live.profile.model.ProfileSpecModifyResult;
import com.cupidapp.live.profile.model.User;
import e1.a;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.v;
import z0.y;
import z0.z;

/* compiled from: FKFillBirthdayLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKFillBirthdayLayout extends BaseLayout {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f11670d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKFillBirthdayLayout(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.f11670d = new LinkedHashMap();
        j();
    }

    public static final void m(FillBirthdayModel model, FKFillBirthdayLayout this$0, SensorPosition position, DialogInterface dialogInterface) {
        kotlin.jvm.internal.s.i(model, "$model");
        kotlin.jvm.internal.s.i(this$0, "this$0");
        kotlin.jvm.internal.s.i(position, "$position");
        Disposable disposed = a.C0726a.c(NetworkClient.f11868a.i(), model.getScene(), WindowType.Birthday.getType(), null, null, null, null, null, null, null, null, 1020, null).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.appdialog.layout.FKFillBirthdayLayout$showFillBirthdayDialog$lambda$3$$inlined$handle$default$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                invoke2(obj);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this$0)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
            this$0.H(disposed);
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
        j1.i.g(j1.i.f50236a, PopupName.BIRTHDAY_POPUP, position, null, 4, null);
    }

    @Nullable
    public View f(int i10) {
        Map<Integer, View> map = this.f11670d;
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

    public final void i(final AlertDialog alertDialog, ProfileSpecListModel profileSpecListModel, final String str, final SensorPosition sensorPosition) {
        Context context = getContext();
        kotlin.jvm.internal.s.h(context, "context");
        List<String> labelList = profileSpecListModel.getLabelList();
        com.cupidapp.live.base.view.timepicker.o e2 = com.cupidapp.live.base.view.timepicker.o.e(new com.cupidapp.live.base.view.timepicker.o(context, labelList != null ? (String) CollectionsKt___CollectionsKt.V(labelList) : null, profileSpecListModel.getMinValue(), profileSpecListModel.getMaxValue(), new Function1<Date, kotlin.p>() { // from class: com.cupidapp.live.appdialog.layout.FKFillBirthdayLayout$configTimePicker$timePicker$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Date date) {
                if (date != null) {
                    FKFillBirthdayLayout.this.k(alertDialog, str, kotlin.collections.r.e(v.t(date, DateFormatPattern.YyyyMMdd)));
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Date date) {
                invoke2(date);
                return kotlin.p.f51048a;
            }
        }), 20, 1.5f, false, 4, null);
        int i10 = R$id.birthdayPickerLayout;
        FrameLayout birthdayPickerLayout = (FrameLayout) f(i10);
        kotlin.jvm.internal.s.h(birthdayPickerLayout, "birthdayPickerLayout");
        final com.cupidapp.live.base.view.timepicker.o g3 = e2.g(birthdayPickerLayout);
        FKUniversalButton saveBirthdayButton = (FKUniversalButton) f(R$id.saveBirthdayButton);
        kotlin.jvm.internal.s.h(saveBirthdayButton, "saveBirthdayButton");
        y.d(saveBirthdayButton, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.appdialog.layout.FKFillBirthdayLayout$configTimePicker$1
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
                j1.i.f50236a.a(PopupName.BIRTHDAY_POPUP, PopupButtonName.SaveBirthday, SensorPosition.this);
                g3.c();
            }
        });
        g3.i((FrameLayout) f(i10), false);
    }

    public final void j() {
        z.a(this, R$layout.layout_fill_birthday, true);
        ((TextView) f(R$id.fillBirthdayTitleTextView)).getPaint().setFakeBoldText(true);
    }

    public final void k(final AlertDialog alertDialog, String str, List<String> list) {
        d();
        Disposable disposed = NetworkClient.f11868a.N().r0(str, list).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<ProfileSpecModifyResult, kotlin.p>() { // from class: com.cupidapp.live.appdialog.layout.FKFillBirthdayLayout$saveBirthdayData$$inlined$handle$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(ProfileSpecModifyResult profileSpecModifyResult) {
                m2452invoke(profileSpecModifyResult);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2452invoke(ProfileSpecModifyResult profileSpecModifyResult) {
                ProfileSpecModifyResult profileSpecModifyResult2 = profileSpecModifyResult;
                p1.g gVar = p1.g.f52734a;
                User X = gVar.X();
                if (X != null) {
                    List<ProfileSpecListModel> profileSpecList = X.getProfileSpecList();
                    if (profileSpecList != null) {
                        profileSpecList.clear();
                    }
                    List<ProfileSpecListModel> profileSpecList2 = X.getProfileSpecList();
                    if (profileSpecList2 != null) {
                        profileSpecList2.addAll(profileSpecModifyResult2.getList());
                    }
                    gVar.A2(X);
                }
                FKFillBirthdayLayout.this.a();
                alertDialog.dismiss();
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.appdialog.layout.FKFillBirthdayLayout$saveBirthdayData$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                kotlin.jvm.internal.s.i(it, "it");
                FKFillBirthdayLayout.this.a();
                alertDialog.dismiss();
                return Boolean.FALSE;
            }
        }, this)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
            H(disposed);
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }

    public final void l(@NotNull final FillBirthdayModel model, @NotNull final SensorPosition position) {
        kotlin.jvm.internal.s.i(model, "model");
        kotlin.jvm.internal.s.i(position, "position");
        ((TextView) f(R$id.fillBirthdayTitleTextView)).setText(model.getTitle());
        ((TextView) f(R$id.fillBirthdayMessageTextView)).setText(model.getContent());
        final AlertDialog create = z0.b.f54812a.e(getContext()).setView(this).create();
        create.setCanceledOnTouchOutside(false);
        create.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.cupidapp.live.appdialog.layout.e
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                FKFillBirthdayLayout.m(FillBirthdayModel.this, this, position, dialogInterface);
            }
        });
        create.show();
        Disposable disposed = NetworkClient.f11868a.N().s0().flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<ProfileComplementResult, kotlin.p>() { // from class: com.cupidapp.live.appdialog.layout.FKFillBirthdayLayout$showFillBirthdayDialog$$inlined$handle$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(ProfileComplementResult profileComplementResult) {
                m2453invoke(profileComplementResult);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2453invoke(ProfileComplementResult profileComplementResult) {
                ProfileComplementResult profileComplementResult2 = profileComplementResult;
                if (profileComplementResult2.getBirthday() != null) {
                    FKFillBirthdayLayout fKFillBirthdayLayout = FKFillBirthdayLayout.this;
                    AlertDialog dialog = create;
                    kotlin.jvm.internal.s.h(dialog, "dialog");
                    fKFillBirthdayLayout.i(create, profileComplementResult2.getBirthday(), model.getItemId(), position);
                }
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
            H(disposed);
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
        Window window = create.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setWindowAnimations(R$style.dialog_translate_anim);
            window.setLayout(-1, -2);
        }
        ImageView fillBirthdayCloseImageView = (ImageView) f(R$id.fillBirthdayCloseImageView);
        kotlin.jvm.internal.s.h(fillBirthdayCloseImageView, "fillBirthdayCloseImageView");
        y.d(fillBirthdayCloseImageView, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.appdialog.layout.FKFillBirthdayLayout$showFillBirthdayDialog$4
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
                j1.i.f50236a.a(PopupName.BIRTHDAY_POPUP, PopupButtonName.Close, SensorPosition.this);
                create.dismiss();
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKFillBirthdayLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.i(context, "context");
        this.f11670d = new LinkedHashMap();
        j();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKFillBirthdayLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.s.i(context, "context");
        this.f11670d = new LinkedHashMap();
        j();
    }
}
