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

package com.liferay.netbeansproject.resolvers;

import com.liferay.netbeansproject.container.Module;

import java.nio.file.Path;

import java.util.Map;

/**
 * @author Tom Wang
 */
public class ProjectDependencyResolver {

	public ProjectDependencyResolver(
		Map<Path, Module> projectMap, Path portalDir) {

		_projectMap = projectMap;

		_portalDir = portalDir;
	}

	public Module resolve(Path moduleRelativePath) {
		return _projectMap.get(_portalDir.resolve(moduleRelativePath));
	}

	private static Path _portalDir;
	private static Map<Path, Module> _projectMap;

}