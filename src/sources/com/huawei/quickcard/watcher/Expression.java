package com.huawei.quickcard.watcher;

import com.huawei.quickcard.framework.QuickCardField;
import com.huawei.quickcard.framework.cache.CacheInterface;
import com.huawei.quickcard.framework.cache.Caches;
import com.huawei.quickcard.utils.StrUtils;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class Expression {

    /* renamed from: d, reason: collision with root package name */
    private static final String f34717d = "[^$_.a-zA-Z0-9]+";

    /* renamed from: a, reason: collision with root package name */
    private final String f34718a;

    /* renamed from: b, reason: collision with root package name */
    private final Set<String> f34719b = new HashSet();

    /* renamed from: c, reason: collision with root package name */
    private final Set<String> f34720c = new HashSet();

    private Expression(String str) {
        this.f34718a = str;
        a(str);
    }

    private void a(String str) {
        if (str == null) {
            return;
        }
        for (String str2 : str.split(f34717d)) {
            String[] split = str2.split("\\.");
            if (split.length > 1) {
                this.f34720c.add(split[0]);
            }
            if (str2.length() > 0 && !str2.equals("$")) {
                StringBuilder sb2 = new StringBuilder();
                for (int i10 = 0; i10 < split.length; i10++) {
                    if (i10 > 0) {
                        sb2.append('.');
                    }
                    sb2.append(split[i10]);
                    this.f34719b.add(sb2.toString().replace(QuickCardField.THIS_POINT, ""));
                }
            }
        }
    }

    public static Expression create(String str) {
        String strip = StrUtils.strip(str);
        CacheInterface<String, Expression> expressions = Caches.get().expressions();
        Expression expression = expressions.get(strip);
        if (expression != null) {
            return expression;
        }
        Expression expression2 = new Expression(strip);
        expressions.put(strip, expression2);
        return expression2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Expression expression = (Expression) obj;
        return Objects.equals(this.f34718a, expression.f34718a) && Objects.equals(this.f34719b, expression.f34719b) && Objects.equals(this.f34720c, expression.f34720c);
    }

    public Set<String> getFirstFieldsSet() {
        return this.f34720c;
    }

    public String getSrc() {
        return this.f34718a;
    }

    public Set<String> getVariablesSet() {
        return this.f34719b;
    }

    public int hashCode() {
        return Objects.hash(this.f34718a, this.f34719b, this.f34720c);
    }
}
