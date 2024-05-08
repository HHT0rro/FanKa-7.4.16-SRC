package com.huawei.flexiblelayout.parser;

import androidx.annotation.NonNull;
import com.huawei.flexiblelayout.parser.cardmanager.CardInfo;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface CardProvider {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface Callback {
        void onLoaded(@NonNull String str, CardInfo cardInfo);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface ICloudCardProvider extends CardProvider {
        CardInfo loadCard(@NonNull String str, String str2);

        void loadCard(@NonNull String str, String str2, Callback callback);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface ILocalCardProvider extends CardProvider {
        CardInfo loadCard(@NonNull String str);
    }

    @NonNull
    String[] schemes();
}
