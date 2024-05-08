package com.vivo.push.model;

/* compiled from: ConfigItem.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private String f46265a;

    /* renamed from: b, reason: collision with root package name */
    private String f46266b;

    public a(String str, String str2) {
        this.f46265a = str;
        this.f46266b = str2;
    }

    public final String a() {
        return this.f46265a;
    }

    public final String b() {
        return this.f46266b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        String str = this.f46265a;
        if (str == null) {
            if (aVar.f46265a != null) {
                return false;
            }
        } else if (!str.equals(aVar.f46265a)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        String str = this.f46265a;
        return (str == null ? 0 : str.hashCode()) + 31;
    }

    public final String toString() {
        return "ConfigItem{mKey='" + this.f46265a + "', mValue='" + this.f46266b + "'}";
    }
}
