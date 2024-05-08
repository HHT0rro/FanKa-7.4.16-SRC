package com.google.common.base;

import java.io.Serializable;
import java.lang.Enum;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
final class Enums$StringConverter<T extends Enum<T>> extends Converter<String, T> implements Serializable {
    private static final long serialVersionUID = 0;
    private final Class<T> enumClass;

    public Enums$StringConverter(Class<T> cls) {
        this.enumClass = (Class) o.r(cls);
    }

    @Override // com.google.common.base.Converter, com.google.common.base.g
    public boolean equals(Object obj) {
        if (obj instanceof Enums$StringConverter) {
            return this.enumClass.equals(((Enums$StringConverter) obj).enumClass);
        }
        return false;
    }

    public int hashCode() {
        return this.enumClass.hashCode();
    }

    public String toString() {
        String name = this.enumClass.getName();
        StringBuilder sb2 = new StringBuilder(name.length() + 29);
        sb2.append("Enums.stringConverter(");
        sb2.append(name);
        sb2.append(".class)");
        return sb2.toString();
    }

    @Override // com.google.common.base.Converter
    public String doBackward(T t2) {
        return t2.name();
    }

    @Override // com.google.common.base.Converter
    public T doForward(String str) {
        return (T) Enum.valueOf(this.enumClass, str);
    }
}
