package com.huawei.openalliance.ad.download.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.huawei.hms.ads.base.R;
import com.huawei.openalliance.ad.inter.data.PermissionEntity;
import com.huawei.openalliance.ad.utils.aa;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class i extends BaseAdapter {
    private static final int Code = 2;
    private List<PermissionEntity> I;
    private Context V;
    private LayoutInflater Z;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a {
        public TextView Code;

        public a(View view) {
            this.Code = (TextView) view.findViewById(R.id.hiad_permissions_dialog_child_tv);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class b {
        public TextView Code;

        public b(View view) {
            this.Code = (TextView) view.findViewById(R.id.hiad_permissions_dialog_parent_tv);
        }
    }

    public i(Context context, List<PermissionEntity> list) {
        this.V = context;
        this.I = list;
        this.Z = LayoutInflater.from(context);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (aa.Code(this.I)) {
            return 0;
        }
        return this.I.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i10) {
        if (aa.Code(this.I)) {
            return null;
        }
        return this.I.get(i10);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        if (aa.Code(this.I)) {
            return 0L;
        }
        return i10;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i10) {
        if (aa.Code(this.I) || this.I.get(i10) == null) {
            return 0;
        }
        return this.I.get(i10).V();
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0069, code lost:
    
        r4 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x006a, code lost:
    
        r8.setText(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0066, code lost:
    
        if (android.text.TextUtils.isEmpty(r0) != false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x003c, code lost:
    
        if (android.text.TextUtils.isEmpty(r0) != false) goto L25;
     */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.View getView(int r6, android.view.View r7, android.view.ViewGroup r8) {
        /*
            r5 = this;
            java.util.List<com.huawei.openalliance.ad.inter.data.PermissionEntity> r0 = r5.I
            java.lang.Object r0 = r0.get(r6)
            com.huawei.openalliance.ad.inter.data.PermissionEntity r0 = (com.huawei.openalliance.ad.inter.data.PermissionEntity) r0
            int r1 = r5.getItemViewType(r6)
            r2 = 1
            r3 = 0
            java.lang.String r4 = ""
            if (r1 == 0) goto L3f
            if (r1 == r2) goto L15
            goto L6d
        L15:
            if (r7 != 0) goto L28
            android.view.LayoutInflater r7 = r5.Z
            int r1 = com.huawei.hms.ads.base.R.layout.hiad_permission_dialog_child_item
            android.view.View r7 = r7.inflate(r1, r8, r3)
            com.huawei.openalliance.ad.download.app.i$a r8 = new com.huawei.openalliance.ad.download.app.i$a
            r8.<init>(r7)
            r7.setTag(r8)
            goto L2e
        L28:
            java.lang.Object r8 = r7.getTag()
            com.huawei.openalliance.ad.download.app.i$a r8 = (com.huawei.openalliance.ad.download.app.i.a) r8
        L2e:
            if (r0 == 0) goto L35
            java.lang.String r0 = r0.Code()
            goto L36
        L35:
            r0 = r4
        L36:
            android.widget.TextView r8 = r8.Code
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L69
            goto L6a
        L3f:
            if (r7 != 0) goto L52
            android.view.LayoutInflater r7 = r5.Z
            int r1 = com.huawei.hms.ads.base.R.layout.hiad_permission_dialog_parent_item
            android.view.View r7 = r7.inflate(r1, r8, r3)
            com.huawei.openalliance.ad.download.app.i$b r8 = new com.huawei.openalliance.ad.download.app.i$b
            r8.<init>(r7)
            r7.setTag(r8)
            goto L58
        L52:
            java.lang.Object r8 = r7.getTag()
            com.huawei.openalliance.ad.download.app.i$b r8 = (com.huawei.openalliance.ad.download.app.i.b) r8
        L58:
            if (r0 == 0) goto L5f
            java.lang.String r0 = r0.Code()
            goto L60
        L5f:
            r0 = r4
        L60:
            android.widget.TextView r8 = r8.Code
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L69
            goto L6a
        L69:
            r4 = r0
        L6a:
            r8.setText(r4)
        L6d:
            r8 = 2
            java.lang.Object[] r8 = new java.lang.Object[r8]
            long r0 = java.lang.System.currentTimeMillis()
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            r8[r3] = r0
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r8[r2] = r6
            java.lang.String r6 = "AppPermissionsDialog"
            java.lang.String r0 = "getView, time:%s, position:%s"
            com.huawei.hms.ads.gl.Code(r6, r0, r8)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.ad.download.app.i.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i10) {
        return false;
    }
}
