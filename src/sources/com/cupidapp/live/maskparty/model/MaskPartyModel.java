package com.cupidapp.live.maskparty.model;

import com.cupidapp.live.base.network.model.ImageModel;
import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MaskPartyMatchConfigResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MaskPartyModel implements Serializable {

    @NotNull
    private final String desc;

    @NotNull
    private final ImageModel icon;

    @NotNull
    private final String title;
    private final int type;

    public MaskPartyModel(int i10, @NotNull String title, @NotNull String desc, @NotNull ImageModel icon) {
        s.i(title, "title");
        s.i(desc, "desc");
        s.i(icon, "icon");
        this.type = i10;
        this.title = title;
        this.desc = desc;
        this.icon = icon;
    }

    public static /* synthetic */ MaskPartyModel copy$default(MaskPartyModel maskPartyModel, int i10, String str, String str2, ImageModel imageModel, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = maskPartyModel.type;
        }
        if ((i11 & 2) != 0) {
            str = maskPartyModel.title;
        }
        if ((i11 & 4) != 0) {
            str2 = maskPartyModel.desc;
        }
        if ((i11 & 8) != 0) {
            imageModel = maskPartyModel.icon;
        }
        return maskPartyModel.copy(i10, str, str2, imageModel);
    }

    public final int component1() {
        return this.type;
    }

    @NotNull
    public final String component2() {
        return this.title;
    }

    @NotNull
    public final String component3() {
        return this.desc;
    }

    @NotNull
    public final ImageModel component4() {
        return this.icon;
    }

    @NotNull
    public final MaskPartyModel copy(int i10, @NotNull String title, @NotNull String desc, @NotNull ImageModel icon) {
        s.i(title, "title");
        s.i(desc, "desc");
        s.i(icon, "icon");
        return new MaskPartyModel(i10, title, desc, icon);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MaskPartyModel)) {
            return false;
        }
        MaskPartyModel maskPartyModel = (MaskPartyModel) obj;
        return this.type == maskPartyModel.type && s.d(this.title, maskPartyModel.title) && s.d(this.desc, maskPartyModel.desc) && s.d(this.icon, maskPartyModel.icon);
    }

    @NotNull
    public final String getDesc() {
        return this.desc;
    }

    @NotNull
    public final ImageModel getIcon() {
        return this.icon;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        return (((((this.type * 31) + this.title.hashCode()) * 31) + this.desc.hashCode()) * 31) + this.icon.hashCode();
    }

    @NotNull
    public String toString() {
        return "MaskPartyModel(type=" + this.type + ", title=" + this.title + ", desc=" + this.desc + ", icon=" + ((Object) this.icon) + ")";
    }
}
