package com.hifive.sdk.entity;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: InitBean.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class Album {

    @NotNull
    private final String code;

    /* renamed from: id, reason: collision with root package name */
    private final int f27201id;

    @NotNull
    private final String name;

    public Album(@NotNull String code, int i10, @NotNull String name) {
        s.j(code, "code");
        s.j(name, "name");
        this.code = code;
        this.f27201id = i10;
        this.name = name;
    }

    public static /* synthetic */ Album copy$default(Album album, String str, int i10, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = album.code;
        }
        if ((i11 & 2) != 0) {
            i10 = album.f27201id;
        }
        if ((i11 & 4) != 0) {
            str2 = album.name;
        }
        return album.copy(str, i10, str2);
    }

    @NotNull
    public final String component1() {
        return this.code;
    }

    public final int component2() {
        return this.f27201id;
    }

    @NotNull
    public final String component3() {
        return this.name;
    }

    @NotNull
    public final Album copy(@NotNull String code, int i10, @NotNull String name) {
        s.j(code, "code");
        s.j(name, "name");
        return new Album(code, i10, name);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof Album) {
                Album album = (Album) obj;
                if (s.d(this.code, album.code)) {
                    if (!(this.f27201id == album.f27201id) || !s.d(this.name, album.name)) {
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

    public final int getId() {
        return this.f27201id;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        String str = this.code;
        int hashCode = (((str != null ? str.hashCode() : 0) * 31) + this.f27201id) * 31;
        String str2 = this.name;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "Album(code=" + this.code + ", id=" + this.f27201id + ", name=" + this.name + ")";
    }
}
