package com.huawei.hmf.orb.tbis;

import com.huawei.hmf.annotation.NamedMethod;
import java.lang.reflect.Method;
import java.util.Comparator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TBMethod.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class MethodBean {
    public int isNamed;
    public boolean isParamSignMethod = false;
    public final Method method;
    public final String name;
    public final int paramLength;

    public MethodBean(Method method) {
        this.method = method;
        this.paramLength = method.getParameterTypes().length;
        NamedMethod namedMethod = (NamedMethod) method.getAnnotation(NamedMethod.class);
        if (namedMethod != null && namedMethod.value() != null && !namedMethod.value().isEmpty()) {
            this.isNamed = -1;
            this.name = namedMethod.value();
        } else {
            this.isNamed = 0;
            this.name = method.getName();
        }
    }

    public static Comparator<MethodBean> getComparator() {
        return new Comparator<MethodBean>() { // from class: com.huawei.hmf.orb.tbis.MethodBean.1
            @Override // java.util.Comparator
            public int compare(MethodBean methodBean, MethodBean methodBean2) {
                int compareTo = methodBean.name.compareTo(methodBean2.name);
                return (compareTo == 0 && (compareTo = methodBean.isNamed - methodBean2.isNamed) == 0) ? methodBean.paramLength - methodBean2.paramLength : compareTo;
            }
        };
    }

    public String getFinalName() {
        StringBuilder sb2 = new StringBuilder();
        if (this.isNamed == -1) {
            sb2.append(this.name);
        } else {
            sb2.append(this.method.getName());
        }
        if (this.isParamSignMethod) {
            for (Class<?> cls : this.method.getParameterTypes()) {
                sb2.append(cls.getSimpleName());
            }
        }
        return sb2.toString();
    }
}
