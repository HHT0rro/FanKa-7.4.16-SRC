package com.alibaba.security.realidentity.build;

import com.alibaba.security.common.log.RPLogging;
import com.alibaba.security.realidentity.build.l;
import com.alibaba.security.realidentity.business.base.chain.BusinessHeadParams;
import com.alibaba.security.realidentity.business.base.chain.BusinessType;
import com.alibaba.security.realidentity.business.biometrics.AbsBiometricsBucketParams;
import com.alibaba.security.realidentity.business.biometrics.BiometricsBucketParams;
import com.alibaba.security.realidentity.business.bucket.BucketParams;
import com.alibaba.security.realidentity.business.start.AbsStartHttpParams;
import com.alibaba.security.realidentity.business.start.StartHttpParams;
import com.alibaba.security.realidentity.business.submit.AbsSubmitHttpParams;
import com.alibaba.security.realidentity.business.submit.SubmitHttpParams;
import com.alibaba.security.realidentity.business.upload.AbsUploadFileParams;
import com.alibaba.security.realidentity.business.upload.UploadFileParams;
import com.alibaba.security.realidentity.business.upload.UploadResultParams;
import com.alibaba.security.realidentity.business.uploadresult.AbsUploadResultParams;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: RealIdentityChainParams.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class r {

    /* renamed from: h, reason: collision with root package name */
    private static final String f3966h = "r";

    /* renamed from: a, reason: collision with root package name */
    public String f3967a;

    /* renamed from: b, reason: collision with root package name */
    public BusinessHeadParams f3968b;

    /* renamed from: c, reason: collision with root package name */
    public StartHttpParams f3969c;

    /* renamed from: d, reason: collision with root package name */
    public BiometricsBucketParams f3970d;

    /* renamed from: e, reason: collision with root package name */
    public UploadFileParams f3971e;

    /* renamed from: f, reason: collision with root package name */
    public UploadResultParams f3972f;

    /* renamed from: g, reason: collision with root package name */
    public SubmitHttpParams f3973g;

    /* renamed from: i, reason: collision with root package name */
    private int f3974i = -1;

    /* renamed from: j, reason: collision with root package name */
    private List<BusinessType> f3975j = new ArrayList();

    /* renamed from: k, reason: collision with root package name */
    private Class<? extends BucketParams>[] f3976k = null;

    /* compiled from: RealIdentityChainParams.java */
    /* renamed from: com.alibaba.security.realidentity.build.r$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3977a;

        static {
            int[] iArr = new int[BusinessType.values().length];
            f3977a = iArr;
            try {
                iArr[BusinessType.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3977a[BusinessType.SUBMIT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3977a[BusinessType.UPLOADFILE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3977a[BusinessType.UPLOADRESULT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3977a[BusinessType.ALBIOMETERICS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public r(BusinessHeadParams businessHeadParams) {
        this.f3968b = businessHeadParams;
    }

    private boolean b(BusinessType businessType) {
        try {
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (InstantiationException e10) {
            e10.printStackTrace();
        } catch (NoSuchMethodException e11) {
            e11.printStackTrace();
        } catch (InvocationTargetException e12) {
            e12.printStackTrace();
        }
        if (this.f3976k == null) {
            RPLogging.e(f3966h, "createParams classes is null");
            return false;
        }
        int i10 = AnonymousClass1.f3977a[businessType.ordinal()];
        if (i10 == 1) {
            for (Class<? extends BucketParams> cls : this.f3976k) {
                if (AbsStartHttpParams.class.isAssignableFrom(cls)) {
                    this.f3969c = (StartHttpParams) cls.getConstructor(new Class[0]).newInstance(new Object[0]);
                    return true;
                }
            }
        } else if (i10 == 2) {
            for (Class<? extends BucketParams> cls2 : this.f3976k) {
                if (AbsSubmitHttpParams.class.isAssignableFrom(cls2)) {
                    this.f3973g = (SubmitHttpParams) cls2.getConstructor(new Class[0]).newInstance(new Object[0]);
                    return true;
                }
            }
        } else if (i10 == 3) {
            for (Class<? extends BucketParams> cls3 : this.f3976k) {
                if (AbsUploadFileParams.class.isAssignableFrom(cls3)) {
                    this.f3971e = (UploadFileParams) cls3.getConstructor(new Class[0]).newInstance(new Object[0]);
                    return true;
                }
            }
        } else if (i10 == 4) {
            for (Class<? extends BucketParams> cls4 : this.f3976k) {
                if (AbsUploadResultParams.class.isAssignableFrom(cls4)) {
                    this.f3972f = (UploadResultParams) cls4.getConstructor(new Class[0]).newInstance(new Object[0]);
                    return true;
                }
            }
        } else if (i10 == 5) {
            for (Class<? extends BucketParams> cls5 : this.f3976k) {
                if (AbsBiometricsBucketParams.class.isAssignableFrom(cls5)) {
                    this.f3970d = (BiometricsBucketParams) cls5.getConstructor(new Class[0]).newInstance(new Object[0]);
                    return true;
                }
            }
        }
        return false;
    }

    public final void a(List<BusinessType> list, String str) {
        this.f3975j = list;
        this.f3974i = -1;
        this.f3976k = l.a.a().c();
        this.f3967a = str;
    }

    public final void c() {
        List<BusinessType> list = this.f3975j;
        if (list == null || list.isEmpty()) {
            return;
        }
        this.f3974i = this.f3975j.size();
    }

    public final void d() {
        List<BusinessType> list = this.f3975j;
        if (list == null || list.isEmpty()) {
            return;
        }
        this.f3974i = this.f3975j.indexOf(BusinessType.ALBIOMETERICS);
    }

    public final boolean a() {
        int i10 = this.f3974i + 1;
        this.f3974i = i10;
        if (i10 >= this.f3975j.size()) {
            return false;
        }
        BusinessType businessType = this.f3975j.get(this.f3974i);
        if (!b(businessType)) {
            RPLogging.e(f3966h, "isCreateSuccessful params error businessType:" + businessType.name());
            return false;
        }
        int i11 = AnonymousClass1.f3977a[businessType.ordinal()];
        if (i11 == 1) {
            this.f3969c.dispatch(this);
        } else if (i11 == 2) {
            this.f3973g.dispatch(this);
        } else if (i11 == 3) {
            this.f3971e.dispatch(this);
        } else if (i11 == 4) {
            this.f3972f.dispatch(this);
        } else if (i11 == 5) {
            this.f3970d.dispatch(this);
        }
        return true;
    }

    private BucketParams.ErrorCode a(BusinessType businessType) {
        int i10 = AnonymousClass1.f3977a[businessType.ordinal()];
        if (i10 == 1) {
            return this.f3969c.getErrorCode();
        }
        if (i10 == 2) {
            return this.f3973g.getErrorCode();
        }
        if (i10 == 3) {
            return this.f3971e.getErrorCode();
        }
        if (i10 == 4) {
            return this.f3972f.getErrorCode();
        }
        if (i10 != 5) {
            return null;
        }
        return this.f3970d.getErrorCode();
    }

    private void a(String str) {
        this.f3967a = str;
    }

    public final String b() {
        return this.f3967a;
    }
}
