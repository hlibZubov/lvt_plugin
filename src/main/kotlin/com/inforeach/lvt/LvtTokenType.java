package com.inforeachinc.livetestsplugin;

import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class LvtTokenType extends IElementType {
    public LvtTokenType(@NotNull @NonNls String debugName) {
        super(debugName, LvtLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "LvtTokenType." + super.toString();
    }
}
