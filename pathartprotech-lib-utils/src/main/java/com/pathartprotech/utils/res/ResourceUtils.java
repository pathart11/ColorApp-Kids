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
import android.util.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import com.pathartprotech.utils.CommonConstants;

/**
 * IO utils
 * @author Pathartprotech
 */
public class ResourceUtils
{
    /**
     * Read the content of an asset text file
     * @param context The context
     * @param asset The asset name
     * @return The content of the file
     */
    public static String readAssetTextFile( Context context, String asset )
    {
        BufferedReader in = null;
        try
        {
            in = new BufferedReader(new InputStreamReader( context.getAssets().open( asset )));
            String line;
            StringBuilder buffer = new StringBuilder();
            while ((line = in.readLine()) != null)
            {
                buffer.append(line).append('\n');
            }
            return buffer.toString();
        } catch (IOException e)
        {
            return "";
        } finally
        {
            if (in != null)
            {
                try
                {
                    in.close();
                } catch (IOException e)
                {
                    Log.e( CommonConstants.TAG , "Error closing input stream while reading asset", e );
                }
            }
        }
    }
    
}
