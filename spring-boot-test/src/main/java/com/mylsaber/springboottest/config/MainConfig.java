package com.mylsaber.springboottest.config;

import com.mylsaber.springboottest.selector.MyImportSelector;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author jfw
 */
@Configuration
@Import({MyImportSelector.class,ConfigB.class})
public class MainConfig {
}
