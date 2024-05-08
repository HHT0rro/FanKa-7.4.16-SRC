package com.tencent.bugly.idasc.proguard;

import com.baidu.mobads.sdk.api.IAdInterListener;
import com.huawei.quickcard.base.Attributes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import sun.security.x509.PolicyMappingsExtension;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a {
    public static String a(ArrayList<String> arrayList) {
        StringBuilder sb2;
        StringBuffer stringBuffer = new StringBuffer();
        int i10 = 0;
        while (true) {
            int size = arrayList.size();
            String str = PolicyMappingsExtension.MAP;
            if (i10 >= size) {
                Collections.reverse(arrayList);
                for (int i11 = 0; i11 < arrayList.size(); i11++) {
                    String str2 = arrayList.get(i11);
                    if (str2.equals("list")) {
                        int i12 = i11 - 1;
                        arrayList.set(i12, "<" + arrayList.get(i12));
                        sb2 = new StringBuilder();
                    } else if (str2.equals(PolicyMappingsExtension.MAP)) {
                        int i13 = i11 - 1;
                        arrayList.set(i13, "<" + arrayList.get(i13) + ",");
                        sb2 = new StringBuilder();
                    } else if (str2.equals("Array")) {
                        int i14 = i11 - 1;
                        arrayList.set(i14, "<" + arrayList.get(i14));
                        sb2 = new StringBuilder();
                    }
                    sb2.append(arrayList.get(0));
                    sb2.append(">");
                    arrayList.set(0, sb2.toString());
                }
                Collections.reverse(arrayList);
                Iterator<String> iterator2 = arrayList.iterator2();
                while (iterator2.hasNext()) {
                    stringBuffer.append(iterator2.next());
                }
                return stringBuffer.toString();
            }
            String str3 = arrayList.get(i10);
            if (str3.equals("java.lang.Integer") || str3.equals(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL)) {
                str = "int32";
            } else if (str3.equals("java.lang.Boolean") || str3.equals("boolean")) {
                str = "bool";
            } else if (str3.equals("java.lang.Byte") || str3.equals("byte")) {
                str = "char";
            } else if (str3.equals("java.lang.Double") || str3.equals("double")) {
                str = "double";
            } else if (str3.equals("java.lang.Float") || str3.equals("float")) {
                str = "float";
            } else if (str3.equals("java.lang.Long") || str3.equals("long")) {
                str = "int64";
            } else if (str3.equals("java.lang.Short") || str3.equals("short")) {
                str = "short";
            } else {
                if (str3.equals("java.lang.Character")) {
                    throw new IllegalArgumentException("can not support java.lang.Character");
                }
                if (str3.equals("java.lang.String")) {
                    str = Attributes.TextOverflow.STRING;
                } else if (str3.equals("java.util.List")) {
                    str = "list";
                } else if (!str3.equals("java.util.Map")) {
                    str = str3;
                }
            }
            arrayList.set(i10, str);
            i10++;
        }
    }
}
