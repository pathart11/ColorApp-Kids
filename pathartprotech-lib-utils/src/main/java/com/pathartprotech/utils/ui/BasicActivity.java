/* Copyright (c) 2010-2011 Pathartprotech androidsoft.org
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.pathartprotech.utils.ui;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

/**
 * Provides a simple activity with just a close menu.
 */
public abstract class BasicActivity extends NoTitleActivity
{
    /**
     * Provides the menu resource. Ex R.menu.menu_close
     * @return The resource id
     */
    public abstract int getMenuResource();

    /**
     * Provides the menu Close
     * @return 
     */
    public abstract int getMenuCloseId();

    /**
     * {@inheritDoc }
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(getMenuResource(), menu);

        return true;
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if (item.getItemId() == getMenuCloseId())
        {
            this.finish();
            return true;
        }
        return false;
    }
}
