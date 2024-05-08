package com.cupidapp.live.match.model;

import com.cupidapp.live.base.network.model.ImageModel;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MatchModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MatchMarketingModel extends MatchRecommendModel {

    @Nullable
    private final String alohaText;

    @Nullable
    private final ImageModel backgroundImage;

    @Nullable
    private final ImageModel buttonImage;

    @Nullable
    private final String configKey;

    @Nullable
    private final String desc;

    @Nullable
    private final String jumpUrl;

    @Nullable
    private final String nopeText;

    @Nullable
    private final ImageModel overlayImage;

    @Nullable
    private final String title;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MatchMarketingModel(@NotNull String type, @Nullable Map<String, ? extends Object> map, @Nullable String str, @Nullable String str2, @Nullable ImageModel imageModel, @Nullable ImageModel imageModel2, @Nullable ImageModel imageModel3, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6) {
        super(type, map);
        s.i(type, "type");
        this.title = str;
        this.desc = str2;
        this.overlayImage = imageModel;
        this.backgroundImage = imageModel2;
        this.buttonImage = imageModel3;
        this.nopeText = str3;
        this.alohaText = str4;
        this.jumpUrl = str5;
        this.configKey = str6;
    }

    @Nullable
    public final String getAlohaText() {
        return this.alohaText;
    }

    @Nullable
    public final ImageModel getBackgroundImage() {
        return this.backgroundImage;
    }

    @Nullable
    public final ImageModel getButtonImage() {
        return this.buttonImage;
    }

    @Nullable
    public final String getConfigKey() {
        return this.configKey;
    }

    @Nullable
    public final String getDesc() {
        return this.desc;
    }

    @Nullable
    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    @Nullable
    public final String getNopeText() {
        return this.nopeText;
    }

    @Nullable
    public final ImageModel getOverlayImage() {
        return this.overlayImage;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }
}
