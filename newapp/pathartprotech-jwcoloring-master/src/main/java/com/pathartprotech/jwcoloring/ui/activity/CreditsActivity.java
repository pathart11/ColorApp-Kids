/* Copyright (c) 2018 Pathartprotech.com pathartprotech.com
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
package com.pathartprotech.jwcoloring.ui.activity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import com.pathartprotech.jwcoloring.R;
import com.pathartprotech.utils.credits.CreditsParams;
import com.pathartprotech.utils.credits.CreditsView;
import com.pathartprotech.utils.ui.BasicActivity;

/**
 * Credits activity
 * @author Pathartprotech
 */
public class CreditsActivity extends BasicActivity
{

    @Override
    public void onCreate(Bundle icicle)
    {
        super.onCreate(icicle);

        View view = new CreditsView(this, getCreditsParams());
        setContentView(view);

    }

    /**
     * {@inheritDoc } 
     */
    @Override
    public int getMenuResource()
    {
        return R.menu.menu_close;
    }

    /**
     * {@inheritDoc } 
     */
    @Override
    public int getMenuCloseId()
    {
        return R.id.menu_close;
    }
    
    private CreditsParams getCreditsParams()
    {
        CreditsParams p = new CreditsParams();
        p.setAppNameRes(R.string.credits_app_name);
        p.setAppVersionRes(R.string.credits_current_version);
        p.setBitmapBackgroundRes(R.drawable.background);
        p.setBitmapBackgroundLandscapeRes(R.drawable.background_land);
        p.setArrayCreditsRes(R.array.credits);

        p.setColorDefault(0xCCEBA757);
        p.setTextSizeDefault(32);
        p.setTypefaceDefault(Typeface.create(Typeface.SANS_SERIF, Typeface.BOLD));
        p.setSpacingBeforeDefault(10);
        p.setSpacingAfterDefault(18);

        p.setColorCategory(0xCC00365C);
        p.setTextSizeCategory(20);
        p.setTypefaceCategory(Typeface.create(Typeface.SANS_SERIF, Typeface.ITALIC));
        p.setSpacingBeforeCategory(12);
        p.setSpacingAfterCategory(12);

        return p;

    }

}
