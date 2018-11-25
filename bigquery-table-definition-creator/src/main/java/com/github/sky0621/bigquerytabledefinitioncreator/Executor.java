package com.github.sky0621.bigquerytabledefinitioncreator;

import com.github.sky0621.bigquerytabledefinitioncreator.error.VelocityTemplateGenException;

/**
 * FIXME: JavaDoc
 */
public class Executor {

    public void run(ExecMode mode) throws VelocityTemplateGenException {
        try {
            Class clz = Class.forName(mode.getExecutorClassName());
            IfGenExecutor executor = (IfGenExecutor) clz.newInstance();
            executor.run();
        } catch (Exception e) {
            throw new VelocityTemplateGenException(e);
        }
    }

}
