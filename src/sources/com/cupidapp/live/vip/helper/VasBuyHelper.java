package com.cupidapp.live.vip.helper;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.network.a;
import com.cupidapp.live.base.network.model.ConstantsResult;
import com.cupidapp.live.base.network.model.LinkDictTipsModel;
import com.cupidapp.live.base.view.dialog.FKAlertDialog;
import com.hailiang.advlib.core.ADEvent;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.s;
import kotlin.p;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import p1.g;

/* compiled from: VasBuyHelper.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VasBuyHelper {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final VasBuyHelper f18742a = new VasBuyHelper();

    public static /* synthetic */ void c(VasBuyHelper vasBuyHelper, Context context, boolean z10, Function0 function0, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = true;
        }
        vasBuyHelper.b(context, z10, function0);
    }

    public final boolean a() {
        String lowerCase = a.f11902a.r().toLowerCase(Locale.ROOT);
        s.h(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return StringsKt__StringsKt.K(lowerCase, "oppo", false, 2, null) || StringsKt__StringsKt.K(lowerCase, ADEvent.VIVO, false, 2, null) || StringsKt__StringsKt.K(lowerCase, ADEvent.XIAOMI, false, 2, null);
    }

    public final void b(@NotNull Context context, boolean z10, @NotNull final Function0<p> confirmCallback) {
        LinkDictTipsModel billingVipTips;
        Map<String, String> linkDict;
        Set<String> h10;
        s.i(context, "context");
        s.i(confirmCallback, "confirmCallback");
        String lowerCase = a.f11902a.r().toLowerCase(Locale.ROOT);
        s.h(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        if (!StringsKt__StringsKt.K(lowerCase, "oppo", false, 2, null) && !StringsKt__StringsKt.K(lowerCase, ADEvent.VIVO, false, 2, null) && !StringsKt__StringsKt.K(lowerCase, ADEvent.XIAOMI, false, 2, null)) {
            confirmCallback.invoke();
            return;
        }
        if (z10) {
            confirmCallback.invoke();
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        ConstantsResult q10 = g.f52734a.q();
        if (q10 != null && (billingVipTips = q10.getBillingVipTips()) != null && (linkDict = billingVipTips.getLinkDict()) != null && (h10 = linkDict.h()) != null) {
            Iterator<String> iterator2 = h10.iterator2();
            while (iterator2.hasNext()) {
                spannableStringBuilder.append((CharSequence) ("《" + iterator2.next() + "》"));
            }
        }
        String string = context.getString(R$string.payment_terms_confirm, spannableStringBuilder);
        s.h(string, "context.getString(R.stri…t_terms_confirm, builder)");
        FKAlertDialog.G(FKAlertDialog.r(FKAlertDialog.w(FKAlertDialog.a.c(FKAlertDialog.f12698l, context, false, 2, null).n(string), 0, null, new Function0<p>() { // from class: com.cupidapp.live.vip.helper.VasBuyHelper$showBuySecondConfirmDialog$2
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
                confirmCallback.invoke();
            }
        }, 3, null), 0, null, 3, null), null, 1, null);
    }
}
