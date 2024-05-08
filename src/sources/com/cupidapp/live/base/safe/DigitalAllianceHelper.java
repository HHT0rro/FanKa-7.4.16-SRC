package com.cupidapp.live.base.safe;

import android.content.Context;
import cn.shuzilm.core.Listener;
import cn.shuzilm.core.Main;
import com.cupidapp.live.AppApplication;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.utils.j;
import com.cupidapp.live.base.view.dialog.FKAlertDialog;
import com.cupidapp.live.base.view.h;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import j1.n;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p1.g;

/* compiled from: DigitalAllianceHelper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class DigitalAllianceHelper {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final DigitalAllianceHelper f12175a = new DigitalAllianceHelper();

    public static final void d(String it) {
        j.a aVar = j.f12332a;
        aVar.a("DigitalAllianceHelper", "QueryID:" + it);
        if (it == null || it.length() == 0) {
            return;
        }
        com.cupidapp.live.base.network.a aVar2 = com.cupidapp.live.base.network.a.f11902a;
        s.h(it, "it");
        aVar2.w(aVar2.e(it));
        aVar.a("DigitalAllianceHelper", "equipmentSafeEncryptId:" + aVar2.h());
        n.f50241a.a(it);
        f12175a.f();
    }

    public final String b() {
        return com.cupidapp.live.base.network.a.f11902a.h() + "\n\n guid: \n\n" + g.f52734a.g();
    }

    public final void c() {
        if (g.f52734a.X() == null) {
            return;
        }
        try {
            AppApplication.a aVar = AppApplication.f11612d;
            Main.init(aVar.h().getApplicationContext(), "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAKrxd6xg3i6OL6j34xOS3aGZZqxFKBj7eeDqJ44coQFoNi7KxZ8h6OkZCRMX0S8Btodi/NFlb57gsk/kowjfBAcCAwEAAQ==");
            Main.setConfig("pkglist", "1");
            Main.setConfig("cdlmt", "1");
            Main.getQueryID(aVar.h().getApplicationContext(), com.cupidapp.live.base.network.a.f11902a.r(), "message", 1, new Listener() { // from class: com.cupidapp.live.base.safe.a
                @Override // cn.shuzilm.core.Listener
                public final void handler(String str) {
                    DigitalAllianceHelper.d(str);
                }
            });
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void e(@Nullable final Context context) {
        if (context == null) {
            return;
        }
        final String b4 = b();
        FKAlertDialog.G(FKAlertDialog.w(FKAlertDialog.a.c(FKAlertDialog.f12698l, context, false, 2, null).D(R$string.anti_fraud_domain_name).n(b4), R$string.copy, null, new Function0<p>() { // from class: com.cupidapp.live.base.safe.DigitalAllianceHelper$showDigitalAllianceText$1
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
                if (q1.c.f53005a.b(context, b4)) {
                    h.f12779a.d(context, "复制成功");
                } else {
                    h.f12779a.s(context, "复制失败");
                }
            }
        }, 2, null), null, 1, null);
    }

    public final void f() {
        Disposable disposed = NetworkClient.f11868a.I().a().flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, p>() { // from class: com.cupidapp.live.base.safe.DigitalAllianceHelper$uploadDigitalAllianceId$$inlined$handle$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Object obj) {
                invoke2(obj);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
                j.f12332a.a("DigitalAllianceHelper", "uploadDigitalAllianceId succeed");
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.base.safe.DigitalAllianceHelper$uploadDigitalAllianceId$2
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                s.i(it, "it");
                j.f12332a.a("DigitalAllianceHelper", "uploadDigitalAllianceId failed");
                return Boolean.TRUE;
            }
        }, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }
}
