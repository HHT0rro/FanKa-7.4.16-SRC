package d5;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.metadata.id3.InternalFrame;
import com.google.android.exoplayer2.util.j0;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: GaplessInfoHolder.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class l {

    /* renamed from: c, reason: collision with root package name */
    public static final Pattern f48638c = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");

    /* renamed from: a, reason: collision with root package name */
    public int f48639a = -1;

    /* renamed from: b, reason: collision with root package name */
    public int f48640b = -1;

    public boolean a() {
        return (this.f48639a == -1 || this.f48640b == -1) ? false : true;
    }

    public final boolean b(String str) {
        Matcher matcher = f48638c.matcher(str);
        if (!matcher.find()) {
            return false;
        }
        try {
            int parseInt = Integer.parseInt((String) j0.j(matcher.group(1)), 16);
            int parseInt2 = Integer.parseInt((String) j0.j(matcher.group(2)), 16);
            if (parseInt <= 0 && parseInt2 <= 0) {
                return false;
            }
            this.f48639a = parseInt;
            this.f48640b = parseInt2;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public boolean c(Metadata metadata) {
        for (int i10 = 0; i10 < metadata.d(); i10++) {
            Metadata.Entry c4 = metadata.c(i10);
            if (c4 instanceof CommentFrame) {
                CommentFrame commentFrame = (CommentFrame) c4;
                if ("iTunSMPB".equals(commentFrame.f20897d) && b(commentFrame.f20898e)) {
                    return true;
                }
            } else if (c4 instanceof InternalFrame) {
                InternalFrame internalFrame = (InternalFrame) c4;
                if ("com.apple.iTunes".equals(internalFrame.f20904c) && "iTunSMPB".equals(internalFrame.f20905d) && b(internalFrame.f20906e)) {
                    return true;
                }
            } else {
                continue;
            }
        }
        return false;
    }

    public boolean d(int i10) {
        int i11 = i10 >> 12;
        int i12 = i10 & 4095;
        if (i11 <= 0 && i12 <= 0) {
            return false;
        }
        this.f48639a = i11;
        this.f48640b = i12;
        return true;
    }
}
