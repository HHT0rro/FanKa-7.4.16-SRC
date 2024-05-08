package com.danlan.android.cognition.collector.util;

import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class SafeJSONObject extends JSONObject {
    @Override // org.json.JSONObject
    @NotNull
    public JSONObject put(@NotNull String str, double d10) {
        try {
            return super.put(str, d10);
        } catch (Exception unused) {
            return this;
        }
    }

    @Override // org.json.JSONObject
    @NotNull
    public JSONObject put(@NotNull String str, int i10) {
        try {
            return super.put(str, i10);
        } catch (Exception unused) {
            return this;
        }
    }

    @Override // org.json.JSONObject
    @NotNull
    public JSONObject put(@NotNull String str, long j10) {
        try {
            return super.put(str, j10);
        } catch (Exception unused) {
            return this;
        }
    }

    @Override // org.json.JSONObject
    @NotNull
    public JSONObject put(@NotNull String str, Object obj) {
        if (obj == null) {
            try {
                obj = JSONObject.NULL;
            } catch (Exception unused) {
                return this;
            }
        }
        try {
            return super.put(str, obj);
        } catch (Exception unused2) {
            return this;
        }
    }

    @Override // org.json.JSONObject
    @NotNull
    public JSONObject put(@NotNull String str, boolean z10) {
        try {
            return super.put(str, z10);
        } catch (Exception unused) {
            return this;
        }
    }
}
