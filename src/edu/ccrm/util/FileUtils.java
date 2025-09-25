package edu.ccrm.util;

import java.io.File;

public class FileUtils {

    // Compute total size of a directory recursively
    public static long computeDirectorySize(File dir) {
        if (!dir.exists()) return 0;
        long size = 0;
        for (File file : dir.listFiles()) {
            size += file.isDirectory() ? computeDirectorySize(file) : file.length();
        }
        return size;
    }

    // Check if file exists
    public static boolean fileExists(String path) {
        File file = new File(path);
        return file.exists() && file.isFile();
    }
}
