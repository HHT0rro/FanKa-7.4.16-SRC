package com.alibaba.security.common.json.parser;

import com.alibaba.security.common.json.annotation.RPJSONType;
import com.alibaba.security.common.json.util.RPFieldInfo;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class JavaBeanInfo {
    public final Constructor<?> creatorConstructor;
    public final Constructor<?> defaultConstructor;
    public final int defaultConstructorParameterSize;
    public final Method factoryMethod;
    public final RPFieldInfo[] fields;
    public final RPJSONType jsonType;
    public boolean ordered = false;
    public final int parserFeatures;
    public final RPFieldInfo[] sortedFields;
    public final boolean supportBeanToArray;
    public final String typeKey;
    public final String typeName;

    public JavaBeanInfo(Class<?> cls, Constructor<?> constructor, Constructor<?> constructor2, Method method, RPFieldInfo[] rPFieldInfoArr, RPFieldInfo[] rPFieldInfoArr2, RPJSONType rPJSONType) {
        int i10;
        boolean z10;
        int i11 = 0;
        this.defaultConstructor = constructor;
        this.creatorConstructor = constructor2;
        this.factoryMethod = method;
        this.fields = rPFieldInfoArr;
        this.jsonType = rPJSONType;
        if (rPJSONType != null) {
            String typeName = rPJSONType.typeName();
            this.typeName = typeName.length() <= 0 ? cls.getName() : typeName;
            String typeKey = rPJSONType.typeKey();
            this.typeKey = typeKey.length() > 0 ? typeKey : null;
            i10 = 0;
            for (Feature feature : rPJSONType.parseFeatures()) {
                i10 |= feature.mask;
            }
        } else {
            this.typeName = cls.getName();
            this.typeKey = null;
            i10 = 0;
        }
        this.parserFeatures = i10;
        if (rPJSONType != null) {
            Feature[] parseFeatures = rPJSONType.parseFeatures();
            z10 = false;
            for (Feature feature2 : parseFeatures) {
                if (feature2 == Feature.SupportArrayToBean) {
                    z10 = true;
                }
            }
        } else {
            z10 = false;
        }
        this.supportBeanToArray = z10;
        RPFieldInfo[] computeSortedFields = computeSortedFields(rPFieldInfoArr, rPFieldInfoArr2);
        this.sortedFields = Arrays.equals(rPFieldInfoArr, computeSortedFields) ? rPFieldInfoArr : computeSortedFields;
        if (constructor != null) {
            i11 = constructor.getParameterTypes().length;
        } else if (method != null) {
            i11 = method.getParameterTypes().length;
        }
        this.defaultConstructorParameterSize = i11;
    }

    public static boolean addField(List<RPFieldInfo> list, RPFieldInfo rPFieldInfo, boolean z10) {
        if (!z10) {
            int size = list.size();
            for (int i10 = 0; i10 < size; i10++) {
                RPFieldInfo rPFieldInfo2 = list.get(i10);
                if (rPFieldInfo2.name.equals(rPFieldInfo.name) && (!rPFieldInfo2.getOnly || rPFieldInfo.getOnly)) {
                    return false;
                }
            }
        }
        list.add(rPFieldInfo);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0533  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x059e  */
    /* JADX WARN: Type inference failed for: r0v15, types: [java.lang.reflect.Type[]] */
    /* JADX WARN: Type inference failed for: r0v41, types: [java.lang.reflect.Type[]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.alibaba.security.common.json.parser.JavaBeanInfo build(java.lang.Class<?> r37, int r38, java.lang.reflect.Type r39, boolean r40, boolean r41, boolean r42, boolean r43, com.alibaba.security.common.json.RPPropertyNamingStrategy r44) {
        /*
            Method dump skipped, instructions count: 2023
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.security.common.json.parser.JavaBeanInfo.build(java.lang.Class, int, java.lang.reflect.Type, boolean, boolean, boolean, boolean, com.alibaba.security.common.json.RPPropertyNamingStrategy):com.alibaba.security.common.json.parser.JavaBeanInfo");
    }

    private RPFieldInfo[] computeSortedFields(RPFieldInfo[] rPFieldInfoArr, RPFieldInfo[] rPFieldInfoArr2) {
        String[] orders;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        RPJSONType rPJSONType = this.jsonType;
        if (rPJSONType != null && (orders = rPJSONType.orders()) != null && orders.length != 0) {
            int i10 = 0;
            while (true) {
                if (i10 >= orders.length) {
                    z10 = true;
                    break;
                }
                int i11 = 0;
                while (true) {
                    if (i11 >= rPFieldInfoArr2.length) {
                        z13 = false;
                        break;
                    }
                    if (rPFieldInfoArr2[i11].name.equals(orders[i10])) {
                        z13 = true;
                        break;
                    }
                    i11++;
                }
                if (!z13) {
                    z10 = false;
                    break;
                }
                i10++;
            }
            if (!z10) {
                return rPFieldInfoArr2;
            }
            if (orders.length == rPFieldInfoArr.length) {
                int i12 = 0;
                while (true) {
                    if (i12 >= orders.length) {
                        z12 = true;
                        break;
                    }
                    if (!rPFieldInfoArr2[i12].name.equals(orders[i12])) {
                        z12 = false;
                        break;
                    }
                    i12++;
                }
                if (z12) {
                    return rPFieldInfoArr2;
                }
                RPFieldInfo[] rPFieldInfoArr3 = new RPFieldInfo[rPFieldInfoArr2.length];
                for (int i13 = 0; i13 < orders.length; i13++) {
                    int i14 = 0;
                    while (true) {
                        if (i14 >= rPFieldInfoArr2.length) {
                            break;
                        }
                        if (rPFieldInfoArr2[i14].name.equals(orders[i13])) {
                            rPFieldInfoArr3[i13] = rPFieldInfoArr2[i14];
                            break;
                        }
                        i14++;
                    }
                }
                this.ordered = true;
                return rPFieldInfoArr3;
            }
            int length = rPFieldInfoArr2.length;
            RPFieldInfo[] rPFieldInfoArr4 = new RPFieldInfo[length];
            for (int i15 = 0; i15 < orders.length; i15++) {
                int i16 = 0;
                while (true) {
                    if (i16 >= rPFieldInfoArr2.length) {
                        break;
                    }
                    if (rPFieldInfoArr2[i16].name.equals(orders[i15])) {
                        rPFieldInfoArr4[i15] = rPFieldInfoArr2[i16];
                        break;
                    }
                    i16++;
                }
            }
            int length2 = orders.length;
            for (int i17 = 0; i17 < rPFieldInfoArr2.length; i17++) {
                for (int i18 = 0; i18 < length && i18 < length2; i18++) {
                    if (rPFieldInfoArr4[i17].equals(rPFieldInfoArr2[i18])) {
                        z11 = true;
                        break;
                    }
                }
                z11 = false;
                if (!z11) {
                    rPFieldInfoArr4[length2] = rPFieldInfoArr2[i17];
                    length2++;
                }
            }
            this.ordered = true;
        }
        return rPFieldInfoArr2;
    }
}
