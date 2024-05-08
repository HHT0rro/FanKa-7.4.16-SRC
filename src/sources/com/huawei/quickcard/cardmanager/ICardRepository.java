package com.huawei.quickcard.cardmanager;

import android.util.Pair;
import androidx.annotation.NonNull;
import com.huawei.quickcard.cardmanager.bean.BatchParams;
import com.huawei.quickcard.cardmanager.bean.BatchResult;
import com.huawei.quickcard.cardmanager.bean.CardBean;
import com.huawei.quickcard.cardmanager.bean.CardMeta;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface ICardRepository {
    @NonNull
    BatchResult batchDownloadCard(@NonNull BatchParams batchParams);

    @NonNull
    Pair<Integer, String> downloadCard(@NonNull String str);

    @NonNull
    Result getCard(@NonNull String str);

    @NonNull
    Result getCard(@NonNull String str, boolean z10);

    @NonNull
    List<CardMeta> getCardMetaInfo();

    @NonNull
    List<String> getCardSignList();

    boolean hasCard(@NonNull String str);

    void removeAllCard();

    void removeCard(@NonNull String str);

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class Result {
        public CardBean cardBean;
        public int code;
        public Exception exception;
        public String message;

        public Result(int i10, String str) {
            this.code = i10;
            this.message = str;
        }

        public Result(@NonNull Pair<Integer, String> pair) {
            this.code = ((Integer) pair.first).intValue();
            this.message = (String) pair.second;
        }

        public Result(int i10, String str, CardBean cardBean, Exception exc) {
            this.code = i10;
            this.message = str;
            this.cardBean = cardBean;
            this.exception = exc;
        }
    }
}
