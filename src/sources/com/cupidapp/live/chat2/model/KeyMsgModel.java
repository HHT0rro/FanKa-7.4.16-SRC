package com.cupidapp.live.chat2.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SurveyChatMessageModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class KeyMsgModel {

    @NotNull
    private final String key;

    @NotNull
    private final String optionId;

    @Nullable
    private final String url;

    public KeyMsgModel(@NotNull String key, @NotNull String optionId, @Nullable String str) {
        s.i(key, "key");
        s.i(optionId, "optionId");
        this.key = key;
        this.optionId = optionId;
        this.url = str;
    }

    public static /* synthetic */ KeyMsgModel copy$default(KeyMsgModel keyMsgModel, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = keyMsgModel.key;
        }
        if ((i10 & 2) != 0) {
            str2 = keyMsgModel.optionId;
        }
        if ((i10 & 4) != 0) {
            str3 = keyMsgModel.url;
        }
        return keyMsgModel.copy(str, str2, str3);
    }

    @NotNull
    public final String component1() {
        return this.key;
    }

    @NotNull
    public final String component2() {
        return this.optionId;
    }

    @Nullable
    public final String component3() {
        return this.url;
    }

    @NotNull
    public final KeyMsgModel copy(@NotNull String key, @NotNull String optionId, @Nullable String str) {
        s.i(key, "key");
        s.i(optionId, "optionId");
        return new KeyMsgModel(key, optionId, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KeyMsgModel)) {
            return false;
        }
        KeyMsgModel keyMsgModel = (KeyMsgModel) obj;
        return s.d(this.key, keyMsgModel.key) && s.d(this.optionId, keyMsgModel.optionId) && s.d(this.url, keyMsgModel.url);
    }

    @NotNull
    public final String getKey() {
        return this.key;
    }

    @NotNull
    public final String getOptionId() {
        return this.optionId;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        int hashCode = ((this.key.hashCode() * 31) + this.optionId.hashCode()) * 31;
        String str = this.url;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    @NotNull
    public String toString() {
        return "KeyMsgModel(key=" + this.key + ", optionId=" + this.optionId + ", url=" + this.url + ")";
    }
}
