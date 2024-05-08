package com.cupidapp.live.match.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FilterModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class KeyWordOptionModel {

    /* renamed from: id, reason: collision with root package name */
    @Nullable
    private final String f16837id;

    @NotNull
    private final String label;

    public KeyWordOptionModel(@Nullable String str, @NotNull String label) {
        s.i(label, "label");
        this.f16837id = str;
        this.label = label;
    }

    public static /* synthetic */ KeyWordOptionModel copy$default(KeyWordOptionModel keyWordOptionModel, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = keyWordOptionModel.f16837id;
        }
        if ((i10 & 2) != 0) {
            str2 = keyWordOptionModel.label;
        }
        return keyWordOptionModel.copy(str, str2);
    }

    @Nullable
    public final String component1() {
        return this.f16837id;
    }

    @NotNull
    public final String component2() {
        return this.label;
    }

    @NotNull
    public final KeyWordOptionModel copy(@Nullable String str, @NotNull String label) {
        s.i(label, "label");
        return new KeyWordOptionModel(str, label);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KeyWordOptionModel)) {
            return false;
        }
        KeyWordOptionModel keyWordOptionModel = (KeyWordOptionModel) obj;
        return s.d(this.f16837id, keyWordOptionModel.f16837id) && s.d(this.label, keyWordOptionModel.label);
    }

    @Nullable
    public final String getId() {
        return this.f16837id;
    }

    @NotNull
    public final String getLabel() {
        return this.label;
    }

    public int hashCode() {
        String str = this.f16837id;
        return ((str == null ? 0 : str.hashCode()) * 31) + this.label.hashCode();
    }

    @NotNull
    public String toString() {
        return "KeyWordOptionModel(id=" + this.f16837id + ", label=" + this.label + ")";
    }
}
