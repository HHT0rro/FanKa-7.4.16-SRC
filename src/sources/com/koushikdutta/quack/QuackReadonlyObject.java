package com.koushikdutta.quack;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface QuackReadonlyObject extends QuackObject {
    boolean set(int i10, Object obj);

    @Override // com.koushikdutta.quack.QuackObject
    boolean set(Object obj, Object obj2);

    boolean set(String str, Object obj);
}
