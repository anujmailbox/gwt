/*
 * Copyright 2006 Google Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.google.gwt.dev.shell;

import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.UnableToCompleteException;
import com.google.gwt.dev.cfg.ModuleDef;

/**
 * Interface that unifies access to the <code>BrowserWidget</code>,
 * <code>ModuleSpaceHost</code>, and the compiler.
 */
public interface BrowserWidgetHost {
  void compile(String[] modules) throws UnableToCompleteException;

  void compile(ModuleDef module) throws UnableToCompleteException;

  // Factor this out if BrowserWidget becomes decoupled from hosted mode
  ModuleSpaceHost createModuleSpaceHost(BrowserWidget widget, String moduleName)
      throws UnableToCompleteException;

  TreeLogger getLogger();

  String normalizeURL(String whatTheUserTyped);

  BrowserWidget openNewBrowserWindow() throws UnableToCompleteException;
}
