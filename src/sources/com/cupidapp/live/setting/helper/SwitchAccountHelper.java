package com.cupidapp.live.setting.helper;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
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
import com.cupidapp.live.base.view.dialog.h;
import com.cupidapp.live.login.helper.LogoutHelper;
import com.cupidapp.live.login.helper.SignInResultHelper;
import com.cupidapp.live.login.model.AuthResult;
import com.cupidapp.live.profile.model.AuditInfoUser;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.setting.model.MultiAccountUserIdsModel;
import com.cupidapp.live.setting.model.SwitchAccountResult;
import com.cupidapp.live.setting.model.SwitchAccountUserModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.Iterator;
import java.util.List;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import n3.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p1.g;

/* compiled from: SwitchAccountHelper.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class SwitchAccountHelper {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final SwitchAccountHelper f18181a = new SwitchAccountHelper();

    public final boolean b(@NotNull final FKBaseActivity activity, @Nullable String str, @Nullable final Uri uri, @Nullable final String str2) {
        List<String> list;
        s.i(activity, "activity");
        g gVar = g.f52734a;
        User X = gVar.X();
        String userId = X != null ? X.userId() : null;
        if (!(str == null || str.length() == 0)) {
            if (!(userId == null || userId.length() == 0) && !s.d(str, userId)) {
                MultiAccountUserIdsModel p02 = gVar.p0();
                if ((p02 == null || (list = p02.getList()) == null || list.contains(str)) ? false : true) {
                    return false;
                }
                h.d(h.f12743a, activity.getString(R$string.account_switching), false, 2, null);
                Disposable disposed = NetworkClient.f11868a.w().c(str, false).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<AuthResult, p>() { // from class: com.cupidapp.live.setting.helper.SwitchAccountHelper$checkPushUserIsCurrentUser$$inlined$handle$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(AuthResult authResult) {
                        m2800invoke(authResult);
                        return p.f51048a;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m2800invoke(AuthResult authResult) {
                        a aVar = new a(false, true, uri, str2);
                        SwitchAccountHelper.f18181a.f(activity, authResult, aVar);
                    }
                }), new e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.setting.helper.SwitchAccountHelper$checkPushUserIsCurrentUser$2
                    @Override // kotlin.jvm.functions.Function1
                    @NotNull
                    public final Boolean invoke(@NotNull Throwable it) {
                        s.i(it, "it");
                        h.f12743a.b();
                        return Boolean.FALSE;
                    }
                }, activity)));
                if (disposed != null) {
                    s.h(disposed, "disposed");
                    activity.H(disposed);
                }
                s.h(disposed, "disposed");
                return false;
            }
        }
        return true;
    }

    public final void c(final FKBaseActivity fKBaseActivity, SwitchAccountUserModel switchAccountUserModel) {
        Disposable disposed = NetworkClient.f11868a.w().c(switchAccountUserModel.getUserId(), true).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<AuthResult, p>() { // from class: com.cupidapp.live.setting.helper.SwitchAccountHelper$logoutAndSwitch$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(AuthResult authResult) {
                m2801invoke(authResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2801invoke(AuthResult authResult) {
                AuthResult authResult2 = authResult;
                MultiAccountUserIdManager multiAccountUserIdManager = MultiAccountUserIdManager.f18178a;
                User X = g.f52734a.X();
                multiAccountUserIdManager.b(X != null ? X.userId() : null);
                SwitchAccountHelper.f18181a.f(FKBaseActivity.this, authResult2, new a(true, true, null, null, 12, null));
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, fKBaseActivity)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            if (fKBaseActivity != null) {
                fKBaseActivity.H(disposed);
            }
        }
        s.h(disposed, "disposed");
    }

    public final void d(@NotNull final FKBaseActivity activity) {
        s.i(activity, "activity");
        h.d(h.f12743a, null, false, 3, null);
        MultiAccountUserIdsModel p02 = g.f52734a.p0();
        List<String> list = p02 != null ? p02.getList() : null;
        if (list == null || list.isEmpty()) {
            LogoutHelper.f(new LogoutHelper(), activity, false, null, 4, null);
            return;
        }
        Disposable disposed = b.a.a(NetworkClient.f11868a.w(), list, false, true, 2, null).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<SwitchAccountResult, p>() { // from class: com.cupidapp.live.setting.helper.SwitchAccountHelper$logoutAndSwitchNextAccount$$inlined$handle$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(SwitchAccountResult switchAccountResult) {
                m2802invoke(switchAccountResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2802invoke(SwitchAccountResult switchAccountResult) {
                SwitchAccountResult switchAccountResult2 = switchAccountResult;
                User X = g.f52734a.X();
                SwitchAccountUserModel switchAccountUserModel = null;
                String userId = X != null ? X.userId() : null;
                List<SwitchAccountUserModel> accountList = switchAccountResult2.getAccountList();
                if (accountList != null) {
                    Iterator<SwitchAccountUserModel> iterator2 = accountList.iterator2();
                    while (true) {
                        if (!iterator2.hasNext()) {
                            break;
                        }
                        SwitchAccountUserModel next = iterator2.next();
                        if (!s.d(next.getUserId(), userId)) {
                            switchAccountUserModel = next;
                            break;
                        }
                    }
                    switchAccountUserModel = switchAccountUserModel;
                }
                if (switchAccountUserModel == null) {
                    LogoutHelper.f(new LogoutHelper(), FKBaseActivity.this, false, null, 4, null);
                } else {
                    SwitchAccountHelper.f18181a.c(FKBaseActivity.this, switchAccountUserModel);
                }
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.setting.helper.SwitchAccountHelper$logoutAndSwitchNextAccount$2
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                s.i(it, "it");
                h.f12743a.b();
                return Boolean.FALSE;
            }
        }, activity)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            activity.H(disposed);
        }
        s.h(disposed, "disposed");
    }

    public final void e(@NotNull Context context, @Nullable User user) {
        s.i(context, "context");
        if (user == null) {
            return;
        }
        Toast toast = new Toast(context);
        View inflate = View.inflate(context, R$layout.layout_switch_account_success_tip, null);
        ImageLoaderView avatarImage = (ImageLoaderView) inflate.findViewById(R$id.switch_account_success_avatar);
        s.h(avatarImage, "avatarImage");
        AuditInfoUser auditInfoUser = user.getAuditInfoUser();
        ImageLoaderView.g(avatarImage, auditInfoUser != null ? auditInfoUser.getAvatar() : null, null, null, 6, null);
        TextView textView = (TextView) inflate.findViewById(R$id.switch_account_success_name);
        AuditInfoUser auditInfoUser2 = user.getAuditInfoUser();
        textView.setText(auditInfoUser2 != null ? auditInfoUser2.getUsername() : null);
        toast.setView(inflate);
        toast.setGravity(80, 0, z0.h.c(this, 30.0f));
        toast.setDuration(1);
        toast.show();
    }

    public final void f(@NotNull final FKBaseActivity activity, @NotNull final AuthResult result, @NotNull final a config) {
        s.i(activity, "activity");
        s.i(result, "result");
        s.i(config, "config");
        new LogoutHelper().e(activity, true, new Function0<p>() { // from class: com.cupidapp.live.setting.helper.SwitchAccountHelper$switchAccount$1
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
                FKBaseActivity.this.d1(R$anim.anim_activity_nothing, Integer.valueOf(R$anim.anim_activity_nothing));
                new SignInResultHelper().i(FKBaseActivity.this, result, null, config);
            }
        });
    }
}
