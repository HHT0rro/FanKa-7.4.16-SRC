package com.cupidapp.live.base.router.jumper;

import android.content.Context;
import android.net.Uri;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.alibaba.security.realidentity.build.cg;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.share.fragment.ShareBottomFragment;
import com.cupidapp.live.base.share.fragment.ShareModel;
import com.cupidapp.live.base.share.helper.ShareBuilder;
import com.tencent.open.SocialConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ShareJumper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class q0 implements com.cupidapp.live.base.router.h {
    @Override // com.cupidapp.live.base.router.h
    public void a(@Nullable Context context, @NotNull Uri uri, @Nullable String str) {
        kotlin.jvm.internal.s.i(uri, "uri");
        com.cupidapp.live.base.utils.j.f12332a.a("ShareJumper", "jump uri:" + ((Object) uri));
        String path = uri.getPath();
        if (kotlin.jvm.internal.s.d(path != null ? kotlin.text.p.A(path, "/", "", false, 4, null) : null, cg.f3316f)) {
            FragmentActivity fragmentActivity = context instanceof FragmentActivity ? (FragmentActivity) context : null;
            if (fragmentActivity != null) {
                b(fragmentActivity, uri);
            }
        }
    }

    public final void b(FragmentActivity fragmentActivity, Uri uri) {
        String queryParameter = uri.getQueryParameter("url");
        String queryParameter2 = uri.getQueryParameter("title");
        String queryParameter3 = uri.getQueryParameter(SocialConstants.PARAM_APP_DESC);
        String queryParameter4 = uri.getQueryParameter("img_url");
        if (queryParameter == null || queryParameter.length() == 0) {
            return;
        }
        if (queryParameter4 == null || queryParameter4.length() == 0) {
            return;
        }
        ShareModel shareModel = new ShareModel(null, null, new ShareBuilder(queryParameter, queryParameter2, queryParameter3, null, fragmentActivity, null, null, null, null, null, null, 0, null, null, queryParameter4, 16352, null), null, null, SensorPosition.Web, null, null, com.cupidapp.live.base.router.helper.a.f12141a.a(uri), null, null, 1755, null);
        ShareBottomFragment a10 = ShareBottomFragment.f12224k.a();
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        kotlin.jvm.internal.s.h(supportFragmentManager, "activity.supportFragmentManager");
        ShareBottomFragment.w1(a10, supportFragmentManager, shareModel, null, 4, null);
    }
}
