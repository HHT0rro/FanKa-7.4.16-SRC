package com.github.megatronking.stringfog;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class StringFogWrapper implements IStringFog {
    public IStringFog mStringFogImpl;

    public StringFogWrapper(String str) {
        try {
            this.mStringFogImpl = (IStringFog) Class.forName(str).newInstance();
        } catch (ClassNotFoundException unused) {
            throw new IllegalArgumentException("Stringfog implementation class not found: " + str);
        } catch (IllegalAccessException e2) {
            throw new IllegalArgumentException("Stringfog implementation class access failed: " + e2.getMessage());
        } catch (InstantiationException e10) {
            throw new IllegalArgumentException("Stringfog implementation class new instance failed: " + e10.getMessage());
        }
    }

    @Override // com.github.megatronking.stringfog.IStringFog
    public String decrypt(String str, String str2) {
        IStringFog iStringFog = this.mStringFogImpl;
        return iStringFog == null ? str : iStringFog.decrypt(str, str2);
    }

    @Override // com.github.megatronking.stringfog.IStringFog
    public String encrypt(String str, String str2) {
        IStringFog iStringFog = this.mStringFogImpl;
        return iStringFog == null ? str : iStringFog.encrypt(str, str2);
    }

    @Override // com.github.megatronking.stringfog.IStringFog
    public boolean overflow(String str, String str2) {
        IStringFog iStringFog = this.mStringFogImpl;
        return iStringFog != null && iStringFog.overflow(str, str2);
    }
}
