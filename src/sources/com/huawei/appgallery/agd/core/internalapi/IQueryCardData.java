package com.huawei.appgallery.agd.core.internalapi;

import androidx.annotation.NonNull;
import com.huawei.appgallery.agd.core.impl.store.carddata.CardDataResponseBean;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface IQueryCardData {
    public static final int ERROR_UNSPECIFIED = 2;
    public static final int JSON_PARES_FAIL = 4;
    public static final int NO_ACTIVE_NETWORK = 5;
    public static final int QUERY_CARD_DATA_FAIL = 1;
    public static final int QUERY_SUCCESS = 0;
    public static final int SERVER_ERROR = 3;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface Callback {
        void onFail(int i10, String str);

        void onSuccess(@NonNull CardDataResponseBean cardDataResponseBean);
    }
}
