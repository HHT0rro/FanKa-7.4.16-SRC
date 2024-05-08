package com.cupidapp.live.base.web.helper;

import android.net.Uri;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.model.BaseUrlModel;
import com.cupidapp.live.base.network.model.ConstantsResult;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.collections.s;
import kotlin.jvm.functions.Function0;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p1.g;

/* compiled from: WebUrlWhiteListHelper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class WebUrlWhiteListHelper {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final WebUrlWhiteListHelper f13094a = new WebUrlWhiteListHelper();

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final Lazy f13095b = kotlin.c.b(new Function0<List<String>>() { // from class: com.cupidapp.live.base.web.helper.WebUrlWhiteListHelper$equalHostWhiteList$2
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final List<String> invoke() {
            return s.o("finka.cn");
        }
    });

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final Lazy f13096c = kotlin.c.b(new Function0<List<String>>() { // from class: com.cupidapp.live.base.web.helper.WebUrlWhiteListHelper$endWithHostWhiteList$2
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final List<String> invoke() {
            return s.o(".finka.cn", ".finkapp.cn", ".wowkaka.cn", ".lunar-landing-mission.com", ".zhongyingleyou.com", ".enjoymeet.com", ".missioncdn.com", ".xingqiuren.cn");
        }
    });

    public final List<String> a() {
        return (List) f13096c.getValue();
    }

    public final List<String> b() {
        return (List) f13095b.getValue();
    }

    public final boolean c(@Nullable String str) {
        if (!(str == null || str.length() == 0) && d(str)) {
            return StringsKt__StringsKt.K(str, "finkaAction=", false, 2, null);
        }
        return false;
    }

    public final boolean d(@Nullable String str) {
        String str2;
        if (str == null || str.length() == 0) {
            return false;
        }
        String host = Uri.parse(str).getHost();
        if (host != null) {
            Locale locale = Locale.getDefault();
            kotlin.jvm.internal.s.h(locale, "getDefault()");
            str2 = host.toLowerCase(locale);
            kotlin.jvm.internal.s.h(str2, "this as java.lang.String).toLowerCase(locale)");
        } else {
            str2 = null;
        }
        if (str2 == null || str2.length() == 0) {
            return false;
        }
        e();
        if (b().contains(str2) || a().contains(str2)) {
            return true;
        }
        Iterator<String> iterator2 = a().iterator2();
        while (iterator2.hasNext()) {
            if (p.p(str2, iterator2.next(), true)) {
                return true;
            }
        }
        return false;
    }

    public final void e() {
        List<String> authRequiredHost;
        List<String> urlWhiteList;
        ConstantsResult q10 = g.f52734a.q();
        if (q10 != null && (urlWhiteList = q10.getUrlWhiteList()) != null) {
            for (String str : urlWhiteList) {
                WebUrlWhiteListHelper webUrlWhiteListHelper = f13094a;
                if (!webUrlWhiteListHelper.a().contains(str)) {
                    webUrlWhiteListHelper.a().add(str);
                }
            }
        }
        BaseUrlModel g3 = NetworkClient.f11868a.g();
        if (g3 == null || (authRequiredHost = g3.getAuthRequiredHost()) == null) {
            return;
        }
        for (String str2 : authRequiredHost) {
            WebUrlWhiteListHelper webUrlWhiteListHelper2 = f13094a;
            if (!webUrlWhiteListHelper2.a().contains(str2)) {
                webUrlWhiteListHelper2.a().add(str2);
            }
        }
    }
}
