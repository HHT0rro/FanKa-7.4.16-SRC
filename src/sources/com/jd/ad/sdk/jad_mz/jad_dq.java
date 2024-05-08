package com.jd.ad.sdk.jad_mz;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* compiled from: DynamicConfigManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class jad_dq {
    public static final int[] jad_an = {2, 3, 4, 5, 6, 7, 8, 9};

    /* compiled from: DynamicConfigManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class jad_an {
        public static final jad_dq jad_an = new jad_dq();
    }

    public int jad_an(boolean z10, int i10) {
        if (i10 == 1) {
            return z10 ? 6 : 2;
        }
        if (i10 == 2) {
            return z10 ? 9 : 5;
        }
        if (i10 == 4) {
            return z10 ? 7 : 3;
        }
        if (i10 != 5) {
            return -1;
        }
        return z10 ? 8 : 4;
    }

    public final boolean jad_an(List<com.jd.ad.sdk.jad_na.jad_hu> list) {
        if (list.size() == 0) {
            return false;
        }
        Iterator<com.jd.ad.sdk.jad_na.jad_hu> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            if (iterator2.next().jad_an == 1) {
                return true;
            }
        }
        return false;
    }

    public boolean jad_an(int i10, String str) {
        boolean z10;
        com.jd.ad.sdk.jad_na.jad_cp jad_cp = com.jd.ad.sdk.jad_pc.jad_an.jad_cp();
        ArrayList arrayList = null;
        List<com.jd.ad.sdk.jad_na.jad_hu> list = jad_cp == null ? null : jad_cp.jad_hu;
        if (list != null && list.size() != 0) {
            try {
                boolean jad_an2 = jad_an(list);
                if (!jad_an2) {
                    for (com.jd.ad.sdk.jad_na.jad_hu jad_huVar : list) {
                        if (jad_huVar.jad_an == i10) {
                            int i11 = 0;
                            while (true) {
                                int[] iArr = jad_an;
                                if (i11 >= iArr.length) {
                                    z10 = false;
                                    break;
                                }
                                if (i10 == iArr[i11]) {
                                    z10 = true;
                                    break;
                                }
                                i11++;
                            }
                            if (z10) {
                                String str2 = jad_huVar.jad_bo;
                                if (!TextUtils.isEmpty(str2)) {
                                    arrayList = new ArrayList();
                                    arrayList.addAll(Arrays.asList(str2.split(",")));
                                }
                                List<String> jad_an3 = jad_an(i10, arrayList);
                                if (jad_an3 != null && jad_an3.size() > 0) {
                                    if (!jad_an3.contains(str)) {
                                        return false;
                                    }
                                }
                            }
                            return true;
                        }
                    }
                }
                return jad_an2;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }

    public List<String> jad_an(int i10, List<String> list) {
        int i11;
        ArrayList arrayList;
        List<com.jd.ad.sdk.jad_na.jad_er> list2;
        if (list != null && list.size() > 0) {
            switch (i10) {
                case 2:
                case 6:
                    i11 = 1;
                    break;
                case 3:
                case 7:
                    i11 = 4;
                    break;
                case 4:
                case 8:
                    i11 = 5;
                    break;
                case 5:
                case 9:
                    i11 = 2;
                    break;
                default:
                    i11 = -1;
                    break;
            }
            com.jd.ad.sdk.jad_na.jad_cp jad_cp = com.jd.ad.sdk.jad_pc.jad_an.jad_cp();
            if (jad_cp == null || (list2 = jad_cp.jad_jt) == null || list2.size() <= 0) {
                arrayList = null;
            } else {
                arrayList = new ArrayList();
                for (com.jd.ad.sdk.jad_na.jad_er jad_erVar : list2) {
                    if (jad_erVar != null && i11 == jad_erVar.jad_bo) {
                        arrayList.add(jad_erVar.jad_an);
                    }
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = new ArrayList();
                for (String str : list) {
                    Iterator<E> iterator2 = arrayList.iterator2();
                    while (iterator2.hasNext()) {
                        if (str.equals((String) iterator2.next())) {
                            arrayList2.add(str);
                        }
                    }
                }
                return arrayList2;
            }
        }
        return null;
    }
}
