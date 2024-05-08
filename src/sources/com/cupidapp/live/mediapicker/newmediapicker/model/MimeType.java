package com.cupidapp.live.mediapicker.newmediapicker.model;

import com.huawei.openalliance.ad.constant.bb;
import com.huawei.quickcard.base.Attributes;
import java.util.Set;
import kotlin.collections.l0;
import kotlin.collections.m0;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MimeType.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum MimeType {
    JPEG(bb.V, m0.f("jpg", "jpeg")),
    JPG(bb.I, m0.f("jpg", "jpeg")),
    PNG(bb.Z, l0.c("png")),
    GIF(bb.B, l0.c("gif")),
    BMP("image/x-ms-bmp", l0.c("bmp")),
    WEBP("image/webp", l0.c("webp")),
    HEIF("image/heif", l0.c("heif")),
    HEIC("image/heic", l0.c("heic")),
    MPEG("video/mpeg", m0.f("mpeg", "mpg")),
    MP4(bb.Code, m0.f("mp4", "m4v")),
    QUICKTIME("video/quicktime", l0.c("mov")),
    THREEGPP("video/3gpp", m0.f("3gp", "3gpp")),
    THREEGPP2("video/3gpp2", m0.f("3g2", "3gpp2")),
    MKV("video/x-matroska", l0.c("mkv")),
    WEBM("video/webm", l0.c("webm")),
    TS("video/mp2ts", l0.c("ts")),
    AVI("video/avi", l0.c("avi"));


    @NotNull
    public static final a Companion = new a(null);

    @NotNull
    private final Set<String> mExtensions;

    @NotNull
    private final String mMimeTypeName;

    /* compiled from: MimeType.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a(@Nullable String str) {
            if (str != null) {
                return p.F(str, Attributes.Component.IMAGE, false, 2, null);
            }
            return false;
        }

        public final boolean b(@Nullable String str) {
            if (str != null) {
                return p.F(str, "video", false, 2, null);
            }
            return false;
        }
    }

    MimeType(String str, Set set) {
        this.mMimeTypeName = str;
        this.mExtensions = set;
    }

    @NotNull
    public final String getMMimeTypeName() {
        return this.mMimeTypeName;
    }

    @Override // java.lang.Enum
    @NotNull
    public String toString() {
        return this.mMimeTypeName;
    }
}
