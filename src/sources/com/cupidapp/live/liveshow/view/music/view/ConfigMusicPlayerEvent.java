package com.cupidapp.live.liveshow.view.music.view;

import com.hifive.sdk.entity.HifiveMusicDetailModel;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKMusicPlayerLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ConfigMusicPlayerEvent {
    private final boolean isPlaying;

    @NotNull
    private final HifiveMusicDetailModel music;

    public ConfigMusicPlayerEvent(boolean z10, @NotNull HifiveMusicDetailModel music) {
        s.i(music, "music");
        this.isPlaying = z10;
        this.music = music;
    }

    public static /* synthetic */ ConfigMusicPlayerEvent copy$default(ConfigMusicPlayerEvent configMusicPlayerEvent, boolean z10, HifiveMusicDetailModel hifiveMusicDetailModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = configMusicPlayerEvent.isPlaying;
        }
        if ((i10 & 2) != 0) {
            hifiveMusicDetailModel = configMusicPlayerEvent.music;
        }
        return configMusicPlayerEvent.copy(z10, hifiveMusicDetailModel);
    }

    public final boolean component1() {
        return this.isPlaying;
    }

    @NotNull
    public final HifiveMusicDetailModel component2() {
        return this.music;
    }

    @NotNull
    public final ConfigMusicPlayerEvent copy(boolean z10, @NotNull HifiveMusicDetailModel music) {
        s.i(music, "music");
        return new ConfigMusicPlayerEvent(z10, music);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConfigMusicPlayerEvent)) {
            return false;
        }
        ConfigMusicPlayerEvent configMusicPlayerEvent = (ConfigMusicPlayerEvent) obj;
        return this.isPlaying == configMusicPlayerEvent.isPlaying && s.d(this.music, configMusicPlayerEvent.music);
    }

    @NotNull
    public final HifiveMusicDetailModel getMusic() {
        return this.music;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z10 = this.isPlaying;
        ?? r02 = z10;
        if (z10) {
            r02 = 1;
        }
        return (r02 * 31) + this.music.hashCode();
    }

    public final boolean isPlaying() {
        return this.isPlaying;
    }

    @NotNull
    public String toString() {
        return "ConfigMusicPlayerEvent(isPlaying=" + this.isPlaying + ", music=" + ((Object) this.music) + ")";
    }
}
