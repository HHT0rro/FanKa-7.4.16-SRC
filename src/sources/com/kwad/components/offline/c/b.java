package com.kwad.components.offline.c;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.tk.IOfflineCompoTachikomaContext;
import com.kwad.components.offline.api.tk.ITkOfflineCompo;
import com.kwad.components.offline.api.tk.TKDownloadListener;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.components.offline.c.a.i;
import com.kwad.sdk.components.q;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class b implements com.kwad.components.core.n.a.d.c {
    private final ITkOfflineCompo acS;

    public b(@NonNull ITkOfflineCompo iTkOfflineCompo) {
        this.acS = iTkOfflineCompo;
    }

    @Override // com.kwad.components.core.n.a.d.c
    public final q a(Context context, String str, int i10, int i11, boolean z10) {
        IOfflineCompoTachikomaContext context2 = this.acS.getContext(context, str, i10, i11, z10);
        if (context2 == null) {
            return null;
        }
        return new i(context2);
    }

    @Override // com.kwad.components.core.n.a.d.c
    public final StyleTemplate checkStyleTemplateById(Context context, String str, String str2, String str3, int i10) {
        return this.acS.checkStyleTemplateById(context, str, str2, str3, i10);
    }

    @Override // com.kwad.sdk.components.a
    public final Class<b> getComponentsType() {
        return b.class;
    }

    @Override // com.kwad.components.core.n.a.d.c
    public final String getJsBaseDir(Context context, String str) {
        return this.acS.getJsBaseDir(context, str);
    }

    @Override // com.kwad.components.core.n.a.d.c
    public final ITkOfflineCompo.TKState getState() {
        return this.acS.getState();
    }

    @Override // com.kwad.sdk.components.a
    public final void init(Context context) {
    }

    @Override // com.kwad.components.core.n.a.d.c
    public final void loadTkFileByTemplateId(Context context, String str, String str2, String str3, int i10, TKDownloadListener tKDownloadListener) {
        this.acS.loadTkFileByTemplateId(context, str, str2, str3, i10, tKDownloadListener);
    }

    public final void onConfigRefresh(Context context, @NonNull JSONObject jSONObject) {
        this.acS.onConfigRefresh(context, jSONObject);
    }

    @Override // com.kwad.components.core.n.a.d.c
    public final void onDestroy() {
        this.acS.onDestroy();
    }

    @Override // com.kwad.sdk.components.a
    public final int priority() {
        return this.acS.priority();
    }
}
