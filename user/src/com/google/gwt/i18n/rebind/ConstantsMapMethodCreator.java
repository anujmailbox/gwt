/*
 * Copyright 2008 Google Inc.
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
package com.google.gwt.i18n.rebind;

import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.UnableToCompleteException;
import com.google.gwt.core.ext.typeinfo.JMethod;
import com.google.gwt.i18n.client.impl.ConstantMap;
import com.google.gwt.i18n.rebind.AbstractResource.MissingResourceException;
import com.google.gwt.user.rebind.AbstractGeneratorClassCreator;

/**
 * Creator for methods of the form Map getX() .
 */
class ConstantsMapMethodCreator extends AbstractLocalizableMethodCreator {
  /**
   * Constructor for localizable returnType method creator.
   * 
   * @param classCreator
   */
  public ConstantsMapMethodCreator(AbstractGeneratorClassCreator classCreator) {
    super(classCreator);
  }

  /**
   * Generates Map of key/value pairs for a list of keys.
   * 
   * @param method method body to create
   * @param value value to create returnType from
   * @throws UnableToCompleteException
   */
  @Override
  public void createMethodFor(TreeLogger logger, JMethod method, String key,
      AbstractResource resource, String locale) throws UnableToCompleteException {
    String methodName = method.getName();
    if (method.getParameters().length > 0) {
      error(
          logger,
          methodName
              + " cannot have parameters; extend Messages instead if you need to create "
              + "parameterized messages");
    }
    // make sure cache exists
    enableCache();
    // check cache for array
    println("java.util.Map args = (java.util.Map) cache.get("
        + wrap(methodName) + ");");
    // if not found create Map
    println("if (args == null){");
    indent();
    println("args = new " + ConstantMap.class.getCanonicalName() + "();");
    String value;
    try {
      value = resource.getRequiredStringExt(logger, key, null);
    } catch (MissingResourceException e) {
      e.setDuring("getting key list");
      throw e;
    }
    String[] args = ConstantsStringArrayMethodCreator.split(value);

    for (int i = 0; i < args.length; i++) {
      try {
        key = args[i];
        String keyValue = getResources().getString(key);
        println("args.put(" + wrap(key) + ", " + wrap(keyValue) + ");");
      } catch (MissingResourceException e) {
        e.setDuring("implementing map");
        throw e;
      }
    }
    println("cache.put(" + wrap(methodName) + ", args);");
    println("}; ");
    outdent();
    println("return args;");
  }
}
