package com.kwad.sdk.core.webview;

import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.af;
import com.kwad.sdk.utils.bg;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class b {
    public WebView NY;
    public ViewGroup OE;
    public com.kwad.sdk.widget.e aDJ;

    @Nullable
    public af aDK;
    public boolean aDL = true;
    public boolean aDM = true;
    private List<AdTemplate> aDN = null;
    private AdResultData mAdResultData;

    @Nullable
    public JSONObject mReportExtData;
    public int mScreenOrientation;

    public final List<AdTemplate> GM() {
        List<AdTemplate> list = this.aDN;
        if (list != null && list.size() > 0) {
            return this.aDN;
        }
        return this.mAdResultData.getAdTemplateList();
    }

    public final boolean GN() {
        return GM() == null || GM().size() == 0;
    }

    public final AdTemplate cV(String str) {
        if (TextUtils.isEmpty(str)) {
            return getAdTemplate();
        }
        for (AdTemplate adTemplate : GM()) {
            if (bg.isEquals(str, String.valueOf(com.kwad.sdk.core.response.b.e.ea(adTemplate)))) {
                return adTemplate;
            }
        }
        return null;
    }

    public final void d(AdResultData adResultData) {
        this.mAdResultData = adResultData;
    }

    public final AdTemplate getAdTemplate() {
        List<AdTemplate> list = this.aDN;
        if (list != null && list.size() > 0) {
            return this.aDN.get(0);
        }
        return com.kwad.sdk.core.response.b.c.n(this.mAdResultData);
    }

    public final AdResultData hk() {
        AdResultData adResultData = this.mAdResultData;
        if (adResultData != null) {
            return adResultData;
        }
        if (this.aDN == null) {
            return null;
        }
        AdResultData adResultData2 = new AdResultData();
        adResultData2.setAdTemplateList(this.aDN);
        return adResultData2;
    }

    public final void setAdTemplate(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        this.aDN = arrayList;
        arrayList.add(adTemplate);
    }

    public final void setAdTemplateList(List<AdTemplate> list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<AdTemplate> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            arrayList.add(iterator2.next());
        }
        this.aDN = arrayList;
    }
}
