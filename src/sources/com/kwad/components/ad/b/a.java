package com.kwad.components.ad.b;

import android.app.Activity;
import com.kwad.sdk.api.KsExitInstallListener;
import com.kwad.sdk.api.KsScene;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface a extends com.kwad.sdk.components.a {
    String getBidRequestToken(KsScene ksScene);

    String getBidRequestTokenV2(KsScene ksScene);

    boolean showInstallDialog(Activity activity, KsExitInstallListener ksExitInstallListener);
}
