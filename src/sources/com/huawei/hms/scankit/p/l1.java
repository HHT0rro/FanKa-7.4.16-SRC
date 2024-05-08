package com.huawei.hms.scankit.p;

import java.util.List;

/* compiled from: DecodeHintType.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public enum l1 {
    OTHER(Object.class),
    POSSIBLE_FORMATS(List.class),
    PHOTO_MODE(Void.TYPE),
    PHOTO_MODE_NUM(Integer.TYPE),
    NEED_JNI(Void.TYPE),
    TRY_HARDER(Void.class),
    CHARACTER_SET(String.class),
    RETURN_CODABAR_START_END(Void.class),
    NEED_RESULT_POINT_CALLBACK(v6.class),
    ALLOWED_EAN_EXTENSIONS(int[].class);


    /* renamed from: a, reason: collision with root package name */
    private final Class<?> f31231a;

    l1(Class cls) {
        this.f31231a = cls;
    }
}
