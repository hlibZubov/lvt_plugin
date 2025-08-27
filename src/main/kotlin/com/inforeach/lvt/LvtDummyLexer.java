package com.inforeachinc.livetestsplugin;

import com.intellij.lexer.LexerBase;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class LvtDummyLexer extends LexerBase {
    private CharSequence buffer;
    private int startOffset;
    private int endOffset;
    private int position;
    private IElementType tokenType;

    @Override
    public void start(@NotNull CharSequence buffer, int startOffset, int endOffset, int initialState) {
        this.buffer = buffer;
        this.startOffset = startOffset;
        this.endOffset = endOffset;
        this.position = startOffset;
        advance();
    }

    @Override
    public int getState() { return 0; }

    @Nullable
    @Override
    public IElementType getTokenType() { return tokenType; }

    @Override
    public int getTokenStart() { return startOffset; }

    @Override
    public int getTokenEnd() { return position; }

    @Override
    public void advance() {
        if (position >= endOffset) {
            tokenType = null;
            return;
        }

        char c = buffer.charAt(position);

        // very simplistic rules
        if (c == '#') { // comment until end of line
            int start = position;
            while (position < endOffset && buffer.charAt(position) != '\n') {
                position++;
            }
            startOffset = start;
            tokenType = LvtTypes.COMMENT;
            return;
        }

        if (c == '"') { // string literal
            int start = position++;
            while (position < endOffset && buffer.charAt(position) != '"') {
                position++;
            }
            if (position < endOffset) position++; // consume closing quote
            startOffset = start;
            tokenType = LvtTypes.STRING;
            return;
        }

        if (Character.isLetter(c)) { // keyword or identifier
            int start = position;
            while (position < endOffset && Character.isLetter(buffer.charAt(position))) {
                position++;
            }
            String word = buffer.subSequence(start, position).toString();
            startOffset = start;
            if (word.equals("testCase") || word.equals("step") || word.equals("verify")) {
                tokenType = LvtTypes.KEYWORD;
            } else {
                tokenType = LvtTypes.IDENTIFIER;
            }
            return;
        }

        // otherwise skip single char
        startOffset = position;
        position++;
        tokenType = LvtTypes.IDENTIFIER;
    }

    @NotNull
    @Override
    public CharSequence getBufferSequence() { return buffer; }

    @Override
    public int getBufferEnd() { return endOffset; }
}
