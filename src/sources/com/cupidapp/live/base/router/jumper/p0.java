package com.cupidapp.live.base.router.jumper;

import android.content.Context;
import android.net.Uri;
import com.cupidapp.live.MainActivity;
import com.cupidapp.live.main.view.FKUpdatePrivacyHelper;
import com.cupidapp.live.push.event.RouterUrlJumperSelectMainTabEvent;
import com.cupidapp.live.push.event.RouterUrlJumperSelectSecondTabEvent;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: RouterUrlJumper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class p0 implements com.cupidapp.live.base.router.h {
    @Override // com.cupidapp.live.base.router.h
    public void a(@Nullable Context context, @NotNull Uri uri, @Nullable String str) {
        kotlin.jvm.internal.s.i(uri, "uri");
        if (context != null && FKUpdatePrivacyHelper.f16202a.e() == null) {
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments.contains("MainPager")) {
                int size = pathSegments.size();
                if (size == 2) {
                    b(pathSegments.get(1));
                } else {
                    if (size != 3) {
                        return;
                    }
                    b(pathSegments.get(1));
                    c(pathSegments.get(2));
                }
            }
        }
    }

    public final void b(String str) {
        MainActivity.MainPagerType mainPagerType = MainActivity.MainPagerType.Match;
        if (!kotlin.jvm.internal.s.d(str, mainPagerType.getPageName())) {
            mainPagerType = MainActivity.MainPagerType.Live;
            if (!kotlin.jvm.internal.s.d(str, mainPagerType.getPageName())) {
                mainPagerType = MainActivity.MainPagerType.Feed;
                if (!kotlin.jvm.internal.s.d(str, mainPagerType.getPageName())) {
                    mainPagerType = MainActivity.MainPagerType.Chat;
                    if (!kotlin.jvm.internal.s.d(str, mainPagerType.getPageName())) {
                        mainPagerType = MainActivity.MainPagerType.Setting;
                    }
                }
            }
        }
        EventBus.c().o(new RouterUrlJumperSelectMainTabEvent(mainPagerType));
    }

    public final void c(String str) {
        if (str != null) {
            EventBus.c().o(new RouterUrlJumperSelectSecondTabEvent(str));
        }
    }
}
