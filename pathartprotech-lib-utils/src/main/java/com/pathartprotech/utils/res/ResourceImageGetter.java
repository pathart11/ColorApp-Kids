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
package com.pathartprotech.utils.res;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Html.ImageGetter;

/**
 * ResourceImageGetter used to retrieve image stored as drawable in order to 
 * insert then in Html textview
 * @author Pathartprotech
 */
public class ResourceImageGetter implements ImageGetter
{
    private Context mContext;
    
    /**
     * Constructor
     * @param context The context 
     */
    public ResourceImageGetter( Context context )
    {
        mContext = context;
    }

    /**
     * Get drawable
     * @param source The drawable name
     * @return The drawable
     */
    @Override
    public Drawable getDrawable(String source)
    {
        Drawable drawFromPath;
        int path = mContext.getResources().getIdentifier(source, "drawable", mContext.getPackageName() );
        drawFromPath = (Drawable) mContext.getResources().getDrawable(path);
        drawFromPath.setBounds(0, 0, drawFromPath.getIntrinsicWidth(), drawFromPath.getIntrinsicHeight());
        return drawFromPath;
    }
}
