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
package com.google.gwt.core.ext;

/**
 * Provides deferred binding property values.
 */
public interface PropertyOracle {

  /**
   * Attempts to get a named deferred binding property. Throws
   * <code>BadPropertyValueException</code> if the property is either
   * undefined or has a value that is unsupported.
   * 
   * @param logger the current logger
   * @param propertyName the name of the property
   * @return a value for the property
   */
  String getPropertyValue(TreeLogger logger, String propertyName)
      throws BadPropertyValueException;

  /**
   * Attempts to get a named deferred binding property and returns the list of
   * possible values. Throws <code>BadPropertyValueException</code> if the
   * property is undefined.
   * 
   * @param logger the current logger
   * @param propertyName the name of the property
   * @return the possible values for the property
   */
  String[] getPropertyValueSet(TreeLogger logger, String propertyName)
      throws BadPropertyValueException;
}
