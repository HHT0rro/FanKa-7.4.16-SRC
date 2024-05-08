package com.jd.ad.sdk.jad_lu;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.jd.ad.sdk.jad_mv.jad_an;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class jad_na implements jad_mz, jad_an.InterfaceC0374jad_an, jad_kx {
    public final String jad_bo;
    public final com.jd.ad.sdk.jad_js.jad_mz jad_cp;
    public final int jad_dq;
    public final boolean jad_er;
    public final com.jd.ad.sdk.jad_mv.jad_an<?, Float> jad_fs;
    public final com.jd.ad.sdk.jad_mv.jad_an<?, Float> jad_hu;

    @Nullable
    public final com.jd.ad.sdk.jad_mv.jad_an<?, Float> jad_iv;
    public final com.jd.ad.sdk.jad_mv.jad_an<?, PointF> jad_jt;
    public final com.jd.ad.sdk.jad_mv.jad_an<?, Float> jad_jw;

    @Nullable
    public final com.jd.ad.sdk.jad_mv.jad_an<?, Float> jad_kx;
    public final com.jd.ad.sdk.jad_mv.jad_an<?, Float> jad_ly;
    public boolean jad_na;
    public final Path jad_an = new Path();
    public final jad_bo jad_mz = new jad_bo();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static /* synthetic */ class jad_an {
        public static final /* synthetic */ int[] jad_an;

        static {
            int[] iArr = new int[com.jd.ad.sdk.jad_jt.jad_fs.jad_bo(2).length];
            jad_an = iArr;
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                jad_an[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public jad_na(com.jd.ad.sdk.jad_js.jad_mz jad_mzVar, com.jd.ad.sdk.jad_ra.jad_an jad_anVar, com.jd.ad.sdk.jad_qz.jad_kx jad_kxVar) {
        com.jd.ad.sdk.jad_mv.jad_an<Float, Float> jad_anVar2;
        this.jad_cp = jad_mzVar;
        this.jad_bo = jad_kxVar.jad_cp();
        int jad_iv = jad_kxVar.jad_iv();
        this.jad_dq = jad_iv;
        this.jad_er = jad_kxVar.jad_jw();
        com.jd.ad.sdk.jad_mv.jad_an<Float, Float> jad_an2 = jad_kxVar.jad_fs().jad_an();
        this.jad_fs = jad_an2;
        com.jd.ad.sdk.jad_mv.jad_an<PointF, PointF> jad_an3 = jad_kxVar.jad_jt().jad_an();
        this.jad_jt = jad_an3;
        com.jd.ad.sdk.jad_mv.jad_an<Float, Float> jad_an4 = jad_kxVar.jad_hu().jad_an();
        this.jad_hu = jad_an4;
        com.jd.ad.sdk.jad_mv.jad_an<Float, Float> jad_an5 = jad_kxVar.jad_dq().jad_an();
        this.jad_jw = jad_an5;
        com.jd.ad.sdk.jad_mv.jad_an<Float, Float> jad_an6 = jad_kxVar.jad_er().jad_an();
        this.jad_ly = jad_an6;
        if (jad_iv == 1) {
            this.jad_iv = jad_kxVar.jad_an().jad_an();
            jad_anVar2 = jad_kxVar.jad_bo().jad_an();
        } else {
            jad_anVar2 = null;
            this.jad_iv = null;
        }
        this.jad_kx = jad_anVar2;
        jad_anVar.jad_an(jad_an2);
        jad_anVar.jad_an(jad_an3);
        jad_anVar.jad_an(jad_an4);
        jad_anVar.jad_an(jad_an5);
        jad_anVar.jad_an(jad_an6);
        if (jad_iv == 1) {
            jad_anVar.jad_an(this.jad_iv);
            jad_anVar.jad_an(this.jad_kx);
        }
        jad_an2.jad_an(this);
        jad_an3.jad_an(this);
        jad_an4.jad_an(this);
        jad_an5.jad_an(this);
        jad_an6.jad_an(this);
        if (jad_iv == 1) {
            this.jad_iv.jad_an(this);
            this.jad_kx.jad_an(this);
        }
    }

    @Override // com.jd.ad.sdk.jad_ox.jad_fs
    public void jad_an(com.jd.ad.sdk.jad_ox.jad_er jad_erVar, int i10, List<com.jd.ad.sdk.jad_ox.jad_er> list, com.jd.ad.sdk.jad_ox.jad_er jad_erVar2) {
        com.jd.ad.sdk.jad_ve.jad_jt.jad_an(jad_erVar, i10, list, jad_erVar2, this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.jd.ad.sdk.jad_ox.jad_fs
    public <T> void jad_an(T t2, @Nullable com.jd.ad.sdk.jad_wf.jad_cp<T> jad_cpVar) {
        com.jd.ad.sdk.jad_mv.jad_an jad_anVar;
        com.jd.ad.sdk.jad_mv.jad_an<?, Float> jad_anVar2;
        if (t2 == com.jd.ad.sdk.jad_js.jad_re.jad_wj) {
            jad_anVar = this.jad_fs;
        } else if (t2 == com.jd.ad.sdk.jad_js.jad_re.jad_xk) {
            jad_anVar = this.jad_hu;
        } else {
            if (t2 != com.jd.ad.sdk.jad_js.jad_re.jad_na) {
                if (t2 != com.jd.ad.sdk.jad_js.jad_re.jad_yl || (jad_anVar2 = this.jad_iv) == null) {
                    if (t2 == com.jd.ad.sdk.jad_js.jad_re.jad_zm) {
                        jad_anVar = this.jad_jw;
                    } else if (t2 != com.jd.ad.sdk.jad_js.jad_re.jad_cn || (jad_anVar2 = this.jad_kx) == null) {
                        if (t2 != com.jd.ad.sdk.jad_js.jad_re.jad_do) {
                            return;
                        } else {
                            jad_anVar = this.jad_ly;
                        }
                    }
                }
                jad_anVar2.jad_er = jad_cpVar;
                return;
            }
            jad_anVar = this.jad_jt;
        }
        jad_anVar.jad_er = jad_cpVar;
    }

    @Override // com.jd.ad.sdk.jad_lu.jad_mz
    public Path jad_bo() {
        float sin;
        float f10;
        double d10;
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        double d11;
        float f16;
        float f17;
        float f18;
        float f19;
        int i10;
        double d12;
        if (this.jad_na) {
            return this.jad_an;
        }
        this.jad_an.reset();
        if (this.jad_er) {
            this.jad_na = true;
            return this.jad_an;
        }
        int i11 = jad_an.jad_an[com.jd.ad.sdk.jad_jt.jad_fs.jad_an(this.jad_dq)];
        double d13 = ShadowDrawableWrapper.COS_45;
        float f20 = 0.0f;
        if (i11 == 1) {
            float floatValue = this.jad_fs.jad_fs().floatValue();
            com.jd.ad.sdk.jad_mv.jad_an<?, Float> jad_anVar = this.jad_hu;
            if (jad_anVar != null) {
                d13 = jad_anVar.jad_fs().floatValue();
            }
            double radians = Math.toRadians(d13 - 90.0d);
            double d14 = floatValue;
            float f21 = (float) (6.283185307179586d / d14);
            float f22 = f21 / 2.0f;
            float f23 = floatValue - ((int) floatValue);
            if (f23 != 0.0f) {
                radians += (1.0f - f23) * f22;
            }
            float floatValue2 = this.jad_jw.jad_fs().floatValue();
            float floatValue3 = this.jad_iv.jad_fs().floatValue();
            com.jd.ad.sdk.jad_mv.jad_an<?, Float> jad_anVar2 = this.jad_kx;
            float floatValue4 = jad_anVar2 != null ? jad_anVar2.jad_fs().floatValue() / 100.0f : 0.0f;
            com.jd.ad.sdk.jad_mv.jad_an<?, Float> jad_anVar3 = this.jad_ly;
            float floatValue5 = jad_anVar3 != null ? jad_anVar3.jad_fs().floatValue() / 100.0f : 0.0f;
            if (f23 != 0.0f) {
                float f24 = ((floatValue2 - floatValue3) * f23) + floatValue3;
                double d15 = f24;
                f12 = f24;
                f11 = (float) (Math.cos(radians) * d15);
                float sin2 = (float) (d15 * Math.sin(radians));
                this.jad_an.moveTo(f11, sin2);
                d10 = radians + ((f21 * f23) / 2.0f);
                f10 = f22;
                sin = sin2;
            } else {
                double d16 = floatValue2;
                float cos = (float) (Math.cos(radians) * d16);
                sin = (float) (d16 * Math.sin(radians));
                this.jad_an.moveTo(cos, sin);
                f10 = f22;
                d10 = radians + f10;
                f11 = cos;
                f12 = 0.0f;
            }
            double ceil = Math.ceil(d14) * 2.0d;
            float f25 = f11;
            int i12 = 0;
            boolean z10 = false;
            while (true) {
                double d17 = i12;
                if (d17 >= ceil) {
                    break;
                }
                float f26 = z10 ? floatValue2 : floatValue3;
                if (f12 == 0.0f || d17 != ceil - 2.0d) {
                    f13 = f21;
                    f14 = f10;
                } else {
                    f13 = f21;
                    f14 = (f21 * f23) / 2.0f;
                }
                if (f12 == 0.0f || d17 != ceil - 1.0d) {
                    f15 = f10;
                    d11 = d17;
                    f16 = f26;
                } else {
                    f15 = f10;
                    d11 = d17;
                    f16 = f12;
                }
                double d18 = f16;
                double d19 = ceil;
                float cos2 = (float) (Math.cos(d10) * d18);
                float sin3 = (float) (Math.sin(d10) * d18);
                if (floatValue4 == 0.0f && floatValue5 == 0.0f) {
                    this.jad_an.lineTo(cos2, sin3);
                    f17 = floatValue2;
                    f18 = floatValue5;
                    f19 = floatValue4;
                } else {
                    f17 = floatValue2;
                    double atan2 = (float) (Math.atan2(sin, f25) - 1.5707963267948966d);
                    float cos3 = (float) Math.cos(atan2);
                    float sin4 = (float) Math.sin(atan2);
                    f18 = floatValue5;
                    f19 = floatValue4;
                    double atan22 = (float) (Math.atan2(sin3, cos2) - 1.5707963267948966d);
                    float cos4 = (float) Math.cos(atan22);
                    float sin5 = (float) Math.sin(atan22);
                    float f27 = z10 ? f19 : f18;
                    float f28 = z10 ? f18 : f19;
                    float f29 = (z10 ? floatValue3 : f17) * f27 * 0.47829f;
                    float f30 = cos3 * f29;
                    float f31 = f29 * sin4;
                    float f32 = (z10 ? f17 : floatValue3) * f28 * 0.47829f;
                    float f33 = cos4 * f32;
                    float f34 = f32 * sin5;
                    if (f23 != 0.0f) {
                        if (i12 == 0) {
                            f30 *= f23;
                            f31 *= f23;
                        } else if (d11 == d19 - 1.0d) {
                            f33 *= f23;
                            f34 *= f23;
                        }
                    }
                    this.jad_an.cubicTo(f25 - f30, sin - f31, cos2 + f33, sin3 + f34, cos2, sin3);
                }
                d10 += f14;
                z10 = !z10;
                i12++;
                f25 = cos2;
                sin = sin3;
                floatValue2 = f17;
                f21 = f13;
                f10 = f15;
                floatValue4 = f19;
                floatValue5 = f18;
                ceil = d19;
            }
            PointF jad_fs = this.jad_jt.jad_fs();
            this.jad_an.offset(jad_fs.x, jad_fs.y);
            this.jad_an.close();
        } else if (i11 == 2) {
            int floor = (int) Math.floor(this.jad_fs.jad_fs().floatValue());
            com.jd.ad.sdk.jad_mv.jad_an<?, Float> jad_anVar4 = this.jad_hu;
            if (jad_anVar4 != null) {
                d13 = jad_anVar4.jad_fs().floatValue();
            }
            double radians2 = Math.toRadians(d13 - 90.0d);
            double d20 = floor;
            float floatValue6 = this.jad_ly.jad_fs().floatValue() / 100.0f;
            float floatValue7 = this.jad_jw.jad_fs().floatValue();
            double d21 = floatValue7;
            float cos5 = (float) (Math.cos(radians2) * d21);
            float sin6 = (float) (Math.sin(radians2) * d21);
            this.jad_an.moveTo(cos5, sin6);
            double d22 = (float) (6.283185307179586d / d20);
            double d23 = radians2 + d22;
            double ceil2 = Math.ceil(d20);
            float f35 = cos5;
            int i13 = 0;
            while (i13 < ceil2) {
                float cos6 = (float) (Math.cos(d23) * d21);
                double d24 = ceil2;
                float sin7 = (float) (Math.sin(d23) * d21);
                if (floatValue6 != f20) {
                    d12 = d21;
                    double atan23 = (float) (Math.atan2(sin6, f35) - 1.5707963267948966d);
                    float cos7 = (float) Math.cos(atan23);
                    float sin8 = (float) Math.sin(atan23);
                    i10 = i13;
                    double atan24 = (float) (Math.atan2(sin7, cos6) - 1.5707963267948966d);
                    float f36 = floatValue7 * floatValue6 * 0.25f;
                    this.jad_an.cubicTo(f35 - (cos7 * f36), sin6 - (sin8 * f36), cos6 + (((float) Math.cos(atan24)) * f36), sin7 + (f36 * ((float) Math.sin(atan24))), cos6, sin7);
                } else {
                    i10 = i13;
                    d12 = d21;
                    this.jad_an.lineTo(cos6, sin7);
                }
                d23 += d22;
                i13 = i10 + 1;
                f35 = cos6;
                sin6 = sin7;
                ceil2 = d24;
                d21 = d12;
                f20 = 0.0f;
            }
            PointF jad_fs2 = this.jad_jt.jad_fs();
            this.jad_an.offset(jad_fs2.x, jad_fs2.y);
            this.jad_an.close();
        }
        this.jad_an.close();
        this.jad_mz.jad_an(this.jad_an);
        this.jad_na = true;
        return this.jad_an;
    }

    @Override // com.jd.ad.sdk.jad_lu.jad_cp
    public String jad_cp() {
        return this.jad_bo;
    }

    @Override // com.jd.ad.sdk.jad_mv.jad_an.InterfaceC0374jad_an
    public void jad_an() {
        this.jad_na = false;
        this.jad_cp.invalidateSelf();
    }

    @Override // com.jd.ad.sdk.jad_lu.jad_cp
    public void jad_an(List<jad_cp> list, List<jad_cp> list2) {
        for (int i10 = 0; i10 < list.size(); i10++) {
            jad_cp jad_cpVar = list.get(i10);
            if (jad_cpVar instanceof jad_sf) {
                jad_sf jad_sfVar = (jad_sf) jad_cpVar;
                if (jad_sfVar.jad_dq == 1) {
                    this.jad_mz.jad_an.add(jad_sfVar);
                    jad_sfVar.jad_cp.add(this);
                }
            }
        }
    }
}
