/*
 * Copyright 2017, OpenSkywalking Organization All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Project repository: https://github.com/OpenSkywalking/skywalking
 */

package org.skywalking.apm.collector.ui.jetty;

import java.util.Map;
import org.skywalking.apm.collector.core.config.ConfigParseException;
import org.skywalking.apm.collector.core.module.ModuleConfigParser;
import org.skywalking.apm.collector.core.util.ObjectUtils;
import org.skywalking.apm.collector.core.util.StringUtils;

/**
 * @author peng-yongsheng
 */
public class UIJettyConfigParser implements ModuleConfigParser {

    private static final String HOST = "host";
    private static final String PORT = "port";
    public static final String CONTEXT_PATH = "contextPath";

    @Override public void parse(Map config) throws ConfigParseException {
        UIJettyConfig.CONTEXT_PATH = "/";

        if (ObjectUtils.isEmpty(config) || StringUtils.isEmpty(config.get(HOST))) {
            UIJettyConfig.HOST = "localhost";
        } else {
            UIJettyConfig.HOST = (String)config.get(HOST);
        }

        if (ObjectUtils.isEmpty(config) || StringUtils.isEmpty(config.get(PORT))) {
            UIJettyConfig.PORT = 12800;
        } else {
            UIJettyConfig.PORT = (Integer)config.get(PORT);
        }
        if (ObjectUtils.isNotEmpty(config) && StringUtils.isNotEmpty(config.get(CONTEXT_PATH))) {
            UIJettyConfig.CONTEXT_PATH = (String)config.get(CONTEXT_PATH);
        }
    }
}
