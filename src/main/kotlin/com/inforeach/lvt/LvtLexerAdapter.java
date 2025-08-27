package com.inforeachinc.livetestsplugin;

import com.intellij.lexer.FlexAdapter;

public class LvtLexerAdapter extends FlexAdapter {
    public LvtLexerAdapter() {
        super(new LiveTestLexer(null)); // pass null, FlexAdapter manages Reader
    }
}
