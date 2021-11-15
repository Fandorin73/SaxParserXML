package ru.YLab.argument;

import ru.YLab.constant.ComparatorTypeConst;
import ru.YLab.exception.ArgumentException;

import java.io.File;
import java.io.IOException;

import static ru.YLab.constant.FileAndDirectoryParseConst.*;

public class ArgumentProcess {
    private String inputFileName;
    private String mask;
    ComparatorTypeConst type;

    public String getInputFileName() {
        return inputFileName;
    }

    public String getMask() {
        return mask;
    }

    public ComparatorTypeConst getType() {
        return type;
    }

    public ArgumentProcess(String[] args) {
       validator(args);
    }

    public void validator(String[] args) {
        if (args[0].equals(KEY_INPUT_FILE)) {
            inputFileName = fileExists(args[1]);
            if (args.length == 2) {
                type = ComparatorTypeConst.Full;
            }
            if (args.length == 4) {
                if (args[2].equals(KEY_MACK)) {
                    mask = args[3];
                    if (args[3].matches("\\*\\.\\w+")) {
                        type = ComparatorTypeConst.Mask;
                    } else {
                        type = ComparatorTypeConst.Eqals;
                    }
                }
                if (args[2].equals(KEY_MACK_REGULAR)) {
                    mask = args[3];
                    type = ComparatorTypeConst.Regular;
                }
                if (mask.isEmpty() && type == null) {
                    throw new ArgumentException("invalid arguments " + args[2]);
                }
            }
        } else throw new ArgumentException("invalid arguments " + args[0]);
    }

    private String fileExists(String fileName) {
        String path = System.getProperty("user.dir");
        File f = new File(path + File.separator + fileName);
        if (f.exists() && f.isFile()) {
            return f.getAbsolutePath();
        } else {
            throw new ArgumentException("input file doesn't exists");
        }

    }
}
