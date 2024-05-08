package com.google.thirdparty.publicsuffix;

import com.android.internal.accessibility.common.ShortcutConstants;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public enum PublicSuffixType {
    PRIVATE(ShortcutConstants.SERVICES_SEPARATOR, ','),
    REGISTRY('!', '?');

    private final char innerNodeCode;
    private final char leafNodeCode;

    PublicSuffixType(char c4, char c10) {
        this.innerNodeCode = c4;
        this.leafNodeCode = c10;
    }

    public static PublicSuffixType fromCode(char c4) {
        for (PublicSuffixType publicSuffixType : values()) {
            if (publicSuffixType.getInnerNodeCode() == c4 || publicSuffixType.getLeafNodeCode() == c4) {
                return publicSuffixType;
            }
        }
        StringBuilder sb2 = new StringBuilder(38);
        sb2.append("No enum corresponding to given code: ");
        sb2.append(c4);
        throw new IllegalArgumentException(sb2.toString());
    }

    public char getInnerNodeCode() {
        return this.innerNodeCode;
    }

    public char getLeafNodeCode() {
        return this.leafNodeCode;
    }
}
