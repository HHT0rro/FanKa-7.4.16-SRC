package org.greenrobot.greendao.converter;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface PropertyConverter<P, D> {
    D convertToDatabaseValue(P p10);

    P convertToEntityProperty(D d10);
}
