package com.huawei.qcardsupport.qcard.cardmanager;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.huawei.flexiblelayout.FLEngine;
import com.huawei.flexiblelayout.log.Log;
import com.huawei.flexiblelayout.parser.CardProvider;
import com.huawei.flexiblelayout.parser.ParseException;
import com.huawei.flexiblelayout.parser.cardmanager.CardInfo;
import com.huawei.flexiblelayout.parser.cardmanager.LocalCardProvider;
import com.huawei.flexiblelayout.services.configuration.ServerUrlProvider;
import com.huawei.qcardsupport.qcard.cardmanager.impl.LayoutLoader;
import com.huawei.qcardsupport.qcard.cardmanager.impl.e;
import com.huawei.quickcard.base.grs.CardServerConfig;
import com.huawei.quickcard.base.grs.ICardServerUrl;
import com.huawei.quickcard.cardmanager.bean.CardMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class CloudCardProvider implements CardProvider.ICloudCardProvider {

    /* renamed from: c, reason: collision with root package name */
    private static final String f33170c = "CloudCardProvider";

    /* renamed from: d, reason: collision with root package name */
    private static volatile CloudCardProvider f33171d = null;

    /* renamed from: e, reason: collision with root package name */
    private static final int f33172e = 0;

    /* renamed from: f, reason: collision with root package name */
    private static final int f33173f = 1;

    /* renamed from: g, reason: collision with root package name */
    private static final int f33174g = 2;

    /* renamed from: a, reason: collision with root package name */
    private final FLEngine f33175a;

    /* renamed from: b, reason: collision with root package name */
    private final LayoutLoader f33176b;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class a implements ICardServerUrl {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ServerUrlProvider f33177a;

        public a(ServerUrlProvider serverUrlProvider) {
            this.f33177a = serverUrlProvider;
        }

        @Override // com.huawei.quickcard.base.grs.ICardServerUrl
        public String getUrl() {
            ServerUrlProvider serverUrlProvider = this.f33177a;
            return serverUrlProvider == null ? "" : serverUrlProvider.getUrl();
        }
    }

    public CloudCardProvider(@NonNull FLEngine fLEngine) {
        e.a(fLEngine);
        this.f33175a = fLEngine;
        this.f33176b = new LayoutLoader(fLEngine.getContext());
    }

    private void a(@NonNull JSONObject jSONObject) throws ParseException {
        String optString = jSONObject.optString("uri");
        String optString2 = jSONObject.optString("type");
        String optString3 = jSONObject.optString("content");
        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString3)) {
            CardInfo build = CardInfo.Builder.fromUri(optString).setContent(optString3).setType(optString2).build();
            this.f33176b.a(build);
            if (build.isCombo()) {
                LocalCardProvider.getInstance(this.f33175a).add(build.getQualifiedName(), build.getContent());
                return;
            }
            return;
        }
        Log.e(f33170c, "uri or content must not be empty.");
        d.c().code(2).build(this.f33175a.getContext()).report();
        throw new ParseException("uri or content must not be empty.");
    }

    public static CloudCardProvider getInstance(FLEngine fLEngine) {
        if (f33171d == null) {
            synchronized (CloudCardProvider.class) {
                if (f33171d == null) {
                    f33171d = new CloudCardProvider(fLEngine);
                }
            }
        }
        return f33171d;
    }

    public CloudCardProvider addFromArray(@NonNull JSONArray jSONArray) throws ParseException {
        int length = jSONArray.length();
        for (int i10 = 0; i10 < length; i10++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i10);
            if (optJSONObject != null) {
                a(optJSONObject);
            }
        }
        d.c().code(0).put("size", Integer.valueOf(length)).build(this.f33175a.getContext()).report();
        return this;
    }

    public CloudCardProvider addFromString(@NonNull String str) throws ParseException {
        try {
            addFromArray(new JSONArray(str));
            return this;
        } catch (JSONException e2) {
            Log.e(f33170c, "Failed to new JSONArray from the 'layouts'.");
            d.c().code(1).build(this.f33175a.getContext()).report();
            throw new ParseException("Failed to new JSONArray from the 'layouts'.", e2);
        }
    }

    public CloudCardProvider addStreamProvider(InputStreamProvider inputStreamProvider) {
        this.f33176b.a(inputStreamProvider);
        return this;
    }

    @NonNull
    public List<CardMetadata> getMetadataList() {
        ArrayList arrayList = new ArrayList();
        List<CardMeta> a10 = this.f33176b.a();
        if (a10 != null) {
            for (CardMeta cardMeta : a10) {
                CardMetadata cardMetadata = new CardMetadata();
                cardMetadata.type = cardMeta.getType();
                cardMetadata.name = cardMeta.getCardId();
                cardMetadata.platform = cardMeta.getMinPlatformVersion();
                cardMetadata.version = cardMeta.getVer();
                cardMetadata.sign = cardMeta.getSign();
                cardMetadata.uri = cardMeta.getUri();
                if (!arrayList.contains(cardMetadata)) {
                    arrayList.add(cardMetadata);
                }
            }
        }
        return arrayList;
    }

    @Override // com.huawei.flexiblelayout.parser.CardProvider.ICloudCardProvider
    public CardInfo loadCard(@NonNull String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        CardInfo cardInfo = this.f33176b.a(str2, false).info;
        return (cardInfo == null || !cardInfo.isCombo() || Objects.equals(str, cardInfo.getName())) ? cardInfo : new CardInfo.Builder(cardInfo).setName(str).build();
    }

    @Override // com.huawei.flexiblelayout.parser.CardProvider
    @NonNull
    public String[] schemes() {
        return new String[]{"flayout", "fastView"};
    }

    public CloudCardProvider setServerUrlProvider(ServerUrlProvider serverUrlProvider) {
        CardServerConfig.setUrl(new a(serverUrlProvider));
        CardServerConfig.setMode(0);
        return this;
    }

    @Override // com.huawei.flexiblelayout.parser.CardProvider.ICloudCardProvider
    public void loadCard(@NonNull String str, String str2, CardProvider.Callback callback) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        QCardManager.getInstance(this.f33175a.getContext()).asyncLoadCard(str2, null);
    }
}
