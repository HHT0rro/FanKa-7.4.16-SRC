package com.cupidapp.live.profile.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
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
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x2.a;

/* compiled from: EditUserDescriptionActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class EditUserDescriptionActivity extends FKBaseActivity {

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public static final a f17605r = new a(null);

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17606q = new LinkedHashMap();

    /* compiled from: EditUserDescriptionActivity.kt */
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
            context.startActivity(new Intent(context, (Class<?>) EditUserDescriptionActivity.class));
            FKBaseActivity.a.c(FKBaseActivity.f11750o, context, 0, 0, 6, null);
        }
    }

    @Nullable
    public View j1(int i10) {
        Map<Integer, View> map = this.f17606q;
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
        FKTitleBarLayout fKTitleBarLayout = (FKTitleBarLayout) j1(R$id.editDescriptionTitleLayout);
        fKTitleBarLayout.setLeftImageClickEvent(new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.profile.activity.EditUserDescriptionActivity$bindClickEvent$1$1
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
                EditUserDescriptionActivity.this.finish();
            }
        });
        fKTitleBarLayout.setRightTextClickEvent(new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.profile.activity.EditUserDescriptionActivity$bindClickEvent$1$2
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
                EditUserDescriptionActivity.this.n1();
            }
        });
        new q1.g(kotlin.collections.r.e((EditText) j1(R$id.userDescriptionEditText)), new Function1<Boolean, kotlin.p>() { // from class: com.cupidapp.live.profile.activity.EditUserDescriptionActivity$bindClickEvent$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return kotlin.p.f51048a;
            }

            public final void invoke(boolean z10) {
                TextView textView = (TextView) EditUserDescriptionActivity.this.j1(R$id.wordCountTextView);
                EditUserDescriptionActivity editUserDescriptionActivity = EditUserDescriptionActivity.this;
                textView.setText(editUserDescriptionActivity.getString(R$string.remaining_input_words, new Object[]{Integer.valueOf(140 - ((EditText) editUserDescriptionActivity.j1(R$id.userDescriptionEditText)).length())}));
            }
        });
    }

    public final void m1() {
        String summary;
        int i10 = R$id.userDescriptionEditText;
        ((EditText) j1(i10)).setFilters(new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(140)});
        User X = p1.g.f52734a.X();
        if (X == null || (summary = X.getSummary()) == null) {
            return;
        }
        ((EditText) j1(i10)).setText(summary);
        int length = ((EditText) j1(i10)).length();
        ((EditText) j1(i10)).setSelection(length);
        ((TextView) j1(R$id.wordCountTextView)).setText(getString(R$string.remaining_input_words, new Object[]{Integer.valueOf(140 - length)}));
        EditText userDescriptionEditText = (EditText) j1(i10);
        kotlin.jvm.internal.s.h(userDescriptionEditText, "userDescriptionEditText");
        z0.h.v(this, userDescriptionEditText);
    }

    public final void n1() {
        String obj = ((EditText) j1(R$id.userDescriptionEditText)).getText().toString();
        final Map h10 = i0.h(kotlin.f.a(Integer.valueOf(RequestErrorCode.ImproperContent.getValue()), new Function1<String, kotlin.p>() { // from class: com.cupidapp.live.profile.activity.EditUserDescriptionActivity$saveDescription$serverErrorInterceptor$1
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
                com.cupidapp.live.base.view.h.f12779a.s(EditUserDescriptionActivity.this, str);
            }
        }));
        e1();
        Disposable disposed = a.C0836a.y(NetworkClient.f11868a.N(), null, obj, 1, null).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<UserModifyResult, kotlin.p>() { // from class: com.cupidapp.live.profile.activity.EditUserDescriptionActivity$saveDescription$$inlined$handle$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(UserModifyResult userModifyResult) {
                m2754invoke(userModifyResult);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2754invoke(UserModifyResult userModifyResult) {
                EditUserDescriptionActivity.this.V0();
                p1.g gVar = p1.g.f52734a;
                gVar.B2(true);
                gVar.A2(userModifyResult.getUser());
                j1.d.f50229a.a(TrackEditInfoType.SELF_DESCRIPTION, SensorPosition.EditProfile);
                com.cupidapp.live.base.view.h.f12779a.c(EditUserDescriptionActivity.this, R$string.save_success);
                EventBus.c().o(new v1.a());
                EditUserDescriptionActivity.this.finish();
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.profile.activity.EditUserDescriptionActivity$saveDescription$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                kotlin.jvm.internal.s.i(it, "it");
                EditUserDescriptionActivity.this.V0();
                com.cupidapp.live.base.network.j.f(com.cupidapp.live.base.network.j.f12008a, it, EditUserDescriptionActivity.this, h10, null, 8, null);
                return Boolean.FALSE;
            }
        }, this)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
            H(disposed);
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_edit_user_description);
        m1();
        l1();
    }
}
