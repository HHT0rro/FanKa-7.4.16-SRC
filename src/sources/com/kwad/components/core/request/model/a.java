package com.kwad.components.core.request.model;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.request.i;
import com.kwad.sdk.commercial.d.d;
import com.kwad.sdk.core.network.e;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a {

    @NonNull
    public final ImpInfo Mv;
    private String RA;

    @NonNull
    public final com.kwad.components.core.request.c Ru;

    @Nullable
    public i Rv;

    @Nullable
    public List<String> Rw;
    public boolean Rx;
    public boolean Ry;

    @Nullable
    public c Rz;

    /* renamed from: com.kwad.components.core.request.model.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class C0478a {
        public ImpInfo Mv;
        public i RB;
        public com.kwad.components.core.request.c Ru;
        public boolean Rx;
        public boolean Ry;

        public final C0478a a(@NonNull com.kwad.components.core.request.c cVar) {
            this.Ru = cVar;
            return this;
        }

        public final C0478a aI(boolean z10) {
            this.Rx = true;
            return this;
        }

        public final C0478a aJ(boolean z10) {
            this.Ry = z10;
            return this;
        }

        public final C0478a e(ImpInfo impInfo) {
            this.Mv = impInfo;
            return this;
        }

        public final a qy() {
            if (com.kwad.components.ad.e.a.f36424md.booleanValue() && (this.Mv == null || this.Ru == null)) {
                throw new IllegalStateException("AdRequestParams build Illegal");
            }
            return new a(this, (byte) 0);
        }

        public final C0478a a(i iVar) {
            this.RB = iVar;
            return this;
        }
    }

    public /* synthetic */ a(C0478a c0478a, byte b4) {
        this(c0478a);
    }

    public static void a(@NonNull a aVar, AdResultData adResultData, boolean z10) {
        d.a(aVar.Mv.adScene, aVar.qx(), adResultData.getAdSource());
        if (adResultData.isAdResultDataEmpty()) {
            aVar.Ru.a(e.avy.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? e.avy.msg : adResultData.testErrorMsg, z10);
        } else {
            aVar.Ru.a(adResultData, z10);
        }
    }

    public final void ax(String str) {
        this.RA = str;
    }

    public final int getAdNum() {
        SceneImpl sceneImpl = this.Mv.adScene;
        if (sceneImpl != null) {
            return sceneImpl.getAdNum();
        }
        return 1;
    }

    public final int getAdStyle() {
        SceneImpl sceneImpl = this.Mv.adScene;
        if (sceneImpl != null) {
            return sceneImpl.adStyle;
        }
        return 0;
    }

    public final long getPosId() {
        SceneImpl sceneImpl = this.Mv.adScene;
        if (sceneImpl != null) {
            return sceneImpl.getPosId();
        }
        return -1L;
    }

    @Nullable
    public final i qw() {
        return this.Rv;
    }

    public final String qx() {
        return !TextUtils.isEmpty(this.RA) ? this.RA : "network_only";
    }

    private a(C0478a c0478a) {
        this.Mv = c0478a.Mv;
        this.Ru = c0478a.Ru;
        this.Rx = c0478a.Rx;
        this.Ry = c0478a.Ry;
        this.Rv = c0478a.RB;
    }

    public static void a(@NonNull a aVar, int i10, String str, boolean z10) {
        aVar.Ru.a(i10, str, z10);
        d.a(aVar.getAdStyle(), i10, str, aVar.qx());
    }
}
