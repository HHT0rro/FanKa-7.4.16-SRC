package com.bytedance.android.live.base.api;

import android.content.Context;
import android.webkit.WebResourceResponse;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface ILiveHostWebViewParam {
    Object createJsBridge2(Context context, Object obj);

    String getFileProvider();

    String getGeckoChannel(boolean z10);

    Map<String, String> getHeaderMap(String str);

    @Deprecated
    String getOfflineCacheDir();

    List<String> getSafeJsbHostList();

    List<String> getShareCookie(String str);

    WebResourceResponse interceptRequest(String str);

    boolean isSafeDomain(String str);

    void setCachePrefix(List<Pattern> list);
}
