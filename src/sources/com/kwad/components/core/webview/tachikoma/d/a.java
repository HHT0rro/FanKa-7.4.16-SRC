package com.kwad.components.core.webview.tachikoma.d;

import android.text.TextUtils;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.bn;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a {
    private List<Integer> aaQ;
    private final List<Integer> aaR;

    /* renamed from: com.kwad.components.core.webview.tachikoma.d.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class C0488a {
        private static final a aaV = new a(0);
    }

    public /* synthetic */ a(byte b4) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aV(int i10) {
        if (this.aaR.contains(Integer.valueOf(i10))) {
            this.aaQ.add(Integer.valueOf(i10));
        }
    }

    public static a sY() {
        return C0488a.aaV;
    }

    public final void aW(final int i10) {
        bn.runOnUiThread(new ay() { // from class: com.kwad.components.core.webview.tachikoma.d.a.1
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                a.this.aV(i10);
            }
        });
    }

    public final List<Integer> sZ() {
        return this.aaQ;
    }

    public final void ta() {
        this.aaQ.clear();
    }

    private a() {
        this.aaQ = new ArrayList();
        this.aaR = Arrays.asList(123, 184, 185, 190, 199, 200);
    }

    public final void aW(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        bn.runOnUiThread(new ay() { // from class: com.kwad.components.core.webview.tachikoma.d.a.2
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                a.this.aV(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aV(String str) {
        int i10;
        try {
            i10 = new JSONObject(str).optInt("elementType");
        } catch (Exception unused) {
            i10 = Integer.MAX_VALUE;
        }
        if (this.aaR.contains(Integer.valueOf(i10))) {
            this.aaQ.add(Integer.valueOf(i10));
        }
    }
}
