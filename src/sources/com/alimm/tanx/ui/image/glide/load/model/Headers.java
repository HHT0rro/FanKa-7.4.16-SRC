package com.alimm.tanx.ui.image.glide.load.model;

import com.alimm.tanx.ui.image.glide.load.model.LazyHeaders;
import java.util.Collections;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface Headers {

    @Deprecated
    public static final Headers NONE = new Headers() { // from class: com.alimm.tanx.ui.image.glide.load.model.Headers.1
        @Override // com.alimm.tanx.ui.image.glide.load.model.Headers
        public Map<String, String> getHeaders() {
            return Collections.emptyMap();
        }
    };
    public static final Headers DEFAULT = new LazyHeaders.Builder().build();

    Map<String, String> getHeaders();
}
