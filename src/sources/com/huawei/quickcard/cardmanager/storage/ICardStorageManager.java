package com.huawei.quickcard.cardmanager.storage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.quickcard.cardmanager.bean.CardBean;
import com.huawei.quickcard.cardmanager.bean.CardMeta;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface ICardStorageManager {
    @Nullable
    CardBean getCard(@NonNull CardBean cardBean);

    @NonNull
    List<CardMeta> getCardMetaInfo();

    @NonNull
    List<String> getCardSignList();

    boolean hasCard(@NonNull String str);

    void putCard(@NonNull CardBean cardBean);

    void removeAllCard();

    void removeCard(@NonNull String str);
}
