package com.cupidapp.live.liveshow.view.liveinfo;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveShowActivityLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveActivityWebModel {

    @NotNull
    private final String webUrl;

    public LiveActivityWebModel(@NotNull String webUrl) {
        s.i(webUrl, "webUrl");
        this.webUrl = webUrl;
    }

    public static /* synthetic */ LiveActivityWebModel copy$default(LiveActivityWebModel liveActivityWebModel, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = liveActivityWebModel.webUrl;
        }
        return liveActivityWebModel.copy(str);
    }

    @NotNull
    public final String component1() {
        return this.webUrl;
    }

    @NotNull
    public final LiveActivityWebModel copy(@NotNull String webUrl) {
        s.i(webUrl, "webUrl");
        return new LiveActivityWebModel(webUrl);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LiveActivityWebModel) && s.d(this.webUrl, ((LiveActivityWebModel) obj).webUrl);
    }

    @NotNull
    public final String getWebUrl() {
        return this.webUrl;
    }

    public int hashCode() {
        return this.webUrl.hashCode();
    }

    @NotNull
    public String toString() {
        return "LiveActivityWebModel(webUrl=" + this.webUrl + ")";
    }
}
