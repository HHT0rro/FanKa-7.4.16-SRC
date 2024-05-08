package com.huawei.quickcard.cardmanager.appgallery;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.huawei.quickcard.cardmanager.ICardRepository;
import com.huawei.quickcard.cardmanager.bean.CardBean;
import com.huawei.quickcard.cardmanager.bi.CardReporterUtil;
import com.huawei.quickcard.cardmanager.log.ManagerLogUtil;
import com.huawei.quickcard.cardmanager.storage.ICardStorageManager;
import com.huawei.quickcard.cardmanager.util.CardUriUtils;
import com.huawei.quickcard.cardmanager.util.FileUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class PresetCardManager {
    public static final PresetCardManager INST = new PresetCardManager();

    /* renamed from: e, reason: collision with root package name */
    private static final String f33477e = "PresetCardManager";

    /* renamed from: f, reason: collision with root package name */
    private static final String f33478f = "quickcard_preset";

    /* renamed from: g, reason: collision with root package name */
    private static final String f33479g = "key_sysnc_card_version_code";

    /* renamed from: h, reason: collision with root package name */
    private static final int f33480h = -1;

    /* renamed from: b, reason: collision with root package name */
    private SharedPreferences f33482b;

    /* renamed from: c, reason: collision with root package name */
    private PresetCardStreamProvider f33483c;

    /* renamed from: a, reason: collision with root package name */
    private final Object f33481a = new Object();

    /* renamed from: d, reason: collision with root package name */
    private int f33484d = -1;

    private void a(Context context) {
        Context applicationContext;
        if (this.f33482b == null && (applicationContext = context.getApplicationContext()) != null) {
            this.f33482b = applicationContext.getSharedPreferences(f33478f, 4);
            this.f33484d = CardReporterUtil.getHostVersionCode(applicationContext);
        }
    }

    private void b() {
        if (this.f33482b.edit().putInt(f33479g, this.f33484d).commit()) {
            return;
        }
        ManagerLogUtil.e(f33477e, "saveSyncPresetCardFlag fail");
    }

    public ICardRepository.Result readFromLocal(ICardStorageManager iCardStorageManager, CardBean cardBean) {
        syncPresetCard(iCardStorageManager);
        CardBean card = iCardStorageManager.getCard(cardBean);
        if (card != null && !TextUtils.isEmpty(card.getContent())) {
            return new ICardRepository.Result(0, "", card, null);
        }
        return new ICardRepository.Result(7, "not exist in preset cards", card, null);
    }

    public void setPresetCardStreamProvider(Context context, PresetCardStreamProvider presetCardStreamProvider) {
        a(context);
        this.f33483c = presetCardStreamProvider;
    }

    public void syncPresetCard(ICardStorageManager iCardStorageManager) {
        if (a()) {
            synchronized (this.f33481a) {
                if (a()) {
                    PresetCardStreamProvider presetCardStreamProvider = this.f33483c;
                    if (presetCardStreamProvider == null) {
                        return;
                    }
                    int size = presetCardStreamProvider.size();
                    boolean z10 = true;
                    for (int i10 = 0; i10 < size; i10++) {
                        z10 = a(iCardStorageManager, presetCardStreamProvider, i10) && z10;
                    }
                    if (z10) {
                        b();
                    }
                }
            }
        }
    }

    private boolean a() {
        SharedPreferences sharedPreferences = this.f33482b;
        return (sharedPreferences == null || this.f33483c == null || this.f33484d == a(sharedPreferences)) ? false : true;
    }

    private int a(SharedPreferences sharedPreferences) {
        try {
            return sharedPreferences.getInt(f33479g, -1);
        } catch (Exception unused) {
            return -1;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [com.huawei.quickcard.cardmanager.appgallery.PresetCardStreamProvider] */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v13 */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r10v9, types: [java.io.Closeable] */
    private boolean a(ICardStorageManager iCardStorageManager, PresetCardStreamProvider presetCardStreamProvider, int i10) {
        InputStream inputStream;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                inputStream = presetCardStreamProvider.open(i10);
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
                } catch (IOException unused) {
                } catch (JSONException unused2) {
                } catch (Exception unused3) {
                } catch (Throwable unused4) {
                }
            } catch (IOException unused5) {
                inputStream = null;
            } catch (JSONException unused6) {
                inputStream = null;
            } catch (Exception unused7) {
                inputStream = null;
            } catch (Throwable unused8) {
                inputStream = null;
            }
            try {
                StringBuffer stringBuffer = new StringBuffer();
                char[] cArr = new char[4096];
                while (true) {
                    int read = bufferedReader.read(cArr);
                    if (read == -1) {
                        break;
                    }
                    stringBuffer.append(cArr, 0, read);
                }
                JSONArray jSONArray = new JSONArray(stringBuffer.toString());
                int length = jSONArray.length();
                for (int i11 = 0; i11 < length; i11++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i11);
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString("content");
                        CardBean parse = CardUriUtils.parse(optJSONObject.optString("uri"));
                        parse.setContent(optString);
                        parse.setTs(System.currentTimeMillis());
                        iCardStorageManager.putCard(parse);
                    }
                }
                FileUtils.closeQuietly(bufferedReader);
                FileUtils.closeQuietly(inputStream);
                return true;
            } catch (IOException unused9) {
                bufferedReader2 = bufferedReader;
                ManagerLogUtil.e(f33477e, "syncPresetCard IOException");
                presetCardStreamProvider = inputStream;
                return false;
            } catch (JSONException unused10) {
                bufferedReader2 = bufferedReader;
                ManagerLogUtil.e(f33477e, "syncPresetCard JSONException");
                b();
                presetCardStreamProvider = inputStream;
                return false;
            } catch (Exception unused11) {
                bufferedReader2 = bufferedReader;
                ManagerLogUtil.e(f33477e, "syncPresetCard fail");
                presetCardStreamProvider = inputStream;
                return false;
            } catch (Throwable unused12) {
                bufferedReader2 = bufferedReader;
                ManagerLogUtil.e(f33477e, "syncPresetCard Throwable fail");
                presetCardStreamProvider = inputStream;
                return false;
            }
        } finally {
            FileUtils.closeQuietly(bufferedReader2);
            FileUtils.closeQuietly(presetCardStreamProvider);
        }
    }
}
