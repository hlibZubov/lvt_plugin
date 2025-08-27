package com.inforeachinc.livetestsplugin;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import javax.swing.*;

public class LvtFileType extends LanguageFileType {
    public static final LvtFileType INSTANCE = new LvtFileType();

    private LvtFileType() {
        super(LvtLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "LVT File";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "LVT language file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "lvt";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return null; // You can create a custom icon later
    }
}