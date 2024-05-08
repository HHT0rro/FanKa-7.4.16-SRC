package com.huawei.hmf.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public @interface ModuleDefine {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public enum Scope {
        PROJECT(1),
        PACKAGE(4);

        private final int value;

        Scope(int i10) {
            this.value = i10;
        }

        public int getValue() {
            return this.value;
        }
    }

    Scope scope() default Scope.PACKAGE;

    String value();
}
