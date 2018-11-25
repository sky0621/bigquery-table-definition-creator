package com.github.sky0621.bigquerytabledefinitioncreator;

import com.github.sky0621.bigquerytabledefinitioncreator.error.ErrorMessage;
import com.github.sky0621.bigquerytabledefinitioncreator.error.VelocityTemplateGenException;

/**
 * FIXME: JavaDoc
 */
public class Argument {

    private int execMode = 0;

    public Argument(String... args) throws VelocityTemplateGenException {
        init(args);
    }

    private void init(String... args) throws VelocityTemplateGenException {
        if (args.length == 0) {
            execMode = 1;
            return;
        }
        if (args.length != 1) {
            throw new VelocityTemplateGenException(ErrorMessage.ILLEGAL_ARGUMENT_EXEC);
        }
        try {
            execMode = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            throw new VelocityTemplateGenException(ErrorMessage.ILLEGAL_ARGUMENT_EXEC);
        }
    }

    public int getExecMode() {
        return execMode;
    }

}
