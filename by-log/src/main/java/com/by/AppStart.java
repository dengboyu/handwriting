package com.by;


import org.apache.log4j.helpers.LogLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class AppStart {

    private static Logger logger = null;
//    private static final Logger logger = Logger.getLogger(AppStart.class.getName());

    static {
        LogLog.setInternalDebugging(true);
        logger = LoggerFactory.getLogger(AppStart.class);
    }

    public static void main(String[] args) {


        logger.info("试试");



    }


}
