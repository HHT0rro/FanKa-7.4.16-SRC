package com.hifive.sdk.entity;

import kotlin.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: InitBean.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class MusicCount {
    private final int knum;
    private final int pnum;
    private final int total;

    public MusicCount(int i10, int i11, int i12) {
        this.total = i10;
        this.pnum = i11;
        this.knum = i12;
    }

    public static /* synthetic */ MusicCount copy$default(MusicCount musicCount, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i10 = musicCount.total;
        }
        if ((i13 & 2) != 0) {
            i11 = musicCount.pnum;
        }
        if ((i13 & 4) != 0) {
            i12 = musicCount.knum;
        }
        return musicCount.copy(i10, i11, i12);
    }

    public final int component1() {
        return this.total;
    }

    public final int component2() {
        return this.pnum;
    }

    public final int component3() {
        return this.knum;
    }

    @NotNull
    public final MusicCount copy(int i10, int i11, int i12) {
        return new MusicCount(i10, i11, i12);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof MusicCount) {
                MusicCount musicCount = (MusicCount) obj;
                if (this.total == musicCount.total) {
                    if (this.pnum == musicCount.pnum) {
                        if (this.knum == musicCount.knum) {
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int getKnum() {
        return this.knum;
    }

    public final int getPnum() {
        return this.pnum;
    }

    public final int getTotal() {
        return this.total;
    }

    public int hashCode() {
        return (((this.total * 31) + this.pnum) * 31) + this.knum;
    }

    @NotNull
    public String toString() {
        return "MusicCount(total=" + this.total + ", pnum=" + this.pnum + ", knum=" + this.knum + ")";
    }
}
