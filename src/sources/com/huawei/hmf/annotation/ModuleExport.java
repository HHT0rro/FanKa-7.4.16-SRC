package com.huawei.hmf.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public @interface ModuleExport {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public enum Type {
        LOCAL(1),
        REMOTE(2),
        TBIS(4),
        DEX(8);

        private final int value;

        Type(int i10) {
            this.value = i10;
        }

        public int getValue() {
            return this.value;
        }

        public boolean in(Type[] typeArr) {
            for (Type type : typeArr) {
                if (type == this) {
                    return true;
                }
            }
            return false;
        }
    }

    Type[] value();
}
