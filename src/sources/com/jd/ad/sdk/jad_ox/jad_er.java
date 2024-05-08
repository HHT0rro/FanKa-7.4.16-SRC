package com.jd.ad.sdk.jad_ox;

import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.huawei.appgallery.agd.common.utils.StringUtils;
import com.jd.ad.sdk.jad_js.jad_zm;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class jad_er {
    public static final jad_er jad_cp = new jad_er("COMPOSITION");
    public final List<String> jad_an;

    @Nullable
    public jad_fs jad_bo;

    public jad_er(jad_er jad_erVar) {
        this.jad_an = new ArrayList(jad_erVar.jad_an);
        this.jad_bo = jad_erVar.jad_bo;
    }

    public jad_er(String... strArr) {
        this.jad_an = Arrays.asList(strArr);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public jad_er jad_an(jad_fs jad_fsVar) {
        jad_er jad_erVar = new jad_er(this);
        jad_erVar.jad_bo = jad_fsVar;
        return jad_erVar;
    }

    @CheckResult
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public jad_er jad_an(String str) {
        jad_er jad_erVar = new jad_er(this);
        jad_erVar.jad_an.add(str);
        return jad_erVar;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean jad_an(String str, int i10) {
        if (i10 >= this.jad_an.size()) {
            return false;
        }
        boolean z10 = i10 == this.jad_an.size() - 1;
        String str2 = this.jad_an.get(i10);
        if (!str2.equals("**")) {
            boolean z11 = str2.equals(str) || str2.equals(StringUtils.NO_PRINT_CODE);
            if (!z10) {
                if (i10 != this.jad_an.size() - 2) {
                    return false;
                }
                List<String> list = this.jad_an;
                if (!list.get(list.size() - 1).equals("**")) {
                    return false;
                }
            }
            return z11;
        }
        if (!(!z10 && this.jad_an.get(i10 + 1).equals(str))) {
            if (z10) {
                return true;
            }
            int i11 = i10 + 1;
            if (i11 < this.jad_an.size() - 1) {
                return false;
            }
            return this.jad_an.get(i11).equals(str);
        }
        if (i10 != this.jad_an.size() - 2) {
            if (i10 != this.jad_an.size() - 3) {
                return false;
            }
            List<String> list2 = this.jad_an;
            if (!list2.get(list2.size() - 1).equals("**")) {
                return false;
            }
        }
        return true;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int jad_bo(String str, int i10) {
        if ("__container".equals(str)) {
            return 0;
        }
        if (this.jad_an.get(i10).equals("**")) {
            return (i10 != this.jad_an.size() - 1 && this.jad_an.get(i10 + 1).equals(str)) ? 2 : 0;
        }
        return 1;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean jad_cp(String str, int i10) {
        if ("__container".equals(str)) {
            return true;
        }
        if (i10 >= this.jad_an.size()) {
            return false;
        }
        return this.jad_an.get(i10).equals(str) || this.jad_an.get(i10).equals("**") || this.jad_an.get(i10).equals(StringUtils.NO_PRINT_CODE);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean jad_dq(String str, int i10) {
        return "__container".equals(str) || i10 < this.jad_an.size() - 1 || this.jad_an.get(i10).equals("**");
    }

    public String toString() {
        StringBuilder jad_an = jad_zm.jad_an("KeyPath{keys=");
        jad_an.append((Object) this.jad_an);
        jad_an.append(",resolved=");
        jad_an.append(this.jad_bo != null);
        jad_an.append('}');
        return jad_an.toString();
    }
}
