package org.apache.lucene.analysis.tokenattributes;

/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.io.Serializable;

import org.apache.lucene.util.AttributeImpl;

/**
 * A Token's lexical type. The Default value is "word". 
 */
public class TypeAttributeImpl extends AttributeImpl implements TypeAttribute, Cloneable, Serializable {
  private String type;
  public static final String DEFAULT_TYPE = "word";
  
  public TypeAttributeImpl() {
    this(DEFAULT_TYPE); 
  }
  
  public TypeAttributeImpl(String type) {
    this.type = type;
  }
  
  /** Returns this Token's lexical type.  Defaults to "word". */
  public String type() {
    return type;
  }

  /** Set the lexical type.
      @see #type() */
  public void setType(String type) {
    this.type = type;
  }

  public void clear() {
    type = DEFAULT_TYPE;    
  }

  public boolean equals(Object other) {
    if (other == this) {
      return true;
    }
    
    if (other instanceof TypeAttributeImpl) {
      return type.equals(((TypeAttributeImpl) other).type);
    }
    
    return false;
  }

  public int hashCode() {
    return type.hashCode();
  }
  
  public void copyTo(AttributeImpl target) {
    TypeAttribute t = (TypeAttribute) target;
    t.setType(type);
  }
}
