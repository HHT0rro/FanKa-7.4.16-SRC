package com.hifive.sdk.entity;

import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: InitBean.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class AddSongJson implements Serializable {

    @NotNull
    private final String mediaAction;

    @NotNull
    private final String musicNo;

    @Nullable
    private final String roomId;

    @NotNull
    private final String userId;

    public AddSongJson(@NotNull String userId, @Nullable String str, @NotNull String musicNo, @NotNull String mediaAction) {
        s.j(userId, "userId");
        s.j(musicNo, "musicNo");
        s.j(mediaAction, "mediaAction");
        this.userId = userId;
        this.roomId = str;
        this.musicNo = musicNo;
        this.mediaAction = mediaAction;
    }

    public static /* synthetic */ AddSongJson copy$default(AddSongJson addSongJson, String str, String str2, String str3, String str4, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = addSongJson.userId;
        }
        if ((i10 & 2) != 0) {
            str2 = addSongJson.roomId;
        }
        if ((i10 & 4) != 0) {
            str3 = addSongJson.musicNo;
        }
        if ((i10 & 8) != 0) {
            str4 = addSongJson.mediaAction;
        }
        return addSongJson.copy(str, str2, str3, str4);
    }

    @NotNull
    public final String component1() {
        return this.userId;
    }

    @Nullable
    public final String component2() {
        return this.roomId;
    }

    @NotNull
    public final String component3() {
        return this.musicNo;
    }

    @NotNull
    public final String component4() {
        return this.mediaAction;
    }

    @NotNull
    public final AddSongJson copy(@NotNull String userId, @Nullable String str, @NotNull String musicNo, @NotNull String mediaAction) {
        s.j(userId, "userId");
        s.j(musicNo, "musicNo");
        s.j(mediaAction, "mediaAction");
        return new AddSongJson(userId, str, musicNo, mediaAction);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AddSongJson)) {
            return false;
        }
        AddSongJson addSongJson = (AddSongJson) obj;
        return s.d(this.userId, addSongJson.userId) && s.d(this.roomId, addSongJson.roomId) && s.d(this.musicNo, addSongJson.musicNo) && s.d(this.mediaAction, addSongJson.mediaAction);
    }

    @NotNull
    public final String getMediaAction() {
        return this.mediaAction;
    }

    @NotNull
    public final String getMusicNo() {
        return this.musicNo;
    }

    @Nullable
    public final String getRoomId() {
        return this.roomId;
    }

    @NotNull
    public final String getUserId() {
        return this.userId;
    }

    public int hashCode() {
        String str = this.userId;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.roomId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.musicNo;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.mediaAction;
        return hashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "AddSongJson(userId=" + this.userId + ", roomId=" + this.roomId + ", musicNo=" + this.musicNo + ", mediaAction=" + this.mediaAction + ")";
    }
}
