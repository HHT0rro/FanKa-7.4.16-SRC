package com.huawei.hmf.services.ui.internal;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class SecurityIntent {
    private final Intent mIntent;

    private SecurityIntent(Intent intent) {
        this.mIntent = intent;
    }

    public static SecurityIntent from(Intent intent) {
        return new SecurityIntent(intent);
    }

    public String getAction() {
        return this.mIntent.getAction();
    }

    public boolean getBooleanExtra(String str, boolean z10) {
        try {
            return this.mIntent.getBooleanExtra(str, z10);
        } catch (Throwable unused) {
            return false;
        }
    }

    public Bundle getBundleExtra(String str) {
        try {
            return this.mIntent.getBundleExtra(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public CharSequence getCharSequenceExtra(String str) {
        try {
            return this.mIntent.getCharSequenceExtra(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public Bundle getExtras() {
        try {
            return this.mIntent.getExtras();
        } catch (Throwable unused) {
            return new Bundle();
        }
    }

    public int getFlags() {
        return this.mIntent.getFlags();
    }

    public float getFloatExtra(String str, float f10) {
        try {
            return this.mIntent.getFloatExtra(str, f10);
        } catch (Throwable unused) {
            return f10;
        }
    }

    public int getIntExtra(String str, int i10) {
        try {
            return this.mIntent.getIntExtra(str, i10);
        } catch (Throwable unused) {
            return i10;
        }
    }

    public Intent getIntent() {
        return this.mIntent;
    }

    public long getLongExtra(String str, long j10) {
        try {
            return this.mIntent.getLongExtra(str, j10);
        } catch (Throwable unused) {
            return j10;
        }
    }

    public Parcelable[] getParcelableArrayExtra(String str) {
        try {
            return this.mIntent.getParcelableArrayExtra(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public <T extends Parcelable> ArrayList<T> getParcelableArrayListExtra(String str) {
        try {
            return this.mIntent.getParcelableArrayListExtra(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public <T extends Parcelable> T getParcelableExtra(String str) {
        try {
            return (T) this.mIntent.getParcelableExtra(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public Serializable getSerializableExtra(String str) {
        try {
            return this.mIntent.getSerializableExtra(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public String getStringExtra(String str) {
        try {
            return this.mIntent.getStringExtra(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public void removeExtra(String str) {
        try {
            this.mIntent.removeExtra(str);
        } catch (Throwable unused) {
        }
    }
}
