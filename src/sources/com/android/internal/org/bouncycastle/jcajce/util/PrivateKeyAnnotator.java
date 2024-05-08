package com.android.internal.org.bouncycastle.jcajce.util;

import java.security.PrivateKey;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class PrivateKeyAnnotator {
    public static AnnotatedPrivateKey annotate(PrivateKey privKey, String label) {
        return new AnnotatedPrivateKey(privKey, label);
    }

    public static AnnotatedPrivateKey annotate(PrivateKey privKey, Map<String, Object> annotations) {
        Map savedAnnotations = new HashMap(annotations);
        return new AnnotatedPrivateKey(privKey, (Map<String, Object>) Collections.unmodifiableMap(savedAnnotations));
    }
}
