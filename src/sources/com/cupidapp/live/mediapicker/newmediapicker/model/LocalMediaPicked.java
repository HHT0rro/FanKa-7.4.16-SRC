package com.cupidapp.live.mediapicker.newmediapicker.model;

import b2.a;
import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LocalMediaPicked.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class LocalMediaPicked implements Serializable {
    private final long bucketId;

    @NotNull
    private final LocalMedia media;
    private final int positionInFolder;

    public LocalMediaPicked(long j10, int i10, @NotNull LocalMedia media) {
        s.i(media, "media");
        this.bucketId = j10;
        this.positionInFolder = i10;
        this.media = media;
    }

    public static /* synthetic */ LocalMediaPicked copy$default(LocalMediaPicked localMediaPicked, long j10, int i10, LocalMedia localMedia, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            j10 = localMediaPicked.bucketId;
        }
        if ((i11 & 2) != 0) {
            i10 = localMediaPicked.positionInFolder;
        }
        if ((i11 & 4) != 0) {
            localMedia = localMediaPicked.media;
        }
        return localMediaPicked.copy(j10, i10, localMedia);
    }

    public final long component1() {
        return this.bucketId;
    }

    public final int component2() {
        return this.positionInFolder;
    }

    @NotNull
    public final LocalMedia component3() {
        return this.media;
    }

    @NotNull
    public final LocalMediaPicked copy(long j10, int i10, @NotNull LocalMedia media) {
        s.i(media, "media");
        return new LocalMediaPicked(j10, i10, media);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocalMediaPicked)) {
            return false;
        }
        LocalMediaPicked localMediaPicked = (LocalMediaPicked) obj;
        return this.bucketId == localMediaPicked.bucketId && this.positionInFolder == localMediaPicked.positionInFolder && s.d(this.media, localMediaPicked.media);
    }

    public final long getBucketId() {
        return this.bucketId;
    }

    @NotNull
    public final LocalMedia getMedia() {
        return this.media;
    }

    public final int getPositionInFolder() {
        return this.positionInFolder;
    }

    public int hashCode() {
        return (((a.a(this.bucketId) * 31) + this.positionInFolder) * 31) + this.media.hashCode();
    }

    @NotNull
    public String toString() {
        return "LocalMediaPicked(bucketId=" + this.bucketId + ", positionInFolder=" + this.positionInFolder + ", media=" + ((Object) this.media) + ")";
    }
}
