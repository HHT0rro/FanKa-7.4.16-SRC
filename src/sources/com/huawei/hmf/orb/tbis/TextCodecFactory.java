package com.huawei.hmf.orb.tbis;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class TextCodecFactory {
    private static Class<? extends TextCodec> defaultCodec;

    public static TextCodec create(String str) {
        Class<? extends TextCodec> cls = defaultCodec;
        if (cls != null) {
            try {
                return cls.getConstructor(String.class).newInstance(str);
            } catch (Exception e2) {
                throw new IllegalArgumentException("instantiate codec error:" + e2.getMessage());
            }
        }
        throw new IllegalStateException("The default codec is not registered");
    }

    public static void registryCodec(Class<? extends TextCodec> cls) {
        defaultCodec = cls;
    }

    public static TextCodec create() {
        Class<? extends TextCodec> cls = defaultCodec;
        if (cls != null) {
            try {
                return cls.newInstance();
            } catch (Exception e2) {
                throw new IllegalArgumentException("instantiate codec error: " + e2.getMessage());
            }
        }
        throw new IllegalStateException("The default codec is not registered");
    }
}
