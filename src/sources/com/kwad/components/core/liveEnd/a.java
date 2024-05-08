package com.kwad.components.core.liveEnd;

import android.text.TextUtils;
import com.kwad.components.offline.api.core.adlive.IAdLiveEndRequest;
import com.kwad.sdk.core.network.b;
import com.kwad.sdk.utils.ar;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a extends b {

    /* renamed from: ga, reason: collision with root package name */
    private IAdLiveEndRequest f36629ga;

    public a(IAdLiveEndRequest iAdLiveEndRequest) {
        this.f36629ga = iAdLiveEndRequest;
    }

    @Override // com.kwad.sdk.core.network.b
    public final void buildBaseBody() {
    }

    @Override // com.kwad.sdk.core.network.b
    public final void buildBaseHeader() {
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final Map<String, String> getBodyMap() {
        return this.f36629ga.getBodyMap();
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final Map<String, String> getHeader() {
        IAdLiveEndRequest iAdLiveEndRequest = this.f36629ga;
        if (iAdLiveEndRequest != null && iAdLiveEndRequest.getHeader() != null && this.f36629ga.getHeader().size() > 0) {
            for (String str : this.f36629ga.getHeader().h()) {
                if (!TextUtils.isEmpty(this.f36629ga.getHeader().get(str))) {
                    addHeader(str, this.f36629ga.getHeader().get(str));
                }
            }
            return super.getHeader();
        }
        return super.getHeader();
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        return ar.appendUrl(this.f36629ga.getUrl(), this.f36629ga.getUrlParam());
    }
}
