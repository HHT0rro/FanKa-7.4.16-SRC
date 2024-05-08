package com.cupidapp.live.liveshow.view.music;

import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveMusicFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class PlayMusicEvent {

    @NotNull
    private final String musicId;

    public PlayMusicEvent(@NotNull String musicId) {
        s.i(musicId, "musicId");
        this.musicId = musicId;
    }

    public static /* synthetic */ PlayMusicEvent copy$default(PlayMusicEvent playMusicEvent, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = playMusicEvent.musicId;
        }
        return playMusicEvent.copy(str);
    }

    @NotNull
    public final String component1() {
        return this.musicId;
    }

    @NotNull
    public final PlayMusicEvent copy(@NotNull String musicId) {
        s.i(musicId, "musicId");
        return new PlayMusicEvent(musicId);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PlayMusicEvent) && s.d(this.musicId, ((PlayMusicEvent) obj).musicId);
    }

    @NotNull
    public final String getMusicId() {
        return this.musicId;
    }

    public int hashCode() {
        return this.musicId.hashCode();
    }

    @NotNull
    public String toString() {
        return "PlayMusicEvent(musicId=" + this.musicId + ")";
    }
}
