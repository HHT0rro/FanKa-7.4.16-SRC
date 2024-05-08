package com.bef.effectsdk;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class RequirementResourceMapper {
    private RequirementResourceMapper() {
    }

    private static native String[] nativePeekResourcesNeededByRequirements(String[] strArr);

    public static String[] peekResourcesNeededByRequirements(String[] strArr) {
        return nativePeekResourcesNeededByRequirements(strArr);
    }
}
