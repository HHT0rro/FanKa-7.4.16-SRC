package com.cupidapp.live.liveshow.view.music.adapter;

import kotlin.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKMusicListRecyclerViewAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class MusicListPromptViewModel {
    private final int image;
    private final int text;

    public MusicListPromptViewModel(int i10, int i11) {
        this.image = i10;
        this.text = i11;
    }

    public static /* synthetic */ MusicListPromptViewModel copy$default(MusicListPromptViewModel musicListPromptViewModel, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = musicListPromptViewModel.image;
        }
        if ((i12 & 2) != 0) {
            i11 = musicListPromptViewModel.text;
        }
        return musicListPromptViewModel.copy(i10, i11);
    }

    public final int component1() {
        return this.image;
    }

    public final int component2() {
        return this.text;
    }

    @NotNull
    public final MusicListPromptViewModel copy(int i10, int i11) {
        return new MusicListPromptViewModel(i10, i11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MusicListPromptViewModel)) {
            return false;
        }
        MusicListPromptViewModel musicListPromptViewModel = (MusicListPromptViewModel) obj;
        return this.image == musicListPromptViewModel.image && this.text == musicListPromptViewModel.text;
    }

    public final int getImage() {
        return this.image;
    }

    public final int getText() {
        return this.text;
    }

    public int hashCode() {
        return (this.image * 31) + this.text;
    }

    @NotNull
    public String toString() {
        return "MusicListPromptViewModel(image=" + this.image + ", text=" + this.text + ")";
    }
}
