package ru.YLab.argument;

import ru.YLab.constant.ComparatorTypeConst;

public class ArgumentProcessParam {
    protected String inputFileName;
    protected String mask;
    protected ComparatorTypeConst type;

    public String getInputFileName() {
        return inputFileName;
    }

    public String getMask() {
        return mask;
    }

    public ComparatorTypeConst getType() {
        return type;
    }
}
