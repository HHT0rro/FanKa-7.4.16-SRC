package com.kwad.sdk.l.a;

import android.content.Context;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class a implements c {
    public List<c> aMR;
    public boolean enabled;

    public a(boolean z10) {
        this.enabled = z10;
    }

    private List<c> getChildren() {
        return this.aMR;
    }

    @Override // com.kwad.sdk.l.a.c
    public final boolean bA(Context context) {
        if (!this.enabled) {
            return false;
        }
        List<c> children = getChildren();
        if (children != null && children.size() > 0) {
            Iterator<c> iterator2 = children.iterator2();
            while (iterator2.hasNext()) {
                if (iterator2.next().bA(context)) {
                    return true;
                }
            }
            return false;
        }
        try {
            return bB(context);
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean bB(Context context) {
        return false;
    }

    public a() {
        this.enabled = true;
    }
}
