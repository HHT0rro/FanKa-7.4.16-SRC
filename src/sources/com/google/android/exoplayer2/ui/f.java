package com.google.android.exoplayer2.ui;

import android.content.res.Resources;
import android.text.TextUtils;
import com.android.internal.logging.nano.MetricsProto;
import com.google.android.exoplayer2.Format;
import java.util.Locale;
import sun.util.locale.LanguageTag;

/* compiled from: DefaultTrackNameProvider.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class f implements n0 {

    /* renamed from: a, reason: collision with root package name */
    public final Resources f22612a;

    public f(Resources resources) {
        this.f22612a = (Resources) com.google.android.exoplayer2.util.a.e(resources);
    }

    public static int i(Format format) {
        int l10 = com.google.android.exoplayer2.util.q.l(format.f19544m);
        if (l10 != -1) {
            return l10;
        }
        if (com.google.android.exoplayer2.util.q.o(format.f19541j) != null) {
            return 2;
        }
        if (com.google.android.exoplayer2.util.q.c(format.f19541j) != null) {
            return 1;
        }
        if (format.f19549r == -1 && format.f19550s == -1) {
            return (format.f19557z == -1 && format.A == -1) ? -1 : 1;
        }
        return 2;
    }

    @Override // com.google.android.exoplayer2.ui.n0
    public String a(Format format) {
        String e2;
        int i10 = i(format);
        if (i10 == 2) {
            e2 = j(h(format), g(format), c(format));
        } else if (i10 == 1) {
            e2 = j(e(format), b(format), c(format));
        } else {
            e2 = e(format);
        }
        return e2.length() == 0 ? this.f22612a.getString(R$string.exo_track_unknown) : e2;
    }

    public final String b(Format format) {
        int i10 = format.f19557z;
        if (i10 == -1 || i10 < 1) {
            return "";
        }
        if (i10 == 1) {
            return this.f22612a.getString(R$string.exo_track_mono);
        }
        if (i10 == 2) {
            return this.f22612a.getString(R$string.exo_track_stereo);
        }
        if (i10 == 6 || i10 == 7) {
            return this.f22612a.getString(R$string.exo_track_surround_5_point_1);
        }
        if (i10 != 8) {
            return this.f22612a.getString(R$string.exo_track_surround);
        }
        return this.f22612a.getString(R$string.exo_track_surround_7_point_1);
    }

    public final String c(Format format) {
        int i10 = format.f19540i;
        return i10 == -1 ? "" : this.f22612a.getString(R$string.exo_track_bitrate, Float.valueOf(i10 / 1000000.0f));
    }

    public final String d(Format format) {
        return TextUtils.isEmpty(format.f19534c) ? "" : format.f19534c;
    }

    public final String e(Format format) {
        String j10 = j(f(format), h(format));
        return TextUtils.isEmpty(j10) ? d(format) : j10;
    }

    public final String f(Format format) {
        String str = format.f19535d;
        if (TextUtils.isEmpty(str) || LanguageTag.UNDETERMINED.equals(str)) {
            return "";
        }
        return (com.google.android.exoplayer2.util.j0.f22990a >= 21 ? Locale.forLanguageTag(str) : new Locale(str)).getDisplayName();
    }

    public final String g(Format format) {
        int i10 = format.f19549r;
        int i11 = format.f19550s;
        return (i10 == -1 || i11 == -1) ? "" : this.f22612a.getString(R$string.exo_track_resolution, Integer.valueOf(i10), Integer.valueOf(i11));
    }

    public final String h(Format format) {
        String string = (format.f19537f & 2) != 0 ? this.f22612a.getString(R$string.exo_track_role_alternate) : "";
        if ((format.f19537f & 4) != 0) {
            string = j(string, this.f22612a.getString(R$string.exo_track_role_supplementary));
        }
        if ((format.f19537f & 8) != 0) {
            string = j(string, this.f22612a.getString(R$string.exo_track_role_commentary));
        }
        return (format.f19537f & MetricsProto.MetricsEvent.DATA_PLAN_USAGE_SUMMARY) != 0 ? j(string, this.f22612a.getString(R$string.exo_track_role_closed_captions)) : string;
    }

    public final String j(String... strArr) {
        String str = "";
        for (String str2 : strArr) {
            if (str2.length() > 0) {
                str = TextUtils.isEmpty(str) ? str2 : this.f22612a.getString(R$string.exo_item_list, str, str2);
            }
        }
        return str;
    }
}
