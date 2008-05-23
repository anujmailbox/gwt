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
package com.google.gwt.dev.util.msg;

import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.TreeLogger.Type;

/**
 * Integer, String, & String message.
 */
public final class Message3IntStringString extends Message3 {

  public Message3IntStringString(Type type, String fmt) {
    super(type, fmt);
  }

  public TreeLogger branch(TreeLogger logger, int x, String s1, String s2,
      Throwable caught) {
    Integer xi = new Integer(x);
    return branch3(logger, xi, s1, s2, getFormatter(xi), getFormatter(s1),
        getFormatter(s2), caught);
  }

  public void log(TreeLogger logger, int x, String s1, String s2,
      Throwable caught) {
    Integer xi = new Integer(x);
    log3(logger, xi, s1, s2, getFormatter(xi), getFormatter(s1),
        getFormatter(s2), caught);
  }
}
