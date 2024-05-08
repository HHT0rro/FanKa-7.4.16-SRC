package com.alimm.tanx.core.view.player.cache.videocache.headers;

import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class EmptyHeadersInjector implements HeaderInjector {
    @Override // com.alimm.tanx.core.view.player.cache.videocache.headers.HeaderInjector
    public Map<String, String> addHeaders(String str) {
        return new HashMap();
    }
}
