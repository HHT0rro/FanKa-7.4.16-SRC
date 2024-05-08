package com.hifive.sdk.entity;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: InitBean.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class Artist {

    @NotNull
    private final String code;

    @NotNull
    private final String icon;

    /* renamed from: id, reason: collision with root package name */
    private final int f27202id;

    @NotNull
    private final String name;

    public Artist(@NotNull String code, @NotNull String icon, int i10, @NotNull String name) {
        s.j(code, "code");
        s.j(icon, "icon");
        s.j(name, "name");
        this.code = code;
        this.icon = icon;
        this.f27202id = i10;
        this.name = name;
    }

    public static /* synthetic */ Artist copy$default(Artist artist, String str, String str2, int i10, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = artist.code;
        }
        if ((i11 & 2) != 0) {
            str2 = artist.icon;
        }
        if ((i11 & 4) != 0) {
            i10 = artist.f27202id;
        }
        if ((i11 & 8) != 0) {
            str3 = artist.name;
        }
        return artist.copy(str, str2, i10, str3);
    }

    @NotNull
    public final String component1() {
        return this.code;
    }

    @NotNull
    public final String component2() {
        return this.icon;
    }

    public final int component3() {
        return this.f27202id;
    }

    @NotNull
    public final String component4() {
        return this.name;
    }

    @NotNull
    public final Artist copy(@NotNull String code, @NotNull String icon, int i10, @NotNull String name) {
        s.j(code, "code");
        s.j(icon, "icon");
        s.j(name, "name");
        return new Artist(code, icon, i10, name);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof Artist) {
                Artist artist = (Artist) obj;
                if (s.d(this.code, artist.code) && s.d(this.icon, artist.icon)) {
                    if (!(this.f27202id == artist.f27202id) || !s.d(this.name, artist.name)) {
                    }
                }
            }
            return false;
        }
        return true;
    }

    @NotNull
    public final String getCode() {
        return this.code;
    }

    @NotNull
    public final String getIcon() {
        return this.icon;
    }

    public final int getId() {
        return this.f27202id;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        String str = this.code;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.icon;
        int hashCode2 = (((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.f27202id) * 31;
        String str3 = this.name;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "Artist(code=" + this.code + ", icon=" + this.icon + ", id=" + this.f27202id + ", name=" + this.name + ")";
    }
}
