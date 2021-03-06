/*
 * Copyright (C) 2011 The Android Open Source Project
 * Modifications Copyright (C) 2015 Fred Grott(GrottWorkSHop)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.grottworkshop.gwsutil;

import android.util.Property;

/**
 * An implementation of {@link android.util.Property} to be used specifically with fields of type
 * <code>int</code>. This type-specific subclass enables performance benefit by allowing
 * calls to a {@link #set(Object, Integer) set()} function that takes the primitive
 * <code>int</code> type and avoids autoboxing and other overhead associated with the
 * <code>Integer</code> class.
 *
 * @param <T> The class on which the Property is declared.
 * Created by fgrott on 8/31/2015.
 */
@SuppressWarnings("unused")
public abstract class IntProperty<T> extends Property<T, Integer> {

    public IntProperty(String name) {
        super(Integer.class, name);
    }

    /**
     * A type-specific override of the {@link #set(Object, Integer)} that is faster when dealing
     * with fields of type <code>int</code>.
     */
    public abstract void setValue(T object, int value);
    //TODO: set method has infiniterecursion fix
    @SuppressWarnings("InfiniteRecursion")
    @Override
    final public void set(T object, Integer value) {
        set(object, value);
    }

}