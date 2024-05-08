package com.huawei.quickcard.cardmanager.download;

import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.quickcard.cardmanager.ICardRepository;
import com.huawei.quickcard.cardmanager.bean.BatchParams;
import com.huawei.quickcard.cardmanager.bean.BatchResult;
import com.huawei.quickcard.cardmanager.bean.CardBean;
import com.huawei.quickcard.cardmanager.bi.CardReportBean;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface ICardDownLoadManager {
    BatchResult batchDownloadCard(BatchParams batchParams);

    Pair<Integer, String> checkSDKVersion(@NonNull CardBean cardBean);

    Pair<Integer, String> downloadCard(@NonNull CardBean cardBean, @NonNull CardReportBean cardReportBean);

    @Nullable
    CardBean getCacheCard(@NonNull CardBean cardBean);

    @NonNull
    ICardRepository.Result getCard(@NonNull CardBean cardBean, @NonNull CardReportBean cardReportBean);

    void setPlatformVersion(int i10);

    void setSDKVersion(int i10);
}
