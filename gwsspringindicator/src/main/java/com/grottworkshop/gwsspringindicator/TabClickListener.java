/*
 * Copyright 2015 chenupt
 * Modifications Copyright (C) 2015 Fred Grott(GrottWorkShop)
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
 */
package com.grottworkshop.gwsspringindicator;

/**
 * TabClickListener interface
 * Created by fgrott on 8/26/2015.
 */
public interface TabClickListener {

    /**
     * Handle click event when tab is clicked.
     * @param position ViewPager item position.
     * @return Call setCurrentItem if return true.
     */
    boolean onTabClick(int position);

}
