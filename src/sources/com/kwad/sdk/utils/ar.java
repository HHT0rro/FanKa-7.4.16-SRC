package com.kwad.sdk.utils;

import androidx.annotation.NonNull;
import com.huawei.appgallery.agd.common.constant.SymbolValues;
import java.util.Iterator;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class ar {
    public static String appendUrl(@NonNull String str, Map<String, String> map) {
        if (map == null || map.size() <= 0) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder();
        Iterator<String> iterator2 = map.h().iterator2();
        while (true) {
            if (!iterator2.hasNext()) {
                break;
            }
            String next = iterator2.next();
            if (map.get(next) != null) {
                sb2.append(next);
                sb2.append("=");
                sb2.append(map.get(next));
                sb2.append("&");
            }
        }
        String substring = sb2.toString().substring(0, r6.length() - 1);
        StringBuilder sb3 = new StringBuilder();
        sb3.append(str);
        sb3.append(str.contains(SymbolValues.QUESTION_EN_SYMBOL) ? "&" : SymbolValues.QUESTION_EN_SYMBOL);
        return sb3.toString() + substring;
    }
}
