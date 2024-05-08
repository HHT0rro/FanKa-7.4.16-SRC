package com.cupidapp.live.liveshow.view.music.model;

import com.hifive.sdk.entity.HifiveMusicModel;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKMusicDataResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class MusicListViewModel {
    private boolean isPlaying;

    @NotNull
    private final HifiveMusicModel musicModel;

    public MusicListViewModel(@NotNull HifiveMusicModel musicModel, boolean z10) {
        s.i(musicModel, "musicModel");
        this.musicModel = musicModel;
        this.isPlaying = z10;
    }

    public static /* synthetic */ MusicListViewModel copy$default(MusicListViewModel musicListViewModel, HifiveMusicModel hifiveMusicModel, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            hifiveMusicModel = musicListViewModel.musicModel;
        }
        if ((i10 & 2) != 0) {
            z10 = musicListViewModel.isPlaying;
        }
        return musicListViewModel.copy(hifiveMusicModel, z10);
    }

    @NotNull
    public final HifiveMusicModel component1() {
        return this.musicModel;
    }

    public final boolean component2() {
        return this.isPlaying;
    }

    @NotNull
    public final MusicListViewModel copy(@NotNull HifiveMusicModel musicModel, boolean z10) {
        s.i(musicModel, "musicModel");
        return new MusicListViewModel(musicModel, z10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MusicListViewModel)) {
            return false;
        }
        MusicListViewModel musicListViewModel = (MusicListViewModel) obj;
        return s.d(this.musicModel, musicListViewModel.musicModel) && this.isPlaying == musicListViewModel.isPlaying;
    }

    @NotNull
    public final HifiveMusicModel getMusicModel() {
        return this.musicModel;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.musicModel.hashCode() * 31;
        boolean z10 = this.isPlaying;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        return hashCode + i10;
    }

    public final boolean isPlaying() {
        return this.isPlaying;
    }

    public final void setPlaying(boolean z10) {
        this.isPlaying = z10;
    }

    @NotNull
    public String toString() {
        HifiveMusicModel hifiveMusicModel = this.musicModel;
        return "MusicListViewModel(musicModel=" + ((Object) hifiveMusicModel) + ", isPlaying=" + this.isPlaying + ")";
    }

    public /* synthetic */ MusicListViewModel(HifiveMusicModel hifiveMusicModel, boolean z10, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(hifiveMusicModel, (i10 & 2) != 0 ? false : z10);
    }
}
