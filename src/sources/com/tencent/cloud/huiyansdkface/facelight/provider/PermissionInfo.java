package com.tencent.cloud.huiyansdkface.facelight.provider;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class PermissionInfo {
    public String[] permissionArray;
    public List<String> permissionList = new ArrayList();
    public List<PermissionTip> infoList = new ArrayList();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class PermissionTip {
        public String content;
        public String noPermissionTip;
        public String title;
        public String toSetting;

        public PermissionTip(String str, String str2, String str3, String str4) {
            this.title = str;
            this.content = str2;
            this.toSetting = str3;
            this.noPermissionTip = str4;
        }
    }

    public void addPermission(String str, PermissionTip permissionTip) {
        if (TextUtils.isEmpty(str) || permissionTip == null) {
            return;
        }
        this.permissionList.add(str);
        this.infoList.add(permissionTip);
        this.permissionArray = null;
    }

    public String[] getPermissionArray() {
        if (this.permissionArray == null) {
            List<String> list = this.permissionList;
            this.permissionArray = (String[]) list.toArray(new String[list.size()]);
        }
        return this.permissionArray;
    }

    public PermissionTip getPermissionTip(String str) {
        PermissionTip permissionTip;
        int i10 = 0;
        while (true) {
            if (i10 >= this.permissionList.size()) {
                permissionTip = this.infoList.get(0);
                break;
            }
            if (this.permissionList.get(i10).equals(str)) {
                permissionTip = this.infoList.get(i10);
                break;
            }
            i10++;
        }
        return permissionTip;
    }
}
