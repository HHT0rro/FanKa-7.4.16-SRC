package com.huawei.appgallery.agd.common.utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class JoinUtils {
    @NonNull
    public static String join(List<String> list, @Nullable String str) {
        return join(list, str, (String) null, (String) null);
    }

    @NonNull
    public static String join(List<String> list, @Nullable String str, @Nullable String str2, @Nullable String str3) {
        return (list == null || list.isEmpty()) ? "" : join((String[]) list.toArray(new String[0]), str, str2, str3);
    }

    @NonNull
    public static String join(@Nullable String[] strArr, @Nullable String str) {
        return join(strArr, str, (String) null, (String) null);
    }

    @NonNull
    public static String join(@Nullable String[] strArr, @Nullable String str, @Nullable String str2, @Nullable String str3) {
        if (strArr == null || strArr.length == 0) {
            return "";
        }
        String nonNull = NonNullUtils.toNonNull(str);
        String nonNull2 = NonNullUtils.toNonNull(str2);
        String nonNull3 = NonNullUtils.toNonNull(str3);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(nonNull2);
        sb2.append(strArr[0]);
        sb2.append(nonNull3);
        for (int i10 = 1; i10 < strArr.length; i10++) {
            sb2.append(nonNull);
            sb2.append(nonNull2);
            sb2.append(strArr[i10]);
            sb2.append(nonNull3);
        }
        return sb2.toString();
    }
}
