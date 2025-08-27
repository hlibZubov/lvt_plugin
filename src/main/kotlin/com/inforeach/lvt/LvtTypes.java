package com.inforeachinc.livetestsplugin;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;
import com.inforeachinc.livetestsplugin.LvtLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public interface LvtTypes {
    // Define token element types
    IElementType KEYWORD = new LvtTokenType("KEYWORD");
    IElementType COMMENT = new LvtTokenType("COMMENT");
    IElementType STRING  = new LvtTokenType("STRING");
    IElementType IDENTIFIER = new LvtTokenType("IDENTIFIER");

    // Useful for grouping tokens
    TokenSet COMMENTS = TokenSet.create(COMMENT);
    TokenSet STRINGS  = TokenSet.create(STRING);
    TokenSet KEYWORDS = TokenSet.create(KEYWORD);
}
