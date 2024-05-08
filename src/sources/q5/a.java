package q5;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.icy.IcyInfo;
import com.google.common.base.c;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import n5.d;
import n5.f;

/* compiled from: IcyDecoder.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class a extends f {

    /* renamed from: c, reason: collision with root package name */
    public static final Pattern f53028c = Pattern.compile("(.+?)='(.*?)';", 32);

    /* renamed from: a, reason: collision with root package name */
    public final CharsetDecoder f53029a = c.f25961c.newDecoder();

    /* renamed from: b, reason: collision with root package name */
    public final CharsetDecoder f53030b = c.f25960b.newDecoder();

    @Override // n5.f
    public Metadata b(d dVar, ByteBuffer byteBuffer) {
        String c4 = c(byteBuffer);
        byte[] bArr = new byte[byteBuffer.limit()];
        byteBuffer.get(bArr);
        String str = null;
        if (c4 == null) {
            return new Metadata(new IcyInfo(bArr, null, null));
        }
        Matcher matcher = f53028c.matcher(c4);
        String str2 = null;
        for (int i10 = 0; matcher.find(i10); i10 = matcher.end()) {
            String group = matcher.group(1);
            String group2 = matcher.group(2);
            if (group != null) {
                String e2 = com.google.common.base.a.e(group);
                e2.hashCode();
                if (e2.equals("streamurl")) {
                    str2 = group2;
                } else if (e2.equals("streamtitle")) {
                    str = group2;
                }
            }
        }
        return new Metadata(new IcyInfo(bArr, str, str2));
    }

    @Nullable
    public final String c(ByteBuffer byteBuffer) {
        try {
            return this.f53029a.decode(byteBuffer).toString();
        } catch (CharacterCodingException unused) {
            try {
                return this.f53030b.decode(byteBuffer).toString();
            } catch (CharacterCodingException unused2) {
                return null;
            } finally {
                this.f53030b.reset();
                byteBuffer.rewind();
            }
        } finally {
            this.f53029a.reset();
            byteBuffer.rewind();
        }
    }
}
