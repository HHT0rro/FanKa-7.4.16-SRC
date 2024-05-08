package com.huawei.quickcard.base.invoke;

import androidx.annotation.NonNull;
import java.lang.reflect.Type;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface IInvoker {
    @NonNull
    Type[] getParameterTypes();

    Object invoke(@NonNull Object obj, Object... objArr) throws Exception;
}
