package com.hifive.sdk.entity;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: InitBean.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class Version {
    private final int duration;
    private final int free;
    private final int majorVersion;

    @NotNull
    private final String musicId;

    @NotNull
    private final String name;
    private final int price;

    public Version(int i10, int i11, int i12, @NotNull String musicId, @NotNull String name, int i13) {
        s.j(musicId, "musicId");
        s.j(name, "name");
        this.duration = i10;
        this.free = i11;
        this.majorVersion = i12;
        this.musicId = musicId;
        this.name = name;
        this.price = i13;
    }

    public static /* synthetic */ Version copy$default(Version version, int i10, int i11, int i12, String str, String str2, int i13, int i14, Object obj) {
        if ((i14 & 1) != 0) {
            i10 = version.duration;
        }
        if ((i14 & 2) != 0) {
            i11 = version.free;
        }
        int i15 = i11;
        if ((i14 & 4) != 0) {
            i12 = version.majorVersion;
        }
        int i16 = i12;
        if ((i14 & 8) != 0) {
            str = version.musicId;
        }
        String str3 = str;
        if ((i14 & 16) != 0) {
            str2 = version.name;
        }
        String str4 = str2;
        if ((i14 & 32) != 0) {
            i13 = version.price;
        }
        return version.copy(i10, i15, i16, str3, str4, i13);
    }

    public final int component1() {
        return this.duration;
    }

    public final int component2() {
        return this.free;
    }

    public final int component3() {
        return this.majorVersion;
    }

    @NotNull
    public final String component4() {
        return this.musicId;
    }

    @NotNull
    public final String component5() {
        return this.name;
    }

    public final int component6() {
        return this.price;
    }

    @NotNull
    public final Version copy(int i10, int i11, int i12, @NotNull String musicId, @NotNull String name, int i13) {
        s.j(musicId, "musicId");
        s.j(name, "name");
        return new Version(i10, i11, i12, musicId, name, i13);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof Version) {
                Version version = (Version) obj;
                if (this.duration == version.duration) {
                    if (this.free == version.free) {
                        if ((this.majorVersion == version.majorVersion) && s.d(this.musicId, version.musicId) && s.d(this.name, version.name)) {
                            if (this.price == version.price) {
                            }
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int getDuration() {
        return this.duration;
    }

    public final int getFree() {
        return this.free;
    }

    public final int getMajorVersion() {
        return this.majorVersion;
    }

    @NotNull
    public final String getMusicId() {
        return this.musicId;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public final int getPrice() {
        return this.price;
    }

    public int hashCode() {
        int i10 = ((((this.duration * 31) + this.free) * 31) + this.majorVersion) * 31;
        String str = this.musicId;
        int hashCode = (i10 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.name;
        return ((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.price;
    }

    @NotNull
    public String toString() {
        return "Version(duration=" + this.duration + ", free=" + this.free + ", majorVersion=" + this.majorVersion + ", musicId=" + this.musicId + ", name=" + this.name + ", price=" + this.price + ")";
    }
}
