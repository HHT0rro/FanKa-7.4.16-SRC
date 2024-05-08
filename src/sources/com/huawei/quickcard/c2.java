package com.huawei.quickcard;

import androidx.annotation.NonNull;
import com.huawei.quickcard.framework.IVirtualView;
import com.huawei.quickcard.views.text.span.Span;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class c2 {
    public static IVirtualView a(@NonNull String str) {
        str.hashCode();
        if (str.equals("a")) {
            return new a();
        }
        if (str.equals("span")) {
            return new Span();
        }
        return null;
    }
}
