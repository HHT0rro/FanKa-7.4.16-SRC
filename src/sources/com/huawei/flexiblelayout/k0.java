package com.huawei.flexiblelayout;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: MethodDefine.java */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public @interface k0 {

    /* compiled from: MethodDefine.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface a {

        /* renamed from: a, reason: collision with root package name */
        public static final int f28180a = 0;

        /* renamed from: b, reason: collision with root package name */
        public static final int f28181b = 1;

        /* renamed from: c, reason: collision with root package name */
        public static final int f28182c = 0;
    }

    String alias();

    int phase() default 0;
}
