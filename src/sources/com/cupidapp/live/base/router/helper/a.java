package com.cupidapp.live.base.router.helper;

import android.net.Uri;
import com.cupidapp.live.base.share.model.SharePlatform;
import com.tencent.connect.common.Constants;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.collections.i0;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: ShareUriHelper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f12141a = new a();

    @NotNull
    public final List<SharePlatform> a(@NotNull Uri uri) {
        s.i(uri, "uri");
        Map g3 = i0.g(kotlin.f.a(ConstantsAPI.Token.WX_TOKEN_PLATFORMID_VALUE, SharePlatform.Wechat), kotlin.f.a("moments", SharePlatform.WechatMoments), kotlin.f.a("qq", SharePlatform.QQ), kotlin.f.a(Constants.SOURCE_QZONE, SharePlatform.QZone), kotlin.f.a("weibo", SharePlatform.Weibo), kotlin.f.a("copy_link", SharePlatform.Copylink));
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : g3.entrySet()) {
            if (!uri.getBooleanQueryParameter((String) entry.getKey(), false)) {
                arrayList.add(entry.getValue());
            }
        }
        return arrayList;
    }
}
