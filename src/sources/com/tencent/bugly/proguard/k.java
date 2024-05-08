package com.tencent.bugly.proguard;

import java.io.Serializable;

/* compiled from: BUGLY */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class k implements Serializable {
    public abstract void a(i iVar);

    public abstract void a(j jVar);

    public abstract void a(StringBuilder sb2, int i10);

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        a(sb2, 0);
        return sb2.toString();
    }
}
