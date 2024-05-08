package com.huawei.jslite;

import com.koushikdutta.quack.JavaMethodObject;
import com.koushikdutta.quack.QuackContext;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface SyntheticProperty {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class FieldProperty implements SyntheticProperty {
        public Field mField;

        public FieldProperty(Field field) {
            this.mField = field;
        }

        @Override // com.huawei.jslite.SyntheticProperty
        public Object get(QuackContext quackContext, Object obj) {
            try {
                return quackContext.coerceJavaToJavaScript(this.mField.get(obj));
            } catch (IllegalAccessException e2) {
                throw new IllegalArgumentException(e2);
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class GetterProperty implements SyntheticProperty {
        public Method mMethod;

        public GetterProperty(Method method) {
            this.mMethod = method;
        }

        @Override // com.huawei.jslite.SyntheticProperty
        public Object get(QuackContext quackContext, Object obj) {
            try {
                return quackContext.coerceJavaToJavaScript(this.mMethod.invoke(obj, new Object[0]));
            } catch (Exception e2) {
                throw new IllegalArgumentException(e2);
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class MethodProperty implements SyntheticProperty {
        public String mMethodName;
        public Method[] mMethods;

        public MethodProperty(String str, Method[] methodArr) {
            this.mMethodName = str;
            this.mMethods = methodArr;
        }

        @Override // com.huawei.jslite.SyntheticProperty
        public Object get(QuackContext quackContext, Object obj) {
            return new JavaMethodObject(quackContext, obj, this.mMethodName, this.mMethods);
        }
    }

    Object get(QuackContext quackContext, Object obj);
}
