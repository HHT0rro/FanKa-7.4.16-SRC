package com.alibaba.security.common.json.serializer;

import java.util.HashSet;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class SimplePropertyPreFilter implements PropertyPreFilter {
    private final Class<?> clazz;
    private final Set<String> excludes;
    private final Set<String> includes;
    private int maxLevel;

    public SimplePropertyPreFilter(String... strArr) {
        this(null, strArr);
    }

    @Override // com.alibaba.security.common.json.serializer.PropertyPreFilter
    public boolean apply(JSONSerializer jSONSerializer, Object obj, String str) {
        if (obj == null) {
            return true;
        }
        Class<?> cls = this.clazz;
        if (cls != null && !cls.isInstance(obj)) {
            return true;
        }
        if (this.excludes.contains(str)) {
            return false;
        }
        if (this.maxLevel > 0) {
            int i10 = 0;
            for (SerialContext serialContext = jSONSerializer.context; serialContext != null; serialContext = serialContext.parent) {
                i10++;
                if (i10 > this.maxLevel) {
                    return false;
                }
            }
        }
        return this.includes.size() == 0 || this.includes.contains(str);
    }

    public Class<?> getClazz() {
        return this.clazz;
    }

    public Set<String> getExcludes() {
        return this.excludes;
    }

    public Set<String> getIncludes() {
        return this.includes;
    }

    public int getMaxLevel() {
        return this.maxLevel;
    }

    public void setMaxLevel(int i10) {
        this.maxLevel = i10;
    }

    public SimplePropertyPreFilter(Class<?> cls, String... strArr) {
        this.includes = new HashSet();
        this.excludes = new HashSet();
        this.maxLevel = 0;
        this.clazz = cls;
        for (String str : strArr) {
            if (str != null) {
                this.includes.add(str);
            }
        }
    }
}
