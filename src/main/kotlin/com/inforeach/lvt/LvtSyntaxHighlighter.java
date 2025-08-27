package com.inforeachinc.livetestsplugin;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
// Assuming you have a LvtTypes class with your tokens
// import com.yourcompany.lvt.psi.LvtTypes;

public class LvtSyntaxHighlighter extends SyntaxHighlighterBase {

    // Define the text attributes (colors)
    public static final TextAttributesKey KEYWORD =
            TextAttributesKey.createTextAttributesKey("LVT_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey COMMENT =
            TextAttributesKey.createTextAttributesKey("LVT_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey STRING =
            TextAttributesKey.createTextAttributesKey("LVT_STRING", DefaultLanguageHighlighterColors.STRING);

    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new LvtDummyLexer(); // for now
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        if (tokenType.equals(LvtTypes.KEYWORD)) {
            return new TextAttributesKey[]{KEYWORD};
        }
        if (tokenType.equals(LvtTypes.COMMENT)) {
            return new TextAttributesKey[]{COMMENT};
        }
        if (tokenType.equals(LvtTypes.STRING)) {
            return new TextAttributesKey[]{STRING};
        }
        return EMPTY_KEYS;
    }

}
