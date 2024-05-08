package com.cupidapp.live.liveshow.model;

import com.cupidapp.live.base.network.model.ImageModel;
import java.io.Serializable;
import kotlin.d;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveShowResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class LiveMenuBtnModel implements Serializable {

    @Nullable
    private final String hoverText;

    @Nullable
    private final ImageModel iconImage;
    private boolean unread;

    @Nullable
    private final String url;

    public LiveMenuBtnModel(@Nullable String str, @Nullable String str2, boolean z10, @Nullable ImageModel imageModel) {
        this.url = str;
        this.hoverText = str2;
        this.unread = z10;
        this.iconImage = imageModel;
    }

    @Nullable
    public final String getHoverText() {
        return this.hoverText;
    }

    @Nullable
    public final ImageModel getIconImage() {
        return this.iconImage;
    }

    public final boolean getUnread() {
        return this.unread;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    public final void setUnread(boolean z10) {
        this.unread = z10;
    }
}
