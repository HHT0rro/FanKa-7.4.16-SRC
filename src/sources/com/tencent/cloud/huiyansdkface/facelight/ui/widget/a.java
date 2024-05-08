package com.tencent.cloud.huiyansdkface.facelight.ui.widget;

import android.app.Dialog;
import android.content.Context;
import android.view.View;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class a extends Dialog implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    private String f41153a;

    /* renamed from: b, reason: collision with root package name */
    private String f41154b;

    /* renamed from: c, reason: collision with root package name */
    private String f41155c;

    /* renamed from: d, reason: collision with root package name */
    private String f41156d;

    /* renamed from: e, reason: collision with root package name */
    private String f41157e;

    /* renamed from: f, reason: collision with root package name */
    private Context f41158f;

    /* renamed from: g, reason: collision with root package name */
    private InterfaceC0627a f41159g;

    /* renamed from: com.tencent.cloud.huiyansdkface.facelight.ui.widget.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface InterfaceC0627a {
        void a();

        void b();
    }

    public a(Context context) {
        super(context);
        this.f41158f = context;
        this.f41157e = "1";
    }

    public a(Context context, String str) {
        super(context);
        this.f41158f = context;
        this.f41157e = str;
    }

    private void a(View view) {
        view.setSystemUiVisibility(5894);
    }

    public a a(String str) {
        this.f41153a = str;
        return this;
    }

    public void a(InterfaceC0627a interfaceC0627a) {
        this.f41159g = interfaceC0627a;
    }

    public a b(String str) {
        this.f41154b = str;
        return this;
    }

    public a c(String str) {
        this.f41155c = str;
        return this;
    }

    public a d(String str) {
        this.f41156d = str;
        return this;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0020, code lost:
    
        if (r3.f41157e.equals("2") != false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003b, code lost:
    
        if (r3.f41157e.equals("2") != false) goto L6;
     */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onClick(android.view.View r4) {
        /*
            r3 = this;
            int r4 = r4.getId()
            int r0 = com.tencent.cloud.huiyansdkface.R.id.wbcf_button_right
            java.lang.String r1 = "2"
            java.lang.String r2 = "1"
            if (r4 != r0) goto L23
            java.lang.String r4 = r3.f41157e
            boolean r4 = r4.equals(r2)
            if (r4 == 0) goto L1a
        L14:
            com.tencent.cloud.huiyansdkface.facelight.ui.widget.a$a r4 = r3.f41159g
            r4.a()
            goto L3e
        L1a:
            java.lang.String r4 = r3.f41157e
            boolean r4 = r4.equals(r1)
            if (r4 == 0) goto L3e
            goto L2f
        L23:
            int r0 = com.tencent.cloud.huiyansdkface.R.id.wbcf_button_left
            if (r4 != r0) goto L3e
            java.lang.String r4 = r3.f41157e
            boolean r4 = r4.equals(r2)
            if (r4 == 0) goto L35
        L2f:
            com.tencent.cloud.huiyansdkface.facelight.ui.widget.a$a r4 = r3.f41159g
            r4.b()
            goto L3e
        L35:
            java.lang.String r4 = r3.f41157e
            boolean r4 = r4.equals(r1)
            if (r4 == 0) goto L3e
            goto L14
        L3e:
            r3.dismiss()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.cloud.huiyansdkface.facelight.ui.widget.a.onClick(android.view.View):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x013a  */
    @Override // android.app.Dialog
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onCreate(android.os.Bundle r6) {
        /*
            Method dump skipped, instructions count: 321
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.cloud.huiyansdkface.facelight.ui.widget.a.onCreate(android.os.Bundle):void");
    }

    @Override // android.app.Dialog
    public void show() {
        getWindow().setFlags(8, 8);
        super.show();
        a(getWindow().getDecorView());
        getWindow().clearFlags(8);
    }
}
