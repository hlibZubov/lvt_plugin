package com.inforeachinc.livetestsplugin;

import com.intellij.lang.Language;

public class LvtLanguage extends Language {
    public static final LvtLanguage INSTANCE = new LvtLanguage();

    private LvtLanguage() {
        super("LVT");
    }
}