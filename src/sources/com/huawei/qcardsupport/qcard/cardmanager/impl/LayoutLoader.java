package com.huawei.qcardsupport.qcard.cardmanager.impl;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.huawei.flexiblelayout.log.Log;
import com.huawei.flexiblelayout.parser.ParseException;
import com.huawei.flexiblelayout.parser.cardmanager.CardInfo;
import com.huawei.flexiblelayout.version.Version;
import com.huawei.qcardsupport.qcard.cardmanager.InputStreamProvider;
import com.huawei.quickcard.cardmanager.CardRepository;
import com.huawei.quickcard.cardmanager.ICardRepository;
import com.huawei.quickcard.cardmanager.appgallery.AppGalleryCardRepository;
import com.huawei.quickcard.cardmanager.appgallery.IAppGalleryCardRepository;
import com.huawei.quickcard.cardmanager.bean.BatchParams;
import com.huawei.quickcard.cardmanager.bean.BatchResult;
import com.huawei.quickcard.cardmanager.bean.CardBean;
import com.huawei.quickcard.cardmanager.bean.CardMeta;
import java.util.List;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class LayoutLoader {

    /* renamed from: f, reason: collision with root package name */
    private static final String f33192f = "LayoutLoader";

    /* renamed from: a, reason: collision with root package name */
    private final Context f33193a;

    /* renamed from: b, reason: collision with root package name */
    private final IAppGalleryCardRepository f33194b;

    /* renamed from: c, reason: collision with root package name */
    private final ICardRepository f33195c;

    /* renamed from: d, reason: collision with root package name */
    private final a f33196d;

    /* renamed from: e, reason: collision with root package name */
    private g f33197e;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class Result {
        public int error;
        public CardInfo info;

        public Result(int i10, CardInfo cardInfo) {
            this.error = i10;
            this.info = cardInfo;
        }

        public static boolean isOk(int i10) {
            return i10 == 200;
        }

        public static boolean isRetry(int i10) {
            return c.a(i10);
        }
    }

    public LayoutLoader(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f33193a = applicationContext;
        this.f33194b = new AppGalleryCardRepository.Builder(applicationContext).build();
        CardRepository.Builder builder = new CardRepository.Builder(applicationContext);
        new Version();
        this.f33195c = builder.setSdkVersion(1).build();
        this.f33196d = new a(applicationContext);
    }

    @NonNull
    public Result a(String str, boolean z10) {
        CardBean cardBean;
        if (TextUtils.isEmpty(str)) {
            return new Result(111, null);
        }
        ICardRepository.Result card = this.f33195c.getCard(str, z10);
        if (card == null) {
            Log.println(z10 ? 5 : 6, f33192f, "Unreachable, Failed to call 'getCard()' for '" + str + "', return null.");
            com.huawei.qcardsupport.qcard.cardmanager.d.b().code(111).uri(str).build(this.f33193a).report();
            return new Result(111, null);
        }
        if (card.code == 0 && (cardBean = card.cardBean) != null) {
            if ("quick".equals(cardBean.getType()) && !this.f33196d.b(str)) {
                Log.e(f33192f, "Failed to call 'CardLoader.load(String)' for '" + str + "'.");
                com.huawei.qcardsupport.qcard.cardmanager.d.b().code(111).uri(str).build(this.f33193a).report();
                return new Result(111, null);
            }
            CardInfo a10 = a(str, cardBean);
            if (a10 == null) {
                com.huawei.qcardsupport.qcard.cardmanager.d.b().code(111).uri(str).build(this.f33193a).report();
                return new Result(111, null);
            }
            com.huawei.qcardsupport.qcard.cardmanager.d.b().code(200).uri(str).build(this.f33193a).report();
            return new Result(200, a10);
        }
        int a11 = c.a(card.exception);
        Log.println(z10 ? 5 : 6, f33192f, "Failed to call 'getCard()' for '" + str + "', error: " + card.code + ", resultCode: " + a11 + ".");
        com.huawei.qcardsupport.qcard.cardmanager.d.b().code(a11).uri(str).build(this.f33193a).report();
        return new Result(a11, null);
    }

    public static CardInfo a(String str, CardBean cardBean) {
        CardInfo.Builder fromUri = CardInfo.Builder.fromUri(str);
        CardInfo build = fromUri.build();
        if (Objects.equals(build.getName(), cardBean.getCardId()) && Objects.equals(build.getType(), cardBean.getType()) && Objects.equals(build.getUri(), str) && build.getVer() == cardBean.getVer() && build.getMinSdkVer() == cardBean.getMinPlatformVersion()) {
            if (TextUtils.isEmpty(cardBean.getContent())) {
                Log.e(f33192f, "The card content of 'uri' is empty.");
                return null;
            }
            return fromUri.setContent(cardBean.getContent()).setType(cardBean.getType()).build();
        }
        Log.e(f33192f, "The card information of 'uri' is different from that of 'bean'." + System.lineSeparator() + "uri : " + build.getName() + "," + build.getType() + "," + build.getUri() + "," + build.getVer() + "," + build.getMinSdkVer() + System.lineSeparator() + "bean: " + cardBean.getCardId() + "," + cardBean.getType() + "," + str + "," + cardBean.getVer() + "," + cardBean.getMinPlatformVersion());
        return null;
    }

    public void a(CardInfo cardInfo) throws ParseException {
        int storeCard = this.f33194b.storeCard(cardInfo.getUri(), cardInfo.getContent());
        com.huawei.qcardsupport.qcard.cardmanager.d.a().code(storeCard).uri(cardInfo.getUri()).build(this.f33193a).report();
        if (storeCard == 0) {
            return;
        }
        Log.e(f33192f, "Failed to call 'storeCard(String, String)' for '" + cardInfo.getUri() + "', error: " + storeCard);
        throw new ParseException("Failed to call 'storeCard(String, String)' for '" + cardInfo.getUri() + "', error: " + storeCard);
    }

    public void a(InputStreamProvider inputStreamProvider) {
        if (inputStreamProvider != null) {
            if (this.f33197e == null) {
                g gVar = new g();
                this.f33197e = gVar;
                this.f33194b.setPresetCardStreamProvider(this.f33193a, gVar);
            }
            this.f33197e.a(inputStreamProvider);
        }
    }

    public List<CardMeta> a() {
        return this.f33195c.getCardMetaInfo();
    }

    public BatchResult a(@NonNull List<String> list, int i10) {
        BatchParams batchParams = new BatchParams();
        batchParams.setUris((String[]) list.toArray(new String[0]));
        batchParams.setMaxSize(i10);
        return this.f33195c.batchDownloadCard(batchParams);
    }
}
