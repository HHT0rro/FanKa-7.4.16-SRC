package com.cupidapp.live.profile.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.RequestErrorCode;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.TrackEditInfoType;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.main.model.UserModifyResult;
import com.cupidapp.live.profile.model.User;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.i0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x2.a;

/* compiled from: EditUserNameActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class EditUserNameActivity extends FKBaseActivity {

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public static final a f17607r = new a(null);

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17608q = new LinkedHashMap();

    /* compiled from: EditUserNameActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context) {
            kotlin.jvm.internal.s.i(context, "context");
            context.startActivity(new Intent(context, (Class<?>) EditUserNameActivity.class));
            FKBaseActivity.a.c(FKBaseActivity.f11750o, context, 0, 0, 6, null);
        }
    }

    @Nullable
    public View j1(int i10) {
        Map<Integer, View> map = this.f17608q;
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

    public final void l1() {
        FKTitleBarLayout fKTitleBarLayout = (FKTitleBarLayout) j1(R$id.editUsrNameTitleLayout);
        fKTitleBarLayout.setLeftImageClickEvent(new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.profile.activity.EditUserNameActivity$bindClickEvent$1$1
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
                EditUserNameActivity.this.finish();
            }
        });
        fKTitleBarLayout.setRightTextClickEvent(new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.profile.activity.EditUserNameActivity$bindClickEvent$1$2
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
                EditUserNameActivity.this.n1();
            }
        });
    }

    public final void m1() {
        String name;
        User X = p1.g.f52734a.X();
        if (X == null || (name = X.getName()) == null) {
            return;
        }
        int i10 = R$id.userNameEditText;
        ((EditText) j1(i10)).setText(name);
        ((EditText) j1(i10)).setSelection(name.length());
        EditText userNameEditText = (EditText) j1(i10);
        kotlin.jvm.internal.s.h(userNameEditText, "userNameEditText");
        z0.h.v(this, userNameEditText);
    }

    public final void n1() {
        String A = kotlin.text.p.A(((EditText) j1(R$id.userNameEditText)).getText().toString(), " ", "", false, 4, null);
        if (A.length() > 0) {
            final Map h10 = i0.h(kotlin.f.a(Integer.valueOf(RequestErrorCode.UserNotFound.getValue()), new Function1<String, kotlin.p>() { // from class: com.cupidapp.live.profile.activity.EditUserNameActivity$saveName$serverErrorInterceptor$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ kotlin.p invoke(String str) {
                    invoke2(str);
                    return kotlin.p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable String str) {
                    com.cupidapp.live.base.view.h.f12779a.s(EditUserNameActivity.this, str);
                }
            }), kotlin.f.a(Integer.valueOf(RequestErrorCode.UsernameUsed.getValue()), new Function1<String, kotlin.p>() { // from class: com.cupidapp.live.profile.activity.EditUserNameActivity$saveName$serverErrorInterceptor$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ kotlin.p invoke(String str) {
                    invoke2(str);
                    return kotlin.p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable String str) {
                    com.cupidapp.live.base.view.h.f12779a.s(EditUserNameActivity.this, str);
                }
            }), kotlin.f.a(Integer.valueOf(RequestErrorCode.ImproperNickName.getValue()), new Function1<String, kotlin.p>() { // from class: com.cupidapp.live.profile.activity.EditUserNameActivity$saveName$serverErrorInterceptor$3
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ kotlin.p invoke(String str) {
                    invoke2(str);
                    return kotlin.p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable String str) {
                    com.cupidapp.live.base.view.h.f12779a.s(EditUserNameActivity.this, str);
                }
            }), kotlin.f.a(Integer.valueOf(RequestErrorCode.NickNameIsTooShort.getValue()), new Function1<String, kotlin.p>() { // from class: com.cupidapp.live.profile.activity.EditUserNameActivity$saveName$serverErrorInterceptor$4
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ kotlin.p invoke(String str) {
                    invoke2(str);
                    return kotlin.p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable String str) {
                    com.cupidapp.live.base.view.h.f12779a.s(EditUserNameActivity.this, str);
                }
            }), kotlin.f.a(Integer.valueOf(RequestErrorCode.NickNameIsTooLong.getValue()), new Function1<String, kotlin.p>() { // from class: com.cupidapp.live.profile.activity.EditUserNameActivity$saveName$serverErrorInterceptor$5
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ kotlin.p invoke(String str) {
                    invoke2(str);
                    return kotlin.p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable String str) {
                    com.cupidapp.live.base.view.h.f12779a.s(EditUserNameActivity.this, str);
                }
            }));
            e1();
            Disposable disposed = a.C0836a.y(NetworkClient.f11868a.N(), A, null, 2, null).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<UserModifyResult, kotlin.p>() { // from class: com.cupidapp.live.profile.activity.EditUserNameActivity$saveName$$inlined$handle$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ kotlin.p invoke(UserModifyResult userModifyResult) {
                    m2755invoke(userModifyResult);
                    return kotlin.p.f51048a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m2755invoke(UserModifyResult userModifyResult) {
                    EditUserNameActivity.this.V0();
                    p1.g gVar = p1.g.f52734a;
                    gVar.B2(true);
                    gVar.A2(userModifyResult.getUser());
                    j1.d.f50229a.a(TrackEditInfoType.NICK_NAME, SensorPosition.EditProfile);
                    com.cupidapp.live.base.view.h.f12779a.r(EditUserNameActivity.this, R$string.save_success);
                    EditUserNameActivity.this.finish();
                }
            }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.profile.activity.EditUserNameActivity$saveName$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull Throwable it) {
                    kotlin.jvm.internal.s.i(it, "it");
                    EditUserNameActivity.this.V0();
                    com.cupidapp.live.base.network.j.f(com.cupidapp.live.base.network.j.f12008a, it, EditUserNameActivity.this, h10, null, 8, null);
                    return Boolean.FALSE;
                }
            }, this)));
            if (disposed != null) {
                kotlin.jvm.internal.s.h(disposed, "disposed");
                H(disposed);
            }
            kotlin.jvm.internal.s.h(disposed, "disposed");
            return;
        }
        com.cupidapp.live.base.view.h.f12779a.r(this, R$string.nick_name_can_not_empty);
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_edit_user_name);
        m1();
        l1();
    }
}
