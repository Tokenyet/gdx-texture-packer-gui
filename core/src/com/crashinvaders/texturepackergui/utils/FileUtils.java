package com.crashinvaders.texturepackergui.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.kotcrab.vis.ui.widget.file.FileTypeFilter;

import java.io.IOException;

public class FileUtils {

    public static boolean fileExists(FileHandle fileHandle) {
        return fileHandle != null && fileHandle.exists();
    }

    public static boolean fileExists(String absolutePath) {
        return Gdx.files.absolute(absolutePath).exists();
    }

    public static FileHandle obtainIfExists(String absolutePath) {
        FileHandle fileHandle = Gdx.files.absolute(absolutePath);
        return fileHandle.exists() ? fileHandle : null;
    }

    public static class FileTypeFilterBuilder {
        private final FileTypeFilter filter;

        public FileTypeFilterBuilder(boolean allTypeAllowed) {
            filter = new FileTypeFilter(allTypeAllowed);
        }

        public FileTypeFilterBuilder rule(String description, String... extensions) {
            filter.addRule(description, extensions);
            return this;
        }

        public FileTypeFilter get() {
            return filter;
        }
    }

    public static void saveTextToFile(String text, FileHandle file) {
        try {
            org.apache.commons.io.FileUtils.write(file.file(), text, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String loadTextFromFile(FileHandle file) {
        try {
            return org.apache.commons.io.FileUtils.readFileToString(file.file(), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}