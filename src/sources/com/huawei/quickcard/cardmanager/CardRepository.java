package com.huawei.quickcard.cardmanager;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.huawei.quickcard.cardmanager.ICardRepository;
import com.huawei.quickcard.cardmanager.appgallery.PresetCardManager;
import com.huawei.quickcard.cardmanager.bean.BatchParams;
import com.huawei.quickcard.cardmanager.bean.BatchResult;
import com.huawei.quickcard.cardmanager.bean.CardBean;
import com.huawei.quickcard.cardmanager.bean.CardMeta;
import com.huawei.quickcard.cardmanager.bi.CardReportBean;
import com.huawei.quickcard.cardmanager.bi.CardReporterUtil;
import com.huawei.quickcard.cardmanager.config.VersionUtils;
import com.huawei.quickcard.cardmanager.download.ICardDownLoadManager;
import com.huawei.quickcard.cardmanager.http.CardServerUtil;
import com.huawei.quickcard.cardmanager.log.ManagerLogUtil;
import com.huawei.quickcard.cardmanager.storage.ICardStorageManager;
import com.huawei.quickcard.cardmanager.util.CardUriUtils;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class CardRepository implements ICardRepository {

    /* renamed from: d, reason: collision with root package name */
    private static final String f33464d = "BaseCardRepository";

    /* renamed from: e, reason: collision with root package name */
    private static final long f33465e = 86400000;

    /* renamed from: f, reason: collision with root package name */
    public static final int f33466f = 512;

    /* renamed from: g, reason: collision with root package name */
    public static final int f33467g = 1024;

    /* renamed from: a, reason: collision with root package name */
    public final ICardDownLoadManager f33468a;

    /* renamed from: b, reason: collision with root package name */
    public final ICardStorageManager f33469b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f33470c;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class Builder {
        public final Context mContext;
        public int mSdkVersion;

        public Builder(@NonNull Context context) {
            this.mContext = context.getApplicationContext();
        }

        public CardRepository build() {
            return new CardRepository(this);
        }

        public Builder setSdkVersion(int i10) {
            this.mSdkVersion = i10;
            return this;
        }
    }

    public CardRepository(Builder builder) {
        Context context = builder.mContext;
        this.f33470c = context;
        c cVar = new c(context);
        this.f33469b = cVar;
        b bVar = new b(context, cVar);
        this.f33468a = bVar;
        bVar.setSDKVersion(builder.mSdkVersion);
        bVar.setPlatformVersion(VersionUtils.getPlatformVersion());
    }

    private Pair<Integer, String> a(CardReportBean cardReportBean) {
        cardReportBean.setErrorCode(1);
        cardReportBean.setErrorMsg("uri param error");
        CardReporterUtil.reportDownload(this.f33470c, cardReportBean);
        return Pair.create(1, "uri param error");
    }

    @Override // com.huawei.quickcard.cardmanager.ICardRepository
    @NonNull
    public BatchResult batchDownloadCard(@NonNull BatchParams batchParams) {
        BatchResult batchResult = new BatchResult();
        if (!CardServerUtil.isNetworkAccess()) {
            batchResult.setCode(22);
            batchResult.setErrMsg("host app disabled network access");
            return batchResult;
        }
        String[] uris = batchParams.getUris();
        boolean z10 = true;
        if (uris.length > 0 && uris.length <= 100) {
            int maxSize = batchParams.getMaxSize();
            if (maxSize < 0) {
                batchParams.setMaxSize(512);
            }
            if (maxSize > 1024) {
                batchParams.setMaxSize(1024);
            }
            int length = uris.length;
            BatchResult.CardInfo[] cardInfoArr = new BatchResult.CardInfo[length];
            int i10 = 0;
            while (true) {
                if (i10 >= uris.length) {
                    z10 = false;
                    break;
                }
                ICardRepository.Result card = getCard(uris[i10], true);
                if (card.code != 0) {
                    break;
                }
                cardInfoArr[i10] = new BatchResult.CardInfo();
                cardInfoArr[i10].setContent(card.cardBean.getContent());
                cardInfoArr[i10].setType(card.cardBean.getType());
                cardInfoArr[i10].setUri(uris[i10]);
                i10++;
            }
            if (!z10) {
                batchResult.setCode(0);
                batchResult.setErrMsg("success");
                batchResult.setInfo(cardInfoArr);
                batchResult.setFailedUris(new String[0]);
                batchResult.setNextIndex(length);
                return batchResult;
            }
            return this.f33468a.batchDownloadCard(batchParams);
        }
        batchResult.setCode(1);
        batchResult.setErrMsg("batch uris length must be between 1 and 100 !");
        return batchResult;
    }

    @Override // com.huawei.quickcard.cardmanager.ICardRepository
    @NonNull
    public Pair<Integer, String> downloadCard(@NonNull String str) {
        if (!CardServerUtil.isNetworkAccess()) {
            return Pair.create(22, "host app disabled network access");
        }
        CardReportBean cardReportBean = new CardReportBean();
        cardReportBean.setStartTime(System.currentTimeMillis());
        cardReportBean.setQuickCardUri(str);
        CardBean parse = CardUriUtils.parse(str);
        if (!CardUriUtils.check(parse)) {
            ManagerLogUtil.e(f33464d, "downloadCard check uri failed");
            cardReportBean.setEndTime(System.currentTimeMillis());
            return a(cardReportBean);
        }
        if (this.f33468a.getCacheCard(parse) != null) {
            return Pair.create(0, "success");
        }
        CardBean card = this.f33469b.getCard(parse);
        if (card != null && !TextUtils.isEmpty(card.getContent()) && !a(card)) {
            return Pair.create(0, "success");
        }
        return this.f33468a.downloadCard(parse, cardReportBean);
    }

    @Override // com.huawei.quickcard.cardmanager.ICardRepository
    @NonNull
    public ICardRepository.Result getCard(@NonNull String str) {
        return getCard(str, false);
    }

    @Override // com.huawei.quickcard.cardmanager.ICardRepository
    @NonNull
    public List<CardMeta> getCardMetaInfo() {
        PresetCardManager.INST.syncPresetCard(this.f33469b);
        return this.f33469b.getCardMetaInfo();
    }

    @Override // com.huawei.quickcard.cardmanager.ICardRepository
    @NonNull
    public List<String> getCardSignList() {
        PresetCardManager.INST.syncPresetCard(this.f33469b);
        return this.f33469b.getCardSignList();
    }

    @Override // com.huawei.quickcard.cardmanager.ICardRepository
    public boolean hasCard(@NonNull String str) {
        if (!CardUriUtils.check(str)) {
            ManagerLogUtil.e(f33464d, "hasCard check uri failed");
            return false;
        }
        return this.f33469b.hasCard(str);
    }

    @Override // com.huawei.quickcard.cardmanager.ICardRepository
    public void removeAllCard() {
        this.f33469b.removeAllCard();
    }

    @Override // com.huawei.quickcard.cardmanager.ICardRepository
    public void removeCard(@NonNull String str) {
        if (!CardUriUtils.check(str)) {
            ManagerLogUtil.e(f33464d, "removeCard check uri failed");
        } else {
            this.f33469b.removeCard(str);
        }
    }

    @Override // com.huawei.quickcard.cardmanager.ICardRepository
    @NonNull
    public ICardRepository.Result getCard(@NonNull String str, boolean z10) {
        CardBean parse = CardUriUtils.parse(str);
        if (!CardUriUtils.check(parse)) {
            ManagerLogUtil.e(f33464d, "getCard check uri failed");
            return new ICardRepository.Result(1, "uri param error");
        }
        CardBean cacheCard = this.f33468a.getCacheCard(parse);
        if (cacheCard != null) {
            return new ICardRepository.Result(0, "", cacheCard, null);
        }
        CardBean card = this.f33469b.getCard(parse);
        if (card != null && !TextUtils.isEmpty(card.getContent())) {
            return new ICardRepository.Result(0, "", card, null);
        }
        if (!z10) {
            CardReportBean cardReportBean = new CardReportBean();
            cardReportBean.setQuickCardUri(str);
            return this.f33468a.getCard(parse, cardReportBean);
        }
        Pair<Integer, String> checkSDKVersion = this.f33468a.checkSDKVersion(parse);
        if (((Integer) checkSDKVersion.first).intValue() != 0) {
            return new ICardRepository.Result(checkSDKVersion);
        }
        ICardRepository.Result readFromLocal = PresetCardManager.INST.readFromLocal(this.f33469b, parse);
        return readFromLocal.code == 0 ? readFromLocal : new ICardRepository.Result(7, "card not exist");
    }

    private boolean a(CardBean cardBean) {
        return System.currentTimeMillis() - cardBean.getTs() >= 86400000;
    }
}
