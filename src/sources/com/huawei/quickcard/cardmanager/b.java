package com.huawei.quickcard.cardmanager;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.quickcard.cardmanager.ICardRepository;
import com.huawei.quickcard.cardmanager.appgallery.PresetCardManager;
import com.huawei.quickcard.cardmanager.bean.BatchParams;
import com.huawei.quickcard.cardmanager.bean.BatchResult;
import com.huawei.quickcard.cardmanager.bean.CardBean;
import com.huawei.quickcard.cardmanager.bi.CardReportBean;
import com.huawei.quickcard.cardmanager.bi.CardReporterUtil;
import com.huawei.quickcard.cardmanager.download.ICardDownLoadManager;
import com.huawei.quickcard.cardmanager.http.ManagerHttpResponse;
import com.huawei.quickcard.cardmanager.http.ServerConfigUtil;
import com.huawei.quickcard.cardmanager.log.ManagerLogUtil;
import com.huawei.quickcard.cardmanager.sha.ShaUtils;
import com.huawei.quickcard.cardmanager.storage.ICardStorageManager;
import com.huawei.quickcard.cardmanager.task.TaskThreadUtil;
import com.huawei.quickcard.cardmanager.util.CardUriUtils;
import com.huawei.quickcard.cardmanager.util.NumUtils;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.SSLProtocolException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class b implements ICardDownLoadManager {

    /* renamed from: f, reason: collision with root package name */
    private static final String f33485f = "CardDownloadManagerImpl";

    /* renamed from: g, reason: collision with root package name */
    private static final int[] f33486g = {3000, 6000, 9000};

    /* renamed from: h, reason: collision with root package name */
    private static final int f33487h = 3;

    /* renamed from: a, reason: collision with root package name */
    private final ICardStorageManager f33488a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f33489b;

    /* renamed from: c, reason: collision with root package name */
    private int f33490c;

    /* renamed from: d, reason: collision with root package name */
    private int f33491d;

    /* renamed from: e, reason: collision with root package name */
    private d f33492e;

    public b(Context context, ICardStorageManager iCardStorageManager) {
        this.f33489b = context;
        this.f33488a = iCardStorageManager;
    }

    private int a(int i10, int i11) {
        if (i10 >= 500) {
            return 21;
        }
        if (i10 >= 400) {
            return 20;
        }
        if (i10 >= 300) {
            return 19;
        }
        return i11;
    }

    private ICardRepository.Result a(@NonNull CardBean cardBean, @NonNull CardReportBean cardReportBean) {
        Pair<Integer, String> checkSDKVersion = checkSDKVersion(cardBean);
        if (((Integer) checkSDKVersion.first).intValue() != 0) {
            cardReportBean.setEndTime(System.currentTimeMillis());
            a(this.f33489b, 0, cardReportBean, ((Integer) checkSDKVersion.first).intValue(), (String) checkSDKVersion.second);
        }
        return new ICardRepository.Result(checkSDKVersion);
    }

    private boolean a(int i10) {
        if (i10 > 0) {
            return i10 >= 200 && i10 < 300;
        }
        return true;
    }

    private ICardRepository.Result b(@NonNull CardBean cardBean, @NonNull CardReportBean cardReportBean) {
        ICardRepository.Result a10 = a(cardBean, cardReportBean);
        if (a10.code != 0) {
            return a10;
        }
        CardBean b4 = b(cardBean);
        ICardRepository.Result readFromLocal = PresetCardManager.INST.readFromLocal(this.f33488a, b4);
        if (readFromLocal.code == 0) {
            return readFromLocal;
        }
        ICardRepository.Result a11 = a(b4, cardReportBean, 0);
        return a(a11) ? a(b4, cardReportBean, a11) : a11;
    }

    private Map<String, String> c(CardBean cardBean) {
        HashMap hashMap = new HashMap(ServerConfigUtil.getPostParamsForNewCard());
        hashMap.put("cardId", cardBean.getCardId());
        hashMap.put("ver", String.valueOf(cardBean.getVer()));
        if ("combo".equals(cardBean.getType())) {
            hashMap.put("minPlatformVer", String.valueOf(this.f33491d));
        } else {
            hashMap.put("minPlatformVer", String.valueOf(this.f33490c));
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(CardBean cardBean) {
        cardBean.setTs(System.currentTimeMillis());
        this.f33488a.putCard(cardBean);
        if ("combo".equals(cardBean.getType()) && !TextUtils.isEmpty(cardBean.getDependencies())) {
            a(cardBean.getDependencies());
        }
        a.b(CardUriUtils.getCardName(cardBean));
    }

    @Override // com.huawei.quickcard.cardmanager.download.ICardDownLoadManager
    public BatchResult batchDownloadCard(BatchParams batchParams) {
        CardReportBean cardReportBean = new CardReportBean();
        cardReportBean.setStartTime(System.currentTimeMillis());
        if (this.f33492e == null) {
            this.f33492e = new d(this.f33489b);
        }
        String a10 = d.a(this.f33489b);
        BatchResult batchResult = new BatchResult();
        try {
            ManagerHttpResponse a11 = this.f33492e.a(a10, batchParams);
            if (a11 != null && a(a11.getCode())) {
                a(batchResult, a11);
            } else if (a11 != null) {
                b(batchResult, a11);
            } else {
                batchResult.setCode(15);
                batchResult.setErrMsg("response is empty");
            }
            cardReportBean.setEndTime(System.currentTimeMillis());
            cardReportBean.setStoreUrl(a10);
            if (batchResult.getInfo().length > 0) {
                cardReportBean.setErrorMsg("success");
                cardReportBean.setErrorCode(0);
                for (BatchResult.CardInfo cardInfo : batchResult.getInfo()) {
                    cardReportBean.setQuickCardUri(cardInfo.getUri());
                    CardReporterUtil.reportDownload(this.f33489b, cardReportBean);
                }
            } else {
                cardReportBean.setErrorCode(batchResult.getCode());
                cardReportBean.setErrorMsg(batchResult.getErrMsg());
                CardReporterUtil.reportDownload(this.f33489b, cardReportBean);
            }
            return batchResult;
        } catch (IOException e2) {
            batchResult.setCode(4);
            batchResult.setErrMsg(e2.getMessage());
            return batchResult;
        }
    }

    @Override // com.huawei.quickcard.cardmanager.download.ICardDownLoadManager
    public Pair<Integer, String> checkSDKVersion(@NonNull CardBean cardBean) {
        String type = cardBean.getType();
        if ("quick".equals(type)) {
            if (cardBean.getMinPlatformVersion() > this.f33490c) {
                return Pair.create(2, "uri platform version not support.");
            }
        } else if ("combo".equals(type)) {
            if (cardBean.getMinPlatformVersion() > this.f33491d) {
                return Pair.create(2, "uri sdk version not support.");
            }
        } else {
            return Pair.create(1, "param error, type not support.");
        }
        return Pair.create(0, "");
    }

    @Override // com.huawei.quickcard.cardmanager.download.ICardDownLoadManager
    public Pair<Integer, String> downloadCard(@NonNull CardBean cardBean, @NonNull CardReportBean cardReportBean) {
        ICardRepository.Result b4 = b(cardBean, cardReportBean);
        return Pair.create(Integer.valueOf(b4.code), b4.message);
    }

    @Override // com.huawei.quickcard.cardmanager.download.ICardDownLoadManager
    @Nullable
    public CardBean getCacheCard(@NonNull CardBean cardBean) {
        return a.a(CardUriUtils.getCardName(cardBean));
    }

    @Override // com.huawei.quickcard.cardmanager.download.ICardDownLoadManager
    @NonNull
    public ICardRepository.Result getCard(@NonNull CardBean cardBean, @NonNull CardReportBean cardReportBean) {
        return b(cardBean, cardReportBean);
    }

    @Override // com.huawei.quickcard.cardmanager.download.ICardDownLoadManager
    public void setPlatformVersion(int i10) {
        this.f33490c = i10;
    }

    @Override // com.huawei.quickcard.cardmanager.download.ICardDownLoadManager
    public void setSDKVersion(int i10) {
        this.f33491d = i10;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final byte[] f33493a = new byte[0];

        /* renamed from: b, reason: collision with root package name */
        private static final Map<String, CardBean> f33494b = new HashMap(5);

        private a() {
        }

        public static CardBean a(@NonNull String str) {
            CardBean cardBean;
            synchronized (f33493a) {
                cardBean = f33494b.get(str);
            }
            return cardBean;
        }

        public static void b(@NonNull String str) {
            synchronized (f33493a) {
                f33494b.remove(str);
            }
        }

        public static void a(@NonNull String str, CardBean cardBean) {
            synchronized (f33493a) {
                f33494b.put(str, cardBean);
            }
        }
    }

    private boolean a(ICardRepository.Result result) {
        int i10 = result.code;
        if (i10 == 17 || i10 == 18) {
            return true;
        }
        if (i10 == 4) {
            return result.message.contains("unexpected end of stream") || result.message.contains("Read error") || result.message.contains("Connection reset") || result.message.contains("Software caused connection abort");
        }
        return false;
    }

    @NonNull
    private ICardRepository.Result a(CardBean cardBean, CardReportBean cardReportBean, ICardRepository.Result result) {
        int i10 = 0;
        while (a(result) && i10 < 3) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("download card result code:");
            sb2.append(result.code);
            sb2.append(" will ");
            int i11 = i10 + 1;
            sb2.append(i11);
            sb2.append(" retry after ");
            sb2.append(f33486g[i10]);
            ManagerLogUtil.d(f33485f, sb2.toString());
            SystemClock.sleep(r2[i10]);
            i10 = i11;
            result = a(cardBean, cardReportBean, i11);
        }
        return result;
    }

    private Pair<Integer, String> b(CardBean cardBean, CardReportBean cardReportBean, int i10) throws IOException, JSONException {
        cardReportBean.setStartTime(System.currentTimeMillis());
        String a10 = d.a(this.f33489b);
        cardReportBean.setStoreUrl(a10);
        if (TextUtils.isEmpty(a10)) {
            cardReportBean.setEndTime(System.currentTimeMillis());
            return a(this.f33489b, i10, cardReportBean, 6, "card server url not config.");
        }
        ManagerLogUtil.i(f33485f, "request card:" + cardBean.getCardId());
        if (this.f33492e == null) {
            this.f33492e = new d(this.f33489b);
        }
        ManagerHttpResponse a11 = this.f33492e.a(a10, c(cardBean));
        cardReportBean.setEndTime(System.currentTimeMillis());
        if (a11 != null && a(a11.getCode())) {
            Pair<Integer, String> a12 = a(i10, a11, cardBean, this.f33489b, cardReportBean);
            if (((Integer) a12.first).intValue() != 0) {
                return a12;
            }
            if ("quick".equals(cardBean.getType())) {
                if (cardBean.getMinPlatformVersion() > this.f33490c) {
                    return a(this.f33489b, i10, cardReportBean, 3, "server platform version not support.");
                }
            } else if (cardBean.getMinPlatformVersion() > this.f33491d) {
                return a(this.f33489b, i10, cardReportBean, 3, "server sdk version not support.");
            }
            if (!TextUtils.isEmpty(cardBean.getContent())) {
                String sha256Encrypt = ShaUtils.sha256Encrypt(cardBean.getContent());
                String sign = cardBean.getSign();
                if (!TextUtils.isEmpty(sign)) {
                    if (!sign.equalsIgnoreCase(sha256Encrypt)) {
                        return a(this.f33489b, i10, cardReportBean, 14, "card sign check failed.");
                    }
                } else {
                    cardBean.setSign(sha256Encrypt);
                }
                a.a(CardUriUtils.getCardName(cardBean), cardBean);
                a(cardBean);
                return a(this.f33489b, i10, cardReportBean, 0, "success");
            }
            return a(this.f33489b, i10, cardReportBean, 5, "server card content is null.");
        }
        cardReportBean.setEndTime(System.currentTimeMillis());
        if (a11 != null) {
            int code = a11.getCode();
            int a13 = a(code, 15);
            return a(this.f33489b, i10, cardReportBean, a13, "http code:" + code + " http error:" + a11.getMessage());
        }
        return a(this.f33489b, i10, cardReportBean, 4, "http failed.");
    }

    private ICardRepository.Result a(CardBean cardBean, CardReportBean cardReportBean, int i10) {
        try {
            Pair<Integer, String> b4 = b(cardBean, cardReportBean, i10);
            return new ICardRepository.Result(((Integer) b4.first).intValue(), (String) b4.second, cardBean, null);
        } catch (IOException e2) {
            cardReportBean.setEndTime(System.currentTimeMillis());
            if (e2 instanceof SSLProtocolException) {
                Pair<Integer, String> a10 = a(this.f33489b, i10, cardReportBean, 17, "request card io exception:" + ((Object) e2));
                return new ICardRepository.Result(((Integer) a10.first).intValue(), (String) a10.second, null, e2);
            }
            if (a(e2)) {
                Pair<Integer, String> a11 = a(this.f33489b, i10, cardReportBean, 18, "request card time out exception:" + ((Object) e2));
                return new ICardRepository.Result(((Integer) a11.first).intValue(), (String) a11.second, null, e2);
            }
            Pair<Integer, String> a12 = a(this.f33489b, i10, cardReportBean, 4, "request card io exception:" + ((Object) e2));
            return new ICardRepository.Result(((Integer) a12.first).intValue(), (String) a12.second, null, e2);
        } catch (IllegalArgumentException e10) {
            cardReportBean.setEndTime(System.currentTimeMillis());
            Pair<Integer, String> a13 = a(this.f33489b, i10, cardReportBean, 1, "request illegal argument exception:" + ((Object) e10));
            return new ICardRepository.Result(((Integer) a13.first).intValue(), (String) a13.second, null, e10);
        } catch (JSONException e11) {
            cardReportBean.setEndTime(System.currentTimeMillis());
            Pair<Integer, String> a14 = a(this.f33489b, i10, cardReportBean, 8, "parse response exception:" + ((Object) e11));
            return new ICardRepository.Result(((Integer) a14.first).intValue(), (String) a14.second, null, e11);
        } catch (Exception e12) {
            cardReportBean.setEndTime(System.currentTimeMillis());
            Pair<Integer, String> a15 = a(this.f33489b, i10, cardReportBean, 15, "request card exception:" + ((Object) e12));
            return new ICardRepository.Result(((Integer) a15.first).intValue(), (String) a15.second, null, e12);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0079  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.util.Pair<java.lang.Integer, java.lang.String> a(int r7, com.huawei.quickcard.cardmanager.http.ManagerHttpResponse r8, com.huawei.quickcard.cardmanager.bean.CardBean r9, android.content.Context r10, com.huawei.quickcard.cardmanager.bi.CardReportBean r11) throws org.json.JSONException {
        /*
            r6 = this;
            java.lang.String r0 = "CardDownloadManagerImpl"
            java.lang.String r8 = r8.getResponse()
            boolean r1 = android.text.TextUtils.isEmpty(r8)
            r2 = 5
            if (r1 == 0) goto L14
            java.lang.String r8 = "server: http response body is empty."
            android.util.Pair r7 = a(r10, r7, r11, r2, r8)
            return r7
        L14:
            org.json.JSONObject r1 = new org.json.JSONObject
            r1.<init>(r8)
            java.lang.String r8 = "result"
            org.json.JSONObject r8 = r1.getJSONObject(r8)
            java.lang.String r3 = "code"
            java.lang.String r3 = r8.getString(r3)
            java.lang.String r4 = "0x"
            boolean r4 = r3.startsWith(r4)     // Catch: java.lang.NumberFormatException -> L47
            if (r4 != 0) goto L3b
            java.lang.String r4 = "0X"
            boolean r4 = r3.startsWith(r4)     // Catch: java.lang.NumberFormatException -> L47
            if (r4 == 0) goto L36
            goto L3b
        L36:
            int r2 = java.lang.Integer.parseInt(r3)     // Catch: java.lang.NumberFormatException -> L47
            goto L5b
        L3b:
            r4 = 2
            java.lang.String r4 = r3.substring(r4)     // Catch: java.lang.NumberFormatException -> L47
            r5 = 16
            int r2 = java.lang.Integer.parseInt(r4, r5)     // Catch: java.lang.NumberFormatException -> L47
            goto L5b
        L47:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "parse code failed: "
            r4.append(r5)
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            com.huawei.quickcard.cardmanager.log.ManagerLogUtil.e(r0, r3)
        L5b:
            if (r2 == 0) goto L79
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r0 = "server: "
            r9.append(r0)
            java.lang.String r0 = "msg"
            java.lang.String r8 = r8.optString(r0)
            r9.append(r8)
            java.lang.String r8 = r9.toString()
            android.util.Pair r7 = a(r10, r7, r11, r2, r8)
            return r7
        L79:
            java.lang.String r7 = "cardContent"
            java.lang.String r7 = r1.getString(r7)
            r9.setContent(r7)
            java.lang.String r7 = "versionCode"
            java.lang.String r7 = r1.getString(r7)
            r8 = 0
            int r7 = com.huawei.quickcard.cardmanager.util.NumUtils.parseInt(r7, r8)
            r9.setVer(r7)
            java.lang.String r7 = "minPlatformVer"
            java.lang.String r7 = r1.getString(r7)
            int r7 = com.huawei.quickcard.cardmanager.util.NumUtils.parseInt(r7, r8)
            r9.setMinPlatformVersion(r7)
            java.lang.String r7 = r9.getType()
            java.lang.String r10 = "combo"
            boolean r7 = r10.equals(r7)
            if (r7 == 0) goto Lb8
            java.lang.String r7 = "dependencies"
            org.json.JSONArray r7 = r1.optJSONArray(r7)
            if (r7 == 0) goto Lb8
            java.lang.String r7 = r7.toString()
            r9.setDependencies(r7)
        Lb8:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r10 = "request card:"
            r7.append(r10)
            r7.append(r9)
            java.lang.String r7 = r7.toString()
            com.huawei.quickcard.cardmanager.log.ManagerLogUtil.i(r0, r7)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r8)
            java.lang.String r8 = "success"
            android.util.Pair r7 = android.util.Pair.create(r7, r8)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.quickcard.cardmanager.b.a(int, com.huawei.quickcard.cardmanager.http.ManagerHttpResponse, com.huawei.quickcard.cardmanager.bean.CardBean, android.content.Context, com.huawei.quickcard.cardmanager.bi.CardReportBean):android.util.Pair");
    }

    private CardBean b(CardBean cardBean) {
        CardBean cardBean2 = new CardBean();
        cardBean2.setCardId(cardBean.getCardId());
        cardBean2.setVer(cardBean.getVer());
        cardBean2.setSign(cardBean.getSign());
        cardBean2.setType(cardBean.getType());
        cardBean2.setMinPlatformVersion(cardBean.getMinPlatformVersion());
        return cardBean2;
    }

    private void b(BatchResult batchResult, @NonNull ManagerHttpResponse managerHttpResponse) {
        try {
            String response = managerHttpResponse.getResponse();
            if (a(response, batchResult)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(response);
            JSONObject optJSONObject = jSONObject.optJSONObject("result");
            if (optJSONObject == null) {
                batchResult.setCode(managerHttpResponse.getCode());
                batchResult.setErrMsg(managerHttpResponse.getMessage());
            } else {
                batchResult.setCode(NumUtils.parseInt(optJSONObject.optString("code"), 16, -1));
                batchResult.setErrMsg(optJSONObject.optString("msg"));
                batchResult.setNextIndex(jSONObject.optInt("nextIndex", 0));
            }
        } catch (JSONException unused) {
            batchResult.setCode(managerHttpResponse.getCode());
            batchResult.setErrMsg(managerHttpResponse.getMessage());
        } catch (Exception e2) {
            batchResult.setCode(24);
            batchResult.setErrMsg(e2.getMessage());
        }
    }

    private void a(final CardBean cardBean) {
        TaskThreadUtil.execute(new Runnable() { // from class: com.huawei.quickcard.cardmanager.e
            @Override // java.lang.Runnable
            public final void run() {
                b.this.d(cardBean);
            }
        });
    }

    private void a(String str) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i10);
                CardBean parse = CardUriUtils.parse(jSONObject.getString("uri"));
                CardBean b4 = b(parse);
                b4.setContent(jSONObject.getString("content"));
                String sha256Encrypt = ShaUtils.sha256Encrypt(b4.getContent());
                String sign = b4.getSign();
                if (!TextUtils.isEmpty(sign) && !sign.equalsIgnoreCase(sha256Encrypt)) {
                    ManagerLogUtil.e(f33485f, "sub-card sign check failed: " + parse.getCardId());
                    return;
                }
                b4.setSign(sha256Encrypt);
                b4.setTs(System.currentTimeMillis());
                this.f33488a.putCard(b4);
            }
        } catch (JSONException e2) {
            ManagerLogUtil.e(f33485f, "parse server response exception:" + e2.getMessage());
        }
    }

    private static Pair<Integer, String> a(Context context, int i10, CardReportBean cardReportBean, int i11, String str) {
        ManagerLogUtil.i(f33485f, "download card result code : " + i11 + " msg : " + str);
        cardReportBean.setErrorCode(i11);
        cardReportBean.setErrorMsg(str);
        cardReportBean.setRetryTimes(i10);
        CardReporterUtil.reportDownload(context, cardReportBean);
        return Pair.create(Integer.valueOf(i11), str);
    }

    private static boolean a(Exception exc) {
        return (exc instanceof SocketTimeoutException) || (exc.getCause() instanceof SocketTimeoutException);
    }

    private boolean a(String str, BatchResult batchResult) {
        if (!TextUtils.isEmpty(str)) {
            return false;
        }
        batchResult.setCode(4);
        batchResult.setErrMsg("response is empty");
        return true;
    }

    private void a(BatchResult batchResult, @NonNull ManagerHttpResponse managerHttpResponse) {
        try {
            String response = managerHttpResponse.getResponse();
            if (a(response, batchResult)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(response);
            JSONArray optJSONArray = jSONObject.optJSONArray("cards");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                BatchResult.CardInfo[] cardInfoArr = new BatchResult.CardInfo[optJSONArray.length()];
                for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i10);
                    BatchResult.CardInfo cardInfo = new BatchResult.CardInfo();
                    cardInfo.setUri(jSONObject2.getString("uri"));
                    cardInfo.setType(jSONObject2.getString("type"));
                    cardInfo.setContent(jSONObject2.getString("content"));
                    cardInfoArr[i10] = cardInfo;
                }
                batchResult.setInfo(cardInfoArr);
            }
            batchResult.setFailedUris(a(jSONObject.optJSONArray("failedUris")));
            batchResult.setNextIndex(jSONObject.optInt("nextIndex", 0));
            JSONObject optJSONObject = jSONObject.optJSONObject("result");
            if (optJSONObject != null) {
                batchResult.setCode(NumUtils.parseInt(optJSONObject.optString("code"), 16, -1));
                batchResult.setErrMsg(optJSONObject.optString("msg"));
            }
        } catch (JSONException e2) {
            batchResult.setCode(8);
            batchResult.setErrMsg(e2.getMessage());
        } catch (Exception e10) {
            batchResult.setCode(24);
            batchResult.setErrMsg(e10.getMessage());
        }
    }

    private String[] a(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return new String[0];
        }
        try {
            int length = jSONArray.length();
            String[] strArr = new String[length];
            for (int i10 = 0; i10 < length; i10++) {
                strArr[i10] = jSONArray.getString(i10);
            }
            return strArr;
        } catch (JSONException unused) {
            return new String[0];
        }
    }
}
