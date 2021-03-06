/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.netbeansproject.template;

import freemarker.cache.ClassTemplateLoader;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapperBuilder;
import freemarker.template.Template;

import java.io.Writer;

/**
 * @author Tariq Dweik
 * @author Brian Wing Shun Chan
 */
public class FreeMarkerUtil {

	public static void process(String name, Object context, Writer writer)
		throws Exception {

		Template template = _configuration.getTemplate(name);

		template.process(context, writer);
	}

	private static final Configuration _configuration;

	static {
		_configuration = new Configuration(Configuration.getVersion());

		DefaultObjectWrapperBuilder defaultObjectWrapperBuilder =
			new DefaultObjectWrapperBuilder(Configuration.getVersion());

		_configuration.setObjectWrapper(defaultObjectWrapperBuilder.build());

		_configuration.setTemplateLoader(
			new ClassTemplateLoader(FreeMarkerUtil.class, "/"));
		_configuration.setTemplateUpdateDelayMilliseconds(Long.MAX_VALUE);
	}

}