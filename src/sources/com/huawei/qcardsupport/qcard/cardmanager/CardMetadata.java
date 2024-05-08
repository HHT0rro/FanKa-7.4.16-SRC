package com.huawei.qcardsupport.qcard.cardmanager;

import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class CardMetadata {
    public String name;
    public int platform;
    public String sign;
    public String type;
    public String uri;
    public int version;

    private static boolean a(String str, String str2) {
        return str != null && str.equalsIgnoreCase(str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || CardMetadata.class != obj.getClass()) {
            return false;
        }
        CardMetadata cardMetadata = (CardMetadata) obj;
        return this.version == cardMetadata.version && this.platform == cardMetadata.platform && Objects.equals(this.type, cardMetadata.type) && Objects.equals(this.name, cardMetadata.name) && a(this.sign, cardMetadata.sign);
    }

    public int hashCode() {
        return Objects.hash(this.type, this.name, this.sign, Integer.valueOf(this.version), Integer.valueOf(this.platform));
    }
}
