package com.jd.ad.sdk.jad_ep;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class jad_fs {
    public final Map<Class<?>, Object> jad_an;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class jad_an {
        public final Map<Class<?>, Object> jad_an = new HashMap();
    }

    public jad_fs(jad_an jad_anVar) {
        this.jad_an = Collections.unmodifiableMap(new HashMap(jad_anVar.jad_an));
    }

    public boolean jad_an(Class<Object> cls) {
        return this.jad_an.containsKey(cls);
    }
}
