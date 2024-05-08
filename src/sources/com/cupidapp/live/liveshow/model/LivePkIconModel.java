package com.cupidapp.live.liveshow.model;

import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveShowResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LivePkIconModel implements Serializable {
    private final boolean pairing;

    @NotNull
    private final String url;

    public LivePkIconModel(@NotNull String url, boolean z10) {
        s.i(url, "url");
        this.url = url;
        this.pairing = z10;
    }

    public static /* synthetic */ LivePkIconModel copy$default(LivePkIconModel livePkIconModel, String str, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = livePkIconModel.url;
        }
        if ((i10 & 2) != 0) {
            z10 = livePkIconModel.pairing;
        }
        return livePkIconModel.copy(str, z10);
    }

    @NotNull
    public final String component1() {
        return this.url;
    }

    public final boolean component2() {
        return this.pairing;
    }

    @NotNull
    public final LivePkIconModel copy(@NotNull String url, boolean z10) {
        s.i(url, "url");
        return new LivePkIconModel(url, z10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LivePkIconModel)) {
            return false;
        }
        LivePkIconModel livePkIconModel = (LivePkIconModel) obj;
        return s.d(this.url, livePkIconModel.url) && this.pairing == livePkIconModel.pairing;
    }

    public final boolean getPairing() {
        return this.pairing;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.url.hashCode() * 31;
        boolean z10 = this.pairing;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        return hashCode + i10;
    }

    @NotNull
    public String toString() {
        return "LivePkIconModel(url=" + this.url + ", pairing=" + this.pairing + ")";
    }
}
